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

    //Se crean los ArrayList para poder añadir la información de las categorías y las ciudades más visitadas

    private FragmentHomeBinding binding;
    private ArrayList<String> NomCategoria = new ArrayList<>();
    private ArrayList<String> ImgCategoria = new ArrayList<>();

    private ArrayList <String> Ciudad = new ArrayList<>();
    private ArrayList <String> ImagenCiudad = new ArrayList<>();
    private ArrayList <String> Descripcion = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //Añadiendo las informaciones a la interfaz
        getImages();
        getImagesCiudad();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    //Insertando la información a los Arraylist de las categorias
    private void getImages(){

        ImgCategoria.add("https://as2.ftcdn.net/v2/jpg/00/65/29/23/1000_F_65292379_4OV8BivNZ8hXfWphx7yS1gNiRMiORmRL.jpg");
        NomCategoria.add("Arte");

        ImgCategoria.add("https://i.pinimg.com/736x/de/75/ce/de75ce81f9cc8651b33fdc44985c8eac.jpg");
        NomCategoria.add("Gastronomia");

        ImgCategoria.add("https://img.freepik.com/vector-gratis/plantilla-logo-deporte-forma-abstracta_23-2148228932.jpg?w=2000");
        NomCategoria.add("Deporte");

        ImgCategoria.add("data:image/png;base64,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");
        NomCategoria.add("Ocio");

        ImgCategoria.add("https://img.freepik.com/vector-gratis/camping-al-aire-libre-logo-icono-vector-concepto-retro-ilustracion-diseno_557439-457.jpg?w=2000");
        NomCategoria.add("Aire libre");

        //Añadiendo la información al RecyclerView
        initRecyclerView();
    }

    //Asignando el RecyclerView al cual ira la información
    private void initRecyclerView(){
        View root = binding.getRoot();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapterCategorias adapter = new RecyclerViewAdapterCategorias(NomCategoria, ImgCategoria, getContext());
        recyclerView.setAdapter(adapter);

    }

    //Insertando la información a los Arraylist de las ciudades más visitadas
    private void getImagesCiudad(){
        Ciudad.add("Madrid");
        ImagenCiudad.add("data:image/png;base64,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");
        Descripcion.add("rfhjkfd gdfghjhjkfh jfdghjfhl\nf hfhjfdghj dfghjkdf");

        Ciudad.add("Toledo");
        ImagenCiudad.add("https://w7.pngwing.com/pngs/862/58/png-transparent-fourth-council-of-toledo-flag-coat-of-arms-of-toledo-ayuntamiento-de-toledo-flag-miscellaneous-flag-logo.png");
        Descripcion.add("hjufsd jdffgjff ghfghfghhjhjfhfj dghnjk fsdjksg");

        Ciudad.add("Barcelona");
        ImagenCiudad.add("https://upload.wikimedia.org/wikipedia/commons/thumb/8/88/Bandera_de_Barcelona_Sporting_Club.png/2560px-Bandera_de_Barcelona_Sporting_Club.png");
        Descripcion.add("fghshusg jdfjkfjvfbhsrghj kseruhgjkrehguh ruksuarehghs urghsourg");

        Ciudad.add("Sevilla");
        ImagenCiudad.add("https://www.dipusevilla.es/export/sites/diputacion-sevilla-corporativo/.galleries/IMAGENES-Contenido-general/bandera.jpg");
        Descripcion.add("sdfdfgdfgfgfdgdfgggfgdrfdgdfddg");

        //Añadiendo la información al RecyclerView
        initRecyclerViewCiudades();
    }

    //Asignando el RecyclerView al cual ira la información
    private void initRecyclerViewCiudades(){
        View root = binding.getRoot();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = root.findViewById(R.id.recyclerViewCiudades);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapterCiudades adapter = new RecyclerViewAdapterCiudades(Ciudad, ImagenCiudad, Descripcion, getContext());
        recyclerView.setAdapter(adapter);

    }
}