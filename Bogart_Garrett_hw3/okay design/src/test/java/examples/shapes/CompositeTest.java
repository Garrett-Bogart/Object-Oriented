package examples.shapes;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import org.junit.Test;

public class CompositeTest {
	@Test
	public void testConstructor() throws ShapeException
	{
		Triangle tri = new Triangle(0,0,3,4,5,5);
		Square sq = new Square(0,0,5);
		Circle cir = new Circle(0,0,5);
		Composite comp = new Composite();
		assertEquals(0, comp.getShapes().size());
		
		Composite comp1 = new Composite(tri);
		assertEquals(1, comp1.getShapes().size());
		assertTrue(comp1.getShape(tri) instanceof Triangle);
		
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		shapes.add(tri);
		shapes.add(sq);
		shapes.add(cir);
		Composite comp2 = new Composite(shapes);
		assertEquals(3, comp2.getShapes().size());
		assertTrue(comp2.getShape(tri) instanceof Triangle);
		assertTrue(comp2.getShape(sq) instanceof Square);
		assertTrue(comp2.getShape(cir) instanceof Circle);
	}
	
	@Test
	public void testInvalidConstructor() throws ShapeException
	{
		Triangle tri = new Triangle(0,0,3,4,5,5);
		Square sq = new Square(0,0,5);
		Circle cir = new Circle(0,0,5);
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		shapes.add(tri);
		shapes.add(sq);
		shapes.add(null);
		cir = null;
		
		try
		{
				new Composite(cir);
		}catch(ShapeException e)
		{
			//ignore
		}
		

		try
		{
				new Composite(shapes);
		}catch(ShapeException e)
		{
			//ignore
		}
	}
	
	@Test
	public void testComputeArea() throws ShapeException
	{
		Triangle tri = new Triangle(0,0,3,0,0,4);
		Square sq = new Square(0,0,5);
		Circle cir = new Circle(0,0,5);
		Composite comp = new Composite();
		assertEquals(0, comp.getShapes().size());
		
		Composite comp1 = new Composite(tri);
		assertEquals(1, comp1.getShapes().size());
		assertEquals(6.0, comp1.computeArea(), .001);
		
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		shapes.add(tri);
		shapes.add(sq);
		shapes.add(cir);
		Composite comp2 = new Composite(shapes);
		assertEquals(109.53975, comp2.computeArea(), .001);

	}
	
	@Test
	public void testAddShape() throws ShapeException
	{
		Triangle tri = new Triangle(0,0,3,0,0,4);
		Square sq = new Square(0,0,5);
		Square sq1 = new Square(0,0,6);
		Circle cir = new Circle(0,0,5);
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		shapes.add(tri);
		shapes.add(sq);
		shapes.add(cir);
		Composite comp = new Composite(shapes);
		cir = new Circle(0,0,6);
		comp.addShape(cir);
		assertEquals(4, comp.getShapes().size());
		assertTrue(comp.getShape(cir) instanceof Circle);
		assertNull(comp.getShape(sq1));
		
	}
	
	@Test
	public void testAddCompositeShape() throws ShapeException
	{
		ArrayList<ArrayList> allShapes = new ArrayList<ArrayList>();
		Triangle tri = new Triangle(0,0,3,0,0,4);
		Square sq = new Square(0,0,5);
		Square sq1 = new Square(0,0,6);
		Circle cir = new Circle(0,0,5);
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		shapes.add(tri);
		shapes.add(sq);
		shapes.add(cir);
		Composite comp = new Composite(shapes);
		cir = new Circle(0,0,6);
		comp.addShape(cir);
		assertEquals(4, comp.getShapes().size());
		assertTrue(comp.getShape(cir) instanceof Circle);
		assertNull(comp.getShape(sq1));
		
		Composite comp1 = new Composite(cir);
		comp1.addShape(comp);
		assertEquals(2, comp1.getShapes().size());
		assertTrue(comp1.getShape(comp) instanceof Composite);

	}
	
	
	@Test
	public void testRemoveShape() throws ShapeException
	{
		Triangle tri = new Triangle(0,0,3,0,0,4);
		Square sq = new Square(0,0,5);
		Circle cir = new Circle(0,0,5);
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		shapes.add(tri);
		shapes.add(sq);
		shapes.add(cir);
		Composite comp = new Composite(shapes);
		comp.removeShape(cir);
		assertEquals(2, comp.getShapes().size());
		assertNull(comp.getShape(cir));
		comp.removeShape(cir);
	}
	
