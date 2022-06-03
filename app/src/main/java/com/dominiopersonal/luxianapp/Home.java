package com.dominiopersonal.luxianapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Home extends AppCompatActivity {
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);

        getImages();
    }

    private void getImages(){
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
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls);
        recyclerView.setAdapter(adapter);



    }

}
