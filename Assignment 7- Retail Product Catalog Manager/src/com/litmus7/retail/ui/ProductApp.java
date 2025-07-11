package com.litmus7.retail.ui;

import java.util.List;
import java.util.Scanner;

import com.litmus7.retail.controller.ProductController;
import com.litmus7.retail.dto.Product;
import com.litmus7.retail.dto.Response;

public class ProductApp {

	public static void main(String[] args) {

		ProductController productController = new ProductController();
		boolean flag=true;
		while(flag) {
			
			System.out.println("Choose an option:");
			showOptions();
			Scanner scanner = new Scanner(System.in);
			int option = scanner.nextInt();
			switch (option) {
			case 1:
				addProduct(productController,scanner);
				break;
			case 2:
				viewProductById(productController,scanner);
				break;
				
			case 3:
				viewAllProduct(productController);
				break;
				
			case 4:
				updateProduct(productController,scanner);
				break;
				
			case 5:
				deleteProduct(productController,scanner);
				break;
			case 6:
				flag=false;
				break;
			default: System.out.println("Enter a valid option");
			
			}
		}

	}

	private static void showOptions() {
		System.out.println("1. Add Product");
		System.out.println("2. View Product by ID");
		System.out.println("3. View all products");
		System.out.println("4. Update product");
		System.out.println("5. Delete Product");
		System.out.println("6. Exit");
	}

	private static void addProduct(ProductController productController,Scanner scanner) {
		System.out.print("Enter product name: ");
        String productName = scanner.nextLine();

        System.out.print("Enter category: ");
        String category = scanner.nextLine();

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter stock quantity: ");
        int stockQuantity = scanner.nextInt();

        Product product = new Product(productName,category,price,stockQuantity);

        Response<Product> addProductResponse=productController.addProduct(product);
        handleResponse(addProductResponse);
        
        
        
	}

	private static void viewProductById(ProductController productController,Scanner scanner) {
		System.out.print("Enter product ID: ");
        int productId = scanner.nextInt();

        Response<Product> viewProductResponse= productController.getProductByProductId(productId);
        handleResponse(viewProductResponse);
	}

	private static void viewAllProduct(ProductController productController) {
		Response<List<Product>> viewAllProductResponse= productController.getAllProducts();
		handleResponse(viewAllProductResponse);
	}

	private static void updateProduct(ProductController productController,Scanner scanner) {
		System.out.print("Enter product name: ");
        String productName = scanner.nextLine();

        System.out.print("Enter category: ");
        String category = scanner.nextLine();

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter stock quantity: ");
        int stockQuantity = scanner.nextInt();

        Product product = new Product(productName,category,price,stockQuantity);

        Response<Product> updateProductResponse=productController.addProduct(product);
        handleResponse(updateProductResponse);
	}

	private static void deleteProduct(ProductController productController,Scanner scanner) {
		System.out.println("Enter product ID to delete:");
		int productId= scanner.nextInt();
		Response<String> deleteResponse= productController.deleteProduct(productId);
		handleResponse(deleteResponse);
	}
	
	private static void handleResponse(Response response) {
		if(response.getStatusCode()==400) {
			System.out.println(response.getResponseData());
		}
		else {
			System.out.println(response.getErrorMessage());
		}
	}

}
