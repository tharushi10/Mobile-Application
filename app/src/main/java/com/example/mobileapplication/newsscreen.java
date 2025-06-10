package com.example.mobileapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class newsscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_newsscreen);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Profile icon click → go to user info screen
        ImageView profileIcon = findViewById(R.id.imageView6);
        profileIcon.setOnClickListener(v -> {
            Intent intent = new Intent(newsscreen.this, userinformationscreen.class);
            startActivity(intent);
        });

        // Convocation image and "Read more" text → go to news details screen
        ImageView convocationImage = findViewById(R.id.imageView8);
        TextView readMoreText = findViewById(R.id.textView5);

        View.OnClickListener goToNewsDetails = v -> {
            Intent intent = new Intent(newsscreen.this, newsdetailsscreen.class);
            startActivity(intent);
        };

        convocationImage.setOnClickListener(goToNewsDetails);
        readMoreText.setOnClickListener(goToNewsDetails);

        // Error icon click → go to developer information screen
        ImageView errorIcon = findViewById(R.id.imageView7);
        errorIcon.setOnClickListener(v -> {
            Intent intent = new Intent(newsscreen.this, developerinformationscreen.class);
            startActivity(intent);
        });
    }
}
