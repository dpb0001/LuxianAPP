package com.dominiopersonal.luxianapp.Categorias;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dominiopersonal.luxianapp.R;
import com.dominiopersonal.luxianapp.RecyclerViewAdapterCadaCategoria;

import java.util.ArrayList;

public class Deporte2 extends AppCompatActivity {

    //Se crean los ArrayList para poder almacenar la información

    private ArrayList<String> ImagenCadaCategoria = new ArrayList<>();
    private ArrayList<String> NombreCiudadCategoria = new ArrayList<>();
    private  ArrayList<String> DescripcionCiudadCategoria = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deporte2);

        //Añadiendo la información a la interfaz
        getImageDeporte();
    }

    //Insertando la información el los ArrayList
    private void getImageDeporte(){
        ImagenCadaCategoria.add("https://img.freepik.com/vector-gratis/plantilla-logo-deporte-forma-abstracta_23-2148228932.jpg?w=2000");
        NombreCiudadCategoria.add("Madrid");
        DescripcionCiudadCategoria.add("Descripcion de cada ciudad Descripcion de cada ciudad Descripcion de cada ciudad");

        ImagenCadaCategoria.add("https://img.freepik.com/vector-gratis/plantilla-logo-deporte-forma-abstracta_23-2148228932.jpg?w=2000");
        NombreCiudadCategoria.add("Malaga");
        DescripcionCiudadCategoria.add("Descripcion de cada ciudad Descripcion de cada ciudad Descripcion de cada ciudad");

        ImagenCadaCategoria.add("https://img.freepik.com/vector-gratis/plantilla-logo-deporte-forma-abstracta_23-2148228932.jpg?w=2000");
        NombreCiudadCategoria.add("Jaen");
        DescripcionCiudadCategoria.add("Descripcion de cada ciudad Descripcion de cada ciudad Descripcion de cada ciudad");

        ImagenCadaCategoria.add("https://img.freepik.com/vector-gratis/plantilla-logo-deporte-forma-abstracta_23-2148228932.jpg?w=2000");
        NombreCiudadCategoria.add("Guadalajara");
        DescripcionCiudadCategoria.add("Descripcion de cada ciudad Descripcion de cada ciudad Descripcion de cada ciudad");

        ImagenCadaCategoria.add("https://img.freepik.com/vector-gratis/plantilla-logo-deporte-forma-abstracta_23-2148228932.jpg?w=2000");
        NombreCiudadCategoria.add("Murcia");
        DescripcionCiudadCategoria.add("Descripcion de cada ciudad Descripcion de cada ciudad Descripcion de cada ciudad");

        //Añadiendo la información al RecyclerView
        initRecyclerViewDeporte();

    }

    //Asignando el RecyclerView al cual ira la información
    private void initRecyclerViewDeporte(){
        RecyclerView recyclerView = findViewById(R.id.recyclerViewCategoriaDeporte);
        RecyclerViewAdapterCadaCategoria adapter = new RecyclerViewAdapterCadaCategoria(ImagenCadaCategoria, NombreCiudadCategoria, DescripcionCiudadCategoria, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}