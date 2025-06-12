package com.example.mobileapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signinscreen extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btnLogin;
    TextView tvSignupLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signinscreen);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvSignupLink = findViewById(R.id.tvSignupLink);

        btnLogin.setOnClickListener(v -> {
            String username = etUsername.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Enter username and password", Toast.LENGTH_SHORT).show();
                return;
            }

            DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference("Users").child(username);
            dbRef.get().addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    DataSnapshot snapshot = task.getResult();
                    if (snapshot.exists()) {
                        String dbPassword = snapshot.child("password").getValue(String.class);
                        if (password.equals(dbPassword)) {
                            Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();

                            // Pass username to news screen
                            Intent intent = new Intent(signinscreen.this, newsscreen.class);
                            intent.putExtra("username", username);
                            startActivity(intent);

                            finish();
                        } else {
                            Toast.makeText(this, "Incorrect password", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(this, "User not found", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show();
                }
            });
        });

        tvSignupLink.setOnClickListener(v -> {
            startActivity(new Intent(signinscreen.this, signupscreen.class));
        });
    }
}
