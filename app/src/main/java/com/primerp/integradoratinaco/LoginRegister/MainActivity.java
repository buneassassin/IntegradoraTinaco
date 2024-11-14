package com.primerp.integradoratinaco.LoginRegister;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.primerp.integradoratinaco.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onRegistrationPromptClick(View view) {
        // Lógica para redirigir a la pantalla de registro
        Intent intent = new Intent(this, Registrar.class);
        startActivity(intent);
    }
}