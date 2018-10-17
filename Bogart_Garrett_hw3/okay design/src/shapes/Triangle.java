package shapes;
import static java.lang.Math.sqrt;

import java.awt.Graphics;

import javax.swing.JFrame;

import draw.DrawRectangle;
import draw.DrawTriangle;
/**
 * 
 * Triangle
 * 
 * This class represents triangle object that can be moved. Users of a triangle can get
 * any of the three vertices that make the triangle and the area of the triangle.
 */
@SuppressWarnings("WeakerAccess")
public class Triangle extends Shape{
	
	private Point point1;
	private Point point2;
	private Point point3;
	
	/**
	 * @param point1		The first point -- must not be null
	 * @param point2		The second point -- must not be null
	 * @param point3		The third point -- must not be null
	 * @throws ShapeException 	Exception thrown if any parameter is invalid
	 */
	public Triangle(Point point1, Point point2, Point point3) throws ShapeException
	{
		validateTriangle(point1, point2, point3, "Points are invalid for a triangle");
		this.points.add(point1);
		this.points.add(point2);
		this.points.add(point3);
	}
	
	/**
	 * validateTrinagle based on x,y Locations
	 * @param x1		The x-location of the first point -- must be a valid double
	 * @param y1		The y-location of the first point -- must be a valid double
	 * @param x2		The y-location of the second point -- must be a valid double
	 * @param y2		The y-location of the second point -- must be a valid double
	 * @param x3		The y-location of the third point -- must be a valid double
	 * @param y3		The y-location of the third point -- must be a valid double
	 * @throws ShapeException Exception thrown if any parameter is invalid
	 * 
	 */
	public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) throws ShapeException
	{
		this(new Point(x1,y1), new Point(x2,y2), new Point(x3, y3));	
	}	
	
	/**
	 * computeArea	returns area of the triangle, uses Heron's formula
	 * 
	 * @return area of triangle
	 */
	public double computeArea() throws ShapeException
	{
		Point point1 = this.points.get(0);
		Point point2 = this.points.get(1);
		Point point3 = this.points.get(2);
		Line line1 = new Line(point1, point2);
		Line line2 = new Line(point2, point3);
		Line line3 = new Line(point3, point1);
		double semiPerimeter = (line1.computeLength()*scalingFactor+line2.computeLength()*scalingFactor+line3.computeLength()*scalingFactor)/2;
		return sqrt(semiPerimeter*(semiPerimeter-line1.computeLength()*scalingFactor)*(semiPerimeter-line2.computeLength()*scalingFactor)*
				(semiPerimeter-line3.computeLength()*scalingFactor));
	}
	
	/**
	 * validateTriangle 	checks lengths of sides and slopes of the sides
	 * 
	 * @param point1 		The first point -- must not be null
	 * @param point2		The second point -- must not be null 
	 * @param point3		The third point -- must not be null
	 * 
	 * @throws ShapeException		Exception thrown if lengths cannot make a triangle
	 * 								and if all the points have the same slope
	 */
	public static void validateTriangle(Point point1, Point point2, Point point3, String errorMessage) throws ShapeException
	{
		Validator.validateNonNullPoint(point1, "Point 1 cannot be null");
		Validator.validateNonNullPoint(point2, "Point 2 cannot be null");
		Validator.validateNonNullPoint(point3, "Point 3 cannot be null");
		Line line1 = new Line(point1, point2);
		Line line2 = new Line(point2, point3);
		Line line3 = new Line(point3, point1);
		validateLengths(line1.computeLength(), line2.computeLength(), line3.computeLength());
		validateSlopes(line1.computeSlope(), line2.computeSlope(), line3.computeSlope());
	}
		
	/**
	 * validateSlopes	checks the slopes of the lines to make sure they don't have the same
	 * 					slopes
	 * 
	 * @slope1		slope of first line
	 * @slope2		slope of second line
	 * @slope3		slope of third line
	 * 
	 * @throws ShapeException	throws an exception if the slopes are all equivalent
	 */

	public static void validateSlopes(double slope1, double slope2, double slope3) throws ShapeException
	{
		if(slope1 == slope2 && slope2 == slope3)
		{
			throw new ShapeException("All sides of the triangle have the same slope");
		}
	}
	
	/**
	 * validateLengths		checks the lengths of the sides to be sure they make a triangle
	 * 
	 * @param 		length1 length of point1 and point 2
	 * @param 		length2 length of point2 and point 3
	 * @param 		length3 length of point3 and point 1
	 * 
	 * @throws ShapeException		if length don't make a valid triangle
	 */
	public static void validateLengths(double length1, double length2, double length3) throws ShapeException
	{
			Validator.validateLength(length1);
			Validator.validateLength(length2);
			Validator.validateLength(length3);
	}

	@Override
	public void scale(double scalingFactor) throws ShapeException {
		this.scalingFactor=scalingFactor;
		
	}
	
	public String toString()
	{
		return "Triangle,"+points.get(0)+","+points.get(1)+","+points.get(2);
	}
	
	public boolean equals(Shape tri) throws ShapeException
    {   	
    	if(!(tri instanceof Triangle))
    	{
    		return false;
    	}
    	
    	if(tri == this)
    	{
    		return true;
    	}
    	Triangle t1 = (Triangle) tri;

    	return this.getPoint1().equals(t1.getPoint1()) && this.getPoint2().equals(t1.getPoint2()) && this.getPoint3().equals(t1.getPoint3());
    }
	
	public void render(Graphics g) throws ShapeException
	{
		int[] x = new int[3];
		int[] y = new int[3];
		int count = 0;
		for(Point p : this.getPoints())
		{
			x[count] = (int) p.getX();
			y[count] = (int) p.getY();
			count++;
		}
		g.drawPolygon(x,y,count);	
	}
}
