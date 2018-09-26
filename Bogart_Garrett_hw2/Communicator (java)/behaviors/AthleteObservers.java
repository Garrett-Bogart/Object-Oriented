package behaviors;

import java.net.InetAddress;

import athlete.Athlete;
import athlete.AthleteTracker;
import observer.Observers;

public class AthleteObservers implements AthleteEvents {

	@Override
	public void athleteExecute(AthleteTracker athleteTracker, Athlete athlete, InetAddress ip, int port) {
			Athlete temp = athleteTracker.getAthlete(athlete.getID());
			if(temp == null)return;
		 	athleteTracker.getAthlete(temp.getID()).addObserver(ip, port);
		 	Observers obs = temp.getObserver(ip, port);
	}

}
