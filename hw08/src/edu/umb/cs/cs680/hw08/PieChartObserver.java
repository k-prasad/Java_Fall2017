
package edu.umb.cs.cs680.hw08;

/**
 * @author Karthik.Prasad001
 *
 */
public class PieChartObserver implements Observer 
{

	public StockEvent argu;
	

	/* (non-Javadoc)
	 * @see edu.umb.cs.cs680.hw08.Observer#update(edu.umb.cs.cs680.hw08.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object argu) 
	{
		// TODO Auto-generated method stub
		this.argu = (StockEvent) argu;
		System.out.println("Pie Chart: \n\tTicker is " + ((StockEvent) argu).getTicker()+ "\n\tOuote: " + ((StockEvent) argu).getQuote()+ "\n");

	}

}
