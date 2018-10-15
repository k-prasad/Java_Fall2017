
package edu.umb.cs.cs680.hw08;

/**
 * @author Karthik.Prasad001
 *
 */
public class StockQuoteObservable extends Observable 
	{
		public StockEvent event;
		
		public void changeQuote(StockEvent event) 
		{
			this.event = event;
			this.setChanged();
			this.notifyObservers(event);
		}
		
		public void changeQuote(double q, String t)
		{
			this.event = new StockEvent(q,t);
			this.setChanged();
			this.notifyObservers(event);
		}
		
		

	}
