package de.railroad.rasproc.tools;

import java.io.EOFException;
import java.io.IOException;

public class Tools
{
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

	/**
	 * Konvertiert 4 Bytes big-endian order nach long
	 */
	public static long getUInt32(byte[] bytes) throws EOFException, IOException
	{
		//byte[] bytes = getBytes(4);
		long value = bytes[0] & 0xFF;
		value |= (bytes[1] << 8) & 0xFFFF;
		value |= (bytes[2] << 16) & 0xFFFFFF;
		value |= (bytes[3] << 24) & 0xFFFFFFFF;
		return value;
	}

	/**
	 * Konvertiert 32 bit Integer to Bytes big-endian order
	 */
	public static byte[] toByteArray(int value)
	{
		return new byte[] { (byte) (value >> 24), (byte) (value >> 16), (byte) (value >> 8), (byte) value };
	}
}
