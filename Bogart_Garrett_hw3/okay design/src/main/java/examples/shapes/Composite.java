package examples.shapes;

import java.util.ArrayList;

public class Composite extends Shape {
	private ArrayList<Shape> shapes;
	
	public Composite()
	{
		shapes = new ArrayList<Shape>();
	}
	
	public Composite(Shape shape) throws ShapeException
	{
		shapes = new ArrayList<Shape>();
		validateShape(shape);
		shapes.add(shape);
	}
	
	public Composite(ArrayList<Shape> shapes) throws ShapeException
	{
		this.shapes = new ArrayList<Shape>();
		for(Shape shape: shapes)
		{
			validateShape(shape);
		}
		this.shapes.addAll(shapes);
	}
	
	@Override
	public double computeArea() throws ShapeException {
		double area = 0;
		for(Shape shape : shapes)
		{
			area+=shape.computeArea();
		}
		// TODO Auto-generated method stub
		return area;
	}

	@Override
	public void scale(double scalingFactor) throws ShapeException {
		// TODO Auto-generated method stub
		for(Shape shape : shapes)
		{
			shape.scale(scalingFactor);
		}
	}
	
	public void addShape(Shape shape) throws ShapeException
	{
		validateShape(shape);
		shapes.add(shape);
	}
	
	public void removeShape(Shape shape)
	{
		int found = shapes.indexOf(shape);
		if(found == -1)
		{
			return;
		}
		shapes.remove(found);
	}
	
	public Shape getShape(Shape shape)
	{
		Shape temp = null;
		for(Shape s : shapes)
		{	
			//System.out.println(s);

			if(s instanceof Composite)
			{
				Shape t =((Composite) s).getShape(shape);	
				if(t != null)
				{
					temp = t;
					break;
				}

			}
			else if(shape.getClass().equals(s.getClass()))
			{

				if(shape.equals(s));
				{
					temp =s;					
				}
			}
		}
		return temp;
	}
	
	public void move(double deltaX, double deltaY) throws ShapeException
	{
		for(Shape shape : shapes)
		{
			shape.move(deltaX, deltaY);
		}
	}
	
	public void validateShape(Shape shape) throws ShapeException
	{
		if(shape == null)
		{
			throw new ShapeException("Shape can't be null");
		}
	}
		
	public ArrayList<Shape> getShapes()
	{
		return shapes;
	}
}
