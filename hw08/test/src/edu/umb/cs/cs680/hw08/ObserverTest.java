
package edu.umb.cs.cs680.hw08;


import java.text.DecimalFormat;
import java.util.Random;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Karthik.Prasad001
 *
 */
public class ObserverTest {

	/**
	 * @throws java.lang.Exception
	 */
	
	private double price;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		System.out.println("WELCOME TO THE STOCK EXCHANGE\n");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception 
	{
		System.out.println("\nGOOD BYE!");
	}

	@Test
	public void test() 
	{
		PieChartObserver pieObserver = new PieChartObserver();
		TableObserver tableObserver = new TableObserver();
		ThreeDimGraphObserver threeDObserver = new ThreeDimGraphObserver();
		
		StockQuoteObservable stock = new StockQuoteObservable();
		stock.addObserver(pieObserver);
		stock.addObserver(tableObserver);
		stock.addObserver(threeDObserver);
		
		double randNum = (Math.random() * (.06)) - .03;
		DecimalFormat df = new DecimalFormat("#.##");
		price = Double.valueOf(df.format((price + randNum)));
		
		final String[] companies = {"AMAZON STOCK", "COCO-COLA", "BANK OF AMERICA", "GOOGLE", "Mc-DONALD'S", "VISA STOCK", "AT&T STOCK", "IBM STOCK" };
		Random random = new Random();
		int index = random.nextInt(companies.length);
		stock.changeQuote(price, companies[index]);
		
	}

}
