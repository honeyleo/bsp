package com.bsp.core.disruptor;

import com.lmax.disruptor.WorkHandler;

public class DbWorkHandler implements WorkHandler<DbEvent> {

	@Override
	public void onEvent(DbEvent event) throws Exception {
		event.getEvent().run();
	}

}