	@Test
	public void testMove() throws ShapeException
	{
		Triangle tri = new Triangle(0,0,3,0,0,4);
		Square sq = new Square(0,0,5);
		Circle cir = new Circle(0,0,5);
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		shapes.add(tri);
		shapes.add(sq);
		shapes.add(cir);
		Composite comp = new Composite(shapes);
		comp.move(1, 1);
		assertEquals(1, comp.getShape(tri).getPoint1().getX(),0);
		assertEquals(1, comp.getShape(tri).getPoint1().getY(),0);
		assertEquals(4, comp.getShape(tri).getPoint2().getX(),0);
		assertEquals(1, comp.getShape(tri).getPoint2().getY(),0);
		assertEquals(1, comp.getShape(tri).getPoint3().getX(),0);
		assertEquals(5, comp.getShape(tri).getPoint3().getY(),0);
		
		assertEquals(1, comp.getShape(sq).getPoint1().getX(),0);
		assertEquals(1, comp.getShape(sq).getPoint1().getY(),0);
		
		assertEquals(1, comp.getShape(cir).getPoint1().getX(),0);
		assertEquals(1, comp.getShape(cir).getPoint1().getY(),0);	
	}
	
	@Test
	public void testScale() throws ShapeException
	{
		Triangle tri = new Triangle(0,0,1.5,0,0,2);
		Square sq = new Square(0,0,2.5);
		Circle cir = new Circle(0,0,2.5);
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		shapes.add(tri);
		shapes.add(sq);
		shapes.add(cir);
		Composite comp = new Composite(shapes);
		comp.scale(2);
		assertEquals(6, comp.getShape(tri).computeArea(),0);
		assertEquals(78.53975, comp.getShape(cir).computeArea(),.0001);
		assertEquals(25, comp.getShape(sq).computeArea(),0);

	}
	
	@Test
	public void testToString() throws NumberFormatException, ShapeException
	{
		ShapeFactory sf = new ShapeFactory();
		Shape shape;
		Composite comp;
		String input = "composite,4;"
				+ "line,0.0,0.0,1.0,1.0;"
				+ "circle,0.0,0.0,1.0;"
				+ "composite,2;"
					+ "composite,1;"
						+ "line,0.0,0.0,5.0,5.0;"
					+ "line,0.0,0.0,1.0,5.0;"
				+ "circle,0.0,0.0,2.7";
		
		shape = sf.makeShape(input);
		comp = (Composite) shape;
		assertEquals(input, comp.toString().toLowerCase());
	}
	
	@Test
	public void testEquals() throws NumberFormatException, ShapeException
	{
		ShapeFactory sf = new ShapeFactory();
		Shape shape;
		Composite comp;
		String input = "composite,4;"
				+ "line,0.0,0.0,1.0,1.0;"
				+ "circle,0.0,0.0,1.0;"
				+ "composite,2;"
					+ "composite,1;"
						+ "line,0.0,0.0,5.0,5.0;"
					+ "line,0.0,0.0,1.0,5.0;"
				+ "circle,0.0,0.0,2.7";
		
		shape = sf.makeShape(input);
		comp = (Composite) shape;
		Shape shape1 = sf.makeShape(input);
		Composite comp1 = (Composite) shape1;
		assertTrue(comp1.equals(comp));
	}
	
    @Test
    public void testSaveShape() throws ShapeException, FileNotFoundException
    {
		ShapeFactory sf = new ShapeFactory();
		Shape shape;
		Composite comp;
		String input = "composite,4;"
				+ "line,0.0,0.0,1.0,1.0;"
				+ "circle,0.0,0.0,1.0;"
				+ "composite,2;"
					+ "composite,1;"
						+ "line,0.0,0.0,5.0,5.0;"
					+ "line,0.0,0.0,1.0,5.0;"
				+ "circle,0.0,0.0,2.7";
		
		shape = sf.makeShape(input);
		comp = (Composite) shape;
		assertEquals(input, comp.toString().toLowerCase());
    	OutputStream out = new FileOutputStream("composite.txt");
    	comp.saveShape(out);
    }
}
