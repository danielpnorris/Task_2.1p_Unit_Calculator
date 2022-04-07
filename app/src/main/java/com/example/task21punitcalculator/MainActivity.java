package com.example.task21punitcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //All xml elements declared so they can be dynamically changed
    TextView resultName1;
    TextView resultName2;
    TextView resultName3;
    TextView resultValue1;
    TextView resultValue2;
    TextView resultValue3;

    EditText editTextNumber;

    ImageButton lengthButton;
    ImageButton tempButton;
    ImageButton weightButton;

    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Actually assign values to the variables declared above
        lengthButton = findViewById(R.id.lengthButton);
        tempButton = findViewById(R.id.tempButton);
        weightButton = findViewById(R.id.weightButton);
        resultName1 = findViewById(R.id.resultName1);
        resultName2 = findViewById(R.id.resultName2);
        resultName3 = findViewById(R.id.resultName3);
        resultValue1 = findViewById(R.id.resultValue1);
        resultValue2 = findViewById(R.id.resultValue2);
        resultValue3 = findViewById(R.id.resultValue3);
        editTextNumber = findViewById(R.id.editTextNumber);
        spinner = findViewById((R.id.unitArray));
        adapter = ArrayAdapter.createFromResource(this, R.array.unit_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        lengthButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(spinner.getSelectedItem().toString().equals("Metres") && editTextNumber.getText().toString() != ""){
                    int metres = Integer.parseInt(editTextNumber.getText().toString());
                    int centimetres = metres * 100;
                    double feet = metres * 3.28084;
                    double inches = metres * 39.3701;

                    //My approach was to keep the same textView elements displayed but change their text values/visibility as needed

                    resultValue1.setText(String.valueOf(centimetres));
                    resultValue1.setVisibility(View.VISIBLE);
                    resultName1.setText("Centimetres");
                    resultName1.setVisibility(View.VISIBLE);
                    resultValue2.setText(String.format("%.2f", feet));
                    resultValue2.setVisibility(View.VISIBLE);
                    resultName2.setText("Feet");
                    resultName2.setVisibility(View.VISIBLE);
                    resultValue3.setText(String.format("%.2f", inches));
                    resultValue3.setVisibility(View.VISIBLE);
                    resultName3.setText("Inches");
                    resultName3.setVisibility(View.VISIBLE);
                }
                else{
                    //If the incorrect value is chosen then this toast is displayed, directing the user to select the correct unit
                    Toast.makeText(MainActivity.this, "Please select the correct conversion icon", Toast.LENGTH_LONG).show();
                }

            }

        });
        tempButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(spinner.getSelectedItem().toString().equals("Celsius") && editTextNumber.getText().toString() != ""){
                    int celsius = Integer.parseInt(editTextNumber.getText().toString());
                    double fahrenheit = (celsius * (9/5)) + 32;
                    double kelvin = celsius + 273.15;

                    resultValue1.setText(String.format("%.2f", fahrenheit));
                    resultValue1.setVisibility(View.VISIBLE);
                    resultName1.setText("Fahrenheit");
                    resultName1.setVisibility(View.VISIBLE);
                    resultValue2.setText(String.format("%.2f", kelvin));
                    resultValue2.setVisibility(View.VISIBLE);
                    resultName2.setText("Kelvin");
                    resultName2.setVisibility(View.VISIBLE);
                    resultValue3.setVisibility(View.INVISIBLE);
                    resultName3.setVisibility(View.INVISIBLE);
                }
                else{
                    Toast.makeText(MainActivity.this, "Please select the correct conversion icon", Toast.LENGTH_LONG).show();
                }

            }

        });
        weightButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(spinner.getSelectedItem().toString().equals("Kilograms") && editTextNumber.getText().toString() != ""){
                    int kilograms = Integer.parseInt(editTextNumber.getText().toString());
                    int grams = kilograms * 1000;
                    double ounces = kilograms * 35.274;
                    double pounds = kilograms * 2.205;

                    resultValue1.setText(String.valueOf(grams));
                    resultValue1.setVisibility(View.VISIBLE);
                    resultName1.setText("Grams");
                    resultName1.setVisibility(View.VISIBLE);
                    resultValue2.setText(String.format("%.2f", ounces));
                    resultValue2.setVisibility(View.VISIBLE);
                    resultName2.setText("Ounce(Oz)");
                    resultName2.setVisibility(View.VISIBLE);
                    resultValue3.setText(String.format("%.2f", pounds));
                    resultValue3.setVisibility(View.VISIBLE);
                    resultName3.setText("Pounds(lb)");
                    resultName3.setVisibility(View.VISIBLE);
                }
                else{
                    Toast.makeText(MainActivity.this, "Please select the correct conversion icon", Toast.LENGTH_LONG).show();
                }

            }

        });


    }
}