package sudokuBoard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RowSet extends SudokuSet {
	
	public RowSet(Cell[][] board, int size, Set<String> symbols)
	{
		solutionSet = new ArrayList<Set<String>>(); 
		for(int i = 0; i < size; i++)
		{
			Set<String> set = new HashSet<String>();
			Set<String> temp = new HashSet<String>(symbols);
			for(int j = 0; j < size; j++)
			{
				if("-".equals(board[i][j].getValue()))
					continue;
				else
				{
					if(temp.contains(board[i][j].getValue()))
					{
						set.add(board[i][j].getValue());
						temp.remove(board[i][j].getValue());
					}
					else
					{
						throw new IllegalArgumentException("RowSet: Value is already in the row "+board[i][j].getValue());
					}
					
				}
					
			}
			solutionSet.add(set);
		}
	}
	
	public boolean validateRows(Cell[][] board, int size, Set<String> symbols)
	{
		boolean isValid = true;
		for(int i = 0; i < size; i++)
		{
			Set<String> set = new HashSet<String>();
			Set<String> sym = new HashSet<String>(symbols);
			for(int j = 0; j < size; j++)
			{
				if("-".equals(board[i][j].getValue()))
					continue;
				else
				{
					if(sym.contains(board[i][j].getValue()))
					{
						set.add(board[i][j].getValue());
						sym.remove(board[i][j].getValue());
					}
					else
					{
						isValid=false;
					}
					
				}
				if(!isValid)
					break;	
			}
			if(!isValid)
				break;
		}
		return isValid;
	}
	
	public void updateSet(Cell c)
	{
		/*Set<String> temp = solutionSet.get(c.getRow());
		String value = c.getValue();
		temp.add(value);*/
		solutionSet.get(c.getRow()).add(c.getValue());
	}
}
