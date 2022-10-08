package com.tauaferreira.robiitcc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        Button button_on = findViewById(R.id.button_main_ON);
        Button button_off = findViewById(R.id.button_main_OFF);


        ConnectedThread myConn = ConnectedThread.getInstance();
        myConn.start();

        button_on.setOnClickListener(v-> {
            if(!myConn.write("E")) Toast.makeText(getBaseContext(), "Perdi a conexão", Toast.LENGTH_LONG).show();
        });

        button_off.setOnClickListener(v-> {
            if(!myConn.write("P")) Toast.makeText(getBaseContext(), "Perdi a conexão", Toast.LENGTH_LONG).show();
        });
    }
}