package behaviors;

import athlete.AthleteTracker;

import java.net.InetAddress;

import athlete.Athlete;

public class AthleteUpdate implements AthleteEvents {

	@Override
	public void athleteExecute(AthleteTracker athletes, Athlete athlete, InetAddress ip, int port) {
		Athlete temp = athletes.getAthlete(athlete.getID());
		athletes.updateAthlete(temp, athlete);
	}

}
