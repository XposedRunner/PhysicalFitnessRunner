package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.mapcore.util.oO00OOOo.O000000o;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.util.Date;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* compiled from: DynamicLoader */
class oOo000o0 extends oOo000Oo {
    private PublicKey O0000Oo0 = null;

    oOo000o0(Context context, o0OO0o00 o0oo0o00, boolean z) throws Exception {
        super(context, o0oo0o00, z);
        String O00000Oo = oO00OOOo.O00000Oo(context, o0oo0o00.O000000o(), o0oo0o00.O00000Oo());
        String O000000o = oO00OOOo.O000000o(context);
        O00000Oo(O00000Oo, O000000o);
        File file = new File(O00000Oo);
        if (oO0OO000.O00000Oo().O000000o(this.O00000oO).O00000Oo) {
            throw new Exception("file is downloading");
        } else if (z) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(O000000o);
            stringBuilder.append(File.separator);
            stringBuilder.append(oO00OOOo.O000000o(file.getName()));
            O000000o(O00000Oo, stringBuilder.toString());
            O00000Oo(context, O00000Oo, O000000o);
        }
    }

    private void O000000o(oO0O0o0o oo0o0o0o, File file) {
        oOOoOOO0 O000000o = O000000o.O000000o(oo0o0o0o, file.getName());
        if (O000000o != null) {
            this.O00000oo = O000000o.O00000oO();
        }
    }

    private void O000000o(JarFile jarFile, JarEntry jarEntry) throws IOException {
        Throwable th;
        Closeable closeable = null;
        try {
            Closeable inputStream = jarFile.getInputStream(jarEntry);
            try {
                while (inputStream.read(new byte[8192]) > 0) {
                }
            } catch (Throwable th2) {
                th = th2;
                closeable = inputStream;
                oOo00ooO.O000000o(closeable);
                throw th;
            }
            try {
                oOo00ooO.O000000o(inputStream);
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
        } catch (Throwable th4) {
            th = th4;
            oOo00ooO.O000000o(th, "DyLoader", "loadJa");
            oOo00ooO.O000000o(closeable);
        }
    }

    private boolean O000000o(oO0O0o0o oo0o0o0o, o0OO0o00 o0oo0o00, String str) {
        return O000000o(new File(str)) ? oOo00ooO.O000000o(oo0o0o0o, oO00OOOo.O000000o(this.O000000o, o0oo0o00.O000000o(), o0oo0o00.O00000Oo()), str, o0oo0o00) : false;
    }

    private boolean O000000o(oO0O0o0o oo0o0o0o, String str, String str2) {
        String O000000o = oO00OOOo.O000000o(this.O000000o, str);
        if (oOo00ooO.O000000o(oo0o0o0o, str, O000000o, this.O00000oO)) {
            return true;
        }
        if (O000000o.O000000o(oo0o0o0o, str) != null) {
            return false;
        }
        if (!TextUtils.isEmpty(this.O00000oo)) {
            O000000o.O000000o(oo0o0o0o, new oOOoOOO0.O000000o(str, o0OO00o0.O000000o(O000000o), this.O00000oO.O000000o(), this.O00000oO.O00000Oo(), str2).O000000o("useod").O000000o(), oOOoOOO0.O00000Oo(str));
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0049 A:{SYNTHETIC, Splitter:B:40:0x0049} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0043 A:{SYNTHETIC, Splitter:B:35:0x0043} */
    private boolean O000000o(java.io.File r5) {
        /*
        r4 = this;
        r0 = 0;
        r1 = 0;
        r4.O00000o0();	 Catch:{ Throwable -> 0x0039 }
        r2 = new java.util.jar.JarFile;	 Catch:{ Throwable -> 0x0039 }
        r2.<init>(r5);	 Catch:{ Throwable -> 0x0039 }
        r1 = "classes.dex";
        r1 = r2.getJarEntry(r1);	 Catch:{ Throwable -> 0x0034, all -> 0x0031 }
        if (r1 != 0) goto L_0x0018;
    L_0x0012:
        if (r2 == 0) goto L_0x0017;
    L_0x0014:
        r2.close();	 Catch:{ Throwable -> 0x0017 }
    L_0x0017:
        return r0;
    L_0x0018:
        r4.O000000o(r2, r1);	 Catch:{ Throwable -> 0x0034, all -> 0x0031 }
        r1 = r1.getCertificates();	 Catch:{ Throwable -> 0x0034, all -> 0x0031 }
        if (r1 != 0) goto L_0x0027;
    L_0x0021:
        if (r2 == 0) goto L_0x0026;
    L_0x0023:
        r2.close();	 Catch:{ Throwable -> 0x0026 }
    L_0x0026:
        return r0;
    L_0x0027:
        r5 = r4.O000000o(r5, r1);	 Catch:{ Throwable -> 0x0034, all -> 0x0031 }
        if (r2 == 0) goto L_0x0030;
    L_0x002d:
        r2.close();	 Catch:{ Throwable -> 0x0030 }
    L_0x0030:
        return r5;
    L_0x0031:
        r5 = move-exception;
        r1 = r2;
        goto L_0x0047;
    L_0x0034:
        r5 = move-exception;
        r1 = r2;
        goto L_0x003a;
    L_0x0037:
        r5 = move-exception;
        goto L_0x0047;
    L_0x0039:
        r5 = move-exception;
    L_0x003a:
        r2 = "DyLoader";
        r3 = "verify";
        com.amap.api.mapcore.util.oOo00ooO.O000000o(r5, r2, r3);	 Catch:{ all -> 0x0037 }
        if (r1 == 0) goto L_0x0046;
    L_0x0043:
        r1.close();	 Catch:{ Throwable -> 0x0046 }
    L_0x0046:
        return r0;
    L_0x0047:
        if (r1 == 0) goto L_0x004c;
    L_0x0049:
        r1.close();	 Catch:{ Throwable -> 0x004c }
    L_0x004c:
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.oOo000o0.O000000o(java.io.File):boolean");
    }

    private boolean O000000o(File file, Certificate[] certificateArr) {
        try {
            if (certificateArr.length > 0) {
                int length = certificateArr.length - 1;
                if (length >= 0) {
                    certificateArr[length].verify(this.O0000Oo0);
                    return true;
                }
            }
        } catch (Exception e) {
            oOo00ooO.O000000o(e, "DyLoader", "check");
        }
        return false;
    }

    private void O00000Oo(final Context context, final String str, final String str2) {
        try {
            oO0OO000.O00000Oo().O000000o().submit(new Runnable() {
                public void run() {
                    try {
                        oOo000o0.this.O000000o(context, str, str2);
                    } catch (Throwable th) {
                        oOo00ooO.O000000o(th, "dLoader", "run()");
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    private void O00000Oo(oO0O0o0o oo0o0o0o, File file) {
        this.O00000o = false;
        oO00OOOo.O000000o(this.O000000o, oo0o0o0o, file.getName());
        String O000000o = oO00OOOo.O000000o(this.O000000o, oo0o0o0o, this.O00000oO);
        if (!TextUtils.isEmpty(O000000o)) {
            this.O00000oo = O000000o;
            oO00OOOo.O000000o(this.O000000o, this.O00000oO);
        }
    }

    private void O00000Oo(String str, String str2) throws Exception {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new Exception("dexPath or dexOutputDir is null.");
        }
    }

    private void O00000o0() {
        if (this.O0000Oo0 == null) {
            this.O0000Oo0 = oOo00ooO.O000000o();
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void O000000o(Context context, String str, String str2) throws Exception {
        new Date().getTime();
        try {
            oO0O0o0o oo0o0o0o = new oO0O0o0o(context, oO00Oo00.O000000o());
            File file = new File(str);
            O000000o(oo0o0o0o, file);
            if (!O000000o(oo0o0o0o, this.O00000oO, file.getAbsolutePath())) {
                O00000Oo(oo0o0o0o, file);
            }
            if (file.exists()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str2);
                stringBuilder.append(File.separator);
                stringBuilder.append(oO00OOOo.O000000o(file.getName()));
                if (new File(stringBuilder.toString()).exists()) {
                    if (!O000000o(oo0o0o0o, oO00OOOo.O000000o(file.getName()), this.O00000oo)) {
                        oO00OOOo.O000000o(this.O000000o, this.O00000oO);
                    }
                }
                new Date().getTime();
            }
        } catch (Throwable th) {
            oOo00ooO.O000000o(th, "dLoader", "verifyD()");
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0054 A:{SYNTHETIC, Splitter:B:39:0x0054} */
    public void O000000o(java.lang.String r5, java.lang.String r6) throws java.lang.Exception {
        /*
        r4 = this;
        r0 = 0;
        r1 = 0;
        r2 = r4.O00000o0;	 Catch:{ Throwable -> 0x0042 }
        if (r2 == 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r2 = com.amap.api.mapcore.util.oO0OO000.O00000Oo();	 Catch:{ Throwable -> 0x0042 }
        r3 = r4.O00000oO;	 Catch:{ Throwable -> 0x0042 }
        r2 = r2.O000000o(r3);	 Catch:{ Throwable -> 0x0042 }
        if (r2 == 0) goto L_0x001d;
    L_0x0013:
        r1 = 1;
        r2.O000000o = r1;	 Catch:{ Throwable -> 0x001a, all -> 0x0017 }
        goto L_0x001d;
    L_0x0017:
        r5 = move-exception;
        r1 = r2;
        goto L_0x0052;
    L_0x001a:
        r5 = move-exception;
        r1 = r2;
        goto L_0x0043;
    L_0x001d:
        r4.O00000Oo();	 Catch:{ Throwable -> 0x001a, all -> 0x0017 }
        r1 = r2.O00000Oo;	 Catch:{ Throwable -> 0x001a, all -> 0x0017 }
        if (r1 == 0) goto L_0x002c;
    L_0x0024:
        r5 = new java.lang.Exception;	 Catch:{ Throwable -> 0x001a, all -> 0x0017 }
        r6 = "file is downloading";
        r5.<init>(r6);	 Catch:{ Throwable -> 0x001a, all -> 0x0017 }
        throw r5;	 Catch:{ Throwable -> 0x001a, all -> 0x0017 }
    L_0x002c:
        r5 = dalvik.system.DexFile.loadDex(r5, r6, r0);	 Catch:{ Throwable -> 0x001a, all -> 0x0017 }
        r4.O00000o0 = r5;	 Catch:{ Throwable -> 0x001a, all -> 0x0017 }
        if (r2 == 0) goto L_0x003f;
    L_0x0034:
        r2.O000000o = r0;	 Catch:{ Throwable -> 0x003f }
        monitor-enter(r2);	 Catch:{ Throwable -> 0x003f }
        r2.notify();	 Catch:{ all -> 0x003c }
        monitor-exit(r2);	 Catch:{ all -> 0x003c }
        goto L_0x003f;
    L_0x003c:
        r5 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x003c }
        throw r5;	 Catch:{ Throwable -> 0x003f }
    L_0x003f:
        return;
    L_0x0040:
        r5 = move-exception;
        goto L_0x0052;
    L_0x0042:
        r5 = move-exception;
    L_0x0043:
        r6 = "dLoader";
        r2 = "loadFile";
        com.amap.api.mapcore.util.oOo00ooO.O000000o(r5, r6, r2);	 Catch:{ all -> 0x0040 }
        r5 = new java.lang.Exception;	 Catch:{ all -> 0x0040 }
        r6 = "load file fail";
        r5.<init>(r6);	 Catch:{ all -> 0x0040 }
        throw r5;	 Catch:{ all -> 0x0040 }
    L_0x0052:
        if (r1 == 0) goto L_0x005f;
    L_0x0054:
        r1.O000000o = r0;	 Catch:{ Throwable -> 0x005f }
        monitor-enter(r1);	 Catch:{ Throwable -> 0x005f }
        r1.notify();	 Catch:{ all -> 0x005c }
        monitor-exit(r1);	 Catch:{ all -> 0x005c }
        goto L_0x005f;
    L_0x005c:
        r6 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x005c }
        throw r6;	 Catch:{ Throwable -> 0x005f }
    L_0x005f:
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.oOo000o0.O000000o(java.lang.String, java.lang.String):void");
    }

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0080 A:{Splitter:B:1:0x0001, ExcHandler: ClassNotFoundException (r7_2 'e' java.lang.ClassNotFoundException A:{Catch:{  }}), Catch:{ all -> 0x0070 }} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0080 A:{Splitter:B:1:0x0001, ExcHandler: ClassNotFoundException (r7_2 'e' java.lang.ClassNotFoundException A:{Catch:{  }}), Catch:{ all -> 0x0070 }} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0080 A:{Splitter:B:1:0x0001, ExcHandler: ClassNotFoundException (r7_2 'e' java.lang.ClassNotFoundException A:{Catch:{  }}), Catch:{ all -> 0x0070 }} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:21:0x0021, code skipped:
            r2 = move-exception;
     */
    /* JADX WARNING: Missing block: B:22:0x0022, code skipped:
            r3 = r1;
     */
    /* JADX WARNING: Missing block: B:24:?, code skipped:
            com.amap.api.mapcore.util.oOo00ooO.O000000o(r2, "dLoader", "findCl");
     */
    /* JADX WARNING: Missing block: B:25:0x002a, code skipped:
            if (r3 != null) goto L_0x002c;
     */
    /* JADX WARNING: Missing block: B:26:0x002c, code skipped:
            r6.O0000OOo = false;
     */
    /* JADX WARNING: Missing block: B:27:0x002e, code skipped:
            return r3;
     */
    /* JADX WARNING: Missing block: B:30:0x0031, code skipped:
            if (r6.O0000O0o != false) goto L_0x0033;
     */
    /* JADX WARNING: Missing block: B:32:0x0038, code skipped:
            throw new java.lang.ClassNotFoundException(r7);
     */
    /* JADX WARNING: Missing block: B:33:0x0039, code skipped:
            r6.O0000OOo = true;
            r1 = r6.O00000o0.loadClass(r7, r6);
     */
    /* JADX WARNING: Missing block: B:34:0x0044, code skipped:
            monitor-enter(r6.O00000o0);
     */
    /* JADX WARNING: Missing block: B:36:?, code skipped:
            r6.O00000o0.notify();
     */
    /* JADX WARNING: Missing block: B:39:?, code skipped:
            r6.O0000OOo = false;
     */
    /* JADX WARNING: Missing block: B:40:0x004d, code skipped:
            if (r1 == null) goto L_0x004f;
     */
    /* JADX WARNING: Missing block: B:42:0x0054, code skipped:
            throw new java.lang.ClassNotFoundException(r7);
     */
    /* JADX WARNING: Missing block: B:45:0x0057, code skipped:
            monitor-enter(r6.O00000Oo);
     */
    /* JADX WARNING: Missing block: B:47:?, code skipped:
            r6.O00000Oo.put(r7, r1);
     */
    /* JADX WARNING: Missing block: B:65:0x0072, code skipped:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:67:?, code skipped:
            com.amap.api.mapcore.util.oOo00ooO.O000000o(r1, "dLoader", "findCl");
            r1 = new java.lang.ClassNotFoundException(r7);
     */
    /* JADX WARNING: Missing block: B:69:0x0080, code skipped:
            r7 = move-exception;
     */
    /* JADX WARNING: Missing block: B:70:0x0081, code skipped:
            throw r7;
     */
    /* JADX WARNING: Missing block: B:71:0x0082, code skipped:
            r6.O0000OOo = false;
     */
    public java.lang.Class<?> findClass(java.lang.String r7) throws java.lang.ClassNotFoundException {
        /*
        r6 = this;
        r0 = 0;
        r1 = r6.O00000o0;	 Catch:{ ClassNotFoundException -> 0x0080, Throwable -> 0x0072 }
        if (r1 != 0) goto L_0x000b;
    L_0x0005:
        r1 = new java.lang.ClassNotFoundException;	 Catch:{ ClassNotFoundException -> 0x0080, Throwable -> 0x0072 }
        r1.<init>(r7);	 Catch:{ ClassNotFoundException -> 0x0080, Throwable -> 0x0072 }
        throw r1;	 Catch:{ ClassNotFoundException -> 0x0080, Throwable -> 0x0072 }
    L_0x000b:
        r1 = 0;
        r2 = r6.O00000Oo;	 Catch:{ Throwable -> 0x0021, ClassNotFoundException -> 0x0080 }
        monitor-enter(r2);	 Catch:{ Throwable -> 0x0021, ClassNotFoundException -> 0x0080 }
        r3 = r6.O00000Oo;	 Catch:{ all -> 0x001e }
        r3 = r3.get(r7);	 Catch:{ all -> 0x001e }
        r3 = (java.lang.Class) r3;	 Catch:{ all -> 0x001e }
        monitor-exit(r2);	 Catch:{ all -> 0x0019 }
        goto L_0x002a;
    L_0x0019:
        r1 = move-exception;
        r5 = r3;
        r3 = r1;
        r1 = r5;
        goto L_0x001f;
    L_0x001e:
        r3 = move-exception;
    L_0x001f:
        monitor-exit(r2);	 Catch:{ all -> 0x001e }
        throw r3;	 Catch:{ Throwable -> 0x0021, ClassNotFoundException -> 0x0080 }
    L_0x0021:
        r2 = move-exception;
        r3 = r1;
        r1 = "dLoader";
        r4 = "findCl";
        com.amap.api.mapcore.util.oOo00ooO.O000000o(r2, r1, r4);	 Catch:{ ClassNotFoundException -> 0x0080, Throwable -> 0x0072 }
    L_0x002a:
        if (r3 == 0) goto L_0x002f;
    L_0x002c:
        r6.O0000OOo = r0;
        return r3;
    L_0x002f:
        r1 = r6.O0000O0o;	 Catch:{ ClassNotFoundException -> 0x0080, Throwable -> 0x0072 }
        if (r1 == 0) goto L_0x0039;
    L_0x0033:
        r1 = new java.lang.ClassNotFoundException;	 Catch:{ ClassNotFoundException -> 0x0080, Throwable -> 0x0072 }
        r1.<init>(r7);	 Catch:{ ClassNotFoundException -> 0x0080, Throwable -> 0x0072 }
        throw r1;	 Catch:{ ClassNotFoundException -> 0x0080, Throwable -> 0x0072 }
    L_0x0039:
        r1 = 1;
        r6.O0000OOo = r1;	 Catch:{ ClassNotFoundException -> 0x0080, Throwable -> 0x0072 }
        r1 = r6.O00000o0;	 Catch:{ ClassNotFoundException -> 0x0080, Throwable -> 0x0072 }
        r1 = r1.loadClass(r7, r6);	 Catch:{ ClassNotFoundException -> 0x0080, Throwable -> 0x0072 }
        r2 = r6.O00000o0;	 Catch:{ ClassNotFoundException -> 0x0080, Throwable -> 0x0072 }
        monitor-enter(r2);	 Catch:{ ClassNotFoundException -> 0x0080, Throwable -> 0x0072 }
        r3 = r6.O00000o0;	 Catch:{ all -> 0x006d }
        r3.notify();	 Catch:{ all -> 0x006d }
        monitor-exit(r2);	 Catch:{ all -> 0x006d }
        r6.O0000OOo = r0;	 Catch:{ ClassNotFoundException -> 0x0080, Throwable -> 0x0072 }
        if (r1 != 0) goto L_0x0055;
    L_0x004f:
        r1 = new java.lang.ClassNotFoundException;	 Catch:{ ClassNotFoundException -> 0x0080, Throwable -> 0x0072 }
        r1.<init>(r7);	 Catch:{ ClassNotFoundException -> 0x0080, Throwable -> 0x0072 }
        throw r1;	 Catch:{ ClassNotFoundException -> 0x0080, Throwable -> 0x0072 }
    L_0x0055:
        r2 = r6.O00000Oo;	 Catch:{ Throwable -> 0x0062, ClassNotFoundException -> 0x0080 }
        monitor-enter(r2);	 Catch:{ Throwable -> 0x0062, ClassNotFoundException -> 0x0080 }
        r3 = r6.O00000Oo;	 Catch:{ all -> 0x005f }
        r3.put(r7, r1);	 Catch:{ all -> 0x005f }
        monitor-exit(r2);	 Catch:{ all -> 0x005f }
        goto L_0x006a;
    L_0x005f:
        r3 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x005f }
        throw r3;	 Catch:{ Throwable -> 0x0062, ClassNotFoundException -> 0x0080 }
    L_0x0062:
        r2 = move-exception;
        r3 = "dLoader";
        r4 = "findCl";
        com.amap.api.mapcore.util.oOo00ooO.O000000o(r2, r3, r4);	 Catch:{ ClassNotFoundException -> 0x0080, Throwable -> 0x0072 }
    L_0x006a:
        r6.O0000OOo = r0;
        return r1;
    L_0x006d:
        r1 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x006d }
        throw r1;	 Catch:{ ClassNotFoundException -> 0x0080, Throwable -> 0x0072 }
    L_0x0070:
        r7 = move-exception;
        goto L_0x0082;
    L_0x0072:
        r1 = move-exception;
        r2 = "dLoader";
        r3 = "findCl";
        com.amap.api.mapcore.util.oOo00ooO.O000000o(r1, r2, r3);	 Catch:{ all -> 0x0070 }
        r1 = new java.lang.ClassNotFoundException;	 Catch:{ all -> 0x0070 }
        r1.<init>(r7);	 Catch:{ all -> 0x0070 }
        throw r1;	 Catch:{ all -> 0x0070 }
    L_0x0080:
        r7 = move-exception;
        throw r7;	 Catch:{ all -> 0x0070 }
    L_0x0082:
        r6.O0000OOo = r0;
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.oOo000o0.findClass(java.lang.String):java.lang.Class");
    }
}
