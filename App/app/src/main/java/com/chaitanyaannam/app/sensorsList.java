package com.chaitanyaannam.app;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class sensorsList extends AppCompatActivity {
    private TextView tvSesnsor;
    private SensorManager mSensorManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensors_list);
        tvSesnsor=(TextView)findViewById(R.id.tvStatus);
        StringBuilder name=new StringBuilder();
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> deviceSensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        for(Sensor senSor:deviceSensors){
            name.append("\n\n Name:"+senSor.getName()+"Vendor: "+senSor.getVendor());


        }
        tvSesnsor.setText(name);
    }
}
