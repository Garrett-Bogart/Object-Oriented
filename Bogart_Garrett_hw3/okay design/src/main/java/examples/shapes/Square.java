package examples.shapes;

@SuppressWarnings("WeakerAccess")
public class Square extends Rectangle
{
	private Point origin;
	private double width;
	
	/**
	 * 
	 * constructor
	 * 
	 * @param origin		first point of the square -- must be a valid point
	 * @param width			width and height of the square -- must be a valid double
	 * @throws ShapeException
	 */
	public Square(Point origin, double width)throws ShapeException
	{
		super(origin, width, width);
	}
	
	/**
	 * constructor
	 * 
	 * @param x			x value of origin of square -- must be a valid double
	 * @param y			y value of origin of square -- must be a valid double
	 * @param width		width and height of the square -- must be a valid double
	 * @throws ShapeException
	 */
	public Square(double x, double y, double width)throws ShapeException
	{
		super(x,y,width, width);
	}
}
