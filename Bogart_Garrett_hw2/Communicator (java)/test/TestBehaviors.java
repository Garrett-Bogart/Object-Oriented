package test;

import static org.junit.Assert.assertEquals;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Vector;

import org.junit.Test;

import athlete.AthleteTracker;
import athlete.Race;
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
import observer.Observers;
import behaviors.RaceChange;

public class TestBehaviors {
	
	@Test
	public void TestAthleteAdd() throws UnknownHostException
	{
		InetAddress ip = InetAddress.getByName("127.0.0.1");
		Race race = new Race();
		AthleteEvents AE = new AthleteAdd();
		AthleteTracker athleteTracker = new AthleteTracker();
		Athlete athlete = new Athlete("10", "900", "Speed", "Racer", "gender", "time");
		AE.athleteExecute(athleteTracker, athlete, ip, 12);
		
		Athlete temp = athleteTracker.getAthlete("10");
		assertEquals(0, temp.getObservers().size(), 0);
		assertEquals("10", temp.getID());
	}
	
	@Test
	public void TestAthleteUpdate() throws UnknownHostException
	{
		InetAddress ip = InetAddress.getByName("127.0.0.1");
		AthleteEvents AE = new AthleteUpdate();
		AthleteTracker athleteTracker = new AthleteTracker();
		Athlete athleteBase = new Athlete("id", "900", "Speed", "Racer", "Yes", "time");
		Athlete athleteUpdater = new Athlete("id", "987654", "distance");
		athleteTracker.addAthlete(athleteBase);
		AE.athleteExecute(athleteTracker, athleteUpdater, ip, 12);
		
		Athlete temp  = athleteTracker.getAthlete("id");
		assertEquals("id", temp.getID());
		assertEquals("987654", temp.getTime());
		assertEquals("distance", temp.getDistance());
	}
	
	@Test
	public void TestAthleteObservers() throws UnknownHostException
	{
		InetAddress ip = InetAddress.getLocalHost();
		int port = 12000;
		AthleteEvents AE = new AthleteObservers();
		AthleteTracker athleteTracker = new AthleteTracker();
		Athlete athlete = new Athlete("id", "900", "Speed", "Racer", "Yes", "time");
		athleteTracker.addAthlete(athlete);
		AE.athleteExecute(athleteTracker, athlete, ip, port);
		
		Athlete temp = athleteTracker.getAthlete("id");
		assertEquals("id", temp.getID());
		assertEquals(ip, temp.getObserver(ip, port).getIP());
		assertEquals(port, temp.getObserver(ip, port).getPort());
	}
	
	@Test
	public void RaceChange()throws Exception
	{
		Communicator comm = new Communicator();
		AthleteTracker athletes = new AthleteTracker();
		RaceEvents RC = new RaceChange();
		Race race = new Race();
		assertEquals(null, race.getRaceName());
		assertEquals(null, race.getDistance());
		
		RC.raceExecute(race, "Registered, big race, 100 years");
		assertEquals("big race", race.getRaceName());
		assertEquals("100 years", race.getDistance());		
	}
	
	@Test
	public void ClientSubscribe() throws UnknownHostException
	{
		InetAddress ip = InetAddress.getLocalHost();
		int port = 12000;
		ClientEvents CE = new ClientSubscribe();
		AthleteTracker athleteTracker = new AthleteTracker();
		Athlete athlete = new Athlete("10", "14", "cool", "guy", "m", "70");
		athleteTracker.addAthlete(athlete);
		
		assertEquals(1, athleteTracker.getAthletes().size(), 0);		
		assertEquals(null, athlete.getObserver(ip, port));
		
		CE.clientExecute(athleteTracker, "message, 10",ip, port);
		Athlete temp = athleteTracker.getAthlete("10");
		
		assertEquals(1, temp.getObservers().size(),0);
		Vector<Observers> observers = temp.getObservers();
		assertEquals(ip, temp.getObserver(ip, port).getIP());
		assertEquals(port, temp.getObserver(ip, port).getPort());		
	}
	
	@Test
	public void ClientUnsubscribe() throws UnknownHostException
	{
		InetAddress ip = InetAddress.getLocalHost();
		int port = 12000;
		ClientEvents CE = new ClientSubscribe();
		AthleteTracker athleteTracker = new AthleteTracker();
		Athlete athlete = new Athlete("10", "14", "cool", "guy", "m", "70");
		athleteTracker.addAthlete(athlete);
		
		assertEquals(1, athleteTracker.getAthletes().size(), 0);		
		assertEquals(null, athlete.getObserver(ip, port));
		
		CE.clientExecute(athleteTracker, "message, 10",ip, port);
		Athlete temp = athleteTracker.getAthlete("10");
		
		assertEquals(1, temp.getObservers().size(),0);
		Vector<Observers> observers = temp.getObservers();
		assertEquals(ip, temp.getObserver(ip, port).getIP());
		assertEquals(port, temp.getObserver(ip, port).getPort());
		
		CE = new ClientUnsubscribe();
		CE.clientExecute(athleteTracker, "message, 10",ip, port);
		temp = athleteTracker.getAthlete("10");
		assertEquals(0, temp.getObservers().size());
	}
	

}
