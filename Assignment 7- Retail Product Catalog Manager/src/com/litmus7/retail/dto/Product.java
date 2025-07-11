package com.litmus7.retail.dto;

public class Product {

	private int product_id;
	private String product_name;
	private String category;
	private double price;
	private int stockQuantity;

	@Override
	public String toString() {
		return ("product name:" + product_name + " category:" + category + " price:" + price + " Stock Quantity"
				+ stockQuantity);
	}

	public Product() {
		super();
	}
	

	public Product(int product_id, String product_name, String category, double price, int stockQuantity) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.category = category;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}

	public Product(String product_name, String category, double price, int stockQuantity) {
		super();
		this.product_name = product_name;
		this.category = category;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

}
