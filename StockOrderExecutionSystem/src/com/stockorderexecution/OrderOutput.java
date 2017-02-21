package com.stockorderexecution;

import java.math.BigInteger;

public class OrderOutput {

	private BigInteger quantityLeft;
	private String status;	
	/**
	 * @return the quantityLeft
	 */
	public BigInteger getQuantityLeft() {
		return quantityLeft;
	}
	/**
	 * @param quantityLeft the quantityLeft to set
	 */
	public void setQuantityLeft(BigInteger quantityLeft) {
		this.quantityLeft = quantityLeft;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}