package com.example.francois.application_dfs;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class BoundService extends Service {

    private String TAG = "TestService";
    private IBinder myBinder = new MylocalBinder();
    int val = 0;

    public IBinder onBind(Intent intent){
        Log.d(TAG,"onBind done");
        return myBinder;
    }

    public void onCreate() {
        Log.d(TAG, "onCreate called");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnBind done");
        return super.onUnbind(intent);
    }

    public BoundService() {
    }

    public class MylocalBinder extends Binder {
        public BoundService getService(){
            return BoundService.this;
        }
    }

    public String getCurrentTime(){
        val +=1;
        return ""+val;
    }
}
