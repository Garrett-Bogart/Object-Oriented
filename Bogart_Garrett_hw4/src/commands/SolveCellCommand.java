package commands;

import sudokuBoard.Cell;
import sudokuBoard.SudokuBoard;

public class SolveCellCommand implements Command {
	private SudokuBoard playerBoard;
	private Cell cell;
	private String value;
	private String previousValue;
	
	public SolveCellCommand(SudokuBoard player, int r, int c, String v)
	{
		playerBoard = player;
		cell = playerBoard.getCell(r, c);
		value = v;
		previousValue = cell.getValue();
	}
	
	public void execute() 
	{
		cell.setValue(value);
	}
	
	public void undo()
	{
		cell.setValue(previousValue);
	}

}
