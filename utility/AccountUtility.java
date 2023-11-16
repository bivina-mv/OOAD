package com.ilp.utility;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.Product;
import com.ilp.entity.Services;
import com.ilp.service.AccountConfiguration;
import com.ilp.service.CustomerConfiguration;
import com.ilp.service.ProductConfiguration;

public class AccountUtility {

	public static void main(String[] args) {
		ArrayList<Customer> customerList=new ArrayList<Customer>(); 
		ArrayList<Account> accountList;
		Account account=null;
		Customer customer=null;
		Scanner scanner=new Scanner(System.in);
		char gotoMain;
	
		ArrayList<Services> serviceList=new ArrayList<Services>();
		ArrayList<Product> productList=new ArrayList<Product>();
		do {
			
			System.out.println("*******Welcome to Bank*******");
			System.out.println("1. Create Customer \n2. Display Customer \n3. Transaction Bill \n4. Create Service \n5. Create Product \n6. Manage Accounts");
			int mainMenuChoice=scanner.nextInt();
			switch(mainMenuChoice) {
			
			case 1: if(serviceList.isEmpty())
						System.out.println("Services/Products is Empty");
					else
						customer=CustomerConfiguration.createCustomer(customer,productList);
					break;
			case 2: CustomerConfiguration.displayCustomer(customer);
					break;
			case 3:ProductConfiguration.transactionBill(customer);
					break;
			case 4:serviceList=ProductConfiguration.createServices(serviceList);
					break;
			case 5:if(serviceList.isEmpty())
				System.out.println("Services is Empty");
				else
				productList.add(ProductConfiguration.createProducts(serviceList));
					break;
			case 6:System.out.println("Enter Customer ID");
				String CustomerId= scanner.next();
				AccountConfiguration.manageAccounts(customer, CustomerId);
			}	
			System.out.println("go back to main menu (y/n)");
			gotoMain=scanner.next().charAt(0);
		}
		while(gotoMain=='y');
	}
}
