package u.com.example.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;

public class QuizDashboard extends AppCompatActivity {

    public CardView cric,tech,topscore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_dashboard);
        cric = (CardView)findViewById(R.id.cricketquiz);
        tech = (CardView)findViewById(R.id.techquiz);
        topscore = (CardView)findViewById(R.id.topscore);
        cric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),CricketQuiz.class);
                startActivityForResult(i,1);

            }
        });
        tech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),CompQuiz.class);
                startActivityForResult(i,1);

            }
        });
        topscore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Main2Activity.class);
                startActivityForResult(i,1);

            }
        });
    }

}
