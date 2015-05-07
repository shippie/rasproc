package de.railroad.rasproc.gpio.mcp;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.PinMode;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.i2c.I2CBus;

public class GpioControlFactory
{
	static final Logger LOGGER = LoggerFactory.getLogger(GpioControlFactory.class);
	static IMCP23017GpioProvider gpioProvider = null;
	static GpioController gpio = null;

	public static IMCP23017GpioProvider getInstance() throws IOException
	{

		if (gpioProvider == null || gpio == null)
		{

			LOGGER.info("<--Pi4J--> MCP23017 GPIO... started.");
			// create gpio controller
			gpio = GpioFactory.getInstance();

			// create custom MCP23017 GPIO provider
			gpioProvider = new MCP23017GpioProvider(I2CBus.BUS_1, 0x20);
		}

		gpioProvider.setMode(MCP23017Pin.GPIO_A0, PinMode.DIGITAL_OUTPUT);
		gpioProvider.setState(MCP23017Pin.GPIO_A0, PinState.HIGH);

		return gpioProvider;
	}

	public void setGpioProvider(IMCP23017GpioProvider gpioProvider, GpioController gpio)
	{
		GpioControlFactory.gpioProvider = gpioProvider;
		GpioControlFactory.gpio = gpio;
	}

	public void shutdown()
	{
		if (gpio != null)
		{
			gpio.shutdown();
		}
	}
}
