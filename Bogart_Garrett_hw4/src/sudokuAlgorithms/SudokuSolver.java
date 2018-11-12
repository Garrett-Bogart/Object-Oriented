package sudokuAlgorithms;
import java.util.ArrayList;
import java.util.HashSet;

import sudokuBoard.*;
abstract public class SudokuSolver {
	private long elapsedTime;
	private long startTime;
	private long endTime;
	protected boolean didWork;
	public boolean solve(SudokuBoard board)
	{
		didWork = false;
		ArrayList<Cell> cells= getCells(board.getBoard());
		ArrayList<Cell> modified = modifyCells(cells, board.getSize());
		updateCells(board, modified);
		return didWork;
	}
	abstract public ArrayList<Cell> getCells(Cell[][] cells);
	abstract public ArrayList<Cell> modifyCells(ArrayList<Cell> cells,int size);
	abstract public ArrayList<Cell> makeRegionList(ArrayList<Cell> cells, int region);
	abstract public void removePair(ArrayList<Cell> cells, ArrayList<HashSet<String>> pair);
	abstract public void updateCells(SudokuBoard board, ArrayList<Cell> cells);
	abstract public void updateSubScript(ArrayList<Cell>cells);
	 
}
