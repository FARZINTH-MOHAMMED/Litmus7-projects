package com.litmus7.retaildiscountsystem.ui;

import java.util.Scanner;

import com.litmus7.retaildiscountsystem.model.Discountable;
import com.litmus7.retaildiscountsystem.model.impl.PremiumCustomers;
import com.litmus7.retaildiscountsystem.model.impl.RegularCustomer;
import com.litmus7.retaildiscountsystem.model.impl.WholesaleCustomer;

/**
 * Java app for taking total amount as input and printing discounted price
 * 
 * @author Farzinth Mohammed
 */
public class RetailsDiscountApp {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter customer type(1- Regular, 2- Premium, 3- Wholesale):");
		int type = scanner.nextInt();

		System.out.println("Enter total purchase amount");
		double totalAmount = scanner.nextDouble();

		double discountedAmount = 0;
		String customerType = null;

		scanner.close();

		switch (type) {
		case 1: {
			Discountable customer = new RegularCustomer();
			discountedAmount = customer.applyDiscount(totalAmount);
			customerType = "Regular Customer";
			break;
		}
		case 2: {
			Discountable customer = new PremiumCustomers();
			discountedAmount = customer.applyDiscount(totalAmount);
			customerType = "Premium Customer";
			break;
		}

		case 3: {
			Discountable customer = new WholesaleCustomer();
			discountedAmount = customer.applyDiscount(totalAmount);
			customerType = "Wholesale Customer";
			break;
		}
		default:
			System.out.println("Something wrong");

		}

		System.out.println("Customer type: " + customerType);
		System.out.println("Original Amount: " + totalAmount);
		System.out.println("Discount Applied: " + (totalAmount - discountedAmount));
		System.out.println("Final Payable Amount: " + discountedAmount);
	}
}
