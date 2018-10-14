package examples.shapes;

import org.junit.Test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;

public class LineTest {

    @Test
    public void testValidConstruction() throws Exception {
        Point p1 = new Point(1,2);
        Point p2 = new Point(4, 10);
    	Shape myLine = new Line(p1, p2);
    	
        assertEquals(1, myLine.getPoint1().getX(),0);
        assertEquals(4, myLine.getPoint2().getX(),0);
        assertEquals(2, myLine.getPoint1().getY(),0);
        assertEquals(10, myLine.getPoint2().getY(),0);
        
        assertSame(p1, myLine.getPoint1());
        assertSame(p2, myLine.getPoint2());

        p1 = new Point(1.4,2.5);
        p2 = new Point(4.6, 10.7);
        myLine = new Line(p1, p2);
        assertSame(p1, myLine.getPoint1());
        assertSame(p2, myLine.getPoint2());

        myLine = new Line(1, 3.33, 4.444, 5.5555);
        assertEquals(1, myLine.getPoint1().getX(), 0);
        assertEquals(3.33, myLine.getPoint1().getY(), 0);
        assertEquals(4.444, myLine.getPoint2().getX(), 0);
        assertEquals(5.5555, myLine.getPoint2().getY(), 0);
    }

    @Test
    public void testInvalidConstruction() throws ShapeException {
        Point p1 = new Point(1,2);
        Point p2 = new Point(4, 10);

        try {
            new Line(p1, null);
            fail("Expected exception not thrown for when the first parameter is null");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("Invalid Point", e.getMessage());
        }

        try {
            new Line(null, p2);
            fail("Expected exception not thrown for when the second parameter is null");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("Invalid Point", e.getMessage());
        }

        try {
            new Line(Double.POSITIVE_INFINITY, 2, 3, 4);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            //assertEquals("Invalid x-location", e.getMessage());
        }

        try {
            new Line(1, Double.POSITIVE_INFINITY, 3, 4);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            //assertEquals("Invalid y-location", e.getMessage());
        }

        try {
            new Line(1, 2, Double.POSITIVE_INFINITY, 4);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            //assertEquals("Invalid x-location", e.getMessage());
        }

        try {
            new Line(1, 2, 3, Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            //assertEquals("Invalid y-location", e.getMessage());
        }

        try {
            new Line(p1, p1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            //assertEquals("A line must have a length > 0", e.getMessage());
        }

        try {
            new Line(1,2, 1,2);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            //assertEquals("A line must have a length > 0", e.getMessage());
        }
    }

    @Test
    public void testMove() throws ShapeException {
        Shape myLine = new Line(1, 2, 4, 10);
        assertEquals(1, myLine.getPoint1().getX(),0);
        assertEquals(4, myLine.getPoint2().getX(),0);
        assertEquals(2, myLine.getPoint1().getY(),0);
        assertEquals(10, myLine.getPoint2().getY(),0);
        myLine.move(3, 4);

        assertEquals(4, myLine.getPoint1().getX(), 0);
        assertEquals(6, myLine.getPoint1().getY(), 0);
        assertEquals(7, myLine.getPoint2().getX(), 0);
        assertEquals(14, myLine.getPoint2().getY(), 0);

        myLine.move(.4321, .7654);
        assertEquals(4.4321, myLine.getPoint1().getX(), 0);
        assertEquals(6.7654, myLine.getPoint1().getY(), 0);
        assertEquals(7.4321, myLine.getPoint2().getX(), 0);
        assertEquals(14.7654, myLine.getPoint2().getY(), 0);

        myLine.move(-0.4321, -0.7654);
        assertEquals(4, myLine.getPoint1().getX(), 0);
        assertEquals(6, myLine.getPoint1().getY(), 0);
        assertEquals(7, myLine.getPoint2().getX(), 0);
        assertEquals(14, myLine.getPoint2().getY(), 0);
    }

    @Test
    public void testComputeLength() throws ShapeException {

        Line myLine = new Line(1, 2, 4, 10);
        assertEquals(8.544, myLine.computeLength(), 0.001);

        myLine = new Line(1, 2, 1, 3);
        assertEquals(Math.sqrt(1), myLine.computeLength(), 0.001);

        myLine = new Line(3, -2, -4, 10);
        assertEquals(13.892, myLine.computeLength(), 0.001);
    }

    @Test
    public void testComputeSlope() throws ShapeException {
        Line myLine = new Line(2, 2, 4, 10);
        assertEquals(4, myLine.computeSlope(), 0.1);

        myLine = new Line(2, 2, 4, 10);
        assertEquals(4, myLine.computeSlope(), 0.1);

        myLine = new Line(2, 2, 2, 4);
        assertEquals(Double.POSITIVE_INFINITY, myLine.computeSlope(), 0.1);

        myLine = new Line(2, 2, 4, 2);
        assertEquals(0, myLine.computeSlope(), 0.1);

        myLine = new Line(4, 2, 2, 2);
        assertEquals(0, myLine.computeSlope(), 0.1);
    }

    @Test
    public void testToString() throws ShapeException {

        Line myLine = new Line(1, 2, 4, 10);
        assertEquals(8.544, myLine.computeLength(), 0.001);
        assertEquals("1.0,2.0", myLine.getPoint1().toString());
        assertEquals("4.0,10.0", myLine.getPoint2().toString());
        assertEquals("Line,1.0,2.0,4.0,10.0", myLine.toString());

    }
    
    @Test
    public void testEquals() throws ShapeException
    {
    	Line l1 = new Line(1, 2, 4, 10);
    	Line l2 = new Line(1, 5, 4, 10);
    	Line l3 = new Line(1, 2, 4, 10);
    	
    	assertTrue(l1.equals(l1));
    	assertFalse(l1.equals(l2));
    	assertFalse(l1.equals(null));
    	assertTrue(l1.equals(l3));
    }
    
    @Test
    public void testSaveShape() throws ShapeException, FileNotFoundException
    {
    	Line l1 = new Line(1, 2, 4, 10);
    	OutputStream out = new FileOutputStream("line.txt");
    	l1.saveShape(out);
    }
    
    @Test
    public void testGetArea() throws ShapeException, FileNotFoundException
    {
    	Line l1 = new Line(1, 2, 4, 10);
    	assertEquals(0, l1.computeArea(),0);
    	l1.scale(1.0);
    }
}