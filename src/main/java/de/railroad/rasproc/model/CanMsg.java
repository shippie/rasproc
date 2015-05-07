package de.railroad.rasproc.model;

import de.railroad.rasproc.tools.UniqId;

public class CanMsg implements ICanMsg
{
	private byte prio;
	private byte command;
	private byte respond;
	private byte hashHigh;
	private byte hashLow;
	private byte dlc;
	private long correlationId;

	public CanMsg()
	{
		correlationId = UniqId.getInstanceDC().getId();
	}

	@Override
	public byte getPrio()
	{
		return prio;
	}

	@Override
	public void setPrio(byte prio)
	{
		this.prio = prio;

	}

	@Override
	public byte getCommand()
	{
		return command;
	}

	@Override
	public void setCommand(byte command)
	{
		this.command = command;
	}

	public byte getRespond()
	{
		return respond;
	}

	public void setRespond(byte respond)
	{
		this.respond = respond;
	}

	@Override
	public byte getHashHigh()
	{
		return hashHigh;
	}

	@Override
	public void setHashHigh(byte hashHigh)
	{
		this.hashHigh = hashHigh;
	}

	@Override
	public byte getHashLow()
	{
		return hashLow;
	}

	@Override
	public void setHashLow(byte hashLow)
	{
		this.hashLow = hashLow;
	}

	@Override
	public byte getDlc()
	{
		return dlc;
	}

	@Override
	public void setDlc(byte dlc)
	{
		this.dlc = dlc;
	}

	/**
	 * @return the correlationId
	 */
	public String getCorrelationId()
	{
		return String.valueOf(correlationId);
	}

	/**
	 * @param correlationId the correlationId to set
	 */
	public void setCorrelationId(long correlationId)
	{
		this.correlationId = correlationId;
	}

	@Override
	public String toString()
	{
		return "CanMsg [prio=" + String.format("%02X ", prio) + ", command=" + String.format("%02X ", command)
			+ ", respond=" + String.format("%02X ", respond) + ", hashHigh=" + String.format("%02X ", hashHigh)
			+ "hashLow=" + String.format("%02X ", hashLow) + ", dlc=" + String.format("%02X ", dlc) + "]";
	}

}
