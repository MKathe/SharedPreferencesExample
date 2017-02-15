package com.example.capsula.sharedpreferencesexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {
    SessionManager sessionManager;
    @BindView(R.id.escribeAqui)
    EditText escribeAqui;
    @BindView(R.id.activity_main)
    RelativeLayout activityMain;
    @BindView(R.id.btn)
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        sessionManager = new SessionManager(getApplicationContext());

    }

    @OnClick(R.id.btn)
    public void onClick() {
        String token = escribeAqui.getText().toString();
        sessionManager.saveToken(token);
        Intent intent = new Intent(getApplicationContext(), LandingActivity.class);
        startActivity(intent);
        finish();
    }
}
