package sudokuAlgorithms;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

import sudokuBoard.Cell;
import sudokuBoard.SudokuBoard;

public class Guess extends SudokuSolver {
	Deque<SudokuBoard> deque = new LinkedList<SudokuBoard>();
	
	ArrayList<Cell> failed = new ArrayList<Cell>();
	Cell worker;
	
	public Guess(SudokuBoard board)
	{
		gameBoard = board;
	}
	
	@Override
	public ArrayList<Cell> getCells(Cell[][] cells) 
	{
		ArrayList<Cell> found = new ArrayList<Cell>();
		for(int i = 0; i < cells.length; i++)
		{
			for(int j =0; j < cells.length; j++)
			{
				if("-".equals(cells[i][j].getValue()) && cells[i][j].getSolutionSet().size() > 0)
					found.add(cells[i][j]);
			}
		}
		Collections.sort(found, new CellSort());
		return found;
	}
		
	@Override
	public ArrayList<Cell> modifyCells(ArrayList<Cell> cells, int size) throws Exception 
	{	
		ArrayList<Cell> modified = new ArrayList<Cell>();
		if(cells.size() > 0)
		{
			Cell c = cells.get(0);
			String value = c.getSolutionSet().iterator().next();
			c.getSolutionSet().remove(value);
			SudokuBoard newGame = new SudokuBoard(gameBoard);
			Cell[][] newBoard = newGame.getBoard();
			newBoard[c.getRow()][c.getCol()].getSolutionSet().remove(value);
			deque.push(newGame); 
			c.setValue(value);
			modified.add(c);
		}
		return modified;
	}

	@Override
	protected ArrayList<Cell> makeRegionList(ArrayList<Cell> cells, int region) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCells(SudokuBoard board, ArrayList<Cell> cells) {
		for(Cell c : cells)
		{
			if(cells.size() > 0)
				didWork = true;
			board.getRows().updateSet(c);
			board.getColumns().updateSet(c);
			board.getBoxes().updateSet(c);
			board.updateCells(c);	
		}
		
	}

	@Override
	protected ArrayList<Cell> updateSubScript(ArrayList<Cell> cells) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getOutput() {
		
		return "Guess: "+ getTotalTime()+"ms\n";
	}
	
	public Deque<SudokuBoard> getDeque(){return deque;}
}
