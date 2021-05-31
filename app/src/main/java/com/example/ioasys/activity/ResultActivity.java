package com.example.ioasys.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ioasys.R;
import com.example.ioasys.constants.Constants;
import com.example.ioasys.domains.Company;

public class ResultActivity extends AppCompatActivity {
    private ImageView resultArrowBackImageView, resultCompanyImageView;
    private TextView resultCompanyNameTextView, resultDescriptionCompanyTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        findViewsById();
        Company company = retrieverDataFromResearchActivity();
        setupArrowBack();
        showCompanyDetails(company);
    }

    private void showCompanyDetails(Company company) {
        resultCompanyImageView.setImageResource(company.getImage());
        resultCompanyNameTextView.setText(company.getName());
        resultDescriptionCompanyTextView.setText(company.getDescription());
    }

    private void setupArrowBack() {
        resultArrowBackImageView.setOnClickListener(v -> finish());
    }

    private void findViewsById() {
        resultArrowBackImageView = findViewById(R.id.resultArrowBackImageView);
        resultCompanyImageView = findViewById(R.id.resultCompanyImageView);
        resultCompanyNameTextView = findViewById(R.id.resultCompanyNameTextView);
        resultDescriptionCompanyTextView = findViewById(R.id.resultDescriptionCompanyTextView);
    }

    private Company retrieverDataFromResearchActivity() {
        return (Company) getIntent().getSerializableExtra(Constants.COMPANY_DETAILS);
    }
}