package com.example.ioasys.utils;

import android.content.Context;
import android.widget.EditText;

import com.example.ioasys.R;
import com.example.ioasys.constants.Constants;
import com.google.android.material.textfield.TextInputLayout;

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
}
