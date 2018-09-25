package behaviors;

import java.net.InetAddress;

import athlete.Athlete;
import athlete.AthleteTracker;

public class AthleteUnsubscribe implements AthleteEvents {

	@Override
	public void athleteExecute(AthleteTracker athleteTracker, Athlete athlete, InetAddress ip, int port) {
		// TODO Auto-generated method stub
		Athlete temp = athleteTracker.getAthlete(athlete.getID());
		temp.removeObserver(ip, port);

	}

}
