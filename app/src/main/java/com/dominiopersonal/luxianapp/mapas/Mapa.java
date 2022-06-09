package com.dominiopersonal.luxianapp.mapas;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.dominiopersonal.luxianapp.BBDD.Modelo.Plan;
import com.dominiopersonal.luxianapp.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.GeoPoint;

public class Mapa extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mapa;

    Bundle datos;

    private FirebaseFirestore db;
    private GeoPoint puntos;
    String TAG = "DocSnippets";

    Double planLatitud, planLongitud;

    private FirebaseDatabase bbdd = FirebaseDatabase.getInstance();
    private DatabaseReference reference = bbdd.getReference().child("Plan");


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



                datos = getIntent().getExtras();


                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot snap:snapshot.getChildren()) {
                            Plan plan = snap.getValue(Plan.class);
                            plan.getLatitud();
                            plan.getLongitud();

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                obtenerMapas();

                LatLng medac = new LatLng(40.283648, -3.78405);
                LatLng medac2 = new LatLng(puntos.getLatitude(), puntos.getLongitude());

                mapa.addMarker(new MarkerOptions()
                        .position(medac)
                        .title("MEDAC Fuenlabrada" )
                        );
                mapa.addMarker(new MarkerOptions()
                        .position(medac2));
                mapa.setMapType(GoogleMap.MAP_TYPE_NORMAL);


            }

            private void  obtenerMapas () {

                db.collection("Plan").document("PlanSol").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if(documentSnapshot.exists()){

                            puntos = documentSnapshot.getGeoPoint("Puntos");

                        } else {
                            Toast.makeText(Mapa.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


                /*
                DocumentReference docRef = db.collection("cities").document("SF");

                docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            if (document.exists()) {
                                Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                            } else {
                                Log.d(TAG, "No such document");
                            }
                        } else {
                            Log.d(TAG, "get failed with ", task.getException());
                        }
                    }


                });
                */

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
