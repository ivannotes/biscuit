package com.ivannotes.biscuit.event.test;

import com.ivannotes.biscuit.event.EventHandler;

/**
 * test handler
 * 
 * @author miracle.ivanlee@gmail.com since 2012-3-30
 * 
 */
public class TestEventHanlder implements EventHandler<TestEvent> {

    @Override
    public void handleEvent(TestEvent event) {
        System.out.println(event.getMsg());
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
