
package edu.umb.cs.cs680.hw08;

/**
 * @author Karthik.Prasad001
 *
 */
public class StockEvent 
{
	public double quote;
	public String ticker;

	
	public StockEvent(double quote, String ticker) 
	{
		// TODO Auto-generated constructor stub
		this.quote=quote;
		this.ticker=ticker;
	}
	
	public double getQuote()
	{
		return this.quote;
	}
	
	public String getTicker()
	{
		return this.ticker;
	}
	

}
