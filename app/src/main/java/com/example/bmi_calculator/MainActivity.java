package com.example.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private EditText editTextWeight, editTextHeight;
    private Button buttonCalculate;
    private ImageButton go_to_settings;
    private TextView textViewBMI,textViewStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextWeight = findViewById(R.id.weight_);
        editTextHeight = findViewById(R.id.height_imp);
        buttonCalculate = findViewById(R.id.result_btn);
        textViewBMI = findViewById(R.id.BMI_txt);
        go_to_settings = findViewById(R.id.settings1_btn);
        textViewStatus =  findViewById(R.id.status_txt);


        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editTextWeight.getText().toString().trim().length() == 0 || editTextHeight.getText().toString().trim().length() == 0 ) {
                    // The EditText input is empty
                    Toast.makeText(MainActivity.this, "Please enter both fields", Toast.LENGTH_SHORT).show();
                } else {
                    // The EditText input is not empty

                double weight = Double.parseDouble(editTextWeight.getText().toString());
                double height = Double.parseDouble(editTextHeight.getText().toString());
                height = height / 100;
                // Calculate the BMI
                double bmi = weight / (height * height);
                if(bmi < 18.5){
                    //Underweight
                    textViewStatus.setText("Underweight"+"");
                } else if ( bmi >= 18.5 && bmi <= 24.9 ) {
//                     Normal weight = 18.5–24.9
                    textViewStatus.setText("Normal weight"+"");

                } else if (bmi >= 25 && bmi <= 29.9) {
//                     Overweight = 25–29.9
                    textViewStatus.setText("Overweight"+"");
                }
                else{
//                     Obesity = BMI of 30 or greater
                    textViewStatus.setText("Obesity"+"");
                }
                DecimalFormat df = new DecimalFormat("#.##");
                String formattedValue = df.format(bmi);
                    // Display the BMI
                textViewBMI.setText(formattedValue+"");

                }
            }
        });


        go_to_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent settings_intent = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(settings_intent);
            }
        });

    }
}