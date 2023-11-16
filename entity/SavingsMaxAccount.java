package com.ilp.entity;

import java.util.ArrayList;

public class SavingsMaxAccount extends Product {
	private double minBalance=1000.0;

	public SavingsMaxAccount(String productCode, String productName, ArrayList<Services> serviceList) {
		super(productCode, productName, serviceList);
	}

	public double getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}
	

}
