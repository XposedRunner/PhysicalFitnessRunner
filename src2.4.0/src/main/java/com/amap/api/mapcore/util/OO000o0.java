package com.amap.api.mapcore.util;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.os.RemoteException;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.LatLngBounds.Builder;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.model.PolylineOptions.LineCapType;
import com.amap.api.maps.model.PolylineOptions.LineJoinType;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.amap.mapcore.AMapNativePolyline;
import com.autonavi.amap.mapcore.AMapNativeRenderer;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.FPoint3;
import com.autonavi.amap.mapcore.FPointBounds;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapConfig;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: PolylineDelegateImp */
public class OO000o0 implements O0o00 {
    Rect O000000o = null;
    int O00000Oo = 0;
    long O00000o = 0;
    ArrayList<FPoint> O00000o0 = new ArrayList();
    private by O00000oO;
    private String O00000oo;
    private List<IPoint> O0000O0o = new ArrayList();
    private List<FPoint> O0000OOo = new ArrayList();
    private List<BitmapDescriptor> O0000Oo = new ArrayList();
    private List<LatLng> O0000Oo0 = new ArrayList();
    private List<O0000O0o> O0000OoO = new ArrayList();
    private List<Integer> O0000Ooo = new ArrayList();
    private BitmapDescriptor O0000o = null;
    private List<Integer> O0000o0 = new ArrayList();
    private List<Integer> O0000o00 = new ArrayList();
    private List<Integer> O0000o0O = new ArrayList();
    private FloatBuffer O0000o0o;
    private boolean O0000oO = true;
    private Object O0000oO0 = new Object();
    private boolean O0000oOO = true;
    private boolean O0000oOo = false;
    private boolean O0000oo = false;
    private boolean O0000oo0 = false;
    private boolean O0000ooO = true;
    private boolean O0000ooo = false;
    private int O000O00o = 0;
    private int O000O0OO = 0;
    private int O000O0Oo = ViewCompat.MEASURED_STATE_MASK;
    private float O000O0o = 10.0f;
    private int O000O0o0 = 0;
    private float O000O0oO = 0.0f;
    private float O000O0oo = 0.0f;
    private float O000OO;
    private float O000OO00;
    private float O000OO0o;
    private float O000OOOo;
    private float O000OOo = 0.0f;
    private float O000OOo0 = 1.0f;
    private float[] O000OOoO;
    private int[] O000OOoo;
    private boolean O000Oo0 = false;
    private int[] O000Oo00;
    private FPointBounds O000Oo0O = null;
    private PolylineOptions O000Oo0o;
    private LineCapType O000OoO = LineCapType.LineCapRound;
    private int O000OoO0 = 0;
    private OO00O O000OoOO;
    private long O000OoOo = 0;
    private float O000Ooo = -1.0f;
    private boolean O000Ooo0 = false;
    private float O000OooO = -1.0f;
    private float O000Oooo = -1.0f;
    private List<IPoint> O000o00 = new ArrayList();
    private int O000o000 = -1;
    private LineJoinType O00O0Oo = LineJoinType.LineJoinBevel;
    private int O00oOoOo = 0;
    private boolean O00oOooO = false;
    private boolean O00oOooo = true;

    public OO000o0(by byVar, PolylineOptions polylineOptions) {
        this.O00000oO = byVar;
        setOptions(polylineOptions);
        try {
            this.O00000oo = getId();
        } catch (RemoteException e) {
            ooOOOOoo.O00000o0(e, "PolylineDelegateImp", "create");
            e.printStackTrace();
        }
    }

    private double O000000o(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d5 - d3;
        double d8 = d - d3;
        double d9 = d6 - d4;
        double d10 = d2 - d4;
        double d11 = (d7 * d8) + (d9 * d10);
        if (d11 <= 0.0d) {
            return Math.sqrt((d8 * d8) + (d10 * d10));
        }
        d8 = (d7 * d7) + (d9 * d9);
        double d12;
        if (d11 >= d8) {
            d12 = d - d5;
            double d13 = d2 - d6;
            return Math.sqrt((d12 * d12) + (d13 * d13));
        }
        d11 /= d8;
        d12 = d - (d3 + (d7 * d11));
        double d14 = (d4 + (d9 * d11)) - d2;
        return Math.sqrt((d12 * d12) + (d14 * d14));
    }

    private double O000000o(FPoint fPoint, FPoint fPoint2, FPoint fPoint3) {
        FPoint fPoint4 = fPoint;
        FPoint fPoint5 = fPoint2;
        FPoint fPoint6 = fPoint3;
        return O000000o((double) fPoint4.x, (double) fPoint4.y, (double) fPoint5.x, (double) fPoint5.y, (double) fPoint6.x, (double) fPoint6.y);
    }

