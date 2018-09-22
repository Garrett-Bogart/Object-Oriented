package behaviors;
import athlete.AthleteTracker;

public class RaceChange implements RaceEvents {
	public void raceExecute(AthleteTracker race, String name, String distance)
	{
		race.setRaceName(name);
		race.setDistance(distance);
	}
	

}
