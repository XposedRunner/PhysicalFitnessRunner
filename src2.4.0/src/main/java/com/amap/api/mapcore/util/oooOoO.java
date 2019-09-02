package com.amap.api.mapcore.util;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
import com.amap.api.mapcore.util.OO00O.O000000o;
import com.amap.api.maps.model.BitmapDescriptor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/* compiled from: FakeInstanceMultiPoint */
public class oooOoO {
    public static int O000000o = 200;
    float[] O00000Oo = null;
    int O00000o = 0;
    int O00000o0 = 0;
    private boolean O00000oO = false;
    private boolean O00000oo = false;
    private BitmapDescriptor O0000O0o;
    private FloatBuffer O0000OOo;
    private int O0000Oo = 0;
    private ShortBuffer O0000Oo0;
    private O000000o O0000OoO;
    private OO00O O0000Ooo;

    public oooOoO(float[] fArr, O00O00Oo o00O00Oo) {
        this.O00000Oo = fArr;
    }

    private void O000000o(Bitmap bitmap) {
        if (bitmap != null) {
            if (this.O0000Oo == 0) {
                int[] iArr = new int[1];
                GLES20.glGenTextures(1, iArr, 0);
                this.O0000Oo = iArr[0];
            }
            if (this.O0000Oo != 0) {
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(3553, this.O0000Oo);
                GLES20.glTexParameterf(3553, 10241, 9728.0f);
                GLES20.glTexParameterf(3553, 10240, 9729.0f);
                GLES20.glTexParameterf(3553, 10242, 33071.0f);
                GLES20.glTexParameterf(3553, 10243, 33071.0f);
                GLUtils.texImage2D(3553, 0, bitmap, 0);
                if (this.O0000Oo != 0) {
                    this.O00000oo = true;
                }
            }
        }
    }

