package com.litmus7.retail.dao;

import java.util.List;

import com.litmus7.retail.dto.Product;
import com.litmus7.retail.exception.ProductDAOException;

public interface ProductDAO {
	
	Product addProduct(Product product) throws ProductDAOException;
	Product getProductById(int productId) throws ProductDAOException;
	List<Product> getAllProducts() throws ProductDAOException;
	Product updateProduct(Product product) throws ProductDAOException;
	String deleteProduct(int productId) throws ProductDAOException;
	
}
