package com.asu.its_app.pedagogical_module;

import android.content.Context;

import com.asu.its_app.dbhelper.ITSDBHelper;
import com.asu.its_app.model.Answer;
import com.asu.its_app.model.Feedback;
import com.asu.its_app.model.Hint;
import com.asu.its_app.model.Question;

public class PedagogicalModule {

	private static PedagogicalModule instance = null;
	
	protected PedagogicalModule()
	{
		
	}
	
	public static PedagogicalModule getInstance()
	{
		if(instance == null)
		{
			return new PedagogicalModule();
		}
		
		return instance;
	}

	public Hint getHintFromDatabase(Question question, Context context) {
		
		return ITSDBHelper.getInstance(context).getHint(question);
	}

	public Feedback getFeedbackFromDatabase(Question question, Answer answer, boolean isAnswerCorrect, Context context) {
		
		if(isAnswerCorrect)
		{
			return ITSDBHelper.getInstance(context).getFeedbackFromDatabase(1);
		}
		else
		{
			return ITSDBHelper.getInstance(context).getFeedbackFromDatabase(2);
		}

	}
}
