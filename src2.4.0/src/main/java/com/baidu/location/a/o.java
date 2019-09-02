package com.baidu.location.a;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.location.f;
import com.baidu.location.indoor.g;
import com.baidu.location.indoor.mapversion.IndoorJni;

public class o implements SensorEventListener {
    private static o d;
    private float[] a;
    private float[] b;
    private SensorManager c;
    private float e;
    private boolean f = false;
    private boolean g = false;
    private boolean h = false;

    private o() {
    }

    public static synchronized o a() {
        o oVar;
        synchronized (o.class) {
            if (d == null) {
                d = new o();
            }
            oVar = d;
        }
        return oVar;
    }

    public void a(boolean z) {
        this.f = z;
    }

    public synchronized void b() {
        if (!this.h) {
            if (this.f) {
                if (this.c == null) {
                    this.c = (SensorManager) f.getServiceContext().getSystemService("sensor");
                }
                if (this.c != null) {
                    Sensor defaultSensor = this.c.getDefaultSensor(11);
                    if (defaultSensor != null && this.f) {
                        this.c.registerListener(this, defaultSensor, 3);
                    }
                    defaultSensor = this.c.getDefaultSensor(2);
                    if (defaultSensor != null && this.f) {
                        this.c.registerListener(this, defaultSensor, 3);
                    }
                }
                this.h = true;
            }
        }
    }

    public void b(boolean z) {
        this.g = z;
    }

    public synchronized void c() {
        if (this.h) {
            if (this.c != null) {
                this.c.unregisterListener(this);
                this.c = null;
            }
            this.h = false;
        }
    }

    public boolean d() {
        return this.f;
    }

    public float e() {
        return this.e;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @SuppressLint({"NewApi"})
    public void onSensorChanged(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        if (type == 2) {
            this.b = (float[]) sensorEvent.values.clone();
            double sqrt = Math.sqrt((double) (((this.b[0] * this.b[0]) + (this.b[1] * this.b[1])) + (this.b[2] * this.b[2])));
            if (this.b != null) {
                try {
                    if (g.a().e()) {
                        IndoorJni.setPfGeomag(sqrt);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (type == 11) {
            this.a = (float[]) sensorEvent.values.clone();
            if (this.a != null) {
                float[] fArr = new float[9];
                try {
                    SensorManager.getRotationMatrixFromVector(fArr, this.a);
                    float[] fArr2 = new float[3];
                    SensorManager.getOrientation(fArr, fArr2);
                    this.e = (float) Math.toDegrees((double) fArr2[0]);
                    this.e = (float) Math.floor((double) (this.e >= 0.0f ? this.e : this.e + 360.0f));
                } catch (Exception unused) {
                    this.e = 0.0f;
                }
            }
        }
    }
}
