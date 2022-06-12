package com.dominiopersonal.luxianapp.BBDD.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dominiopersonal.luxianapp.BBDD.Modelo.Ruta;
import com.dominiopersonal.luxianapp.R;

import java.util.ArrayList;

public class RutaAdapter  extends RecyclerView.Adapter<RutaAdapter.MyViewHolder> {

    Context context;
    ArrayList<Ruta> rutaArrayList;

    public RutaAdapter(Context context, ArrayList<Ruta> rutaArrayList) {
        this.context = context;
        this.rutaArrayList = rutaArrayList;
    }

    @NonNull
    @Override
    public RutaAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.layout_cada_lugar, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RutaAdapter.MyViewHolder holder, int position) {

        Ruta ruta = rutaArrayList.get(position);

        holder.titulo_ruta.setText(ruta.getTítulo());
        holder.descripcion_ruta.setText(ruta.getDescripción());
        holder.precio_ruta.setText(ruta.getPrecio());
        /*
        holder.tiempo_plan.setText(ruta.getTiempo_Medio().toString());

         */





    }

    @Override
    public int getItemCount() {
        return rutaArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {


        TextView titulo_ruta, descripcion_ruta, precio_ruta, tiempo_ruta;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            titulo_ruta = itemView.findViewById(R.id.nombre_lugar);
            descripcion_ruta = itemView.findViewById(R.id.descripcion_lugar);
            precio_ruta = itemView.findViewById(R.id.tiempo);
            /*
            tiempo_ruta = itemView.findViewById(R.id.precio);

             */

        }
    }
}
