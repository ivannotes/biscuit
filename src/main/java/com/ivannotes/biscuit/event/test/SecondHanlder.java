package com.ivannotes.biscuit.event.test;

import com.ivannotes.biscuit.event.EventHandler;
import com.ivannotes.biscuit.event.EventUtil;

/**
 * @author miracle.ivanlee@gmail.com since 2012-3-31
 * 
 */
public class SecondHanlder implements EventHandler<SecondEvent> {

    @Override
    public void handleEvent(SecondEvent event) {
        ThirdEvent e = new ThirdEvent();
        EventUtil.getEventManager().dispatchEvent(e);
        System.out.println("second handler finished");
    }

}
