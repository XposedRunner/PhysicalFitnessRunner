package com.baidu.location.d;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.g.e;
import com.tencent.stat.DeviceInfo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

final class c {
    private final g a;
    private int b;
    private double c;
    private double d;
    private Long e;
    private final c f = new c(this, true);
    private final c g = new c(this, false);
    private final SQLiteDatabase h;
    private final SQLiteDatabase i;
    private StringBuffer j;
    private StringBuffer k;
    private HashSet<Long> l;
    private ConcurrentHashMap<Long, Integer> m;
    private ConcurrentHashMap<Long, String> n;
    private StringBuffer o = new StringBuffer();
    private boolean p = false;

    private static final class a {
        double a;
        double b;
        double c;

        private a(double d, double d2, double d3) {
            this.a = d;
            this.b = d2;
            this.c = d3;
        }

        /* synthetic */ a(double d, double d2, double d3, d dVar) {
            this(d, d2, d3);
        }
    }

    private class b extends Thread {
        private String a;
        private Long c;
        private BDLocation d;
        private BDLocation e;
        private BDLocation f;
        private String g;
        private LinkedHashMap<String, Integer> h;

        private b(String str, Long l, BDLocation bDLocation, BDLocation bDLocation2, BDLocation bDLocation3, String str2, LinkedHashMap<String, Integer> linkedHashMap) {
            this.a = str;
            this.c = l;
            this.d = bDLocation;
            this.e = bDLocation2;
            this.f = bDLocation3;
            this.g = str2;
            this.h = linkedHashMap;
        }

        /* synthetic */ b(c cVar, String str, Long l, BDLocation bDLocation, BDLocation bDLocation2, BDLocation bDLocation3, String str2, LinkedHashMap linkedHashMap, d dVar) {
            this(str, l, bDLocation, bDLocation2, bDLocation3, str2, linkedHashMap);
        }

        public void run() {
            try {
                c.this.a(this.a, this.c, this.d);
                c.this.j = null;
                c.this.k = null;
                c.this.a(this.h);
                c.this.a(this.f, this.d, this.e, this.a, this.c);
                if (this.g != null) {
                    c.this.a.j().a(this.g);
                }
            } catch (Exception unused) {
            }
            this.h = null;
            this.a = null;
            this.g = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
        }
    }

    private final class c extends e {
        private String b;
        private final String c;
        private String d;
        private c e;
        private boolean f = false;
        private int q = 0;
        private long r = -1;
        private long s = -1;
        private long t = -1;
        private long u = -1;

        c(c cVar, boolean z) {
            this.e = cVar;
            this.c = z ? "load" : "update";
            this.k = new HashMap();
            this.b = g.b;
        }

        private void a(String str, String str2, String str3) {
            this.d = str3;
            this.b = String.format("http://%s/%s", new Object[]{str, str2});
            a(false, "ofloc.map.baidu.com");
        }

        private void c() {
            this.q++;
            this.r = System.currentTimeMillis();
        }

