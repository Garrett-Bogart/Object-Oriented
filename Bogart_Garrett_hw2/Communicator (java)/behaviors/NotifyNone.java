package behaviors;

import java.net.InetAddress;

import athlete.AthleteTracker;
import athlete.Race;

public class NotifyNone implements NotifyEvents {

	@Override
	public void notifyExecute(String message, Race race, InetAddress ip, int port) {}

}
