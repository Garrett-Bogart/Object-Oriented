package examples.shapes;

public class Rectangle {
	private Point origin;
	private double width;
	private double height;
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
		Validator.validateNonNullPoint(origin, "Rectangle: The origin can't be null");
		Validator.validatePositiveDouble(width,"Rectangle: width must greater than 0");
		Validator.validatePositiveDouble(height,"Rectangle: height must greater than 0");
		Validator.validateLength(width);
		Validator.validateLength(height);		
		this.origin = origin;
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
	
	public Point getPoint1() {return origin;}
	
	/**
	 * point2 		 based originX+width, originY
	 * @return point2
	 * @throws ShapeException
	 */
	public Point getPoint2() throws ShapeException
	{
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
		Point point4 = new Point(origin.getX()+width, origin.getY()+height);
		return point4;
	}

	public double computeArea()
	{
		return width*height;
	}

	public void move(double deltaX, double deltaY)throws ShapeException
	{
		origin.move(deltaX, deltaY);
	}

}
