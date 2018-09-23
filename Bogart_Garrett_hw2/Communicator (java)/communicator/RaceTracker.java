package communicator;

import java.util.Vector;

import athlete.Athlete;
import athlete.AthleteTracker;
import message.Message;
import observer.Client;
import observer.Observers;

public class RaceTracker {
	private Communicator comm;
	private AthleteTracker athleteTracker;
	private Vector<Observers> observers;
	private String raceName;
	private String distance;
	Message message;
	
	public RaceTracker(Communicator comm, AthleteTracker athleteTracker)
	{
		this.comm = comm;
		DummyMessageProcessor processor = new DummyMessageProcessor("Reciever");
		comm.setProcessor(processor);
		this.athleteTracker = athleteTracker;
	}
	
	public void start()
	{
		while(true)
		{
			/*get message from processor
			 * inside the processor determine message type
			 * then return the message type
			 * message = comm.getProcess.getMessageType()
			 * message.execute();
			message = new Message(msg)*/
			
		}
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
	
	public Communicator getCommunicator() {return comm;}
	public IMessageProcessor getProcessor() {return comm.getProcessor();}
	public String getRaceName() {return raceName;}
	public String getDistance() {return distance;}
	public Vector<Observers> getObservers(){return observers;}
	
	public void setDistance(String dis) {distance = dis;}
	public void setRaceName(String name) {raceName = name;}
	public void setCommunicator(Communicator comm) {comm = comm;}
	public void setProcessor(DummyMessageProcessor proc) { comm.setProcessor(proc);}
}
