
package edu.umb.cs.cs680.hw05;

import java.awt.Point;
import java.util.ArrayList;

/**
 * @author Karthik.Prasad001
 *
 */
public class Polygon {

	private ArrayList<Point> points;
	private AreaCalculator areaCalc;

	public Polygon(ArrayList<Point> points,AreaCalculator areaCalc)
	{
		// TODO Auto-generated constructor stub
		this.points = points;
		this.areaCalc=areaCalc;
	}
	public void setAreaCalc(AreaCalculator areaCalc){
		this.areaCalc=areaCalc;
	}
	public void addPoint(Point point)
	{
		points.add(point);
	}
	public float getArea()
	{
		return this.areaCalc.getArea(this.points);
	}
	

}
