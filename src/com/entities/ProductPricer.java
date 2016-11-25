package com.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT_PRICE")
public class ProductPricer implements Serializable, Comparable<ProductPricer> {

	private static final long serialVersionUID = -6609507946400478658L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;

	@Column(name = "PRICE")
	private BigDecimal price;

	@Column(name = "NOTES")
	private String notes;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
	private ProductDetail productDetail;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "STORE_ID", referencedColumnName = "ID")
	private StoreMaster storeMaster;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public ProductDetail getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(ProductDetail productDetail) {
		this.productDetail = productDetail;
	}

	public StoreMaster getStoreMaster() {
		return storeMaster;
	}

	public void setStoreMaster(StoreMaster storeMaster) {
		this.storeMaster = storeMaster;
	}

	@Override
	public int compareTo(ProductPricer productPricer) {
		BigDecimal price1 = this.getPrice();
		BigDecimal price2 = productPricer.getPrice();
		return price1.compareTo(price2);
	}

}
