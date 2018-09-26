package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.net.InetAddress;
import java.net.SocketException;

import org.junit.Test;

import athlete.Athlete;
import athlete.AthleteTracker;
import athlete.Race;
import behaviors.AthleteEvents;
import behaviors.ClientEvents;
import behaviors.NotifyEvents;
import behaviors.RaceEvents;
import communicator.Communicator;
import communicator.MessageProcessor;
import communicator.RaceTracker;
import message.Message;
import message.SubscribeMessage;
import message.UnsubscribeMessage;
import observer.Observers;

public class TestUnsubscribeMessage {
	@Test
	public void TestSubscribe()throws Exception
	{	
		RaceTracker raceTracker = new RaceTracker();
		raceTracker.start();
		Race comm_race = new Race();
		Communicator comm1 = new Communicator();
			
		InetAddress ip = InetAddress.getLocalHost();
		int port = 12000;
		String msg = "Finished, 10, 6:53";
		Message message = new UnsubscribeMessage();

		//Race race = raceTracker.getRace();
		AthleteTracker athleteTracker = raceTracker.getAthleteTacker();
		Athlete athlete1 = new Athlete("10", "14", "a", "a", "m", "70");
		Athlete athlete2 = new Athlete("11", "14", "b", "b", "m", "70");

		athleteTracker.addAthlete(athlete1);
		athleteTracker.addAthlete(athlete2);

		
		assertEquals(athleteTracker.getAthletes().size(), raceTracker.getAthleteTacker().getAthletes().size());
		
		Athlete temp = new Athlete("10","6:53");
		temp.setStatus("Finished");
		
		athlete1.addObserver(ip, comm1.getLocalPort());
		athlete2.addObserver(ip, comm1.getLocalPort());
		
		assertEquals(1, athlete2.getObservers().size());
		
		raceTracker.getRace().setRaceName("best race");
		raceTracker.getRace().setDistance("1000");
		RaceEvents RE = message.getRaceEvents();
		NotifyEvents NE = message.getNotifyEvents();
		AthleteEvents AE = message.getAthleteEvents();
		ClientEvents CE = message.getClientEvents();
		RE.raceExecute(raceTracker.getRace(), msg);
		AE.athleteExecute(athleteTracker, athlete1, ip, comm1.getLocalPort());
		CE.clientExecute(athleteTracker, msg, ip, port);
		NE.notifyExecute(msg, raceTracker.getRace(), ip, port,athlete1, athleteTracker);
		
		Observers obs = athlete1.getObserver(ip, port);
		
		assertNull(obs);
	}
	
	@Test
	public void TestCommunicatorSubscribe() throws Exception
	{
			RaceTracker raceTracker = new RaceTracker();
			raceTracker.start();
			Race comm_race = new Race();
			raceTracker.start();
			
			Communicator comm1 = new Communicator();				
			InetAddress ip = InetAddress.getLocalHost();
			int port = 12000;
			String msg = "Finished, 10, 6:53";
			Observers obs;
			Athlete athlete1 = new Athlete("12", "14", "a", "a", "m", "70");
			raceTracker.getAthleteTacker().addAthlete(athlete1);
			
			
			comm1.send("Subscribe, 12", ip, raceTracker.getCommunicator().getLocalPort());
			
			
			Thread.sleep(50);
			assertEquals("12", raceTracker.getAthleteTacker().getAthlete("12").getID());
			assertEquals(1, raceTracker.getAthleteTacker().getAthlete("12").getObservers().size());


	/****************** Part two sending the message from a communicator**/		
			
			System.out.println(ip+" : "+raceTracker.getCommunicator().getLocalPort()+"**********");
			System.out.println(ip+" : "+comm1.getLocalPort()+"**********");
			comm1.send("Unsubscribe, 12", ip, raceTracker.getCommunicator().getLocalPort());
			Thread.sleep(50);
			obs = raceTracker.getAthleteTacker().getAthlete("12").getObserver(ip, comm1.getLocalPort());
			assertNull(obs);
			comm1.close();
			raceTracker.getCommunicator().close();

	}	
}
