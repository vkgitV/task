package com.example.manage_external_storage;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private  static final  String TAG="PERMISSION_TAG";
    private  static final int STORAGE_PERMISSION_CODE=100;


    private EditText flodername;
    private MaterialButton createflodername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flodername=findViewById(R.id.flodername);
        createflodername=findViewById(R.id.createfoldername);
        //button
        createflodername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
    }
    private void createfloder(){
        String floderName=flodername.getText().toString().trim();

        File file= new File(Environment.getExternalStorageDirectory()+"/"+floderName);
        boolean floderCreated=file.mkdir();
        if (floderCreated){
            Toast.makeText(this,"Floder Created....\n"+file.getAbsolutePath(),Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"Floder not created...",Toast.LENGTH_SHORT).show();
        }
    }
    private  void requestPermission(){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.R){
            try {
                Log.d(TAG, "requestPermission:try ");
                Intent intent=new Intent();
                intent.setAction(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                Uri uri=Uri.fromParts("package",this.getPackageName(),null);
                intent.setData(uri);
                storageActivityResultLauncher.launch(intent);


            }
            catch (Exception e){
                Log.e(TAG, "requestPermission:catch ");
                Intent intent=new Intent();
                intent.setAction(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
                storageActivityResultLauncher.launch(intent);

        }
    }else {
            ActivityCompat.requestPermissions(this,new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE},STORAGE_PERMISSION_CODE);

        }
}
private ActivityResultLauncher<Intent>storageActivityResultLauncher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
        new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                Log.d(TAG, "onActivityResult");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    if (Environment.isExternalStorageManager()) {
                        Log.d(TAG,"onActivityResult:Manage External Storage Permission is granted");
                        createfloder();
                    }
                    else
                    { Log.d(TAG,"onActivityResult:Manage External Storage Permission is demied");
                        Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();

                    }
                }else {

                }}

            });


    public boolean checkPermission(){

                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.R){
                    return  Environment.isExternalStorageManager();
                }
                else{
                    int write= ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE);
                    int read= ContextCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE);
                    return write==PackageManager.PERMISSION_GRANTED && read == PackageManager.PERMISSION_GRANTED;
                }
            }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==STORAGE_PERMISSION_CODE){
            if (grantResults.length>0){
                boolean write=grantResults[0]==PackageManager.PERMISSION_GRANTED;
                boolean read=grantResults[1]==PackageManager.PERMISSION_GRANTED;
                if (write&&read){
                    Log.d(TAG,"onRequestPermissionResult:External Storage permission granted");
                    createfloder();
                }else{
                    Log.d(TAG,"onRequestPermissionResult:External Storage permission denied");
                    Toast.makeText(this, "External Storage permission denied", Toast.LENGTH_SHORT).show();


                }
            }
        }
    }
}

