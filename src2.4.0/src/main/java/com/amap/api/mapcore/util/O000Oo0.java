package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

/* compiled from: ZoomOutGestureDetectorAbstract */
public class O000Oo0 extends O000OO00 {
    private static final PointF O0000o0 = new PointF();
    private final O000000o O0000Ooo;
    private PointF O0000o = new PointF();
    private boolean O0000o00;
    private PointF O0000o0O;
    private PointF O0000o0o;
    private PointF O0000oO0 = new PointF();

    /* compiled from: ZoomOutGestureDetectorAbstract */
    public interface O000000o {
        boolean O000000o(O000Oo0 o000Oo0);

        void O00000Oo(O000Oo0 o000Oo0);
    }

    /* compiled from: ZoomOutGestureDetectorAbstract */
    public static class O00000Oo implements O000000o {
        public boolean O000000o(O000Oo0 o000Oo0) {
            return true;
        }

        public void O00000Oo(O000Oo0 o000Oo0) {
        }
    }

    public O000Oo0(Context context, O000000o o000000o) {
        super(context);
        this.O0000Ooo = o000000o;
    }

    /* Access modifiers changed, original: protected */
    public void O000000o() {
        super.O000000o();
        this.O0000o00 = false;
        this.O0000o.x = 0.0f;
        this.O0000oO0.x = 0.0f;
        this.O0000o.y = 0.0f;
        this.O0000oO0.y = 0.0f;
    }

    /* Access modifiers changed, original: protected */
    public void O000000o(int i, MotionEvent motionEvent) {
        if (i == 3) {
            O000000o();
        } else if (i == 6) {
            O000000o(motionEvent);
            if (!this.O0000o00) {
                this.O0000Ooo.O00000Oo(this);
            }
            O000000o();
        }
    }

    /* Access modifiers changed, original: protected */
    public void O000000o(int i, MotionEvent motionEvent, int i2, int i3) {
        if (i == 5) {
            O000000o();
            this.O0000O0o = MotionEvent.obtain(motionEvent);
            this.O0000OoO = 0;
            O000000o(motionEvent);
            this.O0000o00 = O00000Oo(motionEvent, i2, i3);
            if (!this.O0000o00) {
                this.O00000oo = this.O0000Ooo.O000000o(this);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void O000000o(MotionEvent motionEvent) {
        super.O000000o(motionEvent);
        MotionEvent motionEvent2 = this.O0000O0o;
        this.O0000o0O = O000OO0o.O00000Oo(motionEvent);
        this.O0000o0o = O000OO0o.O00000Oo(motionEvent2);
        this.O0000oO0 = (this.O0000O0o.getPointerCount() != motionEvent.getPointerCount() ? 1 : null) != null ? O0000o0 : new PointF(this.O0000o0O.x - this.O0000o0o.x, this.O0000o0O.y - this.O0000o0o.y);
        PointF pointF = this.O0000o;
        pointF.x += this.O0000oO0.x;
        pointF = this.O0000o;
        pointF.y += this.O0000oO0.y;
    }

    public float O00000o() {
        return this.O0000o.x;
    }

    public float O00000oO() {
        return this.O0000o.y;
    }
}
