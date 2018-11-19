package sudokuAlgorithms;

import java.util.Comparator;

import sudokuBoard.Cell;

public class CellSort implements Comparator<Cell> {

	@Override
	public int compare(Cell a, Cell b) {
		return a.getSolutionSet().size() - b.getSolutionSet().size();
	}

}
