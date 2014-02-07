package com.bsp.core.disruptor;

public class DbEvent {

	private Runnable event;

	public Runnable getEvent() {
		return event;
	}

	public void setEvent(Runnable event) {
		this.event = event;
	}
	
	
}
