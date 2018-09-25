package test;
import static org.junit.Assert.assertEquals;

import java.net.InetAddress;

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
import athlete.Race;

public class TestRaceMessage {
	
	@Test
	public void TestRaceMessageConstructor()throws Exception
	{
		InetAddress ip = InetAddress.getLocalHost();
		int port = 12000;
		String msg = "Registered,check, 9001";
		Message message = new RaceMessage();
		Communicator comm = new Communicator();
		AthleteTracker athletes = new AthleteTracker();
		RaceTracker raceTracker = new RaceTracker();
		Race race = raceTracker.getRace();
		Athlete athlete1 = new Athlete("10", "14", "a", "a", "m", "70");
		Athlete athlete2 = new Athlete("10", "14", "b", "b", "m", "70");
		Athlete athlete3 = new Athlete("10", "14", "c", "c", "m", "70");
		Athlete athlete4 = new Athlete("10", "14", "d", "d", "m", "70");
		Athlete athlete5 = new Athlete("10", "14", "e", "e", "m", "70");
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
		RE.raceExecute(race, msg);
		AE.athleteExecute(athletes, athlete1, ip, port);
		CE.clientExecute(athletes, msg, ip, port);
		NE.notifyExecute(msg, race, ip, port,athlete1, athletes);
		
		String name = race.getRaceName();
		String distance = race.getDistance();
		assertEquals("check", name);
		assertEquals("9001", distance);
		
		
		
		
	}

	
}
