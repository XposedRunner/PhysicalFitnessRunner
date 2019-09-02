package com.zjwh.map.gaode;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.zjwh.sw.map.O00000o;
import com.zjwh.sw.map.entity.SWLatLng;
import defpackage.lo;
import defpackage.ly;
import java.util.List;
import java.util.Map;

/* compiled from: GaoDeRunHistoryControl */
public class O0000o0 extends O000O00o implements lo {
    public O0000o0(MapView mapView) {
        super(mapView);
    }

    public O0000o0(MapView mapView, Map<String, String> map) {
        super(mapView);
        if (map != null) {
            O000000o((Map) map);
        }
    }

    public void O000000o(Bitmap bitmap) {
        if (this.b_ != null) {
            this.b_.O000000o(bitmap);
        }
    }

    public void O000000o(Bitmap bitmap, SWLatLng sWLatLng) throws O00000o {
        O000O0OO.O000000o(sWLatLng, this.a_.getContext());
        BitmapDescriptor fromBitmap = BitmapDescriptorFactory.fromBitmap(bitmap);
        Object zIndex = new MarkerOptions().position(new LatLng(sWLatLng.getGLat(), sWLatLng.getGLon())).zIndex(9.0f);
        zIndex.icon(fromBitmap);
        this.b_.O000000o(zIndex);
    }

