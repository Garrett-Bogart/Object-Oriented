package behaviors;
import athlete.AthleteTracker;
import communicator.RaceTracker;

public class RaceChange implements RaceEvents {
	public void raceExecute(RaceTracker race, String name, String distance)
	{
		race.setRaceName(name);
		race.setDistance(distance);
	}
	

}
