package com.example.francois.application_dfs;

import android.app.Service;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        Button btn1 = (Button) findViewById(R.id.buttonServ1);
        Button btn2 = (Button) findViewById(R.id.buttonServ2);

        if (btn1 != null)
            btn1.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent service = new Intent(ServiceActivity.this, UpdaterService.class);
                    startService(service);
                }
            });

        if (btn2 != null)
            btn2.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent service = new Intent(ServiceActivity.this, UpdaterService.class);
                    stopService(service);
                }
            });
        }


    }

