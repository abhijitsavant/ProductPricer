package com.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

public class ProductBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String productDesc;
	private String storeId;
	private String barCode;
	private String productPrice;
	private String notes;
	private String storeName;
	private BigDecimal lowestPrice;
	private BigDecimal averagePrice;
	private BigDecimal highestPrice;
	private BigDecimal idealPrice;
	private int productLength;
	private Map<String,String> stores;
	
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public Map<String, String> getStores() {
		return stores;
	}
	public void setStores(Map<String, String> stores) {
		this.stores = stores;
	}
	public BigDecimal getLowestPrice() {
		return lowestPrice;
	}
	public void setLowestPrice(BigDecimal lowestPrice) {
		this.lowestPrice = lowestPrice;
	}
	public BigDecimal getAveragePrice() {
		return averagePrice;
	}
	public void setAveragePrice(BigDecimal averagePrice) {
		this.averagePrice = averagePrice;
	}
	public BigDecimal getHighestPrice() {
		return highestPrice;
	}
	public void setHighestPrice(BigDecimal highestPrice) {
		this.highestPrice = highestPrice;
	}
	public void setIdealPrice(BigDecimal idealPrice) {
		this.idealPrice = idealPrice;
	}
	public BigDecimal getIdealPrice() {
		return idealPrice;
	}
	public int getProductLength() {
		return productLength;
	}
	public void setProductLength(int productLenght) {
		this.productLength = productLenght;
	}
}