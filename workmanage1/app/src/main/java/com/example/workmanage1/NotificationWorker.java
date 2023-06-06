package com.example.workmanage1;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
//import android.support.annotation.NonNull;

import androidx.core.app.NotificationCompat;
import androidx.work.Data;
import androidx.work.WorkManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.example.workmanage1.R;

import java.nio.channels.Channel;

import javax.xml.transform.Result;

public class NotificationWorker extends Worker  {
    private static  final String WORK_RESULT="work_result";

    public NotificationWorker( @androidx.annotation.NonNull Context context, @androidx.annotation.NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @androidx.annotation.NonNull
    @Override
    public Result doWork() {
        Data taskData=getInputData();
        String taskDataString=taskData.getString(MainActivity.MESSAGE_STATUS);
        showNotification("WorkManager",taskDataString!=null?taskDataString:"Message has been Sent");
        Data outputData=new Data.Builder().putString(WORK_RESULT,"job finished").build();
        return Result.success(outputData);
    }

    private void showNotification(String task, String desc) {
        NotificationManager manager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

        String channelId = "task_channel";
        String channelname = "task_name";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId, channelname, NotificationManager.IMPORTANCE_DEFAULT);
            manager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), channelId)
                .setContentTitle(task)
                .setContentText(desc)
                .setSmallIcon(R.mipmap.ic_launcher);
        manager.notify(1, builder.build());
    }
}

