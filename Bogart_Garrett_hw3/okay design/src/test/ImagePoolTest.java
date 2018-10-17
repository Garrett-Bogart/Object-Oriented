package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

import shapes.EmbeddedImage;
import shapes.FlyImage;
import shapes.ImagePool;
import shapes.ShapeException;

public class ImagePoolTest {

		@Test
		public void testAddImage() throws IOException
		{
			ImagePool pool = new ImagePool();
			String filePath = "okay design/src/resources/fancy_bulbasir.jpg";
			FileInputStream file = new FileInputStream("okay design/src/resources/fancy_bulbasir.jpg");
			BufferedImage image = ImageIO.read(file);
			FlyImage img = new FlyImage("okay design/src/resources/fancy_bulbasir.jpg",image);
			FlyImage img2 = new FlyImage("okay design/src/resources/fancy_bulbasir.jpg",image);
			pool.addImage(img);
			assertEquals(1, pool.getImages().size());
			FlyImage img1 = pool.getImage(img);
			assertTrue(img2.compareImages(img.getImage(),img1.getImage()));
		}
		
		@Test
		public void testConstructBufferedImage() throws IOException
		{
			String filePath = "okay design/src/resources/zzaKt.jpg";
			FileInputStream file = new FileInputStream("okay design/src/resources/fancy_bulbasir.jpg");
			BufferedImage image = ImageIO.read(file);
			ImagePool pool = new ImagePool(image);
			BufferedImage img = ImageIO.read(new File("okay design/src/resources/fancy_squirtle.jpg"));
			BufferedImage img1 = ImageIO.read(new File("okay design/src/resources/fancy_charmander.jpg"));
			//pool.addImage(image);
			assertEquals(1, pool.getImages().size());
			
			pool.addImage(img);
			pool.addImage(img1);
			
			assertEquals(3, pool.getImages().size());
			
			FlyImage temp = pool.getImage("okay design/src/resources/image1.jpg");
			img = ImageIO.read(new File("okay design/src/resources/image1.jpg"));

			assertTrue(pool.compareImages(temp.getImage(), img));
			
			img1 = ImageIO.read(new File("okay design/src/resources/image2.jpg"));
			temp = pool.getImage("okay design/src/resources/image2.jpg");
			assertTrue(pool.compareImages(temp.getImage(), img1));
			
			image = ImageIO.read(new File("okay design/src/resources/image0.jpg"));
			temp = pool.getImage("okay design/src/resources/image0.jpg");
			assertTrue(pool.compareImages(temp.getImage(), image));
		}
		
		@Test
		public void testEmbeddedImageLinkage() throws IOException, ShapeException
		{
			String filePath = "okay design/src/resources/zzaKt.jpg";
			FileInputStream file = new FileInputStream("okay design/src/resources/fancy_bulbasir.jpg");
			BufferedImage image = ImageIO.read(file);
			ImagePool pool = new ImagePool(image);
			BufferedImage img = ImageIO.read(new File("okay design/src/resources/fancy_squirtle.jpg"));
			BufferedImage img1 = ImageIO.read(new File("okay design/src/resources/fancy_charmander.jpg"));		
			pool.addImage(img);
			pool.addImage(img1);
			
			
			FlyImage bulb = pool.getImage("okay design/src/resources/image0.jpg");
			FlyImage bulb1 = pool.getImage("okay design/src/resources/image0.jpg");
			FlyImage bulb2 = pool.getImage("okay design/src/resources/image0.jpg");

			
			EmbeddedImage e1 = new EmbeddedImage(0,0,5,5,bulb);
			EmbeddedImage e2 = new EmbeddedImage(0,0,5,5,bulb1);
			EmbeddedImage e3 = new EmbeddedImage(0,0,5,5,bulb2);
			
			assertSame(e1.getImage(), e2.getImage());
			
			e1.getImage().setImagePath("sup");
			assertEquals(e1.getImage().getImagePath(), e2.getImage().getImagePath());
			assertEquals(e3.getImage().getImagePath(), e2.getImage().getImagePath());
		}
		
		@Test
		public void testValidation()
		{
			ImagePool pool = new ImagePool();
			try
			{
				pool.addImage("");
				fail("Expected exception not thrown");
			}catch(Exception e)
			{
				//ignore
			}
			
			try
			{
				pool.addImage("okay design/src/resources/empty.txt");
				fail("Expected exception not thrown");
			}catch(Exception e)
			{
				//ignore
			}
			
			try
			{
				pool.addImage("okay design/src/resources/empty.txt");
				fail("Expected exception not thrown");
			}catch(Exception e)
			{
				//ignore
			}
		}
}
