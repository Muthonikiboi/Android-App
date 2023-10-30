package com.example.gradingsystem2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText englishMarks, socialMarks, scienceMarks, computerMarks;
    private EditText englishGrade, socialGrade, scienceGrade, computerGrade;
    private EditText meanText;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        englishMarks = findViewById(R.id.englishMarks);
        socialMarks = findViewById(R.id.socialMarks);
        scienceMarks = findViewById(R.id.scienceMarks);
        computerMarks = findViewById(R.id.computerMarks);

//        englishGrade = findViewById(R.id.englishGrade);
//        socialGrade = findViewById(R.id.socialGrade);
//        scienceGrade = findViewById(R.id.scienceGrade);
//        computerGrade = findViewById(R.id.computerGrade);

        meanText = findViewById(R.id.meanText);
        calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Calculate grades and mean
                double english = Double.parseDouble(englishMarks.getText().toString());
                double social = Double.parseDouble(socialMarks.getText().toString());
                double science = Double.parseDouble(scienceMarks.getText().toString());
                double computer = Double.parseDouble(computerMarks.getText().toString());

                String englishLetterGrade = calculateGrade(english);
                String socialLetterGrade = calculateGrade(social);
                String scienceLetterGrade = calculateGrade(science);
                String computerLetterGrade = calculateGrade(computer);

                englishGrade.setText(englishLetterGrade);
                socialGrade.setText(socialLetterGrade);
                scienceGrade.setText(scienceLetterGrade);
                computerGrade.setText(computerLetterGrade);

                double mean = (english + social + science + computer) / 4;
                meanText.setText(String.format("%.2f", mean));
            }
        });
    }

    private String calculateGrade(double marks) {
        if (marks >= 90) {
            return "A";
        } else if (marks >= 80) {
            return "B";
        } else if (marks >= 70) {
            return "C";
        } else if (marks >= 60) {
            return "D";
        } else {
            return "E";
        }
    }
}
