package behaviors;
import athlete.AthleteTracker;
import athlete.Race;
import communicator.RaceTracker;

public interface RaceEvents {
	public void raceExecute(Race race, String message);

}
