package com.chaitanyaannam.app;

import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class shakeActivity extends AppCompatActivity implements SensorListener {
    TextView tvShake;
    SensorManager sensorMgr;
    float x,y,z;
    float last_x,last_y,last_z;
    long lastUpdate;
    float SHAKE_THRESHOLD=1000;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shake);
        tvShake=(TextView)findViewById(R.id.tvShake);
        sensorMgr = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorMgr.registerListener(this, SensorManager.SENSOR_ACCELEROMETER, SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    public void onSensorChanged(int sensor, float[] values) {
        if (sensor == SensorManager.SENSOR_ACCELEROMETER) {
            long curTime = System.currentTimeMillis();
            // only allow one update every 100ms.
            if ((curTime - lastUpdate) > 100) {
                long diffTime = (curTime - lastUpdate);
                lastUpdate = curTime;

                x = values[SensorManager.DATA_X];
                y = values[SensorManager.DATA_Y];
                z = values[SensorManager.DATA_Z];

                float speed = Math.abs(x+y+z - last_x - last_y - last_z) / diffTime * 10000;

                if (speed > SHAKE_THRESHOLD) {
                    tvShake.setText("Shake detected");
                }
                last_x = x;
                last_y = y;
                last_z = z;
            }
        }

    }

    @Override
    public void onAccuracyChanged(int sensor, int accuracy) {

    }
}
