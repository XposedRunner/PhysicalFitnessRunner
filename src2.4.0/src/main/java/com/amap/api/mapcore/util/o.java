package com.amap.api.mapcore.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.opengl.GLSurfaceView.Renderer;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

@SuppressLint({"NewApi"})
/* compiled from: GLTextureView */
public class o extends TextureView implements SurfaceTextureListener {
    private static final O0000o0 O000000o = new O0000o0();
    private final WeakReference<o> O00000Oo = new WeakReference(this);
    private Renderer O00000o;
    private O0000o00 O00000o0;
    private boolean O00000oO;
    private O0000O0o O00000oo;
    private O0000OOo O0000O0o;
    private O0000Oo0 O0000OOo;
    private int O0000Oo;
    private O0000o O0000Oo0;
    private int O0000OoO;
    private boolean O0000Ooo;

    /* compiled from: GLTextureView */
    public interface O0000O0o {
        EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    /* compiled from: GLTextureView */
    public interface O0000OOo {
        EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    /* compiled from: GLTextureView */
    private abstract class O000000o implements O0000O0o {
        protected int[] O000000o;

        public O000000o(int[] iArr) {
            this.O000000o = O000000o(iArr);
        }

        private int[] O000000o(int[] iArr) {
            if (o.this.O0000OoO != 2 && o.this.O0000OoO != 3) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[(length + 2)];
            int i = length - 1;
            System.arraycopy(iArr, 0, iArr2, 0, i);
            iArr2[i] = 12352;
            if (o.this.O0000OoO == 2) {
                iArr2[length] = 4;
            } else {
                iArr2[length] = 64;
            }
            iArr2[length + 1] = 12344;
            return iArr2;
        }

        public abstract EGLConfig O000000o(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (egl10.eglChooseConfig(eGLDisplay, this.O000000o, null, 0, iArr)) {
                int i = iArr[0];
                if (i <= 0) {
                    throw new IllegalArgumentException("No configs match configSpec");
                }
                EGLConfig[] eGLConfigArr = new EGLConfig[i];
                if (egl10.eglChooseConfig(eGLDisplay, this.O000000o, eGLConfigArr, i, iArr)) {
                    EGLConfig O000000o = O000000o(egl10, eGLDisplay, eGLConfigArr);
                    if (O000000o != null) {
                        return O000000o;
                    }
                    throw new IllegalArgumentException("No config chosen");
                }
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            throw new IllegalArgumentException("eglChooseConfig failed");
        }
    }

    /* compiled from: GLTextureView */
    private class O00000Oo extends O000000o {
        protected int O00000o;
        protected int O00000o0;
        protected int O00000oO;
        protected int O00000oo;
        protected int O0000O0o;
        protected int O0000OOo;
        private int[] O0000Oo = new int[1];

        public O00000Oo(int i, int i2, int i3, int i4, int i5, int i6) {
            super(new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344});
            this.O00000o0 = i;
            this.O00000o = i2;
            this.O00000oO = i3;
            this.O00000oo = i4;
            this.O0000O0o = i5;
            this.O0000OOo = i6;
        }

        private int O000000o(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.O0000Oo) ? this.O0000Oo[0] : i2;
        }

        public EGLConfig O000000o(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                EGL10 egl102 = egl10;
                EGLDisplay eGLDisplay2 = eGLDisplay;
                EGLConfig eGLConfig2 = eGLConfig;
                int O000000o = O000000o(egl102, eGLDisplay2, eGLConfig2, 12325, 0);
                int O000000o2 = O000000o(egl102, eGLDisplay2, eGLConfig2, 12326, 0);
                if (O000000o >= this.O0000O0o && O000000o2 >= this.O0000OOo) {
                    egl102 = egl10;
                    eGLDisplay2 = eGLDisplay;
                    eGLConfig2 = eGLConfig;
                    O000000o = O000000o(egl102, eGLDisplay2, eGLConfig2, 12324, 0);
                    int O000000o3 = O000000o(egl102, eGLDisplay2, eGLConfig2, 12323, 0);
                    int O000000o4 = O000000o(egl102, eGLDisplay2, eGLConfig2, 12322, 0);
                    O000000o2 = O000000o(egl102, eGLDisplay2, eGLConfig2, 12321, 0);
                    if (O000000o == this.O00000o0 && O000000o3 == this.O00000o && O000000o4 == this.O00000oO && O000000o2 == this.O00000oo) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }
    }

    /* compiled from: GLTextureView */
    private class O00000o0 implements O0000OOo {
        private O00000o0() {
        }

        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = new int[]{12440, o.this.O0000OoO, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (o.this.O0000OoO == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("display:");
                stringBuilder.append(eGLDisplay);
                stringBuilder.append(" context: ");
                stringBuilder.append(eGLContext);
                Log.e("DefaultContextFactory", stringBuilder.toString());
                O0000Oo.O000000o("eglDestroyContex", egl10.eglGetError());
            }
        }
    }

