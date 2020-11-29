package dev.alimansour.multipleactivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView messageTextView;
    private Button adminAreaButton, logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        messageTextView = findViewById(R.id.messageTextView);
        adminAreaButton = findViewById(R.id.adminAreaButton);
        logoutButton = findViewById(R.id.logoutButton);
        adminAreaButton.setOnClickListener(this);
        logoutButton.setOnClickListener(this);

        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");
        boolean isAdmin = intent.getBooleanExtra("isAdmin", false);
        String message = "Welcome back " + userName;
        messageTextView.setText(message);

        if (isAdmin) adminAreaButton.setVisibility(View.VISIBLE);
        else adminAreaButton.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        if (adminAreaButton.equals(v)) {
            Toast.makeText(this, "Welcome to Admin Area!", Toast.LENGTH_LONG).show();
        } else if (logoutButton.equals(v)) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}