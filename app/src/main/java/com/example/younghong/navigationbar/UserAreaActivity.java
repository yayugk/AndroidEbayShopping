package com.example.younghong.navigationbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UserAreaActivity extends AppCompatActivity {

    private Button btnReturnToHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final EditText etAge = (EditText) findViewById(R.id.etAge);
        final TextView welcomeMsg = (TextView) findViewById(R.id.tvWelcomeMsg);
        btnReturnToHome = (Button) findViewById(R.id.btnUserToHome);

        btnReturnToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainLink = new Intent(UserAreaActivity.this, MainActivity.class);
                mainLink.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                mainLink.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(mainLink);

            }
        });

        Intent intent = getIntent();
        String name =intent.getStringExtra("name");
        String username = intent.getStringExtra("username");
        int age = intent.getIntExtra("age", -1);

        String message = name + " welcome to your user are";
        welcomeMsg.setText(message);
        etUsername.setText(username);
        etAge.setText(age + "");
    }
}
