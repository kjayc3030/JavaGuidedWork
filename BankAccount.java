/**
 * Kean Jaycox
 * 5/17/2021
 * Banking Application
 * tutorial source - https://youtu.be/wQbEH4tVMJA
 */

import java.util.Scanner;

public class BankAccount {
	
	int balance;
	int previousTransaction;
	String customerName;
	String customerId;
	
	//constructor
	BankAccount(String cname, String cid) {
		customerName = cname;
		customerId = cid;
	}
	
	void deposit(int amount) {
		if(amount > 0) {
			balance = balance + amount;
			previousTransaction = amount;
		}
	}
	
	void withdraw(int amount) {
		if(amount != 0) {
			balance = balance - amount;
			previousTransaction = -amount;
		}
	}
	
	void getPreviousTransaction() {
		if(previousTransaction > 0) {
			System.out.println("Deposited: "+previousTransaction);
		}
		else if(previousTransaction < 0) {
			System.out.println("Withdrawn: "+Math.abs(previousTransaction));
		}
		else {
			System.out.println("No transaction occured");
		}
	}
	
	void showMenu() {
		char option = '\0';
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Welcome "+customerName);
		System.out.println("Your ID is "+customerId+"\n");
		System.out.println("A. Check Balance");
		System.out.println("B. Deposit");
		System.out.println("C. Withdraw");
		System.out.println("D. Previous Transaction");
		System.out.println("E. Exit");
		
		do {
			System.out.println("=====================================================");
			System.out.println("Enter an option");
			System.out.println("=====================================================");
			option = scn.next().charAt(0);
			System.out.println("\n");
			
			switch(option) {
			
			case 'A':
				System.out.println("-------------------------");
				System.out.println("Balance = "+balance);
				System.out.println("-------------------------");
				break;
				
			case 'B':
				System.out.println("-------------------------");
				System.out.println("Enter an amount to deposit:");
				System.out.println("-------------------------");
				int amount = scn.nextInt();
				deposit(amount);
				System.out.println("\n");
				break;
				
			case 'C':
				System.out.println("-------------------------");
				System.out.println("Enter an amount to withdraw:");
				System.out.println("-------------------------");
				int amount2 = scn.nextInt();
				withdraw(amount2);
				System.out.println("\n");
				break;
				
			case 'D':
				System.out.println("-------------------------");
				getPreviousTransaction();
				System.out.println("-------------------------");
				break;
				
			case 'E':
				System.out.println("**********************************");
				break;
				
			default:
				System.out.println("Invalid Option! Please enter again");
				break;
				
			}
			
		}while(option != 'E');
		
		scn.close();
		System.out.println("Thank you for using our services");
	}
}

