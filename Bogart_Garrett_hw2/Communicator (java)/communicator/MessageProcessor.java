package communicator;

import java.net.InetAddress;

import athlete.Athlete;
import message.Message;
import message.RaceMessage;

public class MessageProcessor implements IMessageProcessor {
	private String name;
	private Message messageType;
	
	public MessageProcessor(String name)
	{
		this.name = name;
	}
	
	@Override
	public Message process(String message, InetAddress address, int port)
	{
        if (message==null) {
            System.out.println("Null string");
        }
        else if (address==null) {
            System.out.println("Null address");
        }        
        else
        {
            //System.out.println(String.format("%s received: %s from :%d", name, message, port));
            String[] parts = message.split(",");
            return determineMessageType(parts);
        }
        return null;
	}
	
	public Athlete makeAthlete(String message)
	{
		String[] parts = message.split(",");
		if("Registered".equals(parts[0].trim()))/*"Registered,<bib number>,<time>,<first name>, <last
			name>,<gender>,<age>"*/
		{
			return new Athlete(parts[1].trim(), parts[2].trim(), parts[3].trim(), parts[4].trim(), parts[5].trim(), parts[6].trim() );
		}
		else if("DidNotStart".equals(parts[0].trim()))// "DidNotStart,<id>,<time>"
		{
			Athlete athlete = new Athlete(parts[1].trim(), parts[2].trim());
			athlete.setStatus(parts[0]);
			return athlete;

		}
		else if("Started".equals(parts[0].trim()))// "Started,<id>,<time>"
		{
			Athlete athlete = new Athlete(parts[1].trim(), parts[2].trim());
			athlete.setStatus(parts[0]);
			return athlete;
		}
		else if("Finished".equals(parts[0].trim()))// "Finished,<id>,<time>"
		{
			Athlete athlete = new Athlete(parts[1].trim(), parts[2].trim());
			athlete.setStatus(parts[0]);
			return athlete;
		}
		else if("Status".equals(parts[0].trim()))/*Status0,<bib number>1,<status>2,<start time>3,<distance
		covered in meters>4,<last updated time>5, <finished time>6*/
		{
			Athlete athlete = new Athlete(parts[1].trim(), parts[4].trim());
			athlete.setStatus(parts[2]);
			athlete.setStartTime(parts[3].trim());
			athlete.setFinishTime(parts[6].trim());
			athlete.setLastUpdate(parts[5].trim());
			athlete.setTime(null);
			athlete.setDistance(parts[4].trim());
			return athlete;
		}
		return null;
	}
	
	public Message determineMessageType(String[] parts)
	{
		if("Race".equals(parts[0]))
		{
			return new RaceMessage();
		}
		else if("Registered".equals(parts[0]))
		{
			
		}
		return null;
	}
}
