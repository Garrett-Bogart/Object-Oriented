package behaviors;

import java.net.InetAddress;

import athlete.Athlete;
import athlete.AthleteTracker;

public class ClientUnsubscribe implements ClientEvents {

	@Override
	public void clientExecute(AthleteTracker race, String message, InetAddress ip, int port) {
		// TODO Auto-generated method stub
		String[] parts = message.split(",");
		Athlete athlete = race.getAthlete(parts[1].trim());
		athlete.removeObserver(ip, port);
	}

}
