
package edu.umb.cs.cs680.hw08;

/**
 * @author Karthik.Prasad001
 *
 */
public class TableObserver implements Observer {

	/* (non-Javadoc)
	 * @see edu.umb.cs.cs680.hw08.Observer#update(edu.umb.cs.cs680.hw08.Observable, java.lang.Object)
	 */
	
	private StockEvent arg;

	@Override
	public void update(Observable o, Object arg) 
	{
		// TODO Auto-generated method stub
		this.arg = (StockEvent) arg;
		System.out.println("Table observe: \n\tTicker is " + ((StockEvent) arg).getTicker()+ "\n\tOuote: " + ((StockEvent) arg).getQuote()+ "\n");

	}

}
