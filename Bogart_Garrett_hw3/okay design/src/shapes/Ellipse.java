package shapes;

import java.awt.Graphics;

import javax.swing.JFrame;

/**
 * Ellipse
 * 
 * This class represents circle object that can be moved and scaled.
 * Users can get the ellipse's area
 *
 */
@SuppressWarnings("WeakerAccess")
public class Ellipse extends Shape {
	protected double radius1;
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
		return radius1*radius2*Math.PI;
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
		radius1*=this.scalingFactor;
		radius2*=this.scalingFactor;
	}
	
	public String toString()
	{
		String center = this.points.get(0).toString();
		return "Ellipse,"+center+","+this.radius1+","+this.radius2;
	}
	
	public boolean equals(Shape ellipse) throws ShapeException
    {   	
    	if(!(ellipse instanceof Ellipse))
    	{
    		return false;
    	}
    	
    	if(ellipse == this)
    	{
    		return true;
    	}
    	Ellipse c1 = (Ellipse) ellipse;
    	boolean t1 = this.getPoint1().equals(c1.getPoint1());
    	boolean t2 = Double.compare(c1.getRadius(), this.radius1)==0;
    	boolean t3 = Double.compare(c1.getRadius2(), this.radius2)==0;
    	
    	return this.getPoint1().equals(c1.getPoint1()) && Double.compare(c1.getRadius(), this.radius1)==0 && Double.compare(c1.getRadius2(), this.radius2)==0;
    }
	
	public void render(Graphics g) throws ShapeException
	{
		g.drawOval((int)this.getPoint1().getX(), (int)this.getPoint1().getY(), (int)this.getRadius(), (int)this.getRadius2());
	}
}
