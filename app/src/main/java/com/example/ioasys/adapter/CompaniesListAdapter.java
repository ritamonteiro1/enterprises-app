package com.example.ioasys.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ioasys.R;
import com.example.ioasys.domains.Companies;

import java.util.List;

import static com.example.ioasys.R.*;

public class CompaniesListAdapter extends RecyclerView.Adapter<CompaniesListAdapter.CompaniesListViewHolder> {
    private final List<Companies> companiesList;

    public CompaniesListAdapter(List<Companies> companiesList) {
        this.companiesList = companiesList;
    }

    @NonNull
    @Override
    public CompaniesListAdapter.CompaniesListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(parent.getContext()).inflate(layout.item_company,
                parent, false);
        return new CompaniesListViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(CompaniesListViewHolder holder, int position) {
    holder.bind(companiesList.get(position));
    }

    @Override
    public int getItemCount() {
        return companiesList.size();
    }


    public class CompaniesListViewHolder extends RecyclerView.ViewHolder{
        private ImageView itemCompanyImageView;
        private TextView itemCompanyNameTextView, itemCompanyTitleTextView, itemCompanyCountryTextView;

        public CompaniesListViewHolder(View itemView) {
            super(itemView);
            itemCompanyImageView = itemView.findViewById(R.id.itemCompanyImageView);
            itemCompanyCountryTextView = itemView.findViewById(R.id.itemCompanyCountryTextView);
            itemCompanyNameTextView = itemView.findViewById(R.id.itemCompanyNameTextView);
            itemCompanyTitleTextView = itemView.findViewById(R.id.itemCompanyTitleTextView);
        }

        public void bind (Companies company){
            itemCompanyTitleTextView.setText(company.getTitle());
            itemCompanyNameTextView.setText(company.getName());
            itemCompanyCountryTextView.setText(company.getCountry());
            itemCompanyImageView.setImageResource(company.getImage());
        }
    }
}

