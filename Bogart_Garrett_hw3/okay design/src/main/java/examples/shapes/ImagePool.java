package examples.shapes;

import java.util.ArrayList;

public class ImagePool {
	private ArrayList<Image> images;
	
	public ImagePool()
	{
		images = new ArrayList<Image>();
	}
	
	public ImagePool(Image image)
	{
		images = new ArrayList<Image>();
		this.images.add(image);
	}
	
	public ImagePool(ArrayList<Image> images)
	{
		this.images = images;
	}
	
	public ArrayList<Image> getImages(){return images;}
	
	public Image getImage(Image image)
	{
		Image found = null;
		for(Image i : this.images)
		{
			if(i.equals(image))
			{
				found = i;
			}
		}
		return found;
	}
	
	public void addImage(Image image)
	{
		images.add(image);
	}
}
