package sudokuBoard;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SudokuBoard {
	private Cell[][] board;
	private OutputStream out;
	private int size;
	private Set<String> validSymbols;
	private RowSet rows;
	private ColumnSet cols;
	private BoxSet boxes;
	private String output = "";

	public SudokuBoard(SudokuBoard board)
	{
		out = board.getOutputStream();
		output = board.getOutput();
		size = board.getSize();
		this.board = new Cell[size][size];
		copyBoard(board.getBoard());
		
		validSymbols = board.getSet();
		rows = new RowSet(this.board, size, validSymbols);
		cols = new ColumnSet(this.board, size, validSymbols);
		boxes = new BoxSet(this.board, size, validSymbols);
		cellSets();
		
	}
	
	public SudokuBoard(InputStream iStream, OutputStream oStream) throws Exception
	{
		out = oStream;
		BufferedReader buff = new BufferedReader(new InputStreamReader(iStream));
		String path = buff.readLine();
		makeBoard(path);
		rows = new RowSet(board, size, validSymbols);
		cols = new ColumnSet(board, size, validSymbols);
		boxes = new BoxSet(board, size, validSymbols);
		cellSets();
	}	
	
	public SudokuBoard(InputStream iStream) throws Exception
	{
		this(iStream, System.out);
	}	
	
	public void copyBoard(Cell[][] oldBoard)
	{
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				Cell cell = new Cell(oldBoard[i][j].getValue());
				board[i][j] = cell;
			}
		}
	}
	
	public void cellSets()
	{
		int box = 0;
		int location = 0;
		int regions = (int) Math.sqrt(size);
		for(int i = 0; i < size; i++)
		{		
			for(int j = 0; j < size; j++)
			{
				HashSet<String> set = new HashSet<String>(validSymbols);	
				set.remove("-");
				if("-".equals(board[i][j].getValue()))
				{
					set.removeAll(rows.getSet(i));
					set.removeAll(cols.getSet(j));
					set.removeAll(boxes.getSet(location+box));
					board[i][j].setSet(set);
					board[i][j].setRow(i);
					board[i][j].setCol(j);
					board[i][j].setRegion(location+box);
					
				}	
				//System.out.print(location+box);	
				if(((j+1)%regions) == 0 && j != 0)
					location++;
			}
			if((i+1)%regions == 0 && i != 0)
				box+=regions;
			location = 0;
			//System.out.println("");
		}
	}
	
 	public int getBoardSize(String s)
	{
		int size = Integer.parseInt(s);
		if(size == 4 || size == 9 || size == 16 || size == 25 || size == 36)
		{
			board = new Cell[size][size];
		}
		else
		{
			size = -1;
			throw new IllegalArgumentException("SudokuBoard: Board size has to be 4,9,16,25,36: given "+size);
		}
		return size;
	}
	
	public void makeBoard(String path) throws Exception
	{
		BufferedReader buff = null;
		String data;
		String[] temp;
		try 
		{			
			FileReader file = new FileReader(path);
			buff = new BufferedReader(file);
			while((data = buff.readLine()) != null)
			{
				if(data.length() <= 2)
				{
					this.size = getBoardSize(data);
				}
				else
				{
					throw new IOException("SudokuBoard: expected single number at start of the file. Got: "+ data);
				}
					
				
				data = buff.readLine();
				temp = data.split(" ");
				
				this.validSymbols = new HashSet<String>();
				this.validSymbols.addAll(Arrays.asList(temp));
				this.validSymbols.add("-");
				
				
				for(int i = 0; i < size; i++)
				{
					data = buff.readLine();
					temp = data.split(" ");
					for(int j = 0; j < size; j++)
					{
						if(validSymbols.contains(temp[j]))
						{
							Cell cell = new Cell(temp[j]);
							board[i][j] = cell;
						}
						else
						{
							throw new IllegalArgumentException(temp[j]+" is not a valid symbol. Valid Symbols: "+ validSymbols.toString());
						}
					}
				}
				

			}
		} 
		catch(FileNotFoundException e)
		{
			output = "SudokuBoard: "+ e.getMessage();
			outputBoard();
			throw new IOException("SudokuBoard: "+ e);
		}
		catch(IOException e)
		{
			output = "SudokuBoard: "+ e.getMessage();
			outputBoard();
			throw new IOException("SudokuBoard: "+e);
		}
		catch(IllegalArgumentException e)
		{
			output = "SudokuBoard: "+ e.getMessage();
			outputBoard();
			throw new IllegalArgumentException("SudokuBoard: "+e);
		}
		catch(Exception e)
		{
			output = "SudokuBoard: "+ e.getMessage();
			outputBoard();
			throw new Exception("SudokuBoard: Unknown error: "+e.getStackTrace());
		}
		finally
		{
			if(buff != null)
				buff.close();
		}

	}
	
	public int getRegion(int x, int y)
	{
		int region = (int)Math.sqrt(size);
		int cols = y/region;//determines what vertical region 5/3 = 1
		int rows = x/region;//determines what horizontal region 5/3 = 1
		int location = cols;		
		return location+(region*rows);
	}
	
	public void updateCells(Cell c)
	{

		for(int i = 0; i < size; i ++)
		{
			for(int j = 0; j<size; j++)
			{
				if("-".equals(board[i][j].getValue()))
				{
					Set<String> row = rows.getSet(board[i][j].getRow());
					Set<String> col = cols.getSet(board[i][j].getCol());
					Set<String>box = boxes.getSet(getRegion(i,j));
					@SuppressWarnings("unused")
					Set<String> temp = board[i][j].getSolutionSet();
					board[i][j].getSolutionSet().removeAll(row);
					board[i][j].getSolutionSet().removeAll(col);
					board[i][j].getSolutionSet().removeAll(box);
					temp = null;
				}
			}
		}
		
	}
	
	public void outputBoard()
	{
		PrintWriter out = new PrintWriter(this.out);
		out.print(this.toString());
		out.close();
	}
	
	public String printBoard()
	{
		String temp = "";
		for(int i = 0; i < this.size; i++)
		{
			for(int j = 0; j < this.size; j++)
			{
				if(board[i][j] == null)
				{
					temp+="*";
				}
				else
					temp+=board[i][j].toString()+" ";
			}
			temp+="\n";
		}
		return temp;
	}
	
	public String toString()
	{
		Set<String> symbols = validSymbols;
		symbols.remove("-");
		String sym = "";
		for(String s : symbols)
		{
			sym+=s+" ";
		}
		String temp = this.size+"\n";
		temp+=sym.trim()+"\n";
		for(int i = 0; i < this.size; i++)
		{
			for(int j = 0; j < this.size; j++)
			{
				if(board[i][j] == null)
				{
					temp+="*";
				}
				else
					temp+=board[i][j].toString()+" ";
			}
			temp+="\n";
		}
		temp+=output;
		return temp;
	}
	
	public boolean validBoard()
	{
		boolean isValid = false;
		boolean rows = this.rows.validateRows(board, size, validSymbols);
		boolean cols = this.cols.validateColumns(board, size, validSymbols);
		boolean boxes = this.boxes.validateBox(board, size, validSymbols);
		if(rows && cols && boxes)
			isValid = true;
		return isValid;
	}
	
	public Cell getCell(int row, int col)
	{
		return board[row][col];
	}
	
	public OutputStream getOutputStream() {return out; }
	public String getOutput() {return output;}
	public Cell[][] getBoard(){return board;}
	public RowSet getRows() {return rows;}
	public ColumnSet getColumns() {return cols;}
	public BoxSet getBoxes() {return boxes;}
	public int getSize() {return size;}
	public Set<String> getSet(){return validSymbols;}
	public void addOutput(String out) {output+=out;}
	
	public void setSize(int size) {this.size = size;}
	

	
}
