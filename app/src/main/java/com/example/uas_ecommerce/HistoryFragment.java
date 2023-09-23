package com.example.uas_ecommerce;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;


public class HistoryFragment extends Fragment {

    MaterialToolbar materialToolbar;
    private ArrayList<historyModel> historyModelArrayList = new ArrayList<>();
    private RecyclerView historyrv;
    private historyAdapter historyAdap;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_history, container, false);

        materialToolbar = view.findViewById(R.id.topAppBar);
        historyAdap = new historyAdapter(getContext(), historyModelArrayList);
        historyrv = view.findViewById(R.id.historyRV);
        historyrv.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        historyrv.setAdapter(historyAdap);
        materialToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DashboardActivity.class);
                startActivity(i);
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        AddDummyData(historyModelArrayList);
        super.onStart();
    }
    public void AddDummyData(ArrayList<historyModel> historyModelArrayList){
        historyModelArrayList.add(new historyModel("baju arab", "Outgoing", "-200.000","10-01-2003"));
        historyModelArrayList.add(new historyModel("baju koko", "Outgoing", "-200.000","10-01-2003"));
        historyModelArrayList.add(new historyModel("baju cici", "Outgoing", "-200.000","10-01-2003"));
    }
}