package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/* compiled from: AbstractTwoFingerGestureDetector */
public abstract class O000OO00 extends O000OO0o {
    protected float O000000o;
    protected float O00000Oo;
    protected float O00000o;
    protected float O00000o0;
    private final float O0000Ooo;
    private float O0000o = 0.0f;
    private float O0000o0;
    private float O0000o00;
    private float O0000o0O;
    private float O0000o0o;
    private float O0000oO = 0.0f;
    private float O0000oO0 = 0.0f;
    private float O0000oOO = 0.0f;

    public O000OO00(Context context) {
        super(context);
        this.O0000Ooo = (float) ViewConfiguration.get(context).getScaledEdgeSlop();
    }

    protected static float O000000o(MotionEvent motionEvent, int i) {
        return i < motionEvent.getPointerCount() ? motionEvent.getX(i) + (motionEvent.getX() - motionEvent.getRawX()) : 0.0f;
    }

    protected static float O000000o(MotionEvent motionEvent, int i, int i2) {
        return i < motionEvent.getPointerCount() ? motionEvent.getY(i) + ((((float) i2) + motionEvent.getY()) - motionEvent.getRawY()) : 0.0f;
    }

    public PointF O000000o(int i) {
        return i == 0 ? new PointF(this.O0000o, this.O0000oO0) : new PointF(this.O0000oO, this.O0000oOO);
    }

    /* Access modifiers changed, original: protected */
    public void O000000o(MotionEvent motionEvent) {
        super.O000000o(motionEvent);
        MotionEvent motionEvent2 = this.O0000O0o;
        int pointerCount = this.O0000O0o.getPointerCount();
        int pointerCount2 = motionEvent.getPointerCount();
        if (pointerCount2 == 2 && pointerCount2 == pointerCount) {
            this.O0000o0O = -1.0f;
            this.O0000o0o = -1.0f;
            float x = motionEvent2.getX(0);
            float y = motionEvent2.getY(0);
            float x2 = motionEvent2.getX(1);
            float y2 = motionEvent2.getY(1);
            float f = y2 - y;
            this.O000000o = x2 - x;
            this.O00000Oo = f;
            float x3 = motionEvent.getX(0);
            float y3 = motionEvent.getY(0);
            f = motionEvent.getX(1);
            float y4 = motionEvent.getY(1);
            float f2 = y4 - y3;
            this.O00000o0 = f - x3;
            this.O00000o = f2;
            this.O0000o = x3 - x;
            this.O0000oO0 = y3 - y;
            this.O0000oO = f - x2;
            this.O0000oOO = y4 - y2;
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean O00000Oo(MotionEvent motionEvent, int i, int i2) {
        DisplayMetrics displayMetrics = this.O00000oO.getResources().getDisplayMetrics();
        this.O0000o00 = ((float) displayMetrics.widthPixels) - this.O0000Ooo;
        this.O0000o0 = ((float) displayMetrics.heightPixels) - this.O0000Ooo;
        float f = this.O0000Ooo;
        float f2 = this.O0000o00;
        float f3 = this.O0000o0;
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float O000000o = O000000o(motionEvent, 1);
        float O000000o2 = O000000o(motionEvent, 1, i2);
        boolean z = rawX < f || rawY < f || rawX > f2 || rawY > f3;
        boolean z2 = O000000o < f || O000000o2 < f || O000000o > f2 || O000000o2 > f3;
        return (z && z2) || z || z2;
    }
}
