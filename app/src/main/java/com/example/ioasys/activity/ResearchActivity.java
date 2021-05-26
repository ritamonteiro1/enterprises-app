package com.example.ioasys.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SearchView;

import com.example.ioasys.R;

public class ResearchActivity extends AppCompatActivity {
    private SearchView researchSearchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_research);
    }
}