package com.dominiopersonal.luxianapp.BBDD.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dominiopersonal.luxianapp.BBDD.Modelo.Ciudad;
import com.dominiopersonal.luxianapp.R;
import com.dominiopersonal.luxianapp.ui.home.HomeFragment;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class CiudadAdapter extends RecyclerView.Adapter<CiudadAdapter.MyViewHolder> {

    Context context;
    ArrayList<Ciudad> ciudadArrayList;

    public CiudadAdapter(Context context, ArrayList<Ciudad> ciudadArrayList) {
        this.context = context;
        this.ciudadArrayList = ciudadArrayList;
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

        holder.nombre_ciudad.setText(ciudad.getNombre());
        holder.descripcion.setText(ciudad.getDescripción());


    }

    @Override
    public int getItemCount() {
        return ciudadArrayList.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        CircleImageView imagen_ciudad;
        TextView nombre_ciudad, descripcion;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imagen_ciudad = itemView.findViewById(R.id.imagen_ciudad);
            nombre_ciudad = itemView.findViewById(R.id.nombre_ciudad);
            descripcion = itemView.findViewById(R.id.descripcion);
        }
    }
}
