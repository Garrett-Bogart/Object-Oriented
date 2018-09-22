package message;
import behaviors.AthleteEvents;
import behaviors.AthleteNone;
import behaviors.ClientEvents;
import behaviors.ClientNone;
import behaviors.NotifyAll;
import behaviors.NotifyEvents;
import behaviors.RaceChange;
import behaviors.RaceEvents;

public class RaceMessage extends Message {

		public RaceMessage() 
		{
			this.raceEvents = new RaceChange();
			this.notifyEvents = new NotifyAll();
			this.athleteEvents = new AthleteNone();
			this.clientEvents = new ClientNone();
		}
		
		public String[] parse(String message)
		{
			String[] parts = message.split(",");
			return parts;
		}
		
		public void execute(String[] message) 
		{
		}
		
		
		public RaceEvents getRaceEvents() {return raceEvents;}
		
		public NotifyEvents getNotifyEvents() {return notifyEvents;}

		public AthleteEvents getAthleteEvents() {return athleteEvents;}

		public ClientEvents getClientEvents() {return clientEvents;}

		public void setNotifyEvents(NotifyEvents event) {this.notifyEvents = event;}

		public void setAthleteEvents(AthleteEvents event) {this.athleteEvents = event;}

		public void setClientEvents(ClientEvents event){this.clientEvents = event;}
		
		public void setRaceEvent(RaceEvents event) {raceEvents = event;}
		
}
