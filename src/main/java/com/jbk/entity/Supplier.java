package com.jbk.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Supplier {
	@Id
	private int supplierId;
	private String supplierName;
	private String city;
	private int postalCode;
	private String country;
	private String mobileNo;
	
	public Supplier() {
		// TODO Auto-generated constructor stub
	}

	public Supplier(int supplierId, String supplierName, String city, int postalCode, String country, String mobileNo) {
		super();
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.city = city;
		this.postalCode = postalCode;
		this.country = country;
		this.mobileNo = mobileNo;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Override
	public String toString() {
		return "Supplier [supplierId=" + supplierId + ", supplierName=" + supplierName + ", city=" + city
				+ ", postalCode=" + postalCode + ", country=" + country + ", mobileNo=" + mobileNo + "]";
	}
	
	
	
	
}