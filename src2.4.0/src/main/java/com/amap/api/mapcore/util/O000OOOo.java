package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

/* compiled from: MoveGestureDetector */
public class O000OOOo extends O000OO0o {
    private static final PointF O000000o = new PointF();
    private final O000000o O00000Oo;
    private PointF O00000o;
    private PointF O00000o0;
    private PointF O0000Ooo = new PointF();
    private PointF O0000o00 = new PointF();

    /* compiled from: MoveGestureDetector */
    public interface O000000o {
        boolean O000000o(O000OOOo o000OOOo);

        boolean O00000Oo(O000OOOo o000OOOo);

        void O00000o0(O000OOOo o000OOOo);
    }

    public O000OOOo(Context context, O000000o o000000o) {
        super(context);
        this.O00000Oo = o000000o;
    }

    /* Access modifiers changed, original: protected */
    public void O000000o(int i, MotionEvent motionEvent) {
        switch (i) {
            case 1:
            case 3:
                this.O00000Oo.O00000o0(this);
                O000000o();
                break;
            case 2:
                O000000o(motionEvent);
                if (this.O0000Oo0 / this.O0000Oo > 0.67f && motionEvent.getPointerCount() <= 1 && this.O00000Oo.O000000o(this)) {
                    this.O0000O0o.recycle();
                    this.O0000O0o = MotionEvent.obtain(motionEvent);
                    break;
                }
        }
    }

    /* Access modifiers changed, original: protected */
    public void O000000o(int i, MotionEvent motionEvent, int i2, int i3) {
        if (i == 0) {
            O000000o();
            this.O0000O0o = MotionEvent.obtain(motionEvent);
            this.O0000OoO = 0;
            O000000o(motionEvent);
        } else if (i == 2) {
            this.O00000oo = this.O00000Oo.O00000Oo(this);
        } else if (i == 5) {
            if (this.O0000O0o != null) {
                this.O0000O0o.recycle();
            }
            this.O0000O0o = MotionEvent.obtain(motionEvent);
            O000000o(motionEvent);
        }
    }

    /* Access modifiers changed, original: protected */
    public void O000000o(MotionEvent motionEvent) {
        super.O000000o(motionEvent);
        MotionEvent motionEvent2 = this.O0000O0o;
        this.O00000o0 = O000OO0o.O00000Oo(motionEvent);
        this.O00000o = O000OO0o.O00000Oo(motionEvent2);
        Object obj = this.O0000O0o.getPointerCount() != motionEvent.getPointerCount() ? 1 : null;
        this.O0000o00 = obj != null ? O000000o : new PointF(this.O00000o0.x - this.O00000o.x, this.O00000o0.y - this.O00000o.y);
        if (obj != null) {
            this.O0000O0o.recycle();
            this.O0000O0o = MotionEvent.obtain(motionEvent);
        }
        PointF pointF = this.O0000Ooo;
        pointF.x += this.O0000o00.x;
        pointF = this.O0000Ooo;
        pointF.y += this.O0000o00.y;
    }

    public PointF O00000o() {
        return this.O0000o00;
    }
}
