package com.example.passingoneactivitytoother;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onButtonClicked(View v) {
        Intent intent = new Intent(this, FirstActivity.class);
        EditText edit1 = (EditText) findViewById(R.id.editText1);
        EditText edit2 = (EditText) findViewById(R.id.editText2);
        Button btn = (Button) findViewById(R.id.button);
        String a = edit1.getText().toString();
        String b = edit2.getText().toString();
        intent.putExtra("value1", a);
        intent.putExtra("value2", b);
        startActivity(intent);

    }

    }

