package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.jiguang.net.HttpUtils;
import com.amap.api.mapcore.util.o0OO0o00.O000000o;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.BaseHoleOptions;
import com.amap.api.maps.model.CircleHoleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.PolygonHoleOptions;
import com.amap.api.maps.utils.SpatialRelationUtil;
import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.AeUtil;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.FPoint3;
import com.autonavi.amap.mapcore.FileUtil;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapConfig;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: Util */
public class OOo000 {
    private static FPoint[] O000000o = new FPoint[]{FPoint.obtain(), FPoint.obtain(), FPoint.obtain(), FPoint.obtain()};
    private static List<Float> O00000Oo = new ArrayList(4);
    private static List<Float> O00000o0 = new ArrayList(4);

    public static double O000000o(double d, double d2, double d3, double d4, double d5, double d6) {
        return ((d3 - d) * (d6 - d2)) - ((d5 - d) * (d4 - d2));
    }

    public static double O000000o(float f, double d, double d2) {
        return 20.0d - (Math.log(d2 / (d * ((double) f))) / Math.log(2.0d));
    }

    public static float O000000o(float f, float f2) {
        if (f <= 40.0f) {
            return f;
        }
        int i = f2 <= 15.0f ? 40 : f2 <= 16.0f ? 56 : f2 <= 17.0f ? 66 : f2 <= 18.0f ? 74 : f2 <= 18.0f ? 78 : 80;
        f2 = (float) i;
        return f > f2 ? f2 : f;
    }

    private static float O000000o(float f, float f2, double d) {
        return (float) (d / (Math.pow(2.0d, (double) (20.0f - f2)) * ((double) f)));
    }

    private static float O000000o(float f, float f2, float f3) {
        return (float) ((((double) f3) * Math.pow(2.0d, (double) (20.0f - f2))) * ((double) f));
    }

    public static float O000000o(DPoint dPoint, DPoint dPoint2) {
        if (dPoint == null || dPoint2 == null) {
            return 0.0f;
        }
        double d = dPoint.x;
        double d2 = dPoint2.x;
        return (float) ((Math.atan2(dPoint2.y - dPoint.y, d2 - d) / 3.141592653589793d) * 180.0d);
    }

    public static float O000000o(MapConfig mapConfig, float f) {
        return mapConfig != null ? f > mapConfig.maxZoomLevel ? mapConfig.maxZoomLevel : f < mapConfig.minZoomLevel ? mapConfig.minZoomLevel : f : f > 20.0f ? 20.0f : f < 3.0f ? 3.0f : f;
    }

    public static int O000000o(int i, int i2) {
        return O000000o(0, Bitmap.createBitmap(i, i2, Config.ARGB_8888), true);
    }

