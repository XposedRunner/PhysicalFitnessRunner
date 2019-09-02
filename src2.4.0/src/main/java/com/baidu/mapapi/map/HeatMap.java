package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import android.graphics.Point;
import android.support.v4.util.LongSparseArray;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.util.SparseIntArray;
import com.baidu.mapapi.model.LatLng;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

public class HeatMap {
    public static final Gradient DEFAULT_GRADIENT = new Gradient(d, e);
    public static final double DEFAULT_OPACITY = 0.6d;
    public static final int DEFAULT_RADIUS = 12;
    private static final String b = "HeatMap";
    private static final SparseIntArray c = new SparseIntArray();
    private static final int[] d = new int[]{Color.rgb(0, 0, 200), Color.rgb(0, 225, 0), Color.rgb(255, 0, 0)};
    private static final float[] e = new float[]{0.08f, 0.4f, 1.0f};
    private static int r;
    BaiduMap a;
    private n<WeightedLatLng> f;
    private Collection<WeightedLatLng> g;
    private int h;
    private Gradient i;
    private double j;
    private g k;
    private int[] l;
    private double[] m;
    private double[] n;
    private HashMap<String, Tile> o;
    private ExecutorService p;
    private HashSet<String> q;

    public static class Builder {
        private Collection<WeightedLatLng> a;
        private int b = 12;
        private Gradient c = HeatMap.DEFAULT_GRADIENT;
        private double d = 0.6d;

        public HeatMap build() {
            if (this.a != null) {
                return new HeatMap(this, null);
            }
            throw new IllegalStateException("No input data: you must use either .data or .weightedData before building");
        }

        public Builder data(Collection<LatLng> collection) {
            if (collection == null || collection.isEmpty()) {
                throw new IllegalArgumentException("No input points.");
            } else if (!collection.contains(null)) {
                return weightedData(HeatMap.c((Collection) collection));
            } else {
                throw new IllegalArgumentException("input points can not contain null.");
            }
        }

        public Builder gradient(Gradient gradient) {
            if (gradient == null) {
                throw new IllegalArgumentException("gradient can not be null");
            }
            this.c = gradient;
            return this;
        }

        public Builder opacity(double d) {
            this.d = d;
            if (this.d >= 0.0d && this.d <= 1.0d) {
                return this;
            }
            throw new IllegalArgumentException("Opacity must be in range [0, 1]");
        }

        public Builder radius(int i) {
            this.b = i;
            if (this.b >= 10 && this.b <= 50) {
                return this;
            }
            throw new IllegalArgumentException("Radius not within bounds.");
        }

        public Builder weightedData(Collection<WeightedLatLng> collection) {
            if (collection == null || collection.isEmpty()) {
                throw new IllegalArgumentException("No input points.");
            } else if (collection.contains(null)) {
                throw new IllegalArgumentException("input points can not contain null.");
            } else {
                ArrayList arrayList = new ArrayList();
                for (WeightedLatLng weightedLatLng : collection) {
                    LatLng latLng = weightedLatLng.latLng;
                    if (latLng.latitude < 0.37532d || latLng.latitude > 54.562495d || latLng.longitude < 72.508319d || latLng.longitude > 135.942198d) {
                        arrayList.add(weightedLatLng);
                    }
                }
                collection.removeAll(arrayList);
                this.a = collection;
                return this;
            }
        }
    }

    static {
        c.put(3, 8388608);
        c.put(4, AccessibilityEventCompat.TYPE_WINDOWS_CHANGED);
        c.put(5, 2097152);
        c.put(6, 1048576);
        c.put(7, 524288);
        c.put(8, 262144);
        c.put(9, 131072);
        c.put(10, 65536);
        c.put(11, 32768);
        c.put(12, 16384);
        c.put(13, 8192);
        c.put(14, 4096);
        c.put(15, 2048);
        c.put(16, 1024);
        c.put(17, 512);
        c.put(18, 256);
        c.put(19, 128);
        c.put(20, 64);
    }

