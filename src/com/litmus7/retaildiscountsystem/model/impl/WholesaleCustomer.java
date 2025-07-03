package com.litmus7.retaildiscountsystem.model.impl;

import com.litmus7.retaildiscountsystem.model.Discountable;

public class WholesaleCustomer implements Discountable {

	private final double discountRate = 0.10;
	private final double discountRateAbove10000 = 0.15;

	@Override
	public double applyDiscount(double totalAmount) {

		if (totalAmount > 10000)
			return totalAmount - (totalAmount * discountRateAbove10000);
		else
			return totalAmount - (totalAmount * discountRate);

	}

}
