package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import commands.HintCommand;
import commands.SolveCellCommand;
import sudokuAlgorithms.SolverManager;
import sudokuBoard.SudokuBoard;

public class HintCommandTest {

	@Test
	public void testSolve4x4_0001_hint() throws Exception
	{
		ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
		
		String input = "src/resources/Puzzle-4x4-0001.txt";
		OutputStream oStream = new FileOutputStream("src/output/Puzzle-4x4-0001-output.txt");
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard solvedBoard = new SudokuBoard(iStream, oStream);
		SudokuBoard playerBoard = new SudokuBoard(solvedBoard);
		SolverManager solver = new SolverManager(solvedBoard);
		solver.solve();
		assertTrue(solver.isSolved());
		
		
		HintCommand hint = new HintCommand(playerBoard, solvedBoard);
		System.setOut(new PrintStream(outputContent));
		hint.execute();
		assertEquals("Errors: 0\nHint: row: 0 col: 1 value: 4", outputContent.toString());
		
		System.setOut(System.out);		
	}
	
	@Test
	public void testSolve4x4_0001_hint_erros() throws Exception
	{
		ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
		
		String input = "src/resources/Puzzle-4x4-0001.txt";
		OutputStream oStream = new FileOutputStream("src/output/Puzzle-4x4-0001-output.txt");
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard solvedBoard = new SudokuBoard(iStream, oStream);
		SudokuBoard playerBoard = new SudokuBoard(solvedBoard);
		SolverManager solver = new SolverManager(solvedBoard);
		solver.solve();
		assertTrue(solver.isSolved());
		
		SolveCellCommand solve = new SolveCellCommand(playerBoard, 0,0,"4");
		SolveCellCommand solve1 = new SolveCellCommand(playerBoard, 0,1,"4");
		SolveCellCommand solve2 = new SolveCellCommand(playerBoard, 0,2,"4");
		SolveCellCommand solve3 = new SolveCellCommand(playerBoard, 0,3,"4");
		HintCommand hint = new HintCommand(playerBoard, solvedBoard);
		System.setOut(new PrintStream(outputContent));
		solve.execute();
		assertEquals("4", playerBoard.getCell(0, 0).getValue());
		solve1.execute();
		assertEquals("4", playerBoard.getCell(0, 1).getValue());
		solve2.execute();
		assertEquals("4", playerBoard.getCell(0, 2).getValue());
		solve3.execute();
		assertEquals("4", playerBoard.getCell(0, 3).getValue());
		hint.execute();
		
		assertEquals("Errors: 3\n" + 
				"Error occured at row: 0 col: 0\n" + 
				"Error occured at row: 0 col: 2\n" + 
				"Error occured at row: 0 col: 3\n" +
				"Hint: row: 1 col: 2 value: 2", outputContent.toString());
		
		System.setOut(System.out);	
	}
}
