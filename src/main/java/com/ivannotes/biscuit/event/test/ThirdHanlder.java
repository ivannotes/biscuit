package com.ivannotes.biscuit.event.test;

import com.ivannotes.biscuit.event.EventHandler;
import com.ivannotes.biscuit.event.EventUtil;

/**
 * @author miracle.ivanlee@gmail.com since 2012-3-31
 * 
 */
public class ThirdHanlder implements EventHandler<ThirdEvent> {

    @Override
    public void handleEvent(ThirdEvent event) {
        FirstEvent e = new FirstEvent();
        EventUtil.getEventManager().dispatchEvent(e);
        System.out.println("third handler finished");
    }

}
