package examples.shapes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import org.junit.Test;

public class EllipseTest {
	@Test
    public void testValidConstruction() throws Exception {
        Point center = new Point(1,2);
               
        Ellipse ellipse = new Ellipse(center, 3, 5);
        assertEquals(1, ellipse.getPoint1().getX(), 0);
        assertEquals(2, ellipse.getPoint1().getY(), 0);
        assertEquals(3, ellipse.getRadius(), 0);
        assertEquals(5, ellipse.getRadius2(), 0);
        
        ellipse = new Ellipse(17.3, 6.66, 9.13, 4.20);
        assertEquals(17.3, ellipse.getPoint1().getX(), 0);
        assertEquals(6.66, ellipse.getPoint1().getY(), 0);
        assertEquals(9.13, ellipse.getRadius(), 0);
        assertEquals(4.20, ellipse.getRadius2(), 0);
    }
	
	@Test
    public void testInvalidConstruction() {

        try {
            new Circle(null, 2.5);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            new Circle( new Point(1, 2), Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            new Circle(new Point(1, 2), Double.NEGATIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            new Circle(new Point(1, 2), Double.NaN);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            new Circle(Double.POSITIVE_INFINITY, 2, 3);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            new Circle(Double.NEGATIVE_INFINITY, 2, 3);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            new Circle(Double.NaN, 2, 3);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            new Circle(1, Double.POSITIVE_INFINITY, 3);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            new Circle(1, Double.NEGATIVE_INFINITY, 3);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            new Circle(1, Double.NaN, 3);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }


        try {
            new Circle(1, 2, Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            new Circle(1, 2, Double.NEGATIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            new Circle(1, 2, Double.NaN);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }
        
        
 //*************Ellipse**********       
        try {
            new Ellipse(null, 2.5, 3.5);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            new Ellipse( new Point(1, 2), Double.POSITIVE_INFINITY, 5);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            new Ellipse( new Point(1, 2), 7, Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }
        
        try {
            new Ellipse(new Point(1, 2), Double.NEGATIVE_INFINITY, 9.8);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }
        
        try {
            new Ellipse(new Point(1, 2), 17.3, Double.NEGATIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            new Ellipse(new Point(1, 2), Double.NaN, 6);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            new Ellipse(new Point(1, 2), 9, Double.NaN);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }
        
        try {
            new Ellipse(Double.POSITIVE_INFINITY, 2, 3, 5);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            new Ellipse(6, Double.POSITIVE_INFINITY, 3, 5);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }
        
        try {
            new Ellipse(Double.NEGATIVE_INFINITY, 2, 3, 9);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }
        
        try {
            new Ellipse(1, Double.NEGATIVE_INFINITY, 3, 9);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            new Ellipse(Double.NaN, 2, 3, 18);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }
        
        try {
            new Ellipse(3, Double.NaN, 3, 18);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            new Ellipse(1, 2, Double.POSITIVE_INFINITY, 9);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }
        
        try {
            new Ellipse(1, 2, 9, Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            new Ellipse(1, 2, Double.NEGATIVE_INFINITY, 17);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            new Ellipse(1, 2, 17, Double.NEGATIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }
        
        try {
            new Ellipse(1, 2, Double.NaN, 66);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }
        
        try {
            new Ellipse(1, 2, 66, Double.NaN);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

    }

	@Test
	public void testMove() throws ShapeException {
        Ellipse ellipse = new Ellipse(1, 2, 5, 6);
        assertEquals(1, ellipse.getPoint1().getX(), 0);
        assertEquals(2, ellipse.getPoint1().getY(), 0);
        assertEquals(5, ellipse.getRadius(), 0);

        ellipse.move(3,  4);
        assertEquals(4, ellipse.getPoint1().getX(), 0);
        assertEquals(6, ellipse.getPoint1().getY(), 0);
        assertEquals(5, ellipse.getRadius(), 0);

        ellipse.move(0.123,  0.456);
        assertEquals(4.123, ellipse.getPoint1().getX(), 0);
        assertEquals(6.456, ellipse.getPoint1().getY(), 0);
        assertEquals(5, ellipse.getRadius(), 0);

        ellipse.move(-0.123,  -0.456);
        assertEquals(4, ellipse.getPoint1().getX(), 0);
        assertEquals(6, ellipse.getPoint1().getY(), 0);
        assertEquals(5, ellipse.getRadius(), 0);

        ellipse.move(-12,  -26);
        assertEquals(-8, ellipse.getPoint1().getX(), 0);
        assertEquals(-20, ellipse.getPoint1().getY(), 0);
        assertEquals(5, ellipse.getRadius(), 0);

        try {
        	ellipse.move(Double.POSITIVE_INFINITY, 1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
        	ellipse.move(Double.NEGATIVE_INFINITY, 1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
        	ellipse.move(Double.NaN, 1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
        	ellipse.move(1, Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
        	ellipse.move(1, Double.NEGATIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
        	ellipse.move(1, Double.NaN);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

    }

	
    @Test
    public void testComputeArea() throws ShapeException {
        Ellipse ellipse = new Ellipse(1, 2, 5, 5);
        assertEquals(78.53975, ellipse.computeArea(), 0.0001);

        ellipse = new Circle(1, 2, 4.234);
        assertEquals(56.3185174, ellipse.computeArea(), 0.0001);

        try {
        	ellipse = new Circle(1, 2, 0);
            assertEquals(0, ellipse.computeArea(), 0);
        } catch(ShapeException e)
        {
        	//ignore
        }
        
        ellipse = new Ellipse(1, 2, 5, 6);
        assertEquals(94.247779607694, ellipse.computeArea(), 0.0001);

        ellipse = new Ellipse(1, 2, 4.234, 6.69);
        assertEquals(88.987057045552, ellipse.computeArea(), 0.0001);

        try {
        	ellipse = new Ellipse(1, 2, 0,5);
            assertEquals(0, ellipse.computeArea(), 0);
        } catch(ShapeException e)
        {
        	//ignore
        }

    }
    
    @Test
    public void testScale() throws ShapeException {
        Ellipse ellipse = new Ellipse(1, 2, 5, 6);
        assertEquals(1, ellipse.getPoint1().getX(), 0);
        assertEquals(2, ellipse.getPoint1().getY(), 0);
        assertEquals(5, ellipse.getRadius(), 0);
        assertEquals(6, ellipse.getRadius2(), 0);

        ellipse.scale(3);
        assertEquals(1, ellipse.getPoint1().getX(), 0);
        assertEquals(2, ellipse.getPoint1().getY(), 0);
        assertEquals(15, ellipse.getRadius(), 0);
        assertEquals(18, ellipse.getRadius2(),0);

        ellipse.scale(0.2);
        assertEquals(1, ellipse.getPoint1().getX(), 0);
        assertEquals(2, ellipse.getPoint1().getY(), 0);
        assertEquals(3, ellipse.getRadius(), 0);
        assertEquals(3.6, ellipse.getRadius2(), 0);

        try {
        	ellipse.scale(Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
        	ellipse.scale(Double.NEGATIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
        	ellipse.scale(Double.NaN);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }
    }
    
}
