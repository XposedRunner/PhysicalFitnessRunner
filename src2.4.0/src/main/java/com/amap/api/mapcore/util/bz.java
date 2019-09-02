package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;

/* compiled from: GlOverlayTextureManager */
public class bz {
    private int O000000o = -1;
    private int O00000Oo = -1;
    private int O00000o = 0;
    private int O00000o0 = -1;
    private Bitmap O00000oO = null;
    private Bitmap O00000oo = null;
    private Bitmap O0000O0o = null;

    public int O000000o() {
        return this.O000000o;
    }

    public int O000000o(int i) {
        return i == 0 ? this.O00000Oo : i == 1 ? this.O00000o0 : -1;
    }

    public void O000000o(Context context) {
        if (this.O00000oO == null || this.O00000oO.isRecycled()) {
            this.O00000oO = OOo000.O000000o(context, "amap_sdk_lineTexture.png");
        }
        if (this.O00000oo == null || this.O00000oo.isRecycled()) {
            this.O00000oo = OOo000.O000000o(context, "amap_sdk_lineDashTexture_square.png");
        }
        if (this.O0000O0o == null || this.O0000O0o.isRecycled()) {
            this.O0000O0o = OOo000.O000000o(context, "amap_sdk_lineDashTexture_circle.png");
        }
        this.O000000o = OOo000.O000000o(this.O00000oO);
        this.O00000Oo = OOo000.O000000o(this.O00000oo, true);
        this.O00000o0 = OOo000.O000000o(this.O0000O0o, true);
        this.O00000o = OOo000.O000000o(512, 1024);
    }

    public int O00000Oo() {
        return this.O00000o;
    }

    public void O00000o() {
        if (this.O00000oo != null) {
            this.O00000oo.recycle();
            this.O00000oo = null;
        }
        if (this.O0000O0o != null) {
            this.O0000O0o.recycle();
            this.O0000O0o = null;
        }
        if (this.O00000oO != null) {
            this.O00000oO.recycle();
            this.O00000oO = null;
        }
    }

    public void O00000o0() {
        GLES20.glDeleteTextures(3, new int[]{this.O000000o, this.O00000Oo, this.O00000o0, this.O00000o}, 0);
    }
}
