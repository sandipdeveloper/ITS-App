package com.asu.its_app.question_template;

import java.util.ArrayList;

import com.asu.its_app.image_template.ImageTemplate;
import com.asu.its_app.model.Option;
import com.asu.its_app.model.Question;

public class QuestionTemplate {

	private Question question;
	private ArrayList<ImageTemplate> imageTemplateList;
	private ArrayList<Option> optionList;
	
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public ArrayList<ImageTemplate> getImageTemplateList() {
		return imageTemplateList;
	}
	public void setImageTemplateList(ArrayList<ImageTemplate> imageTemplateList) {
		this.imageTemplateList = imageTemplateList;
	}
	public ArrayList<Option> getOptionList() {
		return optionList;
	}
	public void setOptionList(ArrayList<Option> optionList) {
		this.optionList = optionList;
	}
	
	
	
}
