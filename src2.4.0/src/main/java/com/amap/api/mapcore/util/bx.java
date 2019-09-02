package com.amap.api.mapcore.util;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.amap.api.mapcore.util.OO00O.O00000Oo;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GlModelCore */
public class bx {
    List<Float> O000000o = new ArrayList();
    List<Float> O00000Oo = new ArrayList();
    private FloatBuffer O00000o;
    private FloatBuffer O00000o0;
    private int O00000oO = 0;
    private float O00000oo;
    private float O0000O0o = 0.0f;
    private float O0000OOo = 0.0f;

    public bx(List<Float> list, List<Float> list2) {
        this.O000000o = list;
        this.O00000Oo = list2;
        if (this.O00000o0 == null) {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(list.size() * 4);
            allocateDirect.order(ByteOrder.nativeOrder());
            this.O00000o0 = allocateDirect.asFloatBuffer();
        }
        this.O00000o0.clear();
        float f = 0.0f;
        float f2 = f;
        float f3 = f2;
        float f4 = 1000000.0f;
        float f5 = f4;
        int i = 1;
        int i2 = i;
        while (i < list.size() + 1) {
            Float f6 = (Float) list.get(i - 1);
            this.O00000o0.put(f6.floatValue());
            if (i2 == 1) {
                f = Math.max(f6.floatValue(), f);
                f4 = Math.min(f6.floatValue(), f4);
            }
            if (i2 == 2) {
                f2 = Math.max(f6.floatValue(), f2);
                f5 = Math.min(f6.floatValue(), f5);
            }
            if (i2 == 3) {
                f3 = Math.max(f3, f6.floatValue());
                i2 = 0;
            }
            i2++;
            i++;
        }
        float abs = Math.abs(f - f4);
        float abs2 = Math.abs(f2 - f5);
        this.O0000O0o = abs > abs2 ? abs : abs2;
        if (abs > abs2) {
            abs = abs2;
        }
        this.O0000OOo = abs;
        this.O00000o0.position(0);
        if (this.O00000o == null) {
            ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(list2.size() * 4);
            allocateDirect2.order(ByteOrder.nativeOrder());
            this.O00000o = allocateDirect2.asFloatBuffer();
        }
        this.O00000o.clear();
        for (Float floatValue : list2) {
            this.O00000o.put(floatValue.floatValue());
        }
        this.O00000o.position(0);
    }

    public float O000000o() {
        return this.O0000O0o;
    }

    public void O000000o(float f) {
        this.O00000oo = -f;
    }

    public void O000000o(int i) {
        this.O00000oO = i;
    }

    public void O000000o(O00000Oo o00000Oo, float[] fArr) {
        Matrix.rotateM(fArr, 0, this.O00000oo, 0.0f, 0.0f, 1.0f);
        GLES20.glUseProgram(o00000Oo.O00000o);
        GLES20.glClear(256);
        GLES20.glEnable(2929);
        GLES20.glDepthMask(true);
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(770, 771);
        GLES20.glBlendColor(1.0f, 1.0f, 1.0f, 1.0f);
        GLES20.glBindTexture(3553, this.O00000oO);
        GLES20.glEnableVertexAttribArray(o00000Oo.O0000OOo);
        GLES20.glVertexAttribPointer(o00000Oo.O0000OOo, 2, 5126, false, 8, this.O00000o);
        GLES20.glEnableVertexAttribArray(o00000Oo.O00000o0);
        GLES20.glVertexAttribPointer(o00000Oo.O00000o0, 3, 5126, false, 12, this.O00000o0);
        GLES20.glUniformMatrix4fv(o00000Oo.O0000O0o, 1, false, fArr, 0);
        GLES20.glDrawArrays(4, 0, this.O000000o.size() / 3);
        GLES20.glBindTexture(3553, 0);
        GLES20.glDisable(2929);
        GLES20.glDisableVertexAttribArray(o00000Oo.O00000o0);
        GLES20.glDisableVertexAttribArray(o00000Oo.O0000OOo);
        GLES20.glUseProgram(0);
    }

    public float O00000Oo() {
        return this.O0000OOo;
    }

    public void O00000o0() {
        this.O000000o.clear();
        this.O00000o.clear();
    }
}
