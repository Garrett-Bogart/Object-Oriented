package commands;

import java.util.Deque;
import java.util.LinkedList;

import sudokuBoard.Cell;
import sudokuBoard.SudokuBoard;

public class Invoker {
	private Deque<Command> solvedCells;
	
	public Invoker()
	{
		solvedCells = new LinkedList<Command>();
	}
	
	public void execute(Command c)
	{
		c.execute();
		if(c instanceof SolveCellCommand)
		{
			solvedCells.push(c);
		}
		if(c instanceof UndoCommand)
		{
			if(!solvedCells.isEmpty())
			{
				SolveCellCommand s = (SolveCellCommand) solvedCells.pop();
				s.undo();
			}
		}
	}
}
