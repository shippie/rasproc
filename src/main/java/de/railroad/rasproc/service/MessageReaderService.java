package de.railroad.rasproc.service;

import java.io.EOFException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import de.railroad.rasproc.consts.CmdConstants;
import de.railroad.rasproc.consts.SubCmdConstants;
import de.railroad.rasproc.model.CanUdpFrame;
import de.railroad.rasproc.model.ICanMsg;
import de.railroad.rasproc.model.SystemStopMsg;
import de.railroad.rasproc.model.ZubehoerMsg;
import de.railroad.rasproc.tools.BeanPropertyCopyUtil;
import de.railroad.rasproc.tools.Tools;

public class MessageReaderService
{
	private static final Logger LOGGER = LoggerFactory.getLogger(MessageReaderService.class);

	public ICanMsg erkenneMessage(CanUdpFrame frame) throws IllegalAccessException, InvocationTargetException,
		NoSuchMethodException, EOFException, IOException
	{
		MDC.put("correlation", frame.getCorrelationId());
		LOGGER.trace("Starte erkenneMessage");


		switch (frame.getCommand())
		{

			case CmdConstants.SYSTEM_CMD:
				LOGGER.debug("System Kommando erkannt");
				SystemStopMsg systemStopMsg = new SystemStopMsg();
				BeanPropertyCopyUtil.copyProperties(frame, systemStopMsg, "prio prio", "command command",
					"hashHigh hashHigh", "hashLow hashLow", "dlc dlc");
				// Adresse zusammenf�gen
				byte[] dataByteSystemMsg = new byte[4];
				dataByteSystemMsg[0] = frame.getdByte4();
				//dataByteSystemMsg[1] = frame.getdByte6();
				//dataByteSystemMsg[2] = frame.getdByte5();
				//dataByteSystemMsg[3] = frame.getdByte4();
				LOGGER.debug("Cmd {}", Tools.getUInt32(dataByteSystemMsg));
				long value = Tools.getUInt32(dataByteSystemMsg);
				if (value == SubCmdConstants.SYSTEM_STOPP)
				{

					LOGGER.debug("Sub Command  STOPP");
				}
				else if (value == SubCmdConstants.SYSTEM_GO)
				{
					LOGGER.debug("Sub Command GO");

				}
				else
				{
					LOGGER.debug("Sub Command unbekannt");
				}
				MDC.clear();
				return systemStopMsg;

			case CmdConstants.ZUBEHOER_SCHALTEN:
				LOGGER.debug("Zubeh�r schalten Kommando erkannt");
				ZubehoerMsg msgBean = new ZubehoerMsg();
				BeanPropertyCopyUtil.copyProperties(frame, msgBean, "prio prio", "command command",
					"hashHigh hashHigh", "hashLow hashLow", "dlc dlc");

				// Adresse zusammenf�gen
				byte[] dataByte = new byte[4];
				dataByte[0] = frame.getdByte3();
				dataByte[1] = frame.getdByte2();
				dataByte[2] = frame.getdByte1();
				dataByte[3] = frame.getdByte0();
				msgBean.setSchaltAdresse(Tools.getUInt32(dataByte));

				msgBean
					.setSchaltzeit(((frame.getdByte6() << 8) & 0x0000ff00 | (frame.getdByte7() << 0) & 0x000000ff) * 10); // x 10 milliseconds
				msgBean.setStellung(frame.getdByte4());
				msgBean.setStrom(frame.getdByte5());
				LOGGER.debug("Message {}", msgBean);
				MDC.clear();
				return msgBean;
			case CmdConstants.LOK_RICHTUNG:
				LOGGER.debug("LOK_RICHTUNG schalten Kommando erkannt");
				MDC.clear();
				return null;
			case CmdConstants.LOK_GESCHWINDIGKEIT:
				LOGGER.debug("LOK_GESCHWINDIGKEIT schalten Kommando erkannt");
				MDC.clear();
				return null;
			default:
				LOGGER.debug("Unbekanntes Kommando {}", String.format("%02X ", frame.getCommand()));
				MDC.clear();
			break;
		}
		LOGGER.trace("Ende erkenneMessage");
		MDC.clear();
		return null;
	}
}
