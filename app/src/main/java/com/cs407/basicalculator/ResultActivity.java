package com.cs407.basicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        resultView = (TextView) findViewById(R.id.resultView);
        Intent intent = getIntent();
        resultView.setText(intent.getStringExtra("result"));
    }

    public void clickBack(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}