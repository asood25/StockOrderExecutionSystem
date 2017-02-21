package com.stockorderexecution;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class StockOrderExecutionMain {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		boolean addOrder = true;
		OrderInput odrIpt = new OrderInput();
		List<OrderInput> buyOdrIptList = new LinkedList<OrderInput>();
		List<OrderInput> sellOdrIptList = new LinkedList<OrderInput>();
		List<OrderInput> totalOrdersInput = new LinkedList<OrderInput>();
		
		System.out.println("Please enter the order type (Is it a Buy or Sell): ");
		
		while(scan.hasNext()) {
			
			if(addOrder) {
				
				String orderType = scan.next();
				System.out.println("Scan 2: " + orderType);
				
				if(orderType.equalsIgnoreCase(Constants.ORDER_BUY)) {
					
					System.out.println("Scan 3: " + orderType);
					odrIpt.setOrderType(Constants.ORDER_BUY);
					setOrderValues(scan, odrIpt);
					buyOdrIptList.add(odrIpt);
					
				} else if(orderType.equalsIgnoreCase(Constants.ORDER_SELL)) {
					
					System.out.println("Scan 4: " + orderType);
					odrIpt.setOrderType(Constants.ORDER_SELL);
					setOrderValues(scan, odrIpt);
					sellOdrIptList.add(odrIpt);
					
				} else {
					
					System.out.println("inside else 1");
					System.out.println("Please enter the  order type (Is it a Buy or Sell): ");
					scan = new Scanner(System.in);
					continue;
					
				}
				
				System.out.println("Input order sucessfully saved.");
				totalOrdersInput.add(odrIpt);
				addOrder = false;
				
				System.out.println("Press 1 to add more orders.");
				System.out.println("Press 2 to process the saved orders.");
			}
			
			if(scan.hasNextInt()) {
				
				int userChoice = scan.nextInt();
				
				if(userChoice == 1) {
					
					addOrder = true;
					scan = new Scanner(System.in);
					System.out.println("Please enter the order type (Is it a Buy or Sell): ");
					continue;
					
				} else if(userChoice == 2) {
					
					OrdersDisplayUtil.renderHeaderColumns(true, false);
					OrdersDisplayUtil.showInputOrders(totalOrdersInput);
					StockOrderProcessing.processStockOrders(buyOdrIptList, sellOdrIptList, totalOrdersInput);
					
				} else {
					
					System.out.println("Please select the correct option.");
					System.out.println("Press 1 to add more orders.");
					System.out.println("Press 2 to process the saved orders.");
					scan = new Scanner(System.in);
					continue;
				}
				
			} else {
				
				System.out.println("Please provide the correct input.");
				System.out.println("Press 1 to add more orders.");
				System.out.println("Press 2 to process the saved orders.");
				scan = new Scanner(System.in);
				continue;
			}
		}	
	}
	
	/**
	 * 
	 * @param scan
	 * @param odrIpt
	 */
	private static void setOrderValues(Scanner scan, OrderInput odrIpt) {
		
		System.out.println("Please enter the company name: ");			
		
		while(scan.hasNext()) { 
		
			if(scan.hasNextLine()) {
				String companyName = scan.next();
				System.out.println("Scan 5: " + companyName);
				odrIpt.setCompanyName(companyName.toUpperCase().trim());
			}
		
			System.out.println("Please enter the order quantity: ");			
		
			if(scan.hasNextBigInteger()) {
				
				BigInteger orderQuantity = scan.nextBigInteger();
				System.out.println("Scan 6: " + orderQuantity);
				
				if(orderQuantity.compareTo(BigInteger.ZERO) == 0 || orderQuantity.compareTo(BigInteger.ZERO) < 0) {
					
					System.out.println("inside if 1");
					System.out.println("Please enter the correct value for order quantity: ");
					scan = new Scanner(System.in);
					continue;
					
				} else { 
					odrIpt.setOrderQuantity(orderQuantity);
					odrIpt.setQuantityLeft(orderQuantity);
				}
				
			} else {
				
				System.out.println("inside else 2");
				System.out.println("Please enter the order quantity: ");
				scan = new Scanner(System.in);
				continue;
			}
			
			odrIpt.setOrderStatus(Constants.STATUS_OPEN);
			break;
		}
	}
}