package com.stockorderexecution;

import java.util.List;

public class OrdersDisplayUtil {
	
	/**
	 * 
	 * @param isInputOrders
	 * @param isOutputOrders
	 */
	public static void renderHeaderColumns(boolean isInputOrders, boolean isOutputOrders) {
		
		if(isInputOrders) {
			
			System.out.println(Constants.SIDE + Constants.TAB_SPACE
					+ Constants.COMPANY + Constants.TAB_SPACE + Constants.QUANTITY);
			
		} else if (isOutputOrders) {
		
			System.out.println(Constants.SIDE + Constants.TAB_SPACE
					+ Constants.COMPANY + Constants.TAB_SPACE + Constants.QUANTITY
					+ Constants.TAB_SPACE + Constants.QUANTITY_LEFT
					+ Constants.TAB_SPACE + Constants.STATUS);
		}
	}
	
	/**
	 * 
	 * @param totalOrdersInput
	 */
	public static void showInputOrders(List<OrderInput> totalOrdersInput) {
		
		for(OrderInput odrIpt : totalOrdersInput) {
			
			System.out.println(odrIpt.getOrderType() + Constants.TAB_SPACE
				+ odrIpt.getCompanyName() + Constants.TAB_SPACE
				+ odrIpt.getOrderQuantity());
		}
	}
	
	/**
	 * 
	 * @param odrIpt
	 * @param odrOtp
	 */
	public static void showProcessedOrders(OrderInput odrIpt, OrderOutput odrOtp) {
		
		System.out.println(odrIpt.getOrderType() + Constants.TAB_SPACE
				+ odrIpt.getCompanyName() + Constants.TAB_SPACE
				+ odrIpt.getOrderQuantity() + Constants.TAB_SPACE
				+ odrOtp.getQuantityLeft() + Constants.TAB_SPACE
				+ odrOtp.getStatus());
	}
}