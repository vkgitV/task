package com.example.inboxnotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.btn);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel=new NotificationChannel("My Notification","My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();

                inboxStyle.setBigContentTitle("Inbox style notification");
                inboxStyle.addLine("vinay");
                inboxStyle.addLine("kabilan");
                inboxStyle.addLine("nithish");
                inboxStyle.addLine("jana");
                inboxStyle.addLine("mugilan");
                inboxStyle.addLine("santhosh");
                inboxStyle.setSummaryText("+2 more");

                NotificationCompat.Builder builder = (NotificationCompat.Builder) new NotificationCompat.Builder(MainActivity.this, "My Notification")
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("inbox style notification")
                        .setContentText("This is inbox style notification")
                        .setStyle(inboxStyle)
                        .setColor(Color.parseColor("#FF1744"));

                NotificationManager notificationManager = (NotificationManager)
                        getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(0, builder.build());

            }});}}}