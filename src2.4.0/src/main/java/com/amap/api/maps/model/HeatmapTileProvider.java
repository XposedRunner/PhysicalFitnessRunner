package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import android.support.v4.util.LongSparseArray;
import android.util.Log;
import com.amap.api.mapcore.util.OO0o0;
import com.amap.api.maps.AMapException;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class HeatmapTileProvider implements TileProvider {
    public static final Gradient DEFAULT_GRADIENT = new Gradient(DEFAULT_GRADIENT_COLORS, DEFAULT_GRADIENT_START_POINTS);
    private static final int[] DEFAULT_GRADIENT_COLORS = new int[]{Color.rgb(102, 225, 0), Color.rgb(255, 0, 0)};
    private static final float[] DEFAULT_GRADIENT_START_POINTS = new float[]{0.2f, 1.0f};
    private static final int DEFAULT_MAX_ZOOM = 11;
    private static final int DEFAULT_MIN_ZOOM = 5;
    public static final double DEFAULT_OPACITY = 0.6d;
    public static final int DEFAULT_RADIUS = 12;
    private static final int MAX_RADIUS = 50;
    private static final int MAX_ZOOM_LEVEL = 21;
    private static final int MIN_RADIUS = 10;
    private static final int SCREEN_SIZE = 1280;
    private static final int TILE_DIM = 256;
    private OO0o0 mBounds;
    private int[] mColorMap;
    private Collection<WeightedLatLng> mData;
    private Gradient mGradient;
    private double[] mKernel;
    private double[] mMaxIntensity;
    private double mOpacity;
    private int mRadius;
    private a mTree;

    public static class Builder {
        private Collection<WeightedLatLng> data;
        private Gradient gradient = HeatmapTileProvider.DEFAULT_GRADIENT;
        private double opacity = 0.6d;
        private int radius = 12;

        public HeatmapTileProvider build() {
            if (this.data == null || this.data.size() == 0) {
                try {
                    throw new AMapException("No input points.");
                } catch (AMapException e) {
                    Log.e("amap", e.getErrorMessage());
                    e.printStackTrace();
                    return null;
                }
            }
            try {
                return new HeatmapTileProvider(this);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        public Builder data(Collection<LatLng> collection) {
            return weightedData(HeatmapTileProvider.d(collection));
        }

        public Builder gradient(Gradient gradient) {
            this.gradient = gradient;
            return this;
        }

        public Builder radius(int i) {
            this.radius = Math.max(10, Math.min(i, 50));
            return this;
        }

        public Builder transparency(double d) {
            this.opacity = Math.max(0.0d, Math.min(d, 1.0d));
            return this;
        }

        public Builder weightedData(Collection<WeightedLatLng> collection) {
            this.data = collection;
            return this;
        }
    }

    private HeatmapTileProvider(Builder builder) {
        this.mData = builder.data;
        this.mRadius = builder.radius;
        this.mGradient = builder.gradient;
        if (this.mGradient == null || !this.mGradient.isAvailable()) {
            this.mGradient = DEFAULT_GRADIENT;
        }
        this.mOpacity = builder.opacity;
        this.mKernel = a(this.mRadius, ((double) this.mRadius) / 3.0d);
        a(this.mGradient);
        c(this.mData);
    }

    static double a(Collection<WeightedLatLng> collection, OO0o0 oO0o0, int i, int i2) {
        OO0o0 oO0o02 = oO0o0;
        double d = oO0o02.O000000o;
        double d2 = oO0o02.O00000o0;
        double d3 = oO0o02.O00000Oo;
        d2 -= d;
        double d4 = oO0o02.O00000o - d3;
        if (d2 <= d4) {
            d2 = d4;
        }
        d4 = ((double) ((int) (((double) (i2 / (2 * i))) + 0.5d))) / d2;
        LongSparseArray longSparseArray = new LongSparseArray();
        double d5 = 0.0d;
        for (WeightedLatLng weightedLatLng : collection) {
            LongSparseArray longSparseArray2;
            double d6;
            int i3 = (int) ((weightedLatLng.getPoint().y - d3) * d4);
            long j = (long) ((int) ((weightedLatLng.getPoint().x - d) * d4));
            LongSparseArray longSparseArray3 = (LongSparseArray) longSparseArray.get(j);
            if (longSparseArray3 == null) {
                longSparseArray3 = new LongSparseArray();
                longSparseArray.put(j, longSparseArray3);
            }
            j = (long) i3;
            Double d7 = (Double) longSparseArray3.get(j);
            if (d7 == null) {
                longSparseArray2 = longSparseArray;
                d6 = d;
                d7 = Double.valueOf(0.0d);
            } else {
                longSparseArray2 = longSparseArray;
                d6 = d;
            }
            Double valueOf = Double.valueOf(weightedLatLng.intensity + d7.doubleValue());
            longSparseArray3.put(j, valueOf);
            if (valueOf.doubleValue() > d5) {
                d5 = valueOf.doubleValue();
            }
            d = d6;
            longSparseArray = longSparseArray2;
        }
        return d5;
    }

    static Bitmap a(double[][] dArr, int[] iArr, double d) {
        double[][] dArr2 = dArr;
        int[] iArr2 = iArr;
        int i = iArr2[iArr2.length - 1];
        double length = ((double) (iArr2.length - 1)) / d;
        int length2 = dArr2.length;
        int[] iArr3 = new int[(length2 * length2)];
        for (int i2 = 0; i2 < length2; i2++) {
            for (int i3 = 0; i3 < length2; i3++) {
                double d2 = dArr2[i3][i2];
                int i4 = (i2 * length2) + i3;
                int i5 = (int) (d2 * length);
                if (d2 == 0.0d) {
                    iArr3[i4] = 0;
                } else if (i5 < iArr2.length) {
                    iArr3[i4] = iArr2[i5];
                } else {
                    iArr3[i4] = i;
                }
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(length2, length2, Config.ARGB_8888);
        createBitmap.setPixels(iArr3, 0, length2, 0, 0, length2, length2);
        return createBitmap;
    }

    static OO0o0 a(Collection<WeightedLatLng> collection) {
        Iterator it = collection.iterator();
        WeightedLatLng weightedLatLng = (WeightedLatLng) it.next();
        double d = weightedLatLng.getPoint().x;
        double d2 = weightedLatLng.getPoint().x;
        double d3 = d;
        double d4 = d2;
        double d5 = weightedLatLng.getPoint().y;
        double d6 = weightedLatLng.getPoint().y;
        while (it.hasNext()) {
            weightedLatLng = (WeightedLatLng) it.next();
            d = weightedLatLng.getPoint().x;
            d2 = weightedLatLng.getPoint().y;
            if (d < d3) {
                d3 = d;
            }
            if (d > d4) {
                d4 = d;
            }
            if (d2 < d5) {
                d5 = d2;
            }
            if (d2 > d6) {
                d6 = d2;
            }
        }
        return new OO0o0(d3, d4, d5, d6);
    }

    private static Tile a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        return Tile.obtain(256, 256, byteArrayOutputStream.toByteArray());
    }

    private void a(Gradient gradient) {
        this.mGradient = gradient;
        this.mColorMap = gradient.generateColorMap(this.mOpacity);
    }

    private double[] a(int i) {
        int i2;
        double[] dArr = new double[21];
        int i3 = 5;
        while (true) {
            i2 = 11;
            if (i3 >= 11) {
                break;
            }
            dArr[i3] = a(this.mData, this.mBounds, i, (int) (1280.0d * Math.pow(2.0d, (double) i3)));
            if (i3 == 5) {
                for (i2 = 0; i2 < i3; i2++) {
                    dArr[i2] = dArr[i3];
                }
            }
            i3++;
        }
        while (i2 < 21) {
            dArr[i2] = dArr[10];
            i2++;
        }
        return dArr;
    }

    static double[] a(int i, double d) {
        double[] dArr = new double[((i * 2) + 1)];
        for (int i2 = -i; i2 <= i; i2++) {
            dArr[i2 + i] = Math.exp(((double) ((-i2) * i2)) / ((2.0d * d) * d));
        }
        return dArr;
    }

    static double[][] a(double[][] dArr, double[] dArr2) {
        int i;
        int i2;
        double[][] dArr3 = dArr;
        double[] dArr4 = dArr2;
        int floor = (int) Math.floor(((double) dArr4.length) / 2.0d);
        int length = dArr3.length;
        int i3 = length - (2 * floor);
        int i4 = (floor + i3) - 1;
        double[][] dArr5 = (double[][]) Array.newInstance(double.class, new int[]{length, length});
        for (i = 0; i < length; i++) {
            for (int i5 = 0; i5 < length; i5++) {
                double d = dArr3[i][i5];
                if (d != 0.0d) {
                    int i6 = i + floor;
                    if (i4 < i6) {
                        i6 = i4;
                    }
                    i6++;
                    int i7 = i - floor;
                    for (i2 = floor > i7 ? floor : i7; i2 < i6; i2++) {
                        double[] dArr6 = dArr5[i2];
                        dArr6[i5] = dArr6[i5] + (dArr4[i2 - i7] * d);
                    }
                }
            }
        }
        dArr3 = (double[][]) Array.newInstance(double.class, new int[]{i3, i3});
        for (i2 = floor; i2 < i4 + 1; i2++) {
            for (i3 = 0; i3 < length; i3++) {
                double d2 = dArr5[i2][i3];
                if (d2 != 0.0d) {
                    i = i3 + floor;
                    if (i4 < i) {
                        i = i4;
                    }
                    i++;
                    int i8 = i3 - floor;
                    int i9 = floor > i8 ? floor : i8;
                    while (i9 < i) {
                        double[] dArr7 = dArr3[i2 - floor];
                        int i10 = i9 - floor;
                        dArr7[i10] = dArr7[i10] + (dArr4[i9 - i8] * d2);
                        i9++;
                    }
                }
            }
        }
        return dArr3;
    }

    private void c(Collection<WeightedLatLng> collection) {
        try {
            ArrayList arrayList = new ArrayList();
            for (WeightedLatLng weightedLatLng : collection) {
                if (weightedLatLng.latLng.latitude < 85.0d && weightedLatLng.latLng.latitude > -85.0d) {
                    arrayList.add(weightedLatLng);
                }
            }
            this.mData = arrayList;
            this.mBounds = a(this.mData);
            this.mTree = new a(this.mBounds);
            for (WeightedLatLng a : this.mData) {
                this.mTree.a(a);
            }
            this.mMaxIntensity = a(this.mRadius);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static Collection<WeightedLatLng> d(Collection<LatLng> collection) {
        ArrayList arrayList = new ArrayList();
        for (LatLng weightedLatLng : collection) {
            arrayList.add(new WeightedLatLng(weightedLatLng));
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x00ae  */
    public com.amap.api.maps.model.Tile getTile(int r39, int r40, int r41) {
        /*
        r38 = this;
        r0 = r38;
        r1 = r39;
        r2 = r40;
        r3 = r41;
        r4 = (double) r3;
        r6 = 4611686018427387904; // 0x4000000000000000 float:0.0 double:2.0;
        r4 = java.lang.Math.pow(r6, r4);
        r8 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;
        r4 = r8 / r4;
        r10 = r0.mRadius;
        r10 = (double) r10;
        r10 = r10 * r4;
        r12 = 4643211215818981376; // 0x4070000000000000 float:0.0 double:256.0;
        r10 = r10 / r12;
        r6 = r6 * r10;
        r6 = r6 + r4;
        r12 = r0.mRadius;
        r12 = r12 * 2;
        r13 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        r12 = r12 + r13;
        r14 = (double) r12;
        r6 = r6 / r14;
        r14 = (double) r1;
        r14 = r14 * r4;
        r14 = r14 - r10;
        r1 = r1 + 1;
        r8 = (double) r1;
        r8 = r8 * r4;
        r19 = r8 + r10;
        r8 = (double) r2;
        r8 = r8 * r4;
        r8 = r8 - r10;
        r1 = r2 + 1;
        r1 = (double) r1;
        r1 = r1 * r4;
        r1 = r1 + r10;
        r4 = new java.util.ArrayList;
        r4.<init>();
        r16 = 0;
        r5 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1));
        if (r5 >= 0) goto L_0x005d;
    L_0x0041:
        r4 = new com.amap.api.mapcore.util.OO0o0;
        r16 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;
        r28 = r14 + r16;
        r30 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;
        r27 = r4;
        r32 = r8;
        r34 = r1;
        r27.<init>(r28, r30, r32, r34);
        r16 = -4616189618054758400; // 0xbff0000000000000 float:0.0 double:-1.0;
        r5 = r0.mTree;
        r4 = r5.a(r4);
    L_0x005a:
        r25 = r16;
        goto L_0x007a;
    L_0x005d:
        r21 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;
        r5 = (r19 > r21 ? 1 : (r19 == r21 ? 0 : -1));
        if (r5 <= 0) goto L_0x005a;
    L_0x0063:
        r4 = new com.amap.api.mapcore.util.OO0o0;
        r28 = 0;
        r30 = r19 - r21;
        r27 = r4;
        r32 = r8;
        r34 = r1;
        r27.<init>(r28, r30, r32, r34);
        r5 = r0.mTree;
        r4 = r5.a(r4);
        r25 = r21;
    L_0x007a:
        r5 = new com.amap.api.mapcore.util.OO0o0;
        r16 = r5;
        r17 = r14;
        r21 = r8;
        r23 = r1;
        r16.<init>(r17, r19, r21, r23);
        r1 = new com.amap.api.mapcore.util.OO0o0;
        r2 = r0.mBounds;
        r36 = r14;
        r13 = r2.O000000o;
        r28 = r13 - r10;
        r2 = r0.mBounds;
        r12 = r2.O00000o0;
        r30 = r12 + r10;
        r2 = r0.mBounds;
        r12 = r2.O00000Oo;
        r32 = r12 - r10;
        r2 = r0.mBounds;
        r12 = r2.O00000o;
        r34 = r12 + r10;
        r27 = r1;
        r27.<init>(r28, r30, r32, r34);
        r1 = r5.O000000o(r1);
        if (r1 != 0) goto L_0x00b1;
    L_0x00ae:
        r1 = com.amap.api.maps.model.TileProvider.NO_TILE;
        return r1;
    L_0x00b1:
        r1 = r0.mTree;
        r1 = r1.a(r5);
        r2 = r1.isEmpty();
        if (r2 == 0) goto L_0x00c0;
    L_0x00bd:
        r1 = com.amap.api.maps.model.TileProvider.NO_TILE;
        return r1;
    L_0x00c0:
        r2 = r0.mRadius;
        r2 = r2 * 2;
        r5 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        r13 = r5 + r2;
        r2 = r0.mRadius;
        r2 = r2 * 2;
        r2 = r2 + r5;
        r2 = new int[]{r13, r2};
        r5 = double.class;
        r2 = java.lang.reflect.Array.newInstance(r5, r2);
        r2 = (double[][]) r2;
        r1 = r1.iterator();
    L_0x00dd:
        r5 = r1.hasNext();
        if (r5 == 0) goto L_0x0102;
    L_0x00e3:
        r5 = r1.next();
        r5 = (com.amap.api.maps.model.WeightedLatLng) r5;
        r10 = r5.getPoint();
        r11 = r10.x;
        r11 = r11 - r36;
        r11 = r11 / r6;
        r11 = (int) r11;
        r12 = r10.y;
        r12 = r12 - r8;
        r12 = r12 / r6;
        r10 = (int) r12;
        r11 = r2[r11];
        r12 = r11[r10];
        r14 = r5.intensity;
        r12 = r12 + r14;
        r11[r10] = r12;
        goto L_0x00dd;
    L_0x0102:
        r1 = r4.iterator();
    L_0x0106:
        r4 = r1.hasNext();
        if (r4 == 0) goto L_0x012d;
    L_0x010c:
        r4 = r1.next();
        r4 = (com.amap.api.maps.model.WeightedLatLng) r4;
        r5 = r4.getPoint();
        r10 = r5.x;
        r10 = r10 + r25;
        r10 = r10 - r36;
        r10 = r10 / r6;
        r10 = (int) r10;
        r11 = r5.y;
        r11 = r11 - r8;
        r11 = r11 / r6;
        r5 = (int) r11;
        r10 = r2[r10];
        r11 = r10[r5];
        r13 = r4.intensity;
        r11 = r11 + r13;
        r10[r5] = r11;
        goto L_0x0106;
    L_0x012d:
        r1 = r0.mKernel;
        r1 = a(r2, r1);
        r2 = r0.mColorMap;
        r4 = r0.mMaxIntensity;
        r3 = r4[r3];
        r1 = a(r1, r2, r3);
        r1 = a(r1);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.maps.model.HeatmapTileProvider.getTile(int, int, int):com.amap.api.maps.model.Tile");
    }

    public int getTileHeight() {
        return 256;
    }

    public int getTileWidth() {
        return 256;
    }
}
