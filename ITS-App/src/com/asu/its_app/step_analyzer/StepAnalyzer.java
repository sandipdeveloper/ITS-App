package com.asu.its_app.step_analyzer;

public class StepAnalyzer {

	private StepAnalyzer instance = null;
	
	protected StepAnalyzer()
	{
		
	}
	
	public StepAnalyzer getInstance()
	{
		if(instance == null)
		{
			return new StepAnalyzer();
		}
		
		return instance;
	}
	
	public void callAssessor()
	{
		
	}
	
	
	
}
