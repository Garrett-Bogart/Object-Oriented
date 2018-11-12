package sudokuAlgorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import sudokuBoard.Cell;
import sudokuBoard.SudokuBoard;

public class Twins extends SudokuSolver {
	
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
			if(c.getRegion() == region)//need rows and columns as well
			{
				regionCells.add(c);
			}
		}		
		return regionCells;
	}
	
	public ArrayList<HashSet<String>> getPairs(Cell[] cells)
	{
		ArrayList<HashSet<String>> pairs = new ArrayList<HashSet<String>>();
		HashSet<String> pair = null;
		
		for(int i = 0; i < cells.length; i++)
		{
			int size = 1;
			for(int j = 0; j < cells.length; j++)
			{
				HashSet<String> temp = new HashSet<String>(cells[i].getSolutionSet());
				temp.removeAll(cells[j].getSolutionSet());
				
				if(cells[j].getSolutionSet().size() > cells[i].getSolutionSet().size())
					continue;
				if(temp.isEmpty() && i!=j)
				{
					size+=1;
					pair = (HashSet<String>) cells[i].getSolutionSet();
					
					if(size != cells[i].getSolutionSet().size())
						continue;				
					if(!pairs.contains(pair))
						pairs.add(pair);
				}
			}
		}
		return pairs;
	}
	
	@Override
	public void removePair(ArrayList<Cell> cells, ArrayList<HashSet<String>> pairs)
	{
		for(HashSet<String> pair : pairs)
		{
			for(Cell c : cells)
			{
				HashSet<String> temp = new HashSet<String>(c.getSolutionSet());
				//System.out.println("Before: "+c.getSolutionSet().toString());
				temp.removeAll(pair);
				if(!temp.isEmpty())
				{
					c.getSolutionSet().removeAll(pair);
					System.out.println("Twins did work: ");
					didWork = true;
				}			
			}
		}

	}
	
	@Override
	public void updateSubScript(ArrayList<Cell> cells)//reduction: this is the update
	{
		Cell[] cell = cells.toArray(new Cell[cells.size()]);
		ArrayList<HashSet<String>> pairs = getPairs(cell);
		if(pairs != null)
		{
			System.out.println("Pair found: ");
			removePair(cells, pairs);
		}
	}
	
	@Override
	public ArrayList<Cell> modifyCells(ArrayList<Cell> cells, int size) {
		for(int i = 0; i < size; i++)
		{
			int r = i;
			ArrayList<Cell> region = makeRegionList(cells, i);
			if(region.size() == 3)
			{
				updateSubScript(region);
			}
			
			cells.removeIf(c ->(c.getRegion() == r));
		}
		return null;
	}

	@Override
	public void updateCells(SudokuBoard board, ArrayList<Cell> cells) {}
}
