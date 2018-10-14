package examples.shapes;

public class EmbeddedImage extends Rectangle {

	private Image image;	
	
	public EmbeddedImage(double x, double y, double width, double height) throws ShapeException {
		super(x, y, width, height);
	}
	
	public EmbeddedImage(Point origin, double width, double height) throws ShapeException
	{
		super(origin, width, height);
	}
	
	public void setImage(Image image) {this.image = image;}
	
	public void render() {}
	
	public String toString()
	{
		return "EmbeddedImage,"+this.width+","+this.height+","+image.getImagePath();
	}
}
