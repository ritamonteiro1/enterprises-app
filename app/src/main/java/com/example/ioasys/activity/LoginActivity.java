package com.example.ioasys.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ioasys.R;
import com.example.ioasys.domains.User;
import com.example.ioasys.utils.Utils;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    private EditText mainEmailEditText, mainPasswordEditText;
    private TextInputLayout mainEmailTextInputLayout, mainPasswordTextInputLayout;
    private Button mainLoginButton;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewsById();
//        mainLoginButton.setVisibility(View.VISIBLE);
//        mainLoginButton.setVisibility(View.INVISIBLE);
//        mainLoginButton.setVisibility(View.GONE);

//        mainPasswordEditText
//        mainPasswordEditText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                String typedText = s.toString();
//                if (typedText.length() > 3){
//                    mainEmailEditText.setVisibility(View.GONE);
//                }
//            }
//        });
        setupLoginButton();
    }

    private void setupLoginButton() {
        mainLoginButton.setOnClickListener(v -> {
            boolean isValidEmail = Utils.isValidEmail(mainEmailEditText, mainEmailTextInputLayout,
                    this);
            boolean isEmptyPassword = Utils.isEmptyField(mainPasswordTextInputLayout,
                    mainPasswordEditText, this);
            if (!isValidEmail || isEmptyPassword) return;
            user = new User(mainEmailEditText.getText().toString(),
                    mainPasswordEditText.getText().toString());
            moveToResearchActivity();
        });
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