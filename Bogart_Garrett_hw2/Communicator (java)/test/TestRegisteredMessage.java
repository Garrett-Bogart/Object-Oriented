package test;

import static org.junit.Assert.assertEquals;

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
import communicator.MessageProcessor;
import communicator.RaceTracker;
import message.Message;
import message.SubscribeMessage;
import observer.Observers;

public class TestRegisteredMessage {
	@Test
	public void TestRegistered()throws Exception
	{	
		RaceTracker raceTracker = new RaceTracker();
		raceTracker.start();
		Race comm_race = new Race();
		
		Communicator comm1 = new Communicator();
		
		Communicator comm = new Communicator(comm_race);
		MessageProcessor processor = new MessageProcessor("Reciever");
		comm.setProcessor(processor);
		comm.start();
		
		InetAddress ip = InetAddress.getLocalHost();


/****************** Part two sending the message from a communicator**/	
		comm1.send("Registered, 12, 100, RaRa, Rasputin, dance machine, 18", ip, raceTracker.getCommunicator().getLocalPort());	
		Thread.sleep(50);
		Athlete athlete = raceTracker.getAthleteTacker().getAthlete("12");
		assertEquals("12", athlete.getID());
		assertEquals("100", athlete.getTime());
		assertEquals("RaRa", athlete.getFirstName());
		assertEquals("Rasputin", athlete.getLastName());
		assertEquals("dance machine", athlete.getGender());
		assertEquals("18", athlete.getAge());
			
		comm1.close();
		raceTracker.getCommunicator().close();
		comm.close();

	}
}
