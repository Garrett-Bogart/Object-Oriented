package test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import sudokuAlgorithms.Guess;
import sudokuAlgorithms.SolverManager;
import sudokuBoard.Cell;
import sudokuBoard.SudokuBoard;

public class GuessTest {
	@Test
	public void testGetCells() throws Exception
	{
		String input = "src/resources/Puzzle-4x4-blank.txt";
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream);
		Guess solver = new Guess(board);
		ArrayList<Cell> found = solver.getCells(board.getBoard());
		for(Cell c : found)
		{
			assertEquals(4, c.getSolutionSet().size());
		}	
	}
	
	@Test
	public void testModifyCells() throws Exception
	{
		String input = "src/resources/Puzzle-4x4-blank.txt";
		Cell temp;
		Cell[][] gameBoard;
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream);
		Guess solver = new Guess(board);
		ArrayList<Cell> found = solver.getCells(board.getBoard());
		@SuppressWarnings("unused")
		ArrayList<Cell> modified = solver.modifyCells(found, board.getSize());
		gameBoard = board.getBoard();
		temp = gameBoard[0][0];
		assertEquals(1, solver.getDeque().size());
		assertEquals("[]", temp.getSolutionSet().toString());
		assertEquals("1", temp.getValue());
		for(Cell c: found)
		{
			if(c.getCol() != 0 && c.getRow() != 0)
				assertEquals(4, c.getSolutionSet().size());
		}
	}
	
	@Test
	public void testUpdateCells() throws Exception
	{
		String input = "src/resources/Puzzle-4x4-blank.txt";
		Cell temp;
		Cell[][] gameBoard;
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream);
		Guess solver = new Guess(board);
		ArrayList<Cell> found = solver.getCells(board.getBoard());
		ArrayList<Cell> modified = solver.modifyCells(found, board.getSize());
		gameBoard = board.getBoard();
		temp = gameBoard[0][1];
		solver.updateCells(board, modified);
		assertEquals("[2, 3, 4]", temp.getSolutionSet().toString());
		
		temp = gameBoard[0][2];
		assertEquals("[2, 3, 4]", temp.getSolutionSet().toString());
		
		temp = gameBoard[0][3];
		assertEquals("[2, 3, 4]", temp.getSolutionSet().toString());
		
		temp = gameBoard[1][0];
		assertEquals("[2, 3, 4]", temp.getSolutionSet().toString());
		
		temp = gameBoard[2][0];
		assertEquals("[2, 3, 4]", temp.getSolutionSet().toString());
		
		temp = gameBoard[2][0];
		assertEquals("[2, 3, 4]", temp.getSolutionSet().toString());
		
		temp = gameBoard[1][1];
		assertEquals("[2, 3, 4]", temp.getSolutionSet().toString());

	}
	
	@Test
	public void testGuess() throws Exception
	{
		String input = "src/resources/Puzzle-4x4-blank.txt";
		Cell temp;
		Cell[][] gameBoard;
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream);
		Guess solver = new Guess(board);
		ArrayList<Cell> found = solver.getCells(board.getBoard());
		ArrayList<Cell> modified = solver.modifyCells(found, board.getSize());
		gameBoard = board.getBoard();
		temp = gameBoard[0][1];
		solver.updateCells(board, modified);

		found = solver.getCells(board.getBoard());
		modified = solver.modifyCells(found, board.getSize());
		gameBoard = board.getBoard();
		temp = gameBoard[0][1];
		solver.updateCells(board, modified);
		
		assertEquals(2, solver.getDeque().size());
		assertEquals("2", temp.getValue());
	}
	
	@Test
	public void testSolve() throws Exception
	{
		String input = "src/resources/Puzzle-4x4-blank.txt";
		OutputStream oStream = new FileOutputStream("src/output/Puzzle-4x4-blank-test.txt");
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream, oStream);
		Guess solver = new Guess(board);
		SolverManager manager = new SolverManager(board);
		while(!manager.isSolved())
		{
			solver.solve(board);
		}
		board.outputBoard();
		
	}
}
