package com.example.its_app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.asu.its_app.assessor.AssessorStat;
import com.asu.its_app.dbhelper.AttemptStatus;
import com.asu.its_app.dbhelper.ITSDBHelper;
import com.asu.its_app.model.Hint;
import com.example.its_app.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class StatFullscreenActivity extends Activity {
	/**
	 * Whether or not the system UI should be auto-hidden after
	 * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
	 */
	private static final boolean AUTO_HIDE = true;

	/**
	 * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
	 * user interaction before hiding the system UI.
	 */
	private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

	/**
	 * If set, will toggle the system UI visibility upon interaction. Otherwise,
	 * will show the system UI visibility upon interaction.
	 */
	private static final boolean TOGGLE_ON_CLICK = true;

	/**
	 * The flags to pass to {@link SystemUiHider#getInstance}.
	 */
	private static final int HIDER_FLAGS = SystemUiHider.FLAG_HIDE_NAVIGATION;

	/**
	 * The instance of the {@link SystemUiHider} for this activity.
	 */
	private SystemUiHider mSystemUiHider;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_stat_fullscreen);

		final View controlsView = findViewById(R.id.up);
		final View contentView = findViewById(R.id.down);

		// Set up an instance of SystemUiHider to control the system UI for
		// this activity.
		mSystemUiHider = SystemUiHider.getInstance(this, contentView,
				HIDER_FLAGS);
		mSystemUiHider.setup();
		mSystemUiHider
				.setOnVisibilityChangeListener(new SystemUiHider.OnVisibilityChangeListener() {
					// Cached values.
					int mControlsHeight;
					int mShortAnimTime;

					@Override
					@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
					public void onVisibilityChange(boolean visible) {
						if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
							// If the ViewPropertyAnimator API is available
							// (Honeycomb MR2 and later), use it to animate the
							// in-layout UI controls at the bottom of the
							// screen.
							if (mControlsHeight == 0) {
								mControlsHeight = controlsView.getHeight();
							}
							if (mShortAnimTime == 0) {
								mShortAnimTime = getResources().getInteger(
										android.R.integer.config_shortAnimTime);
							}
							controlsView
									.animate()
									.translationY(visible ? 0 : mControlsHeight)
									.setDuration(mShortAnimTime);
						} else {
							// If the ViewPropertyAnimator APIs aren't
							// available, simply show or hide the in-layout UI
							// controls.
							controlsView.setVisibility(visible ? View.VISIBLE
									: View.GONE);
						}

						if (visible && AUTO_HIDE) {
							// Schedule a hide().
							delayedHide(AUTO_HIDE_DELAY_MILLIS);
						}
					}
				});

		// Set up the user interaction to manually show or hide the system UI.
		contentView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (TOGGLE_ON_CLICK) {
					mSystemUiHider.toggle();
				} else {
					mSystemUiHider.show();
				}
			}
		});

		// Upon interacting with UI controls, delay any scheduled hide()
		// operations to prevent the jarring behavior of controls going away
		// while interacting with the UI.
		findViewById(R.id.okButton).setOnTouchListener(
				mDelayHideTouchListener);
		Intent intent = getIntent();
		
		ArrayList<AssessorStat> assessorStats = new ArrayList<AssessorStat>();
		
		int totalCorrect=0, totalIncorrect=0, correct=0, incorrect=0, tempId=0;
		
		for(AttemptStatus stat:ITSDBHelper.attemptStatusList)
		{
			if(stat.getQuestionId()==1 && stat.getAttempt()==1)
			{
				totalCorrect++;
				correct++;
			}
			else if(stat.getQuestionId()==1 && stat.getAttempt()==-1)
			{
				totalIncorrect++;
				incorrect++;
			}
		}
		
		TextView correct1 = (TextView) findViewById(R.id.correct1);
		correct1.setText(Integer.toString(correct));
		TextView incorrect1 = (TextView) findViewById(R.id.incorrect1);
		incorrect1.setText(Integer.toString(incorrect));
		assessorStats.add(new AssessorStat(1, correct, incorrect));
		
		////
		correct = 0;
		incorrect =0;
		for(AttemptStatus stat:ITSDBHelper.attemptStatusList)
		{
			if(stat.getQuestionId()==2 && stat.getAttempt()==1)
			{
				totalCorrect++;
				correct++;
			}
			else if(stat.getQuestionId()==2 && stat.getAttempt()==-1)
			{
				totalIncorrect++;
				incorrect++;
			}
		}
		
		TextView correct2 = (TextView) findViewById(R.id.correct2);
		correct2.setText(Integer.toString(correct));
		TextView incorrect2 = (TextView) findViewById(R.id.incorrect2);
		incorrect2.setText(Integer.toString(incorrect));
		assessorStats.add(new AssessorStat(2, correct, incorrect));
		//
		//
		correct = 0;
		incorrect =0;
		for(AttemptStatus stat:ITSDBHelper.attemptStatusList)
		{
			if(stat.getQuestionId()==3 && stat.getAttempt()==1)
			{
				totalCorrect++;
				correct++;
			}
			else if(stat.getQuestionId()==3 && stat.getAttempt()==-1)
			{
				totalIncorrect++;
				incorrect++;
			}
		}
		
		TextView correct3 = (TextView) findViewById(R.id.correct3);
		correct3.setText(Integer.toString(correct));
		TextView incorrect3 = (TextView) findViewById(R.id.incorrect3);
		incorrect3.setText(Integer.toString(incorrect));
		assessorStats.add(new AssessorStat(3, correct, incorrect));
		//
		correct = 0;
		incorrect =0;
		for(AttemptStatus stat:ITSDBHelper.attemptStatusList)
		{
			if(stat.getQuestionId()==4 && stat.getAttempt()==1)
			{
				totalCorrect++;
				correct++;
			}
			else if(stat.getQuestionId()==4 && stat.getAttempt()==-1)
			{
				totalIncorrect++;
				incorrect++;
			}
		}
		
		TextView correct4 = (TextView) findViewById(R.id.correct3);
		correct4.setText(Integer.toString(correct));
		TextView incorrect4 = (TextView) findViewById(R.id.incorrect3);
		incorrect4.setText(Integer.toString(incorrect));
		assessorStats.add(new AssessorStat(4, correct, incorrect));
		//
		correct = 0;
		incorrect =0;
		for(AttemptStatus stat:ITSDBHelper.attemptStatusList)
		{
			if(stat.getQuestionId()==5 && stat.getAttempt()==1)
			{
				totalCorrect++;
				correct++;
			}
			else if(stat.getQuestionId()==5 && stat.getAttempt()==-1)
			{
				totalIncorrect++;
				incorrect++;
			}
		}
		
		TextView correct5 = (TextView) findViewById(R.id.correct5);
		correct5.setText(Integer.toString(correct));
		TextView incorrect5 = (TextView) findViewById(R.id.incorrect5);
		incorrect5.setText(Integer.toString(incorrect));
		assessorStats.add(new AssessorStat(5, correct, incorrect));
		////
		
		correct = 0;
		incorrect =0;
		for(AttemptStatus stat:ITSDBHelper.attemptStatusList)
		{
			if(stat.getQuestionId()==6 && stat.getAttempt()==1)
			{
				totalCorrect++;
				correct++;
			}
			else if(stat.getQuestionId()==6 && stat.getAttempt()==-1)
			{
				totalIncorrect++;
				incorrect++;
			}
		}
		
		TextView correct6 = (TextView) findViewById(R.id.correct6);
		correct6.setText(Integer.toString(correct));
		TextView incorrect6 = (TextView) findViewById(R.id.incorrect6);
		incorrect6.setText(Integer.toString(incorrect));
		assessorStats.add(new AssessorStat(6, correct, incorrect));
		////
		
		correct = 0;
		incorrect =0;
		for(AttemptStatus stat:ITSDBHelper.attemptStatusList)
		{
			if(stat.getQuestionId()==7 && stat.getAttempt()==1)
			{
				totalCorrect++;
				correct++;
			}
			else if(stat.getQuestionId()==7 && stat.getAttempt()==-1)
			{
				totalIncorrect++;
				incorrect++;
			}
		}
		
		TextView correct7 = (TextView) findViewById(R.id.correct7);
		correct7.setText(Integer.toString(correct));
		TextView incorrect7 = (TextView) findViewById(R.id.incorrect7);
		incorrect7.setText(Integer.toString(incorrect));
		assessorStats.add(new AssessorStat(7, correct, incorrect));
		////
		
		correct = 0;
		incorrect =0;
		for(AttemptStatus stat:ITSDBHelper.attemptStatusList)
		{
			if(stat.getQuestionId()==8 && stat.getAttempt()==1)
			{
				totalCorrect++;
				correct++;
			}
			else if(stat.getQuestionId()==8 && stat.getAttempt()==-1)
			{
				totalIncorrect++;
				incorrect++;
			}
		}
		
		TextView correct8 = (TextView) findViewById(R.id.correct8);
		correct8.setText(Integer.toString(correct));
		TextView incorrect8 = (TextView) findViewById(R.id.incorrect8);
		incorrect8.setText(Integer.toString(incorrect));
		assessorStats.add(new AssessorStat(8, correct, incorrect));
		
		////
		
		correct = 0;
		incorrect =0;
		for(AttemptStatus stat:ITSDBHelper.attemptStatusList)
		{
			if(stat.getQuestionId()==9 && stat.getAttempt()==1)
			{
				totalCorrect++;
				correct++;
			}
			else if(stat.getQuestionId()==9 && stat.getAttempt()==-1)
			{
				totalIncorrect++;
				incorrect++;
			}
		}
		
		TextView correct9 = (TextView) findViewById(R.id.correct9);
		correct9.setText(Integer.toString(correct));
		TextView incorrect9 = (TextView) findViewById(R.id.incorrect9);
		incorrect9.setText(Integer.toString(incorrect));
		assessorStats.add(new AssessorStat(9, correct, incorrect));
		
		////
		correct = 0;
		incorrect =0;
		for(AttemptStatus stat:ITSDBHelper.attemptStatusList)
		{
			if(stat.getQuestionId()==10 && stat.getAttempt()==1)
			{
				totalCorrect++;
				correct++;
			}
			else if(stat.getQuestionId()==10 && stat.getAttempt()==-1)
			{
				totalIncorrect++;
				incorrect++;
			}
		}
		
		TextView correct10 = (TextView) findViewById(R.id.correct10);
		correct10.setText(Integer.toString(correct));
		TextView incorrect10 = (TextView) findViewById(R.id.incorrect10);
		incorrect10.setText(Integer.toString(incorrect));
		assessorStats.add(new AssessorStat(10, correct, incorrect));
		////
		
		correct = 0;
		incorrect =0;
		for(AttemptStatus stat:ITSDBHelper.attemptStatusList)
		{
			if(stat.getQuestionId()==11 && stat.getAttempt()==1)
			{
				totalCorrect++;
				correct++;
			}
			else if(stat.getQuestionId()==11 && stat.getAttempt()==-1)
			{
				totalIncorrect++;
				incorrect++;
			}
		}
		
		TextView correct11 = (TextView) findViewById(R.id.correct11);
		correct11.setText(Integer.toString(correct));
		TextView incorrect11 = (TextView) findViewById(R.id.incorrect12);
		incorrect11.setText(Integer.toString(incorrect));
		assessorStats.add(new AssessorStat(11, correct, incorrect));
		///
		
		correct = 0;
		incorrect =0;
		for(AttemptStatus stat:ITSDBHelper.attemptStatusList)
		{
			if(stat.getQuestionId()==12 && stat.getAttempt()==1)
			{
				totalCorrect++;
				correct++;
			}
			else if(stat.getQuestionId()==12 && stat.getAttempt()==-1)
			{
				totalIncorrect++;
				incorrect++;
			}
		}
		
		TextView correct12 = (TextView) findViewById(R.id.correct12);
		correct12.setText(Integer.toString(correct));
		TextView incorrect12 = (TextView) findViewById(R.id.incorrect111);
		incorrect12.setText(Integer.toString(incorrect));
		assessorStats.add(new AssessorStat(12, correct, incorrect));
		////
		
		correct = 0;
		incorrect =0;
		for(AttemptStatus stat:ITSDBHelper.attemptStatusList)
		{
			if(stat.getQuestionId()==13 && stat.getAttempt()==1)
			{
				totalCorrect++;
				correct++;
			}
			else if(stat.getQuestionId()==13 && stat.getAttempt()==-1)
			{
				totalIncorrect++;
				incorrect++;
			}
		}
		
		TextView correct13 = (TextView) findViewById(R.id.correct13);
		correct13.setText(Integer.toString(correct));
		TextView incorrect13 = (TextView) findViewById(R.id.incorrect13);
		incorrect13.setText(Integer.toString(incorrect));
		assessorStats.add(new AssessorStat(13, correct, incorrect));
		
		////
		correct = 0;
		incorrect =0;
		for(AttemptStatus stat:ITSDBHelper.attemptStatusList)
		{
			if(stat.getQuestionId()==14 && stat.getAttempt()==1)
			{
				totalCorrect++;
				correct++;
			}
			else if(stat.getQuestionId()==14 && stat.getAttempt()==-1)
			{
				totalIncorrect++;
				incorrect++;
			}
		}
		
		TextView correct14 = (TextView) findViewById(R.id.correct14);
		correct14.setText(Integer.toString(correct));
		TextView incorrect14 = (TextView) findViewById(R.id.incorrect14);
		incorrect14.setText(Integer.toString(incorrect));
		assessorStats.add(new AssessorStat(14, correct, incorrect));
		
		
		/////
		TextView correctText = (TextView) findViewById(R.id.correctAnswerTextView);
		correctText.setText(Double.toString(totalCorrect/(totalCorrect+totalIncorrect)*100)+" %");
		TextView incorrectText = (TextView) findViewById(R.id.inCorrectAnswerTextView);
		incorrectText.setText(Double.toString(totalCorrect/(totalCorrect+totalIncorrect)*100)+" %");
		
		try
	    {
	        File root = new File(Environment.getExternalStorageDirectory(), "Notes");
	        if (!root.exists()) {
	            root.mkdirs();
	        }
	        File gpxfile = new File(root, "statout.txt");
	        FileWriter writer = new FileWriter(gpxfile);
	        for(AssessorStat stats: assessorStats)
	        { 
	        	writer.append(stats.getQuestionId()+" "+stats.getCorrectCount()+" "+stats.getIncorrectCount());
	        	writer.flush();
	        }
        	writer.close();
	        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
	    }
	    catch(IOException e)
	    {
	         e.printStackTrace();
	    }
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);

		// Trigger the initial hide() shortly after the activity has been
		// created, to briefly hint to the user that UI controls
		// are available.
		delayedHide(100);
	}

	/**
	 * Touch listener to use for in-layout UI controls to delay hiding the
	 * system UI. This is to prevent the jarring behavior of controls going away
	 * while interacting with activity UI.
	 */
	View.OnTouchListener mDelayHideTouchListener = new View.OnTouchListener() {
		@Override
		public boolean onTouch(View view, MotionEvent motionEvent) {
			if (AUTO_HIDE) {
				delayedHide(AUTO_HIDE_DELAY_MILLIS);
			}
			return false;
		}
	};

	Handler mHideHandler = new Handler();
	Runnable mHideRunnable = new Runnable() {
		@Override
		public void run() {
			mSystemUiHider.hide();
		}
	};

	/**
	 * Schedules a call to hide() in [delay] milliseconds, canceling any
	 * previously scheduled calls.
	 */
	private void delayedHide(int delayMillis) {
		mHideHandler.removeCallbacks(mHideRunnable);
		mHideHandler.postDelayed(mHideRunnable, delayMillis);
	}
}
