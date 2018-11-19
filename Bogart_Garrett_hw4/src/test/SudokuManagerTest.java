package test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.jupiter.api.Test;

import sudokuAlgorithms.SolverManager;
import sudokuBoard.SudokuBoard;

public class SudokuManagerTest {
	@Test
	public void testSolve4x4_0001() throws Exception
	{
		String input = "src/resources/Puzzle-4x4-0001.txt";
		OutputStream oStream = new FileOutputStream("src/output/Puzzle-4x4-0001-output.txt");
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream, oStream);
		SolverManager solver = new SolverManager(board);
		solver.solve();
		assertTrue(solver.isSolved());
		
	}
	
	@Test
	public void testSolve4x4_0002() throws Exception
	{
		String input = "src/resources/Puzzle-4x4-0002.txt";
		OutputStream oStream = new FileOutputStream("src/output/Puzzle-4x4-0002-output.txt");
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream, oStream);
		SolverManager solver = new SolverManager(board);
		solver.solve();
		assertTrue(solver.isSolved());
		
	}
	
	@Test
	public void testSolve4x4_0101() throws Exception
	{
		String input = "src/resources/Puzzle-4x4-0101.txt";
		OutputStream oStream = new FileOutputStream("src/output/Puzzle-4x4-0101-output.txt");
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream, oStream);
		SolverManager solver = new SolverManager(board);
		solver.solve();
		assertTrue(solver.isSolved());
		
	}
	
	@Test
	public void testSolve4x4_0201() throws Exception
	{
		String input = "src/resources/Puzzle-4x4-0201.txt";
		OutputStream oStream = new FileOutputStream("src/output/Puzzle-4x4-0201-output.txt");
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream, oStream);
		SolverManager solver = new SolverManager(board);
		solver.solve();
		assertTrue(solver.isSolved());
		
	}
	
	@Test
	public void testSolve4x4_0901() throws Exception
	{
		String input = "src/resources/Puzzle-4x4-0901.txt";
		OutputStream oStream = new FileOutputStream("src/output/Puzzle-4x4-0901-output.txt");
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		try
		{
			SudokuBoard board = new SudokuBoard(iStream, oStream);
			board.getBoard();
			fail();
		}
		catch(Exception e)
		{
			//ignore
		}
	}
	
	@Test
	public void testSolve4x4_0902() throws Exception
	{
		String input = "src/resources/Puzzle-4x4-0902.txt";
		OutputStream oStream = new FileOutputStream("src/output/Puzzle-4x4-0902-output.txt");
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream,oStream);
		SolverManager solver = new SolverManager(board);
		solver.solve();
		assertTrue(solver.isSolved());		
	}
	
	@Test
	public void testSolve4x4_0903() throws Exception
	{
		//TODO need validation for rows, columns, regions		
	}
	
	@Test
	public void testSolve9x9_0001() throws Exception
	{
		String input = "src/resources/Puzzle-9x9-0001.txt";
		OutputStream oStream = new FileOutputStream("src/output/Puzzle-9x9-0001-output.txt");
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream, oStream);
		SolverManager solver = new SolverManager(board);
		solver.solve();
		assertTrue(solver.isSolved());
		
	}
	
	@Test
	public void testSolve9x9_0002() throws Exception
	{
		String input = "src/resources/Puzzle-9x9-0002.txt";
		OutputStream oStream = new FileOutputStream("src/output/Puzzle-9x9-0002-output.txt");
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream, oStream);
		SolverManager solver = new SolverManager(board);
		solver.solve();
		assertTrue(solver.isSolved());		
	}
	
	@Test
	public void testSolve9x9_nakedTwin_test() throws Exception
	{
		String input = "src/resources/Puzzle-9x9-nakedTwin-test.txt";
		OutputStream oStream = new FileOutputStream("src/output/Puzzle-9x9-nakedTwin-test.txt");
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream, oStream);
		SolverManager solver = new SolverManager(board);
		solver.solve();	
	}
	
	@Test
	public void testSolve9x9_0101() throws Exception
	{
		String input = "src/resources/Puzzle-9x9-0101.txt";
		OutputStream oStream = new FileOutputStream("src/output/Puzzle-9x9-0101-output.txt");
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream, oStream);
		SolverManager solver = new SolverManager(board);
		solver.solve();	
	}
	
	@Test
	public void test9x9_0101() throws FileNotFoundException
	{
		String input = "src/output/Puzzle-9x9-0101-output.txt";
		String output = "src/output/Puzzle-9x9-0101-validation.txt";
		OutputStream oStream = new FileOutputStream(output);
		final InputStream iStream = new ByteArrayInputStream(input.getBytes());
		try
		{
			@SuppressWarnings("unused")
			SudokuBoard board = new SudokuBoard(iStream, oStream);
		}catch(Exception e)
		{
		}
		
	}
	@Test
	public void testSolve9x9_0102() throws Exception
	{
		String input = "src/resources/Puzzle-9x9-0102.txt";
		OutputStream oStream = new FileOutputStream("src/output/Puzzle-9x9-0102-output.txt");
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream, oStream);
		SolverManager solver = new SolverManager(board);
		solver.solve();	
	}
	@Test
	public void test9x9_0102() throws FileNotFoundException
	{
		String input = "src/output/Puzzle-9x9-0102-output.txt";
		String output = "src/output/Puzzle-9x9-0102-validation.txt";
		OutputStream oStream = new FileOutputStream(output);
		final InputStream iStream = new ByteArrayInputStream(input.getBytes());
		try
		{
			@SuppressWarnings("unused")
			SudokuBoard board = new SudokuBoard(iStream, oStream);
		}catch(Exception e)
		{
		}
		
	}
	
	@Test
	public void testSolve9x9_0103() throws Exception
	{
		String input = "src/resources/Puzzle-9x9-0103.txt";
		OutputStream oStream = new FileOutputStream("src/output/Puzzle-9x9-0103-output.txt");
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream, oStream);
		SolverManager solver = new SolverManager(board);
		solver.solve();	
	}
	
	@Test
	public void testSolve9x9_0201() throws Exception
	{
		String input = "src/resources/Puzzle-9x9-0201.txt";
		OutputStream oStream = new FileOutputStream("src/output/Puzzle-9x9-0201-output.txt");
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream, oStream);
		SolverManager solver = new SolverManager(board);
		solver.solve();	
	}
	
	@Test
	public void testSolve9x9_0203() throws Exception
	{
		String input = "src/resources/Puzzle-9x9-0203.txt";
		OutputStream oStream = new FileOutputStream("src/output/Puzzle-9x9-0203-output.txt");
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream, oStream);
		SolverManager solver = new SolverManager(board);
		solver.solve();	
	}
	
	@Test
	public void testSolve9x9_0204() throws Exception
	{
		String input = "src/resources/Puzzle-9x9-0204.txt";
		OutputStream oStream = new FileOutputStream("src/output/Puzzle-9x9-0204-output.txt");
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream, oStream);
		SolverManager solver = new SolverManager(board);
		solver.solve();	
	}
	
	@Test
	public void testSolve9x9_0205() throws Exception
	{
		String input = "src/resources/Puzzle-9x9-0205.txt";
		OutputStream oStream = new FileOutputStream("src/output/Puzzle-9x9-0205-output.txt");
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream, oStream);
		SolverManager solver = new SolverManager(board);
		solver.solve();	
	}
	
	@Test
	public void testSolve9x9_0206() throws Exception
	{
		String input = "src/resources/Puzzle-9x9-0206.txt";
		OutputStream oStream = new FileOutputStream("src/output/Puzzle-9x9-0206-output.txt");
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream, oStream);
		SolverManager solver = new SolverManager(board);
		solver.solve();	
	}
	
	@Test
	public void testSolve9x9_0301() throws Exception
	{
		String input = "src/resources/Puzzle-9x9-0301.txt";
		OutputStream oStream = new FileOutputStream("src/output/Puzzle-9x9-0301-output.txt");
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream, oStream);
		SolverManager solver = new SolverManager(board);
		solver.solve();	
	}
	
	@Test
	public void testSolve9x9_0302() throws Exception
	{
		String input = "src/resources/Puzzle-9x9-0302.txt";
		OutputStream oStream = new FileOutputStream("src/output/Puzzle-9x9-0302-output.txt");
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream, oStream);
		SolverManager solver = new SolverManager(board);
		solver.solve();	
	}
	
	@Test
	public void testSolve9x9_0401() throws Exception
	{
		String input = "src/resources/Puzzle-9x9-0401.txt";
		OutputStream oStream = new FileOutputStream("src/output/Puzzle-9x9-0401-output.txt");
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream, oStream);
		SolverManager solver = new SolverManager(board);
		solver.solve();	
	}
	
	@Test
	public void testSolve9x9_0901() throws Exception
	{
		String input = "src/resources/Puzzle-9x9-0901.txt";
		OutputStream oStream = new FileOutputStream("src/output/Puzzle-9x9-0901-output.txt");
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream, oStream);
		SolverManager solver = new SolverManager(board);
		solver.solve();	
	}
	
	@Test
	public void testSolve16x16_0001() throws Exception
	{
		String input = "src/resources/Puzzle-16x16-0001.txt";
		OutputStream oStream = new FileOutputStream("src/output/Puzzle-16x16-0001-output.txt");
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream, oStream);
		SolverManager solver = new SolverManager(board);
		solver.solve();	
	}
	
	@Test
	public void testSolve16x16_0002() throws Exception
	{
		String input = "src/resources/Puzzle-16x16-0002.txt";
		OutputStream oStream = new FileOutputStream("src/output/Puzzle-16x16-0002-output.txt");
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream, oStream);
		SolverManager solver = new SolverManager(board);
		solver.solve();	
	}
	
	@Test
	public void testSolve16x16_0101() throws Exception
	{
		String input = "src/resources/Puzzle-16x16-0101.txt";
		OutputStream oStream = new FileOutputStream("src/output/Puzzle-16x16-0101-output.txt");
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream, oStream);
		SolverManager solver = new SolverManager(board);
		solver.solve();	
	}
	
	@Test
	public void testSolve16x16_0201() throws Exception
	{
		String input = "src/resources/Puzzle-16x16-0201.txt";
		OutputStream oStream = new FileOutputStream("src/output/Puzzle-16x16-0201-output.txt");
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream, oStream);
		SolverManager solver = new SolverManager(board);
		solver.solve();	
	}

	@Test
	public void testSolve16x16_0301() throws Exception
	{
		String input = "src/resources/Puzzle-16x16-0301.txt";
		OutputStream oStream = new FileOutputStream("src/output/Puzzle-16x16-0301-output.txt");
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream, oStream);
		SolverManager solver = new SolverManager(board);
		solver.solve();	
	}
	
	@Test
	public void testSolve16x16_0401() throws Exception
	{
		String input = "src/resources/Puzzle-16x16-0401.txt";
		OutputStream oStream = new FileOutputStream("src/output/Puzzle-16x16-0401-output.txt");
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream, oStream);
		SolverManager solver = new SolverManager(board);
		solver.solve();	
	}
	
	@Test
	public void testSolve16x16_0901() throws Exception
	{
		String input = "src/resources/Puzzle-16x16-0901.txt";
		OutputStream oStream = new FileOutputStream("src/output/Puzzle-16x16-0901-output.txt");
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream, oStream);
		SolverManager solver = new SolverManager(board);
		solver.solve();	
	}
	
	@Test
	public void testSolve16x16_0902() throws Exception
	{
		String input = "src/resources/Puzzle-16x16-0902.txt";
		OutputStream oStream = new FileOutputStream("src/output/Puzzle-16x16-0902-output.txt");
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream, oStream);
		SolverManager solver = new SolverManager(board);
		solver.solve();	
	}
	
	@Test
	public void testSolve25x25_0101() throws Exception
	{
		String input = "src/resources/Puzzle-25x25-0101.txt";
		OutputStream oStream = new FileOutputStream("src/output/Puzzle-25x25-0101-output.txt");
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream, oStream);
		SolverManager solver = new SolverManager(board);
		solver.solve();	
	}
	
	@Test
	public void testSolve25x25_0901() throws Exception
	{
		String input = "src/resources/Puzzle-25x25-0901.txt";
		OutputStream oStream = new FileOutputStream("src/output/Puzzle-25x25-0901-output.txt");
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		
		try
		{
			SudokuBoard board = new SudokuBoard(iStream, oStream);
			SolverManager solver = new SolverManager(board);
			solver.solve();
		}
		catch(Exception e)
		{
			//two fives in row five
		}
	
	}
	
	@Test
	public void testSolve25x25_0902() throws Exception
	{
		String input = "src/resources/Puzzle-25x25-0902.txt";
		OutputStream oStream = new FileOutputStream("src/output/Puzzle-25x25-0902-output.txt");
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		
		try
		{
			SudokuBoard board = new SudokuBoard(iStream, oStream);
			SolverManager solver = new SolverManager(board);
			solver.solve();
		}
		catch(Exception e)
		{
			//0 instead of O
		}
	
	}
	
	@Test
	public void testSolve25x25_0903() throws Exception
	{
		String input = "src/resources/Puzzle-25x25-0903.txt";
		OutputStream oStream = new FileOutputStream("src/output/Puzzle-25x25-0903-output.txt");
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		

			SudokuBoard board = new SudokuBoard(iStream, oStream);
			SolverManager solver = new SolverManager(board);
			solver.solve();

	
	}
	
	@Test
	public void testSolve25x25_0904() throws Exception
	{
		String input = "src/resources/Puzzle-25x25-0904.txt";
		OutputStream oStream = new FileOutputStream("src/output/Puzzle-25x25-0904-output.txt");
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		
		try 
		{
			SudokuBoard board = new SudokuBoard(iStream, oStream);
			SolverManager solver = new SolverManager(board);
			solver.solve();
		}
		catch(Exception e)
		{
			//0 instead of O
		}

	
	}
	
}
