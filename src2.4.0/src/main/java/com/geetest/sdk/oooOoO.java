package com.geetest.sdk;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GT3SensorManager */
public class oooOoO implements SensorEventListener {
    private static final String O000000o = "oooOoO";
    private SensorManager O00000Oo;
    private float O00000o;
    private final List<String> O00000o0 = new ArrayList();
    private final float[] O00000oO = new float[3];
    private boolean O00000oo;
    private int O0000O0o;

    public oooOoO(Context context) {
        int i = 0;
        this.O00000oo = false;
        this.O0000O0o = 0;
        StringBuilder stringBuilder = new StringBuilder("new GT3SensorManager");
        stringBuilder.append(hashCode());
        O0OOO00.O000000o(stringBuilder.toString());
        this.O00000Oo = (SensorManager) context.getSystemService("sensor");
        List sensorList = this.O00000Oo.getSensorList(-1);
        while (i < sensorList.size()) {
            if (((Sensor) sensorList.get(i)).getType() == 4) {
                this.O00000oo = true;
            }
            i++;
        }
    }

    public final void O000000o() {
        this.O0000O0o = 0;
        if (this.O00000oo) {
            Sensor defaultSensor = this.O00000Oo.getDefaultSensor(4);
            if (defaultSensor != null) {
                this.O00000Oo.registerListener(this, defaultSensor, 2);
            }
        }
    }

    public final void O00000Oo() {
        this.O00000o0.clear();
        if (this.O00000oo) {
            StringBuilder stringBuilder = new StringBuilder("GT3SensorManager-->unregisterSensor");
            stringBuilder.append(hashCode());
            O0OOO00.O000000o(stringBuilder.toString());
            this.O00000Oo.unregisterListener(this);
        }
    }

    public final String O00000o0() {
        if (!this.O00000oo) {
            return null;
        }
        if (this.O00000o0.size() != 0) {
            return this.O00000o0.toString();
        }
        List list = this.O00000o0;
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(0));
        arrayList.add(Integer.valueOf(0));
        arrayList.add(Integer.valueOf(0));
        arrayList.add(Integer.valueOf(0));
        list.add(0, arrayList.toString());
        return this.O00000o0.toString();
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 4) {
            if (this.O00000o != 0.0f) {
                try {
                    if (((double) sensorEvent.values[2]) > 0.15d || ((double) sensorEvent.values[2]) < -0.15d) {
                        float f = (((float) sensorEvent.timestamp) - this.O00000o) * 1.0E-9f;
                        float[] fArr = this.O00000oO;
                        fArr[0] = fArr[0] + (sensorEvent.values[0] * f);
                        fArr = this.O00000oO;
                        fArr[1] = fArr[1] + (sensorEvent.values[1] * f);
                        fArr = this.O00000oO;
                        fArr[2] = fArr[2] + (sensorEvent.values[2] * f);
                        float toDegrees = (float) Math.toDegrees((double) this.O00000oO[0]);
                        float toDegrees2 = (float) Math.toDegrees((double) this.O00000oO[1]);
                        float toDegrees3 = (float) Math.toDegrees((double) this.O00000oO[2]);
                        ArrayList arrayList = new ArrayList();
                        arrayList.clear();
                        arrayList.add(new BigDecimal((double) toDegrees).setScale(0, 4));
                        arrayList.add(new BigDecimal((double) toDegrees2).setScale(0, 4));
                        arrayList.add(new BigDecimal((double) toDegrees3).setScale(0, 4));
                        arrayList.add(new BigDecimal((double) (f * 1000.0f)).setScale(0, 4));
                        this.O00000o0.add(arrayList.toString());
                        this.O0000O0o++;
                    }
                } catch (Exception e) {
                    String str = O000000o;
                    StringBuilder stringBuilder = new StringBuilder("Exception: ");
                    stringBuilder.append(e.toString());
                    Log.e(str, stringBuilder.toString());
                    e.printStackTrace();
                    this.O0000O0o++;
                }
                if (this.O0000O0o > 25 && this.O00000oo) {
                    this.O00000Oo.unregisterListener(this);
                }
            }
            this.O00000o = (float) sensorEvent.timestamp;
        }
    }
}
