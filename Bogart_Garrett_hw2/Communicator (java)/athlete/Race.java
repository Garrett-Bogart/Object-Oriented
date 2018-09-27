package athlete;

import java.net.InetAddress;
import java.util.Iterator;
import java.util.Vector;

import observer.Client;
import observer.Observers;

public class Race {
	private Vector<Observers> observers;
	private String raceName;
	private String distance;
	private boolean started;
	
	public Race()
	{
		raceName = "";
		distance = "";
		started = false;
		observers = new Vector<Observers>();
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
	
	public String getRaceName() {return raceName;}
	public String getDistance() {return distance;}
	public Vector<Observers> getObservers(){return observers;}
	public boolean getStartStatus() {return started;}
	
	public void setDistance(String dis) {distance = dis;}
	public void setRaceName(String name) {raceName = name;}
	public void setObservers(Vector<Observers> obs) {observers = obs;}
	public void setStarted(boolean start) {started = start;}
}
