package com.example.dam.testservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ServiceConnection {

    private MyService.myBinder binder = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.btnStartService).setOnClickListener(this);
        findViewById(R.id.btnBindService).setOnClickListener(this);
        findViewById(R.id.btnStopService).setOnClickListener(this);
        findViewById(R.id.btnUnbindService).setOnClickListener(this);
        findViewById(R.id.btnSyncData).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, MyService.class);
        switch (v.getId()) {
            case R.id.btnStartService:
                startService(intent);
                break;
            case R.id.btnBindService:
                bindService(intent,this, BIND_AUTO_CREATE);
                break;
            case R.id.btnStopService:
                stopService(intent);
                break;
            case R.id.btnUnbindService:
                unbindService(this);
                break;
            case R.id.btnSyncData:
                binder.setData("tt");
                break;
        }
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        binder = (MyService.myBinder) service;
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
}
