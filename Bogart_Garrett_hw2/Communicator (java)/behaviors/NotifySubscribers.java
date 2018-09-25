package behaviors;
import java.net.InetAddress;

import athlete.AthleteTracker;
import athlete.Race;

public class NotifySubscribers implements NotifyEvents {
	public void notifyExecute(String message, Race race, InetAddress ip, int port) {}
}
