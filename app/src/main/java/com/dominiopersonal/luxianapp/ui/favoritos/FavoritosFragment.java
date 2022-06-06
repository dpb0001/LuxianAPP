package com.dominiopersonal.luxianapp.ui.favoritos;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.dominiopersonal.luxianapp.AccesoApp;
import com.dominiopersonal.luxianapp.Mapa;
import com.dominiopersonal.luxianapp.R;
import com.dominiopersonal.luxianapp.databinding.FragmentFavoritosBinding;
import com.google.firebase.auth.FirebaseAuth;

public class FavoritosFragment extends Fragment {

    Button btnPruebasMapas;

    private FragmentFavoritosBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        com.dominiopersonal.luxianapp.ui.favoritos.FavoritosViewModel favoritosViewModel =
                new ViewModelProvider(this).get(FavoritosViewModel.class);

        binding = FragmentFavoritosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        btnPruebasMapas = root.findViewById(R.id.btnPruebaMapas);

        btnPruebasMapas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), Mapa.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);

            }
        });




        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
