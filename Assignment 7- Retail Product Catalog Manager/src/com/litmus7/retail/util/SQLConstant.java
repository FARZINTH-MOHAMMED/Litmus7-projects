package com.litmus7.retail.util;

public class SQLConstant {

	private static String addProduct = "INSERT INTO products(product_name,category,price,stock_quantity)"
			+ "VALUES(?,?,?,?);";

	private static String responseToAddProduct = "SELECT product_id,product_name,category,price,stock_quantity FROM products"
			+ " WHERE product_name=?;";

	private static String productByProductId = "SELECT product_id,product_name,category,price,stock_quantity FROM products "
			+ "WHERE product_id=?";

	private static String allProducts = "SELECT product_id,product_name,category,price,stock_quantity FROM products";

	private static String updateProduct = "UPDATE products SET product_name=?,category=?,price=?,stock_quantity=?"
			+ " WHERE product_name=?";

	private static String deleteProduct = "DELETE FROM products WHERE product_id=?";

	private static String PRODUCT_ID = "product_id";
	private static String PRODUCT_NAME = "product_name";
	private static String CATEGORY = "category";
	private static String PRICE = "price";
	private static String STOCK_QUANTITY = "stock_quantity";

	public static String getDeleteProduct() {
		return deleteProduct;
	}

	public static String getUpdateProduct() {
		return updateProduct;
	}

	public static String getAllProducts() {
		return allProducts;
	}

	public static String getProductByProductId() {
		return productByProductId;
	}

	public static String getPRODUCT_ID() {
		return PRODUCT_ID;
	}

	public static String getPRODUCT_NAME() {
		return PRODUCT_NAME;
	}

	public static String getCATEGORY() {
		return CATEGORY;
	}

	public static String getPRICE() {
		return PRICE;
	}

	public static String getSTOCK_QUANTITY() {
		return STOCK_QUANTITY;
	}

	public static String getResponseToAddProduct() {
		return responseToAddProduct;
	}

	public static String getAddProduct() {
		return addProduct;
	}

}
