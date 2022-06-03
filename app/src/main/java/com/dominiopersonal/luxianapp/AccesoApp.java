package com.dominiopersonal.luxianapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AccesoApp extends AppCompatActivity {
    Button btn_acceso;
    TextView txt_recuperar, txt_crear;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acceso_app);

        btn_acceso = findViewById(R.id.btnAcceso);
        txt_recuperar = findViewById(R.id.txtRecuperacion);
        txt_crear = findViewById(R.id.txtCreacion);

        btn_acceso.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        txt_crear.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(),CrearCuenta.class);
                startActivity(intent);
            }
        });

        txt_recuperar.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent i = new Intent(AccesoApp.this,OlvidarContraseña.class);
                startActivity(i);
            }
        });


    }


}
