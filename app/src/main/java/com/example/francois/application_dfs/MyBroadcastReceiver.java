package com.example.francois.application_dfs;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Toast.makeText(context,"Quelqu'un a toasté that ass",Toast.LENGTH_LONG).show();
        Log.i("MyBroadcastReceiver","value:");
    }
}
