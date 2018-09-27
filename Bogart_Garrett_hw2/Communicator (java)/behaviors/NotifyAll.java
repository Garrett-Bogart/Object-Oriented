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

public class NotifyAll implements NotifyEvents{
	public void notifyExecute(String message, Race race, InetAddress ip, int port, Athlete athlete, AthleteTracker athleteTracker) throws Exception 
	{
		Vector<Observers> obs = athleteTracker.getObservers();
		Communicator comm = new Communicator();
		if(athlete != null)
		{
			Athlete temp = athleteTracker.getAthlete(athlete.getID());			
	        String mesg = "Athlete,"+temp.getID()+","+temp.getFirstName()+","+temp.getLastName()+","+temp.getGender()+","+temp.getAge();
	        
	        for(Observers observer: obs)
			{
				comm.send(mesg, observer.getIP(), observer.getPort());
			}
		}
		
		if(race.getStartStatus() == false)
		{
			//System.out.println("gsfdshugfhsjfdhgjsfdh");
			String mesg = "Race,"+race.getRaceName()+","+race.getDistance();
			//System.out.println("size: "+obs.size());

			for(Observers observer: obs)
			{
				//System.out.println(observer.getIP()+" : "+observer.getPort());
				comm.send(mesg, observer.getIP(), observer.getPort());
				for(Athlete ath: athleteTracker.getAthletes())
				{
					String mesg1 ="Athlete," +ath.getID()+","+ ath.getFirstName()+","+ ath.getLastName()+","+ ath.getGender()+","+ ath.getAge();
					comm.send(mesg1, ip, port);
				}
			}

			race.setStarted(true);
		}

	}
}
