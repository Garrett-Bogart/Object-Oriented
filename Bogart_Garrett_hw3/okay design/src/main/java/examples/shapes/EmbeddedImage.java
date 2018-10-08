package examples.shapes;

public class EmbeddedImage extends Rectangle {

	private String filepath;
	
	public EmbeddedImage(double x, double y, double width, double height) throws ShapeException {
		super(x, y, width, height);
	}
	
	public EmbeddedImage(Point origin, double width, double height)throws ShapeException
	{
		super(origin, width, width);
	}
}
