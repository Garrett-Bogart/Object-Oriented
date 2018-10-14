package examples.shapes;

public class ImageState extends EmbeddedImage {
	
	private Image image;
	
	public ImageState(double x, double y, double width, double height) throws ShapeException {
		super(x, y, width, height);
	}
	
	public ImageState(Point origin, double width, double height) throws ShapeException
	{
		super(origin, width, height);
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}

}
