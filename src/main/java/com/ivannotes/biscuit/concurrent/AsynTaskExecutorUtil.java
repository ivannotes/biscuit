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
package com.ivannotes.biscuit.concurrent;

/**
 * 异步任务执行器工具类
 * 
 * @author miracle.ivanlee@gmail.com since 2011-12-5
 * 
 */
public class AsynTaskExecutorUtil {

	private static volatile AsynTaskExecutor exeInstance;
	private static Object lock = new Object();

	/**
	 * 获取异步执行器（单例）
	 * 
	 * @return
	 */
	public static AsynTaskExecutor getAsynExecutor() {
		if (exeInstance == null) {
			synchronized (lock) {
				if (exeInstance == null) {
					exeInstance = new AsynTaskExecutor();
				}
			}
		}

		return exeInstance;
	}
}
