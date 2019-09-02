package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

/* compiled from: HoverGestureDetectorAbstract */
public class O000OO extends O000OO00 {
    private static final PointF O0000Ooo = new PointF();
    private PointF O0000o = new PointF();
    private boolean O0000o0;
    private final O000000o O0000o00;
    private PointF O0000o0O;
    private PointF O0000o0o;
    private PointF O0000oO0 = new PointF();

    /* compiled from: HoverGestureDetectorAbstract */
    public interface O000000o {
        boolean O000000o(O000OO o000oo);

        boolean O00000Oo(O000OO o000oo);

        void O00000o0(O000OO o000oo);
    }

    public O000OO(Context context, O000000o o000000o) {
        super(context);
        this.O0000o00 = o000000o;
    }

    /* Access modifiers changed, original: protected */
    public void O000000o() {
        super.O000000o();
        this.O0000o0 = false;
    }

    /* Access modifiers changed, original: protected */
    public void O000000o(int i, MotionEvent motionEvent) {
        if (i != 6) {
            switch (i) {
                case 2:
                    O000000o(motionEvent);
                    if (this.O0000Oo0 / this.O0000Oo > 0.67f && this.O0000o00.O000000o(this)) {
                        this.O0000O0o.recycle();
                        this.O0000O0o = MotionEvent.obtain(motionEvent);
                        return;
                    }
                    return;
                case 3:
                    if (!this.O0000o0) {
                        this.O0000o00.O00000o0(this);
                    }
                    O000000o();
                    return;
                default:
                    return;
            }
        }
        O000000o(motionEvent);
        if (!this.O0000o0) {
            this.O0000o00.O00000o0(this);
        }
        O000000o();
    }

    /* Access modifiers changed, original: protected */
    public void O000000o(int i, MotionEvent motionEvent, int i2, int i3) {
        if (i != 2) {
            switch (i) {
                case 5:
                    O000000o();
                    this.O0000O0o = MotionEvent.obtain(motionEvent);
                    this.O0000OoO = 0;
                    O000000o(motionEvent);
                    this.O0000o0 = O00000Oo(motionEvent, i2, i3);
                    if (!this.O0000o0) {
                        this.O00000oo = this.O0000o00.O00000Oo(this);
                        return;
                    }
                    return;
                case 6:
                    boolean z = this.O0000o0;
                    return;
                default:
                    return;
            }
        } else if (this.O0000o0) {
            this.O0000o0 = O00000Oo(motionEvent, i2, i3);
            if (!this.O0000o0) {
                this.O00000oo = this.O0000o00.O00000Oo(this);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void O000000o(MotionEvent motionEvent) {
        super.O000000o(motionEvent);
        MotionEvent motionEvent2 = this.O0000O0o;
        this.O0000o0O = O000OO0o.O00000Oo(motionEvent);
        this.O0000o0o = O000OO0o.O00000Oo(motionEvent2);
        this.O0000oO0 = (this.O0000O0o.getPointerCount() != motionEvent.getPointerCount() ? 1 : null) != null ? O0000Ooo : new PointF(this.O0000o0O.x - this.O0000o0o.x, this.O0000o0O.y - this.O0000o0o.y);
        PointF pointF = this.O0000o;
        pointF.x += this.O0000oO0.x;
        pointF = this.O0000o;
        pointF.y += this.O0000oO0.y;
    }

    public PointF O00000o() {
        return this.O0000oO0;
    }
}
