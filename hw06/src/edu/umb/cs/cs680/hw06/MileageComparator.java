
package edu.umb.cs.cs680.hw06;
import java.util.*;

/**
 * @author Karthik.Prasad001
 *
 */

public class MileageComparator implements Comparator <Car>{
	
	public int compare(Car car1, Car car2)
	{
		return (int)(car2.getMileage()-car1.getMileage());
	}
	
}
	
