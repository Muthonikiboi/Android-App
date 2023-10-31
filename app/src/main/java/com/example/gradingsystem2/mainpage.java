package com.example.gradingsystem2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class mainpage extends AppCompatActivity {

    private EditText nameEditText;
    private EditText emailEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Use the correct layout file

        //nameEditText = findViewById(R.id.input1); // Replace with the correct EditText ID for the name field
        //emailEditText = findViewById(R.id.input2); // Replace with the correct EditText ID for the email field
       // loginButton = findViewById(R.id.loginButton); // Replace with the correct Button ID

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String email = emailEditText.getText().toString();

                if (name.isEmpty() || email.isEmpty() || !isValidEmail(email)) {
                    // Check if both name and email are filled and the email is valid
                    Toast.makeText(LoginActivity.this, "Please fill in both name and a valid email.", Toast.LENGTH_SHORT).show();
                } else {
                    // If both name and email are filled and the email is valid, navigate to the HomeActivity
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void startActivity(Intent intent) {
    }

    // A simple email validation method
    private boolean isValidEmail(String email) {
        // You can use a regular expression to perform email validation
        // This is a basic example and may not cover all cases
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        return email.matches(emailPattern);
    }
}
