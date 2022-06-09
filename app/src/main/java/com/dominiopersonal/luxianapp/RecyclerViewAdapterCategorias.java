package com.dominiopersonal.luxianapp;

import android.annotation.SuppressLint;
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
import com.dominiopersonal.luxianapp.Categorias.AireLibre2;
import com.dominiopersonal.luxianapp.Categorias.Arte2;
import com.dominiopersonal.luxianapp.Categorias.Deporte2;
import com.dominiopersonal.luxianapp.Categorias.Gastronomia2;
import com.dominiopersonal.luxianapp.Categorias.Ocio2;

import java.util.ArrayList;

public class RecyclerViewAdapterCategorias extends RecyclerView.Adapter<RecyclerViewAdapterCategorias.ViewHolder>{

    private ArrayList<String> NomCategoria = new ArrayList<>();
    private ArrayList<String> ImgCategoria = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapterCategorias(ArrayList<String> names, ArrayList<String> imageUrls, Context context){
        NomCategoria = names;
        ImgCategoria = imageUrls;
        mContext = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_horizontal_categorias, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Glide.with(mContext)
                .asBitmap()
                .load(ImgCategoria.get(position))
                .into(holder.image);

        holder.name.setText(NomCategoria.get(position));

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NomCategoria.get(position);
                if (position == 0){
                    Intent intent = new Intent(view.getContext(), Arte2.class);
                    mContext.startActivity(intent);
                }else if (position == 1){
                    Intent intent = new Intent(view.getContext(), Gastronomia2.class);
                    mContext.startActivity(intent);

                }else if (position == 2){
                    Intent intent = new Intent(view.getContext(), Deporte2.class);
                    mContext.startActivity(intent);

                }else if (position == 3){
                    Intent intent = new Intent(view.getContext(), Ocio2.class);
                    mContext.startActivity(intent);

                }else if (position == 4){
                    Intent intent = new Intent(view.getContext(), AireLibre2.class);
                    mContext.startActivity(intent);

                }

                //Toast.makeText(mContext,mNames.get(position), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return NomCategoria.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name;

        public ViewHolder(View itemView){
            super(itemView);
            image = itemView.findViewById(R.id.imagen_categoria);
            name = itemView.findViewById(R.id.nombre_categoria);

        }
    }
}
