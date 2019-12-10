package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etusername, etpassword;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        etusername = findViewById (R.id.username);
        etpassword = findViewById (R.id.password);
        btnRegister = findViewById (R.id.btnRegister);
        btnRegister.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                signup ();
            }
        });
    }

    private void signup() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences (this);
        SharedPreferences.Editor editor = sharedPreferences.edit ();

        editor.putString ("username", etusername.getText ().toString ());
        editor.putString ("password", etpassword.getText ().toString ());
        editor.commit ();

        Toast.makeText (this, "Successfully registered", Toast.LENGTH_SHORT).show ();
    }

    private void checkuser() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences (this);
        String username = sharedPreferences.getString ("username", "");
        String password = sharedPreferences.getString ("password", "");
        if (username.equals (etusername.getText ().toString ()) ||
                password.equals (etpassword.getText ().toString ())) {
            Toast.makeText (MainActivity.this, "Successfully ", Toast.LENGTH_SHORT).show ();

        } else {
            Toast.makeText (MainActivity.this, "Either username or password is incorrect", Toast.LENGTH_SHORT).show ();
        }
    }
}
