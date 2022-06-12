package com.dominiopersonal.luxianapp.ui.favoritos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.dominiopersonal.luxianapp.databinding.FragmentFavoritosBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class FavoritosFragment extends Fragment {

    Button btnPruebasMapas;

    FirebaseFirestore firestore;

    Double latitud;
    Double longitud;

    private FragmentFavoritosBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        com.dominiopersonal.luxianapp.ui.favoritos.FavoritosViewModel favoritosViewModel =
                new ViewModelProvider(this).get(FavoritosViewModel.class);

        binding = FragmentFavoritosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        firestore = FirebaseFirestore.getInstance();

        // Obtener Datos

        firestore.collection("Plan").document("PlanSol").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    latitud = documentSnapshot.getDouble("Latitud");
                    longitud = documentSnapshot.getDouble("Longitud");
                }
            }
        });

        // Final Obtener Datos

        return root;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
