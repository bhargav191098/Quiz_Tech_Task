package u.com.example.quiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TopScorer extends AppCompatActivity {
    public int first,second,third;
    public String name = "Bhargav";
    @Override
    public void onBackPressed() {
        Log.d("CDA", "onBackPressed Called");
        Intent setIntent = new Intent(getApplicationContext(),QuizDashboard.class);
        startActivity(setIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_scorer);
        Button button = (Button)findViewById(R.id.play_buttoncric1);
        //TextView txtScore = (TextView) findViewById(R.id.textScore);
        //TextView fplace = (TextView) findViewById(R.id.first);
        //TextView splace = (TextView)findViewById(R.id.second);
        //TextView tplace = (TextView)findViewById(R.id.third);
        // receive the score from last activity by Intent
        Intent intent = getIntent();
        int score = intent.getIntExtra("score", 0);
        // display current score
        button.setText(score+" pt");
        FloatingActionButton dashback = (FloatingActionButton)findViewById(R.id.backdash1);
        Button switch1=(Button)findViewById(R.id.loga1);
        FloatingActionButton rank1=(FloatingActionButton)findViewById(R.id.rank1);
        // display current score
        //txtScore.setText("Your score: " + score);

        // use Shared preferences to save the best score
        SharedPreferences mypref = getSharedPreferences("PREFS",0);
        SharedPreferences.Editor editor = mypref.edit();
        editor.putInt("yourscore",score);
        int first = mypref.getInt("first",0);
        int second = mypref.getInt("second",0);
        int third = mypref.getInt("third",0);

        String cur_user = mypref.getString("username","a");

        String nfirst = mypref.getString("nfirst","no_player");
        String nsecond = mypref.getString("nsecond","no_player");
        String nthird = mypref.getString("nthird","no_player");

        if(score > third){
            third = score;
            editor.putInt("third",third);
            editor.putString("nthird",cur_user);
            editor.apply();
        }
        if(score > second){
            int temp = second;
            second = score;
            third = temp;
            editor.putInt("third",third);
            editor.putString("nthird",nsecond);
            editor.putInt("second",second);
            editor.putString("nsecond",cur_user);
            editor.apply();
        }
        if(score > first){
            int temp = first;
            first = score;
            second = temp;
            editor.putInt("second",second);
            editor.putString("nsecond",nfirst);
            editor.putString("nfirst",cur_user);
            editor.putInt("first",first);
            editor.apply();
        }
        nfirst = mypref.getString("nfirst","no_player");
        nsecond = mypref.getString("nsecond","no_player");
        nthird = mypref.getString("nthird","no_player");


        dashback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),QuizDashboard.class);
                startActivityForResult(i,1);
            }
        });
        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivityForResult(i,1);
            }
        });
        rank1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Main2Activity.class);
                startActivityForResult(i,1);
            }
        });

        //fplace.setText("1."+nfirst+" "+first);
        //splace.setText("2."+nsecond+" "+second);
        //tplace.setText("3."+nthird+" "+third);
    }
}
