package de.railroad.rasproc.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.eventbus.Subscribe;

public class SwitchEventListener
{

	private static final Logger LOGGER = LoggerFactory.getLogger(SwitchEventListener.class);

	@Subscribe
	public void listen(SwitchEvent event)
	{
		LOGGER.info("Schalte Adresse: {} auf Wert: {}", event.getAddress(), event.getValue());
	}

}
