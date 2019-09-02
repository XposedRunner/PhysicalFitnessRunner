package com.amap.api.mapcore.util;

import android.graphics.Color;
import android.opengl.GLES20;
import android.util.Log;
import android.view.SurfaceHolder;
import com.amap.api.mapcore.util.OO00O.O0000O0o;
import com.autonavi.amap.mapcore.AMapNativeRenderer;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

/* compiled from: GlesUtility */
public class OOO00Oo {

    /* compiled from: GlesUtility */
    public static class O000000o extends OOO000o {
        private static int O0000O0o = 4;
        protected int O000000o;
        protected int O00000Oo;
        protected int O00000o;
        protected int O00000o0;
        protected int O00000oO;
        protected int O00000oo;
        private int[] O0000OOo = new int[1];

        public O000000o(int i, int i2, int i3, int i4, int i5, int i6) {
            this.O000000o = i;
            this.O00000Oo = i2;
            this.O00000o0 = i3;
            this.O00000o = i4;
            this.O00000oO = i5;
            this.O00000oo = i6;
        }

        private int O000000o(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.O0000OOo) ? this.O0000OOo[0] : i2;
        }

        private O00000o0 O000000o(EGL10 egl10, EGLDisplay eGLDisplay) {
            O00000o0 o00000o0 = new O00000o0();
            o00000o0.O000000o = O000000o(2, true);
            egl10.eglChooseConfig(eGLDisplay, o00000o0.O000000o, null, 0, o00000o0.O00000Oo);
            if (o00000o0.O00000Oo[0] <= 0) {
                o00000o0.O000000o = O000000o(2, false);
                egl10.eglChooseConfig(eGLDisplay, o00000o0.O000000o, null, 0, o00000o0.O00000Oo);
                if (o00000o0.O00000Oo[0] <= 0) {
                    return null;
                }
            }
            return o00000o0;
        }

        private int[] O000000o(int i, boolean z) {
            if (i == 2) {
                return new int[]{12324, this.O000000o, 12323, this.O00000Oo, 12322, this.O00000o0, 12321, this.O00000o, 12325, this.O00000oO, 12326, this.O00000oo, 12338, z, 12352, O0000O0o, 12344};
            } else if (z) {
                return new int[]{12324, this.O000000o, 12323, this.O00000Oo, 12322, this.O00000o0, 12338, 1, 12344};
            } else {
                return new int[]{12324, this.O000000o, 12323, this.O00000Oo, 12322, this.O00000o0, 12344};
            }
        }

