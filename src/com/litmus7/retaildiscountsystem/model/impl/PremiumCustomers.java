package com.litmus7.retaildiscountsystem.model.impl;

import com.litmus7.retaildiscountsystem.model.Discountable;

public class PremiumCustomers implements Discountable {
	private final double discountRate = 0.07;
	private final double discountRateAbove5000 = 0.10;

	@Override
	public double applyDiscount(double totalAmount) {
		if (totalAmount > 5000)
			return (totalAmount - (totalAmount * discountRateAbove5000));
		else
			return (totalAmount - (totalAmount * discountRate));

	}

}
