/*
 * Copyright 2012 Ivan Lee
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/
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
