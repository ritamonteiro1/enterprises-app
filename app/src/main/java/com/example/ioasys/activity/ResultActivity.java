package com.example.ioasys.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.ioasys.R;
import com.example.ioasys.constants.Constants;
import com.example.ioasys.domains.EnterpriseResponse;

public class ResultActivity extends AppCompatActivity {
    private ImageView resultEnterpriseImageView;
    private TextView resultDescriptionEnterpriseTextView;
    private Toolbar resultToolBar;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        findViewsById();
        EnterpriseResponse enterpriseResponse = retrieverDataFromResearchActivity();
        setupToolBar(enterpriseResponse.getEnterpriseName());
        showCompanyDetails(enterpriseResponse);
    }

    private void setupToolBar(String enterpriseName) {
        setSupportActionBar(resultToolBar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(enterpriseName);
        }
    }


    private void showCompanyDetails(EnterpriseResponse enterpriseResponse) {
        Glide.with(this).load(Constants.BASE_IMAGE_URL + enterpriseResponse.getPhoto())
                .into(resultEnterpriseImageView);
        resultDescriptionEnterpriseTextView.setText(enterpriseResponse.getDescription());
    }

    private void findViewsById() {
        resultEnterpriseImageView = findViewById(R.id.resultEnterpriseImageView);
        resultDescriptionEnterpriseTextView = findViewById(R.id.resultDescriptionEnterpriseTextView);
        resultToolBar = findViewById(R.id.resultToolBar);
    }

    private EnterpriseResponse retrieverDataFromResearchActivity() {
        return (EnterpriseResponse) getIntent().getSerializableExtra(Constants.ENTERPRISE_RESPONSE_DETAILS);
    }
}