package com.amap.api.mapcore.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Point;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.RemoteException;
import android.util.Log;
import android.view.animation.AnimationUtils;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.animation.Animation;
import com.amap.api.maps.model.animation.Animation.AnimationListener;
import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.Rectangle;
import com.autonavi.amap.mapcore.animation.GLAnimation;
import com.autonavi.amap.mapcore.animation.GLAnimationSet;
import com.autonavi.amap.mapcore.animation.GLTransformation;
import com.autonavi.amap.mapcore.animation.GLTranslateAnimation;
import com.autonavi.amap.mapcore.interfaces.IAnimation;
import com.autonavi.amap.mapcore.interfaces.IMarkerAction;
import com.autonavi.amap.mapcore.interfaces.IOverlayImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: MarkerDelegateImp */
public class Oo0OOo extends bi implements O0Oo0, IAnimation, IMarkerAction {
    private static int O0000Oo0;
    float[] O000000o;
    float[] O00000Oo;
    GLTransformation O00000o = null;
    Rect O00000o0 = new Rect(0, 0, 0, 0);
    GLTransformation O00000oO = null;
    GLAnimation O00000oo;
    GLAnimation O0000O0o;
    Object O0000OOo = new Object();
    private boolean O0000Oo;
    private float O0000OoO;
    private boolean O0000Ooo = false;
    private boolean O0000o = false;
    private boolean O0000o0 = false;
    private boolean O0000o00 = false;
    private float O0000o0O = 0.0f;
    private float O0000o0o = 0.0f;
    private int O0000oO = 0;
    private int O0000oO0 = 0;
    private int O0000oOO = 0;
    private int O0000oOo = 0;
    private int O0000oo;
    private int O0000oo0;
    private FPoint O0000ooO = FPoint.obtain();
    private float[] O0000ooo = new float[]{-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private float O000O00o = 1.0f;
    private float O000O0OO = 1.0f;
    private MarkerOptions O000O0Oo;
    private int O000O0o = 5;
    private boolean O000O0o0 = true;
    private boolean O000O0oO = true;
    private boolean O000O0oo = true;
    private boolean O000OO = false;
    private boolean O000OO00 = false;
    private boolean O000OO0o = false;
    private boolean O000OOOo = true;
    private Point O000OOo = new Point();
    private FPoint O000OOo0 = FPoint.obtain();
    private float O000OOoO;
    private float O000OOoo;
    private int O000Oo0 = 0;
    private int O000Oo00 = 0;
    private O0000O0o O000Oo0O;
    private O0000O0o[] O000Oo0o = null;
    private LatLng O000OoO;
    private boolean O000OoO0 = false;
    private LatLng O000OoOO;
    private String O000OoOo;
    private float O000Ooo = 0.5f;
    private String O000Ooo0;
    private float O000OooO = 1.0f;
    private boolean O000Oooo = false;
    private int O000o;
    private List<BitmapDescriptor> O000o0 = new CopyOnWriteArrayList();
    private O00000Oo O000o00;
    private boolean O000o000 = true;
    private Object O000o00O;
    private boolean O000o00o = false;
    private boolean O000o0O = false;
    private boolean O000o0O0 = false;
    private boolean O000o0OO = true;
    private int O000o0Oo = 0;
    private boolean O000o0o = false;
    private int O000o0o0 = 20;
    private int O000o0oo;
    private float O000oO = Float.MAX_VALUE;
    private float O000oO0 = Float.MAX_VALUE;
    private long O000oO00 = 0;
    private float O000oO0O = Float.MIN_VALUE;
    private float O000oO0o = Float.MIN_VALUE;
    private String O00O0Oo;
    private boolean O00oOoOo = false;
    private float O00oOooO = 0.0f;
    private float O00oOooo = 1.0f;

    public Oo0OOo(MarkerOptions markerOptions, O00000Oo o00000Oo) {
        this.O000o00 = o00000Oo;
        setMarkerOptions(markerOptions);
    }

    private Bitmap O000000o(Bitmap bitmap) {
        return (bitmap == null || bitmap.getConfig() == Config.ARGB_8888) ? bitmap : bitmap.copy(Config.ARGB_8888, true);
    }

    private static String O000000o(String str) {
        O0000Oo0++;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(O0000Oo0);
        return stringBuilder.toString();
    }

    private void O000000o(double d, double d2) {
        if (this.O000o0o) {
            IPoint obtain = IPoint.obtain();
            this.O000o00.O00000o0().O000000o((int) d, (int) d2, obtain);
            O000000o(obtain.x, obtain.y);
            obtain.recycle();
            this.O000o0o = true;
            return;
        }
        O000000o((int) d, (int) d2);
    }

    private void O000000o(int i, int i2) {
        this.O0000oo0 = i;
        this.O0000oo = i2;
        DPoint obtain = DPoint.obtain();
        GLMapState.geo2LonLat(this.O0000oo0, this.O0000oo, obtain);
        this.O000OoO = new LatLng(obtain.y, obtain.x, false);
        if (!(this.O000o00 == null || this.O000o00.O00000o0() == null)) {
            this.O0000ooO.x = (float) (this.O0000oo0 - this.O000o00.O00000o0().getMapConfig().getSX());
            this.O0000ooO.y = (float) (this.O0000oo - this.O000o00.O00000o0().getMapConfig().getSY());
        }
        obtain.recycle();
        O0000oO0();
    }

    private void O000000o(ca caVar, float f, int i, int i2) throws RemoteException {
        float f2 = ((float) ((int) (this.O00oOooo * ((float) i)))) * f;
        float f3 = ((float) ((int) (this.O000O00o * ((float) i2)))) * f;
        f = this.O0000ooO.x;
        float f4 = this.O0000ooO.y;
        float sc = caVar.getMapConfig().getSC();
        float f5 = this.O0000o0O;
        if (this.O000o0 != null && this.O000o0.size() > 0) {
            if (this.O0000Oo) {
                int length = this.O000Oo0o.length;
                int i3 = (int) (this.O0000o0O / this.O0000OoO);
                if (i3 > length) {
                    i3 = 0;
                } else {
                    f5 = this.O0000o0O % this.O0000OoO;
                }
                this.O000Oo0O = this.O000Oo0o[(i3 + length) % length];
            } else {
                this.O000o0Oo++;
                if (this.O000o0Oo >= this.O000o0o0 * this.O000o0.size()) {
                    this.O000o0Oo = 0;
                }
                if (this.O000o0o0 == 0) {
                    this.O000o0o0 = 1;
                }
                this.O000Oo0O = this.O000Oo0o[this.O000o0Oo / this.O000o0o0];
                if (!this.O000o0OO) {
                    O0000oO0();
                }
            }
        }
        if (this.O0000o) {
            f5 -= caVar.getMapConfig().getSR();
            sc = 0.0f;
        }
        float f6 = this.O000O0OO;
        if (f6 < 0.0f) {
            f6 = 0.0f;
        }
        if (f6 > 1.0f) {
            f6 = 1.0f;
        }
        this.O0000ooo[0] = f - (this.O000Ooo * f2);
        this.O0000ooo[1] = ((1.0f - this.O000OooO) * f3) + f4;
        this.O0000ooo[2] = f;
        this.O0000ooo[3] = f4;
        this.O0000ooo[6] = f5;
        this.O0000ooo[7] = sc;
        this.O0000ooo[8] = f6;
        this.O0000ooo[9] = ((1.0f - this.O000Ooo) * f2) + f;
        this.O0000ooo[10] = ((1.0f - this.O000OooO) * f3) + f4;
        this.O0000ooo[11] = f;
        this.O0000ooo[12] = f4;
        this.O0000ooo[15] = f5;
        this.O0000ooo[16] = sc;
        this.O0000ooo[17] = f6;
        this.O0000ooo[18] = ((1.0f - this.O000Ooo) * f2) + f;
        this.O0000ooo[19] = f4 - (this.O000OooO * f3);
        this.O0000ooo[20] = f;
        this.O0000ooo[21] = f4;
        this.O0000ooo[24] = f5;
        this.O0000ooo[25] = sc;
        this.O0000ooo[26] = f6;
        this.O0000ooo[27] = f - (f2 * this.O000Ooo);
        this.O0000ooo[28] = f4 - (f3 * this.O000OooO);
        this.O0000ooo[29] = f;
        this.O0000ooo[30] = f4;
        this.O0000ooo[33] = f5;
        this.O0000ooo[34] = sc;
        this.O0000ooo[35] = f6;
    }

    private void O000000o(GLAnimation gLAnimation) {
        if (gLAnimation instanceof GLTranslateAnimation) {
            if (this.O000o0o) {
                this.O000OoO = getPosition();
                setPosition(this.O000OoO);
                this.O000o0o = true;
            }
            GLTranslateAnimation gLTranslateAnimation;
            IPoint obtain;
            if (this.O000o0o) {
                gLTranslateAnimation = (GLTranslateAnimation) gLAnimation;
                gLTranslateAnimation.mFromXDelta = (double) this.O000o0oo;
                gLTranslateAnimation.mFromYDelta = (double) this.O000o;
                obtain = IPoint.obtain();
                this.O000o00.O00000o0().O00000Oo(gLTranslateAnimation.mToYDelta, gLTranslateAnimation.mToXDelta, obtain);
                gLTranslateAnimation.mToXDelta = (double) obtain.x;
                gLTranslateAnimation.mToYDelta = (double) obtain.y;
                obtain.recycle();
                return;
            }
            gLTranslateAnimation = (GLTranslateAnimation) gLAnimation;
            gLTranslateAnimation.mFromXDelta = (double) this.O0000oo0;
            gLTranslateAnimation.mFromYDelta = (double) this.O0000oo;
            obtain = IPoint.obtain();
            GLMapState.lonlat2Geo(gLTranslateAnimation.mToXDelta, gLTranslateAnimation.mToYDelta, obtain);
            gLTranslateAnimation.mToXDelta = (double) obtain.x;
            gLTranslateAnimation.mToYDelta = (double) obtain.y;
            obtain.recycle();
        }
    }

    private void O000000o(float[] fArr, int i) {
        if (this.O000Oo0o != null && this.O000Oo0o.length > 0) {
            System.arraycopy(this.O0000ooo, 0, fArr, i, this.O0000ooo.length);
        }
    }

    private void O0000oO() {
        try {
            if (this.O000Oo0O.O000000o()) {
                this.O0000ooo[4] = this.O000Oo0O.O00000o();
                this.O0000ooo[5] = this.O000Oo0O.O00000o0();
                this.O0000ooo[13] = this.O000Oo0O.O00000Oo();
                this.O0000ooo[14] = this.O000Oo0O.O00000o0();
                this.O0000ooo[22] = this.O000Oo0O.O00000Oo();
                this.O0000ooo[23] = this.O000Oo0O.O00000oO();
                this.O0000ooo[31] = this.O000Oo0O.O00000o();
                this.O0000ooo[32] = this.O000Oo0O.O00000oO();
                return;
            }
            this.O0000ooo[4] = this.O000Oo0O.O0000O0o();
            this.O0000ooo[5] = this.O000Oo0O.O0000Oo0();
            this.O0000ooo[13] = this.O000Oo0O.O0000OOo();
            this.O0000ooo[14] = this.O000Oo0O.O0000Oo0();
            this.O0000ooo[22] = this.O000Oo0O.O0000OOo();
            this.O0000ooo[23] = this.O000Oo0O.O00000oo();
            this.O0000ooo[31] = this.O000Oo0O.O0000O0o();
            this.O0000ooo[32] = this.O000Oo0O.O00000oo();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void O0000oO0() {
        if (this.O000o00.O00000o0() != null) {
            this.O000o00.O00000o0().setRunLowFrame(false);
        }
    }

    private void O0000oOO() {
        if (this.O000OOOo || this.O00000oo == null || this.O00000oo.hasEnded()) {
            if (!(this.O00000oo == null || (this.O00000o == null && this.O00000oO == null))) {
                if (this.O00000o != null && !Double.isNaN(this.O00000o.scaleX) && !Double.isNaN(this.O00000o.scaleY)) {
                    this.O00oOooo = (float) this.O00000o.scaleX;
                    this.O000O00o = (float) this.O00000o.scaleY;
                } else if (!(this.O00000oO == null || Double.isNaN(this.O00000oO.scaleX) || Double.isNaN(this.O00000oO.scaleY) || (((double) this.O00oOooo) == this.O00000oO.scaleX && ((double) this.O000O00o) == this.O00000oO.scaleY))) {
                    this.O00oOooo = (float) this.O00000oO.scaleX;
                    this.O000O00o = (float) this.O00000oO.scaleY;
                }
                if (this.O00000o != null && !Double.isNaN(this.O00000o.rotate)) {
                    setRotateAngle((float) this.O00000o.rotate);
                } else if (!(this.O00000oO == null || Double.isNaN(this.O00000oO.rotate) || ((double) this.O0000o0O) == this.O00000oO.rotate)) {
                    setRotateAngle((float) this.O00000oO.rotate);
                }
                if (this.O00000o != null && !Double.isNaN(this.O00000o.x) && !Double.isNaN(this.O00000o.y)) {
                    O000000o(this.O00000o.x, this.O00000o.y);
                } else if (!(this.O00000oO == null || Double.isNaN(this.O00000oO.x) || Double.isNaN(this.O00000oO.y) || (((double) this.O0000oo0) == this.O00000oO.x && ((double) this.O0000oo) == this.O00000oO.y))) {
                    O000000o(this.O00000o.x, this.O00000o.y);
                }
                if (this.O00000o != null && !Double.isNaN(this.O00000o.alpha)) {
                    this.O000O0OO = (float) this.O00000o.alpha;
                } else if (!(this.O00000oO == null || Double.isNaN(this.O00000oO.alpha) || ((double) this.O000O0OO) == this.O00000oO.alpha)) {
                    this.O000O0OO = (float) this.O00000oO.alpha;
                }
            }
            this.O000OOOo = true;
            this.O00000o = null;
            this.O00000oO = null;
            if (this.O000o0 != null && this.O000o0.size() == 1) {
                this.O000o0OO = true;
                return;
            }
            return;
        }
        O0000oO0();
        synchronized (this.O0000OOo) {
            if (this.O00000oO == null) {
                this.O00000oO = new GLTransformation();
                this.O00000oO.scaleX = (double) this.O00oOooo;
                this.O00000oO.scaleY = (double) this.O000O00o;
                this.O00000oO.rotate = (double) this.O0000o0O;
                this.O00000oO.x = (double) this.O0000oo0;
                this.O00000oO.y = (double) this.O0000oo;
                this.O00000oO.alpha = (double) this.O000O0OO;
            }
            if (this.O00000o == null) {
                this.O00000o = new GLTransformation();
            }
            this.O00000o.clear();
            this.O00000oo.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.O00000o);
            if (this.O00000o != null) {
                if (!(Double.isNaN(this.O00000o.scaleX) || Double.isNaN(this.O00000o.scaleY))) {
                    this.O00oOooo = (float) this.O00000o.scaleX;
                    this.O000O00o = (float) this.O00000o.scaleY;
                }
                if (!Double.isNaN(this.O00000o.rotate)) {
                    setRotateAngle((float) this.O00000o.rotate);
                }
                if (!(Double.isNaN(this.O00000o.x) || Double.isNaN(this.O00000o.y))) {
                    O000000o(this.O00000o.x, this.O00000o.y);
                }
                if (!Double.isNaN(this.O00000o.alpha)) {
                    this.O000O0OO = (float) this.O00000o.alpha;
                }
            }
        }
        this.O0000o0 = true;
        this.O000o0OO = false;
    }

    private int O0000oOo() {
        int[] iArr = new int[]{0};
        GLES20.glGenTextures(1, iArr, 0);
        return iArr[0];
    }

    private void O0000oo0() {
        if (this.O000o00.O00000o0() != null && this.O000o00.O00000o0().getMapConfig() != null) {
            this.O000OOoO = this.O000o00.O00000o0().getMapConfig().getMapPerPixelUnitLength() * ((float) O0000o0());
            this.O000OOoo = this.O000o00.O00000o0().getMapConfig().getMapPerPixelUnitLength() * ((float) O0000o0O());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x005b A:{Catch:{ Throwable -> 0x00eb, all -> 0x00e9 }} */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00c8 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0062 A:{Catch:{ Throwable -> 0x00eb, all -> 0x00e9 }} */
    public void O000000o(com.amap.api.mapcore.util.ca r13) {
        /*
        r12 = this;
        r0 = r12.O000o0O;
        if (r0 != 0) goto L_0x00f7;
    L_0x0004:
        monitor-enter(r12);
        r0 = r12.O000Oo0o;	 Catch:{ Throwable -> 0x00eb }
        r1 = 0;
        if (r0 == 0) goto L_0x001c;
    L_0x000a:
        r0 = r12.O000Oo0o;	 Catch:{ Throwable -> 0x00eb }
        r2 = r0.length;	 Catch:{ Throwable -> 0x00eb }
        r3 = r1;
    L_0x000e:
        if (r3 >= r2) goto L_0x001c;
    L_0x0010:
        r4 = r0[r3];	 Catch:{ Throwable -> 0x00eb }
        if (r4 == 0) goto L_0x0019;
    L_0x0014:
        r5 = r12.O000o00;	 Catch:{ Throwable -> 0x00eb }
        r5.O000000o(r4);	 Catch:{ Throwable -> 0x00eb }
    L_0x0019:
        r3 = r3 + 1;
        goto L_0x000e;
    L_0x001c:
        r0 = 0;
        r12.O000Oo0o = r0;	 Catch:{ Throwable -> 0x00eb }
        r2 = r12.O000o0;	 Catch:{ Throwable -> 0x00eb }
        if (r2 == 0) goto L_0x00e4;
    L_0x0023:
        r2 = r12.O000o0;	 Catch:{ Throwable -> 0x00eb }
        r2 = r2.size();	 Catch:{ Throwable -> 0x00eb }
        r2 = new com.amap.api.mapcore.util.O0000O0o[r2];	 Catch:{ Throwable -> 0x00eb }
        r12.O000Oo0o = r2;	 Catch:{ Throwable -> 0x00eb }
        r2 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x00eb }
        r3 = 12;
        r4 = 1;
        if (r2 < r3) goto L_0x0036;
    L_0x0034:
        r2 = r4;
        goto L_0x0037;
    L_0x0036:
        r2 = r1;
    L_0x0037:
        r3 = r12.O000o0;	 Catch:{ Throwable -> 0x00eb }
        r3 = r3.iterator();	 Catch:{ Throwable -> 0x00eb }
        r5 = r1;
    L_0x003e:
        r6 = r3.hasNext();	 Catch:{ Throwable -> 0x00eb }
        if (r6 == 0) goto L_0x00d3;
    L_0x0044:
        r6 = r3.next();	 Catch:{ Throwable -> 0x00eb }
        r6 = (com.amap.api.maps.model.BitmapDescriptor) r6;	 Catch:{ Throwable -> 0x00eb }
        if (r2 == 0) goto L_0x0057;
    L_0x004c:
        r7 = r13.O000000o(r6);	 Catch:{ Throwable -> 0x00eb }
        if (r7 == 0) goto L_0x0058;
    L_0x0052:
        r8 = r7.O0000OoO();	 Catch:{ Throwable -> 0x00eb }
        goto L_0x0059;
    L_0x0057:
        r7 = r0;
    L_0x0058:
        r8 = r1;
    L_0x0059:
        if (r7 != 0) goto L_0x0060;
    L_0x005b:
        r7 = new com.amap.api.mapcore.util.O0000O0o;	 Catch:{ Throwable -> 0x00eb }
        r7.<init>(r6, r8);	 Catch:{ Throwable -> 0x00eb }
    L_0x0060:
        if (r8 != 0) goto L_0x00c8;
    L_0x0062:
        r6 = r6.getBitmap();	 Catch:{ Throwable -> 0x00eb }
        if (r6 == 0) goto L_0x00c8;
    L_0x0068:
        r8 = r6.isRecycled();	 Catch:{ Throwable -> 0x00eb }
        if (r8 != 0) goto L_0x00c8;
    L_0x006e:
        r8 = r6.getWidth();	 Catch:{ Throwable -> 0x00eb }
        r12.O000Oo00 = r8;	 Catch:{ Throwable -> 0x00eb }
        r8 = r6.getHeight();	 Catch:{ Throwable -> 0x00eb }
        r12.O000Oo0 = r8;	 Catch:{ Throwable -> 0x00eb }
        r8 = r12.O000o00;	 Catch:{ Throwable -> 0x00eb }
        r8 = r8.O00000o0();	 Catch:{ Throwable -> 0x00eb }
        r8 = r8.O00000oO();	 Catch:{ Throwable -> 0x00eb }
        if (r8 != 0) goto L_0x0096;
    L_0x0086:
        r8 = r12.O0000oOo();	 Catch:{ Throwable -> 0x00eb }
        r7.O000000o(r8);	 Catch:{ Throwable -> 0x00eb }
        if (r2 == 0) goto L_0x0092;
    L_0x008f:
        r13.O000000o(r7);	 Catch:{ Throwable -> 0x00eb }
    L_0x0092:
        com.amap.api.mapcore.util.OOo000.O00000Oo(r8, r6, r1);	 Catch:{ Throwable -> 0x00eb }
        goto L_0x00c8;
    L_0x0096:
        r9 = r12.O000o00;	 Catch:{ Throwable -> 0x00eb }
        r9 = r9.O000000o(r6, r7);	 Catch:{ Throwable -> 0x00eb }
        if (r9 == 0) goto L_0x00b9;
    L_0x009e:
        r6 = r12.O000000o(r6);	 Catch:{ Throwable -> 0x00eb }
        r9 = r7.O0000O0o();	 Catch:{ Throwable -> 0x00eb }
        r10 = 1140850688; // 0x44000000 float:512.0 double:5.63655132E-315;
        r9 = r9 * r10;
        r9 = (int) r9;	 Catch:{ Throwable -> 0x00eb }
        r10 = r7.O00000oo();	 Catch:{ Throwable -> 0x00eb }
        r11 = 1149239296; // 0x44800000 float:1024.0 double:5.67799655E-315;
        r10 = r10 * r11;
        r10 = (int) r10;	 Catch:{ Throwable -> 0x00eb }
        com.amap.api.mapcore.util.OOo000.O000000o(r8, r6, r9, r10);	 Catch:{ Throwable -> 0x00eb }
        r7.O000000o(r8);	 Catch:{ Throwable -> 0x00eb }
        goto L_0x00c3;
    L_0x00b9:
        r8 = r12.O0000oOo();	 Catch:{ Throwable -> 0x00eb }
        com.amap.api.mapcore.util.OOo000.O00000Oo(r8, r6, r1);	 Catch:{ Throwable -> 0x00eb }
        r7.O000000o(r8);	 Catch:{ Throwable -> 0x00eb }
    L_0x00c3:
        if (r2 == 0) goto L_0x00c8;
    L_0x00c5:
        r13.O000000o(r7);	 Catch:{ Throwable -> 0x00eb }
    L_0x00c8:
        r7.O0000Ooo();	 Catch:{ Throwable -> 0x00eb }
        r6 = r12.O000Oo0o;	 Catch:{ Throwable -> 0x00eb }
        r6[r5] = r7;	 Catch:{ Throwable -> 0x00eb }
        r5 = r5 + 1;
        goto L_0x003e;
    L_0x00d3:
        r13 = r12.O000o0;	 Catch:{ Throwable -> 0x00eb }
        r13 = r13.size();	 Catch:{ Throwable -> 0x00eb }
        if (r13 != r4) goto L_0x00de;
    L_0x00db:
        r12.O000o0OO = r4;	 Catch:{ Throwable -> 0x00eb }
        goto L_0x00e0;
    L_0x00de:
        r12.O000o0OO = r1;	 Catch:{ Throwable -> 0x00eb }
    L_0x00e0:
        r12.O000OO00 = r1;	 Catch:{ Throwable -> 0x00eb }
        r12.O000o0O = r4;	 Catch:{ Throwable -> 0x00eb }
    L_0x00e4:
        r12.O0000o0o();	 Catch:{ all -> 0x00e9 }
        monitor-exit(r12);	 Catch:{ all -> 0x00e9 }
        goto L_0x00f7;
    L_0x00e9:
        r13 = move-exception;
        goto L_0x00f5;
    L_0x00eb:
        r13 = move-exception;
        r0 = "MarkerDelegateImp";
        r1 = "loadtexture";
        com.amap.api.mapcore.util.ooOOOOoo.O00000o0(r13, r0, r1);	 Catch:{ all -> 0x00e9 }
        monitor-exit(r12);	 Catch:{ all -> 0x00e9 }
        return;
    L_0x00f5:
        monitor-exit(r12);	 Catch:{ all -> 0x00e9 }
        throw r13;
    L_0x00f7:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.Oo0OOo.O000000o(com.amap.api.mapcore.util.ca):void");
    }

    public void O000000o(ca caVar, float[] fArr, int i, float f) {
        boolean z = this.O000OoO0 || ((this.O000OoO == null && !this.O000o0o) || this.O000o0 == null);
        if (!z) {
            try {
                if (!this.O0000Ooo) {
                    this.O000oO00 = System.currentTimeMillis();
                    this.O0000Ooo = true;
                }
                if (this.O000o0o && this.O000O0oo) {
                    IPoint obtain = IPoint.obtain();
                    caVar.O000000o(this.O000o0oo, this.O000o, obtain);
                    this.O0000oo0 = obtain.x;
                    this.O0000oo = obtain.y;
                    obtain.recycle();
                }
                this.O0000ooO.x = (float) (this.O0000oo0 - caVar.getMapConfig().getSX());
                FPoint fPoint;
                if (this.O0000ooO.x > 1.34217728E8f) {
                    fPoint = this.O0000ooO;
                    fPoint.x -= 2.68435456E8f;
                } else if (this.O0000ooO.x < -1.34217728E8f) {
                    fPoint = this.O0000ooO;
                    fPoint.x += 2.68435456E8f;
                }
                this.O0000ooO.y = (float) (this.O0000oo - caVar.getMapConfig().getSY());
                int O0000o0 = O0000o0();
                int O0000o0O = O0000o0O();
                O0000oOO();
                O000000o(caVar, f, O0000o0, O0000o0O);
                if (!(this.O000OO00 && this.O000o0OO)) {
                    O0000oO();
                    this.O000OO00 = true;
                }
                O000000o(fArr, i);
                if (this.O0000o0 && isInfoWindowShown()) {
                    this.O000o00.O00000o0().O0000Oo();
                    if (System.currentTimeMillis() - this.O000oO00 > ((long) 1000)) {
                        this.O0000o0 = false;
                    }
                }
            } catch (Throwable th) {
                ooOOOOoo.O00000o0(th, "MarkerDelegateImp", "drawMarker");
            }
        }
    }

    public synchronized void O000000o(ArrayList<BitmapDescriptor> arrayList) {
        O0000o00();
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                BitmapDescriptor bitmapDescriptor = (BitmapDescriptor) it.next();
                if (bitmapDescriptor != null) {
                    this.O000o0.add(bitmapDescriptor);
                }
            }
        }
        if (this.O000o0.size() > 0) {
            this.O000Oo00 = ((BitmapDescriptor) this.O000o0.get(0)).getWidth();
            this.O000Oo0 = ((BitmapDescriptor) this.O000o0.get(0)).getHeight();
        } else {
            this.O000o0.add(BitmapDescriptorFactory.defaultMarker());
            this.O000Oo00 = ((BitmapDescriptor) this.O000o0.get(0)).getWidth();
            this.O000Oo0 = ((BitmapDescriptor) this.O000o0.get(0)).getHeight();
        }
    }

    public void O000000o(boolean z) {
        this.O0000o00 = z;
        this.O0000o0 = true;
    }

    public boolean O000000o() {
        return this.O000o0OO;
    }

    public FPoint O00000Oo() {
        return this.O0000ooO;
    }

    public void O00000Oo(boolean z) {
        this.O000OO = z;
    }

    public int O00000o() {
        try {
            if (this.O000o0 != null) {
                if (this.O000o0.size() > 0) {
                    return this.O000Oo0O.O0000OoO();
                }
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public LatLng O00000o0() {
        try {
            if (this.O000o0o) {
                DPoint obtain = DPoint.obtain();
                this.O000o00.O00000o0().O00000Oo(this.O000o0oo, this.O000o, obtain);
                LatLng latLng = new LatLng(obtain.y, obtain.y);
                obtain.recycle();
                return latLng;
            }
            return this.O000o0O0 ? this.O000OoOO : this.O000OoO;
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "MarkerDelegateImp", "getRealPosition");
            return null;
        }
    }

    public boolean O00000oO() {
        return this.O000OO;
    }

    public int O00000oo() {
        return this.O0000oO0;
    }

    public int O0000O0o() {
        return this.O0000oO;
    }

    public int O0000OOo() {
        return this.O0000oOO;
    }

    public boolean O0000Oo() {
        return this.O000o0o;
    }

    public int O0000Oo0() {
        return this.O0000oOo;
    }

    public boolean O0000OoO() {
        if (this.O000o0o) {
            return true;
        }
        try {
            if (this.O0000ooO != null) {
                if (!this.O000OOOo) {
                    return true;
                }
                this.O000OOo.x = this.O0000oo0;
                this.O000OOo.y = this.O0000oo;
                Rectangle geoRectangle = this.O000o00.O00000o0().getMapConfig().getGeoRectangle();
                if (geoRectangle.contains(this.O0000oo0, this.O0000oo)) {
                    return true;
                }
                O0000oo0();
                int i = (int) (this.O00oOooo * this.O000OOoO);
                int i2 = (int) (this.O000O00o * this.O000OOoo);
                int i3 = (int) (((float) this.O0000oo0) - (((float) i) * this.O000Ooo));
                int i4 = (int) (((float) this.O0000oo) - (((float) i2) * this.O000OooO));
                if (geoRectangle.contains(i3, i4) || geoRectangle.isOverlap(i3, i4, i, i2)) {
                    return true;
                }
            }
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "MarkerDelegateImp", "checkInBounds");
        }
        return false;
    }

    public Rect O0000Ooo() {
        if (this.O0000ooo == null) {
            this.O00000o0.set(0, 0, 0, 0);
            return this.O00000o0;
        }
        try {
            GLMapState O00000o0 = this.O000o00.O00000o0().O00000o0();
            if (O00000o0 == null) {
                return new Rect(0, 0, 0, 0);
            }
            int O0000o0 = O0000o0();
            int O0000o0O = O0000o0O();
            FPoint obtain = FPoint.obtain();
            if (this.O000o0o) {
                obtain.x = (float) this.O000o0oo;
                obtain.y = (float) this.O000o;
            } else {
                O00000o0.p20ToScreenPoint(this.O0000oo0, this.O0000oo, obtain);
            }
            Matrix.setIdentityM(this.O000000o, 0);
            Matrix.rotateM(this.O000000o, 0, -this.O0000o0O, 0.0f, 0.0f, 1.0f);
            if (this.O0000o) {
                Matrix.rotateM(this.O000000o, 0, this.O000o00.O00000o0().getMapConfig().getSC(), 1.0f, 0.0f, 0.0f);
                Matrix.rotateM(this.O000000o, 0, this.O000o00.O00000o0().getMapConfig().getSR(), 0.0f, 0.0f, 1.0f);
            }
            r2 = new float[4];
            float f = (float) (-O0000o0);
            this.O00000Oo[0] = this.O000Ooo * f;
            float f2 = (float) O0000o0O;
            this.O00000Oo[1] = this.O000OooO * f2;
            this.O00000Oo[2] = 0.0f;
            this.O00000Oo[3] = 1.0f;
            Matrix.multiplyMV(r2, 0, this.O000000o, 0, this.O00000Oo, 0);
            this.O00000o0.set((int) (obtain.x + r2[0]), (int) (obtain.y - r2[1]), (int) (obtain.x + r2[0]), (int) (obtain.y - r2[1]));
            float f3 = (float) O0000o0;
            this.O00000Oo[0] = (1.0f - this.O000Ooo) * f3;
            this.O00000Oo[1] = f2 * this.O000OooO;
            this.O00000Oo[2] = 0.0f;
            this.O00000Oo[3] = 1.0f;
            Matrix.multiplyMV(r2, 0, this.O000000o, 0, this.O00000Oo, 0);
            this.O00000o0.union((int) (obtain.x + r2[0]), (int) (obtain.y - r2[1]));
            this.O00000Oo[0] = f3 * (1.0f - this.O000Ooo);
            float f4 = (float) (-O0000o0O);
            this.O00000Oo[1] = (1.0f - this.O000OooO) * f4;
            this.O00000Oo[2] = 0.0f;
            this.O00000Oo[3] = 1.0f;
            Matrix.multiplyMV(r2, 0, this.O000000o, 0, this.O00000Oo, 0);
            this.O00000o0.union((int) (obtain.x + r2[0]), (int) (obtain.y - r2[1]));
            this.O00000Oo[0] = f * this.O000Ooo;
            this.O00000Oo[1] = f4 * (1.0f - this.O000OooO);
            this.O00000Oo[2] = 0.0f;
            this.O00000Oo[3] = 1.0f;
            Matrix.multiplyMV(r2, 0, this.O000000o, 0, this.O00000Oo, 0);
            this.O00000o0.union((int) (obtain.x + r2[0]), (int) (obtain.y - r2[1]));
            this.O0000oOO = (int) (((float) this.O00000o0.centerX()) - obtain.x);
            this.O0000oOo = (int) (((float) this.O00000o0.top) - obtain.y);
            obtain.recycle();
            return this.O00000o0;
        } catch (Throwable th) {
            Throwable th2 = th;
            ooOOOOoo.O00000o0(th2, "MarkerDelegateImp", "getRect");
            th2.printStackTrace();
            return new Rect(0, 0, 0, 0);
        }
    }

    public IAnimation O0000o() {
        return this;
    }

    public int O0000o0() {
        try {
            return this.O000Oo00;
        } catch (Throwable unused) {
            return 0;
        }
    }

    /* Access modifiers changed, original: declared_synchronized */
    public synchronized void O0000o00() {
        if (this.O000o0 != null) {
            this.O000o0.clear();
        }
    }

    public int O0000o0O() {
        try {
            return this.O000Oo0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public boolean O0000o0o() {
        try {
            if (!(this.O000o00 == null || this.O000o00.O00000o0() == null)) {
                if (this.O000o00.O00000o0().O00000o0() != null) {
                    if (this.O0000ooO == null) {
                        this.O0000ooO = FPoint.obtain();
                    }
                    if (this.O000o0o) {
                        IPoint obtain = IPoint.obtain();
                        this.O000o00.O00000o0().O000000o(this.O000o0oo, this.O000o, obtain);
                        this.O0000oo0 = obtain.x;
                        this.O0000oo = obtain.y;
                        obtain.recycle();
                        this.O000o00.O00000o0().O000000o(this.O0000oo0, this.O0000oo, this.O0000ooO);
                    } else {
                        this.O000o00.O00000o0().O000000o(this.O0000oo0, this.O0000oo, this.O0000ooO);
                    }
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public void destroy(boolean z) {
        try {
            this.O000OoO0 = true;
            if (z) {
                remove();
            }
            int i = 0;
            if (this.O000o00 != null) {
                int i2 = 0;
                while (this.O000Oo0o != null && i2 < this.O000Oo0o.length) {
                    O0000O0o o0000O0o = this.O000Oo0o[i2];
                    if (o0000O0o != null) {
                        this.O000o00.O000000o(o0000O0o);
                        this.O000o00.O00000o0().O00000o0(o0000O0o.O0000o0O());
                    }
                    i2++;
                }
            }
            while (this.O000o0 != null && i < this.O000o0.size()) {
                ((BitmapDescriptor) this.O000o0.get(i)).recycle();
                i++;
            }
            this.O000OoO = null;
            this.O000o00O = null;
            this.O000Oo0o = null;
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "MarkerDelegateImp", "destroy");
            th.printStackTrace();
            Log.d("destroy erro", "MarkerDelegateImp destroy");
        }
    }

    public boolean equalsRemote(IOverlayImage iOverlayImage) throws RemoteException {
        return equals(iOverlayImage) || iOverlayImage.getId().equals(getId());
    }

    public float getAlpha() {
        return this.O000O0OO;
    }

    public float getAnchorU() {
        return this.O000Ooo;
    }

    public float getAnchorV() {
        return this.O000OooO;
    }

    public int getDisplayLevel() {
        return this.O000O0o;
    }

    public IPoint getGeoPoint() {
        IPoint obtain = IPoint.obtain();
        if (this.O000o0o) {
            this.O000o00.O00000o0().O000000o(this.O000o0oo, this.O000o, obtain);
            return obtain;
        }
        obtain.set(this.O0000oo0, this.O0000oo);
        return obtain;
    }

    public IMarkerAction getIMarkerAction() {
        return this;
    }

    public synchronized ArrayList<BitmapDescriptor> getIcons() {
        if (this.O000o0 == null || this.O000o0.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (BitmapDescriptor add : this.O000o0) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public String getId() {
        if (this.O00O0Oo == null) {
            this.O00O0Oo = O000000o("Marker");
        }
        return this.O00O0Oo;
    }

    public Object getObject() {
        return this.O000o00O;
    }

    public MarkerOptions getOptions() {
        return this.O000O0Oo;
    }

    public int getPeriod() {
        return this.O000o0o0;
    }

    public LatLng getPosition() {
        if (!this.O000o0o || this.O0000ooO == null) {
            return this.O000OoO;
        }
        DPoint obtain = DPoint.obtain();
        IPoint obtain2 = IPoint.obtain();
        O0000o0o();
        this.O000o00.O00000o0().O000000o(this.O0000ooO.x, this.O0000ooO.y, obtain2);
        GLMapState.geo2LonLat(obtain2.x, obtain2.y, obtain);
        LatLng latLng = new LatLng(obtain.y, obtain.x);
        obtain2.recycle();
        obtain.recycle();
        return latLng;
    }

    public float getRotateAngle() {
        O0000oO0();
        return this.O0000o0o;
    }

    public String getSnippet() {
        return this.O000Ooo0;
    }

    public String getTitle() {
        return this.O000OoOo;
    }

    public float getZIndex() {
        return this.O00oOooO;
    }

    public int hashCodeRemote() {
        return super.hashCode();
    }

    public void hideInfoWindow() {
        if (isInfoWindowShown()) {
            this.O000o00.O00000Oo((OoO0o) this);
            O0000oO0();
            this.O0000o00 = false;
        }
        this.O0000o0 = false;
    }

    public boolean isClickable() {
        return this.O000O0oO;
    }

    public boolean isDraggable() {
        return this.O000Oooo;
    }

    public boolean isFlat() {
        return this.O0000o;
    }

    public boolean isInfoWindowAutoOverturn() {
        return this.O00oOoOo;
    }

    public boolean isInfoWindowEnable() {
        return this.O000O0o0;
    }

    public boolean isInfoWindowShown() {
        return this.O0000o00;
    }

    public boolean isPerspective() {
        return this.O000o00o;
    }

    public boolean isRemoved() {
        try {
            return this.O000o00.O00000o0(this) ^ 1;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isVisible() {
        return this.O000o000;
    }

    public boolean remove() {
        O0000oO0();
        this.O000o000 = false;
        return this.O000o00 != null ? this.O000o00.O000000o((OoO0o) this) : false;
    }

    public void set2Top() {
        this.O000o00.O000000o((O0Oo0) this);
    }

    public void setAlpha(float f) {
        this.O000O0OO = f;
        this.O000O0Oo.alpha(f);
    }

    public void setAnchor(float f, float f2) {
        if (this.O000Ooo != f || this.O000OooO != f2) {
            this.O000O0Oo.anchor(f, f2);
            this.O000Ooo = f;
            this.O000OooO = f2;
            this.O0000o0 = true;
            O0000oO0();
        }
    }

    public void setAnimation(Animation animation) {
        IAnimation O0000o = O0000o();
        if (O0000o != null) {
            O0000o.setAnimation(animation == null ? null : animation.glAnimation);
        }
    }

    public void setAnimation(GLAnimation gLAnimation) {
        if (gLAnimation != null) {
            this.O0000O0o = gLAnimation;
        }
    }

    public void setAnimationListener(AnimationListener animationListener) {
        if (this.O0000O0o != null) {
            this.O0000O0o.setAnimationListener(animationListener);
        }
    }

    public void setAutoOverturnInfoWindow(boolean z) {
        this.O00oOoOo = z;
        this.O000O0Oo.autoOverturnInfoWindow(z);
    }

    public void setBelowMaskLayer(boolean z) {
        this.O000OO0o = z;
    }

    public void setClickable(boolean z) {
        this.O000O0oO = z;
    }

    public void setDisplayLevel(int i) {
        this.O000O0o = i;
        this.O000O0Oo.displayLevel(i);
    }

    public void setDraggable(boolean z) {
        this.O000Oooo = z;
        this.O000O0Oo.draggable(z);
        O0000oO0();
    }

    public void setFixingPointEnable(boolean z) {
        this.O000O0oo = z;
        if (!z) {
            z = this.O000o0o;
            this.O000OoO = getPosition();
            setPosition(this.O000OoO);
            if (z) {
                this.O000o0o = true;
            }
        } else if (this.O000o0o && this.O000OoO != null) {
            FPoint obtain = FPoint.obtain();
            this.O000o00.O00000o0().O00000o0().p20ToScreenPoint(this.O0000oo0, this.O0000oo, obtain);
            this.O000o0oo = (int) obtain.x;
            this.O000o = (int) obtain.y;
            obtain.recycle();
        }
    }

    public void setFlat(boolean z) throws RemoteException {
        this.O0000o = z;
        O0000oO0();
        this.O000O0Oo.setFlat(z);
    }

    public void setGeoPoint(IPoint iPoint) {
        this.O000o0o = false;
        O000000o(iPoint.x, iPoint.y);
    }

    public void setIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            try {
                if (this.O000o0 != null) {
                    synchronized (this) {
                        this.O0000Oo = false;
                        this.O000o0.clear();
                        this.O000o0.add(bitmapDescriptor);
                        this.O000OO00 = false;
                        this.O000o0O = false;
                        this.O0000Ooo = false;
                        O0000oO0();
                        this.O0000o0 = true;
                        this.O000Oo00 = bitmapDescriptor.getWidth();
                        this.O000Oo0 = bitmapDescriptor.getHeight();
                    }
                }
            } catch (Throwable th) {
                ooOOOOoo.O00000o0(th, "MarkerDelegateImp", "setIcon");
                th.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Missing block: B:16:0x002d, code skipped:
            return;
     */
    public synchronized void setIcons(java.util.ArrayList<com.amap.api.maps.model.BitmapDescriptor> r3) {
        /*
        r2 = this;
        monitor-enter(r2);
        if (r3 == 0) goto L_0x002c;
    L_0x0003:
        r0 = r2.O000o0;	 Catch:{ Throwable -> 0x001d }
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        goto L_0x002c;
    L_0x0008:
        r0 = 0;
        r2.O0000Oo = r0;	 Catch:{ Throwable -> 0x001d }
        r2.O000000o(r3);	 Catch:{ Throwable -> 0x001d }
        r2.O000o0O = r0;	 Catch:{ Throwable -> 0x001d }
        r2.O0000Ooo = r0;	 Catch:{ Throwable -> 0x001d }
        r2.O000OO00 = r0;	 Catch:{ Throwable -> 0x001d }
        r2.O0000oO0();	 Catch:{ Throwable -> 0x001d }
        r3 = 1;
        r2.O0000o0 = r3;	 Catch:{ Throwable -> 0x001d }
        goto L_0x0028;
    L_0x001b:
        r3 = move-exception;
        goto L_0x002a;
    L_0x001d:
        r3 = move-exception;
        r0 = "MarkerDelegateImp";
        r1 = "setIcons";
        com.amap.api.mapcore.util.ooOOOOoo.O00000o0(r3, r0, r1);	 Catch:{ all -> 0x001b }
        r3.printStackTrace();	 Catch:{ all -> 0x001b }
    L_0x0028:
        monitor-exit(r2);
        return;
    L_0x002a:
        monitor-exit(r2);
        throw r3;
    L_0x002c:
        monitor-exit(r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.Oo0OOo.setIcons(java.util.ArrayList):void");
    }

    public void setInfoWindowEnable(boolean z) {
        this.O000O0o0 = z;
        if (!z) {
            hideInfoWindow();
        }
        this.O000O0Oo.infoWindowEnable(z);
    }

    public void setMarkerOptions(MarkerOptions markerOptions) {
        if (markerOptions != null) {
            this.O000O0Oo = markerOptions;
            this.O000OoO = this.O000O0Oo.getPosition();
            IPoint obtain = IPoint.obtain();
            this.O000o0O0 = this.O000O0Oo.isGps();
            if (this.O000O0Oo.getPosition() != null) {
                if (this.O000o0O0) {
                    try {
                        double[] O000000o = as.O000000o(this.O000O0Oo.getPosition().longitude, this.O000O0Oo.getPosition().latitude);
                        this.O000OoOO = new LatLng(O000000o[1], O000000o[0]);
                        GLMapState.lonlat2Geo(O000000o[0], O000000o[1], obtain);
                    } catch (Throwable th) {
                        ooOOOOoo.O00000o0(th, "MarkerDelegateImp", "create");
                        this.O000OoOO = this.O000O0Oo.getPosition();
                    }
                } else {
                    GLMapState.lonlat2Geo(this.O000OoO.longitude, this.O000OoO.latitude, obtain);
                }
            }
            this.O0000oo0 = obtain.x;
            this.O0000oo = obtain.y;
            this.O000Ooo = this.O000O0Oo.getAnchorU();
            this.O000OooO = this.O000O0Oo.getAnchorV();
            this.O0000oO0 = this.O000O0Oo.getInfoWindowOffsetX();
            this.O0000oO = this.O000O0Oo.getInfoWindowOffsetY();
            this.O000o0o0 = this.O000O0Oo.getPeriod();
            this.O00oOooO = this.O000O0Oo.getZIndex();
            this.O000OO0o = this.O000O0Oo.isBelowMaskLayer();
            O0000o0o();
            O000000o(this.O000O0Oo.getIcons());
            this.O0000Oo = this.O000O0Oo.isRotatingMode();
            this.O0000OoO = this.O000O0Oo.getAngleOffset();
            this.O000o000 = this.O000O0Oo.isVisible();
            this.O000Ooo0 = this.O000O0Oo.getSnippet();
            this.O000OoOo = this.O000O0Oo.getTitle();
            this.O000Oooo = this.O000O0Oo.isDraggable();
            this.O00O0Oo = getId();
            this.O000o00o = this.O000O0Oo.isPerspective();
            this.O0000o = this.O000O0Oo.isFlat();
            this.O000OO0o = this.O000O0Oo.isBelowMaskLayer();
            this.O000O0OO = this.O000O0Oo.getAlpha();
            setRotateAngle(this.O000O0Oo.getRotateAngle());
            this.O000O0o = this.O000O0Oo.getDisplayLevel();
            this.O00oOoOo = this.O000O0Oo.isInfoWindowAutoOverturn();
            this.O000O0o0 = this.O000O0Oo.isInfoWindowEnable();
            this.O000000o = new float[16];
            this.O00000Oo = new float[4];
            obtain.recycle();
            OOO0O0O.O000000o().O000000o(this.O000OoO, this.O000OoOo, this.O000Ooo0);
        }
    }

    public void setObject(Object obj) {
        this.O000o00O = obj;
    }

    public void setPeriod(int i) {
        if (i <= 1) {
            this.O000o0o0 = 1;
        } else {
            this.O000o0o0 = i;
        }
    }

    public void setPerspective(boolean z) {
        this.O000o00o = z;
    }

    public void setPosition(LatLng latLng) {
        if (latLng == null) {
            ooOOOOoo.O00000o0(new AMapException("非法坐标值 latlng is null"), "setPosition", "Marker");
            return;
        }
        this.O000OoO = latLng;
        IPoint obtain = IPoint.obtain();
        if (this.O000o0O0) {
            try {
                double[] O000000o = as.O000000o(latLng.longitude, latLng.latitude);
                this.O000OoOO = new LatLng(O000000o[1], O000000o[0]);
                GLMapState.lonlat2Geo(O000000o[0], O000000o[1], obtain);
            } catch (Throwable unused) {
                this.O000OoOO = latLng;
            }
        } else {
            GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, obtain);
        }
        this.O0000oo0 = obtain.x;
        this.O0000oo = obtain.y;
        this.O000o0o = false;
        O0000o0o();
        O0000oO0();
        this.O0000o0 = true;
        obtain.recycle();
    }

    public void setPositionByPixels(int i, int i2) {
        this.O000o0oo = i;
        this.O000o = i2;
        this.O000o0o = true;
        O0000o0o();
        O0000oO0();
        this.O0000o0 = true;
    }

    public void setPositionNotUpdate(LatLng latLng) {
        setPosition(latLng);
    }

    public void setRotateAngle(float f) {
        this.O000O0Oo.rotateAngle(f);
        this.O0000o0o = f;
        this.O0000o0O = (((-f) % 360.0f) + 360.0f) % 360.0f;
        this.O0000o0 = true;
        O0000oO0();
    }

    public void setRotateAngleNotUpdate(float f) {
    }

    public void setSnippet(String str) {
        this.O000Ooo0 = str;
        O0000oO0();
        this.O000O0Oo.snippet(str);
    }

    public void setTitle(String str) {
        this.O000OoOo = str;
        O0000oO0();
        this.O000O0Oo.title(str);
        OOO0O0O.O000000o().O000000o(this.O000OoO, this.O000OoOo, this.O000Ooo0);
    }

    public void setVisible(boolean z) {
        if (this.O000o000 != z) {
            this.O000O0Oo.visible(z);
            this.O000o000 = z;
            if (!z) {
                this.O000OO = false;
                if (isInfoWindowShown()) {
                    this.O000o00.O00000Oo((OoO0o) this);
                }
            }
            O0000oO0();
        }
    }

    public void setZIndex(float f) {
        this.O00oOooO = f;
        this.O000O0Oo.zIndex(f);
        if (this.O000OO) {
            this.O000OO = false;
            this.O000o00.O000000o();
        }
        this.O000o00.O00000oo();
    }

    public void showInfoWindow() {
        if (this.O000o000 && isInfoWindowEnable()) {
            this.O000o00.O000000o((bi) this);
            O0000oO0();
        }
    }

    public boolean startAnimation() {
        if (this.O0000O0o != null) {
            synchronized (this.O0000OOo) {
                if (this.O0000O0o instanceof GLAnimationSet) {
                    GLAnimationSet gLAnimationSet = (GLAnimationSet) this.O0000O0o;
                    for (GLAnimation gLAnimation : gLAnimationSet.getAnimations()) {
                        O000000o(gLAnimation);
                        gLAnimation.setDuration(gLAnimationSet.getDuration());
                    }
                } else {
                    O000000o(this.O0000O0o);
                }
                this.O000OOOo = false;
                this.O00000oo = this.O0000O0o;
                this.O00000oo.start();
            }
            O0000oO0();
        }
        return false;
    }
}
