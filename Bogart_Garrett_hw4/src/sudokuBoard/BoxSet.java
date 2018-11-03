package sudokuBoard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BoxSet extends SudokuSet {
	
	public BoxSet(Cell[][] board, int size)
	{
		solutionSet = new ArrayList<Set<String>>(); 
		
		int region = 0;
		int regionSize = (int)Math.sqrt(size);
		for(int i = 0; i < size; i++)
		{
			Set<String> set = new HashSet<String>();
			if(i%regionSize ==0 && i !=0)
				region +=regionSize;
			for(int r = region; r < region+regionSize; r++)
			{
				for(int c = (i%regionSize)*regionSize; c < ((i%regionSize)*regionSize)+regionSize; c++)
				{
					if("-".equals(board[r][c].getValue()))
						continue;
					else
						set.add(board[r][c].getValue());
				}
			}
			solutionSet.add(set);
		}
	}
}

