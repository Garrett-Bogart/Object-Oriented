package sudokuAlgorithms;
import java.util.ArrayList;
import java.util.HashSet;

import sudokuBoard.*;
abstract public class SudokuSolver {
	private long totalTime;
	private long startTime;
	private long endTime;
	protected boolean didWork;
	protected SudokuBoard gameBoard;
	public boolean solve(SudokuBoard board) throws Exception
	{
		gameBoard = board;
		startTime = System.currentTimeMillis();
		didWork = false;
		
		
		ArrayList<Cell> cells= getCells(board.getBoard());
		ArrayList<Cell> modified = modifyCells(cells, board.getSize());
		updateCells(board, modified);
		
		
		endTime = System.currentTimeMillis();
		totalTime+=(endTime - startTime);
		return didWork;
	}
	public abstract ArrayList<Cell> getCells(Cell[][] cells);
	public abstract ArrayList<Cell> modifyCells(ArrayList<Cell> cells,int size) throws Exception;
	abstract protected ArrayList<Cell> makeRegionList(ArrayList<Cell> cells, int region);
	protected void removePair(ArrayList<Cell> cells, ArrayList<HashSet<String>> pair) {}
	public abstract void updateCells(SudokuBoard board, ArrayList<Cell> cells);
	abstract protected ArrayList<Cell> updateSubScript(ArrayList<Cell>cells);
	public long getTotalTime() {return totalTime;}
	abstract public String getOutput();
	 
}
