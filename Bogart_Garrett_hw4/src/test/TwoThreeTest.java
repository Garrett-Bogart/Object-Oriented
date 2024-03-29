package test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;


import org.junit.jupiter.api.Test;

import sudokuAlgorithms.SudokuSolver;
import sudokuAlgorithms.Twins;
import sudokuBoard.Cell;
import sudokuBoard.SudokuBoard;

public class TwoThreeTest {
	@Test
	public void testGetCells() throws Exception
	{
		String input = "src/resources/Puzzle-9x9-nakedTwin-test.txt";
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream);
		SudokuSolver solver = new Twins();
		ArrayList<Cell> cells = solver.getCells(board.getBoard());
		assertEquals(36, cells.size());		
	}
	
	@Test
	public void testMakeRegion() throws Exception
	{
		String input = "src/resources/Puzzle-9x9-nakedTwin-test.txt";
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream);
		Twins solver = new Twins();
		ArrayList<Cell> cells = solver.getCells(board.getBoard());
		ArrayList<Cell> region = solver.makeRegionList(cells, 0);
		assertEquals(5, region.size());
		
		region = solver.makeRegionList(cells, 1);
		assertEquals(0, region.size());		
		
		region = solver.makeRegionList(cells, 2);
		assertEquals(5, region.size());		
		
		region = solver.makeRegionList(cells, 3);
		assertEquals(5, region.size());		
		
		region = solver.makeRegionList(cells, 4);
		assertEquals(2, region.size());
		
		region = solver.makeRegionList(cells, 5);
		assertEquals(6, region.size());
		
		region = solver.makeRegionList(cells, 6);
		assertEquals(6, region.size());

		region = solver.makeRegionList(cells, 7);
		assertEquals(3, region.size());
		
		region = solver.makeRegionList(cells, 8);
		assertEquals(4, region.size());
	}
	
	@Test
	public void testTwins() throws Exception
	{
		String input = "src/resources/Puzzle-9x9-nakedTwin-test.txt";
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream);
		Twins solver = new Twins();
		ArrayList<Cell> cells = solver.getCells(board.getBoard());
		ArrayList<Cell> region = solver.makeRegionList(cells, 0);
		ArrayList<Cell> row = solver.makeRowList(cells, 2);
		solver.updateSubScript(region);
		solver.updateSubScript(row);
		Cell[][] sBoard = board.getBoard();
		assertEquals("[5]",sBoard[0][2].getSolutionSet().toString());
		assertEquals("[3, 4]",sBoard[2][6].getSolutionSet().toString());
		assertEquals("[4]",sBoard[2][8].getSolutionSet().toString());

	}
}
