package sudokuAlgorithms;
import java.util.ArrayList;

import sudokuBoard.*;
abstract public class SudokuSolver {
	private long elapsedTime;
	private long startTime;
	private long endTime;
	public void solve(SudokuBoard board)
	{
		ArrayList<Cell> cells= getCells(board.getBoard());
		ArrayList<Cell> modified = modifyCells(cells, board.getSize());
		updateCells(board, modified);		
	}
	abstract public ArrayList<Cell> getCells(Cell[][] cells);
	abstract public ArrayList<Cell> modifyCells(ArrayList<Cell> cells,int size);
	abstract public void updateCells(SudokuBoard board, ArrayList<Cell> cells);
	abstract public void newSolver();
	 
}
