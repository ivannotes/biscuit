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
package com.ivannotes.biscuit.event.impl.thread;

/**
 * 调用路径的ThreadLocal工具类
 * 
 * @author miracle.ivanlee@gmail.com since 2012-3-31
 * 
 */
public class InvocationPathUtil {

    private static ThreadLocal<String> invocationPathLocal = new ThreadLocal<String>();

    /** 调用路径分割符 */
    public static final String INV_PATH_SEPERATOR = ".";

    /** 调用路径分隔符（正则） */
    public static final String REG_INV_PATH_SEPERATOR = "\\.";

    /**
     * 绑定{@code invocationPath}到当前线程
     * 
     * @param invocationPath
     */
    public static void bindInvocationToCurrentPath(String invocationPath) {
        invocationPathLocal.set(invocationPath);
    }

    /**
     * 获取当前线程的调用路径
     */
    public static String getCurrentInvocationPath() {
        String invocationPath = invocationPathLocal.get();

        if (null == invocationPath) {
            return INV_PATH_SEPERATOR;
        }
        return invocationPath;
    }

    /**
     * 清除当前线程的调用路径数据
     */
    public static void unbindCurrentInvocationPath() {
        invocationPathLocal.remove();
    }
}
