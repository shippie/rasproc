package de.railroad.rasproc;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.PinMode;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.i2c.I2CBus;

import de.railroad.rasproc.gpio.mcp.MCP23017GpioProvider;
import de.railroad.rasproc.gpio.mcp.MCP23017Pin;

public class OutTester
{

	static final Logger LOGGER = LoggerFactory.getLogger(OutTester.class);

	public static void main(String[] args) throws IOException
	{
		new OutTester().init();

	}

	public void init() throws IOException
	{
		LOGGER.info("<--Pi4J--> MCP23017 GPIO... started.");
		// create gpio controller
		final GpioController gpio = GpioFactory.getInstance();

		// create custom MCP23017 GPIO provider
		final MCP23017GpioProvider gpioProvider = new MCP23017GpioProvider(I2CBus.BUS_1, 0x20);

		gpioProvider.setMode(MCP23017Pin.GPIO_A0, PinMode.DIGITAL_OUTPUT);
		gpioProvider.setState(MCP23017Pin.GPIO_A0, PinState.HIGH);
	}

}