    /* compiled from: GLTextureView */
    public interface O0000Oo0 {
        EGLSurface O000000o(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void O000000o(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    /* compiled from: GLTextureView */
    private static class O00000o implements O0000Oo0 {
        private O00000o() {
        }

        public EGLSurface O000000o(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e) {
                Log.e("GLSurfaceView", "eglCreateWindowSurface", e);
                return null;
            }
        }

        public void O000000o(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    /* compiled from: GLTextureView */
    private static class O0000Oo {
        EGL10 O000000o;
        EGLDisplay O00000Oo;
        EGLConfig O00000o;
        EGLSurface O00000o0;
        EGLContext O00000oO;
        private WeakReference<o> O00000oo;

        public O0000Oo(WeakReference<o> weakReference) {
            this.O00000oo = weakReference;
        }

        private void O000000o(String str) {
            O000000o(str, this.O000000o.eglGetError());
        }

        public static void O000000o(String str, int i) {
            throw new RuntimeException(O00000Oo(str, i));
        }

        public static void O000000o(String str, String str2, int i) {
            Log.w(str, O00000Oo(str2, i));
        }

        public static String O00000Oo(String str, int i) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" failed: ");
            stringBuilder.append(i);
            return stringBuilder.toString();
        }

        private void O0000O0o() {
            if (this.O00000o0 != null && this.O00000o0 != EGL10.EGL_NO_SURFACE) {
                this.O000000o.eglMakeCurrent(this.O00000Oo, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                o oVar = (o) this.O00000oo.get();
                if (oVar != null) {
                    oVar.O0000OOo.O000000o(this.O000000o, this.O00000Oo, this.O00000o0);
                }
                this.O00000o0 = null;
            }
        }

        public void O000000o() {
            this.O000000o = (EGL10) EGLContext.getEGL();
            this.O00000Oo = this.O000000o.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.O00000Oo == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (this.O000000o.eglInitialize(this.O00000Oo, new int[2])) {
                o oVar = (o) this.O00000oo.get();
                if (oVar == null) {
                    this.O00000o = null;
                    this.O00000oO = null;
                } else {
                    this.O00000o = oVar.O00000oo.chooseConfig(this.O000000o, this.O00000Oo);
                    this.O00000oO = oVar.O0000O0o.createContext(this.O000000o, this.O00000Oo, this.O00000o);
                }
                if (this.O00000oO == null || this.O00000oO == EGL10.EGL_NO_CONTEXT) {
                    this.O00000oO = null;
                    O000000o("createContext");
                }
                this.O00000o0 = null;
                return;
            }
            throw new RuntimeException("eglInitialize failed");
        }

        public boolean O00000Oo() {
            if (this.O000000o == null) {
                throw new RuntimeException("egl not initialized");
            } else if (this.O00000Oo == null) {
                throw new RuntimeException("eglDisplay not initialized");
            } else if (this.O00000o == null) {
                throw new RuntimeException("mEglConfig not initialized");
            } else {
                O0000O0o();
                o oVar = (o) this.O00000oo.get();
                if (oVar != null) {
                    this.O00000o0 = oVar.O0000OOo.O000000o(this.O000000o, this.O00000Oo, this.O00000o, oVar.getSurfaceTexture());
                } else {
                    this.O00000o0 = null;
                }
                if (this.O00000o0 == null || this.O00000o0 == EGL10.EGL_NO_SURFACE) {
                    if (this.O000000o.eglGetError() == 12299) {
                        Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                    }
                    return false;
                } else if (this.O000000o.eglMakeCurrent(this.O00000Oo, this.O00000o0, this.O00000o0, this.O00000oO)) {
                    return true;
                } else {
                    O000000o("EGLHelper", "eglMakeCurrent", this.O000000o.eglGetError());
                    return false;
                }
            }
        }

        public int O00000o() {
            return !this.O000000o.eglSwapBuffers(this.O00000Oo, this.O00000o0) ? this.O000000o.eglGetError() : 12288;
        }

        /* Access modifiers changed, original: 0000 */
        public GL O00000o0() {
            GL gl = this.O00000oO.getGL();
            o oVar = (o) this.O00000oo.get();
            if (oVar == null) {
                return gl;
            }
            if (oVar.O0000Oo0 != null) {
                gl = oVar.O0000Oo0.O000000o(gl);
            }
            if ((oVar.O0000Oo & 3) == 0) {
                return gl;
            }
            int i = 0;
            Writer writer = null;
            if ((oVar.O0000Oo & 1) != 0) {
                i = 1;
            }
            if ((oVar.O0000Oo & 2) != 0) {
                writer = new O00oOooO();
            }
            return GLDebugHelper.wrap(gl, i, writer);
        }

        public void O00000oO() {
            O0000O0o();
        }

        public void O00000oo() {
            if (this.O00000oO != null) {
                o oVar = (o) this.O00000oo.get();
                if (oVar != null) {
                    oVar.O0000O0o.destroyContext(this.O000000o, this.O00000Oo, this.O00000oO);
                }
                this.O00000oO = null;
            }
            if (this.O00000Oo != null) {
                this.O000000o.eglTerminate(this.O00000Oo);
                this.O00000Oo = null;
            }
        }
    }

    /* compiled from: GLTextureView */
    static class O0000o00 extends Thread {
        private boolean O000000o;
        private boolean O00000Oo;
        private boolean O00000o;
        private boolean O00000o0;
        private boolean O00000oO;
        private boolean O00000oo;
        private boolean O0000O0o;
        private boolean O0000OOo;
        private boolean O0000Oo;
        private boolean O0000Oo0;
        private boolean O0000OoO;
        private int O0000Ooo = 0;
        private ArrayList<Runnable> O0000o = new ArrayList();
        private int O0000o0 = 1;
        private int O0000o00 = 0;
        private boolean O0000o0O = true;
        private boolean O0000o0o;
        private O0000Oo O0000oO;
        private boolean O0000oO0 = true;
        private WeakReference<o> O0000oOO;

        O0000o00(WeakReference<o> weakReference) {
            this.O0000oOO = weakReference;
        }

        private void O0000Oo() {
            if (this.O0000Oo0) {
                this.O0000Oo0 = false;
                this.O0000oO.O00000oO();
            }
        }

        private void O0000OoO() {
            if (this.O0000OOo) {
                this.O0000oO.O00000oo();
                this.O0000OOo = false;
                o.O000000o.O00000o0(this);
            }
        }

        /* JADX WARNING: Missing block: B:96:0x0155, code skipped:
            if (r11 == null) goto L_0x015d;
     */
        /* JADX WARNING: Missing block: B:99:0x015d, code skipped:
            if (r13 == false) goto L_0x0196;
     */
        /* JADX WARNING: Missing block: B:101:0x0165, code skipped:
            if (r1.O0000oO.O00000Oo() == false) goto L_0x017d;
     */
        /* JADX WARNING: Missing block: B:102:0x0167, code skipped:
            r2 = com.amap.api.mapcore.util.o.O00000oO();
     */
        /* JADX WARNING: Missing block: B:103:0x016b, code skipped:
            monitor-enter(r2);
     */
        /* JADX WARNING: Missing block: B:106:?, code skipped:
            r1.O0000Oo = true;
            com.amap.api.mapcore.util.o.O00000oO().notifyAll();
     */
        /* JADX WARNING: Missing block: B:107:0x0176, code skipped:
            monitor-exit(r2);
     */
        /* JADX WARNING: Missing block: B:108:0x0177, code skipped:
            r13 = r3;
     */
        /* JADX WARNING: Missing block: B:114:0x017d, code skipped:
            r2 = com.amap.api.mapcore.util.o.O00000oO();
     */
        /* JADX WARNING: Missing block: B:115:0x0181, code skipped:
            monitor-enter(r2);
     */
        /* JADX WARNING: Missing block: B:118:?, code skipped:
            r1.O0000Oo = true;
            r1.O00000oo = true;
            com.amap.api.mapcore.util.o.O00000oO().notifyAll();
     */
        /* JADX WARNING: Missing block: B:119:0x018e, code skipped:
            monitor-exit(r2);
     */
        /* JADX WARNING: Missing block: B:126:0x0196, code skipped:
            if (r14 == false) goto L_0x01a9;
     */
        /* JADX WARNING: Missing block: B:127:0x0198, code skipped:
            r2 = (javax.microedition.khronos.opengles.GL10) r1.O0000oO.O00000o0();
            com.amap.api.mapcore.util.o.O00000oO().O000000o(r2);
            r8 = r2;
            r14 = false;
     */
        /* JADX WARNING: Missing block: B:128:0x01a9, code skipped:
            if (r12 == false) goto L_0x01c1;
     */
        /* JADX WARNING: Missing block: B:129:0x01ab, code skipped:
            r2 = (com.amap.api.mapcore.util.o) r1.O0000oOO.get();
     */
        /* JADX WARNING: Missing block: B:130:0x01b3, code skipped:
            if (r2 == null) goto L_0x01c0;
     */
        /* JADX WARNING: Missing block: B:131:0x01b5, code skipped:
            com.amap.api.mapcore.util.o.O0000OOo(r2).onSurfaceCreated(r8, r1.O0000oO.O00000o);
     */
        /* JADX WARNING: Missing block: B:132:0x01c0, code skipped:
            r12 = false;
     */
        /* JADX WARNING: Missing block: B:133:0x01c1, code skipped:
            if (r15 == false) goto L_0x01d5;
     */
        /* JADX WARNING: Missing block: B:134:0x01c3, code skipped:
            r2 = (com.amap.api.mapcore.util.o) r1.O0000oOO.get();
     */
        /* JADX WARNING: Missing block: B:135:0x01cb, code skipped:
            if (r2 == null) goto L_0x01d4;
     */
        /* JADX WARNING: Missing block: B:136:0x01cd, code skipped:
            com.amap.api.mapcore.util.o.O0000OOo(r2).onSurfaceChanged(r8, r9, r10);
     */
        /* JADX WARNING: Missing block: B:137:0x01d4, code skipped:
            r15 = false;
     */
        /* JADX WARNING: Missing block: B:138:0x01d5, code skipped:
            r2 = (com.amap.api.mapcore.util.o) r1.O0000oOO.get();
     */
        /* JADX WARNING: Missing block: B:139:0x01dd, code skipped:
            if (r2 == null) goto L_0x01e6;
     */
        /* JADX WARNING: Missing block: B:140:0x01df, code skipped:
            com.amap.api.mapcore.util.o.O0000OOo(r2).onDrawFrame(r8);
     */
        /* JADX WARNING: Missing block: B:141:0x01e6, code skipped:
            r2 = r1.O0000oO.O00000o();
     */
        /* JADX WARNING: Missing block: B:142:0x01ee, code skipped:
            if (r2 == 12288) goto L_0x0217;
     */
        /* JADX WARNING: Missing block: B:144:0x01f2, code skipped:
            if (r2 == 12302) goto L_0x0212;
     */
        /* JADX WARNING: Missing block: B:145:0x01f4, code skipped:
            r17 = r4;
            com.amap.api.mapcore.util.o.O0000Oo.O000000o("GLThread", "eglSwapBuffers", r2);
            r2 = com.amap.api.mapcore.util.o.O00000oO();
     */
        /* JADX WARNING: Missing block: B:146:0x0201, code skipped:
            monitor-enter(r2);
     */
        /* JADX WARNING: Missing block: B:147:0x0202, code skipped:
            r3 = true;
     */
        /* JADX WARNING: Missing block: B:149:?, code skipped:
            r1.O00000oo = true;
            com.amap.api.mapcore.util.o.O00000oO().notifyAll();
     */
        /* JADX WARNING: Missing block: B:150:0x020c, code skipped:
            monitor-exit(r2);
     */
        /* JADX WARNING: Missing block: B:157:0x0212, code skipped:
            r17 = r4;
            r3 = true;
            r6 = true;
     */
        /* JADX WARNING: Missing block: B:158:0x0217, code skipped:
            r17 = r4;
            r3 = true;
     */
        /* JADX WARNING: Missing block: B:159:0x021a, code skipped:
            if (r7 == false) goto L_0x021f;
     */
        /* JADX WARNING: Missing block: B:160:0x021c, code skipped:
            r4 = r3;
     */
        /* JADX WARNING: Missing block: B:161:0x021f, code skipped:
            r4 = r17;
     */
        private void O0000Ooo() throws java.lang.InterruptedException {
            /*
            r18 = this;
            r1 = r18;
            r2 = new com.amap.api.mapcore.util.o$O0000Oo;
            r3 = r1.O0000oOO;
            r2.<init>(r3);
            r1.O0000oO = r2;
            r2 = 0;
            r1.O0000OOo = r2;
            r1.O0000Oo0 = r2;
            r4 = r2;
            r5 = r4;
            r6 = r5;
            r7 = r6;
            r9 = r7;
            r10 = r9;
            r12 = r10;
            r13 = r12;
            r14 = r13;
            r15 = r14;
            r8 = 0;
        L_0x001b:
            r11 = 0;
        L_0x001c:
            r16 = com.amap.api.mapcore.util.o.O000000o;	 Catch:{ all -> 0x0232 }
            monitor-enter(r16);	 Catch:{ all -> 0x0232 }
        L_0x0021:
            r3 = r1.O000000o;	 Catch:{ all -> 0x022e }
            if (r3 == 0) goto L_0x0037;
        L_0x0025:
            monitor-exit(r16);	 Catch:{ all -> 0x022e }
            r2 = com.amap.api.mapcore.util.o.O000000o;
            monitor-enter(r2);
            r18.O0000Oo();	 Catch:{ all -> 0x0033 }
            r18.O0000OoO();	 Catch:{ all -> 0x0033 }
            monitor-exit(r2);	 Catch:{ all -> 0x0033 }
            return;
        L_0x0033:
            r0 = move-exception;
            r3 = r0;
            monitor-exit(r2);	 Catch:{ all -> 0x0033 }
            throw r3;
        L_0x0037:
            r3 = r1.O0000o;	 Catch:{ all -> 0x022e }
            r3 = r3.isEmpty();	 Catch:{ all -> 0x022e }
            if (r3 != 0) goto L_0x004c;
        L_0x003f:
            r3 = r1.O0000o;	 Catch:{ all -> 0x022e }
            r11 = 0;
            r3 = r3.remove(r11);	 Catch:{ all -> 0x022e }
            r3 = (java.lang.Runnable) r3;	 Catch:{ all -> 0x022e }
            r11 = r3;
            r3 = 0;
            goto L_0x0154;
        L_0x004c:
            r3 = r1.O00000o;	 Catch:{ all -> 0x022e }
            r2 = r1.O00000o0;	 Catch:{ all -> 0x022e }
            if (r3 == r2) goto L_0x0060;
        L_0x0052:
            r2 = r1.O00000o0;	 Catch:{ all -> 0x022e }
            r3 = r1.O00000o0;	 Catch:{ all -> 0x022e }
            r1.O00000o = r3;	 Catch:{ all -> 0x022e }
            r3 = com.amap.api.mapcore.util.o.O000000o;	 Catch:{ all -> 0x022e }
            r3.notifyAll();	 Catch:{ all -> 0x022e }
            goto L_0x0061;
        L_0x0060:
            r2 = 0;
        L_0x0061:
            r3 = r1.O0000OoO;	 Catch:{ all -> 0x022e }
            if (r3 == 0) goto L_0x006f;
        L_0x0065:
            r18.O0000Oo();	 Catch:{ all -> 0x022e }
            r18.O0000OoO();	 Catch:{ all -> 0x022e }
            r3 = 0;
            r1.O0000OoO = r3;	 Catch:{ all -> 0x022e }
            r5 = 1;
        L_0x006f:
            if (r6 == 0) goto L_0x0078;
        L_0x0071:
            r18.O0000Oo();	 Catch:{ all -> 0x022e }
            r18.O0000OoO();	 Catch:{ all -> 0x022e }
            r6 = 0;
        L_0x0078:
            if (r2 == 0) goto L_0x0081;
        L_0x007a:
            r3 = r1.O0000Oo0;	 Catch:{ all -> 0x022e }
            if (r3 == 0) goto L_0x0081;
        L_0x007e:
            r18.O0000Oo();	 Catch:{ all -> 0x022e }
        L_0x0081:
            if (r2 == 0) goto L_0x00a6;
        L_0x0083:
            r3 = r1.O0000OOo;	 Catch:{ all -> 0x022e }
            if (r3 == 0) goto L_0x00a6;
        L_0x0087:
            r3 = r1.O0000oOO;	 Catch:{ all -> 0x022e }
            r3 = r3.get();	 Catch:{ all -> 0x022e }
            r3 = (com.amap.api.mapcore.util.o) r3;	 Catch:{ all -> 0x022e }
            if (r3 != 0) goto L_0x0093;
        L_0x0091:
            r3 = 0;
            goto L_0x0097;
        L_0x0093:
            r3 = r3.O0000Ooo;	 Catch:{ all -> 0x022e }
        L_0x0097:
            if (r3 == 0) goto L_0x00a3;
        L_0x0099:
            r3 = com.amap.api.mapcore.util.o.O000000o;	 Catch:{ all -> 0x022e }
            r3 = r3.O000000o();	 Catch:{ all -> 0x022e }
            if (r3 == 0) goto L_0x00a6;
        L_0x00a3:
            r18.O0000OoO();	 Catch:{ all -> 0x022e }
        L_0x00a6:
            if (r2 == 0) goto L_0x00b7;
        L_0x00a8:
            r2 = com.amap.api.mapcore.util.o.O000000o;	 Catch:{ all -> 0x022e }
            r2 = r2.O00000Oo();	 Catch:{ all -> 0x022e }
            if (r2 == 0) goto L_0x00b7;
        L_0x00b2:
            r2 = r1.O0000oO;	 Catch:{ all -> 0x022e }
            r2.O00000oo();	 Catch:{ all -> 0x022e }
        L_0x00b7:
            r2 = r1.O00000oO;	 Catch:{ all -> 0x022e }
            if (r2 != 0) goto L_0x00d3;
        L_0x00bb:
            r2 = r1.O0000O0o;	 Catch:{ all -> 0x022e }
            if (r2 != 0) goto L_0x00d3;
        L_0x00bf:
            r2 = r1.O0000Oo0;	 Catch:{ all -> 0x022e }
            if (r2 == 0) goto L_0x00c6;
        L_0x00c3:
            r18.O0000Oo();	 Catch:{ all -> 0x022e }
        L_0x00c6:
            r2 = 1;
            r1.O0000O0o = r2;	 Catch:{ all -> 0x022e }
            r2 = 0;
            r1.O00000oo = r2;	 Catch:{ all -> 0x022e }
            r2 = com.amap.api.mapcore.util.o.O000000o;	 Catch:{ all -> 0x022e }
            r2.notifyAll();	 Catch:{ all -> 0x022e }
        L_0x00d3:
            r2 = r1.O00000oO;	 Catch:{ all -> 0x022e }
            if (r2 == 0) goto L_0x00e5;
        L_0x00d7:
            r2 = r1.O0000O0o;	 Catch:{ all -> 0x022e }
            if (r2 == 0) goto L_0x00e5;
        L_0x00db:
            r2 = 0;
            r1.O0000O0o = r2;	 Catch:{ all -> 0x022e }
            r2 = com.amap.api.mapcore.util.o.O000000o;	 Catch:{ all -> 0x022e }
            r2.notifyAll();	 Catch:{ all -> 0x022e }
        L_0x00e5:
            if (r4 == 0) goto L_0x00f3;
        L_0x00e7:
            r2 = 1;
            r1.O0000o0o = r2;	 Catch:{ all -> 0x022e }
            r2 = com.amap.api.mapcore.util.o.O000000o;	 Catch:{ all -> 0x022e }
            r2.notifyAll();	 Catch:{ all -> 0x022e }
            r4 = 0;
            r7 = 0;
        L_0x00f3:
            r2 = r18.O0000o00();	 Catch:{ all -> 0x022e }
            if (r2 == 0) goto L_0x0224;
        L_0x00f9:
            r2 = r1.O0000OOo;	 Catch:{ all -> 0x022e }
            if (r2 != 0) goto L_0x0126;
        L_0x00fd:
            if (r5 == 0) goto L_0x0101;
        L_0x00ff:
            r5 = 0;
            goto L_0x0126;
        L_0x0101:
            r2 = com.amap.api.mapcore.util.o.O000000o;	 Catch:{ all -> 0x022e }
            r2 = r2.O00000Oo(r1);	 Catch:{ all -> 0x022e }
            if (r2 == 0) goto L_0x0126;
        L_0x010b:
            r2 = r1.O0000oO;	 Catch:{ RuntimeException -> 0x011c }
            r2.O000000o();	 Catch:{ RuntimeException -> 0x011c }
            r2 = 1;
            r1.O0000OOo = r2;	 Catch:{ all -> 0x022e }
            r2 = com.amap.api.mapcore.util.o.O000000o;	 Catch:{ all -> 0x022e }
            r2.notifyAll();	 Catch:{ all -> 0x022e }
            r12 = 1;
            goto L_0x0126;
        L_0x011c:
            r0 = move-exception;
            r2 = r0;
            r3 = com.amap.api.mapcore.util.o.O000000o;	 Catch:{ all -> 0x022e }
            r3.O00000o0(r1);	 Catch:{ all -> 0x022e }
            throw r2;	 Catch:{ all -> 0x022e }
        L_0x0126:
            r2 = r1.O0000OOo;	 Catch:{ all -> 0x022e }
            if (r2 == 0) goto L_0x0135;
        L_0x012a:
            r2 = r1.O0000Oo0;	 Catch:{ all -> 0x022e }
            if (r2 != 0) goto L_0x0135;
        L_0x012e:
            r2 = 1;
            r1.O0000Oo0 = r2;	 Catch:{ all -> 0x022e }
            r2 = 1;
            r14 = 1;
            r15 = 1;
            goto L_0x0136;
        L_0x0135:
            r2 = r13;
        L_0x0136:
            r3 = r1.O0000Oo0;	 Catch:{ all -> 0x022e }
            if (r3 == 0) goto L_0x0223;
        L_0x013a:
            r3 = r1.O0000oO0;	 Catch:{ all -> 0x022e }
            if (r3 == 0) goto L_0x0149;
        L_0x013e:
            r9 = r1.O0000Ooo;	 Catch:{ all -> 0x022e }
            r10 = r1.O0000o00;	 Catch:{ all -> 0x022e }
            r3 = 0;
            r1.O0000oO0 = r3;	 Catch:{ all -> 0x022e }
            r2 = 1;
            r7 = 1;
            r15 = 1;
            goto L_0x014a;
        L_0x0149:
            r3 = 0;
        L_0x014a:
            r1.O0000o0O = r3;	 Catch:{ all -> 0x022e }
            r13 = com.amap.api.mapcore.util.o.O000000o;	 Catch:{ all -> 0x022e }
            r13.notifyAll();	 Catch:{ all -> 0x022e }
            r13 = r2;
        L_0x0154:
            monitor-exit(r16);	 Catch:{ all -> 0x022e }
            if (r11 == 0) goto L_0x015d;
        L_0x0157:
            r11.run();	 Catch:{ all -> 0x0232 }
            r2 = r3;
            goto L_0x001b;
        L_0x015d:
            if (r13 == 0) goto L_0x0196;
        L_0x015f:
            r2 = r1.O0000oO;	 Catch:{ all -> 0x0232 }
            r2 = r2.O00000Oo();	 Catch:{ all -> 0x0232 }
            if (r2 == 0) goto L_0x017d;
        L_0x0167:
            r2 = com.amap.api.mapcore.util.o.O000000o;	 Catch:{ all -> 0x0232 }
            monitor-enter(r2);	 Catch:{ all -> 0x0232 }
            r13 = 1;
            r1.O0000Oo = r13;	 Catch:{ all -> 0x0179 }
            r13 = com.amap.api.mapcore.util.o.O000000o;	 Catch:{ all -> 0x0179 }
            r13.notifyAll();	 Catch:{ all -> 0x0179 }
            monitor-exit(r2);	 Catch:{ all -> 0x0179 }
            r13 = r3;
            goto L_0x0196;
        L_0x0179:
            r0 = move-exception;
            r3 = r0;
            monitor-exit(r2);	 Catch:{ all -> 0x0179 }
            throw r3;	 Catch:{ all -> 0x0232 }
        L_0x017d:
            r2 = com.amap.api.mapcore.util.o.O000000o;	 Catch:{ all -> 0x0232 }
            monitor-enter(r2);	 Catch:{ all -> 0x0232 }
            r3 = 1;
            r1.O0000Oo = r3;	 Catch:{ all -> 0x0192 }
            r1.O00000oo = r3;	 Catch:{ all -> 0x0192 }
            r3 = com.amap.api.mapcore.util.o.O000000o;	 Catch:{ all -> 0x0192 }
            r3.notifyAll();	 Catch:{ all -> 0x0192 }
            monitor-exit(r2);	 Catch:{ all -> 0x0192 }
        L_0x018f:
            r2 = 0;
            goto L_0x001c;
        L_0x0192:
            r0 = move-exception;
            r3 = r0;
            monitor-exit(r2);	 Catch:{ all -> 0x0192 }
            throw r3;	 Catch:{ all -> 0x0232 }
        L_0x0196:
            if (r14 == 0) goto L_0x01a9;
        L_0x0198:
            r2 = r1.O0000oO;	 Catch:{ all -> 0x0232 }
            r2 = r2.O00000o0();	 Catch:{ all -> 0x0232 }
            r2 = (javax.microedition.khronos.opengles.GL10) r2;	 Catch:{ all -> 0x0232 }
            r3 = com.amap.api.mapcore.util.o.O000000o;	 Catch:{ all -> 0x0232 }
            r3.O000000o(r2);	 Catch:{ all -> 0x0232 }
            r8 = r2;
            r14 = 0;
        L_0x01a9:
            if (r12 == 0) goto L_0x01c1;
        L_0x01ab:
            r2 = r1.O0000oOO;	 Catch:{ all -> 0x0232 }
            r2 = r2.get();	 Catch:{ all -> 0x0232 }
            r2 = (com.amap.api.mapcore.util.o) r2;	 Catch:{ all -> 0x0232 }
            if (r2 == 0) goto L_0x01c0;
        L_0x01b5:
            r2 = r2.O00000o;	 Catch:{ all -> 0x0232 }
            r3 = r1.O0000oO;	 Catch:{ all -> 0x0232 }
            r3 = r3.O00000o;	 Catch:{ all -> 0x0232 }
            r2.onSurfaceCreated(r8, r3);	 Catch:{ all -> 0x0232 }
        L_0x01c0:
            r12 = 0;
        L_0x01c1:
            if (r15 == 0) goto L_0x01d5;
        L_0x01c3:
            r2 = r1.O0000oOO;	 Catch:{ all -> 0x0232 }
            r2 = r2.get();	 Catch:{ all -> 0x0232 }
            r2 = (com.amap.api.mapcore.util.o) r2;	 Catch:{ all -> 0x0232 }
            if (r2 == 0) goto L_0x01d4;
        L_0x01cd:
            r2 = r2.O00000o;	 Catch:{ all -> 0x0232 }
            r2.onSurfaceChanged(r8, r9, r10);	 Catch:{ all -> 0x0232 }
        L_0x01d4:
            r15 = 0;
        L_0x01d5:
            r2 = r1.O0000oOO;	 Catch:{ all -> 0x0232 }
            r2 = r2.get();	 Catch:{ all -> 0x0232 }
            r2 = (com.amap.api.mapcore.util.o) r2;	 Catch:{ all -> 0x0232 }
            if (r2 == 0) goto L_0x01e6;
        L_0x01df:
            r2 = r2.O00000o;	 Catch:{ all -> 0x0232 }
            r2.onDrawFrame(r8);	 Catch:{ all -> 0x0232 }
        L_0x01e6:
            r2 = r1.O0000oO;	 Catch:{ all -> 0x0232 }
            r2 = r2.O00000o();	 Catch:{ all -> 0x0232 }
            r3 = 12288; // 0x3000 float:1.7219E-41 double:6.071E-320;
            if (r2 == r3) goto L_0x0217;
        L_0x01f0:
            r3 = 12302; // 0x300e float:1.7239E-41 double:6.078E-320;
            if (r2 == r3) goto L_0x0212;
        L_0x01f4:
            r3 = "GLThread";
            r17 = r4;
            r4 = "eglSwapBuffers";
            com.amap.api.mapcore.util.o.O0000Oo.O000000o(r3, r4, r2);	 Catch:{ all -> 0x0232 }
            r2 = com.amap.api.mapcore.util.o.O000000o;	 Catch:{ all -> 0x0232 }
            monitor-enter(r2);	 Catch:{ all -> 0x0232 }
            r3 = 1;
            r1.O00000oo = r3;	 Catch:{ all -> 0x020e }
            r4 = com.amap.api.mapcore.util.o.O000000o;	 Catch:{ all -> 0x020e }
            r4.notifyAll();	 Catch:{ all -> 0x020e }
            monitor-exit(r2);	 Catch:{ all -> 0x020e }
            goto L_0x021a;
        L_0x020e:
            r0 = move-exception;
            r3 = r0;
            monitor-exit(r2);	 Catch:{ all -> 0x020e }
            throw r3;	 Catch:{ all -> 0x0232 }
        L_0x0212:
            r17 = r4;
            r3 = 1;
            r6 = r3;
            goto L_0x021a;
        L_0x0217:
            r17 = r4;
            r3 = 1;
        L_0x021a:
            if (r7 == 0) goto L_0x021f;
        L_0x021c:
            r4 = r3;
            goto L_0x018f;
        L_0x021f:
            r4 = r17;
            goto L_0x018f;
        L_0x0223:
            r13 = r2;
        L_0x0224:
            r2 = com.amap.api.mapcore.util.o.O000000o;	 Catch:{ all -> 0x022e }
            r2.wait();	 Catch:{ all -> 0x022e }
            r2 = 0;
            goto L_0x0021;
        L_0x022e:
            r0 = move-exception;
            r2 = r0;
            monitor-exit(r16);	 Catch:{ all -> 0x022e }
            throw r2;	 Catch:{ all -> 0x0232 }
        L_0x0232:
            r0 = move-exception;
            r2 = r0;
            r3 = com.amap.api.mapcore.util.o.O000000o;
            monitor-enter(r3);
            r18.O0000Oo();	 Catch:{ all -> 0x0241 }
            r18.O0000OoO();	 Catch:{ all -> 0x0241 }
            monitor-exit(r3);	 Catch:{ all -> 0x0241 }
            throw r2;
        L_0x0241:
            r0 = move-exception;
            r2 = r0;
            monitor-exit(r3);	 Catch:{ all -> 0x0241 }
            throw r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.o$O0000o00.O0000Ooo():void");
        }

        private boolean O0000o00() {
            return !this.O00000o && this.O00000oO && !this.O00000oo && this.O0000Ooo > 0 && this.O0000o00 > 0 && (this.O0000o0O || this.O0000o0 == 1);
        }

        public void O000000o(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (o.O000000o) {
                this.O0000o0 = i;
                o.O000000o.notifyAll();
            }
        }

        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0032 */
        /* JADX WARNING: Can't wrap try/catch for region: R(3:15|16|28) */
        /* JADX WARNING: Missing block: B:16:?, code skipped:
            java.lang.Thread.currentThread().interrupt();
     */
        public void O000000o(int r2, int r3) {
            /*
            r1 = this;
            r0 = com.amap.api.mapcore.util.o.O000000o;
            monitor-enter(r0);
            r1.O0000Ooo = r2;	 Catch:{ all -> 0x003c }
            r1.O0000o00 = r3;	 Catch:{ all -> 0x003c }
            r2 = 1;
            r1.O0000oO0 = r2;	 Catch:{ all -> 0x003c }
            r1.O0000o0O = r2;	 Catch:{ all -> 0x003c }
            r2 = 0;
            r1.O0000o0o = r2;	 Catch:{ all -> 0x003c }
            r2 = com.amap.api.mapcore.util.o.O000000o;	 Catch:{ all -> 0x003c }
            r2.notifyAll();	 Catch:{ all -> 0x003c }
        L_0x0018:
            r2 = r1.O00000Oo;	 Catch:{ all -> 0x003c }
            if (r2 != 0) goto L_0x003a;
        L_0x001c:
            r2 = r1.O00000o;	 Catch:{ all -> 0x003c }
            if (r2 != 0) goto L_0x003a;
        L_0x0020:
            r2 = r1.O0000o0o;	 Catch:{ all -> 0x003c }
            if (r2 != 0) goto L_0x003a;
        L_0x0024:
            r2 = r1.O000000o();	 Catch:{ all -> 0x003c }
            if (r2 == 0) goto L_0x003a;
        L_0x002a:
            r2 = com.amap.api.mapcore.util.o.O000000o;	 Catch:{ InterruptedException -> 0x0032 }
            r2.wait();	 Catch:{ InterruptedException -> 0x0032 }
            goto L_0x0018;
        L_0x0032:
            r2 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x003c }
            r2.interrupt();	 Catch:{ all -> 0x003c }
            goto L_0x0018;
        L_0x003a:
            monitor-exit(r0);	 Catch:{ all -> 0x003c }
            return;
        L_0x003c:
            r2 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x003c }
            throw r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.o$O0000o00.O000000o(int, int):void");
        }

        public void O000000o(Runnable runnable) {
            if (runnable == null) {
                throw new IllegalArgumentException("r must not be null");
            }
            synchronized (o.O000000o) {
                this.O0000o.add(runnable);
                o.O000000o.notifyAll();
            }
        }

        public boolean O000000o() {
            return this.O0000OOo && this.O0000Oo0 && O0000o00();
        }

        public int O00000Oo() {
            int i;
            synchronized (o.O000000o) {
                i = this.O0000o0;
            }
            return i;
        }

        /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0026 */
        /* JADX WARNING: Can't wrap try/catch for region: R(3:14|15|26) */
        /* JADX WARNING: Missing block: B:15:?, code skipped:
            java.lang.Thread.currentThread().interrupt();
     */
        public void O00000o() {
            /*
            r2 = this;
            r0 = com.amap.api.mapcore.util.o.O000000o;
            monitor-enter(r0);
            r1 = 1;
            r2.O00000oO = r1;	 Catch:{ all -> 0x0030 }
            r1 = 0;
            r2.O0000Oo = r1;	 Catch:{ all -> 0x0030 }
            r1 = com.amap.api.mapcore.util.o.O000000o;	 Catch:{ all -> 0x0030 }
            r1.notifyAll();	 Catch:{ all -> 0x0030 }
        L_0x0012:
            r1 = r2.O0000O0o;	 Catch:{ all -> 0x0030 }
            if (r1 == 0) goto L_0x002e;
        L_0x0016:
            r1 = r2.O0000Oo;	 Catch:{ all -> 0x0030 }
            if (r1 != 0) goto L_0x002e;
        L_0x001a:
            r1 = r2.O00000Oo;	 Catch:{ all -> 0x0030 }
            if (r1 != 0) goto L_0x002e;
        L_0x001e:
            r1 = com.amap.api.mapcore.util.o.O000000o;	 Catch:{ InterruptedException -> 0x0026 }
            r1.wait();	 Catch:{ InterruptedException -> 0x0026 }
            goto L_0x0012;
        L_0x0026:
            r1 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x0030 }
            r1.interrupt();	 Catch:{ all -> 0x0030 }
            goto L_0x0012;
        L_0x002e:
            monitor-exit(r0);	 Catch:{ all -> 0x0030 }
            return;
        L_0x0030:
            r1 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x0030 }
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.o$O0000o00.O00000o():void");
        }

        public void O00000o0() {
            synchronized (o.O000000o) {
                this.O0000o0O = true;
                o.O000000o.notifyAll();
            }
        }

        /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x001f */
        /* JADX WARNING: Can't wrap try/catch for region: R(3:12|13|23) */
        /* JADX WARNING: Missing block: B:13:?, code skipped:
            java.lang.Thread.currentThread().interrupt();
     */
        public void O00000oO() {
            /*
            r2 = this;
            r0 = com.amap.api.mapcore.util.o.O000000o;
            monitor-enter(r0);
            r1 = 0;
            r2.O00000oO = r1;	 Catch:{ all -> 0x0029 }
            r1 = com.amap.api.mapcore.util.o.O000000o;	 Catch:{ all -> 0x0029 }
            r1.notifyAll();	 Catch:{ all -> 0x0029 }
        L_0x000f:
            r1 = r2.O0000O0o;	 Catch:{ all -> 0x0029 }
            if (r1 != 0) goto L_0x0027;
        L_0x0013:
            r1 = r2.O00000Oo;	 Catch:{ all -> 0x0029 }
            if (r1 != 0) goto L_0x0027;
        L_0x0017:
            r1 = com.amap.api.mapcore.util.o.O000000o;	 Catch:{ InterruptedException -> 0x001f }
            r1.wait();	 Catch:{ InterruptedException -> 0x001f }
            goto L_0x000f;
        L_0x001f:
            r1 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x0029 }
            r1.interrupt();	 Catch:{ all -> 0x0029 }
            goto L_0x000f;
        L_0x0027:
            monitor-exit(r0);	 Catch:{ all -> 0x0029 }
            return;
        L_0x0029:
            r1 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x0029 }
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.o$O0000o00.O00000oO():void");
        }

        /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x001f */
        /* JADX WARNING: Can't wrap try/catch for region: R(3:12|13|23) */
        /* JADX WARNING: Missing block: B:13:?, code skipped:
            java.lang.Thread.currentThread().interrupt();
     */
        public void O00000oo() {
            /*
            r2 = this;
            r0 = com.amap.api.mapcore.util.o.O000000o;
            monitor-enter(r0);
            r1 = 1;
            r2.O00000o0 = r1;	 Catch:{ all -> 0x0029 }
            r1 = com.amap.api.mapcore.util.o.O000000o;	 Catch:{ all -> 0x0029 }
            r1.notifyAll();	 Catch:{ all -> 0x0029 }
        L_0x000f:
            r1 = r2.O00000Oo;	 Catch:{ all -> 0x0029 }
            if (r1 != 0) goto L_0x0027;
        L_0x0013:
            r1 = r2.O00000o;	 Catch:{ all -> 0x0029 }
            if (r1 != 0) goto L_0x0027;
        L_0x0017:
            r1 = com.amap.api.mapcore.util.o.O000000o;	 Catch:{ InterruptedException -> 0x001f }
            r1.wait();	 Catch:{ InterruptedException -> 0x001f }
            goto L_0x000f;
        L_0x001f:
            r1 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x0029 }
            r1.interrupt();	 Catch:{ all -> 0x0029 }
            goto L_0x000f;
        L_0x0027:
            monitor-exit(r0);	 Catch:{ all -> 0x0029 }
            return;
        L_0x0029:
            r1 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x0029 }
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.o$O0000o00.O00000oo():void");
        }

        /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0028 */
        /* JADX WARNING: Can't wrap try/catch for region: R(3:14|15|26) */
        /* JADX WARNING: Missing block: B:15:?, code skipped:
            java.lang.Thread.currentThread().interrupt();
     */
        public void O0000O0o() {
            /*
            r3 = this;
            r0 = com.amap.api.mapcore.util.o.O000000o;
            monitor-enter(r0);
            r1 = 0;
            r3.O00000o0 = r1;	 Catch:{ all -> 0x0032 }
            r2 = 1;
            r3.O0000o0O = r2;	 Catch:{ all -> 0x0032 }
            r3.O0000o0o = r1;	 Catch:{ all -> 0x0032 }
            r1 = com.amap.api.mapcore.util.o.O000000o;	 Catch:{ all -> 0x0032 }
            r1.notifyAll();	 Catch:{ all -> 0x0032 }
        L_0x0014:
            r1 = r3.O00000Oo;	 Catch:{ all -> 0x0032 }
            if (r1 != 0) goto L_0x0030;
        L_0x0018:
            r1 = r3.O00000o;	 Catch:{ all -> 0x0032 }
            if (r1 == 0) goto L_0x0030;
        L_0x001c:
            r1 = r3.O0000o0o;	 Catch:{ all -> 0x0032 }
            if (r1 != 0) goto L_0x0030;
        L_0x0020:
            r1 = com.amap.api.mapcore.util.o.O000000o;	 Catch:{ InterruptedException -> 0x0028 }
            r1.wait();	 Catch:{ InterruptedException -> 0x0028 }
            goto L_0x0014;
        L_0x0028:
            r1 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x0032 }
            r1.interrupt();	 Catch:{ all -> 0x0032 }
            goto L_0x0014;
        L_0x0030:
            monitor-exit(r0);	 Catch:{ all -> 0x0032 }
            return;
        L_0x0032:
            r1 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x0032 }
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.o$O0000o00.O0000O0o():void");
        }

        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001b */
        /* JADX WARNING: Can't wrap try/catch for region: R(3:10|11|20) */
        /* JADX WARNING: Missing block: B:11:?, code skipped:
            java.lang.Thread.currentThread().interrupt();
     */
        public void O0000OOo() {
            /*
            r2 = this;
            r0 = com.amap.api.mapcore.util.o.O000000o;
            monitor-enter(r0);
            r1 = 1;
            r2.O000000o = r1;	 Catch:{ all -> 0x0025 }
            r1 = com.amap.api.mapcore.util.o.O000000o;	 Catch:{ all -> 0x0025 }
            r1.notifyAll();	 Catch:{ all -> 0x0025 }
        L_0x000f:
            r1 = r2.O00000Oo;	 Catch:{ all -> 0x0025 }
            if (r1 != 0) goto L_0x0023;
        L_0x0013:
            r1 = com.amap.api.mapcore.util.o.O000000o;	 Catch:{ InterruptedException -> 0x001b }
            r1.wait();	 Catch:{ InterruptedException -> 0x001b }
            goto L_0x000f;
        L_0x001b:
            r1 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x0025 }
            r1.interrupt();	 Catch:{ all -> 0x0025 }
            goto L_0x000f;
        L_0x0023:
            monitor-exit(r0);	 Catch:{ all -> 0x0025 }
            return;
        L_0x0025:
            r1 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x0025 }
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.o$O0000o00.O0000OOo():void");
        }

        public void O0000Oo0() {
            this.O0000OoO = true;
            o.O000000o.notifyAll();
        }

        public void run() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("GLThread ");
            stringBuilder.append(getId());
            setName(stringBuilder.toString());
            try {
                O0000Ooo();
            } catch (InterruptedException unused) {
            } catch (Throwable th) {
                o.O000000o.O000000o(this);
            }
            o.O000000o.O000000o(this);
        }
    }

    /* compiled from: GLTextureView */
    private static class O0000o0 {
        private static String O000000o = "GLThreadManager";
        private boolean O00000Oo;
        private boolean O00000o;
        private int O00000o0;
        private boolean O00000oO;
        private boolean O00000oo;
        private O0000o00 O0000O0o;

        private O0000o0() {
        }

        private void O00000o0() {
            if (!this.O00000Oo) {
                this.O00000o0 = 131072;
                if (this.O00000o0 >= 131072) {
                    this.O00000oO = true;
                }
                this.O00000Oo = true;
            }
        }

        public synchronized void O000000o(O0000o00 o0000o00) {
            o0000o00.O00000Oo = true;
            if (this.O0000O0o == o0000o00) {
                this.O0000O0o = null;
            }
            notifyAll();
        }

        public synchronized void O000000o(GL10 gl10) {
            if (!(this.O00000o || gl10 == null)) {
                O00000o0();
                String glGetString = gl10.glGetString(7937);
                if (this.O00000o0 < 131072) {
                    this.O00000oO = glGetString.startsWith("Q3Dimension MSM7500 ") ^ 1;
                    notifyAll();
                }
                this.O00000oo = this.O00000oO ^ 1;
                this.O00000o = true;
            }
        }

        public synchronized boolean O000000o() {
            return this.O00000oo;
        }

        public synchronized boolean O00000Oo() {
            O00000o0();
            return this.O00000oO ^ 1;
        }

        public boolean O00000Oo(O0000o00 o0000o00) {
            if (this.O0000O0o == o0000o00 || this.O0000O0o == null) {
                this.O0000O0o = o0000o00;
                notifyAll();
                return true;
            }
            O00000o0();
            if (this.O00000oO) {
                return true;
            }
            if (this.O0000O0o != null) {
                this.O0000O0o.O0000Oo0();
            }
            return false;
        }

        public void O00000o0(O0000o00 o0000o00) {
            if (this.O0000O0o == o0000o00) {
                this.O0000O0o = null;
            }
            notifyAll();
        }
    }

    /* compiled from: GLTextureView */
    public interface O0000o {
        GL O000000o(GL gl);
    }

    /* compiled from: GLTextureView */
    private class O000O00o extends O00000Oo {
        public O000O00o(boolean z) {
            super(8, 8, 8, 0, z ? 16 : 0, 0);
        }
    }

    /* compiled from: GLTextureView */
    static class O00oOooO extends Writer {
        private StringBuilder O000000o = new StringBuilder();

        O00oOooO() {
        }

        private void O000000o() {
            if (this.O000000o.length() > 0) {
                Log.v("GLSurfaceView", this.O000000o.toString());
                this.O000000o.delete(0, this.O000000o.length());
            }
        }

        public void close() {
            O000000o();
        }

        public void flush() {
            O000000o();
        }

        public void write(char[] cArr, int i, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                char c = cArr[i + i3];
                if (c == 10) {
                    O000000o();
                } else {
                    this.O000000o.append(c);
                }
            }
        }
    }

    public o(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o();
    }

    private void O000000o() {
        setSurfaceTextureListener(this);
    }

    private void O00000Oo() {
        if (this.O00000o0 != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    public void O000000o(O0000O0o o0000O0o) {
        O00000Oo();
        this.O00000oo = o0000O0o;
    }

    public void O000000o(O0000OOo o0000OOo) {
        O00000Oo();
        this.O0000O0o = o0000OOo;
    }

    public void O00000o() {
        this.O00000o0.O0000O0o();
    }

    public void O00000o0() {
        this.O00000o0.O00000oo();
    }

    /* Access modifiers changed, original: protected */
    public void finalize() throws Throwable {
        try {
            if (this.O00000o0 != null) {
                this.O00000o0.O0000OOo();
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    public int getRenderMode() {
        return this.O00000o0.O00000Oo();
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.O00000oO && this.O00000o != null) {
            int O00000Oo = this.O00000o0 != null ? this.O00000o0.O00000Oo() : 1;
            this.O00000o0 = new O0000o00(this.O00000Oo);
            if (O00000Oo != 1) {
                this.O00000o0.O000000o(O00000Oo);
            }
            this.O00000o0.start();
        }
        this.O00000oO = false;
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        if (this.O00000o0 != null) {
            this.O00000o0.O0000OOo();
        }
        this.O00000oO = true;
        super.onDetachedFromWindow();
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        onSurfaceTextureSizeChanged(getSurfaceTexture(), i3 - i, i4 - i2);
        super.onLayout(z, i, i2, i3, i4);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.O00000o0.O00000o();
        onSurfaceTextureSizeChanged(surfaceTexture, i, i2);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.O00000o0.O00000oO();
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        this.O00000o0.O000000o(i, i2);
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void queueEvent(Runnable runnable) {
        this.O00000o0.O000000o(runnable);
    }

    public void requestRender() {
        this.O00000o0.O00000o0();
    }

    public void setRenderMode(int i) {
        this.O00000o0.O000000o(i);
    }

    public void setRenderer(Renderer renderer) {
        O00000Oo();
        if (this.O00000oo == null) {
            this.O00000oo = new O000O00o(true);
        }
        if (this.O0000O0o == null) {
            this.O0000O0o = new O00000o0();
        }
        if (this.O0000OOo == null) {
            this.O0000OOo = new O00000o();
        }
        this.O00000o = renderer;
        this.O00000o0 = new O0000o00(this.O00000Oo);
        this.O00000o0.start();
    }
}
