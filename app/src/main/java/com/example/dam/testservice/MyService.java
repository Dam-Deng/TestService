package com.example.dam.testservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {
    private String data = "默認信息";

    public MyService() {
    }

    @Override
    public void onCreate() {
        System.out.println("Service onCreate");
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {

        System.out.println("Service onBind");

        return new myBinder();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("Service onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        System.out.println("Service onUnbind");
        return super.onUnbind(intent);
    }


    @Override
    public void onDestroy() {
        System.out.println("Service onDestroy");
        super.onDestroy();
    }

    public class myBinder extends Binder {

        public void setData(String data) {
            MyService.this.data = data;
        }

    }
}
