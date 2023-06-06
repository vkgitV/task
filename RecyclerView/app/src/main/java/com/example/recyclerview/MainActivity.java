package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    AppUtility appUtility;
ArrayAdapter<String> namesAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appUtility=AppUtility.getAppUtility(getApplicationContext());
        listView=(ListView) findViewById(R.id.listview);
        namesAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,appUtility.getNames());
        listView.setAdapter(namesAdapter);
    }
}