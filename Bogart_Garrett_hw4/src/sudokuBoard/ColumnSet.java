package sudokuBoard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ColumnSet extends SudokuSet {
	
	public ColumnSet(Cell[][] board, int size, Set<String> symbols)
	{
		solutionSet = new ArrayList<Set<String>>(); 
		
		for(int i = 0; i < size; i++)
		{
			Set<String> set = new HashSet<String>();
			Set<String> temp = new HashSet<String>(symbols);
			for(int j = 0; j < size; j++)
			{
				if("-".equals(board[j][i].getValue()))
					continue;
				else
				{
					if(temp.contains(board[j][i].getValue()))
					{
						set.add(board[j][i].getValue());
						temp.remove(board[j][i].getValue());
					}
					else
					{
						throw new IllegalArgumentException("ColumnSet: Value is already in the row "+board[j][i].getValue());
					}
				}
					
			}
			solutionSet.add(set);
		}
	}
	
	public void updateSet(Cell c)
	{
		solutionSet.get(c.getCol()).add(c.getValue());
	}
}

