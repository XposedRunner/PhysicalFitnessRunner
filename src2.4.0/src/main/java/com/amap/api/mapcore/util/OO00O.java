package com.amap.api.mapcore.util;

import android.opengl.GLES20;
import com.autonavi.amap.mapcore.gles.AMapNativeGLShaderManager;

/* compiled from: GlShaderManager */
public class OO00O {
    private O00000o O000000o;
    private O0000OOo O00000Oo;
    private O0000O0o O00000o;
    private O00000o0 O00000o0;
    private O000000o O00000oO;
    private O00000Oo O00000oo;
    private long O0000O0o;

    /* compiled from: GlShaderManager */
    public static class O000000o extends OO00O0o {
        String O000000o;
        String O00000Oo = "        precision highp float;\n        varying vec2 texture;\n        uniform sampler2D aTextureUnit0;\n        void main(){\n            vec4 tempColor = texture2D(aTextureUnit0, texture);\n            gl_FragColor = tempColor;\n        }";
        public int O00000o0;
        public int O0000O0o;
        public int O0000OOo;
        public int O0000Oo;
        public int O0000Oo0;
        public int O0000OoO;

        public O000000o() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("precision highp float;\n        attribute vec4 aVertex;\n        attribute vec2 aTexture;\n        uniform vec4 aMapAttribute;\n        uniform mat4 aMVPMatrix;\n        uniform mat4 aProjection;\n        uniform vec3 aInstanceOffset[");
            stringBuilder.append(oooOoO.O000000o);
            stringBuilder.append("];\n");
            stringBuilder.append("        varying vec2 texture;\n");
            stringBuilder.append("        mat4 rotationMatrix(vec3 axis, float angle)\n");
            stringBuilder.append("        {\n");
            stringBuilder.append("           axis = normalize(axis);\n");
            stringBuilder.append("           float s = sin(angle);\n");
            stringBuilder.append("           float c = cos(angle);\n");
            stringBuilder.append("           float oc = 1.0 - c;\n");
            stringBuilder.append("           return mat4(oc * axis.x * axis.x + c,           oc * axis.x * axis.y - axis.z * s,  oc * axis.z * axis.x + axis.y * s,  0.0,\n");
            stringBuilder.append("                 oc * axis.x * axis.y + axis.z * s,  oc * axis.y * axis.y + c,           oc * axis.y * axis.z - axis.x * s,  0.0,\n");
            stringBuilder.append("                 oc * axis.z * axis.x - axis.y * s,  oc * axis.y * axis.z + axis.x * s,  oc * axis.z * axis.z + c,           0.0,\n");
            stringBuilder.append("                 0.0,                                0.0,                                0.0,                                1.0);\n");
            stringBuilder.append("        }\n");
            stringBuilder.append("        void main(){\n");
            stringBuilder.append("            int instance = int(aVertex.w);\n");
            stringBuilder.append("            vec3 offset_value = aInstanceOffset[instance];\n");
            stringBuilder.append("            mat4 marker_rotate_mat4 = rotationMatrix(vec3(0,0,1.0), offset_value.z * 0.01745);\n");
            stringBuilder.append("            float map_rotate = -aMapAttribute.z * 0.01745;\n");
            stringBuilder.append("            float map_tilt = aMapAttribute.w * 0.01745;\n");
            stringBuilder.append("            //tilt旋转矩阵\n");
            stringBuilder.append("            mat4 map_tilt_mat4 = rotationMatrix(vec3(1,0,0), map_tilt);\n");
            stringBuilder.append("            //bearing旋转矩阵\n");
            stringBuilder.append("            mat4 map_rotate_mat4 = rotationMatrix(vec3(0,0,1), map_rotate);\n");
            stringBuilder.append("                 \n");
            stringBuilder.append("            //旋转图片\n");
            stringBuilder.append("            vec4 pos_1 = marker_rotate_mat4 * vec4(aVertex.xy * aMapAttribute.xy, 0,1);\n");
            stringBuilder.append("                  \n");
            stringBuilder.append("            //让marker站立，tilt旋转之后z轴值有可能不是0\n");
            stringBuilder.append("            vec4 pos_2 =  map_tilt_mat4 * pos_1;\n");
            stringBuilder.append("                  \n");
            stringBuilder.append("            //旋转 bearing\n");
            stringBuilder.append("            vec4 pos_3 =  map_rotate_mat4 * pos_2;\n");
            stringBuilder.append("            gl_Position = aProjection * aMVPMatrix * vec4(pos_3.xy + offset_value.xy, pos_3.z, 1.0);\n");
            stringBuilder.append("            texture = aTexture;\n");
            stringBuilder.append("        }");
            this.O000000o = stringBuilder.toString();
            if (O000000o(this.O000000o, this.O00000Oo)) {
                this.O0000O0o = O00000o0("aMVPMatrix");
                this.O0000OoO = O00000o0("aProjection");
                this.O0000Oo0 = O00000o0("aInstanceOffset");
                this.O0000Oo = O00000o0("aMapAttribute");
                this.O00000o0 = O00000Oo("aVertex");
                this.O0000OOo = O00000Oo("aTexture");
            }
        }
    }

    /* compiled from: GlShaderManager */
    public static class O00000Oo extends OO00O0o {
        String O000000o = "precision highp float;\n        attribute vec3 aVertex;//顶点数组,三维坐标\n        attribute vec2 aTexture;\n        uniform mat4 aMVPMatrix;//mvp矩阵\n        varying vec2 texture;//\n        void main(){\n            gl_Position = aMVPMatrix * vec4(aVertex, 1.0);\n            texture = aTexture;\n        }";
        String O00000Oo = "        precision highp float;\n        varying vec2 texture;//\n        uniform sampler2D aTextureUnit0;//纹理id\n        void main(){\n            gl_FragColor = texture2D(aTextureUnit0, texture);\n        }";
        public int O00000o0;
        public int O0000O0o;
        public int O0000OOo;

        public O00000Oo() {
            if (O000000o(this.O000000o, this.O00000Oo)) {
                this.O00000o0 = GLES20.glGetAttribLocation(this.O00000o, "aVertex");
                this.O0000OOo = GLES20.glGetAttribLocation(this.O00000o, "aTexture");
                this.O0000O0o = GLES20.glGetUniformLocation(this.O00000o, "aMVPMatrix");
            }
        }
    }

    /* compiled from: GlShaderManager */
    public static class O00000o0 extends OO00O0o {
        public int O000000o;
        public int O00000Oo;
        public int O00000o0;
        public int O0000O0o;
        public int O0000OOo;

        O00000o0(String str) {
            if (O000000o(str)) {
                this.O000000o = O00000o0("aMVP");
                this.O00000Oo = O00000Oo("aVertex");
                this.O00000o0 = O00000Oo("aTextureCoord");
                this.O0000O0o = O00000o0("aTransform");
                this.O0000OOo = O00000o0("aColor");
            }
        }
    }

    /* compiled from: GlShaderManager */
    public static class O00000o extends OO00O0o {
        public int O000000o;
        public int O00000Oo;
        public int O00000o0;
        public int O0000O0o;
        public int O0000OOo;

        O00000o(String str) {
            if (O000000o(str)) {
                this.O000000o = O00000o0("aMVP");
                OOO00Oo.O000000o("getUniform");
                this.O0000OOo = O00000o0("aMapBearing");
                this.O00000Oo = O00000Oo("aVertex");
                this.O00000o0 = O00000Oo("aTextureCoord");
                this.O0000O0o = O00000Oo("aBearingTiltAlpha");
            }
        }
    }

    /* compiled from: GlShaderManager */
    public static class O0000O0o extends OO00O0o {
        public int O000000o;
        public int O00000Oo;
        public int O00000o0;

        O0000O0o(String str) {
            if (O000000o(str)) {
                this.O000000o = O00000o0("aMVPMatrix");
                this.O00000o0 = O00000o0("aColor");
                this.O00000Oo = O00000Oo("aVertex");
            }
        }
    }

    /* compiled from: GlShaderManager */
    public static class O0000OOo extends OO00O0o {
        public int O000000o;
        public int O00000Oo;
        public int O00000o0;

        O0000OOo(String str) {
            if (O000000o(str)) {
                this.O000000o = O00000o0("aMVP");
                this.O00000Oo = O00000Oo("aVertex");
                this.O00000o0 = O00000Oo("aTextureCoord");
            }
        }
    }

    public OO00O() {
        this.O0000O0o = 0;
        this.O0000O0o = AMapNativeGLShaderManager.nativeCreateGLShaderManager();
    }

    private synchronized OO00O0o O00000o() {
        if (this.O00000Oo == null) {
            this.O00000Oo = new O0000OOo("texture.glsl");
        }
        return this.O00000Oo;
    }

    private synchronized OO00O0o O00000o0() {
        if (this.O000000o == null) {
            this.O000000o = new O00000o("texture_normal.glsl");
        }
        return this.O000000o;
    }

    private synchronized OO00O0o O00000oO() {
        if (this.O00000o0 == null) {
            this.O00000o0 = new O00000o0("texture_layer.glsl");
        }
        return this.O00000o0;
    }

    private synchronized OO00O0o O00000oo() {
        if (this.O00000o == null) {
            this.O00000o = new O0000O0o("point.glsl");
        }
        return this.O00000o;
    }

    private synchronized O000000o O0000O0o() {
        if (this.O00000oO == null) {
            this.O00000oO = new O000000o();
        }
        return this.O00000oO;
    }

    private synchronized OO00O0o O0000OOo() {
        if (this.O00000oo == null) {
            this.O00000oo = new O00000Oo();
        }
        return this.O00000oo;
    }

    public long O000000o() {
        return this.O0000O0o;
    }

    public OO00O0o O000000o(int i) {
        switch (i) {
            case 0:
                return O00000o();
            case 1:
                return O00000o0();
            case 2:
                return O00000oO();
            case 3:
                return O00000oo();
            case 4:
                return O0000O0o();
            case 5:
                return O0000OOo();
            default:
                return null;
        }
    }

    public synchronized void O00000Oo() {
        if (this.O000000o != null) {
            this.O000000o.O00000Oo();
            this.O000000o = null;
        }
        if (this.O00000Oo != null) {
            this.O00000Oo.O00000Oo();
            this.O00000Oo = null;
        }
        if (this.O00000o0 != null) {
            this.O00000o0.O00000Oo();
            this.O00000o0 = null;
        }
        if (this.O00000o != null) {
            this.O00000o.O00000Oo();
            this.O00000o = null;
        }
        if (this.O0000O0o != 0) {
            AMapNativeGLShaderManager.nativeDestroyGLShaderManager(this.O0000O0o);
            this.O0000O0o = 0;
        }
    }
}
