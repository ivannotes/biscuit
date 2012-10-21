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
