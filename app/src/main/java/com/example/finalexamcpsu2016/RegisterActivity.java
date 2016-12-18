package com.example.finalexamcpsu2016;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.finalexamcpsu2016.model.login;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //String a = LoginActivity.LoginList.get(0).name;




        Button btnRegis = (Button) findViewById(R.id.buttonRegis);
        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText name = (EditText) findViewById(R.id.editText7);
                /*EditText username = (EditText) findViewById(R.id.et2);
                EditText password = (EditText) findViewById(R.id.et3);

                String Name = name.toString();
                String Username = username.toString();
                String Password = password.toString();
                */
               /* for(int i=0 ; i< LoginActivity.LoginList.size() ; i++){

                    if(Username.equals(LoginActivity.LoginList.get(i).username)){*/
                            ///TextView tv = (TextView) findViewById(R.id.test);
                            AlertDialog.Builder dialog = new AlertDialog.Builder(RegisterActivity.this);
                            dialog.setTitle("Registration Failed!");
                            dialog.setMessage("Username already exists.");
                            dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                            });

                            dialog.show();

                    //}
               // }
            }
        });




    }
}
