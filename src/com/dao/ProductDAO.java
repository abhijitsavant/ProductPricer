package com.dao;

import java.util.List;

import com.entities.ProductDetail;
import com.entities.ProductPricer;
import com.entities.StoreMaster;

public interface ProductDAO {
	public List<ProductDetail> getProductList();
	public ProductDetail getProductDetailsByBarCode(String barCode);
	public boolean upsertProductInformation(ProductPricer productPricer);
	public List<StoreMaster> getStoreList();
}
