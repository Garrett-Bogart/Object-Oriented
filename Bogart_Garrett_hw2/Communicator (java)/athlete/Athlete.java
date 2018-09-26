package athlete;
import observer.Client;
import observer.Observers;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.Vector;

public class Athlete {
	private String firstName;
	private String lastName;
	private String time;
	private String age;
	private Vector<Observers> observers;
	private String ID;
	private String gender;
	private String status;
	private String distance;
	private String startTime;
	private String finishedTime;
	private String lastUpdate;//prolly need this to be an int

	
	public Athlete(String ID, String time, String firstName, String lastName, String gender, String age) 
	{
		this.firstName= firstName;
		this.lastName= lastName;
		this.time= time;
		this.startTime = time;
		this.age= age;
		this.ID = ID;
		this.gender= gender;
		this.status ="Registered";
		observers = new Vector<Observers>();
	}
	
	public Athlete(String ID, String time, String distance) 
	{
		this.firstName= null;
		this.lastName= null;
		this.time= time;
		this.age= null;
		this.ID = ID;
		this.gender= null;
		this.distance =distance;
		observers = new Vector<Observers>();
	}
	
	public Athlete(String ID, String time) 
	{
		this.firstName= null;
		this.lastName= null;
		this.time= time;
		this.age= null;
		this.ID = ID;
		this.gender= null;
		this.distance =null;
		observers = new Vector<Observers>();
	}
	
	public Athlete(String ID, String status, String distance, String lastUpdate, String finishedTime)
	{
		this.firstName= null;
		this.lastName= null;
		this.time= time;
		this.age= null;
		this.ID = ID;
		this.gender= null;
		this.status =status;
		this.distance = distance;
		this.lastUpdate = lastUpdate;
		this.finishedTime = finishedTime;
		observers = new Vector<Observers>();
	}
	
	public void addObserver(InetAddress ip, int port) 
	{
		Observers obs = getObserver(ip, port);
		if(obs == null)
		{
			Client client = new Client(ip,  port);
			System.out.println(ip+"hjkhfadjksfhajkshuirewtuiserghjsdgfsadf");
			observers.add(client);
		}
	}
	
	public void removeObserver(InetAddress ip, int port)
	{		
		System.out.println("Removing: "+ip+" "+port+"+++++++++");

		for(Iterator<Observers> i = observers.iterator();i.hasNext();)
		{
			Observers obs = i.next();
			System.out.println(obs.getIP()+" "+obs.getPort()+"+++++++++");
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
	
	public String getDistance() {return distance;}
	public String getID() {return ID;}
	public String getTime() {return time;}
	public String getStartTime() {return startTime;}
	public String getFinishTime() {return finishedTime;}
	public String getFirstName() {return firstName;}
	public String getLastName() {return lastName;}
	public String getGender() {return gender;}
	public String getAge() {return age;}
	public String getStatus() {return status;}
	public Vector<Observers> getObservers() {return observers;}
	public String getLastUpdate() {return lastUpdate;}
	
	public void setDistance(String distance) {this.distance = distance;}
	public void setID(String ID) {this.ID = ID;}
	public void setTime(String time) {this.time= time;}
	public void setFirstName(String firstName) {this.firstName= firstName;}
	public void setLastName(String lastName) {this.lastName= lastName;}
	public void setGender(String gender) {this.gender= gender;}
	public void setAge(String age) {this.age= age;}
	public void setStatus(String status) {this.status = status;}
	public void setFinishTime(String time) {finishedTime = time;}
	public void setStartTime(String time) {startTime = time;}
	public void setLastUpdate(String lastUpdate) { this.lastUpdate = lastUpdate;}
}
