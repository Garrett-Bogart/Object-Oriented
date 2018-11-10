package sudokuBoard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ColumnSet extends SudokuSet {
	
	public ColumnSet(Cell[][] board, int size)
	{
		solutionSet = new ArrayList<Set<String>>(); 
		
		for(int i = 0; i < size; i++)
		{
			Set<String> set = new HashSet<String>();
			for(int j = 0; j < size; j++)
			{
				if("-".equals(board[j][i].getValue()))
					continue;
				else
					set.add(board[j][i].getValue());
			}
			solutionSet.add(set);
		}
	}
	
	public void updateSet(Cell c)
	{
		solutionSet.get(c.getCol()).add(c.getValue());
	}
}

