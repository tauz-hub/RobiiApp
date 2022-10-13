package com.tauaferreira.robiitcc.Utils;

import android.bluetooth.BluetoothSocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ConnectedThread extends Thread {


    private InputStream mmInStream;
    private OutputStream mmOutStream;
    private static volatile ConnectedThread INSTANCE = null;

    public ConnectedThread(InputStream mmInStream, OutputStream mmOutStream) {

        this.mmInStream = mmInStream;
        this.mmOutStream = mmOutStream;
    }

    public static ConnectedThread getInstance() {
        if (INSTANCE == null) {
            synchronized (ConnectedThread.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ConnectedThread(null, null);
                }
            }
        }
        return INSTANCE;
    }


    public void setConnectionThread(BluetoothSocket socket) {
        InputStream tmpIn = null;
        OutputStream tmpOut = null;
        try {
            tmpIn = socket.getInputStream();
            tmpOut = socket.getOutputStream();
        } catch (IOException ignored) {
        }
        mmInStream = tmpIn;
        mmOutStream = tmpOut;
    }

    public void run() {
        byte[] buffer = new byte[256];
        int bytes;

        //Ele permanece no modo de escuta para determinar a entrada de dados
        while (true) {
            try {
                bytes = mmInStream.read(buffer);
                String readMessage = new String(buffer, 0, bytes);
                // Envia os dados pro handler
//                    bluetoothIn.obtainMessage(handlerState, bytes, -1, readMessage).sendToTarget();
            } catch (IOException e) {
                break;
            }
        }
    }

    //Envio de quadros
    public boolean write(String input) {
        try {
            if (getInstance().isAlive()) {
                mmOutStream.write(input.getBytes());
            } else {
                return false;
            }
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
