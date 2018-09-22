package behaviors;

import athlete.Athlete;
import athlete.AthleteTracker;

public class ClientUnsubscribe implements ClientEvents {

	@Override
	public void clientExecute(AthleteTracker race, String id, String endpoint) {
		// TODO Auto-generated method stub
		Athlete athlete = race.getAthlete(id);
		athlete.removeObserver(endpoint);
	}

}
