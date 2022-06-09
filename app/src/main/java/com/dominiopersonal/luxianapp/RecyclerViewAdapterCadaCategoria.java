package com.dominiopersonal.luxianapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapterCadaCategoria extends RecyclerView.Adapter<RecyclerViewAdapterCadaCategoria.ViewHolderCadaCategoria>{

    private ArrayList<String> ImagenCadaCategoria = new ArrayList<>();
    private ArrayList<String> NombreCiudadCategoria = new ArrayList<>();
    private  ArrayList<String> DescripcionCiudadCategoria = new ArrayList<>();
    private Context context;

    public RecyclerViewAdapterCadaCategoria(ArrayList<String> imagenCadaCategoria, ArrayList<String> nombreCiudadCategoria, ArrayList<String> descripcionCiudadCategoria, Context context) {
        ImagenCadaCategoria = imagenCadaCategoria;
        NombreCiudadCategoria = nombreCiudadCategoria;
        DescripcionCiudadCategoria = descripcionCiudadCategoria;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolderCadaCategoria onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_cada_categoria, parent, false);
        ViewHolderCadaCategoria holderCadaCategoria = new ViewHolderCadaCategoria(view);
        return holderCadaCategoria;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderCadaCategoria holder, int position) {

        Glide.with(context)
                .asBitmap()
                .load(ImagenCadaCategoria.get(position))
                .into(holder.imagenCadaCategoria);

        holder.nombreCiudadCategoria.setText(NombreCiudadCategoria.get(position));
        holder.descripcionCiudadCategoria.setText(DescripcionCiudadCategoria.get(position));

        holder.parent_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return NombreCiudadCategoria.size();
    }

    public class ViewHolderCadaCategoria extends RecyclerView.ViewHolder{

        CircleImageView imagenCadaCategoria;
        TextView nombreCiudadCategoria;
        TextView descripcionCiudadCategoria;
        RecyclerView parent_layout;

        public ViewHolderCadaCategoria(@NonNull View itemView) {
            super(itemView);

            imagenCadaCategoria = itemView.findViewById(R.id.imagen_cada_categoria);
            nombreCiudadCategoria = itemView.findViewById(R.id.nombre_cada_categoria);
            descripcionCiudadCategoria = itemView.findViewById(R.id.descripcion_cada_categoria);
            parent_layout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
