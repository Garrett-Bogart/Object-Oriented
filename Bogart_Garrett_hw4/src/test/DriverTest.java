package test;

import sudokuPlayer.*;

import static org.junit.Assert.fail;

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
	public void testMain_input() throws Exception
	{
		String[] input = {"src/resources/Puzzle-9x9-0001.txt"};
		Driver.main(input);
	}
	
	@Test
	public void testMain_input_fail() throws Exception
	{
		try
		{
			String[] input = {"src/resources/Puzzle-9x9-9999.txt"};
			Driver.main(input);
			fail();
		}catch(Exception e)
		{
			//ignore
		}

	}
	
	@Test
	public void testMain_input_output() throws Exception
	{
		String[] input = {"src/resources/Puzzle-9x9-0001.txt", "src/output/Driver_output.txt"};
		Driver.main(input);
	}
}
