package com.litmus7.model.impl;

import com.litmus7.retaildiscountsystem.model.Discountable;

public class RegularCustomer implements Discountable {
	private final double discountRate = 0.05;

	public double applyDiscount(double totalAmount) {
		return totalAmount - (discountRate * totalAmount);
	};

}
