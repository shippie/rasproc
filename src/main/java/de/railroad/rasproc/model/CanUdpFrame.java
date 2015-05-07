package de.railroad.rasproc.model;

import de.railroad.rasproc.tools.UniqId;

public class CanUdpFrame
{
	private byte prio;
	private byte command;
	private byte respond;
	private byte hashHigh;
	private byte hashLow;
	private byte dlc;

	private byte dByte0;
	private byte dByte1;
	private byte dByte2;
	private byte dByte3;

	private byte dByte4;
	private byte dByte5;
	private byte dByte6;
	private byte dByte7;

	private long correlationId;

	public CanUdpFrame()
	{
		correlationId = UniqId.getInstanceDC().getId();
	}

	public byte getPrio()
	{
		return prio;
	}

	public void setPrio(byte prio)
	{
		this.prio = prio;
	}

	public byte getCommand()
	{
		return command;
	}

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

	public byte getHashHigh()
	{
		return hashHigh;
	}

	public byte getHashLow()
	{
		return hashLow;
	}

	public void setHashLow(byte hashLow)
	{
		this.hashLow = hashLow;
	}

	public void setHashHigh(byte hash)
	{
		this.hashHigh = hash;
	}

	public byte getDlc()
	{
		return dlc;
	}

	public void setDlc(byte dlc)
	{
		this.dlc = dlc;
	}

	public byte getdByte0()
	{
		return dByte0;
	}

	public void setdByte0(byte dByte0)
	{
		this.dByte0 = dByte0;
	}

	public byte getdByte1()
	{
		return dByte1;
	}

	public void setdByte1(byte dByte1)
	{
		this.dByte1 = dByte1;
	}

	public byte getdByte2()
	{
		return dByte2;
	}

	public void setdByte2(byte dByte2)
	{
		this.dByte2 = dByte2;
	}

	public byte getdByte3()
	{
		return dByte3;
	}

	public void setdByte3(byte dByte3)
	{
		this.dByte3 = dByte3;
	}

	public byte getdByte4()
	{
		return dByte4;
	}

	public void setdByte4(byte dByte4)
	{
		this.dByte4 = dByte4;
	}

	public byte getdByte5()
	{
		return dByte5;
	}

	public void setdByte5(byte dByte5)
	{
		this.dByte5 = dByte5;
	}

	public byte getdByte6()
	{
		return dByte6;
	}

	public void setdByte6(byte dByte6)
	{
		this.dByte6 = dByte6;
	}

	public byte getdByte7()
	{
		return dByte7;
	}

	public void setdByte7(byte dByte7)
	{
		this.dByte7 = dByte7;
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
		return "CanFrame [prio=" + String.format("%02X ", prio) + ", command=" + String.format("%02X ", command)
			+ ", respond=" + String.format("%02X ", respond) + ", hashHigh=" + String.format("%02X ", hashHigh)
			+ "hashLow=" + String.format("%02X ", hashLow) + ", dlc=" + String.format("%02X ", dlc) + ", dByte0="
			+ String.format("%02X ", dByte0) + ", dByte1=" + String.format("%02X ", dByte1) + ", dByte2="
			+ String.format("%02X ", dByte2) + ", dByte3=" + String.format("%02X ", dByte3) + ", dByte4="
			+ String.format("%02X ", dByte4) + ", dByte5=" + String.format("%02X ", dByte5) + ", dByte6="
			+ String.format("%02X ", dByte6) + ", dByte7=" + String.format("%02X ", dByte7) + "]";
	}

}
