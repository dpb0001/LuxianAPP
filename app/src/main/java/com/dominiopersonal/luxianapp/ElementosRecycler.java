package com.dominiopersonal.luxianapp;
import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ElementosRecycler implements RecyclerView.OnItemTouchListener {
    private ClickListener clickListener;
    private GestureDetector gestureDetector;

    public ElementosRecycler(Context contexto, final RecyclerView recyclerView, final ClickListener clickListener) {
        this.clickListener = clickListener;
        this.gestureDetector = new GestureDetector(contexto, new GestureDetector.SimpleOnGestureListener() {

            // Comprobamos si el usuario ha pulsado un click en algún elemento del Recycler
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

            // Comprobamos si el usuario ha mantenido el dedo en alguno de los elementos del Recycler
            @Override
            public void onLongPress(MotionEvent e) {
                View posicion = recyclerView.findChildViewUnder(e.getX(), e.getY());
                if (posicion != null && clickListener != null) {
                    clickListener.onLongClick(posicion, recyclerView.getChildPosition(posicion));
                }
            }
        });
    }

    // Comprobamos donde ha pulsado el usuario
    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        View posicion = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
        if (posicion != null && clickListener != null && gestureDetector.onTouchEvent(motionEvent)) {
            clickListener.onClick(posicion, recyclerView.getChildAdapterPosition(posicion));
        }
        return false;
    }

    @Override
    public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    public interface ClickListener {
        void onClick(View view, int posicion);

        void onLongClick(View view, int posicion);
    }

}
