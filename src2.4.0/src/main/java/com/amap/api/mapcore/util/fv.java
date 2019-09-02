package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListView;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.GL3DModel;
import com.amap.api.maps.model.Marker;
import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.ae.gmap.listener.AMapWidgetListener;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapConfig;

/* compiled from: MapOverlayViewGroup */
public class fv extends ViewGroup implements O000o000 {
    Oo00 O000000o;
    O000o00 O00000Oo;
    private Context O00000o;
    private ca O00000o0;
    private fy O00000oO;
    private fu O00000oo;
    private fs O0000O0o;
    private fx O0000OOo;
    private ft O0000Oo;
    private fr O0000Oo0;
    private Oo0 O0000OoO;
    private View O0000Ooo;
    private boolean O0000o;
    private Drawable O0000o0 = null;
    private bi O0000o00;
    private boolean O0000o0O;
    private View O0000o0o;
    private boolean O0000oO0;

    /* compiled from: MapOverlayViewGroup */
    public static class O000000o extends LayoutParams {
        public FPoint O000000o = null;
        public int O00000Oo = 0;
        public int O00000o = 51;
        public int O00000o0 = 0;

        public O000000o(int i, int i2, FPoint fPoint, int i3, int i4, int i5) {
            super(i, i2);
            this.O000000o = fPoint;
            this.O00000Oo = i3;
            this.O00000o0 = i4;
            this.O00000o = i5;
        }
    }

