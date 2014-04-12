package com.asu.its_app.task_selector;

public class TaskSelector {
	
	private TaskSelector instance = null;
	
	protected TaskSelector()
	{
		
	}
	
	public TaskSelector getInstance()
	{
		if(instance == null)
		{
			return new TaskSelector();
		}
		
		return instance;
	}
}
