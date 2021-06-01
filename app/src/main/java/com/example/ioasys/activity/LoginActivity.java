package com.example.ioasys.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ioasys.R;
import com.example.ioasys.domains.User;
import com.example.ioasys.utils.Utils;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    private EditText loginEmailEditText, loginPasswordEditText;
    private TextInputLayout loginEmailTextInputLayout, loginPasswordTextInputLayout;
    private Button loginLoginButton;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewsById();
        setupLoginButton();
    }

    private void setupLoginButton() {
        loginLoginButton.setOnClickListener(v -> {
            boolean isValidEmail = Utils.isValidEmail(loginEmailEditText, loginEmailTextInputLayout,
                    this);
            boolean isEmptyPassword = Utils.isEmptyField(loginPasswordTextInputLayout,
                    loginPasswordEditText, this);
            if (!isValidEmail || isEmptyPassword) return;
            user = new User(loginEmailEditText.getText().toString(),
                    loginPasswordEditText.getText().toString());
            moveToResearchActivity();
        });
    }

    private void moveToResearchActivity() {
        Intent intent = new Intent(this, ResearchActivity.class);
        startActivity(intent);
    }

    private void findViewsById() {
        loginEmailEditText = findViewById(R.id.loginEmailEditText);
        loginPasswordEditText = findViewById(R.id.loginPasswordEditText);
        loginEmailTextInputLayout = findViewById(R.id.loginEmailTextInputLayout);
        loginPasswordTextInputLayout = findViewById(R.id.loginPasswordTextInputLayout);
        loginLoginButton = findViewById(R.id.loginLoginButton);
    }
}