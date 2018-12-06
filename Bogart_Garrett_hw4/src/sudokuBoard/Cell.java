	package sudokuBoard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Cell {
	private Set<String> set;
	private String value;
	private int row;
	private int col;
	private int region;
	private boolean original;
	
	public Cell(String value)
	{
		set = new HashSet<String>();
		this.value = value;
	}
	
	public Cell(String value, boolean isOriginal)
	{
		set = new HashSet<String>();
		this.value = value;
		original = isOriginal;
	}
	
	public String toString()
	{
		return value;
	}
	
	public void setValue(String value) 
	{
		this.value = value;
		set = new HashSet<String>();
	}
	
	public void setSet(HashSet<String> s)
	{
		set = new HashSet<String>(s);
	}
	
	public void setRow(int num) {row = num;}
	public void setCol(int num) {col = num;}
	public void setRegion(int num) {region = num;}
	public void setOriginal(boolean set) {original = set;}
	
	public Set<String> getSolutionSet(){return set;}
	public String getValue() {return value;}
	public int getRow() {return row;}
	public int getCol() {return col;}
	public int getRegion() {return region;}
	public boolean getOriginal() {return original;}
}
