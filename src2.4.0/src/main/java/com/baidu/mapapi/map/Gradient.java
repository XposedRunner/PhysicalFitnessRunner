package com.baidu.mapapi.map;

import android.graphics.Color;
import java.util.HashMap;

public class Gradient {
    private final int a;
    private final int[] b;
    private final float[] c;

    private class a {
        private final int b;
        private final int c;
        private final float d;

        private a(int i, int i2, float f) {
            this.b = i;
            this.c = i2;
            this.d = f;
        }

        /* synthetic */ a(Gradient gradient, int i, int i2, float f, h hVar) {
            this(i, i2, f);
        }
    }

    public Gradient(int[] iArr, float[] fArr) {
        this(iArr, fArr, 1000);
    }

    private Gradient(int[] iArr, float[] fArr, int i) {
        if (iArr == null || fArr == null) {
            throw new IllegalArgumentException("colors and startPoints should not be null");
        } else if (iArr.length != fArr.length) {
            throw new IllegalArgumentException("colors and startPoints should be same length");
        } else if (iArr.length == 0) {
            throw new IllegalArgumentException("No colors have been defined");
        } else {
            for (int i2 = 1; i2 < fArr.length; i2++) {
                if (fArr[i2] <= fArr[i2 - 1]) {
                    throw new IllegalArgumentException("startPoints should be in increasing order");
                }
            }
            this.a = i;
            this.b = new int[iArr.length];
            this.c = new float[fArr.length];
            System.arraycopy(iArr, 0, this.b, 0, iArr.length);
            System.arraycopy(fArr, 0, this.c, 0, fArr.length);
        }
    }

    private static int a(int i, int i2, float f) {
        int alpha = (int) ((((float) (Color.alpha(i2) - Color.alpha(i))) * f) + ((float) Color.alpha(i)));
        float[] fArr = new float[3];
        Color.RGBToHSV(Color.red(i), Color.green(i), Color.blue(i), fArr);
        float[] fArr2 = new float[3];
        Color.RGBToHSV(Color.red(i2), Color.green(i2), Color.blue(i2), fArr2);
        i2 = 0;
        if (fArr[0] - fArr2[0] > 180.0f) {
            fArr2[0] = fArr2[0] + 360.0f;
        } else if (fArr2[0] - fArr[0] > 180.0f) {
            fArr[0] = fArr[0] + 360.0f;
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
        HashMap hashMap = new HashMap();
        if (this.c[0] != 0.0f) {
            hashMap.put(Integer.valueOf(0), new a(this, Color.argb(0, Color.red(this.b[0]), Color.green(this.b[0]), Color.blue(this.b[0])), this.b[0], ((float) this.a) * this.c[0], null));
        }
        for (i = 1; i < this.b.length; i++) {
            int i2 = i - 1;
            hashMap.put(Integer.valueOf((int) (((float) this.a) * this.c[i2])), new a(this, this.b[i2], this.b[i], ((float) this.a) * (this.c[i] - this.c[i2]), null));
        }
        if (this.c[this.c.length - 1] != 1.0f) {
            i = this.c.length - 1;
            hashMap.put(Integer.valueOf((int) (((float) this.a) * this.c[i])), new a(this, this.b[i], this.b[i], ((float) this.a) * (1.0f - this.c[i]), null));
        }
        return hashMap;
    }

    /* Access modifiers changed, original: 0000 */
    public int[] a(double d) {
        HashMap a = a();
        int[] iArr = new int[this.a];
        int i = 0;
        int i2 = 0;
        a aVar = (a) a.get(Integer.valueOf(0));
        for (int i3 = i2; i3 < this.a; i3++) {
            if (a.containsKey(Integer.valueOf(i3))) {
                aVar = (a) a.get(Integer.valueOf(i3));
                i2 = i3;
            }
            iArr[i3] = a(aVar.b, aVar.c, ((float) (i3 - i2)) / aVar.d);
        }
        if (d != 1.0d) {
            while (i < this.a) {
                int i4 = iArr[i];
                iArr[i] = Color.argb((int) (((double) Color.alpha(i4)) * d), Color.red(i4), Color.green(i4), Color.blue(i4));
                i++;
            }
        }
        return iArr;
    }
}
