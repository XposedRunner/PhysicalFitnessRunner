package jp.co.cyberagent.android.gpuimage;

import android.graphics.PointF;

/* compiled from: GPUImageSwirlFilter */
public class O0OO0Oo extends O00O00Oo {
    public static final String O000000o = "varying highp vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\n\nuniform highp vec2 center;\nuniform highp float radius;\nuniform highp float angle;\n\nvoid main()\n{\nhighp vec2 textureCoordinateToUse = textureCoordinate;\nhighp float dist = distance(center, textureCoordinate);\nif (dist < radius)\n{\ntextureCoordinateToUse -= center;\nhighp float percent = (radius - dist) / radius;\nhighp float theta = percent * percent * angle * 8.0;\nhighp float s = sin(theta);\nhighp float c = cos(theta);\ntextureCoordinateToUse = vec2(dot(textureCoordinateToUse, vec2(c, -s)), dot(textureCoordinateToUse, vec2(s, c)));\ntextureCoordinateToUse += center;\n}\n\ngl_FragColor = texture2D(inputImageTexture, textureCoordinateToUse );\n\n}\n";
    private float O00000Oo;
    private float O00000o;
    private int O00000o0;
    private int O00000oO;
    private PointF O00000oo;
    private int O0000O0o;

    public O0OO0Oo(float f, float f2, PointF pointF) {
    }

    public void O000000o() {
    }

    public void O000000o(float f) {
    }

    public void O000000o(PointF pointF) {
    }

    public void O00000Oo() {
    }

    public void O00000Oo(float f) {
    }
}
