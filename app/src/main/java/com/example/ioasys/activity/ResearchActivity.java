package com.example.ioasys.activity;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;


import com.example.ioasys.R;
import com.example.ioasys.adapter.CompanyListAdapter;

import com.example.ioasys.constants.Constants;
import com.example.ioasys.domains.CompanyResponse;

import java.util.ArrayList;
import java.util.List;

public class ResearchActivity extends AppCompatActivity {
    private RecyclerView researchRecyclerView;
    private TextView researchInformationTextView;
    private Toolbar researchToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_research);
        findViewsById();
        setupToolBar();
        List<CompanyResponse> companyResponseList = createCompanies();
        CompanyListAdapter companyListAdapter = new CompanyListAdapter(companyResponseList, this);
        setupRecyclerView(companyListAdapter);
    }

    private void setupToolBar() {
        setSupportActionBar(researchToolBar);
        if(getSupportActionBar()!= null){
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setLogo(R.drawable.img_logo_nav);
            getSupportActionBar().setDisplayUseLogoEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem menuItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint(getString(R.string.search));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                researchInformationTextView.setVisibility(View.GONE);
                if (newText.length() >= Constants.TYPED_LETTERS) {
                    researchRecyclerView.setVisibility(View.VISIBLE);
                }
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }


    private void setupRecyclerView(CompanyListAdapter companyListAdapter) {
        researchRecyclerView.setAdapter(companyListAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        researchRecyclerView.setLayoutManager(layoutManager);
    }

    private List<CompanyResponse> createCompanies() {
        String title = getString(R.string.business);
        String country = getString(R.string.country);
        String description = getString(R.string.description_company);

        CompanyResponse companyResponse;
        List<CompanyResponse> companyResponseList = new ArrayList<>();

        companyResponse = new CompanyResponse(R.drawable.img_company, getString(R.string.company_one), title,
                country, description);
        companyResponseList.add(companyResponse);
        companyResponse = new CompanyResponse(R.drawable.img_company, getString(R.string.company_two), title,
                country, description);
        companyResponseList.add(companyResponse);
        companyResponse = new CompanyResponse(R.drawable.img_company, getString(R.string.company_three), title,
                country, description);
        companyResponseList.add(companyResponse);
        companyResponse = new CompanyResponse(R.drawable.img_company, getString(R.string.company_four), title,
                country, description);
        companyResponseList.add(companyResponse);
        companyResponse = new CompanyResponse(R.drawable.img_company, getString(R.string.company_five), title,
                country, description);
        companyResponseList.add(companyResponse);
        companyResponse = new CompanyResponse(R.drawable.img_company, getString(R.string.company_six), title,
                country, description);
        companyResponseList.add(companyResponse);
        companyResponse = new CompanyResponse(R.drawable.img_company, getString(R.string.company_seven), title,
                country, description);
        companyResponseList.add(companyResponse);
        return companyResponseList;
    }

    private void findViewsById() {
        researchRecyclerView = findViewById(R.id.researchRecyclerView);
        researchInformationTextView = findViewById(R.id.researchInformationTextView);
        researchToolBar = findViewById(R.id.researchToolBar);
    }
}