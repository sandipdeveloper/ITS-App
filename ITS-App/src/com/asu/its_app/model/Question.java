package com.asu.its_app.model;

import java.util.ArrayList;

public class Question {

	private int questionId;
	private String questionBody;
	private ArrayList<KC> kcList;
	private int numberOfAttempts;
	
	
	public ArrayList<KC> getKcList() {
		return kcList;
	}
	public void setKcList(ArrayList<KC> kcList) {
		this.kcList = kcList;
	}
	public int getNumberOfAttempts() {
		return numberOfAttempts;
	}
	public void setNumberOfAttempts(int numberOfAttempts) {
		this.numberOfAttempts = numberOfAttempts;
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
