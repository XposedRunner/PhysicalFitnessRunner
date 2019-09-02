package com.geetest.deepknow.b;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.bangcle.andJni.JniLib1557756502;
import com.geetest.deepknow.c.b;
import java.util.List;

/* compiled from: DPProSensor */
public class a implements SensorEventListener {
    private final Handler a = new Handler();
    private String b = "$unknown";
    private String c = "$unknown";
    private float d = 0.0f;
    private float e;
    private final float[] f = new float[3];
    private final SensorManager g;
    private Runnable h;
    private final Context i;
    private boolean j;
    private boolean k;
    private b l;

    /* compiled from: DPProSensor */
    /* renamed from: com.geetest.deepknow.b.a$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ List a;
        final /* synthetic */ Activity b;
        final /* synthetic */ int c;

        AnonymousClass1(List list, Activity activity, int i) {
            this.a = list;
            this.b = activity;
            this.c = i;
        }

        public void run() {
            try {
                if (!("$unknown".equals(a.this.b) || "$unknown".equals(a.this.c) || (a.this.d <= 5.0f && a.this.d >= -5.0f))) {
                    List list = this.a;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(a.this.b);
                    stringBuilder.append(a.this.c);
                    list.add(stringBuilder.toString());
                }
                if (this.a.size() == 10) {
                    a.this.l.a(com.geetest.deepknow.collection.a.a(com.geetest.deepknow.utils.a.b(this.b), com.geetest.deepknow.utils.a.a(this.b), this.a.toString().replace("[", "").replace("]", "").replace(" ", "")));
                    this.a.clear();
                }
                a.this.a.postDelayed(this, (long) this.c);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public a(Context context, b bVar) {
        int i = 0;
        this.j = false;
        this.k = false;
        this.i = context;
        this.l = bVar;
        this.g = (SensorManager) context.getSystemService("sensor");
        List sensorList = this.g.getSensorList(-1);
        while (i < sensorList.size()) {
            if (((Sensor) sensorList.get(i)).getType() == 4) {
                this.j = true;
            }
            if (((Sensor) sensorList.get(i)).getType() == 1) {
                this.k = true;
            }
            i++;
        }
    }

    public void a() {
        JniLib1557756502.cV(this, Integer.valueOf(17));
    }

    public void a(int i, Activity activity) {
        JniLib1557756502.cV(this, Integer.valueOf(i), activity, Integer.valueOf(18));
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
        JniLib1557756502.cV(this, sensor, Integer.valueOf(i), Integer.valueOf(19));
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        JniLib1557756502.cV(this, sensorEvent, Integer.valueOf(20));
    }
}
