package com.baidu.location.a;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import com.alibaba.wireless.security.SecExceptionCode;
import com.baidu.location.Jni;
import com.baidu.location.g.e;
import com.baidu.location.g.j;
import com.umeng.commonsdk.framework.c;
import java.io.File;
import java.util.HashMap;
import org.json.JSONObject;

public class h {
    private static Object c = new Object();
    private static h d;
    private static final String e;
    a a = null;
    a b = null;
    private SQLiteDatabase f = null;
    private boolean g = false;
    private String h = null;
    private int i = -2;

    class a extends e {
        private String b;
        private String c;
        private boolean d;
        private boolean e;

        a() {
            this.b = null;
            this.c = null;
            this.d = true;
            this.e = false;
            this.k = new HashMap();
        }

        public void a() {
            this.i = 1;
            this.h = j.d();
            String encodeTp4 = Jni.encodeTp4(this.c);
            this.c = null;
            this.k.put("bloc", encodeTp4);
        }

        public void a(String str, String str2) {
            if (!h.this.g) {
                h.this.g = true;
                this.b = str;
                this.c = str2;
                c(j.f);
            }
        }

        /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x00ad */
        /* JADX WARNING: Can't wrap try/catch for region: R(6:15|16|17|(1:19)|20|21) */
        public void a(boolean r9) {
            /*
            r8 = this;
            if (r9 == 0) goto L_0x00c8;
        L_0x0002:
            r9 = r8.j;
            if (r9 == 0) goto L_0x00c8;
        L_0x0006:
            r9 = r8.j;	 Catch:{ Exception -> 0x00d1 }
            r0 = r8.d;	 Catch:{ Exception -> 0x00d1 }
            if (r0 == 0) goto L_0x00d1;
        L_0x000c:
            r0 = new org.json.JSONObject;	 Catch:{ Exception -> 0x00d1 }
            r0.<init>(r9);	 Catch:{ Exception -> 0x00d1 }
            r9 = "content";
            r9 = r0.has(r9);	 Catch:{ Exception -> 0x00d1 }
            r1 = 0;
            if (r9 == 0) goto L_0x0021;
        L_0x001a:
            r9 = "content";
            r9 = r0.getJSONObject(r9);	 Catch:{ Exception -> 0x00d1 }
            goto L_0x0022;
        L_0x0021:
            r9 = r1;
        L_0x0022:
            if (r9 == 0) goto L_0x00d1;
        L_0x0024:
            r0 = "imo";
            r0 = r9.has(r0);	 Catch:{ Exception -> 0x00d1 }
            if (r0 == 0) goto L_0x00d1;
        L_0x002c:
            r0 = "imo";
            r0 = r9.getJSONObject(r0);	 Catch:{ Exception -> 0x00d1 }
            r2 = "mac";
            r0 = r0.getString(r2);	 Catch:{ Exception -> 0x00d1 }
            r0 = java.lang.Long.valueOf(r0);	 Catch:{ Exception -> 0x00d1 }
            r2 = "imo";
            r9 = r9.getJSONObject(r2);	 Catch:{ Exception -> 0x00d1 }
            r2 = "mv";
            r9 = r9.getInt(r2);	 Catch:{ Exception -> 0x00d1 }
            r2 = r8.b;	 Catch:{ Exception -> 0x00d1 }
            r2 = com.baidu.location.Jni.encode3(r2);	 Catch:{ Exception -> 0x00d1 }
            r2 = r2.longValue();	 Catch:{ Exception -> 0x00d1 }
            r4 = r0.longValue();	 Catch:{ Exception -> 0x00d1 }
            r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
            if (r6 != 0) goto L_0x00d1;
        L_0x005a:
            r2 = new android.content.ContentValues;	 Catch:{ Exception -> 0x00d1 }
            r2.<init>();	 Catch:{ Exception -> 0x00d1 }
            r3 = "tt";
            r4 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00d1 }
            r6 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
            r4 = r4 / r6;
            r4 = (int) r4;	 Catch:{ Exception -> 0x00d1 }
            r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x00d1 }
            r2.put(r3, r4);	 Catch:{ Exception -> 0x00d1 }
            r3 = "hst";
            r4 = java.lang.Integer.valueOf(r9);	 Catch:{ Exception -> 0x00d1 }
            r2.put(r3, r4);	 Catch:{ Exception -> 0x00d1 }
            r3 = com.baidu.location.a.h.this;	 Catch:{ Exception -> 0x00ad }
            r3 = r3.f;	 Catch:{ Exception -> 0x00ad }
            r4 = "hstdata";
            r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ad }
            r5.<init>();	 Catch:{ Exception -> 0x00ad }
            r6 = "id = \"";
            r5.append(r6);	 Catch:{ Exception -> 0x00ad }
            r5.append(r0);	 Catch:{ Exception -> 0x00ad }
            r6 = "\"";
            r5.append(r6);	 Catch:{ Exception -> 0x00ad }
            r5 = r5.toString();	 Catch:{ Exception -> 0x00ad }
            r3 = r3.update(r4, r2, r5, r1);	 Catch:{ Exception -> 0x00ad }
            if (r3 > 0) goto L_0x00ad;
        L_0x009d:
            r3 = "id";
            r2.put(r3, r0);	 Catch:{ Exception -> 0x00ad }
            r0 = com.baidu.location.a.h.this;	 Catch:{ Exception -> 0x00ad }
            r0 = r0.f;	 Catch:{ Exception -> 0x00ad }
            r3 = "hstdata";
            r0.insert(r3, r1, r2);	 Catch:{ Exception -> 0x00ad }
        L_0x00ad:
            r0 = new android.os.Bundle;	 Catch:{ Exception -> 0x00d1 }
            r0.<init>();	 Catch:{ Exception -> 0x00d1 }
            r1 = "mac";
            r2 = r8.b;	 Catch:{ Exception -> 0x00d1 }
            r2 = r2.getBytes();	 Catch:{ Exception -> 0x00d1 }
            r0.putByteArray(r1, r2);	 Catch:{ Exception -> 0x00d1 }
            r1 = "hotspot";
            r0.putInt(r1, r9);	 Catch:{ Exception -> 0x00d1 }
            r9 = com.baidu.location.a.h.this;	 Catch:{ Exception -> 0x00d1 }
            r9.a(r0);	 Catch:{ Exception -> 0x00d1 }
            goto L_0x00d1;
        L_0x00c8:
            r9 = r8.d;
            if (r9 == 0) goto L_0x00d1;
        L_0x00cc:
            r9 = com.baidu.location.a.h.this;
            r9.f();
        L_0x00d1:
            r9 = r8.k;
            if (r9 == 0) goto L_0x00da;
        L_0x00d5:
            r9 = r8.k;
            r9.clear();
        L_0x00da:
            r9 = com.baidu.location.a.h.this;
            r0 = 0;
            r9.g = r0;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.a.h$a.a(boolean):void");
        }
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(j.i());
        stringBuilder.append("/hst.db");
        e = stringBuilder.toString();
    }

    public static h a() {
        h hVar;
        synchronized (c) {
            if (d == null) {
                d = new h();
            }
            hVar = d;
        }
        return hVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004e  */
    private java.lang.String a(boolean r5) {
        /*
        r4 = this;
        r0 = com.baidu.location.e.b.a();
        r0 = r0.f();
        r1 = com.baidu.location.e.i.a();
        r1 = r1.p();
        r2 = new java.lang.StringBuffer;
        r3 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r2.<init>(r3);
        if (r0 == 0) goto L_0x0026;
    L_0x0019:
        r3 = r0.b();
        if (r3 == 0) goto L_0x0026;
    L_0x001f:
        r0 = r0.h();
        r2.append(r0);
    L_0x0026:
        if (r1 == 0) goto L_0x0039;
    L_0x0028:
        r0 = r1.a();
        r3 = 1;
        if (r0 <= r3) goto L_0x0039;
    L_0x002f:
        r0 = 15;
        r0 = r1.a(r0);
    L_0x0035:
        r2.append(r0);
        goto L_0x004c;
    L_0x0039:
        r0 = com.baidu.location.e.i.a();
        r0 = r0.m();
        if (r0 == 0) goto L_0x004c;
    L_0x0043:
        r0 = com.baidu.location.e.i.a();
        r0 = r0.m();
        goto L_0x0035;
    L_0x004c:
        if (r5 == 0) goto L_0x0053;
    L_0x004e:
        r5 = "&imo=1";
        r2.append(r5);
    L_0x0053:
        r5 = com.baidu.location.g.b.a();
        r0 = 0;
        r5 = r5.a(r0);
        r2.append(r5);
        r5 = com.baidu.location.a.a.a();
        r5 = r5.d();
        r2.append(r5);
        r5 = r2.toString();
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.a.h.a(boolean):java.lang.String");
    }

    private void a(Bundle bundle) {
        a.a().a(bundle, (int) SecExceptionCode.SEC_ERROR_DYN_ENC_INVALID_ENCRYPTED_DATA);
    }

    private void f() {
        Bundle bundle = new Bundle();
        bundle.putInt("hotspot", -1);
        a(bundle);
    }

    public void a(String str) {
        if (!this.g) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject jSONObject2 = jSONObject.has(c.a) ? jSONObject.getJSONObject(c.a) : null;
                if (jSONObject2 != null && jSONObject2.has("imo")) {
                    Long valueOf = Long.valueOf(jSONObject2.getJSONObject("imo").getString("mac"));
                    int i = jSONObject2.getJSONObject("imo").getInt("mv");
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("tt", Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
                    contentValues.put("hst", Integer.valueOf(i));
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("id = \"");
                    stringBuilder.append(valueOf);
                    stringBuilder.append("\"");
                    if (this.f.update("hstdata", contentValues, stringBuilder.toString(), null) <= 0) {
                        contentValues.put("id", valueOf);
                        this.f.insert("hstdata", null, contentValues);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public void b() {
        try {
            File file = new File(e);
            if (!file.exists()) {
                file.createNewFile();
            }
            if (file.exists()) {
                this.f = SQLiteDatabase.openOrCreateDatabase(file, null);
                this.f.execSQL("CREATE TABLE IF NOT EXISTS hstdata(id Long PRIMARY KEY,hst INT,tt INT);");
                this.f.setVersion(1);
            }
        } catch (Exception unused) {
            this.f = null;
        }
    }

    public void c() {
        if (this.f != null) {
            try {
                this.f.close();
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.f = null;
            }
            this.f = null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x0085 A:{SYNTHETIC, Splitter:B:45:0x0085} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x008f */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0092 A:{Catch:{ Exception -> 0x0095 }} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x008c A:{SYNTHETIC, Splitter:B:49:0x008c} */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0092 A:{Catch:{ Exception -> 0x0095 }} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x008c A:{SYNTHETIC, Splitter:B:49:0x008c} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:56:0x0095 */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:7|8|(2:12|(2:16|(6:24|25|26|(3:28|29|(5:31|32|33|34|(2:45|46)))|43|(0))(2:22|23)))|56|57|58|59) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:35|36|40|(0)|51|52) */
    public synchronized int d() {
        /*
        r8 = this;
        monitor-enter(r8);
        r0 = -3;
        r1 = r8.g;	 Catch:{ all -> 0x0099 }
        if (r1 == 0) goto L_0x0008;
    L_0x0006:
        monitor-exit(r8);
        return r0;
    L_0x0008:
        r1 = com.baidu.location.e.i.j();	 Catch:{ Exception -> 0x0095 }
        if (r1 == 0) goto L_0x0095;
    L_0x000e:
        r1 = r8.f;	 Catch:{ Exception -> 0x0095 }
        if (r1 == 0) goto L_0x0095;
    L_0x0012:
        r1 = com.baidu.location.e.i.a();	 Catch:{ Exception -> 0x0095 }
        r1 = r1.l();	 Catch:{ Exception -> 0x0095 }
        if (r1 == 0) goto L_0x0095;
    L_0x001c:
        r2 = r1.getBSSID();	 Catch:{ Exception -> 0x0095 }
        if (r2 == 0) goto L_0x0095;
    L_0x0022:
        r1 = r1.getBSSID();	 Catch:{ Exception -> 0x0095 }
        r2 = ":";
        r3 = "";
        r1 = r1.replace(r2, r3);	 Catch:{ Exception -> 0x0095 }
        r2 = com.baidu.location.Jni.encode3(r1);	 Catch:{ Exception -> 0x0095 }
        r3 = r8.h;	 Catch:{ Exception -> 0x0095 }
        r4 = -2;
        if (r3 == 0) goto L_0x0047;
    L_0x0037:
        r3 = r8.h;	 Catch:{ Exception -> 0x0095 }
        r3 = r1.equals(r3);	 Catch:{ Exception -> 0x0095 }
        if (r3 == 0) goto L_0x0047;
    L_0x003f:
        r3 = r8.i;	 Catch:{ Exception -> 0x0095 }
        if (r3 <= r4) goto L_0x0047;
    L_0x0043:
        r1 = r8.i;	 Catch:{ Exception -> 0x0095 }
        r0 = r1;
        goto L_0x0095;
    L_0x0047:
        r3 = 0;
        r5 = r8.f;	 Catch:{ Exception -> 0x0090, all -> 0x0089 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0090, all -> 0x0089 }
        r6.<init>();	 Catch:{ Exception -> 0x0090, all -> 0x0089 }
        r7 = "select * from hstdata where id = \"";
        r6.append(r7);	 Catch:{ Exception -> 0x0090, all -> 0x0089 }
        r6.append(r2);	 Catch:{ Exception -> 0x0090, all -> 0x0089 }
        r2 = "\";";
        r6.append(r2);	 Catch:{ Exception -> 0x0090, all -> 0x0089 }
        r2 = r6.toString();	 Catch:{ Exception -> 0x0090, all -> 0x0089 }
        r2 = r5.rawQuery(r2, r3);	 Catch:{ Exception -> 0x0090, all -> 0x0089 }
        if (r2 == 0) goto L_0x0082;
    L_0x0066:
        r3 = r2.moveToFirst();	 Catch:{ Exception -> 0x0080, all -> 0x007d }
        if (r3 == 0) goto L_0x0082;
    L_0x006c:
        r3 = 1;
        r3 = r2.getInt(r3);	 Catch:{ Exception -> 0x0080, all -> 0x007d }
        r8.h = r1;	 Catch:{ Exception -> 0x007b, all -> 0x0077 }
        r8.i = r3;	 Catch:{ Exception -> 0x007b, all -> 0x0077 }
        r0 = r3;
        goto L_0x0083;
    L_0x0077:
        r0 = move-exception;
        r1 = r0;
        r0 = r3;
        goto L_0x007e;
    L_0x007b:
        r0 = r3;
        goto L_0x0080;
    L_0x007d:
        r1 = move-exception;
    L_0x007e:
        r3 = r2;
        goto L_0x008a;
    L_0x0080:
        r3 = r2;
        goto L_0x0090;
    L_0x0082:
        r0 = r4;
    L_0x0083:
        if (r2 == 0) goto L_0x0095;
    L_0x0085:
        r2.close();	 Catch:{ Exception -> 0x0095 }
        goto L_0x0095;
    L_0x0089:
        r1 = move-exception;
    L_0x008a:
        if (r3 == 0) goto L_0x008f;
    L_0x008c:
        r3.close();	 Catch:{ Exception -> 0x008f }
    L_0x008f:
        throw r1;	 Catch:{ Exception -> 0x0095 }
    L_0x0090:
        if (r3 == 0) goto L_0x0095;
    L_0x0092:
        r3.close();	 Catch:{ Exception -> 0x0095 }
    L_0x0095:
        r8.i = r0;	 Catch:{ all -> 0x0099 }
        monitor-exit(r8);
        return r0;
    L_0x0099:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.a.h.d():int");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x0098 */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x009c A:{Catch:{ Exception -> 0x00bb }} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x009f A:{Catch:{ Exception -> 0x00bb }} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0095 A:{SYNTHETIC, Splitter:B:32:0x0095} */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:24|(0)|34|35) */
    /* JADX WARNING: Missing block: B:26:0x008b, code skipped:
            if (r1 == null) goto L_0x009d;
     */
    public void e() {
        /*
        r12 = this;
        r0 = r12.g;
        if (r0 == 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = com.baidu.location.e.i.j();	 Catch:{ Exception -> 0x00bb }
        if (r0 == 0) goto L_0x00b8;
    L_0x000b:
        r0 = r12.f;	 Catch:{ Exception -> 0x00bb }
        if (r0 == 0) goto L_0x00b8;
    L_0x000f:
        r0 = com.baidu.location.e.i.a();	 Catch:{ Exception -> 0x00bb }
        r0 = r0.l();	 Catch:{ Exception -> 0x00bb }
        if (r0 == 0) goto L_0x00b8;
    L_0x0019:
        r1 = r0.getBSSID();	 Catch:{ Exception -> 0x00bb }
        if (r1 == 0) goto L_0x00b8;
    L_0x001f:
        r0 = r0.getBSSID();	 Catch:{ Exception -> 0x00bb }
        r1 = ":";
        r2 = "";
        r0 = r0.replace(r1, r2);	 Catch:{ Exception -> 0x00bb }
        r1 = com.baidu.location.Jni.encode3(r0);	 Catch:{ Exception -> 0x00bb }
        r2 = 0;
        r3 = 0;
        r4 = 1;
        r5 = r12.f;	 Catch:{ Exception -> 0x0099, all -> 0x0091 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0099, all -> 0x0091 }
        r6.<init>();	 Catch:{ Exception -> 0x0099, all -> 0x0091 }
        r7 = "select * from hstdata where id = \"";
        r6.append(r7);	 Catch:{ Exception -> 0x0099, all -> 0x0091 }
        r6.append(r1);	 Catch:{ Exception -> 0x0099, all -> 0x0091 }
        r1 = "\";";
        r6.append(r1);	 Catch:{ Exception -> 0x0099, all -> 0x0091 }
        r1 = r6.toString();	 Catch:{ Exception -> 0x0099, all -> 0x0091 }
        r1 = r5.rawQuery(r1, r3);	 Catch:{ Exception -> 0x0099, all -> 0x0091 }
        if (r1 == 0) goto L_0x008a;
    L_0x0050:
        r3 = r1.moveToFirst();	 Catch:{ Exception -> 0x009a, all -> 0x0088 }
        if (r3 == 0) goto L_0x008a;
    L_0x0056:
        r3 = r1.getInt(r4);	 Catch:{ Exception -> 0x009a, all -> 0x0088 }
        r5 = 2;
        r5 = r1.getInt(r5);	 Catch:{ Exception -> 0x009a, all -> 0x0088 }
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x009a, all -> 0x0088 }
        r8 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r6 = r6 / r8;
        r8 = (long) r5;	 Catch:{ Exception -> 0x009a, all -> 0x0088 }
        r10 = r6 - r8;
        r5 = 259200; // 0x3f480 float:3.63217E-40 double:1.28062E-318;
        r7 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1));
        if (r7 <= 0) goto L_0x0071;
    L_0x0070:
        goto L_0x008a;
    L_0x0071:
        r5 = new android.os.Bundle;	 Catch:{ Exception -> 0x009a, all -> 0x0088 }
        r5.<init>();	 Catch:{ Exception -> 0x009a, all -> 0x0088 }
        r6 = "mac";
        r7 = r0.getBytes();	 Catch:{ Exception -> 0x009a, all -> 0x0088 }
        r5.putByteArray(r6, r7);	 Catch:{ Exception -> 0x009a, all -> 0x0088 }
        r6 = "hotspot";
        r5.putInt(r6, r3);	 Catch:{ Exception -> 0x009a, all -> 0x0088 }
        r12.a(r5);	 Catch:{ Exception -> 0x009a, all -> 0x0088 }
        goto L_0x008b;
    L_0x0088:
        r0 = move-exception;
        goto L_0x0093;
    L_0x008a:
        r2 = r4;
    L_0x008b:
        if (r1 == 0) goto L_0x009d;
    L_0x008d:
        r1.close();	 Catch:{ Exception -> 0x009d }
        goto L_0x009d;
    L_0x0091:
        r0 = move-exception;
        r1 = r3;
    L_0x0093:
        if (r1 == 0) goto L_0x0098;
    L_0x0095:
        r1.close();	 Catch:{ Exception -> 0x0098 }
    L_0x0098:
        throw r0;	 Catch:{ Exception -> 0x00bb }
    L_0x0099:
        r1 = r3;
    L_0x009a:
        if (r1 == 0) goto L_0x009d;
    L_0x009c:
        goto L_0x008d;
    L_0x009d:
        if (r2 == 0) goto L_0x00bb;
    L_0x009f:
        r1 = r12.a;	 Catch:{ Exception -> 0x00bb }
        if (r1 != 0) goto L_0x00aa;
    L_0x00a3:
        r1 = new com.baidu.location.a.h$a;	 Catch:{ Exception -> 0x00bb }
        r1.<init>();	 Catch:{ Exception -> 0x00bb }
        r12.a = r1;	 Catch:{ Exception -> 0x00bb }
    L_0x00aa:
        r1 = r12.a;	 Catch:{ Exception -> 0x00bb }
        if (r1 == 0) goto L_0x00bb;
    L_0x00ae:
        r1 = r12.a;	 Catch:{ Exception -> 0x00bb }
        r2 = r12.a(r4);	 Catch:{ Exception -> 0x00bb }
        r1.a(r0, r2);	 Catch:{ Exception -> 0x00bb }
        return;
    L_0x00b8:
        r12.f();	 Catch:{ Exception -> 0x00bb }
    L_0x00bb:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.a.h.e():void");
    }
}
