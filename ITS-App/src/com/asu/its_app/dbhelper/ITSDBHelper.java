package com.asu.its_app.dbhelper;

import java.sql.ResultSet;
import java.util.Date;

import com.asu.its_app.constant.Constants;
import com.asu.its_app.model.CorrectAnswer;
import com.asu.its_app.model.Hint;
import com.asu.its_app.model.KC;
import com.asu.its_app.model.Question;
import com.asu.its_app.step_analyzer.StepAnalyzer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class ITSDBHelper extends SQLiteOpenHelper{		
	
	private static ITSDBHelper instance = null;
	
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
		contentValues.put(Constants.QUESTION_TAB_QUESTION_BODY_COLUMN, "Which one of these triangles is a right triangle?");
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
				+ "imageLocation TEXT," 
				+ "questionId INTEGER)";
		
		db.execSQL(CREATE_HINT_TABLE);
		
		ContentValues contentValues = new ContentValues();
		contentValues.put(Constants.HINT_TAB_HINT_CONTENT_COLUMN, "A right triangle (American English) or right-angled triangle (British English) is a triangle in which one angle is a right angle (that is, a 90-degree angle)");
		contentValues.put(Constants.HINT_TAB_IMAGE_LOCATION_COLUMN, "im5");
		contentValues.put(Constants.HINT_TAB_QUESTION_ID_COLUMN, 1);
		db.insert(Constants.HINT_TAB_NAME, null, contentValues);
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
	
	public String getCorrectAnswer(Question question)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		
		String sResult ="";
		
		Cursor cursor = db.rawQuery("SELECT * FROM CORRECT_ANSWER WHERE questionId = ?",new String[]{Integer.toString(question.getQuestionId())});
        
		try {
			cursor.moveToFirst();
		    while (!cursor.isAfterLast()) {
                sResult = cursor.getString(1);
		      cursor.moveToNext();
		    }
        }
		catch(Exception exception)
		{
			exception.printStackTrace();
        }
		
		return sResult;
	}
	
	public String getQuestion(Question previousQuestion)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		
		String sResult ="";
		
		Cursor cursor = db.rawQuery("SELECT * FROM QUESTION WHERE questionId = ?",new String[]{Integer.toString(previousQuestion.getQuestionId()+1)});
        
		try {
			cursor.moveToFirst();
		    while (!cursor.isAfterLast()) {
                sResult = cursor.getString(1);
		      cursor.moveToNext();
		    }
        }
		catch(Exception exception)
		{
			exception.printStackTrace();
        }
		
		return sResult;
	}
	
	public String getHint(Question question)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		
		String sResult ="";
		
		Cursor cursor = db.rawQuery("SELECT * FROM HINT WHERE questionId = ?",new String[]{Integer.toString(question.getQuestionId())});
        
		try {
			cursor.moveToFirst();
		    while (!cursor.isAfterLast()) {
                sResult = cursor.getString(1);
		      cursor.moveToNext();
		    }
        }
		catch(Exception exception)
		{
			exception.printStackTrace();
        }
		
		return sResult;
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
}
