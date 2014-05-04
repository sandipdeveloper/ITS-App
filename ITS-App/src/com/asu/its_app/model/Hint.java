package com.asu.its_app.model;

import java.io.Serializable;

import android.os.Parcelable;

public class Hint implements Serializable{

	private int hintId;
	private String hintContent;
	private int imageLocation;
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
	public int getImageLocation() {
		return imageLocation;
	}
	public void setImageLocation(int imageLocation) {
		this.imageLocation = imageLocation;
	}
	
	
}
