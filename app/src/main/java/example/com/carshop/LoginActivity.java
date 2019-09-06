package example.com.carshop;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import example.com.carshop.contract.MyContract;
import example.com.carshop.ui.fragment.My_frag;
import example.com.carshop.util.DBOpenHelper;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private SQLiteOpenHelper helper;
    private Cursor cursor;
    private EditText etname;
    private EditText etpsw;
    private Button login;
    private Button regist;
    private String psw;
    private TextView noLogin;
    //private My_frag my_frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etname = findViewById(R.id.et_name);
        etpsw = findViewById(R.id.et_psw);
        login = findViewById(R.id.btn_login);
        noLogin = findViewById(R.id.btn_Nologin);
        regist = findViewById(R.id.btn_regist);
        login.setOnClickListener(this);
        regist.setOnClickListener(this);
        noLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
            helper = new DBOpenHelper(LoginActivity.this);
            SQLiteDatabase db = helper.getReadableDatabase();
             String name = etname.getText().toString();
            String password = etpsw.getText().toString();

            String sql = "select * from user where name =? and password =?";
            cursor = db.rawQuery(sql,new String[] {name,password});
            if(cursor.moveToFirst()) {
                psw = cursor.getString(cursor.getColumnIndex("password"));
                Log.i("","当前用户密码是：-----》"+psw);
            }cursor.close();

            if(name.equals("")  || password.equals("")){
                Toast.makeText(LoginActivity.this, "请输入用户名密码！！", Toast.LENGTH_SHORT).show();
            } else
             if (checkUser(name, password)) {
                    Toast.makeText(LoginActivity.this, "登录成功！！", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("Who",name);
                    startActivity(intent);


                 cursor = db.query("user",null,null,
                            null,null,null,null,null);
                    while(cursor.moveToNext()){
                        String id = cursor.getString(cursor.getColumnIndex(MyContract.UserEntry._ID));
                        String uername = cursor.getString(cursor.getColumnIndex("name"));
                        String user_psw = cursor.getString(cursor.getColumnIndex("password"));//列名
                        Log.i("","id：---->"+id);
                        Log.i("","用户名：---->"+uername);
                        Log.i("","密码：----->"+user_psw);

                    }
             }
            else {
                Toast.makeText(LoginActivity.this, "用户名或密码错误！", Toast.LENGTH_SHORT).show();
            }
            break;
            case R.id.btn_regist:
                Intent intent = new Intent(LoginActivity.this,RegistActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_Nologin:
                Intent intent1 = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent1);
                break;
            default:
                break;
        }
    }

    //验证用户
    public boolean checkUser(String name,String password){
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "select  * from user where name = ? and password = ?";
        cursor = db.rawQuery(sql,new String[] { name,password});
        if(cursor != null && cursor.getCount() > 0){
            cursor.close();
            return true;
        }
        return false;
    }


}
