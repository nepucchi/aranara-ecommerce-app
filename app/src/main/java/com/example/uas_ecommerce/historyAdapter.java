package com.example.uas_ecommerce;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class historyAdapter extends RecyclerView.Adapter<historyAdapter.ViewHolder> {

    private Context context;
    private ArrayList<historyModel> historyModelArrayList;

    public historyAdapter(Context context, ArrayList<historyModel> historyModelArrayList) {
        this.context = context;
        this.historyModelArrayList = historyModelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.history_layout,parent,false);
        return new ViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.status.setText(historyModelArrayList.get(position).getStatus());
        holder.amt.setText(historyModelArrayList.get(position).getAmt());
        holder.date.setText(historyModelArrayList.get(position).getDate());
        holder.name.setText(historyModelArrayList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return historyModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView name,date,amt,status;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.historyName);
            amt = itemView.findViewById(R.id.historyAmt);
            date = itemView.findViewById(R.id.historyAmt);
            status = itemView.findViewById(R.id.historyStatus);
        }
    }
}
