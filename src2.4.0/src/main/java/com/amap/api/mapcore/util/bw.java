package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import com.amap.api.maps.model.AMapGestureListener;
import com.amap.api.maps.utils.SpatialRelationUtil;
import com.autonavi.ae.gmap.gesture.EAMapPlatformGestureInfo;
import com.autonavi.amap.mapcore.message.HoverGestureMapMessage;
import com.autonavi.amap.mapcore.message.MoveGestureMapMessage;
import com.autonavi.amap.mapcore.message.RotateGestureMapMessage;
import com.autonavi.amap.mapcore.message.ScaleGestureMapMessage;

/* compiled from: GlMapGestureDetector */
public class bw {
    ca O000000o;
    Context O00000Oo;
    public AMapGestureListener O00000o;
    GestureDetector O00000o0;
    private O000OOo O00000oO;
    private O000OOOo O00000oo;
    private O000OO O0000O0o;
    private O000Oo0 O0000OOo;
    private int O0000Oo = 0;
    private boolean O0000Oo0 = false;
    private int O0000OoO = 0;
    private int O0000Ooo = 0;
    private boolean O0000o = true;
    private int O0000o0 = 0;
    private int O0000o00 = 0;
    private boolean O0000o0O = false;
    private boolean O0000o0o = false;
    private Handler O0000oO0 = new Handler(Looper.getMainLooper());

    /* compiled from: GlMapGestureDetector */
    private class O000000o implements OnDoubleTapListener, OnGestureListener {
        float O000000o;
        long O00000Oo;
        private int O00000o;
        private EAMapPlatformGestureInfo O00000oO;

        private O000000o() {
            this.O00000o = 0;
            this.O000000o = 0.0f;
            this.O00000oO = new EAMapPlatformGestureInfo();
            this.O00000Oo = 0;
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            bw.this.O00000o0.setIsLongpressEnabled(false);
            this.O00000o = motionEvent.getPointerCount();
            if (bw.this.O00000o != null) {
                bw.this.O00000o.onDoubleTap(motionEvent.getX(), motionEvent.getY());
            }
            return false;
        }

        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            if (this.O00000o < motionEvent.getPointerCount()) {
                this.O00000o = motionEvent.getPointerCount();
            }
            int action = motionEvent.getAction() & 255;
            boolean z = true;
            if (this.O00000o == 1) {
                try {
                    if (!bw.this.O000000o.O0000OOo().isZoomGesturesEnabled()) {
                        return false;
                    }
                } catch (Throwable th) {
                    ooOOOOoo.O00000o0(th, "GLMapGestrureDetector", "onDoubleTapEvent");
                    th.printStackTrace();
                }
                float[] fArr;
                if (action == 0) {
                    this.O00000oO.mGestureState = 1;
                    this.O00000oO.mGestureType = 9;
                    fArr = new float[]{motionEvent.getX(), motionEvent.getY()};
                    this.O00000oO.mLocation = fArr;
                    action = bw.this.O000000o.O000000o(this.O00000oO);
                    this.O000000o = motionEvent.getY();
                    bw.this.O000000o.O000000o(action, ScaleGestureMapMessage.obtain(100, 1.0f, 0, 0));
                    this.O00000Oo = SystemClock.uptimeMillis();
                } else if (action == 2) {
                    bw.this.O0000o0O = true;
                    float y = this.O000000o - motionEvent.getY();
                    if (Math.abs(y) >= ((float) 20)) {
                        this.O00000oO.mGestureState = 2;
                        this.O00000oO.mGestureType = 9;
                        fArr = new float[]{motionEvent.getX(), motionEvent.getY()};
                        this.O00000oO.mLocation = fArr;
                        int O000000o = bw.this.O000000o.O000000o(this.O00000oO);
                        float mapHeight = (4.0f * y) / ((float) bw.this.O000000o.getMapHeight());
                        if (y > 0.0f) {
                            bw.this.O000000o.O000000o(O000000o, ScaleGestureMapMessage.obtain(101, mapHeight, 0, 0));
                        } else {
                            bw.this.O000000o.O000000o(O000000o, ScaleGestureMapMessage.obtain(101, mapHeight, 0, 0));
                        }
                        this.O000000o = motionEvent.getY();
                    }
                } else {
                    this.O00000oO.mGestureState = 3;
                    this.O00000oO.mGestureType = 9;
                    float[] fArr2 = new float[]{motionEvent.getX(), motionEvent.getY()};
                    this.O00000oO.mLocation = fArr2;
                    int O000000o2 = bw.this.O000000o.O000000o(this.O00000oO);
                    bw.this.O00000o0.setIsLongpressEnabled(true);
                    bw.this.O000000o.O000000o(O000000o2, ScaleGestureMapMessage.obtain(102, 1.0f, 0, 0));
                    if (action == 1) {
                        bw.this.O000000o.O000000o(O000000o2, 3);
                        long uptimeMillis = SystemClock.uptimeMillis() - this.O00000Oo;
                        if (!bw.this.O0000o0O || uptimeMillis < ((long) 200)) {
                            return bw.this.O000000o.O00000Oo(O000000o2, motionEvent);
                        }
                        bw.this.O0000o0O = false;
                    } else {
                        bw.this.O0000o0O = false;
                    }
                }
            } else {
                z = false;
            }
            return z;
        }

