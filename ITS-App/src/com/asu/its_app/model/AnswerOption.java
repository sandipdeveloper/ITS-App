package com.asu.its_app.model;

public class AnswerOption {

	private Question question;
	private String imageURL;
	private String level;
	private int answerOptionId;
	
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public int getAnswerOptionId() {
		return answerOptionId;
	}
	public void setAnswerOptionId(int answerOptionId) {
		this.answerOptionId = answerOptionId;
	}
}
