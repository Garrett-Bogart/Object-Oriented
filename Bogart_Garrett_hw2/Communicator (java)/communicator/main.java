package communicator;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			RaceTracker race = new RaceTracker();
			race.start();
			Scanner in = new Scanner(System.in);
			System.out.println("Press Enter to exit");
			while(true)
			{
				if(in.nextLine().equals(""))
				{
					race.getCommunicator().close();
					in.close();
					System.exit(0);
				}
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}


	}

}
