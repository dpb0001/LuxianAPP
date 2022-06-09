package com.dominiopersonal.luxianapp.Categorias;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dominiopersonal.luxianapp.R;
import com.dominiopersonal.luxianapp.RecyclerViewAdapterCadaCategoria;

import java.util.ArrayList;

public class AireLibre2 extends AppCompatActivity {

    private ArrayList<String> ImagenCadaCategoria = new ArrayList<>();
    private ArrayList<String> NombreCiudadCategoria = new ArrayList<>();
    private  ArrayList<String> DescripcionCiudadCategoria = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aire_libre2);

        getImageAireLibre();
    }

    private void getImageAireLibre(){
        ImagenCadaCategoria.add("https://img.freepik.com/vector-gratis/camping-al-aire-libre-logo-icono-vector-concepto-retro-ilustracion-diseno_557439-457.jpg?w=2000");
        NombreCiudadCategoria.add("Madrid");
        DescripcionCiudadCategoria.add("Descripcion de cada ciudad Descripcion de cada ciudad Descripcion de cada ciudad");

        ImagenCadaCategoria.add("https://img.freepik.com/vector-gratis/camping-al-aire-libre-logo-icono-vector-concepto-retro-ilustracion-diseno_557439-457.jpg?w=2000");
        NombreCiudadCategoria.add("Malaga");
        DescripcionCiudadCategoria.add("Descripcion de cada ciudad Descripcion de cada ciudad Descripcion de cada ciudad");

        ImagenCadaCategoria.add("https://img.freepik.com/vector-gratis/camping-al-aire-libre-logo-icono-vector-concepto-retro-ilustracion-diseno_557439-457.jpg?w=2000");
        NombreCiudadCategoria.add("Jaen");
        DescripcionCiudadCategoria.add("Descripcion de cada ciudad Descripcion de cada ciudad Descripcion de cada ciudad");

        ImagenCadaCategoria.add("https://img.freepik.com/vector-gratis/camping-al-aire-libre-logo-icono-vector-concepto-retro-ilustracion-diseno_557439-457.jpg?w=2000");
        NombreCiudadCategoria.add("Guadalajara");
        DescripcionCiudadCategoria.add("Descripcion de cada ciudad Descripcion de cada ciudad Descripcion de cada ciudad");

        ImagenCadaCategoria.add("https://img.freepik.com/vector-gratis/camping-al-aire-libre-logo-icono-vector-concepto-retro-ilustracion-diseno_557439-457.jpg?w=2000");
        NombreCiudadCategoria.add("Murcia");
        DescripcionCiudadCategoria.add("Descripcion de cada ciudad Descripcion de cada ciudad Descripcion de cada ciudad");

        initRecyclerViewAireLibre();

    }

    private void initRecyclerViewAireLibre(){
        RecyclerView recyclerView = findViewById(R.id.recyclerViewCategoriaAireLibre);
        RecyclerViewAdapterCadaCategoria adapter = new RecyclerViewAdapterCadaCategoria(ImagenCadaCategoria, NombreCiudadCategoria, DescripcionCiudadCategoria, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}