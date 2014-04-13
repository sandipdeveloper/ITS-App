package com.asu.its_app.dbhelper;

import java.util.Date;

import com.asu.its_app.constant.Constants;
import com.asu.its_app.model.KC;
import com.asu.its_app.model.Question;
import com.asu.its_app.step_analyzer.StepAnalyzer;

import android.content.ContentValues;
import android.content.Context;
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
	
		//create questions table
		String CREATE_QUESTION_TABLE = "CREATE TABLE "+ Constants.QUESTION_TAB_NAME+" ( "
				+ "questionId INTEGER PRIMARY KEY AUTOINCREMENT," 
				+ "questionBody TEXT" 
				+ "kcId INTEGER )";
		db.execSQL(CREATE_QUESTION_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

		//drop the table
		db.execSQL("DROP TABLE IF EXISTS QUESTION");
		
		this.onCreate(db);
	}
	
	public void addQuestion(Question question)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put(Constants.QUESTION_TAB_QUESTION_BODY_COLUMN, "what is the question?");
		contentValues.put(Constants.QUESTION_TAB_KC_ID_COLUMN, 0);
		db.insert(Constants.QUESTION_TAB_NAME, null, contentValues);
		db.close();
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
