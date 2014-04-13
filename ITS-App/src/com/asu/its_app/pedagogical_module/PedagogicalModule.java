package com.asu.its_app.pedagogical_module;

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

	public Hint getHintFromDatabase(Question question) {
		// TODO Auto-generated method stub
		return null;
	}

	public Feedback getFeedbackFromDatabase(Question question, Answer answer) {
		// TODO Auto-generated method stub
		return null;
	}
}
