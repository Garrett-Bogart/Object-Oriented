package behaviors;

import athlete.AthleteTracker;
import athlete.Athlete;

public class AthleteUpdate implements AthleteEvents {

	@Override
	public void athleteExecute(AthleteTracker race, String id, String time, String firstName, String lastName,
			String gender, String age, String status, String distance, String endpoint) {
		Athlete athlete = race.getAthlete(id);
		athlete.setTime(time);
		athlete.setDistance(distance);
	}

}
