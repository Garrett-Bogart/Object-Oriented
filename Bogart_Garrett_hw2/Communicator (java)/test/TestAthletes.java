package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.net.InetAddress;
import java.net.SocketException;

import org.junit.Test;

import athlete.AthleteTracker;
import athlete.Athlete;
import athlete.Status;
import communicator.Communicator;
import observer.Observers;

public class TestAthletes {
	@Test
	public void testConstruction()
	{
		Athlete athlete1 = new Athlete("10", "14", "a", "a", "m", "70");
		Athlete athlete2 = new Athlete("11", "14", "b", "b", "m", "70");
		Athlete athlete3 = new Athlete("12", "14", "c", "c", "m", "70");
		Athlete athlete4 = new Athlete("13", "14", "d", "d", "m", "70");
		Athlete athlete5 = new Athlete("14", "14", "e", "e", "m", "70");
		AthleteTracker athletes = new AthleteTracker();
		athletes.addAthlete(athlete1);
		athletes.addAthlete(athlete2);
		athletes.addAthlete(athlete3);
		athletes.addAthlete(athlete4);
		athletes.addAthlete(athlete5);
		Athlete test = athletes.getAthlete("10");
		assertEquals("a",test.getFirstName());
		assertEquals("a",test.getLastName());
		
		test = athletes.getAthlete("11");
		assertEquals("b",test.getFirstName());
		assertEquals("b",test.getLastName());

		test = athletes.getAthlete("12");
		assertEquals("c",test.getFirstName());
		assertEquals("c",test.getLastName());
		

		test = athletes.getAthlete("13");
		assertEquals("d",test.getFirstName());
		assertEquals("d",test.getLastName());

		test = athletes.getAthlete("14");
		assertEquals("e",test.getFirstName());
		assertEquals("e",test.getLastName());
		
		test = athletes.getAthlete("15");
		assertEquals(null,test);


	}
	
	@Test
	public void TestUpdateAthlete()
	{
		AthleteTracker at = new AthleteTracker();
		Athlete athlete1 = new Athlete("10", "14", "a", "a", "m", "70");
		Athlete athlete2 = new Athlete("11", "7:43", "b", "b", "m", "70");
		athlete2.setStatus("jgaksda");
		at.addAthlete(athlete1);
		at.updateAthlete(athlete1, athlete2);
		assertEquals("jgaksda",athlete1.getStatus());

	}
	
	@Test
	public void TestAddSubscriber() throws Exception
	{
		AthleteTracker at = new AthleteTracker();
		Communicator comm = new Communicator();
		InetAddress ip = InetAddress.getLocalHost();
		
		assertEquals(0, at.getObservers().size());
		at.addObserver(ip, comm.getLocalPort());
		assertEquals(1, at.getObservers().size());
		Observers obs= at.getObserver(ip, comm.getLocalPort());
		assertEquals(ip, obs.getIP());
		assertEquals(comm.getLocalPort(), obs.getPort());
		
		at.removeObserver(ip, comm.getLocalPort());
		
		obs= at.getObserver(ip, comm.getLocalPort());
		assertNull(obs);
		assertEquals(0, at.getObservers().size());
		
		comm.close();
	}
}
