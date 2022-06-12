package com.dominiopersonal.luxianapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dominiopersonal.luxianapp.BBDD.Adaptador.PlanAdapter;
import com.dominiopersonal.luxianapp.BBDD.Adaptador.RutaAdapter;
import com.dominiopersonal.luxianapp.BBDD.Modelo.Ruta;
import com.dominiopersonal.luxianapp.mapas.Mapa;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class RutaActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Ruta> rutaArrayList;
    private RutaAdapter rutaAdapter;
    private FirebaseFirestore db;
    private ProgressDialog progressDialog;

    private Long ID_ruta;
    private Long ID_plan;


    String ID_ciudad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lugar);

        db = FirebaseFirestore.getInstance();

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Creando datos... ");
        progressDialog.show();

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        rutaArrayList = new ArrayList<Ruta>();
        rutaAdapter = new RutaAdapter(RutaActivity.this,rutaArrayList);

        recyclerView.setAdapter(rutaAdapter);

        EventChangeListener();

        // Obtener Datos

        db.collection("Ruta").document("Ruta1").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    ID_ruta = documentSnapshot.getLong("ID_ruta");
                }
            }
        });

        // Final Obtener Datos
/*
        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

                return false;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

 */

    }

    private void EventChangeListener() {



        db.collection("Ruta").orderBy("ID_ruta", Query.Direction.ASCENDING).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                if(error != null) {

                    if(progressDialog.isShowing())
                        progressDialog.dismiss();

                    Log.e("Error de Firestore: ",error.getMessage());
                    return;

                }

                for (DocumentChange dc : value.getDocumentChanges()) {

                    if(dc.getType() == DocumentChange.Type.ADDED) {

                        rutaArrayList.add(dc.getDocument().toObject(Ruta.class));

                    }

                    rutaAdapter.notifyDataSetChanged();
                    if(progressDialog.isShowing())
                        progressDialog.dismiss();

                }

            }
        });

    }
}
