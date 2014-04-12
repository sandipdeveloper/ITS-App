package com.asu.its_app.assessor;

public class Assessor {

	private Assessor instance = null;
	
	protected Assessor()
	{
		
	}
	
	public Assessor getInstance()
	{
		if(instance == null)
		{
			return new Assessor();
		}
		
		return instance;
	}
	
}
