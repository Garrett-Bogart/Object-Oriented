package behaviors;

import java.net.InetAddress;

import athlete.Athlete;
import athlete.AthleteTracker;

public class ClientSubscribe implements ClientEvents{
	public void clientExecute(AthleteTracker athleteTracker, String message, InetAddress ip, int port)
	{
		/*String[] parts = message.split(",");
		Athlete athlete = athleteTracker.getAthlete(parts[1].trim());*/
		athleteTracker.addObserver(ip, port);
	}
}
