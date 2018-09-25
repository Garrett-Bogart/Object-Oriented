package message;

import java.net.InetAddress;

import athlete.Athlete;
import athlete.AthleteTracker;
import athlete.Race;
import behaviors.AthleteEvents;
import behaviors.AthleteNone;
import behaviors.AthleteUpdate;
import behaviors.ClientEvents;
import behaviors.ClientNone;
import behaviors.NotifyAll;
import behaviors.NotifyEvents;
import behaviors.RaceEvents;
import behaviors.RaceNoChanges;

public class DidNotFinishMessage extends Message{
	public DidNotFinishMessage() 
	{
		this.raceEvents = new RaceNoChanges();
		this.notifyEvents = new NotifyAll();
		this.athleteEvents = new AthleteUpdate();
		this.clientEvents = new ClientNone();
	}
			
	public void execute(String message, Race race, AthleteTracker athleteTracker, Athlete athlete, InetAddress ip, int port) throws Exception 
	{
		raceEvents.raceExecute(race, message);
		athleteEvents.athleteExecute(athleteTracker, athlete, ip, port);
		clientEvents.clientExecute(athleteTracker, message, ip, port);//may need to add client to observer list in athletes
		notifyEvents.notifyExecute(message, race, ip, port, athlete, athleteTracker);
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
