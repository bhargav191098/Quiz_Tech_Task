package u.com.example.quiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TopScorerCric extends AppCompatActivity {
    public int first,second,third;
    public String name = "Bhargav";
    FloatingActionButton dashback,rank;
    Button loga;
    private SharedPreferences mypref123;
    @Override
    public void onBackPressed() {
        Log.d("CDA", "onBackPressed Called");
        Intent setIntent = new Intent(getApplicationContext(),QuizDashboard.class);
        startActivity(setIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_scorer_cric);
        Button button = (Button)findViewById(R.id.play_buttoncric);
        //TextView txtScore = (TextView) findViewById(R.id.textScore);
        //TextView fplace = (TextView) findViewById(R.id.first);
        //TextView splace = (TextView)findViewById(R.id.second);
        //TextView tplace = (TextView)findViewById(R.id.third);
        // receive the score from last activity by Intent
        Intent intent = getIntent();
        int score = intent.getIntExtra("score", 0);
        // display current score
        button.setText(score+" pt");


        loga = (Button)findViewById(R.id.loga);
        dashback = (FloatingActionButton)findViewById(R.id.backdash);
        rank = (FloatingActionButton) findViewById(R.id.rank);

        // use Shared preferences to save the best score
        SharedPreferences mypref123 = getSharedPreferences("P1",0);
        SharedPreferences.Editor editor1 = mypref123.edit();
        editor1.putInt("yourscoreckt",score);
        int first = mypref123.getInt("fc",0);
        int second = mypref123.getInt("sc",0);
        int third = mypref123.getInt("tc",0);


        String cur_user = mypref123.getString("user","a");
        Log.d("name",cur_user);

        String nfirst = mypref123.getString("nfc","no_player");
        String nsecond = mypref123.getString("nsc","no_player");
        String nthird = mypref123.getString("ntc","no_player");

        if(score > third){
            third = score;
            editor1.putInt("tc",third);
            editor1.putString("ntc",cur_user);
            editor1.apply();
        }
        if(score > second){
            int temp = second;
            second = score;
            third = temp;
            editor1.putInt("tc",third);
            editor1.putString("ntc",nsecond);
            editor1.putInt("sc",second);
            editor1.putString("nsc",cur_user);
            editor1.apply();
        }
        if(score > first){
            int temp = first;
            first = score;
            second = temp;
            editor1.putInt("sc",second);
            editor1.putString("nsc",nfirst);
            editor1.putString("nfc",cur_user);
            editor1.putInt("fc",first);
            editor1.apply();
        }
        nfirst = mypref123.getString("nfc","no_player");
        nsecond = mypref123.getString("nsc","no_player");
        nthird = mypref123.getString("ntc","no_player");

        loga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivityForResult(i,1);
            }
        });
        dashback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),QuizDashboard.class);
                startActivityForResult(i,1);
            }
        });
        rank.setOnClickListener(new View.OnClickListener() {
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