        private boolean f() {
            if (this.q < 2) {
                return true;
            }
            if (this.r + 43200000 >= System.currentTimeMillis()) {
                return false;
            }
            this.q = 0;
            this.r = -1;
            return true;
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0058  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0051  */
        /* JADX WARNING: Removed duplicated region for block: B:24:? A:{SYNTHETIC, RETURN} */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0061  */
        private void g() {
            /*
            r9 = this;
            r0 = 0;
            r9.d = r0;
            r0 = r9.l();
            r1 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
            r3 = -1;
            if (r0 == 0) goto L_0x0025;
        L_0x000e:
            r5 = r9.s;
            r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1));
            if (r0 == 0) goto L_0x0020;
        L_0x0014:
            r5 = r9.s;
            r7 = r5 + r1;
            r5 = java.lang.System.currentTimeMillis();
            r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1));
            if (r0 > 0) goto L_0x002b;
        L_0x0020:
            r0 = r9.h();
            goto L_0x0029;
        L_0x0025:
            r0 = r9.i();
        L_0x0029:
            r9.d = r0;
        L_0x002b:
            r0 = r9.d;
            if (r0 != 0) goto L_0x005d;
        L_0x002f:
            r5 = r9.t;
            r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1));
            if (r0 == 0) goto L_0x0041;
        L_0x0035:
            r3 = r9.t;
            r5 = r3 + r1;
            r0 = java.lang.System.currentTimeMillis();
            r2 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1));
            if (r2 > 0) goto L_0x005d;
        L_0x0041:
            r0 = com.baidu.location.d.c.this;
            r0 = r0.a;
            r0 = r0.k();
            r0 = r0.a();
            if (r0 == 0) goto L_0x0058;
        L_0x0051:
            r0 = r9.j();
        L_0x0055:
            r9.d = r0;
            goto L_0x005d;
        L_0x0058:
            r0 = r9.k();
            goto L_0x0055;
        L_0x005d:
            r0 = r9.d;
            if (r0 == 0) goto L_0x0066;
        L_0x0061:
            r0 = "https://ofloc.map.baidu.com/offline_loc";
            r9.c(r0);
        L_0x0066:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.d.c$c.g():void");
        }

        private String h() {
            JSONObject jSONObject;
            try {
                jSONObject = new JSONObject();
                jSONObject.put("type", "0");
                jSONObject.put("cuid", com.baidu.location.g.b.a().b);
                jSONObject.put(DeviceInfo.TAG_VERSION, "1");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(com.baidu.location.g.b.e);
                stringBuilder.append(":");
                stringBuilder.append(com.baidu.location.g.b.d);
                jSONObject.put("prod", stringBuilder.toString());
            } catch (Exception unused) {
                jSONObject = null;
            }
            return jSONObject != null ? Jni.encodeOfflineLocationUpdateRequest(jSONObject.toString()) : null;
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x0087 A:{SYNTHETIC, Splitter:B:21:0x0087} */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x00f1 A:{SYNTHETIC, Splitter:B:36:0x00f1} */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x010e A:{SYNTHETIC, Splitter:B:60:0x010e} */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x0100 A:{SYNTHETIC, Splitter:B:47:0x0100} */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x0105 A:{SYNTHETIC, Splitter:B:51:0x0105} */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x010e A:{SYNTHETIC, Splitter:B:60:0x010e} */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x0100 A:{SYNTHETIC, Splitter:B:47:0x0100} */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x0105 A:{SYNTHETIC, Splitter:B:51:0x0105} */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x010e A:{SYNTHETIC, Splitter:B:60:0x010e} */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x00fc A:{Splitter:B:1:0x0001, ExcHandler: all (th java.lang.Throwable)} */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing block: B:38:0x00f4, code skipped:
            if (r3 != null) goto L_0x00f6;
     */
        /* JADX WARNING: Missing block: B:41:?, code skipped:
            r3.close();
     */
        /* JADX WARNING: Missing block: B:44:0x00fc, code skipped:
            r1 = th;
     */
        /* JADX WARNING: Missing block: B:45:0x00fd, code skipped:
            r3 = null;
     */
        /* JADX WARNING: Missing block: B:55:0x0109, code skipped:
            r2 = null;
            r3 = r2;
     */
        /* JADX WARNING: Missing block: B:62:0x0111, code skipped:
            if (r3 != null) goto L_0x00f6;
     */
        private java.lang.String i() {
            /*
            r14 = this;
            r0 = 0;
            r1 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0109, all -> 0x00fc }
            r1.<init>();	 Catch:{ Exception -> 0x0109, all -> 0x00fc }
            r2 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0109, all -> 0x00fc }
            r2.<init>();	 Catch:{ Exception -> 0x0109, all -> 0x00fc }
            r3 = com.baidu.location.d.c.this;	 Catch:{ Exception -> 0x00fa, all -> 0x00fc }
            r3 = r3.i;	 Catch:{ Exception -> 0x00fa, all -> 0x00fc }
            r4 = "SELECT * FROM %s WHERE frequency>%d ORDER BY frequency DESC LIMIT %d;";
            r5 = 3;
            r6 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x00fa, all -> 0x00fc }
            r7 = "CL";
            r8 = 0;
            r6[r8] = r7;	 Catch:{ Exception -> 0x00fa, all -> 0x00fc }
            r7 = 5;
            r9 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x00fa, all -> 0x00fc }
            r10 = 1;
            r6[r10] = r9;	 Catch:{ Exception -> 0x00fa, all -> 0x00fc }
            r9 = 50;
            r11 = java.lang.Integer.valueOf(r9);	 Catch:{ Exception -> 0x00fa, all -> 0x00fc }
            r12 = 2;
            r6[r12] = r11;	 Catch:{ Exception -> 0x00fa, all -> 0x00fc }
            r4 = java.lang.String.format(r4, r6);	 Catch:{ Exception -> 0x00fa, all -> 0x00fc }
            r3 = r3.rawQuery(r4, r0);	 Catch:{ Exception -> 0x00fa, all -> 0x00fc }
            if (r3 == 0) goto L_0x0062;
        L_0x0036:
            r4 = r3.moveToFirst();	 Catch:{ Exception -> 0x005f, all -> 0x005c }
            if (r4 == 0) goto L_0x0062;
        L_0x003c:
            r4 = r3.getCount();	 Catch:{ Exception -> 0x005f, all -> 0x005c }
            r6 = new org.json.JSONArray;	 Catch:{ Exception -> 0x005f, all -> 0x005c }
            r6.<init>();	 Catch:{ Exception -> 0x005f, all -> 0x005c }
        L_0x0045:
            r11 = r3.isAfterLast();	 Catch:{ Exception -> 0x005f, all -> 0x005c }
            if (r11 != 0) goto L_0x0056;
        L_0x004b:
            r11 = r3.getString(r10);	 Catch:{ Exception -> 0x005f, all -> 0x005c }
            r6.put(r11);	 Catch:{ Exception -> 0x005f, all -> 0x005c }
            r3.moveToNext();	 Catch:{ Exception -> 0x005f, all -> 0x005c }
            goto L_0x0045;
        L_0x0056:
            r11 = "cell";
            r1.put(r11, r6);	 Catch:{ Exception -> 0x005f, all -> 0x005c }
            goto L_0x0063;
        L_0x005c:
            r1 = move-exception;
            goto L_0x00fe;
        L_0x005f:
            r5 = r0;
            goto L_0x010c;
        L_0x0062:
            r4 = r8;
        L_0x0063:
            r6 = com.baidu.location.d.c.this;	 Catch:{ Exception -> 0x005f, all -> 0x005c }
            r6 = r6.i;	 Catch:{ Exception -> 0x005f, all -> 0x005c }
            r11 = "SELECT * FROM %s WHERE frequency>%d ORDER BY frequency DESC LIMIT %d;";
            r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x005f, all -> 0x005c }
            r13 = "AP";
            r5[r8] = r13;	 Catch:{ Exception -> 0x005f, all -> 0x005c }
            r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x005f, all -> 0x005c }
            r5[r10] = r7;	 Catch:{ Exception -> 0x005f, all -> 0x005c }
            r7 = java.lang.Integer.valueOf(r9);	 Catch:{ Exception -> 0x005f, all -> 0x005c }
            r5[r12] = r7;	 Catch:{ Exception -> 0x005f, all -> 0x005c }
            r5 = java.lang.String.format(r11, r5);	 Catch:{ Exception -> 0x005f, all -> 0x005c }
            r5 = r6.rawQuery(r5, r0);	 Catch:{ Exception -> 0x005f, all -> 0x005c }
            if (r5 == 0) goto L_0x00b0;
        L_0x0087:
            r6 = r5.moveToFirst();	 Catch:{ Exception -> 0x010c, all -> 0x00ad }
            if (r6 == 0) goto L_0x00b0;
        L_0x008d:
            r8 = r5.getCount();	 Catch:{ Exception -> 0x010c, all -> 0x00ad }
            r6 = new org.json.JSONArray;	 Catch:{ Exception -> 0x010c, all -> 0x00ad }
            r6.<init>();	 Catch:{ Exception -> 0x010c, all -> 0x00ad }
        L_0x0096:
            r7 = r5.isAfterLast();	 Catch:{ Exception -> 0x010c, all -> 0x00ad }
            if (r7 != 0) goto L_0x00a7;
        L_0x009c:
            r7 = r5.getString(r10);	 Catch:{ Exception -> 0x010c, all -> 0x00ad }
            r6.put(r7);	 Catch:{ Exception -> 0x010c, all -> 0x00ad }
            r5.moveToNext();	 Catch:{ Exception -> 0x010c, all -> 0x00ad }
            goto L_0x0096;
        L_0x00a7:
            r7 = "ap";
            r1.put(r7, r6);	 Catch:{ Exception -> 0x010c, all -> 0x00ad }
            goto L_0x00b0;
        L_0x00ad:
            r1 = move-exception;
            r0 = r5;
            goto L_0x00fe;
        L_0x00b0:
            r6 = "type";
            r7 = "1";
            r2.put(r6, r7);	 Catch:{ Exception -> 0x010c, all -> 0x00ad }
            r6 = "cuid";
            r7 = com.baidu.location.g.b.a();	 Catch:{ Exception -> 0x010c, all -> 0x00ad }
            r7 = r7.b;	 Catch:{ Exception -> 0x010c, all -> 0x00ad }
            r2.put(r6, r7);	 Catch:{ Exception -> 0x010c, all -> 0x00ad }
            r6 = "ver";
            r7 = "1";
            r2.put(r6, r7);	 Catch:{ Exception -> 0x010c, all -> 0x00ad }
            r6 = "prod";
            r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x010c, all -> 0x00ad }
            r7.<init>();	 Catch:{ Exception -> 0x010c, all -> 0x00ad }
            r9 = com.baidu.location.g.b.e;	 Catch:{ Exception -> 0x010c, all -> 0x00ad }
            r7.append(r9);	 Catch:{ Exception -> 0x010c, all -> 0x00ad }
            r9 = ":";
            r7.append(r9);	 Catch:{ Exception -> 0x010c, all -> 0x00ad }
            r9 = com.baidu.location.g.b.d;	 Catch:{ Exception -> 0x010c, all -> 0x00ad }
            r7.append(r9);	 Catch:{ Exception -> 0x010c, all -> 0x00ad }
            r7 = r7.toString();	 Catch:{ Exception -> 0x010c, all -> 0x00ad }
            r2.put(r6, r7);	 Catch:{ Exception -> 0x010c, all -> 0x00ad }
            if (r4 != 0) goto L_0x00ea;
        L_0x00e8:
            if (r8 == 0) goto L_0x00ef;
        L_0x00ea:
            r4 = "model";
            r2.put(r4, r1);	 Catch:{ Exception -> 0x010c, all -> 0x00ad }
        L_0x00ef:
            if (r5 == 0) goto L_0x00f4;
        L_0x00f1:
            r5.close();	 Catch:{ Exception -> 0x00f4 }
        L_0x00f4:
            if (r3 == 0) goto L_0x0114;
        L_0x00f6:
            r3.close();	 Catch:{ Exception -> 0x0114 }
            goto L_0x0114;
        L_0x00fa:
            r3 = r0;
            goto L_0x010b;
        L_0x00fc:
            r1 = move-exception;
            r3 = r0;
        L_0x00fe:
            if (r0 == 0) goto L_0x0103;
        L_0x0100:
            r0.close();	 Catch:{ Exception -> 0x0103 }
        L_0x0103:
            if (r3 == 0) goto L_0x0108;
        L_0x0105:
            r3.close();	 Catch:{ Exception -> 0x0108 }
        L_0x0108:
            throw r1;
        L_0x0109:
            r2 = r0;
            r3 = r2;
        L_0x010b:
            r5 = r3;
        L_0x010c:
            if (r5 == 0) goto L_0x0111;
        L_0x010e:
            r5.close();	 Catch:{ Exception -> 0x0111 }
        L_0x0111:
            if (r3 == 0) goto L_0x0114;
        L_0x0113:
            goto L_0x00f6;
        L_0x0114:
            if (r2 == 0) goto L_0x0143;
        L_0x0116:
            r1 = "model";
            r1 = r2.has(r1);
            if (r1 != 0) goto L_0x0143;
        L_0x011e:
            r3 = r14.u;
            r5 = -1;
            r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
            if (r1 == 0) goto L_0x0135;
        L_0x0126:
            r3 = r14.u;
            r5 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
            r7 = r3 + r5;
            r3 = java.lang.System.currentTimeMillis();
            r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1));
            if (r1 >= 0) goto L_0x0143;
        L_0x0135:
            r0 = r2.toString();
            r0 = com.baidu.location.Jni.encodeOfflineLocationUpdateRequest(r0);
            r3 = java.lang.System.currentTimeMillis();
            r14.u = r3;
        L_0x0143:
            if (r2 == 0) goto L_0x0155;
        L_0x0145:
            r1 = "model";
            r1 = r2.has(r1);
            if (r1 == 0) goto L_0x0155;
        L_0x014d:
            r0 = r2.toString();
            r0 = com.baidu.location.Jni.encodeOfflineLocationUpdateRequest(r0);
        L_0x0155:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.d.c$c.i():java.lang.String");
        }

        private String j() {
            JSONObject jSONObject;
            try {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", "2");
                    jSONObject.put(DeviceInfo.TAG_VERSION, "1");
                    jSONObject.put("cuid", com.baidu.location.g.b.a().b);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(com.baidu.location.g.b.e);
                    stringBuilder.append(":");
                    stringBuilder.append(com.baidu.location.g.b.d);
                    jSONObject.put("prod", stringBuilder.toString());
                    this.t = System.currentTimeMillis();
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                jSONObject = null;
            }
            return jSONObject != null ? Jni.encodeOfflineLocationUpdateRequest(jSONObject.toString()) : null;
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:? A:{SYNTHETIC, RETURN} */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x005b  */
        private java.lang.String k() {
            /*
            r6 = this;
            r0 = 0;
            r1 = com.baidu.location.d.c.this;	 Catch:{ Exception -> 0x0058 }
            r1 = r1.a;	 Catch:{ Exception -> 0x0058 }
            r1 = r1.k();	 Catch:{ Exception -> 0x0058 }
            r1 = r1.b();	 Catch:{ Exception -> 0x0058 }
            if (r1 == 0) goto L_0x0058;
        L_0x0011:
            r2 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0058 }
            r2.<init>();	 Catch:{ Exception -> 0x0058 }
            r3 = "type";
            r4 = "3";
            r2.put(r3, r4);	 Catch:{ Exception -> 0x0059 }
            r3 = "ver";
            r4 = "1";
            r2.put(r3, r4);	 Catch:{ Exception -> 0x0059 }
            r3 = "cuid";
            r4 = com.baidu.location.g.b.a();	 Catch:{ Exception -> 0x0059 }
            r4 = r4.b;	 Catch:{ Exception -> 0x0059 }
            r2.put(r3, r4);	 Catch:{ Exception -> 0x0059 }
            r3 = "prod";
            r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0059 }
            r4.<init>();	 Catch:{ Exception -> 0x0059 }
            r5 = com.baidu.location.g.b.e;	 Catch:{ Exception -> 0x0059 }
            r4.append(r5);	 Catch:{ Exception -> 0x0059 }
            r5 = ":";
            r4.append(r5);	 Catch:{ Exception -> 0x0059 }
            r5 = com.baidu.location.g.b.d;	 Catch:{ Exception -> 0x0059 }
            r4.append(r5);	 Catch:{ Exception -> 0x0059 }
            r4 = r4.toString();	 Catch:{ Exception -> 0x0059 }
            r2.put(r3, r4);	 Catch:{ Exception -> 0x0059 }
            r3 = "rgc";
            r2.put(r3, r1);	 Catch:{ Exception -> 0x0059 }
            r3 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0059 }
            r6.t = r3;	 Catch:{ Exception -> 0x0059 }
            goto L_0x0059;
        L_0x0058:
            r2 = r0;
        L_0x0059:
            if (r2 == 0) goto L_0x0063;
        L_0x005b:
            r0 = r2.toString();
            r0 = com.baidu.location.Jni.encodeOfflineLocationUpdateRequest(r0);
        L_0x0063:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.d.c$c.k():java.lang.String");
        }

        /* JADX WARNING: Removed duplicated region for block: B:46:0x005c A:{SYNTHETIC, Splitter:B:46:0x005c} */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x0061 A:{SYNTHETIC, Splitter:B:50:0x0061} */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0050 A:{SYNTHETIC, Splitter:B:34:0x0050} */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x0055 A:{SYNTHETIC, Splitter:B:38:0x0055} */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x005c A:{SYNTHETIC, Splitter:B:46:0x005c} */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x0061 A:{SYNTHETIC, Splitter:B:50:0x0061} */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0050 A:{SYNTHETIC, Splitter:B:34:0x0050} */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x0055 A:{SYNTHETIC, Splitter:B:38:0x0055} */
        private boolean l() {
            /*
            r5 = this;
            r0 = 0;
            r1 = 1;
            r2 = com.baidu.location.d.c.this;	 Catch:{ Exception -> 0x0059, all -> 0x004c }
            r2 = r2.h;	 Catch:{ Exception -> 0x0059, all -> 0x004c }
            r3 = "SELECT COUNT(*) FROM AP;";
            r2 = r2.rawQuery(r3, r0);	 Catch:{ Exception -> 0x0059, all -> 0x004c }
            r3 = com.baidu.location.d.c.this;	 Catch:{ Exception -> 0x005a, all -> 0x004a }
            r3 = r3.h;	 Catch:{ Exception -> 0x005a, all -> 0x004a }
            r4 = "SELECT COUNT(*) FROM CL";
            r3 = r3.rawQuery(r4, r0);	 Catch:{ Exception -> 0x005a, all -> 0x004a }
            r0 = 0;
            if (r2 == 0) goto L_0x003f;
        L_0x001d:
            r4 = r2.moveToFirst();	 Catch:{ Exception -> 0x003d, all -> 0x0039 }
            if (r4 == 0) goto L_0x003f;
        L_0x0023:
            if (r3 == 0) goto L_0x003f;
        L_0x0025:
            r4 = r3.moveToFirst();	 Catch:{ Exception -> 0x003d, all -> 0x0039 }
            if (r4 == 0) goto L_0x003f;
        L_0x002b:
            r4 = r2.getInt(r0);	 Catch:{ Exception -> 0x003d, all -> 0x0039 }
            if (r4 != 0) goto L_0x0037;
        L_0x0031:
            r4 = r3.getInt(r0);	 Catch:{ Exception -> 0x003d, all -> 0x0039 }
            if (r4 == 0) goto L_0x003f;
        L_0x0037:
            r1 = r0;
            goto L_0x003f;
        L_0x0039:
            r0 = move-exception;
            r1 = r0;
            r0 = r3;
            goto L_0x004e;
        L_0x003d:
            r0 = r3;
            goto L_0x005a;
        L_0x003f:
            if (r2 == 0) goto L_0x0044;
        L_0x0041:
            r2.close();	 Catch:{ Exception -> 0x0044 }
        L_0x0044:
            if (r3 == 0) goto L_0x0064;
        L_0x0046:
            r3.close();	 Catch:{ Exception -> 0x0064 }
            return r1;
        L_0x004a:
            r1 = move-exception;
            goto L_0x004e;
        L_0x004c:
            r1 = move-exception;
            r2 = r0;
        L_0x004e:
            if (r2 == 0) goto L_0x0053;
        L_0x0050:
            r2.close();	 Catch:{ Exception -> 0x0053 }
        L_0x0053:
            if (r0 == 0) goto L_0x0058;
        L_0x0055:
            r0.close();	 Catch:{ Exception -> 0x0058 }
        L_0x0058:
            throw r1;
        L_0x0059:
            r2 = r0;
        L_0x005a:
            if (r2 == 0) goto L_0x005f;
        L_0x005c:
            r2.close();	 Catch:{ Exception -> 0x005f }
        L_0x005f:
            if (r0 == 0) goto L_0x0064;
        L_0x0061:
            r0.close();	 Catch:{ Exception -> 0x0064 }
        L_0x0064:
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.d.c$c.l():boolean");
        }

        public void a() {
            this.f = true;
            this.h = this.b;
            this.k.clear();
            this.k.put("qt", this.c);
            this.k.put("req", this.d);
        }

        public void a(boolean z) {
            if (!z || this.j == null) {
                this.f = false;
                c();
                return;
            }
            new e(this).start();
        }

        /* Access modifiers changed, original: 0000 */
        public void b() {
            if (f() && !this.f) {
                c.this.g.g();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x007b A:{Catch:{ Exception -> 0x0083 }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0089 A:{SYNTHETIC, Splitter:B:21:0x0089} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0068 */
    /* JADX WARNING: Failed to process nested try/catch */
    c(com.baidu.location.d.g r4) {
        /*
        r3 = this;
        r3.<init>();
        r3.a = r4;
        r4 = 0;
        r3.p = r4;
        r0 = new com.baidu.location.d.c$c;
        r1 = 1;
        r0.<init>(r3, r1);
        r3.f = r0;
        r0 = new com.baidu.location.d.c$c;
        r0.<init>(r3, r4);
        r3.g = r0;
        r4 = new java.lang.StringBuffer;
        r4.<init>();
        r3.o = r4;
        r4 = 0;
        r3.j = r4;
        r3.k = r4;
        r0 = new java.util.HashSet;
        r0.<init>();
        r3.l = r0;
        r0 = new java.util.concurrent.ConcurrentHashMap;
        r0.<init>();
        r3.m = r0;
        r0 = new java.util.concurrent.ConcurrentHashMap;
        r0.<init>();
        r3.n = r0;
        r0 = new java.io.File;	 Catch:{ Exception -> 0x0053 }
        r1 = r3.a;	 Catch:{ Exception -> 0x0053 }
        r1 = r1.c();	 Catch:{ Exception -> 0x0053 }
        r2 = "ofl_location.db";
        r0.<init>(r1, r2);	 Catch:{ Exception -> 0x0053 }
        r1 = r0.exists();	 Catch:{ Exception -> 0x0053 }
        if (r1 != 0) goto L_0x004e;
    L_0x004b:
        r0.createNewFile();	 Catch:{ Exception -> 0x0053 }
    L_0x004e:
        r0 = android.database.sqlite.SQLiteDatabase.openOrCreateDatabase(r0, r4);	 Catch:{ Exception -> 0x0053 }
        goto L_0x0054;
    L_0x0053:
        r0 = r4;
    L_0x0054:
        r3.h = r0;
        r0 = r3.h;
        if (r0 == 0) goto L_0x0068;
    L_0x005a:
        r0 = r3.h;	 Catch:{ Exception -> 0x0068 }
        r1 = "CREATE TABLE IF NOT EXISTS AP (id LONG PRIMARY KEY,x DOUBLE,y DOUBLE,r INTEGER,cl DOUBLE,timestamp INTEGER, frequency INTEGER DEFAULT 0);";
        r0.execSQL(r1);	 Catch:{ Exception -> 0x0068 }
        r0 = r3.h;	 Catch:{ Exception -> 0x0068 }
        r1 = "CREATE TABLE IF NOT EXISTS CL (id LONG PRIMARY KEY,x DOUBLE,y DOUBLE,r INTEGER,cl DOUBLE,timestamp INTEGER, frequency INTEGER DEFAULT 0);";
        r0.execSQL(r1);	 Catch:{ Exception -> 0x0068 }
    L_0x0068:
        r0 = new java.io.File;	 Catch:{ Exception -> 0x0083 }
        r1 = r3.a;	 Catch:{ Exception -> 0x0083 }
        r1 = r1.c();	 Catch:{ Exception -> 0x0083 }
        r2 = "ofl_statistics.db";
        r0.<init>(r1, r2);	 Catch:{ Exception -> 0x0083 }
        r1 = r0.exists();	 Catch:{ Exception -> 0x0083 }
        if (r1 != 0) goto L_0x007e;
    L_0x007b:
        r0.createNewFile();	 Catch:{ Exception -> 0x0083 }
    L_0x007e:
        r0 = android.database.sqlite.SQLiteDatabase.openOrCreateDatabase(r0, r4);	 Catch:{ Exception -> 0x0083 }
        r4 = r0;
    L_0x0083:
        r3.i = r4;
        r4 = r3.i;
        if (r4 == 0) goto L_0x0097;
    L_0x0089:
        r4 = r3.i;	 Catch:{ Exception -> 0x0097 }
        r0 = "CREATE TABLE IF NOT EXISTS AP (id LONG PRIMARY KEY, originid VARCHAR(15), frequency INTEGER DEFAULT 0);";
        r4.execSQL(r0);	 Catch:{ Exception -> 0x0097 }
        r4 = r3.i;	 Catch:{ Exception -> 0x0097 }
        r0 = "CREATE TABLE IF NOT EXISTS CL (id LONG PRIMARY KEY, originid VARCHAR(40), frequency INTEGER DEFAULT 0);";
        r4.execSQL(r0);	 Catch:{ Exception -> 0x0097 }
    L_0x0097:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.d.c.<init>(com.baidu.location.d.g):void");
    }

    private double a(double d, double d2, double d3, double d4) {
        double d5 = d4 - d2;
        double d6 = d3 - d;
        d = Math.toRadians(d);
        Math.toRadians(d2);
        d2 = Math.toRadians(d3);
        Math.toRadians(d4);
        d4 = Math.toRadians(d6) / 2.0d;
        d3 = Math.toRadians(d5) / 2.0d;
        d6 = (Math.sin(d4) * Math.sin(d4)) + (((Math.cos(d) * Math.cos(d2)) * Math.sin(d3)) * Math.sin(d3));
        return (2.0d * Math.atan2(Math.sqrt(d6), Math.sqrt(1.0d - d6))) * 6378137.0d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x008c A:{LOOP_END, LOOP:0: B:4:0x000b->B:26:0x008c} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008b A:{SYNTHETIC} */
    private int a(java.util.ArrayList<com.baidu.location.d.c.a> r22, double r23) {
        /*
        r21 = this;
        r0 = r22;
        r1 = r22.size();
        r2 = 0;
        if (r1 != 0) goto L_0x000a;
    L_0x0009:
        return r2;
    L_0x000a:
        r1 = r2;
    L_0x000b:
        r3 = r22.size();
        r4 = 3;
        r5 = 1;
        if (r3 < r4) goto L_0x0087;
    L_0x0013:
        r3 = 0;
        r6 = r3;
        r8 = r6;
        r3 = r2;
    L_0x0018:
        r4 = r22.size();
        if (r3 >= r4) goto L_0x0033;
    L_0x001e:
        r4 = r0.get(r3);
        r4 = (com.baidu.location.d.c.a) r4;
        r10 = r4.a;
        r6 = r6 + r10;
        r4 = r0.get(r3);
        r4 = (com.baidu.location.d.c.a) r4;
        r10 = r4.b;
        r8 = r8 + r10;
        r3 = r3 + 1;
        goto L_0x0018;
    L_0x0033:
        r3 = r22.size();
        r3 = (double) r3;
        r3 = r6 / r3;
        r6 = r22.size();
        r6 = (double) r6;
        r6 = r8 / r6;
        r8 = -4616189618054758400; // 0xbff0000000000000 float:0.0 double:-1.0;
        r10 = -1;
        r19 = r8;
        r9 = r10;
        r8 = r2;
    L_0x0048:
        r10 = r22.size();
        if (r8 >= r10) goto L_0x0073;
    L_0x004e:
        r10 = r0.get(r8);
        r10 = (com.baidu.location.d.c.a) r10;
        r13 = r10.b;
        r10 = r0.get(r8);
        r10 = (com.baidu.location.d.c.a) r10;
        r11 = r10.a;
        r10 = r21;
        r17 = r11;
        r11 = r6;
        r15 = r13;
        r13 = r3;
        r10 = r10.a(r11, r13, r15, r17);
        r12 = (r10 > r19 ? 1 : (r10 == r19 ? 0 : -1));
        if (r12 <= 0) goto L_0x0070;
    L_0x006d:
        r9 = r8;
        r19 = r10;
    L_0x0070:
        r8 = r8 + 1;
        goto L_0x0048;
    L_0x0073:
        r3 = (r19 > r23 ? 1 : (r19 == r23 ? 0 : -1));
        if (r3 <= 0) goto L_0x0087;
    L_0x0077:
        if (r9 < 0) goto L_0x0087;
    L_0x0079:
        r3 = r22.size();
        if (r9 >= r3) goto L_0x0087;
    L_0x007f:
        r1 = r1 + 1;
        r0.remove(r9);
        r3 = r1;
        r1 = r5;
        goto L_0x0089;
    L_0x0087:
        r3 = r1;
        r1 = r2;
    L_0x0089:
        if (r1 == r5) goto L_0x008c;
    L_0x008b:
        return r3;
    L_0x008c:
        r1 = r3;
        goto L_0x000b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.d.c.a(java.util.ArrayList, double):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:63:0x00cd A:{SYNTHETIC, Splitter:B:63:0x00cd} */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e1 A:{SYNTHETIC, Splitter:B:77:0x00e1} */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00d8 A:{SYNTHETIC, Splitter:B:70:0x00d8} */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e1 A:{SYNTHETIC, Splitter:B:77:0x00e1} */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00c3 A:{Splitter:B:9:0x004d, ExcHandler: all (r0_0 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e1 A:{SYNTHETIC, Splitter:B:77:0x00e1} */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00c3 A:{Splitter:B:9:0x004d, ExcHandler: all (r0_0 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e1 A:{SYNTHETIC, Splitter:B:77:0x00e1} */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00c3 A:{Splitter:B:9:0x004d, ExcHandler: all (r0_0 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00c3 A:{Splitter:B:9:0x004d, ExcHandler: all (r0_0 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00c3 A:{Splitter:B:9:0x004d, ExcHandler: all (r0_0 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e1 A:{SYNTHETIC, Splitter:B:77:0x00e1} */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00c3 A:{Splitter:B:9:0x004d, ExcHandler: all (r0_0 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e1 A:{SYNTHETIC, Splitter:B:77:0x00e1} */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00c3 A:{Splitter:B:9:0x004d, ExcHandler: all (r0_0 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e1 A:{SYNTHETIC, Splitter:B:77:0x00e1} */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0102  */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:40:0x00b4, code skipped:
            r6 = r5;
     */
    /* JADX WARNING: Missing block: B:42:0x00b6, code skipped:
            r5 = true;
     */
    /* JADX WARNING: Missing block: B:46:0x00b9, code skipped:
            r5 = 1;
     */
    /* JADX WARNING: Missing block: B:49:0x00bc, code skipped:
            r5 = 1;
     */
    /* JADX WARNING: Missing block: B:52:0x00bf, code skipped:
            r5 = 1;
     */
    /* JADX WARNING: Missing block: B:56:0x00c3, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:57:0x00c4, code skipped:
            r2 = r0;
     */
    /* JADX WARNING: Missing block: B:58:0x00c6, code skipped:
            r6 = 0;
     */
    /* JADX WARNING: Missing block: B:71:?, code skipped:
            r4.close();
     */
    /* JADX WARNING: Missing block: B:78:?, code skipped:
            r4.close();
     */
    private com.baidu.location.BDLocation a(java.lang.Long r20) {
        /*
        r19 = this;
        r1 = r19;
        r2 = r20;
        r3 = 0;
        r1.p = r3;
        r4 = r1.e;
        r5 = 0;
        r6 = 1;
        if (r4 == 0) goto L_0x001f;
    L_0x000d:
        r4 = r1.e;
        r4 = r4.equals(r2);
        if (r4 == 0) goto L_0x001f;
    L_0x0015:
        r2 = r1.c;
        r7 = r1.d;
        r4 = r1.b;
        r9 = r2;
        r3 = r4;
        goto L_0x00e4;
    L_0x001f:
        r4 = java.util.Locale.US;
        r7 = "SELECT * FROM CL WHERE id = %d AND timestamp + %d > %d;";
        r8 = 3;
        r8 = new java.lang.Object[r8];
        r8[r3] = r2;
        r9 = 15552000; // 0xed4e00 float:2.1792994E-38 double:7.683709E-317;
        r9 = java.lang.Integer.valueOf(r9);
        r8[r6] = r9;
        r9 = 2;
        r10 = java.lang.System.currentTimeMillis();
        r12 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r10 = r10 / r12;
        r10 = java.lang.Long.valueOf(r10);
        r8[r9] = r10;
        r4 = java.lang.String.format(r4, r7, r8);
        r7 = 0;
        r9 = r1.h;	 Catch:{ Exception -> 0x00dc, all -> 0x00d3 }
        r4 = r9.rawQuery(r4, r5);	 Catch:{ Exception -> 0x00dc, all -> 0x00d3 }
        if (r4 == 0) goto L_0x00c9;
    L_0x004d:
        r9 = r4.moveToFirst();	 Catch:{ Exception -> 0x00c6, all -> 0x00c3 }
        if (r9 == 0) goto L_0x00c9;
    L_0x0053:
        r9 = "cl";
        r9 = r4.getColumnIndex(r9);	 Catch:{ Exception -> 0x00c6, all -> 0x00c3 }
        r9 = r4.getDouble(r9);	 Catch:{ Exception -> 0x00c6, all -> 0x00c3 }
        r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1));
        if (r11 <= 0) goto L_0x00c9;
    L_0x0061:
        r9 = "x";
        r9 = r4.getColumnIndex(r9);	 Catch:{ Exception -> 0x00c1, all -> 0x00c3 }
        r9 = r4.getDouble(r9);	 Catch:{ Exception -> 0x00c1, all -> 0x00c3 }
        r11 = "y";
        r11 = r4.getColumnIndex(r11);	 Catch:{ Exception -> 0x00bf, all -> 0x00c3 }
        r14 = r4.getDouble(r11);	 Catch:{ Exception -> 0x00bf, all -> 0x00c3 }
        r7 = "r";
        r7 = r4.getColumnIndex(r7);	 Catch:{ Exception -> 0x00bc, all -> 0x00c3 }
        r7 = r4.getInt(r7);	 Catch:{ Exception -> 0x00bc, all -> 0x00c3 }
        r3 = "timestamp";
        r3 = r4.getColumnIndex(r3);	 Catch:{ Exception -> 0x00b9, all -> 0x00c3 }
        r3 = r4.getInt(r3);	 Catch:{ Exception -> 0x00b9, all -> 0x00c3 }
        r8 = 604800; // 0x93a80 float:8.47505E-40 double:2.98811E-318;
        r3 = r3 + r8;
        r5 = (long) r3;
        r17 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00b6, all -> 0x00c3 }
        r17 = r17 / r12;
        r3 = (r5 > r17 ? 1 : (r5 == r17 ? 0 : -1));
        if (r3 >= 0) goto L_0x009c;
    L_0x0098:
        r5 = 1;
        r1.p = r5;	 Catch:{ Exception -> 0x00b7, all -> 0x00c3 }
        goto L_0x009d;
    L_0x009c:
        r5 = 1;
    L_0x009d:
        r3 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        r6 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        if (r7 >= r6) goto L_0x00a5;
    L_0x00a3:
        r3 = r6;
        goto L_0x00a9;
    L_0x00a5:
        if (r3 >= r7) goto L_0x00a8;
    L_0x00a7:
        goto L_0x00a9;
    L_0x00a8:
        r3 = r7;
    L_0x00a9:
        r1.c = r9;	 Catch:{ Exception -> 0x00b4, all -> 0x00c3 }
        r1.d = r14;	 Catch:{ Exception -> 0x00b4, all -> 0x00c3 }
        r1.b = r3;	 Catch:{ Exception -> 0x00b4, all -> 0x00c3 }
        r1.e = r2;	 Catch:{ Exception -> 0x00b4, all -> 0x00c3 }
        r6 = r5;
        r7 = r9;
        goto L_0x00cb;
    L_0x00b4:
        r6 = r5;
        goto L_0x00bd;
    L_0x00b6:
        r5 = 1;
    L_0x00b7:
        r6 = r5;
        goto L_0x00ba;
    L_0x00b9:
        r5 = r6;
    L_0x00ba:
        r3 = r7;
        goto L_0x00bd;
    L_0x00bc:
        r5 = r6;
    L_0x00bd:
        r7 = r14;
        goto L_0x00df;
    L_0x00bf:
        r5 = r6;
        goto L_0x00df;
    L_0x00c1:
        r5 = r6;
        goto L_0x00c7;
    L_0x00c3:
        r0 = move-exception;
        r2 = r0;
        goto L_0x00d6;
    L_0x00c6:
        r6 = r3;
    L_0x00c7:
        r9 = r7;
        goto L_0x00df;
    L_0x00c9:
        r6 = r3;
        r14 = r7;
    L_0x00cb:
        if (r4 == 0) goto L_0x00d0;
    L_0x00cd:
        r4.close();	 Catch:{ Exception -> 0x00d0 }
    L_0x00d0:
        r9 = r7;
        r7 = r14;
        goto L_0x00e4;
    L_0x00d3:
        r0 = move-exception;
        r2 = r0;
        r4 = 0;
    L_0x00d6:
        if (r4 == 0) goto L_0x00db;
    L_0x00d8:
        r4.close();	 Catch:{ Exception -> 0x00db }
    L_0x00db:
        throw r2;
    L_0x00dc:
        r6 = r3;
        r9 = r7;
        r4 = 0;
    L_0x00df:
        if (r4 == 0) goto L_0x00e4;
    L_0x00e1:
        r4.close();	 Catch:{ Exception -> 0x00e4 }
    L_0x00e4:
        if (r6 == 0) goto L_0x0102;
    L_0x00e6:
        r5 = new com.baidu.location.BDLocation;
        r5.<init>();
        r2 = (float) r3;
        r5.setRadius(r2);
        r5.setLatitude(r7);
        r5.setLongitude(r9);
        r2 = "cl";
        r5.setNetworkLocationType(r2);
        r2 = 66;
        r5.setLocType(r2);
        r16 = r5;
        return r16;
    L_0x0102:
        r16 = 0;
        return r16;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.d.c.a(java.lang.Long):com.baidu.location.BDLocation");
    }

    /* JADX WARNING: Removed duplicated region for block: B:152:0x0324 A:{SYNTHETIC, Splitter:B:152:0x0324} */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0301 A:{PHI: r12 , Splitter:B:61:0x0178, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0324 A:{SYNTHETIC, Splitter:B:152:0x0324} */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0301 A:{PHI: r12 , Splitter:B:61:0x0178, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0324 A:{SYNTHETIC, Splitter:B:152:0x0324} */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0301 A:{PHI: r12 , Splitter:B:61:0x0178, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0301 A:{PHI: r12 , Splitter:B:61:0x0178, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0303 A:{PHI: r4 , Splitter:B:22:0x00a8, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0124 A:{Splitter:B:35:0x00f2, ExcHandler: all (r0_0 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0303 A:{PHI: r4 , Splitter:B:22:0x00a8, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:40:0x0124, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:41:0x0125, code skipped:
            r1 = r0;
            r12 = r4;
     */
    /* JADX WARNING: Missing block: B:42:0x0129, code skipped:
            r12 = r4;
            r15 = r11;
            r40 = r15;
            r13 = 0.0d;
            r20 = 0.0d;
     */
    /* JADX WARNING: Missing block: B:75:0x01ff, code skipped:
            r12 = r4;
            r35 = null;
     */
    /* JADX WARNING: Missing block: B:119:0x02bc, code skipped:
            r40 = r1;
     */
    /* JADX WARNING: Missing block: B:134:0x02f8, code skipped:
            if (a(r18, r16, r20, r13) > 10000.0d) goto L_0x0317;
     */
    /* JADX WARNING: Missing block: B:135:0x02fb, code skipped:
            r40 = r11;
     */
    /* JADX WARNING: Missing block: B:138:0x0301, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:139:0x0303, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:140:0x0304, code skipped:
            r12 = r4;
     */
    /* JADX WARNING: Missing block: B:141:0x0305, code skipped:
            r1 = r0;
     */
    /* JADX WARNING: Missing block: B:142:0x0307, code skipped:
            r12 = r4;
            r35 = null;
     */
    /* JADX WARNING: Missing block: B:144:0x030a, code skipped:
            r36 = 0.0d;
     */
    /* JADX WARNING: Missing block: B:148:0x0319, code skipped:
            if (r12 == null) goto L_0x033a;
     */
    /* JADX WARNING: Missing block: B:153:?, code skipped:
            r12.close();
     */
    /* JADX WARNING: Missing block: B:160:0x0335, code skipped:
            if (r12 == null) goto L_0x033a;
     */
    /* JADX WARNING: Missing block: B:162:?, code skipped:
            r12.close();
     */
    private com.baidu.location.BDLocation a(java.util.LinkedHashMap<java.lang.String, java.lang.Integer> r44, com.baidu.location.BDLocation r45, int r46) {
        /*
        r43 = this;
        r10 = r43;
        r1 = r10.o;
        r11 = 0;
        r1.setLength(r11);
        r12 = 1;
        if (r45 == 0) goto L_0x0019;
    L_0x000b:
        r2 = r45.getLatitude();
        r4 = r45.getLongitude();
        r18 = r2;
        r16 = r4;
        r15 = r12;
        goto L_0x001e;
    L_0x0019:
        r15 = r11;
        r16 = 0;
        r18 = 0;
    L_0x001e:
        r1 = new java.lang.StringBuffer;
        r1.<init>();
        r2 = r44.entrySet();
        r2 = r2.iterator();
        r3 = r11;
        r4 = r12;
    L_0x002d:
        r5 = r44.size();
        r8 = 30;
        r5 = java.lang.Math.min(r5, r8);
        if (r3 >= r5) goto L_0x007a;
    L_0x0039:
        r5 = r2.next();
        r5 = (java.util.Map.Entry) r5;
        r6 = r5.getKey();
        r6 = (java.lang.String) r6;
        r5 = r5.getValue();
        r5 = (java.lang.Integer) r5;
        r7 = r5.intValue();
        if (r7 >= 0) goto L_0x005a;
    L_0x0051:
        r5 = r5.intValue();
        r5 = -r5;
        r5 = java.lang.Integer.valueOf(r5);
    L_0x005a:
        r7 = com.baidu.location.Jni.encode3(r6);
        if (r7 != 0) goto L_0x0061;
    L_0x0060:
        goto L_0x0077;
    L_0x0061:
        r8 = r10.n;
        r8.put(r7, r6);
        if (r4 == 0) goto L_0x006a;
    L_0x0068:
        r4 = r11;
        goto L_0x006f;
    L_0x006a:
        r6 = 44;
        r1.append(r6);
    L_0x006f:
        r6 = r10.m;
        r6.put(r7, r5);
        r1.append(r7);
    L_0x0077:
        r3 = r3 + 1;
        goto L_0x002d;
    L_0x007a:
        r2 = java.util.Locale.US;
        r3 = "SELECT * FROM AP WHERE id IN (%s) AND timestamp+%d>%d;";
        r9 = 3;
        r4 = new java.lang.Object[r9];
        r4[r11] = r1;
        r1 = 7776000; // 0x76a700 float:1.0896497E-38 double:3.8418545E-317;
        r1 = java.lang.Integer.valueOf(r1);
        r4[r12] = r1;
        r5 = java.lang.System.currentTimeMillis();
        r20 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r5 = r5 / r20;
        r1 = java.lang.Long.valueOf(r5);
        r6 = 2;
        r4[r6] = r1;
        r1 = java.lang.String.format(r2, r3, r4);
        r7 = 0;
        r2 = r10.h;	 Catch:{ Exception -> 0x0328, all -> 0x031c }
        r4 = r2.rawQuery(r1, r7);	 Catch:{ Exception -> 0x0328, all -> 0x031c }
        if (r4 == 0) goto L_0x030d;
    L_0x00a8:
        r1 = r4.moveToFirst();	 Catch:{ Exception -> 0x0307, all -> 0x0303 }
        if (r1 == 0) goto L_0x030d;
    L_0x00ae:
        r5 = new java.util.ArrayList;	 Catch:{ Exception -> 0x0307, all -> 0x0303 }
        r5.<init>();	 Catch:{ Exception -> 0x0307, all -> 0x0303 }
    L_0x00b3:
        r1 = r4.isAfterLast();	 Catch:{ Exception -> 0x0307, all -> 0x0303 }
        r22 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;
        r24 = 4666723172467343360; // 0x40c3880000000000 float:0.0 double:10000.0;
        if (r1 != 0) goto L_0x020d;
    L_0x00c0:
        r2 = r4.getLong(r11);	 Catch:{ Exception -> 0x0203, all -> 0x0303 }
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ Exception -> 0x0203, all -> 0x0303 }
        r28 = r4.getDouble(r12);	 Catch:{ Exception -> 0x0203, all -> 0x0303 }
        r30 = r4.getDouble(r6);	 Catch:{ Exception -> 0x0203, all -> 0x0303 }
        r3 = r4.getInt(r9);	 Catch:{ Exception -> 0x0203, all -> 0x0303 }
        r1 = 4;
        r32 = r4.getDouble(r1);	 Catch:{ Exception -> 0x0203, all -> 0x0303 }
        r1 = 5;
        r1 = r4.getInt(r1);	 Catch:{ Exception -> 0x0203, all -> 0x0303 }
        r7 = r10.l;	 Catch:{ Exception -> 0x01ff, all -> 0x0303 }
        r7.add(r2);	 Catch:{ Exception -> 0x01ff, all -> 0x0303 }
        r7 = 604800; // 0x93a80 float:8.47505E-40 double:2.98811E-318;
        r1 = r1 + r7;
        r13 = (long) r1;	 Catch:{ Exception -> 0x01ff, all -> 0x0303 }
        r38 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x01ff, all -> 0x0303 }
        r38 = r38 / r20;
        r1 = (r13 > r38 ? 1 : (r13 == r38 ? 0 : -1));
        if (r1 >= 0) goto L_0x0135;
    L_0x00f2:
        r1 = r10.o;	 Catch:{ Exception -> 0x0129, all -> 0x0124 }
        r1 = r1.length();	 Catch:{ Exception -> 0x0129, all -> 0x0124 }
        if (r1 <= 0) goto L_0x0101;
    L_0x00fa:
        r1 = r10.o;	 Catch:{ Exception -> 0x0129, all -> 0x0124 }
        r7 = ",";
        r1.append(r7);	 Catch:{ Exception -> 0x0129, all -> 0x0124 }
    L_0x0101:
        r1 = r10.o;	 Catch:{ Exception -> 0x0129, all -> 0x0124 }
        r7 = java.util.Locale.US;	 Catch:{ Exception -> 0x0129, all -> 0x0124 }
        r13 = "(%d,\"%s\",%d)";
        r14 = new java.lang.Object[r9];	 Catch:{ Exception -> 0x0129, all -> 0x0124 }
        r14[r11] = r2;	 Catch:{ Exception -> 0x0129, all -> 0x0124 }
        r8 = r10.n;	 Catch:{ Exception -> 0x0129, all -> 0x0124 }
        r8 = r8.get(r2);	 Catch:{ Exception -> 0x0129, all -> 0x0124 }
        r14[r12] = r8;	 Catch:{ Exception -> 0x0129, all -> 0x0124 }
        r8 = 100000; // 0x186a0 float:1.4013E-40 double:4.94066E-319;
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ Exception -> 0x0129, all -> 0x0124 }
        r14[r6] = r8;	 Catch:{ Exception -> 0x0129, all -> 0x0124 }
        r7 = java.lang.String.format(r7, r13, r14);	 Catch:{ Exception -> 0x0129, all -> 0x0124 }
        r1.append(r7);	 Catch:{ Exception -> 0x0129, all -> 0x0124 }
        goto L_0x0135;
    L_0x0124:
        r0 = move-exception;
        r1 = r0;
        r12 = r4;
        goto L_0x0322;
    L_0x0129:
        r12 = r4;
        r15 = r11;
        r40 = r15;
        r13 = 0;
        r20 = 0;
    L_0x0131:
        r35 = 0;
        goto L_0x0335;
    L_0x0135:
        r36 = 0;
        r1 = (r32 > r36 ? 1 : (r32 == r36 ? 0 : -1));
        if (r1 > 0) goto L_0x014c;
    L_0x013b:
        r4.moveToNext();	 Catch:{ Exception -> 0x0143, all -> 0x0124 }
        r7 = 0;
        r8 = 30;
        goto L_0x00b3;
    L_0x0143:
        r12 = r4;
        r15 = r11;
        r40 = r15;
        r13 = r36;
        r20 = r13;
        goto L_0x0131;
    L_0x014c:
        r1 = (r28 > r36 ? 1 : (r28 == r36 ? 0 : -1));
        if (r1 <= 0) goto L_0x01e3;
    L_0x0150:
        r1 = (r30 > r36 ? 1 : (r30 == r36 ? 0 : -1));
        if (r1 <= 0) goto L_0x01e3;
    L_0x0154:
        if (r3 <= 0) goto L_0x01e3;
    L_0x0156:
        r1 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        if (r3 < r1) goto L_0x015c;
    L_0x015a:
        goto L_0x01e3;
    L_0x015c:
        if (r15 != r12) goto L_0x0181;
    L_0x015e:
        r1 = r10;
        r13 = r2;
        r14 = r3;
        r8 = 100;
        r2 = r18;
        r7 = r4;
        r11 = r5;
        r4 = r16;
        r26 = r6;
        r12 = r7;
        r35 = 0;
        r6 = r30;
        r38 = r9;
        r41 = r15;
        r15 = 30;
        r8 = r28;
        r1 = r1.a(r2, r4, r6, r8);	 Catch:{ Exception -> 0x0206, all -> 0x0301 }
        r3 = (r1 > r24 ? 1 : (r1 == r24 ? 0 : -1));
        if (r3 <= 0) goto L_0x018f;
    L_0x0180:
        goto L_0x01df;
    L_0x0181:
        r13 = r2;
        r14 = r3;
        r12 = r4;
        r11 = r5;
        r26 = r6;
        r38 = r9;
        r41 = r15;
        r15 = 30;
        r35 = 0;
    L_0x018f:
        r1 = r10.m;	 Catch:{ Exception -> 0x0206, all -> 0x0301 }
        r1 = r1.get(r13);	 Catch:{ Exception -> 0x0206, all -> 0x0301 }
        r1 = (java.lang.Integer) r1;	 Catch:{ Exception -> 0x0206, all -> 0x0301 }
        r1 = r1.intValue();	 Catch:{ Exception -> 0x0206, all -> 0x0301 }
        r1 = java.lang.Math.max(r15, r1);	 Catch:{ Exception -> 0x0206, all -> 0x0301 }
        r13 = 100;
        r1 = java.lang.Math.min(r13, r1);	 Catch:{ Exception -> 0x0206, all -> 0x0301 }
        r2 = 4632233691727265792; // 0x4049000000000000 float:0.0 double:50.0;
        r4 = 70;
        if (r1 <= r4) goto L_0x01b4;
    L_0x01ab:
        r1 = r1 + -70;
        r4 = (double) r1;	 Catch:{ Exception -> 0x0206, all -> 0x0301 }
        r6 = 4629137466983448576; // 0x403e000000000000 float:0.0 double:30.0;
        r4 = r4 / r6;
    L_0x01b1:
        r22 = r22 + r4;
        goto L_0x01b9;
    L_0x01b4:
        r1 = r1 + -70;
        r4 = (double) r1;	 Catch:{ Exception -> 0x0206, all -> 0x0301 }
        r4 = r4 / r2;
        goto L_0x01b1;
    L_0x01b9:
        r4 = (double) r14;	 Catch:{ Exception -> 0x0206, all -> 0x0301 }
        r1 = java.lang.Math.max(r2, r4);	 Catch:{ Exception -> 0x0206, all -> 0x0301 }
        r3 = 4603579539098121011; // 0x3fe3333333333333 float:4.172325E-8 double:0.6;
        r1 = java.lang.Math.pow(r1, r3);	 Catch:{ Exception -> 0x0206, all -> 0x0301 }
        r3 = -4634023872579145564; // 0xbfb0a3d70a3d70a4 float:9.121204E-33 double:-0.065;
        r3 = r3 * r1;
        r3 = r3 * r22;
        r32 = java.lang.Math.exp(r3);	 Catch:{ Exception -> 0x0206, all -> 0x0301 }
        r1 = new com.baidu.location.d.c$a;	 Catch:{ Exception -> 0x0206, all -> 0x0301 }
        r34 = 0;
        r27 = r1;
        r27.<init>(r28, r30, r32, r34);	 Catch:{ Exception -> 0x0206, all -> 0x0301 }
        r11.add(r1);	 Catch:{ Exception -> 0x0206, all -> 0x0301 }
    L_0x01df:
        r12.moveToNext();	 Catch:{ Exception -> 0x0206, all -> 0x0301 }
        goto L_0x01f0;
    L_0x01e3:
        r12 = r4;
        r11 = r5;
        r26 = r6;
        r38 = r9;
        r41 = r15;
        r15 = 30;
        r35 = 0;
        goto L_0x01df;
    L_0x01f0:
        r5 = r11;
        r4 = r12;
        r8 = r15;
        r6 = r26;
        r7 = r35;
        r9 = r38;
        r15 = r41;
        r11 = 0;
        r12 = 1;
        goto L_0x00b3;
    L_0x01ff:
        r12 = r4;
        r35 = 0;
        goto L_0x0206;
    L_0x0203:
        r12 = r4;
        r35 = r7;
    L_0x0206:
        r13 = 0;
        r15 = 0;
        r20 = 0;
        goto L_0x0333;
    L_0x020d:
        r12 = r4;
        r11 = r5;
        r35 = r7;
        r41 = r15;
        r13 = 100;
        r15 = r8;
        r1 = 4652007308841189376; // 0x408f400000000000 float:0.0 double:1000.0;
        r10.a(r11, r1);	 Catch:{ Exception -> 0x030a, all -> 0x0301 }
        r1 = 0;
        r2 = 0;
        r4 = 0;
        r6 = 0;
    L_0x0225:
        r8 = r11.size();	 Catch:{ Exception -> 0x030a, all -> 0x0301 }
        if (r1 >= r8) goto L_0x0250;
    L_0x022b:
        r8 = r11.get(r1);	 Catch:{ Exception -> 0x0206, all -> 0x0301 }
        r8 = (com.baidu.location.d.c.a) r8;	 Catch:{ Exception -> 0x0206, all -> 0x0301 }
        r13 = r8.c;	 Catch:{ Exception -> 0x0206, all -> 0x0301 }
        r20 = 0;
        r9 = (r13 > r20 ? 1 : (r13 == r20 ? 0 : -1));
        if (r9 > 0) goto L_0x023a;
    L_0x0239:
        goto L_0x0249;
    L_0x023a:
        r13 = r8.a;	 Catch:{ Exception -> 0x0206, all -> 0x0301 }
        r9 = r8.c;	 Catch:{ Exception -> 0x0206, all -> 0x0301 }
        r13 = r13 * r9;
        r4 = r4 + r13;
        r9 = r8.b;	 Catch:{ Exception -> 0x0206, all -> 0x0301 }
        r13 = r8.c;	 Catch:{ Exception -> 0x0206, all -> 0x0301 }
        r9 = r9 * r13;
        r6 = r6 + r9;
        r8 = r8.c;	 Catch:{ Exception -> 0x0206, all -> 0x0301 }
        r2 = r2 + r8;
    L_0x0249:
        r1 = r1 + 1;
        r10 = r43;
        r13 = 100;
        goto L_0x0225;
    L_0x0250:
        r36 = 0;
        r1 = (r2 > r36 ? 1 : (r2 == r36 ? 0 : -1));
        if (r1 <= 0) goto L_0x02ab;
    L_0x0256:
        r1 = (r4 > r36 ? 1 : (r4 == r36 ? 0 : -1));
        if (r1 <= 0) goto L_0x02ab;
    L_0x025a:
        r1 = (r6 > r36 ? 1 : (r6 == r36 ? 0 : -1));
        if (r1 <= 0) goto L_0x02ab;
    L_0x025e:
        r13 = r4 / r2;
        r20 = r6 / r2;
        r1 = 0;
        r10 = 0;
    L_0x0264:
        r2 = r11.size();	 Catch:{ Exception -> 0x02a6, all -> 0x0301 }
        if (r10 >= r2) goto L_0x0290;
    L_0x026a:
        r8 = (double) r1;	 Catch:{ Exception -> 0x02a6, all -> 0x0301 }
        r1 = r11.get(r10);	 Catch:{ Exception -> 0x02a6, all -> 0x0301 }
        r1 = (com.baidu.location.d.c.a) r1;	 Catch:{ Exception -> 0x02a6, all -> 0x0301 }
        r6 = r1.a;	 Catch:{ Exception -> 0x02a6, all -> 0x0301 }
        r1 = r11.get(r10);	 Catch:{ Exception -> 0x02a6, all -> 0x0301 }
        r1 = (com.baidu.location.d.c.a) r1;	 Catch:{ Exception -> 0x02a6, all -> 0x0301 }
        r4 = r1.b;	 Catch:{ Exception -> 0x02a6, all -> 0x0301 }
        r1 = r43;
        r2 = r13;
        r26 = r4;
        r4 = r20;
        r28 = r8;
        r8 = r26;
        r1 = r1.a(r2, r4, r6, r8);	 Catch:{ Exception -> 0x02a6, all -> 0x0301 }
        r8 = r28 + r1;
        r1 = (float) r8;	 Catch:{ Exception -> 0x02a6, all -> 0x0301 }
        r10 = r10 + 1;
        goto L_0x0264;
    L_0x0290:
        r2 = r11.size();	 Catch:{ Exception -> 0x02a6, all -> 0x0301 }
        r2 = (float) r2;	 Catch:{ Exception -> 0x02a6, all -> 0x0301 }
        r1 = r1 / r2;
        r1 = java.lang.Math.round(r1);	 Catch:{ Exception -> 0x02a6, all -> 0x0301 }
        if (r1 >= r15) goto L_0x029e;
    L_0x029c:
        r1 = 1;
        goto L_0x02b1;
    L_0x029e:
        r2 = 100;
        if (r2 >= r1) goto L_0x02a4;
    L_0x02a2:
        r15 = r2;
        goto L_0x029c;
    L_0x02a4:
        r15 = r1;
        goto L_0x029c;
    L_0x02a6:
        r15 = 0;
        r40 = 1;
        goto L_0x0335;
    L_0x02ab:
        r13 = r36;
        r20 = r13;
        r1 = 0;
        r15 = 0;
    L_0x02b1:
        if (r41 != 0) goto L_0x02c0;
    L_0x02b3:
        r2 = r11.size();	 Catch:{ Exception -> 0x02bc, all -> 0x0301 }
        r3 = 1;
        if (r2 > r3) goto L_0x02c0;
    L_0x02ba:
        r1 = 0;
        goto L_0x02c0;
    L_0x02bc:
        r40 = r1;
        goto L_0x0335;
    L_0x02c0:
        r2 = r11.size();	 Catch:{ Exception -> 0x02bc, all -> 0x0301 }
        r3 = r46;
        if (r2 >= r3) goto L_0x02e1;
    L_0x02c8:
        r2 = r11.size();	 Catch:{ Exception -> 0x02bc, all -> 0x0301 }
        r2 = (double) r2;	 Catch:{ Exception -> 0x02bc, all -> 0x0301 }
        r22 = r22 * r2;
        r2 = r44.size();	 Catch:{ Exception -> 0x02bc, all -> 0x0301 }
        r2 = (double) r2;
        r22 = r22 / r2;
        r2 = 4602678819172646912; // 0x3fe0000000000000 float:0.0 double:0.5;
        r4 = (r22 > r2 ? 1 : (r22 == r2 ? 0 : -1));
        if (r4 >= 0) goto L_0x02e1;
    L_0x02dc:
        r1 = r41;
        r2 = 1;
        r11 = 0;
        goto L_0x02e5;
    L_0x02e1:
        r11 = r1;
        r1 = r41;
        r2 = 1;
    L_0x02e5:
        if (r1 != r2) goto L_0x02fe;
    L_0x02e7:
        if (r11 != r2) goto L_0x02fe;
    L_0x02e9:
        r1 = r43;
        r2 = r18;
        r4 = r16;
        r6 = r20;
        r8 = r13;
        r1 = r1.a(r2, r4, r6, r8);	 Catch:{ Exception -> 0x02fb, all -> 0x0301 }
        r3 = (r1 > r24 ? 1 : (r1 == r24 ? 0 : -1));
        if (r3 <= 0) goto L_0x02fe;
    L_0x02fa:
        goto L_0x0317;
    L_0x02fb:
        r40 = r11;
        goto L_0x0335;
    L_0x02fe:
        r40 = r11;
        goto L_0x0319;
    L_0x0301:
        r0 = move-exception;
        goto L_0x0305;
    L_0x0303:
        r0 = move-exception;
        r12 = r4;
    L_0x0305:
        r1 = r0;
        goto L_0x0322;
    L_0x0307:
        r12 = r4;
        r35 = r7;
    L_0x030a:
        r36 = 0;
        goto L_0x032e;
    L_0x030d:
        r12 = r4;
        r35 = r7;
        r36 = 0;
        r13 = r36;
        r20 = r13;
        r15 = 0;
    L_0x0317:
        r40 = 0;
    L_0x0319:
        if (r12 == 0) goto L_0x033a;
    L_0x031b:
        goto L_0x0337;
    L_0x031c:
        r0 = move-exception;
        r35 = r7;
        r1 = r0;
        r12 = r35;
    L_0x0322:
        if (r12 == 0) goto L_0x0327;
    L_0x0324:
        r12.close();	 Catch:{ Exception -> 0x0327 }
    L_0x0327:
        throw r1;
    L_0x0328:
        r35 = r7;
        r36 = 0;
        r12 = r35;
    L_0x032e:
        r13 = r36;
        r20 = r13;
        r15 = 0;
    L_0x0333:
        r40 = 0;
    L_0x0335:
        if (r12 == 0) goto L_0x033a;
    L_0x0337:
        r12.close();	 Catch:{ Exception -> 0x033a }
    L_0x033a:
        r1 = r20;
        if (r40 == 0) goto L_0x0359;
    L_0x033e:
        r7 = new com.baidu.location.BDLocation;
        r7.<init>();
        r3 = (float) r15;
        r7.setRadius(r3);
        r7.setLatitude(r1);
        r7.setLongitude(r13);
        r1 = "wf";
        r7.setNetworkLocationType(r1);
        r1 = 66;
        r7.setLocType(r1);
        r35 = r7;
    L_0x0359:
        return r35;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.d.c.a(java.util.LinkedHashMap, com.baidu.location.BDLocation, int):com.baidu.location.BDLocation");
    }

    private void a(BDLocation bDLocation, BDLocation bDLocation2, BDLocation bDLocation3, String str, Long l) {
        if (bDLocation != null && bDLocation.getLocType() == BDLocation.TypeNetWorkLocation) {
            String format;
            String format2;
            if (!(bDLocation2 == null || bDLocation.getNetworkLocationType() == null || !bDLocation.getNetworkLocationType().equals("cl"))) {
                if (a(bDLocation2.getLatitude(), bDLocation2.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude()) > 300.0d) {
                    format = String.format(Locale.US, "UPDATE CL SET cl = 0 WHERE id = %d;", new Object[]{l});
                    format2 = String.format(Locale.US, "INSERT OR REPLACE INTO CL VALUES (%d,\"%s\",%d);", new Object[]{l, str, Integer.valueOf(100000)});
                    try {
                        this.h.execSQL(format);
                        this.i.execSQL(format2);
                    } catch (Exception unused) {
                    }
                }
            }
            if (bDLocation3 != null && bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals("wf")) {
                if (a(bDLocation3.getLatitude(), bDLocation3.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude()) > 100.0d) {
                    try {
                        format = String.format("UPDATE AP SET cl = 0 WHERE id In (%s);", new Object[]{this.j.toString()});
                        format2 = String.format("INSERT OR REPLACE INTO AP VALUES %s;", new Object[]{this.k.toString()});
                        this.h.execSQL(format);
                        this.i.execSQL(format2);
                    } catch (Exception unused2) {
                    }
                }
            }
        }
    }

    private void a(String str, Long l, BDLocation bDLocation) {
        if (str != null) {
            if (bDLocation != null) {
                try {
                    this.h.execSQL(String.format(Locale.US, "UPDATE CL SET frequency=frequency+1 WHERE id = %d;", new Object[]{l}));
                } catch (Exception unused) {
                }
            } else {
                String format = String.format(Locale.US, "INSERT OR IGNORE INTO CL VALUES (%d,\"%s\",0);", new Object[]{l, str});
                String format2 = String.format(Locale.US, "UPDATE CL SET frequency=frequency+1 WHERE id = %d;", new Object[]{l});
                this.i.execSQL(format);
                this.i.execSQL(format2);
            }
            if (this.p) {
                try {
                    this.i.execSQL(String.format(Locale.US, "INSERT OR IGNORE INTO CL VALUES (%d,\"%s\",%d);", new Object[]{l, str, Integer.valueOf(100000)}));
                } catch (Exception unused2) {
                }
            }
        }
    }

    private void a(String str, String str2, String str3) {
        this.f.a(str, str2, str3);
    }

    private void a(LinkedHashMap<String, Integer> linkedHashMap) {
        if (linkedHashMap != null && linkedHashMap.size() > 0) {
            this.j = new StringBuffer();
            this.k = new StringBuffer();
            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer stringBuffer2 = new StringBuffer();
            if (!(this.m == null || this.m.keySet() == null)) {
                int i = 1;
                int i2 = i;
                for (Long l : this.m.keySet()) {
                    try {
                        String str;
                        if (this.l.contains(l)) {
                            if (i != 0) {
                                i = 0;
                            } else {
                                this.j.append(',');
                                this.k.append(',');
                            }
                            this.j.append(l);
                            str = (String) this.n.get(l);
                            StringBuffer stringBuffer3 = this.k;
                            stringBuffer3.append('(');
                            stringBuffer3.append(l);
                            stringBuffer3.append(',');
                            stringBuffer3.append('\"');
                            stringBuffer3.append(str);
                            stringBuffer3.append('\"');
                            stringBuffer3.append(',');
                            stringBuffer3.append(100000);
                            stringBuffer3.append(')');
                        } else {
                            str = (String) this.n.get(l);
                            if (i2 != 0) {
                                i2 = 0;
                            } else {
                                stringBuffer.append(',');
                                stringBuffer2.append(',');
                            }
                            stringBuffer.append(l);
                            stringBuffer2.append('(');
                            stringBuffer2.append(l);
                            stringBuffer2.append(',');
                            stringBuffer2.append('\"');
                            stringBuffer2.append(str);
                            stringBuffer2.append('\"');
                            stringBuffer2.append(",0)");
                        }
                    } catch (Exception unused) {
                    }
                }
            }
            try {
                this.h.execSQL(String.format(Locale.US, "UPDATE AP SET frequency=frequency+1 WHERE id IN(%s)", new Object[]{this.j.toString()}));
            } catch (Exception unused2) {
            }
            if (this.o != null && this.o.length() > 0) {
                if (stringBuffer2.length() > 0) {
                    stringBuffer2.append(",");
                }
                stringBuffer2.append(this.o);
            }
            try {
                String format = String.format("INSERT OR IGNORE INTO AP VALUES %s;", new Object[]{stringBuffer2.toString()});
                String format2 = String.format("UPDATE AP SET frequency=frequency+1 WHERE id in (%s);", new Object[]{stringBuffer.toString()});
                if (stringBuffer2.length() > 0) {
                    this.i.execSQL(format);
                }
                if (stringBuffer.length() > 0) {
                    this.i.execSQL(format2);
                }
            } catch (Exception unused3) {
            }
        }
    }

    private void a(String[] strArr) {
        this.a.l().a(strArr);
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x017c  */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x01ea  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01cf  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x017c  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0195 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01cf  */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x01ea  */
    /* JADX WARNING: Missing block: B:46:0x0102, code skipped:
            if (r17 != null) goto L_0x010c;
     */
    /* JADX WARNING: Missing block: B:49:0x010a, code skipped:
            if (r17 != null) goto L_0x010c;
     */
    /* JADX WARNING: Missing block: B:50:0x010c, code skipped:
            r6 = r5;
            r5 = r13;
            r11 = r17;
     */
    public android.database.Cursor a(com.baidu.location.d.i.a r22) {
        /*
        r21 = this;
        r9 = r21;
        r0 = r22;
        r1 = new com.baidu.location.BDLocation;
        r1.<init>();
        r2 = 67;
        r1.setLocType(r2);
        r2 = r0.c;
        if (r2 == 0) goto L_0x01fe;
    L_0x0012:
        r2 = r0.b;
        r8 = r0.i;
        r3 = r0.f;
        r6 = r0.g;
        r4 = -9223372036854775808;
        r4 = java.lang.Long.valueOf(r4);
        if (r2 == 0) goto L_0x0036;
    L_0x0022:
        r7 = r9.h;
        if (r7 == 0) goto L_0x0036;
    L_0x0026:
        r4 = com.baidu.location.Jni.encode3(r2);
        if (r4 == 0) goto L_0x0036;
    L_0x002c:
        r7 = r9.a(r4);
        r20 = r7;
        r7 = r4;
        r4 = r20;
        goto L_0x0038;
    L_0x0036:
        r7 = r4;
        r4 = 0;
    L_0x0038:
        if (r8 == 0) goto L_0x0059;
    L_0x003a:
        r10 = r8.size();
        if (r10 <= 0) goto L_0x0059;
    L_0x0040:
        r10 = r9.h;
        if (r10 == 0) goto L_0x0059;
    L_0x0044:
        r10 = r9.m;
        r10.clear();
        r10 = r9.l;
        r10.clear();
        r10 = r9.n;
        r10.clear();
        r3 = r9.a(r8, r4, r3);
        r10 = r3;
        goto L_0x005a;
    L_0x0059:
        r10 = 0;
    L_0x005a:
        r3 = 1;
        if (r4 == 0) goto L_0x0094;
    L_0x005d:
        r12 = r4.getLongitude();
        r12 = java.lang.Double.valueOf(r12);
        r13 = r4.getLatitude();
        r13 = java.lang.Double.valueOf(r13);
        r14 = r4.getLongitude();
        r16 = r6;
        r5 = r4.getLatitude();
        r11 = "bd09ll2gcj";
        r5 = com.baidu.location.Jni.coorEncrypt(r14, r5, r11);
        r6 = "gcj";
        r4.setCoorType(r6);
        r14 = r5[r3];
        r4.setLatitude(r14);
        r6 = 0;
        r14 = r5[r6];
        r4.setLongitude(r14);
        r5 = "cl";
        r4.setNetworkLocationType(r5);
        r5 = r12;
        goto L_0x0098;
    L_0x0094:
        r16 = r6;
        r5 = 0;
        r13 = 0;
    L_0x0098:
        if (r10 == 0) goto L_0x00d1;
    L_0x009a:
        r11 = r10.getLongitude();
        r6 = java.lang.Double.valueOf(r11);
        r11 = r10.getLatitude();
        r11 = java.lang.Double.valueOf(r11);
        r14 = r10.getLongitude();
        r17 = r4;
        r3 = r10.getLatitude();
        r12 = "bd09ll2gcj";
        r3 = com.baidu.location.Jni.coorEncrypt(r14, r3, r12);
        r4 = "gcj";
        r10.setCoorType(r4);
        r4 = 1;
        r14 = r3[r4];
        r10.setLatitude(r14);
        r4 = 0;
        r14 = r3[r4];
        r10.setLongitude(r14);
        r3 = "wf";
        r10.setNetworkLocationType(r3);
        goto L_0x00d5;
    L_0x00d1:
        r17 = r4;
        r6 = 0;
        r11 = 0;
    L_0x00d5:
        if (r17 == 0) goto L_0x00db;
    L_0x00d7:
        if (r10 != 0) goto L_0x00db;
    L_0x00d9:
        r3 = 1;
        goto L_0x00e8;
    L_0x00db:
        if (r17 != 0) goto L_0x00e1;
    L_0x00dd:
        if (r10 == 0) goto L_0x00e1;
    L_0x00df:
        r3 = 2;
        goto L_0x00e8;
    L_0x00e1:
        if (r17 == 0) goto L_0x00e7;
    L_0x00e3:
        if (r10 == 0) goto L_0x00e7;
    L_0x00e5:
        r3 = 4;
        goto L_0x00e8;
    L_0x00e7:
        r3 = 0;
    L_0x00e8:
        r4 = r0.f;
        if (r4 <= 0) goto L_0x00ee;
    L_0x00ec:
        r4 = 1;
        goto L_0x00ef;
    L_0x00ee:
        r4 = 0;
    L_0x00ef:
        if (r8 == 0) goto L_0x00fa;
    L_0x00f1:
        r12 = r8.size();
        if (r12 > 0) goto L_0x00f8;
    L_0x00f7:
        goto L_0x00fa;
    L_0x00f8:
        r12 = 0;
        goto L_0x00fb;
    L_0x00fa:
        r12 = 1;
    L_0x00fb:
        if (r4 == 0) goto L_0x0105;
    L_0x00fd:
        if (r10 == 0) goto L_0x0100;
    L_0x00ff:
        goto L_0x0107;
    L_0x0100:
        if (r12 == 0) goto L_0x0111;
    L_0x0102:
        if (r17 == 0) goto L_0x0111;
    L_0x0104:
        goto L_0x010c;
    L_0x0105:
        if (r10 == 0) goto L_0x010a;
    L_0x0107:
        r5 = r11;
        r11 = r10;
        goto L_0x0114;
    L_0x010a:
        if (r17 == 0) goto L_0x0111;
    L_0x010c:
        r6 = r5;
        r5 = r13;
        r11 = r17;
        goto L_0x0114;
    L_0x0111:
        r11 = r1;
        r5 = 0;
        r6 = 0;
    L_0x0114:
        r12 = r0.e;
        if (r12 == 0) goto L_0x0142;
    L_0x0118:
        r12 = r9.a;
        r12 = r12.l();
        r12 = r12.l();
        if (r12 == 0) goto L_0x0142;
    L_0x0124:
        if (r5 == 0) goto L_0x0142;
    L_0x0126:
        if (r6 == 0) goto L_0x0142;
    L_0x0128:
        r12 = r9.a;
        r12 = r12.k();
        r13 = r6.doubleValue();
        r19 = r6;
        r18 = r7;
        r6 = r5.doubleValue();
        r6 = r12.a(r13, r6);
        r11.setAddr(r6);
        goto L_0x0146;
    L_0x0142:
        r19 = r6;
        r18 = r7;
    L_0x0146:
        if (r4 == 0) goto L_0x0157;
    L_0x0148:
        r6 = r0.e;
        if (r6 == 0) goto L_0x0157;
    L_0x014c:
        r6 = r11.getAddrStr();
        if (r6 != 0) goto L_0x0157;
    L_0x0152:
        r11 = r1;
        r3 = 0;
        r5 = 0;
        r6 = 0;
        goto L_0x015a;
    L_0x0157:
        r6 = r3;
        r3 = r19;
    L_0x015a:
        r7 = r0.d;
        if (r7 != 0) goto L_0x0162;
    L_0x015e:
        r7 = r0.h;
        if (r7 == 0) goto L_0x0180;
    L_0x0162:
        if (r5 == 0) goto L_0x0180;
    L_0x0164:
        if (r3 == 0) goto L_0x0180;
    L_0x0166:
        r7 = r9.a;
        r7 = r7.k();
        r12 = r3.doubleValue();
        r14 = r5.doubleValue();
        r5 = r7.b(r12, r14);
        r3 = r0.d;
        if (r3 == 0) goto L_0x0181;
    L_0x017c:
        r11.setPoiList(r5);
        goto L_0x0181;
    L_0x0180:
        r5 = 0;
    L_0x0181:
        if (r4 == 0) goto L_0x0191;
    L_0x0183:
        r3 = r0.d;
        if (r3 == 0) goto L_0x0191;
    L_0x0187:
        if (r5 == 0) goto L_0x018f;
    L_0x0189:
        r3 = r5.size();
        if (r3 > 0) goto L_0x0191;
    L_0x018f:
        r11 = r1;
        r6 = 0;
    L_0x0191:
        r3 = r0.h;
        if (r3 == 0) goto L_0x01b9;
    L_0x0195:
        if (r5 == 0) goto L_0x01b9;
    L_0x0197:
        r3 = r5.size();
        if (r3 <= 0) goto L_0x01b9;
    L_0x019d:
        r3 = java.util.Locale.CHINA;
        r7 = "在%s附近";
        r12 = 1;
        r12 = new java.lang.Object[r12];
        r13 = 0;
        r5 = r5.get(r13);
        r5 = (com.baidu.location.Poi) r5;
        r5 = r5.getName();
        r12[r13] = r5;
        r5 = java.lang.String.format(r3, r7, r12);
        r11.setLocationDescribe(r5);
        goto L_0x01bb;
    L_0x01b9:
        r13 = 0;
        r5 = 0;
    L_0x01bb:
        if (r4 == 0) goto L_0x01c5;
    L_0x01bd:
        r3 = r0.h;
        if (r3 == 0) goto L_0x01c5;
    L_0x01c1:
        if (r5 != 0) goto L_0x01c5;
    L_0x01c3:
        r11 = r1;
        goto L_0x01c6;
    L_0x01c5:
        r13 = r6;
    L_0x01c6:
        r1 = new java.lang.StringBuffer;
        r1.<init>();
        r3 = r0.a;
        if (r3 == 0) goto L_0x01ea;
    L_0x01cf:
        r3 = r0.a;
        r1.append(r3);
        r5 = r17;
        r0 = com.baidu.location.d.i.a(r10, r5, r0);
        r1.append(r0);
        r0 = com.baidu.location.d.i.a(r11, r13);
        r1.append(r0);
        r0 = r1.toString();
        r7 = r0;
        goto L_0x01ed;
    L_0x01ea:
        r5 = r17;
        r7 = 0;
    L_0x01ed:
        r12 = new com.baidu.location.d.d;
        r0 = r12;
        r1 = r9;
        r3 = r18;
        r4 = r5;
        r5 = r10;
        r6 = r16;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8);
        r12.start();
        r1 = r11;
    L_0x01fe:
        r0 = com.baidu.location.d.i.a(r1);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.d.c.a(com.baidu.location.d.i$a):android.database.Cursor");
    }

    /* Access modifiers changed, original: 0000 */
    public SQLiteDatabase a() {
        return this.i;
    }

    /* Access modifiers changed, original: 0000 */
    public void b() {
        this.g.b();
    }
}
