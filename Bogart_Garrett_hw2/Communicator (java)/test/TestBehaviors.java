package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import athlete.AthleteTracker;
import athlete.Athlete;
import athlete.Status;
import behaviors.AthleteAdd;
import behaviors.AthleteEvents;
import behaviors.AthleteNone;
import behaviors.AthleteObservers;
import behaviors.AthleteUpdate;
import behaviors.ClientEvents;
import behaviors.ClientSubscribe;
import behaviors.ClientUnsubscribe;
import behaviors.RaceEvents;
import communicator.Communicator;
import communicator.RaceTracker;
import behaviors.RaceChange;

public class TestBehaviors {
	
	@Test
	public void TestAthleteAdd()
	{
		AthleteEvents AE = new AthleteAdd();
		AthleteTracker race = new AthleteTracker();
		AE.athleteExecute(race, "10", "900", "Speed", "Racer", "Yes", "time", "all", "time", null);
		
		Athlete athlete = race.getAthlete("10");
		assertEquals("10", athlete.getID());
	}
	
	@Test
	public void TestAthleteUpdate()
	{
		AthleteEvents AE = new AthleteUpdate();
		AthleteTracker race = new AthleteTracker();
		Athlete athlete = new Athlete("id", "900", "Speed", "Racer", "Yes", "time", "all");
		race.addAthlete(athlete);
		AE.athleteExecute(race, "id", "time", null, null, null, null, null, "distance", null);
		
		athlete = race.getAthlete("id");
		assertEquals("id", athlete.getID());
		assertEquals("time", athlete.getTime());
		assertEquals("distance", athlete.getDistance());
	}
	
	@Test
	public void TestAthleteObservers()
	{
		AthleteEvents AE = new AthleteObservers();
		AthleteTracker race = new AthleteTracker();
		Athlete athlete = new Athlete("id", "900", "Speed", "Racer", "Yes", "time", "all");
		race.addAthlete(athlete);
		AE.athleteExecute(race, "id", null, null, null, null, null, null, null, "127.0.0.1:12000");
		
		athlete = race.getAthlete("id");
		assertEquals("id", athlete.getID());
		assertEquals("127.0.0.1:12000", athlete.getObserver("127.0.0.1:12000").getEndPoint());
	}
	
	@Test
	public void RaceChange()throws Exception
	{
		Communicator comm = new Communicator();
		AthleteTracker athletes = new AthleteTracker();
		RaceEvents RC = new RaceChange();
		RaceTracker race = new RaceTracker(comm, athletes);
		assertEquals(null, race.getRaceName());
		assertEquals(null, race.getDistance());
		
		RC.raceExecute(race, "big race", "100 years");
		assertEquals("big race", race.getRaceName());
		assertEquals("100 years", race.getDistance());		
	}
	
	@Test
	public void ClientSubscribe()
	{
		ClientEvents CE = new ClientSubscribe();
		AthleteTracker race = new AthleteTracker();
		Athlete athlete = new Athlete("id", "900", "Speed", "Racer", "Yes", "time", "all");
		race.addAthlete(athlete);
		
		assertEquals(null, athlete.getObserver("123456789"));
		
		CE.clientExecute(race, "id", "123456789");
		athlete = race.getAthlete("id");
		athlete.addObserver("123456789");
		
		assertEquals("123456789", athlete.getObserver("123456789").getEndPoint());
	}
	
	@Test
	public void ClientUnsubscribe()
	{
		ClientEvents CE = new ClientSubscribe();
		AthleteTracker race = new AthleteTracker();
		Athlete athlete = new Athlete("id", "900", "Speed", "Racer", "Yes", "time", "all");
		race.addAthlete(athlete);
		
		assertEquals(null, athlete.getObserver("123456789"));
		
		CE.clientExecute(race, "id", "123456789");
		athlete = race.getAthlete("id");
		athlete.addObserver("123456789");
		
		assertEquals("123456789", athlete.getObserver("123456789").getEndPoint());
		
		CE = new ClientUnsubscribe();
		CE.clientExecute(race, "id", "123456789");
		assertEquals(null, athlete.getObserver("123456789"));
	}
	

}
