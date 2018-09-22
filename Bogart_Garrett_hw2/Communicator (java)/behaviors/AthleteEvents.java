package behaviors;
import athlete.RaceTracker;

public interface AthleteEvents {
	public void athleteExecute(RaceTracker race, String id, String time, String firstName, String lastName, String gender, String age, String status );
}
