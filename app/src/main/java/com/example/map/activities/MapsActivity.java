 package com.example.map.activities;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.map.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //mMap.setMinZoomPreference(10);
        //mMap.setMaxZoomPreference(15);

        // Add a marker in Sydney and move the camera
        LatLng mexico = new LatLng(20.4831, -99.2171);
        mMap.addMarker(new MarkerOptions().position(mexico).title("Hola desde Ixmiquilpan").draggable(true));

        CameraPosition camera = new CameraPosition.Builder()
                .target(mexico)
                .zoom(19)           // Limit <=21
                .bearing(45)        //0 - 365°
                .tilt(90)         //Limit <=90
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(camera));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(mexico));
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                Toast.makeText(MapsActivity.this, "Click on : \n " +
                        "Lat : " + latLng.latitude + " \n " +
                        "Lon : " +latLng.longitude, Toast.LENGTH_SHORT).show();

            }
        });

        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
                Toast.makeText(MapsActivity.this, "Long click on : \n " +
                        "Lat : " + latLng.latitude + " \n " +
                        "Lon : " +latLng.longitude, Toast.LENGTH_SHORT).show();
            }
        });
        mMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
            @Override
            public void onMarkerDragStart(Marker marker) {

            }

            @Override
            public void onMarkerDrag(Marker marker) {

            }

            @Override
            public void onMarkerDragEnd(Marker marker) {
                Toast.makeText(MapsActivity.this, "Marker dragged to : \n " +
                        "Lat : " + marker.getPosition().latitude + " \n " +
                        "Lon : " + marker.getPosition().longitude , Toast.LENGTH_SHORT).show();
            }
        });
    }
}
