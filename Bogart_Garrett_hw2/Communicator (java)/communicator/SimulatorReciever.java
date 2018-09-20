package communicator;

import static java.nio.charset.StandardCharsets.UTF_16BE;
import java.net.DatagramPacket;

public class SimulatorReciever {
	private Communicator comm1;
	
	public SimulatorReciever(int port)throws Exception
	{
		this.comm1 = new Communicator(port);
	}
	public SimulatorReciever()throws Exception
	{
		this(1200);
	}
	
	public Communicator getCommunicator() {return comm1;}
	
	public void run() throws Exception
	{
		System.out.println("running");
		while(true)
		{
			System.out.println("running");
			Communicator comm1 = getCommunicator();
			System.out.println("running");
			DatagramPacket packet = comm1.getMessage();	
			System.out.println("running");
			String message = new String( packet.getData(), 0, packet.getLength(), UTF_16BE);
			System.out.println("running");
			System.out.println(message);
		}
	}
}
