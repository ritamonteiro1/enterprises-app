package com.example.ioasys.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;

import com.example.ioasys.R;
import com.example.ioasys.domains.Companies;

import java.util.ArrayList;
import java.util.List;

public class ResearchActivity extends AppCompatActivity {
    private SearchView researchSearchView;
    private RecyclerView researchRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_research);
        findViewsById();
        List<Companies> companiesList = createCompanies();

    }

    private List<Companies> createCompanies() {
        String title = getString(R.string.business);
        String country = getString(R.string.country);

        Companies company;
        List<Companies> companiesList = new ArrayList<>();

        company = new Companies(R.drawable.img_company, getString(R.string.company_one), title, country);
        companiesList.add(company);
        company = new Companies(R.drawable.img_company, getString(R.string.company_one), title, country);
        companiesList.add(company);
        company = new Companies(R.drawable.img_company, getString(R.string.company_one), title, country);
        companiesList.add(company);
        company = new Companies(R.drawable.img_company, getString(R.string.company_one), title, country);
        companiesList.add(company);
        company = new Companies(R.drawable.img_company, getString(R.string.company_one), title, country);
        companiesList.add(company);
        company = new Companies(R.drawable.img_company, getString(R.string.company_one), title, country);
        companiesList.add(company);
        company = new Companies(R.drawable.img_company, getString(R.string.company_one), title, country);
        companiesList.add(company);
        return companiesList;
    }

    private void findViewsById() {
        researchSearchView = findViewById(R.id.researchSearchView);
        researchRecyclerView = findViewById(R.id.researchRecyclerView);
    }
}