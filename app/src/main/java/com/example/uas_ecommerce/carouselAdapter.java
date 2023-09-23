package com.example.uas_ecommerce;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class carouselAdapter extends RecyclerView.Adapter<carouselAdapter.FormHolder> {

    private Context context;
    private ArrayList<itemModel> itemModelArrayList;

    public carouselAdapter(Context context, ArrayList<itemModel> itemModelArrayList) {
        this.context = context;
        this.itemModelArrayList = itemModelArrayList;
    }

    @NonNull
    @Override
    public carouselAdapter.FormHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.carousel_layout, parent, false);
        return new FormHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FormHolder holder, int position) {
        itemModel model = itemModelArrayList.get(position);
        holder.name.setText(model.getItemName());
        holder.price.setText(model.getItemPrice());
        holder.review.setText(Integer.toString(model.getReviewCount()));
    }

    @Override
    public int getItemCount() {
        return itemModelArrayList.size();
    }

    public class FormHolder extends RecyclerView.ViewHolder{

        private TextView name, price, review;

        public FormHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.itemName);
            price = itemView.findViewById(R.id.itemPrice);
            review = itemView.findViewById(R.id.itemReviews);
        }
    }


}
