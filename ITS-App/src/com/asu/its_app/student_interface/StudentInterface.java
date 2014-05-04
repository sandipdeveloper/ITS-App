package com.asu.its_app.student_interface;

import java.util.Date;

import com.asu.its_app.assessor.Assessor;
import com.asu.its_app.dbhelper.ITSDBHelper;
import com.asu.its_app.model.Answer;
import com.asu.its_app.model.Feedback;
import com.asu.its_app.model.Hint;
import com.asu.its_app.model.Question;
import com.asu.its_app.pedagogical_module.PedagogicalModule;
import com.asu.its_app.step_analyzer.StepAnalyzer;
import com.asu.its_app.task_selector.TaskSelector;

public class StudentInterface {
	
	private StudentInterface instance = null;
	private boolean isCorrect = false;
	
	protected StudentInterface()
	{
		
	}
	
	public StudentInterface getInstance()
	{
		if(instance == null)
		{
			return new StudentInterface();
		}
		
		return instance;
	}
	

	public void submitAnswerButtonClickEventHandler() throws Exception
	{
		StepAnalyzer analyzer = StepAnalyzer.getInstance();
		PedagogicalModule module = PedagogicalModule.getInstance();
		Assessor assessor = Assessor.getInstance();
		TaskSelector selector = TaskSelector.getInstance();
		
		Question question = null;
		Question nextQuestion = null;
		Answer selectedAnswer = null;
		Feedback feedback = null;
		Hint hint = null;
		ITSDBHelper helper = ITSDBHelper.getInstance(null);
		
		//check whether correct/incorrect
		//isCorrect = analyzer.isAnswerCorrect(question, selectedAnswer);
		
		//get feedback
		//feedback = module.getFeedbackFromDatabase(question, selectedAnswer);	
		
		//display feedback
		
		//increase number of attempts
		question.setNumberOfAttempts(question.getNumberOfAttempts()+1);
		
		//if attempt > 5 show hint
		if(question.getNumberOfAttempts()>=5)
		{
			//get hint
			//hint = module.getHintFromDatabase(question);			
			//display hint
		}
			
		//calculate competency
		double competency = assessor.getCompetencyCalculated(question, isCorrect);
		//save competency
		assessor.saveCompetencyToDatabase(competency, new Date());
		
		if(isCorrect)
		{
			//select next question
			//nextQuestion = selector.selectNextQuestionFromDatabase(question);
			//populate next question
		}
	}
	
	public void hintOkButtonEventHandler()
	{
		TaskSelector selector = TaskSelector.getInstance();
		Question nextQuestion = null;
		Question question = null;
		//get next question
		//if(isCorrect)
			//nextQuestion = selector.selectNextQuestionFromDatabase(question);
		//else
			//nextQuestion = selector.SameQuestion(question);
		
		//populate next question
	}
	
	public void requestHintButtonEventHandler() 
	{
		Question question = null;
		Assessor assessor = Assessor.getInstance();		
		PedagogicalModule module = PedagogicalModule.getInstance();
		//Hint hint= module.getHintFromDatabase(question);
		
		//recalculate competency
		double competency = assessor.getCompetencyCalculated(question, true);	
		//save competency
		assessor.saveCompetencyToDatabase(competency, new Date());
		
		//display hint
	}
	
}