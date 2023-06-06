package com.example.jobscheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;

import java.util.Random;

public class IntentService extends JobService {
    private  int mRandomNumber;
    private boolean IsRandomGeneratorOn;
    private  final int MIN=0;
    private final int MAX=100;

    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        Log.i("ServiceDemo","onStartJob");
        doBackgroundWork();
        return true;
    }

    private void doBackgroundWork() {
        new  Thread(new Runnable() {
            @Override
            public void run() {
            IsRandomGeneratorOn=true;
            startRandomNumberGenerator();}
        }).start();

    }@Override
    public boolean onStopJob(JobParameters jobParameters) {
        Log.i("ServiceDemo","onStopJob");
        return true;

    }


    private void startRandomNumberGenerator() {
        while (IsRandomGeneratorOn){
            try{
                Thread.sleep(1000);
                if (IsRandomGeneratorOn){
                    mRandomNumber=new Random().nextInt(MAX)+MIN;
                    Log.i("ServiceDemo","Thread id: "+Thread.currentThread().getId()+", Random Number: "+ mRandomNumber);
                }
            } catch (InterruptedException e) {
                Log.i("ServiceDemo","Thread interrupted");
            }
        }

}

    @Override
    public void onDestroy() {
        super.onDestroy();
        IsRandomGeneratorOn=false;
        Log.i("ServiceDemo", "thread Id:"+Thread.currentThread().getId());
    }}

