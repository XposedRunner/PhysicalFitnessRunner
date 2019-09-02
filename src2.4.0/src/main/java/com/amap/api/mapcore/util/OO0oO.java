package com.amap.api.mapcore.util;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.os.RemoteException;
import android.util.Log;
import com.amap.api.mapcore.util.OO00O.O00000o0;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GroundOverlayDelegateImp */
public class OO0oO implements O0Oo00 {
    float[] O000000o;
    O00000o0 O00000Oo;
    private BitmapDescriptor O00000o;
    private ca O00000o0;
    private LatLng O00000oO;
    private float O00000oo;
    private float O0000O0o;
    private LatLngBounds O0000OOo;
    private float O0000Oo;
    private float O0000Oo0;
    private boolean O0000OoO;
    private float O0000Ooo;
    private FloatBuffer O0000o;
    private float O0000o0;
    private float O0000o00;
    private float O0000o0O;
    private String O0000o0o;
    private int O0000oO;
    private FloatBuffer O0000oO0;
    private boolean O0000oOO;
    private boolean O0000oOo;
    private by O0000oo;
    private List<O0000O0o> O0000oo0;

    private OO0oO(ca caVar) {
        this.O0000OoO = true;
        this.O0000Ooo = 0.0f;
        this.O0000o00 = 1.0f;
        this.O0000o0 = 0.5f;
        this.O0000o0O = 0.5f;
        this.O0000o = null;
        this.O0000oOO = false;
        this.O0000oOo = false;
        this.O0000oo0 = new ArrayList();
        this.O000000o = null;
        this.O00000o0 = caVar;
        try {
            this.O0000o0o = getId();
        } catch (RemoteException e) {
            ooOOOOoo.O00000o0(e, "GroundOverlayDelegateImp", "create");
            e.printStackTrace();
        }
    }

    public OO0oO(ca caVar, by byVar) {
        this(caVar);
        this.O0000oo = byVar;
    }

    private int O000000o(boolean z, BitmapDescriptor bitmapDescriptor) {
        O0000O0o O000000o;
        O0000OOo();
        if (z) {
            O000000o = this.O0000oo.O000000o(bitmapDescriptor);
            if (O000000o != null) {
                int O0000OoO = O000000o.O0000OoO();
                O000000o(O000000o);
                return O0000OoO;
            }
        }
        O000000o = null;
        int i = 0;
        if (O000000o == null) {
            O000000o = new O0000O0o(bitmapDescriptor, 0);
        }
        Bitmap bitmap = bitmapDescriptor.getBitmap();
        if (!(bitmap == null || bitmap.isRecycled())) {
            i = O0000Oo0();
            O000000o.O000000o(i);
            if (z) {
                this.O00000o0.O000000o(O000000o);
            }
            O000000o(O000000o);
            OOo000.O00000Oo(i, bitmap, true);
        }
        return i;
    }

