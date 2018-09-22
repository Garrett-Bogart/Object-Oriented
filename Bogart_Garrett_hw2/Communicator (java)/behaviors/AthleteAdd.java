package behaviors;
import athlete.AthleteTracker;
import athlete.Athlete;

public class AthleteAdd implements AthleteEvents {

	@Override
	public void athleteExecute(AthleteTracker race, String id, String time, String firstName, String lastName, String gender, String age,
			String status, String distance, String endpoint) 
	{
		Athlete athlete = new Athlete(id, time, firstName, lastName, gender, age, status);
		race.addAthlete(athlete);		
	}

}
