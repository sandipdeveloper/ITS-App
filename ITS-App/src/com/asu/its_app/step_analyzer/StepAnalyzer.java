package com.asu.its_app.step_analyzer;

import android.content.Context;

import com.asu.its_app.dbhelper.ITSDBHelper;
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
	
	public boolean isAnswerCorrect(Question question, Answer selectedAnswer, Context context, int id)
	{
		ITSDBHelper helper = ITSDBHelper.getInstance(context);
		String answer = helper.getCorrectAnswer(id);
		if(selectedAnswer.getSelectedAnswer().equals(answer))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public KC getKCForQuestion(Question question)
	{
		return null;	
	}
}