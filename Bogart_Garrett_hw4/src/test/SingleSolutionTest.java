package test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import sudokuAlgorithms.SingleSolution;
import sudokuAlgorithms.SudokuSolver;
import sudokuBoard.Cell;
import sudokuBoard.SudokuBoard;

public class SingleSolutionTest {
	@Test
	public void testGetCells() throws Exception
	{
		int count = 0;
		String[] expected = new String[] {"[4]","[2]","[2]","[4]"};
		String input = "src/resources/Puzzle-4x4-0001.txt";
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream);
		SudokuSolver solver = new SingleSolution();
		ArrayList<Cell> cells = solver.getCells(board.getBoard());
		assertEquals(4, cells.size());
		for(Cell c : cells)
		{
			assertEquals(1, c.getSolutionSet().size());
			assertEquals("-", c.getValue());
			assertEquals(expected[count],c.getSolutionSet().toString());
			count++;
		}
	}
	
	@Test
	public void testModifyCells() throws Exception
	{
		int count = 0;
		String[] expected = new String[] {"4","2","2","4"};
		String input = "src/resources/Puzzle-4x4-0001.txt";
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream);
		SudokuSolver solver = new SingleSolution();
		ArrayList<Cell> cells = solver.getCells(board.getBoard());
		ArrayList<Cell>modified = solver.modifyCells(cells, board.getSize());
		assertEquals(4, cells.size());
		for(Cell c : modified)
		{
			//assertEquals(1, c.getSolutionSet().size());
			assertEquals(expected[count], c.getValue());
			count++;
		}
	}
	
	@Test
	public void testUpdateCells() throws Exception
	{
		String file = "4\n"
				+ "2 4 3 1 \n"
				+ "1 3 2 4 \n"
				+ "3 1 4 2 \n"
				+ "4 2 1 3 \n";
		String input = "src/resources/Puzzle-4x4-0001.txt";
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream);
		SudokuSolver solver = new SingleSolution();
		ArrayList<Cell> cells = solver.getCells(board.getBoard());
		ArrayList<Cell>modified = solver.modifyCells(cells, board.getSize());
		solver.updateCells(board, modified);
		assertEquals(4, cells.size());
		assertEquals(file,board.toString());
	}
	
	@Test
	public void testSolve() throws Exception
	{
		String file = "4\n"
				+ "2 4 3 1 \n"
				+ "1 3 2 4 \n"
				+ "3 1 4 2 \n"
				+ "4 2 1 3 \n";
		String input = "src/resources/Puzzle-4x4-0001.txt";
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream);
		SudokuSolver solver = new SingleSolution();
		solver.solve(board);
		assertEquals(file,board.toString());
	}
}
