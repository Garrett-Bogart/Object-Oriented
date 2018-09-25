package behaviors;

import java.net.InetAddress;

import athlete.Athlete;
import athlete.AthleteTracker;

public class AthleteNone implements AthleteEvents {
	public void athleteExecute(AthleteTracker race, Athlete athlete, InetAddress ip, int port) {}
}
