package com.dominiopersonal.luxianapp.ui.perfil;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.dominiopersonal.luxianapp.AccesoApp;
import com.dominiopersonal.luxianapp.R;
import com.dominiopersonal.luxianapp.databinding.FragmentPerfilBinding;
import com.google.firebase.auth.FirebaseAuth;

public class PerfilFragment extends Fragment {

    private FragmentPerfilBinding binding;

    Button btnDesconectar;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PerfilViewModel perfilViewModel =
                new ViewModelProvider(this).get(PerfilViewModel.class);



        binding = FragmentPerfilBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        btnDesconectar = root.findViewById(R.id.btn_desconectar);

        btnDesconectar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(getContext(), "Sesión cerrada", Toast.LENGTH_SHORT).show();
                irloging();
            }
        });


        return root;
    }

    private void irloging() {
        Intent i = new Intent(getContext(), AccesoApp.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}