package test;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import message.RaceMessage;
import message.Message;

import behaviors.RaceChange;
import behaviors.RaceEvents;
import athlete.Athlete;
import athlete.RaceTracker;

public class TestRaceMessage {
	
	@Test
	public void TestRaceMessageConstructor()
	{
		Message message = new RaceMessage();
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
		
		athletes.setRaceName("best race");
		athletes.setDistance("1000");
		RaceEvents RE = message.getRaceEvents();
		RE.raceExecute(athletes, "check", "9001");
		
		String name = athletes.getRaceName();
		String distance = athletes.getDistance();
		assertEquals("check", name);
		assertEquals("9001", distance);
		
		
		
		
	}

	
}
