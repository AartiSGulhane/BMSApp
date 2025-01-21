package com.braindata.bankmanagement.client;

import java.util.Scanner;

import com.braindata.bankmanagement.exceptions.AccNoValidationException;
import com.braindata.bankmanagement.exceptions.MinMaxDepositException;
import com.braindata.bankmanagement.exceptions.NameValidationException;
import com.braindata.bankmanagement.serviceImpl.Sbi;

public class Test {
	public static void main(String []args)
	{
		Scanner sc=new Scanner(System.in);
		Sbi bank=new Sbi();
		while(true)
		{
			System.out.println("Enter Your choice ");
			System.out.println("1. for Crate Account ");
			System.out.println("2. for Display Details ");
			System.out.println("3. for Deposite Money");
			System.out.println("4. for Withdraw Money");
			System.out.println("5. for Check Balance");
			System.out.println("6. for Exit");

			try {

				int choice=sc.nextInt();

				switch(choice)
				{
				case 1:
				{
					bank.createAccount();


					break;
				}
				case 2:
				{

					bank.displayAllDetails();
					break;
				}
				case 3 :
				{
					bank.depositeMoney();
					break;
				}
				case 4:
				{
					bank.withdrwalMoney();
				}
				case 5 :
				{
					bank.balanceCheck();
					break;
				}
				case 6 :
				{
					System.exit(0);
				}
				default :
				{
					System.out.println("Enter Valid Input");
				}
				}
			}
			catch(AccNoValidationException e)
			{
				System.out.println("AccNoValidationException occured");
			}

			catch(NameValidationException e)
			{
				System.out.println("NameValidationException occured");	
			}
			catch(MinMaxDepositException e)
			{
				System.out.println("MinMaxDepositException occured");
			}

		}
	}


}
