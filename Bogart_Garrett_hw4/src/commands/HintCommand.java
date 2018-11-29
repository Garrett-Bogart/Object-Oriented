package commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import sudokuBoard.Cell;
import sudokuBoard.SudokuBoard;

public class HintCommand implements Command {

	private SudokuBoard playerBoard;
	private SudokuBoard solvedBoard;
	
	public HintCommand(SudokuBoard player, SudokuBoard solved)
	{
		playerBoard = player;
		solvedBoard = solved;
	}
	
	public void execute() 
	{
		String message = "";
		message += checkForErrors();
		message+= getCell();
		System.out.print(message);
	}
	
	private String checkForErrors()
	{
		String message = "Errors: ";
		String errorMessages = "";
		String finalMessage = "";
		int count = 0;
		for(int i = 0; i < playerBoard.getSize(); i++)
		{
			for(int j = 0; j < playerBoard.getSize(); j++)
			{
				String playerValue = playerBoard.getBoard()[i][j].getValue();
				String solvedValue = solvedBoard.getBoard()[i][j].getValue();
				if(!playerValue.equals(solvedValue) && !playerValue.equals("-"))
				{
					errorMessages+= "Error occured at row: "+i+" col: "+j+"\n" ;
					count+=1;
				}
			}
		}
		message += count+"\n";
		finalMessage+=message;
		finalMessage+=errorMessages;
		return finalMessage;
	}
	private String getCell()
	{
		String message = "";
		Cell found = null;
		ArrayList<Cell> cells = new ArrayList<Cell>();
		Cell[][] board = playerBoard.getBoard();
		for(int i = 0; i < playerBoard.getSize(); i++)
		{
			for(int j = 0; j < playerBoard.getSize(); j++)
			{
				if("-".equals(board[i][j].getValue()))
				{
					cells.add(board[i][j]);
				}
			}
		}
		Collections.sort(cells, Comparator.comparing(c -> c.getSolutionSet().size()));
		found = cells.get(0);
		message+= "Hint: row: "+found.getRow()+" col: "+found.getCol()+" value: "+solvedBoard.getCell(found.getRow(), found.getCol()).getValue();
		return message;
	}

}
