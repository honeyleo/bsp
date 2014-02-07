package com.bsp.core.disruptor;

import com.lmax.disruptor.EventFactory;

public class DbEventFactory implements EventFactory<DbEvent> {

	@Override
	public DbEvent newInstance() {
		return new DbEvent();
	}

}
