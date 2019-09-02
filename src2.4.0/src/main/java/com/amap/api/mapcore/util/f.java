package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView.Renderer;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import com.amap.api.mapcore.util.o.O0000O0o;
import com.amap.api.mapcore.util.o.O0000OOo;
import com.autonavi.ae.gmap.GLMapRender;

/* compiled from: AMapGLTextureView */
public class f extends o implements cb {
    protected boolean O000000o;
    private ca O00000Oo;
    private GLMapRender O00000o0;

    public f(Context context) {
        this(context, null);
    }

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.O00000Oo = null;
        this.O00000o0 = null;
        this.O000000o = false;
        OOO00Oo.O000000o((cb) this, 5, 6, 5, 0, 16, 8);
        this.O00000Oo = new O00o000(this, context, attributeSet);
    }

    public ca O000000o() {
        return this.O00000Oo;
    }

    public void O000000o(OOO000o oOO000o) {
        super.O000000o((O0000O0o) oOO000o);
    }

    public void O000000o(OOO00O0 ooo00o0) {
        super.O000000o((O0000OOo) ooo00o0);
    }

    public void O00000Oo() {
        O00000o0();
        try {
            if (this.O00000o0 != null) {
                this.O00000o0.onDetachedFromWindow();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.onDetachedFromWindow();
    }

    public void O00000o() {
        super.O00000o();
    }

    public void O00000o0() {
        if (!this.O00000o0.mSurfacedestoryed) {
            queueEvent(new Runnable() {
                public void run() {
                    try {
                        if (f.this.O00000o0 != null) {
                            f.this.O00000o0.onSurfaceDestory();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            int i = 0;
            while (!this.O00000o0.mSurfacedestoryed) {
                int i2 = i + 1;
                if (i >= 20) {
                    break;
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException unused) {
                }
                i = i2;
            }
        }
        super.O00000o0();
    }

    public SurfaceHolder getHolder() {
        return null;
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            if (this.O00000o0 != null) {
                this.O00000o0.onAttachedToWindow();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        O00000o();
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        requestRender();
        try {
            Thread.sleep(100);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return super.onSurfaceTextureDestroyed(surfaceTexture);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        try {
            return this.O00000Oo.onTouchEvent(motionEvent);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* Access modifiers changed, original: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            if (this.O00000o0 != null) {
                this.O00000o0.renderPause();
                this.O000000o = false;
            }
            requestRender();
        } else if (i == 0) {
            try {
                if (this.O00000o0 != null) {
                    this.O00000o0.renderResume();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void setRenderer(Renderer renderer) {
        this.O00000o0 = (GLMapRender) renderer;
        super.setRenderer(renderer);
    }
}
