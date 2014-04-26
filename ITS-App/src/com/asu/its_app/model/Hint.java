package com.asu.its_app.model;

public class Hint {

	private int hintId;
	private String hintContent;
	private String imageLocation;
	private Question question;
	
	
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public int getHintId() {
		return hintId;
	}
	public void setHintId(int hintId) {
		this.hintId = hintId;
	}
	public String getHintContent() {
		return hintContent;
	}
	public void setHintContent(String hintContent) {
		this.hintContent = hintContent;
	}
	public String getImageLocation() {
		return imageLocation;
	}
	public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
	}
	
	
}
