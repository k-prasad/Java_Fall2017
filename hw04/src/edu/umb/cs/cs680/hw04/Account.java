/**
 * 
 */
package edu.umb.cs.cs680.hw04;

/**
 * @author Karthik.Prasad001
 *
 */
public abstract class Account {

	protected float balance;
	public Account() 
	{
		// TODO Auto-generated constructor stub
	}
	
	public float getBalance(float balance)
	{
		return this.balance = balance;
	}
	public float deposit(float d)
	{
		return this.balance = this.balance + d;
	}
	public float withdraw(float w)
	{
		return w;
		
	}

}
