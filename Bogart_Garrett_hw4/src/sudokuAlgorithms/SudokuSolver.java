package sudokuAlgorithms;
import java.util.ArrayList;

import sudokuBoard.*;
abstract public class SudokuSolver {
	public void solve(SudokuBoard board)
	{
		ArrayList<Cell> cells= getCells(board.getBoard());
		ArrayList<Cell> modified = modifyCells(cells);
		updateCells(board, modified);		
	}
	abstract public ArrayList<Cell> getCells(Cell[][] cells);
	abstract public ArrayList<Cell> modifyCells(ArrayList<Cell> cells);
	abstract public void updateCells(SudokuBoard board, ArrayList<Cell> cells);
	abstract public void newSolver();
	 
}
