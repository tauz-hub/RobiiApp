package com.tauaferreira.robiitcc.Utils;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;

import java.io.IOException;
import java.util.Set;
import java.util.UUID;

public class BluetoothSocketClass {
    private static final UUID BTMODULEUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    public static BluetoothSocket createBluetoothSocket(BluetoothDevice device) throws IOException {

        return device.createRfcommSocketToServiceRecord(BTMODULEUUID);
    }

    private ConnectionBluetooth myConn = ConnectionBluetooth.getInstance();

    private BluetoothAdapter btAdapter = null;
    public static String address = null;

    public BluetoothSocket getBtSocket() {

        btAdapter = BluetoothAdapter.getDefaultAdapter();

        Set<BluetoothDevice> pairedDevicesList = btAdapter.getBondedDevices();

        for (BluetoothDevice pairedDevice : pairedDevicesList) {
            if (pairedDevice.getName().equals("HC-05")) {

                address = pairedDevice.getAddress();
            }
        }

        BluetoothSocket btSocket = null;

        BluetoothDevice device = btAdapter.getRemoteDevice(address);

        try {
            btSocket = BluetoothSocketClass.createBluetoothSocket(device);
        } catch (IOException e) {
        }
        return btSocket;
    }

    public boolean sendCommandToArduino(String str){
        BluetoothSocket btSocket = null;
        try {
            btSocket = getBtSocket();

            ConnectionBluetooth myconn = ConnectionBluetooth.getInstance();
            btSocket.connect();
            myconn.setConnectionThread(btSocket);
        } catch (Exception e){
            System.out.println(e);
        }

        if (!myConn.write(str)) {
           return false;
        }
        try {
            btSocket.close();
        } catch (Exception ignore){}

        return true;
    }
}
