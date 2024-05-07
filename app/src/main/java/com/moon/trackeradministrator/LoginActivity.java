package com.moon.trackeradministrator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText idEditText;
    private EditText passEditText;
    private Button login_button;
    private Button reg_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        idEditText = findViewById(R.id.id);
        passEditText = findViewById(R.id.pass);
        login_button = findViewById(R.id.login_button);
        reg_button = findViewById(R.id.reg_button);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve the entered text
                String UserId = idEditText.getText().toString();
                String Pass = passEditText.getText().toString();
                login(UserId, Pass);
            }
        });
        reg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }
    public void login(String username, String password) {
        if (!isValidLogin(username, password)) {
            return;
        }
        boolean loginSuccessful = performLogin(username, password);
        if (loginSuccessful) {
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
        } else {
        }
    }

    private boolean isValidLogin(String username, String password) {
        return !username.isEmpty() && !password.isEmpty();
    }
    private boolean performLogin(String username, String password) {
        return true;
    }
    public void register() {
        Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
        startActivity(intent);
    }
}
