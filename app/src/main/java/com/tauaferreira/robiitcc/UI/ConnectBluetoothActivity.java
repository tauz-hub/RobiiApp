package com.tauaferreira.robiitcc.UI;

import android.Manifest;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.tauaferreira.robiitcc.R;
import com.tauaferreira.robiitcc.UI.ActivityLessonList;
import com.tauaferreira.robiitcc.UI.MainActivity;
import com.tauaferreira.robiitcc.Utils.BluetoothSocketClass;
import com.tauaferreira.robiitcc.Utils.ConnectedThread;

import java.io.IOException;
import java.util.Set;

@SuppressLint("MissingPermission")
public class ConnectBluetoothActivity extends AppCompatActivity {
    private BluetoothAdapter btAdapter = null;
    public static String address = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_bluetooth);

        btAdapter = BluetoothAdapter.getDefaultAdapter();
        verificarBluetooth();

        Set<BluetoothDevice> pairedDeveicesList = btAdapter.getBondedDevices();

        for (BluetoothDevice pairedDevice : pairedDeveicesList) {
            if (pairedDevice.getName().equals("HC-05")) {

                address = pairedDevice.getAddress();
            }
        }

        Button button = findViewById(R.id.button_connect_bluetooth);

        button.setOnClickListener(v -> {
            onResume();
        });
    }


    private void verificarBluetooth() {
        if (!btAdapter.isEnabled()) {
            Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(getBaseContext(), "Ative a permissão do bluetooth", Toast.LENGTH_LONG).show();
                return;
            }
            startActivity(intent);
        }
    }

    public void onResume() {
        super.onResume();
        BluetoothSocket btSocket = null;

        BluetoothDevice device = btAdapter.getRemoteDevice(address);

        try {
            btSocket = BluetoothSocketClass.createBluetoothSocket(device);
        } catch (IOException e) {
            Toast.makeText(getBaseContext(), "A conexão com o Socket falhou", Toast.LENGTH_LONG).show();
        }

        try {
            assert btSocket != null;
            btSocket.connect();
            ConnectedThread myconn = ConnectedThread.getInstance();
            myconn.setConnectionThread(btSocket);

            startActivity(new Intent(this, MainActivity.class));
            finish();
        } catch (IOException e) {
            Toast.makeText(getBaseContext(), "A conexão não foi estabelecida", Toast.LENGTH_LONG).show();
            try {
                btSocket.close();
            } catch (IOException ignored) {
                Toast.makeText(getBaseContext(), "O socket falhou", Toast.LENGTH_LONG).show();
            }
        }
    }
}
