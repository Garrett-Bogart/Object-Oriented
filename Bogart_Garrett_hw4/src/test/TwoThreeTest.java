package test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import sudokuAlgorithms.SudokuSolver;
import sudokuAlgorithms.Twins;
import sudokuBoard.Cell;
import sudokuBoard.SudokuBoard;

public class TwoThreeTest {
	/*@Test
	public void testGetCells() throws Exception
	{
		String input = "src/resources/Puzzle-9x9-TwoThree.txt";
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream);
		SudokuSolver solver = new Twins();
		ArrayList<Cell> cells = solver.getCells(board.getBoard());
		assertEquals(35, cells.size());		
	}
	
	@Test
	public void testMakeRegion() throws Exception
	{
		String input = "src/resources/Puzzle-9x9-TwoThree.txt";
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream);
		Twins solver = new Twins();
		ArrayList<Cell> cells = solver.getCells(board.getBoard());
		ArrayList<Cell> region = solver.makeRegionList(cells, 0);
		assertEquals(2, region.size());
		
		region = solver.makeRegionList(cells, 1);
		assertEquals(4, region.size());		
		
		region = solver.makeRegionList(cells, 2);
		assertEquals(3, region.size());		
		
		region = solver.makeRegionList(cells, 3);
		assertEquals(5, region.size());		
		
		region = solver.makeRegionList(cells, 4);
		assertEquals(5, region.size());
		
		region = solver.makeRegionList(cells, 5);
		assertEquals(5, region.size());
		
		region = solver.makeRegionList(cells, 6);
		assertEquals(3, region.size());

		region = solver.makeRegionList(cells, 7);
		assertEquals(4, region.size());
		
		region = solver.makeRegionList(cells, 8);
		assertEquals(4, region.size());
	}
	
	@Test
	public void testModifyRegion() throws Exception
	{
		String input = "src/resources/Puzzle-9x9-TwoThree.txt";
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream);
		Twins solver = new Twins();
		Cell[][] c = board.getBoard();
		String[] setValues = new String[]{"3","8"};
		String[] setValues1 = new String[]{"1","3","8"};
		HashSet<String> set = new HashSet<String>();
		set.addAll(Arrays.asList(setValues));
		c[0][6].setSet(set);
		c[2][7].setSet(set);
		HashSet<String> set1 = new HashSet<String>();
		set1.addAll(Arrays.asList(setValues1));
		c[1][8].setSet(set1);
		ArrayList<Cell> cells = solver.getCells(board.getBoard());
		ArrayList<Cell> region = solver.makeRegionList(cells, 1);
		
		region = solver.makeRegionList(cells, 2);	
		solver.updateSubScript(region);
		assertEquals("[1]",c[1][8].getSolutionSet().toString());
	}*/
	
	@Test
	public void testTwins() throws Exception
	{
		String input = "src/resources/Puzzle-9x9-nakedTwin-test.txt";
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream);
		Twins solver = new Twins();
		ArrayList<Cell> cells = solver.getCells(board.getBoard());
		ArrayList<Cell> region = solver.makeRegionList(cells, 0);
		solver.updateSubScript(region);
		Cell[][] sBoard = board.getBoard();
		assertEquals("[5]",sBoard[0][2].getSolutionSet().toString());

	}
}
