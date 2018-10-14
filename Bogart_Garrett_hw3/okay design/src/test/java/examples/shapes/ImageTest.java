package examples.shapes;
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

public class ImageTest {

	@Test
	public void testImageConstructor() throws IOException
	{
		File file = new FileInputStream("zzaKt.jpg");
		BufferedImage image = ImageIO.read(file);
		System.out.println(image.toString());
		//Image img = new Image(image.get,image)
	}
}
