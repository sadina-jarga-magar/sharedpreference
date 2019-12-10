package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    private EditText etusername, etpassword;
    private Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_login);

        etusername=findViewById (R.id.username);
        etpassword= findViewById (R.id.password);
        btnlogin.findViewById (R.id.btnlogin);

        btnlogin.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                checkuser();
            }
        });


    }

    private void checkuser(){
        SharedPreferences sharedPreferences =getSharedPreferences ("User",MODE_PRIVATE);
        String username=sharedPreferences.getString ("username", "");
        String password= sharedPreferences.getString ("password", "");
        if(username.equals (etusername.getText ().toString ()) ||
        password.equals (etpassword.getText ().toString ())){
            Toast.makeText (login.this, "Successfully login", Toast.LENGTH_SHORT).show ();

        }else{
            Toast.makeText (login.this,"failed", Toast.LENGTH_SHORT).show ();
        }
    }
}
