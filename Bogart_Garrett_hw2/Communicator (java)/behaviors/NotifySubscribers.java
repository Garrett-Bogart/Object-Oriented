package behaviors;
import java.net.InetAddress;
import java.util.Vector;

import athlete.Athlete;
import athlete.AthleteTracker;
import athlete.Race;
import communicator.Communicator;
import communicator.DummyMessageProcessor;
import communicator.MessageProcessor;
import observer.Observers;

public class NotifySubscribers implements NotifyEvents {
	public void notifyExecute(String message, Race race, InetAddress ip, int port, Athlete athlete, AthleteTracker athleteTracker) throws Exception 
	{
		String[] parts = message.split(",");
		if(athleteTracker.getAthlete(athlete.getID()) == null)return;
		Vector<Observers> obs = athleteTracker.getAthlete(athlete.getID()).getObservers();
		Athlete ath = athleteTracker.getAthlete(athlete.getID());
		Communicator comm = new Communicator();
		String mesg = "Status,"+ath.getID()+","+ath.getStatus()+","+ath.getStartTime()+","+ath.getDistance()+","+ath.getTime()+","+ath.getFinishTime();
		if("Finished".equals(parts[0].trim()))
		{
			 mesg = "Status,"+ath.getID()+","+ath.getStatus()+","+ath.getStartTime()+","+race.getDistance()+","+ath.getTime()+","+ath.getFinishTime();
		}
        //Status,<bib number>,<status>,<start time>,
        //<distance covered in meters>,<last updated time>, <finished time>
		for(Observers observer: obs)
		{
			comm.send(mesg, observer.getIP(), observer.getPort());
	        //System.out.println(String.format("%s received: %s from %s:%d", "Name: ", message, ip.toString(), observer.getPort()));
		}
	}
}
