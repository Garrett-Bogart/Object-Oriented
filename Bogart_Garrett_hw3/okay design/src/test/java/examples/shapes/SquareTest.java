package examples.shapes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class SquareTest {
	@Test
    public void testValidConstruction() throws Exception {
        Point origin = new Point(1,2);
               
        Square rectangle = new Square(origin, 3);
        assertEquals(1, rectangle.getPoint1().getX(), 0);
        assertEquals(2, rectangle.getPoint1().getY(), 0);    
        
        assertEquals(4, rectangle.getPoint2().getX(), 0);
        assertEquals(2, rectangle.getPoint2().getY(), 0);
        
        assertEquals(1, rectangle.getPoint3().getX(), 0);
        assertEquals(5, rectangle.getPoint3().getY(), 0);
        
        assertEquals(4, rectangle.getPoint4().getX(), 0);                       
        assertEquals(5, rectangle.getPoint4().getY(), 0);
        assertEquals(9, rectangle.computeArea(), 0);

        
        rectangle = new Square(17.3, 6.66, 9.13);
        assertEquals(17.3, rectangle.getPoint1().getX(), 0);
        assertEquals(6.66, rectangle.getPoint1().getY(), 0);    
        
        assertEquals(26.43, rectangle.getPoint2().getX(), 0);
        assertEquals(6.66, rectangle.getPoint2().getY(), 0);
        
        assertEquals(17.3, rectangle.getPoint3().getX(), 0);
        assertEquals(15.79, rectangle.getPoint3().getY(), .0000001);
        
        assertEquals(26.43, rectangle.getPoint4().getX(), 0);                       
        assertEquals(15.79, rectangle.getPoint4().getY(), .0000001);
        assertEquals(83.3569, rectangle.computeArea(), 0.0000001);        
    }
	
	@Test
    public void testInvalidConstruction() {

        try {
            new Square(null, 2.5);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            new Square( new Point(1, 2), Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }        
        
        try {
            new Square(new Point(1, 2), Double.NEGATIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }
        

        try {
            new Square(new Point(1, 2), Double.NaN);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }
        
        try {
            new Square(Double.POSITIVE_INFINITY, 2, 3);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            new Square( 2, Double.POSITIVE_INFINITY, 3);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }
        
        try {
            new Square(Double.NEGATIVE_INFINITY, 2, 3);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            new Square( 2, Double.NEGATIVE_INFINITY, 3);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }
        
        try {
            new Square(Double.NaN, 2, 3);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            new Square( 2, Double.NaN, 3);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }
	}
	
	@Test
	public void testMove() throws ShapeException {
		Square rectangle = new Square(5.5, 5.5, 2.3);
        assertEquals(5.5, rectangle.getPoint1().getX(), 0);
        assertEquals(5.5, rectangle.getPoint1().getY(), 0);
        assertEquals(2.3, rectangle.getWidth(), 0);
        assertEquals(2.3, rectangle.getHeight(), 0);

        rectangle.move(3,  4);
        assertEquals(8.5, rectangle.getPoint1().getX(), 0);
        assertEquals(9.5, rectangle.getPoint1().getY(), 0);
        assertEquals(2.3, rectangle.getWidth(), 0);
        assertEquals(2.3, rectangle.getHeight(), 0);

        rectangle.move(0.123,  0.456);
        assertEquals(8.623, rectangle.getPoint1().getX(), 0);
        assertEquals(9.956, rectangle.getPoint1().getY(), 0);
        assertEquals(2.3, rectangle.getWidth(), 0);
        assertEquals(2.3, rectangle.getHeight(), 0);

        rectangle.move(-0.123,  -0.456);
        assertEquals(8.5, rectangle.getPoint1().getX(), 0);
        assertEquals(9.5, rectangle.getPoint1().getY(), 0);
        assertEquals(2.3, rectangle.getWidth(), 0);
        assertEquals(2.3, rectangle.getHeight(), 0);

        rectangle.move(-12,  -26);
        assertEquals(-3.5, rectangle.getPoint1().getX(), 0);
        assertEquals(-16.5, rectangle.getPoint1().getY(), 0);
        assertEquals(2.3, rectangle.getWidth(), 0);
        assertEquals(2.3, rectangle.getHeight(), 0);

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
		Square rectangle = new Square(1, 2, 5);
        assertEquals(25, rectangle.computeArea(), 0.0001);

        rectangle = new Square(1.0, 2.0, 4.234);
        assertEquals(17.926756, rectangle.computeArea(), 0.0001);

        try {
        	rectangle = new Square(1, 2, 0);
            assertEquals(0, rectangle.computeArea(), 0);
        } catch(ShapeException e)
        {
        	//ignore
        }
        
        try
        {
	        rectangle = new Square(1, 2, -5);
	        assertEquals(-30, rectangle.computeArea(), 0.0001);
        }catch(ShapeException e)
        {
        	//ignore
        }
    }
	
	 @Test
	 public void testToString() throws ShapeException
	 {
	     Square rectangle = new Square(1, 2, 5);
	     assertEquals("Square,1.0,2.0,5.0", rectangle.toString());
	 }
}