    public void O000000o(List<SWLatLng> list) {
        if (this.b_ != null) {
            this.b_.O00000Oo((List) list);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:74:0x0124 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0124 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003f  */
    public void O000000o(java.util.List<com.zjwh.sw.map.entity.SWFixedPoint> r19, int r20, int r21) throws com.zjwh.sw.map.O00000o {
        /*
        r18 = this;
        r0 = r18;
        r1 = r21;
        java.util.Collections.sort(r19);
        r2 = 0;
        r3 = 1;
        r4 = -1;
        if (r1 != r4) goto L_0x002f;
    L_0x000c:
        r4 = r19;
        r5 = r4.get(r2);
        r5 = (com.zjwh.sw.map.entity.SWFixedPoint) r5;
        r6 = r5.getPosition();
        r7 = 5;
        if (r6 >= r7) goto L_0x002d;
    L_0x001b:
        r6 = r5.getPosition();
        if (r6 < 0) goto L_0x002d;
    L_0x0021:
        r5 = r5.getPosition();
        if (r5 != 0) goto L_0x0029;
    L_0x0027:
        r5 = r3;
        goto L_0x002a;
    L_0x0029:
        r5 = r2;
    L_0x002a:
        r6 = r5;
        r5 = r3;
        goto L_0x0035;
    L_0x002d:
        r5 = r2;
        goto L_0x0034;
    L_0x002f:
        r4 = r19;
        if (r1 != r3) goto L_0x002d;
    L_0x0033:
        r5 = r3;
    L_0x0034:
        r6 = r3;
    L_0x0035:
        r4 = r19.iterator();
    L_0x0039:
        r7 = r4.hasNext();
        if (r7 == 0) goto L_0x0127;
    L_0x003f:
        r7 = r4.next();
        r7 = (com.zjwh.sw.map.entity.SWFixedPoint) r7;
        r8 = r7.getGLat();
        r10 = r7.getGLon();
        r12 = r7.getBLat();
        r14 = r7.getBLon();
        r3 = r0.a_;
        r16 = r3.getContext();
        r3 = com.zjwh.map.gaode.O000O0OO.O000000o(r8, r10, r12, r14, r16);
        r8 = new com.amap.api.maps.model.LatLng;
        r9 = r3.getGLat();
        r11 = r3.getGLon();
        r8.<init>(r9, r11);
        r3 = new com.amap.api.maps.model.MarkerOptions;
        r3.<init>();
        r3 = r3.position(r8);
        r8 = 1084227584; // 0x40a00000 float:5.0 double:5.356796015E-315;
        r3 = r3.zIndex(r8);
        if (r5 == 0) goto L_0x00d7;
    L_0x007d:
        r8 = r7.getPosition();
        r9 = 999; // 0x3e7 float:1.4E-42 double:4.936E-321;
        if (r8 != r9) goto L_0x0087;
    L_0x0085:
        goto L_0x0127;
    L_0x0087:
        if (r6 == 0) goto L_0x00a9;
    L_0x0089:
        r8 = r7.isPassed();
        if (r8 == 0) goto L_0x0092;
    L_0x008f:
        r8 = r0.O00000o;
        goto L_0x00a5;
    L_0x0092:
        r8 = r7.getPosition();
        if (r2 != r8) goto L_0x009d;
    L_0x0098:
        r8 = r0.O0000Oo;
        r8 = r8[r2];
        goto L_0x00a5;
    L_0x009d:
        r8 = r0.O0000OoO;
        r9 = r7.getPosition();
        r8 = r8[r9];
    L_0x00a5:
        r3.icon(r8);
        goto L_0x00cb;
    L_0x00a9:
        r8 = r7.isPassed();
        if (r8 == 0) goto L_0x00b2;
    L_0x00af:
        r8 = r0.O00000o;
        goto L_0x00c8;
    L_0x00b2:
        r8 = r7.getPosition();
        r9 = 1;
        r8 = r8 - r9;
        if (r2 != r8) goto L_0x00bf;
    L_0x00ba:
        r8 = r0.O0000Oo;
        r8 = r8[r2];
        goto L_0x00c8;
    L_0x00bf:
        r8 = r0.O0000OoO;
        r10 = r7.getPosition();
        r10 = r10 - r9;
        r8 = r8[r10];
    L_0x00c8:
        r3.icon(r8);
    L_0x00cb:
        r7 = r7.isPassed();
        if (r7 == 0) goto L_0x00d3;
    L_0x00d1:
        r2 = r2 + 1;
    L_0x00d3:
        r9 = r20;
    L_0x00d5:
        r11 = 1;
        goto L_0x0119;
    L_0x00d7:
        r8 = 2;
        r9 = r20;
        r10 = 1;
        if (r9 != r10) goto L_0x00ee;
    L_0x00dd:
        if (r1 != r8) goto L_0x00ee;
    L_0x00df:
        r7 = r7.isPassed();
        if (r7 == 0) goto L_0x00e8;
    L_0x00e5:
        r7 = r0.O0000Oo0;
        goto L_0x00ea;
    L_0x00e8:
        r7 = r0.O0000OOo;
    L_0x00ea:
        r3.icon(r7);
        goto L_0x00d5;
    L_0x00ee:
        r10 = r7.getIsFixed();
        r11 = 1;
        if (r10 == r11) goto L_0x010b;
    L_0x00f5:
        r10 = r7.getIsFixed();
        if (r10 != r8) goto L_0x00fc;
    L_0x00fb:
        goto L_0x010b;
    L_0x00fc:
        r7 = r7.isPassed();
        if (r7 == 0) goto L_0x0105;
    L_0x0102:
        r7 = r0.O00000o;
        goto L_0x0107;
    L_0x0105:
        r7 = r0.O00000o0;
    L_0x0107:
        r3.icon(r7);
        goto L_0x0119;
    L_0x010b:
        r7 = r7.isPassed();
        if (r7 == 0) goto L_0x0114;
    L_0x0111:
        r7 = r0.O00000oo;
        goto L_0x0116;
    L_0x0114:
        r7 = r0.O00000oO;
    L_0x0116:
        r3.icon(r7);
    L_0x0119:
        r7 = r3.getIcon();
        if (r7 == 0) goto L_0x0124;
    L_0x011f:
        r7 = r0.b_;
        r7.O000000o(r3);
    L_0x0124:
        r3 = r11;
        goto L_0x0039;
    L_0x0127:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zjwh.map.gaode.O0000o0.O000000o(java.util.List, int, int):void");
    }

    public void O000000o(ly lyVar) {
        if (this.b_ != null) {
            this.b_.O000000o(lyVar);
        }
    }

    public void O00000Oo(Bundle bundle) {
        super.O000000o(0, bundle);
    }

    public void O00000o() {
        this.O0000Ooo = 0;
        this.O0000o00 = null;
    }
}
