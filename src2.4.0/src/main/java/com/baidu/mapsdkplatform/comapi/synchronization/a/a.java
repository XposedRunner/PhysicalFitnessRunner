package com.baidu.mapsdkplatform.comapi.synchronization.a;

import android.content.Context;
import android.view.View;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.synchronization.DisplayOptions;
import com.baidu.mapapi.synchronization.RoleOptions;
import com.baidu.mapapi.synchronization.SyncCoordinateConverter.CoordType;
import com.baidu.mapapi.synchronization.SynchronizationConstants;
import com.baidu.mapapi.synchronization.SynchronizationDisplayListener;
import com.baidu.mapsdkplatform.comapi.synchronization.c.c;
import com.baidu.mapsdkplatform.comapi.synchronization.data.k;
import com.baidu.mapsdkplatform.comapi.synchronization.data.l;
import com.baidu.mapsdkplatform.comapi.synchronization.render.d;
import com.baidu.mapsdkplatform.comapi.synchronization.render.e;

public class a implements k, d {
    private static final String a = "a";
    private l b = null;
    private e c = null;
    private SynchronizationDisplayListener d;

    public a(Context context, BaiduMap baiduMap, RoleOptions roleOptions, DisplayOptions displayOptions) {
        if (context == null) {
            throw new IllegalArgumentException("Context invalid, please check!");
        } else if (baiduMap == null || !(baiduMap instanceof BaiduMap)) {
            throw new IllegalArgumentException("BaiduMap is null or invalid, please check!");
        } else if (b(roleOptions)) {
            this.b = new l(roleOptions, displayOptions);
            this.b.a((k) this);
            this.c = new e(context, baiduMap);
            this.c.a((d) this);
        } else {
            throw new IllegalArgumentException("RoleOptions is invalid, please check!");
        }
    }

