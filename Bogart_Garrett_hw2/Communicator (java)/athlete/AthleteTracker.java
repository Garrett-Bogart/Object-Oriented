package athlete;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import observer.Client;
import observer.Observers;

public class AthleteTracker {
	//private String raceName;
	//private String distance;
	private Vector <Athlete> athletes;
	//private Vector<Observers> observers;
	
	public AthleteTracker() {
		this.athletes = new Vector<Athlete>();
		//this.observers = new Vector<Observers>();
	}
	
	public void addAthlete(Athlete a)
	{
		athletes.add(a);
	}
		
	public Athlete getAthlete(String id)
	{
		for(Athlete athlete : athletes)
		{
			if(athlete.getID() == id)
			{
				return athlete;
			}
		}
		return null;
	}

}
