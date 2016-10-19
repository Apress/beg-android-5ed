package com.artifexdigital.android.mapsexample2;

        import android.support.v4.app.FragmentActivity;
        import android.os.Bundle;
        import android.widget.Toast;
        import com.google.android.gms.maps.CameraUpdateFactory;
        import com.google.android.gms.maps.GoogleMap;
        import com.google.android.gms.maps.SupportMapFragment;
        import com.google.android.gms.maps.model.LatLng;
        import com.google.android.gms.maps.model.MarkerOptions;

public class MapsExampleActivity extends FragmentActivity implements GoogleMap.OnMapClickListener {

    private GoogleMap myMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_example);
        setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded() {
        if (myMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            myMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if map is found
            if (myMap != null) {
                createMap();
            }
        }
    }

    private void createMap() {
        myMap.addMarker(new MarkerOptions().position(new LatLng(51.5, 0)).title("London"));
        myMap.getUiSettings().setZoomControlsEnabled(true);
        myMap.getUiSettings().setCompassEnabled(true);
        myMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        myMap.setOnMapClickListener(this);
    }

    @Override
    public void onMapClick(LatLng point) {
        myMap.animateCamera(CameraUpdateFactory.newLatLng(point));
        Toast.makeText(getApplicationContext(), point.toString(),
                Toast.LENGTH_LONG).show();
    }
}
