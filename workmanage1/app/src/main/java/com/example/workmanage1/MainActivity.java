package com.example.workmanage1;

//import android.arch.lifecycle.LifecycleOwner;
//import android.arch.lifecycle.Observer;
//import android.arch.lifecycle.LifecycleOwner;
//import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import com.example.workmanage1.NotificationWorker;
import com.example.workmanage1.R;

import org.jetbrains.annotations.Contract;

public class MainActivity extends AppCompatActivity {

    public static final String MESSAGE_STATUS = "message_status";
    Button button;
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        button=findViewById(R.id.button);
        final WorkManager workManager=WorkManager.getInstance();
        final OneTimeWorkRequest request=new OneTimeWorkRequest.Builder(NotificationWorker.class).build();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workManager.enqueue(request);

            }
        });
        workManager.getWorkInfoByIdLiveData(request.getId()).observe( this, new Observer<WorkInfo>() {
            @Override
            public void onChanged(@Nullable WorkInfo workInfo) {
                if (workInfo != null) {
                    WorkInfo.State state = workInfo.getState();
                    textView.append(state.toString() + "\n");
                }
            }
        });
    }}