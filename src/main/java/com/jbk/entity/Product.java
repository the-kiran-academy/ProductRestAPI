package com.jbk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
public class Product {

	@Id
	@Column(unique = true, nullable = false)
	@Min(1)
	private String productId;
	
	@Column(unique = true, nullable = false)
	@NotEmpty(message = "productName must be required")
	private String productName;

	@OneToOne
	private Supplier supplier;

	@OneToOne
	private Category category;

	@Column(nullable = false)
	@Min(1)
	private int productQTY;
	
	@Column(nullable = false)
	private double productPrice;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	
	public Product(String productId, String productName, Supplier supplier, Category category, int productQTY,
			double productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.supplier = supplier;
		this.category = category;
		this.productQTY = productQTY;
		this.productPrice = productPrice;
	}


	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	
	public Supplier getSupplier() {
		return supplier;
	}


	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public int getProductQTY() {
		return productQTY;
	}

	public void setProductQTY(int productQTY) {
		this.productQTY = productQTY;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", supplierId=" + supplier
				+ ", categoryId=" + category + ", productQTY=" + productQTY + ", productPrice=" + productPrice + "]";
	}

}
