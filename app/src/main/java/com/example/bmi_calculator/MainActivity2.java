package com.example.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
public static final String SETTING = "SYSTEM";
    private Button metric ;
    private Button imperial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        metric = findViewById(R.id.metric_btn);
        imperial = findViewById(R.id.imperial_btn);

        SharedPreferences pref =getSharedPreferences(SETTING, MODE_PRIVATE);

        metric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myString = pref.getString("SYSTEM", "");
                if(myString.equals("METRIC")){
                    Toast.makeText(MainActivity2.this, "It's already on METRIC", Toast.LENGTH_SHORT).show();
                    Intent back_to_main_screen = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(back_to_main_screen);

                }
                else {
                    SharedPreferences.Editor e = pref.edit();
                    e.putString(SETTING, "METRIC");
                    e.commit();
                    Intent back_to_main_screen = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(back_to_main_screen);
                }
            }
        });
        imperial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myString = pref.getString("SYSTEM", "");
                if(myString.equals("IMPERIAL")){
                    Toast.makeText(MainActivity2.this, "It's already on IMPERIAL", Toast.LENGTH_SHORT).show();

                    Intent back_to_main_screen = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(back_to_main_screen);
                }
                else{
                    SharedPreferences.Editor e = pref.edit();
                    e.putString(SETTING, "IMPERIAL");
                    e.commit();
                    Intent back_to_main_screen = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(back_to_main_screen);
                }

            }
        });
    }
}