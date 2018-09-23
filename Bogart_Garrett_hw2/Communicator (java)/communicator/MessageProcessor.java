package communicator;

import java.net.InetAddress;

import message.Message;
import message.RaceMessage;

public class MessageProcessor implements IMessageProcessor {
	private String name;
	
	public MessageProcessor(String name)
	{
		this.name = name;
	}
	
	@Override
	public void process(String message, InetAddress address, int port)
	{
        if (message==null) {
            System.out.println("Null string");
        }
        else if (address==null) {
            System.out.println("Null address");
        }        
        else
        {
            System.out.println(String.format("%s received: %s from %s:%d", name, message, address.toString(), port));
            String[] parts = message.split(",");
        }
	}
	
	public Message determineMessageType(String[] parts)
	{
		if(parts[0] == "Race")
		{
			return new RaceMessage();
		}
		return null;
	}
}
