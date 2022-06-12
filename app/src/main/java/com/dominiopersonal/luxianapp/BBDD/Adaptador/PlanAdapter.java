package com.dominiopersonal.luxianapp.BBDD.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dominiopersonal.luxianapp.BBDD.Modelo.Plan;
import com.dominiopersonal.luxianapp.R;

import java.util.ArrayList;

public class PlanAdapter extends RecyclerView.Adapter<PlanAdapter.MyViewHolder> {

    Context context;
    ArrayList<Plan> planArrayList;

    public PlanAdapter(Context context, ArrayList<Plan> ciudadArrayList) {
        this.context = context;
        this.planArrayList = planArrayList;
    }

    @NonNull
    @Override
    public PlanAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.layout_cada_lugar, parent, false);

        return new PlanAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanAdapter.MyViewHolder holder, int position) {

        Plan plan = planArrayList.get(position);

        holder.titulo_plan.setText(plan.getNombre());
        holder.descripcion_plan.setText(plan.getDescripción());
        holder.precio_plan.setText(plan.getPrecio());
        holder.tiempo_plan.setText(plan.getTiempo().toString());





    }

    @Override
    public int getItemCount() {
        return planArrayList.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {


        TextView titulo_plan, descripcion_plan, precio_plan, tiempo_plan;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            titulo_plan = itemView.findViewById(R.id.nombre_lugar);
            descripcion_plan = itemView.findViewById(R.id.descripcion_lugar);
            precio_plan = itemView.findViewById(R.id.tiempo);
            tiempo_plan = itemView.findViewById(R.id.precio);

        }
    }



}
