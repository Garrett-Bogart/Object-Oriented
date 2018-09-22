package behaviors;
import athlete.RaceTracker;
import athlete.Athlete;

public class AthleteAdd implements AthleteEvents {

	@Override
	public void athleteExecute(RaceTracker race, String id, String time, String firstName, String lastName, String gender, String age,
			String status) 
	{
		Athlete athlete = new Athlete(id, time, firstName, lastName, gender, age, status);
		race.addAthlete(athlete);		
	}

}
