package com.baidu.location.b;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import cn.jiguang.net.HttpUtils;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.g.b;
import com.baidu.location.g.e;
import com.baidu.location.g.j;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;

public class a {
    private static Object b = new Object();
    private static a c;
    private static final String d;
    a a = null;
    private SQLiteDatabase e = null;
    private boolean f = false;
    private String g = null;
    private double h = Double.MAX_VALUE;
    private double i = Double.MAX_VALUE;

    class a extends e {
        int a;
        int b;
        int c;
        int d;
        double e;

        a() {
            this.k = new HashMap();
        }

        public void a() {
            this.h = "http://loc.map.baidu.com/gpsz";
            String format = String.format(Locale.CHINESE, "&x=%d&y=%d%s", new Object[]{Integer.valueOf(this.a), Integer.valueOf(this.b), b.a().c()});
            String encode = Jni.encode(format);
            if (encode.contains("err!")) {
                Object a;
                try {
                    a = com.baidu.android.bbalbs.common.a.b.a(format.toString().getBytes(), HttpUtils.ENCODING_UTF_8);
                } catch (Exception unused) {
                    a = "err2!";
                }
                this.k.put("gpszb", a);
                return;
            }
            this.k.put("gpsz", encode);
        }

        public void a(double d, double d2, double d3) {
            if (!a.this.f) {
                double[] coorEncrypt = Jni.coorEncrypt(d, d2, "gcj2wgs");
                this.a = (int) Math.floor(coorEncrypt[0] * 100.0d);
                this.b = (int) Math.floor(coorEncrypt[1] * 100.0d);
                this.c = (int) Math.floor(d * 100.0d);
                this.d = (int) Math.floor(d2 * 100.0d);
                this.e = d3;
                a.this.f = true;
                e();
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:45:0x011c A:{SYNTHETIC} */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x010c A:{Catch:{ Exception -> 0x011c }} */
        public void a(boolean r18) {
            /*
            r17 = this;
            r0 = r17;
            r1 = 0;
            if (r18 == 0) goto L_0x0124;
        L_0x0005:
            r2 = r0.j;
            if (r2 == 0) goto L_0x0124;
        L_0x0009:
            r2 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0124 }
            r3 = r0.j;	 Catch:{ Exception -> 0x0124 }
            r2.<init>(r3);	 Catch:{ Exception -> 0x0124 }
            if (r2 == 0) goto L_0x0124;
        L_0x0012:
            r3 = "height";
            r3 = r2.has(r3);	 Catch:{ Exception -> 0x0124 }
            if (r3 == 0) goto L_0x0124;
        L_0x001a:
            r3 = "height";
            r2 = r2.getString(r3);	 Catch:{ Exception -> 0x0124 }
            r3 = ",";
            r3 = r2.contains(r3);	 Catch:{ Exception -> 0x0124 }
            if (r3 == 0) goto L_0x0124;
        L_0x0028:
            r2 = r2.trim();	 Catch:{ Exception -> 0x0124 }
            r3 = ",";
            r2 = r2.split(r3);	 Catch:{ Exception -> 0x0124 }
            r3 = r2.length;	 Catch:{ Exception -> 0x0124 }
            r4 = (double) r3;	 Catch:{ Exception -> 0x0124 }
            r4 = java.lang.Math.sqrt(r4);	 Catch:{ Exception -> 0x0124 }
            r4 = (int) r4;	 Catch:{ Exception -> 0x0124 }
            r5 = r4 * r4;
            if (r5 != r3) goto L_0x0124;
        L_0x003d:
            r3 = r0.c;	 Catch:{ Exception -> 0x0124 }
            r5 = r4 + -1;
            r6 = r5 / 2;
            r3 = r3 - r6;
            r6 = r0.d;	 Catch:{ Exception -> 0x0124 }
            r7 = 2;
            r5 = r5 / r7;
            r6 = r6 - r5;
            r5 = r1;
        L_0x004a:
            if (r5 >= r4) goto L_0x0124;
        L_0x004c:
            r8 = r1;
        L_0x004d:
            if (r8 >= r4) goto L_0x0120;
        L_0x004f:
            r9 = new android.content.ContentValues;	 Catch:{ Exception -> 0x0124 }
            r9.<init>();	 Catch:{ Exception -> 0x0124 }
            r10 = r5 * r4;
            r10 = r10 + r8;
            r11 = r2[r10];	 Catch:{ Exception -> 0x0124 }
            r12 = "E";
            r11 = r11.contains(r12);	 Catch:{ Exception -> 0x0124 }
            r12 = 4666723172467343360; // 0x40c3880000000000 float:0.0 double:10000.0;
            r14 = 1;
            if (r11 == 0) goto L_0x007a;
        L_0x0067:
            r10 = "aldata";
            r11 = java.lang.Double.valueOf(r12);	 Catch:{ Exception -> 0x0124 }
            r9.put(r10, r11);	 Catch:{ Exception -> 0x0124 }
            r10 = "sigma";
        L_0x0072:
            r11 = java.lang.Double.valueOf(r12);	 Catch:{ Exception -> 0x0124 }
            r9.put(r10, r11);	 Catch:{ Exception -> 0x0124 }
            goto L_0x00bc;
        L_0x007a:
            r11 = r2[r10];	 Catch:{ Exception -> 0x0124 }
            r15 = ":";
            r11 = r11.contains(r15);	 Catch:{ Exception -> 0x0124 }
            if (r11 != 0) goto L_0x0092;
        L_0x0084:
            r11 = "aldata";
            r10 = r2[r10];	 Catch:{ Exception -> 0x0124 }
            r10 = java.lang.Double.valueOf(r10);	 Catch:{ Exception -> 0x0124 }
            r9.put(r11, r10);	 Catch:{ Exception -> 0x0124 }
            r10 = "sigma";
            goto L_0x0072;
        L_0x0092:
            r10 = r2[r10];	 Catch:{ Exception -> 0x0124 }
            r11 = ":";
            r10 = r10.split(r11);	 Catch:{ Exception -> 0x0124 }
            r11 = r10.length;	 Catch:{ Exception -> 0x0124 }
            if (r11 != r7) goto L_0x00b0;
        L_0x009d:
            r11 = "aldata";
            r12 = r10[r1];	 Catch:{ Exception -> 0x0124 }
            r12 = java.lang.Double.valueOf(r12);	 Catch:{ Exception -> 0x0124 }
            r9.put(r11, r12);	 Catch:{ Exception -> 0x0124 }
            r11 = "sigma";
            r10 = r10[r14];	 Catch:{ Exception -> 0x0124 }
            r9.put(r11, r10);	 Catch:{ Exception -> 0x0124 }
            goto L_0x00bc;
        L_0x00b0:
            r10 = "aldata";
            r11 = java.lang.Double.valueOf(r12);	 Catch:{ Exception -> 0x0124 }
            r9.put(r10, r11);	 Catch:{ Exception -> 0x0124 }
            r10 = "sigma";
            goto L_0x0072;
        L_0x00bc:
            r10 = "tt";
            r11 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0124 }
            r15 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
            r11 = r11 / r15;
            r11 = (int) r11;	 Catch:{ Exception -> 0x0124 }
            r11 = java.lang.Integer.valueOf(r11);	 Catch:{ Exception -> 0x0124 }
            r9.put(r10, r11);	 Catch:{ Exception -> 0x0124 }
            r10 = r3 + r8;
            r11 = r6 + r5;
            r12 = java.util.Locale.CHINESE;	 Catch:{ Exception -> 0x0124 }
            r13 = "%d,%d";
            r15 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x0124 }
            r10 = java.lang.Integer.valueOf(r10);	 Catch:{ Exception -> 0x0124 }
            r15[r1] = r10;	 Catch:{ Exception -> 0x0124 }
            r10 = java.lang.Integer.valueOf(r11);	 Catch:{ Exception -> 0x0124 }
            r15[r14] = r10;	 Catch:{ Exception -> 0x0124 }
            r10 = java.lang.String.format(r12, r13, r15);	 Catch:{ Exception -> 0x0124 }
            r11 = com.baidu.location.b.a.this;	 Catch:{ Exception -> 0x011c }
            r11 = r11.e;	 Catch:{ Exception -> 0x011c }
            r12 = "galdata_new";
            r13 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x011c }
            r13.<init>();	 Catch:{ Exception -> 0x011c }
            r14 = "id = \"";
            r13.append(r14);	 Catch:{ Exception -> 0x011c }
            r13.append(r10);	 Catch:{ Exception -> 0x011c }
            r14 = "\"";
            r13.append(r14);	 Catch:{ Exception -> 0x011c }
            r13 = r13.toString();	 Catch:{ Exception -> 0x011c }
            r14 = 0;
            r11 = r11.update(r12, r9, r13, r14);	 Catch:{ Exception -> 0x011c }
            if (r11 > 0) goto L_0x011c;
        L_0x010c:
            r11 = "id";
            r9.put(r11, r10);	 Catch:{ Exception -> 0x011c }
            r10 = com.baidu.location.b.a.this;	 Catch:{ Exception -> 0x011c }
            r10 = r10.e;	 Catch:{ Exception -> 0x011c }
            r11 = "galdata_new";
            r10.insert(r11, r14, r9);	 Catch:{ Exception -> 0x011c }
        L_0x011c:
            r8 = r8 + 1;
            goto L_0x004d;
        L_0x0120:
            r5 = r5 + 1;
            goto L_0x004a;
        L_0x0124:
            r2 = r0.k;
            if (r2 == 0) goto L_0x012d;
        L_0x0128:
            r2 = r0.k;
            r2.clear();
        L_0x012d:
            r2 = com.baidu.location.b.a.this;
            r2.f = r1;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.a$a.a(boolean):void");
        }
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(j.i());
        stringBuilder.append("/gal.db");
        d = stringBuilder.toString();
    }

    public static a a() {
        a aVar;
        synchronized (b) {
            if (c == null) {
                c = new a();
            }
            aVar = c;
        }
        return aVar;
    }

    private void a(double d, double d2, double d3) {
        if (this.a == null) {
            this.a = new a();
        }
        this.a.a(d, d2, d3);
    }

    public int a(BDLocation bDLocation) {
        float radius;
        double altitude;
        if (bDLocation != null) {
            radius = bDLocation.getRadius();
            altitude = bDLocation.getAltitude();
        } else {
            altitude = 0.0d;
            radius = 0.0f;
        }
        int i = 0;
        if (this.e != null && radius > 0.0f && altitude > 0.0d && bDLocation != null) {
            double d = a(bDLocation.getLongitude(), bDLocation.getLatitude())[0];
            if (d != Double.MAX_VALUE) {
                d = Jni.getGpsSwiftRadius(radius, altitude, d);
                if (d > 50.0d) {
                    return 3;
                }
                if (d > 20.0d) {
                    return 2;
                }
                i = 1;
            }
        }
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:77:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0140 A:{SYNTHETIC, Splitter:B:87:0x0140} */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0150 A:{SYNTHETIC, Splitter:B:95:0x0150} */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00fe A:{Splitter:B:17:0x0076, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0150 A:{SYNTHETIC, Splitter:B:95:0x0150} */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00fe A:{Splitter:B:17:0x0076, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0150 A:{SYNTHETIC, Splitter:B:95:0x0150} */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0140 A:{SYNTHETIC, Splitter:B:87:0x0140} */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0150 A:{SYNTHETIC, Splitter:B:95:0x0150} */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0140 A:{SYNTHETIC, Splitter:B:87:0x0140} */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0150 A:{SYNTHETIC, Splitter:B:95:0x0150} */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x011e A:{PHI: r21 , Splitter:B:38:0x00c8, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0150 A:{SYNTHETIC, Splitter:B:95:0x0150} */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00fe A:{Splitter:B:17:0x0076, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0150 A:{SYNTHETIC, Splitter:B:95:0x0150} */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x011e A:{PHI: r21 , Splitter:B:38:0x00c8, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x011e A:{PHI: r21 , Splitter:B:38:0x00c8, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:38:0x00c8, B:72:0x011a] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:49:0x00e4, code skipped:
            r1 = r22;
     */
    /* JADX WARNING: Missing block: B:51:0x00e7, code skipped:
            r21 = r13;
            r1 = r14;
            r13 = r6;
     */
    /* JADX WARNING: Missing block: B:53:0x00eb, code skipped:
            r17 = r1;
            r12 = r13;
     */
    /* JADX WARNING: Missing block: B:58:0x00f8, code skipped:
            r12 = r6;
            r6 = r13;
     */
    /* JADX WARNING: Missing block: B:60:0x00fe, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:61:0x00ff, code skipped:
            r21 = r13;
     */
    /* JADX WARNING: Missing block: B:62:0x0101, code skipped:
            r1 = r0;
            r6 = r21;
     */
    /* JADX WARNING: Missing block: B:63:0x0105, code skipped:
            r21 = r13;
     */
    /* JADX WARNING: Missing block: B:65:0x0107, code skipped:
            r6 = r21;
     */
    /* JADX WARNING: Missing block: B:74:0x011e, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:88:?, code skipped:
            r6.close();
     */
    /* JADX WARNING: Missing block: B:96:?, code skipped:
            r6.close();
     */
    public double[] a(double r25, double r27) {
        /*
        r24 = this;
        r8 = r24;
        r1 = 2;
        r9 = new double[r1];
        r6 = r8.e;
        r10 = 0;
        r11 = 1;
        if (r6 == 0) goto L_0x0155;
    L_0x000b:
        r6 = 4591870180066957722; // 0x3fb999999999999a float:-1.5881868E-23 double:0.1;
        r16 = (r25 > r6 ? 1 : (r25 == r6 ? 0 : -1));
        if (r16 <= 0) goto L_0x0155;
    L_0x0014:
        r16 = (r27 > r6 ? 1 : (r27 == r6 ? 0 : -1));
        if (r16 <= 0) goto L_0x0155;
    L_0x0018:
        r6 = java.util.Locale.CHINESE;
        r7 = "%d,%d";
        r12 = new java.lang.Object[r1];
        r19 = 4636737291354636288; // 0x4059000000000000 float:0.0 double:100.0;
        r14 = r25 * r19;
        r13 = java.lang.Math.floor(r14);
        r13 = (int) r13;
        r13 = java.lang.Integer.valueOf(r13);
        r12[r10] = r13;
        r13 = r27 * r19;
        r13 = java.lang.Math.floor(r13);
        r13 = (int) r13;
        r13 = java.lang.Integer.valueOf(r13);
        r12[r11] = r13;
        r12 = java.lang.String.format(r6, r7, r12);
        r6 = r8.g;
        if (r6 == 0) goto L_0x0057;
    L_0x0042:
        r6 = r8.g;
        r6 = r6.equals(r12);
        if (r6 == 0) goto L_0x0057;
    L_0x004a:
        r12 = r8.h;
        r1 = r8.i;
        r17 = r1;
    L_0x0050:
        r1 = 4666723172467343360; // 0x40c3880000000000 float:0.0 double:10000.0;
        goto L_0x0164;
    L_0x0057:
        r6 = 0;
        r7 = r8.e;	 Catch:{ Exception -> 0x0144, all -> 0x013c }
        r13 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0144, all -> 0x013c }
        r13.<init>();	 Catch:{ Exception -> 0x0144, all -> 0x013c }
        r14 = "select * from galdata_new where id = \"";
        r13.append(r14);	 Catch:{ Exception -> 0x0144, all -> 0x013c }
        r13.append(r12);	 Catch:{ Exception -> 0x0144, all -> 0x013c }
        r14 = "\";";
        r13.append(r14);	 Catch:{ Exception -> 0x0144, all -> 0x013c }
        r13 = r13.toString();	 Catch:{ Exception -> 0x0144, all -> 0x013c }
        r13 = r7.rawQuery(r13, r6);	 Catch:{ Exception -> 0x0144, all -> 0x013c }
        if (r13 == 0) goto L_0x010a;
    L_0x0076:
        r6 = r13.moveToFirst();	 Catch:{ Exception -> 0x0105, all -> 0x00fe }
        if (r6 == 0) goto L_0x010a;
    L_0x007c:
        r6 = r13.getDouble(r11);	 Catch:{ Exception -> 0x0105, all -> 0x00fe }
        r14 = r13.getDouble(r1);	 Catch:{ Exception -> 0x00f8, all -> 0x00fe }
        r1 = 3;
        r1 = r13.getInt(r1);	 Catch:{ Exception -> 0x00ef, all -> 0x00fe }
        r19 = 4666723172467343360; // 0x40c3880000000000 float:0.0 double:10000.0;
        r16 = (r6 > r19 ? 1 : (r6 == r19 ? 0 : -1));
        if (r16 != 0) goto L_0x0097;
    L_0x0092:
        r6 = 9218868437227405311; // 0x7fefffffffffffff float:NaN double:1.7976931348623157E308;
    L_0x0097:
        r19 = 0;
        r16 = (r14 > r19 ? 1 : (r14 == r19 ? 0 : -1));
        if (r16 > 0) goto L_0x00a2;
    L_0x009d:
        r14 = 9218868437227405311; // 0x7fefffffffffffff float:NaN double:1.7976931348623157E308;
    L_0x00a2:
        r16 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00e7, all -> 0x00fe }
        r18 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r16 = r16 / r18;
        r10 = (long) r1;	 Catch:{ Exception -> 0x00e7, all -> 0x00fe }
        r18 = r16 - r10;
        r1 = r8.f;	 Catch:{ Exception -> 0x00e7, all -> 0x00fe }
        if (r1 != 0) goto L_0x00d3;
    L_0x00b1:
        r10 = 604800; // 0x93a80 float:8.47505E-40 double:2.98811E-318;
        r1 = (r18 > r10 ? 1 : (r18 == r10 ? 0 : -1));
        if (r1 <= 0) goto L_0x00d3;
    L_0x00b8:
        r10 = 4620265375588679680; // 0x401e7ae140000000 float:2.0 double:7.619999885559082;
        r1 = r8;
        r2 = r25;
        r4 = r27;
        r21 = r13;
        r22 = r14;
        r13 = r6;
        r6 = r10;
        r1.a(r2, r4, r6);	 Catch:{ Exception -> 0x00cc, all -> 0x011e }
        goto L_0x00d8;
    L_0x00cc:
        r12 = r13;
        r6 = r21;
        r17 = r22;
        goto L_0x014e;
    L_0x00d3:
        r21 = r13;
        r22 = r14;
        r13 = r6;
    L_0x00d8:
        r8.g = r12;	 Catch:{ Exception -> 0x00e4, all -> 0x011e }
        r8.h = r13;	 Catch:{ Exception -> 0x00e4, all -> 0x011e }
        r1 = r22;
        r8.i = r1;	 Catch:{ Exception -> 0x00eb, all -> 0x011e }
        r17 = r1;
        r12 = r13;
        goto L_0x012a;
    L_0x00e4:
        r1 = r22;
        goto L_0x00eb;
    L_0x00e7:
        r21 = r13;
        r1 = r14;
        r13 = r6;
    L_0x00eb:
        r17 = r1;
        r12 = r13;
        goto L_0x00f4;
    L_0x00ef:
        r21 = r13;
        r12 = r6;
        r17 = r14;
    L_0x00f4:
        r6 = r21;
        goto L_0x014e;
    L_0x00f8:
        r21 = r13;
        r12 = r6;
        r6 = r21;
        goto L_0x0149;
    L_0x00fe:
        r0 = move-exception;
        r21 = r13;
    L_0x0101:
        r1 = r0;
        r6 = r21;
        goto L_0x013e;
    L_0x0105:
        r21 = r13;
    L_0x0107:
        r6 = r21;
        goto L_0x0144;
    L_0x010a:
        r21 = r13;
        r1 = r8.f;	 Catch:{ Exception -> 0x0138, all -> 0x0133 }
        if (r1 != 0) goto L_0x0120;
    L_0x0110:
        r6 = 4620265375588679680; // 0x401e7ae140000000 float:2.0 double:7.619999885559082;
        r1 = r8;
        r2 = r25;
        r4 = r27;
        r1.a(r2, r4, r6);	 Catch:{ Exception -> 0x0107, all -> 0x011e }
        goto L_0x0120;
    L_0x011e:
        r0 = move-exception;
        goto L_0x0101;
    L_0x0120:
        r12 = 9218868437227405311; // 0x7fefffffffffffff float:NaN double:1.7976931348623157E308;
        r17 = 9218868437227405311; // 0x7fefffffffffffff float:NaN double:1.7976931348623157E308;
    L_0x012a:
        if (r21 == 0) goto L_0x0050;
    L_0x012c:
        r1 = r21;
        r1.close();	 Catch:{ Exception -> 0x0050 }
        goto L_0x0050;
    L_0x0133:
        r0 = move-exception;
        r1 = r21;
        r6 = r1;
        goto L_0x013d;
    L_0x0138:
        r1 = r21;
        r6 = r1;
        goto L_0x0144;
    L_0x013c:
        r0 = move-exception;
    L_0x013d:
        r1 = r0;
    L_0x013e:
        if (r6 == 0) goto L_0x0143;
    L_0x0140:
        r6.close();	 Catch:{ Exception -> 0x0143 }
    L_0x0143:
        throw r1;
    L_0x0144:
        r12 = 9218868437227405311; // 0x7fefffffffffffff float:NaN double:1.7976931348623157E308;
    L_0x0149:
        r17 = 9218868437227405311; // 0x7fefffffffffffff float:NaN double:1.7976931348623157E308;
    L_0x014e:
        if (r6 == 0) goto L_0x0050;
    L_0x0150:
        r6.close();	 Catch:{ Exception -> 0x0050 }
        goto L_0x0050;
    L_0x0155:
        r1 = 4666723172467343360; // 0x40c3880000000000 float:0.0 double:10000.0;
        r12 = 9218868437227405311; // 0x7fefffffffffffff float:NaN double:1.7976931348623157E308;
        r17 = 9218868437227405311; // 0x7fefffffffffffff float:NaN double:1.7976931348623157E308;
    L_0x0164:
        r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1));
        if (r3 <= 0) goto L_0x016c;
    L_0x0168:
        r3 = 0;
        r9[r3] = r1;
        goto L_0x016f;
    L_0x016c:
        r3 = 0;
        r9[r3] = r12;
    L_0x016f:
        r3 = (r17 > r1 ? 1 : (r17 == r1 ? 0 : -1));
        if (r3 <= 0) goto L_0x0177;
    L_0x0173:
        r3 = 1;
        r9[r3] = r1;
        return r9;
    L_0x0177:
        r3 = 1;
        r9[r3] = r17;
        return r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.a.a(double, double):double[]");
    }

    public void b() {
        try {
            File file = new File(d);
            if (!file.exists()) {
                file.createNewFile();
            }
            if (file.exists()) {
                this.e = SQLiteDatabase.openOrCreateDatabase(file, null);
                Cursor rawQuery = this.e.rawQuery("SELECT count(*) FROM sqlite_master WHERE type='table' AND name='galdata'", null);
                if (rawQuery.moveToFirst()) {
                    SQLiteDatabase sQLiteDatabase;
                    String str;
                    if (rawQuery.getInt(0) == 0) {
                        sQLiteDatabase = this.e;
                        str = "CREATE TABLE IF NOT EXISTS galdata_new(id CHAR(40) PRIMARY KEY,aldata DOUBLE, sigma DOUBLE,tt INT);";
                    } else {
                        this.e.execSQL("DROP TABLE galdata");
                        sQLiteDatabase = this.e;
                        str = "CREATE TABLE galdata_new(id CHAR(40) PRIMARY KEY,aldata DOUBLE, sigma DOUBLE,tt INT);";
                    }
                    sQLiteDatabase.execSQL(str);
                }
                this.e.setVersion(1);
                rawQuery.close();
            }
        } catch (Exception unused) {
            this.e = null;
        }
    }

    public void c() {
        if (this.e != null) {
            try {
                this.e.close();
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.e = null;
            }
            this.e = null;
        }
    }
}
