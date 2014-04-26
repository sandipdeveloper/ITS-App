package com.asu.its_app.model;

public class CorrectAnswer {

	private Question question;
	private String correctAnswerBody;
	private int correctAnswerId;
	
	public int getCorrectAnswerId() {
		return correctAnswerId;
	}
	public void setCorrectAnswerId(int correctAnswerId) {
		this.correctAnswerId = correctAnswerId;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public String getAnswer() {
		return correctAnswerBody;
	}
	public void setAnswer(String answer) {
		this.correctAnswerBody = answer;
	}
	
}
