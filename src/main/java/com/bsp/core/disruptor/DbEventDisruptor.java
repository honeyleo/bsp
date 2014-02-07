package com.bsp.core.disruptor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.IgnoreExceptionHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.Sequence;
import com.lmax.disruptor.WorkerPool;
import com.lmax.disruptor.dsl.ProducerType;

public class DbEventDisruptor {

	final static Logger LOG = LoggerFactory.getLogger(DbEventDisruptor.class.getName());
	private static final AtomicInteger poolNumber = new AtomicInteger(1);
	private final AtomicInteger threadNumber = new AtomicInteger(1);
	private final String namePrefix;
	private final ThreadGroup group;
	
	private static RingBuffer<DbEvent> buffer = null;
	
	public final static DbEventDisruptor INSTANCE = Inner.instance;
	
	private static class Inner {
		private static DbEventDisruptor instance = new DbEventDisruptor();
	}
	
	public DbEventDisruptor() {
		SecurityManager s = System.getSecurityManager();
        group = (s != null) ? s.getThreadGroup() :
                              Thread.currentThread().getThreadGroup();
		namePrefix = "pool-" +
                poolNumber.getAndIncrement() +
               "-thread-";
		init(Runtime.getRuntime().availableProcessors() + 1);
	}
	
	public void init(int thread) {
		
		buffer = RingBuffer.create(ProducerType.MULTI,
				new DbEventFactory(), 1 << 10, new BlockingWaitStrategy());
		
		DbWorkHandler[] dbWorkHandlers = new DbWorkHandler[thread];
		for(int i = 0; i < dbWorkHandlers.length; i ++) {
			dbWorkHandlers[i] = new DbWorkHandler();
		}
		
		WorkerPool<DbEvent> workerPool = new WorkerPool<DbEvent>(buffer,
				buffer.newBarrier(), new IgnoreExceptionHandler(), dbWorkHandlers);
		Sequence[] sequences = workerPool.getWorkerSequences();	
		buffer.addGatingSequences(sequences);
		
		workerPool.start(Executors.newFixedThreadPool(thread, new ThreadFactory() {
			
			@Override
			public Thread newThread(Runnable r) {
				Thread t = new Thread(group, r,
                        namePrefix + threadNumber.getAndIncrement(),
                        0);
				t.setDaemon(true);
				return t;
			}
		}));			
	}
	
	public static void publish(final Runnable event) {
		if(event !=null) {
			long next = buffer.next();
			try {
				DbEvent tmp = buffer.get(next);
				tmp.setEvent(event);
			} finally {
				buffer.publish(next);
			}
		}
	}

	public static void main(String args[]) {
		final AtomicInteger n = new AtomicInteger(0);
		int count = 0;
		for(int i = 0; i < 100000; i ++) {
			DbEventDisruptor.publish(new Runnable() {
				
				@Override
				public void run() {
					boolean isDaemon = Thread.currentThread().isDaemon();
					System.out.println("isDaemon = " + isDaemon);
					LOG.info("task-" + n.getAndAdd(1));
				}
			});
			count ++;
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(count);
	}
}
