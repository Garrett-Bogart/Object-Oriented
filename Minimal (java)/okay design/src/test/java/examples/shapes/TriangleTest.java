package examples.shapes;

import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {
	
	@Test
    public void testValidConstruction() throws Exception {
        Point p1 = new Point(1,2);
        Point p2 = new Point(4, 10);
        Point p3 = new Point(3,7);
        
        Triangle triangle = new Triangle(p1, p2, p3);
        
        assertSame(p1, triangle.getPoint1());
        assertSame(p2, triangle.getPoint2());
        assertSame(p3, triangle.getPoint3());

        p1 = new Point(1.4,2.5);
        p2 = new Point(4.6, 10.7);
        p3 = new Point(17.2, 18.5);
        triangle = new Triangle (p1, p2, p3);
        assertSame(p1, triangle.getPoint1());
        assertSame(p2, triangle.getPoint2());
        assertSame(p3, triangle.getPoint3());

        triangle = new Triangle(1, 3.33, 4.444, 5.5555, 2.22, 6.66);
        assertEquals(1, triangle.getPoint1().getX(), 0);
        assertEquals(3.33, triangle.getPoint1().getY(), 0);
        assertEquals(4.444, triangle.getPoint2().getX(), 0);
        assertEquals(5.5555, triangle.getPoint2().getY(), 0);
        assertEquals(2.22, triangle.getPoint3().getX(), 0);
        assertEquals(6.66, triangle.getPoint3().getY(), 0);
    }

	@Test
    public void testInvalidConstruction() throws ShapeException {
        Point p1 = new Point(1,2);
        Point p2 = new Point(4, 10);
        Point p3 = new Point (7, 11);

        try {
            new Triangle(p1, null, p3);
            fail("Expected exception not thrown for when the first parameter is null");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("Invalid Point", e.getMessage());
        }

        try {
            new Triangle(null, p2, p3);
            fail("Expected exception not thrown for when the second parameter is null");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("Invalid Point", e.getMessage());
        }

        try {
            new Triangle(p1, p2, null);
            fail("Expected exception not thrown for when the second parameter is null");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("Invalid Point", e.getMessage());
        }
        
        try {
            new Triangle(Double.POSITIVE_INFINITY, 2, 3, 4, 6, 8);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("Invalid x-location", e.getMessage());
        }

        try {
            new Triangle(1, Double.POSITIVE_INFINITY, 3, 4, 6, 8);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("Invalid y-location", e.getMessage());
        }

        try {
            new Triangle(1, 2, Double.POSITIVE_INFINITY, 4, 6, 8);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("Invalid x-location", e.getMessage());
        }

        try {
            new Triangle(1, 2, 3, Double.POSITIVE_INFINITY, 6, 8);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("Invalid y-location", e.getMessage());
        }

        try {
            new Triangle(1, 2, 3, 4, Double.POSITIVE_INFINITY, 8);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("Invalid x-location", e.getMessage());
        }
        
        try {
            new Triangle(1, 2, 3, 4, 6, Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("Invalid y-location", e.getMessage());
        }
        
        try {
            new Triangle(1, 2, 1.000000001, 2.000000001, 6, 8);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            //ignore
        }
        

	}

	@Test
	public void testMove() throws ShapeException {
	        Triangle triangle = new Triangle(1, 2, 4, 10, 3, 7);

	        triangle.moveTriangle(3, 4);
	        assertEquals(4, triangle.getPoint1().getX(), 0);
	        assertEquals(6, triangle.getPoint1().getY(), 0);
	        assertEquals(7, triangle.getPoint2().getX(), 0);
	        assertEquals(14, triangle.getPoint2().getY(), 0);
	        assertEquals(6, triangle.getPoint3().getX(), 0);
	        assertEquals(11, triangle.getPoint3().getY(), 0);
	        
	        triangle.moveTriangle(.4321, .7654);
	        assertEquals(4.4321, triangle.getPoint1().getX(), 0);
	        assertEquals(6.7654, triangle.getPoint1().getY(), 0);
	        assertEquals(7.4321, triangle.getPoint2().getX(), 0);
	        assertEquals(14.7654, triangle.getPoint2().getY(), 0);
	        assertEquals(6.4321, triangle.getPoint3().getX(), 0);
	        assertEquals(11.7654, triangle.getPoint3().getY(), 0);

	        triangle.moveTriangle(-0.4321, -0.7654);
	        assertEquals(4, triangle.getPoint1().getX(), 0);
	        assertEquals(6, triangle.getPoint1().getY(), 0);
	        assertEquals(7, triangle.getPoint2().getX(), 0);
	        assertEquals(14, triangle.getPoint2().getY(), 0);
	        assertEquals(6, triangle.getPoint3().getX(), 0);
	        assertEquals(11, triangle.getPoint3().getY(), 0);
	    }
	
	@Test
    public void testComputeArea() throws ShapeException {

        Triangle triangle = new Triangle(1, 1, 5, 1, 10, 10);
        assertEquals(18.000, triangle.computeArea(), 0.001);

        triangle = new Triangle(1.5, 1.5, 17.5, 1, 22.75, 33.333);
        assertEquals(259.9765, triangle.computeArea(), 0.001);

    }
	
}
