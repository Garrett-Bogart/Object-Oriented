package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
import communicator.MessageProcessor;
import communicator.RaceTracker;
import athlete.Athlete;
import athlete.AthleteTracker;
import athlete.Race;

public class TestRaceMessage {
	
	@Test
	public void TestRaceMessageConstructor()throws Exception
	{	
		RaceTracker raceTracker = new RaceTracker();
		raceTracker.start();
		
		Communicator comm1 = new Communicator();
		
		Communicator comm = new Communicator();
		MessageProcessor processor = new MessageProcessor("Reciever");
		comm.setProcessor(processor);
		comm.start();
		
		InetAddress ip = InetAddress.getLocalHost();
		
		AthleteTracker athletes = raceTracker.getAthleteTacker();
		
		raceTracker.getRace().setRaceName("best race");
		raceTracker.getRace().setDistance("1000");
		assertEquals("best race", raceTracker.getCommunicator().getRace().getRaceName());
		assertEquals("1000", raceTracker.getCommunicator().getRace().getDistance());


/****************** Part two sending the message from a communicator**/	
		assertNotNull(raceTracker.getRace());
		assertNotNull(raceTracker.getCommunicator().getRace());
		comm1.send("Race,coolest Race, 900m", ip, raceTracker.getCommunicator().getLocalPort());	
		Thread.sleep(50);
		assertEquals("coolest Race", raceTracker.getRace().getRaceName());
		assertEquals("900m", raceTracker.getRace().getDistance());
		
		
		comm.close();
		comm1.close();
		raceTracker.getCommunicator().close();
	}

	
}
