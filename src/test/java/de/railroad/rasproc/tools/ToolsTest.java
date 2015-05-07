package de.railroad.rasproc.tools;

import static org.junit.Assert.fail;

import java.io.EOFException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class ToolsTest
{

	@Before
	public void setUp() throws Exception
	{
	}

	@Test
	public void testGetUInt32() throws EOFException, IOException
	{
		byte[] b = new byte[] { 0x00, 0x30, 0x00, 0x00 };
		long value = Tools.getUInt32(b);
		System.out.println(value);
	}

	@Test
	public void testToByteArray()
	{
		//fail("Not yet implemented");
	}

}
