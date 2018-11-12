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
	
	public SudokuBoard(InputStream iStream, OutputStream oStream) throws Exception
	{
		out = oStream;
		BufferedReader buff = new BufferedReader(new InputStreamReader(iStream));
		String path = buff.readLine();
		makeBoard(path);
		rows = new RowSet(board, size);
		cols = new ColumnSet(board, size);
		boxes = new BoxSet(board, size);
		cellSets();
	}	
	
	public SudokuBoard(InputStream iStream) throws Exception
	{
		this(iStream, System.out);
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
				if(data.length() == 1)
				{
					this.size = getBoardSize(data);
				}
				else
					throw new IOException("SudokuBoard: expected single number at start of the file. Got: "+ data);
				
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
				if(board[i][j].getRow() == c.getRow() ||board[i][j].getCol() == c.getCol()||board[i][j].getRegion() == c.getRegion())
				{
					board[i][j].getSolutionSet().remove(c.getValue());
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
	
	public String toString()
	{
		String temp = this.size+"\n";
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
