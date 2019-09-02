package com.baidu.location.d;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.a.l;
import com.baidu.location.e.h;
import com.baidu.location.e.i;
import com.baidu.location.f;
import com.baidu.location.g.j;
import java.io.File;
import java.util.List;
import java.util.Locale;

public final class a {
    private static a b;
    private static final String l;
    private static final String m;
    public boolean a = false;
    private String c = null;
    private boolean d = false;
    private boolean e = false;
    private double f = 0.0d;
    private double g = 0.0d;
    private double h = 0.0d;
    private double i = 0.0d;
    private double j = 0.0d;
    private volatile boolean k = false;
    private Handler n = null;

    private class a extends AsyncTask<Boolean, Void, Boolean> {
        private a() {
        }

        /* synthetic */ a(a aVar, b bVar) {
            this();
        }

        /* Access modifiers changed, original: protected|varargs */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x004d A:{Catch:{ Exception -> 0x006c }} */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0045 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0063 */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Can't wrap try/catch for region: R(11:12|13|14|(3:16|17|18)|19|20|(3:22|23|24)|25|26|27|29) */
        /* renamed from: a */
        public java.lang.Boolean doInBackground(java.lang.Boolean... r6) {
            /*
            r5 = this;
            r0 = 0;
            r1 = 4;
            r2 = r6.length;
            if (r2 == r1) goto L_0x000a;
        L_0x0005:
            r6 = java.lang.Boolean.valueOf(r0);
            return r6;
        L_0x000a:
            r1 = 0;
            r2 = com.baidu.location.d.a.m;	 Catch:{ Exception -> 0x0014 }
            r2 = android.database.sqlite.SQLiteDatabase.openOrCreateDatabase(r2, r1);	 Catch:{ Exception -> 0x0014 }
            r1 = r2;
        L_0x0014:
            if (r1 != 0) goto L_0x001b;
        L_0x0016:
            r6 = java.lang.Boolean.valueOf(r0);
            return r6;
        L_0x001b:
            r2 = java.lang.System.currentTimeMillis();
            r4 = 28;
            r2 = r2 >> r4;
            r2 = (int) r2;
            r3 = 1;
            r1.beginTransaction();	 Catch:{ Exception -> 0x006c }
            r0 = r6[r0];	 Catch:{ Exception -> 0x006c }
            r0 = r0.booleanValue();	 Catch:{ Exception -> 0x006c }
            if (r0 == 0) goto L_0x0045;
        L_0x002f:
            r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x006c }
            r0.<init>();	 Catch:{ Exception -> 0x006c }
            r4 = "delete from wof where ac < ";
            r0.append(r4);	 Catch:{ Exception -> 0x006c }
            r4 = r2 + -35;
            r0.append(r4);	 Catch:{ Exception -> 0x006c }
            r0 = r0.toString();	 Catch:{ Exception -> 0x006c }
            r1.execSQL(r0);	 Catch:{ Exception -> 0x0045 }
        L_0x0045:
            r6 = r6[r3];	 Catch:{ Exception -> 0x006c }
            r6 = r6.booleanValue();	 Catch:{ Exception -> 0x006c }
            if (r6 == 0) goto L_0x0063;
        L_0x004d:
            r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x006c }
            r6.<init>();	 Catch:{ Exception -> 0x006c }
            r0 = "delete from bdcltb09 where ac is NULL or ac < ";
            r6.append(r0);	 Catch:{ Exception -> 0x006c }
            r2 = r2 + -130;
            r6.append(r2);	 Catch:{ Exception -> 0x006c }
            r6 = r6.toString();	 Catch:{ Exception -> 0x006c }
            r1.execSQL(r6);	 Catch:{ Exception -> 0x0063 }
        L_0x0063:
            r1.setTransactionSuccessful();	 Catch:{ Exception -> 0x006c }
            r1.endTransaction();	 Catch:{ Exception -> 0x006c }
            r1.close();	 Catch:{ Exception -> 0x006c }
        L_0x006c:
            r6 = java.lang.Boolean.valueOf(r3);
            return r6;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.d.a$a.doInBackground(java.lang.Boolean[]):java.lang.Boolean");
        }
    }

    private class b extends AsyncTask<Object, Void, Boolean> {
        private b() {
        }

        /* synthetic */ b(a aVar, b bVar) {
            this();
        }

        /* Access modifiers changed, original: protected|varargs */
        /* renamed from: a */
        public Boolean doInBackground(Object... objArr) {
            if (objArr.length != 4) {
                a.this.k = false;
                return Boolean.valueOf(false);
            }
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(a.m, null);
            } catch (Exception unused) {
            }
            if (sQLiteDatabase == null) {
                a.this.k = false;
                return Boolean.valueOf(false);
            }
            try {
                sQLiteDatabase.beginTransaction();
                a.this.a((String) objArr[0], (com.baidu.location.e.a) objArr[1], sQLiteDatabase);
                a.this.a((h) objArr[2], (BDLocation) objArr[3], sQLiteDatabase);
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
                sQLiteDatabase.close();
            } catch (Exception unused2) {
            }
            a.this.k = false;
            return Boolean.valueOf(true);
        }
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Environment.getExternalStorageDirectory().getPath());
        stringBuilder.append("/baidu/tempdata/");
        l = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(Environment.getExternalStorageDirectory().getPath());
        stringBuilder.append("/baidu/tempdata");
        stringBuilder.append("/ls.db");
        m = stringBuilder.toString();
    }

    private a() {
        b();
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (b == null) {
                b = new a();
            }
            aVar = b;
        }
        return aVar;
    }

    private void a(h hVar, BDLocation bDLocation, SQLiteDatabase sQLiteDatabase) {
        h hVar2 = hVar;
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        if (bDLocation != null && bDLocation.getLocType() == BDLocation.TypeNetWorkLocation && (("wf".equals(bDLocation.getNetworkLocationType()) || bDLocation.getRadius() < 300.0f) && hVar2.a != null)) {
            int currentTimeMillis = (int) (System.currentTimeMillis() >> 28);
            System.currentTimeMillis();
            int i = 0;
            for (ScanResult scanResult : hVar2.a) {
                if (scanResult.level != 0) {
                    i++;
                    if (i <= 6) {
                        ContentValues contentValues = new ContentValues();
                        String encode2 = Jni.encode2(scanResult.BSSID.replace(":", ""));
                        try {
                            int i2;
                            int i3;
                            double d;
                            double d2;
                            int i4;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("select * from wof where id = \"");
                            stringBuilder.append(encode2);
                            stringBuilder.append("\";");
                            Cursor rawQuery = sQLiteDatabase2.rawQuery(stringBuilder.toString(), null);
                            if (rawQuery == null || !rawQuery.moveToFirst()) {
                                i2 = 0;
                                i3 = 0;
                                d = 0.0d;
                                d2 = 0.0d;
                                i4 = 0;
                            } else {
                                d = rawQuery.getDouble(1) - 113.2349d;
                                d2 = rawQuery.getDouble(2) - 432.1238d;
                                i4 = rawQuery.getInt(4);
                                i3 = rawQuery.getInt(5);
                                i2 = 1;
                                double d3 = d;
                                d = d2;
                                d2 = d3;
                            }
                            if (rawQuery != null) {
                                rawQuery.close();
                            }
                            if (i2 == 0) {
                                contentValues.put("mktime", Double.valueOf(113.2349d + bDLocation.getLongitude()));
                                contentValues.put("time", Double.valueOf(bDLocation.getLatitude() + 432.1238d));
                                contentValues.put("bc", Integer.valueOf(1));
                                contentValues.put("cc", Integer.valueOf(1));
                                contentValues.put("ac", Integer.valueOf(currentTimeMillis));
                                contentValues.put("id", encode2);
                                sQLiteDatabase2.insert("wof", null, contentValues);
                            } else if (i3 != 0) {
                                String str;
                                Integer valueOf;
                                float[] fArr = new float[1];
                                Location.distanceBetween(d, d2, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                                if (fArr[0] > 1500.0f) {
                                    i3++;
                                    if (i3 <= 10 || i3 <= 3 * i4) {
                                        str = "cc";
                                        valueOf = Integer.valueOf(i3);
                                        contentValues.put(str, valueOf);
                                        stringBuilder = new StringBuilder();
                                        stringBuilder.append("id = \"");
                                        stringBuilder.append(encode2);
                                        stringBuilder.append("\"");
                                        sQLiteDatabase2.update("wof", contentValues, stringBuilder.toString(), null);
                                    } else {
                                        contentValues.put("mktime", Double.valueOf(113.2349d + bDLocation.getLongitude()));
                                        contentValues.put("time", Double.valueOf(bDLocation.getLatitude() + 432.1238d));
                                        contentValues.put("bc", Integer.valueOf(1));
                                        contentValues.put("cc", Integer.valueOf(1));
                                        str = "ac";
                                    }
                                } else {
                                    int i5 = i4;
                                    double d4 = (double) i5;
                                    i2 = i5 + 1;
                                    double d5 = (double) i2;
                                    d = ((d * d4) + bDLocation.getLatitude()) / d5;
                                    contentValues.put("mktime", Double.valueOf((((d2 * d4) + bDLocation.getLongitude()) / d5) + 113.2349d));
                                    contentValues.put("time", Double.valueOf(432.1238d + d));
                                    contentValues.put("bc", Integer.valueOf(i2));
                                    str = "ac";
                                }
                                valueOf = Integer.valueOf(currentTimeMillis);
                                contentValues.put(str, valueOf);
                                stringBuilder = new StringBuilder();
                                stringBuilder.append("id = \"");
                                stringBuilder.append(encode2);
                                stringBuilder.append("\"");
                                sQLiteDatabase2.update("wof", contentValues, stringBuilder.toString(), null);
                            }
                        } catch (Exception unused) {
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0066 A:{SYNTHETIC, Splitter:B:19:0x0066} */
    /* JADX WARNING: Missing block: B:11:0x005a, code skipped:
            if (r6 != null) goto L_0x005c;
     */
    /* JADX WARNING: Missing block: B:13:?, code skipped:
            r6.close();
     */
    /* JADX WARNING: Missing block: B:14:0x005f, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:25:0x006b, code skipped:
            if (r6 != null) goto L_0x005c;
     */
    /* JADX WARNING: Missing block: B:27:0x006e, code skipped:
            return;
     */
    private void a(java.lang.String r5, android.database.sqlite.SQLiteDatabase r6) {
        /*
        r4 = this;
        if (r5 == 0) goto L_0x006e;
    L_0x0002:
        r0 = r4.c;
        r0 = r5.equals(r0);
        if (r0 == 0) goto L_0x000b;
    L_0x000a:
        return;
    L_0x000b:
        r0 = 0;
        r4.d = r0;
        r0 = 0;
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x006a, all -> 0x0062 }
        r1.<init>();	 Catch:{ Exception -> 0x006a, all -> 0x0062 }
        r2 = "select * from bdcltb09 where id = \"";
        r1.append(r2);	 Catch:{ Exception -> 0x006a, all -> 0x0062 }
        r1.append(r5);	 Catch:{ Exception -> 0x006a, all -> 0x0062 }
        r2 = "\";";
        r1.append(r2);	 Catch:{ Exception -> 0x006a, all -> 0x0062 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x006a, all -> 0x0062 }
        r6 = r6.rawQuery(r1, r0);	 Catch:{ Exception -> 0x006a, all -> 0x0062 }
        r4.c = r5;	 Catch:{ Exception -> 0x006b, all -> 0x0060 }
        r5 = r6.moveToFirst();	 Catch:{ Exception -> 0x006b, all -> 0x0060 }
        if (r5 == 0) goto L_0x005a;
    L_0x0031:
        r5 = 1;
        r0 = r6.getDouble(r5);	 Catch:{ Exception -> 0x006b, all -> 0x0060 }
        r2 = 4653148304163072062; // 0x40934dbaacd9e83e float:-6.193295E-12 double:1235.4323;
        r0 = r0 - r2;
        r4.g = r0;	 Catch:{ Exception -> 0x006b, all -> 0x0060 }
        r0 = 2;
        r0 = r6.getDouble(r0);	 Catch:{ Exception -> 0x006b, all -> 0x0060 }
        r2 = 4661478502002851840; // 0x40b0e60000000000 float:0.0 double:4326.0;
        r0 = r0 - r2;
        r4.f = r0;	 Catch:{ Exception -> 0x006b, all -> 0x0060 }
        r0 = 3;
        r0 = r6.getDouble(r0);	 Catch:{ Exception -> 0x006b, all -> 0x0060 }
        r2 = 4657424210545395263; // 0x40a27ea4b5dcc63f float:-1.6448975E-6 double:2367.3217;
        r0 = r0 - r2;
        r4.h = r0;	 Catch:{ Exception -> 0x006b, all -> 0x0060 }
        r4.d = r5;	 Catch:{ Exception -> 0x006b, all -> 0x0060 }
    L_0x005a:
        if (r6 == 0) goto L_0x006e;
    L_0x005c:
        r6.close();	 Catch:{ Exception -> 0x006e }
        return;
    L_0x0060:
        r5 = move-exception;
        goto L_0x0064;
    L_0x0062:
        r5 = move-exception;
        r6 = r0;
    L_0x0064:
        if (r6 == 0) goto L_0x0069;
    L_0x0066:
        r6.close();	 Catch:{ Exception -> 0x0069 }
    L_0x0069:
        throw r5;
    L_0x006a:
        r6 = r0;
    L_0x006b:
        if (r6 == 0) goto L_0x006e;
    L_0x006d:
        goto L_0x005c;
    L_0x006e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.d.a.a(java.lang.String, android.database.sqlite.SQLiteDatabase):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00c6 A:{RETURN} */
    private void a(java.lang.String r13, com.baidu.location.e.a r14, android.database.sqlite.SQLiteDatabase r15) {
        /*
        r12 = this;
        r0 = r14.b();
        if (r0 == 0) goto L_0x0128;
    L_0x0006:
        r0 = com.baidu.location.a.l.c();
        r0 = r0.h();
        if (r0 != 0) goto L_0x0011;
    L_0x0010:
        return;
    L_0x0011:
        java.lang.System.currentTimeMillis();
        r0 = 0;
        r1 = java.lang.System.currentTimeMillis();
        r3 = 28;
        r1 = r1 >> r3;
        r1 = (int) r1;
        r14 = r14.g();
        r2 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0128 }
        r2.<init>(r13);	 Catch:{ Exception -> 0x0128 }
        r13 = "result";
        r13 = r2.getJSONObject(r13);	 Catch:{ Exception -> 0x0128 }
        r3 = "error";
        r13 = r13.getString(r3);	 Catch:{ Exception -> 0x0128 }
        r13 = java.lang.Integer.parseInt(r13);	 Catch:{ Exception -> 0x0128 }
        r3 = 161; // 0xa1 float:2.26E-43 double:7.95E-322;
        r4 = 1;
        r5 = 0;
        r7 = 0;
        if (r13 != r3) goto L_0x00a4;
    L_0x003e:
        r13 = "content";
        r13 = r2.getJSONObject(r13);	 Catch:{ Exception -> 0x0128 }
        r2 = "clf";
        r2 = r13.has(r2);	 Catch:{ Exception -> 0x0128 }
        r3 = 0;
        if (r2 == 0) goto L_0x00a2;
    L_0x004d:
        r0 = "clf";
        r0 = r13.getString(r0);	 Catch:{ Exception -> 0x0128 }
        r2 = "0";
        r2 = r0.equals(r2);	 Catch:{ Exception -> 0x0128 }
        if (r2 == 0) goto L_0x0084;
    L_0x005b:
        r0 = "point";
        r0 = r13.getJSONObject(r0);	 Catch:{ Exception -> 0x0128 }
        r2 = "x";
        r2 = r0.getString(r2);	 Catch:{ Exception -> 0x0128 }
        r4 = java.lang.Double.parseDouble(r2);	 Catch:{ Exception -> 0x0128 }
        r2 = "y";
        r0 = r0.getString(r2);	 Catch:{ Exception -> 0x0128 }
        r8 = java.lang.Double.parseDouble(r0);	 Catch:{ Exception -> 0x0128 }
        r0 = "radius";
        r13 = r13.getString(r0);	 Catch:{ Exception -> 0x0128 }
        r13 = java.lang.Float.parseFloat(r13);	 Catch:{ Exception -> 0x0128 }
        r0 = r13;
        r10 = r4;
        r4 = r3;
        r2 = r10;
        goto L_0x00a0;
    L_0x0084:
        r13 = "\\|";
        r13 = r0.split(r13);	 Catch:{ Exception -> 0x0128 }
        r0 = r13[r3];	 Catch:{ Exception -> 0x0128 }
        r5 = java.lang.Double.parseDouble(r0);	 Catch:{ Exception -> 0x0128 }
        r0 = r13[r4];	 Catch:{ Exception -> 0x0128 }
        r8 = java.lang.Double.parseDouble(r0);	 Catch:{ Exception -> 0x0128 }
        r0 = 2;
        r13 = r13[r0];	 Catch:{ Exception -> 0x0128 }
        r13 = java.lang.Float.parseFloat(r13);	 Catch:{ Exception -> 0x0128 }
        r0 = r13;
        r4 = r3;
        r2 = r5;
    L_0x00a0:
        r5 = r8;
        goto L_0x00c4;
    L_0x00a2:
        r2 = r5;
        goto L_0x00c4;
    L_0x00a4:
        r2 = 167; // 0xa7 float:2.34E-43 double:8.25E-322;
        if (r13 != r2) goto L_0x00a2;
    L_0x00a8:
        r13 = "bdcltb09";
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0128 }
        r0.<init>();	 Catch:{ Exception -> 0x0128 }
        r1 = "id = \"";
        r0.append(r1);	 Catch:{ Exception -> 0x0128 }
        r0.append(r14);	 Catch:{ Exception -> 0x0128 }
        r14 = "\"";
        r0.append(r14);	 Catch:{ Exception -> 0x0128 }
        r14 = r0.toString();	 Catch:{ Exception -> 0x0128 }
        r15.delete(r13, r14, r7);	 Catch:{ Exception -> 0x0128 }
        return;
    L_0x00c4:
        if (r4 == 0) goto L_0x00c7;
    L_0x00c6:
        return;
    L_0x00c7:
        r8 = 4653148304163072062; // 0x40934dbaacd9e83e float:-6.193295E-12 double:1235.4323;
        r2 = r2 + r8;
        r8 = 4657424210545395263; // 0x40a27ea4b5dcc63f float:-1.6448975E-6 double:2367.3217;
        r5 = r5 + r8;
        r13 = 1166487552; // 0x45873000 float:4326.0 double:5.763214257E-315;
        r0 = r0 + r13;
        r13 = new android.content.ContentValues;
        r13.<init>();
        r4 = "time";
        r2 = java.lang.Double.valueOf(r2);
        r13.put(r4, r2);
        r2 = "tag";
        r0 = java.lang.Float.valueOf(r0);
        r13.put(r2, r0);
        r0 = "type";
        r2 = java.lang.Double.valueOf(r5);
        r13.put(r0, r2);
        r0 = "ac";
        r1 = java.lang.Integer.valueOf(r1);
        r13.put(r0, r1);
        r0 = "bdcltb09";
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0128 }
        r1.<init>();	 Catch:{ Exception -> 0x0128 }
        r2 = "id = \"";
        r1.append(r2);	 Catch:{ Exception -> 0x0128 }
        r1.append(r14);	 Catch:{ Exception -> 0x0128 }
        r2 = "\"";
        r1.append(r2);	 Catch:{ Exception -> 0x0128 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0128 }
        r0 = r15.update(r0, r13, r1, r7);	 Catch:{ Exception -> 0x0128 }
        if (r0 > 0) goto L_0x0128;
    L_0x011e:
        r0 = "id";
        r13.put(r0, r14);	 Catch:{ Exception -> 0x0128 }
        r14 = "bdcltb09";
        r15.insert(r14, r7, r13);	 Catch:{ Exception -> 0x0128 }
    L_0x0128:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.d.a.a(java.lang.String, com.baidu.location.e.a, android.database.sqlite.SQLiteDatabase):void");
    }

    private void a(String str, List<ScanResult> list) {
        this.d = false;
        this.e = false;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(m, null);
        } catch (Throwable unused) {
        }
        if (!(str == null || sQLiteDatabase == null)) {
            a(str, sQLiteDatabase);
        }
        if (!(list == null || sQLiteDatabase == null)) {
            a((List) list, sQLiteDatabase);
        }
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            sQLiteDatabase.close();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x0181 A:{Catch:{ Exception -> 0x01a8, all -> 0x019c }} */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0180 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0180 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0181 A:{Catch:{ Exception -> 0x01a8, all -> 0x019c }} */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0181 A:{Catch:{ Exception -> 0x01a8, all -> 0x019c }} */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0180 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01a3 A:{SYNTHETIC, Splitter:B:72:0x01a3} */
    /* JADX WARNING: Missing block: B:63:0x0196, code skipped:
            if (r3 != null) goto L_0x0198;
     */
    /* JADX WARNING: Missing block: B:65:?, code skipped:
            r3.close();
     */
    /* JADX WARNING: Missing block: B:66:0x019b, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:78:0x01a8, code skipped:
            if (r3 != null) goto L_0x0198;
     */
    /* JADX WARNING: Missing block: B:80:0x01ab, code skipped:
            return;
     */
    private void a(java.util.List<android.net.wifi.ScanResult> r32, android.database.sqlite.SQLiteDatabase r33) {
        /*
        r31 = this;
        r1 = r31;
        r3 = r33;
        java.lang.System.currentTimeMillis();
        r4 = 0;
        r1.e = r4;
        if (r32 == 0) goto L_0x01ab;
    L_0x000c:
        r5 = r32.size();
        if (r5 != 0) goto L_0x0013;
    L_0x0012:
        return;
    L_0x0013:
        if (r3 == 0) goto L_0x01ab;
    L_0x0015:
        if (r32 != 0) goto L_0x0018;
    L_0x0017:
        return;
    L_0x0018:
        r5 = 8;
        r6 = new double[r5];
        r7 = new java.lang.StringBuffer;
        r7.<init>();
        r2 = r32.iterator();
        r8 = r4;
    L_0x0026:
        r9 = r2.hasNext();
        if (r9 == 0) goto L_0x005c;
    L_0x002c:
        r9 = r2.next();
        r9 = (android.net.wifi.ScanResult) r9;
        r10 = 10;
        if (r8 <= r10) goto L_0x0037;
    L_0x0036:
        goto L_0x005c;
    L_0x0037:
        if (r8 <= 0) goto L_0x003e;
    L_0x0039:
        r10 = ",";
        r7.append(r10);
    L_0x003e:
        r8 = r8 + 1;
        r9 = r9.BSSID;
        r10 = ":";
        r11 = "";
        r9 = r9.replace(r10, r11);
        r9 = com.baidu.location.Jni.encode2(r9);
        r10 = "\"";
        r7.append(r10);
        r7.append(r9);
        r9 = "\"";
        r7.append(r9);
        goto L_0x0026;
    L_0x005c:
        r2 = 0;
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01a7, all -> 0x019e }
        r8.<init>();	 Catch:{ Exception -> 0x01a7, all -> 0x019e }
        r9 = "select * from wof where id in (";
        r8.append(r9);	 Catch:{ Exception -> 0x01a7, all -> 0x019e }
        r7 = r7.toString();	 Catch:{ Exception -> 0x01a7, all -> 0x019e }
        r8.append(r7);	 Catch:{ Exception -> 0x01a7, all -> 0x019e }
        r7 = ");";
        r8.append(r7);	 Catch:{ Exception -> 0x01a7, all -> 0x019e }
        r7 = r8.toString();	 Catch:{ Exception -> 0x01a7, all -> 0x019e }
        r3 = r3.rawQuery(r7, r2);	 Catch:{ Exception -> 0x01a7, all -> 0x019e }
        r2 = r3.moveToFirst();	 Catch:{ Exception -> 0x01a8, all -> 0x019c }
        if (r2 == 0) goto L_0x0196;
    L_0x0081:
        r7 = 0;
        r2 = r4;
        r10 = r2;
        r13 = r10;
        r11 = r7;
        r8 = r11;
        r7 = r13;
    L_0x0089:
        r14 = r3.isAfterLast();	 Catch:{ Exception -> 0x01a8, all -> 0x019c }
        r15 = 1;
        if (r14 != 0) goto L_0x018b;
    L_0x0090:
        r16 = r3.getDouble(r15);	 Catch:{ Exception -> 0x01a8, all -> 0x019c }
        r18 = 4637668614646953253; // 0x405c4f089a027525 float:-2.6978E-23 double:113.2349;
        r16 = r16 - r18;
        r14 = 2;
        r18 = r3.getDouble(r14);	 Catch:{ Exception -> 0x01a8, all -> 0x019c }
        r20 = 4646309618475430891; // 0x407b01fb15b573eb float:7.3288204E-26 double:432.1238;
        r18 = r18 - r20;
        r14 = 4;
        r4 = r3.getInt(r14);	 Catch:{ Exception -> 0x01a8, all -> 0x019c }
        r14 = 5;
        r14 = r3.getInt(r14);	 Catch:{ Exception -> 0x01a8, all -> 0x019c }
        if (r14 <= r5) goto L_0x00bd;
    L_0x00b3:
        if (r14 <= r4) goto L_0x00bd;
    L_0x00b5:
        r3.moveToNext();	 Catch:{ Exception -> 0x01a8, all -> 0x019c }
        r29 = r6;
        r30 = r13;
        goto L_0x0115;
    L_0x00bd:
        r4 = r1.d;	 Catch:{ Exception -> 0x01a8, all -> 0x019c }
        if (r4 == 0) goto L_0x00f5;
    L_0x00c1:
        r4 = new float[r15];	 Catch:{ Exception -> 0x01a8, all -> 0x019c }
        r29 = r6;
        r5 = r1.h;	 Catch:{ Exception -> 0x01a8, all -> 0x019c }
        r30 = r13;
        r13 = r1.g;	 Catch:{ Exception -> 0x01a8, all -> 0x019c }
        r20 = r18;
        r22 = r16;
        r24 = r5;
        r26 = r13;
        r28 = r4;
        android.location.Location.distanceBetween(r20, r22, r24, r26, r28);	 Catch:{ Exception -> 0x01a8, all -> 0x019c }
        r5 = 0;
        r4 = r4[r5];	 Catch:{ Exception -> 0x01a8, all -> 0x019c }
        r4 = (double) r4;	 Catch:{ Exception -> 0x01a8, all -> 0x019c }
        r13 = r1.f;	 Catch:{ Exception -> 0x01a8, all -> 0x019c }
        r20 = 4656510908468559872; // 0x409f400000000000 float:0.0 double:2000.0;
        r13 = r13 + r20;
        r6 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1));
        if (r6 <= 0) goto L_0x00ed;
    L_0x00e9:
        r3.moveToNext();	 Catch:{ Exception -> 0x01a8, all -> 0x019c }
        goto L_0x0115;
    L_0x00ed:
        r11 = r11 + r16;
        r8 = r8 + r18;
        r10 = r10 + 1;
        r2 = r15;
        goto L_0x011e;
    L_0x00f5:
        r29 = r6;
        r30 = r13;
        r4 = 1148846080; // 0x447a0000 float:1000.0 double:5.676053805E-315;
        if (r2 == 0) goto L_0x0121;
    L_0x00fd:
        r5 = new float[r15];	 Catch:{ Exception -> 0x01a8, all -> 0x019c }
        r13 = (double) r10;	 Catch:{ Exception -> 0x01a8, all -> 0x019c }
        r24 = r8 / r13;
        r26 = r11 / r13;
        r20 = r18;
        r22 = r16;
        r28 = r5;
        android.location.Location.distanceBetween(r20, r22, r24, r26, r28);	 Catch:{ Exception -> 0x01a8, all -> 0x019c }
        r6 = 0;
        r5 = r5[r6];	 Catch:{ Exception -> 0x01a8, all -> 0x019c }
        r4 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1));
        if (r4 <= 0) goto L_0x011e;
    L_0x0114:
        goto L_0x00e9;
    L_0x0115:
        r6 = r29;
        r13 = r30;
        r4 = 0;
        r5 = 8;
        goto L_0x0089;
    L_0x011e:
        r13 = r30;
        goto L_0x012d;
    L_0x0121:
        if (r7 != 0) goto L_0x0133;
    L_0x0123:
        r13 = r30 + 1;
        r29[r30] = r16;	 Catch:{ Exception -> 0x01a8, all -> 0x019c }
        r4 = r13 + 1;
        r29[r13] = r18;	 Catch:{ Exception -> 0x01a8, all -> 0x019c }
        r13 = r4;
        r7 = r15;
    L_0x012d:
        r4 = 8;
        r5 = 4;
        r20 = 0;
        goto L_0x017e;
    L_0x0133:
        r6 = r2;
        r2 = r30;
        r5 = 0;
    L_0x0137:
        if (r5 >= r2) goto L_0x015f;
    L_0x0139:
        r13 = new float[r15];	 Catch:{ Exception -> 0x01a8, all -> 0x019c }
        r14 = r5 + 1;
        r24 = r29[r14];	 Catch:{ Exception -> 0x01a8, all -> 0x019c }
        r26 = r29[r5];	 Catch:{ Exception -> 0x01a8, all -> 0x019c }
        r20 = r18;
        r22 = r16;
        r28 = r13;
        android.location.Location.distanceBetween(r20, r22, r24, r26, r28);	 Catch:{ Exception -> 0x01a8, all -> 0x019c }
        r20 = 0;
        r13 = r13[r20];	 Catch:{ Exception -> 0x01a8, all -> 0x019c }
        r13 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1));
        if (r13 >= 0) goto L_0x015c;
    L_0x0152:
        r21 = r29[r5];	 Catch:{ Exception -> 0x01a8, all -> 0x019c }
        r11 = r11 + r21;
        r13 = r29[r14];	 Catch:{ Exception -> 0x01a8, all -> 0x019c }
        r8 = r8 + r13;
        r10 = r10 + 1;
        r6 = r15;
    L_0x015c:
        r5 = r5 + 2;
        goto L_0x0137;
    L_0x015f:
        r20 = 0;
        if (r6 == 0) goto L_0x016f;
    L_0x0163:
        r11 = r11 + r16;
        r8 = r8 + r18;
        r10 = r10 + 1;
        r13 = r2;
        r2 = r6;
        r4 = 8;
    L_0x016d:
        r5 = 4;
        goto L_0x017e;
    L_0x016f:
        r4 = 8;
        if (r2 >= r4) goto L_0x018b;
    L_0x0173:
        r13 = r2 + 1;
        r29[r2] = r16;	 Catch:{ Exception -> 0x01a8, all -> 0x019c }
        r2 = r13 + 1;
        r29[r13] = r18;	 Catch:{ Exception -> 0x01a8, all -> 0x019c }
        r13 = r2;
        r2 = r6;
        goto L_0x016d;
    L_0x017e:
        if (r10 <= r5) goto L_0x0181;
    L_0x0180:
        goto L_0x018b;
    L_0x0181:
        r3.moveToNext();	 Catch:{ Exception -> 0x01a8, all -> 0x019c }
        r5 = r4;
        r4 = r20;
        r6 = r29;
        goto L_0x0089;
    L_0x018b:
        if (r10 <= 0) goto L_0x0196;
    L_0x018d:
        r1.e = r15;	 Catch:{ Exception -> 0x01a8, all -> 0x019c }
        r4 = (double) r10;	 Catch:{ Exception -> 0x01a8, all -> 0x019c }
        r11 = r11 / r4;
        r1.i = r11;	 Catch:{ Exception -> 0x01a8, all -> 0x019c }
        r8 = r8 / r4;
        r1.j = r8;	 Catch:{ Exception -> 0x01a8, all -> 0x019c }
    L_0x0196:
        if (r3 == 0) goto L_0x01ab;
    L_0x0198:
        r3.close();	 Catch:{ Exception -> 0x01ab }
        return;
    L_0x019c:
        r0 = move-exception;
        goto L_0x01a0;
    L_0x019e:
        r0 = move-exception;
        r3 = r2;
    L_0x01a0:
        r2 = r0;
        if (r3 == 0) goto L_0x01a6;
    L_0x01a3:
        r3.close();	 Catch:{ Exception -> 0x01a6 }
    L_0x01a6:
        throw r2;
    L_0x01a7:
        r3 = r2;
    L_0x01a8:
        if (r3 == 0) goto L_0x01ab;
    L_0x01aa:
        goto L_0x0198;
    L_0x01ab:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.d.a.a(java.util.List, android.database.sqlite.SQLiteDatabase):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:21:0x00db in {2, 3, 7, 8, 13, 15, 17, 19, 20} preds:[]
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:242)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        */
    private java.lang.String b(boolean r14) {
        /*
        r13 = this;
        r0 = r13.e;
        r1 = 0;
        r3 = 0;
        r4 = 1;
        if (r0 == 0) goto L_0x0014;
        r1 = r13.i;
        r5 = r13.j;
        r7 = 4642873445846928589; // 0x406ecccccccccccd float:-1.07374184E8 double:246.4;
        r0 = r4;
        r9 = r0;
        goto L_0x0023;
        r0 = r13.d;
        if (r0 == 0) goto L_0x001f;
        r1 = r13.g;
        r5 = r13.h;
        r7 = r13.f;
        goto L_0x0011;
        r5 = r1;
        r7 = r5;
        r0 = r3;
        goto L_0x0012;
        if (r0 == 0) goto L_0x00aa;
        r0 = 3;
        r10 = 2;
        r11 = 4;
        if (r14 == 0) goto L_0x006a;
        r14 = new java.lang.StringBuilder;
        r14.<init>();
        r9 = "{\"result\":{\"time\":\"";
        r14.append(r9);
        r9 = com.baidu.location.g.j.a();
        r14.append(r9);
        r9 = "\",\"error\":\"66\"},\"content\":{\"point\":{\"x\":";
        r14.append(r9);
        r9 = "\"%f\",\"y\":\"%f\"},\"radius\":\"%f\",\"isCellChanged\":\"%b\"}}";
        r14.append(r9);
        r14 = r14.toString();
        r9 = java.util.Locale.CHINA;
        r11 = new java.lang.Object[r11];
        r1 = java.lang.Double.valueOf(r1);
        r11[r3] = r1;
        r1 = java.lang.Double.valueOf(r5);
        r11[r4] = r1;
        r1 = java.lang.Double.valueOf(r7);
        r11[r10] = r1;
        r1 = java.lang.Boolean.valueOf(r4);
        r11[r0] = r1;
        r14 = java.lang.String.format(r9, r14, r11);
        return r14;
        r14 = new java.lang.StringBuilder;
        r14.<init>();
        r12 = "{\"result\":{\"time\":\"";
        r14.append(r12);
        r12 = com.baidu.location.g.j.a();
        r14.append(r12);
        r12 = "\",\"error\":\"66\"},\"content\":{\"point\":{\"x\":";
        r14.append(r12);
        r12 = "\"%f\",\"y\":\"%f\"},\"radius\":\"%f\",\"isCellChanged\":\"%b\"}}";
        r14.append(r12);
        r14 = r14.toString();
        r12 = java.util.Locale.CHINA;
        r11 = new java.lang.Object[r11];
        r1 = java.lang.Double.valueOf(r1);
        r11[r3] = r1;
        r1 = java.lang.Double.valueOf(r5);
        r11[r4] = r1;
        r1 = java.lang.Double.valueOf(r7);
        r11[r10] = r1;
        r1 = java.lang.Boolean.valueOf(r9);
        r11[r0] = r1;
        r14 = java.lang.String.format(r12, r14, r11);
        return r14;
        if (r14 == 0) goto L_0x00c7;
        r14 = new java.lang.StringBuilder;
        r14.<init>();
        r0 = "{\"result\":{\"time\":\"";
        r14.append(r0);
        r0 = com.baidu.location.g.j.a();
        r14.append(r0);
        r0 = "\",\"error\":\"67\"}}";
        r14.append(r0);
        r14 = r14.toString();
        return r14;
        r14 = new java.lang.StringBuilder;
        r14.<init>();
        r0 = "{\"result\":{\"time\":\"";
        r14.append(r0);
        r0 = com.baidu.location.g.j.a();
        r14.append(r0);
        r0 = "\",\"error\":\"63\"}}";
        goto L_0x00bf;
        return r14;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.d.a.b(boolean):java.lang.String");
    }

    private void e() {
        SQLiteDatabase openOrCreateDatabase;
        try {
            openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(m, null);
        } catch (Exception unused) {
            openOrCreateDatabase = null;
        }
        if (openOrCreateDatabase != null) {
            try {
                long queryNumEntries = DatabaseUtils.queryNumEntries(openOrCreateDatabase, "wof");
                long queryNumEntries2 = DatabaseUtils.queryNumEntries(openOrCreateDatabase, "bdcltb09");
                boolean z = queryNumEntries > 10000;
                boolean z2 = queryNumEntries2 > 10000;
                openOrCreateDatabase.close();
                if (z || z2) {
                    new a(this, null).execute(new Boolean[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
                }
            } catch (Exception unused2) {
            }
        }
    }

    public BDLocation a(String str, List<ScanResult> list, boolean z) {
        if (this.a) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("{\"result\":{\"time\":\"");
            stringBuilder.append(j.a());
            stringBuilder.append("\",\"error\":\"67\"}}");
            String stringBuilder2 = stringBuilder.toString();
            try {
                a(str, (List) list);
                str = b(true);
                if (str != null) {
                    stringBuilder2 = str;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return new BDLocation(stringBuilder2);
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("{\"result\":{\"time\":\"");
        stringBuilder3.append(j.a());
        stringBuilder3.append("\",\"error\":\"67\"}}");
        return new BDLocation(stringBuilder3.toString());
    }

    public BDLocation a(boolean z) {
        if (this.a) {
            com.baidu.location.e.a f = com.baidu.location.e.b.a().f();
            BDLocation bDLocation = null;
            String g = (f == null || !f.e()) ? null : f.g();
            h o = i.a().o();
            if (o != null) {
                bDLocation = a(g, o.a, true);
            }
            if (bDLocation != null && bDLocation.getLocType() == 66) {
                StringBuffer stringBuffer = new StringBuffer(1024);
                stringBuffer.append(String.format(Locale.CHINA, "&ofl=%f|%f|%f", new Object[]{Double.valueOf(bDLocation.getLatitude()), Double.valueOf(bDLocation.getLongitude()), Float.valueOf(bDLocation.getRadius())}));
                if (o != null && o.a() > 0) {
                    stringBuffer.append("&wf=");
                    stringBuffer.append(o.c(15));
                }
                if (f != null) {
                    stringBuffer.append(f.h());
                }
                stringBuffer.append("&uptype=oldoff");
                stringBuffer.append(j.e(f.getServiceContext()));
                stringBuffer.append(com.baidu.location.g.b.a().a(false));
                stringBuffer.append(com.baidu.location.a.a.a().d());
                stringBuffer.toString();
            }
            return bDLocation;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\"result\":{\"time\":\"");
        stringBuilder.append(j.a());
        stringBuilder.append("\",\"error\":\"67\"}}");
        return new BDLocation(stringBuilder.toString());
    }

    public void a(String str, com.baidu.location.e.a aVar, h hVar, BDLocation bDLocation) {
        if (this.a) {
            int i = (aVar.b() && l.c().h()) ? 0 : true;
            int i2 = (bDLocation == null || bDLocation.getLocType() != BDLocation.TypeNetWorkLocation || (!"wf".equals(bDLocation.getNetworkLocationType()) && bDLocation.getRadius() >= 300.0f)) ? true : 0;
            if (hVar.a == null) {
                i2 = true;
            }
            if ((i == 0 || i2 == 0) && !this.k) {
                this.k = true;
                new b(this, null).execute(new Object[]{str, aVar, hVar, bDLocation});
            }
        }
    }

    public void b() {
        try {
            File file = new File(l);
            File file2 = new File(m);
            if (!file.exists()) {
                file.mkdirs();
            }
            if (!file2.exists()) {
                file2.createNewFile();
            }
            if (file2.exists()) {
                SQLiteDatabase openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(file2, null);
                openOrCreateDatabase.execSQL("CREATE TABLE IF NOT EXISTS bdcltb09(id CHAR(40) PRIMARY KEY,time DOUBLE,tag DOUBLE, type DOUBLE , ac INT);");
                openOrCreateDatabase.execSQL("CREATE TABLE IF NOT EXISTS wof(id CHAR(15) PRIMARY KEY,mktime DOUBLE,time DOUBLE, ac INT, bc INT, cc INT);");
                openOrCreateDatabase.setVersion(1);
                openOrCreateDatabase.close();
            }
            this.a = true;
        } catch (Throwable unused) {
            this.a = false;
        }
    }

    public void c() {
        if (this.n == null) {
            this.n = new Handler();
        }
        this.n.postDelayed(new b(this), 3000);
    }
}
