package com.zjwh.android_wh_physicalfitness.view.photoview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* compiled from: CustomGestureDetector */
class O00000Oo {
    private static final int O000000o = -1;
    private int O00000Oo = -1;
    private final ScaleGestureDetector O00000o;
    private int O00000o0 = 0;
    private VelocityTracker O00000oO;
    private boolean O00000oo;
    private float O0000O0o;
    private float O0000OOo;
    private final float O0000Oo;
    private final float O0000Oo0;
    private O00000o0 O0000OoO;

    O00000Oo(Context context, O00000o0 o00000o0) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.O0000Oo = (float) viewConfiguration.getScaledMinimumFlingVelocity();
        this.O0000Oo0 = (float) viewConfiguration.getScaledTouchSlop();
        this.O0000OoO = o00000o0;
        this.O00000o = new ScaleGestureDetector(context, new OnScaleGestureListener() {
            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                    return false;
                }
                O00000Oo.this.O0000OoO.O000000o(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                return true;
            }

            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                return true;
            }

            public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            }
        });
    }

    private float O00000Oo(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.O00000o0);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    private boolean O00000o(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int i = 0;
        if (action != 6) {
            float xVelocity;
            float yVelocity;
            switch (action) {
                case 0:
                    this.O00000Oo = motionEvent.getPointerId(0);
                    this.O00000oO = VelocityTracker.obtain();
                    if (this.O00000oO != null) {
                        this.O00000oO.addMovement(motionEvent);
                    }
                    this.O0000O0o = O00000Oo(motionEvent);
                    this.O0000OOo = O00000o0(motionEvent);
                    this.O00000oo = false;
                    break;
                case 1:
                    this.O00000Oo = -1;
                    if (this.O00000oo && this.O00000oO != null) {
                        this.O0000O0o = O00000Oo(motionEvent);
                        this.O0000OOo = O00000o0(motionEvent);
                        this.O00000oO.addMovement(motionEvent);
                        this.O00000oO.computeCurrentVelocity(1000);
                        xVelocity = this.O00000oO.getXVelocity();
                        yVelocity = this.O00000oO.getYVelocity();
                        if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.O0000Oo) {
                            this.O0000OoO.O000000o(this.O0000O0o, this.O0000OOo, -xVelocity, -yVelocity);
                        }
                    }
                    if (this.O00000oO != null) {
                        this.O00000oO.recycle();
                        this.O00000oO = null;
                        break;
                    }
                    break;
                case 2:
                    xVelocity = O00000Oo(motionEvent);
                    float O00000o0 = O00000o0(motionEvent);
                    yVelocity = xVelocity - this.O0000O0o;
                    float f = O00000o0 - this.O0000OOo;
                    if (!this.O00000oo) {
                        this.O00000oo = Math.sqrt((double) ((yVelocity * yVelocity) + (f * f))) >= ((double) this.O0000Oo0);
                    }
                    if (this.O00000oo) {
                        this.O0000OoO.O000000o(yVelocity, f);
                        this.O0000O0o = xVelocity;
                        this.O0000OOo = O00000o0;
                        if (this.O00000oO != null) {
                            this.O00000oO.addMovement(motionEvent);
                            break;
                        }
                    }
                    break;
                case 3:
                    this.O00000Oo = -1;
                    if (this.O00000oO != null) {
                        this.O00000oO.recycle();
                        this.O00000oO = null;
                        break;
                    }
                    break;
            }
        }
        action = O00oOooO.O000000o(motionEvent.getAction());
        if (motionEvent.getPointerId(action) == this.O00000Oo) {
            action = action == 0 ? 1 : 0;
            this.O00000Oo = motionEvent.getPointerId(action);
            this.O0000O0o = motionEvent.getX(action);
            this.O0000OOo = motionEvent.getY(action);
        }
        if (this.O00000Oo != -1) {
            i = this.O00000Oo;
        }
        this.O00000o0 = motionEvent.findPointerIndex(i);
        return true;
    }

    private float O00000o0(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.O00000o0);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    public boolean O000000o() {
        return this.O00000o.isInProgress();
    }

    public boolean O000000o(MotionEvent motionEvent) {
        try {
            this.O00000o.onTouchEvent(motionEvent);
            return O00000o(motionEvent);
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }

    public boolean O00000Oo() {
        return this.O00000oo;
    }
}
