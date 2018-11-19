package sudokuAlgorithms;

import java.util.ArrayList;
import java.util.HashSet;

import sudokuBoard.Cell;
import sudokuBoard.SudokuBoard;

public class Loner extends SudokuSolver {

	@Override
	public ArrayList<Cell> getCells(Cell[][] cells) {
		ArrayList<Cell> found = new ArrayList<Cell>();
		for(int i = 0; i < cells.length; i++)
		{
			for(int j = 0; j < cells.length;j++)
			{
				if("-".equals(cells[i][j].getValue()))
				{
					found.add(cells[i][j]);
				}
			}
		}
		return found;
	}

	@Override
	public ArrayList<Cell> makeRegionList(ArrayList<Cell> cells, int region)
	{
		ArrayList<Cell> regionCells = new ArrayList<Cell>();
		for(Cell c: cells)
		{
			if(c.getRegion() == region)//need rows and columns as well
			{
				regionCells.add(c);
			}
		}		
		return regionCells;
	}
	
	public ArrayList<Cell> makeRowList(ArrayList<Cell> cells, int region)
	{
		ArrayList<Cell> regionCells = new ArrayList<Cell>();
		for(Cell c: cells)
		{
			if(c.getRow() == region)//need rows and columns as well
			{
				regionCells.add(c);
			}
		}		
		return regionCells;
	}
	
	public ArrayList<Cell> makeColumnList(ArrayList<Cell> cells, int region)
	{
		ArrayList<Cell> regionCells = new ArrayList<Cell>();
		for(Cell c: cells)
		{
			if(c.getCol() == region)//need rows and columns as well
			{
				regionCells.add(c);
			}
		}		
		return regionCells;
	}

	@Override
	public ArrayList<Cell> updateSubScript(ArrayList<Cell> cells) {
		ArrayList<Cell> modified = new ArrayList<Cell>();
		for(Cell master : cells)
		{
			HashSet<String> temp = new HashSet<String>(master.getSolutionSet());
			for(Cell worker : cells)
			{
				if(master.getCol() != worker.getCol() || master.getRow() != worker.getRow() || master.getRegion() != worker.getRegion())
				{
					temp.removeAll(worker.getSolutionSet());
					if(temp.isEmpty())
						break;
				}
			}
			if(temp.size() == 1)
			{
				master.setSet(temp);
				modified.add(master);
				didWork = true;
			}
		}
		return modified;
	}
	
	@Override
	public ArrayList<Cell> modifyCells(ArrayList<Cell> cells, int size) {
		ArrayList<Cell> modified = new ArrayList<Cell>();
		for(int i = 0; i < size; i++)
		{
			ArrayList<Cell> region = makeRegionList(cells, i);
			ArrayList<Cell> rows = makeRowList(cells,i);
			ArrayList<Cell> cols = makeColumnList(cells, i);
			modified.addAll(updateSubScript(region));
			modified.addAll(updateSubScript(rows));
			modified.addAll(updateSubScript(cols));
		}
		return modified;
	}


	@Override
	public void removePair(ArrayList<Cell> cells, ArrayList<HashSet<String>> pair) {}

	@Override
	public void updateCells(SudokuBoard board, ArrayList<Cell> cells) {
		for(Cell c : cells)
		{
			board.getRows().updateSet(c);
			board.getColumns().updateSet(c);
			board.getBoxes().updateSet(c);
			board.updateCells(c);
		}	
	}

	public String getOutput() {return "Lone Subscript: "+getTotalTime()+"ms\n";}

}
