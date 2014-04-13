package com.asu.its_app.model;

public class Option {

	private Question question;
	private String optionBody;
	private String optionIdentifier;
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public String getOptionBody() {
		return optionBody;
	}
	public void setOptionBody(String optionBody) {
		this.optionBody = optionBody;
	}
	public String getOptionIdentifier() {
		return optionIdentifier;
	}
	public void setOptionIdentifier(String optionIdentifier) {
		this.optionIdentifier = optionIdentifier;
	}
	
}
