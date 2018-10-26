package shapes;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


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
	
	//Graphics object with an x, y
	public void render(Graphics g) throws ShapeException 
	{
		g.drawImage(this.image.getImage(), (int)this.getPoint1().getX(), (int)this.getPoint1().getY(), (int)this.width, (int)this.height, null);
	}
	
	public String toString()
	{
		String origin = this.points.get(0).toString();
		return "Embedded,"+origin+","+this.width+","+this.height+","+image.getImagePath();
	}
}
