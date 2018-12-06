package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.jupiter.api.Test;

import commands.SolveCellCommand;
import sudokuAlgorithms.SolverManager;
import sudokuBoard.Cell;
import sudokuBoard.SudokuBoard;

public class SolveCellCommandTest {
	@Test
	public void testSolve4x4_0001_hint() throws Exception
	{
		
		String input = "src/resources/Puzzle-4x4-0001.txt";
		OutputStream oStream = new FileOutputStream("src/output/Puzzle-4x4-0001-output.txt");
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard solvedBoard = new SudokuBoard(iStream, oStream);
		SudokuBoard playerBoard = new SudokuBoard(solvedBoard);
		SolverManager solver = new SolverManager(solvedBoard);
		solver.solve();
		assertTrue(solver.isSolved());
		Cell[][] board = playerBoard.getBoard();
		assertEquals("-", board[0][1].getValue());
		SolveCellCommand solve = new SolveCellCommand(playerBoard,0, 1, "4");
		solve.execute();
		assertEquals("4", board[0][1].getValue());	
		solve = new SolveCellCommand(playerBoard,0,0,"4");
		solve.execute();
		assertEquals("2", board[0][0].getValue());
		solve = new SolveCellCommand(playerBoard,-1,-4,"z");
		solve = new SolveCellCommand(playerBoard,0,-4,"z");
		solve = new SolveCellCommand(playerBoard,0,1,"z");
		assertEquals("4", board[0][1].getValue());
		solve = new SolveCellCommand(playerBoard,9,9,"z");
		solve = new SolveCellCommand(playerBoard,0,9,"z");
		solve = new SolveCellCommand(playerBoard,0,1,"z");
		assertEquals("4", board[0][1].getValue());
	}
	
	@Test
	public void testSolve4x4_blank_hint() throws Exception
	{
		
		String input = "src/resources/Puzzle-4x4-blank.txt";
		OutputStream oStream = new FileOutputStream("src/output/Puzzle-4x4-blank-output.txt");
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard solvedBoard = new SudokuBoard(iStream, oStream);
		SudokuBoard playerBoard = new SudokuBoard(solvedBoard);
		SolverManager solver = new SolverManager(solvedBoard);
		solver.solve();
		assertTrue(solver.isSolved());
		Cell[][] board = playerBoard.getBoard();
		assertEquals("-", board[0][0].getValue());
		SolveCellCommand solve = new SolveCellCommand(playerBoard, 0, 0, "1");
		solve.execute();
		assertEquals("1", board[0][0].getValue());
	}
}
