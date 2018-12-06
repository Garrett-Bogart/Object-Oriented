package sudokuPlayer;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import commands.Client;
import sudokuAlgorithms.SolverManager;
import sudokuBoard.SudokuBoard;
public class Driver {
	private static SudokuBoard board = null;
	private static SolverManager solver = null;
	private static SudokuBoard playerBoard = null;
	private static Client client = null;
	private static boolean madeBoard = false;
	
	public static void makeBoard(String[] args) throws FileNotFoundException
	{
		InputStream iStream;
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
					madeBoard = true;
				} catch (Exception e) {
					System.out.println("Driver: invalid file "+e);
				}
	    	}
	    }
	    else if(args.length == 2)
	    {
	    	iStream = new ByteArrayInputStream(args[0].getBytes());
			oStream = new FileOutputStream(args[1]);
	    	
	    	try {
				board = new SudokuBoard(iStream, oStream);
				madeBoard = true;
			} catch (Exception e) {
				System.out.println("Driver: "+e);
			}
	    }
	    else
	    {
	    	System.out.println("Driver: the parameters enterd are invalid");
	    }
	    
}
	
	public static void main(String[] args) throws Exception 
	  {
	    makeBoard(args);
	    if(madeBoard)
	    {
		    playerBoard = new SudokuBoard(board);
		    solver = new SolverManager(board);
		    solver.solve();
		    client = new Client(playerBoard, board);
			while(!client.start()) {}
			System.out.println("\nSolved board\n"+client.toString());
	    }


	  }
}
