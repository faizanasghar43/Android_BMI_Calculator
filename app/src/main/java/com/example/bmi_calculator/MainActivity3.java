package com.example.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity3 extends AppCompatActivity {
    private EditText editTextWeight, editTextHeightft, editTextHeightin;
    private Button buttonCalculate;
    private ImageButton go_to_settings;
    private TextView textViewBMI,textViewStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        go_to_settings = findViewById(R.id.settings1_btn);
        editTextWeight = findViewById(R.id.weight_);
        editTextHeightft = findViewById(R.id.height_imp);
        editTextHeightin =  findViewById(R.id.inches_imp);
        buttonCalculate = findViewById(R.id.result_btn);
        textViewBMI = findViewById(R.id.BMI_txt);
        textViewStatus =  findViewById(R.id.status_txt);
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editTextWeight.getText().toString().trim().length() == 0 || editTextHeightft.getText().toString().trim().length() == 0 || editTextHeightin.getText().toString().trim().length() == 0 ) {
                    // The EditText input is empty
                    Toast.makeText(MainActivity3.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                } else if (editTextHeightin.getText().toString().trim().length() > 12) {
                    Toast.makeText(MainActivity3.this, "Inches can't be bigger than 12", Toast.LENGTH_SHORT).show();
                } else {
                    // The EditText input is not empty
                    double weight = Double.parseDouble(editTextWeight.getText().toString());
                    double height = Double.parseDouble(editTextHeightft.getText().toString()) + (Double.parseDouble(editTextHeightin.getText().toString()) *0.0833);
                    System.out.println(height);
                    height = height *12 ;
                    // Calculate the BMI
                    double bmi = (weight / (height * height))*703;
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