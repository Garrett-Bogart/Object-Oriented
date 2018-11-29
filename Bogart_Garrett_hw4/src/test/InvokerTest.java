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
import commands.Invoker;
import commands.SolveCellCommand;
import commands.UndoCommand;
import sudokuAlgorithms.SolverManager;
import sudokuBoard.SudokuBoard;

public class InvokerTest {
	@Test
	public void testSolve4x4_0001_invoker() throws Exception
	{
		ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
		
		String input = "src/resources/Puzzle-4x4-0001.txt";
		OutputStream oStream = new FileOutputStream("src/output/Puzzle-4x4-0001-output.txt");
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard solvedBoard = new SudokuBoard(iStream, oStream);
		SudokuBoard playerBoard = new SudokuBoard(solvedBoard);
		SolverManager solver = new SolverManager(solvedBoard);
		Invoker invoke = new Invoker();
		solver.solve();
		assertTrue(solver.isSolved());
		
		SolveCellCommand solve = new SolveCellCommand(playerBoard, 0,0,"4");
		SolveCellCommand solve1 = new SolveCellCommand(playerBoard, 0,1,"4");
		SolveCellCommand solve2 = new SolveCellCommand(playerBoard, 0,2,"4");
		SolveCellCommand solve3 = new SolveCellCommand(playerBoard, 0,3,"4");
		System.setOut(new PrintStream(outputContent));
		invoke.execute(solve);
		assertEquals("4", playerBoard.getCell(0, 0).getValue());
		invoke.execute(solve1);
		assertEquals("4", playerBoard.getCell(0, 1).getValue());
		invoke.execute(solve2);
		assertEquals("4", playerBoard.getCell(0, 2).getValue());
		invoke.execute(solve3);
		assertEquals("4", playerBoard.getCell(0, 3).getValue());
		
		System.setOut(System.out);	
	}
	
	@Test
	public void testSolve4x4_0001_invoker_undo() throws Exception
	{
		
		String input = "src/resources/Puzzle-4x4-0001.txt";
		OutputStream oStream = new FileOutputStream("src/output/Puzzle-4x4-0001-output.txt");
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard solvedBoard = new SudokuBoard(iStream, oStream);
		SudokuBoard playerBoard = new SudokuBoard(solvedBoard);
		SolverManager solver = new SolverManager(solvedBoard);
		Invoker invoke = new Invoker();
		solver.solve();
		assertTrue(solver.isSolved());
		
		SolveCellCommand solve = new SolveCellCommand(playerBoard, 0,0,"4");
		SolveCellCommand solve1 = new SolveCellCommand(playerBoard, 0,1,"4");
		SolveCellCommand solve2 = new SolveCellCommand(playerBoard, 0,2,"4");
		SolveCellCommand solve3 = new SolveCellCommand(playerBoard, 0,3,"4");
		UndoCommand undo = new UndoCommand();
		
		invoke.execute(solve);
		assertEquals("4", playerBoard.getCell(0, 0).getValue());
		invoke.execute(solve1);
		assertEquals("4", playerBoard.getCell(0, 1).getValue());
		invoke.execute(solve2);
		assertEquals("4", playerBoard.getCell(0, 2).getValue());
		invoke.execute(solve3);
		assertEquals("4", playerBoard.getCell(0, 3).getValue());
		
		invoke.execute(undo);
		assertEquals("1",playerBoard.getCell(0, 3).getValue());
		invoke.execute(undo);
		assertEquals("3",playerBoard.getCell(0, 2).getValue());
		invoke.execute(undo);
		assertEquals("-",playerBoard.getCell(0, 1).getValue());
		invoke.execute(undo);
		assertEquals("2",playerBoard.getCell(0, 0).getValue());
		invoke.execute(undo);
	}
}
