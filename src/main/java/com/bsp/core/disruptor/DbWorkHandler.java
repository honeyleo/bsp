package com.bsp.core.disruptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lmax.disruptor.WorkHandler;

public class DbWorkHandler implements WorkHandler<DbEvent> {

	private final static Logger LOG = LoggerFactory.getLogger(DbWorkHandler.class.getName());
	
	@Override
	public void onEvent(DbEvent event) throws Exception {
		try {
			event.getEvent().run();
		} catch(Throwable e) {
			LOG.error(e.getMessage(), e);
		}
	}

}
