package de.railroad.rasproc.gpio.mcp;

import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinMode;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;

public interface IMCP23017GpioProvider
{

	String getName();

	void export(Pin pin, PinMode mode);

	void unexport(Pin pin);

	void setMode(Pin pin, PinMode mode);

	PinMode getMode(Pin pin);

	void setState(Pin pin, PinState state);

	PinState getState(Pin pin);

	void setPullResistance(Pin pin, PinPullResistance resistance);

	PinPullResistance getPullResistance(Pin pin);

	void shutdown();

}