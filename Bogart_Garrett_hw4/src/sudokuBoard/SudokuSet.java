package sudokuBoard;

import java.util.ArrayList;
import java.util.Set;

abstract public class SudokuSet {
	protected ArrayList<Set<String>> solutionSet;
	public Set<String> getSet(int index){return solutionSet.get(index);}
	abstract public void updateSet(Cell c);
}
