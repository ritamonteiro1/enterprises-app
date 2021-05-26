package com.example.ioasys.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;


import com.example.ioasys.R;
import com.example.ioasys.domains.User;
import com.example.ioasys.utils.Utils;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private EditText mainEmailEditText, mainPasswordEditText;
    private TextInputLayout mainEmailTextInputLayout, mainPasswordTextInputLayout;
    private Button mainLoginButton;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewsById();
        setupLoginButton();
    }

    private void setupLoginButton() {
        mainLoginButton.setOnClickListener(v -> {
            boolean isEmptyEmail = Utils.isEmptyField(mainEmailTextInputLayout, mainEmailEditText, this);
            boolean isEmptyPassword = Utils.isEmptyField(mainPasswordTextInputLayout, mainPasswordEditText, this);
            if(isEmptyEmail || isEmptyPassword) return;
            user = new User(mainEmailEditText.getText().toString(), mainPasswordEditText.getText().toString());
            boolean isValidEmail = user.isValidEmail(mainPasswordEditText.getText().toString());
            if(isValidEmail) {
                moveToResearchActivity();
            } else {
                mainPasswordTextInputLayout.setError(getString(R.string.enter_value_error_message));
            }});
    }

    private void moveToResearchActivity() {
        Intent intent = new Intent(this, ResearchActivity.class);
        startActivity(intent);
    }

    private void findViewsById() {
        mainEmailEditText = findViewById(R.id.mainEmailEditText);
        mainPasswordEditText = findViewById(R.id.mainPasswordEditText);
        mainEmailTextInputLayout = findViewById(R.id.mainEmailTextInputLayout);
        mainPasswordTextInputLayout = findViewById(R.id.mainPasswordTextInputLayout);
        mainLoginButton = findViewById(R.id.mainLoginButton);
    }
}