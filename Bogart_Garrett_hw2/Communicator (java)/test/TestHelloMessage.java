package test;

import static org.junit.Assert.assertEquals;

import java.net.InetAddress;
import java.net.SocketException;

import org.junit.Test;

import athlete.Athlete;
import athlete.AthleteTracker;
import athlete.Race;
import communicator.Communicator;
import communicator.DummyMessageProcessor;
import communicator.RaceTracker;
import observer.Observers;

public class TestHelloMessage {

		@Test
		public void TestHello() throws Exception
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

			comm1.send("Hello", InetAddress.getLocalHost(), raceTracker.getCommunicator().getLocalPort());
			Thread.sleep(50);
			Observers obs  = raceTracker.getAthleteTacker().getObserver(ip, comm1.getLocalPort());
			assertEquals(1, raceTracker.getAthleteTacker().getObservers().size());
			System.out.println("adding client to athletedsadTracker: "+ip+" : "+comm1.getLocalPort());
			assertEquals(ip, obs.getIP());
			assertEquals(comm1.getLocalPort(), obs.getPort());
			
			comm1.send("Finished, 15, 6:53", ip, raceTracker.getCommunicator().getLocalPort());	
			comm1.close();
			comm.close();
			raceTracker.getCommunicator().close();
		}
		
		@Test
		public void TestHelloBefore() throws Exception
		{
			RaceTracker race = new RaceTracker();
			race.start();
			Communicator comm1 = new Communicator();
			
			comm1.send("Hello", InetAddress.getLocalHost(), race.getCommunicator().getLocalPort());
			Thread.sleep(50);
			assertEquals(1, race.getAthleteTacker().getObservers().size());
			
			
			comm1.close();
			race.getCommunicator().close();
		}
}
