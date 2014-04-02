package com.asu.its_app.model;

public class Answer {

	private String answerBody;
	private boolean isCorrect;
	private int questionId;
	public String getAnswerBody() {
		return answerBody;
	}
	public void setAnswerBody(String answerBody) {
		this.answerBody = answerBody;
	}
	public boolean isCorrect() {
		return isCorrect;
	}
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	
}
