package com.primerp.integradoratinaco.LoginRegister;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.primerp.integradoratinaco.LoginRegister.Cosas.Api.ApiService;
import com.primerp.integradoratinaco.LoginRegister.Cosas.Responst.RegisterRequest;
import com.primerp.integradoratinaco.LoginRegister.Cosas.Responst.RegisterResponse;
import com.primerp.integradoratinaco.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Registrar extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private EditText emailEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        // Inicializando las vistas
        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        emailEditText = findViewById(R.id.email);
    }

    public void onRegisterClick(View view) {
        // Obtener los datos del formulario
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String email = emailEditText.getText().toString();

        if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
            Toast.makeText(this, "Por favor complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        // Crear el objeto de solicitud para el registro
        RegisterRequest registerRequest = new RegisterRequest(username, password, email);

        // Configurar Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://tudominio.com/api/") // URL base de tu API de Adonis
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        // Hacer la solicitud de registro
        Call<RegisterResponse> call = apiService.registerUser(registerRequest);
        call.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if (response.isSuccessful()) {
                    RegisterResponse registerResponse = response.body();
                    if (registerResponse != null && registerResponse.isSuccess()) {
                        Toast.makeText(Registrar.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                        // Redirigir a la pantalla de inicio de sesión
                        Intent intent = new Intent(Registrar.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Registrar.this, "Error en el registro: " + registerResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Registrar.this, "Error en la respuesta de la API", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Toast.makeText(Registrar.this, "Error de conexión: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onLoginPromptClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
