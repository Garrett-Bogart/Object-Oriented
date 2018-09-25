package behaviors;

import java.net.InetAddress;
import java.util.Vector;

import athlete.Athlete;
import athlete.AthleteTracker;
import athlete.Race;
import communicator.Communicator;
import communicator.DummyMessageProcessor;
import observer.Observers;

public class NotifyOne implements NotifyEvents {

	@Override
	public void notifyExecute(String message, Race race, InetAddress ip, int port, Athlete athlete, AthleteTracker athleteTracker) throws Exception {
		// TODO Auto-generated method stub
		Vector<Observers> obs = race.getObservers();
		Communicator comm = new Communicator();
        DummyMessageProcessor processor1 = new DummyMessageProcessor("A");
        comm.setProcessor(processor1);
		for(Athlete ath: athleteTracker.getAthletes())
		{
			String mesg = ath.getID()+","+ ath.getFirstName()+","+ ath.getLastName()+","+ ath.getGender()+","+ ath.getAge();
			comm.send(mesg, ip, port);
		}
	}

}
