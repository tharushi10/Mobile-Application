package com.example.mobileapplication;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class userinformationscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_userinformationscreen);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Back icon listener
        findViewById(R.id.imageView14).setOnClickListener(v -> {
            Intent intent = new Intent(userinformationscreen.this, newsscreen.class);
            startActivity(intent);
            finish();
        });

        // Edit info button listener
        findViewById(R.id.btnLogin).setOnClickListener(v -> showEditInfoDialog());

        // Sign out button listener
        Button signOutButton = findViewById(R.id.btn_sign_out);
        if (signOutButton != null) {
            signOutButton.setOnClickListener(v -> showSignOutDialog());
        }
    }

    private void showEditInfoDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(userinformationscreen.this);

        // Title TextView centered
        TextView title = new TextView(this);
        title.setText("EDIT");
        title.setTextSize(20);
        title.setTypeface(Typeface.create("sans-serif", Typeface.BOLD));
        title.setGravity(Gravity.CENTER);
        title.setPadding(0, 40, 0, 10);
        title.setTextColor(Color.BLACK);

        // Container layout
        LinearLayout container = new LinearLayout(this);
        container.setOrientation(LinearLayout.VERTICAL);
        container.setPadding(40, 0, 40, 0);

        container.addView(title);

        // Username EditText
        final EditText inputUsername = new EditText(this);
        inputUsername.setHint("Username");
        inputUsername.setSingleLine(true);
        inputUsername.setPadding(20, 30, 20, 30);
        inputUsername.setTextColor(Color.BLACK);
        inputUsername.setBackgroundResource(android.R.drawable.edit_text);
        container.addView(inputUsername);

        // Password EditText
        final EditText inputPassword = new EditText(this);
        inputPassword.setHint("Password");
        inputPassword.setSingleLine(true);
        inputPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        inputPassword.setPadding(20, 30, 20, 30);
        inputPassword.setTextColor(Color.BLACK);
        inputPassword.setBackgroundResource(android.R.drawable.edit_text);
        container.addView(inputPassword);

        builder.setView(container);

        // CANCEL button
        builder.setNegativeButton("CANCEL", (dialog, which) -> dialog.dismiss());

        // OK button
        builder.setPositiveButton("OK", (dialog, which) -> {
            String username = inputUsername.getText().toString().trim();
            String password = inputPassword.getText().toString().trim();
            // TODO: Add your logic here to handle updated username and password
        });

        AlertDialog dialog = builder.create();
        dialog.show();

        // Style buttons
        Button cancelBtn = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
        Button okBtn = dialog.getButton(AlertDialog.BUTTON_POSITIVE);

        if (cancelBtn != null) {
            cancelBtn.setTextColor(Color.parseColor("#242D69"));
            cancelBtn.setAllCaps(true);
            cancelBtn.setTextSize(14);
            cancelBtn.setTypeface(Typeface.create("sans-serif-semibold", Typeface.NORMAL));
        }

        if (okBtn != null) {
            okBtn.setTextColor(Color.parseColor("#242D69"));
            okBtn.setAllCaps(true);
            okBtn.setTextSize(14);
            okBtn.setTypeface(Typeface.create("sans-serif-semibold", Typeface.NORMAL));
        }

        // Set dialog size (280x300 dp)
        int width = (int) (280 * getResources().getDisplayMetrics().density);
        int height = (int) (300 * getResources().getDisplayMetrics().density);
        if (dialog.getWindow() != null) {
            dialog.getWindow().setLayout(width, height);
        }
    }

    private void showSignOutDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(userinformationscreen.this);

        // Title TextView
        TextView title = new TextView(this);
        title.setText("Sign out?");
        title.setTextSize(20);
        title.setTypeface(Typeface.create("sans-serif", Typeface.BOLD));
        title.setGravity(Gravity.START);
        title.setPadding(40, 40, 40, 10);
        title.setTextColor(Color.BLACK);

        // Supporting message TextView
        TextView message = new TextView(this);
        message.setText("You'll be logout your account");
        message.setTextSize(16);
        message.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));
        message.setGravity(Gravity.START);
        message.setPadding(40, 0, 40, 20);
        message.setTextColor(Color.BLACK);

        // Layout container for title and message
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.addView(title);
        layout.addView(message);

        builder.setView(layout);

        // DISMISS button
        builder.setNegativeButton("DISMISS", (dialog, which) -> dialog.dismiss());

        // CONFIRM button
        builder.setPositiveButton("CONFIRM", (dialog, which) -> {
            Intent intent = new Intent(userinformationscreen.this, signinscreen.class);
            startActivity(intent);
            finish();
        });

        AlertDialog dialog = builder.create();
        dialog.show();

        // Style buttons
        Button dismissBtn = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
        Button confirmBtn = dialog.getButton(AlertDialog.BUTTON_POSITIVE);

        if (dismissBtn != null) {
            dismissBtn.setTextColor(Color.parseColor("#242D69"));
            dismissBtn.setAllCaps(true);
            dismissBtn.setTextSize(14);
            dismissBtn.setTypeface(Typeface.create("sans-serif-semibold", Typeface.NORMAL));
        }

        if (confirmBtn != null) {
            confirmBtn.setTextColor(Color.parseColor("#242D69"));
            confirmBtn.setAllCaps(true);
            confirmBtn.setTextSize(14);
            confirmBtn.setTypeface(Typeface.create("sans-serif-semibold", Typeface.NORMAL));
        }

        // Set dialog size (280x200 dp)
        int width = (int) (280 * getResources().getDisplayMetrics().density);
        int height = (int) (200 * getResources().getDisplayMetrics().density);
        if (dialog.getWindow() != null) {
            dialog.getWindow().setLayout(width, height);
        }
    }
}
