package com.stockorderexecution;

import java.util.List;

public class StockOrderProcessing {

	/**
	 * 
	 * @param buyOdrIptList
	 * @param sellOdrIptList
	 */
	protected static void processStockOrders(List<OrderInput> buyOdrIptList, List<OrderInput> sellOdrIptList, List<OrderInput> totalOrderInputs) {

		OrderOutput odrOtp = new OrderOutput();

		if(buyOdrIptList.size() > 0 && sellOdrIptList.size() == 0) {
			
			setProcessedOrders(buyOdrIptList, odrOtp);
			
		} else if (buyOdrIptList.size() == 0 && sellOdrIptList.size() > 0) {
			
			setProcessedOrders(sellOdrIptList, odrOtp);
			
		} else if (buyOdrIptList.size() > 0 && sellOdrIptList.size() > 0) {
			
			for(OrderInput odrIpt : totalOrderInputs) {
				
				//If the order is a buy order
				if(odrIpt.getOrderType().equalsIgnoreCase(Constants.ORDER_BUY) && odrIpt.getOrderStatus().equalsIgnoreCase(Constants.STATUS_OPEN)) {
					
					OrdersDisplayUtil.renderHeaderColumns(false, true);
					boolean matchingOrderFound = false;
					
					for(OrderInput sellOdrIpt : sellOdrIptList) {
						
						//looking for matching sell order
						if(sellOdrIpt.getCompanyName().equalsIgnoreCase(odrIpt.getCompanyName()) && odrIpt.getOrderStatus().equalsIgnoreCase(Constants.STATUS_OPEN)) {
							
							matchingOrderFound = true;
							
							if(odrIpt.getQuantityLeft().compareTo(sellOdrIpt.getQuantityLeft()) > 1) {
								
								//setting qty left & status for Buy order when buy qty > sell qty
								odrOtp.setQuantityLeft(odrIpt.getQuantityLeft().subtract(sellOdrIpt.getQuantityLeft()));
								odrOtp.setStatus(Constants.STATUS_OPEN);
								
								OrdersDisplayUtil.showProcessedOrders(odrIpt, odrOtp);
								
								sellOdrIpt.setQuantityLeft(Constants.ZERO);
								sellOdrIpt.setOrderStatus(Constants.STATUS_CLOSED);
								
								odrOtp.setQuantityLeft(Constants.ZERO);
								odrOtp.setStatus(Constants.STATUS_CLOSED);
								
								OrdersDisplayUtil.showProcessedOrders(sellOdrIpt, odrOtp);
								
							} else if(odrIpt.getOrderQuantity().compareTo(sellOdrIpt.getOrderQuantity()) < 0) {
								
								//setting qty left & status for Buy order when buy qty < sell qty
								odrOtp.setQuantityLeft(Constants.ZERO);
								odrOtp.setStatus(Constants.STATUS_CLOSED);
								
								OrdersDisplayUtil.showProcessedOrders(odrIpt, odrOtp);
								
								sellOdrIpt.setQuantityLeft(sellOdrIpt.getOrderQuantity().subtract(odrIpt.getOrderQuantity()));
								sellOdrIpt.setOrderStatus(Constants.STATUS_OPEN);
								
								odrOtp.setQuantityLeft(sellOdrIpt.getOrderQuantity().subtract(odrIpt.getOrderQuantity()));
								odrOtp.setStatus(Constants.STATUS_OPEN);
								
								OrdersDisplayUtil.showProcessedOrders(sellOdrIpt, odrOtp);
								
							} else if(odrIpt.getOrderQuantity().compareTo(sellOdrIpt.getOrderQuantity()) == 0) {
								
								//setting qty left & status for Buy order when buy qty == sell qty
								odrOtp.setQuantityLeft(Constants.ZERO);
								odrOtp.setStatus(Constants.STATUS_CLOSED);
								
								OrdersDisplayUtil.showProcessedOrders(odrIpt, odrOtp);
								
								sellOdrIpt.setQuantityLeft(Constants.ZERO);
								sellOdrIpt.setOrderStatus(Constants.STATUS_CLOSED);
								
								odrOtp.setQuantityLeft(Constants.ZERO);
								odrOtp.setStatus(Constants.STATUS_CLOSED);
								
								OrdersDisplayUtil.showProcessedOrders(sellOdrIpt, odrOtp);
							}
							
							break;
						}
					}
					
					if(!matchingOrderFound) {
						
						odrOtp.setQuantityLeft(odrIpt.getQuantityLeft());
						odrOtp.setStatus(Constants.STATUS_OPEN);
						
						OrdersDisplayUtil.showProcessedOrders(odrIpt, odrOtp);
					}
				} 
				
				//If the order is a sell order				
				else if(odrIpt.getOrderType().equalsIgnoreCase(Constants.ORDER_SELL) && odrIpt.getOrderStatus().equalsIgnoreCase(Constants.STATUS_OPEN)) {
					
					OrdersDisplayUtil.renderHeaderColumns(false, true);
					boolean matchingOrderFound = false;
					
					for(OrderInput buyOdrIpt : buyOdrIptList) {
						
						//looking for matching buy order
						if(buyOdrIpt.getCompanyName().equalsIgnoreCase(odrIpt.getCompanyName()) && odrIpt.getOrderStatus().equalsIgnoreCase(Constants.STATUS_OPEN)) {
							
							matchingOrderFound = true;
							
							if(odrIpt.getQuantityLeft().compareTo(buyOdrIpt.getQuantityLeft()) > 1) {
								
								//setting qty left & status for Buy order when buy qty > sell qty
								odrOtp.setQuantityLeft(odrIpt.getQuantityLeft().subtract(buyOdrIpt.getQuantityLeft()));
								odrOtp.setStatus(Constants.STATUS_OPEN);
								
								OrdersDisplayUtil.showProcessedOrders(odrIpt, odrOtp);
								
								buyOdrIpt.setQuantityLeft(Constants.ZERO);
								buyOdrIpt.setOrderStatus(Constants.STATUS_CLOSED);
								
								odrOtp.setQuantityLeft(Constants.ZERO);
								odrOtp.setStatus(Constants.STATUS_CLOSED);
								
								OrdersDisplayUtil.showProcessedOrders(buyOdrIpt, odrOtp);
								
							} else if(odrIpt.getOrderQuantity().compareTo(buyOdrIpt.getOrderQuantity()) < 0) {
								
								//setting qty left & status for Buy order when buy qty < sell qty
								odrOtp.setQuantityLeft(Constants.ZERO);
								odrOtp.setStatus(Constants.STATUS_CLOSED);
								
								OrdersDisplayUtil.showProcessedOrders(odrIpt, odrOtp);
								
								buyOdrIpt.setQuantityLeft(buyOdrIpt.getOrderQuantity().subtract(odrIpt.getOrderQuantity()));
								buyOdrIpt.setOrderStatus(Constants.STATUS_OPEN);
								
								odrOtp.setQuantityLeft(buyOdrIpt.getOrderQuantity().subtract(odrIpt.getOrderQuantity()));
								odrOtp.setStatus(Constants.STATUS_OPEN);
								
								OrdersDisplayUtil.showProcessedOrders(buyOdrIpt, odrOtp);
								
							} else if(odrIpt.getOrderQuantity().compareTo(buyOdrIpt.getOrderQuantity()) == 0) {
								
								//setting qty left & status for Buy order when buy qty == sell qty
								odrOtp.setQuantityLeft(Constants.ZERO);
								odrOtp.setStatus(Constants.STATUS_CLOSED);
								
								OrdersDisplayUtil.showProcessedOrders(odrIpt, odrOtp);
								
								buyOdrIpt.setQuantityLeft(Constants.ZERO);
								buyOdrIpt.setOrderStatus(Constants.STATUS_CLOSED);
								
								odrOtp.setQuantityLeft(Constants.ZERO);
								odrOtp.setStatus(Constants.STATUS_CLOSED);
								
								OrdersDisplayUtil.showProcessedOrders(buyOdrIpt, odrOtp);
							}
							
							break;
						}
					}
					
					if(!matchingOrderFound) {
						
						odrOtp.setQuantityLeft(odrIpt.getQuantityLeft());
						odrOtp.setStatus(Constants.STATUS_OPEN);
						
						OrdersDisplayUtil.showProcessedOrders(odrIpt, odrOtp);
					}
				}
			}
		}
	}
	
	private static void setProcessedOrders(List<OrderInput> targetOrder, OrderOutput odrOtp) {
		
		OrdersDisplayUtil.renderHeaderColumns(false, true);
		
		for(OrderInput odrIpt : targetOrder) {
			
			odrOtp.setQuantityLeft(odrIpt.getOrderQuantity());
			odrOtp.setStatus(Constants.STATUS_OPEN);
							
			OrdersDisplayUtil.showProcessedOrders(odrIpt, odrOtp);
		}
	}
}