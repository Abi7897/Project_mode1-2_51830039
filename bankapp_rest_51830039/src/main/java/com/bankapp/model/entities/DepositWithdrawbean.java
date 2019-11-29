package com.bankapp.model.entities;

public class DepositWithdrawbean {
	private Long accountNumber;
	private double amount;
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public DepositWithdrawbean(Long accountNumber, double amount) {
		super();
		this.accountNumber = accountNumber;
		this.amount = amount;
	}
	public DepositWithdrawbean() {
		super();
	}
	
	
}
