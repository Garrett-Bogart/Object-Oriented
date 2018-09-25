package test;

import static org.junit.Assert.assertEquals;

import java.net.InetAddress;

import org.junit.Test;

import athlete.Athlete;
import athlete.AthleteTracker;
import athlete.Race;
import behaviors.AthleteEvents;
import behaviors.ClientEvents;
import behaviors.NotifyEvents;
import behaviors.RaceEvents;
import communicator.Communicator;
import communicator.MessageProcessor;
import communicator.RaceTracker;
import message.DidNotFinishMessage;
import message.DidNotStartMessage;
import message.FinishedMessage;
import message.HelloMessage;
import message.Message;
import message.OnCourseMessage;
import message.RaceMessage;
import message.RegisteredMessage;
import message.SubscribeMessage;
import message.UnsubscribeMessage;

public class TestMessageMaker {
	@Test
	public void TestMessageMaker()
	{
		MessageProcessor processor = new MessageProcessor("Maker");
		Message msg;
		int state = 0;
		
		String[] parts = "Race, fasfas".split(",");
		msg = processor.determineMessageType(parts);
		if(msg instanceof RaceMessage)
		{
			state = 1;
		}
		assertEquals(1,state);
		state = 0;
		
		parts = "Registered, fasfas".split(",");
		msg = processor.determineMessageType(parts);
		if(msg instanceof RegisteredMessage)
		{
			state = 1;
		}
		assertEquals(1,state);
		state = 0;
		
		parts = "DidNotFinish, fasfas".split(",");
		msg = processor.determineMessageType(parts);
		if(msg instanceof DidNotFinishMessage)
		{
			state = 1;
		}
		assertEquals(1,state);
		state = 0;
		
		parts = "DidNotStart, fasfas".split(",");
		msg = processor.determineMessageType(parts);
		if(msg instanceof DidNotStartMessage)
		{
			state = 1;
		}
		assertEquals(1,state);
		state = 0;
		
		parts = "OnCourse, fasfas".split(",");
		msg = processor.determineMessageType(parts);
		if(msg instanceof OnCourseMessage)
		{
			state = 1;
		}
		assertEquals(1,state);
		state = 0;
		
		parts = "Finished, fasfas".split(",");
		msg = processor.determineMessageType(parts);
		if(msg instanceof FinishedMessage)
		{
			state = 1;
		}
		assertEquals(1,state);
		state = 0;
		
		parts = "Hello, fasfas".split(",");
		msg = processor.determineMessageType(parts);
		if(msg instanceof HelloMessage)
		{
			state = 1;
		}
		assertEquals(1,state);
		state = 0;
		
		parts = "Subscribe, fasfas".split(",");
		msg = processor.determineMessageType(parts);
		if(msg instanceof SubscribeMessage)
		{
			state = 1;
		}
		assertEquals(1,state);
		state = 0;
		
		parts = "Unsubscribe, fasfas".split(",");
		msg = processor.determineMessageType(parts);
		if(msg instanceof UnsubscribeMessage)
		{
			state = 1;
		}
		assertEquals(1,state);
		state = 0;
	}
}
