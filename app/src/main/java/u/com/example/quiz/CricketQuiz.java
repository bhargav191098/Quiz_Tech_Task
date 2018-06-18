package u.com.example.quiz;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.github.lzyzsd.circleprogress.DonutProgress;


public class CricketQuiz extends AppCompatActivity {
    private QuestionBankCric mQuestionLibrary = new QuestionBankCric();
    public CountDownTimer t;

    private TextView mScoreView;   // view for current total score
    private TextView mQuestionView;  //current question to answer
    private Button mButtonChoice1; // multiple choice 1 for mQuestionView
    private Button mButtonChoice2; // multiple choice 2 for mQuestionView
    private Button mButtonChoice3; // multiple choice 3 for mQuestionView
    private Button mButtonChoice4; // multiple choice 4 for mQuestionView
    public DonutProgress donutProgress;
    private String mAnswer;  // correct answer for question in mQuestionView
    private int mScore = 0;  // current total score
    private int mQuestionNumber = 0; // current question number

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cricket_quiz);
        mScoreView = (TextView)findViewById(R.id.score);
        mQuestionView = (TextView)findViewById(R.id.question);
        mButtonChoice1 = (Button)findViewById(R.id.choice1);
        mButtonChoice2 = (Button)findViewById(R.id.choice2);
        mButtonChoice3 = (Button)findViewById(R.id.choice3);
        mButtonChoice4 = (Button)findViewById(R.id.choice4);
        donutProgress = (DonutProgress) findViewById(R.id.doprogress);
        donutProgress.setMax(100);
        donutProgress.setSuffixText("s");
        donutProgress.setFinishedStrokeColor(Color.parseColor("#FFFB385F"));
        donutProgress.setTextColor(Color.parseColor("#FFFB385F"));
        donutProgress.setKeepScreenOn(true);
        mQuestionLibrary.initQuestions(getApplicationContext());
        updateQuestion();
        t =new CountDownTimer(50000, 1000) {//countdowntimer
            int i = 100;
            @Override
            public void onTick(long millisUntilFinished) {
                i = i - 2;
                donutProgress.setProgress(i);


            }

            @Override
            public void onFinish() {
                updateScore(mScore);
                //donutProgress.setProgress(0);
                Toast.makeText(getApplicationContext(), "Time Up!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), TopScorer.class);
                intent.putExtra("score", mScore); // pass the current score to the second screen
                startActivity(intent);

            }

        }.start();
        // show current total score for the user


    }
    private void updateQuestion(){
        // check if we are not outside array bounds for questions
        if(mQuestionNumber<mQuestionLibrary.getLength() ){
            // set the text for new question,
            // and new 4 alternative to answer on four buttons
            mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
            mButtonChoice1.setText(mQuestionLibrary.getChoice(mQuestionNumber,1));
            mButtonChoice2.setText(mQuestionLibrary.getChoice(mQuestionNumber, 2));
            mButtonChoice3.setText(mQuestionLibrary.getChoice(mQuestionNumber, 3));
            mButtonChoice4.setText(mQuestionLibrary.getChoice(mQuestionNumber,4));
            mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
            mQuestionNumber++;
        }
        else {
            Intent intent = new Intent(getApplicationContext(), TopScorerCric.class);
            intent.putExtra("score", mScore); // pass the current score to the second screen
            startActivity(intent);
            t.cancel();
        }
    }
    private void updateScore(int point) {
        mScoreView.setText(""+mScore+"/"+mQuestionLibrary.getLength());
    }

    public void onClick(View view) throws InterruptedException {
        //all logic for all answers buttons in one method
        Button answer = (Button) view;
        // if the answer is correct, increase the score
        if (answer.getText().equals(mAnswer)){
            mScore = mScore + 1;
            Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getApplicationContext(), "Wrong! " + mAnswer + " is the correct answer.", Toast.LENGTH_SHORT).show();
        }// show current total score for the user
        updateScore(mScore);
        // once user answer the question, we move on to the next one, if any
        updateQuestion();


    }


}
