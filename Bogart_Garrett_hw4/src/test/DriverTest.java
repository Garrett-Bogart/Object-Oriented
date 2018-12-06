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
	public void testMain_help_fail() throws Exception
	{
		String[] input = {"solve"};
		Driver.main(input);
	}
	
	
	@Test
	public void testMain_input_fail() throws Exception
	{
		String[] input = {"src/resources/Puzzle-9x9-9999.txt"};
		Driver.main(input);
	}

}
