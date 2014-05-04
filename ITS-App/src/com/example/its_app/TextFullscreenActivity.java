package com.example.its_app;

import java.util.Random;

import com.asu.its_app.dbhelper.AttemptStatus;
import com.asu.its_app.dbhelper.ITSDBHelper;
import com.asu.its_app.model.Answer;
import com.asu.its_app.model.Feedback;
import com.asu.its_app.model.Question;
import com.asu.its_app.pedagogical_module.PedagogicalModule;
import com.asu.its_app.step_analyzer.StepAnalyzer;
import com.asu.its_app.task_selector.TaskSelector;
import com.example.its_app.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class TextFullscreenActivity extends Activity {
	
	public static Question currentActivityQuestion = null;

	
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

		setContentView(R.layout.activity_text_fullscreen);

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

        ITSDBHelper db = ITSDBHelper.getInstance(this);
        
		Question prev = new Question();
		
		prev.setQuestionId(10);
		
        TextView tv = (TextView) findViewById(R.id.questionTextView);
		
		Question currentQuestion = db.getQuestion(prev);
        
		TaskSelector selector = TaskSelector.getInstance();
		
		selector.setCurrentQuestion(currentQuestion);
		
		tv.setText(currentQuestion.getQuestionBody());
        
        ImageView iv1 = (ImageView) findViewById(R.id.questionImageView);
        
        currentActivityQuestion = currentQuestion;

        int img_id = db.getQuestionResourceIdFromDatabase(currentActivityQuestion);
        
        iv1.setImageResource(img_id);
        
        iv1.setTag(img_id);
        
        Button hintButton = (Button) findViewById(R.id.hintButton);
        
        hintButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ImageView questionImageView = (ImageView) findViewById(R.id.questionImageView);
		        currentActivityQuestion.setNumberOfAttempts(new Random().nextInt(3)+1);
				Integer img_id = ITSDBHelper.getInstance(v.getContext()).getQuestionResourceIdFromDatabase(currentActivityQuestion);
		        questionImageView.setImageResource(img_id);
		        questionImageView.setTag(img_id);
				Intent intent = new Intent(v.getContext(), HintFullscreenActivity.class);
				intent.putExtra("Hint", PedagogicalModule.getInstance().getHintFromDatabase(currentActivityQuestion, v.getContext()));
		        startActivity(intent);
		        
		    }
		});
        
        Button submitButton = (Button) findViewById(R.id.submitButton);
        
        submitButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				Answer answer = new Answer();
				EditText answerEditText = (EditText)findViewById(R.id.answerEditText);
				String selectedAnswer = answerEditText.getText().toString();
				EditText explanationEditText = (EditText)findViewById(R.id.explanationEditText);
				String selectedExplanation = explanationEditText.getText().toString();
				Question currentQuestion = currentActivityQuestion;
				currentQuestion.setNumberOfAttempts(currentQuestion.getNumberOfAttempts()+1);
				currentActivityQuestion = currentQuestion;				
				answer.setQuestion(currentQuestion);
				answer.setSelectedAnswer(selectedAnswer);
				ImageView questionImageView = (ImageView) findViewById(R.id.questionImageView);
				Integer img_id = (Integer)questionImageView.getTag();
				boolean isAnswerCorrect = StepAnalyzer.getInstance().isAnswerCorrect(currentQuestion, answer, v.getContext(), img_id);
				TextView feedBackTextView = (TextView) findViewById(R.id.feedbackTextView);
				
				
				Button nextButton = (Button)findViewById(R.id.nextButton);
				Button submitButton = (Button)findViewById(R.id.submitButton);
				if(isAnswerCorrect)
				{
					
					String feedText = "Correct ! "+ITSDBHelper.stringMatcher(selectedExplanation, currentActivityQuestion.getQuestionId())+" %";
					feedBackTextView.setText(feedText);
					feedBackTextView.setTextColor(Color.GREEN);
					nextButton.setEnabled(true);
					submitButton.setEnabled(false);
					ITSDBHelper.attemptStatusList.add(new AttemptStatus(currentActivityQuestion.getQuestionId(), 1));
				}
				else
				{
					String feedText = "Not Correct ! "+ITSDBHelper.stringMatcher(selectedExplanation, currentActivityQuestion.getQuestionId())+" %";
					feedBackTextView.setText(feedText);
					feedBackTextView.setTextColor(Color.RED);
					nextButton.setEnabled(false);
					ITSDBHelper.attemptStatusList.add(new AttemptStatus(currentActivityQuestion.getQuestionId(), -1));
					return;
				}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
			}
		});
        Button nextButton = (Button) findViewById(R.id.nextButton);
        
        nextButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				
				if(currentActivityQuestion.getQuestionId()==13)
				{
					Intent intent = new Intent(view.getContext(), StatFullscreenActivity.class);
			        startActivity(intent);
				}
				//Question previousQuestion = TaskSelector.getInstance().getCurrentQuestion();
				Question currentQuestion = TaskSelector.getInstance().selectNextQuestionFromDatabase(currentActivityQuestion, view.getContext());
				TextView questionTextView = (TextView) findViewById(R.id.questionTextView);
				questionTextView.setText(currentQuestion.getQuestionBody());
				ImageView questionImageView = (ImageView) findViewById(R.id.questionImageView);				
				int img_id = ITSDBHelper.getInstance(view.getContext()).getQuestionResourceIdFromDatabase(currentQuestion);
				questionImageView.setImageResource(img_id);
				questionImageView.setTag(img_id);
				Button nextButton = (Button)findViewById(R.id.nextButton);
				nextButton.setEnabled(false);
				Button submitButton = (Button)findViewById(R.id.submitButton);
				submitButton.setEnabled(true);
				TextView feedbackTextView = (TextView) findViewById(R.id.feedbackTextView);
				feedbackTextView.setText("");
				feedbackTextView.setTextColor(Color.BLACK);
				currentActivityQuestion = currentQuestion;
				EditText answerEditText = (EditText)findViewById(R.id.answerEditText);
				answerEditText.setText("");
				EditText explanationEditText = (EditText)findViewById(R.id.explanationEditText);
				explanationEditText.setText("");

			}
        });
		// Upon interacting with UI controls, delay any scheduled hide()
		// operations to prevent the jarring behavior of controls going away
		// while interacting with the UI.
		
        findViewById(R.id.submitButton).setOnTouchListener(
				mDelayHideTouchListener);
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
