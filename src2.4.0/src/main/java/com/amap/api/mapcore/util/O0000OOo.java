package com.amap.api.mapcore.util;

import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.amap.api.maps.model.CrossOverlay.GenerateCrossImageListener;
import java.nio.FloatBuffer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;

/* compiled from: PboPluginTexture */
public class O0000OOo {
    float[] O000000o = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    float[] O00000Oo = new float[]{-1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, -1.0f, 0.0f, -1.0f, -1.0f, 0.0f};
    private int O00000o = 0;
    private final ca O00000o0;
    private int O00000oO = 0;
    private int O00000oo = 0;
    private BlockingQueue<Runnable> O0000O0o = new LinkedBlockingQueue();
    private ExecutorService O0000OOo = null;
    private boolean O0000Oo = false;
    private boolean O0000Oo0 = false;
    private int O0000OoO = 0;
    private int O0000Ooo = 0;
    private EGLDisplay O0000o = EGL14.EGL_NO_DISPLAY;
    private boolean O0000o0 = false;
    private int O0000o00 = 0;
    private volatile EGLContext O0000o0O;
    private volatile EGLConfig O0000o0o;
    private EGLSurface O0000oO = EGL14.EGL_NO_SURFACE;
    private EGLContext O0000oO0 = EGL14.EGL_NO_CONTEXT;
    private com.amap.api.mapcore.util.OO00O.O0000OOo O0000oOO;
    private FloatBuffer O0000oOo;
    private O000000o O0000oo;
    private FloatBuffer O0000oo0;
    private GenerateCrossImageListener O0000ooO;

    /* compiled from: PboPluginTexture */
    public interface O000000o {
        int getTextureID();
    }

    public O0000OOo(ca caVar) {
        this.O00000o0 = caVar;
        this.O0000Oo = false;
        this.O0000OOo = new ThreadPoolExecutor(1, Runtime.getRuntime().availableProcessors() * 2, (long) 1, TimeUnit.SECONDS, this.O0000O0o, new OOO0o00("AMapPboRenderThread"), new AbortPolicy());
    }

    private void O000000o(String str) {
    }

    private void O00000o() {
        this.O0000o = EGL14.eglGetDisplay(0);
        if (this.O0000o == EGL14.EGL_NO_DISPLAY) {
            O000000o("eglGetDisplay failed");
            return;
        }
        int[] iArr = new int[2];
        if (EGL14.eglInitialize(this.O0000o, iArr, 0, iArr, 1)) {
            this.O0000oO0 = EGL14.eglCreateContext(this.O0000o, this.O0000o0o, this.O0000o0O, new int[]{12440, 2, 12344}, 0);
            if (this.O0000oO0 == EGL14.EGL_NO_CONTEXT) {
                O000000o("eglCreateContext failed");
                return;
            }
            this.O0000oO = EGL14.eglCreatePbufferSurface(this.O0000o, this.O0000o0o, new int[]{12375, this.O00000oO, 12374, this.O00000oo, 12344}, 0);
            if (this.O0000oO == EGL14.EGL_NO_SURFACE) {
                O000000o("eglCreatePbufferSurface failed");
                return;
            } else if (EGL14.eglMakeCurrent(this.O0000o, this.O0000oO, this.O0000oO, this.O0000oO0)) {
                GLES20.glFlush();
                O000000o("initOpenGL complete");
                this.O0000Oo0 = true;
                return;
            } else {
                O000000o("eglMakeCurrent failed");
                return;
            }
        }
        this.O0000o = null;
        O000000o("eglInitialize failed");
    }

    private void O00000oO() {
        if (this.O00000o0 != null) {
            this.O0000oOO = (com.amap.api.mapcore.util.OO00O.O0000OOo) this.O00000o0.O0000oOo(0);
        }
    }

