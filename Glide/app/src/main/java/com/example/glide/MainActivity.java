package com.example.glide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class MainActivity extends AppCompatActivity {
    ImageView image1, image2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image1=findViewById(R.id.image1);
        image2=findViewById(R.id.image2);

        Glide.with(MainActivity.this)
                .load("https://png.pngtree.com/png-clipart/20190918/ourmid/pngtree-load-the-3273350-png-image_1733730.jpg").placeholder(R.drawable.progress_bar)
                .placeholder(R.drawable.progress_bar).diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(image1);
        Glide.with(MainActivity.this)
                .load("https://www.adorama.com/alc/wp-content/uploads/2021/05/bird-wings-flying.gif")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(image2);
    }
}