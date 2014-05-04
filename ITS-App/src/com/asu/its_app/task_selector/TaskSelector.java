package com.asu.its_app.task_selector;

import android.content.Context;

import com.asu.its_app.dbhelper.ITSDBHelper;
import com.asu.its_app.model.Question;

public class TaskSelector {
	
	private static TaskSelector instance = null;
	private static Question currentQuestion = null;
	
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
	
	public Question selectNextQuestionFromDatabase(Question question, Context context)
	{
		return ITSDBHelper.getInstance(context).getQuestion(question);	
	}
	
	public void setCurrentQuestion(Question currentQuestion)
	{
		this.currentQuestion = currentQuestion;
	}
	
	public Question getCurrentQuestion()
	{
		return currentQuestion;
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
