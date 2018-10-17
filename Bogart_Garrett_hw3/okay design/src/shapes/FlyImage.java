package shapes;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;

public class FlyImage {
	private String imagePath;
	private BufferedImage image;
	
	/**
	 * https://www.baeldung.com/java-images
	 * String imagePath = "path/to/your/image.jpg";
	   BufferedImage myPicture = ImageIO.read(new File(imagePath));
	 * @param path
	 * @param image
	 */
	public FlyImage(String path, BufferedImage image)
	{
		//TODO add in validation
		this.imagePath = path;
		this.image = image;
	}
	
	public BufferedImage getImage() {return image;}
	public String getImagePath() {return imagePath;}
	
	//public void setGraphic(BufferedImage image) {this.image = image;}
	public void setImagePath(String path) {this.imagePath = path;}
	
	public boolean compareImages(BufferedImage bfa, BufferedImage bfb) {
        DataBuffer dbA = bfa.getData().getDataBuffer();
        int sizeA = dbA.getSize();
        DataBuffer dbB = bfb.getData().getDataBuffer();
        int sizeB = dbB.getSize();
        if(sizeA == sizeB) {
            for(int i=0; i<sizeA; i++) { 
                if(dbA.getElem(i) != dbB.getElem(i)) {
                    return false;
                }
            }
            return true;
        }
        else {
            return false;
        }
    }
}