    public static int O000000o(int i, Bitmap bitmap, int i2, int i3) {
        if (bitmap == null || bitmap.isRecycled()) {
            return 0;
        }
        if (i == 0) {
            int[] iArr = new int[]{0};
            GLES20.glGenTextures(1, iArr, 0);
            i = iArr[0];
        }
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i);
        GLUtils.texSubImage2D(3553, 0, i2, i3, bitmap);
        return i;
    }

    public static int O000000o(int i, Bitmap bitmap, boolean z) {
        i = O00000Oo(i, bitmap, z);
        if (bitmap != null) {
            bitmap.recycle();
        }
        return i;
    }

    public static int O000000o(Bitmap bitmap) {
        return O000000o(bitmap, false);
    }

    public static int O000000o(Bitmap bitmap, boolean z) {
        return O000000o(0, bitmap, z);
    }

    public static int O000000o(Object[] objArr) {
        return Arrays.hashCode(objArr);
    }

    public static Bitmap O000000o(int i, int i2, int i3, int i4) {
        int i5 = i3 * i4;
        try {
            int[] iArr = new int[i5];
            int[] iArr2 = new int[i5];
            IntBuffer wrap = IntBuffer.wrap(iArr);
            wrap.position(0);
            GLES20.glReadPixels(i, i2, i3, i4, 6408, 5121, wrap);
            for (i = 0; i < i4; i++) {
                for (i2 = 0; i2 < i3; i2++) {
                    int i6 = iArr[(i * i3) + i2];
                    iArr2[(((i4 - i) - 1) * i3) + i2] = ((i6 & -16711936) | ((i6 << 16) & 16711680)) | ((i6 >> 16) & 255);
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(i3, i4, Config.ARGB_8888);
            createBitmap.setPixels(iArr2, 0, i3, 0, 0, i3, i4);
            return createBitmap;
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "AMapDelegateImpGLSurfaceView", "SavePixels");
            th.printStackTrace();
            return null;
        }
    }

    public static Bitmap O000000o(Context context, String str) {
        try {
            InputStream open = OOOO0OO.O000000o(context).open(str);
            Bitmap decodeStream = BitmapFactory.decodeStream(open);
            open.close();
            return decodeStream;
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "Util", "fromAsset");
            return null;
        }
    }

    public static Bitmap O000000o(Bitmap bitmap, float f) {
        return bitmap == null ? null : Bitmap.createScaledBitmap(bitmap, (int) (((float) bitmap.getWidth()) * f), (int) (((float) bitmap.getHeight()) * f), true);
    }

    public static Bitmap O000000o(View view) {
        try {
            O00000Oo(view);
            view.destroyDrawingCache();
            view.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            Bitmap drawingCache = view.getDrawingCache();
            return drawingCache != null ? drawingCache.copy(Config.ARGB_8888, false) : null;
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "Utils", "getBitmapFromView");
            th.printStackTrace();
            return null;
        }
    }

    public static Pair<Float, IPoint> O000000o(AbstractCameraUpdateMessage abstractCameraUpdateMessage, GLMapState gLMapState, MapConfig mapConfig) {
        return O000000o(mapConfig, Math.max(abstractCameraUpdateMessage.paddingLeft, 1), Math.max(abstractCameraUpdateMessage.paddingRight, 1), Math.max(abstractCameraUpdateMessage.paddingTop, 1), Math.max(abstractCameraUpdateMessage.paddingBottom, 1), abstractCameraUpdateMessage.bounds, abstractCameraUpdateMessage.width, abstractCameraUpdateMessage.height);
    }

    public static Pair<Float, Boolean> O000000o(MapConfig mapConfig, int i, int i2, int i3, int i4, int i5, int i6) {
        float maxZoomLevel;
        mapConfig.getSZ();
        boolean z = true;
        if (i == i3 && i2 == i4) {
            maxZoomLevel = mapConfig.getMaxZoomLevel();
        } else {
            float O000000o = (float) O000000o(mapConfig.getMapZoomScale(), (double) i5, (double) Math.abs(i3 - i));
            float min = Math.min(O000000o, (float) O000000o(mapConfig.getMapZoomScale(), (double) i6, (double) Math.abs(i4 - i2)));
            if (min != O000000o) {
                z = false;
            }
            maxZoomLevel = Math.min(mapConfig.getMaxZoomLevel(), Math.max(mapConfig.getMinZoomLevel(), min));
        }
        return new Pair(Float.valueOf(maxZoomLevel), Boolean.valueOf(z));
    }

    /* JADX WARNING: Missing block: B:33:0x0124, code skipped:
            return null;
     */
    public static android.util.Pair<java.lang.Float, com.autonavi.amap.mapcore.IPoint> O000000o(com.autonavi.amap.mapcore.MapConfig r16, int r17, int r18, int r19, int r20, com.amap.api.maps.model.LatLngBounds r21, int r22, int r23) {
        /*
        r7 = r16;
        r0 = r21;
        r1 = 0;
        if (r0 == 0) goto L_0x0124;
    L_0x0007:
        r2 = r0.northeast;
        if (r2 == 0) goto L_0x0124;
    L_0x000b:
        r2 = r0.southwest;
        if (r2 != 0) goto L_0x0011;
    L_0x000f:
        goto L_0x0124;
    L_0x0011:
        if (r7 != 0) goto L_0x0014;
    L_0x0013:
        return r1;
    L_0x0014:
        r2 = r0.northeast;
        r2 = r2.latitude;
        r4 = r0.northeast;
        r4 = r4.longitude;
        r6 = 20;
        r10 = com.autonavi.amap.mapcore.VirtualEarthProjection.latLongToPixels(r2, r4, r6);
        r2 = r0.southwest;
        r2 = r2.latitude;
        r0 = r0.southwest;
        r4 = r0.longitude;
        r11 = com.autonavi.amap.mapcore.VirtualEarthProjection.latLongToPixels(r2, r4, r6);
        r0 = r10.x;
        r2 = r11.x;
        r0 = r0 - r2;
        r2 = r11.y;
        r3 = r10.y;
        r2 = r2 - r3;
        r3 = r17 + r18;
        r3 = r22 - r3;
        r4 = r19 + r20;
        r4 = r23 - r4;
        if (r0 >= 0) goto L_0x0045;
    L_0x0042:
        if (r2 >= 0) goto L_0x0045;
    L_0x0044:
        return r1;
    L_0x0045:
        r12 = 1;
        if (r0 > 0) goto L_0x004a;
    L_0x0048:
        r6 = r12;
        goto L_0x004b;
    L_0x004a:
        r6 = r0;
    L_0x004b:
        if (r2 > 0) goto L_0x004f;
    L_0x004d:
        r5 = r12;
        goto L_0x0050;
    L_0x004f:
        r5 = r2;
    L_0x0050:
        if (r3 > 0) goto L_0x0054;
    L_0x0052:
        r13 = r12;
        goto L_0x0055;
    L_0x0054:
        r13 = r3;
    L_0x0055:
        if (r4 > 0) goto L_0x0059;
    L_0x0057:
        r14 = r12;
        goto L_0x005a;
    L_0x0059:
        r14 = r4;
    L_0x005a:
        r1 = r10.x;
        r2 = r10.y;
        r3 = r11.x;
        r4 = r11.y;
        r0 = r7;
        r9 = r5;
        r5 = r13;
        r8 = r6;
        r6 = r14;
        r0 = O000000o(r0, r1, r2, r3, r4, r5, r6);
        r1 = r0.first;
        r1 = (java.lang.Float) r1;
        r1 = r1.floatValue();
        r0 = r0.second;
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        r2 = r16.getMapZoomScale();
        r3 = (double) r8;
        r2 = O000000o(r2, r1, r3);
        r3 = r16.getMapZoomScale();
        r4 = (double) r9;
        r3 = O000000o(r3, r1, r4);
        r4 = r7.maxZoomLevel;
        r4 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1));
        r5 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        if (r4 < 0) goto L_0x00b0;
    L_0x0095:
        r0 = r11.x;
        r0 = (float) r0;
        r4 = r18 - r17;
        r4 = (float) r4;
        r4 = r4 + r2;
        r6 = (float) r8;
        r4 = r4 * r6;
        r2 = r2 * r5;
        r4 = r4 / r2;
        r0 = r0 + r4;
        r0 = (int) r0;
        r2 = r10.y;
        r2 = (float) r2;
        r4 = r20 - r19;
        r4 = (float) r4;
        r4 = r4 + r3;
        r6 = (float) r9;
        r4 = r4 * r6;
        r5 = r5 * r3;
        r4 = r4 / r5;
        r2 = r2 + r4;
        r2 = (int) r2;
        goto L_0x00ea;
    L_0x00b0:
        if (r0 == 0) goto L_0x00ce;
    L_0x00b2:
        r0 = r11.x;
        r0 = (float) r0;
        r6 = r8;
        r4 = r22 / 2;
        r4 = r4 - r17;
        r4 = (float) r4;
        r4 = r4 / r2;
        r2 = (float) r6;
        r4 = r4 * r2;
        r0 = r0 + r4;
        r0 = (int) r0;
        r2 = r10.y;
        r2 = (float) r2;
        r4 = r20 - r19;
        r4 = (float) r4;
        r4 = r4 + r3;
        r6 = (float) r9;
        r4 = r4 * r6;
        r5 = r5 * r3;
        r4 = r4 / r5;
        r2 = r2 + r4;
        r2 = (int) r2;
        goto L_0x00ea;
    L_0x00ce:
        r6 = r8;
        r0 = r11.x;
        r0 = (float) r0;
        r4 = r18 - r17;
        r4 = (float) r4;
        r4 = r4 + r2;
        r6 = (float) r6;
        r4 = r4 * r6;
        r5 = r5 * r2;
        r4 = r4 / r5;
        r0 = r0 + r4;
        r0 = (int) r0;
        r2 = r10.y;
        r2 = (float) r2;
        r5 = r9;
        r4 = r23 / 2;
        r4 = r4 - r19;
        r4 = (float) r4;
        r4 = r4 / r3;
        r3 = (float) r5;
        r4 = r4 * r3;
        r2 = r2 + r4;
        r2 = (int) r2;
    L_0x00ea:
        r3 = r16.getAnchorX();
        r4 = r16.getMapWidth();
        r4 = r4 >> r12;
        r3 = r3 - r4;
        r3 = (float) r3;
        r4 = r16.getAnchorY();
        r5 = r16.getMapHeight();
        r5 = r5 >> r12;
        r4 = r4 - r5;
        r4 = (float) r4;
        r0 = (float) r0;
        r5 = r16.getMapZoomScale();
        r3 = O000000o(r5, r1, r3);
        r0 = r0 + r3;
        r0 = (int) r0;
        r2 = (float) r2;
        r3 = r16.getMapZoomScale();
        r3 = O000000o(r3, r1, r4);
        r2 = r2 + r3;
        r2 = (int) r2;
        r3 = new android.util.Pair;
        r1 = java.lang.Float.valueOf(r1);
        r0 = com.autonavi.amap.mapcore.IPoint.obtain(r0, r2);
        r3.<init>(r1, r0);
        return r3;
    L_0x0124:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.OOo000.O000000o(com.autonavi.amap.mapcore.MapConfig, int, int, int, int, com.amap.api.maps.model.LatLngBounds, int, int):android.util.Pair");
    }

    public static DPoint O000000o(LatLng latLng) {
        double d = (latLng.longitude / 360.0d) + 0.5d;
        double sin = Math.sin(Math.toRadians(latLng.latitude));
        return DPoint.obtain(d * 1.0d, (((Math.log((1.0d + sin) / (1.0d - sin)) * 0.5d) / -6.283185307179586d) + 0.5d) * 1.0d);
    }

    private static FPoint3 O000000o(FPoint fPoint, FPoint fPoint2, FPoint3 fPoint3, FPoint3 fPoint32, int i) {
        FPoint3 fPoint33 = new FPoint3(0.0f, 0.0f, i);
        double d = (double) (((fPoint2.y - fPoint.y) * (fPoint.x - fPoint3.x)) - ((fPoint2.x - fPoint.x) * (fPoint.y - fPoint3.y)));
        double d2 = (double) (((fPoint2.y - fPoint.y) * (fPoint32.x - fPoint3.x)) - ((fPoint2.x - fPoint.x) * (fPoint32.y - fPoint3.y)));
        fPoint33.x = (float) (((double) fPoint3.x) + ((((double) (fPoint32.x - fPoint3.x)) * d) / d2));
        fPoint33.y = (float) (((double) fPoint3.y) + ((((double) (fPoint32.y - fPoint3.y)) * d) / d2));
        return fPoint33;
    }

    private static FPoint O000000o(FPoint fPoint, FPoint fPoint2, FPoint fPoint3, FPoint fPoint4) {
        FPoint obtain = FPoint.obtain(0.0f, 0.0f);
        double d = (double) (((fPoint2.y - fPoint.y) * (fPoint.x - fPoint3.x)) - ((fPoint2.x - fPoint.x) * (fPoint.y - fPoint3.y)));
        double d2 = (double) (((fPoint2.y - fPoint.y) * (fPoint4.x - fPoint3.x)) - ((fPoint2.x - fPoint.x) * (fPoint4.y - fPoint3.y)));
        obtain.x = (float) (((double) fPoint3.x) + ((((double) (fPoint4.x - fPoint3.x)) * d) / d2));
        obtain.y = (float) (((double) fPoint3.y) + ((((double) (fPoint4.y - fPoint3.y)) * d) / d2));
        return obtain;
    }

    private static IPoint O000000o(IPoint iPoint, IPoint iPoint2, IPoint iPoint3, IPoint iPoint4) {
        IPoint obtain = IPoint.obtain(0, 0);
        double d = (((double) (iPoint2.y - iPoint.y)) * ((double) (iPoint.x - iPoint3.x))) - (((double) (iPoint2.x - iPoint.x)) * ((double) (iPoint.y - iPoint3.y)));
        double d2 = (((double) (iPoint2.y - iPoint.y)) * ((double) (iPoint4.x - iPoint3.x))) - (((double) (iPoint2.x - iPoint.x)) * ((double) (iPoint4.y - iPoint3.y)));
        obtain.x = (int) (((double) iPoint3.x) + ((((double) (iPoint4.x - iPoint3.x)) * d) / d2));
        obtain.y = (int) (((double) iPoint3.y) + ((((double) (iPoint4.y - iPoint3.y)) * d) / d2));
        return obtain;
    }

    public static String O000000o(int i) {
        if (i < 1000) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i);
            stringBuilder.append("m");
            return stringBuilder.toString();
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(i / 1000);
        stringBuilder2.append("km");
        return stringBuilder2.toString();
    }

    public static String O000000o(Context context) {
        File file = new File(FileUtil.getMapBaseStorage(context), AeUtil.ROOT_DATA_PATH_NAME);
        if (!file.exists()) {
            file.mkdir();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(file.toString());
        stringBuilder.append(File.separator);
        File file2 = new File(stringBuilder.toString());
        if (!file2.exists()) {
            file2.mkdir();
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(file.toString());
        stringBuilder.append(File.separator);
        return stringBuilder.toString();
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:72:0x00a0=Splitter:B:72:0x00a0, B:49:0x0071=Splitter:B:49:0x0071} */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x00d4 A:{SYNTHETIC, Splitter:B:97:0x00d4} */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x00f6 A:{SYNTHETIC, Splitter:B:115:0x00f6} */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00ac A:{SYNTHETIC, Splitter:B:75:0x00ac} */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x00c9 A:{SYNTHETIC, Splitter:B:91:0x00c9} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x007d A:{SYNTHETIC, Splitter:B:52:0x007d} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x009a A:{SYNTHETIC, Splitter:B:68:0x009a} */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x00d4 A:{SYNTHETIC, Splitter:B:97:0x00d4} */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x00f6 A:{SYNTHETIC, Splitter:B:115:0x00f6} */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00ac A:{SYNTHETIC, Splitter:B:75:0x00ac} */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x00c9 A:{SYNTHETIC, Splitter:B:91:0x00c9} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x007d A:{SYNTHETIC, Splitter:B:52:0x007d} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x009a A:{SYNTHETIC, Splitter:B:68:0x009a} */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x00d4 A:{SYNTHETIC, Splitter:B:97:0x00d4} */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x00f6 A:{SYNTHETIC, Splitter:B:115:0x00f6} */
    public static java.lang.String O000000o(java.io.File r6) {
        /*
        r0 = new java.lang.StringBuffer;
        r0.<init>();
        r1 = 0;
        r2 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x009e, IOException -> 0x006f, all -> 0x006b }
        r2.<init>(r6);	 Catch:{ FileNotFoundException -> 0x009e, IOException -> 0x006f, all -> 0x006b }
        r6 = new java.io.BufferedReader;	 Catch:{ FileNotFoundException -> 0x0066, IOException -> 0x0061, all -> 0x005b }
        r3 = new java.io.InputStreamReader;	 Catch:{ FileNotFoundException -> 0x0066, IOException -> 0x0061, all -> 0x005b }
        r4 = "utf-8";
        r3.<init>(r2, r4);	 Catch:{ FileNotFoundException -> 0x0066, IOException -> 0x0061, all -> 0x005b }
        r6.<init>(r3);	 Catch:{ FileNotFoundException -> 0x0066, IOException -> 0x0061, all -> 0x005b }
    L_0x0017:
        r1 = r6.readLine();	 Catch:{ FileNotFoundException -> 0x0056, IOException -> 0x0051, all -> 0x004c }
        if (r1 == 0) goto L_0x0021;
    L_0x001d:
        r0.append(r1);	 Catch:{ FileNotFoundException -> 0x0056, IOException -> 0x0051, all -> 0x004c }
        goto L_0x0017;
    L_0x0021:
        if (r2 == 0) goto L_0x0045;
    L_0x0023:
        r2.close();	 Catch:{ IOException -> 0x0029 }
        goto L_0x0045;
    L_0x0027:
        r0 = move-exception;
        goto L_0x003a;
    L_0x0029:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ all -> 0x0027 }
        if (r6 == 0) goto L_0x00cc;
    L_0x002f:
        r6.close();	 Catch:{ IOException -> 0x0034 }
        goto L_0x00cc;
    L_0x0034:
        r6 = move-exception;
        r6.printStackTrace();
        goto L_0x00cc;
    L_0x003a:
        if (r6 == 0) goto L_0x0044;
    L_0x003c:
        r6.close();	 Catch:{ IOException -> 0x0040 }
        goto L_0x0044;
    L_0x0040:
        r6 = move-exception;
        r6.printStackTrace();
    L_0x0044:
        throw r0;
    L_0x0045:
        if (r6 == 0) goto L_0x00cc;
    L_0x0047:
        r6.close();	 Catch:{ IOException -> 0x0034 }
        goto L_0x00cc;
    L_0x004c:
        r0 = move-exception;
        r1 = r2;
        r2 = r6;
        goto L_0x00d2;
    L_0x0051:
        r1 = move-exception;
        r5 = r2;
        r2 = r6;
        r6 = r1;
        goto L_0x0064;
    L_0x0056:
        r1 = move-exception;
        r5 = r2;
        r2 = r6;
        r6 = r1;
        goto L_0x0069;
    L_0x005b:
        r0 = move-exception;
        r5 = r2;
        r2 = r1;
        r1 = r5;
        goto L_0x00d2;
    L_0x0061:
        r6 = move-exception;
        r5 = r2;
        r2 = r1;
    L_0x0064:
        r1 = r5;
        goto L_0x0071;
    L_0x0066:
        r6 = move-exception;
        r5 = r2;
        r2 = r1;
    L_0x0069:
        r1 = r5;
        goto L_0x00a0;
    L_0x006b:
        r0 = move-exception;
        r2 = r1;
        goto L_0x00d2;
    L_0x006f:
        r6 = move-exception;
        r2 = r1;
    L_0x0071:
        r3 = "Util";
        r4 = "readFile io";
        com.amap.api.mapcore.util.ooOOOOoo.O00000o0(r6, r3, r4);	 Catch:{ all -> 0x00d1 }
        r6.printStackTrace();	 Catch:{ all -> 0x00d1 }
        if (r1 == 0) goto L_0x0098;
    L_0x007d:
        r1.close();	 Catch:{ IOException -> 0x0083 }
        goto L_0x0098;
    L_0x0081:
        r6 = move-exception;
        goto L_0x008d;
    L_0x0083:
        r6 = move-exception;
        r6.printStackTrace();	 Catch:{ all -> 0x0081 }
        if (r2 == 0) goto L_0x00cc;
    L_0x0089:
        r2.close();	 Catch:{ IOException -> 0x0034 }
        goto L_0x00cc;
    L_0x008d:
        if (r2 == 0) goto L_0x0097;
    L_0x008f:
        r2.close();	 Catch:{ IOException -> 0x0093 }
        goto L_0x0097;
    L_0x0093:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x0097:
        throw r6;
    L_0x0098:
        if (r2 == 0) goto L_0x00cc;
    L_0x009a:
        r2.close();	 Catch:{ IOException -> 0x0034 }
        goto L_0x00cc;
    L_0x009e:
        r6 = move-exception;
        r2 = r1;
    L_0x00a0:
        r3 = "Util";
        r4 = "readFile fileNotFound";
        com.amap.api.mapcore.util.ooOOOOoo.O00000o0(r6, r3, r4);	 Catch:{ all -> 0x00d1 }
        r6.printStackTrace();	 Catch:{ all -> 0x00d1 }
        if (r1 == 0) goto L_0x00c7;
    L_0x00ac:
        r1.close();	 Catch:{ IOException -> 0x00b2 }
        goto L_0x00c7;
    L_0x00b0:
        r6 = move-exception;
        goto L_0x00bc;
    L_0x00b2:
        r6 = move-exception;
        r6.printStackTrace();	 Catch:{ all -> 0x00b0 }
        if (r2 == 0) goto L_0x00cc;
    L_0x00b8:
        r2.close();	 Catch:{ IOException -> 0x0034 }
        goto L_0x00cc;
    L_0x00bc:
        if (r2 == 0) goto L_0x00c6;
    L_0x00be:
        r2.close();	 Catch:{ IOException -> 0x00c2 }
        goto L_0x00c6;
    L_0x00c2:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x00c6:
        throw r6;
    L_0x00c7:
        if (r2 == 0) goto L_0x00cc;
    L_0x00c9:
        r2.close();	 Catch:{ IOException -> 0x0034 }
    L_0x00cc:
        r6 = r0.toString();
        return r6;
    L_0x00d1:
        r0 = move-exception;
    L_0x00d2:
        if (r1 == 0) goto L_0x00f4;
    L_0x00d4:
        r1.close();	 Catch:{ IOException -> 0x00da }
        goto L_0x00f4;
    L_0x00d8:
        r6 = move-exception;
        goto L_0x00e9;
    L_0x00da:
        r6 = move-exception;
        r6.printStackTrace();	 Catch:{ all -> 0x00d8 }
        if (r2 == 0) goto L_0x00f9;
    L_0x00e0:
        r2.close();	 Catch:{ IOException -> 0x00e4 }
        goto L_0x00f9;
    L_0x00e4:
        r6 = move-exception;
        r6.printStackTrace();
        goto L_0x00f9;
    L_0x00e9:
        if (r2 == 0) goto L_0x00f3;
    L_0x00eb:
        r2.close();	 Catch:{ IOException -> 0x00ef }
        goto L_0x00f3;
    L_0x00ef:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x00f3:
        throw r6;
    L_0x00f4:
        if (r2 == 0) goto L_0x00f9;
    L_0x00f6:
        r2.close();	 Catch:{ IOException -> 0x00e4 }
    L_0x00f9:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.OOo000.O000000o(java.io.File):java.lang.String");
    }

    public static String O000000o(InputStream inputStream) {
        try {
            return new String(O00000Oo(inputStream), "utf-8");
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "Util", "decodeAssetResData");
            th.printStackTrace();
            return null;
        }
    }

    public static String O000000o(String str, Object obj) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(HttpUtils.EQUAL_SIGN);
        stringBuilder.append(String.valueOf(obj));
        return stringBuilder.toString();
    }

    public static String O000000o(String... strArr) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        int length = strArr.length;
        int i2 = 0;
        while (i < length) {
            stringBuilder.append(strArr[i]);
            if (i2 != strArr.length - 1) {
                stringBuilder.append(",");
            }
            i2++;
            i++;
        }
        return stringBuilder.toString();
    }

    public static FloatBuffer O000000o(float[] fArr) {
        try {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
            allocateDirect.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
            asFloatBuffer.put(fArr);
            asFloatBuffer.position(0);
            return asFloatBuffer;
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "Util", "makeFloatBuffer1");
            th.printStackTrace();
            return null;
        }
    }

    public static FloatBuffer O000000o(float[] fArr, FloatBuffer floatBuffer) {
        try {
            floatBuffer.clear();
            floatBuffer.put(fArr);
            floatBuffer.position(0);
            return floatBuffer;
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "Util", "makeFloatBuffer2");
            th.printStackTrace();
            return null;
        }
    }

    public static List<FPoint> O000000o(FPoint[] fPointArr, List<FPoint> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(list);
        int i = 0;
        while (i < 4) {
            arrayList.clear();
            int size = arrayList2.size();
            int i2 = 0;
            while (true) {
                if (i2 >= (z ? size : size - 1)) {
                    break;
                }
                FPoint fPoint = (FPoint) arrayList2.get(i2 % size);
                int i3 = i2 + 1;
                FPoint fPoint2 = (FPoint) arrayList2.get(i3 % size);
                if (i2 == 0 && O000000o(fPoint, fPointArr[i], fPointArr[(i + 1) % fPointArr.length])) {
                    arrayList.add(fPoint);
                }
                int i4 = i + 1;
                if (O000000o(fPoint, fPointArr[i], fPointArr[i4 % fPointArr.length])) {
                    if (O000000o(fPoint2, fPointArr[i], fPointArr[i4 % fPointArr.length])) {
                        arrayList.add(fPoint2);
                    } else {
                        arrayList.add(O000000o(fPointArr[i], fPointArr[i4 % fPointArr.length], fPoint, fPoint2));
                    }
                } else if (O000000o(fPoint2, fPointArr[i], fPointArr[i4 % fPointArr.length])) {
                    arrayList.add(O000000o(fPointArr[i], fPointArr[i4 % fPointArr.length], fPoint, fPoint2));
                    arrayList.add(fPoint2);
                }
                i2 = i3;
            }
            arrayList2.clear();
            for (size = 0; size < arrayList.size(); size++) {
                arrayList2.add(arrayList.get(size));
            }
            i = (byte) (i + 1);
        }
        return arrayList2;
    }

    public static List<IPoint> O000000o(IPoint[] iPointArr, List<IPoint> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(list);
        int i = 0;
        while (i < 4) {
            arrayList.clear();
            int size = arrayList2.size();
            int i2 = 0;
            while (true) {
                if (i2 >= (z ? size : size - 1)) {
                    break;
                }
                IPoint iPoint = (IPoint) arrayList2.get(i2 % size);
                int i3 = i2 + 1;
                IPoint iPoint2 = (IPoint) arrayList2.get(i3 % size);
                if (i2 == 0 && O000000o(iPoint, iPointArr[i], iPointArr[(i + 1) % iPointArr.length])) {
                    arrayList.add(iPoint);
                }
                int i4 = i + 1;
                if (O000000o(iPoint, iPointArr[i], iPointArr[i4 % iPointArr.length])) {
                    if (O000000o(iPoint2, iPointArr[i], iPointArr[i4 % iPointArr.length])) {
                        arrayList.add(iPoint2);
                    } else {
                        arrayList.add(O000000o(iPointArr[i], iPointArr[i4 % iPointArr.length], iPoint, iPoint2));
                    }
                } else if (O000000o(iPoint2, iPointArr[i], iPointArr[i4 % iPointArr.length])) {
                    arrayList.add(O000000o(iPointArr[i], iPointArr[i4 % iPointArr.length], iPoint, iPoint2));
                    arrayList.add(iPoint2);
                }
                i2 = i3;
            }
            arrayList2.clear();
            for (size = 0; size < arrayList.size(); size++) {
                arrayList2.add(arrayList.get(size));
            }
            i = (byte) (i + 1);
        }
        return arrayList2;
    }

    public static void O000000o(Rect rect) {
        if (rect != null) {
            rect.set(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, Integer.MIN_VALUE, Integer.MIN_VALUE, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        }
    }

    public static void O000000o(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public static boolean O000000o() {
        return VERSION.SDK_INT >= 8;
    }

    public static boolean O000000o(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        double d9 = d3 - d;
        double d10 = d8 - d6;
        double d11 = d4 - d2;
        double d12 = d7 - d5;
        double d13 = (d9 * d10) - (d11 * d12);
        if (d13 != 0.0d) {
            double d14 = d2 - d6;
            double d15 = d - d5;
            d12 = ((d12 * d14) - (d10 * d15)) / d13;
            d14 = ((d14 * d9) - (d15 * d11)) / d13;
            if (d12 >= 0.0d && d12 <= 1.0d && d14 >= 0.0d && d14 <= 1.0d) {
                return true;
            }
        }
        return false;
    }

    private static boolean O000000o(int i, int i2, IPoint iPoint, IPoint iPoint2) {
        return (((double) (iPoint2.x - iPoint.x)) * ((double) (i2 - iPoint.y))) - (((double) (i - iPoint.x)) * ((double) (iPoint2.y - iPoint.y))) >= 0.0d;
    }

    public static boolean O000000o(Rect rect, int i, int i2) {
        return rect.contains(i, i2);
    }

    public static boolean O000000o(BaseHoleOptions baseHoleOptions, LatLng latLng) {
        if (baseHoleOptions instanceof CircleHoleOptions) {
            CircleHoleOptions circleHoleOptions = (CircleHoleOptions) baseHoleOptions;
            LatLng center = circleHoleOptions.getCenter();
            return center != null && ((double) AMapUtils.calculateLineDistance(center, latLng)) <= circleHoleOptions.getRadius();
        } else {
            List points = ((PolygonHoleOptions) baseHoleOptions).getPoints();
            return (points == null || points.size() == 0) ? false : O000000o(latLng, points);
        }
    }

    public static boolean O000000o(CircleHoleOptions circleHoleOptions, CircleHoleOptions circleHoleOptions2) {
        boolean z = false;
        try {
            if (((double) AMapUtils.calculateLineDistance(circleHoleOptions2.getCenter(), circleHoleOptions.getCenter())) < circleHoleOptions.getRadius() + circleHoleOptions2.getRadius()) {
                z = true;
            }
            return z;
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "Util", "isPolygon2CircleIntersect");
            th.printStackTrace();
            return false;
        }
    }

    public static boolean O000000o(LatLng latLng, List<LatLng> list) {
        LatLng latLng2 = latLng;
        List list2 = list;
        double d = latLng2.longitude;
        double d2 = latLng2.latitude;
        double d3 = latLng2.latitude;
        boolean z = false;
        if (list.size() < 3) {
            return false;
        }
        boolean z2;
        boolean z3 = true;
        if (!((LatLng) list2.get(0)).equals(list2.get(list.size() - 1))) {
            list2.add(list2.get(0));
        }
        int i = 0;
        int i2 = i;
        while (i < list.size() - 1) {
            double d4 = ((LatLng) list2.get(i)).longitude;
            double d5 = ((LatLng) list2.get(i)).latitude;
            i++;
            double d6 = ((LatLng) list2.get(i)).longitude;
            int i3 = i;
            double d7 = ((LatLng) list2.get(i)).latitude;
            double d8 = d6;
            double d9 = d5;
            double d10 = d4;
            z2 = z;
            double d11 = d3;
            double d12 = d2;
            if (O00000Oo(d, d2, d4, d9, d8, d7)) {
                return true;
            }
            List<LatLng> list22;
            if (Math.abs(d7 - d9) >= 1.0E-9d) {
                if (O00000Oo(d10, d9, d, d12, 180.0d, d11)) {
                    if (d9 > d7) {
                        i2++;
                    }
                } else if (!O00000Oo(d8, d7, d, d12, 180.0d, d11)) {
                    d7 = d;
                    if (O000000o(d10, d9, d8, d7, d, d12, 180.0d, d11)) {
                        i2++;
                    }
                    d = d7;
                    i = i3;
                    z = z2;
                    d3 = d11;
                    d2 = d12;
                    list22 = list;
                } else if (d7 > d9) {
                    i2++;
                }
            }
            d7 = d;
            d = d7;
            i = i3;
            z = z2;
            d3 = d11;
            d2 = d12;
            list22 = list;
        }
        z2 = z;
        if (i2 % 2 == 0) {
            z3 = z2;
        }
        return z3;
    }

    private static boolean O000000o(FPoint fPoint, FPoint fPoint2, FPoint fPoint3) {
        return ((double) (((fPoint3.x - fPoint2.x) * (fPoint.y - fPoint2.y)) - ((fPoint.x - fPoint2.x) * (fPoint3.y - fPoint2.y)))) >= 0.0d;
    }

    public static boolean O000000o(FPoint fPoint, FPoint[] fPointArr) {
        if (fPointArr == null) {
            return false;
        }
        int i = 0;
        while (i < fPointArr.length) {
            FPoint fPoint2 = fPointArr[i];
            i++;
            if (!O000000o(fPoint, fPoint2, fPointArr[i % fPointArr.length])) {
                return false;
            }
            i = (byte) i;
        }
        return true;
    }

    private static boolean O000000o(IPoint iPoint, IPoint iPoint2, IPoint iPoint3) {
        return O000000o(iPoint.x, iPoint.y, iPoint2, iPoint3);
    }

    public static boolean O000000o(List<IPoint> list, int i, int i2) {
        List<IPoint> list2 = list;
        int i3 = i2;
        boolean z = false;
        if (i3 < 3) {
            return false;
        }
        int i4 = i3 - 1;
        double d = 0.0d;
        for (int i5 = 0; i5 < i3; i5++) {
            IPoint iPoint = (IPoint) list2.get(i4);
            IPoint iPoint2 = (IPoint) list2.get(i5);
            d += ((((double) iPoint.x) / 1000000.0d) * (((double) iPoint2.y) / 1000000.0d)) - ((((double) iPoint2.x) / 1000000.0d) * (((double) iPoint.y) / 1000000.0d));
            i4 = i5;
        }
        if (d < 0.0d) {
            z = true;
        }
        return z;
    }

    public static boolean O000000o(List<BaseHoleOptions> list, CircleHoleOptions circleHoleOptions) {
        int i = 0;
        boolean z = false;
        while (i < list.size()) {
            BaseHoleOptions baseHoleOptions = (BaseHoleOptions) list.get(i);
            if (baseHoleOptions instanceof PolygonHoleOptions) {
                z = O00000Oo(((PolygonHoleOptions) baseHoleOptions).getPoints(), circleHoleOptions);
                if (z) {
                    return true;
                }
            } else if (baseHoleOptions instanceof CircleHoleOptions) {
                z = O000000o(circleHoleOptions, (CircleHoleOptions) baseHoleOptions);
                if (z) {
                    return true;
                }
            } else {
                continue;
            }
            i++;
        }
        return z;
    }

    public static boolean O000000o(List<BaseHoleOptions> list, PolygonHoleOptions polygonHoleOptions) {
        int i = 0;
        boolean z = false;
        while (i < list.size()) {
            BaseHoleOptions baseHoleOptions = (BaseHoleOptions) list.get(i);
            if (baseHoleOptions instanceof PolygonHoleOptions) {
                z = O000000o(((PolygonHoleOptions) baseHoleOptions).getPoints(), polygonHoleOptions.getPoints());
                if (z) {
                    return true;
                }
            } else if (baseHoleOptions instanceof CircleHoleOptions) {
                z = O00000Oo(polygonHoleOptions.getPoints(), (CircleHoleOptions) baseHoleOptions);
                if (z) {
                    return true;
                }
            } else {
                continue;
            }
            i++;
        }
        return z;
    }

    public static boolean O000000o(List<LatLng> list, List<LatLng> list2) {
        int i = 0;
        while (i < list2.size()) {
            try {
                if (O000000o((LatLng) list2.get(i), (List) list)) {
                    return true;
                }
                i++;
            } catch (Throwable th) {
                ooOOOOoo.O00000o0(th, "Util", "isPolygon2PolygonIntersect");
                th.printStackTrace();
                return false;
            }
        }
        for (i = 0; i < list.size(); i++) {
            if (O000000o((LatLng) list.get(i), (List) list2)) {
                return true;
            }
        }
        return O00000Oo((List) list, (List) list2);
    }

    public static byte[] O000000o(byte[] bArr, int i) {
        return O000000o(bArr, i, i, true);
    }

    public static byte[] O000000o(byte[] bArr, int i, int i2, boolean z) {
        try {
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            Bitmap copy = decodeByteArray.copy(decodeByteArray.getConfig(), true);
            int width = decodeByteArray.getWidth();
            int height = decodeByteArray.getHeight();
            for (int i3 = 0; i3 < width; i3++) {
                for (int i4 = 0; i4 < height; i4++) {
                    if (i3 != 0) {
                        if (i4 != 0) {
                            copy.setPixel(i3, i4, i);
                        }
                    }
                    if (!z) {
                        copy.setPixel(i3, i4, i2);
                    }
                }
            }
            byte[] O00000Oo = O00000Oo(copy);
            if (O00000Oo == null) {
                O00000Oo = bArr;
            }
            copy.recycle();
            decodeByteArray.recycle();
            return O00000Oo;
        } catch (Throwable th) {
            th.printStackTrace();
            return bArr;
        }
    }

    public static byte[] O000000o(byte[] bArr, int[] iArr) {
        try {
            int i = 0;
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            int i2 = 1;
            Bitmap copy = decodeByteArray.copy(decodeByteArray.getConfig(), true);
            decodeByteArray.getWidth();
            decodeByteArray.getHeight();
            int i3 = 6;
            int i4 = 6;
            while (i2 < 72) {
                int i5 = i3;
                i3 = i;
                for (i = 8; i < 12; i++) {
                    decodeByteArray.getPixel(i, i2);
                    if (i2 < 4 * i4) {
                        copy.setPixel(i, i2, iArr[i3]);
                    } else {
                        i3++;
                        i5--;
                        i4 += i5;
                    }
                }
                i2++;
                i = i3;
                i3 = i5;
            }
            byte[] O00000Oo = O00000Oo(copy);
            if (O00000Oo == null) {
                O00000Oo = bArr;
            }
            copy.recycle();
            decodeByteArray.recycle();
            return O00000Oo;
        } catch (Throwable th) {
            th.printStackTrace();
            return bArr;
        }
    }

    public static synchronized int[] O000000o(int i, int i2, int i3, int i4, MapConfig mapConfig, GLMapState gLMapState, int i5, int i6) {
        int[] iArr;
        synchronized (OOo000.class) {
            int mapWidth = mapConfig.getMapWidth();
            int mapHeight = mapConfig.getMapHeight();
            int anchorX = mapConfig.getAnchorX();
            int anchorY = mapConfig.getAnchorY();
            float O000000o = O000000o(mapConfig.getMapZoomScale(), gLMapState.getMapZoomer(), (float) anchorX);
            float O000000o2 = O000000o(mapConfig.getMapZoomScale(), gLMapState.getMapZoomer(), (float) (mapWidth - anchorX));
            float O000000o3 = ((float) i2) + O000000o(mapConfig.getMapZoomScale(), gLMapState.getMapZoomer(), (float) anchorY);
            float O000000o4 = ((float) i4) - O000000o(mapConfig.getMapZoomScale(), gLMapState.getMapZoomer(), (float) (mapHeight - anchorY));
            iArr = new int[2];
            iArr[0] = (int) Math.max(((float) i3) + O000000o, Math.min((float) i5, ((float) i) - O000000o2));
            iArr[1] = (int) Math.max(O000000o3, Math.min((float) i6, O000000o4));
        }
        return iArr;
    }

    public static FPoint[] O000000o(ca caVar, boolean z) {
        int i;
        int i2;
        float skyHeight = caVar.getSkyHeight();
        if (z) {
            i = 100;
            i2 = 10;
        } else {
            i = 0;
            i2 = i;
        }
        PointF obtain = FPoint.obtain();
        int i3 = -i;
        int i4 = (int) (skyHeight - ((float) i2));
        caVar.O000000o(i3, i4, obtain);
        O000000o[0].set(obtain.x, obtain.y);
        PointF obtain2 = FPoint.obtain();
        caVar.O000000o(caVar.getMapWidth() + i, i4, obtain2);
        O000000o[1].set(obtain2.x, obtain2.y);
        PointF obtain3 = FPoint.obtain();
        caVar.O000000o(caVar.getMapWidth() + i, caVar.getMapHeight() + i, obtain3);
        O000000o[2].set(obtain3.x, obtain3.y);
        PointF obtain4 = FPoint.obtain();
        caVar.O000000o(i3, caVar.getMapHeight() + i, obtain4);
        O000000o[3].set(obtain4.x, obtain4.y);
        obtain.recycle();
        obtain2.recycle();
        obtain3.recycle();
        obtain4.recycle();
        return O000000o;
    }

    public static float O00000Oo(MapConfig mapConfig, int i, int i2, int i3, int i4, int i5, int i6) {
        float sz = mapConfig.getSZ();
        if (i == i3 || i2 == i4) {
            return sz;
        }
        return Math.max((float) O000000o(mapConfig.getMapZoomScale(), (double) i5, (double) Math.abs(i3 - i)), (float) O000000o(mapConfig.getMapZoomScale(), (double) i6, (double) Math.abs(i4 - i2)));
    }

    public static int O00000Oo(int i, Bitmap bitmap, boolean z) {
        if (bitmap == null || bitmap.isRecycled()) {
            return 0;
        }
        if (i == 0) {
            int[] iArr = new int[]{0};
            GLES20.glGenTextures(1, iArr, 0);
            i = iArr[0];
        }
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        if (z) {
            GLES20.glTexParameterf(3553, 10242, 10497.0f);
            GLES20.glTexParameterf(3553, 10243, 10497.0f);
        } else {
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
        }
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        return i;
    }

    public static String O00000Oo(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(FileUtil.getMapBaseStorage(context));
        stringBuilder.append(File.separator);
        stringBuilder.append("data");
        stringBuilder.append(File.separator);
        return stringBuilder.toString();
    }

    public static List<FPoint> O00000Oo(FPoint[] fPointArr, List<FPoint> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(list);
        int i = 0;
        while (i < 4) {
            arrayList.clear();
            int size = arrayList2.size();
            int i2 = 0;
            while (true) {
                if (i2 >= (z ? size : size - 1)) {
                    break;
                }
                FPoint fPoint = (FPoint3) arrayList2.get(i2 % size);
                int i3 = i2 + 1;
                FPoint fPoint2 = (FPoint3) arrayList2.get(i3 % size);
                if (i2 == 0 && O000000o(fPoint, fPointArr[i], fPointArr[(i + 1) % fPointArr.length])) {
                    arrayList.add(fPoint);
                }
                int i4 = i + 1;
                if (O000000o(fPoint, fPointArr[i], fPointArr[i4 % fPointArr.length])) {
                    if (O000000o(fPoint2, fPointArr[i], fPointArr[i4 % fPointArr.length])) {
                        arrayList.add(fPoint2);
                    } else {
                        arrayList.add(O000000o(fPointArr[i], fPointArr[i4 % fPointArr.length], fPoint, fPoint2, fPoint2.colorIndex));
                    }
                } else if (O000000o(fPoint2, fPointArr[i], fPointArr[i4 % fPointArr.length])) {
                    arrayList.add(O000000o(fPointArr[i], fPointArr[i4 % fPointArr.length], fPoint, fPoint2, fPoint.colorIndex));
                    arrayList.add(fPoint2);
                }
                i2 = i3;
            }
            arrayList2.clear();
            for (size = 0; size < arrayList.size(); size++) {
                arrayList2.add(arrayList.get(size));
            }
            i = (byte) (i + 1);
        }
        return arrayList2;
    }

    public static void O00000Oo(int i) {
        GLES20.glDeleteTextures(1, new int[]{i}, 0);
    }

    public static void O00000Oo(Rect rect, int i, int i2) {
        if (rect != null) {
            if (i < rect.left) {
                rect.left = i;
            }
            if (i > rect.right) {
                rect.right = i;
            }
            if (i2 > rect.top) {
                rect.top = i2;
            }
            if (i2 < rect.bottom) {
                rect.bottom = i2;
            }
        }
    }

    private static void O00000Oo(View view) {
        int i = 0;
        if (view instanceof ViewGroup) {
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i < viewGroup.getChildCount()) {
                    O00000Oo(viewGroup.getChildAt(i));
                    i++;
                } else {
                    return;
                }
            }
        } else if (view instanceof TextView) {
            ((TextView) view).setHorizontallyScrolling(false);
        }
    }

    public static boolean O00000Oo() {
        return VERSION.SDK_INT >= 9;
    }

    public static boolean O00000Oo(double d, double d2, double d3, double d4, double d5, double d6) {
        return Math.abs(O000000o(d, d2, d3, d4, d5, d6)) < 1.0E-9d && (d - d3) * (d - d5) <= 0.0d && (d2 - d4) * (d2 - d6) <= 0.0d;
    }

    public static boolean O00000Oo(int i, int i2) {
        if (i > 0 && i2 > 0) {
            return true;
        }
        Log.w("3dmap", "the map must have a size");
        return false;
    }

    public static boolean O00000Oo(List<LatLng> list, CircleHoleOptions circleHoleOptions) {
        try {
            int i;
            ArrayList arrayList = new ArrayList();
            for (i = 0; i < list.size(); i++) {
                arrayList.add(list.get(i));
            }
            arrayList.add(list.get(0));
            List arrayList2 = new ArrayList();
            i = 0;
            while (i < arrayList.size()) {
                int i2 = i + 1;
                if (i2 >= arrayList.size()) {
                    break;
                }
                if (circleHoleOptions.getRadius() < ((double) AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), (LatLng) arrayList.get(i)))) {
                    if (circleHoleOptions.getRadius() < ((double) AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), (LatLng) arrayList.get(i2)))) {
                        arrayList2.clear();
                        arrayList2.add(arrayList.get(i));
                        arrayList2.add(arrayList.get(i2));
                        if (circleHoleOptions.getRadius() >= ((double) AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), (LatLng) SpatialRelationUtil.calShortestDistancePoint(arrayList2, circleHoleOptions.getCenter()).second))) {
                            return true;
                        }
                        i = i2;
                    }
                }
                return true;
            }
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "Util", "isPolygon2CircleIntersect");
            th.printStackTrace();
        }
        return false;
    }

    private static boolean O00000Oo(List<LatLng> list, List<LatLng> list2) {
        int i = 0;
        while (i < list.size()) {
            try {
                int i2 = i + 1;
                if (i2 >= list.size()) {
                    break;
                }
                int i3 = 0;
                while (i3 < list2.size()) {
                    int i4 = i3 + 1;
                    if (i4 >= list2.size()) {
                        break;
                    }
                    boolean O000000o = OOOO0o0.O000000o((LatLng) list.get(i), (LatLng) list.get(i2), (LatLng) list2.get(i3), (LatLng) list2.get(i4));
                    if (O000000o) {
                        return O000000o;
                    }
                    i3 = i4;
                }
                i = i2;
            } catch (Throwable th) {
                ooOOOOoo.O00000o0(th, "Util", "isSegmentsIntersect");
                th.printStackTrace();
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x002e A:{SYNTHETIC, Splitter:B:24:0x002e} */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0022 A:{SYNTHETIC, Splitter:B:15:0x0022} */
    private static byte[] O00000Oo(android.graphics.Bitmap r4) {
        /*
        r0 = 0;
        r1 = new java.io.ByteArrayOutputStream;	 Catch:{ Throwable -> 0x002b, all -> 0x001e }
        r1.<init>();	 Catch:{ Throwable -> 0x002b, all -> 0x001e }
        r2 = android.graphics.Bitmap.CompressFormat.PNG;	 Catch:{ Throwable -> 0x002c, all -> 0x001c }
        r3 = 100;
        r4.compress(r2, r3, r1);	 Catch:{ Throwable -> 0x002c, all -> 0x001c }
        r4 = r1.toByteArray();	 Catch:{ Throwable -> 0x002c, all -> 0x001c }
        if (r1 == 0) goto L_0x001b;
    L_0x0013:
        r1.close();	 Catch:{ Throwable -> 0x0017 }
        goto L_0x001b;
    L_0x0017:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x001b:
        return r4;
    L_0x001c:
        r4 = move-exception;
        goto L_0x0020;
    L_0x001e:
        r4 = move-exception;
        r1 = r0;
    L_0x0020:
        if (r1 == 0) goto L_0x002a;
    L_0x0022:
        r1.close();	 Catch:{ Throwable -> 0x0026 }
        goto L_0x002a;
    L_0x0026:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x002a:
        throw r4;
    L_0x002b:
        r1 = r0;
    L_0x002c:
        if (r1 == 0) goto L_0x0036;
    L_0x002e:
        r1.close();	 Catch:{ Throwable -> 0x0032 }
        goto L_0x0036;
    L_0x0032:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x0036:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.OOo000.O00000Oo(android.graphics.Bitmap):byte[]");
    }

    public static byte[] O00000Oo(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[2048];
        while (true) {
            int read = inputStream.read(bArr, 0, 2048);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static boolean O00000o() {
        return VERSION.SDK_INT >= 12;
    }

    public static boolean O00000o(Context context) {
        if (context == null) {
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return false;
        }
        State state = activeNetworkInfo.getState();
        return (state == null || state == State.DISCONNECTED || state == State.DISCONNECTING) ? false : true;
    }

    public static String O00000o0(Context context) {
        String O000000o = O000000o(context);
        if (O000000o == null) {
            return null;
        }
        File file = new File(O000000o, "VMAP2");
        if (!file.exists()) {
            file.mkdir();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(file.toString());
        stringBuilder.append(File.separator);
        return stringBuilder.toString();
    }

    public static boolean O00000o0() {
        return VERSION.SDK_INT >= 11;
    }

    public static o0OO0o00 O00000oO() {
        try {
            if (bu.O00000oO != null) {
                return bu.O00000oO;
            }
            return new O000000o("3dmap", "6.8.0", bu.O00000o0).O000000o(new String[]{"com.amap.api.maps", "com.amap.api.mapcore", "com.autonavi.amap.mapcore", "com.amap.api.3dmap.admic", "com.amap.api.trace", "com.amap.api.trace.core"}).O000000o("6.8.0").O000000o();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean O00000oO(Context context) {
        File file = new File(O00000Oo(context));
        return !file.exists() ? true : FileUtil.deleteFile(file);
    }
}
