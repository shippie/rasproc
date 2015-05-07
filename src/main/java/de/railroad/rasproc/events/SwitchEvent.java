package de.railroad.rasproc.events;

import de.railroad.rasproc.model.ISwitchRequest;

public class SwitchEvent {
	
	private ISwitchRequest switchRequest;
	
	
	public SwitchEvent(ISwitchRequest switchRequest) {
		this.switchRequest = switchRequest;
	}


	public long getAddress() {
		return this.switchRequest.getAddress();
	}
	
	public int getValue() {
		return this.switchRequest.getValue();
	}
}
