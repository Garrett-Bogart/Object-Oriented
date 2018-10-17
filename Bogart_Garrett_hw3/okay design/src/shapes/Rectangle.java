package shapes;

import java.awt.Graphics;

import javax.swing.JFrame;

import draw.DrawEllipse;
import draw.DrawRectangle;

public class Rectangle extends Shape {
	protected double width;
	protected double height;
	/**
	 * constructor
	 * 
	 * @param origin		starting point of rectangle -- can't be null
	 * @param width			width of the rectangle -- must be a valid double
	 * @param height		height of the rectangle -- must be a valid double
	 * 
	 * @exception		Throws ShapeExceptions
	 */
	public Rectangle(Point origin, double width, double height) throws ShapeException
	{
		validateRectangle(origin, width, height);
		this.points.add(origin);
		this.width = width;
		this.height = height;
	}
	
	/**
	 * constructor
	 * 
	 * @param x,y			starting point of rectangle -- must be a valid double
	 * @param width			width of the rectangle -- must be a valid double
	 * @param height		height of the rectangle -- must be a valid double
	 * 
	 * @exception		Throws ShapeExceptions
	 */
	public Rectangle(double x, double y, double width, double height)throws ShapeException
	{
		this(new Point(x,y), width, height );
	}
	
	public double getWidth() { return width;}
	
	public double getHeight() { return height;}
	
	
	/**
	 * point2 		 based originX+width, originY
	 * @return point2
	 * @throws ShapeException
	 */
	public Point getPoint2() throws ShapeException
	{
		Point origin = this.getPoint1();
		Point point2 = new Point(origin.getX()+width, origin.getY());
		return point2;
	}
	
	/**
	 * point3 		 based originX, originY+height
	 * @return point3
	 * @throws ShapeException
	 */
	public Point getPoint3() throws ShapeException
	{
		Point origin = this.getPoint1();
		Point point3 = new Point(origin.getX(), origin.getY()+height);
		return point3;
	}
	
	/**
	 * point4 		 based originX+width, originY+heght
	 * @return point4
	 * @throws ShapeException
	 */
	public Point getPoint4() throws ShapeException
	{
		Point origin = this.getPoint1();
		Point point4 = new Point(origin.getX()+width, origin.getY()+height);
		return point4;
	}
	@Override
	public double computeArea()
	{
		return width*height;
	}
	
	public void validateRectangle(Point origin, double width, double height) throws ShapeException
	{
		Validator.validateNonNullPoint(origin, "Rectangle: The origin can't be null");
		Validator.validatePositiveDouble(width,"Rectangle: width must greater than 0");
		Validator.validatePositiveDouble(height,"Rectangle: height must greater than 0");
		Validator.validateLength(width);
		Validator.validateLength(height);
	}

	@Override
	public void scale(double scalingFactor) throws ShapeException {
		Validator.validateDouble(scalingFactor, "Ellipse: scaling factor not valid");
		this.scalingFactor = scalingFactor;
		width*=scalingFactor;
		height*= scalingFactor;
	}
	
	public String toString()
	{
		String origin = this.points.get(0).toString();
		return "Rectangle,"+origin+","+width+","+height;
	}
	
	public boolean equals(Shape rect) throws ShapeException
    {   	
    	if(!(rect instanceof Rectangle))
    	{
    		return false;
    	}
    	
    	if(rect == this)
    	{
    		return true;
    	}
    	Rectangle r1 = (Rectangle) rect;
    	boolean t1 = this.getPoint1().equals(r1.getPoint1());
    	boolean t2 = Double.compare(r1.getWidth(), this.width)==0;
    	boolean t3 = Double.compare(r1.getHeight(), this.height)==0;
    	
    	return this.getPoint1().equals(r1.getPoint1()) && Double.compare(r1.getWidth(), this.width)==0 && Double.compare(r1.getHeight(), this.height)==0;
    }

	public void render(Graphics g) throws ShapeException
	{
		g.drawRect((int)this.getPoint1().getX(), (int)this.getPoint1().getY(), (int) width,(int) height);
	}

}
