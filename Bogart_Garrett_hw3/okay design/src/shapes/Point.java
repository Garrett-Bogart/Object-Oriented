package shapes;

/**
 * Point
 *
 * This class represents point objects that can be moved and copied
 */
@SuppressWarnings("WeakerAccess")
public class Point {
    private double x;
    private double y;

    /**
     * Constructor
     *
     * @param x                 The x-location of the point -- must be a valid double
     * @param y                 The y-location of the point -- must be a valid double
     * @throws ShapeException   Exception throw if any parameter is invalid
     */
    public Point(double x, double y) throws ShapeException {
        Validator.validateDouble(x, "Point: Invalid x-location");
        Validator.validateDouble(y, "Point: Invalid y-location");
        this.x = x;
        this.y = y;
    }

    /**
     * @return  The x-location of the point
     */
    public double getX() { return x; }

    /**
     * @return  The y-location of the point
     */
    public double getY() { return y; }

    /**
     * Move the point
     *
     * @param deltaX            The delta amount to move the point in the x direction -- must be a valid double
     * @param deltaY            The delta amount to move the point in the y direction -- must be a valid double
     * @throws ShapeException   Exception throw if any parameter is invalid
     */
    public void move(double deltaX, double deltaY) throws ShapeException {
        Validator.validateDouble(deltaX, "Invalid delta-x value");
        Validator.validateDouble(deltaY, "Invalid delta-y value");
        x += deltaX;
        y += deltaY;

    }

    /**
     * Copy the point
     * @return                  A new point with same x and y locations
     * @throws ShapeException   Should never thrown because the current x and y are valid
     */
    public Point copy() throws ShapeException {
        return new Point(x, y);
    }
        
    public String toString()
    {
    	return ""+x+"," + y;  	
    }
    
    public boolean equals(Point point)
    {   	
    	if(!(point instanceof Point))
    	{
    		return false;
    	}
    	
    	if(point == this)
    	{
    		return true;
    	}
    	Point p1 = (Point) point;
    	return Double.compare(p1.getX(), x) == 0 && Double.compare(p1.getY(), y)==0;
    }
}
