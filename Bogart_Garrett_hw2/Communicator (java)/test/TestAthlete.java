package test;
import org.junit.Test;

import athlete.Athlete;
import athlete.Status;
import observer.Observers;

import static org.junit.Assert.*;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestAthlete {

	@Test
	public void testConstruction()
	{
		Athlete athlete = new Athlete("10", "14", "cool", "guy", "m", "70");
		assertEquals("10", athlete.getID());
		assertEquals("14", athlete.getTime());
		assertEquals("cool", athlete.getFirstName());
		assertEquals("guy", athlete.getLastName());
		assertEquals("m", athlete.getGender());
		assertEquals("70", athlete.getAge());
		assertEquals("Registered", athlete.getStatus());
		
		athlete.setID("12");
		athlete.setTime("12");
		athlete.setFirstName("guy");
		athlete.setLastName("cool");
		athlete.setGender("f");
		athlete.setAge("12");
		athlete.setStatus("cool");
		athlete.setDistance("420");
		
		assertEquals("12", athlete.getID());
		assertEquals("12", athlete.getTime());
		assertEquals("guy", athlete.getFirstName());
		assertEquals("cool", athlete.getLastName());
		assertEquals("f", athlete.getGender());
		assertEquals("12", athlete.getAge());
		assertEquals("cool", athlete.getStatus());
		assertEquals("420", athlete.getDistance());
	}
	
	@Test
	public void testObservers() throws UnknownHostException
	{
		InetAddress ip = InetAddress.getLocalHost();
		int port = 12000;
		Athlete athlete = new Athlete("10", "14", "cool", "guy", "m", "70");
		athlete.addObserver(ip ,port);
		assertEquals(InetAddress.getLocalHost(), athlete.getObserver(ip, port).getIP());
		assertEquals(12000, athlete.getObserver(ip, port).getPort());
		assertEquals(1, athlete.getObservers().size());
		
		athlete.removeObserver(ip, port);
		Observers obs = athlete.getObserver(ip, port);
		assertEquals(null, obs);
		
		ip = InetAddress.getByName("127.0.0.3");
		port = 12;
		athlete.removeObserver(ip,port);
		obs = athlete.getObserver(ip, port);
		assertEquals(null, obs);
	}
	
	//need to come up with cases where it fails
	
}
