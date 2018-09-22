package test;
import org.junit.Test;

import athlete.Athlete;
import athlete.Status;

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

		String id = athlete.getID();
		String time = athlete.getTime();
		String firstName = athlete.getFirstName();
		String lastName = athlete.getLastName();
		String gender = athlete.getGender();
		String age = athlete.getAge();
		String status = athlete.getStatus();
		
		assertEquals("12", id);
		assertEquals("12", time);
		assertEquals("cool", lastName);
		assertEquals("guy", firstName);
		assertEquals("f", gender);
		assertEquals("12", age);
		assertEquals("cool", status);
	}
	
	//need to come up with cases where it fails
	
}