    private void O000000o(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (floatBuffer != null && floatBuffer2 != null) {
            if (this.O00000Oo == null || this.O00000Oo.O00000o0()) {
                O0000Oo();
            }
            this.O00000Oo.O000000o();
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(1, 771);
            GLES20.glBlendColor(this.O0000o00 * 1.0f, this.O0000o00 * 1.0f, this.O0000o00 * 1.0f, this.O0000o00);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i);
            GLES20.glEnableVertexAttribArray(this.O00000Oo.O00000Oo);
            GLES20.glVertexAttribPointer(this.O00000Oo.O00000Oo, 4, 5126, false, 16, floatBuffer);
            GLES20.glEnableVertexAttribArray(this.O00000Oo.O00000o0);
            GLES20.glVertexAttribPointer(this.O00000Oo.O00000o0, 2, 5126, false, 8, floatBuffer2);
            GLES20.glUniform4f(this.O00000Oo.O0000O0o, (float) (this.O00000o0.getMapConfig().getSX() / 10000), (float) (this.O00000o0.getMapConfig().getSY() / 10000), (float) (this.O00000o0.getMapConfig().getSX() % 10000), (float) (this.O00000o0.getMapConfig().getSY() % 10000));
            GLES20.glUniform4f(this.O00000Oo.O0000OOo, this.O0000o00 * 1.0f, this.O0000o00 * 1.0f, 1.0f * this.O0000o00, this.O0000o00);
            GLES20.glUniformMatrix4fv(this.O00000Oo.O000000o, 1, false, this.O00000o0.O0000ooO(), 0);
            GLES20.glDrawArrays(6, 0, 4);
            GLES20.glBindTexture(3553, 0);
            GLES20.glDisableVertexAttribArray(this.O00000Oo.O00000Oo);
            GLES20.glDisableVertexAttribArray(this.O00000Oo.O00000o0);
            GLES20.glDisable(3042);
            GLES20.glUseProgram(0);
        }
    }

    private void O000000o(O0000O0o o0000O0o) {
        if (o0000O0o != null) {
            this.O0000oo0.add(o0000O0o);
            o0000O0o.O0000Ooo();
        }
    }

    private void O000000o(DPoint dPoint, double d, double d2, double d3, double d4, IPoint iPoint) {
        d -= d3 * ((double) this.O0000o0);
        d4 = (d4 * ((double) (1.0f - this.O0000o0O))) - d2;
        d2 = ((double) (-this.O0000Oo0)) * 0.01745329251994329d;
        iPoint.x = (int) (dPoint.x + ((Math.cos(d2) * d) + (Math.sin(d2) * d4)));
        iPoint.y = (int) (dPoint.y + ((d4 * Math.cos(d2)) - (d * Math.sin(d2))));
    }

    private void O00000o() {
        if (this.O00000oO != null) {
            double cos = ((double) this.O00000oo) / ((6371000.79d * Math.cos(this.O00000oO.latitude * 0.01745329251994329d)) * 0.01745329251994329d);
            double d = ((double) this.O0000O0o) / 111194.94043265979d;
            try {
                this.O0000OOo = new LatLngBounds(new LatLng(this.O00000oO.latitude - (((double) (1.0f - this.O0000o0O)) * d), this.O00000oO.longitude - (((double) this.O0000o0) * cos)), new LatLng(this.O00000oO.latitude + (((double) this.O0000o0O) * d), this.O00000oO.longitude + (((double) (1.0f - this.O0000o0)) * cos)));
            } catch (Throwable th) {
                th.printStackTrace();
            }
            O00000oo();
        }
    }

    private synchronized void O00000oO() {
        if (this.O0000OOo != null) {
            LatLng latLng = this.O0000OOo.southwest;
            LatLng latLng2 = this.O0000OOo.northeast;
            this.O00000oO = new LatLng(latLng.latitude + (((double) (1.0f - this.O0000o0O)) * (latLng2.latitude - latLng.latitude)), latLng.longitude + (((double) this.O0000o0) * (latLng2.longitude - latLng.longitude)));
            this.O00000oo = (float) (((Math.cos(this.O00000oO.latitude * 0.01745329251994329d) * 6371000.79d) * (latLng2.longitude - latLng.longitude)) * 0.01745329251994329d);
            this.O0000O0o = (float) ((6371000.79d * (latLng2.latitude - latLng.latitude)) * 0.01745329251994329d);
            O00000oo();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x018d A:{Catch:{ all -> 0x01a5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0184 A:{Catch:{ all -> 0x01a5 }} */
    private synchronized void O00000oo() {
        /*
        r22 = this;
        r12 = r22;
        monitor-enter(r22);
        r1 = r12.O0000OOo;	 Catch:{ all -> 0x01a5 }
        if (r1 != 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r22);
        return;
    L_0x0009:
        r1 = 16;
        r1 = new float[r1];	 Catch:{ all -> 0x01a5 }
        r12.O000000o = r1;	 Catch:{ all -> 0x01a5 }
        r13 = com.autonavi.amap.mapcore.IPoint.obtain();	 Catch:{ all -> 0x01a5 }
        r14 = com.autonavi.amap.mapcore.IPoint.obtain();	 Catch:{ all -> 0x01a5 }
        r15 = com.autonavi.amap.mapcore.IPoint.obtain();	 Catch:{ all -> 0x01a5 }
        r11 = com.autonavi.amap.mapcore.IPoint.obtain();	 Catch:{ all -> 0x01a5 }
        r1 = r12.O0000OOo;	 Catch:{ all -> 0x01a5 }
        r1 = r1.southwest;	 Catch:{ all -> 0x01a5 }
        r1 = r1.longitude;	 Catch:{ all -> 0x01a5 }
        r3 = r12.O0000OOo;	 Catch:{ all -> 0x01a5 }
        r3 = r3.southwest;	 Catch:{ all -> 0x01a5 }
        r3 = r3.latitude;	 Catch:{ all -> 0x01a5 }
        com.autonavi.ae.gmap.GLMapState.lonlat2Geo(r1, r3, r13);	 Catch:{ all -> 0x01a5 }
        r1 = r12.O0000OOo;	 Catch:{ all -> 0x01a5 }
        r1 = r1.northeast;	 Catch:{ all -> 0x01a5 }
        r1 = r1.longitude;	 Catch:{ all -> 0x01a5 }
        r3 = r12.O0000OOo;	 Catch:{ all -> 0x01a5 }
        r3 = r3.southwest;	 Catch:{ all -> 0x01a5 }
        r3 = r3.latitude;	 Catch:{ all -> 0x01a5 }
        com.autonavi.ae.gmap.GLMapState.lonlat2Geo(r1, r3, r14);	 Catch:{ all -> 0x01a5 }
        r1 = r12.O0000OOo;	 Catch:{ all -> 0x01a5 }
        r1 = r1.northeast;	 Catch:{ all -> 0x01a5 }
        r1 = r1.longitude;	 Catch:{ all -> 0x01a5 }
        r3 = r12.O0000OOo;	 Catch:{ all -> 0x01a5 }
        r3 = r3.northeast;	 Catch:{ all -> 0x01a5 }
        r3 = r3.latitude;	 Catch:{ all -> 0x01a5 }
        com.autonavi.ae.gmap.GLMapState.lonlat2Geo(r1, r3, r15);	 Catch:{ all -> 0x01a5 }
        r1 = r12.O0000OOo;	 Catch:{ all -> 0x01a5 }
        r1 = r1.southwest;	 Catch:{ all -> 0x01a5 }
        r1 = r1.longitude;	 Catch:{ all -> 0x01a5 }
        r3 = r12.O0000OOo;	 Catch:{ all -> 0x01a5 }
        r3 = r3.northeast;	 Catch:{ all -> 0x01a5 }
        r3 = r3.latitude;	 Catch:{ all -> 0x01a5 }
        com.autonavi.ae.gmap.GLMapState.lonlat2Geo(r1, r3, r11);	 Catch:{ all -> 0x01a5 }
        r1 = r12.O0000Oo0;	 Catch:{ all -> 0x01a5 }
        r2 = 0;
        r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1));
        if (r1 == 0) goto L_0x00d4;
    L_0x0062:
        r1 = r14.x;	 Catch:{ all -> 0x01a5 }
        r2 = r13.x;	 Catch:{ all -> 0x01a5 }
        r1 = r1 - r2;
        r9 = (double) r1;	 Catch:{ all -> 0x01a5 }
        r1 = r14.y;	 Catch:{ all -> 0x01a5 }
        r2 = r15.y;	 Catch:{ all -> 0x01a5 }
        r1 = r1 - r2;
        r7 = (double) r1;	 Catch:{ all -> 0x01a5 }
        r5 = com.autonavi.amap.mapcore.DPoint.obtain();	 Catch:{ all -> 0x01a5 }
        r1 = r13.x;	 Catch:{ all -> 0x01a5 }
        r1 = (double) r1;	 Catch:{ all -> 0x01a5 }
        r3 = r12.O0000o0;	 Catch:{ all -> 0x01a5 }
        r3 = (double) r3;	 Catch:{ all -> 0x01a5 }
        r3 = r3 * r9;
        r1 = r1 + r3;
        r5.x = r1;	 Catch:{ all -> 0x01a5 }
        r1 = r13.y;	 Catch:{ all -> 0x01a5 }
        r1 = (double) r1;	 Catch:{ all -> 0x01a5 }
        r3 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r4 = r12.O0000o0O;	 Catch:{ all -> 0x01a5 }
        r3 = r3 - r4;
        r3 = (double) r3;	 Catch:{ all -> 0x01a5 }
        r3 = r3 * r7;
        r1 = r1 - r3;
        r5.y = r1;	 Catch:{ all -> 0x01a5 }
        r3 = 0;
        r16 = 0;
        r1 = r12;
        r2 = r5;
        r18 = r5;
        r5 = r16;
        r16 = r7;
        r7 = r9;
        r19 = r9;
        r9 = r16;
        r21 = r11;
        r11 = r13;
        r1.O000000o(r2, r3, r5, r7, r9, r11);	 Catch:{ all -> 0x01a5 }
        r5 = 0;
        r1 = r12;
        r2 = r18;
        r3 = r19;
        r7 = r19;
        r9 = r16;
        r11 = r14;
        r1.O000000o(r2, r3, r5, r7, r9, r11);	 Catch:{ all -> 0x01a5 }
        r1 = r12;
        r2 = r18;
        r3 = r19;
        r5 = r16;
        r7 = r19;
        r9 = r16;
        r11 = r15;
        r1.O000000o(r2, r3, r5, r7, r9, r11);	 Catch:{ all -> 0x01a5 }
        r3 = 0;
        r1 = r12;
        r2 = r18;
        r5 = r16;
        r7 = r19;
        r9 = r16;
        r11 = r21;
        r1.O000000o(r2, r3, r5, r7, r9, r11);	 Catch:{ all -> 0x01a5 }
        r1 = r18;
        r1.recycle();	 Catch:{ all -> 0x01a5 }
        goto L_0x00d6;
    L_0x00d4:
        r21 = r11;
    L_0x00d6:
        r1 = r12.O000000o;	 Catch:{ all -> 0x01a5 }
        r2 = 0;
        r3 = r13.x;	 Catch:{ all -> 0x01a5 }
        r3 = r3 / 10000;
        r3 = (float) r3;	 Catch:{ all -> 0x01a5 }
        r1[r2] = r3;	 Catch:{ all -> 0x01a5 }
        r1 = r12.O000000o;	 Catch:{ all -> 0x01a5 }
        r2 = 1;
        r3 = r13.y;	 Catch:{ all -> 0x01a5 }
        r3 = r3 / 10000;
        r3 = (float) r3;	 Catch:{ all -> 0x01a5 }
        r1[r2] = r3;	 Catch:{ all -> 0x01a5 }
        r1 = r12.O000000o;	 Catch:{ all -> 0x01a5 }
        r2 = 2;
        r3 = r13.x;	 Catch:{ all -> 0x01a5 }
        r3 = r3 % 10000;
        r3 = (float) r3;	 Catch:{ all -> 0x01a5 }
        r1[r2] = r3;	 Catch:{ all -> 0x01a5 }
        r1 = r12.O000000o;	 Catch:{ all -> 0x01a5 }
        r2 = 3;
        r3 = r13.y;	 Catch:{ all -> 0x01a5 }
        r3 = r3 % 10000;
        r3 = (float) r3;	 Catch:{ all -> 0x01a5 }
        r1[r2] = r3;	 Catch:{ all -> 0x01a5 }
        r1 = r12.O000000o;	 Catch:{ all -> 0x01a5 }
        r2 = 4;
        r3 = r14.x;	 Catch:{ all -> 0x01a5 }
        r3 = r3 / 10000;
        r3 = (float) r3;	 Catch:{ all -> 0x01a5 }
        r1[r2] = r3;	 Catch:{ all -> 0x01a5 }
        r1 = r12.O000000o;	 Catch:{ all -> 0x01a5 }
        r2 = 5;
        r3 = r14.y;	 Catch:{ all -> 0x01a5 }
        r3 = r3 / 10000;
        r3 = (float) r3;	 Catch:{ all -> 0x01a5 }
        r1[r2] = r3;	 Catch:{ all -> 0x01a5 }
        r1 = r12.O000000o;	 Catch:{ all -> 0x01a5 }
        r2 = 6;
        r3 = r14.x;	 Catch:{ all -> 0x01a5 }
        r3 = r3 % 10000;
        r3 = (float) r3;	 Catch:{ all -> 0x01a5 }
        r1[r2] = r3;	 Catch:{ all -> 0x01a5 }
        r1 = r12.O000000o;	 Catch:{ all -> 0x01a5 }
        r2 = 7;
        r3 = r14.y;	 Catch:{ all -> 0x01a5 }
        r3 = r3 % 10000;
        r3 = (float) r3;	 Catch:{ all -> 0x01a5 }
        r1[r2] = r3;	 Catch:{ all -> 0x01a5 }
        r1 = r12.O000000o;	 Catch:{ all -> 0x01a5 }
        r2 = 8;
        r3 = r15.x;	 Catch:{ all -> 0x01a5 }
        r3 = r3 / 10000;
        r3 = (float) r3;	 Catch:{ all -> 0x01a5 }
        r1[r2] = r3;	 Catch:{ all -> 0x01a5 }
        r1 = r12.O000000o;	 Catch:{ all -> 0x01a5 }
        r2 = 9;
        r3 = r15.y;	 Catch:{ all -> 0x01a5 }
        r3 = r3 / 10000;
        r3 = (float) r3;	 Catch:{ all -> 0x01a5 }
        r1[r2] = r3;	 Catch:{ all -> 0x01a5 }
        r1 = r12.O000000o;	 Catch:{ all -> 0x01a5 }
        r2 = 10;
        r3 = r15.x;	 Catch:{ all -> 0x01a5 }
        r3 = r3 % 10000;
        r3 = (float) r3;	 Catch:{ all -> 0x01a5 }
        r1[r2] = r3;	 Catch:{ all -> 0x01a5 }
        r1 = r12.O000000o;	 Catch:{ all -> 0x01a5 }
        r2 = 11;
        r3 = r15.y;	 Catch:{ all -> 0x01a5 }
        r3 = r3 % 10000;
        r3 = (float) r3;	 Catch:{ all -> 0x01a5 }
        r1[r2] = r3;	 Catch:{ all -> 0x01a5 }
        r1 = r12.O000000o;	 Catch:{ all -> 0x01a5 }
        r2 = 12;
        r3 = r21;
        r4 = r3.x;	 Catch:{ all -> 0x01a5 }
        r4 = r4 / 10000;
        r4 = (float) r4;	 Catch:{ all -> 0x01a5 }
        r1[r2] = r4;	 Catch:{ all -> 0x01a5 }
        r1 = r12.O000000o;	 Catch:{ all -> 0x01a5 }
        r2 = 13;
        r4 = r3.y;	 Catch:{ all -> 0x01a5 }
        r4 = r4 / 10000;
        r4 = (float) r4;	 Catch:{ all -> 0x01a5 }
        r1[r2] = r4;	 Catch:{ all -> 0x01a5 }
        r1 = r12.O000000o;	 Catch:{ all -> 0x01a5 }
        r2 = 14;
        r4 = r3.x;	 Catch:{ all -> 0x01a5 }
        r4 = r4 % 10000;
        r4 = (float) r4;	 Catch:{ all -> 0x01a5 }
        r1[r2] = r4;	 Catch:{ all -> 0x01a5 }
        r1 = r12.O000000o;	 Catch:{ all -> 0x01a5 }
        r2 = 15;
        r4 = r3.y;	 Catch:{ all -> 0x01a5 }
        r4 = r4 % 10000;
        r4 = (float) r4;	 Catch:{ all -> 0x01a5 }
        r1[r2] = r4;	 Catch:{ all -> 0x01a5 }
        r1 = r12.O0000o;	 Catch:{ all -> 0x01a5 }
        if (r1 != 0) goto L_0x018d;
    L_0x0184:
        r1 = r12.O000000o;	 Catch:{ all -> 0x01a5 }
        r1 = com.amap.api.mapcore.util.OOo000.O000000o(r1);	 Catch:{ all -> 0x01a5 }
        r12.O0000o = r1;	 Catch:{ all -> 0x01a5 }
        goto L_0x0197;
    L_0x018d:
        r1 = r12.O000000o;	 Catch:{ all -> 0x01a5 }
        r2 = r12.O0000o;	 Catch:{ all -> 0x01a5 }
        r1 = com.amap.api.mapcore.util.OOo000.O000000o(r1, r2);	 Catch:{ all -> 0x01a5 }
        r12.O0000o = r1;	 Catch:{ all -> 0x01a5 }
    L_0x0197:
        r3.recycle();	 Catch:{ all -> 0x01a5 }
        r13.recycle();	 Catch:{ all -> 0x01a5 }
        r14.recycle();	 Catch:{ all -> 0x01a5 }
        r15.recycle();	 Catch:{ all -> 0x01a5 }
        monitor-exit(r22);
        return;
    L_0x01a5:
        r0 = move-exception;
        r1 = r0;
        monitor-exit(r22);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.OO0oO.O00000oo():void");
    }

    private void O0000O0o() {
        if (this.O00000o != null || (this.O00000o != null && this.O00000o.getBitmap() != null)) {
            int width = this.O00000o.getWidth();
            float width2 = ((float) width) / ((float) this.O00000o.getBitmap().getWidth());
            float height = ((float) this.O00000o.getHeight()) / ((float) this.O00000o.getBitmap().getHeight());
            this.O0000oO0 = OOo000.O000000o(new float[]{0.0f, height, width2, height, width2, 0.0f, 0.0f, 0.0f});
        }
    }

    private void O0000OOo() {
        if (this.O0000oo0 != null) {
            for (O0000O0o o0000O0o : this.O0000oo0) {
                if (!(o0000O0o == null || this.O0000oo == null)) {
                    this.O0000oo.O000000o(o0000O0o);
                }
            }
            this.O0000oo0.clear();
        }
    }

    private void O0000Oo() {
        if (this.O00000o0 != null) {
            this.O00000Oo = (O00000o0) this.O00000o0.O0000oOo(2);
        }
    }

    private int O0000Oo0() {
        int[] iArr = new int[]{0};
        GLES20.glGenTextures(1, iArr, 0);
        return iArr[0];
    }

    public void O000000o(float f, float f2) throws RemoteException {
        this.O0000o0 = f;
        this.O0000o0O = f2;
        this.O00000o0.setRunLowFrame(false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0019 A:{SKIP} */
    /* JADX WARNING: Missing block: B:17:0x001c, code skipped:
            O00000Oo();
     */
    /* JADX WARNING: Missing block: B:18:0x0021, code skipped:
            if (r3.O0000oOO != false) goto L_0x0034;
     */
    /* JADX WARNING: Missing block: B:20:0x0027, code skipped:
            if (android.os.Build.VERSION.SDK_INT < 12) goto L_0x002a;
     */
    /* JADX WARNING: Missing block: B:21:0x0029, code skipped:
            r0 = true;
     */
    /* JADX WARNING: Missing block: B:22:0x002a, code skipped:
            r3.O0000oO = O000000o(r0, r3.O00000o);
            r3.O0000oOO = true;
     */
    /* JADX WARNING: Missing block: B:24:0x0039, code skipped:
            if (r3.O00000oo != 0.0f) goto L_0x0042;
     */
    /* JADX WARNING: Missing block: B:26:0x003f, code skipped:
            if (r3.O0000O0o != 0.0f) goto L_0x0042;
     */
    /* JADX WARNING: Missing block: B:27:0x0041, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:28:0x0042, code skipped:
            monitor-enter(r3);
     */
    /* JADX WARNING: Missing block: B:30:?, code skipped:
            O000000o(r3.O0000oO, r3.O0000o, r3.O0000oO0);
     */
    /* JADX WARNING: Missing block: B:31:0x004c, code skipped:
            monitor-exit(r3);
     */
    /* JADX WARNING: Missing block: B:32:0x004d, code skipped:
            r3.O0000oOo = true;
     */
    /* JADX WARNING: Missing block: B:33:0x004f, code skipped:
            return;
     */
    public void O000000o(com.autonavi.amap.mapcore.MapConfig r4) throws android.os.RemoteException {
        /*
        r3 = this;
        monitor-enter(r3);
        r4 = r3.O0000OoO;	 Catch:{ all -> 0x0053 }
        r0 = 0;
        r1 = 1;
        if (r4 == 0) goto L_0x0016;
    L_0x0007:
        r4 = r3.O00000oO;	 Catch:{ all -> 0x0053 }
        if (r4 != 0) goto L_0x000f;
    L_0x000b:
        r4 = r3.O0000OOo;	 Catch:{ all -> 0x0053 }
        if (r4 == 0) goto L_0x0016;
    L_0x000f:
        r4 = r3.O00000o;	 Catch:{ all -> 0x0053 }
        if (r4 != 0) goto L_0x0014;
    L_0x0013:
        goto L_0x0016;
    L_0x0014:
        r4 = r0;
        goto L_0x0017;
    L_0x0016:
        r4 = r1;
    L_0x0017:
        if (r4 == 0) goto L_0x001b;
    L_0x0019:
        monitor-exit(r3);	 Catch:{ all -> 0x0053 }
        return;
    L_0x001b:
        monitor-exit(r3);	 Catch:{ all -> 0x0053 }
        r3.O00000Oo();
        r4 = r3.O0000oOO;
        if (r4 != 0) goto L_0x0034;
    L_0x0023:
        r4 = android.os.Build.VERSION.SDK_INT;
        r2 = 12;
        if (r4 < r2) goto L_0x002a;
    L_0x0029:
        r0 = r1;
    L_0x002a:
        r4 = r3.O00000o;
        r4 = r3.O000000o(r0, r4);
        r3.O0000oO = r4;
        r3.O0000oOO = r1;
    L_0x0034:
        r4 = r3.O00000oo;
        r0 = 0;
        r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r4 != 0) goto L_0x0042;
    L_0x003b:
        r4 = r3.O0000O0o;
        r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r4 != 0) goto L_0x0042;
    L_0x0041:
        return;
    L_0x0042:
        monitor-enter(r3);
        r4 = r3.O0000oO;	 Catch:{ all -> 0x0050 }
        r0 = r3.O0000o;	 Catch:{ all -> 0x0050 }
        r2 = r3.O0000oO0;	 Catch:{ all -> 0x0050 }
        r3.O000000o(r4, r0, r2);	 Catch:{ all -> 0x0050 }
        monitor-exit(r3);	 Catch:{ all -> 0x0050 }
        r3.O0000oOo = r1;
        return;
    L_0x0050:
        r4 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0050 }
        throw r4;
    L_0x0053:
        r4 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0053 }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.OO0oO.O000000o(com.autonavi.amap.mapcore.MapConfig):void");
    }

    public boolean O000000o() {
        return true;
    }

    /* JADX WARNING: Missing block: B:7:0x0009, code skipped:
            r2.O0000oOo = false;
     */
    /* JADX WARNING: Missing block: B:8:0x000d, code skipped:
            if (r2.O00000oO != null) goto L_0x0013;
     */
    /* JADX WARNING: Missing block: B:9:0x000f, code skipped:
            O00000oO();
     */
    /* JADX WARNING: Missing block: B:11:0x0015, code skipped:
            if (r2.O0000OOo != null) goto L_0x001b;
     */
    /* JADX WARNING: Missing block: B:12:0x0017, code skipped:
            O00000o();
     */
    /* JADX WARNING: Missing block: B:13:0x001b, code skipped:
            O00000oo();
     */
    /* JADX WARNING: Missing block: B:15:0x001f, code skipped:
            return true;
     */
    public boolean O00000Oo() throws android.os.RemoteException {
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = r2.O000000o;	 Catch:{ all -> 0x0020 }
        r1 = 0;
        if (r0 == 0) goto L_0x0008;
    L_0x0006:
        monitor-exit(r2);	 Catch:{ all -> 0x0020 }
        return r1;
    L_0x0008:
        monitor-exit(r2);	 Catch:{ all -> 0x0020 }
        r2.O0000oOo = r1;
        r0 = r2.O00000oO;
        if (r0 != 0) goto L_0x0013;
    L_0x000f:
        r2.O00000oO();
        goto L_0x001e;
    L_0x0013:
        r0 = r2.O0000OOo;
        if (r0 != 0) goto L_0x001b;
    L_0x0017:
        r2.O00000o();
        goto L_0x001e;
    L_0x001b:
        r2.O00000oo();
    L_0x001e:
        r0 = 1;
        return r0;
    L_0x0020:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0020 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.OO0oO.O00000Oo():boolean");
    }

    public boolean O00000o0() {
        return this.O0000oOo;
    }

    public void destroy() {
        try {
            remove();
            if (this.O0000oo0 != null && this.O0000oo0.size() > 0) {
                for (int i = 0; i < this.O0000oo0.size(); i++) {
                    O0000O0o o0000O0o = (O0000O0o) this.O0000oo0.get(i);
                    if (o0000O0o != null) {
                        if (this.O0000oo != null) {
                            this.O0000oo.O000000o(o0000O0o);
                        }
                        if (this.O00000o0 != null) {
                            this.O00000o0.O00000o0(o0000O0o.O0000o0O());
                        }
                    }
                }
                this.O0000oo0.clear();
            }
            if (this.O00000o != null) {
                Bitmap bitmap = this.O00000o.getBitmap();
                if (bitmap != null) {
                    bitmap.recycle();
                    this.O00000o = null;
                }
            }
            if (this.O0000oO0 != null) {
                this.O0000oO0.clear();
                this.O0000oO0 = null;
            }
            synchronized (this) {
                if (this.O0000o != null) {
                    this.O0000o.clear();
                    this.O0000o = null;
                }
                this.O0000OOo = null;
            }
            this.O00000oO = null;
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "GroundOverlayDelegateImp", "destroy");
            th.printStackTrace();
        }
    }

    public boolean equalsRemote(IOverlay iOverlay) throws RemoteException {
        return equals(iOverlay) || iOverlay.getId().equals(getId());
    }

    public float getBearing() throws RemoteException {
        return this.O0000Oo0;
    }

    public LatLngBounds getBounds() throws RemoteException {
        return this.O0000OOo;
    }

    public float getHeight() throws RemoteException {
        return this.O0000O0o;
    }

    public String getId() throws RemoteException {
        if (this.O0000o0o == null) {
            this.O0000o0o = this.O00000o0.O00000o("GroundOverlay");
        }
        return this.O0000o0o;
    }

    public LatLng getPosition() throws RemoteException {
        return this.O00000oO;
    }

    public float getTransparency() throws RemoteException {
        return this.O0000Ooo;
    }

    public float getWidth() throws RemoteException {
        return this.O00000oo;
    }

    public float getZIndex() throws RemoteException {
        return this.O0000Oo;
    }

    public int hashCodeRemote() throws RemoteException {
        return super.hashCode();
    }

    public boolean isAboveMaskLayer() {
        return false;
    }

    public boolean isVisible() throws RemoteException {
        return this.O0000OoO;
    }

    public void remove() throws RemoteException {
        this.O00000o0.O000000o(getId());
        this.O00000o0.setRunLowFrame(false);
    }

    public void setAboveMaskLayer(boolean z) {
    }

    public void setBearing(float f) throws RemoteException {
        f = ((f % 360.0f) + 360.0f) % 360.0f;
        if (((double) Math.abs(this.O0000Oo0 - f)) > 1.0E-7d) {
            this.O0000Oo0 = f;
            O00000oo();
        }
        this.O00000o0.setRunLowFrame(false);
    }

    public void setDimensions(float f) throws RemoteException {
        if (f <= 0.0f) {
            Log.w("GroundOverlayDelegateImp", "Width must be non-negative");
        }
        if (!this.O0000oOO || this.O00000oo == f) {
            this.O00000oo = f;
            this.O0000O0o = f;
        } else {
            this.O00000oo = f;
            this.O0000O0o = f;
            O00000o();
        }
        this.O00000o0.setRunLowFrame(false);
    }

    public void setDimensions(float f, float f2) throws RemoteException {
        if (f <= 0.0f || f2 <= 0.0f) {
            Log.w("GroundOverlayDelegateImp", "Width and Height must be non-negative");
        }
        if (!this.O0000oOO || this.O00000oo == f || this.O0000O0o == f2) {
            this.O00000oo = f;
            this.O0000O0o = f2;
        } else {
            this.O00000oo = f;
            this.O0000O0o = f2;
            O00000o();
        }
        this.O00000o0.setRunLowFrame(false);
    }

    public void setImage(BitmapDescriptor bitmapDescriptor) throws RemoteException {
        if (bitmapDescriptor != null && bitmapDescriptor.getBitmap() != null && !bitmapDescriptor.getBitmap().isRecycled()) {
            this.O00000o = bitmapDescriptor;
            O0000O0o();
            if (this.O0000oOO) {
                this.O0000oOO = false;
            }
            this.O00000o0.setRunLowFrame(false);
        }
    }

    public void setPosition(LatLng latLng) throws RemoteException {
        this.O00000oO = latLng;
        O00000o();
        this.O00000o0.setRunLowFrame(false);
    }

    public void setPositionFromBounds(LatLngBounds latLngBounds) throws RemoteException {
        if (latLngBounds != null) {
            this.O0000OOo = latLngBounds;
            O00000oO();
            this.O00000o0.setRunLowFrame(false);
        }
    }

    public void setTransparency(float f) throws RemoteException {
        this.O0000Ooo = (float) Math.min(1.0d, Math.max(0.0d, (double) f));
        this.O0000o00 = 1.0f - f;
        this.O00000o0.setRunLowFrame(false);
    }

    public void setVisible(boolean z) throws RemoteException {
        this.O0000OoO = z;
        this.O00000o0.setRunLowFrame(false);
    }

    public void setZIndex(float f) throws RemoteException {
        this.O0000Oo = f;
        this.O00000o0.O00000oo();
        this.O00000o0.setRunLowFrame(false);
    }
}
