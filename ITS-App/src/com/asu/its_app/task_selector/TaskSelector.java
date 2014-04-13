package com.asu.its_app.task_selector;

import com.asu.its_app.model.Question;

public class TaskSelector {
	
	private static TaskSelector instance = null;
	
	protected TaskSelector()
	{
		
	}
	
	public static TaskSelector getInstance()
	{
		if(instance == null)
		{
			return new TaskSelector();
		}
		
		return instance;
	}
	
	public Question selectNextQuestionFromDatabase(Question question)
	{
		return question;
		
	}
	
	public Question selectSameQuestionWithDifferentParameters(Question question)
	{
		return question;
		
	}

	public Question SameQuestion(Question previousQuestion) {
		// TODO Auto-generated method stub
		return null;
	}
}
