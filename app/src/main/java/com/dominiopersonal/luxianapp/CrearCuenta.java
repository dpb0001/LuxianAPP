package com.dominiopersonal.luxianapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.firebase.auth.FirebaseAuth;

public class CrearCuenta extends AppCompatActivity {
    EditText etNombre, etApellidos, etCorreo, etContrasena, etContrasenaConf;
    Button btnCrear, btnCancelar;
    FirebaseAuth Autenticador;
    AwesomeValidation Validacion;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crear_cuenta);

        etNombre = findViewById(R.id.editTextNombre);
        etApellidos = findViewById(R.id.editTextApellidos);
        etCorreo = findViewById(R.id.editTextCorreo);
        etContrasena = findViewById(R.id.editTextContrasena);
        etContrasenaConf = findViewById(R.id.editTextConContrasena);

        btnCrear = findViewById(R.id.btnCrear);
        btnCancelar = findViewById(R.id.btnCancelar);

        Autenticador = FirebaseAuth.getInstance();
        Validacion = new AwesomeValidation(ValidationStyle.BASIC);





        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    private void Errores(String error) {

    }
}
