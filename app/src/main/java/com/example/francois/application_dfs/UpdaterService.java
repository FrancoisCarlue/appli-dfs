package com.example.francois.application_dfs;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import static com.example.francois.application_dfs.MainActivity.TAG;

public class UpdaterService extends Service {

    String valueRecup;

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        valueRecup = intent.getExtras().getString("ValueServ");
        Log.d(TAG,"Valeur recup :" + valueRecup);
    }

    public UpdaterService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }


    @Override
    public void onCreate() {
        Log.d(TAG,"Service onCreate");
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG,"Service onDestroy");
        super.onDestroy();
    }
}
