package behaviors;
import java.net.InetAddress;
import java.util.Vector;

import athlete.Athlete;
import athlete.AthleteTracker;
import athlete.Race;
import communicator.Communicator;
import communicator.DummyMessageProcessor;
import observer.Observers;

public class NotifySubscribers implements NotifyEvents {
	public void notifyExecute(String message, Race race, InetAddress ip, int port, Athlete athlete, AthleteTracker athleteTracker) throws Exception 
	{
		Vector<Observers> obs = athlete.getObservers();
		Communicator comm = new Communicator();
        DummyMessageProcessor processor1 = new DummyMessageProcessor("A");
        comm.setProcessor(processor1);
		for(Observers observer: obs)
		{
			comm.send(message, observer.getIP(), observer.getPort());
		}
	}
}
