package test;
import shapes.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.junit.Test;

public class EmbeddedImageTest {
	@Test
	public void testEIConsructer() throws IOException, ShapeException
	{
		Point point = new Point(0,0);
		FileInputStream file = new FileInputStream("okay design/src/resources/fancy_bulbasir.jpg");
		BufferedImage image = ImageIO.read(file);
		FlyImage img = new FlyImage("okay design/src/resources/fancy_bulbasir.jpg",image);
		EmbeddedImage ei = new EmbeddedImage(0,0,5,6,img);
		assertEquals(0,ei.getPoint1().getX(),0);
		assertEquals(0,ei.getPoint1().getY(),0);
		assertEquals(5,ei.getWidth(),0);
		assertEquals(6,ei.getHeight(),0);
		assertEquals("okay design/src/resources/fancy_bulbasir.jpg",ei.getImage().getImagePath());
		assertTrue(img.compareImages(img.getImage(), ei.getImage().getImage()));
		
		ei = new EmbeddedImage(point,5,6,img);
		assertEquals(0,ei.getPoint1().getX(),0);
		assertEquals(0,ei.getPoint1().getY(),0);
		assertEquals(5,ei.getWidth(),0);
		assertEquals(6,ei.getHeight(),0);
		assertEquals("okay design/src/resources/fancy_bulbasir.jpg",ei.getImage().getImagePath());
		assertTrue(img.compareImages(img.getImage(), ei.getImage().getImage()));
	}
	
	@Test
	public void testToString() throws IOException, ShapeException
	{
		Point point = new Point(0,0);
		FileInputStream file = new FileInputStream("okay design/src/resources/fancy_bulbasir.jpg");
		BufferedImage image = ImageIO.read(file);
		FlyImage img = new FlyImage("okay design/src/resources/fancy_bulbasir.jpg",image);
		EmbeddedImage ei = new EmbeddedImage(0,0,5,6,img);

		assertEquals("Embedded,0.0,0.0,5.0,6.0,okay design/src/resources/fancy_bulbasir.jpg",ei.toString());		

	}
	
	@Test
	public void testRender() throws IOException, ShapeException, InterruptedException
	{
		FileInputStream file = new FileInputStream("okay design/src/resources/fancy_bulbasir.jpg");
		BufferedImage buff = ImageIO.read(file);
		FlyImage img = new FlyImage("okay design/src/resources/fancy_bulbasir.jpg",buff);
		EmbeddedImage ei = new EmbeddedImage(0,0,500,600,img);
    	BufferedImage image = new BufferedImage(500,600,BufferedImage.TYPE_INT_RGB);
    	Graphics g = image.createGraphics();
    	g.setColor(Color.WHITE);
    	g.fillRect(0, 0, 500, 600);
    	g.setColor(Color.BLACK);
    	ei.render(g);
    	
    	assertTrue(ImageIO.write(image, "png", new File("okay design/src/resources/Embedded")));
	}
	
}
