package communicator;

import athlete.AthleteTracker;
import message.Message;

public class RaceTracker {
	private Communicator comm;
	private AthleteTracker athleteTracker;
	Message message;
	
	public RaceTracker(Communicator comm, AthleteTracker athleteTracker)
	{
		this.comm = comm;
		this.athleteTracker = athleteTracker;
	}
	
	public void start()
	{
		String msg;
		/*while(true)
		{
			//get message from processor
			//message = new Message(msg)
			
		}*/
	}
}
