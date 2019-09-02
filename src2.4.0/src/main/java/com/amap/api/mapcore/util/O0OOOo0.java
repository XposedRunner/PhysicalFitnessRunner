package com.amap.api.mapcore.util;

import android.content.Context;
import android.opengl.GLSurfaceView.Renderer;
import android.util.AttributeSet;
import android.view.SurfaceHolder;

/* compiled from: AMapGLRenderer */
public class O0OOOo0 implements cb {
    protected boolean O000000o;
    private ca O00000Oo;

    public O0OOOo0(Context context) {
        this(context, null);
    }

    public O0OOOo0(Context context, AttributeSet attributeSet) {
        this.O00000Oo = null;
        this.O000000o = false;
        this.O00000Oo = new O00o000(this, context, attributeSet);
    }

    public ca O000000o() {
        return this.O00000Oo;
    }

    public void O000000o(OOO000o oOO000o) {
    }

    public void O000000o(OOO00O0 ooo00o0) {
    }

    public void O00000Oo() {
    }

    public int getHeight() {
        return 0;
    }

    public SurfaceHolder getHolder() {
        return null;
    }

    public int getRenderMode() {
        return 0;
    }

    public int getWidth() {
        return 0;
    }

    public boolean isEnabled() {
        return this.O00000Oo != null;
    }

    public boolean post(Runnable runnable) {
        return false;
    }

    public boolean postDelayed(Runnable runnable, long j) {
        return false;
    }

    public void queueEvent(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }

    public void requestRender() {
    }

    public void setRenderMode(int i) {
    }

    public void setRenderer(Renderer renderer) {
    }

    public void setVisibility(int i) {
    }
}
