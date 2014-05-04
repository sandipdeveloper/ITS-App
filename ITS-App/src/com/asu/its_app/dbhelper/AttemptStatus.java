package com.asu.its_app.dbhelper;


public class AttemptStatus {

	private int questionId;
	private int attempt;
	
	public AttemptStatus(int questionId, int attempt)
	{
		this.questionId = questionId;
		this.attempt = attempt;
		
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public int getAttempt() {
		return attempt;
	}
	public void setAttempt(int attempt) {
		this.attempt = attempt;
	}
}