    private HeatMap(Builder builder) {
        this.o = new HashMap();
        this.p = Executors.newFixedThreadPool(1);
        this.q = new HashSet();
        this.g = builder.a;
        this.h = builder.b;
        this.i = builder.c;
        this.j = builder.d;
        this.m = a(this.h, ((double) this.h) / 3.0d);
        a(this.i);
        b(this.g);
    }

    /* synthetic */ HeatMap(Builder builder, i iVar) {
        this(builder);
    }

    private static double a(Collection<WeightedLatLng> collection, g gVar, int i, int i2) {
        g gVar2 = gVar;
        double d = gVar2.a;
        double d2 = gVar2.c;
        double d3 = gVar2.b;
        d2 -= d;
        double d4 = gVar2.d - d3;
        if (d2 <= d4) {
            d2 = d4;
        }
        d4 = ((double) ((int) (((double) (i2 / (2 * i))) + 0.5d))) / d2;
        LongSparseArray longSparseArray = new LongSparseArray();
        double d5 = 0.0d;
        for (WeightedLatLng weightedLatLng : collection) {
            LongSparseArray longSparseArray2;
            double d6;
            int i3 = (int) ((((double) weightedLatLng.a().y) - d3) * d4);
            long j = (long) ((int) ((((double) weightedLatLng.a().x) - d) * d4));
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

    private static Bitmap a(double[][] dArr, int[] iArr, double d) {
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

    private static Tile a(Bitmap bitmap) {
        ByteBuffer allocate = ByteBuffer.allocate((bitmap.getWidth() * bitmap.getHeight()) * 4);
        bitmap.copyPixelsToBuffer(allocate);
        return new Tile(256, 256, allocate.array());
    }

    private void a(Gradient gradient) {
        this.i = gradient;
        this.l = gradient.a(this.j);
    }

    private synchronized void a(String str, Tile tile) {
        this.o.put(str, tile);
    }

    private synchronized boolean a(String str) {
        return this.q.contains(str);
    }

    private double[] a(int i) {
        int i2;
        double[] dArr = new double[20];
        int i3 = 5;
        while (true) {
            i2 = 11;
            if (i3 >= 11) {
                break;
            }
            dArr[i3] = a(this.g, this.k, i, (int) (1280.0d * Math.pow(2.0d, (double) (i3 - 3))));
            if (i3 == 5) {
                for (i2 = 0; i2 < i3; i2++) {
                    dArr[i2] = dArr[i3];
                }
            }
            i3++;
        }
        while (i2 < 20) {
            dArr[i2] = dArr[10];
            i2++;
        }
        return dArr;
    }

    private static double[] a(int i, double d) {
        double[] dArr = new double[((i * 2) + 1)];
        for (int i2 = -i; i2 <= i; i2++) {
            dArr[i2 + i] = Math.exp(((double) ((-i2) * i2)) / ((2.0d * d) * d));
        }
        return dArr;
    }

    private static double[][] a(double[][] dArr, double[] dArr2) {
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

    private void b(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        double d = (double) c.get(i6);
        double d2 = (((double) this.h) * d) / 256.0d;
        double d3 = ((2.0d * d2) + d) / ((double) ((this.h * 2) + 256));
        if (i4 >= 0 && i5 >= 0) {
            double d4 = (((double) i4) * d) - d2;
            double d5 = (((double) (i4 + 1)) * d) + d2;
            double d6 = (((double) i5) * d) - d2;
            d = (((double) (i5 + 1)) * d) + d2;
            g gVar = new g(d4, d5, d6, d);
            double d7 = d4;
            if (gVar.a(new g(this.k.a - d2, this.k.c + d2, this.k.b - d2, this.k.d + d2))) {
                Collection<WeightedLatLng> a = this.f.a(gVar);
                if (!a.isEmpty()) {
                    double[][] dArr = (double[][]) Array.newInstance(double.class, new int[]{256 + (this.h * 2), (this.h * 2) + 256});
                    for (WeightedLatLng weightedLatLng : a) {
                        Point a2 = weightedLatLng.a();
                        int i7 = (int) ((((double) a2.x) - d7) / d3);
                        int i8 = (int) ((d - ((double) a2.y)) / d3);
                        if (i7 >= (this.h * 2) + 256) {
                            i7 = ((this.h * 2) + 256) - 1;
                        }
                        if (i8 >= (this.h * 2) + 256) {
                            i8 = ((this.h * 2) + 256) - 1;
                        }
                        double[] dArr2 = dArr[i7];
                        double d8 = d;
                        dArr2[i8] = dArr2[i8] + weightedLatLng.intensity;
                        d = d8;
                    }
                    Bitmap a3 = a(a(dArr, this.m), this.l, this.n[i6 - 1]);
                    Tile a4 = a(a3);
                    a3.recycle();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(i4);
                    stringBuilder.append("_");
                    stringBuilder.append(i5);
                    stringBuilder.append("_");
                    stringBuilder.append(i6);
                    a(stringBuilder.toString(), a4);
                    if (this.o.size() > r) {
                        a();
                    }
                    if (this.a != null) {
                        this.a.a();
                    }
                }
            }
        }
    }

    private synchronized void b(String str) {
        this.q.add(str);
    }

    private void b(Collection<WeightedLatLng> collection) {
        this.g = collection;
        if (this.g.isEmpty()) {
            throw new IllegalArgumentException("No input points.");
        }
        this.k = d(this.g);
        this.f = new n(this.k);
        for (a a : this.g) {
            this.f.a(a);
        }
        this.n = a(this.h);
    }

    private synchronized Tile c(String str) {
        if (!this.o.containsKey(str)) {
            return null;
        }
        Tile tile = (Tile) this.o.get(str);
        this.o.remove(str);
        return tile;
    }

    private static Collection<WeightedLatLng> c(Collection<LatLng> collection) {
        ArrayList arrayList = new ArrayList();
        for (LatLng weightedLatLng : collection) {
            arrayList.add(new WeightedLatLng(weightedLatLng));
        }
        return arrayList;
    }

    private static g d(Collection<WeightedLatLng> collection) {
        Iterator it = collection.iterator();
        WeightedLatLng weightedLatLng = (WeightedLatLng) it.next();
        double d = (double) weightedLatLng.a().x;
        double d2 = (double) weightedLatLng.a().x;
        double d3 = (double) weightedLatLng.a().y;
        double d4 = (double) weightedLatLng.a().y;
        while (it.hasNext()) {
            weightedLatLng = (WeightedLatLng) it.next();
            double d5 = (double) weightedLatLng.a().x;
            double d6 = (double) weightedLatLng.a().y;
            if (d5 < d) {
                d = d5;
            }
            if (d5 > d2) {
                d2 = d5;
            }
            if (d6 < d3) {
                d3 = d6;
            }
            if (d6 > d4) {
                d4 = d6;
            }
        }
        return new g(d, d2, d3, d4);
    }

    private synchronized void d() {
        this.o.clear();
    }

    /* Access modifiers changed, original: 0000 */
    public Tile a(int i, int i2, int i3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append("_");
        stringBuilder.append(i2);
        stringBuilder.append("_");
        stringBuilder.append(i3);
        String stringBuilder2 = stringBuilder.toString();
        Tile c = c(stringBuilder2);
        if (c != null) {
            return c;
        }
        if (!a(stringBuilder2)) {
            if (this.a != null && r == 0) {
                MapStatus mapStatus = this.a.getMapStatus();
                r = ((((mapStatus.a.j.right - mapStatus.a.j.left) / 256) + 2) * (((mapStatus.a.j.bottom - mapStatus.a.j.top) / 256) + 2)) * 4;
            }
            if (this.o.size() > r) {
                a();
            }
            if (!this.p.isShutdown()) {
                try {
                    this.p.execute(new i(this, i, i2, i3));
                    b(stringBuilder2);
                } catch (RejectedExecutionException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /* Access modifiers changed, original: declared_synchronized */
    public synchronized void a() {
        this.q.clear();
        this.o.clear();
    }

    /* Access modifiers changed, original: 0000 */
    public void b() {
        d();
    }

    /* Access modifiers changed, original: 0000 */
    public void c() {
        this.p.shutdownNow();
    }

    public void removeHeatMap() {
        if (this.a != null) {
            this.a.a(this);
        }
    }
}
