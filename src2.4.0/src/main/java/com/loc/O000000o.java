package com.loc;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.amap.api.fence.GeoFence;
import com.amap.api.fence.GeoFenceListener;
import com.amap.api.fence.GeoFenceManagerBase;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.DPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"NewApi"})
/* compiled from: GeoFenceManager */
public class O000000o implements GeoFenceManagerBase {
    ooO0Ooo O000000o = null;
    Context O00000Oo = null;
    String O00000o = null;
    PendingIntent O00000o0 = null;
    GeoFenceListener O00000oO = null;
    volatile int O00000oo = 1;
    ArrayList<GeoFence> O0000O0o = new ArrayList();
    O00000o0 O0000OOo = null;
    Object O0000Oo = new Object();
    Object O0000Oo0 = new Object();
    O000000o O0000OoO = null;
    O00000Oo O0000Ooo = null;
    O00o0000 O0000o = null;
    volatile boolean O0000o0 = false;
    volatile boolean O0000o00 = false;
    volatile boolean O0000o0O = false;
    O000o00 O0000o0o = null;
    volatile AMapLocation O0000oO = null;
    AMapLocationClient O0000oO0 = null;
    long O0000oOO = 0;
    AMapLocationClientOption O0000oOo = null;
    AMapLocationListener O0000oo = new AMapLocationListener() {
        /* JADX WARNING: Removed duplicated region for block: B:18:0x006a A:{Catch:{ Throwable -> 0x00a1 }} */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x005f A:{Catch:{ Throwable -> 0x00a1 }} */
        public final void onLocationChanged(com.amap.api.location.AMapLocation r14) {
            /*
            r13 = this;
            r0 = com.loc.O000000o.this;	 Catch:{ Throwable -> 0x00a1 }
            r0 = r0.O0000ooo;	 Catch:{ Throwable -> 0x00a1 }
            if (r0 == 0) goto L_0x0007;
        L_0x0006:
            return;
        L_0x0007:
            r0 = com.loc.O000000o.this;	 Catch:{ Throwable -> 0x00a1 }
            r0 = r0.O0000o0O;	 Catch:{ Throwable -> 0x00a1 }
            if (r0 != 0) goto L_0x000e;
        L_0x000d:
            return;
        L_0x000e:
            r0 = com.loc.O000000o.this;	 Catch:{ Throwable -> 0x00a1 }
            r0.O0000oO = r14;	 Catch:{ Throwable -> 0x00a1 }
            r0 = 0;
            r2 = 0;
            r3 = 8;
            r4 = 1;
            r5 = 0;
            if (r14 == 0) goto L_0x005b;
        L_0x001b:
            r6 = r14.getErrorCode();	 Catch:{ Throwable -> 0x00a1 }
            r7 = r14.getErrorCode();	 Catch:{ Throwable -> 0x00a1 }
            if (r7 != 0) goto L_0x0035;
        L_0x0025:
            r14 = com.loc.O000000o.this;	 Catch:{ Throwable -> 0x00a1 }
            r7 = com.loc.OO000OO.O00000o0();	 Catch:{ Throwable -> 0x00a1 }
            r14.O0000oOO = r7;	 Catch:{ Throwable -> 0x00a1 }
            r14 = com.loc.O000000o.this;	 Catch:{ Throwable -> 0x00a1 }
            r7 = 5;
            r14.O000000o(r7, r2, r0);	 Catch:{ Throwable -> 0x00a1 }
            r14 = r4;
            goto L_0x005d;
        L_0x0035:
            r7 = com.loc.O000000o.this;	 Catch:{ Throwable -> 0x00a1 }
            r7 = "定位失败";
            r8 = r14.getErrorCode();	 Catch:{ Throwable -> 0x00a1 }
            r9 = r14.getErrorInfo();	 Catch:{ Throwable -> 0x00a1 }
            r10 = new java.lang.String[r4];	 Catch:{ Throwable -> 0x00a1 }
            r11 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00a1 }
            r12 = "locationDetail:";
            r11.<init>(r12);	 Catch:{ Throwable -> 0x00a1 }
            r14 = r14.getLocationDetail();	 Catch:{ Throwable -> 0x00a1 }
            r11.append(r14);	 Catch:{ Throwable -> 0x00a1 }
            r14 = r11.toString();	 Catch:{ Throwable -> 0x00a1 }
            r10[r5] = r14;	 Catch:{ Throwable -> 0x00a1 }
            com.loc.O000000o.O000000o(r7, r8, r9, r10);	 Catch:{ Throwable -> 0x00a1 }
            goto L_0x005c;
        L_0x005b:
            r6 = r3;
        L_0x005c:
            r14 = r5;
        L_0x005d:
            if (r14 == 0) goto L_0x006a;
        L_0x005f:
            r14 = com.loc.O000000o.this;	 Catch:{ Throwable -> 0x00a1 }
            r14.O0000oo0 = r5;	 Catch:{ Throwable -> 0x00a1 }
            r14 = com.loc.O000000o.this;	 Catch:{ Throwable -> 0x00a1 }
            r3 = 6;
            r14.O000000o(r3, r2, r0);	 Catch:{ Throwable -> 0x00a1 }
            return;
        L_0x006a:
            r14 = new android.os.Bundle;	 Catch:{ Throwable -> 0x00a1 }
            r14.<init>();	 Catch:{ Throwable -> 0x00a1 }
            r0 = com.loc.O000000o.this;	 Catch:{ Throwable -> 0x00a1 }
            r0 = r0.O0000o00;	 Catch:{ Throwable -> 0x00a1 }
            if (r0 != 0) goto L_0x0087;
        L_0x0075:
            r0 = com.loc.O000000o.this;	 Catch:{ Throwable -> 0x00a1 }
            r1 = 7;
            r0.O000000o(r1);	 Catch:{ Throwable -> 0x00a1 }
            r0 = "interval";
            r1 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
            r14.putLong(r0, r1);	 Catch:{ Throwable -> 0x00a1 }
            r0 = com.loc.O000000o.this;	 Catch:{ Throwable -> 0x00a1 }
            r0.O000000o(r3, r14, r1);	 Catch:{ Throwable -> 0x00a1 }
        L_0x0087:
            r0 = com.loc.O000000o.this;	 Catch:{ Throwable -> 0x00a1 }
            r1 = r0.O0000oo0;	 Catch:{ Throwable -> 0x00a1 }
            r1 = r1 + r4;
            r0.O0000oo0 = r1;	 Catch:{ Throwable -> 0x00a1 }
            r0 = com.loc.O000000o.this;	 Catch:{ Throwable -> 0x00a1 }
            r0 = r0.O0000oo0;	 Catch:{ Throwable -> 0x00a1 }
            r1 = 3;
            if (r0 < r1) goto L_0x00a1;
        L_0x0095:
            r0 = "location_errorcode";
            r14.putInt(r0, r6);	 Catch:{ Throwable -> 0x00a1 }
            r0 = com.loc.O000000o.this;	 Catch:{ Throwable -> 0x00a1 }
            r1 = 1002; // 0x3ea float:1.404E-42 double:4.95E-321;
            r0.O000000o(r1, r14);	 Catch:{ Throwable -> 0x00a1 }
        L_0x00a1:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.loc.O000000o$AnonymousClass1.onLocationChanged(com.amap.api.location.AMapLocation):void");
        }
    };
    int O0000oo0 = 0;
    final int O0000ooO = 3;
    volatile boolean O0000ooo = false;
    private Object O00oOooO = new Object();

    /* compiled from: GeoFenceManager */
    class O000000o extends Handler {
        public O000000o(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 0:
                        O000000o.this.O00000Oo(message.getData());
                        break;
                    case 1:
                        O000000o.this.O00000o0(message.getData());
                        return;
                    case 2:
                        O000000o.this.O00000oO(message.getData());
                        return;
                    case 3:
                        O000000o.this.O00000o(message.getData());
                        return;
                    case 4:
                        O000000o.this.O00000oo(message.getData());
                        return;
                    case 5:
                        O000000o.this.O00000o0();
                        return;
                    case 6:
                        O000000o.this.O000000o(O000000o.this.O0000oO);
                        return;
                    case 7:
                        O000000o.this.O00000Oo();
                        return;
                    case 8:
                        O000000o.this.O0000Oo(message.getData());
                        return;
                    case 9:
                        O000000o.this.O000000o(message.getData());
                        return;
                    case 10:
                        O000000o.this.O000000o();
                        return;
                    case 11:
                        O000000o.this.O0000OOo(message.getData());
                        return;
                    case 12:
                        O000000o.this.O0000O0o(message.getData());
                        return;
                    case 13:
                        O000000o.this.O00000o();
                        return;
                    default:
                        return;
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: GeoFenceManager */
    static class O00000Oo extends HandlerThread {
        public O00000Oo(String str) {
            super(str);
        }

        public final void run() {
            try {
                super.run();
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: GeoFenceManager */
    class O00000o0 extends Handler {
        public O00000o0(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            try {
                Bundle data = message.getData();
                switch (message.what) {
                    case 1000:
                        O000000o.this.O0000Oo0(data);
                        break;
                    case 1001:
                        try {
                            O000000o.this.O000000o((GeoFence) data.getParcelable("geoFence"));
                            return;
                        } catch (Throwable th) {
                            th.printStackTrace();
                            return;
                        }
                    case 1002:
                        O000000o.this.O00000Oo(data.getInt(GeoFence.BUNDLE_KEY_LOCERRORCODE));
                        return;
                    default:
                        return;
                }
            } catch (Throwable unused) {
            }
        }
    }

    public O000000o(Context context) {
        try {
            this.O00000Oo = context.getApplicationContext();
            O00000oO();
        } catch (Throwable th) {
            O0o0000.O000000o(th, "GeoFenceManger", "<init>");
        }
    }

    static float O000000o(DPoint dPoint, List<DPoint> list) {
        float f = Float.MAX_VALUE;
        if (!(dPoint == null || list == null || list.isEmpty())) {
            for (DPoint O000000o : list) {
                f = Math.min(f, OO000OO.O000000o(dPoint, O000000o));
            }
        }
        return f;
    }

    private int O000000o(List<GeoFence> list) {
        try {
            if (this.O0000O0o == null) {
                this.O0000O0o = new ArrayList();
            }
            for (GeoFence O00000Oo : list) {
                O00000Oo(O00000Oo);
            }
            return 0;
        } catch (Throwable th) {
            O0o0000.O000000o(th, "GeoFenceManager", "addGeoFenceList");
            O000000o("添加围栏失败", 8, th.getMessage(), new String[0]);
            return 8;
        }
    }

    private static Bundle O000000o(GeoFence geoFence, String str, String str2, int i, int i2) {
        Bundle bundle = new Bundle();
        String str3 = GeoFence.BUNDLE_KEY_FENCEID;
        if (str == null) {
            str = "";
        }
        bundle.putString(str3, str);
        bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str2);
        bundle.putInt("event", i);
        bundle.putInt(GeoFence.BUNDLE_KEY_LOCERRORCODE, i2);
        bundle.putParcelable(GeoFence.BUNDLE_KEY_FENCE, geoFence);
        return bundle;
    }

    private GeoFence O000000o(Bundle bundle, boolean z) {
        GeoFence geoFence = new GeoFence();
        Object arrayList = new ArrayList();
        DPoint dPoint = new DPoint();
        if (z) {
            geoFence.setType(1);
            arrayList = bundle.getParcelableArrayList("pointList");
            if (arrayList != null) {
                dPoint = O00000Oo((List) arrayList);
            }
            geoFence.setMaxDis2Center(O00000Oo(dPoint, (List) arrayList));
            geoFence.setMinDis2Center(O000000o(dPoint, (List) arrayList));
        } else {
            geoFence.setType(0);
            dPoint = (DPoint) bundle.getParcelable("centerPoint");
            if (dPoint != null) {
                arrayList.add(dPoint);
            }
            float f = bundle.getFloat("fenceRadius", 1000.0f);
            if (f <= 0.0f) {
                f = 1000.0f;
            }
            geoFence.setRadius(f);
            geoFence.setMinDis2Center(f);
            geoFence.setMaxDis2Center(f);
        }
        geoFence.setActivatesAction(this.O00000oo);
        geoFence.setCustomId(bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(arrayList);
        geoFence.setPointList(arrayList2);
        geoFence.setCenter(dPoint);
        geoFence.setPendingIntentAction(this.O00000o);
        geoFence.setExpiration(-1);
        geoFence.setPendingIntent(this.O00000o0);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(O00o0000.O000000o());
        geoFence.setFenceId(stringBuilder.toString());
        if (this.O000000o != null) {
            this.O000000o.O000000o(this.O00000Oo, 2);
        }
        return geoFence;
    }

    static void O000000o(String str, int i, String str2, String... strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("===========================================\n");
        StringBuilder stringBuilder = new StringBuilder("              ");
        stringBuilder.append(str);
        stringBuilder.append("                ");
        stringBuffer.append(stringBuilder.toString());
        stringBuffer.append("\n");
        stringBuffer.append("-------------------------------------------\n");
        StringBuilder stringBuilder2 = new StringBuilder("errorCode:");
        stringBuilder2.append(i);
        stringBuffer.append(stringBuilder2.toString());
        stringBuffer.append("\n");
        stringBuilder2 = new StringBuilder("错误信息:");
        stringBuilder2.append(str2);
        stringBuffer.append(stringBuilder2.toString());
        stringBuffer.append("\n");
        if (strArr != null && strArr.length > 0) {
            for (String str22 : strArr) {
                stringBuffer.append(str22);
                stringBuffer.append("\n");
            }
        }
        stringBuffer.append("===========================================\n");
        Log.i("fenceErrLog", stringBuffer.toString());
    }

    private static boolean O000000o(GeoFence geoFence, int i) {
        boolean z = false;
        if ((1 & i) == 1) {
            try {
                if (geoFence.getStatus() == 1) {
                    z = true;
                }
            } catch (Throwable th) {
                O0o0000.O000000o(th, "Utils", "remindStatus");
            }
        }
        if ((2 & i) == 2 && geoFence.getStatus() == 2) {
            z = true;
        }
        if ((i & 4) == 4 && geoFence.getStatus() == 3) {
            return true;
        }
        return z;
    }

    private static boolean O000000o(AMapLocation aMapLocation, GeoFence geoFence) {
        Throwable th;
        boolean z;
        try {
            if (!(!OO000OO.O000000o(aMapLocation) || geoFence == null || geoFence.getPointList() == null || geoFence.getPointList().isEmpty())) {
                switch (geoFence.getType()) {
                    case 0:
                    case 2:
                        DPoint center = geoFence.getCenter();
                        if ((OO000OO.O000000o(new double[]{center.getLatitude(), center.getLongitude(), aMapLocation.getLatitude(), aMapLocation.getLongitude()}) <= geoFence.getRadius() ? 1 : 0) != 0) {
                            return true;
                        }
                        break;
                    case 1:
                    case 3:
                        int i = 0;
                        for (List list : geoFence.getPointList()) {
                            try {
                                if (list.size() < 3 ? false : O0o0000.O000000o(new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude()), list)) {
                                    i = 1;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                z = i;
                                O0o0000.O000000o(th, "Utils", "isInGeoFence");
                                return z;
                            }
                        }
                        return i;
                    default:
                        break;
                }
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            z = false;
            O0o0000.O000000o(th, "Utils", "isInGeoFence");
            return z;
        }
    }

    static float O00000Oo(DPoint dPoint, List<DPoint> list) {
        float f = Float.MIN_VALUE;
        if (!(dPoint == null || list == null || list.isEmpty())) {
            for (DPoint O000000o : list) {
                f = Math.max(f, OO000OO.O000000o(dPoint, O000000o));
            }
        }
        return f;
    }

    private int O00000Oo(GeoFence geoFence) {
        try {
            if (this.O0000O0o == null) {
                this.O0000O0o = new ArrayList();
            }
            if (this.O0000O0o.contains(geoFence)) {
                return 17;
            }
            this.O0000O0o.add(geoFence);
            return 0;
        } catch (Throwable th) {
            O0o0000.O000000o(th, "GeoFenceManager", "addGeoFence2List");
            O000000o("添加围栏失败", 8, th.getMessage(), new String[0]);
            return 8;
        }
    }

    private static DPoint O00000Oo(List<DPoint> list) {
        DPoint dPoint = new DPoint();
        if (list != null) {
            try {
                double d = 0.0d;
                double d2 = 0.0d;
                for (DPoint dPoint2 : list) {
                    d += dPoint2.getLatitude();
                    d2 += dPoint2.getLongitude();
                }
                return new DPoint(OO000OO.O00000o0(d / ((double) list.size())), OO000OO.O00000o0(d2 / ((double) list.size())));
            } catch (Throwable th) {
                O0o0000.O000000o(th, "GeoFenceUtil", "getPolygonCenter");
            }
        }
        return dPoint;
    }

    /* JADX WARNING: Missing block: B:11:0x005c, code skipped:
            r23 = r8;
     */
    /* JADX WARNING: Missing block: B:24:0x00c6, code skipped:
            if (android.text.TextUtils.isEmpty(r15) != false) goto L_0x0056;
     */
    /* JADX WARNING: Missing block: B:29:0x00d5, code skipped:
            r7 = 1;
     */
    private void O00000Oo(int r26, android.os.Bundle r27) {
        /*
        r25 = this;
        r1 = r25;
        r2 = r26;
        r3 = r27;
        r4 = new android.os.Bundle;
        r4.<init>();
        r8 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x020e, all -> 0x0208 }
        r8.<init>();	 Catch:{ Throwable -> 0x020e, all -> 0x0208 }
        if (r3 == 0) goto L_0x01fc;
    L_0x0012:
        r10 = r27.isEmpty();	 Catch:{ Throwable -> 0x020e, all -> 0x0208 }
        if (r10 != 0) goto L_0x01fc;
    L_0x0018:
        r11 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x020e, all -> 0x0208 }
        r11.<init>();	 Catch:{ Throwable -> 0x020e, all -> 0x0208 }
        r12 = "customId";
        r12 = r3.getString(r12);	 Catch:{ Throwable -> 0x020e, all -> 0x0208 }
        r13 = "keyWords";
        r13 = r3.getString(r13);	 Catch:{ Throwable -> 0x020e, all -> 0x0208 }
        r14 = "city";
        r19 = r3.getString(r14);	 Catch:{ Throwable -> 0x020e, all -> 0x0208 }
        r14 = "poiType";
        r15 = r3.getString(r14);	 Catch:{ Throwable -> 0x020e, all -> 0x0208 }
        r14 = "centerPoint";
        r14 = r3.getParcelable(r14);	 Catch:{ Throwable -> 0x020e, all -> 0x0208 }
        r14 = (com.amap.api.location.DPoint) r14;	 Catch:{ Throwable -> 0x020e, all -> 0x0208 }
        r10 = "searchSize";
        r6 = 10;
        r6 = r3.getInt(r10, r6);	 Catch:{ Throwable -> 0x020e, all -> 0x0208 }
        r10 = "aroundRadius";
        r5 = 1161527296; // 0x453b8000 float:3000.0 double:5.738707337E-315;
        r3 = r3.getFloat(r10, r5);	 Catch:{ Throwable -> 0x020e, all -> 0x0208 }
        r5 = android.text.TextUtils.isEmpty(r13);	 Catch:{ Throwable -> 0x020e, all -> 0x0208 }
        if (r5 == 0) goto L_0x0059;
    L_0x0054:
        r23 = r8;
    L_0x0056:
        r7 = 0;
        goto L_0x00d6;
    L_0x0059:
        switch(r2) {
            case 1: goto L_0x00c0;
            case 2: goto L_0x0060;
            default: goto L_0x005c;
        };
    L_0x005c:
        r23 = r8;
        goto L_0x00d5;
    L_0x0060:
        if (r14 != 0) goto L_0x0063;
    L_0x0062:
        goto L_0x0054;
    L_0x0063:
        r16 = r14.getLatitude();	 Catch:{ Throwable -> 0x00d0, all -> 0x00c9 }
        r20 = 4636033603912859648; // 0x4056800000000000 float:0.0 double:90.0;
        r5 = (r16 > r20 ? 1 : (r16 == r20 ? 0 : -1));
        if (r5 > 0) goto L_0x0097;
    L_0x0070:
        r16 = r14.getLatitude();	 Catch:{ Throwable -> 0x00d0, all -> 0x00c9 }
        r20 = -4587338432941916160; // 0xc056800000000000 float:0.0 double:-90.0;
        r5 = (r16 > r20 ? 1 : (r16 == r20 ? 0 : -1));
        if (r5 < 0) goto L_0x0097;
    L_0x007d:
        r16 = r14.getLongitude();	 Catch:{ Throwable -> 0x00d0, all -> 0x00c9 }
        r20 = 4640537203540230144; // 0x4066800000000000 float:0.0 double:180.0;
        r5 = (r16 > r20 ? 1 : (r16 == r20 ? 0 : -1));
        if (r5 > 0) goto L_0x0097;
    L_0x008a:
        r16 = r14.getLongitude();	 Catch:{ Throwable -> 0x00d0, all -> 0x00c9 }
        r20 = -4582834833314545664; // 0xc066800000000000 float:0.0 double:-180.0;
        r5 = (r16 > r20 ? 1 : (r16 == r20 ? 0 : -1));
        if (r5 >= 0) goto L_0x005c;
    L_0x0097:
        r5 = "添加围栏失败";
        r10 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00d0, all -> 0x00c9 }
        r9 = "经纬度错误，传入的纬度：";
        r10.<init>(r9);	 Catch:{ Throwable -> 0x00d0, all -> 0x00c9 }
        r23 = r8;
        r7 = r14.getLatitude();	 Catch:{ Throwable -> 0x00d0, all -> 0x00c9 }
        r10.append(r7);	 Catch:{ Throwable -> 0x00d0, all -> 0x00c9 }
        r7 = "传入的经度:";
        r10.append(r7);	 Catch:{ Throwable -> 0x00d0, all -> 0x00c9 }
        r7 = r14.getLongitude();	 Catch:{ Throwable -> 0x00d0, all -> 0x00c9 }
        r10.append(r7);	 Catch:{ Throwable -> 0x00d0, all -> 0x00c9 }
        r7 = r10.toString();	 Catch:{ Throwable -> 0x00d0, all -> 0x00c9 }
        r8 = 0;
        r9 = new java.lang.String[r8];	 Catch:{ Throwable -> 0x00d0, all -> 0x00c9 }
        O000000o(r5, r8, r7, r9);	 Catch:{ Throwable -> 0x00d0, all -> 0x00c9 }
        goto L_0x0056;
    L_0x00c0:
        r23 = r8;
        r5 = android.text.TextUtils.isEmpty(r15);	 Catch:{ Throwable -> 0x00d0, all -> 0x00c9 }
        if (r5 == 0) goto L_0x00d5;
    L_0x00c8:
        goto L_0x0056;
    L_0x00c9:
        r0 = move-exception;
        r3 = r0;
        r2 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r8 = 0;
        goto L_0x0226;
    L_0x00d0:
        r0 = move-exception;
        r2 = r0;
        r7 = 0;
        goto L_0x0212;
    L_0x00d5:
        r7 = 1;
    L_0x00d6:
        if (r7 == 0) goto L_0x01e7;
    L_0x00d8:
        r5 = new android.os.Bundle;	 Catch:{ Throwable -> 0x020e, all -> 0x0208 }
        r5.<init>();	 Catch:{ Throwable -> 0x020e, all -> 0x0208 }
        r7 = "customId";
        r5.putString(r7, r12);	 Catch:{ Throwable -> 0x020e, all -> 0x0208 }
        r7 = "pendingIntentAction";
        r8 = r1.O00000o;	 Catch:{ Throwable -> 0x020e, all -> 0x0208 }
        r5.putString(r7, r8);	 Catch:{ Throwable -> 0x020e, all -> 0x0208 }
        r7 = "expiration";
        r8 = -1;
        r5.putLong(r7, r8);	 Catch:{ Throwable -> 0x020e, all -> 0x0208 }
        r7 = "activatesAction";
        r8 = r1.O00000oo;	 Catch:{ Throwable -> 0x020e, all -> 0x0208 }
        r5.putInt(r7, r8);	 Catch:{ Throwable -> 0x020e, all -> 0x0208 }
        switch(r2) {
            case 1: goto L_0x0149;
            case 2: goto L_0x0107;
            case 3: goto L_0x00fc;
            default: goto L_0x00fa;
        };
    L_0x00fa:
        r10 = 0;
        goto L_0x0163;
    L_0x00fc:
        r3 = r1.O0000o0o;	 Catch:{ Throwable -> 0x00d0, all -> 0x00c9 }
        r6 = r1.O00000Oo;	 Catch:{ Throwable -> 0x00d0, all -> 0x00c9 }
        r7 = "http://restapi.amap.com/v3/config/district?";
        r10 = r3.O000000o(r6, r7, r13);	 Catch:{ Throwable -> 0x00d0, all -> 0x00c9 }
        goto L_0x0163;
    L_0x0107:
        r7 = r14.getLatitude();	 Catch:{ Throwable -> 0x00d0, all -> 0x00c9 }
        r7 = com.loc.OO000OO.O00000o0(r7);	 Catch:{ Throwable -> 0x00d0, all -> 0x00c9 }
        r9 = r14.getLongitude();	 Catch:{ Throwable -> 0x00d0, all -> 0x00c9 }
        r9 = com.loc.OO000OO.O00000o0(r9);	 Catch:{ Throwable -> 0x00d0, all -> 0x00c9 }
        r3 = java.lang.Float.valueOf(r3);	 Catch:{ Throwable -> 0x00d0, all -> 0x00c9 }
        r3 = r3.intValue();	 Catch:{ Throwable -> 0x00d0, all -> 0x00c9 }
        r14 = "fenceRadius";
        r24 = r15;
        r15 = 1128792064; // 0x43480000 float:200.0 double:5.5769738E-315;
        r5.putFloat(r14, r15);	 Catch:{ Throwable -> 0x00d0, all -> 0x00c9 }
        r14 = r1.O0000o0o;	 Catch:{ Throwable -> 0x00d0, all -> 0x00c9 }
        r15 = r1.O00000Oo;	 Catch:{ Throwable -> 0x00d0, all -> 0x00c9 }
        r16 = "http://restapi.amap.com/v3/place/around?";
        r19 = java.lang.String.valueOf(r6);	 Catch:{ Throwable -> 0x00d0, all -> 0x00c9 }
        r20 = java.lang.String.valueOf(r7);	 Catch:{ Throwable -> 0x00d0, all -> 0x00c9 }
        r21 = java.lang.String.valueOf(r9);	 Catch:{ Throwable -> 0x00d0, all -> 0x00c9 }
        r22 = java.lang.String.valueOf(r3);	 Catch:{ Throwable -> 0x00d0, all -> 0x00c9 }
        r3 = r24;
        r17 = r13;
        r18 = r3;
        r10 = r14.O000000o(r15, r16, r17, r18, r19, r20, r21, r22);	 Catch:{ Throwable -> 0x00d0, all -> 0x00c9 }
        goto L_0x0163;
    L_0x0149:
        r3 = r15;
        r7 = "fenceRadius";
        r8 = 1148846080; // 0x447a0000 float:1000.0 double:5.676053805E-315;
        r5.putFloat(r7, r8);	 Catch:{ Throwable -> 0x00d0, all -> 0x00c9 }
        r14 = r1.O0000o0o;	 Catch:{ Throwable -> 0x00d0, all -> 0x00c9 }
        r15 = r1.O00000Oo;	 Catch:{ Throwable -> 0x00d0, all -> 0x00c9 }
        r16 = "http://restapi.amap.com/v3/place/text?";
        r20 = java.lang.String.valueOf(r6);	 Catch:{ Throwable -> 0x00d0, all -> 0x00c9 }
        r17 = r13;
        r18 = r3;
        r10 = r14.O000000o(r15, r16, r17, r18, r19, r20);	 Catch:{ Throwable -> 0x00d0, all -> 0x00c9 }
    L_0x0163:
        r6 = 4;
        if (r10 == 0) goto L_0x01e3;
    L_0x0166:
        r3 = 1;
        if (r3 != r2) goto L_0x0170;
    L_0x0169:
        r3 = r1.O0000o;	 Catch:{ Throwable -> 0x00d0, all -> 0x00c9 }
        r7 = com.loc.O00o0000.O000000o(r10, r11, r5);	 Catch:{ Throwable -> 0x00d0, all -> 0x00c9 }
        goto L_0x0171;
    L_0x0170:
        r7 = 0;
    L_0x0171:
        r3 = 2;
        if (r3 != r2) goto L_0x017a;
    L_0x0174:
        r3 = r1.O0000o;	 Catch:{ Throwable -> 0x00d0, all -> 0x00c9 }
        r7 = com.loc.O00o0000.O00000Oo(r10, r11, r5);	 Catch:{ Throwable -> 0x00d0, all -> 0x00c9 }
    L_0x017a:
        r3 = 3;
        if (r3 != r2) goto L_0x0184;
    L_0x017d:
        r2 = r1.O0000o;	 Catch:{ Throwable -> 0x00d0, all -> 0x00c9 }
        r2 = r2.O00000o0(r10, r11, r5);	 Catch:{ Throwable -> 0x00d0, all -> 0x00c9 }
        goto L_0x0185;
    L_0x0184:
        r2 = r7;
    L_0x0185:
        r3 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        if (r2 != r3) goto L_0x01a6;
    L_0x0189:
        r2 = r11.isEmpty();	 Catch:{ Throwable -> 0x00d0, all -> 0x00c9 }
        if (r2 == 0) goto L_0x0196;
    L_0x018f:
        r2 = 16;
        r7 = r2;
        r3 = r23;
        goto L_0x01ea;
    L_0x0196:
        r7 = r1.O000000o(r11);	 Catch:{ Throwable -> 0x00d0, all -> 0x00c9 }
        if (r7 != 0) goto L_0x01a2;
    L_0x019c:
        r3 = r23;
        r3.addAll(r11);	 Catch:{ Throwable -> 0x01f9, all -> 0x01f5 }
        goto L_0x01ea;
    L_0x01a2:
        r3 = r23;
        r6 = r7;
        goto L_0x01e5;
    L_0x01a6:
        r3 = r23;
        r5 = 7;
        r7 = 1;
        if (r2 == r7) goto L_0x01c4;
    L_0x01ac:
        if (r2 == r5) goto L_0x01c4;
    L_0x01ae:
        switch(r2) {
            case 4: goto L_0x01c4;
            case 5: goto L_0x01c4;
            default: goto L_0x01b1;
        };
    L_0x01b1:
        switch(r2) {
            case 16: goto L_0x01c4;
            case 17: goto L_0x01c4;
            default: goto L_0x01b4;
        };
    L_0x01b4:
        switch(r2) {
            case 10000: goto L_0x01c3;
            case 10001: goto L_0x01c1;
            case 10002: goto L_0x01c1;
            case 10003: goto L_0x01bf;
            case 10004: goto L_0x01bf;
            case 10005: goto L_0x01bf;
            case 10006: goto L_0x01bf;
            case 10007: goto L_0x01c1;
            case 10008: goto L_0x01c1;
            case 10009: goto L_0x01c1;
            case 10010: goto L_0x01bf;
            case 10011: goto L_0x01bf;
            case 10012: goto L_0x01c1;
            case 10013: goto L_0x01c1;
            case 10014: goto L_0x01bf;
            case 10015: goto L_0x01bf;
            case 10016: goto L_0x01bf;
            case 10017: goto L_0x01bf;
            default: goto L_0x01b7;
        };
    L_0x01b7:
        switch(r2) {
            case 20000: goto L_0x01bd;
            case 20001: goto L_0x01bd;
            case 20002: goto L_0x01bd;
            case 20003: goto L_0x01ba;
            default: goto L_0x01ba;
        };
    L_0x01ba:
        r2 = 8;
        goto L_0x01c4;
    L_0x01bd:
        r2 = r7;
        goto L_0x01c4;
    L_0x01bf:
        r2 = r6;
        goto L_0x01c4;
    L_0x01c1:
        r2 = r5;
        goto L_0x01c4;
    L_0x01c3:
        r2 = 0;
    L_0x01c4:
        if (r2 == 0) goto L_0x01e1;
    L_0x01c6:
        r5 = "添加围栏失败";
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x020e, all -> 0x0208 }
        r7 = "searchErrCode is ";
        r6.<init>(r7);	 Catch:{ Throwable -> 0x020e, all -> 0x0208 }
        r6.append(r2);	 Catch:{ Throwable -> 0x020e, all -> 0x0208 }
        r6 = r6.toString();	 Catch:{ Throwable -> 0x020e, all -> 0x0208 }
        r8 = 0;
        r7 = new java.lang.String[r8];	 Catch:{ Throwable -> 0x01df, all -> 0x01dd }
        O000000o(r5, r2, r6, r7);	 Catch:{ Throwable -> 0x01df, all -> 0x01dd }
        goto L_0x01e1;
    L_0x01dd:
        r0 = move-exception;
        goto L_0x020a;
    L_0x01df:
        r0 = move-exception;
        goto L_0x0210;
    L_0x01e1:
        r7 = r2;
        goto L_0x01ea;
    L_0x01e3:
        r3 = r23;
    L_0x01e5:
        r7 = r6;
        goto L_0x01ea;
    L_0x01e7:
        r3 = r23;
        r7 = 1;
    L_0x01ea:
        r2 = "customId";
        r4.putString(r2, r12);	 Catch:{ Throwable -> 0x01f9, all -> 0x01f5 }
        r2 = "resultList";
        r4.putParcelableArrayList(r2, r3);	 Catch:{ Throwable -> 0x01f9, all -> 0x01f5 }
        goto L_0x01fd;
    L_0x01f5:
        r0 = move-exception;
        r3 = r0;
        r8 = r7;
        goto L_0x020b;
    L_0x01f9:
        r0 = move-exception;
        r2 = r0;
        goto L_0x0212;
    L_0x01fc:
        r7 = 1;
    L_0x01fd:
        r2 = "errorCode";
        r4.putInt(r2, r7);
    L_0x0202:
        r2 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r1.O000000o(r2, r4);
        return;
    L_0x0208:
        r0 = move-exception;
        r8 = 0;
    L_0x020a:
        r3 = r0;
    L_0x020b:
        r2 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        goto L_0x0226;
    L_0x020e:
        r0 = move-exception;
        r8 = 0;
    L_0x0210:
        r2 = r0;
        r7 = r8;
    L_0x0212:
        r3 = "GeoFenceManager";
        r5 = "doAddGeoFenceNearby";
        com.loc.O0o0000.O000000o(r2, r3, r5);	 Catch:{ all -> 0x0221 }
        r2 = "errorCode";
        r3 = 8;
        r4.putInt(r2, r3);
        goto L_0x0202;
    L_0x0221:
        r0 = move-exception;
        r2 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r3 = r0;
        r8 = r7;
    L_0x0226:
        r5 = "errorCode";
        r4.putInt(r5, r8);
        r1.O000000o(r2, r4);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O000000o.O00000Oo(int, android.os.Bundle):void");
    }

    private static boolean O00000Oo(AMapLocation aMapLocation, GeoFence geoFence) {
        Throwable th;
        boolean z = true;
        try {
            if (O000000o(aMapLocation, geoFence)) {
                if (geoFence.getEnterTime() == -1) {
                    if (geoFence.getStatus() != 1) {
                        geoFence.setEnterTime(OO000OO.O00000o0());
                        geoFence.setStatus(1);
                        return true;
                    }
                } else if (geoFence.getStatus() != 3 && OO000OO.O00000o0() - geoFence.getEnterTime() > 600000) {
                    geoFence.setStatus(3);
                    return true;
                }
            } else if (geoFence.getStatus() != 2) {
                try {
                    geoFence.setStatus(2);
                    geoFence.setEnterTime(-1);
                    return true;
                } catch (Throwable th2) {
                    th = th2;
                    O0o0000.O000000o(th, "Utils", "isFenceStatusChanged");
                    return z;
                }
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            z = false;
            O0o0000.O000000o(th, "Utils", "isFenceStatusChanged");
            return z;
        }
    }

    private void O00000oO() {
        if (!this.O0000o0O) {
            this.O0000o0O = true;
        }
        if (!this.O0000o0) {
            try {
                this.O0000OOo = Looper.myLooper() == null ? new O00000o0(this.O00000Oo.getMainLooper()) : new O00000o0();
            } catch (Throwable th) {
                O0o0000.O000000o(th, "GeoFenceManger", "init 1");
            }
            try {
                this.O0000Ooo = new O00000Oo("fenceActionThread");
                this.O0000Ooo.setPriority(5);
                this.O0000Ooo.start();
                this.O0000OoO = new O000000o(this.O0000Ooo.getLooper());
            } catch (Throwable th2) {
                O0o0000.O000000o(th2, "GeoFenceManger", "init 2");
            }
            try {
                this.O0000o0o = new O000o00(this.O00000Oo);
                this.O0000o = new O00o0000();
                this.O0000oOo = new AMapLocationClientOption();
                this.O0000oO0 = new AMapLocationClient(this.O00000Oo);
                this.O0000oOo.setLocationCacheEnable(true);
                this.O0000oOo.setNeedAddress(false);
                this.O0000oO0.setLocationListener(this.O0000oo);
                if (this.O000000o == null) {
                    this.O000000o = new ooO0Ooo();
                }
            } catch (Throwable th22) {
                O0o0000.O000000o(th22, "GeoFenceManger", "initBase");
            }
            this.O0000o0 = true;
            try {
                if (this.O00000o != null && this.O00000o0 == null) {
                    createPendingIntent(this.O00000o);
                }
            } catch (Throwable th222) {
                O0o0000.O000000o(th222, "GeoFenceManger", "init 4");
            }
        }
    }

    private void O00000oo() {
        if (!(this.O0000ooo || this.O0000OoO == null)) {
            Object obj = null;
            if (this.O0000oO != null && OO000OO.O000000o(this.O0000oO) && OO000OO.O00000o0() - this.O0000oOO < 10000) {
                obj = 1;
            }
            if (obj != null) {
                O000000o(6, null, 0);
                O000000o(5, null, 0);
                return;
            }
            O000000o(7);
            O000000o(7, null, 0);
        }
    }

    private void O0000O0o() {
        try {
            if (this.O0000o00) {
                O000000o(8);
            }
            if (this.O0000oO0 != null) {
                this.O0000oO0.stopLocation();
            }
            this.O0000o00 = false;
        } catch (Throwable unused) {
        }
    }

    /* Access modifiers changed, original: final */
    public final void O000000o() {
        try {
            if (this.O0000o0) {
                if (this.O0000O0o != null) {
                    this.O0000O0o.clear();
                    this.O0000O0o = null;
                }
                if (!this.O0000o0O) {
                    try {
                        synchronized (this.O0000Oo0) {
                            if (this.O0000OoO != null) {
                                this.O0000OoO.removeCallbacksAndMessages(null);
                            }
                            this.O0000OoO = null;
                        }
                    } catch (Throwable th) {
                        O0o0000.O000000o(th, "GeoFenceManager", "destroyActionHandler");
                    }
                    if (this.O0000oO0 != null) {
                        this.O0000oO0.stopLocation();
                        this.O0000oO0.onDestroy();
                    }
                    this.O0000oO0 = null;
                    if (this.O0000Ooo != null) {
                        if (VERSION.SDK_INT >= 18) {
                            this.O0000Ooo.quitSafely();
                        } else {
                            this.O0000Ooo.quit();
                        }
                    }
                    this.O0000Ooo = null;
                    this.O0000o0o = null;
                    synchronized (this.O00oOooO) {
                        if (this.O00000o0 != null) {
                            this.O00000o0.cancel();
                        }
                        this.O00000o0 = null;
                    }
                    try {
                        synchronized (this.O0000Oo) {
                            if (this.O0000OOo != null) {
                                this.O0000OOo.removeCallbacksAndMessages(null);
                            }
                            this.O0000OOo = null;
                        }
                    } catch (Throwable th2) {
                        O0o0000.O000000o(th2, "GeoFenceManager", "destroyResultHandler");
                    }
                    if (this.O000000o != null) {
                        this.O000000o.O00000Oo(this.O00000Oo);
                    }
                    this.O0000o00 = false;
                    this.O0000o0 = false;
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* Access modifiers changed, original: final */
    public final void O000000o(int i) {
        try {
            synchronized (this.O0000Oo0) {
                if (this.O0000OoO != null) {
                    this.O0000OoO.removeMessages(i);
                }
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "GeoFenceManager", "removeActionHandlerMessage");
        }
    }

    /* Access modifiers changed, original: final */
    public final void O000000o(int i, Bundle bundle) {
        try {
            synchronized (this.O0000Oo) {
                if (this.O0000OOo != null) {
                    Message obtainMessage = this.O0000OOo.obtainMessage();
                    obtainMessage.what = i;
                    obtainMessage.setData(bundle);
                    this.O0000OOo.sendMessage(obtainMessage);
                }
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "GeoFenceManager", "sendResultHandlerMessage");
        }
    }

    /* Access modifiers changed, original: final */
    public final void O000000o(int i, Bundle bundle, long j) {
        try {
            synchronized (this.O0000Oo0) {
                if (this.O0000OoO != null) {
                    Message obtainMessage = this.O0000OoO.obtainMessage();
                    obtainMessage.what = i;
                    obtainMessage.setData(bundle);
                    this.O0000OoO.sendMessageDelayed(obtainMessage, j);
                }
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "GeoFenceManager", "sendActionHandlerMessage");
        }
    }

    /* Access modifiers changed, original: final */
    public final void O000000o(Bundle bundle) {
        int i = 1;
        if (bundle != null) {
            try {
                i = bundle.getInt("activatesAction", 1);
            } catch (Throwable th) {
                O0o0000.O000000o(th, "GeoFenceManager", "doSetActivatesAction");
                return;
            }
        }
        if (this.O00000oo != i) {
            if (!(this.O0000O0o == null || this.O0000O0o.isEmpty())) {
                Iterator it = this.O0000O0o.iterator();
                while (it.hasNext()) {
                    GeoFence geoFence = (GeoFence) it.next();
                    geoFence.setStatus(0);
                    geoFence.setEnterTime(-1);
                }
            }
            O00000oo();
        }
        this.O00000oo = i;
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Missing block: B:21:0x0054, code skipped:
            return;
     */
    public final void O000000o(com.amap.api.fence.GeoFence r7) {
        /*
        r6 = this;
        r0 = r6.O00oOooO;	 Catch:{ Throwable -> 0x0058 }
        monitor-enter(r0);	 Catch:{ Throwable -> 0x0058 }
        r1 = r6.O00000Oo;	 Catch:{ all -> 0x0055 }
        if (r1 == 0) goto L_0x0053;
    L_0x0007:
        r1 = r6.O00000o0;	 Catch:{ all -> 0x0055 }
        if (r1 != 0) goto L_0x0013;
    L_0x000b:
        r1 = r7.getPendingIntent();	 Catch:{ all -> 0x0055 }
        if (r1 != 0) goto L_0x0013;
    L_0x0011:
        monitor-exit(r0);	 Catch:{ all -> 0x0055 }
        return;
    L_0x0013:
        r1 = new android.content.Intent;	 Catch:{ all -> 0x0055 }
        r1.<init>();	 Catch:{ all -> 0x0055 }
        r2 = r7.getFenceId();	 Catch:{ all -> 0x0055 }
        r3 = r7.getCustomId();	 Catch:{ all -> 0x0055 }
        r4 = r7.getStatus();	 Catch:{ all -> 0x0055 }
        r5 = 0;
        r2 = O000000o(r7, r2, r3, r4, r5);	 Catch:{ all -> 0x0055 }
        r1.putExtras(r2);	 Catch:{ all -> 0x0055 }
        r2 = r6.O00000o;	 Catch:{ all -> 0x0055 }
        if (r2 == 0) goto L_0x0035;
    L_0x0030:
        r2 = r6.O00000o;	 Catch:{ all -> 0x0055 }
        r1.setAction(r2);	 Catch:{ all -> 0x0055 }
    L_0x0035:
        r2 = r6.O00000Oo;	 Catch:{ all -> 0x0055 }
        r2 = com.loc.OO00o00.O00000o0(r2);	 Catch:{ all -> 0x0055 }
        r1.setPackage(r2);	 Catch:{ all -> 0x0055 }
        r2 = r7.getPendingIntent();	 Catch:{ all -> 0x0055 }
        if (r2 == 0) goto L_0x004e;
    L_0x0044:
        r7 = r7.getPendingIntent();	 Catch:{ all -> 0x0055 }
        r2 = r6.O00000Oo;	 Catch:{ all -> 0x0055 }
    L_0x004a:
        r7.send(r2, r5, r1);	 Catch:{ all -> 0x0055 }
        goto L_0x0053;
    L_0x004e:
        r7 = r6.O00000o0;	 Catch:{ all -> 0x0055 }
        r2 = r6.O00000Oo;	 Catch:{ all -> 0x0055 }
        goto L_0x004a;
    L_0x0053:
        monitor-exit(r0);	 Catch:{ all -> 0x0055 }
        return;
    L_0x0055:
        r7 = move-exception;
        monitor-exit(r0);	 Catch:{ Throwable -> 0x0058 }
        throw r7;	 Catch:{ Throwable -> 0x0058 }
    L_0x0058:
        r7 = move-exception;
        r0 = "GeoFenceManager";
        r1 = "resultTriggerGeoFence";
        com.loc.O0o0000.O000000o(r7, r0, r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O000000o.O000000o(com.amap.api.fence.GeoFence):void");
    }

    /* Access modifiers changed, original: final */
    public final void O000000o(AMapLocation aMapLocation) {
        try {
            if (!(this.O0000ooo || this.O0000O0o == null || this.O0000O0o.isEmpty() || aMapLocation == null || aMapLocation.getErrorCode() != 0)) {
                Iterator it = this.O0000O0o.iterator();
                while (it.hasNext()) {
                    GeoFence geoFence = (GeoFence) it.next();
                    if (geoFence.isAble() && O00000Oo(aMapLocation, geoFence) && O000000o(geoFence, this.O00000oo)) {
                        geoFence.setCurrentLocation(aMapLocation);
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("geoFence", geoFence);
                        O000000o(1001, bundle);
                    }
                }
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "GeoFenceManager", "doCheckFence");
        }
    }

    /* Access modifiers changed, original: final */
    public final void O00000Oo() {
        try {
            if (this.O0000oO0 != null) {
                O0000O0o();
                this.O0000oOo.setOnceLocation(true);
                this.O0000oO0.setLocationOption(this.O0000oOo);
                this.O0000oO0.startLocation();
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "GeoFenceManager", "doStartOnceLocation");
        }
    }

    /* Access modifiers changed, original: final */
    public final void O00000Oo(int i) {
        try {
            if (this.O00000Oo != null) {
                synchronized (this.O00oOooO) {
                    if (this.O00000o0 == null) {
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtras(O000000o(null, null, null, 4, i));
                    this.O00000o0.send(this.O00000Oo, 0, intent);
                }
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "GeoFenceManager", "resultRemindLocationError");
        }
    }

    /* Access modifiers changed, original: final */
    public final void O00000Oo(Bundle bundle) {
        try {
            String str;
            ArrayList arrayList = new ArrayList();
            String str2 = "";
            int i = 1;
            if (bundle == null || bundle.isEmpty()) {
                str = str2;
            } else {
                DPoint dPoint = (DPoint) bundle.getParcelable("centerPoint");
                str = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                if (dPoint != null) {
                    if (dPoint.getLatitude() <= 90.0d && dPoint.getLatitude() >= -90.0d && dPoint.getLongitude() <= 180.0d) {
                        if (dPoint.getLongitude() >= -180.0d) {
                            GeoFence O000000o = O000000o(bundle, false);
                            i = O00000Oo(O000000o);
                            if (i == 0) {
                                arrayList.add(O000000o);
                            }
                        }
                    }
                    StringBuilder stringBuilder = new StringBuilder("经纬度错误，传入的纬度：");
                    stringBuilder.append(dPoint.getLatitude());
                    stringBuilder.append("传入的经度:");
                    stringBuilder.append(dPoint.getLongitude());
                    O000000o("添加围栏失败", 1, stringBuilder.toString(), new String[0]);
                }
            }
            bundle = new Bundle();
            bundle.putInt("errorCode", i);
            bundle.putParcelableArrayList("resultList", arrayList);
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
            O000000o(1000, bundle);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "GeoFenceManager", "doAddGeoFenceRound");
        }
    }

    /* Access modifiers changed, original: final */
    public final void O00000o() {
        try {
            O000000o(7);
            O000000o(8);
            if (this.O0000oO0 != null) {
                this.O0000oO0.stopLocation();
            }
            this.O0000o00 = false;
        } catch (Throwable th) {
            O0o0000.O000000o(th, "GeoFenceManager", "doPauseGeoFence");
        }
    }

    /* Access modifiers changed, original: final */
    public final void O00000o(Bundle bundle) {
        O00000Oo(2, bundle);
    }

    /* Access modifiers changed, original: final */
    public final void O00000o0() {
        try {
            if (!this.O0000ooo && OO000OO.O000000o(this.O0000oO)) {
                float f;
                AMapLocation aMapLocation = this.O0000oO;
                ArrayList<GeoFence> arrayList = this.O0000O0o;
                if (aMapLocation == null || aMapLocation.getErrorCode() != 0 || arrayList == null || arrayList.isEmpty()) {
                    f = Float.MAX_VALUE;
                } else {
                    DPoint dPoint = new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude());
                    float f2 = Float.MAX_VALUE;
                    for (GeoFence geoFence : arrayList) {
                        if (geoFence.isAble()) {
                            float O000000o = OO000OO.O000000o(dPoint, geoFence.getCenter());
                            if (O000000o > geoFence.getMinDis2Center() && O000000o < geoFence.getMaxDis2Center()) {
                                f = 0.0f;
                                break;
                            }
                            if (O000000o > geoFence.getMaxDis2Center()) {
                                f2 = Math.min(f2, O000000o - geoFence.getMaxDis2Center());
                            }
                            if (O000000o < geoFence.getMinDis2Center()) {
                                f2 = Math.min(f2, geoFence.getMinDis2Center() - O000000o);
                            }
                        }
                    }
                    f = f2;
                }
                if (f != Float.MAX_VALUE) {
                    if (f < 1000.0f) {
                        O000000o(7);
                        Bundle bundle = new Bundle();
                        bundle.putLong("interval", 2000);
                        O000000o(8, bundle, 500);
                    } else if (f < 5000.0f) {
                        O0000O0o();
                        O000000o(7);
                        O000000o(7, null, 10000);
                    } else {
                        O0000O0o();
                        O000000o(7);
                        O000000o(7, null, (long) (((f - 4000.0f) / 100.0f) * 1000.0f));
                    }
                }
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "GeoFenceManager", "doCheckLocationPolicy");
        }
    }

    /* Access modifiers changed, original: final */
    public final void O00000o0(Bundle bundle) {
        try {
            String str;
            ArrayList arrayList = new ArrayList();
            String str2 = "";
            int i = 1;
            if (bundle == null || bundle.isEmpty()) {
                str = str2;
            } else {
                ArrayList parcelableArrayList = bundle.getParcelableArrayList("pointList");
                str = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                if (parcelableArrayList != null) {
                    if (parcelableArrayList.size() > 2) {
                        GeoFence O000000o = O000000o(bundle, true);
                        i = O00000Oo(O000000o);
                        if (i == 0) {
                            arrayList.add(O000000o);
                        }
                    }
                }
            }
            bundle = new Bundle();
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
            bundle.putInt("errorCode", i);
            bundle.putParcelableArrayList("resultList", arrayList);
            O000000o(1000, bundle);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "GeoFenceManager", "doAddGeoFencePolygon");
        }
    }

    /* Access modifiers changed, original: final */
    public final void O00000oO(Bundle bundle) {
        O00000Oo(1, bundle);
    }

    /* Access modifiers changed, original: final */
    public final void O00000oo(Bundle bundle) {
        O00000Oo(3, bundle);
    }

    /* Access modifiers changed, original: final */
    public final void O0000O0o(Bundle bundle) {
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    String string = bundle.getString("fid");
                    if (!TextUtils.isEmpty(string)) {
                        boolean z = true;
                        boolean z2 = bundle.getBoolean("ab", true);
                        if (this.O0000O0o != null && !this.O0000O0o.isEmpty()) {
                            Iterator it = this.O0000O0o.iterator();
                            while (it.hasNext()) {
                                GeoFence geoFence = (GeoFence) it.next();
                                if (geoFence.getFenceId().equals(string)) {
                                    geoFence.setAble(z2);
                                    break;
                                }
                            }
                        }
                        if (z2) {
                            O00000oo();
                        } else {
                            if (this.O0000O0o != null) {
                                if (!this.O0000O0o.isEmpty()) {
                                    Iterator it2 = this.O0000O0o.iterator();
                                    while (it2.hasNext()) {
                                        if (((GeoFence) it2.next()).isAble()) {
                                            z = false;
                                            break;
                                        }
                                    }
                                }
                            }
                            if (z) {
                                O00000o();
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                O0o0000.O000000o(th, "GeoFenceManager", "doSetGeoFenceAble");
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void O0000OOo(Bundle bundle) {
        try {
            if (this.O0000O0o != null) {
                GeoFence geoFence = (GeoFence) bundle.getParcelable("fc");
                if (this.O0000O0o.contains(geoFence)) {
                    this.O0000O0o.remove(geoFence);
                }
                if (this.O0000O0o.size() <= 0) {
                    O000000o();
                    return;
                }
                O00000oo();
            }
        } catch (Throwable unused) {
        }
    }

    /* Access modifiers changed, original: final */
    public final void O0000Oo(Bundle bundle) {
        try {
            if (this.O0000oO0 != null) {
                long j = 2000;
                if (!(bundle == null || bundle.isEmpty())) {
                    j = bundle.getLong("interval", 2000);
                }
                this.O0000oOo.setOnceLocation(false);
                this.O0000oOo.setInterval(j);
                this.O0000oO0.setLocationOption(this.O0000oOo);
                if (!this.O0000o00) {
                    this.O0000oO0.stopLocation();
                    this.O0000oO0.startLocation();
                    this.O0000o00 = true;
                }
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "GeoFenceManager", "doStartContinueLocation");
        }
    }

    /* Access modifiers changed, original: final */
    public final void O0000Oo0(Bundle bundle) {
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    int i = bundle.getInt("errorCode");
                    ArrayList parcelableArrayList = bundle.getParcelableArrayList("resultList");
                    if (parcelableArrayList == null) {
                        parcelableArrayList = new ArrayList();
                    }
                    String string = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                    if (string == null) {
                        string = "";
                    }
                    if (this.O00000oO != null) {
                        this.O00000oO.onGeoFenceCreateFinished((ArrayList) parcelableArrayList.clone(), i, string);
                    }
                    if (i == 0) {
                        O00000oo();
                    }
                }
            } catch (Throwable th) {
                O0o0000.O000000o(th, "GeoFenceManager", "resultAddGeoFenceFinished");
            }
        }
    }

    public void addDistrictGeoFence(String str, String str2) {
        try {
            O00000oO();
            Bundle bundle = new Bundle();
            bundle.putString("keyWords", str);
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str2);
            O000000o(4, bundle, 0);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "GeoFenceManager", "addDistricetGeoFence");
        }
    }

    public void addKeywordGeoFence(String str, String str2, String str3, int i, String str4) {
        try {
            O00000oO();
            if (i <= 0) {
                i = 10;
            }
            if (i > 25) {
                i = 25;
            }
            Bundle bundle = new Bundle();
            bundle.putString("keyWords", str);
            bundle.putString("poiType", str2);
            bundle.putString("city", str3);
            bundle.putInt("searchSize", i);
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str4);
            O000000o(2, bundle, 0);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "GeoFenceManager", "addKeywordGeoFence");
        }
    }

    public void addNearbyGeoFence(String str, String str2, DPoint dPoint, float f, int i, String str3) {
        try {
            O00000oO();
            if (f <= 0.0f || f > 50000.0f) {
                f = 3000.0f;
            }
            if (i <= 0) {
                i = 10;
            }
            if (i > 25) {
                i = 25;
            }
            Bundle bundle = new Bundle();
            bundle.putString("keyWords", str);
            bundle.putString("poiType", str2);
            bundle.putParcelable("centerPoint", dPoint);
            bundle.putFloat("aroundRadius", f);
            bundle.putInt("searchSize", i);
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str3);
            O000000o(3, bundle, 0);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "GeoFenceManager", "addNearbyGeoFence");
        }
    }

    public void addPolygonGeoFence(List<DPoint> list, String str) {
        try {
            O00000oO();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("pointList", new ArrayList(list));
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
            O000000o(1, bundle, 0);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "GeoFenceManager", "addPolygonGeoFence");
        }
    }

    public void addRoundGeoFence(DPoint dPoint, float f, String str) {
        try {
            O00000oO();
            Bundle bundle = new Bundle();
            bundle.putParcelable("centerPoint", dPoint);
            bundle.putFloat("fenceRadius", f);
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
            O000000o(0, bundle, 0);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "GeoFenceManager", "addRoundGeoFence");
        }
    }

    public PendingIntent createPendingIntent(String str) {
        synchronized (this.O00oOooO) {
            try {
                Intent intent = new Intent(str);
                intent.setPackage(OO00o00.O00000o0(this.O00000Oo));
                this.O00000o0 = PendingIntent.getBroadcast(this.O00000Oo, 0, intent, 0);
                this.O00000o = str;
                if (!(this.O0000O0o == null || this.O0000O0o.isEmpty())) {
                    Iterator it = this.O0000O0o.iterator();
                    while (it.hasNext()) {
                        GeoFence geoFence = (GeoFence) it.next();
                        geoFence.setPendingIntent(this.O00000o0);
                        geoFence.setPendingIntentAction(this.O00000o);
                    }
                }
            } catch (Throwable th) {
                O0o0000.O000000o(th, "GeoFenceManager", "createPendingIntent");
            }
        }
        return this.O00000o0;
    }

    public List<GeoFence> getAllGeoFence() {
        try {
            if (this.O0000O0o == null) {
                this.O0000O0o = new ArrayList();
            }
            return (ArrayList) this.O0000O0o.clone();
        } catch (Throwable unused) {
            return new ArrayList();
        }
    }

    public boolean isPause() {
        return this.O0000ooo;
    }

    public void pauseGeoFence() {
        try {
            O00000oO();
            this.O0000ooo = true;
            O000000o(13, null, 0);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "GeoFenceManager", "pauseGeoFence");
        }
    }

    public void removeGeoFence() {
        try {
            this.O0000o0O = false;
            O000000o(10, null, 0);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "GeoFenceManager", "removeGeoFence");
        }
    }

    public boolean removeGeoFence(GeoFence geoFence) {
        try {
            if (this.O0000O0o != null) {
                if (!this.O0000O0o.isEmpty()) {
                    if (!this.O0000O0o.contains(geoFence)) {
                        return false;
                    }
                    if (this.O0000O0o.size() == 1) {
                        this.O0000o0O = false;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("fc", geoFence);
                    O000000o(11, bundle, 0);
                    return true;
                }
            }
            this.O0000o0O = false;
            O000000o(10, null, 0);
            return true;
        } catch (Throwable th) {
            O0o0000.O000000o(th, "GeoFenceManager", "removeGeoFence(GeoFence)");
            return false;
        }
    }

    public void resumeGeoFence() {
        try {
            O00000oO();
            if (this.O0000ooo) {
                this.O0000ooo = false;
                O00000oo();
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "GeoFenceManager", "resumeGeoFence");
        }
    }

    public void setActivateAction(int i) {
        try {
            O00000oO();
            if (i > 7 || i <= 0) {
                i = 1;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("activatesAction", i);
            O000000o(9, bundle, 0);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "GeoFenceManager", "setActivateAction");
        }
    }

    public void setGeoFenceAble(String str, boolean z) {
        try {
            O00000oO();
            Bundle bundle = new Bundle();
            bundle.putString("fid", str);
            bundle.putBoolean("ab", z);
            O000000o(12, bundle, 0);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "GeoFenceManager", "setGeoFenceAble");
        }
    }

    public void setGeoFenceListener(GeoFenceListener geoFenceListener) {
        try {
            this.O00000oO = geoFenceListener;
        } catch (Throwable unused) {
        }
    }
}
