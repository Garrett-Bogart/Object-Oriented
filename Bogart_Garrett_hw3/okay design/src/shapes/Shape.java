package shapes;

import java.io.FileWriter;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

abstract public class Shape {
	protected ArrayList<Point> points;
	protected double scalingFactor;
	
	public Shape()
	{
		this.points = new ArrayList<Point>();
		this.scalingFactor = 1;		
	}
	
	
	public ArrayList<Point> getPoints() {return points;}
	abstract public double computeArea() throws ShapeException;
	public void move(double deltaX, double deltaY) throws ShapeException
	{
		for(Point point : points)
		{
			point.move(deltaX, deltaY);
		}
	}
	abstract public void scale(double scalingFactor) throws ShapeException;
	public void add(Point point) {this.points.add(point);}
	public Point getPoint1() throws ShapeException  {return this.points.get(0);}
	public Point getPoint2() throws ShapeException  {return this.points.get(1);}
	public Point getPoint3() throws ShapeException  {return this.points.get(2);}
	public Point getPoint4() throws ShapeException {return this.points.get(3);}
	abstract public String toString();
	abstract public boolean equals(Shape shape) throws ShapeException;
	public void saveShape(OutputStream output)
	{
		PrintWriter out = new PrintWriter(output);
		out.print(this.toString());
		out.close();	
	}

	
	
}
