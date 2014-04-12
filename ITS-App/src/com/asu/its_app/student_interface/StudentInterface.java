package com.asu.its_app.student_interface;

public class StudentInterface {
	
	private StudentInterface instance = null;
	
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
}
