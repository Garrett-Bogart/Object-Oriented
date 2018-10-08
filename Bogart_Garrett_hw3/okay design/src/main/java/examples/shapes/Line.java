package examples.shapes;

/**
 *
 *  Line
 *
 *  This class represents line objects that can be moved.  Users of a line can also get its length and slope.
 *
 */
@SuppressWarnings("WeakerAccess")
public class Line extends Shape {

    private Point point1;
    private Point point2;

    /**
     * Constructor based on x-y Locations
     * @param x1                The x-location of first point -- must be a valid double.
     * @param y1                The y-location of first point -- must be a valid double.
     * @param x2                The x-location of second point -- must be a valid double.
     * @param y2                The y-location of second point -- must be a valid double.
     * @throws ShapeException   Exception throw if any parameter is invalid
     */
    public Line(double x1, double y1, double x2, double y2) throws ShapeException {
    	this(new Point(x1,y1), new Point(x2,y2));

    }

    /**
     *
     * @param point1            The first point -- must not be null
     * @param point2            The second point -- must not b e null
     * @throws ShapeException   Exception throw if any parameter is invalid
     */
    public Line(Point point1, Point point2) throws ShapeException {
        if (point1==null || point2==null)
            throw new ShapeException("Invalid Point");

        this.points.add(point1);
        this.points.add(point2);
        this.point1 = point1;
        this.point2 = point2;

        Validator.validateLength(computeLength());
    }

    /**
     * @return  The length of the line
     */
    public double computeLength() {
        return Math.sqrt(Math.pow(point2.getX() - point1.getX(), 2) +
                         Math.pow(point2.getY() - point1.getY(), 2));
    }

    /**
     * @return  The slope of the line
     */
    public double computeSlope() {
        return (point2.getY() - point1.getY())/(point2.getX() - point1.getX());
    }

	@Override
	public double computeArea() {return 0;}

	@Override
	public void scale(double scalingFactor) {		
	}
	
	public String toString()
	{
		String point1 = this.point1.toString();
		String point2 = this.point2.toString();
		String Line = "Line,"+point1+","+point2;
		return "Line,"+point1.toString()+","+point2.toString();
	}
    
	public boolean equals(Shape line) throws ShapeException
    {   	
    	if(!(line instanceof Line))
    	{
    		return false;
    	}
    	
    	if(line == this)
    	{
    		return true;
    	}
    	Line l1 = (Line) line;

    	return this.getPoint1().equals(l1.getPoint1()) && this.getPoint2().equals(l1.getPoint2());
    }

}
