package com.ecloud.pulltozoomview;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;

public abstract class PullToZoomBase<T extends View> extends LinearLayout implements O00000Oo<T> {
    private static final float O00000oo = 2.0f;
    protected T O000000o;
    protected View O00000Oo;
    protected int O00000o;
    protected View O00000o0;
    protected int O00000oO;
    private boolean O0000O0o;
    private boolean O0000OOo;
    private boolean O0000Oo;
    private boolean O0000Oo0;
    private int O0000OoO;
    private boolean O0000Ooo;
    private O000000o O0000o;
    private float O0000o0;
    private float O0000o00;
    private float O0000o0O;
    private float O0000o0o;

    public interface O000000o {
        void O000000o();

        void O000000o(int i);
    }

    public PullToZoomBase(Context context) {
        this(context, null);
    }

    public PullToZoomBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.O0000O0o = true;
        this.O0000OOo = true;
        this.O0000Oo0 = false;
        this.O0000Oo = false;
        this.O0000Ooo = false;
        O00000Oo(context, attributeSet);
    }

    private void O00000Oo(Context context, AttributeSet attributeSet) {
        setGravity(17);
        this.O0000OoO = ViewConfiguration.get(context).getScaledTouchSlop();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.O00000o = displayMetrics.heightPixels;
        this.O00000oO = displayMetrics.widthPixels;
        this.O000000o = O000000o(context, attributeSet);
        if (attributeSet != null) {
            LayoutInflater from = LayoutInflater.from(getContext());
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.PullToZoomView);
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.PullToZoomView_zoomView, 0);
            if (resourceId > 0) {
                this.O00000o0 = from.inflate(resourceId, null, false);
            }
            resourceId = obtainStyledAttributes.getResourceId(R.styleable.PullToZoomView_headerView, 0);
            if (resourceId > 0) {
                this.O00000Oo = from.inflate(resourceId, null, false);
            }
            this.O0000OOo = obtainStyledAttributes.getBoolean(R.styleable.PullToZoomView_isHeaderParallax, true);
            O000000o(obtainStyledAttributes);
            obtainStyledAttributes.recycle();
        }
        addView(this.O000000o, -1, -1);
    }

    private void O0000O0o() {
        int round = Math.round(Math.min(this.O0000o0O - this.O0000o00, 0.0f) / O00000oo);
        O000000o(round);
        if (this.O0000o != null) {
            this.O0000o.O000000o(round);
        }
    }

    public abstract T O000000o(Context context, AttributeSet attributeSet);

    public abstract void O000000o(int i);

    public boolean O000000o() {
        return this.O0000O0o;
    }

    public boolean O00000Oo() {
        return this.O0000Oo0;
    }

    public boolean O00000o() {
        return this.O0000Oo;
    }

    public boolean O00000o0() {
        return this.O0000OOo;
    }

    public abstract void O00000oO();

    public abstract boolean O00000oo();

    public View getHeaderView() {
        return this.O00000Oo;
    }

    public T getPullRootView() {
        return this.O000000o;
    }

    public View getZoomView() {
        return this.O00000o0;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!O000000o() || O00000o()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.O0000Ooo = false;
            return false;
        } else if (action != 0 && this.O0000Ooo) {
            return true;
        } else {
            float y;
            float x;
            if (action != 0) {
                if (action == 2 && O00000oo()) {
                    y = motionEvent.getY();
                    x = motionEvent.getX();
                    float f = y - this.O0000o00;
                    float f2 = x - this.O0000o0;
                    float abs = Math.abs(f);
                    if (abs > ((float) this.O0000OoO) && abs > Math.abs(f2) && f >= 1.0f && O00000oo()) {
                        this.O0000o00 = y;
                        this.O0000o0 = x;
                        this.O0000Ooo = true;
                    }
                }
            } else if (O00000oo()) {
                y = motionEvent.getY();
                this.O0000o0O = y;
                this.O0000o00 = y;
                x = motionEvent.getX();
                this.O0000o0o = x;
                this.O0000o0 = x;
                this.O0000Ooo = false;
            }
            return this.O0000Ooo;
        }
    }

    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (!O000000o() || O00000o()) {
            return false;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (O00000oo()) {
                    float y = motionEvent.getY();
                    this.O0000o0O = y;
                    this.O0000o00 = y;
                    float x = motionEvent.getX();
                    this.O0000o0o = x;
                    this.O0000o0 = x;
                    return true;
                }
                break;
            case 1:
            case 3:
                if (this.O0000Ooo) {
                    this.O0000Ooo = false;
                    if (!O00000Oo()) {
                        return true;
                    }
                    O00000oO();
                    if (this.O0000o != null) {
                        this.O0000o.O000000o();
                    }
                    this.O0000Oo0 = false;
                    return true;
                }
                break;
            case 2:
                if (this.O0000Ooo) {
                    this.O0000o00 = motionEvent.getY();
                    this.O0000o0 = motionEvent.getX();
                    O0000O0o();
                    this.O0000Oo0 = true;
                    return true;
                }
                break;
        }
        return false;
    }

    public abstract void setHeaderView(View view);

    public void setHideHeader(boolean z) {
        this.O0000Oo = z;
    }

    public void setOnPullZoomListener(O000000o o000000o) {
        this.O0000o = o000000o;
    }

    public void setParallax(boolean z) {
        this.O0000OOo = z;
    }

    public void setZoomEnabled(boolean z) {
        this.O0000O0o = z;
    }

    public abstract void setZoomView(View view);
}
