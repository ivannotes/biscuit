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
package com.ivannotes.biscuit.event.exception;

/**
 * 调用路劲过长会导致该异常发生
 */
public class LongEventPathException extends RuntimeException {

    private static final long serialVersionUID = 1652278845277775748L;

    private String invocationPath;

    private int maxAllowedLength;

    public LongEventPathException(String invocationPath, int maxAllowedLength) {
        super("Long event invocation path detected. allowed max path length:" + maxAllowedLength
                + " invocationPath: " + invocationPath);
        this.invocationPath = invocationPath;
        this.maxAllowedLength = maxAllowedLength;
    }

    public String getInvocationPath() {
        return invocationPath;
    }

    public void setInvocationPath(String invocationPath) {
        this.invocationPath = invocationPath;
    }

    public int getMaxAllowedLength() {
        return maxAllowedLength;
    }

    public void setMaxAllowedLength(int maxAllowedLength) {
        this.maxAllowedLength = maxAllowedLength;
    }

}
