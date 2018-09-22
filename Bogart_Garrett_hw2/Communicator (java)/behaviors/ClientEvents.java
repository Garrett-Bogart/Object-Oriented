package behaviors;

import athlete.AthleteTracker;

public interface ClientEvents {
	public void clientExecute(AthleteTracker race,String id, String endpoint);
}
