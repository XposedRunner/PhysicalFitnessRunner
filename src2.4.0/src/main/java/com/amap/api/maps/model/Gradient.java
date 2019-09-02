package com.amap.api.maps.model;

import android.graphics.Color;
import android.util.Log;
import com.amap.api.maps.AMapException;
import java.util.HashMap;

public class Gradient {
    private static final int DEFAULT_COLOR_MAP_SIZE = 1000;
    private boolean isAvailable;
    private int mColorMapSize;
    private int[] mColors;
    private float[] mStartPoints;

    private static class a {
        private final int a;
        private final int b;
        private final float c;

        private a(int i, int i2, float f) {
            this.a = i;
            this.b = i2;
            this.c = f;
        }
    }

    public Gradient(int[] iArr, float[] fArr) {
        this(iArr, fArr, 1000);
    }

    private Gradient(int[] iArr, float[] fArr, int i) {
        this.isAvailable = true;
        if (iArr == null || fArr == null) {
            throw new AMapException("colors and startPoints should not be null");
        }
        try {
            if (iArr.length != fArr.length) {
                throw new AMapException("colors and startPoints should be same length");
            } else if (iArr.length == 0) {
                throw new AMapException("No colors have been defined");
            } else {
                for (int i2 = 1; i2 < fArr.length; i2++) {
                    if (fArr[i2] <= fArr[i2 - 1]) {
                        throw new AMapException("startPoints should be in increasing order");
                    }
                }
                this.mColorMapSize = i;
                this.mColors = new int[iArr.length];
                this.mStartPoints = new float[fArr.length];
                System.arraycopy(iArr, 0, this.mColors, 0, iArr.length);
                System.arraycopy(fArr, 0, this.mStartPoints, 0, fArr.length);
                this.isAvailable = true;
            }
        } catch (AMapException e) {
            this.isAvailable = false;
            Log.e("amap", e.getErrorMessage());
            e.printStackTrace();
        }
    }

    static int a(int i, int i2, float f) {
        int alpha = (int) ((((float) (Color.alpha(i2) - Color.alpha(i))) * f) + ((float) Color.alpha(i)));
        float[] fArr = new float[3];
        Color.RGBToHSV(Color.red(i), Color.green(i), Color.blue(i), fArr);
        float[] fArr2 = new float[3];
        Color.RGBToHSV(Color.red(i2), Color.green(i2), Color.blue(i2), fArr2);
        i2 = 0;
        float f2 = (float) 180;
        if (fArr[0] - fArr2[0] > f2) {
            fArr2[0] = fArr2[0] + ((float) 360);
        } else if (fArr2[0] - fArr[0] > f2) {
            fArr[0] = fArr[0] + ((float) 360);
        }
        float[] fArr3 = new float[3];
        while (i2 < 3) {
            fArr3[i2] = ((fArr2[i2] - fArr[i2]) * f) + fArr[i2];
            i2++;
        }
        return Color.HSVToColor(alpha, fArr3);
    }

    private HashMap<Integer, a> a() {
        int i;
        HashMap hashMap = new HashMap(32);
        if (this.mStartPoints[0] != 0.0f) {
            hashMap.put(Integer.valueOf(0), new a(Color.argb(0, Color.red(this.mColors[0]), Color.green(this.mColors[0]), Color.blue(this.mColors[0])), this.mColors[0], ((float) this.mColorMapSize) * this.mStartPoints[0]));
        }
        for (i = 1; i < this.mColors.length; i++) {
            int i2 = i - 1;
            hashMap.put(Integer.valueOf((int) (((float) this.mColorMapSize) * this.mStartPoints[i2])), new a(this.mColors[i2], this.mColors[i], ((float) this.mColorMapSize) * (this.mStartPoints[i] - this.mStartPoints[i2])));
        }
        if (this.mStartPoints[this.mStartPoints.length - 1] != 1.0f) {
            i = this.mStartPoints.length - 1;
            hashMap.put(Integer.valueOf((int) (((float) this.mColorMapSize) * this.mStartPoints[i])), new a(this.mColors[i], this.mColors[i], ((float) this.mColorMapSize) * (1.0f - this.mStartPoints[i])));
        }
        return hashMap;
    }

    /* Access modifiers changed, original: protected */
    public int[] generateColorMap(double d) {
        HashMap a = a();
        int[] iArr = new int[this.mColorMapSize];
        int i = 0;
        int i2 = 0;
        a aVar = (a) a.get(Integer.valueOf(0));
        for (int i3 = i2; i3 < this.mColorMapSize; i3++) {
            if (a.containsKey(Integer.valueOf(i3))) {
                aVar = (a) a.get(Integer.valueOf(i3));
                i2 = i3;
            }
            iArr[i3] = a(aVar.a, aVar.b, ((float) (i3 - i2)) / aVar.c);
        }
        if (d != 1.0d) {
            while (i < this.mColorMapSize) {
                int i4 = iArr[i];
                iArr[i] = Color.argb((int) (((double) Color.alpha(i4)) * d), Color.red(i4), Color.green(i4), Color.blue(i4));
                i++;
            }
        }
        return iArr;
    }

    /* Access modifiers changed, original: protected */
    public boolean isAvailable() {
        return this.isAvailable;
    }
}
