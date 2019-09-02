package com.tencent.bugly.crashreport.crash;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Parcelable;
import com.sina.weibo.sdk.statistic.LogBuilder;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.common.strategy.a;
import com.tencent.bugly.proguard.ah;
import com.tencent.bugly.proguard.aj;
import com.tencent.bugly.proguard.ak;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.r;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

/* compiled from: BUGLY */
public final class b {
    private static int a;
    private Context b;
    private u c;
    private p d;
    private a e;
    private o f;
    private BuglyStrategy.a g;

    public b(int i, Context context, u uVar, p pVar, a aVar, BuglyStrategy.a aVar2, o oVar) {
        a = i;
        this.b = context;
        this.c = uVar;
        this.d = pVar;
        this.e = aVar;
        this.g = aVar2;
        this.f = oVar;
    }

    private static CrashDetailBean a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j = cursor.getLong(cursor.getColumnIndex("_id"));
            CrashDetailBean crashDetailBean = (CrashDetailBean) z.a(blob, CrashDetailBean.CREATOR);
            if (crashDetailBean != null) {
                crashDetailBean.a = j;
            }
            return crashDetailBean;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private CrashDetailBean a(List<a> list, CrashDetailBean crashDetailBean) {
        if (list == null || list.size() == 0) {
            return crashDetailBean;
        }
        CrashDetailBean crashDetailBean2 = null;
        List arrayList = new ArrayList(10);
        for (a aVar : list) {
            if (aVar.e) {
                arrayList.add(aVar);
            }
        }
        if (arrayList.size() > 0) {
            arrayList = b(arrayList);
            if (arrayList != null && arrayList.size() > 0) {
                Collections.sort(arrayList);
                CrashDetailBean crashDetailBean3 = null;
                for (int i = 0; i < arrayList.size(); i++) {
                    CrashDetailBean crashDetailBean4 = (CrashDetailBean) arrayList.get(i);
                    if (i == 0) {
                        crashDetailBean3 = crashDetailBean4;
                    } else if (crashDetailBean4.s != null) {
                        String[] split = crashDetailBean4.s.split("\n");
                        if (split != null) {
                            for (String str : split) {
                                String str2 = crashDetailBean3.s;
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append(str);
                                if (!str2.contains(stringBuilder.toString())) {
                                    crashDetailBean3.t++;
                                    StringBuilder stringBuilder2 = new StringBuilder();
                                    stringBuilder2.append(crashDetailBean3.s);
                                    stringBuilder2.append(str);
                                    stringBuilder2.append("\n");
                                    crashDetailBean3.s = stringBuilder2.toString();
                                }
                            }
                        }
                    }
                }
                crashDetailBean2 = crashDetailBean3;
            }
        }
        if (crashDetailBean2 == null) {
            crashDetailBean.j = true;
            crashDetailBean.t = 0;
            crashDetailBean.s = "";
            crashDetailBean2 = crashDetailBean;
        }
        for (a aVar2 : list) {
            if (!(aVar2.e || aVar2.d)) {
                String str3 = crashDetailBean2.s;
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(aVar2.b);
                if (!str3.contains(stringBuilder3.toString())) {
                    crashDetailBean2.t++;
                    StringBuilder stringBuilder4 = new StringBuilder();
                    stringBuilder4.append(crashDetailBean2.s);
                    stringBuilder4.append(aVar2.b);
                    stringBuilder4.append("\n");
                    crashDetailBean2.s = stringBuilder4.toString();
                }
            }
        }
        if (crashDetailBean2.r != crashDetailBean.r) {
            String str4 = crashDetailBean2.s;
            StringBuilder stringBuilder5 = new StringBuilder();
            stringBuilder5.append(crashDetailBean.r);
            if (!str4.contains(stringBuilder5.toString())) {
                crashDetailBean2.t++;
                StringBuilder stringBuilder6 = new StringBuilder();
                stringBuilder6.append(crashDetailBean2.s);
                stringBuilder6.append(crashDetailBean.r);
                stringBuilder6.append("\n");
                crashDetailBean2.s = stringBuilder6.toString();
            }
        }
        return crashDetailBean2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ba A:{SYNTHETIC, Splitter:B:49:0x00ba} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0093 A:{Catch:{ all -> 0x00b7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0098 A:{SYNTHETIC, Splitter:B:37:0x0098} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ac  */
    private static com.tencent.bugly.proguard.aj a(java.lang.String r5, android.content.Context r6, java.lang.String r7) {
        /*
        r0 = 0;
        r1 = 0;
        if (r7 == 0) goto L_0x00d9;
    L_0x0004:
        if (r6 != 0) goto L_0x0008;
    L_0x0006:
        goto L_0x00d9;
    L_0x0008:
        r2 = "zip %s";
        r3 = 1;
        r4 = new java.lang.Object[r3];
        r4[r1] = r7;
        com.tencent.bugly.proguard.x.c(r2, r4);
        r2 = new java.io.File;
        r2.<init>(r7);
        r7 = new java.io.File;
        r6 = r6.getCacheDir();
        r7.<init>(r6, r5);
        r5 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        r5 = com.tencent.bugly.proguard.z.a(r2, r7, r5);
        if (r5 != 0) goto L_0x0030;
    L_0x0028:
        r5 = "zip fail!";
        r6 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.x.d(r5, r6);
        return r0;
    L_0x0030:
        r5 = new java.io.ByteArrayOutputStream;
        r5.<init>();
        r6 = new java.io.FileInputStream;	 Catch:{ Throwable -> 0x008b, all -> 0x0088 }
        r6.<init>(r7);	 Catch:{ Throwable -> 0x008b, all -> 0x0088 }
        r2 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r2 = new byte[r2];	 Catch:{ Throwable -> 0x0086 }
    L_0x003e:
        r4 = r6.read(r2);	 Catch:{ Throwable -> 0x0086 }
        if (r4 <= 0) goto L_0x004b;
    L_0x0044:
        r5.write(r2, r1, r4);	 Catch:{ Throwable -> 0x0086 }
        r5.flush();	 Catch:{ Throwable -> 0x0086 }
        goto L_0x003e;
    L_0x004b:
        r5 = r5.toByteArray();	 Catch:{ Throwable -> 0x0086 }
        r2 = "read bytes :%d";
        r3 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x0086 }
        r4 = r5.length;	 Catch:{ Throwable -> 0x0086 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Throwable -> 0x0086 }
        r3[r1] = r4;	 Catch:{ Throwable -> 0x0086 }
        com.tencent.bugly.proguard.x.c(r2, r3);	 Catch:{ Throwable -> 0x0086 }
        r2 = new com.tencent.bugly.proguard.aj;	 Catch:{ Throwable -> 0x0086 }
        r3 = 2;
        r4 = r7.getName();	 Catch:{ Throwable -> 0x0086 }
        r2.<init>(r3, r4, r5);	 Catch:{ Throwable -> 0x0086 }
        r6.close();	 Catch:{ IOException -> 0x006b }
        goto L_0x0075;
    L_0x006b:
        r5 = move-exception;
        r6 = com.tencent.bugly.proguard.x.a(r5);
        if (r6 != 0) goto L_0x0075;
    L_0x0072:
        r5.printStackTrace();
    L_0x0075:
        r5 = r7.exists();
        if (r5 == 0) goto L_0x0085;
    L_0x007b:
        r5 = "del tmp";
        r6 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.x.c(r5, r6);
        r7.delete();
    L_0x0085:
        return r2;
    L_0x0086:
        r5 = move-exception;
        goto L_0x008d;
    L_0x0088:
        r5 = move-exception;
        r6 = r0;
        goto L_0x00b8;
    L_0x008b:
        r5 = move-exception;
        r6 = r0;
    L_0x008d:
        r2 = com.tencent.bugly.proguard.x.a(r5);	 Catch:{ all -> 0x00b7 }
        if (r2 != 0) goto L_0x0096;
    L_0x0093:
        r5.printStackTrace();	 Catch:{ all -> 0x00b7 }
    L_0x0096:
        if (r6 == 0) goto L_0x00a6;
    L_0x0098:
        r6.close();	 Catch:{ IOException -> 0x009c }
        goto L_0x00a6;
    L_0x009c:
        r5 = move-exception;
        r6 = com.tencent.bugly.proguard.x.a(r5);
        if (r6 != 0) goto L_0x00a6;
    L_0x00a3:
        r5.printStackTrace();
    L_0x00a6:
        r5 = r7.exists();
        if (r5 == 0) goto L_0x00b6;
    L_0x00ac:
        r5 = "del tmp";
        r6 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.x.c(r5, r6);
        r7.delete();
    L_0x00b6:
        return r0;
    L_0x00b7:
        r5 = move-exception;
    L_0x00b8:
        if (r6 == 0) goto L_0x00c8;
    L_0x00ba:
        r6.close();	 Catch:{ IOException -> 0x00be }
        goto L_0x00c8;
    L_0x00be:
        r6 = move-exception;
        r0 = com.tencent.bugly.proguard.x.a(r6);
        if (r0 != 0) goto L_0x00c8;
    L_0x00c5:
        r6.printStackTrace();
    L_0x00c8:
        r6 = r7.exists();
        if (r6 == 0) goto L_0x00d8;
    L_0x00ce:
        r6 = "del tmp";
        r0 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.x.c(r6, r0);
        r7.delete();
    L_0x00d8:
        throw r5;
    L_0x00d9:
        r5 = "rqdp{  createZipAttachment sourcePath == null || context == null ,pls check}";
        r6 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.x.d(r5, r6);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.b.a(java.lang.String, android.content.Context, java.lang.String):com.tencent.bugly.proguard.aj");
    }

    private static ak a(Context context, CrashDetailBean crashDetailBean, com.tencent.bugly.crashreport.common.info.a aVar) {
        boolean z = false;
        if (context == null || crashDetailBean == null || aVar == null) {
            x.d("enExp args == null", new Object[0]);
            return null;
        }
        ah ahVar;
        aj a;
        Map map;
        StringBuilder stringBuilder;
        ak akVar = new ak();
        switch (crashDetailBean.b) {
            case 0:
                akVar.a = crashDetailBean.j ? "200" : "100";
                break;
            case 1:
                akVar.a = crashDetailBean.j ? "201" : "101";
                break;
            case 2:
                akVar.a = crashDetailBean.j ? "202" : "102";
                break;
            case 3:
                akVar.a = crashDetailBean.j ? "203" : "103";
                break;
            case 4:
                akVar.a = crashDetailBean.j ? "204" : "104";
                break;
            case 5:
                akVar.a = crashDetailBean.j ? "207" : "107";
                break;
            case 6:
                akVar.a = crashDetailBean.j ? "206" : "106";
                break;
            case 7:
                akVar.a = crashDetailBean.j ? "208" : "108";
                break;
            default:
                x.e("crash type error! %d", Integer.valueOf(crashDetailBean.b));
                break;
        }
        akVar.b = crashDetailBean.r;
        akVar.c = crashDetailBean.n;
        akVar.d = crashDetailBean.o;
        akVar.e = crashDetailBean.p;
        akVar.g = crashDetailBean.q;
        akVar.h = crashDetailBean.y;
        akVar.i = crashDetailBean.c;
        akVar.j = null;
        akVar.l = crashDetailBean.m;
        akVar.m = crashDetailBean.e;
        akVar.f = crashDetailBean.A;
        akVar.t = com.tencent.bugly.crashreport.common.info.a.b().i();
        akVar.n = null;
        if (crashDetailBean.i != null && crashDetailBean.i.size() > 0) {
            akVar.o = new ArrayList();
            for (Entry entry : crashDetailBean.i.entrySet()) {
                ahVar = new ah();
                ahVar.a = ((PlugInBean) entry.getValue()).a;
                ahVar.c = ((PlugInBean) entry.getValue()).c;
                ahVar.d = ((PlugInBean) entry.getValue()).b;
                ahVar.b = aVar.r();
                akVar.o.add(ahVar);
            }
        }
        if (crashDetailBean.h != null && crashDetailBean.h.size() > 0) {
            akVar.p = new ArrayList();
            for (Entry entry2 : crashDetailBean.h.entrySet()) {
                ahVar = new ah();
                ahVar.a = ((PlugInBean) entry2.getValue()).a;
                ahVar.c = ((PlugInBean) entry2.getValue()).c;
                ahVar.d = ((PlugInBean) entry2.getValue()).b;
                akVar.p.add(ahVar);
            }
        }
        if (crashDetailBean.j) {
            akVar.k = crashDetailBean.t;
            if (crashDetailBean.s != null && crashDetailBean.s.length() > 0) {
                if (akVar.q == null) {
                    akVar.q = new ArrayList();
                }
                try {
                    akVar.q.add(new aj((byte) 1, "alltimes.txt", crashDetailBean.s.getBytes("utf-8")));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    akVar.q = null;
                }
            }
            String str = "crashcount:%d sz:%d";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(akVar.k);
            objArr[1] = Integer.valueOf(akVar.q != null ? akVar.q.size() : 0);
            x.c(str, objArr);
        }
        if (crashDetailBean.w != null) {
            if (akVar.q == null) {
                akVar.q = new ArrayList();
            }
            try {
                akVar.q.add(new aj((byte) 1, "log.txt", crashDetailBean.w.getBytes("utf-8")));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                akVar.q = null;
            }
        }
        if (!z.a(crashDetailBean.T)) {
            Object ajVar;
            if (akVar.q == null) {
                akVar.q = new ArrayList();
            }
            try {
                ajVar = new aj((byte) 1, "crashInfos.txt", crashDetailBean.T.getBytes("utf-8"));
            } catch (UnsupportedEncodingException e22) {
                e22.printStackTrace();
                ajVar = null;
            }
            if (ajVar != null) {
                x.c("attach crash infos", new Object[0]);
                akVar.q.add(ajVar);
            }
        }
        if (crashDetailBean.U != null) {
            if (akVar.q == null) {
                akVar.q = new ArrayList();
            }
            a = a("backupRecord.zip", context, crashDetailBean.U);
            if (a != null) {
                x.c("attach backup record", new Object[0]);
                akVar.q.add(a);
            }
        }
        if (crashDetailBean.x != null && crashDetailBean.x.length > 0) {
            a = new aj((byte) 2, "buglylog.zip", crashDetailBean.x);
            x.c("attach user log", new Object[0]);
            if (akVar.q == null) {
                akVar.q = new ArrayList();
            }
            akVar.q.add(a);
        }
        if (crashDetailBean.b == 3) {
            if (akVar.q == null) {
                akVar.q = new ArrayList();
            }
            if (crashDetailBean.N != null && crashDetailBean.N.containsKey("BUGLY_CR_01")) {
                try {
                    akVar.q.add(new aj((byte) 1, "anrMessage.txt", ((String) crashDetailBean.N.get("BUGLY_CR_01")).getBytes("utf-8")));
                    x.c("attach anr message", new Object[0]);
                } catch (UnsupportedEncodingException e222) {
                    e222.printStackTrace();
                    akVar.q = null;
                }
                crashDetailBean.N.remove("BUGLY_CR_01");
            }
            if (crashDetailBean.v != null) {
                a = a("trace.zip", context, crashDetailBean.v);
                if (a != null) {
                    x.c("attach traces", new Object[0]);
                    akVar.q.add(a);
                }
            }
        }
        if (crashDetailBean.b == 1) {
            if (akVar.q == null) {
                akVar.q = new ArrayList();
            }
            if (crashDetailBean.v != null) {
                aj a2 = a("tomb.zip", context, crashDetailBean.v);
                if (a2 != null) {
                    x.c("attach tombs", new Object[0]);
                    akVar.q.add(a2);
                }
            }
        }
        if (!(aVar.C == null || aVar.C.isEmpty())) {
            if (akVar.q == null) {
                akVar.q = new ArrayList();
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            for (String append : aVar.C) {
                stringBuilder2.append(append);
            }
            try {
                akVar.q.add(new aj((byte) 1, "martianlog.txt", stringBuilder2.toString().getBytes("utf-8")));
                x.c("attach pageTracingList", new Object[0]);
            } catch (UnsupportedEncodingException e3) {
                e3.printStackTrace();
            }
        }
        if (crashDetailBean.S != null && crashDetailBean.S.length > 0) {
            if (akVar.q == null) {
                akVar.q = new ArrayList();
            }
            akVar.q.add(new aj((byte) 1, "userExtraByteData", crashDetailBean.S));
            x.c("attach extraData", new Object[0]);
        }
        akVar.r = new HashMap();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(crashDetailBean.B);
        akVar.r.put("A9", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(crashDetailBean.C);
        akVar.r.put("A11", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(crashDetailBean.D);
        akVar.r.put("A10", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(crashDetailBean.f);
        akVar.r.put("A23", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(aVar.f);
        akVar.r.put("A7", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(aVar.s());
        akVar.r.put("A6", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(aVar.r());
        akVar.r.put("A5", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(aVar.h());
        akVar.r.put("A22", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(crashDetailBean.F);
        akVar.r.put("A2", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(crashDetailBean.E);
        akVar.r.put("A1", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(aVar.h);
        akVar.r.put("A24", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(crashDetailBean.G);
        akVar.r.put("A17", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(aVar.k());
        akVar.r.put("A3", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(aVar.m());
        akVar.r.put("A16", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(aVar.n());
        akVar.r.put("A25", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(aVar.l());
        akVar.r.put("A14", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(aVar.w());
        akVar.r.put("A15", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(aVar.x());
        akVar.r.put("A13", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(crashDetailBean.z);
        akVar.r.put("A34", stringBuilder3.toString());
        if (aVar.x != null) {
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(aVar.x);
            akVar.r.put("productIdentify", stringBuilder3.toString());
        }
        try {
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(URLEncoder.encode(crashDetailBean.H, "utf-8"));
            akVar.r.put("A26", stringBuilder3.toString());
        } catch (UnsupportedEncodingException e32) {
            e32.printStackTrace();
        }
        if (crashDetailBean.b == 1) {
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(crashDetailBean.J);
            akVar.r.put("A27", stringBuilder3.toString());
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(crashDetailBean.I);
            akVar.r.put("A28", stringBuilder3.toString());
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(crashDetailBean.k);
            akVar.r.put("A29", stringBuilder3.toString());
        }
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(crashDetailBean.K);
        akVar.r.put("A30", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(crashDetailBean.L);
        akVar.r.put("A18", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(crashDetailBean.M ^ 1);
        akVar.r.put("A36", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(aVar.q);
        akVar.r.put("F02", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(aVar.r);
        akVar.r.put("F03", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(aVar.e());
        akVar.r.put("F04", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(aVar.s);
        akVar.r.put("F05", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(aVar.p);
        akVar.r.put("F06", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(aVar.v);
        akVar.r.put("F08", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(aVar.w);
        akVar.r.put("F09", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(aVar.t);
        akVar.r.put("F10", stringBuilder3.toString());
        if (crashDetailBean.O >= 0) {
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(crashDetailBean.O);
            akVar.r.put("C01", stringBuilder3.toString());
        }
        if (crashDetailBean.P >= 0) {
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(crashDetailBean.P);
            akVar.r.put("C02", stringBuilder3.toString());
        }
        if (crashDetailBean.Q != null && crashDetailBean.Q.size() > 0) {
            for (Entry entry3 : crashDetailBean.Q.entrySet()) {
                map = akVar.r;
                stringBuilder = new StringBuilder("C03_");
                stringBuilder.append((String) entry3.getKey());
                map.put(stringBuilder.toString(), entry3.getValue());
            }
        }
        if (crashDetailBean.R != null && crashDetailBean.R.size() > 0) {
            for (Entry entry32 : crashDetailBean.R.entrySet()) {
                map = akVar.r;
                stringBuilder = new StringBuilder("C04_");
                stringBuilder.append((String) entry32.getKey());
                map.put(stringBuilder.toString(), entry32.getValue());
            }
        }
        akVar.s = null;
        if (crashDetailBean.N != null && crashDetailBean.N.size() > 0) {
            akVar.s = crashDetailBean.N;
            x.a("setted message size %d", Integer.valueOf(akVar.s.size()));
        }
        String str2 = "%s rid:%s sess:%s ls:%ds isR:%b isF:%b isM:%b isN:%b mc:%d ,%s ,isUp:%b ,vm:%d";
        Object[] objArr2 = new Object[12];
        objArr2[0] = crashDetailBean.n;
        objArr2[1] = crashDetailBean.c;
        objArr2[2] = aVar.e();
        objArr2[3] = Long.valueOf((crashDetailBean.r - crashDetailBean.L) / 1000);
        objArr2[4] = Boolean.valueOf(crashDetailBean.k);
        objArr2[5] = Boolean.valueOf(crashDetailBean.M);
        objArr2[6] = Boolean.valueOf(crashDetailBean.j);
        if (crashDetailBean.b == 1) {
            z = true;
        }
        objArr2[7] = Boolean.valueOf(z);
        objArr2[8] = Integer.valueOf(crashDetailBean.t);
        objArr2[9] = crashDetailBean.s;
        objArr2[10] = Boolean.valueOf(crashDetailBean.d);
        objArr2[11] = Integer.valueOf(akVar.r.size());
        x.c(str2, objArr2);
        return akVar;
    }

    private static List<a> a(List<a> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (a aVar : list) {
            if (aVar.d && aVar.b <= currentTimeMillis - LogBuilder.MAX_INTERVAL) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    public static void a(String str, String str2, String str3, Thread thread, String str4, CrashDetailBean crashDetailBean) {
        com.tencent.bugly.crashreport.common.info.a b = com.tencent.bugly.crashreport.common.info.a.b();
        if (b != null) {
            x.e("#++++++++++Record By Bugly++++++++++#", new Object[0]);
            x.e("# You can use Bugly(http:\\\\bugly.qq.com) to get more Crash Detail!", new Object[0]);
            x.e("# PKG NAME: %s", b.c);
            x.e("# APP VER: %s", b.j);
            x.e("# LAUNCH TIME: %s", z.a(new Date(com.tencent.bugly.crashreport.common.info.a.b().a)));
            x.e("# CRASH TYPE: %s", str);
            x.e("# CRASH TIME: %s", str2);
            x.e("# CRASH PROCESS: %s", str3);
            if (thread != null) {
                x.e("# CRASH THREAD: %s", thread.getName());
            }
            if (crashDetailBean != null) {
                x.e("# REPORT ID: %s", crashDetailBean.c);
                str = "# CRASH DEVICE: %s %s";
                Object[] objArr = new Object[2];
                objArr[0] = b.g;
                objArr[1] = b.x().booleanValue() ? "ROOTED" : "UNROOT";
                x.e(str, objArr);
                x.e("# RUNTIME AVAIL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.B), Long.valueOf(crashDetailBean.C), Long.valueOf(crashDetailBean.D));
                x.e("# RUNTIME TOTAL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.E), Long.valueOf(crashDetailBean.F), Long.valueOf(crashDetailBean.G));
                if (!z.a(crashDetailBean.J)) {
                    x.e("# EXCEPTION FIRED BY %s %s", crashDetailBean.J, crashDetailBean.I);
                } else if (crashDetailBean.b == 3) {
                    str = "# EXCEPTION ANR MESSAGE:\n %s";
                    Object[] objArr2 = new Object[1];
                    if (crashDetailBean.N == null) {
                        str3 = "null";
                    } else {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append((String) crashDetailBean.N.get("BUGLY_CR_01"));
                        str3 = stringBuilder.toString();
                    }
                    objArr2[0] = str3;
                    x.e(str, objArr2);
                }
            }
            if (!z.a(str4)) {
                x.e("# CRASH STACK: ", new Object[0]);
                x.e(str4, new Object[0]);
            }
            x.e("#++++++++++++++++++++++++++++++++++++++++++#", new Object[0]);
        }
    }

    public static void a(boolean z, List<CrashDetailBean> list) {
        if (list != null && list.size() > 0) {
            x.c("up finish update state %b", Boolean.valueOf(z));
            for (CrashDetailBean crashDetailBean : list) {
                x.c("pre uid:%s uc:%d re:%b me:%b", crashDetailBean.c, Integer.valueOf(crashDetailBean.l), Boolean.valueOf(crashDetailBean.d), Boolean.valueOf(crashDetailBean.j));
                crashDetailBean.l++;
                crashDetailBean.d = z;
                x.c("set uid:%s uc:%d re:%b me:%b", crashDetailBean.c, Integer.valueOf(crashDetailBean.l), Boolean.valueOf(crashDetailBean.d), Boolean.valueOf(crashDetailBean.j));
            }
            for (CrashDetailBean crashDetailBean2 : list) {
                c.a().a(crashDetailBean2);
            }
            x.c("update state size %d", Integer.valueOf(list.size()));
        }
        if (!z) {
            x.b("[crash] upload fail.", new Object[0]);
        }
    }

    private static a b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            a aVar = new a();
            aVar.a = cursor.getLong(cursor.getColumnIndex("_id"));
            aVar.b = cursor.getLong(cursor.getColumnIndex("_tm"));
            aVar.c = cursor.getString(cursor.getColumnIndex("_s1"));
            boolean z = false;
            aVar.d = cursor.getInt(cursor.getColumnIndex("_up")) == 1;
            if (cursor.getInt(cursor.getColumnIndex("_me")) == 1) {
                z = true;
            }
            aVar.e = z;
            aVar.f = cursor.getInt(cursor.getColumnIndex("_uc"));
            return aVar;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b3 A:{Catch:{ all -> 0x00bc }} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00bf  */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x006a */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:18|19|46) */
    /* JADX WARNING: Missing block: B:19:?, code skipped:
            com.tencent.bugly.proguard.x.d("unknown id!", new java.lang.Object[0]);
     */
    private java.util.List<com.tencent.bugly.crashreport.crash.a> b() {
        /*
        r15 = this;
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = 6;
        r2 = 0;
        r5 = new java.lang.String[r1];	 Catch:{ Throwable -> 0x00a9, all -> 0x00a6 }
        r1 = "_id";
        r10 = 0;
        r5[r10] = r1;	 Catch:{ Throwable -> 0x00a9, all -> 0x00a6 }
        r1 = "_tm";
        r11 = 1;
        r5[r11] = r1;	 Catch:{ Throwable -> 0x00a9, all -> 0x00a6 }
        r1 = "_s1";
        r12 = 2;
        r5[r12] = r1;	 Catch:{ Throwable -> 0x00a9, all -> 0x00a6 }
        r1 = 3;
        r3 = "_up";
        r5[r1] = r3;	 Catch:{ Throwable -> 0x00a9, all -> 0x00a6 }
        r1 = "_me";
        r13 = 4;
        r5[r13] = r1;	 Catch:{ Throwable -> 0x00a9, all -> 0x00a6 }
        r1 = 5;
        r3 = "_uc";
        r5[r1] = r3;	 Catch:{ Throwable -> 0x00a9, all -> 0x00a6 }
        r3 = com.tencent.bugly.proguard.p.a();	 Catch:{ Throwable -> 0x00a9, all -> 0x00a6 }
        r4 = "t_cr";
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = 1;
        r1 = r3.a(r4, r5, r6, r7, r8, r9);	 Catch:{ Throwable -> 0x00a9, all -> 0x00a6 }
        if (r1 != 0) goto L_0x003d;
    L_0x0037:
        if (r1 == 0) goto L_0x003c;
    L_0x0039:
        r1.close();
    L_0x003c:
        return r2;
    L_0x003d:
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00a4 }
        r2.<init>();	 Catch:{ Throwable -> 0x00a4 }
    L_0x0042:
        r3 = r1.moveToNext();	 Catch:{ Throwable -> 0x00a4 }
        if (r3 == 0) goto L_0x0072;
    L_0x0048:
        r3 = b(r1);	 Catch:{ Throwable -> 0x00a4 }
        if (r3 == 0) goto L_0x0052;
    L_0x004e:
        r0.add(r3);	 Catch:{ Throwable -> 0x00a4 }
        goto L_0x0042;
    L_0x0052:
        r3 = "_id";
        r3 = r1.getColumnIndex(r3);	 Catch:{ Throwable -> 0x006a }
        r3 = r1.getLong(r3);	 Catch:{ Throwable -> 0x006a }
        r5 = " or _id";
        r2.append(r5);	 Catch:{ Throwable -> 0x006a }
        r5 = " = ";
        r2.append(r5);	 Catch:{ Throwable -> 0x006a }
        r2.append(r3);	 Catch:{ Throwable -> 0x006a }
        goto L_0x0042;
    L_0x006a:
        r3 = "unknown id!";
        r4 = new java.lang.Object[r10];	 Catch:{ Throwable -> 0x00a4 }
        com.tencent.bugly.proguard.x.d(r3, r4);	 Catch:{ Throwable -> 0x00a4 }
        goto L_0x0042;
    L_0x0072:
        r2 = r2.toString();	 Catch:{ Throwable -> 0x00a4 }
        r3 = r2.length();	 Catch:{ Throwable -> 0x00a4 }
        if (r3 <= 0) goto L_0x009e;
    L_0x007c:
        r6 = r2.substring(r13);	 Catch:{ Throwable -> 0x00a4 }
        r4 = com.tencent.bugly.proguard.p.a();	 Catch:{ Throwable -> 0x00a4 }
        r5 = "t_cr";
        r7 = 0;
        r8 = 0;
        r9 = 1;
        r2 = r4.a(r5, r6, r7, r8, r9);	 Catch:{ Throwable -> 0x00a4 }
        r3 = "deleted %s illegle data %d";
        r4 = new java.lang.Object[r12];	 Catch:{ Throwable -> 0x00a4 }
        r5 = "t_cr";
        r4[r10] = r5;	 Catch:{ Throwable -> 0x00a4 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ Throwable -> 0x00a4 }
        r4[r11] = r2;	 Catch:{ Throwable -> 0x00a4 }
        com.tencent.bugly.proguard.x.d(r3, r4);	 Catch:{ Throwable -> 0x00a4 }
    L_0x009e:
        if (r1 == 0) goto L_0x00a3;
    L_0x00a0:
        r1.close();
    L_0x00a3:
        return r0;
    L_0x00a4:
        r2 = move-exception;
        goto L_0x00ad;
    L_0x00a6:
        r0 = move-exception;
        r1 = r2;
        goto L_0x00bd;
    L_0x00a9:
        r1 = move-exception;
        r14 = r2;
        r2 = r1;
        r1 = r14;
    L_0x00ad:
        r3 = com.tencent.bugly.proguard.x.a(r2);	 Catch:{ all -> 0x00bc }
        if (r3 != 0) goto L_0x00b6;
    L_0x00b3:
        r2.printStackTrace();	 Catch:{ all -> 0x00bc }
    L_0x00b6:
        if (r1 == 0) goto L_0x00bb;
    L_0x00b8:
        r1.close();
    L_0x00bb:
        return r0;
    L_0x00bc:
        r0 = move-exception;
    L_0x00bd:
        if (r1 == 0) goto L_0x00c2;
    L_0x00bf:
        r1.close();
    L_0x00c2:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.b.b():java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d0 A:{Catch:{ all -> 0x00d9 }} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00dc  */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0087 */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:29|30|59) */
    /* JADX WARNING: Missing block: B:30:?, code skipped:
            com.tencent.bugly.proguard.x.d("unknown id!", new java.lang.Object[0]);
     */
    private java.util.List<com.tencent.bugly.crashreport.crash.CrashDetailBean> b(java.util.List<com.tencent.bugly.crashreport.crash.a> r13) {
        /*
        r12 = this;
        r0 = 0;
        if (r13 == 0) goto L_0x00e0;
    L_0x0003:
        r1 = r13.size();
        if (r1 != 0) goto L_0x000b;
    L_0x0009:
        goto L_0x00e0;
    L_0x000b:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r13 = r13.iterator();
    L_0x0014:
        r2 = r13.hasNext();
        if (r2 == 0) goto L_0x0030;
    L_0x001a:
        r2 = r13.next();
        r2 = (com.tencent.bugly.crashreport.crash.a) r2;
        r3 = " or _id";
        r1.append(r3);
        r3 = " = ";
        r1.append(r3);
        r2 = r2.a;
        r1.append(r2);
        goto L_0x0014;
    L_0x0030:
        r13 = r1.toString();
        r2 = r13.length();
        r3 = 4;
        if (r2 <= 0) goto L_0x003f;
    L_0x003b:
        r13 = r13.substring(r3);
    L_0x003f:
        r7 = r13;
        r13 = 0;
        r1.setLength(r13);
        r4 = com.tencent.bugly.proguard.p.a();	 Catch:{ Throwable -> 0x00c8, all -> 0x00c5 }
        r5 = "t_cr";
        r6 = 0;
        r8 = 0;
        r9 = 0;
        r10 = 1;
        r2 = r4.a(r5, r6, r7, r8, r9, r10);	 Catch:{ Throwable -> 0x00c8, all -> 0x00c5 }
        if (r2 != 0) goto L_0x005a;
    L_0x0054:
        if (r2 == 0) goto L_0x0059;
    L_0x0056:
        r2.close();
    L_0x0059:
        return r0;
    L_0x005a:
        r4 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x00c3 }
        r4.<init>();	 Catch:{ Throwable -> 0x00c3 }
    L_0x005f:
        r5 = r2.moveToNext();	 Catch:{ Throwable -> 0x00c3 }
        if (r5 == 0) goto L_0x008f;
    L_0x0065:
        r5 = a(r2);	 Catch:{ Throwable -> 0x00c3 }
        if (r5 == 0) goto L_0x006f;
    L_0x006b:
        r4.add(r5);	 Catch:{ Throwable -> 0x00c3 }
        goto L_0x005f;
    L_0x006f:
        r5 = "_id";
        r5 = r2.getColumnIndex(r5);	 Catch:{ Throwable -> 0x0087 }
        r5 = r2.getLong(r5);	 Catch:{ Throwable -> 0x0087 }
        r7 = " or _id";
        r1.append(r7);	 Catch:{ Throwable -> 0x0087 }
        r7 = " = ";
        r1.append(r7);	 Catch:{ Throwable -> 0x0087 }
        r1.append(r5);	 Catch:{ Throwable -> 0x0087 }
        goto L_0x005f;
    L_0x0087:
        r5 = "unknown id!";
        r6 = new java.lang.Object[r13];	 Catch:{ Throwable -> 0x00c3 }
        com.tencent.bugly.proguard.x.d(r5, r6);	 Catch:{ Throwable -> 0x00c3 }
        goto L_0x005f;
    L_0x008f:
        r1 = r1.toString();	 Catch:{ Throwable -> 0x00c3 }
        r5 = r1.length();	 Catch:{ Throwable -> 0x00c3 }
        if (r5 <= 0) goto L_0x00bd;
    L_0x0099:
        r8 = r1.substring(r3);	 Catch:{ Throwable -> 0x00c3 }
        r6 = com.tencent.bugly.proguard.p.a();	 Catch:{ Throwable -> 0x00c3 }
        r7 = "t_cr";
        r9 = 0;
        r10 = 0;
        r11 = 1;
        r1 = r6.a(r7, r8, r9, r10, r11);	 Catch:{ Throwable -> 0x00c3 }
        r3 = "deleted %s illegle data %d";
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ Throwable -> 0x00c3 }
        r6 = "t_cr";
        r5[r13] = r6;	 Catch:{ Throwable -> 0x00c3 }
        r13 = 1;
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ Throwable -> 0x00c3 }
        r5[r13] = r1;	 Catch:{ Throwable -> 0x00c3 }
        com.tencent.bugly.proguard.x.d(r3, r5);	 Catch:{ Throwable -> 0x00c3 }
    L_0x00bd:
        if (r2 == 0) goto L_0x00c2;
    L_0x00bf:
        r2.close();
    L_0x00c2:
        return r4;
    L_0x00c3:
        r13 = move-exception;
        goto L_0x00ca;
    L_0x00c5:
        r13 = move-exception;
        r2 = r0;
        goto L_0x00da;
    L_0x00c8:
        r13 = move-exception;
        r2 = r0;
    L_0x00ca:
        r1 = com.tencent.bugly.proguard.x.a(r13);	 Catch:{ all -> 0x00d9 }
        if (r1 != 0) goto L_0x00d3;
    L_0x00d0:
        r13.printStackTrace();	 Catch:{ all -> 0x00d9 }
    L_0x00d3:
        if (r2 == 0) goto L_0x00d8;
    L_0x00d5:
        r2.close();
    L_0x00d8:
        return r0;
    L_0x00d9:
        r13 = move-exception;
    L_0x00da:
        if (r2 == 0) goto L_0x00df;
    L_0x00dc:
        r2.close();
    L_0x00df:
        throw r13;
    L_0x00e0:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.b.b(java.util.List):java.util.List");
    }

    private static void c(List<a> list) {
        if (list != null && list.size() != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (a aVar : list) {
                stringBuilder.append(" or _id");
                stringBuilder.append(" = ");
                stringBuilder.append(aVar.a);
            }
            String stringBuilder2 = stringBuilder.toString();
            if (stringBuilder2.length() > 0) {
                stringBuilder2 = stringBuilder2.substring(4);
            }
            String str = stringBuilder2;
            stringBuilder.setLength(0);
            try {
                int a = p.a().a("t_cr", str, null, null, true);
                x.c("deleted %s data %d", "t_cr", Integer.valueOf(a));
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    private static void d(List<CrashDetailBean> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (CrashDetailBean crashDetailBean : list) {
                        stringBuilder.append(" or _id");
                        stringBuilder.append(" = ");
                        stringBuilder.append(crashDetailBean.a);
                    }
                    String stringBuilder2 = stringBuilder.toString();
                    if (stringBuilder2.length() > 0) {
                        stringBuilder2 = stringBuilder2.substring(4);
                    }
                    String str = stringBuilder2;
                    stringBuilder.setLength(0);
                    int a = p.a().a("t_cr", str, null, null, true);
                    x.c("deleted %s data %d", "t_cr", Integer.valueOf(a));
                }
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    private static ContentValues e(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (crashDetailBean.a > 0) {
                contentValues.put("_id", Long.valueOf(crashDetailBean.a));
            }
            contentValues.put("_tm", Long.valueOf(crashDetailBean.r));
            contentValues.put("_s1", crashDetailBean.u);
            contentValues.put("_up", Integer.valueOf(crashDetailBean.d));
            contentValues.put("_me", Integer.valueOf(crashDetailBean.j));
            contentValues.put("_uc", Integer.valueOf(crashDetailBean.l));
            contentValues.put("_dt", z.a((Parcelable) crashDetailBean));
            return contentValues;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public final List<CrashDetailBean> a() {
        StrategyBean c = a.a().c();
        if (c == null) {
            x.d("have not synced remote!", new Object[0]);
            return null;
        } else if (c.g) {
            long currentTimeMillis = System.currentTimeMillis();
            long b = z.b();
            List b2 = b();
            if (b2 == null || b2.size() <= 0) {
                return null;
            }
            List arrayList = new ArrayList();
            Iterator it = b2.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar.b < b - c.g) {
                    it.remove();
                    arrayList.add(aVar);
                } else if (aVar.d) {
                    if (aVar.b >= currentTimeMillis - LogBuilder.MAX_INTERVAL) {
                        it.remove();
                    } else if (!aVar.e) {
                        it.remove();
                        arrayList.add(aVar);
                    }
                } else if (((long) aVar.f) >= 3 && aVar.b < currentTimeMillis - LogBuilder.MAX_INTERVAL) {
                    it.remove();
                    arrayList.add(aVar);
                }
            }
            if (arrayList.size() > 0) {
                c(arrayList);
            }
            arrayList = new ArrayList();
            b2 = b(b2);
            if (b2 != null && b2.size() > 0) {
                String str = com.tencent.bugly.crashreport.common.info.a.b().j;
                Iterator it2 = b2.iterator();
                while (it2.hasNext()) {
                    CrashDetailBean crashDetailBean = (CrashDetailBean) it2.next();
                    if (!str.equals(crashDetailBean.f)) {
                        it2.remove();
                        arrayList.add(crashDetailBean);
                    }
                }
            }
            if (arrayList.size() > 0) {
                d(arrayList);
            }
            return b2;
        } else {
            x.d("Crashreport remote closed, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            x.b("[init] WARNING! Crashreport closed by server, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            return null;
        }
    }

    public final void a(CrashDetailBean crashDetailBean, long j, boolean z) {
        if (c.l) {
            boolean z2 = false;
            x.a("try to upload right now", new Object[0]);
            ArrayList arrayList = new ArrayList();
            arrayList.add(crashDetailBean);
            if (crashDetailBean.b == 7) {
                z2 = true;
            }
            a(arrayList, 3000, z, z2, z);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b2 A:{Catch:{ Throwable -> 0x00ec }} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00aa A:{Catch:{ Throwable -> 0x00ec }} */
    public final void a(java.util.List<com.tencent.bugly.crashreport.crash.CrashDetailBean> r16, long r17, boolean r19, boolean r20, boolean r21) {
        /*
        r15 = this;
        r1 = r15;
        r2 = r16;
        r3 = r1.b;
        r3 = com.tencent.bugly.crashreport.common.info.a.a(r3);
        r3 = r3.e;
        if (r3 != 0) goto L_0x000e;
    L_0x000d:
        return;
    L_0x000e:
        r3 = r1.c;
        if (r3 != 0) goto L_0x0013;
    L_0x0012:
        return;
    L_0x0013:
        if (r21 != 0) goto L_0x0020;
    L_0x0015:
        r3 = r1.c;
        r4 = com.tencent.bugly.crashreport.crash.c.a;
        r3 = r3.b(r4);
        if (r3 != 0) goto L_0x0020;
    L_0x001f:
        return;
    L_0x0020:
        r3 = r1.e;
        r3 = r3.c();
        r4 = r3.g;
        r5 = 0;
        if (r4 != 0) goto L_0x003a;
    L_0x002b:
        r2 = "remote report is disable!";
        r3 = new java.lang.Object[r5];
        com.tencent.bugly.proguard.x.d(r2, r3);
        r2 = "[crash] server closed bugly in this app. please check your appid if is correct, and re-install it";
        r3 = new java.lang.Object[r5];
        com.tencent.bugly.proguard.x.b(r2, r3);
        return;
    L_0x003a:
        if (r2 == 0) goto L_0x0106;
    L_0x003c:
        r4 = r16.size();
        if (r4 != 0) goto L_0x0044;
    L_0x0042:
        goto L_0x0106;
    L_0x0044:
        r4 = r1.c;	 Catch:{ Throwable -> 0x00ec }
        r4 = r4.a;	 Catch:{ Throwable -> 0x00ec }
        if (r4 == 0) goto L_0x004d;
    L_0x004a:
        r3 = r3.s;	 Catch:{ Throwable -> 0x00ec }
        goto L_0x004f;
    L_0x004d:
        r3 = r3.t;	 Catch:{ Throwable -> 0x00ec }
    L_0x004f:
        r9 = r3;
        r3 = r1.c;	 Catch:{ Throwable -> 0x00ec }
        r3 = r3.a;	 Catch:{ Throwable -> 0x00ec }
        if (r3 == 0) goto L_0x0059;
    L_0x0056:
        r3 = com.tencent.bugly.crashreport.common.strategy.StrategyBean.c;	 Catch:{ Throwable -> 0x00ec }
        goto L_0x005b;
    L_0x0059:
        r3 = com.tencent.bugly.crashreport.common.strategy.StrategyBean.a;	 Catch:{ Throwable -> 0x00ec }
    L_0x005b:
        r10 = r3;
        r3 = r1.c;	 Catch:{ Throwable -> 0x00ec }
        r3 = r3.a;	 Catch:{ Throwable -> 0x00ec }
        if (r3 == 0) goto L_0x0065;
    L_0x0062:
        r3 = 830; // 0x33e float:1.163E-42 double:4.1E-321;
        goto L_0x0067;
    L_0x0065:
        r3 = 630; // 0x276 float:8.83E-43 double:3.113E-321;
    L_0x0067:
        r4 = r1.b;	 Catch:{ Throwable -> 0x00ec }
        r6 = com.tencent.bugly.crashreport.common.info.a.b();	 Catch:{ Throwable -> 0x00ec }
        if (r4 == 0) goto L_0x00a0;
    L_0x006f:
        if (r2 == 0) goto L_0x00a0;
    L_0x0071:
        r7 = r16.size();	 Catch:{ Throwable -> 0x00ec }
        if (r7 == 0) goto L_0x00a0;
    L_0x0077:
        if (r6 != 0) goto L_0x007a;
    L_0x0079:
        goto L_0x00a0;
    L_0x007a:
        r7 = new com.tencent.bugly.proguard.al;	 Catch:{ Throwable -> 0x00ec }
        r7.<init>();	 Catch:{ Throwable -> 0x00ec }
        r8 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x00ec }
        r8.<init>();	 Catch:{ Throwable -> 0x00ec }
        r7.a = r8;	 Catch:{ Throwable -> 0x00ec }
        r8 = r16.iterator();	 Catch:{ Throwable -> 0x00ec }
    L_0x008a:
        r11 = r8.hasNext();	 Catch:{ Throwable -> 0x00ec }
        if (r11 == 0) goto L_0x00a8;
    L_0x0090:
        r11 = r8.next();	 Catch:{ Throwable -> 0x00ec }
        r11 = (com.tencent.bugly.crashreport.crash.CrashDetailBean) r11;	 Catch:{ Throwable -> 0x00ec }
        r12 = r7.a;	 Catch:{ Throwable -> 0x00ec }
        r11 = a(r4, r11, r6);	 Catch:{ Throwable -> 0x00ec }
        r12.add(r11);	 Catch:{ Throwable -> 0x00ec }
        goto L_0x008a;
    L_0x00a0:
        r4 = "enEXPPkg args == null!";
        r6 = new java.lang.Object[r5];	 Catch:{ Throwable -> 0x00ec }
        com.tencent.bugly.proguard.x.d(r4, r6);	 Catch:{ Throwable -> 0x00ec }
        r7 = 0;
    L_0x00a8:
        if (r7 != 0) goto L_0x00b2;
    L_0x00aa:
        r2 = "create eupPkg fail!";
        r3 = new java.lang.Object[r5];	 Catch:{ Throwable -> 0x00ec }
        com.tencent.bugly.proguard.x.d(r2, r3);	 Catch:{ Throwable -> 0x00ec }
        return;
    L_0x00b2:
        r4 = com.tencent.bugly.proguard.a.a(r7);	 Catch:{ Throwable -> 0x00ec }
        if (r4 != 0) goto L_0x00c0;
    L_0x00b8:
        r2 = "send encode fail!";
        r3 = new java.lang.Object[r5];	 Catch:{ Throwable -> 0x00ec }
        com.tencent.bugly.proguard.x.d(r2, r3);	 Catch:{ Throwable -> 0x00ec }
        return;
    L_0x00c0:
        r6 = r1.b;	 Catch:{ Throwable -> 0x00ec }
        r8 = com.tencent.bugly.proguard.a.a(r6, r3, r4);	 Catch:{ Throwable -> 0x00ec }
        if (r8 != 0) goto L_0x00d0;
    L_0x00c8:
        r2 = "request package is null.";
        r3 = new java.lang.Object[r5];	 Catch:{ Throwable -> 0x00ec }
        com.tencent.bugly.proguard.x.d(r2, r3);	 Catch:{ Throwable -> 0x00ec }
        return;
    L_0x00d0:
        r11 = new com.tencent.bugly.crashreport.crash.b$1;	 Catch:{ Throwable -> 0x00ec }
        r11.<init>(r2);	 Catch:{ Throwable -> 0x00ec }
        if (r19 == 0) goto L_0x00e3;
    L_0x00d7:
        r6 = r1.c;	 Catch:{ Throwable -> 0x00ec }
        r7 = a;	 Catch:{ Throwable -> 0x00ec }
        r12 = r17;
        r14 = r20;
        r6.a(r7, r8, r9, r10, r11, r12, r14);	 Catch:{ Throwable -> 0x00ec }
        goto L_0x0105;
    L_0x00e3:
        r6 = r1.c;	 Catch:{ Throwable -> 0x00ec }
        r7 = a;	 Catch:{ Throwable -> 0x00ec }
        r12 = 0;
        r6.a(r7, r8, r9, r10, r11, r12);	 Catch:{ Throwable -> 0x00ec }
        return;
    L_0x00ec:
        r0 = move-exception;
        r2 = r0;
        r3 = "req cr error %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r6 = r2.toString();
        r4[r5] = r6;
        com.tencent.bugly.proguard.x.e(r3, r4);
        r3 = com.tencent.bugly.proguard.x.b(r2);
        if (r3 != 0) goto L_0x0105;
    L_0x0102:
        r2.printStackTrace();
    L_0x0105:
        return;
    L_0x0106:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.b.a(java.util.List, long, boolean, boolean, boolean):void");
    }

    public final boolean a(CrashDetailBean crashDetailBean) {
        return a(crashDetailBean, -123456789);
    }

    public final boolean a(CrashDetailBean crashDetailBean, int i) {
        if (crashDetailBean == null) {
            return true;
        }
        if (!(c.m == null || c.m.isEmpty())) {
            x.c("Crash filter for crash stack is: %s", c.m);
            if (crashDetailBean.q.contains(c.m)) {
                x.d("This crash contains the filter string set. It will not be record and upload.", new Object[0]);
                return true;
            }
        }
        if (!(c.n == null || c.n.isEmpty())) {
            x.c("Crash regular filter for crash stack is: %s", c.n);
            if (Pattern.compile(c.n).matcher(crashDetailBean.q).find()) {
                x.d("This crash matches the regular filter string set. It will not be record and upload.", new Object[0]);
                return true;
            }
        }
        int i2 = crashDetailBean.b;
        String str = crashDetailBean.n;
        str = crashDetailBean.p;
        str = crashDetailBean.q;
        long j = crashDetailBean.r;
        str = crashDetailBean.m;
        str = crashDetailBean.e;
        str = crashDetailBean.c;
        if (this.f != null) {
            o oVar = this.f;
            String str2 = crashDetailBean.z;
            if (!oVar.c()) {
                x.d("Crash listener 'onCrashSaving' return 'false' thus will not handle this crash.", new Object[0]);
                return true;
            }
        }
        if (crashDetailBean.b != 2) {
            r rVar = new r();
            rVar.b = 1;
            rVar.c = crashDetailBean.z;
            rVar.d = crashDetailBean.A;
            rVar.e = crashDetailBean.r;
            this.d.b(1);
            this.d.a(rVar);
            x.b("[crash] a crash occur, handling...", new Object[0]);
        } else {
            x.b("[crash] a caught exception occur, handling...", new Object[0]);
        }
        List<a> b = b();
        List list = null;
        if (b != null && b.size() > 0) {
            list = new ArrayList(10);
            List<a> arrayList = new ArrayList(10);
            list.addAll(a((List) b));
            b.removeAll(list);
            if (!com.tencent.bugly.b.c && c.d) {
                int i3 = 0;
                for (a aVar : b) {
                    if (crashDetailBean.u.equals(aVar.c)) {
                        if (aVar.e) {
                            i3 = true;
                        }
                        arrayList.add(aVar);
                    }
                }
                if (i3 != 0 || arrayList.size() >= c.c) {
                    x.a("same crash occur too much do merged!", new Object[0]);
                    crashDetailBean = a((List) arrayList, crashDetailBean);
                    for (a aVar2 : arrayList) {
                        if (aVar2.a != crashDetailBean.a) {
                            list.add(aVar2);
                        }
                    }
                    d(crashDetailBean);
                    c(list);
                    x.b("[crash] save crash success. For this device crash many times, it will not upload crashes immediately", new Object[0]);
                    return true;
                }
            }
        }
        d(crashDetailBean);
        if (!(list == null || list.isEmpty())) {
            c(list);
        }
        x.b("[crash] save crash success", new Object[0]);
        return false;
    }

    public final void b(CrashDetailBean crashDetailBean) {
        if (this.f != null) {
            o oVar = this.f;
            int i = crashDetailBean.b;
        }
    }

    public final void c(CrashDetailBean crashDetailBean) {
        if (crashDetailBean != null) {
            if (this.g != null || this.f != null) {
                try {
                    int i;
                    Map map;
                    x.a("[crash callback] start user's callback:onCrashHandleStart()", new Object[0]);
                    switch (crashDetailBean.b) {
                        case 0:
                            i = 0;
                            break;
                        case 1:
                            i = 2;
                            break;
                        case 2:
                            i = 1;
                            break;
                        case 3:
                            i = 4;
                            break;
                        case 4:
                            i = 3;
                            break;
                        case 5:
                            i = 5;
                            break;
                        case 6:
                            i = 6;
                            break;
                        case 7:
                            i = 7;
                            break;
                        default:
                            return;
                    }
                    int i2 = crashDetailBean.b;
                    String str = crashDetailBean.n;
                    str = crashDetailBean.p;
                    str = crashDetailBean.q;
                    long j = crashDetailBean.r;
                    byte[] bArr = null;
                    if (this.f != null) {
                        HashMap hashMap;
                        o oVar = this.f;
                        str = this.f.b();
                        if (str != null) {
                            hashMap = new HashMap(1);
                            hashMap.put("userData", str);
                        } else {
                            hashMap = null;
                        }
                        map = hashMap;
                    } else {
                        map = this.g != null ? this.g.onCrashHandleStart(i, crashDetailBean.n, crashDetailBean.o, crashDetailBean.q) : null;
                    }
                    if (map != null && map.size() > 0) {
                        crashDetailBean.N = new LinkedHashMap(map.size());
                        for (Entry entry : map.entrySet()) {
                            if (!z.a((String) entry.getKey())) {
                                Object stringBuilder;
                                Object obj = (String) entry.getKey();
                                if (obj.length() > 100) {
                                    obj = obj.substring(0, 100);
                                    x.d("setted key length is over limit %d substring to %s", Integer.valueOf(100), obj);
                                }
                                if (z.a((String) entry.getValue()) || ((String) entry.getValue()).length() <= 30000) {
                                    StringBuilder stringBuilder2 = new StringBuilder();
                                    stringBuilder2.append((String) entry.getValue());
                                    stringBuilder = stringBuilder2.toString();
                                } else {
                                    stringBuilder = ((String) entry.getValue()).substring(((String) entry.getValue()).length() - 30000);
                                    x.d("setted %s value length is over limit %d substring", obj, Integer.valueOf(30000));
                                }
                                crashDetailBean.N.put(obj, stringBuilder);
                                x.a("add setted key %s value size:%d", obj, Integer.valueOf(stringBuilder.length()));
                            }
                        }
                    }
                    x.a("[crash callback] start user's callback:onCrashHandleStart2GetExtraDatas()", new Object[0]);
                    if (this.f != null) {
                        bArr = this.f.a();
                    } else if (this.g != null) {
                        bArr = this.g.onCrashHandleStart2GetExtraDatas(i, crashDetailBean.n, crashDetailBean.o, crashDetailBean.q);
                    }
                    crashDetailBean.S = bArr;
                    if (crashDetailBean.S != null) {
                        if (crashDetailBean.S.length > 30000) {
                            x.d("extra bytes size %d is over limit %d will drop over part", Integer.valueOf(crashDetailBean.S.length), Integer.valueOf(30000));
                        }
                        x.a("add extra bytes %d ", Integer.valueOf(crashDetailBean.S.length));
                    }
                } catch (Throwable th) {
                    x.d("crash handle callback somthing wrong! %s", th.getClass().getName());
                    if (!x.a(th)) {
                        th.printStackTrace();
                    }
                }
            }
        }
    }

    public final void d(CrashDetailBean crashDetailBean) {
        if (crashDetailBean != null) {
            ContentValues e = e(crashDetailBean);
            if (e != null) {
                long a = p.a().a("t_cr", e, null, true);
                if (a >= 0) {
                    x.c("insert %s success!", "t_cr");
                    crashDetailBean.a = a;
                }
            }
        }
    }
}
