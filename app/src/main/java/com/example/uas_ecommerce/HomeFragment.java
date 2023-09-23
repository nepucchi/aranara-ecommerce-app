package com.example.uas_ecommerce;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private ImageView findus;
    private ArrayList<itemModel> itemModelArrayList = new ArrayList<>();
    private carouselAdapter carouselAdap;
    private RecyclerView carousel1,carousel2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        findus = view.findViewById(R.id.findbutton);
        carousel1 = view.findViewById(R.id.carousel1);
        carousel2 = view.findViewById(R.id.carousel2);

        carouselAdap = new carouselAdapter(getContext(), itemModelArrayList);
        findus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), MapsActivity.class);
                startActivity(i);
            }
        });
        carousel1.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        carousel2.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        carousel1.setAdapter(carouselAdap);
        carousel2.setAdapter(carouselAdap);
        return view;
    }

    @Override
    public void onStart() {
        AddDummyData(itemModelArrayList);
        super.onStart();
    }
    public void AddDummyData(ArrayList<itemModel> itemModelArrayList){
        itemModelArrayList.add(new itemModel("dudul", "2000", 20));
        itemModelArrayList.add(new itemModel("sumbul", "12300", 11));
        itemModelArrayList.add(new itemModel("juki", "3000", 21));
    }
}