package com.example.francois.application_dfs;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TestActivityIntent extends AppCompatActivity {

    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_intent);

        Button buttonTestIntent = (Button) findViewById(R.id.buttonTestIntent);

        buttonTestIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = null;
                position = 3;
                switch (position){
                    case 0:
                        intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.corellis.eu"));
                        break;
                    case 1:
                        intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:0624948124"));
                        break;
                    case 2:
                        intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:0624948124"));
                        break;
                    case 3:
                        intent = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:50.123,7.14347z=19"));
                        break;
                }
                startActivity(intent);

            }
        });


    }
}
