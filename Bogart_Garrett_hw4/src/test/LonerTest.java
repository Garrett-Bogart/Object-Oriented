package test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import sudokuAlgorithms.Loner;
import sudokuAlgorithms.SudokuSolver;
import sudokuAlgorithms.Twins;
import sudokuBoard.Cell;
import sudokuBoard.SudokuBoard;

public class LonerTest {
	@Test
	public void testGetCells() throws Exception
	{
		String input = "src/resources/Puzzle-4x4-blank.txt";
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream);
		SudokuSolver solver = new Loner();
		ArrayList<Cell> cells = solver.getCells(board.getBoard());
		assertEquals(16, cells.size());		
	}
	
	@Test
	public void testMakeRegion() throws Exception
	{
		String input = "src/resources/Puzzle-4x4-blank.txt";
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard board = new SudokuBoard(iStream);
		Loner solver = new Loner();
		Cell[][] gameBoard = board.getBoard();
		String[] setValues = new String[]{"4"};
		Set<String> set = new HashSet<String>();
		set.addAll(Arrays.asList(setValues));
		gameBoard[0][1].getSolutionSet().removeAll(set);
		gameBoard[0][2].getSolutionSet().removeAll(set);
		gameBoard[0][3].getSolutionSet().removeAll(set);
		solver.solve(board);
		assertEquals("[4]",gameBoard[0][0].getSolutionSet().toString());
	}
	
	/*@Test
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

	}*/
}
