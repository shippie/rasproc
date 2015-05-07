package de.railroad.rasproc.processor;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Timer;
import java.util.concurrent.BlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import com.google.common.eventbus.EventBus;

import de.railroad.rasproc.events.SwitchEvent;
import de.railroad.rasproc.model.CanUdpFrame;
import de.railroad.rasproc.model.ICanMsg;
import de.railroad.rasproc.model.SwichRequest;
import de.railroad.rasproc.model.ZubehoerMsg;
import de.railroad.rasproc.service.MessageReaderService;

public class MessageProcessor implements Runnable
{
	private static final Logger LOGGER = LoggerFactory.getLogger(MessageProcessor.class);
	BlockingQueue<CanUdpFrame> udpCanFrameQueue;
	MessageReaderService messageReaderService;
	EventBus eventBus;

	public MessageProcessor(BlockingQueue<CanUdpFrame> udpCanFrameQueue, EventBus eventBus)
	{
		this.udpCanFrameQueue = udpCanFrameQueue;
		messageReaderService = new MessageReaderService();
		this.eventBus = eventBus;
	}

	@Override
	public void run()
	{
		try
		{

			while (true)
			{
				CanUdpFrame frame = this.udpCanFrameQueue.take();
				MDC.put("correlation", frame.getCorrelationId());
				LOGGER.trace("Message gefunden");
				ICanMsg msg = messageReaderService.erkenneMessage(frame);

				if (msg instanceof ZubehoerMsg)
				{
					LOGGER.info("Class: {}", msg.getClass().getName());
					ZubehoerMsg zubehoerMsg = (ZubehoerMsg) msg;
					int stellung = zubehoerMsg.getStellung();
					eventBus.post(new SwitchEvent(new SwichRequest(zubehoerMsg.getSchaltAdresse(), stellung)));
					stellung ^= 1;
					JobProcessor jobProcessor = new JobProcessor(eventBus, new SwitchEvent(new SwichRequest(
						zubehoerMsg.getSchaltAdresse(), stellung)));
					Timer caretaker = new Timer();
					caretaker.schedule(jobProcessor, zubehoerMsg.getSchaltzeit());
				}
				else
				{
					LOGGER.trace("Unbekannt - ignorieren");
				}
				MDC.clear();
			}
		}
		catch (InterruptedException | IllegalAccessException | InvocationTargetException | NoSuchMethodException
			| IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			MDC.clear();
		}
	}

}
