package com.service;

import java.util.List;

import com.bean.ProductBean;
import com.entities.ProductDetail;

public interface ProductService {
	public List<ProductDetail> getProductList();
	public ProductBean getProductDetailsByBarCode(String barCode);
	public boolean upsertProductInformation(ProductBean productBean);
	public ProductBean getStoreList();
}
