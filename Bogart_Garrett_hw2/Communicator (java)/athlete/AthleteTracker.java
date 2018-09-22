package athlete;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import observer.Client;
import observer.Observers;

public class AthleteTracker {
	private String raceName;
	private String distance;
	private Vector <Athlete> athletes;
	private Vector<Observers> observers;
	
	public AthleteTracker() {
		this.athletes = new Vector<Athlete>();
		this.observers = new Vector<Observers>();
	}
	
	public void addAthlete(Athlete a)
	{
		athletes.add(a);
	}
	
	public void addObserver(String endpoint)
	{
		Observers client = new Client(endpoint);
		int found = findObserver(endpoint);
		if(found != 0)
		{
			observers.add(client);
		}
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
	
	public int findObserver(String endpoint)
	{
		for(Observers obs : observers)
		{
			if(obs.getEndPoint() == endpoint)
			{
				return 1;
			}
		}
		return 0;
	}
	
	
	
	public String getRaceName() {return raceName;}
	public String getDistance() {return distance;}
	public Vector<Observers> getObservers(){return observers;}
	
	public void setDistance(String dis) {distance = dis;}
	public void setRaceName(String name) {raceName = name;}
	
	
}
