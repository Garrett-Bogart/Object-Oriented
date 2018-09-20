package communicator;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Communicator comm1 = new Communicator(12000);
			DummyMessageProcessor processor1 = new DummyMessageProcessor("A");
			comm1.setProcessor(processor1);
			comm1.start();
			
		}catch(Exception e)
		{
			System.out.println(e);
		}


	}

}
