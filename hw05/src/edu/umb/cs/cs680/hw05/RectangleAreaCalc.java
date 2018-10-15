
package edu.umb.cs.cs680.hw05;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Karthik.Prasad001
 *
 */
public class RectangleAreaCalc implements AreaCalculator {

	/* (non-Javadoc)
	 * @see edu.umb.cs.cs680.hw05.AreaCalculator#getArea(java.util.ArrayList)
	 */
	@Override
	public float getArea(ArrayList<Point> points) {
		// TODO Auto-generated method stub
		float r1 = (float) points.get(0).distance(points.get(1));
		float r2 = (float) points.get(0).distance(points.get(2));
		float r3 = (float) points.get(0).distance(points.get(3));
		float r4 = (float) points.get(1).distance(points.get(2));
		float r5 = (float) points.get(1).distance(points.get(3));
		float r6 = (float) points.get(2).distance(points.get(3));
	    if(r1 == r6 && r2 == r5 && r3 == r4)
	    {
	    	float[] sides = new float[] { r1, r2, r3, r4, r5, r6 }; 
	    	Arrays.sort(sides);
	    	return sides[0]*sides[2];
	    }
		return 0;
	}

}
