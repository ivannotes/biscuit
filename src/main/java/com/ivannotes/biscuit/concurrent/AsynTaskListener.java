package com.ivannotes.biscuit.concurrent;

/**
 * @author miracle.ivanlee@gmail.com since 2011-12-2
 * 
 */
public interface AsynTaskListener {
    
    void onTaskReady(AsynTask task);
	
	void onTaskAdded(AsynTask task);

	void onTaskStart(AsynTask task);
	
	void onTaskEnd(AsynTask task);
	
	void onTaskTimeOut(AsynTask task);
	
	void onTaskError(AsynTask task);
}
