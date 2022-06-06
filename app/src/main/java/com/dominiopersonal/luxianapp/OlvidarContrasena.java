package com.dominiopersonal.luxianapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class OlvidarContrasena extends AppCompatActivity {
    EditText recuperarEmail;
    Button btnRecuperar, btnCancelar;
    ProgressDialog progress;
    FirebaseAuth Autenticador;
    String correo;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.olvidar_contrasena);

        recuperarEmail = findViewById(R.id.editTextEmailRecuperar);
        btnCancelar = findViewById(R.id.btnCancelarRec);
        btnRecuperar = findViewById(R.id.btnRecuperar);

        Autenticador = FirebaseAuth.getInstance();

        progress = new ProgressDialog(this);

        getRecuperar();

    }


    public void getRecuperar() {
        recuperarEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                correo = recuperarEmail.getText().toString().trim();
                if(!correo.isEmpty()){
                    progress.setMessage("Espere un momento...");
                    progress.setCanceledOnTouchOutside(false);
                    progress.show();
                    getEnviarCorreo();
                }else {
                    Toast.makeText(OlvidarContrasena.this, "El correo no se pudo Enviar", Toast.LENGTH_LONG).show();

                }




            }
        });
        btnCancelar.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void getEnviarCorreo() {
            Autenticador.setLanguageCode("es");
            Autenticador.sendPasswordResetEmail(correo).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(OlvidarContrasena.this, "Acceda a su correo para poder recuperar su contraseña", Toast.LENGTH_LONG).show();
                        finish();

                    }
                }
            });

        }


}
