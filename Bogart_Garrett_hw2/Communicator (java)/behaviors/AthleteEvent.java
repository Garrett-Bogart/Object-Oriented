package behaviors;
import java.net.InetAddress;

import athlete.Athlete;
import athlete.AthleteTracker;

public interface AthleteEvents {
	public void athleteExecute(AthleteTracker race, Athlete athlete, InetAddress ip, int port );
}
