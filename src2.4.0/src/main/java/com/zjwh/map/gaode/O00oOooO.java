package com.zjwh.map.gaode;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.zjwh.sw.map.O00000o;
import com.zjwh.sw.map.entity.SWLatLng;
import defpackage.lq;
import defpackage.lz;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: GaoDeRunMapControl */
public class O00oOooO extends O000O00o implements lq {
    private List<Marker> O000O0Oo = new ArrayList();
    private List<Marker> O000O0o0 = new ArrayList();
    private List<BitmapDescriptor> O00oOoOo = new ArrayList();

    public O00oOooO(MapView mapView) {
        super(mapView);
    }

    public O00oOooO(MapView mapView, Map<String, String> map) {
        super(mapView);
        if (map != null) {
            O000000o((Map) map);
        }
    }

    public double O000000o(double d, double d2, double d3, double d4) {
        return O000O0OO.O000000o(d, d2, d3, d4);
    }

    public void O000000o(double d, double d2) {
        if (this.b_ != null) {
            this.b_.O000000o(d, d2, 17.0f);
        }
    }

    public void O000000o(double d, double d2, float f) {
        if (this.b_ != null) {
            this.b_.O00000Oo(d, d2, f);
        }
    }

    public void O000000o(int i, boolean z) {
        if (this.O000O0Oo.size() > i) {
            ((Marker) this.O000O0Oo.get(i)).setIcon(z ? this.O00000oo : this.O00000o);
        }
    }

    public void O000000o(Bitmap bitmap, SWLatLng sWLatLng) throws O00000o {
        if (this.b_ != null) {
            O000O0OO.O000000o(sWLatLng, this.a_.getContext());
            BitmapDescriptor fromBitmap = BitmapDescriptorFactory.fromBitmap(bitmap);
            this.O00oOoOo.add(fromBitmap);
            Object zIndex = new MarkerOptions().position(new LatLng(sWLatLng.getGLat(), sWLatLng.getGLon())).zIndex(9.0f);
            zIndex.icon(fromBitmap);
            this.O000O0o0.add((Marker) this.b_.O000000o(zIndex));
        }
    }