    public static synchronized void O000000o(String str) {
        synchronized (oooOoO.class) {
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
    }

    private void O000000o(float[] fArr) {
        if (fArr != null) {
            int length;
            int i;
            if (this.O0000OOo == null) {
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect((fArr.length * O000000o) * 4);
                allocateDirect.order(ByteOrder.nativeOrder());
                this.O0000OOo = allocateDirect.asFloatBuffer();
            }
            this.O0000OOo.clear();
            int i2 = 0;
            for (int i3 = 0; i3 < O000000o; i3++) {
                length = fArr.length;
                int i4 = 0;
                i = i4;
                while (i4 < length) {
                    float f = fArr[i4];
                    if (i % 6 == 3) {
                        this.O0000OOo.put((float) i3);
                    } else {
                        this.O0000OOo.put(f);
                    }
                    i++;
                    i4++;
                }
            }
            this.O0000OOo.position(0);
            if (this.O0000Oo0 == null) {
                ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect((O000000o * 6) * 2);
                allocateDirect2.order(ByteOrder.nativeOrder());
                this.O0000Oo0 = allocateDirect2.asShortBuffer();
                short[] sArr = new short[(O000000o * 6)];
                while (i2 < O000000o) {
                    length = 6 * i2;
                    i = 4 * i2;
                    short s = (short) (i + 0);
                    sArr[length + 0] = s;
                    sArr[length + 1] = (short) (i + 1);
                    short s2 = (short) (i + 2);
                    sArr[length + 2] = s2;
                    sArr[length + 3] = s;
                    sArr[length + 4] = s2;
                    sArr[length + 5] = (short) (i + 3);
                    i2++;
                }
                this.O0000Oo0.put(sArr);
                this.O0000Oo0.flip();
            }
            this.O00000oO = true;
        }
    }

    private void O00000oO() {
        if (this.O00000o0 == 0) {
            int[] iArr = new int[2];
            GLES20.glGenBuffers(2, iArr, 0);
            this.O00000o0 = iArr[0];
            this.O00000o = iArr[1];
            GLES20.glBindBuffer(34962, this.O00000o0);
            GLES20.glBufferData(34962, this.O0000OOo.limit() * 4, this.O0000OOo, 35044);
            GLES20.glBindBuffer(34963, this.O00000o);
            GLES20.glBufferData(34963, (O000000o * 6) * 2, this.O0000Oo0, 35044);
            O000000o("bindVbo");
            this.O0000OOo.clear();
            this.O0000OOo = null;
        }
    }

    private void O00000oo() {
        try {
            if (this.O0000Ooo != null) {
                this.O0000OoO = (O000000o) this.O0000Ooo.O000000o(4);
            }
        } catch (Throwable unused) {
            O000000o = 1;
            if (this.O0000Ooo != null) {
                this.O0000OoO = (O000000o) this.O0000Ooo.O000000o(4);
            }
        }
    }

    public void O000000o() {
        if (this.O00000Oo != null && !this.O00000oO) {
            O000000o(this.O00000Oo);
        }
    }

    public void O000000o(OO00O oo00o) {
        this.O0000Ooo = oo00o;
    }

    public void O000000o(BitmapDescriptor bitmapDescriptor) {
        this.O0000O0o = bitmapDescriptor;
    }

    public void O000000o(float[] fArr, float[] fArr2, float[] fArr3, float f, float f2, float f3, float f4, int i) {
        if (!(this.O00000oo || this.O0000O0o == null)) {
            O000000o(this.O0000O0o.getBitmap());
        }
        if (this.O0000Oo != 0) {
            if (this.O0000OoO == null || this.O0000OoO.O00000o0()) {
                O00000oo();
            }
            O00000oO();
            GLES20.glUseProgram(this.O0000OoO.O00000o);
            GLES20.glUniform4f(this.O0000OoO.O0000Oo, f, f2, f3, f4);
            GLES20.glUniform3fv(this.O0000OoO.O0000Oo0, i, fArr3, 0);
            GLES20.glDisable(2929);
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(770, 771);
            GLES20.glBlendColor(1.0f, 1.0f, 1.0f, 1.0f);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.O0000Oo);
            GLES20.glEnableVertexAttribArray(this.O0000OoO.O00000o0);
            GLES20.glBindBuffer(34962, this.O00000o0);
            GLES20.glVertexAttribPointer(this.O0000OoO.O00000o0, 4, 5126, false, 24, 0);
            GLES20.glEnableVertexAttribArray(this.O0000OoO.O0000OOo);
            GLES20.glVertexAttribPointer(this.O0000OoO.O0000OOo, 2, 5126, false, 24, 16);
            GLES20.glUniformMatrix4fv(this.O0000OoO.O0000O0o, 1, false, fArr, 0);
            GLES20.glUniformMatrix4fv(this.O0000OoO.O0000OoO, 1, false, fArr2, 0);
            GLES20.glBindBuffer(34963, this.O00000o);
            GLES20.glDrawElements(4, 6 * i, 5123, 0);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindBuffer(34962, 0);
            GLES20.glDisableVertexAttribArray(this.O0000OoO.O00000o0);
            GLES20.glDisableVertexAttribArray(this.O0000OoO.O0000OOo);
            GLES20.glUseProgram(0);
        }
    }

    public boolean O00000Oo() {
        return this.O00000oO;
    }

    public boolean O00000o() {
        return this.O0000Ooo != null;
    }

    public void O00000o0() {
        if (this.O0000OOo != null) {
            this.O0000OOo.clear();
        }
        if (this.O0000Oo0 != null) {
            this.O0000Oo0.clear();
        }
        if (this.O0000O0o != null) {
            this.O0000O0o = null;
        }
        GLES20.glDeleteBuffers(2, new int[]{this.O00000o0, this.O00000o}, 0);
        if (this.O0000Oo != 0) {
            GLES20.glDeleteTextures(1, new int[]{this.O0000Oo}, 0);
        }
        this.O00000o0 = 0;
        this.O00000o = 0;
        this.O00000Oo = null;
        this.O00000oO = false;
        this.O00000oo = false;
        this.O00000o0 = 0;
        this.O00000o = 0;
        this.O0000Ooo = null;
    }
}
