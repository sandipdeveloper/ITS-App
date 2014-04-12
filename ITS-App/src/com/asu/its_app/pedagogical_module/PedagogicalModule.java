package com.asu.its_app.pedagogical_module;

public class PedagogicalModule {

	private PedagogicalModule instance = null;
	
	protected PedagogicalModule()
	{
		
	}
	
	public PedagogicalModule getInstance()
	{
		if(instance == null)
		{
			return new PedagogicalModule();
		}
		
		return instance;
	}
}
