package com.dominiopersonal.luxianapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dominiopersonal.luxianapp.R;
import com.dominiopersonal.luxianapp.RecyclerViewAdapterCategorias;
import com.dominiopersonal.luxianapp.RecyclerViewAdapterCiudades;
import com.dominiopersonal.luxianapp.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    private ArrayList <String> Ciudad = new ArrayList<>();
    private ArrayList <String> ImagenCiudad = new ArrayList<>();
    private ArrayList <String> Descripcion = new ArrayList<>();
    private ArrayList <String> Boton = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        getImages();
        getImagesCiudad();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void getImages(){

        mImageUrls.add("");
        mNames.add("Arte");

        mImageUrls.add("");
        mNames.add("Comida");

        mImageUrls.add("");
        mNames.add("Deporte");

        mImageUrls.add("");
        mNames.add("Ocio");

        mImageUrls.add("");
        mNames.add("Aire libre");

        initRecyclerView();
    }

    private void initRecyclerView(){
        View root = binding.getRoot();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapterCategorias adapter = new RecyclerViewAdapterCategorias(mNames, mImageUrls, getContext());
        recyclerView.setAdapter(adapter);

    }

    private void getImagesCiudad(){
        Ciudad.add("Madrid");
        ImagenCiudad.add("");
        Descripcion.add("rfhjkfd gdfghjhjkfh jfdghjfhlf hfhjfdghj dfghjkdf");
        Boton.add("Más información");

        Ciudad.add("Toledo");
        ImagenCiudad.add("");
        Descripcion.add("hjufsd jdffgjff ghfghfghhjhjfhfj dghnjk fsdjksg");
        Boton.add("Más información");

        Ciudad.add("Barcelona");
        ImagenCiudad.add("");
        Descripcion.add("fghshusg jdfjkfjvfbhsrghj kseruhgjkrehguh ruksuarehghs urghsourg");
        Boton.add("Más información");

        initRecyclerViewCiudades();
    }

    private void initRecyclerViewCiudades(){
        View root = binding.getRoot();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = root.findViewById(R.id.recyclerViewCiudades);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapterCiudades adapter = new RecyclerViewAdapterCiudades(Ciudad, ImagenCiudad, Descripcion, Boton, getContext());
        recyclerView.setAdapter(adapter);

    }
}