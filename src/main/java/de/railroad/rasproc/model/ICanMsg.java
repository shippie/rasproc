package de.railroad.rasproc.model;

public interface ICanMsg
{

	public byte getPrio();

	public void setPrio(byte prio);

	public byte getCommand();

	public void setCommand(byte command);

	public byte getHashHigh();

	public void setHashHigh(byte hashHigh);

	public byte getHashLow();

	public void setHashLow(byte hashLow);

	public byte getDlc();

	public void setDlc(byte dlc);

}
