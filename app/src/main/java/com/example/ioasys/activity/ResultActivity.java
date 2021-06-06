package com.example.ioasys.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.ioasys.R;
import com.example.ioasys.constants.Constants;
import com.example.ioasys.domains.CompanyResponse;

public class ResultActivity extends AppCompatActivity {
    private ImageView resultCompanyImageView;
    private TextView resultDescriptionCompanyTextView;
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
        CompanyResponse companyResponse = retrieverDataFromResearchActivity();
        setupToolBar(companyResponse.getName());
        showCompanyDetails(companyResponse);
    }

    private void setupToolBar(String companyName) {
        setSupportActionBar(resultToolBar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(companyName);
        }
    }


    private void showCompanyDetails(CompanyResponse companyResponse) {
        resultCompanyImageView.setImageResource(companyResponse.getImage());
        resultDescriptionCompanyTextView.setText(companyResponse.getDescription());
    }

    private void findViewsById() {
        resultCompanyImageView = findViewById(R.id.resultCompanyImageView);
        resultDescriptionCompanyTextView = findViewById(R.id.resultDescriptionCompanyTextView);
        resultToolBar = findViewById(R.id.resultToolBar);
    }

    private CompanyResponse retrieverDataFromResearchActivity() {
        return (CompanyResponse) getIntent().getSerializableExtra(Constants.COMPANY_DETAILS);
    }
}