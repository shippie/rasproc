package de.railroad.rasproc.model;

public class ZubehoerMsg extends CanMsg
{

	private long schaltAdresse;
	private int stellung;
	private int strom;
	private int schaltzeit;

	public long getSchaltAdresse()
	{
		return schaltAdresse;
	}

	public void setSchaltAdresse(long schaltAdresse)
	{
		this.schaltAdresse = schaltAdresse;
	}

	public int getStellung()
	{
		return stellung;
	}

	public void setStellung(int stellung)
	{
		this.stellung = stellung;
	}

	public int getStrom()
	{
		return strom;
	}

	public void setStrom(int strom)
	{
		this.strom = strom;
	}

	public int getSchaltzeit()
	{
		return schaltzeit;
	}

	public void setSchaltzeit(int schaltzeit)
	{
		this.schaltzeit = schaltzeit;
	}

	@Override
	public String toString()
	{
		return super.toString() + " -> ZubehoerMsg [schaltAdresse=" + schaltAdresse + ", stellung=" + stellung
			+ ", strom=" + strom + ", schaltzeit=" + schaltzeit + "ms]";
	}
}
