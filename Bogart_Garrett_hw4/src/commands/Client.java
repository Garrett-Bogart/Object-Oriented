package commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Set;

import sudokuBoard.SudokuBoard;

public class Client {
	
	private SudokuBoard playerBoard;
	private SudokuBoard solvedBoard;
	private Invoker invoker;
	private boolean solved;
	Scanner scanner;
	
	public Client(SudokuBoard player, SudokuBoard solve)
	{
		playerBoard = player;
		solvedBoard = solve;
		invoker = new Invoker();
		solved = false;
		scanner = new Scanner(System.in);
	}
	
	public boolean start() throws IOException
	{
		System.out.println("Current Board\n");
		System.out.println(toString());
		Command command = makeCommand();
		invoker.execute(command);
		if(command instanceof SolveCellCommand)
		{
			if(isSolved())
			{
				solved = true;
			}
		}
		return solved;
	}
	
	public Command makeCommand() throws IOException
	{
		System.out.println("Enter a command\nValid commands: solve, hint, undo");
		String input = scanner.nextLine().trim().toLowerCase();
		Command command = null;
		if("solve".equals(input))
		{
			System.out.print("Enter the row of your cell: ");
			String row = scanner.nextLine();
			System.out.println("");
			System.out.print("Enter the column of your cell: ");
			String col = scanner.nextLine();
			System.out.println("");
			System.out.print("Enter the value of your cell: ");
			String value = scanner.nextLine();
			System.out.println("");
			command = new SolveCellCommand(playerBoard,Integer.parseInt(row.trim()), Integer.parseInt(col.trim()), value.trim());
		}
		else if("hint".equals(input))
		{
			command = new HintCommand(playerBoard, solvedBoard);
		}
		else if("undo".equals(input))
		{
			command = new UndoCommand();
		}
		else
		{
			command = new DoNothingCommand();
		}
		return command;
	}
	
	public boolean isSolved()
	{
		boolean isSolved = true;
		int size = playerBoard.getSize();
		for(int i = 0; i <size; i++)
		{	
			for(int j = 0; j < size; j++)
			{
				if(!playerBoard.getCell(i, j).getValue().equals(solvedBoard.getCell(i, j).getValue()))
				{
					isSolved = false;
				}
			}
		}
		return isSolved;
	}
	
	public String toString()
	{
		String temp = "";
		for(int i = 0; i < playerBoard.getSize(); i++)
		{
			for(int j = 0; j < playerBoard.getSize(); j++)
			{
				temp+=playerBoard.getCell(i,j).toString()+" ";
			}
			temp+="\n";
		}
		return temp;
	}
}
