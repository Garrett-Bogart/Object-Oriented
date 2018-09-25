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
import message.DidNotFinishMessage;
import message.Message;

public class TestFinishedMessage {
	@Test
	public void TestFinished()throws Exception
	{	
		RaceTracker raceTracker = new RaceTracker();
		Race comm_race = new Race();
		Communicator comm1 = new Communicator();
		
		Communicator comm = new Communicator(comm_race);
		MessageProcessor processor = new MessageProcessor("Reciever");
		comm.setProcessor(processor);
		comm.start();
		
		InetAddress ip = InetAddress.getLocalHost();
		int port = 12000;
		String msg = "Finished, 10, 6:53";
		Message message = new DidNotFinishMessage();

		//Race race = raceTracker.getRace();
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
		
		Athlete temp = new Athlete("10","6:53");
		temp.setStatus("Finished");
		
		raceTracker.getRace().setRaceName("best race");
		raceTracker.getRace().setDistance("1000");
		RaceEvents RE = message.getRaceEvents();
		NotifyEvents NE = message.getNotifyEvents();
		AthleteEvents AE = message.getAthleteEvents();
		ClientEvents CE = message.getClientEvents();
		RE.raceExecute(raceTracker.getRace(), msg);
		AE.athleteExecute(athleteTracker, temp, ip, port);
		CE.clientExecute(athleteTracker, msg, ip, port);
		NE.notifyExecute(msg, raceTracker.getRace(), ip, port,athlete1, athleteTracker);
		assertEquals("Finished", athlete1.getStatus());
		assertEquals("6:53", athlete1.getTime());
		
/****************** Part two sending the message from a communicator**/	
		//should fail because there is no way to give an active athletes list to a test.
		comm1.send("Finished, 12, 6:53", ip, raceTracker.getCommunicator().getLocalPort());	
		assertEquals("Finished", athlete1.getStatus());
		assertEquals("6:53", athlete1.getTime());
		
		comm1.send("Finished, 15, 6:53", ip, raceTracker.getCommunicator().getLocalPort());	

	}
}
