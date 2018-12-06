package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import commands.Client;
import commands.Command;
import commands.HintCommand;
import commands.SolveCellCommand;
import commands.UndoCommand;
import sudokuAlgorithms.SolverManager;
import sudokuBoard.SudokuBoard;

public class ClientTest {
	
	@Test
	public void testSolve4x4_0001_client_make_solveCell() throws Exception
	{
		ByteArrayInputStream in = new ByteArrayInputStream("solve\n0\n0\n4\n".getBytes());
		System.setIn(in);
		String input = "src/resources/Puzzle-4x4-0001.txt";
		OutputStream oStream = new FileOutputStream("src/output/Puzzle-4x4-0001-output.txt");
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard solvedBoard = new SudokuBoard(iStream, oStream);
		SudokuBoard playerBoard = new SudokuBoard(solvedBoard);
		SolverManager solver = new SolverManager(solvedBoard);
		Client client = new Client(playerBoard, solvedBoard);
		solver.solve();
		assertTrue(solver.isSolved());
		assertTrue(client.makeCommand() instanceof SolveCellCommand);
		
		System.setIn(System.in);
	}
	
	@Test
	public void testSolve4x4_0001_client_execute_SolveCell() throws Exception
	{
		ByteArrayInputStream in = new ByteArrayInputStream("solve\n0\n1\n4\n".getBytes());
		System.setIn(in);
		String input = "src/resources/Puzzle-4x4-0001.txt";
		OutputStream oStream = new FileOutputStream("src/output/Puzzle-4x4-0001-output.txt");
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard solvedBoard = new SudokuBoard(iStream, oStream);
		SudokuBoard playerBoard = new SudokuBoard(solvedBoard);
		SolverManager solver = new SolverManager(solvedBoard);
		Client client = new Client(playerBoard, solvedBoard);
		solver.solve();
		assertTrue(solver.isSolved());
		
		Command command;
		command = client.makeCommand();
		command.execute();
		
		assertEquals("4", playerBoard.getCell(0, 1).getValue());
		
		System.setIn(System.in);
	}
	
	@Test
	public void testSolve4x4_0001_client_make_Hint() throws Exception
	{
		ByteArrayInputStream in = new ByteArrayInputStream("hint".getBytes());
		
		
		System.setIn(in);
		String input = "src/resources/Puzzle-4x4-0001.txt";
		OutputStream oStream = new FileOutputStream("src/output/Puzzle-4x4-0001-output.txt");
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard solvedBoard = new SudokuBoard(iStream, oStream);
		SudokuBoard playerBoard = new SudokuBoard(solvedBoard);
		SolverManager solver = new SolverManager(solvedBoard);
		Client client = new Client(playerBoard, solvedBoard);
		solver.solve();
		assertTrue(solver.isSolved());
		
		assertTrue(client.makeCommand() instanceof HintCommand);
		
		System.setIn(System.in);
	}
	
	@Test
	public void testSolve4x4_0001_client_execute_Hint() throws Exception
	{
		ByteArrayInputStream in = new ByteArrayInputStream("hint".getBytes());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		System.setIn(in);
		System.setOut(new PrintStream(out));
		String input = "src/resources/Puzzle-4x4-0001.txt";
		OutputStream oStream = new FileOutputStream("src/output/Puzzle-4x4-0001-output.txt");
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard solvedBoard = new SudokuBoard(iStream, oStream);
		SudokuBoard playerBoard = new SudokuBoard(solvedBoard);
		SolverManager solver = new SolverManager(solvedBoard);
		Client client = new Client(playerBoard, solvedBoard);
		solver.solve();
		assertTrue(solver.isSolved());
		
		Command command;
		command = client.makeCommand();
		command.execute();
		
		assertEquals("Errors: 0\nHint: row: 0 col: 1 value: 4", out.toString());
		
		System.setOut(System.out);
		System.setIn(System.in);
	}
	
	@Test
	public void testSolve4x4_0001_client_make_Undo() throws Exception
	{
		ByteArrayInputStream in = new ByteArrayInputStream("undo".getBytes());
		
		
		System.setIn(in);
		String input = "src/resources/Puzzle-4x4-0001.txt";
		OutputStream oStream = new FileOutputStream("src/output/Puzzle-4x4-0001-output.txt");
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard solvedBoard = new SudokuBoard(iStream, oStream);
		SudokuBoard playerBoard = new SudokuBoard(solvedBoard);
		SolverManager solver = new SolverManager(solvedBoard);
		Client client = new Client(playerBoard, solvedBoard);
		solver.solve();
		assertTrue(solver.isSolved());
		
		assertTrue(client.makeCommand() instanceof UndoCommand);
		
		System.setIn(System.in);
	}
	
	@Test
	public void testSolve9x9_0001_client_start() throws Exception
	{
		final FileInputStream in = new FileInputStream(new File("src/resources/input_client_start.txt"));
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		System.setIn(in);
		System.setOut(new PrintStream(out));;
		String input = "src/resources/Puzzle-9x9-0001.txt";
		OutputStream oStream = new FileOutputStream("src/output/Puzzle-9x9-0001-output.txt");
		InputStream iStream = new ByteArrayInputStream(input.getBytes());
		SudokuBoard solvedBoard = new SudokuBoard(iStream, oStream);
		SudokuBoard playerBoard = new SudokuBoard(solvedBoard);
		SolverManager solver = new SolverManager(solvedBoard);
		Client client = new Client(playerBoard, solvedBoard);
		solver.solve();
		assertTrue(solver.isSolved());
		
		client.start();
		assertEquals("2", playerBoard.getCell(0, 2).getValue());
		
		client.start();
		assertEquals("-", playerBoard.getCell(0, 2).getValue());
		
		client.start();

		client.start();
		
		
		System.setIn(System.in);
		System.setOut(System.out);
	}
}
