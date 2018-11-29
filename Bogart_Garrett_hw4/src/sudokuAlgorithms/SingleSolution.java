package sudokuAlgorithms;

import java.util.ArrayList;
import java.util.HashSet;

import sudokuBoard.Cell;
import sudokuBoard.SudokuBoard;

public class SingleSolution extends SudokuSolver {

	@Override
	public ArrayList<Cell> getCells(Cell[][] cells) {
		ArrayList<Cell> found = new ArrayList<Cell>();
		for(int i = 0; i < cells.length; i++)
		{
			for(int j =0; j < cells.length; j++)
			{
				if (cells[i][j].getSolutionSet().size() == 1)
				{
					found.add(cells[i][j]);
				}
			}
		}
		return found;
	}

	@Override
	public ArrayList<Cell> modifyCells(ArrayList<Cell> cells, int size) {
		ArrayList<Cell> test = new ArrayList<Cell>();
		for(Cell c : cells)
		{
			String value = c.getSolutionSet().iterator().next();
			c.setValue(value);
			test.add(c);
		}
		return test;
	}

	@Override
	public void updateCells(SudokuBoard board, ArrayList<Cell> cells) {
		if(cells.size() > 0)
			didWork = true;
		for(Cell c : cells)
		{
			board.getRows().updateSet(c);
			board.getColumns().updateSet(c);
			board.getBoxes().updateSet(c);
			board.updateCells(c);
		}	
	}
	
	public String getOutput() {return "Single Solution: "+getTotalTime()+"ms\n";}

	@Override
	protected ArrayList<Cell> updateSubScript(ArrayList<Cell> cells) {
		return null;
	}
}
