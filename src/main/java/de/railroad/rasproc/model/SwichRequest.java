package de.railroad.rasproc.model;

public class SwichRequest implements ISwitchRequest {

	
	private long address;
	private int value;
	
	public SwichRequest(){
	}
	
	public SwichRequest(long address, int value) {
		super();
		this.address = address;
		this.value = value;
	}

	@Override
	public long getAddress() {
		return address;
	}

	@Override
	public int getValue() {
		return value;
	}

	public void setAddress(long address) {
		this.address = address;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
