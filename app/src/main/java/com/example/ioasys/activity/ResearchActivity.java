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
import com.example.ioasys.adapter.EnterpriseListAdapter;

import com.example.ioasys.api.Api;
import com.example.ioasys.api.DataService;
import com.example.ioasys.domains.EnterpriseListResponse;

import org.jetbrains.annotations.NotNull;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
    }

    private void getCompanyResponse(Call<EnterpriseListResponse> call) {
        call.enqueue(new Callback<EnterpriseListResponse>() {
            @Override
            public void onResponse(@NotNull Call<EnterpriseListResponse> call,
                                   @NotNull Response<EnterpriseListResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    researchRecyclerView.setVisibility(View.VISIBLE);
                    EnterpriseListResponse enterpriseListResponse = response.body();
                    EnterpriseListAdapter enterpriseListAdapter =
                            new EnterpriseListAdapter(enterpriseListResponse.getEnterprises(),
                                    ResearchActivity.this);
                    setupRecyclerView(enterpriseListAdapter);
                } else {
                    researchInformationTextView.setVisibility(View.VISIBLE);
                    researchInformationTextView.setText(getString(R.string.ocurred_error));
                }
            }

            @Override
            public void onFailure(@NotNull Call<EnterpriseListResponse> call,
                                  @NotNull Throwable t) {
                researchInformationTextView.setVisibility(View.VISIBLE);
                researchInformationTextView.setText(getString(R.string.error_connection_fail));
            }
        });
    }

    private void setupToolBar() {
        setSupportActionBar(researchToolBar);
        if (getSupportActionBar() != null) {
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
                DataService dataService = Api.setupRetrofit().create(DataService.class);
                Call<EnterpriseListResponse> call = dataService.recoverCompanyResponse(newText);
                getCompanyResponse(call);
                researchInformationTextView.setVisibility(View.GONE);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }


    private void setupRecyclerView(EnterpriseListAdapter enterpriseListAdapter) {
        researchRecyclerView.setAdapter(enterpriseListAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        researchRecyclerView.setLayoutManager(layoutManager);
    }

    private void findViewsById() {
        researchRecyclerView = findViewById(R.id.researchRecyclerView);
        researchInformationTextView = findViewById(R.id.researchInformationTextView);
        researchToolBar = findViewById(R.id.researchToolBar);
    }
}