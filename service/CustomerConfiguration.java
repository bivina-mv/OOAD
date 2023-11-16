package com.ilp.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.Product;
import com.ilp.entity.Services;

public class CustomerConfiguration {

	
	public static Account createAccount(ArrayList<Product> productList) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int i=1;
		for(Product product: productList)
		{
			System.out.println(i+" "+product.getProductCode()+"    "+product.getProductName());
			i++;
		}
		System.out.println("Enter Product Choice");
		int productChoice = scanner.nextInt();
		Product product = productList.get(productChoice-1);
		System.out.println("Enter the account no: ");
		String accountNo=scanner.next();
		System.out.println("Enter opening balance");
		double openingBalance=scanner.nextDouble();
		return new Account(accountNo,openingBalance,product);	
	}


	public static void displayCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		System.out.println("****************Customer-Account Details**************");
		System.out.println("Customer ID   CustomerName    AccountType    Balance");
		System.out.println("*****************************************************");
		System.out.println(customer.getCustomerCode()+" "+customer.getCustomerName()+"  "+customer.getAccountList().get(0).getProduct().getProductName()+" "+customer.getAccountList().get(0).getAccountBalance());
		System.out.println("[Display for Multiple Accounts]");
		System.out.println("********Customer-Account Details********");
		System.out.println("Customer ID   CustomerName    AccountType    Balance");
		System.out.println("*****************************************");
		for (Account account: customer.getAccountList()) {
			System.out.println(customer.getCustomerCode()+"  "+customer.getCustomerName()+"  "+account.getProduct().getProductName()+"  "+account.getAccountBalance());;
		}
	}


	public static Customer createCustomer(Customer customer,ArrayList<Product> productList) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		ArrayList<Account> accountList;
		Account account=null;
		if(customer==null) {
			accountList=new ArrayList<Account>();
			System.out.println("Enter the Customer Code: ");
			String customerCode=scanner.next();
			System.out.println("Enter the Customer Name: ");
			String customerName=scanner.next();
			account=createAccount(productList);
			accountList.add(account);
			customer=new Customer(customerCode,customerName,accountList);
			}
			else {
				 accountList=customer.getAccountList();
				 account=createAccount(productList);
				 accountList.add(account);
				 customer.setAccountList(accountList);	 
			}
			
		System.out.println(account.getProduct().getProductName()+" created for "+customer.getCustomerName() + " with the following services" );
		for(Services service : account.getProduct().getServiceList()) {
			System.out.println(service.getServiceCode() + " : "+service.getServiceName());		
		}
		System.out.println("Account is Active");
		return customer;
}
	
	
}
