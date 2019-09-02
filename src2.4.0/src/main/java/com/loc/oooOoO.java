package com.loc;

import java.io.Closeable;
import java.io.IOException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* compiled from: DynamicLoader */
final class oooOoO extends O000Oo0 {
    private PublicKey O0000Oo0 = null;

    /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x0099 */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00be A:{SYNTHETIC, Splitter:B:47:0x00be} */
    oooOoO(final android.content.Context r7, com.loc.OO0Oo0 r8) throws java.lang.Exception {
        /*
        r6 = this;
        r6.<init>(r7, r8);
        r0 = 0;
        r6.O0000Oo0 = r0;
        r1 = r8.O000000o();
        r8 = r8.O00000Oo();
        r8 = com.loc.O000o000.O00000Oo(r7, r1, r8);
        r1 = com.loc.O000o000.O000000o(r7);
        r2 = android.text.TextUtils.isEmpty(r8);
        if (r2 != 0) goto L_0x00ca;
    L_0x001c:
        r2 = android.text.TextUtils.isEmpty(r1);
        if (r2 == 0) goto L_0x0024;
    L_0x0022:
        goto L_0x00ca;
    L_0x0024:
        r2 = new java.io.File;
        r2.<init>(r8);
        r3 = com.loc.O00O00Oo.O00000Oo();
        r4 = r6.O00000oO;
        r3 = r3.O000000o(r4);
        r3 = r3.O00000Oo;
        if (r3 == 0) goto L_0x003f;
    L_0x0037:
        r7 = new java.lang.Exception;
        r8 = "file is downloading";
        r7.<init>(r8);
        throw r7;
    L_0x003f:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r3.append(r1);
        r4 = java.io.File.separator;
        r3.append(r4);
        r2 = r2.getName();
        r2 = com.loc.O000o000.O000000o(r2);
        r3.append(r2);
        r2 = r3.toString();
        r3 = 0;
        r4 = r6.O00000o0;	 Catch:{ Throwable -> 0x00ac }
        if (r4 == 0) goto L_0x0061;
    L_0x0060:
        goto L_0x0099;
    L_0x0061:
        r4 = com.loc.O00O00Oo.O00000Oo();	 Catch:{ Throwable -> 0x00ac }
        r5 = r6.O00000oO;	 Catch:{ Throwable -> 0x00ac }
        r4 = r4.O000000o(r5);	 Catch:{ Throwable -> 0x00ac }
        if (r4 == 0) goto L_0x0077;
    L_0x006d:
        r0 = 1;
        r4.O000000o = r0;	 Catch:{ Throwable -> 0x0074, all -> 0x0071 }
        goto L_0x0077;
    L_0x0071:
        r7 = move-exception;
        r0 = r4;
        goto L_0x00bc;
    L_0x0074:
        r7 = move-exception;
        r0 = r4;
        goto L_0x00ad;
    L_0x0077:
        r6.O00000Oo();	 Catch:{ Throwable -> 0x0074, all -> 0x0071 }
        r0 = r4.O00000Oo;	 Catch:{ Throwable -> 0x0074, all -> 0x0071 }
        if (r0 == 0) goto L_0x0086;
    L_0x007e:
        r7 = new java.lang.Exception;	 Catch:{ Throwable -> 0x0074, all -> 0x0071 }
        r8 = "file is downloading";
        r7.<init>(r8);	 Catch:{ Throwable -> 0x0074, all -> 0x0071 }
        throw r7;	 Catch:{ Throwable -> 0x0074, all -> 0x0071 }
    L_0x0086:
        r0 = dalvik.system.DexFile.loadDex(r8, r2, r3);	 Catch:{ Throwable -> 0x0074, all -> 0x0071 }
        r6.O00000o0 = r0;	 Catch:{ Throwable -> 0x0074, all -> 0x0071 }
        if (r4 == 0) goto L_0x0099;
    L_0x008e:
        r4.O000000o = r3;	 Catch:{ Throwable -> 0x0099 }
        monitor-enter(r4);	 Catch:{ Throwable -> 0x0099 }
        r4.notify();	 Catch:{ all -> 0x0096 }
        monitor-exit(r4);	 Catch:{ all -> 0x0096 }
        goto L_0x0099;
    L_0x0096:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ Throwable -> 0x0099 }
        throw r0;	 Catch:{ Throwable -> 0x0099 }
    L_0x0099:
        r0 = com.loc.O00O00Oo.O00000Oo();	 Catch:{ Throwable -> 0x00a9 }
        r0 = r0.O000000o();	 Catch:{ Throwable -> 0x00a9 }
        r2 = new com.loc.oooOoO$1;	 Catch:{ Throwable -> 0x00a9 }
        r2.<init>(r7, r8, r1);	 Catch:{ Throwable -> 0x00a9 }
        r0.submit(r2);	 Catch:{ Throwable -> 0x00a9 }
    L_0x00a9:
        return;
    L_0x00aa:
        r7 = move-exception;
        goto L_0x00bc;
    L_0x00ac:
        r7 = move-exception;
    L_0x00ad:
        r8 = "dLoader";
        r1 = "loadFile";
        com.loc.O0000Oo.O000000o(r7, r8, r1);	 Catch:{ all -> 0x00aa }
        r7 = new java.lang.Exception;	 Catch:{ all -> 0x00aa }
        r8 = "load file fail";
        r7.<init>(r8);	 Catch:{ all -> 0x00aa }
        throw r7;	 Catch:{ all -> 0x00aa }
    L_0x00bc:
        if (r0 == 0) goto L_0x00c9;
    L_0x00be:
        r0.O000000o = r3;	 Catch:{ Throwable -> 0x00c9 }
        monitor-enter(r0);	 Catch:{ Throwable -> 0x00c9 }
        r0.notify();	 Catch:{ all -> 0x00c6 }
        monitor-exit(r0);	 Catch:{ all -> 0x00c6 }
        goto L_0x00c9;
    L_0x00c6:
        r8 = move-exception;
        monitor-exit(r0);	 Catch:{ Throwable -> 0x00c9 }
        throw r8;	 Catch:{ Throwable -> 0x00c9 }
    L_0x00c9:
        throw r7;
    L_0x00ca:
        r7 = new java.lang.Exception;
        r8 = "dexPath or dexOutputDir is null.";
        r7.<init>(r8);
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.oooOoO.<init>(android.content.Context, com.loc.OO0Oo0):void");
    }

    private static void O000000o(JarFile jarFile, JarEntry jarEntry) throws IOException {
        Throwable th;
        Closeable closeable = null;
        try {
            Closeable inputStream = jarFile.getInputStream(jarEntry);
            try {
                do {
                } while (inputStream.read(new byte[8192]) > 0);
                try {
                    O00O00o0.O000000o(inputStream);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            } catch (Throwable th3) {
                th = th3;
                closeable = inputStream;
                O00O00o0.O000000o(closeable);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            O0000Oo.O000000o(th, "DyLoader", "loadJa");
            O00O00o0.O000000o(closeable);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x004a A:{SYNTHETIC, Splitter:B:40:0x004a} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0044 A:{SYNTHETIC, Splitter:B:35:0x0044} */
    private boolean O000000o(java.io.File r5) {
        /*
        r4 = this;
        r0 = 0;
        r1 = 0;
        r2 = r4.O0000Oo0;	 Catch:{ Throwable -> 0x003a }
        if (r2 != 0) goto L_0x000c;
    L_0x0006:
        r2 = com.loc.O00O00o0.O000000o();	 Catch:{ Throwable -> 0x003a }
        r4.O0000Oo0 = r2;	 Catch:{ Throwable -> 0x003a }
    L_0x000c:
        r2 = new java.util.jar.JarFile;	 Catch:{ Throwable -> 0x003a }
        r2.<init>(r5);	 Catch:{ Throwable -> 0x003a }
        r5 = "classes.dex";
        r5 = r2.getJarEntry(r5);	 Catch:{ Throwable -> 0x0035, all -> 0x0032 }
        if (r5 != 0) goto L_0x001d;
    L_0x0019:
        r2.close();	 Catch:{ Throwable -> 0x001c }
    L_0x001c:
        return r0;
    L_0x001d:
        O000000o(r2, r5);	 Catch:{ Throwable -> 0x0035, all -> 0x0032 }
        r5 = r5.getCertificates();	 Catch:{ Throwable -> 0x0035, all -> 0x0032 }
        if (r5 != 0) goto L_0x002a;
    L_0x0026:
        r2.close();	 Catch:{ Throwable -> 0x0029 }
    L_0x0029:
        return r0;
    L_0x002a:
        r5 = r4.O000000o(r5);	 Catch:{ Throwable -> 0x0035, all -> 0x0032 }
        r2.close();	 Catch:{ Throwable -> 0x0031 }
    L_0x0031:
        return r5;
    L_0x0032:
        r5 = move-exception;
        r1 = r2;
        goto L_0x0048;
    L_0x0035:
        r5 = move-exception;
        r1 = r2;
        goto L_0x003b;
    L_0x0038:
        r5 = move-exception;
        goto L_0x0048;
    L_0x003a:
        r5 = move-exception;
    L_0x003b:
        r2 = "DyLoader";
        r3 = "verify";
        com.loc.O0000Oo.O000000o(r5, r2, r3);	 Catch:{ all -> 0x0038 }
        if (r1 == 0) goto L_0x0047;
    L_0x0044:
        r1.close();	 Catch:{ Throwable -> 0x0047 }
    L_0x0047:
        return r0;
    L_0x0048:
        if (r1 == 0) goto L_0x004d;
    L_0x004a:
        r1.close();	 Catch:{ Throwable -> 0x004d }
    L_0x004d:
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.oooOoO.O000000o(java.io.File):boolean");
    }

    private boolean O000000o(Certificate[] certificateArr) {
        try {
            if (certificateArr.length > 0) {
                int length = certificateArr.length - 1;
                if (length >= 0) {
                    certificateArr[length].verify(this.O0000Oo0);
                    return true;
                }
            }
        } catch (Exception e) {
            O0000Oo.O000000o(e, "DyLoader", "check");
        }
        return false;
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00f0 A:{Catch:{ Throwable -> 0x00f8 }} */
    public final void O000000o(android.content.Context r11, java.lang.String r12, java.lang.String r13) throws java.lang.Exception {
        /*
        r10 = this;
        r0 = new java.util.Date;
        r0.<init>();
        r0.getTime();
        r0 = new com.loc.O000O0o;	 Catch:{ Throwable -> 0x00f8 }
        r1 = com.loc.O000o.O00000Oo();	 Catch:{ Throwable -> 0x00f8 }
        r0.<init>(r11, r1);	 Catch:{ Throwable -> 0x00f8 }
        r11 = new java.io.File;	 Catch:{ Throwable -> 0x00f8 }
        r11.<init>(r12);	 Catch:{ Throwable -> 0x00f8 }
        r12 = r11.getName();	 Catch:{ Throwable -> 0x00f8 }
        r12 = com.loc.O000o000.O000000o.O000000o(r0, r12);	 Catch:{ Throwable -> 0x00f8 }
        if (r12 == 0) goto L_0x0026;
    L_0x0020:
        r12 = r12.O00000oO();	 Catch:{ Throwable -> 0x00f8 }
        r10.O00000oo = r12;	 Catch:{ Throwable -> 0x00f8 }
    L_0x0026:
        r12 = r10.O00000oO;	 Catch:{ Throwable -> 0x00f8 }
        r1 = r11.getAbsolutePath();	 Catch:{ Throwable -> 0x00f8 }
        r2 = new java.io.File;	 Catch:{ Throwable -> 0x00f8 }
        r2.<init>(r1);	 Catch:{ Throwable -> 0x00f8 }
        r2 = r10.O000000o(r2);	 Catch:{ Throwable -> 0x00f8 }
        r3 = 0;
        if (r2 == 0) goto L_0x004b;
    L_0x0038:
        r2 = r10.O000000o;	 Catch:{ Throwable -> 0x00f8 }
        r4 = r12.O000000o();	 Catch:{ Throwable -> 0x00f8 }
        r5 = r12.O00000Oo();	 Catch:{ Throwable -> 0x00f8 }
        r2 = com.loc.O000o000.O000000o(r2, r4, r5);	 Catch:{ Throwable -> 0x00f8 }
        r12 = com.loc.O00O00o0.O000000o(r0, r2, r1, r12);	 Catch:{ Throwable -> 0x00f8 }
        goto L_0x004c;
    L_0x004b:
        r12 = r3;
    L_0x004c:
        if (r12 != 0) goto L_0x0070;
    L_0x004e:
        r10.O00000o = r3;	 Catch:{ Throwable -> 0x00f8 }
        r12 = r10.O000000o;	 Catch:{ Throwable -> 0x00f8 }
        r1 = r11.getName();	 Catch:{ Throwable -> 0x00f8 }
        com.loc.O000o000.O000000o(r12, r0, r1);	 Catch:{ Throwable -> 0x00f8 }
        r12 = r10.O000000o;	 Catch:{ Throwable -> 0x00f8 }
        r1 = r10.O00000oO;	 Catch:{ Throwable -> 0x00f8 }
        r12 = com.loc.O000o000.O000000o(r12, r0, r1);	 Catch:{ Throwable -> 0x00f8 }
        r1 = android.text.TextUtils.isEmpty(r12);	 Catch:{ Throwable -> 0x00f8 }
        if (r1 != 0) goto L_0x0070;
    L_0x0067:
        r10.O00000oo = r12;	 Catch:{ Throwable -> 0x00f8 }
        r12 = r10.O000000o;	 Catch:{ Throwable -> 0x00f8 }
        r1 = r10.O00000oO;	 Catch:{ Throwable -> 0x00f8 }
        com.loc.O000o000.O000000o(r12, r1);	 Catch:{ Throwable -> 0x00f8 }
    L_0x0070:
        r12 = r11.exists();	 Catch:{ Throwable -> 0x00f8 }
        if (r12 != 0) goto L_0x0077;
    L_0x0076:
        return;
    L_0x0077:
        r12 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00f8 }
        r12.<init>();	 Catch:{ Throwable -> 0x00f8 }
        r12.append(r13);	 Catch:{ Throwable -> 0x00f8 }
        r13 = java.io.File.separator;	 Catch:{ Throwable -> 0x00f8 }
        r12.append(r13);	 Catch:{ Throwable -> 0x00f8 }
        r13 = r11.getName();	 Catch:{ Throwable -> 0x00f8 }
        r13 = com.loc.O000o000.O000000o(r13);	 Catch:{ Throwable -> 0x00f8 }
        r12.append(r13);	 Catch:{ Throwable -> 0x00f8 }
        r12 = r12.toString();	 Catch:{ Throwable -> 0x00f8 }
        r13 = new java.io.File;	 Catch:{ Throwable -> 0x00f8 }
        r13.<init>(r12);	 Catch:{ Throwable -> 0x00f8 }
        r12 = r13.exists();	 Catch:{ Throwable -> 0x00f8 }
        if (r12 == 0) goto L_0x0100;
    L_0x009e:
        r11 = r11.getName();	 Catch:{ Throwable -> 0x00f8 }
        r11 = com.loc.O000o000.O000000o(r11);	 Catch:{ Throwable -> 0x00f8 }
        r9 = r10.O00000oo;	 Catch:{ Throwable -> 0x00f8 }
        r12 = r10.O000000o;	 Catch:{ Throwable -> 0x00f8 }
        r12 = com.loc.O000o000.O000000o(r12, r11);	 Catch:{ Throwable -> 0x00f8 }
        r13 = r10.O00000oO;	 Catch:{ Throwable -> 0x00f8 }
        r13 = com.loc.O00O00o0.O000000o(r0, r11, r12, r13);	 Catch:{ Throwable -> 0x00f8 }
        if (r13 != 0) goto L_0x00ed;
    L_0x00b6:
        r13 = com.loc.O000o000.O000000o.O000000o(r0, r11);	 Catch:{ Throwable -> 0x00f8 }
        if (r13 == 0) goto L_0x00bd;
    L_0x00bc:
        goto L_0x00ee;
    L_0x00bd:
        r13 = r10.O00000oo;	 Catch:{ Throwable -> 0x00f8 }
        r13 = android.text.TextUtils.isEmpty(r13);	 Catch:{ Throwable -> 0x00f8 }
        if (r13 != 0) goto L_0x00ed;
    L_0x00c5:
        r13 = new com.loc.O00O000o$O000000o;	 Catch:{ Throwable -> 0x00f8 }
        r6 = com.loc.OO0OOOO.O000000o(r12);	 Catch:{ Throwable -> 0x00f8 }
        r12 = r10.O00000oO;	 Catch:{ Throwable -> 0x00f8 }
        r7 = r12.O000000o();	 Catch:{ Throwable -> 0x00f8 }
        r12 = r10.O00000oO;	 Catch:{ Throwable -> 0x00f8 }
        r8 = r12.O00000Oo();	 Catch:{ Throwable -> 0x00f8 }
        r4 = r13;
        r5 = r11;
        r4.<init>(r5, r6, r7, r8, r9);	 Catch:{ Throwable -> 0x00f8 }
        r12 = "useod";
        r12 = r13.O000000o(r12);	 Catch:{ Throwable -> 0x00f8 }
        r12 = r12.O000000o();	 Catch:{ Throwable -> 0x00f8 }
        r11 = com.loc.O00O000o.O00000Oo(r11);	 Catch:{ Throwable -> 0x00f8 }
        r0.O000000o(r12, r11);	 Catch:{ Throwable -> 0x00f8 }
    L_0x00ed:
        r3 = 1;
    L_0x00ee:
        if (r3 != 0) goto L_0x0100;
    L_0x00f0:
        r11 = r10.O000000o;	 Catch:{ Throwable -> 0x00f8 }
        r12 = r10.O00000oO;	 Catch:{ Throwable -> 0x00f8 }
        com.loc.O000o000.O000000o(r11, r12);	 Catch:{ Throwable -> 0x00f8 }
        goto L_0x0100;
    L_0x00f8:
        r11 = move-exception;
        r12 = "dLoader";
        r13 = "verifyD()";
        com.loc.O0000Oo.O000000o(r11, r12, r13);
    L_0x0100:
        r11 = new java.util.Date;
        r11.<init>();
        r11.getTime();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.oooOoO.O000000o(android.content.Context, java.lang.String, java.lang.String):void");
    }

    /* Access modifiers changed, original: protected|final */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0080 A:{Splitter:B:1:0x0001, ExcHandler: ClassNotFoundException (r7_2 'e' java.lang.ClassNotFoundException A:{Catch:{  }}), Catch:{ all -> 0x0070 }} */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0080 A:{Splitter:B:1:0x0001, ExcHandler: ClassNotFoundException (r7_2 'e' java.lang.ClassNotFoundException A:{Catch:{  }}), Catch:{ all -> 0x0070 }} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:20:0x0021, code skipped:
            r2 = move-exception;
     */
    /* JADX WARNING: Missing block: B:21:0x0022, code skipped:
            r3 = r1;
     */
    /* JADX WARNING: Missing block: B:23:?, code skipped:
            com.loc.O0000Oo.O000000o(r2, "dLoader", "findCl");
     */
    /* JADX WARNING: Missing block: B:24:0x002a, code skipped:
            if (r3 != null) goto L_0x002c;
     */
    /* JADX WARNING: Missing block: B:25:0x002c, code skipped:
            r6.O0000OOo = false;
     */
    /* JADX WARNING: Missing block: B:26:0x002e, code skipped:
            return r3;
     */
    /* JADX WARNING: Missing block: B:29:0x0031, code skipped:
            if (r6.O0000O0o != false) goto L_0x0033;
     */
    /* JADX WARNING: Missing block: B:31:0x0038, code skipped:
            throw new java.lang.ClassNotFoundException(r7);
     */
    /* JADX WARNING: Missing block: B:32:0x0039, code skipped:
            r6.O0000OOo = true;
            r1 = r6.O00000o0.loadClass(r7, r6);
     */
    /* JADX WARNING: Missing block: B:33:0x0044, code skipped:
            monitor-enter(r6.O00000o0);
     */
    /* JADX WARNING: Missing block: B:35:?, code skipped:
            r6.O00000o0.notify();
     */
    /* JADX WARNING: Missing block: B:38:?, code skipped:
            r6.O0000OOo = false;
     */
    /* JADX WARNING: Missing block: B:39:0x004d, code skipped:
            if (r1 == null) goto L_0x004f;
     */
    /* JADX WARNING: Missing block: B:41:0x0054, code skipped:
            throw new java.lang.ClassNotFoundException(r7);
     */
    /* JADX WARNING: Missing block: B:44:0x0057, code skipped:
            monitor-enter(r6.O00000Oo);
     */
    /* JADX WARNING: Missing block: B:46:?, code skipped:
            r6.O00000Oo.put(r7, r1);
     */
    /* JADX WARNING: Missing block: B:62:0x0072, code skipped:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:64:?, code skipped:
            com.loc.O0000Oo.O000000o(r1, "dLoader", "findCl");
            r1 = new java.lang.ClassNotFoundException(r7);
     */
    /* JADX WARNING: Missing block: B:66:0x0080, code skipped:
            r7 = move-exception;
     */
    /* JADX WARNING: Missing block: B:67:0x0081, code skipped:
            throw r7;
     */
    /* JADX WARNING: Missing block: B:68:0x0082, code skipped:
            r6.O0000OOo = false;
     */
    public final java.lang.Class<?> findClass(java.lang.String r7) throws java.lang.ClassNotFoundException {
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
        monitor-exit(r2);	 Catch:{ Throwable -> 0x0021, ClassNotFoundException -> 0x0080 }
        throw r3;	 Catch:{ Throwable -> 0x0021, ClassNotFoundException -> 0x0080 }
    L_0x0021:
        r2 = move-exception;
        r3 = r1;
        r1 = "dLoader";
        r4 = "findCl";
        com.loc.O0000Oo.O000000o(r2, r1, r4);	 Catch:{ ClassNotFoundException -> 0x0080, Throwable -> 0x0072 }
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
        monitor-exit(r2);	 Catch:{ Throwable -> 0x0062, ClassNotFoundException -> 0x0080 }
        throw r3;	 Catch:{ Throwable -> 0x0062, ClassNotFoundException -> 0x0080 }
    L_0x0062:
        r2 = move-exception;
        r3 = "dLoader";
        r4 = "findCl";
        com.loc.O0000Oo.O000000o(r2, r3, r4);	 Catch:{ ClassNotFoundException -> 0x0080, Throwable -> 0x0072 }
    L_0x006a:
        r6.O0000OOo = r0;
        return r1;
    L_0x006d:
        r1 = move-exception;
        monitor-exit(r2);	 Catch:{ ClassNotFoundException -> 0x0080, Throwable -> 0x0072 }
        throw r1;	 Catch:{ ClassNotFoundException -> 0x0080, Throwable -> 0x0072 }
    L_0x0070:
        r7 = move-exception;
        goto L_0x0082;
    L_0x0072:
        r1 = move-exception;
        r2 = "dLoader";
        r3 = "findCl";
        com.loc.O0000Oo.O000000o(r1, r2, r3);	 Catch:{ all -> 0x0070 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.loc.oooOoO.findClass(java.lang.String):java.lang.Class");
    }
}
