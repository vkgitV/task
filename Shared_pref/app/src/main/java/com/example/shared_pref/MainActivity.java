package com.example.shared_pref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText firstname , lastname,age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstname=findViewById(R.id.edit1);
        lastname=findViewById(R.id.edit2);
        age=findViewById(R.id.edit3);


    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences= getSharedPreferences("My shared preference", MODE_PRIVATE);

        String s1=sharedPreferences.getString("first name","");
        String s2=sharedPreferences.getString("last name","");
        int a=sharedPreferences.getInt("age",0);

        firstname.setText(s1);
        lastname.setText(s2);
        age.setText(String.valueOf(a));
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences=getSharedPreferences("My shared preference",MODE_PRIVATE);
        SharedPreferences.Editor myedit=sharedPreferences.edit();

        myedit.putString("first name",firstname.getText().toString());
        myedit.putString("last name",lastname.getText().toString());
        myedit.putInt("age",Integer.parseInt(age.getText().toString()));
        myedit.apply();



    }
}