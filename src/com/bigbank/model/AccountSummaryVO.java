package com.bigbank.model;

public class AccountSummaryVO {
	
	private String name;
	private float balance, reqwardsBalance;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public float getReqwardsBalance() {
		return reqwardsBalance;
	}
	public void setReqwardsBalance(float reqwardsBalance) {
		this.reqwardsBalance = reqwardsBalance;
	}	
}
