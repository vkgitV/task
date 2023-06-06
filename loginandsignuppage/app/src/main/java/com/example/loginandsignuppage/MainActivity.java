package com.example.loginandsignuppage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

EditText LoginText,PasswordText;
Button btnlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoginText=(EditText) findViewById(R.id.login);
        PasswordText=(EditText) findViewById(R.id.Password);

        btnlogin=(Button) findViewById(R.id.buttonlogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = LoginText.getText().toString();
                String Password = PasswordText.getText().toString();

                if (username.equals("vinay") && (Password.equals("12345"))) {
                    Toast.makeText(MainActivity.this, "welcome", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), NewActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "invalid credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}





