package examples.shapes;
import static java.lang.Math.sqrt;
/**
 * 
 * Triangle
 * 
 * This class represents triangle object that can be moved. Users of a triangle can get
 * any of the three vertices that make the triangle and the area of the triangle.
 */
@SuppressWarnings("WeakerAccess")
public class Triangle {
	
	private Point point1;
	private Point point2;
	private Point point3;
	/**
	 * Constructor based on x,y Locations
	 * @param x1		The x-location of the first point -- must be a valid double
	 * @param y1		The y-location of the first point -- must be a valid double
	 * @param x2		The y-location of the first point -- must be a valid double
	 * @param y2		The y-location of the first point -- must be a valid double
	 * @param x3		The y-location of the first point -- must be a valid double
	 * @param y3		The y-location of the first point -- must be a valid double
	 * @throws ShapeException Exception thrown if any parameter is invalid
	 * 
	 */
	public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) throws ShapeException
	{
		point1 = new Point(x1,y1);
		point2 = new Point(x2,y2);
		point3 = new Point(x3, y3);
		validateTriangle();
		

		//Need to add a function to compute all the lengths of triangle
		//Need a function to calculate the slope of lines. Can access line class
		
	}
	/**
	 * @param point1		The first point -- must not be null
	 * @param point2		The second point -- must not be null
	 * @param point3		The third point -- must not be null
	 * @throws ShapeException 	Exception thrown if any parameter is invalid
	 */
	public Triangle(Point point1, Point point2, Point point3) throws ShapeException
	{
		Validator.validateNonNullPoint(point1, "Point 1 cannot be null");
		Validator.validateNonNullPoint(point2, "Point 2 cannot be null");
		Validator.validateNonNullPoint(point3, "Point 3 cannot be null");
		this.point1 = point1;
		this.point2 = point2;
		this.point3 = point3;
		validateTriangle();
	}
	
	/**
	 * validateTriangle 	checks lengths of sides and slopes of the sides
	 * 
	 * @throws ShapeException		Exception thrown if lengths cannot make a triangle
	 * 								and if all the points have the same slope
	 */
	public void validateTriangle() throws ShapeException
	{
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

	public void validateSlopes(double slope1, double slope2, double slope3) throws ShapeException
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
	public void validateLengths(double length1, double length2, double length3) throws ShapeException
	{
		if(length1+length2 < length3 )
		{
			throw new ShapeException("length between point1 and point3 is greater than "
					+ "the sum of the other two lengths");
		}
		if(length1+length3 < length2 )
		{
			throw new ShapeException("length between point2 and point3 is greater than "
					+ "the sum of the other two lengths");
		}
		if(length3+length2 < length1 )
		{
			throw new ShapeException("length between point1 and point2 is greater than "
					+ "the sum of the other two lengths");
		}
	}

	/**
	 * getPoint1	gets the first vertex
	 * 
	 * @return		point1
	 */
	public Point getPoint1() { return point1;}
	
	/**
	 * getPoint2	gets the second vertex
	 * 
	 * @return		point2
	 */
	public Point getPoint2() { return point2;}
	
	/**
	 * getPoint3	gets the third vertex
	 * 
	 * @return		point3
	 */
	public Point getPoint3() { return point3;}
	
	/**
	 * computeArea	returns area of the triangle, uses Heron's formula
	 * 
	 * @return area of triangle
	 */
	public double computeArea() throws ShapeException
	{
		Line line1 = new Line(point1, point2);
		Line line2 = new Line(point2, point3);
		Line line3 = new Line(point3, point1);
		double semiPerimeter = (line1.computeLength()+line2.computeLength()+line3.computeLength()/2);
		return sqrt(semiPerimeter*(semiPerimeter-line1.computeLength())*(semiPerimeter-line2.computeLength())*
				(semiPerimeter-line3.computeLength()));
	}

	/**
	 * moveTriangle 		moves triangle 
	 * 
	 * @param deltaX 		The delta x-location by which the triangle should be moved -- must be a valid double
	 * @param deltaY		The delta y-location by which the triangle should be moved -- must be a valid double
	 * @ throws ShapeException	Exception thrown if any parameter is invalid
	 */
	public void moveTriangle(double deltaX, double deltaY) throws ShapeException
	{
		point1.move(deltaX, deltaY);
		point2.move(deltaX, deltaY);
		point3.move(deltaX, deltaY);
	}

}
