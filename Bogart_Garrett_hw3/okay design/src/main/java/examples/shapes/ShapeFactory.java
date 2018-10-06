package examples.shapes;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

import javafx.util.Pair;

public class ShapeFactory {
	ArrayList<String> shapeList;
	
	public ShapeFactory()
	{
		shapeList = new ArrayList<String>();
		shapeList.add("line");
		shapeList.add("triangle");
		shapeList.add("rectangle");
		shapeList.add("square");
		shapeList.add("ellipse");
		shapeList.add("circle");
	}
	
	public double convertString(String part)throws NumberFormatException
	{
		return Double.parseDouble(part.trim());
	}
	
	public Shape makeShape(String in) throws NumberFormatException, ShapeException //shape,x1,y1,x2,y2,x3,y3
	{
		String input = in.toLowerCase();
		String[] parts = input.split(",");
		Shape shape = null;
		//System.out.println(parts[0]);
		if("line".equals(parts[0].trim()))
		{
			//System.out.println(parts[0]);
			shape = new Line(convertString(parts[1]), convertString(parts[2]),convertString(parts[3]),convertString(parts[4]));
		}
		else if("triangle".equals(parts[0]))
		{
			//System.out.println(parts[0]);
			shape = new Triangle(convertString(parts[1]), convertString(parts[2]),convertString(parts[3]),convertString(parts[4]),convertString(parts[5]),convertString(parts[6]));
		}
		else if("ellipse".equals(parts[0]))
		{
			//System.out.println(parts[0]);
			shape = new Ellipse(convertString(parts[1]), convertString(parts[2]),convertString(parts[3]),convertString(parts[4]));
		}
		else if("circle".equals(parts[0]))
		{
			//System.out.println(parts[0]);
			shape = new Circle(convertString(parts[1]), convertString(parts[2]),convertString(parts[3]));
		}
		else if("rectangle".equals(parts[0]))
		{
			//System.out.println(parts[0]);
			shape = new Rectangle(convertString(parts[1]), convertString(parts[2]),convertString(parts[3]),convertString(parts[4]));
		}
		else if("square".equals(parts[0]))
		{
			//System.out.println(parts[0]);
			shape = new Square(convertString(parts[1]), convertString(parts[2]),convertString(parts[3]));
		}
		//composite,#;line, x, y, x, y;
		else if("composite".equals(parts[0]))//composite,# of shapes; shape, x1,y1,x2,y2;shape 
		{
			parts = input.split(";");
			String[] semiParts = parts[0].split(",");
			Composite master = new Composite();
			Deque<Pair<Composite, Integer>> deque = new ArrayDeque<Pair<Composite, Integer>>();
			
			deque.push(new Pair<>(master, Integer.parseInt(semiParts[1])));
			
			for(int i = 1; i<parts.length; i++)
			{
				String current = parts[i];
				//System.out.println(current);
				String[] terms = current.split(",");
				
				if("composite".equals(terms[0].trim()))
				{
					Composite subComposite = new Composite();
					deque.push(new Pair<>(subComposite, Integer.parseInt(terms[1])));
				}
				else
				{
					deque.peek().getKey().addShape(makeShape(current));
				}
				while(deque.peek().getKey().getShapes().size() == deque.peek().getValue() && deque.size()>1)
				{
					Pair<Composite,Integer> temp = deque.pop();
					deque.peek().getKey().addShape(temp.getKey());
				}
			}
			shape = master;
			
		}
		
		return shape;
	}	
	
}
