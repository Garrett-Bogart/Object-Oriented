package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.net.InetAddress;

import org.junit.Test;

import athlete.Athlete;
import athlete.AthleteTracker;
import athlete.Race;
import behaviors.AthleteEvents;
import behaviors.ClientEvents;
import behaviors.NotifyEvents;
import behaviors.RaceEvents;
import communicator.Communicator;
import communicator.DummyMessageProcessor;
import communicator.MessageProcessor;
import communicator.RaceTracker;
import message.AthleteMessage;
import message.DidNotStartMessage;
import message.Message;

public class TestDidNotStart {
	@Test
	public void testDidNotStartMessage() throws Exception
	{
		RaceTracker raceTracker = new RaceTracker();
		raceTracker.start();
		Race comm_race = new Race();
		Communicator comm1 = new Communicator();
		
		InetAddress ip = InetAddress.getLocalHost();

		
		Communicator comm = new Communicator(comm_race);
		DummyMessageProcessor processor = new DummyMessageProcessor("Reciever");
		comm.setProcessor(processor);
		comm.start();
	

		AthleteTracker athleteTracker = raceTracker.getAthleteTacker();
		Athlete athlete1 = new Athlete("10", "14", "a", "a", "m", "70");
		Athlete athlete2 = new Athlete("11", "14", "b", "b", "m", "70");
		Athlete athlete3 = new Athlete("12", "14", "c", "c", "m", "70");
		Athlete athlete4 = new Athlete("13", "14", "d", "d", "m", "70");
		Athlete athlete5 = new Athlete("14", "14", "e", "e", "m", "70");
		athleteTracker.addAthlete(athlete1);
		athleteTracker.addAthlete(athlete2);
		athleteTracker.addAthlete(athlete3);
		athleteTracker.addAthlete(athlete4);
		athleteTracker.addAthlete(athlete5);
	
/****************** Part two sending the message from a communicator**/	
		//should fail because there is no way to give an active athletes list to a test.

		comm1.send("DidNotStart, 12, 6:53", InetAddress.getLocalHost(), raceTracker.getCommunicator().getLocalPort());
		Thread.sleep(50);
		Athlete beforeUpdate = raceTracker.getAthleteTacker().getAthlete("12");
		assertEquals("DidNotStart",beforeUpdate.getStatus() );
		assertEquals("6:53", athlete3.getTime());
		
		comm1.send("DidNotStart, 15, 6:53", ip, raceTracker.getCommunicator().getLocalPort());	
		comm1.close();
		comm.close();
		raceTracker.getCommunicator().close();

	}
}
