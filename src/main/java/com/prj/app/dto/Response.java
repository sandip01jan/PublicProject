package com.prj.app.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Response {
	private int customerId;
	
	@JsonInclude(Include.NON_DEFAULT)
	private int month;

	@JsonInclude(Include.NON_NULL)
	private String transactionDate;
	
	private int amount;
	
	private int rewardPoints;

	@Override
	public String toString() {
		return String.format("Response [customerId=%s, month=%s, amount=%s, rewardPoints=%s, transactionDate=%s]",
				customerId, month, amount, rewardPoints, transactionDate);
	}
	
	public int getRewardPoints() {
		return rewardPoints;
	}
	public void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
}
