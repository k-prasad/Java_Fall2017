/**
 * 
 */
package edu.umb.cs.cs680.hw04;

/**
 * @author Karthik.Prasad001
 *
 */
public class SavingsAccount extends Account {

	public float w;

	public SavingsAccount(float w, float balance) 
	{
		// TODO Auto-generated constructor stub
		this.w = w;
		this.balance = balance;

	}
	public void withdraw()
	{
		//System.out.println("In savings withdraw & balance = " +this.getBalance(balance));
		if (this.getBalance(balance) >= w)
		System.out.println("\n Withdraw Success! Collect money");
		System.out.println("New Savings Account Balance = " +(balance-w));
		if((balance-w) <0)
			System.out.println("ACCOUNT OVER DRAFT! FINE APPLIED");
		
		if (this.getBalance(balance) < 0)
			System.out.println("\n Infufficient Funds! Cannot withdraw");
			
		 
	}

}
