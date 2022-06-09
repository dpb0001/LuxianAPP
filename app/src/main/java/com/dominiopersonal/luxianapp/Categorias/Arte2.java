package com.dominiopersonal.luxianapp.Categorias;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dominiopersonal.luxianapp.R;
import com.dominiopersonal.luxianapp.RecyclerViewAdapterCadaCategoria;

import java.util.ArrayList;

public class Arte2 extends AppCompatActivity {

    private ArrayList<String> ImagenCadaCategoria = new ArrayList<>();
    private ArrayList<String> NombreCiudadCategoria = new ArrayList<>();
    private  ArrayList<String> DescripcionCiudadCategoria = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arte2);

        getImagesCadaCategoria();
    }

    private void getImagesCadaCategoria(){
        ImagenCadaCategoria.add("https://as2.ftcdn.net/v2/jpg/00/65/29/23/1000_F_65292379_4OV8BivNZ8hXfWphx7yS1gNiRMiORmRL.jpg");
        NombreCiudadCategoria.add("Madrid");
        DescripcionCiudadCategoria.add("Descripcion de cada ciudad Descripcion de cada ciudad Descripcion de cada ciudad");

        ImagenCadaCategoria.add("https://as2.ftcdn.net/v2/jpg/00/65/29/23/1000_F_65292379_4OV8BivNZ8hXfWphx7yS1gNiRMiORmRL.jpg");
        NombreCiudadCategoria.add("Malaga");
        DescripcionCiudadCategoria.add("Descripcion de cada ciudad Descripcion de cada ciudad Descripcion de cada ciudad");

        ImagenCadaCategoria.add("https://as2.ftcdn.net/v2/jpg/00/65/29/23/1000_F_65292379_4OV8BivNZ8hXfWphx7yS1gNiRMiORmRL.jpg");
        NombreCiudadCategoria.add("Jaen");
        DescripcionCiudadCategoria.add("Descripcion de cada ciudad Descripcion de cada ciudad Descripcion de cada ciudad");

        ImagenCadaCategoria.add("https://as2.ftcdn.net/v2/jpg/00/65/29/23/1000_F_65292379_4OV8BivNZ8hXfWphx7yS1gNiRMiORmRL.jpg");
        NombreCiudadCategoria.add("Guadalajara");
        DescripcionCiudadCategoria.add("Descripcion de cada ciudad Descripcion de cada ciudad Descripcion de cada ciudad");

        ImagenCadaCategoria.add("https://as2.ftcdn.net/v2/jpg/00/65/29/23/1000_F_65292379_4OV8BivNZ8hXfWphx7yS1gNiRMiORmRL.jpg");
        NombreCiudadCategoria.add("Murcia");
        DescripcionCiudadCategoria.add("Descripcion de cada ciudad Descripcion de cada ciudad Descripcion de cada ciudad");

        initRecyclerViewCadaCategoria();
    }

    private void initRecyclerViewCadaCategoria(){
        RecyclerView recyclerView = findViewById(R.id.recyclerViewCadaCategoria);
        RecyclerViewAdapterCadaCategoria adapter = new RecyclerViewAdapterCadaCategoria(ImagenCadaCategoria, NombreCiudadCategoria, DescripcionCiudadCategoria, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}