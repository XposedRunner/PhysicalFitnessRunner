package com.amap.api.mapcore.util;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/* compiled from: ScaleGestureDetector */
public class O000OOo0 {
    private final Context O000000o;
    private final O000000o O00000Oo;
    private MotionEvent O00000o;
    private boolean O00000o0;
    private MotionEvent O00000oO;
    private float O00000oo;
    private float O0000O0o;
    private float O0000OOo;
    private float O0000Oo;
    private float O0000Oo0;
    private float O0000OoO;
    private float O0000Ooo;
    private long O0000o;
    private float O0000o0;
    private float O0000o00;
    private float O0000o0O;
    private float O0000o0o;
    private float O0000oO;
    private final float O0000oO0;
    private float O0000oOO;
    private boolean O0000oOo;
    private int O0000oo;
    private boolean O0000oo0;
    private int O0000ooO;
    private boolean O0000ooo;

    /* compiled from: ScaleGestureDetector */
    public interface O000000o {
        boolean O000000o(O000OOo0 o000OOo0);

        boolean O00000Oo(O000OOo0 o000OOo0);

        void O00000o0(O000OOo0 o000OOo0);
    }

    public O000OOo0(Context context, O000000o o000000o) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.O000000o = context;
        this.O00000Oo = o000000o;
        this.O0000oO0 = (float) viewConfiguration.getScaledEdgeSlop();
    }

    private static float O000000o(MotionEvent motionEvent, int i) {
        if (i < 0) {
            return Float.MIN_VALUE;
        }
        if (i == 0) {
            return motionEvent.getRawX();
        }
        return motionEvent.getX(i) + (motionEvent.getRawX() - motionEvent.getX());
    }

    private int O000000o(MotionEvent motionEvent, int i, int i2) {
        int pointerCount = motionEvent.getPointerCount();
        i = motionEvent.findPointerIndex(i);
        int i3 = 0;
        while (i3 < pointerCount) {
            if (!(i3 == i2 || i3 == i)) {
                float f = this.O0000oO0;
                float f2 = this.O0000oO;
                float f3 = this.O0000oOO;
                float O000000o = O000000o(motionEvent, i3);
                float O00000Oo = O00000Oo(motionEvent, i3);
                if (O000000o >= f && O00000Oo >= f && O000000o <= f2 && O00000Oo <= f3) {
                    return i3;
                }
            }
            i3++;
        }
        return -1;
    }

    private static float O00000Oo(MotionEvent motionEvent, int i) {
        if (i < 0) {
            return Float.MIN_VALUE;
        }
        if (i == 0) {
            return motionEvent.getRawY();
        }
        return motionEvent.getY(i) + (motionEvent.getRawY() - motionEvent.getY());
    }

    private void O00000Oo(MotionEvent motionEvent) {
        if (this.O00000oO != null) {
            this.O00000oO.recycle();
        }
        this.O00000oO = MotionEvent.obtain(motionEvent);
        this.O0000Ooo = -1.0f;
        this.O0000o00 = -1.0f;
        this.O0000o0 = -1.0f;
        MotionEvent motionEvent2 = this.O00000o;
        int findPointerIndex = motionEvent2.findPointerIndex(this.O0000oo);
        int findPointerIndex2 = motionEvent2.findPointerIndex(this.O0000ooO);
        int findPointerIndex3 = motionEvent.findPointerIndex(this.O0000oo);
        int findPointerIndex4 = motionEvent.findPointerIndex(this.O0000ooO);
        if (findPointerIndex < 0 || findPointerIndex2 < 0 || findPointerIndex3 < 0 || findPointerIndex4 < 0) {
            this.O0000oo0 = true;
            if (this.O00000o0) {
                this.O00000Oo.O00000o0(this);
            }
            return;
        }
        float x = motionEvent2.getX(findPointerIndex);
        float y = motionEvent2.getY(findPointerIndex);
        float x2 = motionEvent2.getX(findPointerIndex2);
        float y2 = motionEvent2.getY(findPointerIndex2);
        float x3 = motionEvent.getX(findPointerIndex3);
        float y3 = motionEvent.getY(findPointerIndex3);
        y2 -= y;
        float x4 = motionEvent.getX(findPointerIndex4) - x3;
        float y4 = motionEvent.getY(findPointerIndex4) - y3;
        this.O0000OOo = x2 - x;
        this.O0000Oo0 = y2;
        this.O0000Oo = x4;
        this.O0000OoO = y4;
        this.O00000oo = x3 + (x4 * 0.5f);
        this.O0000O0o = y3 + (y4 * 0.5f);
        this.O0000o = motionEvent.getEventTime() - motionEvent2.getEventTime();
        this.O0000o0O = motionEvent.getPressure(findPointerIndex3) + motionEvent.getPressure(findPointerIndex4);
        this.O0000o0o = motionEvent2.getPressure(findPointerIndex) + motionEvent2.getPressure(findPointerIndex2);
    }

    private void O0000Ooo() {
        if (this.O00000o != null) {
            this.O00000o.recycle();
            this.O00000o = null;
        }
        if (this.O00000oO != null) {
            this.O00000oO.recycle();
            this.O00000oO = null;
        }
        this.O0000oOo = false;
        this.O00000o0 = false;
        this.O0000oo = -1;
        this.O0000ooO = -1;
        this.O0000oo0 = false;
    }

    public MotionEvent O000000o() {
        return this.O00000oO;
    }

    /* JADX WARNING: Removed duplicated region for block: B:119:0x021d  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x020f  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x01ec  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0205 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x020f  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x021d  */
    public boolean O000000o(android.view.MotionEvent r14) {
        /*
        r13 = this;
        r0 = r14.getAction();
        r0 = r0 & 255;
        if (r0 != 0) goto L_0x000b;
    L_0x0008:
        r13.O0000Ooo();
    L_0x000b:
        r1 = r13.O0000oo0;
        r2 = 1;
        r3 = 0;
        if (r1 == 0) goto L_0x0014;
    L_0x0011:
        r2 = r3;
        goto L_0x0381;
    L_0x0014:
        r1 = r13.O00000o0;
        r4 = 2;
        r5 = -1;
        r6 = 8;
        if (r1 != 0) goto L_0x0248;
    L_0x001c:
        r1 = -1082130432; // 0xffffffffbf800000 float:-1.0 double:NaN;
        switch(r0) {
            case 0: goto L_0x023e;
            case 1: goto L_0x0239;
            case 2: goto L_0x0183;
            case 3: goto L_0x0021;
            case 4: goto L_0x0021;
            case 5: goto L_0x0096;
            case 6: goto L_0x0023;
            default: goto L_0x0021;
        };
    L_0x0021:
        goto L_0x0381;
    L_0x0023:
        r0 = r13.O0000oOo;
        if (r0 == 0) goto L_0x0381;
    L_0x0027:
        r0 = r14.getPointerCount();
        r1 = android.os.Build.VERSION.SDK_INT;
        if (r1 < r6) goto L_0x0034;
    L_0x002f:
        r1 = r14.getActionIndex();
        goto L_0x0035;
    L_0x0034:
        r1 = r3;
    L_0x0035:
        r6 = r14.getPointerId(r1);
        if (r0 <= r4) goto L_0x0063;
    L_0x003b:
        r0 = r13.O0000oo;
        if (r6 != r0) goto L_0x004f;
    L_0x003f:
        r0 = r13.O0000ooO;
        r0 = r13.O000000o(r14, r0, r1);
        if (r0 < 0) goto L_0x0381;
    L_0x0047:
        r14 = r14.getPointerId(r0);
        r13.O0000oo = r14;
        goto L_0x0381;
    L_0x004f:
        r0 = r13.O0000ooO;
        if (r6 != r0) goto L_0x0381;
    L_0x0053:
        r0 = r13.O0000oo;
        r0 = r13.O000000o(r14, r0, r1);
        if (r0 < 0) goto L_0x0381;
    L_0x005b:
        r14 = r14.getPointerId(r0);
        r13.O0000ooO = r14;
        goto L_0x0381;
    L_0x0063:
        r0 = r13.O0000oo;
        if (r6 != r0) goto L_0x006a;
    L_0x0067:
        r0 = r13.O0000ooO;
        goto L_0x006c;
    L_0x006a:
        r0 = r13.O0000oo;
    L_0x006c:
        r0 = r14.findPointerIndex(r0);
        if (r0 >= 0) goto L_0x007e;
    L_0x0072:
        r13.O0000oo0 = r2;
        r14 = r13.O00000o0;
        if (r14 == 0) goto L_0x007d;
    L_0x0078:
        r14 = r13.O00000Oo;
        r14.O00000o0(r13);
    L_0x007d:
        return r3;
    L_0x007e:
        r1 = r14.getPointerId(r0);
        r13.O0000oo = r1;
        r13.O0000ooo = r2;
        r13.O0000ooO = r5;
        r1 = r14.getX(r0);
        r13.O00000oo = r1;
        r14 = r14.getY(r0);
        r13.O0000O0o = r14;
        goto L_0x0381;
    L_0x0096:
        r0 = r13.O000000o;
        r0 = r0.getResources();
        r0 = r0.getDisplayMetrics();
        r4 = r0.widthPixels;
        r4 = (float) r4;
        r7 = r13.O0000oO0;
        r4 = r4 - r7;
        r13.O0000oO = r4;
        r0 = r0.heightPixels;
        r0 = (float) r0;
        r4 = r13.O0000oO0;
        r0 = r0 - r4;
        r13.O0000oOO = r0;
        r0 = r13.O00000o;
        if (r0 == 0) goto L_0x00b9;
    L_0x00b4:
        r0 = r13.O00000o;
        r0.recycle();
    L_0x00b9:
        r0 = android.view.MotionEvent.obtain(r14);
        r13.O00000o = r0;
        r7 = 0;
        r13.O0000o = r7;
        r0 = android.os.Build.VERSION.SDK_INT;
        if (r0 < r6) goto L_0x00eb;
    L_0x00c7:
        r0 = r14.getActionIndex();
        r4 = r13.O0000oo;
        r4 = r14.findPointerIndex(r4);
        r6 = r14.getPointerId(r0);
        r13.O0000ooO = r6;
        if (r4 < 0) goto L_0x00db;
    L_0x00d9:
        if (r4 != r0) goto L_0x0104;
    L_0x00db:
        if (r4 != r0) goto L_0x00de;
    L_0x00dd:
        goto L_0x00e0;
    L_0x00de:
        r5 = r13.O0000ooO;
    L_0x00e0:
        r4 = r13.O000000o(r14, r5, r4);
        r5 = r14.getPointerId(r4);
        r13.O0000oo = r5;
        goto L_0x0104;
    L_0x00eb:
        r0 = r14.getPointerCount();
        if (r0 <= 0) goto L_0x0102;
    L_0x00f1:
        r0 = r14.findPointerIndex(r2);
        r4 = r13.O0000oo;
        r4 = r14.findPointerIndex(r4);
        r5 = r14.getPointerId(r0);
        r13.O0000ooO = r5;
        goto L_0x0104;
    L_0x0102:
        r0 = r3;
        r4 = r0;
    L_0x0104:
        r13.O0000ooo = r3;
        r13.O00000Oo(r14);
        r5 = r13.O0000oO0;
        r6 = r13.O0000oO;
        r7 = r13.O0000oOO;
        r8 = O000000o(r14, r4);
        r9 = O00000Oo(r14, r4);
        r10 = O000000o(r14, r0);
        r11 = O00000Oo(r14, r0);
        r12 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1));
        if (r12 < 0) goto L_0x0132;
    L_0x0123:
        r12 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1));
        if (r12 < 0) goto L_0x0132;
    L_0x0127:
        r8 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1));
        if (r8 > 0) goto L_0x0132;
    L_0x012b:
        r8 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1));
        if (r8 <= 0) goto L_0x0130;
    L_0x012f:
        goto L_0x0132;
    L_0x0130:
        r8 = r3;
        goto L_0x0133;
    L_0x0132:
        r8 = r2;
    L_0x0133:
        r9 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1));
        if (r9 < 0) goto L_0x0146;
    L_0x0137:
        r5 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1));
        if (r5 < 0) goto L_0x0146;
    L_0x013b:
        r5 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1));
        if (r5 > 0) goto L_0x0146;
    L_0x013f:
        r5 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1));
        if (r5 <= 0) goto L_0x0144;
    L_0x0143:
        goto L_0x0146;
    L_0x0144:
        r5 = r3;
        goto L_0x0147;
    L_0x0146:
        r5 = r2;
    L_0x0147:
        if (r8 == 0) goto L_0x0153;
    L_0x0149:
        if (r5 == 0) goto L_0x0153;
    L_0x014b:
        r13.O00000oo = r1;
        r13.O0000O0o = r1;
        r13.O0000oOo = r2;
        goto L_0x0381;
    L_0x0153:
        if (r8 == 0) goto L_0x0165;
    L_0x0155:
        r1 = r14.getX(r0);
        r13.O00000oo = r1;
        r14 = r14.getY(r0);
        r13.O0000O0o = r14;
        r13.O0000oOo = r2;
        goto L_0x0381;
    L_0x0165:
        if (r5 == 0) goto L_0x0177;
    L_0x0167:
        r0 = r14.getX(r4);
        r13.O00000oo = r0;
        r14 = r14.getY(r4);
        r13.O0000O0o = r14;
        r13.O0000oOo = r2;
        goto L_0x0381;
    L_0x0177:
        r13.O0000oOo = r3;
        r14 = r13.O00000Oo;
        r14 = r14.O00000Oo(r13);
        r13.O00000o0 = r14;
        goto L_0x0381;
    L_0x0183:
        r0 = r13.O0000oOo;
        if (r0 == 0) goto L_0x0381;
    L_0x0187:
        r0 = r13.O0000oO0;
        r4 = r13.O0000oO;
        r5 = r13.O0000oOO;
        r6 = r13.O0000oo;
        r6 = r14.findPointerIndex(r6);
        r7 = r13.O0000ooO;
        r7 = r14.findPointerIndex(r7);
        r8 = O000000o(r14, r6);
        r9 = O00000Oo(r14, r6);
        r10 = O000000o(r14, r7);
        r11 = O00000Oo(r14, r7);
        r12 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1));
        if (r12 < 0) goto L_0x01bc;
    L_0x01ad:
        r12 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1));
        if (r12 < 0) goto L_0x01bc;
    L_0x01b1:
        r8 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1));
        if (r8 > 0) goto L_0x01bc;
    L_0x01b5:
        r8 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1));
        if (r8 <= 0) goto L_0x01ba;
    L_0x01b9:
        goto L_0x01bc;
    L_0x01ba:
        r8 = r3;
        goto L_0x01bd;
    L_0x01bc:
        r8 = r2;
    L_0x01bd:
        r9 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1));
        if (r9 < 0) goto L_0x01d0;
    L_0x01c1:
        r0 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1));
        if (r0 < 0) goto L_0x01d0;
    L_0x01c5:
        r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1));
        if (r0 > 0) goto L_0x01d0;
    L_0x01c9:
        r0 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1));
        if (r0 <= 0) goto L_0x01ce;
    L_0x01cd:
        goto L_0x01d0;
    L_0x01ce:
        r0 = r3;
        goto L_0x01d1;
    L_0x01d0:
        r0 = r2;
    L_0x01d1:
        if (r8 == 0) goto L_0x01e9;
    L_0x01d3:
        r4 = r13.O0000ooO;
        r4 = r13.O000000o(r14, r4, r6);
        if (r4 < 0) goto L_0x01e9;
    L_0x01db:
        r5 = r14.getPointerId(r4);
        r13.O0000oo = r5;
        O000000o(r14, r4);
        O00000Oo(r14, r4);
        r8 = r3;
        goto L_0x01ea;
    L_0x01e9:
        r4 = r6;
    L_0x01ea:
        if (r0 == 0) goto L_0x0202;
    L_0x01ec:
        r5 = r13.O0000oo;
        r5 = r13.O000000o(r14, r5, r7);
        if (r5 < 0) goto L_0x0202;
    L_0x01f4:
        r0 = r14.getPointerId(r5);
        r13.O0000ooO = r0;
        O000000o(r14, r5);
        O00000Oo(r14, r5);
        r0 = r3;
        goto L_0x0203;
    L_0x0202:
        r5 = r7;
    L_0x0203:
        if (r8 == 0) goto L_0x020d;
    L_0x0205:
        if (r0 == 0) goto L_0x020d;
    L_0x0207:
        r13.O00000oo = r1;
        r13.O0000O0o = r1;
        goto L_0x0381;
    L_0x020d:
        if (r8 == 0) goto L_0x021d;
    L_0x020f:
        r0 = r14.getX(r5);
        r13.O00000oo = r0;
        r14 = r14.getY(r5);
        r13.O0000O0o = r14;
        goto L_0x0381;
    L_0x021d:
        if (r0 == 0) goto L_0x022d;
    L_0x021f:
        r0 = r14.getX(r4);
        r13.O00000oo = r0;
        r14 = r14.getY(r4);
        r13.O0000O0o = r14;
        goto L_0x0381;
    L_0x022d:
        r13.O0000oOo = r3;
        r14 = r13.O00000Oo;
        r14 = r14.O00000Oo(r13);
        r13.O00000o0 = r14;
        goto L_0x0381;
    L_0x0239:
        r13.O0000Ooo();
        goto L_0x0381;
    L_0x023e:
        r14 = r14.getPointerId(r3);
        r13.O0000oo = r14;
        r13.O0000ooo = r2;
        goto L_0x0381;
    L_0x0248:
        switch(r0) {
            case 1: goto L_0x037e;
            case 2: goto L_0x035b;
            case 3: goto L_0x0352;
            case 4: goto L_0x024b;
            case 5: goto L_0x02f4;
            case 6: goto L_0x024d;
            default: goto L_0x024b;
        };
    L_0x024b:
        goto L_0x0381;
    L_0x024d:
        r0 = r14.getPointerCount();
        r1 = android.os.Build.VERSION.SDK_INT;
        if (r1 < r6) goto L_0x025a;
    L_0x0255:
        r1 = r14.getActionIndex();
        goto L_0x025b;
    L_0x025a:
        r1 = r3;
    L_0x025b:
        r5 = r14.getPointerId(r1);
        if (r0 <= r4) goto L_0x02c7;
    L_0x0261:
        r0 = r13.O0000oo;
        if (r5 != r0) goto L_0x028c;
    L_0x0265:
        r0 = r13.O0000ooO;
        r0 = r13.O000000o(r14, r0, r1);
        if (r0 < 0) goto L_0x02b7;
    L_0x026d:
        r1 = r13.O00000Oo;
        r1.O00000o0(r13);
        r0 = r14.getPointerId(r0);
        r13.O0000oo = r0;
        r13.O0000ooo = r2;
        r0 = android.view.MotionEvent.obtain(r14);
        r13.O00000o = r0;
        r13.O00000Oo(r14);
        r0 = r13.O00000Oo;
        r0 = r0.O00000Oo(r13);
        r13.O00000o0 = r0;
        goto L_0x02b8;
    L_0x028c:
        r0 = r13.O0000ooO;
        if (r5 != r0) goto L_0x02b8;
    L_0x0290:
        r0 = r13.O0000oo;
        r0 = r13.O000000o(r14, r0, r1);
        if (r0 < 0) goto L_0x02b7;
    L_0x0298:
        r1 = r13.O00000Oo;
        r1.O00000o0(r13);
        r0 = r14.getPointerId(r0);
        r13.O0000ooO = r0;
        r13.O0000ooo = r3;
        r0 = android.view.MotionEvent.obtain(r14);
        r13.O00000o = r0;
        r13.O00000Oo(r14);
        r0 = r13.O00000Oo;
        r0 = r0.O00000Oo(r13);
        r13.O00000o0 = r0;
        goto L_0x02b8;
    L_0x02b7:
        r3 = r2;
    L_0x02b8:
        r0 = r13.O00000o;
        r0.recycle();
        r0 = android.view.MotionEvent.obtain(r14);
        r13.O00000o = r0;
        r13.O00000Oo(r14);
        goto L_0x02c8;
    L_0x02c7:
        r3 = r2;
    L_0x02c8:
        if (r3 == 0) goto L_0x0381;
    L_0x02ca:
        r13.O00000Oo(r14);
        r0 = r13.O0000oo;
        if (r5 != r0) goto L_0x02d4;
    L_0x02d1:
        r0 = r13.O0000ooO;
        goto L_0x02d6;
    L_0x02d4:
        r0 = r13.O0000oo;
    L_0x02d6:
        r1 = r14.findPointerIndex(r0);
        r3 = r14.getX(r1);
        r13.O00000oo = r3;
        r14 = r14.getY(r1);
        r13.O0000O0o = r14;
        r14 = r13.O00000Oo;
        r14.O00000o0(r13);
        r13.O0000Ooo();
        r13.O0000oo = r0;
        r13.O0000ooo = r2;
        goto L_0x0381;
    L_0x02f4:
        r0 = r13.O00000Oo;
        r0.O00000o0(r13);
        r0 = r13.O0000oo;
        r1 = r13.O0000ooO;
        r13.O0000Ooo();
        r4 = android.view.MotionEvent.obtain(r14);
        r13.O00000o = r4;
        r4 = r13.O0000ooo;
        if (r4 == 0) goto L_0x030b;
    L_0x030a:
        goto L_0x030c;
    L_0x030b:
        r0 = r1;
    L_0x030c:
        r13.O0000oo = r0;
        r0 = android.os.Build.VERSION.SDK_INT;
        if (r0 < r6) goto L_0x031d;
    L_0x0312:
        r0 = r14.getActionIndex();
        r0 = r14.getPointerId(r0);
        r13.O0000ooO = r0;
        goto L_0x0323;
    L_0x031d:
        r0 = r14.getPointerId(r2);
        r13.O0000ooO = r0;
    L_0x0323:
        r13.O0000ooo = r3;
        r0 = r13.O0000oo;
        r0 = r14.findPointerIndex(r0);
        if (r0 < 0) goto L_0x0333;
    L_0x032d:
        r1 = r13.O0000oo;
        r3 = r13.O0000ooO;
        if (r1 != r3) goto L_0x0346;
    L_0x0333:
        r1 = r13.O0000oo;
        r3 = r13.O0000ooO;
        if (r1 != r3) goto L_0x033a;
    L_0x0339:
        goto L_0x033c;
    L_0x033a:
        r5 = r13.O0000ooO;
    L_0x033c:
        r0 = r13.O000000o(r14, r5, r0);
        r0 = r14.getPointerId(r0);
        r13.O0000oo = r0;
    L_0x0346:
        r13.O00000Oo(r14);
        r14 = r13.O00000Oo;
        r14 = r14.O00000Oo(r13);
        r13.O00000o0 = r14;
        goto L_0x0381;
    L_0x0352:
        r14 = r13.O00000Oo;
        r14.O00000o0(r13);
        r13.O0000Ooo();
        goto L_0x0381;
    L_0x035b:
        r13.O00000Oo(r14);
        r0 = r13.O0000o0O;
        r1 = r13.O0000o0o;
        r0 = r0 / r1;
        r1 = 1059816735; // 0x3f2b851f float:0.67 double:5.236190397E-315;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 <= 0) goto L_0x0381;
    L_0x036a:
        r0 = r13.O00000Oo;
        r0 = r0.O000000o(r13);
        if (r0 == 0) goto L_0x0381;
    L_0x0372:
        r0 = r13.O00000o;
        r0.recycle();
        r14 = android.view.MotionEvent.obtain(r14);
        r13.O00000o = r14;
        goto L_0x0381;
    L_0x037e:
        r13.O0000Ooo();
    L_0x0381:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.O000OOo0.O000000o(android.view.MotionEvent):boolean");
    }

    public float O00000Oo() {
        return this.O00000oo;
    }

    public float O00000o() {
        if (this.O0000Ooo == -1.0f) {
            float f = this.O0000Oo;
            float f2 = this.O0000OoO;
            this.O0000Ooo = (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
        }
        return this.O0000Ooo;
    }

    public float O00000o0() {
        return this.O0000O0o;
    }

    public float O00000oO() {
        return this.O0000Oo;
    }

    public float O00000oo() {
        return this.O0000OoO;
    }

    public float O0000O0o() {
        if (this.O0000o00 == -1.0f) {
            float f = this.O0000OOo;
            float f2 = this.O0000Oo0;
            this.O0000o00 = (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
        }
        return this.O0000o00;
    }

    public float O0000OOo() {
        return this.O0000OOo;
    }

    public float O0000Oo() {
        if (this.O0000o0 == -1.0f) {
            this.O0000o0 = O00000o() / O0000O0o();
        }
        return this.O0000o0;
    }

    public float O0000Oo0() {
        return this.O0000Oo0;
    }

    public long O0000OoO() {
        return this.O0000o;
    }
}
