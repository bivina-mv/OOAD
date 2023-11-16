package com.ilp.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.Product;
import com.ilp.entity.SavingsMaxAccount;
import com.ilp.entity.Services;
public class ProductConfiguration {

	public static ArrayList<Services> createServices(ArrayList<Services> serviceList) {		
		Scanner scanner=new Scanner(System.in);
		 char choice;
		 do {	
			System.out.println("Enter the Service Code: ");
			String serviceCode=scanner.next();
			System.out.println("Enter the Service Name: ");
			String serviceName=scanner.next();
			System.out.println("Enter the Rate: ");
			double rate=scanner.nextDouble();
			serviceList.add(new Services(serviceCode,serviceName,rate));
			System.out.println("Do you want to create more services (y/n) : ");
			choice=scanner.next().charAt(0);
		}
		while(choice=='y');
	return serviceList;		 
	}
	
//	to create products
	public static Product createProducts(ArrayList<Services> serviceList) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		Product product=null;
		ArrayList<Services> productServiceList= new ArrayList<Services>();		
		String productCode,productName;
		System.out.println("1. Savings Max Account \n2. Current Account \n3. Loan Acocunt ");
		int mainChoice=scanner.nextInt();
		switch(mainChoice) {
		case 1:
			productCode="P100";
			productName="SavingsMaxAccount";
			productServiceList=addServicetoProduct(serviceList);
			product=new SavingsMaxAccount(productCode, productName, productServiceList);
			break;
		case 2:
			productCode="P200";
			productName="CurrentAccount";
			productServiceList=addServicetoProduct(serviceList);
			product=new SavingsMaxAccount(productCode, productName, productServiceList);
			break;
		case 3:
			productCode="P300";
			productName="LoanAccount";
			productServiceList=addServicetoProduct(serviceList);
			product=new SavingsMaxAccount(productCode, productName, productServiceList);
			break;
		}
		
		return product;
	}
	
//	to create services for a product
	public static ArrayList<Services> addServicetoProduct(ArrayList<Services> serviceList) {
		
		Scanner scanner=new Scanner(System.in);
		ArrayList<Services> productServiceList= new  ArrayList<Services>();
		char choice;
		do {
			
			System.out.println("ServiceCode   ServiceName  Rate");
			for(Services service: serviceList) {
				System.out.println(service.getServiceCode()+"      "+service.getServiceName()+"      "+service.getRate());
			}
			System.out.println("Enter Service Code");
			String serviceCode=scanner.next();
			for(Services service: serviceList) {
				if(service.getServiceCode().equalsIgnoreCase(serviceCode))
					productServiceList.add(service);
			}
			System.out.println("Do you want to add more services (y/n) : ");
			choice=scanner.next().charAt(0);
		}
		while(choice=='y');
		
		return productServiceList;
	}

	
	public static void transactionBill(Customer customer) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the customer Code:");
		String customerCode = scanner.nextLine();
		System.out.println(customer.getCustomerName()+ " has the following accounts:");
		for(Account account : customer.getAccountList()) {
			System.out.println((customer.getAccountList().indexOf(account) +1)+"." +account.getProduct().getProductName());
		}	
		System.out.println("Enter your choice:");
		int accountChoice = scanner.nextInt();
		System.out.println("Choose the Service you want to use :");
		Account selectedAccount = customer.getAccountList().get(accountChoice-1);
		ArrayList<Services> selectedServiceList = selectedAccount.getProduct().getServiceList();
		for(Services service : selectedServiceList) {
			System.out.println((selectedServiceList.indexOf(service)+1) +"." +service.getServiceName());
		}
		System.out.println("Enter your choice:");
		int selectedService = scanner.nextInt();
		System.out.print("Enter the number of  transactions");
		int numberOfTransactions = scanner.nextInt();
		double rate = selectedServiceList.get(selectedService-1).getRate();
		System.out.println("**********Transaction Bill**********");
		System.out.println("Total transaction amount: "+ numberOfTransactions*rate);
	}


	
	
}



