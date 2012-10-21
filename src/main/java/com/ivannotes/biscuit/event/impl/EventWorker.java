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
package com.ivannotes.biscuit.event.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ivannotes.biscuit.event.EventHandler;
import com.ivannotes.biscuit.event.impl.thread.InvocationPathUtil;

/**
 * 执行事件派发的Worker
 * 
 * @author miracle.ivanlee@gmail.com since 2012-3-29
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class EventWorker implements Runnable {

    private EventWrapper eventWrapper;

    private List<EventHandler> handlers;

    private Log logger = LogFactory.getLog(EventWorker.class);

    public EventWorker(EventWrapper eventWrapper, List<EventHandler> handlers) {
        this.eventWrapper = eventWrapper;
        this.handlers = handlers;
    }

    @Override
    public void run() {
        try {
            InvocationPathUtil.bindInvocationToCurrentPath(eventWrapper.getInvocationPath());

            for (EventHandler handler : handlers) {
                try {
                    handler.handleEvent(eventWrapper.getEvent());
                } catch (Exception e) {
                    logger.error("Handle event error: handler-" + handler.getClass() + " event-"
                            + eventWrapper.getEvent().getClass(), e);
                }
            }
        } finally {
            // 清除调用路径数据避免引起内存泄露
            InvocationPathUtil.unbindCurrentInvocationPath();
        }
    }

}
