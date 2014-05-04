package com.asu.its_app.model;

public class Answer {

	private String answerBody;
	private Question question;
	private int answerId;
	private String selectedAnswer;
	
	public String getSelectedAnswer() {
		return selectedAnswer;
	}
	public void setSelectedAnswer(String selectedAnswer) {
		this.selectedAnswer = selectedAnswer;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public String getAnswerBody() {
		return answerBody;
	}
	public void setAnswerBody(String answerBody) {
		this.answerBody = answerBody;
	}
}
