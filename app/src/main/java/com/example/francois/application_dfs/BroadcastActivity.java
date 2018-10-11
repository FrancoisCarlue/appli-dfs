package com.example.francois.application_dfs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BroadcastActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);

        Button btn = (Button) findViewById(R.id.buttonBroadcast);
        btn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.buttonBroadcast){
            Intent i = new Intent("eu.corellis.action.NEW_EVENT");
            i.putExtra("Value1","This value one for Broadcast"); //on passe des paramètre
            sendBroadcast(i);
        }
    }
}
