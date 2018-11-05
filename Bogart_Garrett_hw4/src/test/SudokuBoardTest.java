package test;
import org.junit.Test;

import sudokuBoard.*;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SudokuBoardTest {
	
	@Test
	public void testConstructor() throws Exception
	{
		String file = "4\n"
				+ "2 - 3 1 \n"
				+ "1 3 - 4 \n"
				+ "3 1 4 - \n"
				+ "- 2 1 3 \n";
		String input = "src/resources/Puzzle-4x4-0001.txt";
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream);
		assertEquals(board.toString(), file);		
	}
	
	@Test
	public void testMakeBoard() throws Exception
	{
		String input = "src/resources/Puzzle-4x4-0001.txt";
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream);
		String file = "4\n"
				+ "2 - 3 1 \n"
				+ "1 3 - 4 \n"
				+ "3 1 4 - \n"
				+ "- 2 1 3 \n";
		board.setSize(-1);
		board.makeBoard(input);
		assertEquals(board.toString(), file);		
	}
	
	@Test
	public void testGetters() throws Exception
	{
		String input = "src/resources/Puzzle-4x4-0001.txt";
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream);
		String[] setValues = new String[]{"1","2","3","4", "-"};
		Set<String> set = new HashSet<String>();
		set.addAll(Arrays.asList(setValues));
		assertEquals(board.getSize(), 4);	
		assertEquals(board.getSet(),set);
	}
	
	@Test
	public void testInvalidConstructors() throws IOException
	{
		String input = "src/resources/Puzzle-4x4-test-****.txt";
		final InputStream iStream = new ByteArrayInputStream(input.getBytes());
		assertThrows(IOException.class,()->{new SudokuBoard(iStream);});
		
		input = "src/resources/Puzzle-4x4-test-0001.txt";
		final InputStream iStream1 = new ByteArrayInputStream(input.getBytes());
		assertThrows(IOException.class,()->{new SudokuBoard(iStream1);});

		input = "src/resources/Puzzle-4x4-test-0002.txt";
		final InputStream iStream2 = new ByteArrayInputStream(input.getBytes());
		assertThrows(IOException.class,()->{new SudokuBoard(iStream2);});
		
		input = "src/resources/Puzzle-4x4-test-0003.txt";
		final InputStream iStream3 = new ByteArrayInputStream(input.getBytes());		
		assertThrows(Exception.class,()->{new SudokuBoard(iStream3);});
		
		input = "src/resources/Puzzle-4x4-test-0004.txt";
		final InputStream iStream4 = new ByteArrayInputStream(input.getBytes());
		assertThrows(IllegalArgumentException.class,()->{new SudokuBoard(iStream4);});
		
		input = "src/resources/Puzzle-4x4-test-0005.txt";
		final InputStream iStream5 = new ByteArrayInputStream(input.getBytes());
		assertThrows(IllegalArgumentException.class,()->{new SudokuBoard(iStream5);});

	}
	
	@Test
	public void testGetBoard() throws Exception
	{
		String input = "src/resources/Puzzle-4x4-0001.txt";
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		InputStream iStream1 = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream);
		SudokuBoard board1 = new SudokuBoard(iStream1);
		for(int i = 0; i < board.getSize();i++)
		{
			for(int j =0; j < board.getSize(); j++)
			{
				if(!(board.getBoard()[i][j].getValue().equals(board1.getBoard()[i][j].getValue())))
				{
					fail("values of board were not the same");
				}
			}
		}
	}
	
	@Test
	public void testCellSet() throws Exception
	{
		String input = "src/resources/Puzzle-9x9-0001.txt";
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream);
		Cell[][] cells = board.getBoard();
		/*assertEquals("[]", cells[2][2].getSolutionSet().toString());
		assertEquals("[4]", cells[0][1].getSolutionSet().toString());
		assertEquals("[2]", cells[1][2].getSolutionSet().toString());
		assertEquals("[2]", cells[2][3].getSolutionSet().toString());
		assertEquals("[4]", cells[3][0].getSolutionSet().toString());
		
		board = new SudokuBoard("src/resources/Puzzle-9x9-0001.txt");*/
		cells = board.getBoard();
		assertEquals("[5]", cells[0][7].getSolutionSet().toString());
	}
	
	@Test
	public void testGetRegion() throws Exception
	{
		String input = "src/resources/Puzzle-9x9-0001.txt";
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream);
		assertEquals(0,board.getRegion(0, 0));
		assertEquals(0,board.getRegion(1, 1));
		assertEquals(0,board.getRegion(2, 2));
		assertEquals(1,board.getRegion(0, 3));
		assertEquals(1,board.getRegion(1, 4));
		assertEquals(1,board.getRegion(2, 5));
		assertEquals(2,board.getRegion(0, 6));
		assertEquals(2,board.getRegion(1, 7));
		assertEquals(2,board.getRegion(2, 8));
		
		assertEquals(3,board.getRegion(3, 0));
		assertEquals(3,board.getRegion(4, 1));
		assertEquals(3,board.getRegion(5, 2));
		assertEquals(4,board.getRegion(3, 3));
		assertEquals(4,board.getRegion(4, 4));
		assertEquals(4,board.getRegion(5, 5));
		assertEquals(5,board.getRegion(3, 6));
		assertEquals(5,board.getRegion(4, 7));
		assertEquals(5,board.getRegion(5, 8));
		
		assertEquals(6,board.getRegion(6, 0));
		assertEquals(6,board.getRegion(7, 1));
		assertEquals(6,board.getRegion(8, 2));
		assertEquals(7,board.getRegion(6, 3));
		assertEquals(7,board.getRegion(7, 4));
		assertEquals(7,board.getRegion(8, 5));
		assertEquals(8,board.getRegion(6, 6));
		assertEquals(8,board.getRegion(7, 7));
		assertEquals(8,board.getRegion(8, 8));
	}
	
}
