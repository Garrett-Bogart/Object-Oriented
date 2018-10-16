package shapes;

public class EmbeddedImage extends Rectangle {

	private FlyImage image;	
	
	public EmbeddedImage(double x, double y, double width, double height, FlyImage image) throws ShapeException {
		super(x, y, width, height);
		this.image = image;
	}
	
	public EmbeddedImage(Point origin, double width, double height, FlyImage image) throws ShapeException
	{
		super(origin, width, height);
		this.image = image;
	}
	
	public FlyImage getImage() {return image;}
	
	public void setImage(FlyImage image) {this.image = image;}
	
	public void render() {}
	
	public String toString()
	{
		return "EmbeddedImage,"+this.width+","+this.height+","+image.getImagePath();
	}
}
