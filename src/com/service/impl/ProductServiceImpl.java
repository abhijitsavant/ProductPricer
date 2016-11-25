package com.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bean.ProductBean;
import com.dao.ProductDAO;
import com.entities.ProductDetail;
import com.entities.ProductPricer;
import com.entities.StoreMaster;
import com.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductDAO productDAO;
	
	@Autowired
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	@Override
	@Transactional
	public List<ProductDetail> getProductList() {
		return productDAO.getProductList();
	}

	@Override
	@Transactional
	public ProductBean getProductDetailsByBarCode(String barCode) {
		ProductBean productBean = null;
		ProductDetail productDetail = productDAO.getProductDetailsByBarCode(barCode);
		if (productDetail != null) {
			productBean = converProductDetailsEntityToBean(productDetail);
		}
		return productBean;
	}

	@Override
	@Transactional
	public boolean upsertProductInformation(ProductBean productBean) {
		ProductPricer ProductPricer = converBeanTOEntity(productBean);
		return productDAO.upsertProductInformation(ProductPricer);
	}
	
	private ProductPricer converBeanTOEntity(ProductBean productBean){
		ProductPricer  productPricer = null;
		StoreMaster storeMaster = null;
		ProductDetail productDetail = new ProductDetail();
		if(productBean != null){
			productPricer = new ProductPricer();
			storeMaster = new StoreMaster();
			storeMaster.setStoreId(new BigInteger(productBean.getStoreId()));
			productDetail.setBarCode(productBean.getBarCode());;
			productPricer.setProductDetail(productDetail);
			productPricer.setStoreMaster(storeMaster);
			productPricer.setPrice(new BigDecimal(productBean.getProductPrice()));
			productPricer.setNotes(productBean.getNotes());
		}
		return productPricer;
	
	}
	
	private ProductBean converProductDetailsEntityToBean(ProductDetail productDetail){
		ProductBean productBean = null;
		if (productDetail != null) {
			productBean = new ProductBean();
			productBean.setBarCode(productDetail.getBarCode());
			productBean.setProductDesc(productDetail.getProductDesc());
			productBean.setAveragePrice(productDetail.getAveragePrice());
			productBean.setHighestPrice(productDetail.getHighestPrice());
			productBean.setLowestPrice(productDetail.getLowestPrice());
			productBean.setIdealPrice(productDetail.getIdealPrice());
			productBean.setProductLength(productDetail.getProductLength());
		}
		return productBean;
	
	}

	@Override
	@Transactional
	public ProductBean getStoreList() {
		ProductBean productBean = null;
		Map<String,String> stores = new HashMap<>();
		List<StoreMaster> storeMasters = null;
		storeMasters = productDAO.getStoreList();
		for (StoreMaster storeMaster : storeMasters) {
			stores.put(storeMaster.getStoreId().toString(),storeMaster.getName());
		}
		productBean = new ProductBean();
		productBean.setStores(stores);
		return productBean;
	}
}
