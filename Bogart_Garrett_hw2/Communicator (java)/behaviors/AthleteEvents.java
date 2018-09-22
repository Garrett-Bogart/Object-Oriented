package behaviors;
import athlete.AthleteTracker;

public interface AthleteEvents {
	public void athleteExecute(AthleteTracker race, String id, String time, String firstName, String lastName, String gender, String age, String status, String distance, String endpoint );
}
