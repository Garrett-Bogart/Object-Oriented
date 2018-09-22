package athlete;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class RaceTracker {
	private String raceName;
	private String distance;
	private Vector <Athlete> athletes;
	
	public RaceTracker() {
		this.athletes = new Vector<Athlete>();
	}
	
	public void addAthlete(Athlete a)
	{
		athletes.add(a);
	}
	
	public Athlete getAthlete(String firstName, String lastName)
	{
		for(Athlete athlete : athletes)
		{
			if(athlete.getFirstName() == firstName && athlete.getLastName() == lastName)
			{
				return athlete;
			}
		}
		return null;
	}
	
	public String getRaceName() {return raceName;}
	public String getDistance() {return distance;}
	
	public void setDistance(String dis) {distance = dis;}
	public void setRaceName(String name) {raceName = name;}
	
	
}
