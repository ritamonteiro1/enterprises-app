package com.example.ioasys.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.ioasys.R;
import com.example.ioasys.adapter.CompanyListAdapter;

import com.example.ioasys.domains.Company;

import java.util.ArrayList;
import java.util.List;

public class ResearchActivity extends AppCompatActivity {
    private ImageView researchSearchImageView;
    private RecyclerView researchRecyclerView;
    private TextView researchInformationTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_research);
        findViewsById();
        List<Company> companyList = createCompanies();
        CompanyListAdapter companyListAdapter = new CompanyListAdapter(companyList, this);
        setupRecyclerView(companyListAdapter);
        setupSearchView();
    }

    private void setupRecyclerView(CompanyListAdapter companyListAdapter) {
        researchRecyclerView.setAdapter(companyListAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        researchRecyclerView.setLayoutManager(layoutManager);
    }

    private void setupSearchView() {
        researchSearchImageView.setOnClickListener(v -> {
            researchInformationTextView.setVisibility(View.GONE);
            researchRecyclerView.setVisibility(View.VISIBLE);
        });
    }

    private List<Company> createCompanies() {
        String title = getString(R.string.business);
        String country = getString(R.string.country);
        String description = getString(R.string.description_company);

        Company company;
        List<Company> companyList = new ArrayList<>();

        company = new Company(R.drawable.img_company, getString(R.string.company_one), title,
                country, description);
        companyList.add(company);
        company = new Company(R.drawable.img_company, getString(R.string.company_two), title,
                country, description);
        companyList.add(company);
        company = new Company(R.drawable.img_company, getString(R.string.company_three), title,
                country, description);
        companyList.add(company);
        company = new Company(R.drawable.img_company, getString(R.string.company_four), title,
                country, description);
        companyList.add(company);
        company = new Company(R.drawable.img_company, getString(R.string.company_five), title,
                country, description);
        companyList.add(company);
        company = new Company(R.drawable.img_company, getString(R.string.company_six), title,
                country, description);
        companyList.add(company);
        company = new Company(R.drawable.img_company, getString(R.string.company_seven), title,
                country, description);
        companyList.add(company);
        return companyList;
    }

    private void findViewsById() {
        researchSearchImageView = findViewById(R.id.researchSearchImageView);
        researchRecyclerView = findViewById(R.id.researchRecyclerView);
        researchInformationTextView = findViewById(R.id.researchInformationTextView);
    }
}