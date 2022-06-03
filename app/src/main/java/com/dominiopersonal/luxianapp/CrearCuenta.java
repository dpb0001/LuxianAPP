package com.dominiopersonal.luxianapp;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

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

        Validacion.addValidation(this,R.id.editTextNombre,".(4,)",R.string.nombre_incorrecto);
        Validacion.addValidation(this,R.id.editTextApellidos,".(4,)",R.string.apellido_incorrecto);
        Validacion.addValidation(this,R.id.editTextCorreo, Patterns.EMAIL_ADDRESS,R.string.correo_incorrecto);
        Validacion.addValidation(this,R.id.editTextContrasenaAcceso,".(6,)",R.string.contraseña_incorrecta);





        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nombre = etNombre.getText().toString();
                String apellidos = etApellidos.getText().toString();
                String email = etCorreo.getText().toString();
                String contrasena = etContrasena.getText().toString();
                String valcontrasena = etContrasenaConf.getText().toString();

                if(R.id.editTextConContrasena != R.id.editTextContrasenaAcceso){
                    Toast.makeText(CrearCuenta.this,"Es necesario que coincidan las contraseñas", Toast.LENGTH_SHORT).show();
                } else if (Validacion.validate()){
                    Autenticador.createUserWithEmailAndPassword(email,contrasena).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(CrearCuenta.this,"Usuario creado con éxito", Toast.LENGTH_SHORT).show();
                                finish();
                            } else {
                                String errorCode = ((FirebaseAuthException) task.getException()).getErrorCode();
                                Errores(errorCode);
                            }
                        }
                    });
                } else {
                    Toast.makeText(CrearCuenta.this,"Es necesario que completes los datos", Toast.LENGTH_SHORT).show();

                }


            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void Errores(String error) {

        switch (error) {

            case "ERROR_INVALID_CUSTOM_TOKEN":
                Toast.makeText(CrearCuenta.this, "El formato del token personalizado es incorrecto. Por favor revise la documentación", Toast.LENGTH_LONG).show();
                break;

            case "ERROR_CUSTOM_TOKEN_MISMATCH":
                Toast.makeText(CrearCuenta.this, "El token personalizado corresponde a una audiencia diferente.", Toast.LENGTH_LONG).show();
                break;

            case "ERROR_INVALID_CREDENTIAL":
                Toast.makeText(CrearCuenta.this, "La credencial de autenticación proporcionada tiene un formato incorrecto o ha caducado.", Toast.LENGTH_LONG).show();
                break;

            case "ERROR_INVALID_EMAIL":
                Toast.makeText(CrearCuenta.this, "La dirección de correo electrónico está mal formateada.", Toast.LENGTH_LONG).show();
                etCorreo.setError("La dirección de correo electrónico está mal formateada.");
                etCorreo.requestFocus();
                break;

            case "ERROR_WRONG_PASSWORD":
                Toast.makeText(CrearCuenta.this, "La contraseña no es válida o el usuario no tiene contraseña.", Toast.LENGTH_LONG).show();
                etContrasena.setError("la contraseña es incorrecta ");
                etContrasena.requestFocus();
                etContrasena.setText("");
                break;

            case "ERROR_USER_MISMATCH":
                Toast.makeText(CrearCuenta.this, "Las credenciales proporcionadas no corresponden al usuario que inició sesión anteriormente..", Toast.LENGTH_LONG).show();
                break;

            case "ERROR_REQUIRES_RECENT_LOGIN":
                Toast.makeText(CrearCuenta.this,"Esta operación es sensible y requiere autenticación reciente. Inicie sesión nuevamente antes de volver a intentar esta solicitud.", Toast.LENGTH_LONG).show();
                break;

            case "ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL":
                Toast.makeText(CrearCuenta.this, "Ya existe una cuenta con la misma dirección de correo electrónico pero diferentes credenciales de inicio de sesión. Inicie sesión con un proveedor asociado a esta dirección de correo electrónico.", Toast.LENGTH_LONG).show();
                break;

            case "ERROR_EMAIL_ALREADY_IN_USE":
                Toast.makeText(CrearCuenta.this, "La dirección de correo electrónico ya está siendo utilizada por otra cuenta..   ", Toast.LENGTH_LONG).show();
                etCorreo.setError("La dirección de correo electrónico ya está siendo utilizada por otra cuenta.");
                etCorreo.requestFocus();
                break;

            case "ERROR_CREDENTIAL_ALREADY_IN_USE":
                Toast.makeText(CrearCuenta.this, "Esta credencial ya está asociada con una cuenta de usuario diferente.", Toast.LENGTH_LONG).show();
                break;

            case "ERROR_USER_DISABLED":
                Toast.makeText(CrearCuenta.this, "La cuenta de usuario ha sido inhabilitada por un administrador..", Toast.LENGTH_LONG).show();
                break;

            case "ERROR_USER_TOKEN_EXPIRED":
                Toast.makeText(CrearCuenta.this, "La credencial del usuario ya no es válida. El usuario debe iniciar sesión nuevamente.", Toast.LENGTH_LONG).show();
                break;

            case "ERROR_USER_NOT_FOUND":
                Toast.makeText(CrearCuenta.this, "No hay ningún registro de usuario que corresponda a este identificador. Es posible que se haya eliminado al usuario.", Toast.LENGTH_LONG).show();
                break;

            case "ERROR_INVALID_USER_TOKEN":
                Toast.makeText(CrearCuenta.this, "La credencial del usuario ya no es válida. El usuario debe iniciar sesión nuevamente.", Toast.LENGTH_LONG).show();
                break;

            case "ERROR_OPERATION_NOT_ALLOWED":
                Toast.makeText(CrearCuenta.this, "Esta operación no está permitida. Debes habilitar este servicio en la consola.", Toast.LENGTH_LONG).show();
                break;

            case "ERROR_WEAK_PASSWORD":
                Toast.makeText(CrearCuenta.this, "La contraseña proporcionada no es válida..", Toast.LENGTH_LONG).show();
                etContrasena.setError("La contraseña no es válida, debe tener al menos 6 caracteres");
                etContrasena.requestFocus();
                break;

        }

    }
}