    /* JADX WARNING: Missing block: B:23:0x00ba, code skipped:
            return false;
     */
    private boolean a(com.baidu.mapapi.model.LatLng r20, com.baidu.mapapi.synchronization.RoleOptions r21) {
        /*
        r19 = this;
        r0 = r20;
        r1 = 0;
        if (r0 != 0) goto L_0x0006;
    L_0x0005:
        return r1;
    L_0x0006:
        r2 = -4582834833314545664; // 0xc066800000000000 float:0.0 double:-180.0;
        r4 = 4640537203540230144; // 0x4066800000000000 float:0.0 double:180.0;
        r6 = -4587338432941916160; // 0xc056800000000000 float:0.0 double:-90.0;
        r8 = 4636033603912859648; // 0x4056800000000000 float:0.0 double:90.0;
        r10 = com.baidu.mapapi.synchronization.SyncCoordinateConverter.CoordType.COMMON;
        r11 = r21.getCoordType();
        r12 = 0;
        if (r10 != r11) goto L_0x007d;
    L_0x0024:
        r10 = new com.baidu.mapapi.synchronization.SyncCoordinateConverter;
        r10.<init>();
        r11 = r21.getCoordType();
        r11 = r10.from(r11);
        r14 = new com.baidu.mapapi.model.LatLng;
        r14.<init>(r6, r2);
        r2 = r11.coord(r14);
        r2 = r2.convert();
        r6 = r2.longitude;
        r2 = r2.latitude;
        r11 = r21.getCoordType();
        r11 = r10.from(r11);
        r14 = new com.baidu.mapapi.model.LatLng;
        r14.<init>(r8, r4);
        r4 = r11.coord(r14);
        r4 = r4.convert();
        r8 = r4.longitude;
        r4 = r4.latitude;
        r11 = r21.getCoordType();
        r10 = r10.from(r11);
        r11 = new com.baidu.mapapi.model.LatLng;
        r11.<init>(r12, r12);
        r10 = r10.coord(r11);
        r10 = r10.convert();
        r12 = r10.longitude;
        r10 = r10.latitude;
        r15 = r4;
        r4 = r8;
        r8 = r15;
        r17 = r2;
        r2 = r6;
        r6 = r17;
        goto L_0x007e;
    L_0x007d:
        r10 = r12;
    L_0x007e:
        r12 = java.lang.Double.valueOf(r12);
        r13 = r0.longitude;
        r13 = java.lang.Double.valueOf(r13);
        r12 = r12.compareTo(r13);
        if (r12 != 0) goto L_0x009f;
    L_0x008e:
        r10 = java.lang.Double.valueOf(r10);
        r11 = r0.latitude;
        r11 = java.lang.Double.valueOf(r11);
        r10 = r10.compareTo(r11);
        if (r10 != 0) goto L_0x009f;
    L_0x009e:
        return r1;
    L_0x009f:
        r10 = r0.longitude;
        r12 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1));
        if (r12 < 0) goto L_0x00ba;
    L_0x00a5:
        r2 = r0.longitude;
        r10 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r10 > 0) goto L_0x00ba;
    L_0x00ab:
        r2 = r0.latitude;
        r4 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r4 < 0) goto L_0x00ba;
    L_0x00b1:
        r2 = r0.latitude;
        r0 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
        if (r0 <= 0) goto L_0x00b8;
    L_0x00b7:
        return r1;
    L_0x00b8:
        r0 = 1;
        return r0;
    L_0x00ba:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.synchronization.a.a.a(com.baidu.mapapi.model.LatLng, com.baidu.mapapi.synchronization.RoleOptions):boolean");
    }

    private boolean a(CoordType coordType) {
        return CoordType.BD09LL == coordType || CoordType.COMMON == coordType;
    }

    private boolean b(RoleOptions roleOptions) {
        if (roleOptions != null && roleOptions.getOrderId() != null && !roleOptions.getOrderId().equals("") && roleOptions.getRoleType() == 0 && roleOptions.getDriverId() != null && !roleOptions.getDriverId().equals("") && roleOptions.getUserId() != null && !roleOptions.getUserId().equals("") && a(roleOptions.getCoordType()) && a(roleOptions.getStartPosition(), roleOptions)) {
            return true;
        }
        if (roleOptions == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The roleOptions is null");
        } else {
            String str = a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("The roleOptions content is: OrderId = ");
            stringBuilder.append(roleOptions.getOrderId());
            stringBuilder.append("; DriverId = ");
            stringBuilder.append(roleOptions.getDriverId());
            stringBuilder.append("; UserId = ");
            stringBuilder.append(roleOptions.getUserId());
            stringBuilder.append("; StartPosition = ");
            stringBuilder.append(roleOptions.getStartPosition());
            stringBuilder.append("; EndPosition = ");
            stringBuilder.append(roleOptions.getEndPosition());
            stringBuilder.append("; DriverPosition = ");
            stringBuilder.append(roleOptions.getDriverPosition());
            stringBuilder.append("; CoordType = ");
            stringBuilder.append(roleOptions.getCoordType());
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str, stringBuilder.toString());
        }
        return false;
    }

    private boolean e(int i) {
        return i >= 0 && i <= 5;
    }

    public void a() {
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "onResume");
        if (this.b != null) {
            this.b.a();
        }
        if (this.c != null) {
            this.c.a();
        }
    }

    public void a(float f, long j) {
        if (this.d != null) {
            this.d.onRoutePlanInfoFreshFinished(f, j);
        }
    }

    public void a(int i) {
        String str = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The order state = ");
        stringBuilder.append(i);
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(str, stringBuilder.toString());
        if (!e(i)) {
            if (this.d != null) {
                this.d.onSynchronizationProcessResult(1002, SynchronizationConstants.LBS_STATUS_MESSAGE_ORDER_STATE_INVALID);
            }
            i = 0;
        }
        if (this.c != null) {
            this.c.a(i);
        }
        if (this.b != null) {
            this.b.a(i);
        }
    }

    public void a(int i, int i2, int i3, int i4) {
        if (this.c != null) {
            this.c.a(i, i2, i3, i4);
        }
    }

    public void a(int i, String str) {
        if (this.d != null) {
            this.d.onSynchronizationProcessResult(i, str);
        }
    }

    public void a(View view) {
        if (this.b != null) {
            this.b.a(view);
        }
    }

    public void a(DisplayOptions displayOptions) {
        if (this.b != null && displayOptions != null) {
            this.b.a(displayOptions);
        }
    }

    public void a(RoleOptions roleOptions) {
        if (roleOptions == null || !b(roleOptions)) {
            if (this.d != null) {
                this.d.onSynchronizationProcessResult(1003, SynchronizationConstants.LBS_STATUS_MESSAGE_ORDER_PARAM_INVALID);
            }
            return;
        }
        if (this.b != null) {
            this.b.a(roleOptions);
        }
    }

    public void a(SynchronizationDisplayListener synchronizationDisplayListener) {
        if (synchronizationDisplayListener == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "SynchronizationDisplayListener is null, must be applied.");
            throw new IllegalArgumentException("synchronizationDisplayListener is null");
        } else {
            this.d = synchronizationDisplayListener;
        }
    }

    public void a(boolean z) {
        c.b = z;
    }

    public void b() {
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "onPause");
        if (this.b != null) {
            this.b.b();
        }
        if (this.c != null) {
            this.c.b();
        }
    }

    public void b(int i) {
        if (i < 5) {
            i = 5;
        }
        if (i > 30) {
            i = 30;
        }
        if (this.b != null) {
            this.b.b(i);
        }
        if (this.c != null) {
            this.c.b(i);
        }
    }

    public void b(int i, String str) {
        if (this.d != null) {
            this.d.onSynchronizationProcessResult(i, str);
        }
    }

    public void b(View view) {
        if (this.b != null) {
            this.b.b(view);
        }
    }

    public void b(SynchronizationDisplayListener synchronizationDisplayListener) {
        if (this.d != null) {
            this.d = null;
        }
    }

    public void c() {
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "release");
        if (this.b != null) {
            this.b.c();
        }
        if (this.c != null) {
            this.c.f();
        }
        if (this.d != null) {
            this.d = null;
        }
    }

    public void c(int i) {
        if (i < 10) {
            i = 10;
        }
        if (i > 30) {
            i = 30;
        }
        if (this.c != null) {
            this.c.c(i);
        }
    }

    public void c(int i, String str) {
        if (this.d != null) {
            this.d.onSynchronizationProcessResult(i, str);
        }
    }

    public void c(View view) {
        if (this.b != null) {
            this.b.c(view);
        }
    }

    public Marker d() {
        if (this.c != null) {
            return this.c.c();
        }
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Data manager instance is null");
        return null;
    }

    public void d(int i) {
        if (i < 5) {
            i = 5;
        }
        if (i > 30) {
            i = 30;
        }
        if (this.c != null) {
            this.c.d(i);
        }
    }

    public Marker e() {
        if (this.c != null) {
            return this.c.d();
        }
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Data manager instance is null");
        return null;
    }

    public Marker f() {
        if (this.c != null) {
            return this.c.e();
        }
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Data manager instance is null");
        return null;
    }

    public void g() {
        if (this.c != null) {
            this.c.g();
        }
    }

    public boolean h() {
        return c.b;
    }
}
