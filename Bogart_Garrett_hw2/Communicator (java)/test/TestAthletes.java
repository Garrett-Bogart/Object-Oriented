package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import athlete.RaceTracker;
import athlete.Athlete;
import athlete.Status;

public class TestAthletes {
	@Test
	public void testConstruction()
	{
		Athlete athlete1 = new Athlete("10", "14", "a", "a", "m", "70", "registered");
		Athlete athlete2 = new Athlete("10", "14", "b", "b", "m", "70", "registered");
		Athlete athlete3 = new Athlete("10", "14", "c", "c", "m", "70", "registered");
		Athlete athlete4 = new Athlete("10", "14", "d", "d", "m", "70", "registered");
		Athlete athlete5 = new Athlete("10", "14", "e", "e", "m", "70", "registered");
		RaceTracker athletes = new RaceTracker();
		athletes.addAthlete(athlete1);
		athletes.addAthlete(athlete2);
		athletes.addAthlete(athlete3);
		athletes.addAthlete(athlete4);
		athletes.addAthlete(athlete5);
		Athlete test = athletes.getAthlete("a", "a");
		assertEquals("a",test.getFirstName());
		assertEquals("a",test.getLastName());
		
		test = athletes.getAthlete("b", "b");
		assertEquals("b",test.getFirstName());
		assertEquals("b",test.getLastName());

		test = athletes.getAthlete("c", "c");
		assertEquals("c",test.getFirstName());
		assertEquals("c",test.getLastName());
		

		test = athletes.getAthlete("d", "d");
		assertEquals("d",test.getFirstName());
		assertEquals("d",test.getLastName());

		test = athletes.getAthlete("e", "e");
		assertEquals("e",test.getFirstName());
		assertEquals("e",test.getLastName());
		
		test = athletes.getAthlete("e", "b");
		assertEquals(null,test);
		assertEquals(null,null);
		
		test = athletes.getAthlete("a", "b");
		assertEquals(null,test);
		assertEquals(null,test);


	}
}
