package test;
import org.junit.Test;

import athlete.Athlete;
import athlete.Status;

import static org.junit.Assert.*;

public class TestAthlete {

	@Test
	public void testConstruction()
	{
		Athlete athlete = new Athlete(10, 14, "cool", "guy", 'm', 70);
		assertEquals(10, athlete.getID(), 0);
		assertEquals(14, athlete.getTime(), 0);
		assertEquals("cool", athlete.getFirstName());
		assertEquals("guy", athlete.getLastName());
		assertEquals('m', athlete.getGender());
		assertEquals(70, athlete.getAge(), 0);
		assertEquals(Status.Registered, athlete.getStatus());
		
		athlete.setID(12);
		athlete.setTime(12);
		athlete.setFirstName("guy");
		athlete.setLastName("cool");
		athlete.setGender('f');
		athlete.setAge(12);
		athlete.setStatus(Status.Finished);

		assertEquals(12, athlete.getID(), 0);
		assertEquals(12, athlete.getTime(), 0);
		assertEquals("cool", athlete.getLastName());
		assertEquals("guy", athlete.getFirstName());
		assertEquals('f', athlete.getGender());
		assertEquals(12, athlete.getAge(), 0);
		assertEquals(Status.Finished, athlete.getStatus());
	}
	
}
