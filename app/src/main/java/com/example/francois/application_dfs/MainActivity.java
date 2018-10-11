package com.example.francois.application_dfs;

import android.app.LauncherActivity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    static final String TAG="Centrale";

    private TextView mGreetingText;
    private EditText mNameInput;
    private Button mPlayButton;
    private Button mButtonLog;
    private Button mButtonForResult;
    private Button mButtonForResult2;
    private Button mButtonTestIntent;
    private int REQUEST_CODE=100;
    private int REQUEST_CODE2=200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlayButton = (Button) findViewById(R.id.button1);
        mButtonLog = (Button) findViewById(R.id.button2);
        mButtonForResult = (Button) findViewById(R.id.button3);
        mButtonForResult2 = (Button) findViewById(R.id.button4);
        mButtonTestIntent = (Button) findViewById(R.id.buttonTestIntent);
        mNameInput = (EditText) findViewById(R.id.activity_main_name_input);
        mGreetingText = (TextView) findViewById(R.id.activity_main_greeting_txt);

        mPlayButton.setEnabled(false);
        mNameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPlayButton.setEnabled(s.toString().length() != 0);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {  // lien avec une deuxième activité ici
                Intent secondAct = new Intent(MainActivity.this, BroadcastActivity.class);
                Toast.makeText(MainActivity.this,"Broadcast lancé",Toast.LENGTH_LONG).show();
                startActivity(secondAct);
                //the user just clicked
            }
        });

        mButtonLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent thirdAct = new Intent(MainActivity.this,ContentAdapter.class); //class est la classe à lancer dans notre intention
                Toast.makeText(MainActivity.this,"Log des contacts en cours",Toast.LENGTH_LONG).show();
                startActivity(thirdAct);
            }
        });

        mButtonForResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fourthAct = new Intent(MainActivity.this,forResultActivity.class); //class est la classe à lancer dans notre intention
                Toast.makeText(MainActivity.this,"Activité pour résultat 1",Toast.LENGTH_LONG).show();
                fourthAct.putExtra("Value1","this value one for Fourth Activity");
                fourthAct.putExtra("Value2", "this value two for Fourth Activity");
                startActivityForResult(fourthAct,REQUEST_CODE);
            }
        });

        mButtonForResult2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fifthAct = new Intent(MainActivity.this,forResultActivity2.class); //class est la classe à lancer dans notre intention
                Toast.makeText(MainActivity.this,"Activité pour résultat 2",Toast.LENGTH_LONG).show();
                fifthAct.putExtra("Value1","this value one for Fourth Activity");
                fifthAct.putExtra("Value2", "this value two for Fourth Activity");
                startActivityForResult(fifthAct,REQUEST_CODE2);
            }
        });

        mButtonTestIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sixthAct = new Intent(MainActivity.this,TestActivityIntent.class); //class est la classe à lancer dans notre intention
                startActivity(sixthAct);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE){
            if (data.hasExtra("returnKey1")){
                Toast.makeText(this,data.getExtras().getString("returnKey1"),Toast.LENGTH_SHORT).show();
            }
        }
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE2){
            if (data.hasExtra("returnKey1")){
                Intent serviceInt = new Intent(MainActivity.this,UpdaterService.class);
                serviceInt.putExtra("ValueServ",data.getExtras().getString("returnKey1"));
                startService(serviceInt);
            }
        }
    }

    protected void onDestroy(){
        Log.d(TAG,"onDestroy");
        super.onDestroy();
    }

    protected void onPause(){
        Log.d(TAG,"onPause");
        super.onPause();
    }

    protected void onRestart(){
        Log.d(TAG,"onRestart");
        super.onRestart();
    }

    @Override
    protected void onStart() {
        Log.d(TAG,"onStart");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.d(TAG,"onStop");
        super.onStop();
    }

    @Override
    protected void onResume() {
        Log.d(TAG,"onResume");
        super.onResume();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d(TAG,"onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.d(TAG,"onSaveInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
    }
}
