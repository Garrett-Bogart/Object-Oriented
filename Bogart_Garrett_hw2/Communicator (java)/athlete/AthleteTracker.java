package athlete;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import observer.Client;
import observer.Observers;

public class AthleteTracker {
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
	
	public void addObserver(InetAddress ip, int port) 
	{
		Observers obs = getObserver(ip, port);
		if(obs == null)
		{
			Client client = new Client(ip,  port);
			observers.add(client);
		}
	}
	
	public void removeObserver(InetAddress ip, int port)
	{
		
		for(Iterator<Observers> i = observers.iterator();i.hasNext();)
		{
			Observers obs = i.next();
			if(obs.getPort() == port && obs.getIP() == ip)
			{
				i.remove();
			}
		}
	}
	
	public Observers getObserver(InetAddress ip, int port)
	{
		for(Observers obs : observers)
		{
			if(obs.getPort() == port && obs.getIP() == ip)
			{
				return obs;
			}
		}
		return null;
	}

	public Vector<Athlete> getAthletes(){return athletes;}
}
