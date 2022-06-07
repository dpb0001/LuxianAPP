package com.dominiopersonal.luxianapp.mapas;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.dominiopersonal.luxianapp.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Mapa extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mapa;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapa);

        //Desde Esta parte estamos cargando el mapa, para poder conectarlo con la vista
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mapa = googleMap;

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        mapa.setMyLocationEnabled(true);

        mapa.getUiSettings().setMyLocationButtonEnabled(true);

        LocationManager locationManager = (LocationManager) Mapa.this.getSystemService(Context.LOCATION_SERVICE);
        LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {


                LatLng medac = new LatLng(40.283828, -3.783878);
                LatLng medac2 = new LatLng(40.283648, -3.784050);

                mapa.addMarker(new MarkerOptions()
                        .position(medac)
                        .title("MEDAC Fuenlabrada")
                        );
                mapa.addMarker(new MarkerOptions()
                        .position(medac2));
                mapa.setMapType(GoogleMap.MAP_TYPE_NORMAL);


            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        /*        LatLng "id_plan" = new LatLng("Latitud", "Longitud");
        *  mapa.addMarker(new MarkerOptions()
                .position("id_plan")
                .title("Titulo"));
        * */

        };
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
    }
}
