package com.example.handler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG =MainActivity.class.getSimpleName() ;
    private Button startThread ,stopThread;
    private TextView textView;
    int count=0;
    Handler handler;
    private  boolean mStopLoop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"Thread id :"+Thread.currentThread().getId());
        startThread=(Button) findViewById(R.id.button);
        stopThread=(Button) findViewById(R.id.button2);

        textView=(TextView)findViewById(R.id.textViewthreadCount;

        startThread.setOnClickListener(this);
        stopThread.setOnClickListener(this);
        handler=new Handler(getApplicationContext().getMainLooper());

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                StopLoop=true;

                new Thread(new Runnable() {
                    while (mStoploop)

                    {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            Log.i(TAG, e.getMessage());
                        }
                        Log.i(TAG, "Thread id in while loop:" + Thread.currentThread().getId() + ",  Count:" + count);
                        textViewthreadCount.post(new Runnable() {

                            @Override
                            public void run() {
                                textViewthreadCount.setText("" + count);

                            }
                        });
                    }
                }).start();
                break;
            case R.id.button2:StopLoop=false;
                break;
        }

    }
}