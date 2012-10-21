package com.ivannotes.biscuit.event.test;

import com.ivannotes.biscuit.event.Event;

/**
 * @author miracle.ivanlee@gmail.com since 2012-3-30
 *
 */
public class TestEvent implements Event {

    private static final long serialVersionUID = 237228291954241285L;

    private String msg;

    public TestEvent(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
