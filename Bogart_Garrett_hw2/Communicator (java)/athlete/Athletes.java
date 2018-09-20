package athlete;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Athletes {
	private Vector <Athlete> athletes;
	
	public Athletes() {
		this.athletes = new Vector<Athlete>();
	}
	
	public void add(Athlete a)
	{
		athletes.add(a);
	}
	
	public Athlete getAthlete(String firstName, String lastName)
	{
		Athlete container;
		for(Athlete athlete : athletes)
		{
			if(athlete.getFirstName() == firstName && athlete.getLastName() == lastName)
			{
				return athlete;
			}
		}
		return null;
	}
	
}