        public boolean onDown(MotionEvent motionEvent) {
            bw.this.O0000o0O = false;
            return true;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (bw.this.O00000o != null) {
                bw.this.O00000o.onFling(f, f2);
            }
            try {
                if (bw.this.O000000o.O0000OOo().isScrollGesturesEnabled() && bw.this.O0000o00 <= 0 && bw.this.O0000OoO <= 0 && bw.this.O0000Ooo == 0 && !bw.this.O0000o) {
                    this.O00000oO.mGestureState = 3;
                    this.O00000oO.mGestureType = 3;
                    float[] fArr = new float[]{motionEvent2.getX(), motionEvent2.getY()};
                    this.O00000oO.mLocation = fArr;
                    int O000000o = bw.this.O000000o.O000000o(this.O00000oO);
                    bw.this.O000000o.onFling();
                    bw.this.O000000o.O000000o().startMapSlidAnim(O000000o, new Point((int) motionEvent2.getX(), (int) motionEvent2.getY()), f, f2);
                }
                return true;
            } catch (Throwable th) {
                ooOOOOoo.O00000o0(th, "GLMapGestrureDetector", "onFling");
                th.printStackTrace();
                return true;
            }
        }

        public void onLongPress(MotionEvent motionEvent) {
            if (bw.this.O0000o0 == 1) {
                this.O00000oO.mGestureState = 3;
                this.O00000oO.mGestureType = 7;
                float[] fArr = new float[]{motionEvent.getX(), motionEvent.getY()};
                this.O00000oO.mLocation = fArr;
                bw.this.O000000o.O000000o(bw.this.O000000o.O000000o(this.O00000oO), motionEvent);
                if (bw.this.O00000o != null) {
                    bw.this.O00000o.onLongPress(motionEvent.getX(), motionEvent.getY());
                }
            }
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (bw.this.O00000o != null) {
                bw.this.O00000o.onScroll(f, f2);
            }
            return false;
        }

