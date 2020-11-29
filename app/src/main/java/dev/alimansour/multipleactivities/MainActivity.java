package dev.alimansour.multipleactivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText userNameEditText, passwordEditText;
    private Button signInButton;
    private boolean isAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameEditText = findViewById(R.id.userNameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        signInButton = findViewById(R.id.signInButton);
        signInButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String userName = userNameEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        if (userName.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter username and password!", Toast.LENGTH_LONG).show();
            return;
        }
        if ((userName.equalsIgnoreCase("admin")
                || userName.equalsIgnoreCase("user"))
                && password.equals("123456")) {
            isAdmin = userName.equalsIgnoreCase("admin");
            Intent intent = new Intent(this, HomeActivity.class);
            intent.putExtra("userName",userName);
            intent.putExtra("isAdmin",isAdmin);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Invalid username or password!", Toast.LENGTH_LONG).show();
        }
    }
}