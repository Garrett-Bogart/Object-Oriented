package test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import sudokuBoard.BoxSet;
import sudokuBoard.SudokuBoard;

public class BoxSetTest {
	@Test
	public void testRowSet() throws Exception
	{
		String input = "src/resources/Puzzle-4x4-0001.txt";
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		OutputStream oStream = System.out;
		SudokuBoard board = new SudokuBoard(iStream, oStream);
		BoxSet rows = board.getBoxes();
		String[] setValues = new String[]{"1","2","3"};
		Set<String> set = new HashSet<String>();
		set.addAll(Arrays.asList(setValues));
		rows.getSet(0).removeAll(set);
		assertEquals("[]",rows.getSet(0).toString());
		
		setValues = new String[]{"1","4","3"};
		set = new HashSet<String>();
		set.addAll(Arrays.asList(setValues));
		rows.getSet(1).removeAll(set);
		assertEquals("[]",rows.getSet(1).toString());
		
		setValues = new String[]{"1","2","3"};
		set = new HashSet<String>();
		set.addAll(Arrays.asList(setValues));
		rows.getSet(2).removeAll(set);
		assertEquals("[]",rows.getSet(2).toString());
		
		setValues = new String[]{"1","4","3"};
		set = new HashSet<String>();
		set.addAll(Arrays.asList(setValues));
		rows.getSet(3).removeAll(set);
		assertEquals("[]",rows.getSet(3).toString());
	}
}
