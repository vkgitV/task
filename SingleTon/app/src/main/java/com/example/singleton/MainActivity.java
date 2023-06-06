package com.example.singleton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button Save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.editText);
        Save=findViewById(R.id.save);
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().toString().isEmpty()) {

                    Toast.makeText(MainActivity.this, "Enter Text", Toast.LENGTH_SHORT).show();
                   // editText.setError("enter text");
                }else{
                    String editValue=editText.getText().toString();
                    SingleTon singleTon=com.example.singleton.SingleTon.getInstance();
                    singleTon.setText(editValue);
                    Toast.makeText(MainActivity.this,singleTon.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}