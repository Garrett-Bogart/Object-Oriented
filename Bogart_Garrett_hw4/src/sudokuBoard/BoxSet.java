package sudokuBoard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BoxSet extends SudokuSet {
	
	public BoxSet(Cell[][] board, int size, Set<String> symbols)
	{
		solutionSet = new ArrayList<Set<String>>(); 
		
		int region = 0;
		int regionSize = (int)Math.sqrt(size);
		for(int i = 0; i < size; i++)
		{
			Set<String> set = new HashSet<String>();
			Set<String> temp = new HashSet<String>(symbols);
			if(i%regionSize ==0 && i !=0)
				region +=regionSize;
			for(int r = region; r < region+regionSize; r++)
			{
				for(int c = (i%regionSize)*regionSize; c < ((i%regionSize)*regionSize)+regionSize; c++)
				{
					if("-".equals(board[r][c].getValue()))
						continue;
					else
					{
						if(temp.contains(board[r][c].getValue()))
						{
							set.add(board[r][c].getValue());
							temp.remove(board[r][c].getValue());
						}
						else
						{
							throw new IllegalArgumentException("BoxSet: Value is already in the row "+board[r][c].getValue());
						}
						
					}
						
				}
			}
			solutionSet.add(set);
		}
	}
	
	public boolean validateBox(Cell[][] board, int size, Set<String> symbols)
	{
		boolean isValid = true;
		int region = 0;
		int regionSize = (int)Math.sqrt(size);
		for(int i = 0; i < size; i++)
		{
			Set<String> set = new HashSet<String>();
			Set<String> temp = new HashSet<String>(symbols);
			if(i%regionSize ==0 && i !=0)
				region +=regionSize;
			for(int r = region; r < region+regionSize; r++)
			{
				for(int c = (i%regionSize)*regionSize; c < ((i%regionSize)*regionSize)+regionSize; c++)
				{
					if("-".equals(board[r][c].getValue()))
						continue;
					else
					{
						if(temp.contains(board[r][c].getValue()))
						{
							set.add(board[r][c].getValue());
							temp.remove(board[r][c].getValue());
						}
						else
						{
							isValid = false;
						}
						
					}
						
				}
			}
			if(!isValid == false)
				break;
		}
		return isValid;
	}
	
	public void updateSet(Cell c)
	{
		solutionSet.get(c.getRegion()).add(c.getValue());
	}
}

