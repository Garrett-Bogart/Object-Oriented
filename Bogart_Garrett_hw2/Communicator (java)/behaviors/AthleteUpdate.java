package behaviors;

import athlete.RaceTracker;
import athlete.Athlete;

public class AthleteUpdate implements AthleteEvents {

	@Override
	public void athleteExecute(RaceTracker race, String id, String time, String firstName, String lastName,
			String gender, String age, String status) {
		Athlete athlete = race.getAthlete(firstName, lastName);
		athlete.setTime(time);
		//athlete.setDistamce(distance);
	}

}
