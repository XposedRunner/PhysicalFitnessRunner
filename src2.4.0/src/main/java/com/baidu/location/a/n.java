package com.baidu.location.a;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.location.f;
import java.util.ArrayList;
import java.util.List;

public class n implements SensorEventListener {
    private static Object a = new Object();
    private static n b;
    private float[] c;
    private int d = 0;
    private List<Float> e = new ArrayList();
    private List<Float> f = new ArrayList();
    private boolean g = false;
    private boolean h = false;
    private SensorManager i;

    public n() {
        try {
            if (this.i == null) {
                this.i = (SensorManager) f.getServiceContext().getSystemService("sensor");
            }
            if (this.i.getDefaultSensor(6) != null) {
                this.h = true;
            }
        } catch (Exception unused) {
            this.h = false;
        }
    }

    public static n a() {
        n nVar;
        synchronized (a) {
            if (b == null) {
                b = new n();
            }
            nVar = b;
        }
        return nVar;
    }

    public void b() {
        if (this.h && !this.g) {
            try {
                this.d = 0;
                this.e.clear();
                this.f.clear();
                if (this.i == null) {
                    this.i = (SensorManager) f.getServiceContext().getSystemService("sensor");
                }
                if (this.i != null) {
                    Sensor defaultSensor = this.i.getDefaultSensor(6);
                    if (defaultSensor != null) {
                        this.i.registerListener(this, defaultSensor, 2);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.g = true;
        }
    }

    public void c() {
        if (this.g) {
            try {
                if (this.i != null) {
                    this.i.unregisterListener(this);
                    this.i = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.g = false;
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0033 */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:2|3|(3:7|8|9)|10|11) */
    public float d() {
        /*
        r5 = this;
        r0 = r5.f;
        monitor-enter(r0);
        r1 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0035 }
        r3 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r1 = r1 / r3;
        r1 = (int) r1;	 Catch:{ all -> 0x0035 }
        r2 = r5.d;	 Catch:{ all -> 0x0035 }
        r1 = r1 - r2;
        r1 = java.lang.Math.abs(r1);	 Catch:{ all -> 0x0035 }
        r2 = 5;
        r3 = 0;
        if (r1 > r2) goto L_0x0033;
    L_0x0016:
        r1 = r5.f;	 Catch:{ all -> 0x0035 }
        r1 = r1.size();	 Catch:{ all -> 0x0035 }
        if (r1 <= 0) goto L_0x0033;
    L_0x001e:
        r1 = r5.f;	 Catch:{ Throwable -> 0x0033 }
        r2 = r5.f;	 Catch:{ Throwable -> 0x0033 }
        r2 = r2.size();	 Catch:{ Throwable -> 0x0033 }
        r2 = r2 + -1;
        r1 = r1.get(r2);	 Catch:{ Throwable -> 0x0033 }
        r1 = (java.lang.Float) r1;	 Catch:{ Throwable -> 0x0033 }
        r1 = r1.floatValue();	 Catch:{ Throwable -> 0x0033 }
        r3 = r1;
    L_0x0033:
        monitor-exit(r0);	 Catch:{ all -> 0x0035 }
        return r3;
    L_0x0035:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0035 }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.a.n.d():float");
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @SuppressLint({"NewApi"})
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 6 && this.g) {
            this.c = (float[]) sensorEvent.values.clone();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis != this.d) {
                this.d = currentTimeMillis;
                if (this.e.size() > 0) {
                    currentTimeMillis = this.e.size();
                    float f = 0.0f;
                    for (Float floatValue : this.e) {
                        f += floatValue.floatValue();
                    }
                    f /= (float) currentTimeMillis;
                    synchronized (this.f) {
                        try {
                            this.f.add(Float.valueOf(f));
                            if (this.f.size() >= 4) {
                                this.f.remove(0);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            this.f.clear();
                        }
                    }
                    this.e.clear();
                    return;
                }
            }
            this.e.add(Float.valueOf(this.c[0]));
        }
    }
}
