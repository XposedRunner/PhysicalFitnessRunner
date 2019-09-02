package cn.jiguang.d.d;

import android.content.Context;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.d.h.f;
import cn.jiguang.d.h.h;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public final class p {
    private static String a;
    private static ConcurrentHashMap<File, Boolean> b = new ConcurrentHashMap();

    public static File a(Context context, String str, JSONObject jSONObject) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(e(context));
        stringBuilder.append(str);
        stringBuilder.append(File.separator);
        stringBuilder.append(UUID.randomUUID().toString());
        File file = new File(stringBuilder.toString());
        b.put(file, Boolean.valueOf(true));
        f.a(file, jSONObject.toString());
        return file;
    }

    private static List<n> a(String str, Set<String> set, JSONObject jSONObject) {
        int i = 0;
        File[] a = f.a(str, false);
        if (a == null || a.length == 0) {
            return null;
        }
        int b = h.b(jSONObject) ^ 1;
        ArrayList arrayList = new ArrayList();
        int length = a.length;
        while (i < length) {
            File file = a[i];
            Boolean bool = (Boolean) b.get(file);
            if (bool == null || !bool.booleanValue()) {
                n a2 = o.a(file, (Set) set);
                if (a2 == null) {
                    f.a(file);
                } else {
                    if (h.b(a2.e())) {
                        if (b != 0) {
                            a2.b(jSONObject);
                            a2.b(true);
                            a2.a(true);
                        }
                    }
                    arrayList.add(a2);
                }
            }
            i++;
        }
        return arrayList;
    }

    public static void a(Context context) {
        File[] a = f.a(context.getFilesDir(), true);
        if (a != null) {
            for (File file : a) {
                if (file.getName().startsWith("jpush_stat_history")) {
                    f.d(file);
                }
            }
        }
    }

    public static void a(Context context, String str, String str2) {
        File[] a = f.a(context.getFilesDir(), new q());
        if (a != null && a.length != 0) {
            FileFilter rVar = new r(null);
            FileFilter sVar = new s(str2);
            for (File a2 : a) {
                try {
                    File[] a3 = f.a(a2, rVar);
                    if (a3 != null) {
                        if (a3.length != 0) {
                            for (File a4 : a3) {
                                File[] a5 = f.a(a4, sVar);
                                if (!(a5 == null || a5.length == 0)) {
                                    for (File d : a5) {
                                        f.d(d);
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static void a(File file) {
        b.remove(file);
    }

    private static void a(List<n> list, long j) {
        long j2 = 0;
        for (n a : list) {
            j2 += a.a();
        }
        long j3 = j2 - j;
        while (j3 > 0) {
            n nVar = (n) Collections.min(list, new u());
            long a2 = j3 - nVar.a();
            list.remove(nVar);
            f.a(nVar.c());
            j3 = a2;
        }
    }

    public static void b(Context context) {
        JCoreInterface.execute("REPORT_HISTORY", new t(context), new int[0]);
    }

    /* JADX WARNING: Missing block: B:19:0x0044, code skipped:
            return;
     */
    private static synchronized void d(android.content.Context r3) {
        /*
        r0 = cn.jiguang.d.d.p.class;
        monitor-enter(r0);
        r1 = a;	 Catch:{ all -> 0x0045 }
        if (r1 != 0) goto L_0x0043;
    L_0x0007:
        r1 = cn.jiguang.d.b.a.c(r3);	 Catch:{ all -> 0x0045 }
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ all -> 0x0045 }
        if (r2 == 0) goto L_0x0016;
    L_0x0011:
        r3 = 0;
        a = r3;	 Catch:{ all -> 0x0045 }
        monitor-exit(r0);
        return;
    L_0x0016:
        r2 = r3.getPackageName();	 Catch:{ all -> 0x0045 }
        r2 = r1.equals(r2);	 Catch:{ all -> 0x0045 }
        if (r2 == 0) goto L_0x0026;
    L_0x0020:
        r3 = "";
        a = r3;	 Catch:{ all -> 0x0045 }
        monitor-exit(r0);
        return;
    L_0x0026:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0045 }
        r2.<init>();	 Catch:{ all -> 0x0045 }
        r3 = r3.getPackageName();	 Catch:{ all -> 0x0045 }
        r2.append(r3);	 Catch:{ all -> 0x0045 }
        r3 = ":";
        r2.append(r3);	 Catch:{ all -> 0x0045 }
        r3 = r2.toString();	 Catch:{ all -> 0x0045 }
        r2 = "_";
        r3 = r1.replaceFirst(r3, r2);	 Catch:{ all -> 0x0045 }
        a = r3;	 Catch:{ all -> 0x0045 }
    L_0x0043:
        monitor-exit(r0);
        return;
    L_0x0045:
        r3 = move-exception;
        monitor-exit(r0);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.d.d.p.d(android.content.Context):void");
    }

    private static String e(Context context) {
        d(context);
        String str = a != null ? a : "";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.getFilesDir().getPath());
        stringBuilder.append(File.separator);
        stringBuilder.append("jpush_stat_history");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }
}
