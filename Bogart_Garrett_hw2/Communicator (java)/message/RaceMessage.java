package message;
import behaviors.RaceChange;
import behaviors.RaceEvents;

public class RaceMessage extends Message {

		public RaceMessage() 
		{
			this.raceEvents = new RaceChange();
		}
		
		public String[] parse(String message)
		{
			String[] parts = message.split(",");
			return parts;
		}
		
		public void execute(String[] message) 
		{
			//RaceTraker name = message[0]
			//RaceTracker distance = Integer.parseInt(message[0]);
		}
		
		public void setRaceEvent(RaceEvents event) {raceEvents = event;}
		public RaceEvents getRaceEvents() {return raceEvents;}

		
}
