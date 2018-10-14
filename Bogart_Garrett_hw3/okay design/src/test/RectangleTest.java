package test;

import shapes.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class RectangleTest {
	@Test
    public void testValidConstruction() throws Exception {
        Point origin = new Point(1,2);
               
        Rectangle rectangle = new Rectangle(origin, 3, 5);
        assertEquals(1, rectangle.getPoint1().getX(), 0);
        assertEquals(4, rectangle.getPoint2().getX(), 0);
        assertEquals(1, rectangle.getPoint3().getX(), 0);
        assertEquals(4, rectangle.getPoint4().getX(), 0);
        assertEquals(2, rectangle.getPoint1().getY(), 0);
        assertEquals(2, rectangle.getPoint2().getY(), 0);
        assertEquals(7, rectangle.getPoint3().getY(), 0);
        assertEquals(7, rectangle.getPoint4().getY(), 0);
        assertEquals(15, rectangle.computeArea(), 0);

        
        rectangle = new Rectangle(17.3, 6.66, 9.13, 4.20);
        assertEquals(17.3, rectangle.getPoint1().getX(), 0);
        assertEquals(26.43, rectangle.getPoint2().getX(), 0);
        assertEquals(17.3, rectangle.getPoint3().getX(), 0);
        assertEquals(26.43, rectangle.getPoint4().getX(), 0);
        assertEquals(6.66, rectangle.getPoint1().getY(), 0);
        assertEquals(6.66, rectangle.getPoint2().getY(), 0);
        assertEquals(10.86, rectangle.getPoint3().getY(), 0);
        assertEquals(10.86, rectangle.getPoint4().getY(), 0);
        assertEquals(38.346, rectangle.computeArea(), 0.0000001);
        
        
    }
	
	@Test
    public void testInvalidConstruction() {

        try {
            new Rectangle(null, 2.5, 5.5);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            new Rectangle( new Point(1, 2), Double.POSITIVE_INFINITY, 5.5);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }
        
        try {
            new Rectangle( new Point(1, 2), 5.5, Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }
        
        try {
            new Rectangle(new Point(1, 2), Double.NEGATIVE_INFINITY, 6.98);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }
        
        try {
            new Rectangle(new Point(1, 2), 6.98, Double.NEGATIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            new Rectangle(new Point(1, 2), Double.NaN,98.3);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            new Rectangle(new Point(1, 2), 72.6 ,Double.NaN);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }
        
        try {
            new Rectangle(Double.POSITIVE_INFINITY, 2, 3, 6.5);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            new Rectangle( 2, Double.POSITIVE_INFINITY, 3, 6.5);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }
        
        try {
            new Rectangle(Double.NEGATIVE_INFINITY, 2, 3, 6.5);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            new Rectangle( 2, Double.NEGATIVE_INFINITY, 3, 6.5);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }
        
        try {
            new Rectangle(Double.NaN, 2, 3, 6.5);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            new Rectangle( 2, Double.NaN, 3, 6.5);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }
	}
	
	
	@Test
	public void testMove() throws ShapeException {
		Rectangle rectangle = new Rectangle(5.5, 5.5, 2.3,3.3);
        assertEquals(5.5, rectangle.getPoint1().getX(), 0);
        assertEquals(5.5, rectangle.getPoint1().getY(), 0);
        assertEquals(2.3, rectangle.getWidth(), 0);
        assertEquals(3.3, rectangle.getHeight(), 0);

        rectangle.move(3,  4);
        assertEquals(8.5, rectangle.getPoint1().getX(), 0);
        assertEquals(9.5, rectangle.getPoint1().getY(), 0);
        assertEquals(2.3, rectangle.getWidth(), 0);
        assertEquals(3.3, rectangle.getHeight(), 0);

        rectangle.move(0.123,  0.456);
        assertEquals(8.623, rectangle.getPoint1().getX(), 0);
        assertEquals(9.956, rectangle.getPoint1().getY(), 0);
        assertEquals(2.3, rectangle.getWidth(), 0);
        assertEquals(3.3, rectangle.getHeight(), 0);

        rectangle.move(-0.123,  -0.456);
        assertEquals(8.5, rectangle.getPoint1().getX(), 0);
        assertEquals(9.5, rectangle.getPoint1().getY(), 0);
        assertEquals(2.3, rectangle.getWidth(), 0);
        assertEquals(3.3, rectangle.getHeight(), 0);

        rectangle.move(-12,  -26);
        assertEquals(-3.5, rectangle.getPoint1().getX(), 0);
        assertEquals(-16.5, rectangle.getPoint1().getY(), 0);
        assertEquals(2.3, rectangle.getWidth(), 0);
        assertEquals(3.3, rectangle.getHeight(), 0);

        try {
        	rectangle.move(Double.POSITIVE_INFINITY, 1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
        	rectangle.move(Double.NEGATIVE_INFINITY, 1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
        	rectangle.move(Double.NaN, 1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
        	rectangle.move(1, Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
        	rectangle.move(1, Double.NEGATIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
        	rectangle.move(1, Double.NaN);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

    }
	
	 @Test
	    public void testComputeArea() throws ShapeException {
	        Rectangle rectangle = new Rectangle(1, 2, 5, 5);
	        assertEquals(25, rectangle.computeArea(), 0.0001);

	        rectangle = new Rectangle(1.0, 2.0, 4.234,6.789);
	        assertEquals(28.744626, rectangle.computeArea(), 0.0001);

	        try {
	        	rectangle = new Rectangle(1, 2, 0, 63.2);
	            assertEquals(0, rectangle.computeArea(), 0);
	        } catch(ShapeException e)
	        {
	        	//ignore
	        }
	        
	        try
	        {
		        rectangle = new Rectangle(1, 2, -5, 6);
		        assertEquals(-30, rectangle.computeArea(), 0.0001);
	        }catch(ShapeException e)
	        {
	        	//ignore
	        }

	        try
	        {
		        rectangle = new Rectangle(1, 2, 4.234, -6.69);
		        assertEquals(-28.32546, rectangle.computeArea(), 0.0001);
	        }catch(ShapeException e)
	        {
	        	//ignore
	        }

	        try {
	        	rectangle = new Rectangle(1, 2, 3.3,0);
	            assertEquals(0, rectangle.computeArea(), 0);
	        } catch(ShapeException e)
	        {
	        	//ignore
	        }

	    }
	 
	 @Test
	 public void testToString() throws ShapeException
	 {
	     Rectangle rectangle = new Rectangle(1, 2, 5, 6);
	     assertEquals("Rectangle,1.0,2.0,5.0,6.0", rectangle.toString());
	 }

	 @Test
	 public void testEquals() throws ShapeException
	 {
	    Rectangle l1 = new Rectangle(1, 2, 4, 4);
	    Rectangle l2 = new Rectangle(1, 5, 4, 5);
	    Rectangle l3 = new Rectangle(1, 2, 4, 4);
	    	
	    assertTrue(l1.equals(l1));
	    assertFalse(l1.equals(l2));
	    assertFalse(l1.equals(null));
	    assertTrue(l1.equals(l3));
	   }
}
