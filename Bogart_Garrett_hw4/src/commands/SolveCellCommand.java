package commands;

import sudokuBoard.Cell;
import sudokuBoard.SudokuBoard;

public class SolveCellCommand implements Command {
	private SudokuBoard playerBoard;
	private Cell cell;
	private String value;
	private String previousValue;
	private boolean validInput;
	
	public SolveCellCommand(SudokuBoard player, int r, int c, String v)
	{
		playerBoard = player;
		validInput = valid(r,c,v);
		if(validInput)
		{
			cell = playerBoard.getCell(r, c);
			value = v;
			previousValue = cell.getValue();
		}

	}
	
	public void execute() 
	{
		if(validInput)
		{
			if(!cell.getOriginal())
			{
				cell.setValue(value);
			}
		}
	}
	
	public boolean valid(int r, int c, String v)
	{
		boolean isValid = true;
		if(r > playerBoard.getSize() || r < 0 || c > playerBoard.getSize() || c < 0)
			isValid = false;
		if(!playerBoard.getSet().contains(v))
			isValid = false;
		return isValid;
	}
	
	public void undo()
	{
		cell.setValue(previousValue);
	}

}
