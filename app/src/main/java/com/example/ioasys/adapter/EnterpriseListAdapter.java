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

import com.bumptech.glide.Glide;
import com.example.ioasys.R;
import com.example.ioasys.activity.ResultActivity;
import com.example.ioasys.constants.Constants;
import com.example.ioasys.domains.EnterpriseResponse;

import java.util.List;

import static com.example.ioasys.R.layout;

public class EnterpriseListAdapter extends RecyclerView.Adapter<EnterpriseListAdapter.CompanyListViewHolder> {
    private final List<EnterpriseResponse> enterprises;
    private final Context context;

    public EnterpriseListAdapter(List<EnterpriseResponse> enterprises, Context context) {
        this.enterprises = enterprises;
        this.context = context;
    }

    @NonNull
    @Override
    public EnterpriseListAdapter.CompanyListViewHolder onCreateViewHolder(ViewGroup parent,
                                                                          int viewType) {
        View listItem = LayoutInflater.from(parent.getContext()).inflate(layout.item_company,
                parent, false);
        return new CompanyListViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(CompanyListViewHolder holder, int position) {
        holder.bind(enterprises.get(position), context);
    }

    @Override
    public int getItemCount() {
        return enterprises.size();
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

        public void bind(EnterpriseResponse enterpriseResponse, Context context) {
            itemCompanyTitleTextView.setText(enterpriseResponse.getEnterpriseType().getEnterpriseTypeName());
            itemCompanyNameTextView.setText(enterpriseResponse.getEnterpriseName());
            itemCompanyCountryTextView.setText(enterpriseResponse.getCountry());
            Glide.with(context).load(Constants.BASE_IMAGE_URL + enterpriseResponse.getPhoto()).into(itemCompanyImageView);

            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(context, ResultActivity.class);
                intent.putExtra(Constants.ENTERPRISE_RESPONSE_DETAILS, enterpriseResponse);
                context.startActivity(intent);
            });
        }
    }
}



