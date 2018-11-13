package sudokuAlgorithms;

import java.util.ArrayList;
import java.util.HashSet;

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
			//System.out.println("Pair found: "+pair.toString());
			for(Cell c : cells)
			{
				HashSet<String> temp = new HashSet<String>(c.getSolutionSet());
				//System.out.println("Before: "+c.getSolutionSet().toString());
				temp.removeAll(pair);
				if(!temp.isEmpty())
				{
					c.getSolutionSet().removeAll(pair);
					//System.out.println("Twins did work: ");
					didWork = true;
				}			
			}
		}

	}
	
	@Override
	public ArrayList<Cell> updateSubScript(ArrayList<Cell> cells)//reduction: this is the update
	{
		Cell[] cell = cells.toArray(new Cell[cells.size()]);
		ArrayList<HashSet<String>> pairs = getPairs(cell);
		if(pairs != null)
		{		
			removePair(cells, pairs);
		}
		return null;
	}
	
	@Override
	public ArrayList<Cell> modifyCells(ArrayList<Cell> cells, int size) {
		for(int i = 0; i < size; i++)
		{
			int r = i;
			ArrayList<Cell> region = makeRegionList(cells, i);
			ArrayList<Cell> rows = makeRowList(cells,i);
			ArrayList<Cell> cols = makeColumnList(cells, i);
			if(region.size() == 3)
			{
				updateSubScript(region);
				updateSubScript(rows);
				updateSubScript(cols);
			}
			
			cells.removeIf(c ->(c.getRegion() == r));
			cells.removeIf(c ->(c.getRow() == r));
			cells.removeIf(c ->(c.getCol() == r));
		}
		return null;
	}

	@Override
	public void updateCells(SudokuBoard board, ArrayList<Cell> cells) {}
}
