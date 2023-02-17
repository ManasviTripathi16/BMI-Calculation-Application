package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


    TextView res;
    Button calc;
    private RadioButton malebut;
    private RadioButton femalebut;
    private EditText age;
    private EditText feet;
    private EditText inches;
    private EditText weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();

        setupClicklistener();
    }



    private void findViews()
    {
        res=findViewById(R.id.text_view_result);
        findViewById(R.id.text_view_result);
        findViewById(R.id.radio_button_male);
        findViewById(R.id.radio_button_female);
        findViewById(R.id.edit_text_age);
        findViewById(R.id.edit_text_feet);
        findViewById(R.id.edit_text_inches);
        findViewById(R.id.edit_text_weight);
        findViewById(R.id.button_calculate);



        //res.setText("IM A BEAST");
        malebut = findViewById(R.id.radio_button_male);
        femalebut = findViewById(R.id.radio_button_female);

        age = findViewById(R.id.edit_text_age);
        feet = findViewById(R.id.edit_text_feet);
        inches = findViewById(R.id.edit_text_inches);
        weight = findViewById(R.id.edit_text_weight);

        calc=findViewById(R.id.button_calculate);
    }
    private void setupClicklistener() {
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double BMIRESULT=calculateBMI();
                String ageT=age.getText().toString();
                int age=Integer.parseInt(ageT);
                if(age>=18)
                {
                    display(BMIRESULT);
                }
                else
                {
                    guidance(BMIRESULT);
                }
            }
        });
    }



    private double calculateBMI() {

        String feetT=feet.getText().toString();
        String inchesT=inches.getText().toString();
        String weightT=weight.getText().toString();
        // int ageint=Integer.parseInt(ageT);
        int feetint=Integer.parseInt(feetT);
        int inchint=Integer.parseInt(inchesT);
        int weightint=Integer.parseInt(weightT);
        int totalinches=(feetint*12)+inchint;
        //
        double heightinm=totalinches*0.0254;

        return weightint/(heightinm*heightinm);


    }

    private void display(double BMI)
    {
        DecimalFormat decform=new DecimalFormat("0.00");
        String BMIRESULT= decform.format(BMI);

        String finalres;

        if(BMI<18.5)
        {
            finalres=BMIRESULT+": You are Underweight";
        }
        else if(BMI>25)
        {
            finalres=BMIRESULT+": You are Overweight";
        }
        else
        {
            finalres=BMIRESULT+": You are a Healthy weight";
        }
        res.setText(finalres);
    }

    private void guidance(double BMI) {
        DecimalFormat decform=new DecimalFormat("0.00");
        String BMIRESULT= decform.format(BMI);

        String finalres;
        if(malebut.isChecked())
        {
            finalres=BMIRESULT+"You are under 18, please consult doctor for healthy range of boys";
        }
        else if(femalebut.isChecked())
        {
            finalres=BMIRESULT+"You are under 18, please consult doctor for healthy range for girls";
        }
        else
        {
            finalres=BMIRESULT+"You are under 18, please consult doctor for healthy range";
        }
        res.setText(finalres);


    }



}