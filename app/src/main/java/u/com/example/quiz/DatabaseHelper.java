package u.com.example.quiz;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper{


    public DatabaseHelper(Context context) {
        super(context,"Login.db", null ,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(email text primary key,password text)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
    }
    //insertion
    public boolean insert(String email,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email",email);
        contentValues.put("password",password);
        long ins = db.insert("user",null,contentValues);
        if(ins==-1) return  false;
        else return true;

    }
    public Boolean check(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where email=?",new String[]{email});
        if(cursor.getCount()>0) return  false;
        else return true;
    }
    public Boolean login_func(String u,String p){
        Log.d("loginfunc","called");
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("Select *from user where email=? and password=?",new String[]{u,p});
        if(c.getCount()>0)return true;
        else return false;
    }
}
