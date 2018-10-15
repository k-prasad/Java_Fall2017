
package edu.umb.cs.cs680.hw08;

import java.util.ArrayList;

/**
 * @author Karthik.Prasad001
 *
 */
public abstract class Observable {

	public boolean change;
	public ArrayList<Observer> observers; 
	
	public Observable() 
	{
		// TODO Auto-generated constructor stub
		
		observers = new ArrayList<Observer>();
		change = false;
	}

	
	public void addObserver(Observer observer) 
	{
		this.observers.add(observer);
	}
	
	public void notifyObservers() 
	{
		notifyObservers(null);
	}
	
	public void setChanged() 
	{
		this.change = true;
	}
	
	public boolean hasChanged() 
	{
		return this.change;
	}

	public void clearChanged() 
	{
		this.change = false;
	}
	
	public void notifyObservers(Object obj1) {
		if (hasChanged()) 
		{
			for (Observer obj2 : this.observers) {
				obj2.update(this, obj1);
			}
			clearChanged();
		}
	}

	
	}


