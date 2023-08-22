package com.example.bmicalculator;



import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtResult;
        EditText edtHeightFt, edtWeight, edtHeightIn;
        Button btnCalculate;
        LinearLayout llMain;

        txtResult = findViewById(R.id.txtResult);
        edtHeightFt = findViewById(R.id.edtHeightFt);
        edtHeightIn = findViewById(R.id.edtHeightIn);
        edtWeight = findViewById(R.id.edtWeight);
        btnCalculate = findViewById(R.id.btnCalculate);
        llMain = findViewById(R.id.llMain);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt = Integer.parseInt(edtWeight.getText().toString());
                int ft =Integer.parseInt(edtHeightFt.getText().toString());
                int in = Integer.parseInt(edtHeightIn.getText().toString());

                int totalIn = ft*12 + in;
                double totalCm = totalIn*2.53;
                double totalM = totalCm/100;

                double bmi = wt /(totalM*totalM);

                if(bmi >25) {
                    txtResult.setText("You are OverWeight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorOW));
                } else if(bmi <18){
                    txtResult.setText("You are UnderWeight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorUW));
                    } else {
                    txtResult.setText("You are Healthy");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorH));
                }

            }
        });

    }
}