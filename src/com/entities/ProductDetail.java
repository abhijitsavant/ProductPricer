package com.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "PRODUCT")
public class ProductDetail implements Serializable {

	private static final long serialVersionUID = -3310819941793604383L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;

	@Column(name = "BARCODE")
	private String barCode;

	@Column(name = "DESCRIPTION")
	private String productDesc;

	@Transient
	private BigDecimal lowestPrice;
	@Transient
	private BigDecimal averagePrice;
	@Transient
	private BigDecimal highestPrice;
	@Transient
	private BigDecimal idealPrice;
	@Transient
	private int productLength;
	
	public void setId(BigInteger id) {
		this.id = id;
	}

	public BigInteger getId() {
		return id;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
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
	public BigDecimal getIdealPrice() {
		return idealPrice;
	}
	public void setIdealPrice(BigDecimal idealPrice) {
		this.idealPrice = idealPrice;
	}

	public int getProductLength() {
		return productLength;
	}

	public void setProductLength(int productLength) {
		this.productLength = productLength;
	}
}
