package sudokuAlgorithms;

import java.util.ArrayList;
import java.util.HashSet;

import sudokuBoard.Cell;
import sudokuBoard.SudokuBoard;

abstract public class SudokuReduction {
	private long elapsedTime;
	private long startTime;
	private long endTime;
	public void solve(SudokuBoard board)
	{
		ArrayList<Cell> cells= getCells(board.getBoard());
		ArrayList<Cell> modified = modifyCells(cells, board.getSize());	
	}
	abstract public ArrayList<Cell> getCells(Cell[][] cells);
	abstract public ArrayList<Cell> modifyCells(ArrayList<Cell> cells,int size);
	abstract public ArrayList<Cell> makeRegionList(ArrayList<Cell> cells, int region);
	abstract public Cell getLargest(ArrayList<Cell> cells);
	abstract public HashSet<String> getPairs(Cell[] cells);
	abstract public void updateCells(ArrayList<Cell> cells);
}
