package sudokuAlgorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import sudokuBoard.Cell;
import sudokuBoard.SudokuBoard;

public class TwoThreeReduction extends SudokuReduction {
	
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

	public ArrayList<Cell> makeRegionList(ArrayList<Cell> cells, int region)
	{
		ArrayList<Cell> regionCells = new ArrayList<Cell>();
		for(Cell c: cells)
		{
			if(c.getRegion() == region)
			{
				regionCells.add(c);
			}
		}		
		return regionCells;
	}
	
	public Cell getLargest(ArrayList<Cell> cells)//might be able to be expanded
	{
		Cell biggest = cells.get(0);
		for(Cell c: cells)
		{
			if(c.getSolutionSet().size() > biggest.getSolutionSet().size())
			{
				biggest = c;
			}
		}
		return biggest;
	}
	
	public HashSet<String> getPairs(Cell[] cells)//may be templatizable
	{
		HashSet<String> pair = null;
		for(int i = 0; i < cells.length; i++)
		{
			for(int j = 0; j < cells.length; j++)
			{
				HashSet<String> temp = new HashSet<String>(cells[i].getSolutionSet());
				temp.removeAll(cells[j].getSolutionSet());
				if(temp.isEmpty() && i!=j)
				{
					pair = (HashSet<String>) cells[i].getSolutionSet();
				}
			}
		}
		return pair;
	}
	
	@Override
	public void updateCells(ArrayList<Cell> cells)//reduction: this is the update
	{
		//TODO come up with a better way to figure out pairs and reductions
		Cell biggest = getLargest(cells);
		Cell[] cell = cells.toArray(new Cell[cells.size()]);
		HashSet<String> pair = getPairs(cell);
		if(pair != null && pair != null)
		{
			biggest.getSolutionSet().removeAll(pair);
		}
	}
	
	@Override
	public ArrayList<Cell> modifyCells(ArrayList<Cell> cells, int size) {
		ArrayList<Cell> modified = new ArrayList<Cell>();
		for(int i = 0; i < size; i++)
		{
			int r = i;
			ArrayList<Cell> region = makeRegionList(cells, i);
			if(region.size() == 3)
			{
				updateCells(region);
			}
			
			cells.removeIf(c ->(c.getRegion() == r));
		}
		return modified;
	}

}
