package com.ilp.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.LoanAccount;
import com.ilp.entity.SavingsMaxAccount;
import com.ilp.entity.Services;

public class AccountConfiguration {
	
	public static void manageAccounts(Customer customer,String customerID) {
		if(customer.getCustomerCode().equalsIgnoreCase(customerID)) {
			Scanner scanner = new Scanner(System.in);
			System.out.println(customer.getCustomerName()+ " has the following accounts:");
			for(Account account : customer.getAccountList()) {
				System.out.println((customer.getAccountList().indexOf(account) +1)+"." +account.getProduct().getProductName());
			}	
			System.out.println("Enter your choice:");
			int accountChoice = scanner.nextInt();
			
			Account selectedAccount = customer.getAccountList().get(accountChoice-1);
			ArrayList<Services> selectedServiceList = selectedAccount.getProduct().getServiceList();
			System.out.println("Choose the Service you want to use :");
			for(Services service : selectedServiceList) {
				System.out.println((selectedServiceList.indexOf(service)+1) +"." +service.getServiceName());
			}
			System.out.println("Enter your choice:");
			int selectedService = scanner.nextInt();
			String selectedServiceName=selectedServiceList.get(selectedService-1).getServiceName();
			if(selectedServiceName.equalsIgnoreCase("CashDeposit")) {
				
				System.out.println("Enter the amount to be deposited");
				double amount=scanner.nextDouble();
				selectedAccount.setAccountBalance(amount+selectedAccount.getAccountBalance());
				
			}
			else if(selectedServiceName.equalsIgnoreCase("ATMWithdrawal")) {
				System.out.println("Enter the amount to withdraw");
				double amount=scanner.nextDouble();
				checkAccountType(selectedAccount,amount);
			}
			
			else if(selectedServiceName.equalsIgnoreCase("OnlineBanking")) {
				
				System.out.println("Enter the amount to be transfered");
				double amount=scanner.nextDouble();
				checkAccountType(selectedAccount,amount);
			}
			else if(selectedServiceName.equalsIgnoreCase("MobileBanking")) {
				System.out.println("Enter the amount to be transfered");
				double amount=scanner.nextDouble();
				checkAccountType(selectedAccount,amount);
			}
			else if(selectedServiceName.equalsIgnoreCase("ChequeDeposit")) {
				System.out.println("Enter the amount to be deposited");
				double amount=scanner.nextDouble();
				if (selectedAccount.getProduct().getProductName().equalsIgnoreCase("LoanAccount") )
				{
					LoanAccount loanAccount=(LoanAccount) selectedAccount.getProduct();
					double rate=loanAccount.getChequeDepositCharge();
					amount-=amount*rate;
				}
				selectedAccount.setAccountBalance(selectedAccount.getAccountBalance()+amount);
				
			}	

		}
		else
			System.out.println("Enter Valid Customer ID");
		
	}
	
	public static void checkAccountType(Account selectedAccount,double amount) {
		
		String productName=selectedAccount.getProduct().getProductName();
		if("SavingsMaxAccount".equalsIgnoreCase(productName)) {
			SavingsMaxAccount savingsAccount=(SavingsMaxAccount)selectedAccount.getProduct();
			if(selectedAccount.getAccountBalance()< savingsAccount.getMinBalance()) {
				System.out.print("Balance is low");
			}
		}else {
			selectedAccount.setAccountBalance(selectedAccount.getAccountBalance()-amount);
		}
		
	}

}
