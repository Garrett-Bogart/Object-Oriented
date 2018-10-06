package examples.shapes;


/**
 * Ellipse
 * 
 * This class represents circle object that can be moved and scaled.
 * Users can get the ellipse's area
 *
 */
@SuppressWarnings("WeakerAccess")
public class Ellipse extends Shape {
	private double radius1;
	private double radius2;
	
	/**
	 * Constructor
	 * 
     * @param center            The x,y -location of the center of the circle -- must be a valid point
     * @param radius1           The radius of part of the ellipse -- must be greater or equal to zero.
     * @param radius2           The radius of part of the ellipse -- must be greater or equal to zero.
     * 
     * @throws ShapeException   The exception thrown if the x, y, or z are not valid
	 */
	public Ellipse(Point center, double radius1, double radius2)throws ShapeException
	{
		validateEllipse(center, radius1, radius2);
		this.points.add(center);
		this.radius1 = radius1;
		this.radius2 = radius2;

	}
	/**
	 * Constructor
	 * 
     * @param x            		The x -location of the center of the circle -- must be a valid double
     * @param y            		The y -location of the center of the circle -- must be a valid double
     * @param radius1           The radius of part of the ellipse -- must be greater or equal to zero.
     * @param radius2           The radius of part of the ellipse -- must be greater or equal to zero.
     * 
     * @throws ShapeException   The exception thrown if the x, y, radius1, or radius2 are not valid
	 */
	public Ellipse(double x, double y, double radius1, double radius2)throws ShapeException
	{
		this(new Point(x,y), radius1, radius2);
	}	
	
	
	/**
	 * getRadius return first radius
	 */
	public double getRadius() {return radius1;}
	
	/**
	 * getRadius2 return second radius
	 */
	public double getRadius2() {return radius2;}
	
	/**
	 * moveEllipse
	 * @param x 		moves the center point by x -- x must be a valid double
	 * @param y			moves the center point by y -- y must be a valid double
	 */
	
	/**
	 * computeArea 		returns area of ellipse
	 * @return			area -- double
	 */
	public double computeArea()
	{
		return (radius1*this.scalingFactor)*(radius2*this.scalingFactor)*Math.PI;
	}
        
	public static void validateEllipse(Point center, double radius1, double radius2)throws ShapeException
	{
		Validator.validateNonNullPoint(center, "Ellipse: Invalid center");
		Validator.validatePositiveDouble(radius1, "Ellipse: The first radius is invalid");
		Validator.validateLength(radius1);
		Validator.validatePositiveDouble(radius2, "Ellipse: The second radius is invalid");
		Validator.validateLength(radius2);
	}
	@Override
	public void scale(double scalingFactor) throws ShapeException {
		// TODO Auto-generated method stub
		Validator.validateDouble(scalingFactor, "Ellipse: scaling factor not valid");
		this.scalingFactor = scalingFactor;
	}
	
}
