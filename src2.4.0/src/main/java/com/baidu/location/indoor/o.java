package com.baidu.location.indoor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.baidu.location.indoor.mapversion.a;

class o implements SensorEventListener {
    final /* synthetic */ n a;

    o(n nVar) {
        this.a = nVar;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        float[] fArr;
        if (type != 1) {
            switch (type) {
                case 3:
                    fArr = (float[]) sensorEvent.values.clone();
                    if (this.a.k && a.b()) {
                        a.a(5, fArr, sensorEvent.timestamp);
                    }
                    this.a.P[this.a.O] = (double) fArr[0];
                    this.a.O = this.a.O + 1;
                    if (this.a.O == this.a.N) {
                        this.a.O = 0;
                    }
                    if (n.h(this.a) >= 20) {
                        this.a.Q = this.a.i();
                        if (!this.a.Q) {
                            this.a.d.unregisterListener(this.a.b, this.a.h);
                        }
                        this.a.r[0] = this.a.a(this.a.r[0], (double) fArr[0], 0.7d);
                        this.a.r[1] = (double) fArr[1];
                        this.a.r[2] = (double) fArr[2];
                        return;
                    }
                    break;
                case 4:
                    fArr = (float[]) sensorEvent.values.clone();
                    if (this.a.k && a.b()) {
                        a.a(4, fArr, sensorEvent.timestamp);
                        return;
                    }
                default:
                    return;
            }
        }
        fArr = (float[]) sensorEvent.values.clone();
        this.a.q = (float[]) fArr.clone();
        if (this.a.k && a.b()) {
            a.a(1, fArr, sensorEvent.timestamp);
        }
        float[] a = this.a.a(fArr[0], fArr[1], fArr[2]);
        if (n.b(this.a) >= 20) {
            double d = (double) (((a[0] * a[0]) + (a[1] * a[1])) + (a[2] * a[2]));
            if (this.a.n == 0) {
                if (d > 4.0d) {
                    this.a.n = 1;
                }
            } else if (d < 0.009999999776482582d) {
                this.a.n = 0;
            }
        }
    }
}
