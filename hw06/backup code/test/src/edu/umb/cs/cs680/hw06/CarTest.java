/**
 * 
 */
package edu.umb.cs.cs680.hw06;

//import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

/**
 * @author Karthik.Prasad001
 *
 */
public class CarTest {
	
	
	@Test
	public void Test()
	{
		ArrayList<Car> usedCars = new ArrayList<Car>();
		usedCars.add(new Car(23000,105543,2011));
		usedCars.add(new Car(35000,80003,2015));
		usedCars.add(new Car(90000,5000,2016));
		usedCars.add(new Car(11000,153000,2008));
		usedCars.add(new Car(123000,981,2017));
		System.out.println("Year \t  Mileage \t Price");
		
		for(Car i: usedCars){
			System.out.println(i.getYear()+" \t  "+i.getMileage()+" \t $"+i.getPrice());
		}
		
		System.out.println("\n---------- SORTING ----------");
		
		System.out.println("\nYear Comparator Sort:\n");
		Collections.sort(usedCars, new YearComparator());
		for(Car i: usedCars)
		{
		System.out.println(i.getYear());
		}
		
		System.out.println("----------------------------");
		
		System.out.println("\nMileage Comparator Sort:\n");
		Collections.sort(usedCars, new MileageComparator());
		for(Car i: usedCars)
		{
		System.out.println(i.getMileage());
		}
		
		System.out.println("----------------------------");
		
		System.out.println("\nPrice Comparator Sort:\n");
		Collections.sort(usedCars, new PriceComparator());
		for(Car i: usedCars)
		{
		System.out.println("$"+i.getPrice());
		}

	
		
	}

}
