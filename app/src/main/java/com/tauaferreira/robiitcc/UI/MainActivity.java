package com.tauaferreira.robiitcc.UI;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tauaferreira.robiitcc.R;
import com.tauaferreira.robiitcc.Utils.BluetoothSocketClass;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
        import androidx.appcompat.app.AppCompatActivity;

        import com.tauaferreira.robiitcc.R;
        import com.tauaferreira.robiitcc.Utils.BluetoothSocketClass;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//TODO - Activity de testes
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
        button_l1.setOnClickListener(this);
        button_l2.setOnClickListener(this);
        button_r1.setOnClickListener(this);
        button_r2.setOnClickListener(this);
        button_j1.setOnClickListener(this);
        button_j2.setOnClickListener(this);

    }



    private void lostConnection(String input) {

        BluetoothSocketClass btSocket = new BluetoothSocketClass();
        boolean sendMessage = btSocket.sendCommandToArduino(input);

        if(sendMessage){
            Toast.makeText(this, "Perfect", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "ERRO", Toast.LENGTH_SHORT).show();
        }
    }



    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_main_l2: lostConnection("b"); break;
            case R.id.button_main_l1: lostConnection("e"); break;
            case R.id.button_main_r1: lostConnection("c"); break;
            case R.id.button_main_r2: lostConnection("d"); break;
            case R.id.button_main_j2: lostConnection("f"); break;
        }
    }
}