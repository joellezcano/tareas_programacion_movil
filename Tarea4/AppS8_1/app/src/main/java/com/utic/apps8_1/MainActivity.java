package com.utic.apps8_1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etNombre,etApellido,etDomicilio,etCiudad,etPais,etTelefono,etPostal,etEmail;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etNombre=(EditText) findViewById(R.id.etNombre);
        etApellido=(EditText) findViewById(R.id.etApellido);
        etDomicilio=(EditText) findViewById(R.id.etDomicilio);
        etCiudad=(EditText) findViewById(R.id.etCiudad);
        etPais=(EditText) findViewById(R.id.etPais);
        etTelefono=(EditText) findViewById(R.id.etTelMovil);
        etPostal=(EditText) findViewById(R.id.etCPostal);
        etEmail=(EditText) findViewById(R.id.etEmail);
        btnEnviar=(Button) findViewById(R.id.btnEnviar);

        //controlar eventos
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //validacion
                if (validar(etNombre)&&validar(etApellido)&&validar(etDomicilio)&&validar(etCiudad)
                        &&validar(etPais)&&validar(etTelefono)&&validar(etPostal)&&validar(etEmail)){
                    Toast.makeText(getApplicationContext(),"Registro Exitoso!", Toast.LENGTH_LONG).show();
                } else{

                }
            }
        });
    }

    public boolean validar(EditText campo){
        //verificar contenido del campo (elemento view)
        if (campo.getText().toString().trim().length()<1){
            campo.setError("Favor completar datos!");
            campo.requestFocus();
            return false;
        } else{
            return true;
        }
    }
}