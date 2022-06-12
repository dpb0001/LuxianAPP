package com.dominiopersonal.luxianapp.BBDD.Adaptador;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.dominiopersonal.luxianapp.BBDD.Modelo.Ciudad;
import com.dominiopersonal.luxianapp.R;
import com.dominiopersonal.luxianapp.mapas.Mapa;

import java.util.ArrayList;



public class CiudadAdapter extends RecyclerView.Adapter<CiudadAdapter.MyViewHolder> {

    Context context;
    ArrayList<Ciudad> ciudadArrayList;
    ArrayList<String> Nombre = new ArrayList<>();


    public CiudadAdapter(Context context, ArrayList<Ciudad> ciudadArrayList, ArrayList<String> Nombre) {
        this.context = context;
        this.ciudadArrayList = ciudadArrayList;
        this.Nombre = Nombre;
    }


    @NonNull
    @Override
    public CiudadAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.layout_horizontal_ciudades, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CiudadAdapter.MyViewHolder holder, int position) {

        Ciudad ciudad = ciudadArrayList.get(position);


        Glide.with(context)
                .asBitmap()
                .load(ciudad.getFoto())
                .into(holder.imagen_ciudad);

        holder.nombre_ciudad.setText(ciudad.getNombre());
        holder.descripcion.setText(ciudad.getDescripción());
        holder.imagen_ciudad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i = new Intent(view.getContext(), Mapa.class);

                i.putExtra("Latitud", ciudad.getLatitud());
                i.putExtra("Longitud", ciudad.getLongitud());
                i.putExtra("Nombre", ciudad.getNombre());

                context.startActivity(i);



            }
        });




    }

    @Override
    public int getItemCount() {
        return ciudadArrayList.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imagen_ciudad;
        TextView nombre_ciudad, descripcion;
        String Titulo;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imagen_ciudad = itemView.findViewById(R.id.imagen_ciudad);
            nombre_ciudad = itemView.findViewById(R.id.nombre_ciudad);
            descripcion = itemView.findViewById(R.id.descripcion);
        }
    }
}
