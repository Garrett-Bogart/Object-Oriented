package behaviors;

import java.net.InetAddress;

import athlete.Athlete;
import athlete.AthleteTracker;

public class AthleteObservers implements AthleteEvents {

	@Override
	public void athleteExecute(AthleteTracker race, Athlete athlete, InetAddress ip, int port) {
		 	Athlete temp = race.getAthlete(athlete.getID());
		 	temp.addObserver(ip, port);

	}

}
