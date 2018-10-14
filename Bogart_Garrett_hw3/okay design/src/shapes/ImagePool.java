package shapes;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class ImagePool {
	private ArrayList<FlyImage> images;
	int count = 0;
	/*
	 * File outputfile = new File("image.jpg");
	   ImageIO.write(bufferedImage, "jpg", outputfile);
	 */
	public ImagePool()
	{
		images = new ArrayList<FlyImage>();
	}
	
	public ImagePool(BufferedImage image) throws IOException
	{
		images = new ArrayList<FlyImage>();
		String filePath = "okay design/src/resources/image"+count+".jpg";
		File outputFile = new File(filePath);
		ImageIO.write(image, "jpg", outputFile);
		FileInputStream file = new FileInputStream(filePath);
		BufferedImage buff = ImageIO.read(file);
		FlyImage img = new FlyImage(filePath,buff );
		this.images.add(img);
		count++;
	}
	
	public ImagePool(FlyImage image)
	{
		images = new ArrayList<FlyImage>();
		this.images.add(image);
	}
	
	public ImagePool(ArrayList<FlyImage> images)
	{
		this.images = images;
	}
	
	public ArrayList<FlyImage> getImages(){return images;}
	
	public FlyImage getImage(FlyImage image)
	{
		FlyImage found = null;
		for(FlyImage i : this.images)
		{
			if(i.equals(image))
			{
				found = i;
			}
		}
		return found;
	}
	
	public FlyImage getImage(String imagePath)
	{
		FlyImage found = null;
		for(FlyImage i : this.images)
		{
			if(i.getImagePath().equals(imagePath))
			{
				found = i;
			}
		}
		return found;
	}
	
	public FlyImage addImage(FlyImage image)
	{
		images.add(image);
		return image;
	}
	
	public FlyImage addImage(BufferedImage image) throws IOException
	{
		String filePath = "okay design/src/resources/image"+count+".jpg";
		File outputFile = new File(filePath);
		ImageIO.write(image, "jpg", outputFile);
		FileInputStream file = new FileInputStream(filePath);
		BufferedImage buff = ImageIO.read(file);
		FlyImage img = new FlyImage(filePath,buff );
		this.images.add(img);
		count++;
		return img;
	}
	
	public FlyImage addImage(String path) throws IOException
	{
		FileInputStream input = new FileInputStream(path);
		BufferedImage buff = ImageIO.read(input);
		return addImage(buff);
	}
	
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
