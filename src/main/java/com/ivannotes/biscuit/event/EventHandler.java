package com.ivannotes.biscuit.event;

/**
 * 事件处理器
 * 
 * @author miracle.ivanlee@gmail.com since 2012-3-29
 *
 * @param <T> 事件类型
 */
public interface EventHandler<T extends Event> {

    /**
     * 处理事件
     * 
     * @param event 能够处理的事件类型
     */
    public void handleEvent(T event);
}
