package com.asu.its_app.assessor;

import java.util.Date;

import com.asu.its_app.dbhelper.ITSDBHelper;
import com.asu.its_app.model.KC;
import com.asu.its_app.model.Question;

public class Assessor {

	private static Assessor instance = null;
	
	protected Assessor()
	{
		
	}
	
	public static Assessor getInstance()
	{
		if(instance == null)
		{
			return new Assessor();
		}
		
		return instance;
	}
	
	public double getCompetencyCalculated(Question question, boolean isCorrectAnswer)
	{
		double sumFactor = 0.0;

		//get DB helper object 
		ITSDBHelper helper = ITSDBHelper.getInstance(null);
		
		//get total steps correct/total step incorrect
		int totalCorrectAnswers = helper.getTotalNumberCorrectAnswersFromDatabase();
		
		int totalIncorrectAnswers = helper.getTotalNumberCorrectAnswersFromDatabase();
		
		int probabilityOfNextStepToBeCorrect = totalCorrectAnswers/totalIncorrectAnswers;
		//get number of attempts 
		
		int numberOfAttempts = question.getNumberOfAttempts();
		
		// get beta for KC
		for(int count=0; count<question.getKcList().size(); count++)
		{
			KC kc  = question.getKcList().get(count);
			
			//get the learning rate of the KC
			double learning_rate = helper.getLearningRateForKC(kc);
			
			//get beta
			double beta = helper.getDifficultyForKC(kc);
			
			sumFactor+= learning_rate*numberOfAttempts - beta;
		}
		
		//competency  = ln(correct/incorrect) - sum(learning rate*number of attempts - difficulty)
		double theta = Math.log10(probabilityOfNextStepToBeCorrect) - sumFactor;
		
		return theta;
	}
	
	public boolean saveCompetencyToDatabase(double competency, Date dateTime)
	{
		//get DB helper object 
		ITSDBHelper helper = ITSDBHelper.getInstance(null);
		
		return helper.saveCompetencyToDatabase(competency, dateTime);	
	}
}
