package com.loc;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;

/* compiled from: AmapSensorManager */
public final class O0OoOo implements SensorEventListener {
    SensorManager O000000o = null;
    Sensor O00000Oo = null;
    Sensor O00000o = null;
    Sensor O00000o0 = null;
    public boolean O00000oO = false;
    public double O00000oo = 0.0d;
    public float O0000O0o = 0.0f;
    Handler O0000OOo = new Handler() {
    };
    double O0000Oo = 0.0d;
    double O0000Oo0 = 0.0d;
    double O0000OoO = 0.0d;
    double O0000Ooo = 0.0d;
    final int O0000o = 100;
    volatile double O0000o0 = 0.0d;
    double[] O0000o00 = new double[3];
    long O0000o0O = 0;
    long O0000o0o = 0;
    private Context O0000oO = null;
    final int O0000oO0 = 30;
    private float O0000oOO = 1013.25f;
    private float O0000oOo = 0.0f;

    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x005e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0068 */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|(1:4)|5|6|7|8|9|10|11) */
    /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|(1:4)|5|6|7|8|9|10|11) */
    public O0OoOo(android.content.Context r5) {
        /*
        r4 = this;
        r4.<init>();
        r0 = 0;
        r4.O0000oO = r0;
        r4.O000000o = r0;
        r4.O00000Oo = r0;
        r4.O00000o0 = r0;
        r4.O00000o = r0;
        r0 = 0;
        r4.O00000oO = r0;
        r0 = 0;
        r4.O00000oo = r0;
        r2 = 0;
        r4.O0000O0o = r2;
        r3 = 1149063168; // 0x447d5000 float:1013.25 double:5.67712636E-315;
        r4.O0000oOO = r3;
        r4.O0000oOo = r2;
        r2 = new com.loc.O0OoOo$1;
        r2.<init>();
        r4.O0000OOo = r2;
        r4.O0000Oo0 = r0;
        r4.O0000Oo = r0;
        r4.O0000OoO = r0;
        r4.O0000Ooo = r0;
        r2 = 3;
        r2 = new double[r2];
        r4.O0000o00 = r2;
        r4.O0000o0 = r0;
        r0 = 0;
        r4.O0000o0O = r0;
        r4.O0000o0o = r0;
        r0 = 100;
        r4.O0000o = r0;
        r0 = 30;
        r4.O0000oO0 = r0;
        r4.O0000oO = r5;	 Catch:{ Throwable -> 0x0072 }
        r5 = r4.O000000o;	 Catch:{ Throwable -> 0x0072 }
        if (r5 != 0) goto L_0x0055;
    L_0x0049:
        r5 = r4.O0000oO;	 Catch:{ Throwable -> 0x0072 }
        r0 = "sensor";
        r5 = r5.getSystemService(r0);	 Catch:{ Throwable -> 0x0072 }
        r5 = (android.hardware.SensorManager) r5;	 Catch:{ Throwable -> 0x0072 }
        r4.O000000o = r5;	 Catch:{ Throwable -> 0x0072 }
    L_0x0055:
        r5 = r4.O000000o;	 Catch:{ Throwable -> 0x005e }
        r0 = 6;
        r5 = r5.getDefaultSensor(r0);	 Catch:{ Throwable -> 0x005e }
        r4.O00000Oo = r5;	 Catch:{ Throwable -> 0x005e }
    L_0x005e:
        r5 = r4.O000000o;	 Catch:{ Throwable -> 0x0068 }
        r0 = 11;
        r5 = r5.getDefaultSensor(r0);	 Catch:{ Throwable -> 0x0068 }
        r4.O00000o0 = r5;	 Catch:{ Throwable -> 0x0068 }
    L_0x0068:
        r5 = r4.O000000o;	 Catch:{ Throwable -> 0x0071 }
        r0 = 1;
        r5 = r5.getDefaultSensor(r0);	 Catch:{ Throwable -> 0x0071 }
        r4.O00000o = r5;	 Catch:{ Throwable -> 0x0071 }
    L_0x0071:
        return;
    L_0x0072:
        r5 = move-exception;
        r0 = "AMapSensorManager";
        r1 = "<init>";
        com.loc.O0o0000.O000000o(r5, r0, r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O0OoOo.<init>(android.content.Context):void");
    }

    public final void O000000o() {
        if (!(this.O000000o == null || this.O00000oO)) {
            this.O00000oO = true;
            try {
                if (this.O00000Oo != null) {
                    this.O000000o.registerListener(this, this.O00000Oo, 3, this.O0000OOo);
                }
            } catch (Throwable th) {
                O0o0000.O000000o(th, "AMapSensorManager", "registerListener mPressure");
            }
            try {
                if (this.O00000o0 != null) {
                    this.O000000o.registerListener(this, this.O00000o0, 3, this.O0000OOo);
                }
            } catch (Throwable th2) {
                O0o0000.O000000o(th2, "AMapSensorManager", "registerListener mRotationVector");
            }
            try {
                if (this.O00000o != null) {
                    this.O000000o.registerListener(this, this.O00000o, 3, this.O0000OOo);
                }
            } catch (Throwable th3) {
                O0o0000.O000000o(th3, "AMapSensorManager", "registerListener mAcceleroMeterVector");
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0025 A:{Catch:{ Throwable -> 0x002c }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0021 */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001a A:{Catch:{ Throwable -> 0x0021 }} */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0025 A:{Catch:{ Throwable -> 0x002c }} */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0016 */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Can't wrap try/catch for region: R(10:4|5|6|(1:8)|9|10|(1:12)|13|14|(2:16|18)(1:22)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(10:4|5|6|(1:8)|9|10|(1:12)|13|14|(2:16|18)(1:22)) */
    /* JADX WARNING: Missing block: B:19:?, code skipped:
            return;
     */
    public final void O00000Oo() {
        /*
        r2 = this;
        r0 = r2.O000000o;
        if (r0 == 0) goto L_0x002c;
    L_0x0004:
        r0 = r2.O00000oO;
        if (r0 == 0) goto L_0x002c;
    L_0x0008:
        r0 = 0;
        r2.O00000oO = r0;
        r0 = r2.O00000Oo;	 Catch:{ Throwable -> 0x0016 }
        if (r0 == 0) goto L_0x0016;
    L_0x000f:
        r0 = r2.O000000o;	 Catch:{ Throwable -> 0x0016 }
        r1 = r2.O00000Oo;	 Catch:{ Throwable -> 0x0016 }
        r0.unregisterListener(r2, r1);	 Catch:{ Throwable -> 0x0016 }
    L_0x0016:
        r0 = r2.O00000o0;	 Catch:{ Throwable -> 0x0021 }
        if (r0 == 0) goto L_0x0021;
    L_0x001a:
        r0 = r2.O000000o;	 Catch:{ Throwable -> 0x0021 }
        r1 = r2.O00000o0;	 Catch:{ Throwable -> 0x0021 }
        r0.unregisterListener(r2, r1);	 Catch:{ Throwable -> 0x0021 }
    L_0x0021:
        r0 = r2.O00000o;	 Catch:{ Throwable -> 0x002c }
        if (r0 == 0) goto L_0x002c;
    L_0x0025:
        r0 = r2.O000000o;	 Catch:{ Throwable -> 0x002c }
        r1 = r2.O00000o;	 Catch:{ Throwable -> 0x002c }
        r0.unregisterListener(r2, r1);	 Catch:{ Throwable -> 0x002c }
    L_0x002c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O0OoOo.O00000Oo():void");
    }

    public final float O00000o() {
        return this.O0000oOo;
    }

    public final double O00000o0() {
        return this.O00000oo;
    }

    public final double O00000oO() {
        return this.O0000Ooo;
    }

    public final void O00000oo() {
        try {
            O00000Oo();
            this.O00000Oo = null;
            this.O00000o0 = null;
            this.O000000o = null;
            this.O00000o = null;
            this.O00000oO = false;
        } catch (Throwable th) {
            O0o0000.O000000o(th, "AMapSensorManager", "destroy");
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent != null) {
            try {
                int type = sensorEvent.sensor.getType();
                float[] fArr;
                if (type == 1) {
                    if (this.O00000o != null) {
                        fArr = (float[]) sensorEvent.values.clone();
                        this.O0000o00[0] = (this.O0000o00[0] * 0.800000011920929d) + ((double) (fArr[0] * 0.19999999f));
                        this.O0000o00[1] = (this.O0000o00[1] * 0.800000011920929d) + ((double) (fArr[1] * 0.19999999f));
                        this.O0000o00[2] = (0.800000011920929d * this.O0000o00[2]) + ((double) (0.19999999f * fArr[2]));
                        this.O0000Oo0 = ((double) fArr[0]) - this.O0000o00[0];
                        this.O0000Oo = ((double) fArr[1]) - this.O0000o00[1];
                        this.O0000OoO = ((double) fArr[2]) - this.O0000o00[2];
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - this.O0000o0O >= 100) {
                            double sqrt = Math.sqrt(((this.O0000Oo0 * this.O0000Oo0) + (this.O0000Oo * this.O0000Oo)) + (this.O0000OoO * this.O0000OoO));
                            this.O0000o0o++;
                            this.O0000o0O = currentTimeMillis;
                            this.O0000o0 += sqrt;
                            if (this.O0000o0o >= 30) {
                                this.O0000Ooo = this.O0000o0 / ((double) this.O0000o0o);
                                this.O0000o0 = 0.0d;
                                this.O0000o0o = 0;
                            }
                        }
                    }
                } else if (type == 6) {
                    try {
                        if (this.O00000Oo != null) {
                            fArr = (float[]) sensorEvent.values.clone();
                            if (fArr != null) {
                                this.O0000O0o = fArr[0];
                            }
                            if (fArr != null) {
                                this.O00000oo = (double) OO000OO.O000000o(SensorManager.getAltitude(this.O0000oOO, fArr[0]));
                            }
                        }
                    } catch (Throwable unused) {
                    }
                } else if (type == 11) {
                    try {
                        if (this.O00000o0 != null) {
                            fArr = (float[]) sensorEvent.values.clone();
                            if (fArr != null) {
                                float[] fArr2 = new float[9];
                                SensorManager.getRotationMatrixFromVector(fArr2, fArr);
                                fArr = new float[3];
                                SensorManager.getOrientation(fArr2, fArr);
                                this.O0000oOo = (float) Math.toDegrees((double) fArr[0]);
                                this.O0000oOo = (float) Math.floor((double) (this.O0000oOo > 0.0f ? this.O0000oOo : this.O0000oOo + 360.0f));
                            }
                        }
                    } catch (Throwable unused2) {
                    }
                }
            } catch (Throwable unused3) {
            }
        }
    }
}
