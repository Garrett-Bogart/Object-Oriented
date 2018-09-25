package behaviors;
import athlete.AthleteTracker;

import java.net.InetAddress;

import athlete.Athlete;

public class AthleteAdd implements AthleteEvents {

	@Override
	public void athleteExecute(AthleteTracker race, Athlete athlete, InetAddress ip, int port) 
	{
		race.addAthlete(athlete);		
	}

}
