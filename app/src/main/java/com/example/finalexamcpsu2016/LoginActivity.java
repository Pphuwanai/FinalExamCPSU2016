package com.example.finalexamcpsu2016;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalexamcpsu2016.db.DatabaseHelper;
import com.example.finalexamcpsu2016.model.login;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    private DatabaseHelper mHelper;
    private SQLiteDatabase mDb;

    public static ArrayList<login> LoginList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mHelper = new DatabaseHelper(this);
        mDb = mHelper.getWritableDatabase();

        Button btnLogin = (Button) findViewById(R.id.button1);

        Cursor cursor = mDb.query(DatabaseHelper.TABLE_NAME, null, null, null, null, null, null);////ค่า null คือดึงทุกคอลัมล์ใน TABLE นั้นๆ
        LoginList.clear();
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_NAME));
            String username = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_USERNAME));
            String password = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_PASSWORD));

            login login = new login(name, username, password);
            LoginList.add(login);
        }
        cursor.close();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editTextusername = (EditText) findViewById(R.id.editText1);
                EditText editTextpassword = (EditText) findViewById(R.id.editText2);
                String user = editTextusername.getText().toString();
                String pass = editTextpassword.getText().toString();

                login value = getLogin(user,pass);

                if(value != null){
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    intent.putExtra("name", value.name);
                    startActivity(intent);
                }
                else{
                    Context context = getApplicationContext();
                    CharSequence text =  "Invalid username or password";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });

        Button btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });


    }

    public login getLogin(String user, String pass){
        for(int i=0 ; i < LoginList.size() ; i++) {
            if (user.equals(LoginList.get(i).username) && pass.equals(LoginList.get(i).password)) {
                return LoginList.get(i);
            }
        }
        return null;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.action_list){
            Intent intent = new Intent(this,UserListActivity.class);
            startActivity(intent);
            return  true;
        }

        return super.onOptionsItemSelected(item);
    }

}
