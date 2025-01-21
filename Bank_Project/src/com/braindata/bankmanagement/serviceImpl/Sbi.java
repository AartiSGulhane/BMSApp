package com.braindata.bankmanagement.serviceImpl;

import java.util.Scanner;

import com.braindata.bankmanagement.exceptions.AccNoValidationException;
import com.braindata.bankmanagement.exceptions.MinMaxDepositException;
import com.braindata.bankmanagement.exceptions.NameValidationException;
import com.braindata.bankmanagement.model.Account;

public class Sbi {
	Scanner sc=new Scanner(System.in);
	Account s=new Account();


	public void createAccount() throws AccNoValidationException, NameValidationException
	{
		s.setAccNo(validAccNumber());

		//System.out.println("Enter Name :");
		s.setName(validName());

		//System.out.println("Enter Mobile No");
		s.setMobNo(validMobNumber());

		//System.out.println("Enter Adhar No");
		s.setAdharNo(validAdharNumber());

		//System.out.println("Enter Gender");
		s.setGender(validGender());

		//System.out.println("Enter Age");
		s.setAge(validAge());

		//System.out.println("Enter Balance");
		s.setBalance(minBalance());
		System.out.println("Account Created Successfully...");
	}

	public void displayAllDetails()
	{
		System.out.println("Account No : "+s.getAccNo());
		System.out.println("Name : "+s.getName());
		System.out.println("Mobile No : "+s.getMobNo());
		System.out.println("Adhar No : "+s.getAdharNo());
		System.out.println("Gender : "+s.getGender());
		System.out.println("Age : "+s.getAge());
		System.out.println("Balance : "+s.getBalance());
	}

	public void depositeMoney()throws MinMaxDepositException
	{
		System.out.println("Enter the Amount to deposite ");
		double deposit=sc.nextDouble();
		minMaxDeposit(deposit);
		
		System.out.println("Amount Deposited Successfully..");
	}

	public void withdrwalMoney()
	{
		System.out.println("Enter the amount you want to withdraw");
		int withdr=sc.nextInt();
		s.setBalance(s.getBalance()-withdr);
		System.out.println("Amount withdrawn successfully..");
	}

	public void balanceCheck()
	{
		System.out.println("Available Balance= "+s.getBalance());
	}

	public int validAccNumber() throws AccNoValidationException
	{
		int ac=0;
		boolean b=true;
		while(b)
		{	
			int digit=0;
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Account No");
			ac=sc.nextInt();
			int accno=ac; 
			while(accno>0)
			{

				accno=accno/10;
				digit++;
			}
			if(digit==8)
			{
				System.out.println("AccNo validation done successfully");
				b=false;
			}
			else
			{
				throw new AccNoValidationException("No is not valid Enter valid No");
			}
		}
		return ac;

	}

	public String validMobNumber()
	{
		String mb=null;
		boolean b=true;
		while(b)
		{	
			int digit=0;
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Mobile Number");
			mb=sc.next();
			long mobno=Long.parseLong(mb); 
			while(mobno>0)
			{

				mobno=mobno/10;
				digit++;
				//System.out.println("Digit="+digit+" "+ accno);
			}
			if(digit==10)
			{
				System.out.println("Mobile number validation done successfully");
				b=false;
			}
			else
			{
				System.out.println("Mobile no is not valid Enter mobile No");
			}
		}
		return mb;

	}
	public String validName() throws NameValidationException
	{
		System.out.println("Enter name");
		String name=sc.next()+sc.nextLine();//abc def

		int count=0;
		for(int i=0;i<name.length();i++)
		{
			char c=name.charAt(i);

			if(!(c>='A' && c<='Z' || c>='a' && c<='z' || c==' '))
			{
				count++;

			}

		}
		if(count==0)
		{
			System.out.println("Name validation done Successfully..");
			
		}
		else
		{
			throw new NameValidationException("Special char or number is present Enter valid Name");
			//validName();	

		}
		return name;
	}

	public String validAdharNumber()
	{
		String ad=null;
		boolean b=true;
		while(b)
		{	
			int digit=0;
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Adhar Number");
			ad=sc.next();
			long adhar=Long.parseLong(ad); 
			while(adhar>0)
			{

				adhar=adhar/10;
				digit++;

			}
			if(digit==12)
			{
				System.out.println("Adhar number validation done successfully");
				b=false;
			}
			else
			{
				System.out.println("Adhar no is not valid Enter Adhar No");
			}
		}
		return ad;

	}

	public String validGender()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Gender");
		String gender=sc.next();
		if(gender.equalsIgnoreCase("Male") ||gender.equalsIgnoreCase("Female") ||gender.equalsIgnoreCase("M") ||gender.equalsIgnoreCase("F"))
		{
			System.out.println("Gender Validation done Successfully..");
		}
		else
		{
			System.out.println("Invalid Gender Enter Valid Gender");
			validGender();
		}
		return gender;
	}

	public int validAge()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Age");
		int age=sc.nextInt();
		if(age>18) 
		{
			System.out.println("Age validation done Successfully..");
		}
		else
		{
			System.out.println("Age should be greater than 18..Enter valid age");
			validAge();
		}
		return age;
	}

	public double minBalance()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Balance");
		double balance=sc.nextDouble();
		if(balance>=1000)
		{
			System.out.println("Money deposite successfully..");
		}
		else
		{
			System.out.println("Balance Should be greater than 1000. Please deposit money.");
			minBalance();
		}
		return balance;

	}
	public void minMaxDeposit(double deposit)throws MinMaxDepositException
	{ 
		
		if (deposit<500 || deposit>100000)
		{
			throw new MinMaxDepositException("Deposit should be minimun 500 and maximum 100000 ");
			
		}else
		{
			s.setBalance(s.getBalance()+deposit);
		}
		
	}
	}
	






