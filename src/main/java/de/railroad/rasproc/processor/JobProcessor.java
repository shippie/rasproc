package de.railroad.rasproc.processor;

import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.eventbus.EventBus;

import de.railroad.rasproc.events.SwitchEvent;

public class JobProcessor extends TimerTask
{

	private static final Logger LOGGER = LoggerFactory.getLogger(JobProcessor.class);
	EventBus eventBus;
	SwitchEvent switchEvent;

	public JobProcessor(EventBus eventBus, SwitchEvent switchEvent)
	{
		this.switchEvent = switchEvent;
		this.eventBus = eventBus;
	}

	@Override
	public void run()
	{
		//LOGGER.info("RUN");
		eventBus.post(switchEvent);
	}

}
