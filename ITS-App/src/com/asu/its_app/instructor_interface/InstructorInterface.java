package com.asu.its_app.instructor_interface;

import com.asu.its_app.step_analyzer.StepAnalyzer;

public class InstructorInterface {

private InstructorInterface instance = null;
	
	protected InstructorInterface()
	{
		
	}
	
	public InstructorInterface getInstance()
	{
		if(instance == null)
		{
			return new InstructorInterface();
		}
		
		return instance;
	}
}
