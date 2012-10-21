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

import com.ivannotes.biscuit.event.Event;

/**
 * 一个对Event的wrapper，主要用途是为了避免循环事件的发生，对Event记录调用路径{@code invocationPath}<br>
 * 该调用路径由事件派发器填充，如果Hanlder中业务也会继续派发事件，派发器就会检查调用路劲判断是否要完成派发。
 * 
 * @author miracle.ivanlee@gmail.com since 2012-3-31
 * 
 */
public class EventWrapper implements Event {

    private static final long serialVersionUID = 4291169986658102264L;

    /**
     * 调用路径
     */
    private String invocationPath;

    /**
     * 事件
     */
    private Event event;

    public EventWrapper(Event event, String invocationPath) {
        this.event = event;
        this.invocationPath = invocationPath;
    }

    public String getInvocationPath() {
        return invocationPath;
    }

    public void setInvocationPath(String invocationPath) {
        this.invocationPath = invocationPath;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

}
