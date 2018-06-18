package u.com.example.quiz;

import android.app.Application;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity{
    DatabaseHelper db;
    EditText name1,p1,pass1;
    Button register;
    public TextView log;
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("in reg","vandhuduchu");
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //code that displays the content in full screen mode
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//int flag, int mask

        setContentView(R.layout.activity_register);
        db = new DatabaseHelper(this);
        name1= (EditText)findViewById(R.id.input_name);
        p1=(EditText)findViewById(R.id.input_password2);
        pass1=(EditText)findViewById(R.id.input_password1);
        log=(TextView)findViewById(R.id.link_login);
        log.setPaintFlags(log.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        register=(Button)findViewById(R.id.btn_signup);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(),MainActivity.class);
                startActivityForResult(in,1);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n2 = name1.getText().toString();
                String e2 = p1.getText().toString();
                String p2 = pass1.getText().toString();
                if(n2.equals("")||e2.equals("")||p2.equals("")){
                    Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_LONG).show();
                }
                else{
                    if(e2.equals(p2)){
                        Boolean ch = db.check(n2);
                        if(ch==true){
                            Boolean insert = db.insert(n2,e2);
                            if(insert==true){
                                Toast.makeText(getApplicationContext(),"Registered Successfully",Toast.LENGTH_LONG).show();
                                name1.setText("");
                                p1.setText("");
                                pass1.setText("");
                                try {
                                    Thread.sleep(100);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                Intent in = new Intent(getApplicationContext(),MainActivity.class);
                                startActivityForResult(in,1);
                            }
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"UserName already exists",Toast.LENGTH_LONG).show();
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Passwords donot match!",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }
}