        public EGLConfig O000000o(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                EGL10 egl102 = egl10;
                EGLDisplay eGLDisplay2 = eGLDisplay;
                EGLConfig eGLConfig2 = eGLConfig;
                int O000000o = O000000o(egl102, eGLDisplay2, eGLConfig2, 12325, 0);
                int O000000o2 = O000000o(egl102, eGLDisplay2, eGLConfig2, 12326, 0);
                if (O000000o >= this.O00000oO && O000000o2 >= this.O00000oo) {
                    egl102 = egl10;
                    eGLDisplay2 = eGLDisplay;
                    eGLConfig2 = eGLConfig;
                    O000000o = O000000o(egl102, eGLDisplay2, eGLConfig2, 12324, 0);
                    int O000000o3 = O000000o(egl102, eGLDisplay2, eGLConfig2, 12323, 0);
                    int O000000o4 = O000000o(egl102, eGLDisplay2, eGLConfig2, 12322, 0);
                    O000000o2 = O000000o(egl102, eGLDisplay2, eGLConfig2, 12321, 0);
                    if (O000000o == this.O000000o && O000000o3 == this.O00000Oo && O000000o4 == this.O00000o0 && O000000o2 == this.O00000o) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            O00000o0 O000000o = O000000o(egl10, eGLDisplay);
            if (O000000o == null || O000000o.O000000o == null) {
                return null;
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[O000000o.O00000Oo[0]];
            egl10.eglChooseConfig(eGLDisplay, O000000o.O000000o, eGLConfigArr, O000000o.O00000Oo[0], O000000o.O00000Oo);
            EGLConfig O000000o2 = O000000o(egl10, eGLDisplay, eGLConfigArr);
            if (O000000o2 == null) {
                this.O000000o = 8;
                this.O00000Oo = 8;
                this.O00000o0 = 8;
                O00000o0 O000000o3 = O000000o(egl10, eGLDisplay);
                if (!(O000000o3 == null || O000000o3.O000000o == null)) {
                    EGLConfig[] eGLConfigArr2 = new EGLConfig[O000000o3.O00000Oo[0]];
                    egl10.eglChooseConfig(eGLDisplay, O000000o3.O000000o, eGLConfigArr2, O000000o3.O00000Oo[0], O000000o3.O00000Oo);
                    O000000o2 = O000000o(egl10, eGLDisplay, eGLConfigArr2);
                }
            }
            return O000000o2;
        }
    }

    /* compiled from: GlesUtility */
    public static class O00000Oo extends OOO00O0 {
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            try {
                return egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            egl10.eglDestroyContext(eGLDisplay, eGLContext);
        }
    }

    /* compiled from: GlesUtility */
    private static class O00000o0 {
        public int[] O000000o;
        public int[] O00000Oo;

        private O00000o0() {
            this.O000000o = null;
            this.O00000Oo = new int[1];
        }
    }

    private static void O000000o(O0000O0o o0000O0o, int i, int i2, FloatBuffer floatBuffer, float f, int i3, int i4, float[] fArr) {
        O0000O0o o0000O0o2 = o0000O0o;
        if (f != 0.0f && o0000O0o2 != null) {
            o0000O0o2.O000000o();
            GLES20.glEnable(3042);
            GLES20.glDisable(2929);
            GLES20.glBlendFunc(770, 771);
            float alpha = ((float) Color.alpha(i2)) / 255.0f;
            float red = ((float) Color.red(i2)) / 255.0f;
            float green = ((float) Color.green(i2)) / 255.0f;
            float blue = ((float) Color.blue(i2)) / 255.0f;
            float[] fArr2 = new float[]{red, green, blue, alpha};
            GLES20.glLineWidth(f);
            GLES20.glEnableVertexAttribArray(o0000O0o2.O00000Oo);
            GLES20.glVertexAttribPointer(o0000O0o2.O00000Oo, 3, 5126, false, 0, floatBuffer);
            GLES20.glUniform4fv(o0000O0o2.O00000o0, 1, fArr2, 0);
            GLES20.glUniformMatrix4fv(o0000O0o2.O000000o, 1, false, fArr, 0);
            GLES20.glDrawArrays(i, i3, i4);
            GLES20.glDisableVertexAttribArray(o0000O0o2.O00000Oo);
            GLES20.glDisable(3042);
            GLES20.glUseProgram(0);
        }
    }

    private static void O000000o(O0000O0o o0000O0o, int i, int i2, FloatBuffer floatBuffer, float f, int i3, float[] fArr) {
        O000000o(o0000O0o, 2, i2, floatBuffer, f, 1, i3 - 1, fArr);
    }

    public static void O000000o(O0000O0o o0000O0o, int i, int i2, FloatBuffer floatBuffer, float f, int i3, float[] fArr, float f2, int i4) {
        O00000Oo(o0000O0o, 6, i, floatBuffer, 1.0f, i3, fArr);
        O00000Oo(o0000O0o, i, i2, floatBuffer, f, i3, fArr, f2, i4);
    }

    private static void O000000o(O0000O0o o0000O0o, int i, int i2, FloatBuffer floatBuffer, float f, int i3, float[] fArr, int i4) {
        FloatBuffer floatBuffer2 = floatBuffer;
        int i5 = i3;
        try {
            float alpha = ((float) Color.alpha(i2)) / 255.0f;
            float red = ((float) Color.red(i2)) / 255.0f;
            float green = ((float) Color.green(i2)) / 255.0f;
            float blue = ((float) Color.blue(i2)) / 255.0f;
            if (i5 >= 3) {
                i5 = (i5 - 2) * 3;
                if (floatBuffer2 != null) {
                    if (floatBuffer.limit() >= i5 + 3) {
                        float[] fArr2 = new float[i5];
                        for (int i6 = 0; i6 < i5; i6++) {
                            fArr2[i6] = floatBuffer2.get(i6 + 3);
                        }
                        AMapNativeRenderer.nativeDrawLineByTextureID(fArr2, fArr2.length, f, i4, red, green, blue, alpha, 0.0f, true, true, false, fArr, 3, 0);
                    }
                }
            }
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "GlesUtility", "drawCircleLine");
        }
    }

    public static void O000000o(O0000O0o o0000O0o, int i, int i2, FloatBuffer floatBuffer, float f, FloatBuffer floatBuffer2, int i3, int i4, float[] fArr) {
        O00000Oo(o0000O0o, 4, i, floatBuffer2, 1.0f, i4, fArr);
        O00000Oo(o0000O0o, 2, i2, floatBuffer, f, i3, fArr);
    }

    public static void O000000o(cb cbVar, int i, int i2, int i3, int i4, int i5, int i6) {
        if (i4 > 0) {
            SurfaceHolder holder = cbVar.getHolder();
            if (holder != null) {
                holder.setFormat(-3);
            }
        }
        cbVar.O000000o(new O00000Oo());
        cbVar.O000000o(new O000000o(i, i2, i3, i4, i5, i6));
    }

    public static void O000000o(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(": glError ");
            stringBuilder.append(glGetError);
            Log.e("amap", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(": glError ");
            stringBuilder.append(glGetError);
            throw new RuntimeException(stringBuilder.toString());
        }
    }

    private static void O00000Oo(O0000O0o o0000O0o, int i, int i2, FloatBuffer floatBuffer, float f, int i3, float[] fArr) {
        O000000o(o0000O0o, i, i2, floatBuffer, f, 0, i3, fArr);
    }

    public static void O00000Oo(O0000O0o o0000O0o, int i, int i2, FloatBuffer floatBuffer, float f, int i3, float[] fArr, float f2, int i4) {
        int i5 = i4;
        if (i5 != -1) {
            O000000o(o0000O0o, i, i2, floatBuffer, f * f2, i3, fArr, i5);
            return;
        }
        O000000o(o0000O0o, i, i2, floatBuffer, f, i3, fArr);
    }

    public static void O00000Oo(O0000O0o o0000O0o, int i, int i2, FloatBuffer floatBuffer, float f, FloatBuffer floatBuffer2, int i3, int i4, float[] fArr) {
        O00000Oo(o0000O0o, 2, i2, floatBuffer, f, i3, fArr);
    }
}
