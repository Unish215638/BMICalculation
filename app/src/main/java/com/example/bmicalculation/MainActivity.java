package com.example.bmicalculation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText weight,height,bmires;
    Button btnBMI;
    Double weightval,heightval,heightinm,bmi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();

        btnBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (weight.getText().toString().trim().isEmpty()) {
                    weight.setError("Wieght Required");
                }
                else if(height.getText().toString().trim().isEmpty()){
                    height.setError("Height Required");
                }
                else {

                    displayBMI();

                }

            }
        });
    }


    public void initComponents(){

        weight=findViewById(R.id.weightt);
        height=findViewById(R.id.heightt);
        btnBMI=findViewById(R.id.btnBMI);
        bmires=findViewById(R.id.bmires);
    }


    public void displayBMI(){

        weightval = Double.parseDouble(weight.getText().toString().trim());
        heightval = Double.parseDouble(height.getText().toString().trim());
        heightinm = heightval / 100;

        BMI bmic=new BMI(heightinm,weightval);
        bmi = bmic.getWeight() / (bmic.getHeight()*bmic.getHeight());

        String.format("%.2f", bmi);
        bmires.setText(bmi + "");

        if(bmi<=18.55){
            Toast.makeText(MainActivity.this, "UnderWeight", Toast.LENGTH_LONG).show();
            bmires.setTextColor(getResources().getColor(R.color.Red));
        }
        else if(bmi>=18.55&&bmi<=24.9){
            Toast.makeText(MainActivity.this, "Normal Weight", Toast.LENGTH_LONG).show();
            bmires.setTextColor(getResources().getColor(R.color.Green));
        }

        else if(bmi>=25 && bmi<=29.9){
            Toast.makeText(MainActivity.this, "Over Weight", Toast.LENGTH_LONG).show();
            bmires.setTextColor(getResources().getColor(R.color.Red));
        }

        else if(bmi>=30){
            Toast.makeText(MainActivity.this, "Obesity", Toast.LENGTH_LONG).show();
            bmires.setTextColor(getResources().getColor(R.color.Maroon));
        }


    }
}
