package test;

import shapes.*;

import org.junit.Test;

import shapes.Point;

import static org.junit.Assert.*;

public class CircleTest {

    @Test
    public void testValidConstruction() throws Exception {
        Point center = new Point(1,2);
        Circle myCircle = new Circle(center, 5);
        assertSame(center, myCircle.getPoint1());
        assertEquals(5, myCircle.getRadius(), 0);

        myCircle = new Circle(1.3, 2.6, 2.5);
        assertEquals(1.3, myCircle.getPoint1().getX(), 0);
        assertEquals(2.6, myCircle.getPoint1().getY(), 0);
        assertEquals(2.5, myCircle.getRadius(), 0);
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

    }

    @Test
    public void testMove() throws ShapeException {
        Circle myCircle = new Circle(1, 2, 5);
        assertEquals(1, myCircle.getPoint1().getX(), 0);
        assertEquals(2, myCircle.getPoint1().getY(), 0);
        assertEquals(5, myCircle.getRadius(), 0);

        myCircle.move(3,  4);
        assertEquals(4, myCircle.getPoint1().getX(), 0);
        assertEquals(6, myCircle.getPoint1().getY(), 0);
        assertEquals(5, myCircle.getRadius(), 0);

        myCircle.move(0.123,  0.456);
        assertEquals(4.123, myCircle.getPoint1().getX(), 0);
        assertEquals(6.456, myCircle.getPoint1().getY(), 0);
        assertEquals(5, myCircle.getRadius(), 0);

        myCircle.move(-0.123,  -0.456);
        assertEquals(4, myCircle.getPoint1().getX(), 0);
        assertEquals(6, myCircle.getPoint1().getY(), 0);
        assertEquals(5, myCircle.getRadius(), 0);

        myCircle.move(-12,  -26);
        assertEquals(-8, myCircle.getPoint1().getX(), 0);
        assertEquals(-20, myCircle.getPoint1().getY(), 0);
        assertEquals(5, myCircle.getRadius(), 0);

        try {
            myCircle.move(Double.POSITIVE_INFINITY, 1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            myCircle.move(Double.NEGATIVE_INFINITY, 1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            myCircle.move(Double.NaN, 1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            myCircle.move(1, Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            myCircle.move(1, Double.NEGATIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            myCircle.move(1, Double.NaN);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

    }

    @Test
    public void testScale() throws ShapeException {
        Circle myCircle = new Circle(1, 2, 5);
        assertEquals(1, myCircle.getPoint1().getX(), 0);
        assertEquals(2, myCircle.getPoint1().getY(), 0);
        assertEquals(5, myCircle.getRadius(), 0);

        myCircle.scale(3);
        assertEquals(1, myCircle.getPoint1().getX(), 0);
        assertEquals(2, myCircle.getPoint1().getY(), 0);
        assertEquals(15, myCircle.getRadius(), 0);

        myCircle.scale(0.2);
        assertEquals(1, myCircle.getPoint1().getX(), 0);
        assertEquals(2, myCircle.getPoint1().getY(), 0);
        assertEquals(3, myCircle.getRadius(), 0);

        try {
            myCircle.scale(Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            myCircle.scale(Double.NEGATIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            myCircle.scale(Double.NaN);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }
    }

    @Test
    public void testComputeArea() throws ShapeException {
        Circle myCircle = new Circle(1, 2, 5);
        assertEquals(78.53975, myCircle.computeArea(), 0.0001);

        myCircle = new Circle(1, 2, 4.234);
        assertEquals(56.3185174, myCircle.computeArea(), 0.0001);

        try {
            myCircle = new Circle(1, 2, 0);
            assertEquals(0, myCircle.computeArea(), 0);
        } catch(ShapeException e)
        {
        	//ignore
        }


    }
    @Test
    public void testToString() throws ShapeException
    {
        Circle ellipse = new Circle(1, 2, 5);
        assertEquals("Circle,1.0,2.0,5.0", ellipse.toString());
    }
    
    @Test
    public void testEquals() throws ShapeException
    {
    	Circle l1 = new Circle(1, 2, 4);
    	Circle l2 = new Circle(1, 5, 4);
    	Circle l3 = new Circle(1, 2, 4);
    	
    	assertTrue(l1.equals(l1));
    	assertFalse(l1.equals(l2));
    	assertFalse(l1.equals(null));
    	assertTrue(l1.equals(l3));
    }
}