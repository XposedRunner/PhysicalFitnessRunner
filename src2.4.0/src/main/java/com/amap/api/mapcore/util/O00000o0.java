package com.amap.api.mapcore.util;

import com.autonavi.amap.mapcore.animation.GLAlphaAnimation;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/* compiled from: MaskLayer */
public class O00000o0 {
    public FloatBuffer O000000o;
    public ShortBuffer O00000Oo;
    short[] O00000o = new short[]{(short) 0, (short) 1, (short) 3, (short) 0, (short) 3, (short) 2};
    float[] O00000o0 = new float[]{-1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f};
    private float O00000oO = 0.0f;
    private float O00000oo = 0.0f;
    private float O0000O0o = 0.0f;
    private float O0000OOo = 0.7f;
    private GLAlphaAnimation O0000Oo0;

    public O00000o0() {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.O00000o.length * 2);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.O00000Oo = allocateDirect.asShortBuffer();
        this.O00000Oo.put(this.O00000o);
        this.O00000Oo.position(0);
        allocateDirect = ByteBuffer.allocateDirect(this.O00000o0.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.O000000o = allocateDirect.asFloatBuffer();
        this.O000000o.put(this.O00000o0);
        this.O000000o.position(0);
    }

    public void O000000o(int i, int i2, int i3, int i4) {
        this.O00000oO = ((float) i) / 255.0f;
        this.O00000oo = ((float) i2) / 255.0f;
        this.O0000O0o = ((float) i3) / 255.0f;
        this.O0000OOo = ((float) i4) / 255.0f;
    }

    public void O000000o(GLAlphaAnimation gLAlphaAnimation) {
        if (!(this.O0000Oo0 == null || this.O0000Oo0.hasEnded())) {
            this.O0000Oo0.cancel();
        }
        if (gLAlphaAnimation != null) {
            this.O0000Oo0 = gLAlphaAnimation;
            this.O0000Oo0.start();
        }
    }
}
