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
			if(id.equals(athlete.getID()))
			{
				return athlete;
			}
		}
		return null;
	}
	
	public void updateAthlete(Athlete athleteBase, Athlete athleteUpdater)
	{
		if(athleteUpdater.getTime() != null)
			athleteBase.setTime(athleteUpdater.getTime());
		if(athleteUpdater.getStatus() != null)
			athleteBase.setStatus(athleteUpdater.getStatus());
		if(athleteUpdater.getDistance() != null)
			athleteBase.setDistance(athleteUpdater.getDistance());
	}

	public Vector<Athlete> getAthletes(){return athletes;}
}
