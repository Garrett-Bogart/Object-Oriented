package test;
import org.junit.Test;

import sudokuBoard.*;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

public class CellTest {
	
	@Test
	public void testCellConstructor()
	{
		Cell cell = new Cell("1");
		assertEquals("1", cell.getValue());
		cell = new Cell("-");
		assertEquals("-", cell.getValue());
	}
	
	@Test
	public void testCellSet()
	{
		String[] setValues = new String[]{"1","2","3","4"};
		Cell cell = new Cell("1");
		cell.getSolutionSet().addAll(Arrays.asList(setValues));
		assertEquals(cell.getSolutionSet().toString(), "[1, 2, 3, 4]");
		cell.getSolutionSet().add("4");
		assertEquals(cell.getSolutionSet().toString(), "[1, 2, 3, 4]");
	}
	
	@Test
	public void testRemoveSet()
	{
		String[] setValues = new String[]{"1","2","3","4"};
		Cell cell = new Cell("1");
		cell.getSolutionSet().addAll(Arrays.asList(setValues));
		assertEquals(cell.getSolutionSet().toString(), "[1, 2, 3, 4]");
		cell.getSolutionSet().remove("4");
		assertEquals(cell.getSolutionSet().toString(), "[1, 2, 3]");
	}
	
	@Test
	public void testSetSet()
	{
		Cell cell = new Cell("1");
		ArrayList<String> set = new ArrayList<String>();
		String[] setValues = new String[]{"1","2","3","4"};
		cell.getSolutionSet().addAll(Arrays.asList(setValues));
		assertEquals(cell.getSolutionSet().toString(), "[1, 2, 3, 4]");
		set.add("5");
		set.add("6");
		set.add("7");
		set.add("8");
		//cell.setSet(set);
		assertEquals(cell.getSolutionSet().toString(), "[5, 6, 7, 8]");
	}
	
	@Test
	public void testToString()
	{
		Cell cell = new Cell("-");
		assertEquals(cell.toString(),"-");
		cell = new Cell("dfasdfa");
		assertEquals(cell.toString(),"dfasdfa");
	}
	
	@Test
	public void testSetValue()
	{
		Cell cell = new Cell("-");
		assertEquals(cell.toString(),"-");
		cell.setValue("dfasdfa");
		assertEquals(cell.toString(),"dfasdfa");
		assertNull(cell.getSolutionSet());
	}
	
}
