package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.location.AMapLocationClient;
import com.autonavi.amap.mapcore.Inner_3dMap_locationListener;
import com.autonavi.amap.mapcore.Inner_3dMap_locationManagerBase;
import com.autonavi.amap.mapcore.Inner_3dMap_locationOption;

/* compiled from: AMapLocationClient */
public class o0000000 {
    Context O000000o;
    Inner_3dMap_locationManagerBase O00000Oo = null;
    boolean O00000o = false;
    Object O00000o0 = null;
    av O00000oO = null;
    o0OO0o00 O00000oo = null;

    public o0000000(Context context) {
        try {
            this.O00000oo = bd.O000000o();
        } catch (Throwable unused) {
        }
        this.O00000oO = new av();
        O000000o(context);
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:1:0x0002, B:7:0x0012] */
    /* JADX WARNING: Missing block: B:4:0x000a, code skipped:
            r5 = move-exception;
     */
    /* JADX WARNING: Missing block: B:22:?, code skipped:
            r4.O00000o = false;
     */
    /* JADX WARNING: Missing block: B:29:0x0052, code skipped:
            com.amap.api.mapcore.util.bp.O000000o(r5, "AMapLocationClient", "AMapLocationClient 1");
     */
    /* JADX WARNING: Missing block: B:30:0x0059, code skipped:
            return;
     */
    private void O000000o(android.content.Context r5) {
        /*
        r4 = this;
        if (r5 != 0) goto L_0x000c;
    L_0x0002:
        r5 = new java.lang.IllegalArgumentException;	 Catch:{ Throwable -> 0x000a }
        r0 = "Context参数不能为null";
        r5.<init>(r0);	 Catch:{ Throwable -> 0x000a }
        throw r5;	 Catch:{ Throwable -> 0x000a }
    L_0x000a:
        r5 = move-exception;
        goto L_0x0052;
    L_0x000c:
        r5 = r5.getApplicationContext();	 Catch:{ Throwable -> 0x000a }
        r4.O000000o = r5;	 Catch:{ Throwable -> 0x000a }
        r5 = "com.amap.api.location.AMapLocationClient";
        r5 = java.lang.Class.forName(r5);	 Catch:{ Throwable -> 0x0038 }
        r0 = new android.content.ComponentName;	 Catch:{ Throwable -> 0x0038 }
        r1 = r4.O000000o;	 Catch:{ Throwable -> 0x0038 }
        r2 = "com.amap.api.location.APSService";
        r0.<init>(r1, r2);	 Catch:{ Throwable -> 0x0038 }
        r1 = 0;
        r2 = r4.O000000o;	 Catch:{ Throwable -> 0x002f }
        r2 = r2.getPackageManager();	 Catch:{ Throwable -> 0x002f }
        r3 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        r0 = r2.getServiceInfo(r0, r3);	 Catch:{ Throwable -> 0x002f }
        goto L_0x0030;
    L_0x002f:
        r0 = r1;
    L_0x0030:
        if (r5 == 0) goto L_0x003b;
    L_0x0032:
        if (r0 == 0) goto L_0x003b;
    L_0x0034:
        r5 = 1;
        r4.O00000o = r5;	 Catch:{ Throwable -> 0x0038 }
        goto L_0x003b;
    L_0x0038:
        r5 = 0;
        r4.O00000o = r5;	 Catch:{ Throwable -> 0x000a }
    L_0x003b:
        r5 = r4.O00000o;	 Catch:{ Throwable -> 0x000a }
        if (r5 == 0) goto L_0x0049;
    L_0x003f:
        r5 = new com.amap.api.location.AMapLocationClient;	 Catch:{ Throwable -> 0x000a }
        r0 = r4.O000000o;	 Catch:{ Throwable -> 0x000a }
        r5.<init>(r0);	 Catch:{ Throwable -> 0x000a }
        r4.O00000o0 = r5;	 Catch:{ Throwable -> 0x000a }
        return;
    L_0x0049:
        r5 = r4.O000000o;	 Catch:{ Throwable -> 0x000a }
        r5 = r4.O00000Oo(r5);	 Catch:{ Throwable -> 0x000a }
        r4.O00000Oo = r5;	 Catch:{ Throwable -> 0x000a }
        return;
    L_0x0052:
        r0 = "AMapLocationClient";
        r1 = "AMapLocationClient 1";
        com.amap.api.mapcore.util.bp.O000000o(r5, r0, r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.o0000000.O000000o(android.content.Context):void");
    }

    private Inner_3dMap_locationManagerBase O00000Oo(Context context) {
        Inner_3dMap_locationManagerBase inner_3dMap_locationManagerBase;
        try {
            inner_3dMap_locationManagerBase = (Inner_3dMap_locationManagerBase) oO00o000.O000000o(context, this.O00000oo, o0OOOO00.O00000o0("YY29tLmFtYXAuYXBpLndyYXBwZXIuSW5uZXJfM2RNYXBfbG9jYXRpb25NYW5hZ2VyV3JhcHBlcg=="), ax.class, new Class[]{Context.class}, new Object[]{context});
        } catch (Throwable unused) {
            inner_3dMap_locationManagerBase = new ax(context);
        }
        return inner_3dMap_locationManagerBase == null ? new ax(context) : inner_3dMap_locationManagerBase;
    }

    public void O000000o() {
        try {
            if (this.O00000o) {
                ((AMapLocationClient) this.O00000o0).startLocation();
            } else {
                this.O00000Oo.startLocation();
            }
        } catch (Throwable th) {
            bp.O000000o(th, "AMapLocationClient", "startLocation");
        }
    }

    public void O000000o(Inner_3dMap_locationListener inner_3dMap_locationListener) {
        if (inner_3dMap_locationListener == null) {
            try {
                throw new IllegalArgumentException("listener参数不能为null");
            } catch (Throwable th) {
                bp.O000000o(th, "AMapLocationClient", "setLocationListener");
            }
        } else if (this.O00000o) {
            this.O00000oO.O000000o(this.O00000o0, inner_3dMap_locationListener);
        } else {
            this.O00000Oo.setLocationListener(inner_3dMap_locationListener);
        }
    }

    public void O000000o(Inner_3dMap_locationOption inner_3dMap_locationOption) {
        if (inner_3dMap_locationOption == null) {
            try {
                throw new IllegalArgumentException("LocationManagerOption参数不能为null");
            } catch (Throwable th) {
                bp.O000000o(th, "AMapLocationClient", "setLocationOption");
            }
        } else if (this.O00000o) {
            av avVar = this.O00000oO;
            av.O000000o(this.O00000o0, inner_3dMap_locationOption);
        } else {
            this.O00000Oo.setLocationOption(inner_3dMap_locationOption);
        }
    }

    public void O00000Oo() {
        try {
            if (this.O00000o) {
                ((AMapLocationClient) this.O00000o0).stopLocation();
            } else {
                this.O00000Oo.stopLocation();
            }
        } catch (Throwable th) {
            bp.O000000o(th, "AMapLocationClient", "stopLocation");
        }
    }

    public void O00000o0() {
        try {
            if (this.O00000o) {
                ((AMapLocationClient) this.O00000o0).onDestroy();
            } else {
                this.O00000Oo.destroy();
            }
            if (this.O00000oO != null) {
                this.O00000oO = null;
            }
        } catch (Throwable th) {
            bp.O000000o(th, "AMapLocationClient", "onDestroy");
        }
    }
}
