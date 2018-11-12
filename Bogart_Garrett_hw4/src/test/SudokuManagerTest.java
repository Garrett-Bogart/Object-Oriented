package test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
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
		assertTrue(!solver.isSolved());
		
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
	
	/*@Test
	public void testSolve9x9_0102() throws Exception
	{
		String input = "src/resources/Puzzle-9x9-0102.txt";
		OutputStream oStream = new FileOutputStream("src/output/Puzzle-9x9-0102-output.txt");
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream, oStream);
		SolverManager solver = new SolverManager(board);
		solver.solve();
		assertTrue(solver.isSolved());		
	}*/
}
