package com.asu.its_app.constant;

public class Constants {

	
	public static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "ITSDB";
	
	public static final String QUESTION_TAB_NAME = "QUESTION";
	public static final String QUESTION_TAB_QUESTION_ID_COLUMN = "questionId";
	public static final String QUESTION_TAB_QUESTION_BODY_COLUMN = "questionBody";
	public static final String QUESTION_TAB_KC_ID_COLUMN = "kcId";
	public static final String QUESTION_TAB_NUMBER_OF_ATTEMPTS = "numberOfAttepts";
	
	
	public static final String HINT_TAB_NAME = "HINT";
	public static final String HINT_TAB_HINT_ID_COLUMN = "hintId";
	public static final String HINT_TAB_HINT_CONTENT_COLUMN = "hintContent";
	public static final String HINT_TAB_IMAGE_LOCATION_COLUMN = "imageLocation";
	public static final String HINT_TAB_QUESTION_ID_COLUMN = "questionId";

	public static final String RESOURCE_TAB_NAME = "RESOURCE";
	public static final String RESOURCE_TAB_RESOURCE_ID_COLUMN = "resourceId";
	public static final String RESOURCE_TAB_RESOURCE_VALUE_COLUMN = "resourceValue";
	public static final String RESOURCE_TAB_CORRECT_OPTION_COLUMN = "correctOption";

	
	public static final String CORRECT_ANSWER_TAB_NAME = "CORRECT_ANSWER";
	public static final String CORRECT_ANSWER_TAB_ID_COLUMN = "correctAnswerId";
	public static final String CORRECT_ANSWER_TAB_ANSWER_BODY_COLUMN = "correctAnswerBody";
	public static final String CORRECT_ANSWER_TAB_QUESTION_ID_COLUMN = "questionId";
	
	public static final String FEEDBACK_TAB_NAME = "FEEDBACK";
	public static final String FEEDBACK_TAB_FEEDBACK_ID_COLUMN = "feedbackId";
	public static final String FEEDBACK_TAB_FEEDBACK_CONTENT_COLUMN = "feedbackContent";
	public static final String FEEDBACK_TAB_ISCORRECT_COLUMN = "isCorrect";
}
