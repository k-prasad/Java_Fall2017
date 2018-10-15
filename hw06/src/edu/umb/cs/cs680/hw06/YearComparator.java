
package edu.umb.cs.cs680.hw06;
import java.util.*;

/**
 * @author Karthik.Prasad001
 *
 */

public class YearComparator implements Comparator<Car>{

	public int compare(Car car1, Car car2)
	{
		return car1.getYear() - car2.getYear();
}
}
