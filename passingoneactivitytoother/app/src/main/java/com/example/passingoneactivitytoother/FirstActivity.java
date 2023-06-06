package com.example.passingoneactivitytoother;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        String value1= getIntent().getStringExtra("value1");
        String value2 =getIntent().getStringExtra("value2");
        TextView textView = (TextView) findViewById(R.id.TV_1);
        textView.setText(value1);
        TextView textView2 = (TextView) findViewById(R.id.TV_2);
        textView2.setText(value2);
    }
}