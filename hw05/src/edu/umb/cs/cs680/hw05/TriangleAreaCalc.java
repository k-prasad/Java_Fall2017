
package edu.umb.cs.cs680.hw05;

import java.awt.Point;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * @author Karthik.Prasad001
 *
 */
public class TriangleAreaCalc implements AreaCalculator {

	/* (non-Javadoc)
	 * @see edu.umb.cs.cs680.hw05.AreaCalculator#getArea(java.util.ArrayList)
	 */
	@Override
	public float getArea(ArrayList<Point> points) 
	{
		// TODO Auto-generated method stub
		float a = (float) points.get(0).distance(points.get(1));
		float b = (float) points.get(1).distance(points.get(2));
		float c = (float) points.get(0).distance(points.get(2));
		float s = (a + b + c) / 2;
		float area = (float) Math.sqrt(s * (s - a) * (s - b) * (s - c));
		DecimalFormat df = new DecimalFormat("#.00");  
		float result = (float) Double.parseDouble(df.format(area));
		return result;
	}

}
