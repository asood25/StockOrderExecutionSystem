package com.stockorderexecution;

import java.math.BigInteger;

public class OrderInput {

	private String orderType;
	private String companyName;
	private BigInteger orderQuantity;
	private BigInteger quantityLeft;
	private String orderStatus;
	
	/**
	 * @return the orderType
	 */
	public String getOrderType() {
		return orderType;
	}
	/**
	 * @param orderType the orderType to set
	 */
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * @return the orderQuantity
	 */
	public BigInteger getOrderQuantity() {
		return orderQuantity;
	}
	/**
	 * @param orderQuantity the orderQuantity to set
	 */
	public void setOrderQuantity(BigInteger orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
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
	 * @return the orderStatus
	 */
	public String getOrderStatus() {
		return orderStatus;
	}
	/**
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
}