package behaviors;

import athlete.RaceTracker;

public class AthleteObservers implements AthleteEvents {

	@Override
	public void athleteExecute(RaceTracker race, String id, String time, String firstName, String lastName,
			String gender, String age, String status) {
		// Athlete athlete = race.getAthlete(firstName, lastName);

	}

}
