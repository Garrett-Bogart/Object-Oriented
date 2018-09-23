package test;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import message.RaceMessage;
import message.Message;
import behaviors.AthleteEvents;
import behaviors.ClientEvents;
import behaviors.NotifyEvents;
import behaviors.RaceChange;
import behaviors.RaceEvents;
import communicator.Communicator;
import communicator.RaceTracker;
import athlete.Athlete;
import athlete.AthleteTracker;

public class TestRaceMessage {
	
	@Test
	public void TestRaceMessageConstructor()throws Exception
	{
		
		Message message = new RaceMessage();
		Communicator comm = new Communicator();
		AthleteTracker athletes = new AthleteTracker();
		RaceTracker race = new RaceTracker(comm, athletes);
		Athlete athlete1 = new Athlete("10", "14", "a", "a", "m", "70", "registered");
		Athlete athlete2 = new Athlete("10", "14", "b", "b", "m", "70", "registered");
		Athlete athlete3 = new Athlete("10", "14", "c", "c", "m", "70", "registered");
		Athlete athlete4 = new Athlete("10", "14", "d", "d", "m", "70", "registered");
		Athlete athlete5 = new Athlete("10", "14", "e", "e", "m", "70", "registered");
		athletes.addAthlete(athlete1);
		athletes.addAthlete(athlete2);
		athletes.addAthlete(athlete3);
		athletes.addAthlete(athlete4);
		athletes.addAthlete(athlete5);
		
		race.setRaceName("best race");
		race.setDistance("1000");
		RaceEvents RE = message.getRaceEvents();
		NotifyEvents NE = message.getNotifyEvents();
		AthleteEvents AE = message.getAthleteEvents();
		ClientEvents CE = message.getClientEvents();
		RE.raceExecute(race, "check", "9001");
		NE.notifyExecute(athletes);
		AE.athleteExecute(athletes, null, null, null, null, null, null, null, null, null);
		CE.clientExecute(athletes, null, null);
		
		String name = race.getRaceName();
		String distance = race.getDistance();
		assertEquals("check", name);
		assertEquals("9001", distance);
		
		
		
		
	}

	
}
