package com.litmus7.retail.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.litmus7.retail.dto.Product;
import com.litmus7.retail.exception.ProductDAOException;
import com.litmus7.retail.util.DBUtil;
import com.litmus7.retail.util.SQLConstant;

public class ProductDAOImpl implements ProductDAO {

	@Override
	public Product addProduct(Product product) throws ProductDAOException {
		int productId = 0;
		String productName = null;
		String category = null;
		double price = 0;
		int stockQuantity = 0;

		try (Connection connection = DBUtil.getConnection();
				PreparedStatement statment = connection.prepareStatement(SQLConstant.getAddProduct())) {
			statment.setString(1, product.getProduct_name());
			statment.setString(2, product.getCategory());
			statment.setDouble(3, product.getPrice());
			statment.setInt(4, product.getStockQuantity());

			statment.execute();

			try (PreparedStatement responseStatment = connection
					.prepareStatement(SQLConstant.getResponseToAddProduct())) {

				responseStatment.setString(1, product.getProduct_name());
				try (ResultSet result = responseStatment.executeQuery();) {
					if (result.next()) {
						productId = result.getInt(SQLConstant.getPRODUCT_ID());
						productName = result.getString(SQLConstant.getPRODUCT_NAME());
						category = result.getString(SQLConstant.getCATEGORY());
						price = result.getDouble(SQLConstant.getPRICE());
						stockQuantity = result.getInt(SQLConstant.getSTOCK_QUANTITY());
					}
					return new Product(productId, productName, category, price, stockQuantity);
				} catch (SQLException e) {
					throw new ProductDAOException("Product added.Coundn't fetch the result:" + e.getMessage(), e);
				}

			}
		} catch (SQLException e) {
			throw new ProductDAOException("Couldn't add product data", e);
		}

	}

	@Override
	public Product getProductById(int productId) throws ProductDAOException {
		String productName = null;
		String category = null;
		double price = 0;
		int stockQuantity = 0;

		try (Connection connection = DBUtil.getConnection();
				PreparedStatement statment = connection.prepareStatement(SQLConstant.getProductByProductId())) {
			statment.setInt(1, productId);
			try (ResultSet result = statment.executeQuery()) {
				if (result.next()) {
					productName = result.getString(SQLConstant.getPRODUCT_NAME());
					category = result.getString(SQLConstant.getCATEGORY());
					price = result.getDouble(SQLConstant.getPRICE());
					stockQuantity = result.getInt(SQLConstant.getSTOCK_QUANTITY());
				}

				return new Product(productName, category, price, stockQuantity);
			}

		} catch (SQLException e) {
			throw new ProductDAOException("Couldn't fetch product details", e);
		}
	}

	@Override
	public List<Product> getAllProducts() throws ProductDAOException {
		List<Product> products = new ArrayList<Product>();
		int productId = 0;
		String productName = null;
		String category = null;
		double price = 0;
		int stockQuantity = 0;

		try (Connection connection = DBUtil.getConnection();
				PreparedStatement statment = connection.prepareStatement(SQLConstant.getAllProducts());
				ResultSet result = statment.executeQuery()) {
			while (result.next()) {
				productId = result.getInt(SQLConstant.getPRODUCT_ID());
				productName = result.getString(SQLConstant.getPRODUCT_NAME());
				category = result.getString(SQLConstant.getCATEGORY());
				price = result.getDouble(SQLConstant.getPRICE());
				stockQuantity = result.getInt(SQLConstant.getSTOCK_QUANTITY());
				products.add(new Product(productId, productName, category, price, stockQuantity));
			}
			return products;

		} catch (SQLException e) {
			throw new ProductDAOException("Couldn't load product data", e);
		}
	}

	@Override
	public Product updateProduct(Product product) throws ProductDAOException {
		int productId = 0;
		String productName = null;
		String category = null;
		double price = 0;
		int stockQuantity = 0;

		try (Connection connection = DBUtil.getConnection();
				PreparedStatement statment = connection.prepareStatement(SQLConstant.getUpdateProduct())) {
			statment.setString(1, product.getProduct_name());
			statment.setString(2, product.getCategory());
			statment.setDouble(3, product.getPrice());
			statment.setInt(4, product.getStockQuantity());
			statment.setString(5, product.getProduct_name());

			statment.executeUpdate();
			try (PreparedStatement responseStatment = connection
					.prepareStatement(SQLConstant.getResponseToAddProduct())) {

				responseStatment.setString(1, product.getProduct_name());
				try (ResultSet result = responseStatment.executeQuery();) {
					if (result.next()) {
						productId = result.getInt(SQLConstant.getPRODUCT_ID());
						productName = result.getString(SQLConstant.getPRODUCT_NAME());
						category = result.getString(SQLConstant.getCATEGORY());
						price = result.getDouble(SQLConstant.getPRICE());
						stockQuantity = result.getInt(SQLConstant.getSTOCK_QUANTITY());
					}
					return new Product(productId, productName, category, price, stockQuantity);
				} catch (SQLException e) {
					throw new ProductDAOException("Couldn't load result", e);
				}
			}
		} catch (SQLException e) {
			throw new ProductDAOException("Couldn't update product", e);
		}
	}

	@Override
	public String deleteProduct(int productId) throws ProductDAOException {
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement statment = connection.prepareStatement(SQLConstant.getDeleteProduct())) {
			statment.setInt(1, productId);
			statment.executeUpdate();
			return "Delete successfull";
		} catch (SQLException e) {
			throw new ProductDAOException("Couldn't delete product", e);
		}
	}

}
