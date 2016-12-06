package com.chaitanyaannam.app;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
  private   Button btnSensors,btnCompass,btnShake,btnBluetooth;
    Intent sensors,compass,shake,bluetooth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSensors=(Button)findViewById(R.id.btnSensors);
        btnCompass=(Button)findViewById(R.id.btnComoass);


        btnShake=(Button)findViewById(R.id.btnShake);
        btnBluetooth=(Button)findViewById(R.id.btnBluetooth);
        sensors=new Intent(MainActivity.this,sensorsList.class);
        compass=new Intent(MainActivity.this,compassActivity.class);
        shake=new Intent(MainActivity.this,shakeActivity.class);
        bluetooth=new Intent(MainActivity.this, com.chaitanyaannam.app.bluetooth.class);
    }
    public void launchSensor(View view){
        startActivity(sensors);
    }
    public void goCompass(View view){
        startActivity(compass);
    }
    public void goShake(View view){
        startActivity(shake);
    }
    public void goBluetooth(View view){

        startActivity(bluetooth);


    }

}
