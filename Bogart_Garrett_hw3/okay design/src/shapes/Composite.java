package shapes;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


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
	
	public Shape getShape(Shape shape) throws ShapeException
	{
		Shape temp = null;
		for(Shape s : shapes)
		{	
			if(s instanceof Composite)
			{
				if(s.equals(shape))
				{
					temp = s;
				}
				else
				{
					temp = ((Composite) s).getShape(shape);
				}				
			}			
			else if(s.equals(shape))
			{
				temp = s;
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
	
	public String toString()
	{
		String comp = "Composite"+","+shapes.size();
		for(Shape s : shapes)
		{
			comp+=";"+s.toString();
		}
		return comp;
	}

	@Override
	public boolean equals(Shape shape) throws ShapeException 
	{
		boolean same = true;
    	if(!(shape instanceof Composite))
    	{
    		return false;
    	}
    	
    	if(shape == this)
    	{
    		return true;
    	}
    	return this.toString().equals(shape.toString());
	}
	
	public void render(Graphics g) throws ShapeException
	{
		for(Shape s: shapes)
		{
			s.render(g);
		}	
	}
}
