package sudokuBoard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Cell {
	Set<String> set;
	String value;
	
	public Cell(String value)
	{
		set = new HashSet<String>();
		this.value = value;
	}
	
	public void updateSolutionSet(ArrayList<String> toBeRemoved)//might change to a single string
	{
		for(String s : toBeRemoved) 
		{
			set.remove(s);
		}
	}
	
	public String toString()
	{
		return value;
	}
	
	public void setValue(String value) 
	{
		this.value = value;
		set = null;
	}
	
	public void setSet(HashSet<String> s)
	{
		set = new HashSet<String>(s);
	}
	
	public Set<String> getSolutionSet(){return set;}
	public String getValue() {return value;}
}
