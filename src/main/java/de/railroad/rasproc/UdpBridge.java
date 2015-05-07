package de.railroad.rasproc;

import java.io.IOException;
import java.util.EventListener;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.eventbus.EventBus;

import de.railroad.rasproc.events.SwitchEvent;
import de.railroad.rasproc.events.SwitchEventListener;
import de.railroad.rasproc.model.CanUdpFrame;
import de.railroad.rasproc.processor.MessageProcessor;
import de.railroad.rasproc.udp.ReceiverUdpPackets;

public class UdpBridge
{
	static final Logger LOGGER = LoggerFactory.getLogger(UdpBridge.class);

	public static void main(String args[]) throws Exception
	{

		UdpBridge server = new UdpBridge();
		server.init();

	
	}

	public void init() throws IOException
	{
		BlockingQueue<CanUdpFrame> udpCanFrameQueue = new LinkedBlockingQueue<>();
		LOGGER.info("Initialiere....");
	    
		EventBus eventBus = new EventBus("switch");
		eventBus.register(new SwitchEventListener());
		

	    

		//		LOGGER.info("<--Pi4J--> MCP23017 GPIO... started.");
		//		// create gpio controller
		//		final GpioController gpio = GpioFactory.getInstance();
		//
		//		// create custom MCP23017 GPIO provider
		//		final MCP23017GpioProvider gpioProvider = new MCP23017GpioProvider(I2CBus.BUS_1, 0x20);
		//
		//		gpioProvider.setMode(MCP23017Pin.GPIO_A0, PinMode.DIGITAL_OUTPUT);
		//		gpioProvider.setState(MCP23017Pin.GPIO_A0, PinState.HIGH);

		LOGGER.info("UDP Listener... started.");
		MessageProcessor messageProcessor = new MessageProcessor(udpCanFrameQueue, eventBus);
		ReceiverUdpPackets receiverUdpPackets = new ReceiverUdpPackets(15731, udpCanFrameQueue);

		Thread tReceiver = new Thread(receiverUdpPackets);
		Thread tMsgProcessor = new Thread(messageProcessor);
		tReceiver.start();
		tMsgProcessor.start();

	}

	public static String asHex(byte[] b)
	{
		String result = "";
		for (int i = 0; i < b.length; i++)
		{
			result += Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1);
		}
		return result;
	}

	public static String byteToString(byte[] b)
	{
		StringBuilder sb = new StringBuilder();
		//            0x00  0x00  0x03  0x00  0x05  0x00  0x00  0x00  0x00  0x00  0x00  0x00  0x00  
		sb.append("\r\n00    01    02    03    04    05    06    07    08    09    10    11    12  \r\n");
		for (int i = 0; i < b.length; i++)
		{
			sb.append("0x");
			sb.append(String.format("%02X ", b[i]));
			sb.append(" ");
		}
		return sb.toString();
	}
}
