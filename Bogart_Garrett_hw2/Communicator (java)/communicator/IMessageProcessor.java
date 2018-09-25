package communicator;
import java.net.InetAddress;

import athlete.Athlete;
import message.Message;

public interface IMessageProcessor {
    Message process(String message, InetAddress address, int port);

	Athlete makeAthlete(String message);
}
