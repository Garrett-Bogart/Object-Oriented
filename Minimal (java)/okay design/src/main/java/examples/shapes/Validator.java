package examples.shapes;

public class Validator {
    public static void validateDouble(double value, String errorMessage) throws ShapeException {
        if (Double.isInfinite(value) || Double.isNaN(value))
            throw new ShapeException(errorMessage);
    }

    public static void validatePositiveDouble(double value, String errorMessage) throws ShapeException {
        validateDouble(value, errorMessage);
        if (value<0)
            throw new ShapeException(errorMessage);
    }
    
    public static void validateNonNullPoint(Point point, String errorMessage) throws ShapeException
    {
    	if (point==null)
            throw new ShapeException("Invalid Point");
    }
    
    public static void validateLength(double length)throws ShapeException
    {
        if (length < 0.00000001)
            throw new ShapeException("A line must have a length > 0");
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
		validateNonNullPoint(point1, "Point 1 cannot be null");
		validateNonNullPoint(point2, "Point 2 cannot be null");
		validateNonNullPoint(point3, "Point 3 cannot be null");
		Line line1 = new Line(point1, point2);
		Line line2 = new Line(point2, point3);
		Line line3 = new Line(point3, point1);
		validateLengths(line1.computeLength(), line2.computeLength(), line3.computeLength());
		validateSlopes(line1.computeSlope(), line2.computeSlope(), line3.computeSlope());
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
	public static void validateTriangle(double x1, double y1, double x2, double y2, double x3, double y3, String errorMessage) throws ShapeException
	{
		Point point1 = new Point(x1,y1);
		Point point2 = new Point(x2,y2);
		Point point3 = new Point(x3, y3);
		validateTriangle(point1, point2, point3, errorMessage);
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

	public static void validateEllipse(Point center, double radius1, double radius2)throws ShapeException
	{
		validateNonNullPoint(center, "Invalid center");
		validateDouble(radius1, "The first radius is invalid");
		validatePositiveDouble(radius1, "The first radius is negative");
		validateLength(radius1);
		validateDouble(radius2, "The second radius is invalid");
		validatePositiveDouble(radius2, "The second radius is negative");
		validateLength(radius2);
	}
	
	public static void validateEllipse(double x, double y,double radius1, double radius2)throws ShapeException
	{
		validateDouble(x, "The x coordinate is invalid");
		validateDouble(y, "The y coordinate is invalid");
		validateDouble(radius1, "The first radius is invalid");
		validatePositiveDouble(radius1, "The first radius is negative");
		validateLength(radius1);
		validateDouble(radius2, "The second radius is invalid");
		validatePositiveDouble(radius2, "The second radius is negative");
		validateLength(radius2);
	}
}
