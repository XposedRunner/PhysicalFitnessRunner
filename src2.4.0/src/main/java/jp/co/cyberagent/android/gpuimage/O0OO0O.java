package jp.co.cyberagent.android.gpuimage;

import android.graphics.PointF;

/* compiled from: GPUImageSphereRefractionFilter */
public class O0OO0O extends O00O00Oo {
    public static final String O000000o = "varying highp vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\n\nuniform highp vec2 center;\nuniform highp float radius;\nuniform highp float aspectRatio;\nuniform highp float refractiveIndex;\n\nvoid main()\n{\nhighp vec2 textureCoordinateToUse = vec2(textureCoordinate.x, (textureCoordinate.y * aspectRatio + 0.5 - 0.5 * aspectRatio));\nhighp float distanceFromCenter = distance(center, textureCoordinateToUse);\nlowp float checkForPresenceWithinSphere = step(distanceFromCenter, radius);\n\ndistanceFromCenter = distanceFromCenter / radius;\n\nhighp float normalizedDepth = radius * sqrt(1.0 - distanceFromCenter * distanceFromCenter);\nhighp vec3 sphereNormal = normalize(vec3(textureCoordinateToUse - center, normalizedDepth));\n\nhighp vec3 refractedVector = refract(vec3(0.0, 0.0, -1.0), sphereNormal, refractiveIndex);\n\ngl_FragColor = texture2D(inputImageTexture, (refractedVector.xy + 1.0) * 0.5) * checkForPresenceWithinSphere;     \n}\n";
    private PointF O00000Oo;
    private float O00000o;
    private int O00000o0;
    private int O00000oO;
    private float O00000oo;
    private int O0000O0o;
    private float O0000OOo;
    private int O0000o;

    public O0OO0O(PointF pointF, float f, float f2) {
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
