package com.litmus7.retail.controller;

import java.util.List;

import com.litmus7.retail.dto.Product;
import com.litmus7.retail.dto.Response;
import com.litmus7.retail.exception.ProductServiceException;
import com.litmus7.retail.service.ProductService;

public class ProductController {
	
	private static int ERROR_STATUS_CODE=200;
	private static int SUCCESS_STATUS_CODE=400;
	private ProductService productService = new ProductService();

	public Response<Product> addProduct(Product product) {
		Response<Product> response=new Response<>();
		try {
			
			response.setResponseData(productService.addProduct(product)); 
			response.setStatusCode(SUCCESS_STATUS_CODE);
		} catch (ProductServiceException e) {
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}
	
	public Response<Product> getProductByProductId(int productId) {
		Response<Product> response= new Response<Product>();
		try {
			response.setResponseData(productService.getProductByProductId(productId));
			response.setStatusCode(SUCCESS_STATUS_CODE);
		} catch (ProductServiceException e) {
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}
	
	public Response<List<Product>> getAllProducts(){
		Response<List<Product>> response = new Response<>();
		try {
			response.setResponseData(productService.getAllProducts());
			response.setStatusCode(SUCCESS_STATUS_CODE);
		} catch (ProductServiceException e) {
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}
	
	public Response<Product> updateProduct(Product product) {
		Response<Product> response= new Response<Product>();
		try {
			response.setResponseData(productService.updateProduct(product));
			response.setStatusCode(SUCCESS_STATUS_CODE);
		} catch (ProductServiceException e) {
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}
	
	public Response<String> deleteProduct(int productId) {
		Response<String> response= new Response<String>();
		try {
			response.setResponseData(productService.deleteProduct(productId));
			response.setStatusCode(SUCCESS_STATUS_CODE);
		}catch (ProductServiceException e) {
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}
}
