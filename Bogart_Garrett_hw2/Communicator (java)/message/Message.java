package message;
import behaviors.RaceEvents;

abstract public class Message {
	protected RaceEvents raceEvents;
	
	abstract public void execute(String[] message);
	abstract public String[] parse(String message);
	abstract public void setRaceEvent(RaceEvents event);
	abstract public RaceEvents getRaceEvents();
}
