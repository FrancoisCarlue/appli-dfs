package com.example.francois.application_dfs;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BoundActivity extends AppCompatActivity {
    BoundService myService;
    boolean isBound = false;

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            BoundService.MylocalBinder binder = (BoundService.MylocalBinder) service;
            myService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            myService = null;
            isBound = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound);

        final TextView myTextView = (TextView) findViewById(R.id.textBound) ;
        Intent intent = new Intent(this, BoundService.class);
        bindService(intent, serviceConnection,BIND_AUTO_CREATE);

        Button play;
        play = (Button) findViewById(R.id.buttonBoundServ1);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myTextView.setText(myService.getCurrentTime());
            }
        });
    }


}
