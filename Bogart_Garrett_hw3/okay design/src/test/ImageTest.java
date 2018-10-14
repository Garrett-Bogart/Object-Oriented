package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

import shapes.FlyImage;

public class ImageTest {

	@Test
	public void testImageConstructor() throws IOException
	{
		String filePath = "okay design/src/resources/zzaKt.jpg";
		FileInputStream file = new FileInputStream("okay design/src/resources/fancy_bulbasir.jpg");
		BufferedImage image = ImageIO.read(file);
		FlyImage img = new FlyImage("okay design/src/resources/fancy_bulbasir.jpg",image);
		FlyImage img1 = new FlyImage("okay design/src/resources/fancy_bulbasir.jpg",image);
		assertEquals(filePath, img.getImagePath());
		assertTrue(img1.compareImages(image, img.getImage()));
	}
}
