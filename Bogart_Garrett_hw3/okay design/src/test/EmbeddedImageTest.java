package test;
import shapes.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.awt.image.BufferedImage;
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
	}
	
}
