package com.example.uas_ecommerce;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.uas_ecommerce.databinding.ActivityMapsBinding;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Geocoder geocoder;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        List<Address> addresses;
        geocoder = new Geocoder(this, Locale.getDefault());

        LatLng loc1 = new LatLng(-6.915845285206341, 107.58613438261567);
        try {
            addresses = geocoder.getFromLocation(loc1.latitude, loc1.longitude, 1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        mMap.addMarker(new MarkerOptions().position(loc1).title("Location 1").snippet(addresses.get(0).getAddressLine(0)));

        LatLng loc2 = new LatLng(-6.916319633556482, 107.59370478791487);
        try {
            addresses = geocoder.getFromLocation(loc2.latitude, loc2.longitude, 1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        mMap.addMarker(new MarkerOptions().position(loc2).title("Location 2").snippet(addresses.get(0).getAddressLine(0)));

        LatLng loc3 = new LatLng(-6.912804868628957, 107.59174141113208);
        try {
            addresses = geocoder.getFromLocation(loc3.latitude, loc3.longitude, 1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        mMap.addMarker(new MarkerOptions().position(loc3).title("Location 3").snippet(addresses.get(0).getAddressLine(0)));

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(@NonNull Marker marker) {
                moveToCurrentLocation(marker.getPosition());
                return false;
            }
        });

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(loc3,15));
    }

    private void moveToCurrentLocation(LatLng currentLocation)
    {
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLocation,15));
        mMap.animateCamera(CameraUpdateFactory.zoomIn());
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);
    }
}