package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.view.MotionEvent;

/* compiled from: BaseGestureDetector */
public abstract class O000OO0o {
    protected final Context O00000oO;
    protected boolean O00000oo;
    protected MotionEvent O0000O0o;
    protected MotionEvent O0000OOo;
    protected float O0000Oo;
    protected float O0000Oo0;
    protected long O0000OoO;

    public O000OO0o(Context context) {
        this.O00000oO = context;
    }

    public static PointF O00000Oo(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        float f = 0.0f;
        float f2 = 0.0f;
        for (int i = 0; i < pointerCount; i++) {
            f += motionEvent.getX(i);
            f2 += motionEvent.getY(i);
        }
        float f3 = (float) pointerCount;
        return new PointF(f / f3, f2 / f3);
    }

    /* Access modifiers changed, original: protected */
    public void O000000o() {
        if (this.O0000O0o != null) {
            this.O0000O0o.recycle();
            this.O0000O0o = null;
        }
        if (this.O0000OOo != null) {
            this.O0000OOo.recycle();
            this.O0000OOo = null;
        }
        this.O00000oo = false;
    }

    public abstract void O000000o(int i, MotionEvent motionEvent);

    public abstract void O000000o(int i, MotionEvent motionEvent, int i2, int i3);

    /* Access modifiers changed, original: protected */
    public void O000000o(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = this.O0000O0o;
        if (this.O0000OOo != null) {
            this.O0000OOo.recycle();
            this.O0000OOo = null;
        }
        this.O0000OOo = MotionEvent.obtain(motionEvent);
        this.O0000OoO = motionEvent.getEventTime() - motionEvent2.getEventTime();
        if (VERSION.SDK_INT >= 8) {
            this.O0000Oo0 = motionEvent.getPressure(motionEvent.getActionIndex());
            this.O0000Oo = motionEvent2.getPressure(motionEvent2.getActionIndex());
            return;
        }
        this.O0000Oo0 = motionEvent.getPressure(0);
        this.O0000Oo = motionEvent2.getPressure(0);
    }

    public long O00000Oo() {
        return this.O0000OoO;
    }

    public MotionEvent O00000o0() {
        return this.O0000OOo;
    }

    public boolean O00000o0(MotionEvent motionEvent, int i, int i2) {
        int action = motionEvent.getAction() & 255;
        if (this.O00000oo) {
            O000000o(action, motionEvent);
        } else {
            O000000o(action, motionEvent, i, i2);
        }
        return true;
    }
}
