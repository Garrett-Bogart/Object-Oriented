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
import communicator.MessageProcessor;
import communicator.RaceTracker;
import athlete.Athlete;
import athlete.AthleteTracker;
import athlete.Race;

public class TestRaceMessage {
	
	@Test
	public void TestRaceMessageConstructor()throws Exception
	{	Race comm_race = new Race();
		Communicator comm1 = new Communicator();
		
		Communicator comm = new Communicator(comm_race);
		MessageProcessor processor = new MessageProcessor("Reciever");
		comm.setProcessor(processor);
		comm.start();
		
		InetAddress ip = InetAddress.getLocalHost();
		int port = 12000;
		String msg = "Registered,check, 9001";
		Message message = new RaceMessage();
		AthleteTracker athletes = new AthleteTracker();
		RaceTracker raceTracker = new RaceTracker();
		//Race race = raceTracker.getRace();
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
		
		raceTracker.getRace().setRaceName("best race");
		raceTracker.getRace().setDistance("1000");
		RaceEvents RE = message.getRaceEvents();
		NotifyEvents NE = message.getNotifyEvents();
		AthleteEvents AE = message.getAthleteEvents();
		ClientEvents CE = message.getClientEvents();
		RE.raceExecute(raceTracker.getRace(), msg);
		AE.athleteExecute(athletes, athlete1, ip, port);
		CE.clientExecute(athletes, msg, ip, port);
		NE.notifyExecute(msg, raceTracker.getRace(), ip, port,athlete1, athletes);
/****************** Part two sending the message from a communicator**/		
		comm1.send("Race,coolest Race, 900m", ip, comm.getLocalPort());	
	}

	
}
