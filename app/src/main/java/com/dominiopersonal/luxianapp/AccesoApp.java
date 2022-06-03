package com.dominiopersonal.luxianapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class AccesoApp extends AppCompatActivity {
    Button btn_acceso;
    TextView txt_recuperar, txt_crear;
    EditText etCorreo, etContrasena;

    Intent intent;

    AwesomeValidation validacion;
    FirebaseAuth autenticador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acceso_app);

        btn_acceso = findViewById(R.id.btnAcceso);

        txt_crear = findViewById(R.id.txtCreacion);
        txt_recuperar = findViewById(R.id.txtRecuperacion);


        autenticador = FirebaseAuth.getInstance();
        validacion = new AwesomeValidation(ValidationStyle.BASIC);
        validacion.addValidation(this,R.id.editTextCorreoAcceso, Patterns.EMAIL_ADDRESS,R.string.correo_incorrecto);
        validacion.addValidation(this,R.id.editTextContrasenaAcceso,".{6,}",R.string.contraseña_incorrecta);

        FirebaseAuth automatico = FirebaseAuth.getInstance();
        FirebaseUser usuario = automatico.getCurrentUser();

        if (usuario != null){
            irainicio();
        }

        etCorreo = findViewById(R.id.editTextCorreoAcceso);
        etContrasena = findViewById(R.id.editTextContrasenaAcceso);


        btn_acceso.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if(validacion.validate()){
                    String email = etCorreo.getText().toString();
                    String contrasena = etContrasena.getText().toString();

                    autenticador.signInWithEmailAndPassword(email, contrasena).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            //Se comprueba si se hizo login correctamente
                            if(task.isSuccessful()) {
                                irainicio();
                            } else {
                                String errorCode = ((FirebaseAuthException) Objects.requireNonNull(task.getException())).getErrorCode();
                                Errores(errorCode);
                            }
                        }
                    });
                }
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

    private void irainicio() {
        Intent i = new Intent(this,MainActivity.class);
        i.putExtra("email",etCorreo.getText().toString());
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }

    private void Errores(String error) {

        switch (error) {

            case "ERROR_INVALID_CUSTOM_TOKEN":
                Toast.makeText(AccesoApp.this, "El formato del token personalizado es incorrecto. Por favor revise la documentación", Toast.LENGTH_LONG).show();
                break;

            case "ERROR_CUSTOM_TOKEN_MISMATCH":
                Toast.makeText(AccesoApp.this, "El token personalizado corresponde a una audiencia diferente.", Toast.LENGTH_LONG).show();
                break;

            case "ERROR_INVALID_CREDENTIAL":
                Toast.makeText(AccesoApp.this, "La credencial de autenticación proporcionada tiene un formato incorrecto o ha caducado.", Toast.LENGTH_LONG).show();
                break;

            case "ERROR_INVALID_EMAIL":
                Toast.makeText(AccesoApp.this, "La dirección de correo electrónico está mal formateada.", Toast.LENGTH_LONG).show();
                etCorreo.setError("La dirección de correo electrónico está mal formateada.");
                etCorreo.requestFocus();
                break;

            case "ERROR_WRONG_PASSWORD":
                Toast.makeText(AccesoApp.this, "La contraseña no es válida o el usuario no tiene contraseña.", Toast.LENGTH_LONG).show();
                etContrasena.setError("la contraseña es incorrecta ");
                etContrasena.requestFocus();
                etContrasena.setText("");
                break;

            case "ERROR_USER_MISMATCH":
                Toast.makeText(AccesoApp.this, "Las credenciales proporcionadas no corresponden al usuario que inició sesión anteriormente..", Toast.LENGTH_LONG).show();
                break;

            case "ERROR_REQUIRES_RECENT_LOGIN":
                Toast.makeText(AccesoApp.this,"Esta operación es sensible y requiere autenticación reciente. Inicie sesión nuevamente antes de volver a intentar esta solicitud.", Toast.LENGTH_LONG).show();
                break;

            case "ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL":
                Toast.makeText(AccesoApp.this, "Ya existe una cuenta con la misma dirección de correo electrónico pero diferentes credenciales de inicio de sesión. Inicie sesión con un proveedor asociado a esta dirección de correo electrónico.", Toast.LENGTH_LONG).show();
                break;

            case "ERROR_EMAIL_ALREADY_IN_USE":
                Toast.makeText(AccesoApp.this, "La dirección de correo electrónico ya está siendo utilizada por otra cuenta..   ", Toast.LENGTH_LONG).show();
                etCorreo.setError("La dirección de correo electrónico ya está siendo utilizada por otra cuenta.");
                etCorreo.requestFocus();
                break;

            case "ERROR_CREDENTIAL_ALREADY_IN_USE":
                Toast.makeText(AccesoApp.this, "Esta credencial ya está asociada con una cuenta de usuario diferente.", Toast.LENGTH_LONG).show();
                break;

            case "ERROR_USER_DISABLED":
                Toast.makeText(AccesoApp.this, "La cuenta de usuario ha sido inhabilitada por un administrador..", Toast.LENGTH_LONG).show();
                break;

            case "ERROR_USER_TOKEN_EXPIRED":
                Toast.makeText(AccesoApp.this, "La credencial del usuario ya no es válida. El usuario debe iniciar sesión nuevamente.", Toast.LENGTH_LONG).show();
                break;

            case "ERROR_USER_NOT_FOUND":
                Toast.makeText(AccesoApp.this, "No hay ningún registro de usuario que corresponda a este identificador. Es posible que se haya eliminado al usuario.", Toast.LENGTH_LONG).show();
                break;



            case "ERROR_OPERATION_NOT_ALLOWED":
                Toast.makeText(AccesoApp.this, "Esta operación no está permitida. Debes habilitar este servicio en la consola.", Toast.LENGTH_LONG).show();
                break;

            case "ERROR_WEAK_PASSWORD":
                Toast.makeText(AccesoApp.this, "La contraseña proporcionada no es válida..", Toast.LENGTH_LONG).show();
                etContrasena.setError("La contraseña no es válida, debe tener al menos 6 caracteres");
                etContrasena.requestFocus();
                break;

        }

    }


}
