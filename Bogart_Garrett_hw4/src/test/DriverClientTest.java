package test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;

import org.junit.jupiter.api.Test;

import sudokuPlayer.Driver;

public class DriverClientTest {
	@Test
	public void testMain_Client() throws Exception
	{
		String[] input = {"src/resources/Puzzle-4x4-0001.txt", "src/output/Driver_output.txt"};
		final FileInputStream in = new FileInputStream(new File("src/resources/input_4x4_solve.txt"));
		System.setIn(in);
		Driver.main(input);
		System.setIn(System.in);
	}
}
