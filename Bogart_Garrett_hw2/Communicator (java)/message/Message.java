package message;
import java.net.InetAddress;

import athlete.Athlete;
import athlete.AthleteTracker;
import athlete.Race;
import behaviors.AthleteEvents;
import behaviors.ClientEvents;
import behaviors.NotifyEvents;
import behaviors.RaceEvents;
import communicator.RaceTracker;

abstract public class Message {
	protected RaceEvents raceEvents;
	protected NotifyEvents notifyEvents;
	protected AthleteEvents athleteEvents;
	protected ClientEvents clientEvents;
	
	abstract public void execute(String message, Race race, AthleteTracker athleteTracker, Athlete athlete, InetAddress ip, int port);
	
	abstract public RaceEvents getRaceEvents();
	abstract public NotifyEvents getNotifyEvents();
	abstract public AthleteEvents getAthleteEvents();
	abstract public ClientEvents getClientEvents();
	
	abstract public void setRaceEvent(RaceEvents event);
	abstract public void setNotifyEvents(NotifyEvents event);
	abstract public void setAthleteEvents(AthleteEvents event);
	abstract public void setClientEvents(ClientEvents event);
	
	
}
