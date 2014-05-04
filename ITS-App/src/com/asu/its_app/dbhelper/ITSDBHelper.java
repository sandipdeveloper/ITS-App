package com.asu.its_app.dbhelper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.asu.its_app.constant.Constants;
import com.asu.its_app.model.Answer;
import com.asu.its_app.model.CorrectAnswer;
import com.asu.its_app.model.Feedback;
import com.asu.its_app.model.Hint;
import com.asu.its_app.model.KC;
import com.asu.its_app.model.Question;
import com.asu.its_app.step_analyzer.StepAnalyzer;
import com.example.its_app.R;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class ITSDBHelper extends SQLiteOpenHelper{		
	
	private static ITSDBHelper instance = null;
	
	public static ArrayList<AttemptStatus> attemptStatusList = new ArrayList<AttemptStatus>();
	
	public static ITSDBHelper getInstance(Context context)
	{
		if(instance == null)
		{
			return new ITSDBHelper(context);
		}
		
		return instance;
	}
	
	
	
	protected ITSDBHelper(Context context) {
		
		super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
	
	}

	
	@Override
	public void onCreate(SQLiteDatabase db) {

		//drop the table
		db.execSQL("DROP TABLE IF EXISTS QUESTION");

		
		//create questions table
		String CREATE_QUESTION_TABLE = "CREATE TABLE "+ Constants.QUESTION_TAB_NAME+" ( "
				+ "questionId INTEGER PRIMARY KEY AUTOINCREMENT," 
				+ "questionBody TEXT," 
				+ "numberOfAttepts INTEGER)";
		db.execSQL(CREATE_QUESTION_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}
	
	public void addStatus()
	{
		SQLiteDatabase db = this.getWritableDatabase();
		
		//drop the table
		db.execSQL("DROP TABLE IF EXISTS STATUS");

		//create questions table
		String CREATE_QUESTION_TABLE = "CREATE TABLE "+ Constants.QUESTION_TAB_NAME+" ( "
				+ "statusId INTEGER PRIMARY KEY AUTOINCREMENT," 
				+ "questionId TEXT," 
				+ "attempt INTEGER)";
		db.execSQL(CREATE_QUESTION_TABLE);
	}
	
	public void insertStatus(int questionId, int attempt)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		
		//create questions table
		String sql = "INSERT INTO STATUS  (questionId, attempt) VALUES ("
				+ questionId+ ","+attempt+")";
		
		db.execSQL(sql);
		
		db.close();
		
	}
	
	public int[][] getStatus()
	{
		int [][] status = new int[11][4];
		return status;
		
		
	}
	public void addQuestion(Question question)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		
		//drop the table
		db.execSQL("DROP TABLE IF EXISTS QUESTION");

		//create questions table
		String CREATE_QUESTION_TABLE = "CREATE TABLE "+ Constants.QUESTION_TAB_NAME+" ( "
				+ "questionId INTEGER PRIMARY KEY AUTOINCREMENT," 
				+ "questionBody TEXT," 
				+ "numberOfAttepts INTEGER)";
		db.execSQL(CREATE_QUESTION_TABLE);
		
		ContentValues contentValues = new ContentValues();
		contentValues.put(Constants.QUESTION_TAB_QUESTION_BODY_COLUMN, "Following are the pictures of different types of triangles. Which one of these triangles is a right triangle ? ");
		contentValues.put(Constants.QUESTION_TAB_NUMBER_OF_ATTEMPTS, 1);
		
		db.insert(Constants.QUESTION_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.QUESTION_TAB_QUESTION_BODY_COLUMN, "Following are the pictures of angleas of a right-angle triangle . Which one of these angles is a right angle ? ");
		contentValues.put(Constants.QUESTION_TAB_NUMBER_OF_ATTEMPTS, 1);
		
		db.insert(Constants.QUESTION_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.QUESTION_TAB_QUESTION_BODY_COLUMN, "Following are the pictures of the sides of a right-angle triangle . Which two legs are the leags of the right angle ? ");
		contentValues.put(Constants.QUESTION_TAB_NUMBER_OF_ATTEMPTS, 1);
		
		db.insert(Constants.QUESTION_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.QUESTION_TAB_QUESTION_BODY_COLUMN, "Following are the pictures of the sides of a right-angle triangle. Which one these sides is the hypotenuse of right-angle triangle ? ");
		contentValues.put(Constants.QUESTION_TAB_NUMBER_OF_ATTEMPTS, 1);
		
		db.insert(Constants.QUESTION_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.QUESTION_TAB_QUESTION_BODY_COLUMN, "Following is the picture of a right-angle triangle. Identify the formula of Pythagoras' Theorem ");
		contentValues.put(Constants.QUESTION_TAB_NUMBER_OF_ATTEMPTS, 1);
		
		db.insert(Constants.QUESTION_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.QUESTION_TAB_QUESTION_BODY_COLUMN, "Following is the picture of a rectangular football ground with length of its' sides. Identify the shortest distance from corner A to D using Pythagoras' Theorem ");
		contentValues.put(Constants.QUESTION_TAB_NUMBER_OF_ATTEMPTS, 1);
		
		db.insert(Constants.QUESTION_TAB_NAME, null, contentValues);

		contentValues = new ContentValues();
		contentValues.put(Constants.QUESTION_TAB_QUESTION_BODY_COLUMN, "From point R a person can see the two furthest point of a pond P and Q, RP = 24 ft and RQ = 26 ft, if the angle RPQ = 90 degree, what is the length of the pond ? ");
		contentValues.put(Constants.QUESTION_TAB_NUMBER_OF_ATTEMPTS, 1);

		db.insert(Constants.QUESTION_TAB_NAME, null, contentValues);

		contentValues = new ContentValues();
		contentValues.put(Constants.QUESTION_TAB_QUESTION_BODY_COLUMN, "How long must a guywire be to reach from the top of a 12 ft pole to a point on the ground 5 ft from the base of the pole ? ");
		contentValues.put(Constants.QUESTION_TAB_NUMBER_OF_ATTEMPTS, 1);

		db.insert(Constants.QUESTION_TAB_NAME, null, contentValues);

		contentValues = new ContentValues();
		contentValues.put(Constants.QUESTION_TAB_QUESTION_BODY_COLUMN, "What is the length of the shadow of 30 ft pole (AB), provided that the elevation of sun rays is such that AB/AC = 3/5 ? ");
		contentValues.put(Constants.QUESTION_TAB_NUMBER_OF_ATTEMPTS, 1);

		db.insert(Constants.QUESTION_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.QUESTION_TAB_QUESTION_BODY_COLUMN, "A police starts chasing a thief (both have same velocity) from A, after 1 hour the thief reaches at point C, if the police takes path A-B-C, will she be able to catch the thief in 1 hour? ");
		contentValues.put(Constants.QUESTION_TAB_NUMBER_OF_ATTEMPTS, 1);

		db.insert(Constants.QUESTION_TAB_NAME, null, contentValues);

		contentValues = new ContentValues();
		contentValues.put(Constants.QUESTION_TAB_QUESTION_BODY_COLUMN, "What is the minimum length of a ladder the fire department can use to put up the fire broke out at a 1200 ft high apartment from 500 ft distance ?");
		contentValues.put(Constants.QUESTION_TAB_NUMBER_OF_ATTEMPTS, 1);

		db.insert(Constants.QUESTION_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.QUESTION_TAB_QUESTION_BODY_COLUMN, "What is the maximum length of a stick which can fit inside a 4 ft long and 3 ft wide (diameter) oil drum ? ");
		contentValues.put(Constants.QUESTION_TAB_NUMBER_OF_ATTEMPTS, 1);

		db.insert(Constants.QUESTION_TAB_NAME, null, contentValues);

		contentValues = new ContentValues();
		contentValues.put(Constants.QUESTION_TAB_QUESTION_BODY_COLUMN, "What is the hight of a tent as shown in the diagram, with 6 ft base, 12 ft length and 5 ft side (both sides are equal) ? ");
		contentValues.put(Constants.QUESTION_TAB_NUMBER_OF_ATTEMPTS, 1);

		db.insert(Constants.QUESTION_TAB_NAME, null, contentValues);

		
		db.close();
	}

	public void addHint(Hint hint)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		
		//drop the table
		db.execSQL("DROP TABLE IF EXISTS HINT");

		//create questions table
		String CREATE_HINT_TABLE = "CREATE TABLE "+ Constants.HINT_TAB_NAME+" ( "
				+ "hintId INTEGER PRIMARY KEY AUTOINCREMENT," 
				+ "hintContent TEXT," 
				+ "imageLocation INT," 
				+ "questionId INTEGER)";
		
		db.execSQL(CREATE_HINT_TABLE);
		
		ContentValues contentValues = new ContentValues();
		contentValues.put(Constants.HINT_TAB_HINT_CONTENT_COLUMN, "A right triangle is a triangle in which one angle is a right angle (that is, a 90-degree angle)" +
				"Following is a picture of right triangle where angle between side a and b is a right angle");
		contentValues.put(Constants.HINT_TAB_IMAGE_LOCATION_COLUMN, R.drawable.hint_1);
		contentValues.put(Constants.HINT_TAB_QUESTION_ID_COLUMN, 1);
		db.insert(Constants.HINT_TAB_NAME, null, contentValues);
		
		
		contentValues = new ContentValues();
		contentValues.put(Constants.HINT_TAB_HINT_CONTENT_COLUMN, "A right angle is an angle equal to half the angle from one end of a line segment to the other. A right angle is pi/2 radians or  90 degrees." +
				"Following is a picture of right triangle where angle between leg a and b is a right angle");
		contentValues.put(Constants.HINT_TAB_IMAGE_LOCATION_COLUMN, R.drawable.hint_2);
		contentValues.put(Constants.HINT_TAB_QUESTION_ID_COLUMN, 2);
		db.insert(Constants.HINT_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.HINT_TAB_HINT_CONTENT_COLUMN, "In a right triangle, the sides opposite to the acute angles are called the Legs of a Triangle. " +
				"The legs are the two shorter sides of a right triangle. The legs of a right triangle are perpendicular to each other." +
				"Following is a picture of right triangle where  a and b are the legs");
		contentValues.put(Constants.HINT_TAB_IMAGE_LOCATION_COLUMN, R.drawable.hint_3);
		contentValues.put(Constants.HINT_TAB_QUESTION_ID_COLUMN, 3);
		db.insert(Constants.HINT_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.HINT_TAB_HINT_CONTENT_COLUMN, "The hypotenuse of a right triangle is the triangle's longest side, i.e., the side opposite the right angle. " +
				"Following is a picture of right triangle where  c is the hypotenuse");
		contentValues.put(Constants.HINT_TAB_IMAGE_LOCATION_COLUMN, R.drawable.hint_4);
		contentValues.put(Constants.HINT_TAB_QUESTION_ID_COLUMN, 4);
		db.insert(Constants.HINT_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.HINT_TAB_HINT_CONTENT_COLUMN, "In a right triangle, the square of the hypotenuse is equal to the sum of the squares of the other two sides. " +
				"Following is a picture of a right triangle ABC where, according to Pythagoras' Theorem, AC^2 = AB^2 + BC^2");
		contentValues.put(Constants.HINT_TAB_IMAGE_LOCATION_COLUMN, R.drawable.hint_5);
		contentValues.put(Constants.HINT_TAB_QUESTION_ID_COLUMN, 5);
		db.insert(Constants.HINT_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.HINT_TAB_HINT_CONTENT_COLUMN, "From diagram it is clear that ADC is a right triangle where angle ACD is right angle. According to Pythagoras' Theorem AD^2 = 30^2 + 40^2, or AD = 50" +
				"Following is a picture of a right triangle ABC where, according to Pythagoras' Theorem, AC^2 = AB^2 + BC^2");
		contentValues.put(Constants.HINT_TAB_IMAGE_LOCATION_COLUMN, R.drawable.hint_6);
		contentValues.put(Constants.HINT_TAB_QUESTION_ID_COLUMN, 6);
		db.insert(Constants.HINT_TAB_NAME, null, contentValues);
		
		db.close();
	}

	public void addResource()
	{
		SQLiteDatabase db = this.getWritableDatabase();
		
		//drop the table
		db.execSQL("DROP TABLE IF EXISTS RESOURCE");

		//create questions table
		String CREATE_RESOURCE_TABLE = "CREATE TABLE "+ Constants.RESOURCE_TAB_NAME+" ( "
				+ "resourceId INTEGER PRIMARY KEY AUTOINCREMENT," 
				+ "resourceValue INT," 
				+ "correctOption TEXT)";
		
		db.execSQL(CREATE_RESOURCE_TABLE);
		
		ContentValues contentValues = new ContentValues();
		contentValues.put(Constants.RESOURCE_TAB_RESOURCE_VALUE_COLUMN, R.drawable.question_1_1);
		contentValues.put(Constants.RESOURCE_TAB_CORRECT_OPTION_COLUMN, "d");
		db.insert(Constants.RESOURCE_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.RESOURCE_TAB_RESOURCE_VALUE_COLUMN, R.drawable.question_1_2);
		contentValues.put(Constants.RESOURCE_TAB_CORRECT_OPTION_COLUMN, "c");
		db.insert(Constants.RESOURCE_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.RESOURCE_TAB_RESOURCE_VALUE_COLUMN, R.drawable.question_1_3);
		contentValues.put(Constants.RESOURCE_TAB_CORRECT_OPTION_COLUMN, "a");
		db.insert(Constants.RESOURCE_TAB_NAME, null, contentValues);		
		
		contentValues = new ContentValues();
		contentValues.put(Constants.RESOURCE_TAB_RESOURCE_VALUE_COLUMN, R.drawable.question_1_4);
		contentValues.put(Constants.RESOURCE_TAB_CORRECT_OPTION_COLUMN, "b");
		db.insert(Constants.RESOURCE_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.RESOURCE_TAB_RESOURCE_VALUE_COLUMN, R.drawable.question_2_1);
		contentValues.put(Constants.RESOURCE_TAB_CORRECT_OPTION_COLUMN, "d");
		db.insert(Constants.RESOURCE_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.RESOURCE_TAB_RESOURCE_VALUE_COLUMN, R.drawable.question_2_2);
		contentValues.put(Constants.RESOURCE_TAB_CORRECT_OPTION_COLUMN, "a");
		db.insert(Constants.RESOURCE_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.RESOURCE_TAB_RESOURCE_VALUE_COLUMN, R.drawable.question_2_3);
		contentValues.put(Constants.RESOURCE_TAB_CORRECT_OPTION_COLUMN, "d");
		db.insert(Constants.RESOURCE_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.RESOURCE_TAB_RESOURCE_VALUE_COLUMN, R.drawable.question_2_4);
		contentValues.put(Constants.RESOURCE_TAB_CORRECT_OPTION_COLUMN, "b");
		db.insert(Constants.RESOURCE_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.RESOURCE_TAB_RESOURCE_VALUE_COLUMN, R.drawable.question_3_1);
		contentValues.put(Constants.RESOURCE_TAB_CORRECT_OPTION_COLUMN, "b");
		db.insert(Constants.RESOURCE_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.RESOURCE_TAB_RESOURCE_VALUE_COLUMN, R.drawable.question_3_2);
		contentValues.put(Constants.RESOURCE_TAB_CORRECT_OPTION_COLUMN, "b");
		db.insert(Constants.RESOURCE_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.RESOURCE_TAB_RESOURCE_VALUE_COLUMN, R.drawable.question_3_3);
		contentValues.put(Constants.RESOURCE_TAB_CORRECT_OPTION_COLUMN, "a");
		db.insert(Constants.RESOURCE_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.RESOURCE_TAB_RESOURCE_VALUE_COLUMN, R.drawable.question_3_4);
		contentValues.put(Constants.RESOURCE_TAB_CORRECT_OPTION_COLUMN, "d");
		db.insert(Constants.RESOURCE_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.RESOURCE_TAB_RESOURCE_VALUE_COLUMN, R.drawable.question_4_1);
		contentValues.put(Constants.RESOURCE_TAB_CORRECT_OPTION_COLUMN, "b");
		db.insert(Constants.RESOURCE_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.RESOURCE_TAB_RESOURCE_VALUE_COLUMN, R.drawable.question_4_2);
		contentValues.put(Constants.RESOURCE_TAB_CORRECT_OPTION_COLUMN, "b");
		db.insert(Constants.RESOURCE_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.RESOURCE_TAB_RESOURCE_VALUE_COLUMN, R.drawable.question_4_3);
		contentValues.put(Constants.RESOURCE_TAB_CORRECT_OPTION_COLUMN, "d");
		db.insert(Constants.RESOURCE_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.RESOURCE_TAB_RESOURCE_VALUE_COLUMN, R.drawable.question_4_4);
		contentValues.put(Constants.RESOURCE_TAB_CORRECT_OPTION_COLUMN, "b");
		db.insert(Constants.RESOURCE_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.RESOURCE_TAB_RESOURCE_VALUE_COLUMN, R.drawable.question_5_1);
		contentValues.put(Constants.RESOURCE_TAB_CORRECT_OPTION_COLUMN, "d");
		db.insert(Constants.RESOURCE_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.RESOURCE_TAB_RESOURCE_VALUE_COLUMN, R.drawable.question_5_2);
		contentValues.put(Constants.RESOURCE_TAB_CORRECT_OPTION_COLUMN, "d");
		db.insert(Constants.RESOURCE_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.RESOURCE_TAB_RESOURCE_VALUE_COLUMN, R.drawable.question_5_3);
		contentValues.put(Constants.RESOURCE_TAB_CORRECT_OPTION_COLUMN, "d");
		db.insert(Constants.RESOURCE_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.RESOURCE_TAB_RESOURCE_VALUE_COLUMN, R.drawable.question_5_4);
		contentValues.put(Constants.RESOURCE_TAB_CORRECT_OPTION_COLUMN, "a");
		db.insert(Constants.RESOURCE_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.RESOURCE_TAB_RESOURCE_VALUE_COLUMN, R.drawable.question_6_1);
		contentValues.put(Constants.RESOURCE_TAB_CORRECT_OPTION_COLUMN, "b");
		db.insert(Constants.RESOURCE_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.RESOURCE_TAB_RESOURCE_VALUE_COLUMN, R.drawable.question_6_2);
		contentValues.put(Constants.RESOURCE_TAB_CORRECT_OPTION_COLUMN, "c");
		db.insert(Constants.RESOURCE_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.RESOURCE_TAB_RESOURCE_VALUE_COLUMN, R.drawable.question_6_3);
		contentValues.put(Constants.RESOURCE_TAB_CORRECT_OPTION_COLUMN, "d");
		db.insert(Constants.RESOURCE_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.RESOURCE_TAB_RESOURCE_VALUE_COLUMN, R.drawable.question_6_4);
		contentValues.put(Constants.RESOURCE_TAB_CORRECT_OPTION_COLUMN, "a");
		db.insert(Constants.RESOURCE_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.RESOURCE_TAB_RESOURCE_VALUE_COLUMN, R.drawable.question_7_1);
		contentValues.put(Constants.RESOURCE_TAB_CORRECT_OPTION_COLUMN, "a");
		db.insert(Constants.RESOURCE_TAB_NAME, null, contentValues);

		contentValues = new ContentValues();
		contentValues.put(Constants.RESOURCE_TAB_RESOURCE_VALUE_COLUMN, R.drawable.question_7_2);
		contentValues.put(Constants.RESOURCE_TAB_CORRECT_OPTION_COLUMN, "c");
		db.insert(Constants.RESOURCE_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.RESOURCE_TAB_RESOURCE_VALUE_COLUMN, R.drawable.question_7_3);
		contentValues.put(Constants.RESOURCE_TAB_CORRECT_OPTION_COLUMN, "c");
		db.insert(Constants.RESOURCE_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.RESOURCE_TAB_RESOURCE_VALUE_COLUMN, R.drawable.question_7_4);
		contentValues.put(Constants.RESOURCE_TAB_CORRECT_OPTION_COLUMN, "c");
		db.insert(Constants.RESOURCE_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.RESOURCE_TAB_RESOURCE_VALUE_COLUMN, R.drawable.question_8_1);
		contentValues.put(Constants.RESOURCE_TAB_CORRECT_OPTION_COLUMN, "c");
		db.insert(Constants.RESOURCE_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.RESOURCE_TAB_RESOURCE_VALUE_COLUMN, R.drawable.question_8_2);
		contentValues.put(Constants.RESOURCE_TAB_CORRECT_OPTION_COLUMN, "b");
		db.insert(Constants.RESOURCE_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.RESOURCE_TAB_RESOURCE_VALUE_COLUMN, R.drawable.question_8_3);
		contentValues.put(Constants.RESOURCE_TAB_CORRECT_OPTION_COLUMN, "c");
		db.insert(Constants.RESOURCE_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.RESOURCE_TAB_RESOURCE_VALUE_COLUMN, R.drawable.question_8_4);
		contentValues.put(Constants.RESOURCE_TAB_CORRECT_OPTION_COLUMN, "b");
		db.insert(Constants.RESOURCE_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.RESOURCE_TAB_RESOURCE_VALUE_COLUMN, R.drawable.question_9_1);
		contentValues.put(Constants.RESOURCE_TAB_CORRECT_OPTION_COLUMN, "a");
		db.insert(Constants.RESOURCE_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.RESOURCE_TAB_RESOURCE_VALUE_COLUMN, R.drawable.question_9_2);
		contentValues.put(Constants.RESOURCE_TAB_CORRECT_OPTION_COLUMN, "b");
		db.insert(Constants.RESOURCE_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.RESOURCE_TAB_RESOURCE_VALUE_COLUMN, R.drawable.question_9_3);
		contentValues.put(Constants.RESOURCE_TAB_CORRECT_OPTION_COLUMN, "d");
		db.insert(Constants.RESOURCE_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.RESOURCE_TAB_RESOURCE_VALUE_COLUMN, R.drawable.question_9_4);
		contentValues.put(Constants.RESOURCE_TAB_CORRECT_OPTION_COLUMN, "a");
		db.insert(Constants.RESOURCE_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.RESOURCE_TAB_RESOURCE_VALUE_COLUMN, R.drawable.question_10_1);
		contentValues.put(Constants.RESOURCE_TAB_CORRECT_OPTION_COLUMN, "");
		db.insert(Constants.RESOURCE_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.RESOURCE_TAB_RESOURCE_VALUE_COLUMN, R.drawable.question_11_1);
		contentValues.put(Constants.RESOURCE_TAB_CORRECT_OPTION_COLUMN, "b");
		db.insert(Constants.RESOURCE_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.RESOURCE_TAB_RESOURCE_VALUE_COLUMN, R.drawable.question_12_1);
		contentValues.put(Constants.RESOURCE_TAB_CORRECT_OPTION_COLUMN, "130");
		db.insert(Constants.RESOURCE_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.RESOURCE_TAB_RESOURCE_VALUE_COLUMN, R.drawable.question_13_1);
		contentValues.put(Constants.RESOURCE_TAB_CORRECT_OPTION_COLUMN, "5");
		db.insert(Constants.RESOURCE_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.RESOURCE_TAB_RESOURCE_VALUE_COLUMN, R.drawable.question_14_1);
		contentValues.put(Constants.RESOURCE_TAB_CORRECT_OPTION_COLUMN, "4");
		db.insert(Constants.RESOURCE_TAB_NAME, null, contentValues);
		
		db.close();
	}
	
	public String getCorrectAnswer(int id)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery("SELECT * FROM RESOURCE WHERE resourceValue = ?",new String[]{Integer.toString(id)});
        String answer="";
		try {
			cursor.moveToFirst();
		    while (!cursor.isAfterLast()) {
                     answer = cursor.getString(2);
                                
		      cursor.moveToNext();
		    }
        }
		catch(Exception exception)
		{
			exception.printStackTrace();
        }
		
		return answer;		
	}
	public void addFeedback(Feedback feedback)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		
		//drop the table
		db.execSQL("DROP TABLE IF EXISTS FEEDBACK");

		//create questions table
		String CREATE_HINT_TABLE = "CREATE TABLE "+ Constants.FEEDBACK_TAB_NAME+" ( "
				+ "feedbackId INTEGER PRIMARY KEY AUTOINCREMENT," 
				+ "feedbackContent TEXT," 
				+ "isCorrect INTEGER )";
		
		db.execSQL(CREATE_HINT_TABLE);
		
		ContentValues contentValues = new ContentValues();
		contentValues.put(Constants.FEEDBACK_TAB_FEEDBACK_CONTENT_COLUMN, "That is correct. Please click on the next button to proceed to the next question");
		contentValues.put(Constants.FEEDBACK_TAB_ISCORRECT_COLUMN, "1");
		db.insert(Constants.FEEDBACK_TAB_NAME, null, contentValues);
		
		contentValues = new ContentValues();
		contentValues.put(Constants.FEEDBACK_TAB_FEEDBACK_CONTENT_COLUMN, "That is not correct. Please try again. Click on hint if you need one");
		contentValues.put(Constants.FEEDBACK_TAB_ISCORRECT_COLUMN, "0");
		db.insert(Constants.FEEDBACK_TAB_NAME, null, contentValues);
				
		db.close();
	}
	
	public void addCorrectAnswer(CorrectAnswer correctAnswer)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		
		//drop the table
		db.execSQL("DROP TABLE IF EXISTS CORRECT_ANSWER");

		//create questions table
		String CREATE_HINT_TABLE = "CREATE TABLE "+ Constants.CORRECT_ANSWER_TAB_NAME+" ( "
				+ "correctAnswerId INTEGER PRIMARY KEY AUTOINCREMENT," 
				+ "correctAnswerBody TEXT,"  
				+ "questionId INTEGER)";
		
		db.execSQL(CREATE_HINT_TABLE);
		
		ContentValues contentValues = new ContentValues();
		contentValues.put(Constants.CORRECT_ANSWER_TAB_ANSWER_BODY_COLUMN, "c");
		contentValues.put(Constants.CORRECT_ANSWER_TAB_QUESTION_ID_COLUMN, 1);
		db.insert(Constants.CORRECT_ANSWER_TAB_NAME, null, contentValues);
		db.close();
	}
	
	public Answer getCorrectAnswer(Question question)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery("SELECT * FROM CORRECT_ANSWER WHERE questionId = ?",new String[]{Integer.toString(question.getQuestionId())});
        Answer answer = new Answer();
		try {
			cursor.moveToFirst();
		    while (!cursor.isAfterLast()) {
                answer.setAnswerId(cursor.getInt(0));
                answer.setAnswerBody(cursor.getString(1));
                answer.setQuestion(question);                
		      cursor.moveToNext();
		    }
        }
		catch(Exception exception)
		{
			exception.printStackTrace();
        }
		
		return answer;
	}
	
	public Question getQuestion(Question previousQuestion)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		
		String sResult ="";
		
		Cursor cursor = db.rawQuery("SELECT * FROM QUESTION WHERE questionId = ?",new String[]{Integer.toString(previousQuestion.getQuestionId()+1)});
        
		Question question = new Question();
		try {
			cursor.moveToFirst();
		    while (!cursor.isAfterLast()) 
		    {
                question.setQuestionId(cursor.getInt(0));
                question.setQuestionBody(cursor.getString(1));
                question.setNumberOfAttempts(cursor.getInt(2));
                cursor.moveToNext();
		    }
        }
		catch(Exception exception)
		{
			exception.printStackTrace();
        }
		
		return question;
	}
	
	public Hint getHint(Question question)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		
		Hint hint = new Hint();
		
		Cursor cursor = db.rawQuery("SELECT * FROM HINT WHERE questionId = ?",new String[]{Integer.toString(question.getQuestionId())});
        
		try {
			cursor.moveToFirst();
		    while (!cursor.isAfterLast()) {		    	
                hint.setHintId(cursor.getInt(0));
                hint.setHintContent(cursor.getString(1));
                hint.setImageLocation(cursor.getInt(2));
                cursor.moveToNext();
		    }
        }
		catch(Exception exception)
		{
			exception.printStackTrace();
        }
		
		return hint;
	}
	public double getLearningRateForKC(KC kc) {
		// TODO Auto-generated method stub
		return 0;
	}


	public int getTotalNumberCorrectAnswersFromDatabase() {
		// TODO Auto-generated method stub
		return 0;
	}


	public double getDifficultyForKC(KC kc) {
		// TODO Auto-generated method stub
		return 0;
	}


	public boolean saveCompetencyToDatabase(double competency, Date dateTime) {
		return false;
		// TODO Auto-generated method stub
		
	}


	public int getQuestionResourceIdFromDatabase(Question currentQuestion) {
		
		if(currentQuestion.getQuestionId()==1)
		{
			if(currentQuestion.getNumberOfAttempts()==1)
			{
				return R.drawable.question_1_1;
			}
			else if(currentQuestion.getNumberOfAttempts()==2)
			{
				return R.drawable.question_1_2;
			}
			else if(currentQuestion.getNumberOfAttempts()==3)
			{
				return R.drawable.question_1_3;
			}
			else if(currentQuestion.getNumberOfAttempts()==4)
			{
				return R.drawable.question_1_4;
			}
		}
		else if(currentQuestion.getQuestionId()==2)
		{
			if(currentQuestion.getNumberOfAttempts()==1)
			{
				return R.drawable.question_2_1;
			}
			else if(currentQuestion.getNumberOfAttempts()==2)
			{
				return R.drawable.question_2_2;
			}
			else if(currentQuestion.getNumberOfAttempts()==3)
			{
				return R.drawable.question_2_3;
			}
			else if(currentQuestion.getNumberOfAttempts()==4)
			{
				return R.drawable.question_2_4;
			}
		}
		else if(currentQuestion.getQuestionId()==3)
		{
			if(currentQuestion.getNumberOfAttempts()==1)
			{
				return R.drawable.question_3_1;
			}
			else if(currentQuestion.getNumberOfAttempts()==2)
			{
				return R.drawable.question_3_2;
			}
			else if(currentQuestion.getNumberOfAttempts()==3)
			{
				return R.drawable.question_3_3;
			}
			else if(currentQuestion.getNumberOfAttempts()==4)
			{
				return R.drawable.question_3_4;
			}
		}
		else if(currentQuestion.getQuestionId()==4)
		{
			if(currentQuestion.getNumberOfAttempts()==1)
			{
				return R.drawable.question_4_1;
			}
			else if(currentQuestion.getNumberOfAttempts()==2)
			{
				return R.drawable.question_4_2;
			}
			else if(currentQuestion.getNumberOfAttempts()==3)
			{
				return R.drawable.question_4_3;
			}
			else if(currentQuestion.getNumberOfAttempts()==4)
			{
				return R.drawable.question_4_4;
			}
		}
		else if(currentQuestion.getQuestionId()==5)
		{
			if(currentQuestion.getNumberOfAttempts()==1)
			{
				return R.drawable.question_5_1;
			}
			else if(currentQuestion.getNumberOfAttempts()==2)
			{
				return R.drawable.question_5_2;
			}
			else if(currentQuestion.getNumberOfAttempts()==3)
			{
				return R.drawable.question_5_3;
			}
			else if(currentQuestion.getNumberOfAttempts()==4)
			{
				return R.drawable.question_5_4;
			}
		}
		else if(currentQuestion.getQuestionId()==6)
		{
			if(currentQuestion.getNumberOfAttempts()==1)
			{
				return R.drawable.question_6_1;
			}
			else if(currentQuestion.getNumberOfAttempts()==2)
			{
				return R.drawable.question_6_2;
			}
			else if(currentQuestion.getNumberOfAttempts()==3)
			{
				return R.drawable.question_6_3;
			}
			else if(currentQuestion.getNumberOfAttempts()==4)
			{
				return R.drawable.question_6_4;
			}
		}
		else if(currentQuestion.getQuestionId()==7)
		{
			if(currentQuestion.getNumberOfAttempts()==1)
			{
				return R.drawable.question_7_1;
			}
			else if(currentQuestion.getNumberOfAttempts()==2)
			{
				return R.drawable.question_7_2;
			}
			else if(currentQuestion.getNumberOfAttempts()==3)
			{
				return R.drawable.question_7_3;
			}
			else if(currentQuestion.getNumberOfAttempts()==4)
			{
				return R.drawable.question_7_4;
			}
		}
		else if(currentQuestion.getQuestionId()==8)
		{
			if(currentQuestion.getNumberOfAttempts()==1)
			{
				return R.drawable.question_8_1;
			}
			else if(currentQuestion.getNumberOfAttempts()==2)
			{
				return R.drawable.question_8_2;
			}
			else if(currentQuestion.getNumberOfAttempts()==3)
			{
				return R.drawable.question_8_3;
			}
			else if(currentQuestion.getNumberOfAttempts()==4)
			{
				return R.drawable.question_8_4;
			}
		}
		else if(currentQuestion.getQuestionId()==9)
		{
			if(currentQuestion.getNumberOfAttempts()==1)
			{
				return R.drawable.question_9_1;
			}
			else if(currentQuestion.getNumberOfAttempts()==2)
			{
				return R.drawable.question_9_2;
			}
			else if(currentQuestion.getNumberOfAttempts()==3)
			{
				return R.drawable.question_9_3;
			}
			else if(currentQuestion.getNumberOfAttempts()==4)
			{
				return R.drawable.question_9_4;
			}
		}
		else if(currentQuestion.getQuestionId()==10)
		{
				return R.drawable.question_11_1;
		}
		else if(currentQuestion.getQuestionId()==11)
		{
				return R.drawable.question_12_1;
		}
		else if(currentQuestion.getQuestionId()==12)
		{
				return R.drawable.question_13_1;
		}
		else if(currentQuestion.getQuestionId()==13)
		{
				return R.drawable.question_14_1;
		}
		return 0;
	}


	public int getAnswerOptionResourceIdFromDatabase(Question currentQuestion) {
		// TODO Auto-generated method stub
		return R.drawable.answer_option_1_1;
	}


	public int getHintImageResource(Hint hint) {
		// TODO Auto-generated method stub
		return 0;
	}


	public Feedback getFeedbackFromDatabase(int i) {
		
		SQLiteDatabase db = this.getWritableDatabase();
		
		Feedback feedback = new Feedback();
		
		Cursor cursor = db.rawQuery("SELECT * FROM FEEDBACK WHERE feedbackId = ?",new String[]{Integer.toString(i)});
        
		try {
			cursor.moveToFirst();
		    while (!cursor.isAfterLast()) {
              feedback.setFeedbackId(cursor.getInt(0));
              feedback.setFeedbackText(cursor.getString(1));
		      cursor.moveToNext();
		    }
        }
		catch(Exception exception)
		{
			exception.printStackTrace();
        }
		
		return feedback;
	}
	
	public static double stringMatcher(String a, int questionId)
	{
		String b ="";
		if(questionId == 10)
		{
			b ="Police has to travel 7 miles to reach the point C whereas the thief only needs to go (3^2+4^2)^1/2 = 5 miles, according to Pythagorean theorem" +
					"Here angle  ABC is 90 degree" +
					"If they start at the same point A, and their velocity is same then the police will not be able to catch the thief in 1 hour.";
		}
		else if(questionId == 11)
		{
			b = "Here angle betwwen the building and the horizontal plane is 90 degree. So according to Pythagorean theorem" +
					" if length of ladder is l, height of building apartment from ground is h and distance is d then " +
					"l2 = h2+d2, l = (h^2+d^2)^1/2, l = (120^2+50^2)^1/2, = 130 ft";
		}
		else if(questionId == 12)
		{
			b = "If we draw a diagonal between the furthest corners of the cylinder, and its' length is l" +
					" then according to Pythagorean theorem l^2 = (3^2+4^2)^1/2 ft = 5 ft ";
		}
		else if(questionId == 13)
		{
			b = "If h is the height of the triangle, according to Pythagorean theorem and properties of" +
					" isoscales triangle h^2 = (5^2-3^2)^1/2 ft = 4 ft ";
		}
		double count = 0;
		String[] words = a.split("\\s+");
		String []cont = b.split("\\s+");
		for(String word : words) {
		if(b.indexOf(word) != -1) {
			      count++;
			}
		}
		return (count / cont.length)*100;
			
	}
}
