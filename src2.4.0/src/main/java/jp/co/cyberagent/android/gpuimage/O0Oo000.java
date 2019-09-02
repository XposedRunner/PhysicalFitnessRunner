package jp.co.cyberagent.android.gpuimage;

import android.graphics.PointF;

/* compiled from: GPUImageVignetteFilter */
public class O0Oo000 extends O00O00Oo {
    public static final String O000000o = " uniform sampler2D inputImageTexture;\n varying highp vec2 textureCoordinate;\n \n uniform lowp vec2 vignetteCenter;\n uniform lowp vec3 vignetteColor;\n uniform highp float vignetteStart;\n uniform highp float vignetteEnd;\n \n void main()\n {\n     /*\n     lowp vec3 rgb = texture2D(inputImageTexture, textureCoordinate).rgb;\n     lowp float d = distance(textureCoordinate, vec2(0.5,0.5));\n     rgb *= (1.0 - smoothstep(vignetteStart, vignetteEnd, d));\n     gl_FragColor = vec4(vec3(rgb),1.0);\n      */\n     \n     lowp vec3 rgb = texture2D(inputImageTexture, textureCoordinate).rgb;\n     lowp float d = distance(textureCoordinate, vec2(vignetteCenter.x, vignetteCenter.y));\n     lowp float percent = smoothstep(vignetteStart, vignetteEnd, d);\n     gl_FragColor = vec4(mix(rgb.x, vignetteColor.x, percent), mix(rgb.y, vignetteColor.y, percent), mix(rgb.z, vignetteColor.z, percent), 1.0);\n }";
    private int O00000Oo;
    private int O00000o;
    private PointF O00000o0;
    private float[] O00000oO;
    private int O00000oo;
    private float O0000O0o;
    private int O0000OOo;
    private float O0000o;

    public O0Oo000(PointF pointF, float[] fArr, float f, float f2) {
    }

    public void O000000o() {
    }

    public void O000000o(float f) {
    }

    public void O000000o(PointF pointF) {
    }

    public void O000000o(float[] fArr) {
    }

    public void O00000Oo(float f) {
    }
}
