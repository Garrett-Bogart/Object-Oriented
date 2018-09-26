package behaviors;

import java.net.InetAddress;

import athlete.Athlete;
import athlete.AthleteTracker;
import observer.Observers;

public class AthleteUnsubscribe implements AthleteEvents {

	@Override
	public void athleteExecute(AthleteTracker athleteTracker, Athlete athlete, InetAddress ip, int port) {
		// TODO Auto-generated method stub
		Athlete temp = athleteTracker.getAthlete(athlete.getID());
		Observers obs = temp.getObserver(ip, port);
		temp.removeObserver(ip, port);
	}

}
