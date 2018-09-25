package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import athlete.AthleteTracker;
import athlete.Athlete;
import athlete.Status;

public class TestAthletes {
	@Test
	public void testConstruction()
	{
		Athlete athlete1 = new Athlete("10", "14", "a", "a", "m", "70");
		Athlete athlete2 = new Athlete("11", "14", "b", "b", "m", "70");
		Athlete athlete3 = new Athlete("12", "14", "c", "c", "m", "70");
		Athlete athlete4 = new Athlete("13", "14", "d", "d", "m", "70");
		Athlete athlete5 = new Athlete("14", "14", "e", "e", "m", "70");
		AthleteTracker athletes = new AthleteTracker();
		athletes.addAthlete(athlete1);
		athletes.addAthlete(athlete2);
		athletes.addAthlete(athlete3);
		athletes.addAthlete(athlete4);
		athletes.addAthlete(athlete5);
		Athlete test = athletes.getAthlete("10");
		assertEquals("a",test.getFirstName());
		assertEquals("a",test.getLastName());
		
		test = athletes.getAthlete("11");
		assertEquals("b",test.getFirstName());
		assertEquals("b",test.getLastName());

		test = athletes.getAthlete("12");
		assertEquals("c",test.getFirstName());
		assertEquals("c",test.getLastName());
		

		test = athletes.getAthlete("13");
		assertEquals("d",test.getFirstName());
		assertEquals("d",test.getLastName());

		test = athletes.getAthlete("14");
		assertEquals("e",test.getFirstName());
		assertEquals("e",test.getLastName());
		
		test = athletes.getAthlete("15");
		assertEquals(null,test);


	}
}
