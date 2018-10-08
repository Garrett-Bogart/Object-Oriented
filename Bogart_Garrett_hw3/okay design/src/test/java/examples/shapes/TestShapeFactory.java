package examples.shapes;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class TestShapeFactory {
	@Test
	public void testMakeShape() throws NumberFormatException, ShapeException
	{
		ShapeFactory sf = new ShapeFactory();
		Shape shape;
		Line line;
		
		
		shape = sf.makeShape("line,0,0,1,1");
		assertTrue(shape instanceof Line);
		assertEquals(0,shape.getPoint1().getX(),0);
		assertEquals(0,shape.getPoint1().getY(),0);
		assertEquals(1,shape.getPoint2().getX(),0);
		assertEquals(1,shape.getPoint2().getY(),0);
		
		shape = sf.makeShape("Triangle,0,0,1,1,4,3");
		assertTrue(shape instanceof Triangle);
		assertEquals(0,shape.getPoint1().getX(),0);
		assertEquals(0,shape.getPoint1().getY(),0);
		assertEquals(1,shape.getPoint2().getX(),0);
		assertEquals(1,shape.getPoint2().getY(),0);
		assertEquals(4,shape.getPoint3().getX(),0);
		assertEquals(3,shape.getPoint3().getY(),0);
		
		shape = sf.makeShape("Ellipse,0,0,1,2");
		assertTrue(shape instanceof Ellipse);
		assertEquals(0,shape.getPoint1().getX(),0);
		assertEquals(0,shape.getPoint1().getY(),0);
		
		shape = sf.makeShape("circle,0,0,1");
		assertTrue(shape instanceof Circle);
		assertEquals(0,shape.getPoint1().getX(),0);
		assertEquals(0,shape.getPoint1().getY(),0);
		
		shape = sf.makeShape("Rectangle,0,0,1,2");
		assertTrue(shape instanceof Rectangle);
		assertEquals(0,shape.getPoint1().getX(),0);
		assertEquals(0,shape.getPoint1().getY(),0);
		
		shape = sf.makeShape("Square,0,0,2.5");
		assertTrue(shape instanceof Square);
		assertEquals(0,shape.getPoint1().getX(),0);
		assertEquals(0,shape.getPoint1().getY(),0);
		assertEquals(6.25,shape.computeArea(),0);
		shape.computeArea();
		
		shape = sf.makeShape("");
		assertNull(shape);

	}
	
	@Test
	public void testMakeComposite() throws NumberFormatException, ShapeException
	{
		ShapeFactory sf = new ShapeFactory();
		Shape shape;
		Composite comp;
		
		shape = sf.makeShape("composite,4;Line,0,0,1,1;Square,0,0,1;Rectangle,0,0,1,2;Circle,0,0,1");
		comp = (Composite) shape;
		assertEquals(4,comp.getShapes().size());

	}
	
	
	@Test
	public void testMakeNestedComposite() throws NumberFormatException, ShapeException, IOException
	{
		ShapeFactory sf = new ShapeFactory();
		Shape shape;
		Composite comp;
		String input = "composite,4;"
				+ "line,0,0,1,1;"
				+ "circle,0,0,1;"
				+ "composite,2;"
					+ "composite,1;"
						+ "line,0,0,5,5;"
					+ "line,0,0,1,5;"
				+ "Circle,0,0,2.7";
		
		shape = sf.makeShape(input);
		comp = (Composite) shape;
		assertEquals(4,comp.getShapes().size());
		assertNotNull(comp);
				
		Line line1 = new Line(0.0,0.0,5.0,5.0);
		Shape l2 = comp.getShape(line1);
		//System.out.println(l2);
		assertTrue(l2 instanceof Line);
		assertEquals(0.0,l2.getPoint1().getX(),0);
		assertEquals(0.0,l2.getPoint1().getY(),0);
		assertEquals(5.0,l2.getPoint2().getX(),0);
		assertEquals(5.0,l2.getPoint2().getY(),0);
		
		ArrayList<Shape> test = comp.getShapes();
		assertTrue(test.get(0) instanceof Line);
		assertTrue(test.get(1) instanceof Circle);
		assertTrue(test.get(2) instanceof Composite);
		assertTrue(test.get(3) instanceof Circle);
		
		Composite subComp = (Composite) test.get(2);
		ArrayList<Shape> test1 = subComp.getShapes();
		assertTrue(test1.get(0) instanceof Composite);
		assertTrue(test1.get(1) instanceof Line);
		
		subComp = (Composite) test1.get(0);
		test1 = subComp.getShapes();
		assertTrue(test1.get(0) instanceof Line);
		

	}
	
	@Test
	public void testMakeNestedCompositeInputStream() throws NumberFormatException, ShapeException, IOException
	{
		ShapeFactory sf = new ShapeFactory();
		Shape shape;
		Composite comp;
		String input = "composite,4;"
				+ "line,0,0,1,1;"
				+ "circle,0,0,1;"
				+ "composite,2;"
					+ "composite,1;"
						+ "line,0,0,5,5;"
					+ "line,0,0,1,5;"
				+ "Circle,0,0,2.7";
		InputStream inputStream = new ByteArrayInputStream(input.getBytes());
		//BufferedReader buff = new BufferedReader(new InputStreamReader(inputStream) );
		//System.out.print(buff.readLine());
		
		shape = sf.makeShape(inputStream);
		comp = (Composite) shape;
		assertEquals(4,comp.getShapes().size());
		assertNotNull(comp);
				
		Line line1 = new Line(0.0,0.0,5.0,5.0);
		Shape l2 = comp.getShape(line1);
		//System.out.println(l2);
		assertTrue(l2 instanceof Line);
		assertEquals(0.0,l2.getPoint1().getX(),0);
		assertEquals(0.0,l2.getPoint1().getY(),0);
		assertEquals(5.0,l2.getPoint2().getX(),0);
		assertEquals(5.0,l2.getPoint2().getY(),0);
		
		ArrayList<Shape> test = comp.getShapes();
		assertTrue(test.get(0) instanceof Line);
		assertTrue(test.get(1) instanceof Circle);
		assertTrue(test.get(2) instanceof Composite);
		assertTrue(test.get(3) instanceof Circle);
		
		Composite subComp = (Composite) test.get(2);
		ArrayList<Shape> test1 = subComp.getShapes();
		assertTrue(test1.get(0) instanceof Composite);
		assertTrue(test1.get(1) instanceof Line);
		
		subComp = (Composite) test1.get(0);
		test1 = subComp.getShapes();
		assertTrue(test1.get(0) instanceof Line);
		

	}
	

		
}
