package behaviors;

import athlete.Athlete;
import athlete.AthleteTracker;

public class ClientSubscribe implements ClientEvents{
	public void clientExecute(AthleteTracker race, String id, String endpoint)
	{
		Athlete athlete = race.getAthlete(id);
		athlete.addObserver(endpoint);
	}
}
