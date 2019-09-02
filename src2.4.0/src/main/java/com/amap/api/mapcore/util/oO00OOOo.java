package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import dalvik.system.DexFile;
import java.io.File;
import java.util.List;

/* compiled from: DexFileManager */
public class oO00OOOo {

    /* compiled from: DexFileManager */
    public static class O000000o {
        static oOOoOOO0 O000000o(oO0O0o0o oo0o0o0o, String str) {
            List O00000Oo = oo0o0o0o.O00000Oo(oOOoOOO0.O00000Oo(str), oOOoOOO0.class);
            return (O00000Oo == null || O00000Oo.size() <= 0) ? null : (oOOoOOO0) O00000Oo.get(0);
        }

        public static List<oOOoOOO0> O000000o(oO0O0o0o oo0o0o0o, String str, String str2) {
            return oo0o0o0o.O00000Oo(oOOoOOO0.O00000Oo(str, str2), oOOoOOO0.class);
        }

        public static void O000000o(oO0O0o0o oo0o0o0o, oOOoOOO0 ooooooo0, String str) {
            oo0o0o0o.O000000o((Object) ooooooo0, str);
        }
    }

    static String O000000o(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.getFilesDir().getAbsolutePath());
        stringBuilder.append(File.separator);
        stringBuilder.append("pngex");
        return stringBuilder.toString();
    }

    static String O000000o(Context context, oO0O0o0o oo0o0o0o, o0OO0o00 o0oo0o00) {
        List O00000Oo = oo0o0o0o.O00000Oo(oOOoOOO0.O00000Oo(o0oo0o00.O000000o(), "copy"), oOOoOOO0.class);
        String str = null;
        if (O00000Oo == null || O00000Oo.size() == 0) {
            return null;
        }
        oOo00ooO.O000000o(O00000Oo);
        int i = 0;
        while (i < O00000Oo.size()) {
            oOOoOOO0 ooooooo0 = (oOOoOOO0) O00000Oo.get(i);
            if (oOo00ooO.O000000o(context, oo0o0o0o, ooooooo0.O000000o(), o0oo0o00)) {
                try {
                    O000000o(context, oo0o0o0o, o0oo0o00, O000000o(context, ooooooo0.O000000o()), ooooooo0.O00000oO());
                    str = ooooooo0.O00000oO();
                    break;
                } catch (Throwable th) {
                    oOo00ooO.O000000o(th, "FileManager", "loadAvailableD");
                }
            } else {
                O00000o0(context, oo0o0o0o, ooooooo0.O000000o());
                i++;
            }
        }
        return str;
    }

    public static String O000000o(Context context, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(O000000o(context));
        stringBuilder.append(File.separator);
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    static String O000000o(Context context, String str, String str2) {
        String O0000oo0 = o0O0o000.O0000oo0(context);
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append(str2);
        stringBuilder2.append(O0000oo0);
        stringBuilder.append(o0OO00o0.O00000Oo(stringBuilder2.toString()));
        stringBuilder.append(".jar");
        return stringBuilder.toString();
    }

    static String O000000o(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(".o");
        return stringBuilder.toString();
    }

    static void O000000o(Context context, o0OO0o00 o0oo0o00) {
        try {
            O000000o O000000o = oO0OO000.O00000Oo().O000000o(o0oo0o00);
            if (O000000o != null && O000000o.O000000o) {
                synchronized (O000000o) {
                    O000000o.wait();
                }
            }
            O000000o.O00000Oo = true;
            String O00000Oo = O00000Oo(context, o0oo0o00.O000000o(), o0oo0o00.O00000Oo());
            if (!TextUtils.isEmpty(O00000Oo)) {
                File file = new File(O00000Oo);
                File parentFile = file.getParentFile();
                if (file.exists()) {
                    String O000000o2 = O000000o(context, O000000o(file.getName()));
                    DexFile loadDex = DexFile.loadDex(O00000Oo, O000000o2, 0);
                    if (loadDex != null) {
                        loadDex.close();
                        O000000o(context, file, O000000o2, o0oo0o00);
                    }
                    O000000o.O00000Oo = false;
                    return;
                }
                if (parentFile != null && parentFile.exists()) {
                    O00000o0(context, o0oo0o00.O000000o(), o0oo0o00.O00000Oo());
                }
            }
        } catch (Throwable th) {
            oOo00ooO.O000000o(th, "BaseLoader", "getInstanceByThread()");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:73:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00fa  */
    static void O000000o(android.content.Context r17, com.amap.api.mapcore.util.oO0O0o0o r18, com.amap.api.mapcore.util.o0OO0o00 r19, java.lang.String r20, java.lang.String r21) throws java.lang.Throwable {
        /*
        r1 = r17;
        r2 = r18;
        r3 = 0;
        r4 = 0;
        r8 = r19.O000000o();	 Catch:{ Throwable -> 0x00df, all -> 0x00da }
        r5 = com.amap.api.mapcore.util.oO0OO000.O00000Oo();	 Catch:{ Throwable -> 0x00df, all -> 0x00da }
        r6 = r19;
        r11 = r5.O000000o(r6);	 Catch:{ Throwable -> 0x00df, all -> 0x00da }
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
        monitor-exit(r11);	 Catch:{ all -> 0x0020 }
        throw r1;	 Catch:{ Throwable -> 0x0029, all -> 0x0024 }
    L_0x0024:
        r0 = move-exception;
        r1 = r0;
        r12 = r3;
        goto L_0x00e8;
    L_0x0029:
        r0 = move-exception;
        r1 = r0;
        r2 = r3;
        goto L_0x00e3;
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
        r5 = new byte[r5];	 Catch:{ Throwable -> 0x00d5, all -> 0x00d2 }
        r12.read(r5);	 Catch:{ Throwable -> 0x00d5, all -> 0x00d2 }
        r5 = new java.io.File;	 Catch:{ Throwable -> 0x00d5, all -> 0x00d2 }
        r9 = r19.O00000Oo();	 Catch:{ Throwable -> 0x00d5, all -> 0x00d2 }
        r1 = O00000Oo(r1, r8, r9);	 Catch:{ Throwable -> 0x00d5, all -> 0x00d2 }
        r5.<init>(r1);	 Catch:{ Throwable -> 0x00d5, all -> 0x00d2 }
        r1 = new java.io.RandomAccessFile;	 Catch:{ Throwable -> 0x00d5, all -> 0x00d2 }
        r9 = "rw";
        r1.<init>(r5, r9);	 Catch:{ Throwable -> 0x00d5, all -> 0x00d2 }
        r3 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r9 = new byte[r3];	 Catch:{ Throwable -> 0x00cd, all -> 0x00ca }
        r10 = r4;
    L_0x0068:
        r13 = r12.read(r9);	 Catch:{ Throwable -> 0x00cd, all -> 0x00ca }
        if (r13 <= 0) goto L_0x0089;
    L_0x006e:
        if (r13 != r3) goto L_0x0078;
    L_0x0070:
        r14 = (long) r10;	 Catch:{ Throwable -> 0x00cd, all -> 0x00ca }
        r1.seek(r14);	 Catch:{ Throwable -> 0x00cd, all -> 0x00ca }
        r1.write(r9);	 Catch:{ Throwable -> 0x00cd, all -> 0x00ca }
        goto L_0x0084;
    L_0x0078:
        r14 = new byte[r13];	 Catch:{ Throwable -> 0x00cd, all -> 0x00ca }
        java.lang.System.arraycopy(r9, r4, r14, r4, r13);	 Catch:{ Throwable -> 0x00cd, all -> 0x00ca }
        r3 = (long) r10;	 Catch:{ Throwable -> 0x00cd, all -> 0x00ca }
        r1.seek(r3);	 Catch:{ Throwable -> 0x00cd, all -> 0x00ca }
        r1.write(r14);	 Catch:{ Throwable -> 0x00cd, all -> 0x00ca }
    L_0x0084:
        r10 = r10 + r13;
        r3 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r4 = 0;
        goto L_0x0068;
    L_0x0089:
        r3 = r5.getAbsolutePath();	 Catch:{ Throwable -> 0x00cd, all -> 0x00ca }
        r3 = com.amap.api.mapcore.util.o0OO00o0.O000000o(r3);	 Catch:{ Throwable -> 0x00cd, all -> 0x00ca }
        r4 = new com.amap.api.mapcore.util.oOOoOOO0$O000000o;	 Catch:{ Throwable -> 0x00cd, all -> 0x00ca }
        r9 = r19.O00000Oo();	 Catch:{ Throwable -> 0x00cd, all -> 0x00ca }
        r5 = r4;
        r6 = r7;
        r7 = r3;
        r10 = r21;
        r5.<init>(r6, r7, r8, r9, r10);	 Catch:{ Throwable -> 0x00cd, all -> 0x00ca }
        r3 = "used";
        r3 = r4.O000000o(r3);	 Catch:{ Throwable -> 0x00cd, all -> 0x00ca }
        r3 = r3.O000000o();	 Catch:{ Throwable -> 0x00cd, all -> 0x00ca }
        r4 = r3.O000000o();	 Catch:{ Throwable -> 0x00cd, all -> 0x00ca }
        r4 = com.amap.api.mapcore.util.oOOoOOO0.O00000Oo(r4);	 Catch:{ Throwable -> 0x00cd, all -> 0x00ca }
        com.amap.api.mapcore.util.oO00OOOo.O000000o.O000000o(r2, r3, r4);	 Catch:{ Throwable -> 0x00cd, all -> 0x00ca }
        com.amap.api.mapcore.util.oOo00ooO.O000000o(r12);	 Catch:{ Throwable -> 0x00b8 }
        goto L_0x00bc;
    L_0x00b8:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x00bc:
        com.amap.api.mapcore.util.oOo00ooO.O000000o(r1);	 Catch:{ Throwable -> 0x00c0 }
        goto L_0x00c4;
    L_0x00c0:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x00c4:
        if (r11 == 0) goto L_0x00c9;
    L_0x00c6:
        r1 = 0;
        r11.O00000Oo = r1;	 Catch:{ Throwable -> 0x00c9 }
    L_0x00c9:
        return;
    L_0x00ca:
        r0 = move-exception;
        r3 = r1;
        goto L_0x00d3;
    L_0x00cd:
        r0 = move-exception;
        r2 = r1;
        r3 = r12;
        r1 = r0;
        goto L_0x00e3;
    L_0x00d2:
        r0 = move-exception;
    L_0x00d3:
        r1 = r0;
        goto L_0x00e8;
    L_0x00d5:
        r0 = move-exception;
        r1 = r0;
        r2 = r3;
        r3 = r12;
        goto L_0x00e3;
    L_0x00da:
        r0 = move-exception;
        r1 = r0;
        r11 = r3;
        r12 = r11;
        goto L_0x00e8;
    L_0x00df:
        r0 = move-exception;
        r1 = r0;
        r2 = r3;
        r11 = r2;
    L_0x00e3:
        throw r1;	 Catch:{ all -> 0x00e4 }
    L_0x00e4:
        r0 = move-exception;
        r1 = r0;
        r12 = r3;
        r3 = r2;
    L_0x00e8:
        com.amap.api.mapcore.util.oOo00ooO.O000000o(r12);	 Catch:{ Throwable -> 0x00ec }
        goto L_0x00f0;
    L_0x00ec:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x00f0:
        com.amap.api.mapcore.util.oOo00ooO.O000000o(r3);	 Catch:{ Throwable -> 0x00f4 }
        goto L_0x00f8;
    L_0x00f4:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x00f8:
        if (r11 == 0) goto L_0x00fd;
    L_0x00fa:
        r2 = 0;
        r11.O00000Oo = r2;	 Catch:{ Throwable -> 0x00fd }
    L_0x00fd:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.oO00OOOo.O000000o(android.content.Context, com.amap.api.mapcore.util.oO0O0o0o, com.amap.api.mapcore.util.o0OO0o00, java.lang.String, java.lang.String):void");
    }

    static void O000000o(Context context, oO0O0o0o oo0o0o0o, String str) {
        O00000o0(context, oo0o0o0o, O000000o(str));
        O00000o0(context, oo0o0o0o, str);
    }

    static void O000000o(Context context, File file, o0OO0o00 o0oo0o00) {
        File parentFile = file.getParentFile();
        if (!file.exists() && parentFile != null && parentFile.exists()) {
            O00000o0(context, o0oo0o00.O000000o(), o0oo0o00.O00000Oo());
        }
    }

    private static void O000000o(Context context, File file, String str, o0OO0o00 o0oo0o00) {
        oO0O0o0o oo0o0o0o = new oO0O0o0o(context, oO00Oo00.O000000o());
        oOOoOOO0 O000000o = O000000o.O000000o(oo0o0o0o, file.getName());
        String O00000oO = O000000o != null ? O000000o.O00000oO() : null;
        File file2 = new File(str);
        if (!TextUtils.isEmpty(O00000oO) && file2.exists()) {
            String O000000o2 = o0OO00o0.O000000o(str);
            String name = file2.getName();
            O000000o.O000000o(oo0o0o0o, new com.amap.api.mapcore.util.oOOoOOO0.O000000o(name, O000000o2, o0oo0o00.O000000o(), o0oo0o00.O00000Oo(), O00000oO).O000000o("useod").O000000o(), oOOoOOO0.O00000Oo(name));
        }
    }

    static void O000000o(oO0O0o0o oo0o0o0o, Context context, String str) {
        List<oOOoOOO0> O000000o = O000000o.O000000o(oo0o0o0o, str, "used");
        if (O000000o != null && O000000o.size() > 0) {
            for (oOOoOOO0 ooooooo0 : O000000o) {
                oOOoOOO0 ooooooo02;
                if (ooooooo02 != null && ooooooo02.O00000o0().equals(str)) {
                    O000000o(context, oo0o0o0o, ooooooo02.O000000o());
                    List O00000Oo = oo0o0o0o.O00000Oo(oOOoOOO0.O000000o(str, ooooooo02.O00000oO()), oOOoOOO0.class);
                    if (O00000Oo != null && O00000Oo.size() > 0) {
                        ooooooo02 = (oOOoOOO0) O00000Oo.get(0);
                        ooooooo02.O00000o0("errorstatus");
                        O000000o.O000000o(oo0o0o0o, ooooooo02, oOOoOOO0.O00000Oo(ooooooo02.O000000o()));
                        File file = new File(O000000o(context, ooooooo02.O000000o()));
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
        oO0O0o0o oo0o0o0o = new oO0O0o0o(context, oO00Oo00.O000000o());
        List O000000o = O000000o.O000000o(oo0o0o0o, str, "copy");
        oOo00ooO.O000000o(O000000o);
        if (O000000o != null) {
            int i = 1;
            if (O000000o.size() > 1) {
                int size = O000000o.size();
                while (i < size) {
                    O00000o0(context, oo0o0o0o, ((oOOoOOO0) O000000o.get(i)).O000000o());
                    i++;
                }
            }
        }
    }

    private static void O00000o0(Context context, oO0O0o0o oo0o0o0o, String str) {
        File file = new File(O000000o(context, str));
        if (file.exists()) {
            file.delete();
        }
        oo0o0o0o.O000000o(oOOoOOO0.O00000Oo(str), oOOoOOO0.class);
    }

    static void O00000o0(final Context context, final String str, final String str2) {
        try {
            oO0OO000.O00000Oo().O000000o().submit(new Runnable() {
                public void run() {
                    try {
                        oO0O0o0o oo0o0o0o = new oO0O0o0o(context, oO00Oo00.O000000o());
                        List<oOOoOOO0> O00000Oo = oo0o0o0o.O00000Oo(oOOoOOO0.O000000o(str), oOOoOOO0.class);
                        if (O00000Oo != null && O00000Oo.size() > 0) {
                            for (oOOoOOO0 ooooooo0 : O00000Oo) {
                                if (!str2.equalsIgnoreCase(ooooooo0.O00000o())) {
                                    oO00OOOo.O00000o0(context, oo0o0o0o, ooooooo0.O000000o());
                                }
                            }
                        }
                    } catch (Throwable th) {
                        oOo00ooO.O000000o(th, "FileManager", "clearUnSuitableV");
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }
}
