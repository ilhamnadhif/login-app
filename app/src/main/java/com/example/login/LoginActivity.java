package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {
        String username = editTextUsername.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Mohon masukkan username dan password", Toast.LENGTH_SHORT).show();
            return;
        }

        // Here you would typically validate the credentials against a database or API
        // For this example, we'll just proceed with the login
        Toast.makeText(this, "Login berhasil!", Toast.LENGTH_SHORT).show();

        // Navigate to HomeActivity
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        intent.putExtra("USERNAME", username);
        startActivity(intent);
        finish(); // Close LoginActivity so user can't go back to it with back button
    }
}