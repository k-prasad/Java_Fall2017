/**
 * 
 */
package edu.umb.cs.cs680.hw04;

/**
 * @author Karthik.Prasad001
 *
 */
public class CheckingAccount extends Account {

	private float w, balance;
	public SavingsAccount sa;

	public CheckingAccount(float w, float balance)
	{
		// TODO Auto-generated constructor stub
		this.w = w;
		this.balance = balance;
	}
	
	public void withdraw()
	{
		if (this.getBalance(balance) > w)
		System.out.println("\n Withdraw SUCCESSFUL! Collect money! ");
		
		if ((sa.getBalance(balance) + this.getBalance(balance)) >= w)
		{
			System.out.println("\n Withdraw through Overdraft $50 Fine");
			System.out.println("Total Remaining Balance = " +(1000-w));
		}
		
		if ((sa.getBalance(balance) + this.getBalance(balance)) < w)
			System.out.println("\n Infufficient Funds! Cannot withdraw");
		
		if (this.getBalance(balance) < 0)
			System.out.println("\n Infufficient Funds! Cannot withdraw");
			
		 
	}

}
