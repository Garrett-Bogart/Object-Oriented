package sudokuAlgorithms;

import sudokuBoard.SudokuBoard;

public class SolverManager {
	private SudokuBoard board;
	private SudokuSolver solver;
	
	public SolverManager(SudokuBoard board)
	{
		this.board = board;
		solver = null;
	}
	
	public void solve()
	{
		solver = new SingleSolution();
		while(!isSolved())
		{
			solver.solve(board);
		}
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
