package test;

import sudokuPlayer.*;

import org.junit.jupiter.api.Test;

public class DriverTest {
	@Test
	public void testMain_help() throws Exception
	{
		String[] input = {"-h"};
		Driver.main(input);
	}
	
	@Test
	public void testMain_input() throws Exception
	{
		String[] input = {"src/resources/Puzzle-9x9-0001.txt"};
		Driver.main(input);
	}
	
	@Test
	public void testMain_input_output() throws Exception
	{
		String[] input = {"src/resources/Puzzle-9x9-0001.txt", "src/output/Driver_output.txt"};
		Driver.main(input);
	}
}