    /* JADX WARNING: Missing block: B:42:0x00ed, code skipped:
            if (r10 == null) goto L_0x0018;
     */
    /* JADX WARNING: Missing block: B:43:0x00ef, code skipped:
            r7.icon(r10);
     */
    /* JADX WARNING: Missing block: B:44:0x00f3, code skipped:
            if (r3 != 4) goto L_0x011d;
     */
    /* JADX WARNING: Missing block: B:45:0x00f5, code skipped:
            r0.b_.O000000o(new com.amap.api.maps.model.CircleOptions().center(r8).radius(50.0d).fillColor(422823106).strokeColor(-13384510).strokeWidth(1.0f));
     */
    /* JADX WARNING: Missing block: B:46:0x011d, code skipped:
            r7 = (com.amap.api.maps.model.Marker) r0.b_.O000000o(r7);
            r7.setPeriod(r11);
            r7.setTitle(r9);
            r0.O000O0Oo.add(r7);
     */
    /* JADX WARNING: Missing block: B:47:0x0134, code skipped:
            if (r6.getPosition() == 0) goto L_0x0138;
     */
    /* JADX WARNING: Missing block: B:48:0x0136, code skipped:
            if (r11 != 1) goto L_0x0018;
     */
    /* JADX WARNING: Missing block: B:49:0x0138, code skipped:
            r0.b_.O00000Oo(r7);
     */
    public void O000000o(java.util.List<com.zjwh.sw.map.entity.SWFixedPoint> r18, com.zjwh.sw.map.entity.SWLatLng r19, int r20) throws com.zjwh.sw.map.O00000o {
        /*
        r17 = this;
        r0 = r17;
        r1 = r19;
        r3 = r20;
        if (r18 != 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r4 = r0.O000O0Oo;
        r4.clear();
        r4 = new java.util.ArrayList;
        r4.<init>();
        r5 = 0;
        r2 = r18.iterator();
    L_0x0018:
        r6 = r2.hasNext();
        if (r6 == 0) goto L_0x013f;
    L_0x001e:
        r6 = r2.next();
        r6 = (com.zjwh.sw.map.entity.SWFixedPoint) r6;
        r7 = r6.getGLat();
        r9 = r6.getGLon();
        r11 = r6.getBLat();
        r13 = r6.getBLon();
        r15 = r0.a_;
        r15 = r15.getContext();
        r7 = com.zjwh.map.gaode.O000O0OO.O000000o(r7, r9, r11, r13, r15);
        r4.add(r7);
        r8 = new com.amap.api.maps.model.LatLng;
        r9 = r7.getGLat();
        r11 = r7.getGLon();
        r8.<init>(r9, r11);
        r7 = new com.amap.api.maps.model.MarkerOptions;
        r7.<init>();
        r7 = r7.position(r8);
        r9 = 1091567616; // 0x41100000 float:9.0 double:5.39306059E-315;
        r7 = r7.zIndex(r9);
        r9 = r6.getPointName();
        if (r9 == 0) goto L_0x0068;
    L_0x0063:
        r9 = r6.getPointName();
        goto L_0x006a;
    L_0x0068:
        r9 = "点位未命名";
    L_0x006a:
        r10 = 3;
        r11 = 2;
        r12 = 1;
        switch(r3) {
            case 2: goto L_0x00c4;
            case 3: goto L_0x0083;
            case 4: goto L_0x007f;
            default: goto L_0x0070;
        };
    L_0x0070:
        r11 = r6.getIsFixed();
        if (r11 != r12) goto L_0x00dd;
    L_0x0076:
        r10 = r6.isPassed();
        if (r10 == 0) goto L_0x00d9;
    L_0x007c:
        r10 = r0.O00000oo;
        goto L_0x00db;
    L_0x007f:
        r10 = r0.O0000O0o;
        goto L_0x00ed;
    L_0x0083:
        r10 = r6.getPosition();
        r11 = 999; // 0x3e7 float:1.4E-42 double:4.936E-321;
        if (r10 != r11) goto L_0x008d;
    L_0x008b:
        goto L_0x013f;
    L_0x008d:
        r10 = r6.isPassed();
        if (r10 == 0) goto L_0x0098;
    L_0x0093:
        r10 = r0.O00000o;
        r5 = r5 + 1;
        goto L_0x00ab;
    L_0x0098:
        r10 = r6.getPosition();
        if (r10 != r5) goto L_0x00a3;
    L_0x009e:
        r10 = r0.O0000Oo;
        r10 = r10[r5];
        goto L_0x00ab;
    L_0x00a3:
        r10 = r0.O0000OoO;
        r11 = r6.getPosition();
        r10 = r10[r11];
    L_0x00ab:
        r11 = r6.getPosition();
        r11 = r11 + r12;
        r13 = new java.lang.StringBuilder;
        r13.<init>();
        r13.append(r9);
        r9 = r6.getPosition();
        r13.append(r9);
        r9 = r13.toString();
        goto L_0x00ed;
    L_0x00c4:
        r13 = r6.getIsFixed();
        if (r13 != r12) goto L_0x00cd;
    L_0x00ca:
        r10 = r0.O0000O0o;
        goto L_0x00ed;
    L_0x00cd:
        r11 = r6.isPassed();
        if (r11 == 0) goto L_0x00d6;
    L_0x00d3:
        r11 = r0.O00000o;
        goto L_0x00e8;
    L_0x00d6:
        r11 = r0.O00000o0;
        goto L_0x00e8;
    L_0x00d9:
        r10 = r0.O00000oO;
    L_0x00db:
        r11 = r12;
        goto L_0x00ed;
    L_0x00dd:
        r11 = r6.isPassed();
        if (r11 == 0) goto L_0x00e6;
    L_0x00e3:
        r11 = r0.O00000o;
        goto L_0x00e8;
    L_0x00e6:
        r11 = r0.O00000o0;
    L_0x00e8:
        r16 = r11;
        r11 = r10;
        r10 = r16;
    L_0x00ed:
        if (r10 == 0) goto L_0x0018;
    L_0x00ef:
        r7.icon(r10);
        r10 = 4;
        if (r3 != r10) goto L_0x011d;
    L_0x00f5:
        r10 = new com.amap.api.maps.model.CircleOptions;
        r10.<init>();
        r8 = r10.center(r8);
        r13 = 4632233691727265792; // 0x4049000000000000 float:0.0 double:50.0;
        r8 = r8.radius(r13);
        r10 = 422823106; // 0x1933c4c2 float:9.293818E-24 double:2.08902371E-315;
        r8 = r8.fillColor(r10);
        r10 = -13384510; // 0xffffffffff33c4c2 float:-2.3895344E38 double:NaN;
        r8 = r8.strokeColor(r10);
        r10 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r8 = r8.strokeWidth(r10);
        r10 = r0.b_;
        r10.O000000o(r8);
    L_0x011d:
        r8 = r0.b_;
        r7 = r8.O000000o(r7);
        r7 = (com.amap.api.maps.model.Marker) r7;
        r7.setPeriod(r11);
        r7.setTitle(r9);
        r8 = r0.O000O0Oo;
        r8.add(r7);
        r6 = r6.getPosition();
        if (r6 == 0) goto L_0x0138;
    L_0x0136:
        if (r11 != r12) goto L_0x0018;
    L_0x0138:
        r6 = r0.b_;
        r6.O00000Oo(r7);
        goto L_0x0018;
    L_0x013f:
        if (r1 == 0) goto L_0x0144;
    L_0x0141:
        r4.add(r1);
    L_0x0144:
        r1 = r0.b_;
        r1.O00000Oo(r4);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zjwh.map.gaode.O00oOooO.O000000o(java.util.List, com.zjwh.sw.map.entity.SWLatLng, int):void");
    }

    public void O000000o(lz lzVar) {
        if (this.b_ != null) {
            this.b_.O000000o(lzVar);
        }
    }

    public void O00000Oo(int i, boolean z) {
        if (this.b_ != null && this.O000O0Oo.size() > i) {
            ((Marker) this.O000O0Oo.get(i)).setIcon(this.O00000o);
            if (!z) {
                i++;
                if (this.O000O0Oo.size() > i) {
                    Object obj = (Marker) this.O000O0Oo.get(i);
                    obj.setIcon(this.O0000Oo[i]);
                    this.b_.O00000Oo(obj);
                }
            }
        }
    }

    public void O00000Oo(Bundle bundle) {
        super.O000000o(2, bundle);
    }

    public void O00000o() {
        if (this.O00oOoOo.size() > 0) {
            for (BitmapDescriptor recycle : this.O00oOoOo) {
                recycle.recycle();
            }
        }
        this.O00oOoOo.clear();
        if (this.O000O0o0.size() > 0) {
            for (Marker remove : this.O000O0o0) {
                remove.remove();
            }
        }
        this.O000O0o0.clear();
    }

    public void O00000o0() {
        super.O00000o0();
        O00000o();
        if (this.O000O0Oo != null) {
            this.O000O0Oo.clear();
            this.O000O0Oo = null;
        }
    }
}
