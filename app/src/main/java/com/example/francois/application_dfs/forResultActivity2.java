package com.example.francois.application_dfs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class forResultActivity2 extends AppCompatActivity {

    EditText tf = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_result2);

        Button buttonResult = (Button) findViewById(R.id.buttonResult2);
        tf = (EditText) findViewById(R.id.editTextResult2);

        buttonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra("returnKey1",tf.getText().toString());
                setResult(RESULT_OK,data);
                finish();
            }
        });

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            String value1 = extras.getString("Value1");
            if (value1 != null){
                tf.setText(value1);
            }
        }
    }
}
