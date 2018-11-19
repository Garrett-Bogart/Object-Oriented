package sudokuPlayer;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import sudokuAlgorithms.SolverManager;
import sudokuBoard.SudokuBoard;
public class Driver {
	private static SudokuBoard board = null;
	private static SolverManager solver = null;
	
	public static void makeBoard(String[] args)
	{
		InputStream iStream;
		//TODO add fileoutput to SodokuBoard
	    OutputStream oStream = System.out;
	    if(args.length == 1)
	    {
	    	if(args[0]=="-h")
	    	{
	    		System.out.println("Command Line parameters");
	    		System.out.println("-h    if -h is used then no other parameters will be used");
	    		System.out.println("<input file>");
	    		System.out.println("<input file> <output file>");
	    	}
	    	else
	    	{
	    		iStream = new ByteArrayInputStream(args[0].getBytes());
	    		try {
					board = new SudokuBoard(iStream,oStream);
				} catch (Exception e) {
					System.out.println("Driver: "+e);
				}
	    	}
	    }
	    else if(args.length == 2)
	    {
	    	iStream = new ByteArrayInputStream(args[0].getBytes());
	    	
	    	try 
	    	{
				oStream = new FileOutputStream(args[1]);
			} 
	    	catch (FileNotFoundException e) 
	    	{
				System.out.println("Driver: outputStream could not find the file "+ e);
			}
	    	
	    	try {
				board = new SudokuBoard(iStream, oStream);
			} catch (Exception e) {
				System.out.println("Driver: "+e);
			}
	    }
	    else
	    {
	    	System.out.println("Driver: the parameters enterd are invalid");
	    	System.exit(1);
	    }
	    
}
	
	public static void main(String[] args) throws Exception 
	  {
	    makeBoard(args);
	    solver = new SolverManager(board);
	    solver.solve();
	  }
}
