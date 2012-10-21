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
package com.ivannotes.biscuit.event;

/**
 * 时间管理器
 * <p>
 * 主要完成两个工作：
 * <ul>
 * <li>派发事件</li>
 * <li>订阅事件并注册事件处理器</li>
 * </ul>
 * 
 * @author miracle.ivanlee@gmail.com since 2012-3-29
 * 
 */
public interface EventManager {

    /**
     * 派发事件
     * 
     * @param event
     */
    public <T extends Event> void dispatchEvent(T event);

    /**
     * 订阅指定类型的事件{@code eventClass}并注册处理器{@code handler}
     * 
     * @param <T> 事件类型
     * @param handler 事件处理器
     * @param eventClass 事件Class
     */
    public <T extends Event> void subscribeEvent(EventHandler<T> handler, Class<T> eventClass);
}
