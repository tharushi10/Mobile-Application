package com.example.mobileapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class signupscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signupscreen);

        // Apply window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 🔗 Navigate to login screen
        TextView loginText = findViewById(R.id.textView);
        loginText.setOnClickListener(v -> {
            Intent intent = new Intent(signupscreen.this, signinscreen.class);
            startActivity(intent);
            finish();
        });

        // ✅ Navigate to news screen when sign-up button is clicked
        Button signupButton = findViewById(R.id.btnLogin);
        signupButton.setOnClickListener(v -> {
            Intent intent = new Intent(signupscreen.this, newsscreen.class);
            startActivity(intent);
            finish(); // Optional: close signup screen
        });
    }
}
