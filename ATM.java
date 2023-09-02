package com.atp.atm;
import com.atp.atm.*;
import java.util.Scanner;

public class ATM {

	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);

	        // For getting ID
	        System.out.println("Enter Your ID");
	       int ID = sc.nextInt();
	        // For getting User PIN or Password
	        System.out.println("Enter the PIN Number ");
	       int pin = sc.nextInt();

	        //Current Balance and PIN 
	        AtmTest atm = new AtmTest(50000 , 7978);
          
         // validation of ID and Pin Number
	         if (atm.getPin()== pin  && atm.getId(ID)==(ID)) {
         
	            // Menu Items
	            System.out.println("Welcome to ATM");
	            System.out.println("Which Action do you want to perform ");
	            System.out.println(" 1: Check Balance ");
	            System.out.println(" 2: Withdraw Money ");
	            System.out.println(" 3: Deposit Money ");
	            System.out.println(" 4: transfer Money ");
	            System.out.println(" 5:Exit ");

	            // user Choice
	            int Choice = sc.nextInt();

	            // Operation Perform

	            switch (Choice) {
	                case 1:
	                    System.out.println(" Your Account Balance is :- " + atm.getBalance());
	                    break;

	                case 2:
	                    System.out.println(" Enter the amount you want to Withdraw");
	                    int amount = sc.nextInt();

	                    if (amount > atm.getBalance()) {
	                        System.out.println("Insufficient Balance");

	                    } else {
	                        atm.setBalance(atm.getBalance() - amount);
	                        System.out.println("You have Withdrawn Rs - " + amount);
	                    }
	                case 3:
	                    System.out.println("Enter the amount of Money do you want to deposit ");
	                    amount = sc.nextInt();
	                    atm.setBalance(atm.getBalance() + amount);
	                    System.out.println("You have Deposited Rs :- " + amount);
	                    break;

	                
	                case 4:
	                    System.out.println("Enter the Amount of money you want to transfer");
	                    int transferAmount = sc.nextInt();
	                    sc.nextLine(); // Consume the newline character

	                    System.out.println("Enter the Account Number you want to transfer to");
	                    String accountNumber = sc.nextLine();

	                    System.out.println("Enter the amount you want to transfer");
	                    int amount1 = sc.nextInt();

	                    if (amount1 > atm.getBalance()) {
	                        System.out.println("Insufficient funds");
	                    } else {
	                        atm.setBalance(atm.getBalance() - amount1);
	                        System.out.println("You have transferred $" + amount1 + " to Account Number " + accountNumber);
	                    }
	                    break;

	                case 5:
	                    System.out.println("Thank you fir using ATM");
	                    break;

	                default:
	                    System.out.println("Invalid Choice");

	            }
	        } else {
	            System.out.println("Invalid ID or PIN");

	        }
	}

}
