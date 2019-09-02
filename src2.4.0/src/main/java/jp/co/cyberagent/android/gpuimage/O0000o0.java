package jp.co.cyberagent.android.gpuimage;

import android.graphics.PointF;

/* compiled from: GPUImageBulgeDistortionFilter */
public class O0000o0 extends O00O00Oo {
    public static final String O000000o = "varying highp vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\n\nuniform highp float aspectRatio;\nuniform highp vec2 center;\nuniform highp float radius;\nuniform highp float scale;\n\nvoid main()\n{\nhighp vec2 textureCoordinateToUse = vec2(textureCoordinate.x, (textureCoordinate.y * aspectRatio + 0.5 - 0.5 * aspectRatio));\nhighp float dist = distance(center, textureCoordinateToUse);\ntextureCoordinateToUse = textureCoordinate;\n\nif (dist < radius)\n{\ntextureCoordinateToUse -= center;\nhighp float percent = 1.0 - ((radius - dist) / radius) * scale;\npercent = percent * percent;\n\ntextureCoordinateToUse = textureCoordinateToUse * percent;\ntextureCoordinateToUse += center;\n}\n\ngl_FragColor = texture2D(inputImageTexture, textureCoordinateToUse );    \n}\n";
    private float O00000Oo;
    private float O00000o;
    private int O00000o0;
    private int O00000oO;
    private PointF O00000oo;
    private int O0000O0o;
    private float O0000OOo;
    private int O0000o;

    public O0000o0(float f, float f2, PointF pointF) {
    }

    private void O00000o0(float f) {
    }

    public void O000000o() {
    }

    public void O000000o(float f) {
    }

    public void O000000o(int i, int i2) {
    }

    public void O000000o(PointF pointF) {
    }

    public void O00000Oo() {
    }

    public void O00000Oo(float f) {
    }
}
