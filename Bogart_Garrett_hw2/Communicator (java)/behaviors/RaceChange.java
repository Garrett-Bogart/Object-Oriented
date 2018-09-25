package behaviors;
import athlete.AthleteTracker;
import athlete.Race;
import communicator.RaceTracker;

public class RaceChange implements RaceEvents {
	public void raceExecute(Race race, String message)
	{
		System.out.println(message);
		String[] parts = message.split(",");
		race.setRaceName(parts[1]);
		race.setDistance(parts[2].trim());
	}
	

}
