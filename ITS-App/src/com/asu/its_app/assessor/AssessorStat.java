package com.asu.its_app.assessor;

public class AssessorStat {

	private int questionId;
	private int correctCount;
	private int incorrectCount;
	
	public AssessorStat(int questionId, int correctCount, int incorrectCount)
	{
		this.questionId = questionId;
		this.correctCount = questionId;
		this.incorrectCount = incorrectCount;
	}
	
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public int getCorrectCount() {
		return correctCount;
	}
	public void setCorrectCount(int correctCount) {
		this.correctCount = correctCount;
	}
	public int getIncorrectCount() {
		return incorrectCount;
	}
	public void setIncorrectCount(int incorrectCount) {
		this.incorrectCount = incorrectCount;
	}
	
}
