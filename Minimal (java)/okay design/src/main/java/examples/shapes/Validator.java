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
	
}
