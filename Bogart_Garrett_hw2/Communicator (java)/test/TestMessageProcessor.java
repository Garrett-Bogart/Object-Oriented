package test;
import static org.junit.Assert.assertEquals;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Test;

import athlete.AthleteTracker;
import athlete.Race;
import athlete.Athlete;
import athlete.Status;
import communicator.Communicator;
import communicator.IMessageProcessor;
import communicator.MessageProcessor;
import communicator.RaceTracker;
import message.Message;

public class TestMessageProcessor {
	@Test
	public void testMessageProcess() throws Exception
	{
		Communicator comm = new Communicator();
		AthleteTracker athleteTracker = new AthleteTracker();
		RaceTracker raceTracker = new RaceTracker();
		Race race = new Race();
		IMessageProcessor process = new MessageProcessor("Name");
		Athlete athlete = new Athlete("10", "14", "cool", "guy", "m", "70");
		String message = "Race, Race's Name, distance";
		InetAddress ip = InetAddress.getLocalHost();
		int port = 12000;
		Message mesg;
		Message same;

		
		
		

		mesg = process.process(message, ip, port);
		
	}
	
	@Test
	public void testMakeAthlete()
	{
		IMessageProcessor process = new MessageProcessor("Name");
		String message = "Registered,<bib number>,<time>,<first name>, <lastname>,<gender>,<age>";
		Athlete athlete = process.makeAthlete(message);
		assertEquals("<bib number>", athlete.getID());
		assertEquals("<time>", athlete.getTime());
		assertEquals("<first name>", athlete.getFirstName());
		assertEquals("<lastname>", athlete.getLastName());
		assertEquals("<gender>", athlete.getGender());
		assertEquals("<age>", athlete.getAge());
		
		message = "DidNotStart,<id>,<time>";
		athlete = process.makeAthlete(message);
		assertEquals("<id>", athlete.getID());
		assertEquals("<time>", athlete.getTime());
		
		message = "Started,<id>,<time>";
		athlete = process.makeAthlete(message);
		assertEquals("<id>", athlete.getID());
		assertEquals("<time>", athlete.getTime());
		
		message = "Finished,<id>,<time>";
		athlete = process.makeAthlete(message);
		assertEquals("<id>", athlete.getID());
		assertEquals("<time>", athlete.getTime());
		
		message = "Status,<bib number>,<status>,<start time>, <distance covered in meters>,<last updated time>,<finished time>";
		athlete = process.makeAthlete(message);
		assertEquals("<status>", athlete.getStatus());
		assertEquals("<bib number>", athlete.getID());
		assertEquals("<start time>", athlete.getStartTime());
		assertEquals("<distance covered in meters>", athlete.getDistance());
		assertEquals("<last updated time>", athlete.getLastUpdate());
		assertEquals("<finished time>", athlete.getFinishTime());
		
	}
}
