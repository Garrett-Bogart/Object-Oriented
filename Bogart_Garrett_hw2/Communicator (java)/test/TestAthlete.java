package test;
import org.junit.Test;

import athlete.Athlete;
import athlete.Status;
import observer.Observers;

import static org.junit.Assert.*;

public class TestAthlete {

	@Test
	public void testConstruction()
	{
		Athlete athlete = new Athlete("10", "14", "cool", "guy", "m", "70", "registered");
		assertEquals("10", athlete.getID());
		assertEquals("14", athlete.getTime());
		assertEquals("cool", athlete.getFirstName());
		assertEquals("guy", athlete.getLastName());
		assertEquals("m", athlete.getGender());
		assertEquals("70", athlete.getAge());
		assertEquals("registered", athlete.getStatus());
		
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
	public void testObservers()
	{
		Athlete athlete = new Athlete("10", "14", "cool", "guy", "m", "70", "registered");
		athlete.addObserver("123456789");
		String endpoint = athlete.getObserver("123456789").getEndPoint();
		assertEquals("123456789", endpoint);
		
		athlete.removeObserver(endpoint);
		Observers obs = athlete.getObserver("123456789");
		assertEquals(null, obs);
		
		athlete.removeObserver("adfasdf");
		obs = athlete.getObserver("11111");
		assertEquals(null, obs);
	}
	
	//need to come up with cases where it fails
	
}
