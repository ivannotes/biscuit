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
 * @author miracle.ivanlee@gmail.com since 2011-12-5
 *
 */
public class TestAsynExecutor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AsynTaskExecutor executor = AsynTaskExecutorUtil.getAsynExecutor();
		executor.addTask("testtask", "01", new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Hello");
				try{
					Thread.sleep(1500);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		executor.addTask("testtask", "02", new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Hello2");
				throw new RuntimeException("test exception");
			}
		});
		executor.addTask("testtask", "04", new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Hello3");
				try{
					Thread.sleep(1500);
				}catch(Exception e){
					System.out.println("+++" + e.toString());
				}
				
				try{
					System.out.println("in this place");
					Thread.sleep(1500);
				}catch(Exception e){
				}
				System.out.println("Hello3_1");
			}
		}, 0L);
		executor.addTask("testtask", "04", new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Hello4");
				try{
					Thread.sleep(5000);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}, 0L);
		executor.addTask("testtask", "04", new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Hello5");
				try{
					Thread.sleep(5000);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}, 0L);
		executor.addTask("testtask", "04", new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Hello4_f");
				try{
					Thread.sleep(5000);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}, 0L);
		executor.addTask("testtask", "04", new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Hello4_f2");
				try{
					Thread.sleep(5000);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}, 0L);
	}

}