    private void O00000oo() {
        try {
            if (!this.O0000Oo) {
                if (this.O0000oo == null) {
                    O000000o("renderTextureAndReadPixel failed textureHelper is null");
                    return;
                }
                if (this.O0000oo != null) {
                    this.O00000o = this.O0000oo.getTextureID();
                }
                StringBuilder stringBuilder;
                if (this.O00000o <= 0) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("renderTextureAndReadPixel failed mTextureID is <= 0 mTextureID ");
                    stringBuilder.append(this.O00000o);
                    O000000o(stringBuilder.toString());
                    return;
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("renderTextureAndReadPixel  mTextureID is  mTextureID ");
                stringBuilder.append(this.O00000o);
                O000000o(stringBuilder.toString());
                if (this.O0000oOO == null || this.O0000oOO.O00000o0()) {
                    O00000oO();
                }
                if (this.O0000oOo == null) {
                    this.O0000oOo = OOo000.O000000o(this.O00000Oo);
                }
                if (this.O0000oo0 == null) {
                    this.O0000oo0 = OOo000.O000000o(new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f});
                }
                this.O0000oOO.O000000o();
                GLES20.glDisable(3042);
                GLES20.glBlendFunc(1, 771);
                GLES20.glBlendColor(1.0f, 1.0f, 1.0f, 1.0f);
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(3553, this.O00000o);
                GLES20.glEnableVertexAttribArray(this.O0000oOO.O00000Oo);
                GLES20.glVertexAttribPointer(this.O0000oOO.O00000Oo, 3, 5126, false, 12, this.O0000oOo);
                GLES20.glEnableVertexAttribArray(this.O0000oOO.O00000o0);
                GLES20.glVertexAttribPointer(this.O0000oOO.O00000o0, 2, 5126, false, 8, this.O0000oo0);
                Matrix.setIdentityM(this.O000000o, 0);
                Matrix.scaleM(this.O000000o, 0, 1.0f, 1.0f, 1.0f);
                GLES20.glUniformMatrix4fv(this.O0000oOO.O000000o, 1, false, this.O000000o, 0);
                GLES20.glDrawArrays(6, 0, 4);
                GLES20.glDisableVertexAttribArray(this.O0000oOO.O00000Oo);
                GLES20.glDisableVertexAttribArray(this.O0000oOO.O00000o0);
                GLES20.glBindTexture(3553, 0);
                GLES20.glUseProgram(0);
                GLES20.glDisable(3042);
                OOO00Oo.O000000o("drawTexure");
                GLES20.glFinish();
                this.O0000OoO++;
                if (this.O0000OoO == 50) {
                    O0000O0o();
                }
            }
        } catch (Throwable unused) {
            if (this.O0000ooO != null) {
                this.O0000ooO.onGenerateComplete(null, -1);
            }
        }
    }

    private void O0000O0o() {
        if (this.O0000ooO != null) {
            if (this.O0000Ooo == 0) {
                this.O0000Ooo = this.O00000oO;
            }
            if (this.O0000o00 == 0) {
                this.O0000o00 = this.O00000oo;
            }
            int i = 0;
            Bitmap O000000o = OOo000.O000000o(0, this.O00000oo - this.O0000o00, this.O0000Ooo, this.O0000o00);
            GenerateCrossImageListener generateCrossImageListener = this.O0000ooO;
            if (!this.O0000Oo0) {
                i = -1;
            }
            generateCrossImageListener.onGenerateComplete(O000000o, i);
            this.O0000o0 = true;
        }
    }

    public void O000000o() {
        if (this.O0000OOo != null && !this.O0000OOo.isShutdown()) {
            this.O0000OOo.execute(new Runnable() {
                public void run() {
                    try {
                        O0000OOo.this.O0000o0 = false;
                        if (O0000OOo.this.O0000Oo) {
                            if (!O0000OOo.this.O0000o0) {
                                O0000OOo.this.O0000o0 = true;
                                if (O0000OOo.this.O0000ooO != null) {
                                    O0000OOo.this.O0000ooO.onGenerateComplete(null, -1);
                                }
                            }
                            if (O0000OOo.this.O0000oO0 != EGL14.EGL_NO_CONTEXT) {
                                EGL14.eglDestroyContext(O0000OOo.this.O0000o, O0000OOo.this.O0000oO0);
                                EGL14.eglDestroySurface(O0000OOo.this.O0000o, O0000OOo.this.O0000oO);
                                O0000OOo.this.O0000oO0 = null;
                            }
                            if (O0000OOo.this.O0000o != EGL14.EGL_NO_DISPLAY) {
                                EGL14.eglTerminate(O0000OOo.this.O0000o);
                                O0000OOo.this.O0000o = null;
                            }
                            O0000OOo.this.O0000oO0 = EGL14.EGL_NO_CONTEXT;
                            O0000OOo.this.O0000o = EGL14.EGL_NO_DISPLAY;
                            return;
                        }
                        O0000OOo.this.O0000OoO = 0;
                        int i = 0;
                        while (!O0000OOo.this.O0000Oo && O0000OOo.this.O0000OoO < 5 && i < 50) {
                            i++;
                            Thread.sleep(16);
                            if (O0000OOo.this.O0000Oo0) {
                                GLES20.glViewport(0, 0, O0000OOo.this.O00000oO, O0000OOo.this.O00000oo);
                                GLES20.glClear(16640);
                                O0000OOo.this.O00000oo();
                            } else {
                                if (O0000OOo.this.O0000ooO != null) {
                                    O0000OOo.this.O0000ooO.onGenerateComplete(null, -1);
                                }
                                if (!O0000OOo.this.O0000o0) {
                                    O0000OOo.this.O0000o0 = true;
                                    if (O0000OOo.this.O0000ooO != null) {
                                        O0000OOo.this.O0000ooO.onGenerateComplete(null, -1);
                                    }
                                }
                                if (O0000OOo.this.O0000oO0 != EGL14.EGL_NO_CONTEXT) {
                                    EGL14.eglDestroyContext(O0000OOo.this.O0000o, O0000OOo.this.O0000oO0);
                                    EGL14.eglDestroySurface(O0000OOo.this.O0000o, O0000OOo.this.O0000oO);
                                    O0000OOo.this.O0000oO0 = null;
                                }
                                if (O0000OOo.this.O0000o != EGL14.EGL_NO_DISPLAY) {
                                    EGL14.eglTerminate(O0000OOo.this.O0000o);
                                    O0000OOo.this.O0000o = null;
                                }
                                O0000OOo.this.O0000oO0 = EGL14.EGL_NO_CONTEXT;
                                O0000OOo.this.O0000o = EGL14.EGL_NO_DISPLAY;
                                return;
                            }
                        }
                        if (!O0000OOo.this.O0000o0) {
                            O0000OOo.this.O0000o0 = true;
                            if (O0000OOo.this.O0000ooO != null) {
                                O0000OOo.this.O0000ooO.onGenerateComplete(null, -1);
                            }
                        }
                        if (O0000OOo.this.O0000oO0 != EGL14.EGL_NO_CONTEXT) {
                            EGL14.eglDestroyContext(O0000OOo.this.O0000o, O0000OOo.this.O0000oO0);
                            EGL14.eglDestroySurface(O0000OOo.this.O0000o, O0000OOo.this.O0000oO);
                            O0000OOo.this.O0000oO0 = null;
                        }
                        if (O0000OOo.this.O0000o != EGL14.EGL_NO_DISPLAY) {
                            EGL14.eglTerminate(O0000OOo.this.O0000o);
                            O0000OOo.this.O0000o = null;
                        }
                        O0000OOo.this.O0000oO0 = EGL14.EGL_NO_CONTEXT;
                        O0000OOo.this.O0000o = EGL14.EGL_NO_DISPLAY;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (Throwable th) {
                        if (!O0000OOo.this.O0000o0) {
                            O0000OOo.this.O0000o0 = true;
                            if (O0000OOo.this.O0000ooO != null) {
                                O0000OOo.this.O0000ooO.onGenerateComplete(null, -1);
                            }
                        }
                        if (O0000OOo.this.O0000oO0 != EGL14.EGL_NO_CONTEXT) {
                            EGL14.eglDestroyContext(O0000OOo.this.O0000o, O0000OOo.this.O0000oO0);
                            EGL14.eglDestroySurface(O0000OOo.this.O0000o, O0000OOo.this.O0000oO);
                            O0000OOo.this.O0000oO0 = null;
                        }
                        if (O0000OOo.this.O0000o != EGL14.EGL_NO_DISPLAY) {
                            EGL14.eglTerminate(O0000OOo.this.O0000o);
                            O0000OOo.this.O0000o = null;
                        }
                        O0000OOo.this.O0000oO0 = EGL14.EGL_NO_CONTEXT;
                        O0000OOo.this.O0000o = EGL14.EGL_NO_DISPLAY;
                    }
                }
            });
        }
    }

    public void O000000o(int i, int i2) {
        this.O00000oO = i;
        this.O00000oo = i2;
        this.O0000o0O = EGL14.eglGetCurrentContext();
        if (this.O0000o0O == EGL14.EGL_NO_CONTEXT) {
            O000000o("eglGetCurrentContext failed");
            return;
        }
        EGLDisplay eglGetCurrentDisplay = EGL14.eglGetCurrentDisplay();
        if (eglGetCurrentDisplay == EGL14.EGL_NO_DISPLAY) {
            O000000o("sharedEglDisplay failed");
            return;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (EGL14.eglGetConfigs(eglGetCurrentDisplay, eGLConfigArr, 0, eGLConfigArr.length, new int[1], 0)) {
            this.O0000o0o = eGLConfigArr[0];
            if (!(this.O0000OOo == null || this.O0000OOo.isShutdown())) {
                this.O0000OOo.execute(new Runnable() {
                    public void run() {
                        O0000OOo.this.O00000o();
                    }
                });
            }
            return;
        }
        O000000o("eglGetConfigs failed");
    }

    public void O000000o(O000000o o000000o) {
        this.O0000oo = o000000o;
    }

    public void O000000o(GenerateCrossImageListener generateCrossImageListener) {
        this.O0000ooO = generateCrossImageListener;
    }

    public void O00000Oo() {
        this.O0000Oo = true;
        if (this.O0000oo0 != null) {
            this.O0000oo0.clear();
            this.O0000oo0 = null;
        }
        if (this.O0000oOo != null) {
            this.O0000oOo.clear();
            this.O0000oOo = null;
        }
        this.O0000oo = null;
        this.O0000OOo.shutdownNow();
    }

    public void O00000Oo(int i, int i2) {
        this.O0000Ooo = i;
        this.O0000o00 = i2;
    }

    public boolean O00000o0() {
        return this.O0000Oo;
    }
}
