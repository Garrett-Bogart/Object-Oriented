package communicator;

import athlete.RaceTracker;
import message.Message;
import message.RaceMessage;
import java.net.InetAddress;
import static java.nio.charset.StandardCharsets.UTF_16BE;
import java.net.DatagramPacket;

public class SimulatorReciever {
	private Communicator comm1;
	DummyMessageProcessor processor;
	
	public SimulatorReciever(int port)throws Exception
	{
		System.out.println("______________");

		Communicator comm = new Communicator();
		System.out.println("______________");

		processor = new DummyMessageProcessor("A");
		System.out.println("______________");

		comm.setProcessor(processor);
		start();
	}
	public SimulatorReciever()throws Exception
	{
		this(1200);
	}
	
	public void start()
	{
		String message;
		System.out.println("______________");
		while(true)
		{
			message = processor.getMessage();
			System.out.println("********************");

			if(message != null)
			{
				System.out.println("+++++++++++++++++");

				update(message);
			}
		}
	}
	
	public void update(String message)
	{
		String[] parts = message.split(",");
		if(parts[0] == "Race")
		{
			//Message mess = new RaceMessage(parts);
			System.out.println("____________________");
			System.out.println("Race Message Recieved");
			System.out.println("____________________");

		}
	}
	
	public Communicator getCommunicator() {return comm1;}
	public DummyMessageProcessor getProcessor() {return processor;}
	
	public void setCommunicator(Communicator comm) {comm1 = comm;}
	public void setProcessor(DummyMessageProcessor proc) { processor = proc;}
	
}
