package com.dao.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.ProductDAO;
import com.entities.ProductDetail;
import com.entities.ProductPricer;
import com.entities.StoreMaster;

@Repository
public class ProductDAOImpl implements ProductDAO{

	private static final Logger logger = LoggerFactory.getLogger(ProductDAOImpl.class);

	private SessionFactory sessionFactory;
	
	static int idealLow = 2;
	static int idealHigh = 2;
	static BigDecimal idealPercent = new BigDecimal(0.2);
	
	@Autowired
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public List<ProductDetail> getProductList() {
		if (logger.isDebugEnabled()) {
			logger.info("getProductList called");
		}
		List<ProductDetail> productDetails = null;
		Session session = this.sessionFactory.getCurrentSession();
		productDetails = session.createQuery("From ProductDetail").list();
		session.close();
		return productDetails;
	}

	@Override
	public ProductDetail getProductDetailsByBarCode(String barCode) {
		if (logger.isDebugEnabled()) {
			logger.debug("getProductDetailsByBarCode called with Barcode : "+barCode);
		}
		Query query = null; 
		ProductDetail productDetail = new ProductDetail();
		Session session = this.sessionFactory.openSession();
		query = session.createSQLQuery("SELECT p.id, barcode, description,(SELECT MAX(price) FROM product_price pc WHERE pc.product_id = p.id) highest_price,(SELECT MIN(price) FROM product_price pc WHERE pc.product_id = p.id) lowest_price,(SELECT AVG(price) FROM product_price pc WHERE pc.product_id = p.id) avg_price FROM product p WHERE p.barCode = :barCode");
		query.setParameter("barCode", barCode);
		Object[] row = (Object[]) query.list().get(0);
		productDetail.setId(new BigInteger(row[0].toString()));
		productDetail.setBarCode(row[1].toString());
		productDetail.setProductDesc(row[2].toString());
		productDetail.setHighestPrice(new BigDecimal(row[3].toString()));
		productDetail.setLowestPrice(new BigDecimal(row[4].toString()));
		productDetail.setAveragePrice(new BigDecimal(row[5].toString()));
		query = session.createQuery("From ProductPricer p where p.productDetail.id = :prodId");
		query.setParameter("prodId", productDetail.getId());
		List<ProductPricer> productPricerList = query.list();
		int length = 0;
		BigDecimal idealTotal = BigDecimal.ZERO;
		BigDecimal idealAverage = BigDecimal.ZERO;
		BigDecimal idealPrice = BigDecimal.ZERO;
		if(null != productPricerList && !productPricerList.isEmpty()){
			length = productPricerList.size();
			Collections.sort(productPricerList);
			productPricerList = productPricerList.subList(2, length-2);
			for(ProductPricer productPricer : productPricerList){
				idealTotal = productPricer.getPrice().add(idealTotal);
			}
			idealAverage = idealTotal.divide(new BigDecimal(productPricerList.size()), 2, RoundingMode.HALF_UP);
			idealPrice = idealAverage.add(idealAverage.multiply(idealPercent));
		}
		productDetail.setIdealPrice(idealPrice.setScale(2, RoundingMode.FLOOR));
		productDetail.setProductLength(length);
		session.close();
		return productDetail;
	}

	@Override
	public boolean upsertProductInformation(ProductPricer productPricer) {
		boolean isProductSaved = false;
		StoreMaster storeMaster = null;
		ProductDetail productDetail = null;
		BigInteger generatedId = null;
		Query query = null;
		Session session = this.sessionFactory.openSession();
		if(productPricer!=null){
			storeMaster = (StoreMaster) session.get(StoreMaster.class, productPricer.getStoreMaster().getStoreId());
			 query = session.createQuery("From ProductDetail pd where pd.barCode= :barCode");
			 productDetail = (ProductDetail) query.setString("barCode", productPricer.getProductDetail().getBarCode()).list().get(0);
			 productPricer.setProductDetail(productDetail);
			 productPricer.setStoreMaster(storeMaster);
			 generatedId = (BigInteger) session.save(productPricer);
			 isProductSaved = generatedId != null ? true : false;
		}
		session.close();
		return isProductSaved;
		
	}

	@Override
	public List<StoreMaster> getStoreList() {
		List<StoreMaster> storeMasters = null;
		Session session = this.sessionFactory.openSession();
		storeMasters = session.createQuery("FROM StoreMaster").list();
		session.close();
		return storeMasters;
	}
}
