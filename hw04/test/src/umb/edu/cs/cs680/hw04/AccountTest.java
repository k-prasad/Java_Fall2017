/**
 * 
 */
package umb.edu.cs.cs680.hw04;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Before;

import org.junit.Test;

import edu.umb.cs.cs680.hw04.SavingsAccount;
import edu.umb.cs.cs680.hw04.Account;
import edu.umb.cs.cs680.hw04.CheckingAccount;

/**
 * @author Karthik.Prasad001
 *
 */
public class AccountTest {

	@Before
	public void Before() throws Exception 
	{
		System.out.println("Welcome to the Bank of America");
	}

	
	@Test
	public void test()
	{
		System.out.println("Your Total balance is: $1000 \n\t Checking = $300 \n\t Savings = $700");
		
		Scanner reader = new Scanner(System.in); 
		System.out.println("\n Choose the account type to withdraw \n\t 1 -- Savings \n\t 2 -- Checking ");
		System.out.println("\nChoice: ");
		int choice = reader.nextInt();
		System.out.println("Enter Withdawal ammount: ");
		float w = reader.nextInt();
		
		reader.close(); 
		SavingsAccount sa =	new SavingsAccount(w, 700);
		CheckingAccount ca = new CheckingAccount(w, 300);
		
		if(choice == 1)
		{
		//SavingsAccount sa =	new SavingsAccount(w, 700);
		sa.withdraw();
		}
		else if(choice == 2)
		{
			
			ca.withdraw();
		}
		else System.out.println("\nWrong Choice!");
	}

}
