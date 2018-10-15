
package edu.umb.cs.cs680.hw05;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import java.awt.Point;
import java.util.ArrayList;

import org.junit.Test;

/**
 * @author Karthik.Prasad001
 *
 */
public class PolygonTest {

	@Test
	public void test() 
	{
		ArrayList<Point> al = new  ArrayList<Point>();
		al.add(new Point(1, 2));
		al.add(new Point(1, 4));
		al.add(new Point(4, 2));
		Polygon p = new Polygon( al, new TriangleAreaCalc() );
		assertThat(p.getArea(), is(3.0F));
		p.addPoint( new Point(4,4) );
		p.setAreaCalc( new RectangleAreaCalc() );
		assertThat(p.getArea(), is(6.0F));
		
	}

}
