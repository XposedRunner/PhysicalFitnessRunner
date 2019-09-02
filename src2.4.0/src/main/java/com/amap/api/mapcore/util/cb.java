package com.amap.api.mapcore.util;

import android.opengl.GLSurfaceView.Renderer;
import android.view.SurfaceHolder;

/* compiled from: IGLSurfaceView */
public interface cb {
    void O000000o(OOO000o oOO000o);

    void O000000o(OOO00O0 ooo00o0);

    void O00000Oo();

    int getHeight();

    SurfaceHolder getHolder();

    int getRenderMode();

    int getWidth();

    boolean isEnabled();

    boolean post(Runnable runnable);

    boolean postDelayed(Runnable runnable, long j);

    void queueEvent(Runnable runnable);

    void requestRender();

    void setRenderMode(int i);

    void setRenderer(Renderer renderer);

    void setVisibility(int i);
}
