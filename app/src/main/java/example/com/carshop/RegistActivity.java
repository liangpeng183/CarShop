package example.com.carshop;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import example.com.carshop.util.DBOpenHelper;

public class RegistActivity extends AppCompatActivity implements View.OnClickListener {

    private Button regist;
    private EditText re_name;
    private EditText re_psw;
    private DBOpenHelper helper;
    private Cursor cursor;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);

        regist = findViewById(R.id.regist);
        re_name = findViewById(R.id.re_name);
        re_psw = findViewById(R.id.re_psw);

        regist.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name1 = re_name.getText().toString();
        String psw1 = re_psw.getText().toString();

        if(name1.equals("") || psw1.equals("")){
            Toast.makeText(RegistActivity.this,"请输入用户名密码",Toast.LENGTH_SHORT).show();

        }   else if(checkUserIsOn(name1)){
            Toast.makeText(RegistActivity.this,"此用户已被注册",Toast.LENGTH_SHORT).show();
        }else{
            saveUser(name1,psw1);
            Toast.makeText(RegistActivity.this,"注册成功！！",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RegistActivity.this,LoginActivity.class);
            startActivity(intent);
        }
    }

    //验证用户是否已存在
    public boolean checkUserIsOn(String name){
        helper = new DBOpenHelper(RegistActivity.this);
        db = helper.getReadableDatabase();
        String sql = "select * from user where name = ?";
        cursor = db.rawQuery(sql,new String[] {name});
        if(cursor != null && cursor.getCount()>0){
            cursor.close();
            return true;
        }
        return false;
    }

    //保存数据
    public void saveUser(String name,String password){
        helper = new DBOpenHelper(RegistActivity.this);
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("password",password);
        long r = db.insert("user",null,values);
        //Toast.makeText(RegistActivity.this,"此用户已被注册",Toast.LENGTH_SHORT).show();
        Log.i("提示————————","当前注册--》"+name+"数据个数"+r);
    }

}
