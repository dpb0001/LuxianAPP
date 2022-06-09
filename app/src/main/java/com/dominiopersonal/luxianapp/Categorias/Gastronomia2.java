package com.dominiopersonal.luxianapp.Categorias;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dominiopersonal.luxianapp.R;
import com.dominiopersonal.luxianapp.RecyclerViewAdapterCadaCategoria;

import java.util.ArrayList;


public class Gastronomia2 extends AppCompatActivity {

    private ArrayList<String> ImagenCadaCategoria = new ArrayList<>();
    private ArrayList<String> NombreCiudadCategoria = new ArrayList<>();
    private  ArrayList<String> DescripcionCiudadCategoria = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gastronomia2);
        getImageGastronomia();
    }

    private void getImageGastronomia(){
        ImagenCadaCategoria.add("https://i.pinimg.com/736x/de/75/ce/de75ce81f9cc8651b33fdc44985c8eac.jpg");
        NombreCiudadCategoria.add("Madrid");
        DescripcionCiudadCategoria.add("Descripcion de cada ciudad Descripcion de cada ciudad Descripcion de cada ciudad");

        ImagenCadaCategoria.add("https://i.pinimg.com/736x/de/75/ce/de75ce81f9cc8651b33fdc44985c8eac.jpg");
        NombreCiudadCategoria.add("Malaga");
        DescripcionCiudadCategoria.add("Descripcion de cada ciudad Descripcion de cada ciudad Descripcion de cada ciudad");

        ImagenCadaCategoria.add("https://i.pinimg.com/736x/de/75/ce/de75ce81f9cc8651b33fdc44985c8eac.jpg");
        NombreCiudadCategoria.add("Jaen");
        DescripcionCiudadCategoria.add("Descripcion de cada ciudad Descripcion de cada ciudad Descripcion de cada ciudad");

        ImagenCadaCategoria.add("https://i.pinimg.com/736x/de/75/ce/de75ce81f9cc8651b33fdc44985c8eac.jpg");
        NombreCiudadCategoria.add("Guadalajara");
        DescripcionCiudadCategoria.add("Descripcion de cada ciudad Descripcion de cada ciudad Descripcion de cada ciudad");

        ImagenCadaCategoria.add("https://i.pinimg.com/736x/de/75/ce/de75ce81f9cc8651b33fdc44985c8eac.jpg");
        NombreCiudadCategoria.add("Murcia");
        DescripcionCiudadCategoria.add("Descripcion de cada ciudad Descripcion de cada ciudad Descripcion de cada ciudad");

        initRecyclerViewGastronomia();

    }

    private void initRecyclerViewGastronomia(){
        RecyclerView recyclerView = findViewById(R.id.recyclerViewCategoriaGastronomia);
        RecyclerViewAdapterCadaCategoria adapter = new RecyclerViewAdapterCadaCategoria(ImagenCadaCategoria, NombreCiudadCategoria, DescripcionCiudadCategoria, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}