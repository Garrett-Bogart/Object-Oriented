package examples.shapes;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Image {
	private String imagePath;
	private Image image;
	
	/**
	 * https://www.baeldung.com/java-images
	 * String imagePath = "path/to/your/image.jpg";
	   BufferedImage myPicture = ImageIO.read(new File(imagePath));
	 * @param path
	 * @param image
	 */
	public Image(String path, Image image)
	{
		//TODO add in validation
		this.imagePath = path;
		this.image = image;
	}
	
	public Image getImage() {return image;}
	public String getImagePath() {return imagePath;}
	
	public void setGraphic(Image image) {this.image = image;}
	public void setImagePath(String path) {this.imagePath = path;}
}
