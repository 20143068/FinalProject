package com.example.jkseo_000.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InputData extends AppCompatActivity {
    Button BtSave;
    EditText EtEvent;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        EtEvent = (EditText) findViewById(R.id.editEvent);

        Button BtSave = (Button) findViewById(R.id.buttonSave);
        BtSave.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                String event = EtEvent.getText().toString();
                Intent intent = new Intent();
                finish();
            }
        });
    }
}
