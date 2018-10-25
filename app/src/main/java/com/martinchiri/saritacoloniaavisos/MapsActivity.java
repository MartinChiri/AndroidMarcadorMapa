package com.martinchiri.saritacoloniaavisos;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Intent transporte=getIntent();
        final double latitud=transporte.getDoubleExtra(OfertasActivity.IDLATITUD,-12.0431800);
        final double longitud=transporte.getDoubleExtra(OfertasActivity.IDLONGITUD,-77.0282400);
        final String titulo=transporte.getStringExtra(OfertasActivity.IDTITULO);

        LatLng posicion = new LatLng(latitud,  longitud);
        mMap.addMarker(new MarkerOptions().position(posicion).title(titulo));
        CameraPosition camera=new CameraPosition.Builder()
                .target(posicion)
                .zoom(16)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(camera));
    }
}
