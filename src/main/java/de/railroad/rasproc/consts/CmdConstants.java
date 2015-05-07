package de.railroad.rasproc.consts;

public class CmdConstants
{
	//public / private static final TYPE NAME = VALUE;

	public static final byte SYSTEM_CMD = 0x00;
	public static final byte LOK_DISCOVERY = 0x02;
	public static final byte MFX_BIND = 0x04;
	public static final byte MFX_VERIFY = 0x04;
	public static final byte LOK_GESCHWINDIGKEIT = 0x08;
	public static final byte LOK_RICHTUNG = 0x0A;
	public static final byte LOK_FUNKTION = 0x0C;
	public static final byte READ_CONFIG = 0x0E;
	public static final byte WRITE_CONFIG = 0x10;
	public static final byte ZUBEHOER_SCHALTEN = 0x16;
	public static final byte ZUBEHOER_CONFIG = 0x18;
	public static final byte S88_POLLING_FEEDBACK = 0x20;
	public static final byte S88_EVENT = 0x22;
	public static final byte SX1_EVENT = 0x24;
	public static final byte SOFTWARE_REQ_OR_PING = 0x30;
	public static final byte SOFTWARE_UPDATEANGEBOT = 0x32;
	public static final byte READ_CONFIG_DATA = 0x34;
	public static final byte BOOTLOADER_CAN_GEBUNDEN = 0x36;
	public static final byte BOOTLOADER_SCHIENEN_GEBUNDEN = 0x38;
	public static final byte STATUSDATEN_KONFIG = 0x3A;
	public static final byte ANFORDERN_STATUSDATEN_KONFIG = 0x40;
	public static final byte STATUSDATEN_KONFIG_STREAM = 0x42;
	public static final byte STATUSDATEN_KONFIG_STREAM_60128 = 0x44;
}
