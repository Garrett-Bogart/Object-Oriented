package sudokuBoard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RowSet extends SudokuSet {
	
	public RowSet(Cell[][] board, int size)
	{
		solutionSet = new ArrayList<Set<String>>(); 
		for(int i = 0; i < size; i++)
		{
			Set<String> set = new HashSet<String>();
			for(int j = 0; j < size; j++)
			{
				if("-".equals(board[i][j].getValue()))
					continue;
				else
					set.add(board[i][j].getValue());
			}
			solutionSet.add(set);
		}
	}
	
	public void updateSet(Cell c)
	{
		solutionSet.get(c.getRow()).add(c.getValue());
	}
}
