
package edu.umb.cs.cs680.hw06;
//import java.util.*;

/**
 * @author Karthik.Prasad001
 *
 */

public class Car {
	private float price;
	private float mileage;
	private int year;
//	private ArrayList<Car> usedCars;

	public Car(float price, float mileage, int year) {
		// TODO Auto-generated constructor stub
		
		this.price = price;
		this.mileage = mileage;
		this.year = year;
	}

	public float getPrice() {
		return price;
	}

	public float getMileage() {
		return mileage;
	}

	public int getYear() {
		return year;
	}
	
	
	
}

