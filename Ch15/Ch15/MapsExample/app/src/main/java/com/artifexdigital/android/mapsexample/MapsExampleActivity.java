package com.artifexdigital.android.mapsexample;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsExampleActivity extends FragmentActivity {

    private GoogleMap myMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_example);
        createMap();
    }

    @Override
    protected void onResume() {
        super.onResume();
        createMap();
    }

    private void createMap() {
        myMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                .getMap();
        myMap.addMarker(new MarkerOptions().position(new LatLng(51.5, 0)).title("London"));
    }
}
