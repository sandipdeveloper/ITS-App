package com.asu.its_app.step_analyzer;

import com.asu.its_app.model.Answer;
import com.asu.its_app.model.KC;
import com.asu.its_app.model.Question;

public class StepAnalyzer {

	private static StepAnalyzer instance = null;
	
	protected StepAnalyzer()
	{
		
	}
	
	public static StepAnalyzer getInstance()
	{
		if(instance == null)
		{
			return new StepAnalyzer();
		}
		
		return instance;
	}
	
	public boolean isAnswerCorrect(Question question, Answer selectedAnswer)
	{
		return false;
		
	}
	
	public KC getKCForQuestion(Question question)
	{
		return null;	
	}
}
