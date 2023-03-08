package com.jbk.model;

import com.jbk.entity.Category;
import com.jbk.entity.Supplier;

public class FinalProduct {

	private String productId;
	private String productName;
	private Supplier supplier;
	private Category category;
	private int productQTY;
	private double productPrice;
	private Charges charges;
	private double discountAmount;
	private double finalProductPrice;
	
	public FinalProduct() {
		// TODO Auto-generated constructor stub
	}

	public FinalProduct(String productId, String productName, Supplier supplier, Category category, int productQTY,
			double productPrice, Charges charges, double discountAmount, double finalProductPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.supplier = supplier;
		this.category = category;
		this.productQTY = productQTY;
		this.productPrice = productPrice;
		this.charges = charges;
		this.discountAmount = discountAmount;
		this.finalProductPrice = finalProductPrice;
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

	public Charges getCharges() {
		return charges;
	}

	public void setCharges(Charges charges) {
		this.charges = charges;
	}

	public double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public double getFinalProductPrice() {
		return finalProductPrice;
	}

	public void setFinalProductPrice(double finalProductPrice) {
		this.finalProductPrice = finalProductPrice;
	}
	
	
	
}
