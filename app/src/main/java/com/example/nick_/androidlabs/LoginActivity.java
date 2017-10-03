package com.example.nick_.androidlabs;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Context;
import android.widget.EditText;

public class LoginActivity extends Activity {

    protected static final String ACTIVITY_NAME = "LoginActivity";
    Button loginButton;
    EditText login_text;
    final static String PREFERENCES = "Prefs";
    final static String USERNAME = "username";
    SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.i(ACTIVITY_NAME, "onCreate() NOW");

        loginButton = (Button) findViewById(R.id.loginButton);
        login_text = (EditText) findViewById(R.id.loginText);
        sp = getSharedPreferences(PREFERENCES, 0);
        if(sp != null){
            String loadUsername = sp.getString(USERNAME, "DEFAULT");
            if(loadUsername != null && !loadUsername.isEmpty()){
                login_text.setText(loadUsername);
            }
        }

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor sharedEditor = sp.edit();
                sharedEditor.putString(USERNAME, login_text.getText().toString());
                sharedEditor.commit();

                Intent intent = new Intent(LoginActivity.this, StartActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(ACTIVITY_NAME, "onResume() NOW");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(ACTIVITY_NAME, "onStart() NOW");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(ACTIVITY_NAME, "onPause() NOW");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(ACTIVITY_NAME, "onStop() NOW");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "onDestroy() NOW");
    }
}
