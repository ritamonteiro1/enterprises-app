package com.example.ioasys.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ioasys.R;
import com.example.ioasys.activity.ResultActivity;
import com.example.ioasys.constants.Constants;
import com.example.ioasys.domains.CompanyResponse;

import java.util.List;

import static com.example.ioasys.R.layout;

public class CompanyListAdapter extends RecyclerView.Adapter<CompanyListAdapter.CompanyListViewHolder> {
    private final List<CompanyResponse> companyResponseList;
    private final Context context;

    public CompanyListAdapter(List<CompanyResponse> companyResponseList, Context context) {
        this.companyResponseList = companyResponseList;
        this.context = context;
    }

    @NonNull
    @Override
    public CompanyListAdapter.CompanyListViewHolder onCreateViewHolder(ViewGroup parent,
                                                                       int viewType) {
        View listItem = LayoutInflater.from(parent.getContext()).inflate(layout.item_company,
                parent, false);
        return new CompanyListViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(CompanyListViewHolder holder, int position) {
        holder.bind(companyResponseList.get(position), context);
    }

    @Override
    public int getItemCount() {
        return companyResponseList.size();
    }

    public static class CompanyListViewHolder extends RecyclerView.ViewHolder {
        private final ImageView itemCompanyImageView;
        private final TextView itemCompanyNameTextView;
        private final TextView itemCompanyTitleTextView;
        private final TextView itemCompanyCountryTextView;

        public CompanyListViewHolder(View itemView) {
            super(itemView);
            itemCompanyImageView = itemView.findViewById(R.id.itemCompanyImageView);
            itemCompanyCountryTextView = itemView.findViewById(R.id.itemCompanyCountryTextView);
            itemCompanyNameTextView = itemView.findViewById(R.id.itemCompanyNameTextView);
            itemCompanyTitleTextView = itemView.findViewById(R.id.itemCompanyTitleTextView);
        }

        public void bind(CompanyResponse companyResponse, Context context) {
            itemCompanyTitleTextView.setText(companyResponse.getTitle());
            itemCompanyNameTextView.setText(companyResponse.getName());
            itemCompanyCountryTextView.setText(companyResponse.getCountry());
            itemCompanyImageView.setImageResource(companyResponse.getImage());
            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(context, ResultActivity.class);
                intent.putExtra(Constants.COMPANY_DETAILS, companyResponse);
                context.startActivity(intent);
            });
        }
    }
}