    public fv(Context context, ca caVar) {
        super(context);
        int i = 1;
        this.O0000o0O = true;
        this.O0000oO0 = true;
        try {
            this.O00000o0 = caVar;
            this.O00000o = context;
            this.O000000o = new Oo00();
            this.O0000Oo0 = new fr(context);
            LayoutParams layoutParams = new LayoutParams(-1, -1);
            if (this.O00000o0.O0000o00() != null) {
                addView(this.O00000o0.O0000o00(), 0, layoutParams);
            } else {
                i = 0;
            }
            addView(this.O0000Oo0, i, layoutParams);
            if (!this.O0000oO0) {
                O000000o(context);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void O000000o(Context context) {
        this.O00000oO = new fy(context, this.O00000o0);
        this.O0000OOo = new fx(context, this.O00000o0);
        this.O0000Oo = new ft(context);
        this.O0000OoO = new Oo0(context, this.O00000o0);
        this.O00000oo = new fu(context, this.O00000o0);
        this.O0000O0o = new fs(context, this.O00000o0);
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        addView(this.O00000oO, layoutParams);
        addView(this.O0000OOo, layoutParams);
        addView(this.O0000Oo, new LayoutParams(-2, -2));
        addView(this.O0000OoO, new O000000o(-2, -2, new FPoint(0.0f, 0.0f), 0, 0, 83));
        addView(this.O00000oo, new O000000o(-2, -2, FPoint.obtain(0.0f, 0.0f), 0, 0, 83));
        addView(this.O0000O0o, new O000000o(-2, -2, FPoint.obtain(0.0f, 0.0f), 0, 0, 51));
        this.O0000O0o.setVisibility(8);
        this.O00000o0.O000000o(new AMapWidgetListener() {
            public void invalidateCompassView() {
                if (fv.this.O0000O0o != null) {
                    fv.this.O0000O0o.post(new Runnable() {
                        public void run() {
                            fv.this.O0000O0o.O00000Oo();
                        }
                    });
                }
            }

            public void invalidateScaleView() {
                if (fv.this.O0000OOo != null) {
                    fv.this.O0000OOo.post(new Runnable() {
                        public void run() {
                            fv.this.O0000OOo.O00000Oo();
                        }
                    });
                }
            }

            public void invalidateZoomController(final float f) {
                if (fv.this.O0000OoO != null) {
                    fv.this.O0000OoO.post(new Runnable() {
                        public void run() {
                            fv.this.O0000OoO.O000000o(f);
                        }
                    });
                }
            }

            public void setFrontViewVisibility(boolean z) {
            }
        });
        try {
            if (!this.O00000o0.O0000OOo().isMyLocationButtonEnabled()) {
                this.O00000oo.setVisibility(8);
            }
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "AMapDelegateImpGLSurfaceView", "locationView gone");
            th.printStackTrace();
        }
    }

    private void O000000o(View view, int i, int i2) throws RemoteException {
        if (view != null) {
            int i3;
            int i4;
            if (this.O0000Ooo != null) {
                if (view != this.O0000Ooo) {
                    this.O0000Ooo.clearFocus();
                    removeView(this.O0000Ooo);
                } else {
                    return;
                }
            }
            this.O0000Ooo = view;
            LayoutParams layoutParams = this.O0000Ooo.getLayoutParams();
            this.O0000Ooo.setDrawingCacheEnabled(true);
            this.O0000Ooo.setDrawingCacheQuality(0);
            this.O0000o00.O0000Ooo();
            if (layoutParams != null) {
                int i5 = layoutParams.width;
                i3 = layoutParams.height;
                i4 = i5;
            } else {
                i4 = -2;
                i3 = i4;
            }
            addView(this.O0000Ooo, new O000000o(i4, i3, this.O0000o00.O00000Oo(), i, i2, 81));
        }
    }

    private void O000000o(View view, int i, int i2, int i3, int i4, int i5) {
        int i6 = i5 & 7;
        i5 &= 112;
        if (i6 == 5) {
            i3 -= i;
        } else if (i6 == 1) {
            i3 -= i / 2;
        }
        if (i5 == 80) {
            i4 -= i2;
        } else if (i5 == 17) {
            i4 -= i2 / 2;
        } else if (i5 == 16) {
            i4 = (i4 / 2) - (i2 / 2);
        }
        view.layout(i3, i4, i3 + i, i4 + i2);
        if (view instanceof cb) {
            this.O00000o0.O00000Oo(i, i2);
        }
    }

    private void O000000o(View view, int i, int i2, int[] iArr) {
        if (view instanceof ListView) {
            View view2 = (View) view.getParent();
            if (view2 != null) {
                iArr[0] = view2.getWidth();
                iArr[1] = view2.getHeight();
            }
        }
        if (i <= 0 || i2 <= 0) {
            view.measure(0, 0);
        }
        if (i == -2) {
            iArr[0] = view.getMeasuredWidth();
        } else if (i == -1) {
            iArr[0] = getMeasuredWidth();
        } else {
            iArr[0] = i;
        }
        if (i2 == -2) {
            iArr[1] = view.getMeasuredHeight();
        } else if (i2 == -1) {
            iArr[1] = getMeasuredHeight();
        } else {
            iArr[1] = i2;
        }
    }

    private void O000000o(View view, LayoutParams layoutParams) {
        int[] iArr = new int[2];
        O000000o(view, layoutParams.width, layoutParams.height, iArr);
        if (view instanceof ft) {
            O000000o(view, iArr[0], iArr[1], 20, (this.O00000o0.O0000Ooo().y - 80) - iArr[1], 51);
            return;
        }
        O000000o(view, iArr[0], iArr[1], 0, 0, 51);
    }

    private void O000000o(View view, O000000o o000000o) {
        int[] iArr = new int[2];
        O000000o(view, o000000o.width, o000000o.height, iArr);
        if (view instanceof Oo0) {
            O000000o(view, iArr[0], iArr[1], getWidth() - iArr[0], getHeight(), o000000o.O00000o);
        } else if (view instanceof fu) {
            O000000o(view, iArr[0], iArr[1], getWidth() - iArr[0], iArr[1], o000000o.O00000o);
        } else if (view instanceof fs) {
            O000000o(view, iArr[0], iArr[1], 0, 0, o000000o.O00000o);
        } else if (o000000o.O000000o != null) {
            IPoint obtain = IPoint.obtain();
            MapConfig mapConfig = this.O00000o0.getMapConfig();
            GLMapState O00000o0 = this.O00000o0.O00000o0();
            if (!(mapConfig == null || O00000o0 == null)) {
                FPoint obtain2 = FPoint.obtain();
                O00000o0.p20ToScreenPoint(mapConfig.getSX() + ((int) o000000o.O000000o.x), mapConfig.getSY() + ((int) o000000o.O000000o.y), obtain2);
                obtain.x = (int) obtain2.x;
                obtain.y = (int) obtain2.y;
                obtain2.recycle();
            }
            obtain.x += o000000o.O00000Oo;
            obtain.y += o000000o.O00000o0;
            O000000o(view, iArr[0], iArr[1], obtain.x, obtain.y, o000000o.O00000o);
            obtain.recycle();
        }
    }

    private View O00000Oo(bi biVar) throws RemoteException {
        View O000000o;
        Throwable th;
        View view = null;
        BasePointOverlay marker;
        if (biVar instanceof Oo0OOo) {
            marker = new Marker((Oo0OOo) biVar);
            try {
                if (this.O0000o0 == null) {
                    this.O0000o0 = OOO.O000000o(this.O00000o, "infowindow_bg.9.png");
                }
            } catch (Throwable th2) {
                ooOOOOoo.O00000o0(th2, "MapOverlayViewGroup", "showInfoWindow decodeDrawableFromAsset");
                th2.printStackTrace();
            }
            try {
                if (this.O0000o) {
                    O000000o = this.O00000Oo.O000000o(marker);
                    if (O000000o == null) {
                        try {
                            O000000o = this.O00000Oo.O00000Oo(marker);
                        } catch (Throwable th3) {
                            th = th3;
                            view = O000000o;
                            ooOOOOoo.O00000o0(th, "MapOverlayViewGroup", "getInfoWindow or getInfoContents");
                            th.printStackTrace();
                            return view;
                        }
                    }
                    this.O0000o0o = O000000o;
                    this.O0000o = false;
                } else {
                    O000000o = this.O0000o0o;
                }
                if (O000000o != null) {
                    view = O000000o;
                } else if (!this.O00000Oo.O000000o()) {
                    return null;
                } else {
                    view = this.O00000Oo.O000000o(marker);
                }
                if (view != null) {
                    if (view.getBackground() == null) {
                        view.setBackground(this.O0000o0);
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                ooOOOOoo.O00000o0(th, "MapOverlayViewGroup", "getInfoWindow or getInfoContents");
                th.printStackTrace();
                return view;
            }
        }
        try {
            if (this.O0000o0 == null) {
                this.O0000o0 = OOO.O000000o(this.O00000o, "infowindow_bg.9.png");
            }
        } catch (Throwable th5) {
            ooOOOOoo.O00000o0(th5, "MapOverlayViewGroup", "showInfoWindow decodeDrawableFromAsset");
            th5.printStackTrace();
        }
        try {
            marker = new GL3DModel((O0OOO0O) biVar);
            if (this.O0000o) {
                O000000o = this.O00000Oo.O000000o(marker);
                if (O000000o == null) {
                    try {
                        O000000o = this.O00000Oo.O00000Oo(marker);
                    } catch (Throwable th6) {
                        th5 = th6;
                        view = O000000o;
                        ooOOOOoo.O00000o0(th5, "MapOverlayViewGroup", "getInfoWindow or getInfoContents");
                        th5.printStackTrace();
                        return view;
                    }
                }
                this.O0000o0o = O000000o;
                this.O0000o = false;
            } else {
                O000000o = this.O0000o0o;
            }
            if (O000000o != null) {
                view = O000000o;
            } else if (!this.O00000Oo.O000000o()) {
                return null;
            } else {
                view = this.O00000Oo.O000000o(marker);
            }
            if (view.getBackground() == null) {
                view.setBackground(this.O0000o0);
            }
            return view;
        } catch (Throwable th7) {
            th5 = th7;
            ooOOOOoo.O00000o0(th5, "MapOverlayViewGroup", "getInfoWindow or getInfoContents");
            th5.printStackTrace();
            return view;
        }
        return view;
    }

    private void O0000o0O() {
        if (this.O0000OOo == null) {
            this.O000000o.O000000o(this, new Object[0]);
            return;
        }
        if (this.O0000OOo != null && this.O0000OOo.getVisibility() == 0) {
            this.O0000OOo.postInvalidate();
        }
    }

    public float O000000o(int i) {
        if (this.O00000oO == null) {
            return 0.0f;
        }
        O0000o0O();
        return this.O00000oO.O00000o(i);
    }

    public void O000000o(Canvas canvas) {
        if (this.O0000Ooo != null && this.O0000o00 != null) {
            Bitmap drawingCache = this.O0000Ooo.getDrawingCache(true);
            if (drawingCache != null) {
                canvas.drawBitmap(drawingCache, (float) this.O0000Ooo.getLeft(), (float) this.O0000Ooo.getTop(), new Paint());
            }
        }
    }

    public void O000000o(O000o00 o000o00) {
        this.O00000Oo = o000o00;
    }

    public void O000000o(bi biVar) {
        if (biVar != null) {
            try {
                if (!(this.O00000Oo != null && this.O00000Oo.O000000o() && biVar.getTitle() == null && biVar.getSnippet() == null) && biVar.isInfoWindowEnable()) {
                    if (!(this.O0000o00 == null || this.O0000o00.getId().equals(biVar.getId()))) {
                        a_();
                    }
                    if (this.O00000Oo != null) {
                        this.O0000o00 = biVar;
                        biVar.O000000o(true);
                        this.O0000o = true;
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void O000000o(com.amap.api.mapcore.util.ft.O000000o o000000o) {
        if (this.O0000Oo == null) {
            this.O000000o.O000000o(this, o000000o);
            return;
        }
        this.O0000Oo.O000000o(o000000o);
        Log.d("MapOverlayViewGroup", "setOnIndoorFloorSwitchListener");
    }

    public void O000000o(CameraPosition cameraPosition) {
        if (this.O00000oO == null) {
            this.O000000o.O000000o(this, cameraPosition);
        } else if (this.O00000o0.O0000OOo().isLogoEnable()) {
            if (MapsInitializer.isLoadWorldGridMap() && cameraPosition.zoom >= 7.0f && !OOOO0O.O000000o(cameraPosition.target.latitude, cameraPosition.target.longitude)) {
                this.O00000oO.setVisibility(8);
            } else if (this.O00000o0.O0000o0O() == -1) {
                this.O00000oO.setVisibility(0);
            }
        }
    }

    public void O000000o(Boolean bool) {
        if (this.O0000Oo == null) {
            this.O000000o.O000000o(this, bool);
            return;
        }
        if (this.O0000Oo != null && bool.booleanValue() && this.O00000o0.O0000o0()) {
            this.O0000Oo.O000000o(true);
        }
    }

    public void O000000o(Float f) {
        if (this.O0000OoO == null) {
            this.O000000o.O000000o(this, f);
            return;
        }
        if (this.O0000OoO != null) {
            this.O0000OoO.O000000o(f.floatValue());
        }
    }

    public void O000000o(Integer num) {
        if (this.O0000OoO == null) {
            this.O000000o.O000000o(this, num);
            return;
        }
        if (this.O0000OoO != null) {
            this.O0000OoO.O000000o(num.intValue());
        }
    }

    public void O000000o(Integer num, Float f) {
        if (this.O00000oO != null) {
            this.O000000o.O000000o(this, num, f);
            return;
        }
        if (this.O00000oO != null) {
            this.O00000oO.O000000o(num.intValue(), f.floatValue());
            O0000o0O();
        }
    }

    public void O000000o(String str, Boolean bool, Integer num) {
        if (this.O00000oO == null) {
            this.O000000o.O000000o(this, str, bool, num);
        } else if (!TextUtils.isEmpty(str)) {
            this.O00000oO.O000000o(str, num.intValue());
            this.O00000oO.O00000Oo(bool.booleanValue());
        }
    }

    /* JADX WARNING: Missing block: B:9:0x003a, code skipped:
            return false;
     */
    public boolean O000000o(android.view.MotionEvent r7) {
        /*
        r6 = this;
        r0 = r6.O0000Ooo;
        r1 = 0;
        if (r0 == 0) goto L_0x003a;
    L_0x0005:
        r0 = r6.O0000o00;
        if (r0 != 0) goto L_0x000a;
    L_0x0009:
        goto L_0x003a;
    L_0x000a:
        r0 = new android.graphics.Rect;
        r2 = r6.O0000Ooo;
        r2 = r2.getLeft();
        r3 = r6.O0000Ooo;
        r3 = r3.getTop();
        r4 = r6.O0000Ooo;
        r4 = r4.getRight();
        r5 = r6.O0000Ooo;
        r5 = r5.getBottom();
        r0.<init>(r2, r3, r4, r5);
        r2 = r7.getX();
        r2 = (int) r2;
        r7 = r7.getY();
        r7 = (int) r7;
        r7 = com.amap.api.mapcore.util.OOo000.O000000o(r0, r2, r7);
        if (r7 == 0) goto L_0x0039;
    L_0x0037:
        r7 = 1;
        return r7;
    L_0x0039:
        return r1;
    L_0x003a:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.fv.O000000o(android.view.MotionEvent):boolean");
    }

    public void O00000Oo() {
        try {
            if (this.O0000o00 == null || !this.O0000o00.O0000OoO()) {
                if (this.O0000Ooo != null && this.O0000Ooo.getVisibility() == 0) {
                    this.O0000Ooo.setVisibility(8);
                }
            } else if (this.O0000o0O) {
                int O0000OOo = this.O0000o00.O0000OOo() + this.O0000o00.O00000oo();
                int O0000Oo0 = (this.O0000o00.O0000Oo0() + this.O0000o00.O0000O0o()) + 2;
                View O00000Oo = O00000Oo(this.O0000o00);
                if (O00000Oo != null) {
                    O000000o(O00000Oo, O0000OOo, O0000Oo0);
                    if (this.O0000Ooo != null) {
                        O000000o o000000o = (O000000o) this.O0000Ooo.getLayoutParams();
                        if (o000000o != null) {
                            o000000o.O000000o = this.O0000o00.O00000Oo();
                            o000000o.O00000Oo = O0000OOo;
                            o000000o.O00000o0 = O0000Oo0;
                        }
                        onLayout(false, 0, 0, 0, 0);
                        if (this.O00000Oo.O000000o()) {
                            this.O00000Oo.O000000o(this.O0000o00.getTitle(), this.O0000o00.getSnippet());
                        }
                        if (this.O0000Ooo.getVisibility() == 8) {
                            this.O0000Ooo.setVisibility(0);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "MapOverlayViewGroup", "redrawInfoWindow");
            th.printStackTrace();
        }
    }

    public void O00000Oo(Boolean bool) {
        if (this.O0000OoO == null) {
            this.O000000o.O000000o(this, bool);
            return;
        }
        this.O0000OoO.O000000o(bool.booleanValue());
    }

    public void O00000Oo(Integer num) {
        if (this.O00000oO == null) {
            this.O000000o.O000000o(this, num);
            return;
        }
        if (this.O00000oO != null) {
            this.O00000oO.O000000o(num.intValue());
            this.O00000oO.postInvalidate();
            O0000o0O();
        }
    }

    public void O00000o(Boolean bool) {
        if (this.O0000O0o == null) {
            this.O000000o.O000000o(this, bool);
            return;
        }
        this.O0000O0o.O000000o(bool.booleanValue());
    }

    public void O00000o(Integer num) {
        if (this.O00000oO == null) {
            this.O000000o.O000000o(this, num);
            return;
        }
        if (this.O00000oO != null) {
            this.O00000oO.O00000o0(num.intValue());
            O0000o0O();
        }
    }

    public boolean O00000o() {
        return this.O00000oO != null ? this.O00000oO.O00000oO() : false;
    }

    public Point O00000o0() {
        return this.O00000oO == null ? null : this.O00000oO.O00000o0();
    }

    public void O00000o0(Boolean bool) {
        if (this.O00000oo == null) {
            this.O000000o.O000000o(this, bool);
            return;
        }
        if (bool.booleanValue()) {
            this.O00000oo.setVisibility(0);
        } else {
            this.O00000oo.setVisibility(8);
        }
    }

    public void O00000o0(Integer num) {
        if (this.O00000oO == null) {
            this.O000000o.O000000o(this, num);
            return;
        }
        if (this.O00000oO != null) {
            this.O00000oO.O00000Oo(num.intValue());
            O0000o0O();
        }
    }

    public void O00000oO() {
        if (this.O00000oO == null) {
            this.O000000o.O000000o(this, new Object[0]);
            return;
        }
        if (this.O00000oO != null) {
            this.O00000oO.O00000o();
        }
    }

    public void O00000oO(Boolean bool) {
        if (this.O0000OOo == null) {
            this.O000000o.O000000o(this, bool);
            return;
        }
        this.O0000OOo.O000000o(bool.booleanValue());
    }

    public fr O00000oo() {
        return this.O0000Oo0;
    }

    public void O00000oo(Boolean bool) {
        int i = 0;
        if (this.O00000oO == null) {
            this.O000000o.O000000o(this, bool);
            return;
        }
        fy fyVar = this.O00000oO;
        if (!bool.booleanValue()) {
            i = 8;
        }
        fyVar.setVisibility(i);
    }

    public ft O0000O0o() {
        return this.O0000Oo;
    }

    public void O0000O0o(Boolean bool) {
        if (this.O00000oO == null) {
            this.O000000o.O000000o(this, bool);
            return;
        }
        if (this.O00000oO != null && bool.booleanValue()) {
            this.O00000oO.O000000o(true);
        } else if (this.O00000oO != null) {
            this.O00000oO.O000000o(false);
        }
    }

    public fu O0000OOo() {
        return this.O00000oo;
    }

    public void O0000OOo(Boolean bool) {
        if (this.O00000oo == null) {
            this.O000000o.O000000o(this, bool);
            return;
        }
        this.O00000oo.O000000o(bool.booleanValue());
    }

    public void O0000Oo() {
        if (this.O0000OoO != null) {
            this.O0000OoO.O000000o();
        }
        if (this.O0000OOo != null) {
            this.O0000OOo.O000000o();
        }
        if (this.O00000oO != null) {
            this.O00000oO.O000000o();
        }
        if (this.O00000oo != null) {
            this.O00000oo.O000000o();
        }
        if (this.O0000O0o != null) {
            this.O0000O0o.O000000o();
        }
        if (this.O0000Oo != null) {
            this.O0000Oo.O00000Oo();
        }
    }

    public void O0000Oo(Boolean bool) {
        if (this.O00000oO == null) {
            this.O000000o.O000000o(this, bool);
            return;
        }
        boolean booleanValue = bool.booleanValue();
        this.O00000oO.setVisibility(4);
    }

    public fy O0000Oo0() {
        return this.O00000oO;
    }

    public void O0000Oo0(Boolean bool) {
        if (this.O0000Oo == null) {
            this.O000000o.O000000o(this, bool);
            return;
        }
        this.O0000Oo.O000000o(bool.booleanValue());
    }

    public void O0000OoO() {
        a_();
        OOo000.O000000o(this.O0000o0);
        O0000Oo();
        removeAllViews();
        this.O0000o0o = null;
    }

    public void O0000Ooo() {
    }

    public void O0000o0() {
        if (this.O0000oO0 && this.O00000o != null) {
            O000000o(this.O00000o);
            if (this.O000000o != null) {
                this.O000000o.O000000o();
            }
        }
    }

    public void O0000o00() {
        if (this.O0000O0o == null) {
            this.O000000o.O000000o(this, new Object[0]);
        } else {
            this.O0000O0o.O00000Oo();
        }
    }

    public void a_() {
        if (this.O00000o0 != null && this.O00000o0.getMainHandler() != null) {
            this.O00000o0.getMainHandler().post(new Runnable() {
                public void run() {
                    if (fv.this.O0000Ooo != null) {
                        fv.this.O0000Ooo.clearFocus();
                        fv.this.removeView(fv.this.O0000Ooo);
                        OOo000.O000000o(fv.this.O0000Ooo.getBackground());
                        OOo000.O000000o(fv.this.O0000o0);
                        fv.this.O0000Ooo = null;
                    }
                }
            });
            if (this.O0000o00 != null) {
                this.O0000o00.O000000o(false);
            }
            this.O0000o00 = null;
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        try {
            int childCount = getChildCount();
            for (i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt != null) {
                    if (childAt.getLayoutParams() instanceof O000000o) {
                        O000000o(childAt, (O000000o) childAt.getLayoutParams());
                    } else {
                        O000000o(childAt, childAt.getLayoutParams());
                    }
                }
            }
            if (this.O00000oO != null) {
                this.O00000oO.O00000o();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
