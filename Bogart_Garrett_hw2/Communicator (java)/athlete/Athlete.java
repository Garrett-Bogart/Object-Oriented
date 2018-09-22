package athlete;
import observer.Client;
import observer.Observers;

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

	
	public Athlete(String ID, String time, String firstName, String lastName, String gender, String age, String status ) 
	{
		this.firstName= firstName;
		this.lastName= lastName;
		this.time= time;
		this.age= age;
		this.ID = ID;
		this.gender= gender;
		this.status =status;
		observers = new Vector<Observers>();
	}
	
	public void addObserver(String endpoint) 
	{
		Client client = new Client(endpoint);
		observers.add(client);
	}
	
	public void removeObserver(String endpoint)
	{
		
		for(Iterator<Observers> i = observers.iterator();i.hasNext();)
		{
			Observers obs = i.next();
			if(obs.getEndPoint() == endpoint)
			{
				i.remove();
			}
		}
		/*int count = 0;
		for(Observers obs : observers)
		{
			if(obs.getEndPoint() == endpoint)
			{
				observers.remove(count);
				break;
			}
			System.out.println("}+++++++++++");
			count++;
		}*/
	}
	
	public Observers getObserver(String endpoint)
	{
		for(Observers obs : observers)
		{
			if(obs.getEndPoint() == endpoint)
			{
				return obs;
			}
		}
		return null;
	}
	
	public String getDistance() {return distance;}
	public String getID() {return ID;}
	public String getTime() {return time;}
	public String getFirstName() {return firstName;}
	public String getLastName() {return lastName;}
	public String getGender() {return gender;}
	public String getAge() {return age;}
	public String getStatus() {return status;}
	public Vector<Observers> getObservers() {return observers;}
	
	public void setDistance(String distance) {this.distance = distance;}
	public void setID(String ID) {this.ID = ID;}
	public void setTime(String time) {this.time= time;}
	public void setFirstName(String firstName) {this.firstName= firstName;}
	public void setLastName(String lastName) {this.lastName= lastName;}
	public void setGender(String gender) {this.gender= gender;}
	public void setAge(String age) {this.age= age;}
	public void setStatus(String status) {this.status = status;}
}
