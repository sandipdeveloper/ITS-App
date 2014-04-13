package com.asu.its_app.activities;

import com.asu.its_app.dbhelper.ITSDBHelper;
import com.asu.its_app.model.Question;
import com.example.its_app.R;
import android.app.Activity;
import android.os.Bundle;

public class ITSMainActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fullscreen);
		ITSDBHelper db  = ITSDBHelper.getInstance(this);
		db.addQuestion(new Question());
		
	}

}
