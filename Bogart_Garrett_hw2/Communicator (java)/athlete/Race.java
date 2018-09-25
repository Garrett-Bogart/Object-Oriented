package athlete;

import java.net.InetAddress;
import java.util.Vector;

import observer.Client;
import observer.Observers;

public class Race {
	private Vector<Observers> observers;
	private String raceName;
	private String distance;
	
	public Race()
	{
		observers = new Vector<Observers>();
	}
	
	public void addObserver(InetAddress ip, int port)
	{
		Observers client = new Client( ip,  port);
		int found = findObserver( ip,  port);
		if(found != 0)
		{
			observers.add(client);
		}
	}
	
	public int findObserver(InetAddress ip, int port)
	{
		for(Observers obs : observers)
		{
			if(obs.getPort() == port && obs.getIP() == ip)
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
	public void setObservers(Vector<Observers> obs) {observers = obs;}
}
