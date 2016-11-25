package com.entities;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STORE")
public class StoreMaster implements Serializable {

	private static final long serialVersionUID = -6609507946400478658L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger storeId;

	@Column(name = "NAME")
	private String name;

	public BigInteger getStoreId() {
		return storeId;
	}

	public void setStoreId(BigInteger storeId) {
		this.storeId = storeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
