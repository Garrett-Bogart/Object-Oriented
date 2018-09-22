package message;
import behaviors.AthleteEvents;
import behaviors.ClientEvents;
import behaviors.NotifyEvents;
import behaviors.RaceEvents;

abstract public class Message {
	protected RaceEvents raceEvents;
	protected NotifyEvents notifyEvents;
	protected AthleteEvents athleteEvents;
	protected ClientEvents clientEvents;
	
	abstract public void execute(String[] message);
	abstract public String[] parse(String message);
	
	
	abstract public RaceEvents getRaceEvents();
	abstract public NotifyEvents getNotifyEvents();
	abstract public AthleteEvents getAthleteEvents();
	abstract public ClientEvents getClientEvents();
	
	abstract public void setRaceEvent(RaceEvents event);
	abstract public void setNotifyEvents(NotifyEvents event);
	abstract public void setAthleteEvents(AthleteEvents event);
	abstract public void setClientEvents(ClientEvents event);
	
	
}
