package com.asu.its_app.model;

public class CorrectAnswer {

	private Question question;
	private Answer answer;
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
	public Answer getAnswer() {
		return answer;
	}
	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
	
	
}
