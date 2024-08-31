package com.utic.appdivina;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        num = (int) (Math.random() * 100001);
        String cadena = "Número generado: " + num;
        Toast notification = Toast.makeText(this, cadena, Toast.LENGTH_LONG);
        notification.show();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void controlar(View v) {
        String valorIngresado = et1.getText().toString();
        int valor = Integer.parseInt(valorIngresado);
        if (valor == num) {
            Toast notificacion = Toast.makeText(this, "Yupiii", Toast.LENGTH_LONG);
            notificacion.show();
        } else {
            Toast notificacion = Toast.makeText(this, "Nono, así no era", Toast.LENGTH_LONG);
            notificacion.show();
        }
    }
}