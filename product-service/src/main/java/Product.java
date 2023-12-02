package com.example.microservices;

public class Product {
	private int productId;
	private String productName;
	private double price;
	private String description;
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price
				+ ", description=" + description + "]";
	}
	public int getProductId() {
		return productId;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Product() {}
	public Product(int productId, String productName, double price, String description) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.description = description;
	}
	public void setProductId(long newProductId) {
				
	}
	
	
	
}