package com.ivannotes.biscuit.concurrent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 一个用来帮助延迟执行的task
 * 
 * @author miracle.ivanlee@gmail.com since Sep 12, 2012
 */
public abstract class DelayedTask implements Runnable {

    private static Log logger = LogFactory.getLog(DelayedTask.class);

    private static int DEFAULT_DELAY_MILLIS = 400;

    private int delayedMillis;

    private long timestamp;

    public abstract void doTask();

    public DelayedTask() {
        this(DEFAULT_DELAY_MILLIS);
    }

    /**
     * @param millis 延迟的毫秒数
     */
    public DelayedTask(int millis) {
        this.delayedMillis = millis;
        this.timestamp = System.currentTimeMillis();
    }

    @Override
    public final void run() {
        long nowstamp = System.currentTimeMillis();
        long delay = delayedMillis + timestamp - nowstamp;
        if (delay > 0) {
            try {
                if (logger.isDebugEnabled()) {
                    logger.debug("Delay Task has " + delay + " millis to wait");
                }

                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException("Delay task waiting error. ", e);
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("Delay Task begin at: " + System.currentTimeMillis());
        }

        doTask();
    }

}
