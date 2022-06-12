package com.dominiopersonal.luxianapp.ui.home;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dominiopersonal.luxianapp.BBDD.Adaptador.CiudadAdapter;
import com.dominiopersonal.luxianapp.BBDD.Modelo.Ciudad;
import com.dominiopersonal.luxianapp.ElementosRecycler;
import com.dominiopersonal.luxianapp.R;
import com.dominiopersonal.luxianapp.RecyclerViewAdapterCategorias;
import com.dominiopersonal.luxianapp.databinding.FragmentHomeBinding;
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

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private RecyclerView recyclerView;
    private ArrayList<Ciudad> ciudadArrayList;
    private ArrayList<String> Nombre;
    private CiudadAdapter ciudadAdapter;
    private FirebaseFirestore db;
    private ProgressDialog progressDialog;

    private Long ID_ciudad;
    RecyclerView imagen_ciudad;


    private ArrayList<String> NomCategoria = new ArrayList<>();
    private ArrayList<String> ImgCategoria = new ArrayList<>();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);



        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        db = FirebaseFirestore.getInstance();


        getImages();

        progressDialog = new ProgressDialog(getContext());
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Creando datos... ");
        progressDialog.show();


        recyclerView = root.findViewById(R.id.recyclerViewCiudades);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        ciudadArrayList = new ArrayList<Ciudad>();
        ciudadAdapter = new CiudadAdapter(HomeFragment.this.getContext(),ciudadArrayList, Nombre);

        recyclerView.setAdapter(ciudadAdapter);

        EventChangeListener();

        // Obtener Datos

        db.collection("Ciudad").document("Madrid").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    ID_ciudad = documentSnapshot.getLong("ID_ciudad");
                }
            }
        });

        // Final Obtener Datos


        recyclerView.addOnItemTouchListener(new ElementosRecycler(getContext(), recyclerView, new ElementosRecycler.ClickListener(){

            // En caso de que el usuario pulse un click sobre algun elemento del recycler, se pasara
            // la información a la clase EditarCerveza para poder manipularla desde allí
            @Override
            public void onClick(View view, int posicion){
                Intent i = new Intent(getContext(), Mapa.class);

                i.putExtra("Latitud", 40.4321033);
                i.putExtra("Longitud", -3.7340368);

                startActivity(i);

            }

            // Si el usuario mantiene el dedo sobre un elemento del recycler aparecera un mensaje
            // indicando si quiere eliminar ese elemento
            @Override
            public void onLongClick(View view, int posicion) {


            }
        }));


        return root;
    }





    private void EventChangeListener() {

        db.collection("Ciudad").orderBy("ID_ciudad", Query.Direction.ASCENDING).addSnapshotListener(new EventListener<QuerySnapshot>() {
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

                        ciudadArrayList.add(dc.getDocument().toObject(Ciudad.class));

                    }

                    ciudadAdapter.notifyDataSetChanged();
                    if(progressDialog.isShowing())
                        progressDialog.dismiss();

                }

            }
        });

    }

    //Insertando la información a los Arraylist de las categorias
    private void getImages(){

        ImgCategoria.add("https://as2.ftcdn.net/v2/jpg/00/65/29/23/1000_F_65292379_4OV8BivNZ8hXfWphx7yS1gNiRMiORmRL.jpg");
        NomCategoria.add("Arte");

        ImgCategoria.add("https://i.pinimg.com/736x/de/75/ce/de75ce81f9cc8651b33fdc44985c8eac.jpg");
        NomCategoria.add("Gastronomia");

        ImgCategoria.add("https://img.freepik.com/vector-gratis/plantilla-logo-deporte-forma-abstracta_23-2148228932.jpg?w=2000");
        NomCategoria.add("Deporte");

        ImgCategoria.add("data:image/png;base64,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");
        NomCategoria.add("Ocio");

        ImgCategoria.add("https://img.freepik.com/vector-gratis/camping-al-aire-libre-logo-icono-vector-concepto-retro-ilustracion-diseno_557439-457.jpg?w=2000");
        NomCategoria.add("Aire libre");

        //Añadiendo la información al RecyclerView
        initRecyclerView();
    }

    //Asignando el RecyclerView al cual ira la información
    private void initRecyclerView(){
        View root = binding.getRoot();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapterCategorias adapter = new RecyclerViewAdapterCategorias(NomCategoria, ImgCategoria, getContext());
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}