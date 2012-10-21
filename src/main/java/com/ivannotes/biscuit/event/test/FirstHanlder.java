package com.ivannotes.biscuit.event.test;

import com.ivannotes.biscuit.event.EventHandler;
import com.ivannotes.biscuit.event.EventUtil;

/**
 * @author miracle.ivanlee@gmail.com since 2012-3-31
 * 
 */
public class FirstHanlder implements EventHandler<FirstEvent> {

    @Override
    public void handleEvent(FirstEvent event) {
        SecondEvent e = new SecondEvent();
        EventUtil.getEventManager().dispatchEvent(e);
        System.out.println("first handler finished");
    }

}
