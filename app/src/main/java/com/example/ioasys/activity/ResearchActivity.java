package com.example.ioasys.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import android.widget.SearchView;
import android.widget.TextView;

import com.example.ioasys.R;
import com.example.ioasys.adapter.CompanyListAdapter;

import com.example.ioasys.domains.Company;

import java.util.ArrayList;
import java.util.List;

public class ResearchActivity extends AppCompatActivity {
    private SearchView researchSearchView;
    private RecyclerView researchRecyclerView;
    private TextView researchInformationTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_research);
        findViewsById();
        researchRecyclerView.setVisibility(View.INVISIBLE);
        List<Company> companyList = createCompanies();
        CompanyListAdapter companyListAdapter = new CompanyListAdapter(companyList, this);
        setupRecyclerView(companyListAdapter);
        setupSearchView();
    }

    private void setupRecyclerView(CompanyListAdapter companyListAdapter) {
            researchRecyclerView.setAdapter(companyListAdapter);
    }

    private void setupSearchView() {
        researchSearchView.setOnClickListener(v -> {
            researchInformationTextView.setVisibility(View.GONE);
            researchRecyclerView.setVisibility(View.VISIBLE);
        });
    }

    private List<Company> createCompanies() {
        String title = getString(R.string.business);
        String country = getString(R.string.country);
        String description = getString(R.string.description_company);

        Company company;
        List<Company> companiesList = new ArrayList<>();

        company = new Company(R.drawable.img_company, getString(R.string.company_one), title,
                country, description);
        companiesList.add(company);
        company = new Company(R.drawable.img_company, getString(R.string.company_one), title,
                country, description);
        companiesList.add(company);
        company = new Company(R.drawable.img_company, getString(R.string.company_one), title,
                country, description);
        companiesList.add(company);
        company = new Company(R.drawable.img_company, getString(R.string.company_one), title,
                country, description);
        companiesList.add(company);
        company = new Company(R.drawable.img_company, getString(R.string.company_one), title,
                country, description);
        companiesList.add(company);
        company = new Company(R.drawable.img_company, getString(R.string.company_one), title,
                country, description);
        companiesList.add(company);
        company = new Company(R.drawable.img_company, getString(R.string.company_one), title,
                country, description);
        companiesList.add(company);
        return companiesList;
    }

    private void findViewsById() {
        researchSearchView = findViewById(R.id.researchSearchView);
        researchRecyclerView = findViewById(R.id.researchRecyclerView);
        researchInformationTextView = findViewById(R.id.researchInformationTextView);
    }
}