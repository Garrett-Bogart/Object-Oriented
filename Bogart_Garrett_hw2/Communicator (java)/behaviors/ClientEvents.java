package behaviors;

import java.net.InetAddress;

import athlete.AthleteTracker;

public interface ClientEvents {
	public void clientExecute(AthleteTracker race, String message, InetAddress ip, int port );
}
