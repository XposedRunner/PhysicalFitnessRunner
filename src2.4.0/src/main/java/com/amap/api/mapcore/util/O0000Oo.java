package com.amap.api.mapcore.util;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.WindowManager;
import com.amap.api.maps.model.Marker;

/* compiled from: SensorEventHelper */
public class O0000Oo implements SensorEventListener {
    private SensorManager O000000o;
    private Sensor O00000Oo;
    private float O00000o;
    private long O00000o0 = 0;
    private Context O00000oO;
    private ca O00000oo;
    private Marker O0000O0o;
    private boolean O0000OOo = true;

    public O0000Oo(Context context, ca caVar) {
        this.O00000oO = context.getApplicationContext();
        this.O00000oo = caVar;
        try {
            this.O000000o = (SensorManager) context.getSystemService("sensor");
            if (this.O000000o != null) {
                this.O00000Oo = this.O000000o.getDefaultSensor(3);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static int O000000o(Context context) {
        if (context != null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                switch (windowManager.getDefaultDisplay().getRotation()) {
                    case 0:
                        return 0;
                    case 1:
                        return 90;
                    case 2:
                        return 180;
                    case 3:
                        return -90;
                }
            }
        }
        return 0;
    }

    public void O000000o() {
        if (this.O000000o != null && this.O00000Oo != null) {
            this.O000000o.registerListener(this, this.O00000Oo, 3);
        }
    }

    public void O000000o(Marker marker) {
        this.O0000O0o = marker;
    }

    public void O000000o(boolean z) {
        this.O0000OOo = z;
    }

    public void O00000Oo() {
        if (this.O000000o != null && this.O00000Oo != null) {
            this.O000000o.unregisterListener(this, this.O00000Oo);
        }
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        try {
            if (System.currentTimeMillis() - this.O00000o0 >= 100) {
                if (this.O00000oo.O000000o() == null || this.O00000oo.O000000o().getAnimateionsCount() <= 0) {
                    if (sensorEvent.sensor.getType() == 3) {
                        float O000000o = (sensorEvent.values[0] + ((float) O000000o(this.O00000oO))) % 360.0f;
                        if (O000000o > 180.0f) {
                            O000000o -= 360.0f;
                        } else if (O000000o < -180.0f) {
                            O000000o += 360.0f;
                        }
                        if (Math.abs(this.O00000o - O000000o) >= 3.0f) {
                            if (Float.isNaN(O000000o)) {
                                O000000o = 0.0f;
                            }
                            this.O00000o = O000000o;
                            if (this.O0000O0o != null) {
                                if (this.O0000OOo) {
                                    this.O00000oo.O000000o(O000O0o0.O00000o(this.O00000o));
                                    this.O0000O0o.setRotateAngle(-this.O00000o);
                                } else {
                                    this.O0000O0o.setRotateAngle(360.0f - this.O00000o);
                                }
                            }
                            this.O00000o0 = System.currentTimeMillis();
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
