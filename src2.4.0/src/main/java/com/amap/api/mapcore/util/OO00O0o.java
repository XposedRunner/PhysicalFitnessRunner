package com.amap.api.mapcore.util;

import android.opengl.GLES20;

/* compiled from: GlShader */
public class OO00O0o {
    private boolean O000000o;
    public int O00000o;
    public int O00000oO;
    public int O00000oo;

    public int O000000o(int i, String str) {
        i = GLES20.glCreateShader(i);
        GLES20.glShaderSource(i, str);
        GLES20.glCompileShader(i);
        return i;
    }

    public void O000000o() {
        GLES20.glUseProgram(this.O00000o);
    }

    /* Access modifiers changed, original: protected */
    public boolean O000000o(String str) {
        this.O00000o = O00000o(str);
        return this.O00000o != 0;
    }

    /* Access modifiers changed, original: protected */
    public boolean O000000o(String str, String str2) {
        this.O00000o = O00000Oo(str, str2);
        return this.O00000o != 0;
    }

    /* Access modifiers changed, original: protected */
    public int O00000Oo(String str) {
        return GLES20.glGetAttribLocation(this.O00000o, str);
    }

    public int O00000Oo(String str, String str2) {
        this.O00000oO = O000000o(35633, str);
        this.O00000oo = O000000o(35632, str2);
        int glCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(glCreateProgram, this.O00000oO);
        GLES20.glAttachShader(glCreateProgram, this.O00000oo);
        GLES20.glLinkProgram(glCreateProgram);
        return glCreateProgram;
    }

    public void O00000Oo() {
        if (this.O00000o >= 0) {
            GLES20.glDeleteProgram(this.O00000o);
        }
        if (this.O00000oO >= 0) {
            GLES20.glDeleteShader(this.O00000oO);
        }
        if (this.O00000oo >= 0) {
            GLES20.glDeleteShader(this.O00000oo);
        }
        this.O000000o = true;
    }

    public int O00000o(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("amap_sdk_shaders/");
        stringBuilder.append(str);
        str = stringBuilder.toString();
        String O000000o = OO0Oo0.O000000o(str);
        StringBuilder stringBuilder2;
        if (O000000o == null) {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("shader file not found: ");
            stringBuilder2.append(str);
            throw new IllegalArgumentException(stringBuilder2.toString());
        }
        int indexOf = O000000o.indexOf(36);
        if (indexOf < 0 || O000000o.charAt(indexOf + 1) != '$') {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("not a shader file ");
            stringBuilder2.append(str);
            throw new IllegalArgumentException(stringBuilder2.toString());
        }
        return O00000Oo(O000000o.substring(0, indexOf), O000000o.substring(indexOf + 2));
    }

    /* Access modifiers changed, original: protected */
    public int O00000o0(String str) {
        return GLES20.glGetUniformLocation(this.O00000o, str);
    }

    public boolean O00000o0() {
        return this.O000000o;
    }
}