    private int O000000o(boolean z, BitmapDescriptor bitmapDescriptor, boolean z2) {
        if (z2) {
            O00000oo();
        }
        int i = 0;
        O0000O0o o0000O0o = null;
        if (z) {
            o0000O0o = this.O00000oO.O000000o(bitmapDescriptor);
            if (o0000O0o != null) {
                int O0000OoO = o0000O0o.O0000OoO();
                O000000o(o0000O0o);
                return O0000OoO;
            }
        }
        if (o0000O0o == null) {
            o0000O0o = new O0000O0o(bitmapDescriptor, 0);
        }
        Bitmap bitmap = bitmapDescriptor.getBitmap();
        if (!(bitmap == null || bitmap.isRecycled())) {
            i = O0000O0o();
            if (z) {
                o0000O0o.O000000o(i);
                this.O00000oO.O0000O0o().O000000o(o0000O0o);
            }
            O000000o(o0000O0o);
            OOo000.O00000Oo(i, bitmap, true);
        }
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0086 A:{Catch:{ all -> 0x00d5, all -> 0x0068, Throwable -> 0x00d9 }} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0086 A:{Catch:{ all -> 0x00d5, all -> 0x0068, Throwable -> 0x00d9 }} */
    private void O000000o(float r18, com.autonavi.amap.mapcore.MapConfig r19) {
        /*
        r17 = this;
        r1 = r17;
        r2 = r1.O0000oo;
        r3 = 1;
        r4 = 0;
        if (r2 != 0) goto L_0x004d;
    L_0x0008:
        r2 = r1.O0000Oo;	 Catch:{ Throwable -> 0x0043 }
        if (r2 == 0) goto L_0x004d;
    L_0x000c:
        r2 = r1.O0000Oo;	 Catch:{ Throwable -> 0x0043 }
        r2 = r2.size();	 Catch:{ Throwable -> 0x0043 }
        r2 = new int[r2];	 Catch:{ Throwable -> 0x0043 }
        r1.O000Oo00 = r2;	 Catch:{ Throwable -> 0x0043 }
        r2 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x0043 }
        r5 = 12;
        if (r2 < r5) goto L_0x001e;
    L_0x001c:
        r2 = r3;
        goto L_0x001f;
    L_0x001e:
        r2 = r4;
    L_0x001f:
        r17.O00000oo();	 Catch:{ Throwable -> 0x0043 }
        r5 = r1.O0000Oo;	 Catch:{ Throwable -> 0x0043 }
        r5 = r5.iterator();	 Catch:{ Throwable -> 0x0043 }
        r6 = r4;
    L_0x0029:
        r7 = r5.hasNext();	 Catch:{ Throwable -> 0x0043 }
        if (r7 == 0) goto L_0x0040;
    L_0x002f:
        r7 = r5.next();	 Catch:{ Throwable -> 0x0043 }
        r7 = (com.amap.api.maps.model.BitmapDescriptor) r7;	 Catch:{ Throwable -> 0x0043 }
        r7 = r1.O000000o(r2, r7, r4);	 Catch:{ Throwable -> 0x0043 }
        r8 = r1.O000Oo00;	 Catch:{ Throwable -> 0x0043 }
        r8[r6] = r7;	 Catch:{ Throwable -> 0x0043 }
        r6 = r6 + 1;
        goto L_0x0029;
    L_0x0040:
        r1.O0000oo = r3;	 Catch:{ Throwable -> 0x0043 }
        goto L_0x004d;
    L_0x0043:
        r0 = move-exception;
        r2 = r0;
        r3 = "MarkerDelegateImp";
        r4 = "loadtexture";
        com.amap.api.mapcore.util.ooOOOOoo.O00000o0(r2, r3, r4);
        return;
    L_0x004d:
        r2 = r19.getGeoRectangle();
        r2 = r2.getClipMapRect();
        r5 = r1.O0000OOo;	 Catch:{ Throwable -> 0x00d9 }
        r6 = r1.O000000o(r2);	 Catch:{ Throwable -> 0x00d9 }
        if (r6 == 0) goto L_0x006c;
    L_0x005d:
        r5 = r1.O0000oO0;	 Catch:{ Throwable -> 0x00d9 }
        monitor-enter(r5);	 Catch:{ Throwable -> 0x00d9 }
        r6 = r1.O0000OOo;	 Catch:{ all -> 0x0068 }
        r2 = com.amap.api.mapcore.util.OOo000.O00000Oo(r2, r6, r4);	 Catch:{ all -> 0x0068 }
        monitor-exit(r5);	 Catch:{ all -> 0x0068 }
        goto L_0x006d;
    L_0x0068:
        r0 = move-exception;
        r2 = r0;
        monitor-exit(r5);	 Catch:{ all -> 0x0068 }
        throw r2;	 Catch:{ Throwable -> 0x00d9 }
    L_0x006c:
        r2 = r5;
    L_0x006d:
        r5 = r2.size();	 Catch:{ Throwable -> 0x00d9 }
        r6 = 2;
        if (r5 < r6) goto L_0x00de;
    L_0x0074:
        r1.O00000o(r2);	 Catch:{ Throwable -> 0x00d9 }
        r2 = r1.O0000o0;	 Catch:{ Throwable -> 0x00d9 }
        monitor-enter(r2);	 Catch:{ Throwable -> 0x00d9 }
        r5 = r1.O0000o0;	 Catch:{ all -> 0x00d5 }
        r5 = r5.size();	 Catch:{ all -> 0x00d5 }
        r9 = new int[r5];	 Catch:{ all -> 0x00d5 }
        r5 = r4;
    L_0x0083:
        r6 = r9.length;	 Catch:{ all -> 0x00d5 }
        if (r5 >= r6) goto L_0x009e;
    L_0x0086:
        r6 = r1.O0000o0;	 Catch:{ all -> 0x00d5 }
        r6 = r6.get(r5);	 Catch:{ all -> 0x00d5 }
        r6 = (java.lang.Integer) r6;	 Catch:{ all -> 0x00d5 }
        r6 = r6.intValue();	 Catch:{ all -> 0x00d5 }
        if (r6 >= 0) goto L_0x0095;
    L_0x0094:
        r6 = r4;
    L_0x0095:
        r7 = r1.O000Oo00;	 Catch:{ all -> 0x00d5 }
        r6 = r7[r6];	 Catch:{ all -> 0x00d5 }
        r9[r5] = r6;	 Catch:{ all -> 0x00d5 }
        r5 = r5 + 1;
        goto L_0x0083;
    L_0x009e:
        monitor-exit(r2);	 Catch:{ all -> 0x00d5 }
        if (r9 == 0) goto L_0x00a3;
    L_0x00a1:
        r2 = r3;
        goto L_0x00a4;
    L_0x00a3:
        r2 = r4;
    L_0x00a4:
        r5 = r1.O000OOoo;	 Catch:{ Throwable -> 0x00d9 }
        if (r5 == 0) goto L_0x00a9;
    L_0x00a8:
        goto L_0x00aa;
    L_0x00a9:
        r3 = r4;
    L_0x00aa:
        r2 = r2 & r3;
        if (r2 == 0) goto L_0x00de;
    L_0x00ad:
        r6 = r1.O000OOoO;	 Catch:{ Throwable -> 0x00d9 }
        r7 = r1.O00000Oo;	 Catch:{ Throwable -> 0x00d9 }
        r10 = r9.length;	 Catch:{ Throwable -> 0x00d9 }
        r11 = r1.O000OOoo;	 Catch:{ Throwable -> 0x00d9 }
        r2 = r1.O000OOoo;	 Catch:{ Throwable -> 0x00d9 }
        r12 = r2.length;	 Catch:{ Throwable -> 0x00d9 }
        r2 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r3 = r1.O000OOo0;	 Catch:{ Throwable -> 0x00d9 }
        r13 = r2 - r3;
        r2 = r1.O00000oO;	 Catch:{ Throwable -> 0x00d9 }
        r14 = r2.O0000OOo();	 Catch:{ Throwable -> 0x00d9 }
        r2 = r1.O000OoO;	 Catch:{ Throwable -> 0x00d9 }
        r15 = r2.getTypeValue();	 Catch:{ Throwable -> 0x00d9 }
        r2 = r1.O00O0Oo;	 Catch:{ Throwable -> 0x00d9 }
        r16 = r2.getTypeValue();	 Catch:{ Throwable -> 0x00d9 }
        r8 = r18;
        com.autonavi.amap.mapcore.AMapNativeRenderer.nativeDrawLineByMultiTextureID(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);	 Catch:{ Throwable -> 0x00d9 }
        goto L_0x00de;
    L_0x00d5:
        r0 = move-exception;
        r3 = r0;
        monitor-exit(r2);	 Catch:{ all -> 0x00d5 }
        throw r3;	 Catch:{ Throwable -> 0x00d9 }
    L_0x00d9:
        r0 = move-exception;
        r2 = r0;
        r2.printStackTrace();
    L_0x00de:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.OO000o0.O000000o(float, com.autonavi.amap.mapcore.MapConfig):void");
    }

    private void O000000o(O0000O0o o0000O0o) {
        if (o0000O0o != null) {
            this.O0000OoO.add(o0000O0o);
            o0000O0o.O0000Ooo();
        }
    }

    private boolean O000000o(FPoint fPoint, FPoint fPoint2) {
        boolean z = true;
        if ((fPoint instanceof FPoint3) && (fPoint2 instanceof FPoint3) && ((FPoint3) fPoint).colorIndex != ((FPoint3) fPoint2).colorIndex) {
            return true;
        }
        if (Math.abs(fPoint2.x - fPoint.x) < this.O000OOo && Math.abs(fPoint2.y - fPoint.y) < this.O000OOo) {
            z = false;
        }
        return z;
    }

    private boolean O000000o(FPoint[] fPointArr) {
        this.O000O0oo = this.O00000oO.O0000O0o().O0000O0o();
        O00000oO();
        if (this.O000O0oo <= ((float) (this.O0000O0o.size() > 10000 ? 7 : 3))) {
            return false;
        }
        try {
            return this.O00000oO.O0000O0o() != null ? (OOo000.O000000o(this.O000Oo0O.northeast, fPointArr) && OOo000.O000000o(this.O000Oo0O.southwest, fPointArr)) ? false : true : false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private FPoint O00000Oo(LatLng latLng) {
        IPoint obtain = IPoint.obtain();
        this.O00000oO.O0000O0o().O000000o(latLng.latitude, latLng.longitude, obtain);
        FPoint obtain2 = FPoint.obtain();
        this.O00000oO.O0000O0o().O000000o(obtain.x, obtain.y, obtain2);
        obtain.recycle();
        return obtain2;
    }

    private void O00000Oo(float f, MapConfig mapConfig) {
        int[] iArr = new int[this.O0000o00.size()];
        for (int i = 0; i < this.O0000o00.size(); i++) {
            iArr[i] = ((Integer) this.O0000o00.get(i)).intValue();
        }
        FPoint[] clipMapRect = mapConfig.getGeoRectangle().getClipMapRect();
        try {
            List O00000Oo;
            List list = this.O0000OOo;
            if (O000000o(clipMapRect)) {
                synchronized (this.O0000oO0) {
                    O00000Oo = OOo000.O00000Oo(clipMapRect, this.O0000OOo, false);
                }
            } else {
                O00000Oo = list;
            }
            if (O00000Oo.size() >= 2) {
                int i2;
                O00000o(O00000Oo);
                int[] iArr2 = new int[this.O0000o0O.size()];
                for (i2 = 0; i2 < iArr2.length; i2++) {
                    iArr2[i2] = ((Integer) this.O0000o0O.get(i2)).intValue();
                }
                i2 = 1;
                int i3 = iArr2 != null ? 1 : 0;
                if (this.O000OOoo == null) {
                    i2 = 0;
                }
                if ((i2 & i3) != 0) {
                    AMapNativeRenderer.nativeDrawGradientColorLine(this.O000OOoO, this.O00000Oo, f, iArr2, iArr2.length, this.O000OOoo, this.O000OOoo.length, this.O00000oO.O0000O0o().O00000o(), this.O00000oO.O0000OOo(), this.O000OoO.getTypeValue(), this.O00O0Oo.getTypeValue());
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void O00000Oo(MapConfig mapConfig) {
        float mapLenWithWin = this.O00000oO.O0000O0o().O00000o0().getMapLenWithWin((int) this.O000O0o);
        switch (this.O000O00o) {
            case 0:
                O00000oo(mapLenWithWin, mapConfig);
                return;
            case 1:
                if (this.O00oOooo) {
                    O00000o(mapLenWithWin, mapConfig);
                    return;
                } else {
                    O00000oo(mapLenWithWin, mapConfig);
                    return;
                }
            case 2:
                if (this.O000O0o0 == -1) {
                    O00000oo(mapLenWithWin, mapConfig);
                    return;
                } else {
                    O00000oO(mapLenWithWin, mapConfig);
                    return;
                }
            case 3:
                O00000o0(mapLenWithWin, mapConfig);
                return;
            case 4:
                O00000Oo(mapLenWithWin, mapConfig);
                return;
            case 5:
                if (this.O00oOooo) {
                    O000000o(mapLenWithWin, mapConfig);
                    return;
                } else {
                    O00000o0(mapLenWithWin, mapConfig);
                    return;
                }
            default:
                return;
        }
    }

    private void O00000o(float f, MapConfig mapConfig) {
        Throwable th;
        if (!this.O0000oo) {
            synchronized (this) {
                try {
                    if (this.O0000o != null) {
                        this.O000O0OO = O000000o(VERSION.SDK_INT >= 12, this.O0000o, true);
                        this.O0000oo = true;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        try {
            List O000000o;
            if (mapConfig.getChangeRatio() == 1.0d && this.O000OOoO != null) {
                this.O000OoO0++;
                if (this.O000OoO0 > 2) {
                    AMapNativeRenderer.nativeDrawLineByTextureID(this.O000OOoO, this.O00000Oo, f, this.O000O0OO, this.O000OO0o, this.O000OO, this.O000OOOo, this.O000OO00, 1.0f - this.O000OOo0, false, false, false, this.O00000oO.O0000OOo(), this.O000OoO.getTypeValue(), this.O00O0Oo.getTypeValue());
                    return;
                }
            }
            this.O000OoO0 = 0;
            FPoint[] clipMapRect = mapConfig.getGeoRectangle().getClipMapRect();
            List list = this.O0000OOo;
            if (O000000o(clipMapRect)) {
                synchronized (this.O0000oO0) {
                    O000000o = OOo000.O000000o(clipMapRect, this.O0000OOo, false);
                }
            } else {
                O000000o = list;
            }
            if (O000000o.size() >= 2) {
                O00000o(O000000o);
                AMapNativeRenderer.nativeDrawLineByTextureID(this.O000OOoO, this.O00000Oo, f, this.O000O0OO, this.O000OO0o, this.O000OO, this.O000OOOo, this.O000OO00, 1.0f - this.O000OOo0, false, false, false, this.O00000oO.O0000OOo(), this.O000OoO.getTypeValue(), this.O00O0Oo.getTypeValue());
            }
        } catch (Throwable unused) {
        }
    }

    private void O00000o(List<FPoint> list) throws RemoteException {
        this.O00000o0.clear();
        int size = list.size();
        if (size >= 2) {
            int i;
            int i2 = 0;
            FPoint fPoint = (FPoint) list.get(0);
            this.O00000o0.add(fPoint);
            FPoint fPoint2 = fPoint;
            int i3 = 1;
            while (true) {
                i = size - 1;
                if (i3 >= i) {
                    break;
                }
                FPoint fPoint3 = (FPoint) list.get(i3);
                if (i3 == 1 || O000000o(fPoint2, fPoint3)) {
                    this.O00000o0.add(fPoint3);
                    fPoint2 = fPoint3;
                } else {
                    this.O00000o0.set(this.O00000o0.size() - 1, fPoint3);
                }
                i3++;
            }
            this.O00000o0.add(list.get(i));
            int size2 = this.O00000o0.size() * 3;
            this.O00000Oo = size2;
            if (this.O000OOoO == null || this.O000OOoO.length < this.O00000Oo) {
                this.O000OOoO = new float[size2];
            }
            int i4;
            if (this.O000O00o == 5 || this.O000O00o == 3 || this.O000O00o == 4) {
                int[] iArr = new int[this.O00000o0.size()];
                ArrayList arrayList = new ArrayList();
                i4 = 0;
                int i5 = i4;
                int i6 = i5;
                while (i4 < size2 / 3) {
                    FPoint3 fPoint32 = (FPoint3) this.O00000o0.get(i4);
                    int i7 = i4 * 3;
                    this.O000OOoO[i7] = fPoint32.x;
                    this.O000OOoO[i7 + 1] = fPoint32.y;
                    this.O000OOoO[i7 + 2] = 0.0f;
                    int i8 = fPoint32.colorIndex;
                    if (i4 == 0) {
                        arrayList.add(Integer.valueOf(i8));
                    } else if (i8 != i5) {
                        if (i8 == -1) {
                            i8 = i5;
                        }
                        arrayList.add(Integer.valueOf(i8));
                    } else {
                        i4++;
                    }
                    iArr[i6] = i4;
                    i6++;
                    i5 = i8;
                    i4++;
                }
                this.O000OOoo = new int[arrayList.size()];
                System.arraycopy(iArr, 0, this.O000OOoo, 0, this.O000OOoo.length);
                this.O0000o0 = arrayList;
                this.O0000o0O = arrayList;
            } else {
                Iterator it = this.O00000o0.iterator();
                while (it.hasNext()) {
                    FPoint fPoint4 = (FPoint) it.next();
                    i4 = i2 * 3;
                    this.O000OOoO[i4] = fPoint4.x;
                    this.O000OOoO[i4 + 1] = fPoint4.y;
                    this.O000OOoO[i4 + 2] = 0.0f;
                    i2++;
                }
            }
        }
    }

    private void O00000o0(float f, MapConfig mapConfig) {
        int[] iArr = new int[this.O0000o00.size()];
        for (int i = 0; i < this.O0000o00.size(); i++) {
            iArr[i] = ((Integer) this.O0000o00.get(i)).intValue();
        }
        FPoint[] clipMapRect = mapConfig.getGeoRectangle().getClipMapRect();
        try {
            List O00000Oo;
            List list = this.O0000OOo;
            if (O000000o(clipMapRect)) {
                synchronized (this.O0000oO0) {
                    O00000Oo = OOo000.O00000Oo(clipMapRect, this.O0000OOo, false);
                }
            } else {
                O00000Oo = list;
            }
            if (O00000Oo.size() >= 2) {
                int i2;
                O00000o(O00000Oo);
                int[] iArr2 = new int[this.O0000o0O.size()];
                for (i2 = 0; i2 < iArr2.length; i2++) {
                    iArr2[i2] = ((Integer) this.O0000o0O.get(i2)).intValue();
                }
                i2 = 1;
                int i3 = iArr2 != null ? 1 : 0;
                if (this.O000OOoo == null) {
                    i2 = 0;
                }
                if ((i2 & i3) != 0) {
                    AMapNativeRenderer.nativeDrawLineByMultiColor(this.O000OOoO, this.O00000Oo, f, this.O00000oO.O0000O0o().O00000o(), iArr2, iArr2.length, this.O000OOoo, this.O000OOoo.length, this.O00000oO.O0000OOo(), this.O000OoO.getTypeValue(), this.O00O0Oo.getTypeValue());
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void O00000oO() {
        float mapPerPixelUnitLength = this.O00000oO.O0000O0o().getMapConfig().getMapPerPixelUnitLength();
        if (this.O00oOoOo <= 5000) {
            this.O000OOo = mapPerPixelUnitLength * 2.0f;
        } else if (this.O000O0oo <= ((float) 12)) {
            float f = (this.O000O0o / 2.0f) + (this.O000O0oo / 2.0f);
            if (f > 200.0f) {
                f = 200.0f;
            }
            this.O000OOo = mapPerPixelUnitLength * f;
        } else {
            this.O000OOo = mapPerPixelUnitLength * 10.0f;
        }
    }

    private void O00000oO(float f, MapConfig mapConfig) {
        if (!this.O0000oo) {
            synchronized (this) {
                try {
                    if (this.O0000o != null) {
                        this.O000O0OO = O000000o(VERSION.SDK_INT >= 12, this.O0000o, true);
                        this.O0000oo = true;
                    }
                } catch (Throwable th) {
                    Throwable th2 = th;
                }
            }
        }
        try {
            List list = this.O0000OOo;
            if (this.O00000oO.O0000O0o() != null) {
                if (mapConfig.getChangeRatio() == 1.0d && this.O000OOoO != null) {
                    this.O000OoO0++;
                    if (this.O000OoO0 > 2) {
                        AMapNativeRenderer.nativeDrawLineByTextureID(this.O000OOoO, this.O00000Oo, f, this.O00000oO.O0000O0o().O00000oo(this.O000O0o0), this.O000OO0o, this.O000OO, this.O000OOOo, this.O000OO00, 0.0f, true, true, false, this.O00000oO.O0000OOo(), this.O000OoO.getTypeValue(), this.O00O0Oo.getTypeValue());
                        return;
                    }
                }
                this.O000OoO0 = 0;
                FPoint[] clipMapRect = mapConfig.getGeoRectangle().getClipMapRect();
                if (O000000o(clipMapRect)) {
                    List O000000o;
                    synchronized (this.O0000oO0) {
                        O000000o = OOo000.O000000o(clipMapRect, this.O0000OOo, false);
                    }
                    list = O000000o;
                }
                if (list.size() >= 2) {
                    O00000o(list);
                    AMapNativeRenderer.nativeDrawLineByTextureID(this.O000OOoO, this.O00000Oo, f, this.O00000oO.O0000O0o().O00000oo(this.O000O0o0), this.O000OO0o, this.O000OO, this.O000OOOo, this.O000OO00, 0.0f, true, true, false, this.O00000oO.O0000OOo(), this.O000OoO.getTypeValue(), this.O00O0Oo.getTypeValue());
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void O00000oO(List<BitmapDescriptor> list) {
        if (list != null && list.size() != 0) {
            if (list.size() > 1) {
                this.O0000oOO = false;
                this.O000O00o = 5;
                this.O0000Oo = list;
                this.O00000oO.O0000O0o().setRunLowFrame(false);
            } else {
                setCustomTexture((BitmapDescriptor) list.get(0));
            }
        }
    }

    private List<Integer> O00000oo(List<Integer> list) {
        int[] iArr = new int[list.size()];
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = i;
        int i3 = i2;
        while (i < list.size()) {
            int intValue = ((Integer) list.get(i)).intValue();
            if (i == 0) {
                arrayList.add(Integer.valueOf(intValue));
            } else if (intValue == i2) {
                i++;
            } else {
                arrayList.add(Integer.valueOf(intValue));
            }
            iArr[i3] = i;
            i3++;
            i2 = intValue;
            i++;
        }
        this.O000OOoo = new int[arrayList.size()];
        System.arraycopy(iArr, 0, this.O000OOoo, 0, this.O000OOoo.length);
        return arrayList;
    }

    private void O00000oo() {
        if (this.O0000OoO != null) {
            for (O0000O0o o0000O0o : this.O0000OoO) {
                if (!(o0000O0o == null || this.O00000oO == null)) {
                    this.O00000oO.O000000o(o0000O0o);
                }
            }
            this.O0000OoO.clear();
        }
    }

    private void O00000oo(float f, MapConfig mapConfig) {
        try {
            List list = this.O0000OOo;
            if (this.O00000oO.O0000O0o() != null) {
                float[] fArr;
                int i;
                int O00000o;
                float f2;
                float f3;
                float f4;
                if (mapConfig.getChangeRatio() == 1.0d && this.O000OOoO != null) {
                    this.O000OoO0++;
                    if (this.O000OoO0 > 2) {
                        if (this.O000OoOo == 0 || this.O000OoOO == null) {
                            fArr = this.O000OOoO;
                            i = this.O00000Oo;
                            O00000o = this.O00000oO.O0000O0o().O00000o();
                            f2 = this.O000OO0o;
                            f3 = this.O000OO;
                            f4 = this.O000OOOo;
                            AMapNativeRenderer.nativeDrawLineByTextureID(fArr, i, f, O00000o, f2, f3, f4, this.O000OO00, 0.0f, false, true, false, this.O00000oO.O0000OOo(), this.O000OoO.getTypeValue(), this.O00O0Oo.getTypeValue());
                        } else {
                            AMapNativePolyline.nativeDrawLineByTextureID(this.O000OoOo, this.O000OOoO, this.O00000Oo, f, this.O00000oO.O0000O0o().O00000o(), this.O000OO0o, this.O000OO, this.O000OOOo, this.O000OO00, 0.0f, false, true, false, this.O00000oO.O0000OOo(), this.O000OoO.getTypeValue(), this.O00O0Oo.getTypeValue());
                        }
                        return;
                    }
                }
                this.O000OoO0 = 0;
                FPoint[] clipMapRect = mapConfig.getGeoRectangle().getClipMapRect();
                if (O000000o(clipMapRect)) {
                    List O000000o;
                    synchronized (this.O0000oO0) {
                        O000000o = OOo000.O000000o(clipMapRect, this.O0000OOo, false);
                    }
                    list = O000000o;
                }
                if (list.size() >= 2) {
                    O00000o(list);
                    if (this.O000OoOo == 0 || this.O000OoOO == null) {
                        fArr = this.O000OOoO;
                        i = this.O00000Oo;
                        O00000o = this.O00000oO.O0000O0o().O00000o();
                        f2 = this.O000OO0o;
                        f3 = this.O000OO;
                        f4 = this.O000OOOo;
                        AMapNativeRenderer.nativeDrawLineByTextureID(fArr, i, f, O00000o, f2, f3, f4, this.O000OO00, 0.0f, false, true, false, this.O00000oO.O0000OOo(), this.O000OoO.getTypeValue(), this.O00O0Oo.getTypeValue());
                    } else {
                        AMapNativePolyline.nativeDrawLineByTextureID(this.O000OoOo, this.O000OOoO, this.O00000Oo, f, this.O00000oO.O0000O0o().O00000o(), this.O000OO0o, this.O000OO, this.O000OOOo, this.O000OO00, 0.0f, false, true, false, this.O00000oO.O0000OOo(), this.O000OoO.getTypeValue(), this.O00O0Oo.getTypeValue());
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private int O0000O0o() {
        int[] iArr = new int[]{0};
        GLES20.glGenTextures(1, iArr, 0);
        return iArr[0];
    }

    private ArrayList<FPoint> O0000OOo() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < this.O000OOoO.length) {
            float f = this.O000OOoO[i];
            i++;
            float f2 = this.O000OOoO[i];
            i++;
            arrayList.add(FPoint.obtain(f, f2));
            i++;
        }
        return arrayList;
    }

    /* Access modifiers changed, original: 0000 */
    public IPoint O000000o(IPoint iPoint, IPoint iPoint2, IPoint iPoint3, double d, int i) {
        IPoint obtain = IPoint.obtain();
        double d2 = (double) (iPoint2.x - iPoint.x);
        double d3 = (double) (iPoint2.y - iPoint.y);
        obtain.y = (int) (((((double) i) * d) / Math.sqrt(((d3 * d3) / (d2 * d2)) + 1.0d)) + ((double) iPoint3.y));
        obtain.x = (int) (((((double) (iPoint3.y - obtain.y)) * d3) / d2) + ((double) iPoint3.x));
        return obtain;
    }

    public void O000000o(int i) {
        this.O000O0o0 = i;
    }

    public void O000000o(OO00O oo00o) {
        this.O000OoOO = oo00o;
    }

    /* Access modifiers changed, original: 0000 */
    public void O000000o(LatLng latLng, LatLng latLng2, List<IPoint> list, Builder builder) {
        LatLng latLng3 = latLng;
        LatLng latLng4 = latLng2;
        double abs = (Math.abs(latLng3.longitude - latLng4.longitude) * 3.141592653589793d) / 180.0d;
        LatLng latLng5 = new LatLng((latLng4.latitude + latLng3.latitude) / 2.0d, (latLng4.longitude + latLng3.longitude) / 2.0d, false);
        builder.include(latLng3).include(latLng5).include(latLng4);
        int i = latLng5.latitude > 0.0d ? -1 : 1;
        IPoint obtain = IPoint.obtain();
        this.O00000oO.O0000O0o().O000000o(latLng3.latitude, latLng3.longitude, obtain);
        IPoint obtain2 = IPoint.obtain();
        this.O00000oO.O0000O0o().O000000o(latLng4.latitude, latLng4.longitude, obtain2);
        IPoint obtain3 = IPoint.obtain();
        this.O00000oO.O0000O0o().O000000o(latLng5.latitude, latLng5.longitude, obtain3);
        abs *= 0.5d;
        double cos = Math.cos(abs);
        IPoint O000000o = O000000o(obtain, obtain2, obtain3, (Math.hypot((double) (obtain.x - obtain2.x), (double) (obtain.y - obtain2.y)) * 0.5d) * Math.tan(abs), i);
        List arrayList = new ArrayList();
        arrayList.add(obtain);
        arrayList.add(O000000o);
        arrayList.add(obtain2);
        O000000o(arrayList, (List) list, cos);
        obtain.recycle();
        O000000o.recycle();
        obtain2.recycle();
    }

    public void O000000o(LineCapType lineCapType) {
        this.O000OoO = lineCapType;
    }

    public void O000000o(LineJoinType lineJoinType) {
        this.O00O0Oo = lineJoinType;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0053 A:{Catch:{ all -> 0x010b, all -> 0x01cc }} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0051 A:{Catch:{ all -> 0x010b, all -> 0x01cc }} */
    /* JADX WARNING: Missing block: B:76:0x0140, code skipped:
            if (r1.O0000ooO == false) goto L_0x0149;
     */
    /* JADX WARNING: Missing block: B:77:0x0142, code skipped:
            O00000Oo();
            r1.O0000ooO = false;
     */
    /* JADX WARNING: Missing block: B:78:0x0149, code skipped:
            r2 = 0;
     */
    /* JADX WARNING: Missing block: B:79:0x014c, code skipped:
            if (r1.O0000ooo == false) goto L_0x01b1;
     */
    /* JADX WARNING: Missing block: B:80:0x014e, code skipped:
            r3 = r1.O0000oO0;
     */
    /* JADX WARNING: Missing block: B:81:0x0150, code skipped:
            monitor-enter(r3);
     */
    /* JADX WARNING: Missing block: B:83:?, code skipped:
            r4 = r1.O0000OOo.size();
            r5 = r1.O0000Ooo;
     */
    /* JADX WARNING: Missing block: B:84:0x0159, code skipped:
            monitor-enter(r5);
     */
    /* JADX WARNING: Missing block: B:86:?, code skipped:
            r6 = r1.O0000Ooo.size();
     */
    /* JADX WARNING: Missing block: B:87:0x0160, code skipped:
            if (r2 >= r4) goto L_0x01a6;
     */
    /* JADX WARNING: Missing block: B:88:0x0162, code skipped:
            if (r6 <= r2) goto L_0x0180;
     */
    /* JADX WARNING: Missing block: B:90:0x0166, code skipped:
            if (r1.O000o000 > 0) goto L_0x0180;
     */
    /* JADX WARNING: Missing block: B:91:0x0168, code skipped:
            ((com.autonavi.amap.mapcore.FPoint3) r1.O0000OOo.get(r2)).setColorIndex(((java.lang.Integer) r1.O0000Ooo.get(r2)).intValue());
     */
    /* JADX WARNING: Missing block: B:93:0x0183, code skipped:
            if (r6 <= (r1.O000o000 + r2)) goto L_0x01a3;
     */
    /* JADX WARNING: Missing block: B:95:0x0187, code skipped:
            if (r1.O000o000 <= 0) goto L_0x01a3;
     */
    /* JADX WARNING: Missing block: B:96:0x0189, code skipped:
            ((com.autonavi.amap.mapcore.FPoint3) r1.O0000OOo.get(r2)).setColorIndex(((java.lang.Integer) r1.O0000Ooo.get(r1.O000o000 + r2)).intValue());
     */
    /* JADX WARNING: Missing block: B:97:0x01a3, code skipped:
            r2 = r2 + 1;
     */
    /* JADX WARNING: Missing block: B:98:0x01a6, code skipped:
            monitor-exit(r5);
     */
    /* JADX WARNING: Missing block: B:100:?, code skipped:
            monitor-exit(r3);
     */
    /* JADX WARNING: Missing block: B:101:0x01a9, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:106:?, code skipped:
            throw r0;
     */
    /* JADX WARNING: Missing block: B:107:0x01ad, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:110:0x01b0, code skipped:
            throw r0;
     */
    /* JADX WARNING: Missing block: B:112:0x01b3, code skipped:
            if (r1.O000OOoO == null) goto L_0x01c6;
     */
    /* JADX WARNING: Missing block: B:114:0x01b7, code skipped:
            if (r1.O00oOoOo <= 0) goto L_0x01c6;
     */
    /* JADX WARNING: Missing block: B:115:0x01b9, code skipped:
            O00000Oo(r1.O00000oO.O0000O0o().getMapConfig());
     */
    /* JADX WARNING: Missing block: B:116:0x01c6, code skipped:
            r1.O00oOooO = true;
     */
    /* JADX WARNING: Missing block: B:117:0x01c9, code skipped:
            return;
     */
    public void O000000o(com.autonavi.amap.mapcore.MapConfig r18) throws android.os.RemoteException {
        /*
        r17 = this;
        r1 = r17;
        r2 = r1.O000OoOo;
        r4 = 0;
        r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r6 != 0) goto L_0x0025;
    L_0x000a:
        r2 = com.autonavi.amap.mapcore.AMapNativePolyline.nativeCreate();
        r1.O000OoOo = r2;
        r2 = r1.O000OoOo;
        r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r6 == 0) goto L_0x0025;
    L_0x0016:
        r2 = r1.O000OoOO;
        if (r2 == 0) goto L_0x0025;
    L_0x001a:
        r2 = r1.O000OoOo;
        r4 = r1.O000OoOO;
        r4 = r4.O000000o();
        com.autonavi.amap.mapcore.AMapNativePolyline.nativeSetGLShaderManager(r2, r4);
    L_0x0025:
        r2 = r1.O0000oO0;
        monitor-enter(r2);
        r3 = r1.O000Ooo;	 Catch:{ all -> 0x01cc }
        r4 = -1082130432; // 0xffffffffbf800000 float:-1.0 double:NaN;
        r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1));
        if (r3 != 0) goto L_0x0040;
    L_0x0030:
        r3 = r1.O000OooO;	 Catch:{ all -> 0x01cc }
        r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1));
        if (r3 != 0) goto L_0x0040;
    L_0x0036:
        r3 = r1.O000Oooo;	 Catch:{ all -> 0x01cc }
        r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1));
        if (r3 == 0) goto L_0x003d;
    L_0x003c:
        goto L_0x0040;
    L_0x003d:
        r3 = r1.O0000O0o;	 Catch:{ all -> 0x01cc }
        goto L_0x0042;
    L_0x0040:
        r3 = r1.O000o00;	 Catch:{ all -> 0x01cc }
    L_0x0042:
        if (r3 == 0) goto L_0x01ca;
    L_0x0044:
        r4 = r3.size();	 Catch:{ all -> 0x01cc }
        if (r4 == 0) goto L_0x01ca;
    L_0x004a:
        r4 = r1.O000O0o;	 Catch:{ all -> 0x01cc }
        r5 = 0;
        r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1));
        if (r4 > 0) goto L_0x0053;
    L_0x0051:
        goto L_0x01ca;
    L_0x0053:
        r4 = r1.O00000oO;	 Catch:{ all -> 0x01cc }
        r4 = r4.O0000O0o();	 Catch:{ all -> 0x01cc }
        if (r4 != 0) goto L_0x005d;
    L_0x005b:
        monitor-exit(r2);	 Catch:{ all -> 0x01cc }
        return;
    L_0x005d:
        r4 = r18.getSX();	 Catch:{ all -> 0x01cc }
        r5 = r18.getSY();	 Catch:{ all -> 0x01cc }
        r6 = r18.getGeoRectangle();	 Catch:{ all -> 0x01cc }
        r6 = r6.getBeyond180Mode();	 Catch:{ all -> 0x01cc }
        r7 = r1.O0000OOo;	 Catch:{ all -> 0x01cc }
        r7 = r7.size();	 Catch:{ all -> 0x01cc }
        r8 = r3.size();	 Catch:{ all -> 0x01cc }
        r9 = 1300234240; // 0x4d800000 float:2.68435456E8 double:6.424010695E-315;
        r10 = 134217728; // 0x8000000 float:3.85186E-34 double:6.63123685E-316;
        if (r7 != r8) goto L_0x00ae;
    L_0x007d:
        r7 = 0;
    L_0x007e:
        if (r7 >= r8) goto L_0x013d;
    L_0x0080:
        r12 = r3.get(r7);	 Catch:{ all -> 0x01cc }
        r12 = (com.autonavi.amap.mapcore.IPoint) r12;	 Catch:{ all -> 0x01cc }
        r13 = r1.O0000OOo;	 Catch:{ all -> 0x01cc }
        r13 = r13.get(r7);	 Catch:{ all -> 0x01cc }
        r13 = (com.autonavi.amap.mapcore.FPoint) r13;	 Catch:{ all -> 0x01cc }
        r14 = r12.x;	 Catch:{ all -> 0x01cc }
        r14 = r14 - r4;
        r14 = (float) r14;	 Catch:{ all -> 0x01cc }
        r13.x = r14;	 Catch:{ all -> 0x01cc }
        r12 = r12.y;	 Catch:{ all -> 0x01cc }
        r12 = r12 - r5;
        r12 = (float) r12;	 Catch:{ all -> 0x01cc }
        r13.y = r12;	 Catch:{ all -> 0x01cc }
        r12 = r1.O000Ooo0;	 Catch:{ all -> 0x01cc }
        if (r12 == 0) goto L_0x00ab;
    L_0x009e:
        if (r6 < 0) goto L_0x00a6;
    L_0x00a0:
        r12 = r18.getSX();	 Catch:{ all -> 0x01cc }
        if (r12 >= r10) goto L_0x00ab;
    L_0x00a6:
        r12 = r13.x;	 Catch:{ all -> 0x01cc }
        r12 = r12 - r9;
        r13.x = r12;	 Catch:{ all -> 0x01cc }
    L_0x00ab:
        r7 = r7 + 1;
        goto L_0x007e;
    L_0x00ae:
        r7 = r1.O0000OOo;	 Catch:{ all -> 0x01cc }
        r7.clear();	 Catch:{ all -> 0x01cc }
        r7 = 0;
        r12 = 0;
    L_0x00b5:
        if (r7 >= r8) goto L_0x013d;
    L_0x00b7:
        r13 = r3.get(r7);	 Catch:{ all -> 0x01cc }
        r13 = (com.autonavi.amap.mapcore.IPoint) r13;	 Catch:{ all -> 0x01cc }
        r14 = new com.autonavi.amap.mapcore.FPoint3;	 Catch:{ all -> 0x01cc }
        r14.<init>();	 Catch:{ all -> 0x01cc }
        r15 = r1.O0000Ooo;	 Catch:{ all -> 0x01cc }
        if (r15 == 0) goto L_0x010f;
    L_0x00c6:
        r15 = r1.O0000Ooo;	 Catch:{ all -> 0x01cc }
        monitor-enter(r15);	 Catch:{ all -> 0x01cc }
        r11 = r1.O000o000;	 Catch:{ all -> 0x010b }
        if (r11 > 0) goto L_0x00e9;
    L_0x00cd:
        r11 = r1.O0000Ooo;	 Catch:{ all -> 0x010b }
        if (r11 == 0) goto L_0x0109;
    L_0x00d1:
        r11 = r1.O0000Ooo;	 Catch:{ all -> 0x010b }
        r11 = r11.size();	 Catch:{ all -> 0x010b }
        if (r11 <= r12) goto L_0x0109;
    L_0x00d9:
        r11 = r1.O0000Ooo;	 Catch:{ all -> 0x010b }
        r11 = r11.get(r12);	 Catch:{ all -> 0x010b }
        r11 = (java.lang.Integer) r11;	 Catch:{ all -> 0x010b }
        r11 = r11.intValue();	 Catch:{ all -> 0x010b }
        r14.setColorIndex(r11);	 Catch:{ all -> 0x010b }
        goto L_0x0109;
    L_0x00e9:
        r11 = r1.O0000Ooo;	 Catch:{ all -> 0x010b }
        if (r11 == 0) goto L_0x0109;
    L_0x00ed:
        r11 = r1.O0000Ooo;	 Catch:{ all -> 0x010b }
        r11 = r11.size();	 Catch:{ all -> 0x010b }
        r9 = r1.O000o000;	 Catch:{ all -> 0x010b }
        if (r11 <= r9) goto L_0x0109;
    L_0x00f7:
        r9 = r1.O0000Ooo;	 Catch:{ all -> 0x010b }
        r11 = r1.O000o000;	 Catch:{ all -> 0x010b }
        r11 = r11 + r12;
        r9 = r9.get(r11);	 Catch:{ all -> 0x010b }
        r9 = (java.lang.Integer) r9;	 Catch:{ all -> 0x010b }
        r9 = r9.intValue();	 Catch:{ all -> 0x010b }
        r14.setColorIndex(r9);	 Catch:{ all -> 0x010b }
    L_0x0109:
        monitor-exit(r15);	 Catch:{ all -> 0x010b }
        goto L_0x010f;
    L_0x010b:
        r0 = move-exception;
        r3 = r0;
        monitor-exit(r15);	 Catch:{ all -> 0x010b }
        throw r3;	 Catch:{ all -> 0x01cc }
    L_0x010f:
        r9 = r13.x;	 Catch:{ all -> 0x01cc }
        r9 = r9 - r4;
        r9 = (float) r9;	 Catch:{ all -> 0x01cc }
        r14.x = r9;	 Catch:{ all -> 0x01cc }
        r9 = r13.y;	 Catch:{ all -> 0x01cc }
        r9 = r9 - r5;
        r9 = (float) r9;	 Catch:{ all -> 0x01cc }
        r14.y = r9;	 Catch:{ all -> 0x01cc }
        r9 = r1.O000Ooo0;	 Catch:{ all -> 0x01cc }
        if (r9 == 0) goto L_0x012f;
    L_0x011f:
        if (r6 < 0) goto L_0x0127;
    L_0x0121:
        r9 = r18.getSX();	 Catch:{ all -> 0x01cc }
        if (r9 >= r10) goto L_0x012f;
    L_0x0127:
        r9 = r14.x;	 Catch:{ all -> 0x01cc }
        r11 = 1300234240; // 0x4d800000 float:2.68435456E8 double:6.424010695E-315;
        r9 = r9 - r11;
        r14.x = r9;	 Catch:{ all -> 0x01cc }
        goto L_0x0131;
    L_0x012f:
        r11 = 1300234240; // 0x4d800000 float:2.68435456E8 double:6.424010695E-315;
    L_0x0131:
        r9 = r1.O0000OOo;	 Catch:{ all -> 0x01cc }
        r9.add(r14);	 Catch:{ all -> 0x01cc }
        r12 = r12 + 1;
        r7 = r7 + 1;
        r9 = r11;
        goto L_0x00b5;
    L_0x013d:
        monitor-exit(r2);	 Catch:{ all -> 0x01cc }
        r2 = r1.O0000ooO;
        if (r2 == 0) goto L_0x0149;
    L_0x0142:
        r17.O00000Oo();
        r2 = 0;
        r1.O0000ooO = r2;
        goto L_0x01b1;
    L_0x0149:
        r2 = 0;
        r3 = r1.O0000ooo;
        if (r3 == 0) goto L_0x01b1;
    L_0x014e:
        r3 = r1.O0000oO0;
        monitor-enter(r3);
        r4 = r1.O0000OOo;	 Catch:{ all -> 0x01ad }
        r4 = r4.size();	 Catch:{ all -> 0x01ad }
        r5 = r1.O0000Ooo;	 Catch:{ all -> 0x01ad }
        monitor-enter(r5);	 Catch:{ all -> 0x01ad }
        r6 = r1.O0000Ooo;	 Catch:{ all -> 0x01a9 }
        r6 = r6.size();	 Catch:{ all -> 0x01a9 }
    L_0x0160:
        if (r2 >= r4) goto L_0x01a6;
    L_0x0162:
        if (r6 <= r2) goto L_0x0180;
    L_0x0164:
        r7 = r1.O000o000;	 Catch:{ all -> 0x01a9 }
        if (r7 > 0) goto L_0x0180;
    L_0x0168:
        r7 = r1.O0000OOo;	 Catch:{ all -> 0x01a9 }
        r7 = r7.get(r2);	 Catch:{ all -> 0x01a9 }
        r7 = (com.autonavi.amap.mapcore.FPoint3) r7;	 Catch:{ all -> 0x01a9 }
        r8 = r1.O0000Ooo;	 Catch:{ all -> 0x01a9 }
        r8 = r8.get(r2);	 Catch:{ all -> 0x01a9 }
        r8 = (java.lang.Integer) r8;	 Catch:{ all -> 0x01a9 }
        r8 = r8.intValue();	 Catch:{ all -> 0x01a9 }
        r7.setColorIndex(r8);	 Catch:{ all -> 0x01a9 }
        goto L_0x01a3;
    L_0x0180:
        r7 = r1.O000o000;	 Catch:{ all -> 0x01a9 }
        r7 = r7 + r2;
        if (r6 <= r7) goto L_0x01a3;
    L_0x0185:
        r7 = r1.O000o000;	 Catch:{ all -> 0x01a9 }
        if (r7 <= 0) goto L_0x01a3;
    L_0x0189:
        r7 = r1.O0000OOo;	 Catch:{ all -> 0x01a9 }
        r7 = r7.get(r2);	 Catch:{ all -> 0x01a9 }
        r7 = (com.autonavi.amap.mapcore.FPoint3) r7;	 Catch:{ all -> 0x01a9 }
        r8 = r1.O0000Ooo;	 Catch:{ all -> 0x01a9 }
        r9 = r1.O000o000;	 Catch:{ all -> 0x01a9 }
        r9 = r9 + r2;
        r8 = r8.get(r9);	 Catch:{ all -> 0x01a9 }
        r8 = (java.lang.Integer) r8;	 Catch:{ all -> 0x01a9 }
        r8 = r8.intValue();	 Catch:{ all -> 0x01a9 }
        r7.setColorIndex(r8);	 Catch:{ all -> 0x01a9 }
    L_0x01a3:
        r2 = r2 + 1;
        goto L_0x0160;
    L_0x01a6:
        monitor-exit(r5);	 Catch:{ all -> 0x01a9 }
        monitor-exit(r3);	 Catch:{ all -> 0x01ad }
        goto L_0x01b1;
    L_0x01a9:
        r0 = move-exception;
        r2 = r0;
        monitor-exit(r5);	 Catch:{ all -> 0x01a9 }
        throw r2;	 Catch:{ all -> 0x01ad }
    L_0x01ad:
        r0 = move-exception;
        r2 = r0;
        monitor-exit(r3);	 Catch:{ all -> 0x01ad }
        throw r2;
    L_0x01b1:
        r2 = r1.O000OOoO;
        if (r2 == 0) goto L_0x01c6;
    L_0x01b5:
        r2 = r1.O00oOoOo;
        if (r2 <= 0) goto L_0x01c6;
    L_0x01b9:
        r2 = r1.O00000oO;
        r2 = r2.O0000O0o();
        r2 = r2.getMapConfig();
        r1.O00000Oo(r2);
    L_0x01c6:
        r2 = 1;
        r1.O00oOooO = r2;
        return;
    L_0x01ca:
        monitor-exit(r2);	 Catch:{ all -> 0x01cc }
        return;
    L_0x01cc:
        r0 = move-exception;
        r3 = r0;
        monitor-exit(r2);	 Catch:{ all -> 0x01cc }
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.OO000o0.O000000o(com.autonavi.amap.mapcore.MapConfig):void");
    }

    /* Access modifiers changed, original: 0000 */
    public void O000000o(List<LatLng> list) throws RemoteException {
        int i;
        ArrayList arrayList = new ArrayList();
        Builder builder = LatLngBounds.builder();
        if (list != null) {
            LatLng latLng = null;
            i = 0;
            for (LatLng latLng2 : list) {
                IPoint obtain;
                if (!this.O0000oOo) {
                    obtain = IPoint.obtain();
                    this.O00000oO.O0000O0o().O000000o(latLng2.latitude, latLng2.longitude, obtain);
                    arrayList.add(obtain);
                    builder.include(latLng2);
                } else if (latLng != null) {
                    if (Math.abs(latLng2.longitude - latLng.longitude) < 0.01d) {
                        IPoint obtain2 = IPoint.obtain();
                        this.O00000oO.O0000O0o().O000000o(latLng.latitude, latLng.longitude, obtain2);
                        arrayList.add(obtain2);
                        builder.include(latLng);
                        obtain = IPoint.obtain();
                        this.O00000oO.O0000O0o().O000000o(latLng2.latitude, latLng2.longitude, obtain);
                        arrayList.add(obtain);
                        builder.include(latLng2);
                    } else {
                        O000000o(latLng, latLng2, arrayList, builder);
                    }
                }
                if (latLng2 != null) {
                    if (i == 0 && latLng2.longitude < -180.0d) {
                        this.O000Ooo0 = true;
                        i = true;
                    }
                    if (!this.O000Ooo0 && latLng2.longitude > 180.0d) {
                        this.O000Ooo0 = true;
                    }
                }
                latLng = latLng2;
            }
        } else {
            i = 0;
        }
        this.O0000O0o = arrayList;
        this.O00oOoOo = 0;
        if (this.O000000o == null) {
            this.O000000o = new Rect();
        }
        OOo000.O000000o(this.O000000o);
        for (IPoint iPoint : this.O0000O0o) {
            if (i != 0) {
                iPoint.x += AMapEngineUtils.MAX_P20_WIDTH;
            }
            OOo000.O00000Oo(this.O000000o, iPoint.x, iPoint.y);
        }
        this.O000000o.sort();
        this.O00000oO.O0000O0o().setRunLowFrame(false);
    }

    /* Access modifiers changed, original: 0000 */
    public void O000000o(List<IPoint> list, List<IPoint> list2, double d) {
        List<IPoint> list3 = list;
        if (list.size() == 3) {
            int i = 10;
            int i2 = 0;
            int i3 = 0;
            while (i3 <= i) {
                float f = (float) i3;
                float f2 = f / 10.0f;
                IPoint obtain = IPoint.obtain();
                double d2 = 1.0d - ((double) f2);
                double d3 = d2 * d2;
                double d4 = ((double) (2.0f * f2)) * d2;
                f2 *= f2;
                double d5 = ((((double) ((IPoint) list3.get(i2)).x) * d3) + ((((double) ((IPoint) list3.get(1)).x) * d4) * d)) + ((double) (((float) ((IPoint) list3.get(2)).x) * f2));
                float f3 = f;
                d2 = ((((double) ((IPoint) list3.get(i2)).y) * d3) + ((((double) ((IPoint) list3.get(1)).y) * d4) * d)) + ((double) (((float) ((IPoint) list3.get(2)).y) * f2));
                d3 = (d3 + (d4 * d)) + ((double) f2);
                obtain.x = (int) (d5 / d3);
                obtain.y = (int) (d2 / d3);
                list2.add(obtain);
                i3 = (int) (f3 + 1.0f);
                i = 10;
                i2 = 0;
            }
        }
    }

    public void O000000o(boolean z) {
        this.O00oOooo = z;
        this.O00000oO.O0000O0o().setRunLowFrame(false);
    }

    /* JADX WARNING: Missing block: B:11:0x0025, code skipped:
            return true;
     */
    public boolean O000000o() {
        /*
        r3 = this;
        r0 = r3.O000Ooo0;
        r1 = 1;
        if (r0 == 0) goto L_0x0006;
    L_0x0005:
        return r1;
    L_0x0006:
        r0 = r3.O00000oO;
        r0 = r0.O0000O0o();
        r0 = r0.getMapConfig();
        r0 = r0.getGeoRectangle();
        r2 = r3.O000000o;
        if (r2 == 0) goto L_0x0025;
    L_0x0018:
        if (r0 == 0) goto L_0x0025;
    L_0x001a:
        r2 = r3.O000000o;
        r0 = r0.isOverlap(r2);
        if (r0 == 0) goto L_0x0023;
    L_0x0022:
        return r1;
    L_0x0023:
        r0 = 0;
        return r0;
    L_0x0025:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.OO000o0.O000000o():boolean");
    }

    public boolean O000000o(LatLng latLng) {
        float[] fArr = new float[this.O000OOoO.length];
        System.arraycopy(this.O000OOoO, 0, fArr, 0, this.O000OOoO.length);
        if (fArr.length / 3 < 2) {
            return false;
        }
        try {
            ArrayList O0000OOo = O0000OOo();
            if (O0000OOo == null || O0000OOo.size() < 1) {
                return false;
            }
            double mapLenWithWin = (double) this.O00000oO.O0000O0o().O00000o0().getMapLenWithWin(((int) this.O000O0o) / 4);
            double mapLenWithWin2 = (double) this.O00000oO.O0000O0o().O00000o0().getMapLenWithWin(5);
            FPoint O00000Oo = O00000Oo(latLng);
            FPoint fPoint = null;
            int i = 0;
            while (i < O0000OOo.size() - 1) {
                if (i == 0) {
                    fPoint = (FPoint) O0000OOo.get(i);
                }
                i++;
                FPoint fPoint2 = (FPoint) O0000OOo.get(i);
                if ((mapLenWithWin2 + mapLenWithWin) - O000000o(O00000Oo, fPoint, fPoint2) >= 0.0d) {
                    O0000OOo.clear();
                    return true;
                }
                fPoint = fPoint2;
            }
            O0000OOo.clear();
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public void O00000Oo(boolean z) {
        if (z && this.O0000o00 != null && this.O0000o00.size() > 1) {
            this.O000O00o = 4;
            this.O00000oO.O0000O0o().setRunLowFrame(false);
        }
    }

    public boolean O00000Oo() throws RemoteException {
        if (this.O000Ooo == -1.0f && this.O000OooO == -1.0f && this.O000Oooo == -1.0f) {
            O00000Oo(this.O0000O0o);
        } else {
            O00000Oo(this.O000o00);
        }
        return true;
    }

    public boolean O00000Oo(List<IPoint> list) {
        synchronized (this.O0000oO0) {
            FPointBounds.Builder builder = new FPointBounds.Builder();
            this.O0000OOo.clear();
            int i = 0;
            this.O00oOooO = false;
            this.O000OOoO = new float[(3 * list.size())];
            this.O00000Oo = this.O000OOoO.length;
            for (IPoint iPoint : list) {
                FPoint fPoint3 = new FPoint3();
                this.O00000oO.O0000O0o().O000000o(iPoint.x, iPoint.y, fPoint3);
                int i2 = i * 3;
                this.O000OOoO[i2] = fPoint3.x;
                this.O000OOoO[i2 + 1] = fPoint3.y;
                this.O000OOoO[i2 + 2] = 0.0f;
                if (this.O0000Ooo != null) {
                    synchronized (this.O0000Ooo) {
                        if (this.O0000Ooo == null || this.O0000Ooo.size() <= i) {
                            if (this.O0000o00 != null && this.O0000o00.size() > i) {
                                if (this.O000o000 <= 0) {
                                    fPoint3.setColorIndex(((Integer) this.O0000o00.get(i)).intValue());
                                } else if (this.O000o000 + i < this.O0000o00.size()) {
                                    fPoint3.setColorIndex(((Integer) this.O0000o00.get(this.O000o000 + i)).intValue());
                                }
                            }
                        } else if (this.O000o000 <= 0) {
                            fPoint3.setColorIndex(((Integer) this.O0000Ooo.get(i)).intValue());
                        } else if (this.O000o000 + i < this.O0000Ooo.size()) {
                            fPoint3.setColorIndex(((Integer) this.O0000Ooo.get(this.O000o000 + i)).intValue());
                        }
                    }
                }
                this.O0000OOo.add(fPoint3);
                builder.include(fPoint3);
                i++;
            }
            this.O000Oo0O = builder.build();
            if (!this.O00oOooo) {
                this.O0000o0o = OOo000.O000000o(this.O000OOoO);
            }
            this.O00oOoOo = list.size();
            O00000oO();
        }
        return true;
    }

    public void O00000o() {
        this.O0000oo = false;
        this.O000O0OO = 0;
        if (this.O000Oo00 != null) {
            Arrays.fill(this.O000Oo00, 0);
        }
    }

    public void O00000o0(List<Integer> list) {
        if (list != null && list.size() != 0) {
            this.O0000o00 = list;
            if (list.size() > 1) {
                this.O0000oOO = false;
                this.O0000o0O = O00000oo(list);
                this.O000O00o = 3;
                this.O00000oO.O0000O0o().setRunLowFrame(false);
            } else {
                setColor(((Integer) list.get(0)).intValue());
            }
        }
    }

    public boolean O00000o0() {
        return this.O00oOooO;
    }

    public void destroy() {
        try {
            remove();
            if (this.O0000OoO != null && this.O0000OoO.size() > 0) {
                for (int i = 0; i < this.O0000OoO.size(); i++) {
                    O0000O0o o0000O0o = (O0000O0o) this.O0000OoO.get(i);
                    if (o0000O0o != null) {
                        this.O00000oO.O000000o(o0000O0o);
                        this.O00000oO.O0000O0o().O00000o0(o0000O0o.O0000o0O());
                    }
                }
                this.O0000OoO.clear();
            }
            if (this.O000OOoO != null) {
                this.O000OOoO = null;
            }
            if (this.O0000o0o != null) {
                this.O0000o0o.clear();
                this.O0000o0o = null;
            }
            if (this.O0000Oo != null && this.O0000Oo.size() > 0) {
                for (BitmapDescriptor recycle : this.O0000Oo) {
                    recycle.recycle();
                }
            }
            synchronized (this) {
                if (this.O0000o != null) {
                    this.O0000o.recycle();
                }
            }
            if (this.O0000o00 != null) {
                this.O0000o00.clear();
                this.O0000o00 = null;
            }
            if (this.O0000Ooo != null) {
                synchronized (this.O0000Ooo) {
                    this.O0000Ooo.clear();
                    this.O0000Ooo = null;
                }
            }
            if (this.O0000Oo0 != null) {
                this.O0000Oo0.clear();
                this.O0000Oo0 = null;
            }
            this.O000Oo0o = null;
            if (this.O000OoOo != 0) {
                AMapNativePolyline.nativeDestroy(this.O000OoOo);
            }
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "PolylineDelegateImp", "destroy");
            th.printStackTrace();
            Log.d("destroy erro", "PolylineDelegateImp destroy");
        }
    }

    public boolean equalsRemote(IOverlay iOverlay) throws RemoteException {
        return equals(iOverlay) || iOverlay.getId().equals(getId());
    }

    public int getColor() throws RemoteException {
        return this.O000O0Oo;
    }

    public String getId() throws RemoteException {
        if (this.O00000oo == null) {
            this.O00000oo = this.O00000oO.O000000o("Polyline");
        }
        return this.O00000oo;
    }

    public LatLng getNearestLatLng(LatLng latLng) {
        if (latLng == null || this.O0000Oo0 == null || this.O0000Oo0.size() == 0) {
            return null;
        }
        int i = 0;
        float f = 0.0f;
        int i2 = 0;
        while (i < this.O0000Oo0.size()) {
            try {
                if (i == 0) {
                    f = AMapUtils.calculateLineDistance(latLng, (LatLng) this.O0000Oo0.get(i));
                } else {
                    float calculateLineDistance = AMapUtils.calculateLineDistance(latLng, (LatLng) this.O0000Oo0.get(i));
                    if (f > calculateLineDistance) {
                        i2 = i;
                        f = calculateLineDistance;
                    }
                }
                i++;
            } catch (Throwable th) {
                ooOOOOoo.O00000o0(th, "PolylineDelegateImp", "getNearestLatLng");
                th.printStackTrace();
                return null;
            }
        }
        return (LatLng) this.O0000Oo0.get(i2);
    }

    public PolylineOptions getOptions() {
        return this.O000Oo0o;
    }

    public List<LatLng> getPoints() throws RemoteException {
        return this.O0000Oo0;
    }

    public float getShownRatio() {
        return this.O000Ooo;
    }

    public float getWidth() throws RemoteException {
        return this.O000O0o;
    }

    public float getZIndex() throws RemoteException {
        return this.O000O0oO;
    }

    public int hashCodeRemote() throws RemoteException {
        return super.hashCode();
    }

    public boolean isAboveMaskLayer() {
        return this.O000Oo0;
    }

    public boolean isDottedLine() {
        return this.O0000oo0;
    }

    public boolean isGeodesic() {
        return this.O0000oOo;
    }

    public boolean isVisible() throws RemoteException {
        return this.O0000oO;
    }

    public void remove() throws RemoteException {
        this.O00000oO.removeOverlay(getId());
        setVisible(false);
        this.O00000oO.O0000O0o().setRunLowFrame(false);
    }

    public void setAboveMaskLayer(boolean z) {
        this.O000Oo0 = z;
    }

    public void setColor(int i) {
        if (this.O000O00o == 0 || this.O000O00o == 2) {
            this.O000O0Oo = i;
            this.O000OO00 = ((float) Color.alpha(i)) / 255.0f;
            this.O000OO0o = ((float) Color.red(i)) / 255.0f;
            this.O000OO = ((float) Color.green(i)) / 255.0f;
            this.O000OOOo = ((float) Color.blue(i)) / 255.0f;
            if (this.O0000oOO) {
                if (this.O0000oo0) {
                    this.O000O00o = 2;
                } else {
                    this.O000O00o = 0;
                }
            }
            this.O00000oO.O0000O0o().setRunLowFrame(false);
        }
        this.O000Oo0o.color(i);
    }

    public void setCustemTextureIndex(List<Integer> list) {
        if (list != null && list.size() != 0) {
            try {
                synchronized (this.O0000Ooo) {
                    this.O0000Ooo.clear();
                    this.O0000Ooo.addAll(list);
                    this.O0000o0 = O00000oo(list);
                    this.O0000ooo = true;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Missing block: B:16:0x003d, code skipped:
            return;
     */
    public void setCustomTexture(com.amap.api.maps.model.BitmapDescriptor r8) {
        /*
        r7 = this;
        r0 = java.lang.System.nanoTime();
        r2 = r7.O00000o;
        r4 = r0 - r2;
        r2 = 16;
        r2 = (long) r2;
        r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        if (r6 >= 0) goto L_0x0010;
    L_0x000f:
        return;
    L_0x0010:
        r7.O00000o = r0;
        if (r8 != 0) goto L_0x0015;
    L_0x0014:
        return;
    L_0x0015:
        monitor-enter(r7);
        r0 = r7.O0000o;	 Catch:{ all -> 0x003e }
        r0 = r8.equals(r0);	 Catch:{ all -> 0x003e }
        if (r0 == 0) goto L_0x0020;
    L_0x001e:
        monitor-exit(r7);	 Catch:{ all -> 0x003e }
        return;
    L_0x0020:
        r0 = 0;
        r7.O0000oOO = r0;	 Catch:{ all -> 0x003e }
        r7.O0000oo = r0;	 Catch:{ all -> 0x003e }
        r1 = 1;
        r7.O000O00o = r1;	 Catch:{ all -> 0x003e }
        r7.O0000o = r8;	 Catch:{ all -> 0x003e }
        r1 = r7.O00000oO;	 Catch:{ all -> 0x003e }
        r1 = r1.O0000O0o();	 Catch:{ all -> 0x003e }
        r1.setRunLowFrame(r0);	 Catch:{ all -> 0x003e }
        r0 = r7.O000Oo0o;	 Catch:{ all -> 0x003e }
        if (r0 == 0) goto L_0x003c;
    L_0x0037:
        r0 = r7.O000Oo0o;	 Catch:{ all -> 0x003e }
        r0.setCustomTexture(r8);	 Catch:{ all -> 0x003e }
    L_0x003c:
        monitor-exit(r7);	 Catch:{ all -> 0x003e }
        return;
    L_0x003e:
        r8 = move-exception;
        monitor-exit(r7);	 Catch:{ all -> 0x003e }
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.OO000o0.setCustomTexture(com.amap.api.maps.model.BitmapDescriptor):void");
    }

    public void setCustomTextureList(List<BitmapDescriptor> list) {
        O00000oO(list);
        setCustemTextureIndex(this.O000Oo0o.getCustomTextureIndex());
        O00000o();
    }

    public void setDottedLine(boolean z) {
        if (this.O000O00o == 2 || this.O000O00o == 0) {
            this.O0000oo0 = z;
            if (z && this.O0000oOO) {
                this.O000O00o = 2;
            } else if (!z && this.O0000oOO) {
                this.O000O00o = 0;
            }
            this.O00000oO.O0000O0o().setRunLowFrame(false);
        }
    }

    public void setGeodesic(boolean z) throws RemoteException {
        this.O0000oOo = z;
        this.O00000oO.O0000O0o().setRunLowFrame(false);
    }

    public void setOptions(PolylineOptions polylineOptions) {
        if (polylineOptions != null) {
            this.O000Oo0o = polylineOptions;
            try {
                setColor(polylineOptions.getColor());
                setGeodesic(polylineOptions.isGeodesic());
                setDottedLine(polylineOptions.isDottedLine());
                O000000o(polylineOptions.getDottedLineType());
                setAboveMaskLayer(polylineOptions.isAboveMaskLayer());
                setVisible(polylineOptions.isVisible());
                setWidth(polylineOptions.getWidth());
                setZIndex(polylineOptions.getZIndex());
                O000000o(polylineOptions.isUseTexture());
                setTransparency(polylineOptions.getTransparency());
                O000000o(polylineOptions.getLineCapType());
                O000000o(polylineOptions.getLineJoinType());
                if (polylineOptions.getColorValues() != null) {
                    O00000o0(polylineOptions.getColorValues());
                    O00000Oo(polylineOptions.isUseGradient());
                }
                if (polylineOptions.getCustomTexture() != null) {
                    setCustomTexture(polylineOptions.getCustomTexture());
                    O00000o();
                }
                if (polylineOptions.getCustomTextureList() != null) {
                    O00000oO(polylineOptions.getCustomTextureList());
                    setCustemTextureIndex(polylineOptions.getCustomTextureIndex());
                    O00000o();
                }
                setPoints(polylineOptions.getPoints());
                setShownRatio(polylineOptions.getShownRatio());
                setShowRange(polylineOptions.getShownRangeBegin(), polylineOptions.getShownRangeEnd());
            } catch (RemoteException e) {
                ooOOOOoo.O00000o0(e, "PolylineDelegateImp", "setOptions");
                e.printStackTrace();
            }
        }
    }

    public void setPoints(List<LatLng> list) throws RemoteException {
        try {
            this.O0000Oo0 = list;
            synchronized (this.O0000oO0) {
                O000000o((List) list);
            }
            this.O0000ooO = true;
            this.O00000oO.O0000O0o().setRunLowFrame(false);
            this.O000Oo0o.setPoints(list);
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "PolylineDelegateImp", "setPoints");
            this.O0000O0o.clear();
            th.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0046 A:{Catch:{ all -> 0x015e }} */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0044 A:{Catch:{ all -> 0x015e }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0059 A:{Catch:{ all -> 0x015e }} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0090 A:{Catch:{ all -> 0x015e }} */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0144 A:{Catch:{ all -> 0x015e }} */
    /* JADX WARNING: Missing block: B:60:0x0147, code skipped:
            r1.O0000ooO = true;
            r1.O00000oO.O0000O0o().setRunLowFrame(false);
            r1.O000Oo0o.setShownRange(r1.O000OooO, r1.O000Oooo);
     */
    /* JADX WARNING: Missing block: B:61:0x015d, code skipped:
            return;
     */
    public void setShowRange(float r20, float r21) {
        /*
        r19 = this;
        r1 = r19;
        r2 = r20;
        r3 = r21;
        r1.O000OooO = r2;
        r1.O000Oooo = r3;
        r4 = r1.O0000oO0;
        monitor-enter(r4);
        r5 = r1.O0000O0o;	 Catch:{ all -> 0x015e }
        r5 = r5.size();	 Catch:{ all -> 0x015e }
        r6 = 2;
        if (r5 >= r6) goto L_0x0018;
    L_0x0016:
        monitor-exit(r4);	 Catch:{ all -> 0x015e }
        return;
    L_0x0018:
        r7 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1));
        if (r7 <= 0) goto L_0x002a;
    L_0x001c:
        r2 = r1.O000o00;	 Catch:{ all -> 0x015e }
        r2.clear();	 Catch:{ all -> 0x015e }
        r2 = "mapcore";
        r3 = "setShownRange return begin < end";
        android.util.Log.d(r2, r3);	 Catch:{ all -> 0x015e }
        monitor-exit(r4);	 Catch:{ all -> 0x015e }
        return;
    L_0x002a:
        r7 = 0;
        r8 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1));
        if (r8 < 0) goto L_0x003f;
    L_0x002f:
        r8 = java.lang.Float.isNaN(r20);	 Catch:{ all -> 0x015e }
        if (r8 == 0) goto L_0x0036;
    L_0x0035:
        goto L_0x003f;
    L_0x0036:
        r8 = (float) r5;	 Catch:{ all -> 0x015e }
        r8 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
        if (r8 < 0) goto L_0x0040;
    L_0x003b:
        r2 = r5 + -1;
        r2 = (float) r2;	 Catch:{ all -> 0x015e }
        goto L_0x0040;
    L_0x003f:
        r2 = r7;
    L_0x0040:
        r8 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1));
        if (r8 >= 0) goto L_0x0046;
    L_0x0044:
        r3 = r7;
        goto L_0x0054;
    L_0x0046:
        r7 = (float) r5;	 Catch:{ all -> 0x015e }
        r7 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1));
        if (r7 >= 0) goto L_0x0051;
    L_0x004b:
        r7 = java.lang.Float.isNaN(r21);	 Catch:{ all -> 0x015e }
        if (r7 == 0) goto L_0x0054;
    L_0x0051:
        r3 = r5 + -1;
        r3 = (float) r3;	 Catch:{ all -> 0x015e }
    L_0x0054:
        r7 = r1.O0000oOo;	 Catch:{ all -> 0x015e }
        r8 = 1;
        if (r7 == 0) goto L_0x0073;
    L_0x0059:
        r7 = r1.O0000Oo0;	 Catch:{ all -> 0x015e }
        r7 = r7.size();	 Catch:{ all -> 0x015e }
        if (r7 >= r6) goto L_0x006a;
    L_0x0061:
        r2 = "mapcore";
        r3 = "setShownRatio return m_polylineOptions.m_latLngPoints.size() < MIN_POLYLINE_COUNT";
        android.util.Log.d(r2, r3);	 Catch:{ all -> 0x015e }
        monitor-exit(r4);	 Catch:{ all -> 0x015e }
        return;
    L_0x006a:
        r7 = r7 - r8;
        r6 = (float) r7;	 Catch:{ all -> 0x015e }
        r2 = r2 / r6;
        r7 = r5 + -1;
        r7 = (float) r7;	 Catch:{ all -> 0x015e }
        r2 = r2 * r7;
        r3 = r3 / r6;
        r3 = r3 * r7;
    L_0x0073:
        r6 = r1.O000o00;	 Catch:{ all -> 0x015e }
        r6.clear();	 Catch:{ all -> 0x015e }
        r6 = (double) r2;	 Catch:{ all -> 0x015e }
        r6 = java.lang.Math.floor(r6);	 Catch:{ all -> 0x015e }
        r6 = (int) r6;	 Catch:{ all -> 0x015e }
        r9 = (double) r3;	 Catch:{ all -> 0x015e }
        r9 = java.lang.Math.floor(r9);	 Catch:{ all -> 0x015e }
        r7 = (int) r9;	 Catch:{ all -> 0x015e }
        r9 = (float) r6;	 Catch:{ all -> 0x015e }
        r2 = r2 - r9;
        r9 = (double) r2;	 Catch:{ all -> 0x015e }
        r2 = (float) r7;	 Catch:{ all -> 0x015e }
        r3 = r3 - r2;
        r2 = (double) r3;	 Catch:{ all -> 0x015e }
        r11 = 0;
        r12 = r11;
        r13 = r12;
        r11 = r6;
    L_0x008e:
        if (r11 >= r5) goto L_0x0142;
    L_0x0090:
        r14 = r1.O0000O0o;	 Catch:{ all -> 0x015e }
        r14 = r14.get(r11);	 Catch:{ all -> 0x015e }
        r14 = (com.autonavi.amap.mapcore.IPoint) r14;	 Catch:{ all -> 0x015e }
        if (r6 < r11) goto L_0x00a1;
    L_0x009a:
        r16 = r9;
        r8 = r11;
        r12 = r14;
        r13 = r12;
        goto L_0x013b;
    L_0x00a1:
        if (r6 >= r11) goto L_0x0104;
    L_0x00a3:
        r15 = r11 + -1;
        if (r6 != r15) goto L_0x0104;
    L_0x00a7:
        r13 = new com.autonavi.amap.mapcore.IPoint;	 Catch:{ all -> 0x015e }
        r13.<init>();	 Catch:{ all -> 0x015e }
        r15 = r12.x;	 Catch:{ all -> 0x015e }
        r16 = r9;
        r8 = (double) r15;	 Catch:{ all -> 0x015e }
        r10 = r14.x;	 Catch:{ all -> 0x015e }
        r15 = r12.x;	 Catch:{ all -> 0x015e }
        r10 = r10 - r15;
        r18 = r11;
        r10 = (double) r10;	 Catch:{ all -> 0x015e }
        r10 = r10 * r16;
        r8 = r8 + r10;
        r8 = (int) r8;	 Catch:{ all -> 0x015e }
        r13.x = r8;	 Catch:{ all -> 0x015e }
        r8 = r12.y;	 Catch:{ all -> 0x015e }
        r8 = (double) r8;	 Catch:{ all -> 0x015e }
        r10 = r14.y;	 Catch:{ all -> 0x015e }
        r11 = r12.y;	 Catch:{ all -> 0x015e }
        r10 = r10 - r11;
        r10 = (double) r10;	 Catch:{ all -> 0x015e }
        r10 = r10 * r16;
        r8 = r8 + r10;
        r8 = (int) r8;	 Catch:{ all -> 0x015e }
        r13.y = r8;	 Catch:{ all -> 0x015e }
        r8 = r1.O000o00;	 Catch:{ all -> 0x015e }
        r8.add(r13);	 Catch:{ all -> 0x015e }
        if (r7 != r6) goto L_0x00fc;
    L_0x00d5:
        r5 = new com.autonavi.amap.mapcore.IPoint;	 Catch:{ all -> 0x015e }
        r5.<init>();	 Catch:{ all -> 0x015e }
        r7 = r12.x;	 Catch:{ all -> 0x015e }
        r7 = (double) r7;	 Catch:{ all -> 0x015e }
        r9 = r14.x;	 Catch:{ all -> 0x015e }
        r10 = r12.x;	 Catch:{ all -> 0x015e }
        r9 = r9 - r10;
        r9 = (double) r9;	 Catch:{ all -> 0x015e }
        r9 = r9 * r2;
        r7 = r7 + r9;
        r7 = (int) r7;	 Catch:{ all -> 0x015e }
        r5.x = r7;	 Catch:{ all -> 0x015e }
        r7 = r12.y;	 Catch:{ all -> 0x015e }
        r7 = (double) r7;	 Catch:{ all -> 0x015e }
        r9 = r14.y;	 Catch:{ all -> 0x015e }
        r10 = r12.y;	 Catch:{ all -> 0x015e }
        r9 = r9 - r10;
        r9 = (double) r9;	 Catch:{ all -> 0x015e }
        r9 = r9 * r2;
        r7 = r7 + r9;
        r2 = (int) r7;	 Catch:{ all -> 0x015e }
        r5.y = r2;	 Catch:{ all -> 0x015e }
        r2 = r1.O000o00;	 Catch:{ all -> 0x015e }
        r2.add(r5);	 Catch:{ all -> 0x015e }
        goto L_0x0142;
    L_0x00fc:
        r8 = r1.O000o00;	 Catch:{ all -> 0x015e }
        r8.add(r14);	 Catch:{ all -> 0x015e }
        r8 = r18;
        goto L_0x0110;
    L_0x0104:
        r16 = r9;
        r8 = r11;
        if (r6 >= r8) goto L_0x0112;
    L_0x0109:
        if (r7 < r8) goto L_0x0112;
    L_0x010b:
        r9 = r1.O000o00;	 Catch:{ all -> 0x015e }
        r9.add(r14);	 Catch:{ all -> 0x015e }
    L_0x0110:
        r13 = r14;
        goto L_0x013b;
    L_0x0112:
        if (r7 >= r8) goto L_0x013b;
    L_0x0114:
        r5 = new com.autonavi.amap.mapcore.IPoint;	 Catch:{ all -> 0x015e }
        r5.<init>();	 Catch:{ all -> 0x015e }
        r7 = r13.x;	 Catch:{ all -> 0x015e }
        r7 = (double) r7;	 Catch:{ all -> 0x015e }
        r9 = r14.x;	 Catch:{ all -> 0x015e }
        r10 = r13.x;	 Catch:{ all -> 0x015e }
        r9 = r9 - r10;
        r9 = (double) r9;	 Catch:{ all -> 0x015e }
        r9 = r9 * r2;
        r7 = r7 + r9;
        r7 = (int) r7;	 Catch:{ all -> 0x015e }
        r5.x = r7;	 Catch:{ all -> 0x015e }
        r7 = r13.y;	 Catch:{ all -> 0x015e }
        r7 = (double) r7;	 Catch:{ all -> 0x015e }
        r9 = r14.y;	 Catch:{ all -> 0x015e }
        r10 = r13.y;	 Catch:{ all -> 0x015e }
        r9 = r9 - r10;
        r9 = (double) r9;	 Catch:{ all -> 0x015e }
        r9 = r9 * r2;
        r7 = r7 + r9;
        r2 = (int) r7;	 Catch:{ all -> 0x015e }
        r5.y = r2;	 Catch:{ all -> 0x015e }
        r2 = r1.O000o00;	 Catch:{ all -> 0x015e }
        r2.add(r5);	 Catch:{ all -> 0x015e }
        goto L_0x0142;
    L_0x013b:
        r11 = r8 + 1;
        r9 = r16;
        r8 = 1;
        goto L_0x008e;
    L_0x0142:
        if (r6 < 0) goto L_0x0146;
    L_0x0144:
        r1.O000o000 = r6;	 Catch:{ all -> 0x015e }
    L_0x0146:
        monitor-exit(r4);	 Catch:{ all -> 0x015e }
        r2 = 1;
        r1.O0000ooO = r2;
        r2 = r1.O00000oO;
        r2 = r2.O0000O0o();
        r3 = 0;
        r2.setRunLowFrame(r3);
        r2 = r1.O000Oo0o;
        r3 = r1.O000OooO;
        r4 = r1.O000Oooo;
        r2.setShownRange(r3, r4);
        return;
    L_0x015e:
        r0 = move-exception;
        r2 = r0;
        monitor-exit(r4);	 Catch:{ all -> 0x015e }
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.OO000o0.setShowRange(float, float):void");
    }

    /* JADX WARNING: Missing block: B:30:0x008b, code skipped:
            r10.O0000ooO = true;
            r10.O00000oO.O0000O0o().setRunLowFrame(false);
            r10.O000Oo0o.setShownRatio(r11);
     */
    /* JADX WARNING: Missing block: B:31:0x009b, code skipped:
            return;
     */
    public void setShownRatio(float r11) {
        /*
        r10 = this;
        r10.O000Ooo = r11;
        r0 = r10.O0000oO0;
        monitor-enter(r0);
        r1 = r10.O0000O0o;	 Catch:{ all -> 0x009c }
        r1 = r1.size();	 Catch:{ all -> 0x009c }
        r2 = 2;
        if (r1 >= r2) goto L_0x0010;
    L_0x000e:
        monitor-exit(r0);	 Catch:{ all -> 0x009c }
        return;
    L_0x0010:
        r3 = r10.O000Ooo;	 Catch:{ all -> 0x009c }
        r4 = 0;
        r5 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1));
        if (r5 >= 0) goto L_0x0019;
    L_0x0017:
        r3 = r4;
        goto L_0x0021;
    L_0x0019:
        r5 = (float) r1;	 Catch:{ all -> 0x009c }
        r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r5 < 0) goto L_0x0021;
    L_0x001e:
        r3 = r1 + -1;
        r3 = (float) r3;	 Catch:{ all -> 0x009c }
    L_0x0021:
        r5 = r10.O0000oOo;	 Catch:{ all -> 0x009c }
        r6 = 1;
        if (r5 == 0) goto L_0x0037;
    L_0x0026:
        r5 = r10.O0000Oo0;	 Catch:{ all -> 0x009c }
        r5 = r5.size();	 Catch:{ all -> 0x009c }
        if (r5 >= r2) goto L_0x0030;
    L_0x002e:
        monitor-exit(r0);	 Catch:{ all -> 0x009c }
        return;
    L_0x0030:
        r5 = r5 - r6;
        r2 = (float) r5;	 Catch:{ all -> 0x009c }
        r3 = r3 / r2;
        r2 = r1 + -1;
        r2 = (float) r2;	 Catch:{ all -> 0x009c }
        r3 = r3 * r2;
    L_0x0037:
        r2 = r10.O000o00;	 Catch:{ all -> 0x009c }
        r2.clear();	 Catch:{ all -> 0x009c }
        r7 = (double) r3;	 Catch:{ all -> 0x009c }
        r7 = java.lang.Math.floor(r7);	 Catch:{ all -> 0x009c }
        r2 = (int) r7;	 Catch:{ all -> 0x009c }
        r5 = 0;
        r7 = 0;
        r8 = r5;
        r5 = r7;
    L_0x0046:
        if (r5 >= r1) goto L_0x008a;
    L_0x0048:
        r9 = r10.O0000O0o;	 Catch:{ all -> 0x009c }
        r9 = r9.get(r5);	 Catch:{ all -> 0x009c }
        r9 = (com.autonavi.amap.mapcore.IPoint) r9;	 Catch:{ all -> 0x009c }
        if (r5 <= r2) goto L_0x0081;
    L_0x0052:
        r1 = (float) r2;	 Catch:{ all -> 0x009c }
        r3 = r3 - r1;
        r1 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1));
        if (r1 == 0) goto L_0x008a;
    L_0x0058:
        if (r8 == 0) goto L_0x008a;
    L_0x005a:
        r1 = new com.autonavi.amap.mapcore.IPoint;	 Catch:{ all -> 0x009c }
        r1.<init>();	 Catch:{ all -> 0x009c }
        r2 = r8.x;	 Catch:{ all -> 0x009c }
        r2 = (float) r2;	 Catch:{ all -> 0x009c }
        r4 = r9.x;	 Catch:{ all -> 0x009c }
        r5 = r8.x;	 Catch:{ all -> 0x009c }
        r4 = r4 - r5;
        r4 = (float) r4;	 Catch:{ all -> 0x009c }
        r4 = r4 * r3;
        r2 = r2 + r4;
        r2 = (int) r2;	 Catch:{ all -> 0x009c }
        r1.x = r2;	 Catch:{ all -> 0x009c }
        r2 = r8.y;	 Catch:{ all -> 0x009c }
        r2 = (float) r2;	 Catch:{ all -> 0x009c }
        r4 = r9.y;	 Catch:{ all -> 0x009c }
        r5 = r8.y;	 Catch:{ all -> 0x009c }
        r4 = r4 - r5;
        r4 = (float) r4;	 Catch:{ all -> 0x009c }
        r4 = r4 * r3;
        r2 = r2 + r4;
        r2 = (int) r2;	 Catch:{ all -> 0x009c }
        r1.y = r2;	 Catch:{ all -> 0x009c }
        r2 = r10.O000o00;	 Catch:{ all -> 0x009c }
        r2.add(r1);	 Catch:{ all -> 0x009c }
        goto L_0x008a;
    L_0x0081:
        r8 = r10.O000o00;	 Catch:{ all -> 0x009c }
        r8.add(r9);	 Catch:{ all -> 0x009c }
        r5 = r5 + 1;
        r8 = r9;
        goto L_0x0046;
    L_0x008a:
        monitor-exit(r0);	 Catch:{ all -> 0x009c }
        r10.O0000ooO = r6;
        r0 = r10.O00000oO;
        r0 = r0.O0000O0o();
        r0.setRunLowFrame(r7);
        r0 = r10.O000Oo0o;
        r0.setShownRatio(r11);
        return;
    L_0x009c:
        r11 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x009c }
        throw r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.OO000o0.setShownRatio(float):void");
    }

    public void setTransparency(float f) {
        this.O000OOo0 = (float) Math.min(1.0d, Math.max(0.0d, (double) f));
        this.O00000oO.O0000O0o().setRunLowFrame(false);
    }

    public void setVisible(boolean z) throws RemoteException {
        this.O0000oO = z;
        this.O00000oO.O0000O0o().setRunLowFrame(false);
        if (this.O000Oo0o != null) {
            this.O000Oo0o.visible(z);
        }
    }

    public void setWidth(float f) throws RemoteException {
        this.O000O0o = f;
        this.O00000oO.O0000O0o().setRunLowFrame(false);
        this.O000Oo0o.width(f);
    }

    public void setZIndex(float f) throws RemoteException {
        this.O000O0oO = f;
        this.O00000oO.O00000oO();
        this.O00000oO.O0000O0o().setRunLowFrame(false);
        if (this.O000Oo0o != null) {
            this.O000Oo0o.zIndex(f);
        }
    }
}
