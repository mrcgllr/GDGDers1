package com.example.gdgders1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity {

    TextView username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        username = (TextView) findViewById(R.id.txtUserActivityUserName);

        username.setText(getIntent().getStringExtra("username"));
    }
}
