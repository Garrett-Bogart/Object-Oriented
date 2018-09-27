package communicator;

import java.net.InetAddress;

import athlete.Athlete;
import message.DidNotFinishMessage;
import message.DidNotStartMessage;
import message.FinishedMessage;
import message.HelloMessage;
import message.Message;
import message.OnCourseMessage;
import message.RaceMessage;
import message.RegisteredMessage;
import message.StartedMessage;
import message.SubscribeMessage;
import message.UnsubscribeMessage;

public class MessageProcessor implements IMessageProcessor {
	private String name;
	private Message messageType;
    private int receiveCount;
    private String message;
	
	public MessageProcessor(String name)
	{
		this.name = name;
	}
	
	@Override
	public Message process(String message, InetAddress address, int port)
	{
        if (message==null) {
            //System.out.println("Null string");
        }
        else if (address==null) {
            //System.out.println("Null address");
        }        
        else
        {
            //System.out.println(String.format("%s received: %s from :%d", name, message, port));
            String[] parts = message.split(",");
            receiveCount++;
            setMessage(message);
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
			//System.out.println("Making a Registered athlete");
			return new Athlete(parts[1].trim(), parts[2].trim(), parts[3].trim(), parts[4].trim(), parts[5].trim(), parts[6].trim() );
		}
		else if("DidNotStart".equals(parts[0].trim()))// "DidNotStart,<id>,<time>"
		{
			//System.out.println("Making a DidNotStart athlete");
			Athlete athlete = new Athlete(parts[1].trim(), parts[2].trim());
			athlete.setStatus(parts[0]);
			return athlete;

		}
		else if("Started".equals(parts[0].trim()))// "Started,<id>,<time>"
		{
			//System.out.println("Making a Started athlete");
			Athlete athlete = new Athlete(parts[1].trim(), parts[2].trim());
			athlete.setStatus(parts[0]);
			return athlete;
		}
		else if("Finished".equals(parts[0].trim()))// "Finished,<id>,<time>"
		{
			//System.out.println("Making finish athlete");
			Athlete athlete = new Athlete(parts[1].trim(), parts[2].trim());
			athlete.setFinishTime(parts[2].trim());
			athlete.setStatus(parts[0]);
			return athlete;
		}
		else if("OnCourse".equals(parts[0].trim()))// "Finished,<id>,<time>"
		{
			//System.out.println("Making OnCourse athlete");
			Athlete athlete = new Athlete(parts[1].trim(), parts[2].trim());
			athlete.setStatus(parts[0]);
			athlete.setDistance(parts[3].trim());
			return athlete;
		}
		else if("DidNotFinish".equals(parts[0].trim()))// "Finished,<id>,<time>"
		{
			//System.out.println("Making a Did not finish athlete");
			Athlete athlete = new Athlete(parts[1].trim(), parts[2].trim());
			athlete.setStatus(parts[0]);
			return athlete;
		}

		else if("Subscribe".equals(parts[0].trim()))// "Finished,<id>,<time>"
		{
			//System.out.println("Making a subscribe athlete");
			Athlete athlete = new Athlete(parts[1].trim(), null);
			return athlete;
		}
		else if("Unsubscribe".equals(parts[0].trim()))// "Finished,<id>,<time>"
		{
			//System.out.println("Making a Unsubscribe athlete");
			Athlete athlete = new Athlete(parts[1].trim(), null);
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
		//System.out.println("Making a null athlete");

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
			return new RegisteredMessage();
		}
		else if("DidNotFinish".equals(parts[0]))
		{
			return new DidNotFinishMessage();
		}
		else if("DidNotStart".equals(parts[0]))
		{
			//System.out.println("DNS MESSAGE");
			return new DidNotStartMessage();
		}
		else if("OnCourse".equals(parts[0]))
		{
			return new OnCourseMessage();
			
		}
		else if("Finished".equals(parts[0]))
		{
			return new FinishedMessage();
		}
		else if("Hello".equals(parts[0]))
		{
			return new HelloMessage();
		}
		else if("Subscribe".equals(parts[0]))
		{
			return new SubscribeMessage();
		}
		else if("Unsubscribe".equals(parts[0]))
		{
			return new UnsubscribeMessage();
		}
		else if("Started".equals(parts[0]))
		{
			return new StartedMessage();
		}
		else if("Hello".equals(parts[0]))
		{
			return new HelloMessage();
		}
		return null;
	}
	public String getMessage() {return message;}
    public int ReceiveCount() { return receiveCount; }
    
    public void setMessage(String message) {this.message = message;}
}
