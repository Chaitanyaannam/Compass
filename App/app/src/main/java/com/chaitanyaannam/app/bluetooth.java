package com.chaitanyaannam.app;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class bluetooth extends AppCompatActivity {
    private ListView listView;
    private ArrayList<String> mDeviceList = new ArrayList<String>();
    BluetoothAdapter mBluetoothAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        listView = (ListView) findViewById(R.id.listView);

    }
    public    void onBluetooth(View view){

        Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        startActivity(enableBtIntent);


    }
    public void scanDevice(View view){
        mBluetoothAdapter.startDiscovery();
        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        registerReceiver(mReceiver, filter);

    }
    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                BluetoothDevice device = intent
                        .getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                mDeviceList.add(device.getName() + "\n" + device.getAddress());

                listView.setAdapter(new ArrayAdapter<String>(context,
                        android.R.layout.simple_list_item_1, mDeviceList));
            }
        }
    };
    @Override
    protected void onDestroy() {
        unregisterReceiver(mReceiver);
        super.onDestroy();
    }
}
