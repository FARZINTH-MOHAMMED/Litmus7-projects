package com.litmus7.retail.service;

import java.util.List;

import com.litmus7.retail.dao.ProductDAO;
import com.litmus7.retail.dao.ProductDAOImpl;
import com.litmus7.retail.dto.Product;
import com.litmus7.retail.exception.ProductDAOException;
import com.litmus7.retail.exception.ProductServiceException;

public class ProductService {
	private ProductDAO productDAO= new ProductDAOImpl();
	
	public Product addProduct(Product product) throws ProductServiceException {
		try {
			return(productDAO.addProduct(product));
		} catch (ProductDAOException e) {
			throw new ProductServiceException(e.getMessage(), e);
		}
	}
	
	public Product getProductByProductId(int productId) throws ProductServiceException {
		try {
			return productDAO.getProductById(productId);
		} catch (ProductDAOException e) {
			throw new ProductServiceException(e.getMessage(), e);
		}
	}
	
	public List<Product> getAllProducts() throws ProductServiceException{
		try {
			return productDAO.getAllProducts();
		} catch (ProductDAOException e) {
			throw new ProductServiceException(e.getMessage(),e);
		}
	}
	
	public Product updateProduct(Product product) throws ProductServiceException {
		try {
			return productDAO.updateProduct(product);
		} catch (ProductDAOException e) {
			throw new ProductServiceException(e.getMessage(),e);
		}
	}
	
	public String deleteProduct(int productId) throws ProductServiceException {
		try {
			return productDAO.deleteProduct(productId);
		} catch (ProductDAOException e) {
			throw new ProductServiceException(e.getMessage(), e);
		}
	}
	
}
