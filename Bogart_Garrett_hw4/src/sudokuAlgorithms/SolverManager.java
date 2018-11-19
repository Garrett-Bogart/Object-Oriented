package sudokuAlgorithms;

import java.util.ArrayList;
import java.util.Set;

import sudokuBoard.SudokuBoard;

public class SolverManager {
	private SudokuBoard board;
	ArrayList<SudokuSolver> solver;
	private SingleSolution single = new SingleSolution();
	private Loner loner = new Loner();
	private Twins twins = new Twins();
	private Guess guess = new Guess(board);
	
	public SolverManager(SudokuBoard board)
	{
		this.board = board;
		solver = new ArrayList<SudokuSolver>();
		solver.add(single);
		solver.add(loner);
		solver.add(twins);
		solver.add(guess);
	}
	
	public void solve() throws Exception
	{
		boolean changes = true;
		boolean isValid = true;
		while(!isSolved() && changes)
		{

			for(SudokuSolver s: solver)
			{
				changes = s.solve(board);
				if(changes)
				{
					break;
				}
			}
			if(isSolved())
				break;
			isValid = board.validBoard();
			if(!isValid && guess.getDeque().size() > 0)
			{
				board = guess.getDeque().pop();
				continue;
			}
			if(guess.getDeque().size() != 0 && !changes)
			{
				board = guess.getDeque().pop();
			}
		}

		board.addOutput(getOutput());
		board.outputBoard();
	}
	
	public String getOutput()
	{
		String output = "";
		for(SudokuSolver s: solver)
		{
			output+=s.getOutput();
		}
		return output;
	}
	
	public boolean isSolved()
	{
		boolean isSolved = true;
		int size = board.getSize();
		for(int i = 0; i <size; i++)
		{	
			Set<String> row = board.getRows().getSet(i);
			Set<String> col = board.getRows().getSet(i);
			Set<String> box = board.getRows().getSet(i);
			row.remove("-");
			col.remove("-");
			box.remove("-");
			if(row.size() !=size)
				isSolved =false;
			if(col.size() != size)
				isSolved =false;
			if(box.size() != size)
				isSolved =false;
			if(isSolved == false)
				break;
		}
		return isSolved;
	}
}
