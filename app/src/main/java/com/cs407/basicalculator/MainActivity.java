package com.cs407.basicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickPlus(View view){
        calculate("plus");
    }

    public void clickMinus(View view){
        calculate("minus");
    }

    public void clickMultiply(View view){
        calculate("multiply");
    }

    public void clickDivide(View view){
        calculate("divide");
    }

    public void goToActivity(String s){
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("result", s);
        startActivity(intent);
    }

    private int calculate(String operation){
        EditText intInput1 = (EditText) findViewById(R.id.intInput1);
        EditText intInput2 = (EditText) findViewById(R.id.intInput2);
        double result = 0;
        try{
            int a = Integer.parseInt(intInput1.getText().toString());
            int b = Integer.parseInt(intInput2.getText().toString());
            switch (operation){
                case "plus":
                    result = a + b;
                    break;

                case "minus":
                    result = a - b;
                    break;

                case "multiply":
                    result = a * b;
                    break;

                case "divide":
                    if(b == 0) {
                        Toast.makeText(MainActivity.this, "The Number Dividing Must Not Be A Zero!", Toast.LENGTH_LONG).show();
                        return -1;
                    }
                    result = (double)a / (double)b;
                    break;
            }
            goToActivity("The Calculation Result is " + result);
        }
        catch (NumberFormatException e){
            Toast.makeText(MainActivity.this, "Input Must Be Integers!", Toast.LENGTH_LONG).show();
            return -1;
        }
        return 0;
    }
}