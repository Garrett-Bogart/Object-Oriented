package sudokuAlgorithms;

import java.util.ArrayList;

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
	public ArrayList<Cell> modifyCells(ArrayList<Cell> cells) {
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
		for(Cell c : cells)
		{
			board.getRows().getSet(c.getRow()).add(c.getValue());
			board.getColumns().getSet(c.getCol()).add(c.getValue());
			board.getBoxes().getSet(c.getRegion()).add(c.getValue());
			board.updateCells(c.getRow(), c.getCol(), c.getRegion(), c.getValue());
		}
		
	}

	@Override
	public void newSolver() {
		// TODO Auto-generated method stub
		
	}

}
