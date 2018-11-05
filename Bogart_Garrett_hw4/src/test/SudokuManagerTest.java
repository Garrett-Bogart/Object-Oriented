package test;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

import sudokuAlgorithms.SolverManager;
import sudokuBoard.SudokuBoard;

public class SudokuManagerTest {
	/*@Test
	public void testSolve4x4() throws Exception
	{
		String input = "src/resources/Puzzle-4x4-0001.txt";
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream);
		SolverManager solver = new SolverManager(board);
		solver.solve();
		assertTrue(solver.isSolved());
		
	}*/
	
	@Test
	public void testSolve9x9() throws Exception
	{
		String input = "src/resources/Puzzle-9x9-0001.txt";
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream);
		SolverManager solver = new SolverManager(board);
		solver.solve();
		assertTrue(solver.isSolved());
		
	}
}
