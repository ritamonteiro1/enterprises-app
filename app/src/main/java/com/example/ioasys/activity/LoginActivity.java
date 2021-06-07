package com.example.ioasys.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ioasys.R;
import com.example.ioasys.api.Api;
import com.example.ioasys.api.DataService;
import com.example.ioasys.domains.UserRequest;
import com.example.ioasys.utils.Utils;
import com.google.android.material.textfield.TextInputLayout;

import org.jetbrains.annotations.NotNull;

import java.net.HttpURLConnection;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private EditText loginEmailEditText, loginPasswordEditText;
    private TextInputLayout loginEmailTextInputLayout, loginPasswordTextInputLayout;
    private Button loginLoginButton;

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
            UserRequest userRequest = new UserRequest(loginEmailEditText.getText().toString(),
                    loginPasswordEditText.getText().toString());
            DataService dataService = Api.setupRetrofit().create(DataService.class);
            Call<ResponseBody> call = dataService.recoverVerifyLogin(userRequest);
            doLogin(call);
        });
    }

    private void doLogin(Call<ResponseBody> call) {
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NotNull Call<ResponseBody> call,
                                   @NotNull Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    moveToResearchActivity();
                } else if (response.code() == HttpURLConnection.HTTP_UNAUTHORIZED) {
                    loginEmailTextInputLayout.setError(getString(R.string.blank_space));
                    loginPasswordTextInputLayout.setError(getString(R.string.error_email_password));
                } else {
                    createErrorDialog(getString(R.string.ocurred_error));
                }
            }

            @Override
            public void onFailure(@NotNull Call<ResponseBody> call, @NotNull Throwable t) {
                createErrorDialog(getString(R.string.error_connection_fail));
            }
        });
    }

    public void createErrorDialog(String message) {
        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);
        builder.setMessage(message)
                .setCancelable(false)
                .setPositiveButton(getString(R.string.alert_dialog_text), null);
        AlertDialog alert = builder.create();
        alert.show();
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