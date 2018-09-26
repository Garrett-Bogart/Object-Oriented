package test;

import static org.junit.Assert.assertEquals;

import java.net.InetAddress;
import java.net.UnknownHostException;

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
import message.AthleteMessage;
import message.DidNotFinishMessage;
import message.DidNotStartMessage;
import message.Message;

public class TestAlthleteMessage {
	
	@Test
	public void testAthleteMessage() throws Exception
	{
		RaceTracker raceTracker = new RaceTracker();
		Race comm_race = new Race();
		raceTracker.start();
		Communicator comm1 = new Communicator();
		raceTracker.start();
		
		Communicator comm = new Communicator(comm_race);
		MessageProcessor processor = new MessageProcessor("Reciever");
		comm.setProcessor(processor);
		comm.start();
		
		InetAddress ip = InetAddress.getLocalHost();
		int port = 12000;
		String msg = "DidNotFinish, 10, 6:53";
		Message message = new AthleteMessage();

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
		temp.setStatus("DidNotFinish");
		
		raceTracker.getRace().setRaceName("best race");
		raceTracker.getRace().setDistance("1000");
		AthleteEvents AE = message.getAthleteEvents();
		
		AE.athleteExecute(athleteTracker, temp, ip, port);
		
		assertEquals("DidNotFinish", athlete1.getStatus());
		assertEquals("6:53", athlete1.getTime());
		
/****************** Part two sending the message from a communicator**/	
		//should fail because there is no way to give an active athletes list to a test.

	}
	
	@Test
	public void TestFunctionChain() throws Exception
	{
		RaceTracker raceTracker = new RaceTracker();		
		Communicator comm1 = new Communicator();
		raceTracker.start();
		
		InetAddress ip = InetAddress.getLocalHost();
		
		Athlete athlete3 = new Athlete("12", "14", "c", "c", "m", "70");

		
		raceTracker.getAthleteTacker().addAthlete(athlete3);
		assertEquals(1, raceTracker.getAthleteTacker().getAthletes().size());
		/*Testing function chain*/
		Athlete temp = new Athlete("12","6:53");
		temp.setStatus("Neat");
		assertEquals("12",raceTracker.getAthleteTacker().getAthlete("12").getID() );
		assertEquals("Registered",raceTracker.getAthleteTacker().getAthlete("12").getStatus());
		raceTracker.getAthleteTacker().updateAthlete(athlete3, temp);
		assertEquals("Neat",raceTracker.getAthleteTacker().getAthlete("12").getStatus());
		assertEquals("6:53",raceTracker.getAthleteTacker().getAthlete("12").getTime());

		/*Testing the communicator usage*/
		comm1.send("DidNotFinish, 12, 7:53", ip, raceTracker.getCommunicator().getLocalPort());
		temp = raceTracker.getAthleteTacker().getAthlete("12");
		assertEquals("12", temp.getID());
		assertEquals("DidNotFinish", temp.getStatus());
		
		comm1.send("DidNotFinish, 15, 6:53", ip, raceTracker.getCommunicator().getLocalPort());	
		comm1.close();
		raceTracker.getCommunicator().close();
	}
	
	@Test
	public void TestCommunicator() throws Exception
	{
		RaceTracker raceTracker = new RaceTracker();
		Race comm_race = new Race();
		raceTracker.start();
		Communicator comm1 = new Communicator();
		
		Communicator comm = new Communicator(comm_race);
		MessageProcessor processor = new MessageProcessor("Reciever");
		comm.setProcessor(processor);
		comm.start();
		
		InetAddress ip = InetAddress.getLocalHost();
		int port = 12000;
		String msg = "DidNotFinish, 10, 6:53";
		Message message = new DidNotStartMessage();

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
		assertEquals("DidNotFinish", athlete3.getStatus());
		assertEquals("6:53", athlete1.getTime());
		
		comm1.send("OnCourse, 15, 6:53", ip, raceTracker.getCommunicator().getLocalPort());	
	}
}
