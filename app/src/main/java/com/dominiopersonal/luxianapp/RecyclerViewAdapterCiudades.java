package com.dominiopersonal.luxianapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerViewAdapterCiudades extends RecyclerView.Adapter<RecyclerViewAdapterCiudades.ViewHolderCiudades> {

    private ArrayList <String> Ciudad = new ArrayList<>();
    private ArrayList <String> ImagenCiudad = new ArrayList<>();
    private ArrayList <String> Descripcion = new ArrayList<>();
    private ArrayList <String> Boton = new ArrayList<>();
    private Context context;

    public RecyclerViewAdapterCiudades(ArrayList<String> ciudad, ArrayList<String> imagenCiudad, ArrayList<String> descripcion, ArrayList<String> boton, Context context) {
        Ciudad = ciudad;
        ImagenCiudad = imagenCiudad;
        Descripcion = descripcion;
        Boton = boton;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolderCiudades onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater .from(parent.getContext()).inflate(R.layout.layout_horizontal_ciudades, parent, false);
        return new ViewHolderCiudades(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderCiudades holder, int position) {

        Glide.with(context)
                .asBitmap()
                .load(ImagenCiudad.get(position))
                .into(holder.imagen);

        holder.textoCiudad.setText(Ciudad.get(position));
        holder.descripcion.setText(Descripcion.get(position));
        holder.informacion.setText(Boton.get(position));

        holder.informacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return Ciudad.size();
    }

    public class ViewHolderCiudades extends RecyclerView.ViewHolder{

        ImageView imagen;
        TextView textoCiudad;
        TextView descripcion;
        Button informacion;


        public ViewHolderCiudades(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imagen_ciudad);
            textoCiudad = itemView.findViewById(R.id.nombre_ciudad);
            descripcion = itemView.findViewById(R.id.descripcion);
            informacion = itemView.findViewById(R.id.btnInformacion);
        }
    }
}
