package com.tauaferreira.robiitcc.Utils;

import android.bluetooth.BluetoothSocket;

import java.io.IOException;
import java.io.OutputStream;

public class ConnectionBluetooth {

    private OutputStream mmOutStream;
    private static volatile ConnectionBluetooth INSTANCE = null;

    public ConnectionBluetooth(OutputStream mmOutStream) {

        this.mmOutStream = mmOutStream;
    }

    public static ConnectionBluetooth getInstance() {
        if (INSTANCE == null) {
            synchronized (ConnectionBluetooth.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ConnectionBluetooth( null);
                }
            }
        }
        return INSTANCE;
    }


    public void setConnectionThread(BluetoothSocket socket) {
        OutputStream tmpOut = null;
        try {
            tmpOut = socket.getOutputStream();
        } catch (IOException ignored) {
        }
        mmOutStream = tmpOut;
    }

    public boolean write(String input) {
        try {
            mmOutStream.write(input.getBytes());
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
