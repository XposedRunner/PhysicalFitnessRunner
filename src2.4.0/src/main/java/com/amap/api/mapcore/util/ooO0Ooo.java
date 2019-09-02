package com.amap.api.mapcore.util;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Point;
import android.location.Location;
import android.os.RemoteException;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MyLocationStyle;
import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.amap.mapcore.IPoint;

/* compiled from: MyLocationOverlay */
public class ooO0Ooo {
    O000000o O000000o = null;
    ValueAnimator O00000Oo;
    AnimatorUpdateListener O00000o = new AnimatorUpdateListener() {
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            try {
                if (ooO0Ooo.this.O0000O0o != null) {
                    LatLng latLng = (LatLng) valueAnimator.getAnimatedValue();
                    ooO0Ooo.this.O0000O0o.setCenter(latLng);
                    ooO0Ooo.this.O00000oo.setPosition(latLng);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };
    AnimatorListener O00000o0 = new AnimatorListener() {
        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            ooO0Ooo.this.O0000Oo0();
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    };
    private ca O00000oO;
    private Marker O00000oo;
    private Circle O0000O0o;
    private MyLocationStyle O0000OOo = new MyLocationStyle();
    private double O0000Oo;
    private LatLng O0000Oo0;
    private Context O0000OoO;
    private O0000Oo O0000Ooo;
    private boolean O0000o = false;
    private boolean O0000o0 = false;
    private int O0000o00 = 4;
    private boolean O0000o0O = false;
    private boolean O0000o0o = false;
    private boolean O0000oO = false;
    private boolean O0000oO0 = false;

    /* compiled from: MyLocationOverlay */
    public static class O000000o implements TypeEvaluator {
        public Object evaluate(float f, Object obj, Object obj2) {
            LatLng latLng = (LatLng) obj;
            LatLng latLng2 = (LatLng) obj2;
            double d = (double) f;
            return new LatLng(latLng.latitude + ((latLng2.latitude - latLng.latitude) * d), latLng.longitude + (d * (latLng2.longitude - latLng.longitude)));
        }
    }

    public ooO0Ooo(ca caVar, Context context) {
        this.O0000OoO = context.getApplicationContext();
        this.O00000oO = caVar;
        this.O0000Ooo = new O0000Oo(this.O0000OoO, caVar);
        O000000o(4, true);
    }

    private void O000000o(int i, boolean z) {
        this.O0000o00 = i;
        this.O0000o0 = false;
        this.O0000o0o = false;
        this.O0000o0O = false;
        this.O0000oO0 = false;
        this.O0000oO = false;
        switch (this.O0000o00) {
            case 1:
                this.O0000o0O = true;
                this.O0000o0o = true;
                this.O0000o = true;
                break;
            case 2:
                this.O0000o0O = true;
                this.O0000o = true;
                break;
            case 3:
                this.O0000o0O = true;
                this.O0000oO = true;
                break;
            case 4:
                this.O0000o0O = true;
                this.O0000oO0 = true;
                break;
            case 5:
                this.O0000oO0 = true;
                break;
            case 7:
                this.O0000oO = true;
                break;
        }
        if (this.O0000oO0 || this.O0000oO) {
            if (this.O0000oO) {
                this.O0000Ooo.O000000o(true);
                if (!z) {
                    try {
                        this.O00000oO.O000000o(O000O0o0.O000000o(17.0f));
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                O00000Oo(45.0f);
            } else {
                this.O0000Ooo.O000000o(false);
            }
            this.O0000Ooo.O000000o();
            if (this.O00000oo != null) {
                this.O00000oo.setFlat(true);
                return;
            }
            return;
        }
        if (this.O00000oo != null) {
            this.O00000oo.setFlat(false);
        }
        O0000OOo();
        O0000O0o();
        O00000oo();
    }

    private void O000000o(LatLng latLng) {
        LatLng position = this.O00000oo.getPosition();
        if (position == null) {
            position = new LatLng(0.0d, 0.0d);
        }
        if (this.O000000o == null) {
            this.O000000o = new O000000o();
        }
        if (this.O00000Oo == null) {
            this.O00000Oo = ValueAnimator.ofObject(new O000000o(), new Object[]{position, latLng});
            this.O00000Oo.addListener(this.O00000o0);
            this.O00000Oo.addUpdateListener(this.O00000o);
        } else {
            this.O00000Oo.setObjectValues(new Object[]{position, latLng});
            this.O00000Oo.setEvaluator(this.O000000o);
        }
        if (position.latitude == 0.0d && position.longitude == 0.0d) {
            this.O00000Oo.setDuration(1);
        } else {
            this.O00000Oo.setDuration(1000);
        }
        this.O00000Oo.start();
    }

    private void O00000Oo(float f) {
        if (this.O00000oO != null) {
            try {
                this.O00000oO.O000000o(O000O0o0.O00000o0(f));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void O00000o(float f) {
        if (this.O0000o) {
            f %= 360.0f;
            if (f > 180.0f) {
                f -= 360.0f;
            } else if (f < -180.0f) {
                f += 360.0f;
            }
            if (this.O00000oo != null) {
                this.O00000oo.setRotateAngle(-f);
            }
        }
    }

    private void O00000o0(float f) {
        if (this.O00000oO != null) {
            try {
                this.O00000oO.O000000o(O000O0o0.O00000o(f));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void O00000oo() {
        this.O0000Ooo.O00000Oo();
    }

    private void O0000O0o() {
        O00000Oo(0.0f);
    }

    private void O0000OOo() {
        O00000o0(0.0f);
    }

    private void O0000Oo() {
        if (this.O0000OOo == null) {
            this.O0000OOo = new MyLocationStyle();
            this.O0000OOo.myLocationIcon(BitmapDescriptorFactory.fromAsset("location_map_gps_locked.png"));
            O0000Ooo();
            return;
        }
        if (this.O0000OOo.getMyLocationIcon() == null || this.O0000OOo.getMyLocationIcon().getBitmap() == null) {
            this.O0000OOo.myLocationIcon(BitmapDescriptorFactory.fromAsset("location_map_gps_locked.png"));
        }
        O0000Ooo();
    }

    private void O0000Oo0() {
        if (this.O0000Oo0 == null || !this.O0000o0O) {
            return;
        }
        if (!this.O0000o0o || !this.O0000o0) {
            this.O0000o0 = true;
            try {
                Point obtain = IPoint.obtain();
                GLMapState.lonlat2Geo(this.O0000Oo0.longitude, this.O0000Oo0.latitude, obtain);
                this.O00000oO.O00000Oo(O000O0o0.O000000o(obtain));
            } catch (Throwable th) {
                ooOOOOoo.O00000o0(th, "MyLocationOverlay", "moveMapToLocation");
                th.printStackTrace();
            }
        }
    }

    private void O0000OoO() {
        if (this.O0000O0o != null) {
            try {
                this.O00000oO.O000000o(this.O0000O0o.getId());
            } catch (Throwable th) {
                ooOOOOoo.O00000o0(th, "MyLocationOverlay", "locationIconRemove");
                th.printStackTrace();
            }
            this.O0000O0o = null;
        }
        if (this.O00000oo != null) {
            this.O00000oo.remove();
            this.O00000oo = null;
            this.O0000Ooo.O000000o(null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x011b A:{Catch:{ Throwable -> 0x0132 }} */
    private void O0000Ooo() {
        /*
        r5 = this;
        r0 = r5.O0000O0o;	 Catch:{ Throwable -> 0x0132 }
        if (r0 != 0) goto L_0x0017;
    L_0x0004:
        r0 = r5.O00000oO;	 Catch:{ Throwable -> 0x0132 }
        r1 = new com.amap.api.maps.model.CircleOptions;	 Catch:{ Throwable -> 0x0132 }
        r1.<init>();	 Catch:{ Throwable -> 0x0132 }
        r2 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r1 = r1.zIndex(r2);	 Catch:{ Throwable -> 0x0132 }
        r0 = r0.addCircle(r1);	 Catch:{ Throwable -> 0x0132 }
        r5.O0000O0o = r0;	 Catch:{ Throwable -> 0x0132 }
    L_0x0017:
        r0 = r5.O0000O0o;	 Catch:{ Throwable -> 0x0132 }
        r1 = 1;
        if (r0 == 0) goto L_0x0080;
    L_0x001c:
        r0 = r5.O0000O0o;	 Catch:{ Throwable -> 0x0132 }
        r0 = r0.getStrokeWidth();	 Catch:{ Throwable -> 0x0132 }
        r2 = r5.O0000OOo;	 Catch:{ Throwable -> 0x0132 }
        r2 = r2.getStrokeWidth();	 Catch:{ Throwable -> 0x0132 }
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 == 0) goto L_0x0037;
    L_0x002c:
        r0 = r5.O0000O0o;	 Catch:{ Throwable -> 0x0132 }
        r2 = r5.O0000OOo;	 Catch:{ Throwable -> 0x0132 }
        r2 = r2.getStrokeWidth();	 Catch:{ Throwable -> 0x0132 }
        r0.setStrokeWidth(r2);	 Catch:{ Throwable -> 0x0132 }
    L_0x0037:
        r0 = r5.O0000O0o;	 Catch:{ Throwable -> 0x0132 }
        r0 = r0.getFillColor();	 Catch:{ Throwable -> 0x0132 }
        r2 = r5.O0000OOo;	 Catch:{ Throwable -> 0x0132 }
        r2 = r2.getRadiusFillColor();	 Catch:{ Throwable -> 0x0132 }
        if (r0 == r2) goto L_0x0050;
    L_0x0045:
        r0 = r5.O0000O0o;	 Catch:{ Throwable -> 0x0132 }
        r2 = r5.O0000OOo;	 Catch:{ Throwable -> 0x0132 }
        r2 = r2.getRadiusFillColor();	 Catch:{ Throwable -> 0x0132 }
        r0.setFillColor(r2);	 Catch:{ Throwable -> 0x0132 }
    L_0x0050:
        r0 = r5.O0000O0o;	 Catch:{ Throwable -> 0x0132 }
        r0 = r0.getStrokeColor();	 Catch:{ Throwable -> 0x0132 }
        r2 = r5.O0000OOo;	 Catch:{ Throwable -> 0x0132 }
        r2 = r2.getStrokeColor();	 Catch:{ Throwable -> 0x0132 }
        if (r0 == r2) goto L_0x0069;
    L_0x005e:
        r0 = r5.O0000O0o;	 Catch:{ Throwable -> 0x0132 }
        r2 = r5.O0000OOo;	 Catch:{ Throwable -> 0x0132 }
        r2 = r2.getStrokeColor();	 Catch:{ Throwable -> 0x0132 }
        r0.setStrokeColor(r2);	 Catch:{ Throwable -> 0x0132 }
    L_0x0069:
        r0 = r5.O0000Oo0;	 Catch:{ Throwable -> 0x0132 }
        if (r0 == 0) goto L_0x0074;
    L_0x006d:
        r0 = r5.O0000O0o;	 Catch:{ Throwable -> 0x0132 }
        r2 = r5.O0000Oo0;	 Catch:{ Throwable -> 0x0132 }
        r0.setCenter(r2);	 Catch:{ Throwable -> 0x0132 }
    L_0x0074:
        r0 = r5.O0000O0o;	 Catch:{ Throwable -> 0x0132 }
        r2 = r5.O0000Oo;	 Catch:{ Throwable -> 0x0132 }
        r0.setRadius(r2);	 Catch:{ Throwable -> 0x0132 }
        r0 = r5.O0000O0o;	 Catch:{ Throwable -> 0x0132 }
        r0.setVisible(r1);	 Catch:{ Throwable -> 0x0132 }
    L_0x0080:
        r0 = r5.O00000oo;	 Catch:{ Throwable -> 0x0132 }
        r2 = 0;
        if (r0 != 0) goto L_0x0096;
    L_0x0085:
        r0 = r5.O00000oO;	 Catch:{ Throwable -> 0x0132 }
        r3 = new com.amap.api.maps.model.MarkerOptions;	 Catch:{ Throwable -> 0x0132 }
        r3.<init>();	 Catch:{ Throwable -> 0x0132 }
        r3 = r3.visible(r2);	 Catch:{ Throwable -> 0x0132 }
        r0 = r0.addMarker(r3);	 Catch:{ Throwable -> 0x0132 }
        r5.O00000oo = r0;	 Catch:{ Throwable -> 0x0132 }
    L_0x0096:
        r0 = r5.O00000oo;	 Catch:{ Throwable -> 0x0132 }
        if (r0 == 0) goto L_0x0127;
    L_0x009a:
        r0 = r5.O00000oo;	 Catch:{ Throwable -> 0x0132 }
        r0 = r0.getAnchorU();	 Catch:{ Throwable -> 0x0132 }
        r3 = r5.O0000OOo;	 Catch:{ Throwable -> 0x0132 }
        r3 = r3.getAnchorU();	 Catch:{ Throwable -> 0x0132 }
        r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1));
        if (r0 != 0) goto L_0x00ba;
    L_0x00aa:
        r0 = r5.O00000oo;	 Catch:{ Throwable -> 0x0132 }
        r0 = r0.getAnchorV();	 Catch:{ Throwable -> 0x0132 }
        r3 = r5.O0000OOo;	 Catch:{ Throwable -> 0x0132 }
        r3 = r3.getAnchorV();	 Catch:{ Throwable -> 0x0132 }
        r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1));
        if (r0 == 0) goto L_0x00cb;
    L_0x00ba:
        r0 = r5.O00000oo;	 Catch:{ Throwable -> 0x0132 }
        r3 = r5.O0000OOo;	 Catch:{ Throwable -> 0x0132 }
        r3 = r3.getAnchorU();	 Catch:{ Throwable -> 0x0132 }
        r4 = r5.O0000OOo;	 Catch:{ Throwable -> 0x0132 }
        r4 = r4.getAnchorV();	 Catch:{ Throwable -> 0x0132 }
        r0.setAnchor(r3, r4);	 Catch:{ Throwable -> 0x0132 }
    L_0x00cb:
        r0 = r5.O00000oo;	 Catch:{ Throwable -> 0x0132 }
        r0 = r0.getIcons();	 Catch:{ Throwable -> 0x0132 }
        if (r0 == 0) goto L_0x010c;
    L_0x00d3:
        r0 = r5.O00000oo;	 Catch:{ Throwable -> 0x0132 }
        r0 = r0.getIcons();	 Catch:{ Throwable -> 0x0132 }
        r0 = r0.size();	 Catch:{ Throwable -> 0x0132 }
        if (r0 != 0) goto L_0x00e0;
    L_0x00df:
        goto L_0x010c;
    L_0x00e0:
        r0 = r5.O0000OOo;	 Catch:{ Throwable -> 0x0132 }
        r0 = r0.getMyLocationIcon();	 Catch:{ Throwable -> 0x0132 }
        if (r0 == 0) goto L_0x0117;
    L_0x00e8:
        r0 = r5.O00000oo;	 Catch:{ Throwable -> 0x0132 }
        r0 = r0.getIcons();	 Catch:{ Throwable -> 0x0132 }
        r0 = r0.get(r2);	 Catch:{ Throwable -> 0x0132 }
        r0 = (com.amap.api.maps.model.BitmapDescriptor) r0;	 Catch:{ Throwable -> 0x0132 }
        r2 = r5.O0000OOo;	 Catch:{ Throwable -> 0x0132 }
        r2 = r2.getMyLocationIcon();	 Catch:{ Throwable -> 0x0132 }
        r0 = r0.equals(r2);	 Catch:{ Throwable -> 0x0132 }
        if (r0 != 0) goto L_0x0117;
    L_0x0100:
        r0 = r5.O00000oo;	 Catch:{ Throwable -> 0x0132 }
        r2 = r5.O0000OOo;	 Catch:{ Throwable -> 0x0132 }
        r2 = r2.getMyLocationIcon();	 Catch:{ Throwable -> 0x0132 }
        r0.setIcon(r2);	 Catch:{ Throwable -> 0x0132 }
        goto L_0x0117;
    L_0x010c:
        r0 = r5.O00000oo;	 Catch:{ Throwable -> 0x0132 }
        r2 = r5.O0000OOo;	 Catch:{ Throwable -> 0x0132 }
        r2 = r2.getMyLocationIcon();	 Catch:{ Throwable -> 0x0132 }
        r0.setIcon(r2);	 Catch:{ Throwable -> 0x0132 }
    L_0x0117:
        r0 = r5.O0000Oo0;	 Catch:{ Throwable -> 0x0132 }
        if (r0 == 0) goto L_0x0127;
    L_0x011b:
        r0 = r5.O00000oo;	 Catch:{ Throwable -> 0x0132 }
        r2 = r5.O0000Oo0;	 Catch:{ Throwable -> 0x0132 }
        r0.setPosition(r2);	 Catch:{ Throwable -> 0x0132 }
        r0 = r5.O00000oo;	 Catch:{ Throwable -> 0x0132 }
        r0.setVisible(r1);	 Catch:{ Throwable -> 0x0132 }
    L_0x0127:
        r5.O0000Oo0();	 Catch:{ Throwable -> 0x0132 }
        r0 = r5.O0000Ooo;	 Catch:{ Throwable -> 0x0132 }
        r1 = r5.O00000oo;	 Catch:{ Throwable -> 0x0132 }
        r0.O000000o(r1);	 Catch:{ Throwable -> 0x0132 }
        goto L_0x013d;
    L_0x0132:
        r0 = move-exception;
        r1 = "MyLocationOverlay";
        r2 = "myLocStyle";
        com.amap.api.mapcore.util.ooOOOOoo.O00000o0(r0, r1, r2);
        r0.printStackTrace();
    L_0x013d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.ooO0Ooo.O0000Ooo():void");
    }

    public MyLocationStyle O000000o() {
        return this.O0000OOo;
    }

    public void O000000o(float f) {
        if (this.O00000oo != null) {
            this.O00000oo.setRotateAngle(f);
        }
    }

    public void O000000o(int i) {
        O000000o(i, false);
    }

    public void O000000o(Location location) {
        if (location != null) {
            O000000o(this.O0000OOo.isMyLocationShowing());
            if (this.O0000OOo.isMyLocationShowing()) {
                this.O0000Oo0 = new LatLng(location.getLatitude(), location.getLongitude());
                this.O0000Oo = (double) location.getAccuracy();
                if (this.O00000oo == null && this.O0000O0o == null) {
                    O0000Oo();
                }
                if (this.O0000O0o != null) {
                    try {
                        if (this.O0000Oo != -1.0d) {
                            this.O0000O0o.setRadius(this.O0000Oo);
                        }
                    } catch (Throwable th) {
                        ooOOOOoo.O00000o0(th, "MyLocationOverlay", "setCentAndRadius");
                        th.printStackTrace();
                    }
                }
                O00000o(location.getBearing());
                if (this.O0000Oo0.equals(this.O00000oo.getPosition())) {
                    O0000Oo0();
                } else {
                    O000000o(this.O0000Oo0);
                }
            }
        }
    }

    public void O000000o(MyLocationStyle myLocationStyle) {
        try {
            this.O0000OOo = myLocationStyle;
            O000000o(this.O0000OOo.isMyLocationShowing());
            if (this.O0000OOo.isMyLocationShowing()) {
                O0000Oo();
                if (this.O00000oo != null || this.O0000O0o != null) {
                    this.O0000Ooo.O000000o(this.O00000oo);
                    O000000o(this.O0000OOo.getMyLocationType());
                    return;
                }
                return;
            }
            this.O0000Ooo.O000000o(false);
            this.O0000o00 = this.O0000OOo.getMyLocationType();
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "MyLocationOverlay", "setMyLocationStyle");
            th.printStackTrace();
        }
    }

    public void O000000o(boolean z) {
        if (!(this.O0000O0o == null || this.O0000O0o.isVisible() == z)) {
            this.O0000O0o.setVisible(z);
        }
        if (this.O00000oo != null && this.O00000oo.isVisible() != z) {
            this.O00000oo.setVisible(z);
        }
    }

    public void O00000Oo() throws RemoteException {
        O0000OoO();
        if (this.O0000Ooo != null) {
            O00000oo();
            this.O0000Ooo = null;
        }
    }

    public String O00000o() throws RemoteException {
        return this.O0000O0o != null ? this.O0000O0o.getId() : null;
    }

    public String O00000o0() {
        return this.O00000oo != null ? this.O00000oo.getId() : null;
    }

    public void O00000oO() {
        this.O0000O0o = null;
        this.O00000oo = null;
    }
}
