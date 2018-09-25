package observer;

import java.net.InetAddress;

public class Client extends Observers {
	
	public Client(InetAddress ip, int port)
	{
		this.ip = ip;
		this.port = port;
	}
}
