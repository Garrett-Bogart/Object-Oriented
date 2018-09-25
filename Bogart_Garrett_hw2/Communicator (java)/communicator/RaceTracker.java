package communicator;

import java.net.SocketException;
import java.util.Vector;

import athlete.Athlete;
import athlete.AthleteTracker;
import athlete.Race;
import message.Message;
import observer.Client;
import observer.Observers;

public class RaceTracker {
	private Communicator comm;
	private AthleteTracker athleteTracker;
	private Race race;
	private Message message;
	
	public RaceTracker() throws Exception
	{
		race = new Race();
		this.comm = new Communicator(race);
		this.athleteTracker = new AthleteTracker();
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
	
	public Communicator getCommunicator() {return comm;}
	public IMessageProcessor getProcessor() {return comm.getProcessor();}
	public AthleteTracker getAthleteTacker() {return athleteTracker;}
	public Race getRace() {return race;}
	

	public void setCommunicator(Communicator comm) {comm = comm;}
	public void setProcessor(DummyMessageProcessor proc) { comm.setProcessor(proc);}
	public void setRace(Race race) {this.race =race;}
	public void setMessage(Message message) {this.message = message;}
}
