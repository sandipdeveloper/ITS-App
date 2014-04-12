package com.asu.its_app.model;

public class Question {

	private int questionId;
	private String questionBody;
	private KC kc;
	
	
	
	public KC getKc() {
		return kc;
	}
	public void setKc(KC kc) {
		this.kc = kc;
	}
	public String getQuestionBody() {
		return questionBody;
	}
	public void setQuestionBody(String questionBody) {
		this.questionBody = questionBody;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	
}
