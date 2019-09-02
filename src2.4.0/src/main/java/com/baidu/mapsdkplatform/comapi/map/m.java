package com.baidu.mapsdkplatform.comapi.map;

import android.annotation.SuppressLint;
import android.graphics.SurfaceTexture;
import android.opengl.GLUtils;
import java.lang.Thread.State;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;

@SuppressLint({"NewApi"})
public class m extends Thread {
    private AtomicBoolean a;
    private SurfaceTexture b;
    private a c;
    private EGL10 d;
    private EGLDisplay e = EGL10.EGL_NO_DISPLAY;
    private EGLContext f = EGL10.EGL_NO_CONTEXT;
    private EGLSurface g = EGL10.EGL_NO_SURFACE;
    private GL10 h;
    private int i = 1;
    private boolean j = false;
    private final ac k;

    public interface a {
        int a();
    }

    public m(SurfaceTexture surfaceTexture, a aVar, AtomicBoolean atomicBoolean, ac acVar) {
        this.b = surfaceTexture;
        this.c = aVar;
        this.a = atomicBoolean;
        this.k = acVar;
    }

    private boolean a(int i, int i2, int i3, int i4, int i5, int i6) {
        this.d = (EGL10) EGLContext.getEGL();
        this.e = this.d.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        StringBuilder stringBuilder;
        if (this.e == EGL10.EGL_NO_DISPLAY) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("eglGetdisplay failed : ");
            stringBuilder.append(GLUtils.getEGLErrorString(this.d.eglGetError()));
            throw new RuntimeException(stringBuilder.toString());
        }
        if (this.d.eglInitialize(this.e, new int[2])) {
            EGLConfig[] eGLConfigArr = new EGLConfig[100];
            int[] iArr = new int[1];
            if (!this.d.eglChooseConfig(this.e, new int[]{12352, 4, 12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344}, eGLConfigArr, 100, iArr) || iArr[0] <= 0) {
                return false;
            }
            this.f = this.d.eglCreateContext(this.e, eGLConfigArr[0], EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
            this.g = this.d.eglCreateWindowSurface(this.e, eGLConfigArr[0], this.b, null);
            if (this.g == EGL10.EGL_NO_SURFACE || this.f == EGL10.EGL_NO_CONTEXT) {
                if (this.d.eglGetError() == 12299) {
                    throw new RuntimeException("eglCreateWindowSurface returned EGL_BAD_NATIVE_WINDOW. ");
                }
                GLUtils.getEGLErrorString(this.d.eglGetError());
            }
            if (this.d.eglMakeCurrent(this.e, this.g, this.g, this.f)) {
                this.h = (GL10) this.f.getGL();
                return true;
            }
            String eGLErrorString = GLUtils.getEGLErrorString(this.d.eglGetError());
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("eglMakeCurrent failed : ");
            stringBuilder2.append(eGLErrorString);
            throw new RuntimeException(stringBuilder2.toString());
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("eglInitialize failed : ");
        stringBuilder.append(GLUtils.getEGLErrorString(this.d.eglGetError()));
        throw new RuntimeException(stringBuilder.toString());
    }

    private static boolean b(int i, int i2, int i3, int i4, int i5, int i6) {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        egl10.eglInitialize(eglGetDisplay, new int[2]);
        int[] iArr = new int[1];
        return egl10.eglChooseConfig(eglGetDisplay, new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344}, new EGLConfig[100], 100, iArr) && iArr[0] > 0;
    }

    private void d() {
        try {
            if (b(5, 6, 5, 0, 24, 0)) {
                a(8, 8, 8, 0, 24, 0);
            } else {
                a(8, 8, 8, 0, 24, 0);
            }
        } catch (IllegalArgumentException unused) {
            a(8, 8, 8, 0, 24, 0);
        }
        if (this.k.b() != null) {
            MapRenderer.nativeInit(this.k.b().j);
            MapRenderer.nativeResize(this.k.b().j, ac.a, ac.b);
        }
    }

    private void e() {
        if (this.g != EGL10.EGL_NO_SURFACE) {
            this.d.eglMakeCurrent(this.e, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
            this.d.eglDestroySurface(this.e, this.g);
            this.g = EGL10.EGL_NO_SURFACE;
        }
        if (this.f != EGL10.EGL_NO_CONTEXT) {
            this.d.eglDestroyContext(this.e, this.f);
            this.f = EGL10.EGL_NO_CONTEXT;
        }
        if (this.e != EGL10.EGL_NO_DISPLAY) {
            this.d.eglTerminate(this.e);
            this.e = EGL10.EGL_NO_DISPLAY;
        }
    }

    public void a() {
        this.i = 1;
        this.j = false;
        synchronized (this) {
            if (getState() == State.WAITING) {
                notify();
            }
        }
    }

    public void b() {
        this.i = 0;
        synchronized (this) {
            this.j = true;
        }
    }

    public void c() {
        this.j = true;
        synchronized (this) {
            if (getState() == State.WAITING) {
                notify();
            }
        }
    }

    public void run() {
        d();
        while (this.c != null) {
            if (this.i != 1 || this.j) {
                try {
                    synchronized (this) {
                        wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (this.k.b() == null) {
                break;
            } else {
                synchronized (this.k.b()) {
                    synchronized (this) {
                        if (!this.j) {
                            this.i = this.c.a();
                        }
                    }
                    e b = this.k.b();
                    if (!(b == null || b.h == null)) {
                        for (l lVar : b.h) {
                            if (lVar != null) {
                                ab J = b.J();
                                if (this.h == null) {
                                    return;
                                } else if (lVar != null) {
                                    lVar.a(this.h, J);
                                }
                            }
                        }
                    }
                    this.d.eglSwapBuffers(this.e, this.g);
                }
            }
            if (this.j) {
                break;
            }
        }
        e();
    }
}
