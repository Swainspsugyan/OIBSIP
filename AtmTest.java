package com.atp.atm;

public class AtmTest {
	private int balance ;
	private int pin;
	
	public AtmTest(int balance , int pin){
		this.balance = balance ;
		this.pin = pin ;
	}
	public int getBalance() {
		// TODO Auto-generated method stub
		return balance;
	}
	public void setBalance(int balance)
	{
		this.balance = balance ;
	
	}
	public int getPin()
	{
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin ;
	}
	public int getId(int Id) {
		return Id;
	}

	public static void main(String[] args) {

	}
		
}
