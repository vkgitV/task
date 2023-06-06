package com.example.glide1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        String url ="https://pbs.twimg.com/media/E90YbU2WUAckrdT?format=jpg&name=small";
        Glide.with(this).load(url).into(imageView);

    }
}