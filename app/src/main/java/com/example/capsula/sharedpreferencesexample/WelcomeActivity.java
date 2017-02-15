package com.example.capsula.sharedpreferencesexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Desarrollo3 on 13/02/2017.
 */

public class WelcomeActivity extends AppCompatActivity {
    SessionManager sessionManager;
    @BindView(R.id.welcome)
    TextView welcome;
    @BindView(R.id.button)
    Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
        sessionManager = new SessionManager(getApplicationContext());
        String token = sessionManager.getToken();
        welcome.setText(token);
    }

    @OnClick(R.id.button)
    public void onClick() {
        sessionManager.closeSession();
        Intent intent = new Intent(getApplicationContext(), LandingActivity.class);
        startActivity(intent);
        finish();
    }
}