        public void onShowPress(MotionEvent motionEvent) {
            try {
                this.O00000oO.mGestureState = 3;
                this.O00000oO.mGestureType = 7;
                float[] fArr = new float[]{motionEvent.getX(), motionEvent.getY()};
                this.O00000oO.mLocation = fArr;
                bw.this.O000000o.O000000o().clearAnimations(bw.this.O000000o.O000000o(this.O00000oO), false);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (bw.this.O0000o0 != 1) {
                return false;
            }
            this.O00000oO.mGestureState = 3;
            this.O00000oO.mGestureType = 8;
            float[] fArr = new float[]{motionEvent.getX(), motionEvent.getY()};
            this.O00000oO.mLocation = fArr;
            int O000000o = bw.this.O000000o.O000000o(this.O00000oO);
            if (bw.this.O00000o != null) {
                try {
                    bw.this.O00000o.onSingleTap(motionEvent.getX(), motionEvent.getY());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return bw.this.O000000o.O00000o0(O000000o, motionEvent);
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }
    }

    /* compiled from: GlMapGestureDetector */
    private class O00000Oo implements com.amap.api.mapcore.util.O000OO.O000000o {
        private EAMapPlatformGestureInfo O00000Oo;

        private O00000Oo() {
            this.O00000Oo = new EAMapPlatformGestureInfo();
        }

        public boolean O000000o(O000OO o000oo) {
            this.O00000Oo.mGestureState = 2;
            this.O00000Oo.mGestureType = 6;
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.O00000Oo;
            r1 = new float[2];
            int i = 0;
            r1[0] = o000oo.O00000o0().getX();
            r1[1] = o000oo.O00000o0().getY();
            eAMapPlatformGestureInfo.mLocation = r1;
            try {
                if (!bw.this.O000000o.O0000OOo().isTiltGesturesEnabled()) {
                    return true;
                }
                int O000000o = bw.this.O000000o.O000000o(this.O00000Oo);
                if (bw.this.O000000o.O00000o(O000000o) || bw.this.O0000Ooo > 3) {
                    return false;
                }
                float f = o000oo.O00000o().x;
                float f2 = o000oo.O00000o().y;
                if (!bw.this.O0000Oo0) {
                    PointF O000000o2 = o000oo.O000000o(0);
                    PointF O000000o3 = o000oo.O000000o(1);
                    if ((O000000o2.y > 10.0f && O000000o3.y > 10.0f) || (O000000o2.y < -10.0f && O000000o3.y < -10.0f)) {
                        i = 1;
                    }
                    if (i != 0) {
                        float f3 = (float) 10;
                        if (Math.abs(f2) > f3 && Math.abs(f) < f3) {
                            bw.this.O0000Oo0 = true;
                        }
                    }
                }
                if (bw.this.O0000Oo0) {
                    bw.this.O0000Oo0 = true;
                    f2 /= 6.0f;
                    if (Math.abs(f2) > 1.0f) {
                        bw.this.O000000o.O000000o(O000000o, HoverGestureMapMessage.obtain(101, f2));
                        bw.this.O0000o00 = bw.this.O0000o00 + 1;
                        return true;
                    }
                }
                return true;
            } catch (Throwable th) {
                ooOOOOoo.O00000o0(th, "GLMapGestrureDetector", "onHove");
                th.printStackTrace();
                return true;
            }
        }

        public boolean O00000Oo(O000OO o000oo) {
            this.O00000Oo.mGestureState = 1;
            this.O00000Oo.mGestureType = 6;
            float[] fArr = new float[]{o000oo.O00000o0().getX(), o000oo.O00000o0().getY()};
            this.O00000Oo.mLocation = fArr;
            try {
                if (!bw.this.O000000o.O0000OOo().isTiltGesturesEnabled()) {
                    return true;
                }
                int O000000o = bw.this.O000000o.O000000o(this.O00000Oo);
                if (bw.this.O000000o.O00000o(O000000o)) {
                    return false;
                }
                bw.this.O000000o.O000000o(O000000o, HoverGestureMapMessage.obtain(100, bw.this.O000000o.O0000o0O(O000000o)));
                return true;
            } catch (Throwable th) {
                ooOOOOoo.O00000o0(th, "GLMapGestrureDetector", "onHoveBegin");
                th.printStackTrace();
                return true;
            }
        }

        public void O00000o0(O000OO o000oo) {
            this.O00000Oo.mGestureState = 3;
            this.O00000Oo.mGestureType = 6;
            float[] fArr = new float[]{o000oo.O00000o0().getX(), o000oo.O00000o0().getY()};
            this.O00000Oo.mLocation = fArr;
            try {
                if (bw.this.O000000o.O0000OOo().isTiltGesturesEnabled()) {
                    int O000000o = bw.this.O000000o.O000000o(this.O00000Oo);
                    if (!bw.this.O000000o.O00000o(O000000o)) {
                        if (bw.this.O000000o.O0000o0O(O000000o) >= 0.0f && bw.this.O0000o00 > 0) {
                            bw.this.O000000o.O000000o(O000000o, 7);
                        }
                        bw.this.O0000Oo0 = false;
                        bw.this.O000000o.O000000o(O000000o, HoverGestureMapMessage.obtain(102, bw.this.O000000o.O0000o0O(O000000o)));
                    }
                }
            } catch (Throwable th) {
                ooOOOOoo.O00000o0(th, "GLMapGestrureDetector", "onHoveEnd");
                th.printStackTrace();
            }
        }
    }

    /* compiled from: GlMapGestureDetector */
    private class O00000o0 implements com.amap.api.mapcore.util.O000OOOo.O000000o {
        private EAMapPlatformGestureInfo O00000Oo;

        private O00000o0() {
            this.O00000Oo = new EAMapPlatformGestureInfo();
        }

        public boolean O000000o(O000OOOo o000OOOo) {
            if (bw.this.O0000Oo0) {
                return true;
            }
            try {
                if (!bw.this.O000000o.O0000OOo().isScrollGesturesEnabled() || bw.this.O0000o0o) {
                    return true;
                }
                this.O00000Oo.mGestureState = 2;
                this.O00000Oo.mGestureType = 3;
                float[] fArr = new float[]{o000OOOo.O00000o0().getX(), o000OOOo.O00000o0().getY()};
                this.O00000Oo.mLocation = fArr;
                int O000000o = bw.this.O000000o.O000000o(this.O00000Oo);
                PointF O00000o = o000OOOo.O00000o();
                float f = 1.0f;
                if (bw.this.O0000Oo == 0) {
                    f = 4.0f;
                }
                if (Math.abs(O00000o.x) <= f && Math.abs(O00000o.y) <= f) {
                    return false;
                }
                if (bw.this.O0000Oo == 0) {
                    bw.this.O000000o.O000000o().clearAnimations(O000000o, false);
                }
                bw.this.O000000o.O000000o(O000000o, MoveGestureMapMessage.obtain(101, O00000o.x, O00000o.y));
                bw.this.O0000Oo = bw.this.O0000Oo + 1;
                return true;
            } catch (Throwable th) {
                ooOOOOoo.O00000o0(th, "GLMapGestrureDetector", "onMove");
                th.printStackTrace();
                return true;
            }
        }

        public boolean O00000Oo(O000OOOo o000OOOo) {
            try {
                if (!bw.this.O000000o.O0000OOo().isScrollGesturesEnabled()) {
                    return true;
                }
                this.O00000Oo.mGestureState = 1;
                this.O00000Oo.mGestureType = 3;
                float[] fArr = new float[]{o000OOOo.O00000o0().getX(), o000OOOo.O00000o0().getY()};
                this.O00000Oo.mLocation = fArr;
                bw.this.O000000o.O000000o(bw.this.O000000o.O000000o(this.O00000Oo), MoveGestureMapMessage.obtain(100, 0.0f, 0.0f));
                return true;
            } catch (Throwable th) {
                ooOOOOoo.O00000o0(th, "GLMapGestrureDetector", "onMoveBegin");
                th.printStackTrace();
                return true;
            }
        }

        public void O00000o0(O000OOOo o000OOOo) {
            try {
                if (bw.this.O000000o.O0000OOo().isScrollGesturesEnabled()) {
                    this.O00000Oo.mGestureState = 3;
                    this.O00000Oo.mGestureType = 3;
                    float[] fArr = new float[]{o000OOOo.O00000o0().getX(), o000OOOo.O00000o0().getY()};
                    this.O00000Oo.mLocation = fArr;
                    int O000000o = bw.this.O000000o.O000000o(this.O00000Oo);
                    if (bw.this.O0000Oo > 0) {
                        bw.this.O000000o.O000000o(O000000o, 5);
                    }
                    bw.this.O000000o.O000000o(O000000o, MoveGestureMapMessage.obtain(102, 0.0f, 0.0f));
                }
            } catch (Throwable th) {
                ooOOOOoo.O00000o0(th, "GLMapGestrureDetector", "onMoveEnd");
                th.printStackTrace();
            }
        }
    }

    /* compiled from: GlMapGestureDetector */
    private class O00000o extends com.amap.api.mapcore.util.O000OOo.O000000o {
        private boolean O00000Oo;
        private boolean O00000o;
        private boolean O00000o0;
        private Point O00000oO;
        private float[] O00000oo;
        private float O0000O0o;
        private float[] O0000OOo;
        private EAMapPlatformGestureInfo O0000Oo;
        private float O0000Oo0;

        private O00000o() {
            this.O00000Oo = false;
            this.O00000o0 = false;
            this.O00000o = false;
            this.O00000oO = new Point();
            this.O00000oo = new float[10];
            this.O0000O0o = 0.0f;
            this.O0000OOo = new float[10];
            this.O0000Oo0 = 0.0f;
            this.O0000Oo = new EAMapPlatformGestureInfo();
        }

        /* JADX WARNING: Removed duplicated region for block: B:35:0x00ce A:{Catch:{ Throwable -> 0x010e }} */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x00cd A:{Catch:{ Throwable -> 0x010e }} */
        /* JADX WARNING: Removed duplicated region for block: B:84:? A:{SYNTHETIC, RETURN, SKIP} */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x0130 A:{Catch:{ Throwable -> 0x01ae }} */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x0130 A:{Catch:{ Throwable -> 0x01ae }} */
        /* JADX WARNING: Removed duplicated region for block: B:84:? A:{SYNTHETIC, RETURN, SKIP} */
        /* JADX WARNING: Removed duplicated region for block: B:84:? A:{SYNTHETIC, RETURN, SKIP} */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x0130 A:{Catch:{ Throwable -> 0x01ae }} */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x0130 A:{Catch:{ Throwable -> 0x01ae }} */
        /* JADX WARNING: Removed duplicated region for block: B:84:? A:{SYNTHETIC, RETURN, SKIP} */
        public boolean O000000o(com.amap.api.mapcore.util.O000OOo r19) {
            /*
            r18 = this;
            r1 = r18;
            r2 = r1.O0000Oo;
            r3 = 2;
            r2.mGestureState = r3;
            r2 = r1.O0000Oo;
            r4 = 4;
            r2.mGestureType = r4;
            r2 = r1.O0000Oo;
            r4 = new float[r3];
            r5 = r19.O000000o();
            r5 = r5.getX();
            r6 = 0;
            r4[r6] = r5;
            r5 = r19.O000000o();
            r5 = r5.getY();
            r7 = 1;
            r4[r7] = r5;
            r2.mLocation = r4;
            r2 = com.amap.api.mapcore.util.bw.this;
            r2 = r2.O000000o;
            r4 = r1.O0000Oo;
            r2 = r2.O000000o(r4);
            r4 = r19.O0000Oo();
            r8 = r19.O0000OoO();
            r5 = (float) r8;
            r8 = r19.O00000Oo();
            r8 = (int) r8;
            r9 = r19.O00000o0();
            r9 = (int) r9;
            r10 = r1.O00000oO;
            r10 = r10.x;
            r10 = r8 - r10;
            r10 = java.lang.Math.abs(r10);
            r10 = (float) r10;
            r11 = r1.O00000oO;
            r11 = r11.y;
            r11 = r9 - r11;
            r11 = java.lang.Math.abs(r11);
            r11 = (float) r11;
            r12 = r1.O00000oO;
            r12.x = r8;
            r12 = r1.O00000oO;
            r12.y = r9;
            r12 = (double) r4;
            r12 = java.lang.Math.log(r12);
            r4 = (float) r12;
            r12 = com.amap.api.mapcore.util.bw.this;
            r12 = r12.O0000OoO;
            if (r12 > 0) goto L_0x007e;
        L_0x0071:
            r12 = java.lang.Math.abs(r4);
            r13 = 1045220557; // 0x3e4ccccd float:0.2 double:5.164075695E-315;
            r12 = (r12 > r13 ? 1 : (r12 == r13 ? 0 : -1));
            if (r12 <= 0) goto L_0x007e;
        L_0x007c:
            r1.O00000o = r7;
        L_0x007e:
            r12 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
            r13 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
            r14 = com.amap.api.mapcore.util.bw.this;	 Catch:{ Throwable -> 0x0114 }
            r14 = r14.O000000o;	 Catch:{ Throwable -> 0x0114 }
            r14 = r14.O0000OOo();	 Catch:{ Throwable -> 0x0114 }
            r14 = r14.isZoomGesturesEnabled();	 Catch:{ Throwable -> 0x0114 }
            if (r14 == 0) goto L_0x0112;
        L_0x0090:
            r14 = r1.O00000Oo;	 Catch:{ Throwable -> 0x0114 }
            if (r14 != 0) goto L_0x00a6;
        L_0x0094:
            r14 = 1031127695; // 0x3d75c28f float:0.06 double:5.094447706E-315;
            r15 = java.lang.Math.abs(r4);	 Catch:{ Throwable -> 0x00a2 }
            r14 = (r14 > r15 ? 1 : (r14 == r15 ? 0 : -1));
            if (r14 >= 0) goto L_0x00a6;
        L_0x009f:
            r1.O00000Oo = r7;	 Catch:{ Throwable -> 0x00a2 }
            goto L_0x00a6;
        L_0x00a2:
            r0 = move-exception;
            r3 = r0;
            goto L_0x0117;
        L_0x00a6:
            r14 = r1.O00000Oo;	 Catch:{ Throwable -> 0x0114 }
            if (r14 == 0) goto L_0x0112;
        L_0x00aa:
            r14 = 1008981770; // 0x3c23d70a float:0.01 double:4.9850323E-315;
            r15 = java.lang.Math.abs(r4);	 Catch:{ Throwable -> 0x0114 }
            r14 = (r14 > r15 ? 1 : (r14 == r15 ? 0 : -1));
            if (r14 >= 0) goto L_0x0112;
        L_0x00b5:
            r14 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1));
            if (r14 > 0) goto L_0x00bd;
        L_0x00b9:
            r14 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1));
            if (r14 <= 0) goto L_0x00ca;
        L_0x00bd:
            r14 = java.lang.Math.abs(r4);	 Catch:{ Throwable -> 0x010e }
            r15 = 1017370378; // 0x3ca3d70a float:0.02 double:5.02647753E-315;
            r14 = (r14 > r15 ? 1 : (r14 == r15 ? 0 : -1));
            if (r14 >= 0) goto L_0x00ca;
        L_0x00c8:
            r14 = r7;
            goto L_0x00cb;
        L_0x00ca:
            r14 = r6;
        L_0x00cb:
            if (r14 == 0) goto L_0x00ce;
        L_0x00cd:
            goto L_0x010c;
        L_0x00ce:
            r14 = 0;
            r15 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1));
            if (r15 <= 0) goto L_0x010c;
        L_0x00d3:
            r15 = r4 / r5;
            r1.O0000O0o = r15;	 Catch:{ Throwable -> 0x010e }
            r15 = r1.O0000O0o;	 Catch:{ Throwable -> 0x010e }
            r15 = java.lang.Math.abs(r15);	 Catch:{ Throwable -> 0x010e }
            r6 = r1.O00000oo;	 Catch:{ Throwable -> 0x010e }
            r13 = com.amap.api.mapcore.util.bw.this;	 Catch:{ Throwable -> 0x010e }
            r13 = r13.O0000OoO;	 Catch:{ Throwable -> 0x010e }
            r13 = r13 % 10;
            r6[r13] = r15;	 Catch:{ Throwable -> 0x010e }
            r6 = com.amap.api.mapcore.util.bw.this;	 Catch:{ Throwable -> 0x010e }
            r6.O0000OoO = r6.O0000OoO + 1;	 Catch:{ Throwable -> 0x010e }
            r6 = com.amap.api.mapcore.util.bw.this;	 Catch:{ Throwable -> 0x010e }
            r6 = r6.O000000o;	 Catch:{ Throwable -> 0x010e }
            r13 = com.autonavi.amap.mapcore.message.ScaleGestureMapMessage.obtain(r12, r4, r8, r9);	 Catch:{ Throwable -> 0x010e }
            r6.O000000o(r2, r13);	 Catch:{ Throwable -> 0x010e }
            r4 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1));
            if (r4 <= 0) goto L_0x0105;
        L_0x00fd:
            r3 = com.amap.api.mapcore.util.bw.this;	 Catch:{ Throwable -> 0x010e }
            r3 = r3.O000000o;	 Catch:{ Throwable -> 0x010e }
            r3.O000000o(r2, r7);	 Catch:{ Throwable -> 0x010e }
            goto L_0x010c;
        L_0x0105:
            r4 = com.amap.api.mapcore.util.bw.this;	 Catch:{ Throwable -> 0x010e }
            r4 = r4.O000000o;	 Catch:{ Throwable -> 0x010e }
            r4.O000000o(r2, r3);	 Catch:{ Throwable -> 0x010e }
        L_0x010c:
            r3 = r7;
            goto L_0x0122;
        L_0x010e:
            r0 = move-exception;
            r3 = r0;
            r6 = r7;
            goto L_0x0117;
        L_0x0112:
            r3 = 0;
            goto L_0x0122;
        L_0x0114:
            r0 = move-exception;
            r3 = r0;
            r6 = 0;
        L_0x0117:
            r4 = "GLMapGestrureDetector";
            r13 = "onScaleRotate";
            com.amap.api.mapcore.util.ooOOOOoo.O00000o0(r3, r4, r13);
            r3.printStackTrace();
            r3 = r6;
        L_0x0122:
            r4 = com.amap.api.mapcore.util.bw.this;	 Catch:{ Throwable -> 0x01ae }
            r4 = r4.O000000o;	 Catch:{ Throwable -> 0x01ae }
            r4 = r4.O0000OOo();	 Catch:{ Throwable -> 0x01ae }
            r4 = r4.isRotateGesturesEnabled();	 Catch:{ Throwable -> 0x01ae }
            if (r4 == 0) goto L_0x01ba;
        L_0x0130:
            r4 = com.amap.api.mapcore.util.bw.this;	 Catch:{ Throwable -> 0x01ae }
            r4 = r4.O000000o;	 Catch:{ Throwable -> 0x01ae }
            r4 = r4.O00000oO(r2);	 Catch:{ Throwable -> 0x01ae }
            if (r4 != 0) goto L_0x01ba;
        L_0x013a:
            r4 = r1.O00000o;	 Catch:{ Throwable -> 0x01ae }
            if (r4 != 0) goto L_0x01ba;
        L_0x013e:
            r4 = r19.O0000Ooo();	 Catch:{ Throwable -> 0x01ae }
            r6 = r1.O00000o0;	 Catch:{ Throwable -> 0x01ae }
            r13 = 1082130432; // 0x40800000 float:4.0 double:5.34643471E-315;
            if (r6 != 0) goto L_0x0152;
        L_0x0148:
            r6 = java.lang.Math.abs(r4);	 Catch:{ Throwable -> 0x01ae }
            r6 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1));
            if (r6 < 0) goto L_0x0152;
        L_0x0150:
            r1.O00000o0 = r7;	 Catch:{ Throwable -> 0x01ae }
        L_0x0152:
            r6 = r1.O00000o0;	 Catch:{ Throwable -> 0x01ae }
            if (r6 == 0) goto L_0x01ba;
        L_0x0156:
            r6 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
            r14 = java.lang.Math.abs(r4);	 Catch:{ Throwable -> 0x01ae }
            r6 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1));
            if (r6 >= 0) goto L_0x01ba;
        L_0x0160:
            r6 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1));
            if (r6 > 0) goto L_0x0168;
        L_0x0164:
            r6 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1));
            if (r6 <= 0) goto L_0x0175;
        L_0x0168:
            r6 = java.lang.Math.abs(r4);	 Catch:{ Throwable -> 0x01ae }
            r10 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
            r6 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1));
            if (r6 >= 0) goto L_0x0175;
        L_0x0172:
            r16 = r7;
            goto L_0x0177;
        L_0x0175:
            r16 = 0;
        L_0x0177:
            if (r16 == 0) goto L_0x017a;
        L_0x0179:
            goto L_0x01ba;
        L_0x017a:
            r5 = r4 / r5;
            r1.O0000Oo0 = r5;	 Catch:{ Throwable -> 0x01ae }
            r5 = r1.O0000Oo0;	 Catch:{ Throwable -> 0x01ae }
            r5 = java.lang.Math.abs(r5);	 Catch:{ Throwable -> 0x01ae }
            r6 = r1.O0000OOo;	 Catch:{ Throwable -> 0x01ae }
            r10 = com.amap.api.mapcore.util.bw.this;	 Catch:{ Throwable -> 0x01ae }
            r10 = r10.O0000Ooo;	 Catch:{ Throwable -> 0x01ae }
            r10 = r10 % 10;
            r6[r10] = r5;	 Catch:{ Throwable -> 0x01ae }
            r5 = com.amap.api.mapcore.util.bw.this;	 Catch:{ Throwable -> 0x01ae }
            r5.O0000Ooo = r5.O0000Ooo + 1;	 Catch:{ Throwable -> 0x01ae }
            r5 = com.amap.api.mapcore.util.bw.this;	 Catch:{ Throwable -> 0x01ae }
            r5 = r5.O000000o;	 Catch:{ Throwable -> 0x01ae }
            r4 = com.autonavi.amap.mapcore.message.RotateGestureMapMessage.obtain(r12, r4, r8, r9);	 Catch:{ Throwable -> 0x01ae }
            r5.O000000o(r2, r4);	 Catch:{ Throwable -> 0x01ae }
            r3 = com.amap.api.mapcore.util.bw.this;	 Catch:{ Throwable -> 0x01aa }
            r3 = r3.O000000o;	 Catch:{ Throwable -> 0x01aa }
            r4 = 6;
            r3.O000000o(r2, r4);	 Catch:{ Throwable -> 0x01aa }
            r3 = r7;
            goto L_0x01ba;
        L_0x01aa:
            r0 = move-exception;
            r2 = r0;
            r3 = r7;
            goto L_0x01b0;
        L_0x01ae:
            r0 = move-exception;
            r2 = r0;
        L_0x01b0:
            r4 = "GLMapGestrureDetector";
            r5 = "onScaleRotate";
            com.amap.api.mapcore.util.ooOOOOoo.O00000o0(r2, r4, r5);
            r2.printStackTrace();
        L_0x01ba:
            return r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.bw$O00000o.O000000o(com.amap.api.mapcore.util.O000OOo):boolean");
        }

        public boolean O00000Oo(O000OOo o000OOo) {
            this.O0000Oo.mGestureState = 1;
            this.O0000Oo.mGestureType = 4;
            float[] fArr = new float[]{o000OOo.O000000o().getX(), o000OOo.O000000o().getY()};
            this.O0000Oo.mLocation = fArr;
            int O000000o = bw.this.O000000o.O000000o(this.O0000Oo);
            int O00000Oo = (int) o000OOo.O00000Oo();
            int O00000o0 = (int) o000OOo.O00000o0();
            this.O00000o = false;
            this.O00000oO.x = O00000Oo;
            this.O00000oO.y = O00000o0;
            this.O00000Oo = false;
            this.O00000o0 = false;
            bw.this.O000000o.O000000o(O000000o, ScaleGestureMapMessage.obtain(100, 1.0f, O00000Oo, O00000o0));
            try {
                if (bw.this.O000000o.O0000OOo().isRotateGesturesEnabled() && !bw.this.O000000o.O00000oO(O000000o)) {
                    bw.this.O000000o.O000000o(O000000o, RotateGestureMapMessage.obtain(100, bw.this.O000000o.O0000o0(O000000o), O00000Oo, O00000o0));
                }
            } catch (Throwable th) {
                ooOOOOoo.O00000o0(th, "GLMapGestrureDetector", "onScaleRotateBegin");
                th.printStackTrace();
            }
            return true;
        }

        public void O00000o0(O000OOo o000OOo) {
            int O00000Oo;
            float f;
            float f2;
            float f3;
            this.O0000Oo.mGestureState = 3;
            this.O0000Oo.mGestureType = 4;
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.O0000Oo;
            float[] fArr = new float[2];
            fArr[0] = o000OOo.O000000o().getX();
            int i = 1;
            fArr[1] = o000OOo.O000000o().getY();
            eAMapPlatformGestureInfo.mLocation = fArr;
            int O000000o = bw.this.O000000o.O000000o(this.O0000Oo);
            this.O00000o = false;
            bw.this.O000000o.O000000o(O000000o, ScaleGestureMapMessage.obtain(102, 1.0f, 0, 0));
            if (bw.this.O0000OoO > 0) {
                O00000Oo = bw.this.O0000OoO > 10 ? 10 : bw.this.O0000OoO;
                f = 0.0f;
                for (int i2 = 0; i2 < 10; i2++) {
                    f += this.O00000oo[i2];
                    this.O00000oo[i2] = 0.0f;
                }
                f /= (float) O00000Oo;
                if (0.004f <= f) {
                    f *= 300.0f;
                    f2 = 1.5f;
                    if (f < 1.5f) {
                        f2 = f;
                    }
                    if (this.O0000O0o < 0.0f) {
                        f2 = -f2;
                    }
                    f2 += bw.this.O000000o.O000000o(O000000o);
                } else {
                    f2 = -9999.0f;
                }
                this.O0000O0o = 0.0f;
                f3 = f2;
            } else {
                f3 = -9999.0f;
            }
            if (bw.this.O000000o.O00000oO(O000000o)) {
                f2 = -9999.0f;
            } else {
                try {
                    if (bw.this.O000000o.O0000OOo().isRotateGesturesEnabled()) {
                        bw.this.O000000o.O000000o(O000000o, RotateGestureMapMessage.obtain(102, bw.this.O000000o.O0000o0(O000000o), 0, 0));
                    }
                } catch (Throwable th) {
                    ooOOOOoo.O00000o0(th, "GLMapGestrureDetector", "onScaleRotateEnd");
                    th.printStackTrace();
                }
                if (bw.this.O0000Ooo > 0) {
                    bw.this.O000000o.O000000o(O000000o, 6);
                    O00000Oo = bw.this.O0000Ooo > 10 ? 10 : bw.this.O0000Ooo;
                    f = 0.0f;
                    for (int i3 = 0; i3 < 10; i3++) {
                        f += this.O0000OOo[i3];
                        this.O0000OOo[i3] = 0.0f;
                    }
                    f /= (float) O00000Oo;
                    if (0.1f <= f) {
                        f *= 200.0f;
                        O00000Oo = ((int) bw.this.O000000o.O0000o0(O000000o)) % SpatialRelationUtil.A_CIRCLE_DEGREE;
                        float f4 = 60.0f;
                        if (f < 60.0f) {
                            f4 = f;
                        }
                        if (this.O0000Oo0 < 0.0f) {
                            f4 = -f4;
                        }
                        f2 = (float) (((int) (((float) O00000Oo) + f4)) % SpatialRelationUtil.A_CIRCLE_DEGREE);
                        this.O0000O0o = 0.0f;
                    }
                }
                f2 = -9999.0f;
                this.O0000O0o = 0.0f;
            }
            if (f3 == -9999.0f && f2 == -9999.0f) {
                i = 0;
            }
            if (i != 0) {
                bw.this.O000000o.O000000o().startPivotZoomRotateAnim(O000000o, this.O00000oO, f3, (int) f2, 500);
            }
        }
    }

    /* compiled from: GlMapGestureDetector */
    private class O0000O0o extends com.amap.api.mapcore.util.O000Oo0.O00000Oo {
        EAMapPlatformGestureInfo O000000o;

        private O0000O0o() {
            this.O000000o = new EAMapPlatformGestureInfo();
        }

        public void O00000Oo(O000Oo0 o000Oo0) {
            try {
                if (bw.this.O000000o.O0000OOo().isZoomGesturesEnabled()) {
                    float f = (float) 10;
                    if (Math.abs(o000Oo0.O00000o()) <= f && Math.abs(o000Oo0.O00000oO()) <= f && o000Oo0.O00000Oo() < 200) {
                        bw.this.O0000o = true;
                        this.O000000o.mGestureState = 2;
                        this.O000000o.mGestureType = 2;
                        float[] fArr = new float[]{o000Oo0.O00000o0().getX(), o000Oo0.O00000o0().getY()};
                        this.O000000o.mLocation = fArr;
                        int O000000o = bw.this.O000000o.O000000o(this.O000000o);
                        bw.this.O000000o.O000000o(O000000o, 4);
                        bw.this.O000000o.O00000o0(O000000o);
                    }
                }
            } catch (Throwable th) {
                ooOOOOoo.O00000o0(th, "GLMapGestrureDetector", "onZoomOut");
                th.printStackTrace();
            }
        }
    }

    public bw(ca caVar) {
        this.O00000Oo = caVar.O0000oo0();
        this.O000000o = caVar;
        O000000o o000000o = new O000000o();
        this.O00000o0 = new GestureDetector(this.O00000Oo, o000000o, this.O0000oO0);
        this.O00000o0.setOnDoubleTapListener(o000000o);
        this.O00000oO = new O000OOo(this.O00000Oo, new O00000o());
        this.O00000oo = new O000OOOo(this.O00000Oo, new O00000o0());
        this.O0000O0o = new O000OO(this.O00000Oo, new O00000Oo());
        this.O0000OOo = new O000Oo0(this.O00000Oo, new O0000O0o());
    }

    public void O000000o() {
        this.O0000Oo = 0;
        this.O0000Ooo = 0;
        this.O0000OoO = 0;
        this.O0000o00 = 0;
        this.O0000o0 = 0;
    }

    public void O000000o(AMapGestureListener aMapGestureListener) {
        this.O00000o = aMapGestureListener;
    }

    public boolean O000000o(MotionEvent motionEvent) {
        if (this.O0000o0 < motionEvent.getPointerCount()) {
            this.O0000o0 = motionEvent.getPointerCount();
        }
        if ((motionEvent.getAction() & 255) == 0) {
            this.O0000o0o = false;
            this.O0000o = false;
        }
        if (motionEvent.getAction() == 6 && motionEvent.getPointerCount() > 0) {
            this.O0000o0o = true;
        }
        if (this.O0000o0O && this.O0000o0 >= 2) {
            this.O0000o0O = false;
        }
        try {
            int[] iArr = new int[]{0, 0};
            if (!(this.O000000o == null || this.O000000o.O0000o00() == null)) {
                this.O000000o.O0000o00().getLocationOnScreen(iArr);
            }
            if (this.O00000o != null) {
                if (motionEvent.getAction() == 0) {
                    this.O00000o.onDown(motionEvent.getX(), motionEvent.getY());
                } else if (motionEvent.getAction() == 1) {
                    this.O00000o.onUp(motionEvent.getX(), motionEvent.getY());
                }
            }
            this.O00000o0.onTouchEvent(motionEvent);
            boolean O00000o0 = this.O0000O0o.O00000o0(motionEvent, iArr[0], iArr[1]);
            if (!this.O0000Oo0 || this.O0000o00 <= 0) {
                this.O0000OOo.O00000o0(motionEvent, iArr[0], iArr[1]);
                if (!this.O0000o0O) {
                    this.O00000oO.O000000o(motionEvent);
                    O00000o0 = this.O00000oo.O00000o0(motionEvent, iArr[0], iArr[1]);
                }
            }
            return O00000o0;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public void O00000Oo() {
        if (this.O0000oO0 != null) {
            this.O0000oO0.removeCallbacks(null);
            this.O0000oO0 = null;
        }
    }
}
