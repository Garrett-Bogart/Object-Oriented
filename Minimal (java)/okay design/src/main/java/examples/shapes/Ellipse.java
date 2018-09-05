package examples.shapes;


/**
 * Ellipse
 * 
 * This class represents circle object that can be moved and scaled.
 * Users can get the ellipse's area
 *
 */
@SuppressWarnings("WeakerAccess")
public class Ellipse {
	private Point center;
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
		Validator.validateEllipse(center, radius1, radius2);
		this.center = center;
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
		Validator.validateEllipse(x, y, radius1, radius2);
		center = new Point(x,y);
		this.radius1 = radius1;
		this.radius2 = radius2;
	}	
	
	/**
	 * getCenter returns center Point
	 */
	public Point getCenter() {return center;};
	
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
    public void move(double deltaX, double deltaY) throws ShapeException {
        center.move(deltaX, deltaY);
    }
	
	/**
	 * computeArea 		returns area of ellipse
	 * @return			area -- double
	 */
	public double computeArea()
	{
		return radius1*radius2*Math.PI;
	}
	
    /**
     * Scale the Ellipse
     *
     * @param scaleFactor       a non-negative double that represents the percentage to scale the circle.
     *                          0>= and <1 to shrink.
     *                          >1 to grow.
     * @throws ShapeException   Exception thrown if the scale factor is not valid
     */
    public void scale(double scaleFactor) throws ShapeException {
        Validator.validatePositiveDouble(scaleFactor, "Invalid scale factor");
        radius1 *= scaleFactor;
        radius2 *= scaleFactor;
    }
}
