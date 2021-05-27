package com.example.ioasys.utils;

import android.content.Context;
import android.util.Patterns;
import android.widget.EditText;

import com.example.ioasys.R;
import com.example.ioasys.constants.Constants;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.util.Patterns.EMAIL_ADDRESS;

public class Utils {
    public static boolean isEmptyField(TextInputLayout textInputLayout, EditText editText,
                                       Context context) {
        String value = editText.getText().toString();
        if (value.isEmpty()) {
            textInputLayout.setError(context.getString(R.string.enter_value_error_message));
            return true;
        } else {
            textInputLayout.setError(Constants.EMPTY);
            return false;
        }
    }

    public static boolean isValidEmail(EditText editText, TextInputLayout textInputLayout, Context context) {
        String email = editText.getText().toString();
        if(!email.isEmpty() && EMAIL_ADDRESS.matcher(email).matches()){
            textInputLayout.setError(Constants.EMPTY);
            return true;
        } else {
            textInputLayout.setError(context.getString(R.string.enter_value_error_message));
            return false;
        }
        }
    }

