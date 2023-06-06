package com.example.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG =MainActivity.class.getSimpleName() ;
   private Button startThread ,stopThread;
    private  boolean StopLoop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startThread=(Button) findViewById(R.id.button);
        stopThread=(Button) findViewById(R.id.button2);
        Log.i(TAG,"Thread id :"+Thread.currentThread().getId());
        startThread.setOnClickListener(this);
        stopThread.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                StopLoop=true;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                while (StopLoop) {
                    Log.i(TAG, "Thread id in while loop:" + Thread.currentThread().getId());
                }}
                }).start();
                break;
            case R.id.button2:StopLoop=false;
            break;
        }

    }
}