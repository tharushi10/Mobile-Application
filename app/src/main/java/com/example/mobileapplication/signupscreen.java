package com.example.mobileapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signupscreen extends AppCompatActivity {

    EditText etUsername1, etPassword2, etPassword, etEmail;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupscreen);

        etUsername1 = findViewById(R.id.etUsername1); // username
        etPassword2 = findViewById(R.id.etPassword2); // password
        etPassword = findViewById(R.id.etPassword);   // confirm password
        etEmail = findViewById(R.id.etUsername);      // email
        btnLogin = findViewById(R.id.btnLogin);       // sign up button

        btnLogin.setOnClickListener(v -> {
            String username = etUsername1.getText().toString().trim();
            String password = etPassword2.getText().toString().trim();
            String confirmPassword = etPassword.getText().toString().trim();
            String email = etEmail.getText().toString().trim();

            if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!password.equals(confirmPassword)) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                return;
            }

            DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference("Users");
            user user = new user(username, password, email);

            dbRef.child(username).setValue(user).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    Toast.makeText(this, "Sign up successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this, signinscreen.class));
                    finish();
                } else {
                    Toast.makeText(this, "Sign up failed", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}
