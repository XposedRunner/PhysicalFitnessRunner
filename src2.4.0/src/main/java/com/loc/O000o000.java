package com.loc;

import android.content.Context;
import android.text.TextUtils;
import dalvik.system.DexFile;
import java.io.File;
import java.util.List;

/* compiled from: DexFileManager */
public final class O000o000 {

    /* compiled from: DexFileManager */
    public static class O000000o {
        static O00O000o O000000o(O000O0o o000O0o, String str) {
            List O00000Oo = o000O0o.O00000Oo(O00O000o.O00000Oo(str), O00O000o.class);
            return (O00000Oo == null || O00000Oo.size() <= 0) ? null : (O00O000o) O00000Oo.get(0);
        }

        public static List<O00O000o> O000000o(O000O0o o000O0o, String str, String str2) {
            return o000O0o.O00000Oo(O00O000o.O00000Oo(str, str2), O00O000o.class);
        }
    }

    static String O000000o(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.getFilesDir().getAbsolutePath());
        stringBuilder.append(File.separator);
        stringBuilder.append("pngex");
        return stringBuilder.toString();
    }

    static String O000000o(Context context, O000O0o o000O0o, OO0Oo0 oO0Oo0) {
        List O00000Oo = o000O0o.O00000Oo(O00O000o.O00000Oo(oO0Oo0.O000000o(), "copy"), O00O000o.class);
        if (O00000Oo == null || O00000Oo.size() == 0) {
            return null;
        }
        O00O00o0.O000000o(O00000Oo);
        int i = 0;
        while (i < O00000Oo.size()) {
            O00O000o o00O000o = (O00O000o) O00000Oo.get(i);
            String O000000o = o00O000o.O000000o();
            if (O00O00o0.O000000o(o000O0o, O000000o, O000000o(context, O000000o), oO0Oo0)) {
                try {
                    O000000o(context, o000O0o, oO0Oo0, O000000o(context, o00O000o.O000000o()), o00O000o.O00000oO());
                    return o00O000o.O00000oO();
                } catch (Throwable th) {
                    O0000Oo.O000000o(th, "FileManager", "loadAvailableD");
                }
            } else {
                O00000o0(context, o000O0o, o00O000o.O000000o());
                i++;
            }
        }
        return null;
    }

    public static String O000000o(Context context, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(O000000o(context));
        stringBuilder.append(File.separator);
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    static String O000000o(Context context, String str, String str2) {
        String O0000oo0 = OO0O0o0.O0000oo0(context);
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append(str2);
        stringBuilder2.append(O0000oo0);
        stringBuilder.append(OO0OOOO.O00000Oo(stringBuilder2.toString()));
        stringBuilder.append(".jar");
        return stringBuilder.toString();
    }

    static String O000000o(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(".o");
        return stringBuilder.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:74:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00fb  */
    static void O000000o(android.content.Context r17, com.loc.O000O0o r18, com.loc.OO0Oo0 r19, java.lang.String r20, java.lang.String r21) throws java.lang.Throwable {
        /*
        r1 = r17;
        r2 = r18;
        r3 = 0;
        r4 = 0;
        r8 = r19.O000000o();	 Catch:{ Throwable -> 0x00e0, all -> 0x00db }
        r5 = com.loc.O00O00Oo.O00000Oo();	 Catch:{ Throwable -> 0x00e0, all -> 0x00db }
        r6 = r19;
        r11 = r5.O000000o(r6);	 Catch:{ Throwable -> 0x00e0, all -> 0x00db }
        if (r11 == 0) goto L_0x002e;
    L_0x0016:
        r5 = r11.O000000o;	 Catch:{ Throwable -> 0x0029, all -> 0x0024 }
        if (r5 == 0) goto L_0x002e;
    L_0x001a:
        monitor-enter(r11);	 Catch:{ Throwable -> 0x0029, all -> 0x0024 }
        r11.wait();	 Catch:{ all -> 0x0020 }
        monitor-exit(r11);	 Catch:{ all -> 0x0020 }
        goto L_0x002e;
    L_0x0020:
        r0 = move-exception;
        r1 = r0;
        monitor-exit(r11);	 Catch:{ Throwable -> 0x0029, all -> 0x0024 }
        throw r1;	 Catch:{ Throwable -> 0x0029, all -> 0x0024 }
    L_0x0024:
        r0 = move-exception;
        r1 = r0;
        r12 = r3;
        goto L_0x00e9;
    L_0x0029:
        r0 = move-exception;
        r1 = r0;
        r2 = r3;
        goto L_0x00e4;
    L_0x002e:
        r5 = 1;
        r11.O00000Oo = r5;	 Catch:{ Throwable -> 0x0029, all -> 0x0024 }
        r5 = r19.O00000Oo();	 Catch:{ Throwable -> 0x0029, all -> 0x0024 }
        r7 = O000000o(r1, r8, r5);	 Catch:{ Throwable -> 0x0029, all -> 0x0024 }
        O000000o(r1, r2, r7);	 Catch:{ Throwable -> 0x0029, all -> 0x0024 }
        r5 = new java.io.File;	 Catch:{ Throwable -> 0x0029, all -> 0x0024 }
        r9 = r20;
        r5.<init>(r9);	 Catch:{ Throwable -> 0x0029, all -> 0x0024 }
        r12 = new java.io.FileInputStream;	 Catch:{ Throwable -> 0x0029, all -> 0x0024 }
        r12.<init>(r5);	 Catch:{ Throwable -> 0x0029, all -> 0x0024 }
        r5 = 32;
        r5 = new byte[r5];	 Catch:{ Throwable -> 0x00d6, all -> 0x00d3 }
        r12.read(r5);	 Catch:{ Throwable -> 0x00d6, all -> 0x00d3 }
        r5 = new java.io.File;	 Catch:{ Throwable -> 0x00d6, all -> 0x00d3 }
        r9 = r19.O00000Oo();	 Catch:{ Throwable -> 0x00d6, all -> 0x00d3 }
        r1 = O00000Oo(r1, r8, r9);	 Catch:{ Throwable -> 0x00d6, all -> 0x00d3 }
        r5.<init>(r1);	 Catch:{ Throwable -> 0x00d6, all -> 0x00d3 }
        r1 = new java.io.RandomAccessFile;	 Catch:{ Throwable -> 0x00d6, all -> 0x00d3 }
        r9 = "rw";
        r1.<init>(r5, r9);	 Catch:{ Throwable -> 0x00d6, all -> 0x00d3 }
        r3 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r9 = new byte[r3];	 Catch:{ Throwable -> 0x00ce, all -> 0x00cb }
        r10 = r4;
    L_0x0068:
        r13 = r12.read(r9);	 Catch:{ Throwable -> 0x00ce, all -> 0x00cb }
        if (r13 <= 0) goto L_0x0089;
    L_0x006e:
        if (r13 != r3) goto L_0x0078;
    L_0x0070:
        r14 = (long) r10;	 Catch:{ Throwable -> 0x00ce, all -> 0x00cb }
        r1.seek(r14);	 Catch:{ Throwable -> 0x00ce, all -> 0x00cb }
        r1.write(r9);	 Catch:{ Throwable -> 0x00ce, all -> 0x00cb }
        goto L_0x0084;
    L_0x0078:
        r14 = new byte[r13];	 Catch:{ Throwable -> 0x00ce, all -> 0x00cb }
        java.lang.System.arraycopy(r9, r4, r14, r4, r13);	 Catch:{ Throwable -> 0x00ce, all -> 0x00cb }
        r3 = (long) r10;	 Catch:{ Throwable -> 0x00ce, all -> 0x00cb }
        r1.seek(r3);	 Catch:{ Throwable -> 0x00ce, all -> 0x00cb }
        r1.write(r14);	 Catch:{ Throwable -> 0x00ce, all -> 0x00cb }
    L_0x0084:
        r10 = r10 + r13;
        r3 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r4 = 0;
        goto L_0x0068;
    L_0x0089:
        r3 = r5.getAbsolutePath();	 Catch:{ Throwable -> 0x00ce, all -> 0x00cb }
        r3 = com.loc.OO0OOOO.O000000o(r3);	 Catch:{ Throwable -> 0x00ce, all -> 0x00cb }
        r4 = new com.loc.O00O000o$O000000o;	 Catch:{ Throwable -> 0x00ce, all -> 0x00cb }
        r9 = r19.O00000Oo();	 Catch:{ Throwable -> 0x00ce, all -> 0x00cb }
        r5 = r4;
        r6 = r7;
        r7 = r3;
        r10 = r21;
        r5.<init>(r6, r7, r8, r9, r10);	 Catch:{ Throwable -> 0x00ce, all -> 0x00cb }
        r3 = "used";
        r3 = r4.O000000o(r3);	 Catch:{ Throwable -> 0x00ce, all -> 0x00cb }
        r3 = r3.O000000o();	 Catch:{ Throwable -> 0x00ce, all -> 0x00cb }
        r4 = r3.O000000o();	 Catch:{ Throwable -> 0x00ce, all -> 0x00cb }
        r4 = com.loc.O00O000o.O00000Oo(r4);	 Catch:{ Throwable -> 0x00ce, all -> 0x00cb }
        r2.O000000o(r3, r4);	 Catch:{ Throwable -> 0x00ce, all -> 0x00cb }
        com.loc.O00O00o0.O000000o(r12);	 Catch:{ Throwable -> 0x00b8 }
        goto L_0x00bc;
    L_0x00b8:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x00bc:
        com.loc.O00O00o0.O000000o(r1);	 Catch:{ Throwable -> 0x00c0 }
        goto L_0x00c4;
    L_0x00c0:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x00c4:
        if (r11 == 0) goto L_0x00ca;
    L_0x00c6:
        r1 = 0;
        r11.O00000Oo = r1;	 Catch:{ Throwable -> 0x00ca }
        return;
    L_0x00ca:
        return;
    L_0x00cb:
        r0 = move-exception;
        r3 = r1;
        goto L_0x00d4;
    L_0x00ce:
        r0 = move-exception;
        r2 = r1;
        r3 = r12;
        r1 = r0;
        goto L_0x00e4;
    L_0x00d3:
        r0 = move-exception;
    L_0x00d4:
        r1 = r0;
        goto L_0x00e9;
    L_0x00d6:
        r0 = move-exception;
        r1 = r0;
        r2 = r3;
        r3 = r12;
        goto L_0x00e4;
    L_0x00db:
        r0 = move-exception;
        r1 = r0;
        r11 = r3;
        r12 = r11;
        goto L_0x00e9;
    L_0x00e0:
        r0 = move-exception;
        r1 = r0;
        r2 = r3;
        r11 = r2;
    L_0x00e4:
        throw r1;	 Catch:{ all -> 0x00e5 }
    L_0x00e5:
        r0 = move-exception;
        r1 = r0;
        r12 = r3;
        r3 = r2;
    L_0x00e9:
        com.loc.O00O00o0.O000000o(r12);	 Catch:{ Throwable -> 0x00ed }
        goto L_0x00f1;
    L_0x00ed:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x00f1:
        com.loc.O00O00o0.O000000o(r3);	 Catch:{ Throwable -> 0x00f5 }
        goto L_0x00f9;
    L_0x00f5:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x00f9:
        if (r11 == 0) goto L_0x00fe;
    L_0x00fb:
        r2 = 0;
        r11.O00000Oo = r2;	 Catch:{ Throwable -> 0x00fe }
    L_0x00fe:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O000o000.O000000o(android.content.Context, com.loc.O000O0o, com.loc.OO0Oo0, java.lang.String, java.lang.String):void");
    }

    static void O000000o(Context context, O000O0o o000O0o, String str) {
        O00000o0(context, o000O0o, O000000o(str));
        O00000o0(context, o000O0o, str);
    }

    static void O000000o(Context context, OO0Oo0 oO0Oo0) {
        try {
            O000000o O000000o = O00O00Oo.O00000Oo().O000000o(oO0Oo0);
            if (O000000o != null && O000000o.O000000o) {
                synchronized (O000000o) {
                    O000000o.wait();
                }
            }
            O000000o.O00000Oo = true;
            String O00000Oo = O00000Oo(context, oO0Oo0.O000000o(), oO0Oo0.O00000Oo());
            if (!TextUtils.isEmpty(O00000Oo)) {
                File file = new File(O00000Oo);
                File parentFile = file.getParentFile();
                if (file.exists()) {
                    String O000000o2 = O000000o(context, O000000o(file.getName()));
                    DexFile loadDex = DexFile.loadDex(O00000Oo, O000000o2, 0);
                    if (loadDex != null) {
                        loadDex.close();
                        O00000Oo = null;
                        O000O0o o000O0o = new O000O0o(context, O000o.O00000Oo());
                        O00O000o O000000o3 = O000000o.O000000o(o000O0o, file.getName());
                        if (O000000o3 != null) {
                            O00000Oo = O000000o3.O00000oO();
                        }
                        String str = O00000Oo;
                        File file2 = new File(O000000o2);
                        if (!TextUtils.isEmpty(str) && file2.exists()) {
                            String O000000o4 = OO0OOOO.O000000o(O000000o2);
                            String name = file2.getName();
                            o000O0o.O000000o(new com.loc.O00O000o.O000000o(name, O000000o4, oO0Oo0.O000000o(), oO0Oo0.O00000Oo(), str).O000000o("useod").O000000o(), O00O000o.O00000Oo(name));
                        }
                    }
                    O000000o.O00000Oo = false;
                    return;
                }
                if (parentFile != null && parentFile.exists()) {
                    O00000o0(context, oO0Oo0.O000000o(), oO0Oo0.O00000Oo());
                }
            }
        } catch (Throwable th) {
            O0000Oo.O000000o(th, "BaseLoader", "getInstanceByThread()");
        }
    }

    static void O000000o(Context context, File file, OO0Oo0 oO0Oo0) {
        File parentFile = file.getParentFile();
        if (!file.exists() && parentFile != null && parentFile.exists()) {
            O00000o0(context, oO0Oo0.O000000o(), oO0Oo0.O00000Oo());
        }
    }

    static void O000000o(O000O0o o000O0o, Context context, String str) {
        List<O00O000o> O000000o = O000000o.O000000o(o000O0o, str, "used");
        if (O000000o != null && O000000o.size() > 0) {
            for (O00O000o o00O000o : O000000o) {
                if (o00O000o != null && o00O000o.O00000o0().equals(str)) {
                    O000000o(context, o000O0o, o00O000o.O000000o());
                    List O00000Oo = o000O0o.O00000Oo(O00O000o.O000000o(str, o00O000o.O00000oO()), O00O000o.class);
                    if (O00000Oo != null && O00000Oo.size() > 0) {
                        Object obj = (O00O000o) O00000Oo.get(0);
                        obj.O00000o0("errorstatus");
                        o000O0o.O000000o(obj, O00O000o.O00000Oo(obj.O000000o()));
                        File file = new File(O000000o(context, obj.O000000o()));
                        if (file.exists()) {
                            file.delete();
                        }
                    }
                }
            }
        }
    }

    static String O00000Oo(Context context, String str, String str2) {
        return O000000o(context, O000000o(context, str, str2));
    }

    static void O00000Oo(Context context, String str) {
        O000O0o o000O0o = new O000O0o(context, O000o.O00000Oo());
        List O000000o = O000000o.O000000o(o000O0o, str, "copy");
        O00O00o0.O000000o(O000000o);
        if (O000000o != null) {
            int i = 1;
            if (O000000o.size() > 1) {
                int size = O000000o.size();
                while (i < size) {
                    O00000o0(context, o000O0o, ((O00O000o) O000000o.get(i)).O000000o());
                    i++;
                }
            }
        }
    }

    private static void O00000o0(Context context, O000O0o o000O0o, String str) {
        File file = new File(O000000o(context, str));
        if (file.exists()) {
            file.delete();
        }
        o000O0o.O000000o(O00O000o.O00000Oo(str), O00O000o.class);
    }

    private static void O00000o0(final Context context, final String str, final String str2) {
        try {
            O00O00Oo.O00000Oo().O000000o().submit(new Runnable() {
                public final void run() {
                    try {
                        O000O0o o000O0o = new O000O0o(context, O000o.O00000Oo());
                        List<O00O000o> O00000Oo = o000O0o.O00000Oo(O00O000o.O000000o(str), O00O000o.class);
                        if (O00000Oo != null && O00000Oo.size() > 0) {
                            for (O00O000o o00O000o : O00000Oo) {
                                if (!str2.equalsIgnoreCase(o00O000o.O00000o())) {
                                    O000o000.O00000o0(context, o000O0o, o00O000o.O000000o());
                                }
                            }
                        }
                    } catch (Throwable th) {
                        O0000Oo.O000000o(th, "FileManager", "clearUnSuitableV");
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }
}
