package test;

import java.net.InetAddress;

import org.junit.Test;
import static org.junit.Assert.*;

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
import message.RaceMessage;

public class TestDidNotFinishMessage {
	@Test
	public void TestDidNotFinish()throws Exception
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
		int port = 12000;
		String msg = "DidNotFinish, 10, 6:53";
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
		raceTracker.getAthleteTacker().addAthlete(athlete1);
		raceTracker.getAthleteTacker().addAthlete(athlete2);
		raceTracker.getAthleteTacker().addAthlete(athlete3);
		raceTracker.getAthleteTacker().addAthlete(athlete4);
		raceTracker.getAthleteTacker().addAthlete(athlete5);
		
		Athlete temp = new Athlete("10","6:53");
		temp.setStatus("DidNotFinish");
		
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
		assertEquals("DidNotFinish", athlete1.getStatus());
		assertEquals("6:53", athlete1.getTime());
		
/****************** Part two sending the message from a communicator**/	
		//should fail because there is no way to give an active athletes list to a test.
		comm1.send("DidNotFinish, 12, 6:53", ip, raceTracker.getCommunicator().getLocalPort());	
		Thread.sleep(50);
		assertEquals("DidNotFinish", athlete3.getStatus());
		assertEquals("6:53", athlete1.getTime());
		
		comm1.send("DidNotFinish, 15, 6:53", ip, raceTracker.getCommunicator().getLocalPort());	
		
		comm1.close();
		comm.close();
		raceTracker.getCommunicator().close();

	}

}
