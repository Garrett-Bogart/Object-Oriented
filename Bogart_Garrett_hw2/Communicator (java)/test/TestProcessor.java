package test;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import athlete.AthleteTracker;
import athlete.Athlete;
import athlete.Status;
import communicator.MessageProcessor;

public class TestProcessor {
	@Test
	public void testConstuction()
	{
		//<race name>,<course length in meters>
		MessageProcessor process = new MessageProcessor("A");
		process.process("Race, cool ,1000", null, 120);
	}
}
