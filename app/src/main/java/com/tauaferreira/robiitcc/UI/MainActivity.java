package com.tauaferreira.robiitcc.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.tauaferreira.robiitcc.Utils.ConnectedThread;
import com.tauaferreira.robiitcc.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_l1 = findViewById(R.id.button_main_l1);
        Button button_l2 = findViewById(R.id.button_main_l2);
        Button button_r1 = findViewById(R.id.button_main_r1);
        Button button_r2 = findViewById(R.id.button_main_r2);
        Button button_j1 = findViewById(R.id.button_main_j1);
        Button button_j2 = findViewById(R.id.button_main_j2);

        ConnectedThread myConn = ConnectedThread.getInstance();

        myConn.start();

        button_l1.setOnClickListener(v-> {
            if(!myConn.write("a")) {
                Toast.makeText(getBaseContext(), "Perdi a conexão", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, ConnectBluetoothActivity.class));
                finish();
            }
        });
        button_l2.setOnClickListener(v-> {
            if(!myConn.write("b")) {
                Toast.makeText(getBaseContext(), "Perdi a conexão", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, ConnectBluetoothActivity.class));
                finish();
            }
        });
        button_r1.setOnClickListener(v-> {
            if(!myConn.write("c")) {
                Toast.makeText(getBaseContext(), "Perdi a conexão", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, ConnectBluetoothActivity.class));
                finish();
            }
        });
        button_r2.setOnClickListener(v-> {
            if(!myConn.write("d")) {
                Toast.makeText(getBaseContext(), "Perdi a conexão", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, ConnectBluetoothActivity.class));
                finish();
            }
        });
        button_j1.setOnClickListener(v-> {
            if(!myConn.write("e")) {
                Toast.makeText(getBaseContext(), "Perdi a conexão", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, ConnectBluetoothActivity.class));
                finish();
            }
        });
        button_j2.setOnClickListener(v-> {
            if(!myConn.write("f")) {
                Toast.makeText(getBaseContext(), "Perdi a conexão", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, ConnectBluetoothActivity.class));
                finish();
            }
        });
    }
}