package behaviors;

import java.net.InetAddress;

import athlete.Athlete;
import athlete.AthleteTracker;
import athlete.Race;
import communicator.Communicator;

public class NotifyNone implements NotifyEvents {

	@Override
	public void notifyExecute(String message, Race race, InetAddress ip, int port, Athlete athlete, AthleteTracker athleteTracker){}

}
