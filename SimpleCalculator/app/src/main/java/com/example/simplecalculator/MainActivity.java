package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText edittxt1;
    private EditText edittxt2;
    private TextView textviewresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edittxt1=(EditText) findViewById(R.id.edittxt1);
        edittxt2=(EditText) findViewById(R.id.edittxt2);
        textviewresult=(TextView) findViewById(R.id.textviewresult);

    }

    public void btnsum(View view) {
        int n1 = Integer.parseInt(edittxt1.getText().toString());
        int n2 = Integer.parseInt(edittxt2.getText().toString());
        int sum= n1+n2;
        textviewresult.setText(String.valueOf(sum));
    }

    public void btnmul(View view) {
        int n1 = Integer.parseInt(edittxt1.getText().toString());
        int n2 = Integer.parseInt(edittxt2.getText().toString());
        int mul= n1*n2;
        textviewresult.setText(String.valueOf(mul));
    }

    public void btndiv(View view) {
        int n1 = Integer.parseInt(edittxt1.getText().toString());
        int n2 = Integer.parseInt(edittxt2.getText().toString());
        int div= n1/n2;
        textviewresult.setText(String.valueOf(div));
    }

    public void btnsub(View view) {
        int n1 = Integer.parseInt(edittxt1.getText().toString());
        int n2 = Integer.parseInt(edittxt2.getText().toString());
        int sub= n1-n2;
        textviewresult.setText(String.valueOf(sub));
    }
}