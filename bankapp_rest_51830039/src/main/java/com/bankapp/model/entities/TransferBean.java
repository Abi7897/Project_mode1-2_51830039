package com.bankapp.model.entities;

public class TransferBean {
private Long fromAccount;
private Long toAccount;
private double amount;

public Long getFromAccount() {
	return fromAccount;
}
public void setFromAccount(Long fromAccount) {
	this.fromAccount = fromAccount;
}
public Long getToAccount() {
	return toAccount;
}
public void setToAccount(Long toAccount) {
	this.toAccount = toAccount;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public TransferBean(Long fromAccount, Long toAccount, double amount) {
	super();
	this.fromAccount = fromAccount;
	this.toAccount = toAccount;
	this.amount = amount;
}
public TransferBean() {
	super();
}


}
