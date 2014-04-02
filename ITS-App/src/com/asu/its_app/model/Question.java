package com.asu.its_app.model;

public class Question {

	private String questionBody;
	private String imageLocation;
	private int questionId;
	private int kcId;
	
	
	public int getKcId() {
		return kcId;
	}
	public void setKcId(int kcId) {
		this.kcId = kcId;
	}
	public String getQuestionBody() {
		return questionBody;
	}
	public void setQuestionBody(String questionBody) {
		this.questionBody = questionBody;
	}
	public String getImageLocation() {
		return imageLocation;
	}
	public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	
}
