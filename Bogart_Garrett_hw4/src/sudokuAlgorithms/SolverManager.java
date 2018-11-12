package sudokuAlgorithms;

import sudokuBoard.SudokuBoard;

public class SolverManager {
	private SudokuBoard board;
	private SudokuSolver solver;
	private SingleSolution single = new SingleSolution();
	private Twins twoThree = new Twins();
	
	public SolverManager(SudokuBoard board)
	{
		this.board = board;
		solver = null;
	}
	
	public void solve()
	{
		String output = "";
		int singles = 0;
		int twoThrees = 0;
		boolean changes = true;
		while(!isSolved() && changes)
		{
			changes = false;
			solver = single;
			if(!solver.solve(board))
			{
				solver = twoThree;
				if(!solver.solve(board))
				{
					//will contain guess or twins
				}
				else
				{
					changes = true;
					if(twoThrees == 0)
					{
						output+= "Twin reductions were used\n";
					}
					twoThrees+=1;
				}

			}
			else
			{
				changes = true;
				if(singles == 0)
				{
					output+= "singles were used\n";
				}
				singles+=1;
			}
			
		}
		if(!changes)
		{
			output+="cannot solve the current puzzle\n";
		}
		board.addOutput(output);
		board.outputBoard();
	}
	
	public boolean isSolved()
	{
		boolean isSolved = true;
		int size = board.getSize();
		for(int i = 0; i <size; i++)
		{
			if(board.getRows().getSet(i).size() !=size)
				isSolved =false;
			if(board.getColumns().getSet(i).size() != size)
				isSolved =false;
			if(board.getBoxes().getSet(i).size() != size)
				isSolved =false;
			if(isSolved == false)
				break;
		}
		return isSolved;
	}
}
