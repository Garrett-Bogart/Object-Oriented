package behaviors;

import athlete.Athlete;
import athlete.AthleteTracker;

public class AthleteObservers implements AthleteEvents {

	@Override
	public void athleteExecute(AthleteTracker race, String id, String time, String firstName, String lastName,
			String gender, String age, String status, String distance, String endpoint) {
		 	Athlete athlete = race.getAthlete(id);
		 	athlete.addObserver(endpoint);

	}

}
