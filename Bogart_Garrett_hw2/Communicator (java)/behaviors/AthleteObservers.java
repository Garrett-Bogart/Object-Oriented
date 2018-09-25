package behaviors;

import java.net.InetAddress;

import athlete.Athlete;
import athlete.AthleteTracker;

public class AthleteObservers implements AthleteEvents {

	@Override
	public void athleteExecute(AthleteTracker athleteTracker, Athlete athlete, InetAddress ip, int port) {
		 	Athlete temp = athleteTracker.getAthlete(athlete.getID());
		 	athleteTracker.addObserver(ip, port);
		 	temp.addObserver(ip, port);
		 	

	}

}
