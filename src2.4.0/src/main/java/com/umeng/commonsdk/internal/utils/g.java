package com.umeng.commonsdk.internal.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/* compiled from: ProcessUtil */
public class g {
    private static final String a = "\n";
    private static final byte[] b = "\nexit\n".getBytes();
    private static byte[] c = new byte[32];

    /* JADX WARNING: Removed duplicated region for block: B:68:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0068 A:{Splitter:B:13:0x0032, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00b8  */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:27:0x0061, code skipped:
            if (r9 != null) goto L_0x0063;
     */
    /* JADX WARNING: Missing block: B:28:0x0063, code skipped:
            c(r9);
     */
    /* JADX WARNING: Missing block: B:29:0x0068, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:79:0x00c6, code skipped:
            if (r9 != null) goto L_0x0063;
     */
    /* JADX WARNING: Missing block: B:89:0x00d3, code skipped:
            if (r9 != null) goto L_0x0063;
     */
    /* JADX WARNING: Missing block: B:90:0x00d6, code skipped:
            if (r7 != null) goto L_0x00d9;
     */
    /* JADX WARNING: Missing block: B:91:0x00d8, code skipped:
            return null;
     */
    /* JADX WARNING: Missing block: B:93:0x00dd, code skipped:
            return r7.toString();
     */
    public static java.lang.String a(java.lang.String... r9) {
        /*
        r0 = 0;
        r1 = new java.lang.ProcessBuilder;	 Catch:{ IOException -> 0x00c9, Exception -> 0x00bc, all -> 0x00ab }
        r2 = 0;
        r2 = new java.lang.String[r2];	 Catch:{ IOException -> 0x00c9, Exception -> 0x00bc, all -> 0x00ab }
        r1.<init>(r2);	 Catch:{ IOException -> 0x00c9, Exception -> 0x00bc, all -> 0x00ab }
        r9 = r1.command(r9);	 Catch:{ IOException -> 0x00c9, Exception -> 0x00bc, all -> 0x00ab }
        r9 = r9.start();	 Catch:{ IOException -> 0x00c9, Exception -> 0x00bc, all -> 0x00ab }
        r1 = r9.getOutputStream();	 Catch:{ IOException -> 0x00a9, Exception -> 0x00a7, all -> 0x009f }
        r2 = r9.getInputStream();	 Catch:{ IOException -> 0x009d, Exception -> 0x009b, all -> 0x0094 }
        r3 = r9.getErrorStream();	 Catch:{ IOException -> 0x0091, Exception -> 0x008f, all -> 0x0089 }
        r4 = b;	 Catch:{ IOException -> 0x0086, Exception -> 0x0083, all -> 0x007d }
        r1.write(r4);	 Catch:{ IOException -> 0x0086, Exception -> 0x0083, all -> 0x007d }
        r1.flush();	 Catch:{ IOException -> 0x0086, Exception -> 0x0083, all -> 0x007d }
        r9.waitFor();	 Catch:{ IOException -> 0x0086, Exception -> 0x0083, all -> 0x007d }
        r4 = new java.io.InputStreamReader;	 Catch:{ IOException -> 0x0086, Exception -> 0x0083, all -> 0x007d }
        r4.<init>(r2);	 Catch:{ IOException -> 0x0086, Exception -> 0x0083, all -> 0x007d }
        r5 = new java.io.BufferedReader;	 Catch:{ IOException -> 0x007a, Exception -> 0x0077, all -> 0x0071 }
        r5.<init>(r4);	 Catch:{ IOException -> 0x007a, Exception -> 0x0077, all -> 0x0071 }
        r6 = r5.readLine();	 Catch:{ IOException -> 0x006e, Exception -> 0x006b, all -> 0x0068 }
        if (r6 == 0) goto L_0x0054;
    L_0x0038:
        r7 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x006e, Exception -> 0x006b, all -> 0x0068 }
        r7.<init>();	 Catch:{ IOException -> 0x006e, Exception -> 0x006b, all -> 0x0068 }
        r7.append(r6);	 Catch:{ IOException -> 0x00d0, Exception -> 0x00c3, all -> 0x0068 }
        r6 = a;	 Catch:{ IOException -> 0x00d0, Exception -> 0x00c3, all -> 0x0068 }
        r7.append(r6);	 Catch:{ IOException -> 0x00d0, Exception -> 0x00c3, all -> 0x0068 }
    L_0x0045:
        r6 = r5.readLine();	 Catch:{ IOException -> 0x00d0, Exception -> 0x00c3, all -> 0x0068 }
        if (r6 == 0) goto L_0x0055;
    L_0x004b:
        r7.append(r6);	 Catch:{ IOException -> 0x00d0, Exception -> 0x00c3, all -> 0x0068 }
        r6 = a;	 Catch:{ IOException -> 0x00d0, Exception -> 0x00c3, all -> 0x0068 }
        r7.append(r6);	 Catch:{ IOException -> 0x00d0, Exception -> 0x00c3, all -> 0x0068 }
        goto L_0x0045;
    L_0x0054:
        r7 = r0;
    L_0x0055:
        r6 = c;	 Catch:{ IOException -> 0x00d0, Exception -> 0x00c3, all -> 0x0068 }
        r6 = r3.read(r6);	 Catch:{ IOException -> 0x00d0, Exception -> 0x00c3, all -> 0x0068 }
        if (r6 <= 0) goto L_0x005e;
    L_0x005d:
        goto L_0x0055;
    L_0x005e:
        a(r1, r3, r2, r4, r5);
        if (r9 == 0) goto L_0x00d6;
    L_0x0063:
        c(r9);
        goto L_0x00d6;
    L_0x0068:
        r0 = move-exception;
        goto L_0x00b3;
    L_0x006b:
        r7 = r0;
        goto L_0x00c3;
    L_0x006e:
        r7 = r0;
        goto L_0x00d0;
    L_0x0071:
        r5 = move-exception;
        r8 = r5;
        r5 = r0;
        r0 = r8;
        goto L_0x00b3;
    L_0x0077:
        r5 = r0;
        goto L_0x00c2;
    L_0x007a:
        r5 = r0;
        goto L_0x00cf;
    L_0x007d:
        r4 = move-exception;
        r5 = r0;
        r0 = r4;
        r4 = r5;
        goto L_0x00b3;
    L_0x0083:
        r4 = r0;
        goto L_0x00c1;
    L_0x0086:
        r4 = r0;
        goto L_0x00ce;
    L_0x0089:
        r3 = move-exception;
        r4 = r0;
        r5 = r4;
        r0 = r3;
        r3 = r5;
        goto L_0x00b3;
    L_0x008f:
        r3 = r0;
        goto L_0x00c0;
    L_0x0091:
        r3 = r0;
        goto L_0x00cd;
    L_0x0094:
        r2 = move-exception;
        r3 = r0;
        r4 = r3;
        r5 = r4;
        r0 = r2;
        r2 = r5;
        goto L_0x00b3;
    L_0x009b:
        r2 = r0;
        goto L_0x00bf;
    L_0x009d:
        r2 = r0;
        goto L_0x00cc;
    L_0x009f:
        r1 = move-exception;
        r2 = r0;
        r3 = r2;
        r4 = r3;
        r5 = r4;
        r0 = r1;
        r1 = r5;
        goto L_0x00b3;
    L_0x00a7:
        r1 = r0;
        goto L_0x00be;
    L_0x00a9:
        r1 = r0;
        goto L_0x00cb;
    L_0x00ab:
        r9 = move-exception;
        r1 = r0;
        r2 = r1;
        r3 = r2;
        r4 = r3;
        r5 = r4;
        r0 = r9;
        r9 = r5;
    L_0x00b3:
        a(r1, r3, r2, r4, r5);
        if (r9 == 0) goto L_0x00bb;
    L_0x00b8:
        c(r9);
    L_0x00bb:
        throw r0;
    L_0x00bc:
        r9 = r0;
        r1 = r9;
    L_0x00be:
        r2 = r1;
    L_0x00bf:
        r3 = r2;
    L_0x00c0:
        r4 = r3;
    L_0x00c1:
        r5 = r4;
    L_0x00c2:
        r7 = r5;
    L_0x00c3:
        a(r1, r3, r2, r4, r5);
        if (r9 == 0) goto L_0x00d6;
    L_0x00c8:
        goto L_0x0063;
    L_0x00c9:
        r9 = r0;
        r1 = r9;
    L_0x00cb:
        r2 = r1;
    L_0x00cc:
        r3 = r2;
    L_0x00cd:
        r4 = r3;
    L_0x00ce:
        r5 = r4;
    L_0x00cf:
        r7 = r5;
    L_0x00d0:
        a(r1, r3, r2, r4, r5);
        if (r9 == 0) goto L_0x00d6;
    L_0x00d5:
        goto L_0x0063;
    L_0x00d6:
        if (r7 != 0) goto L_0x00d9;
    L_0x00d8:
        return r0;
    L_0x00d9:
        r9 = r7.toString();
        return r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.utils.g.a(java.lang.String[]):java.lang.String");
    }

    private static void a(OutputStream outputStream, InputStream inputStream, InputStream inputStream2, InputStreamReader inputStreamReader, BufferedReader bufferedReader) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException unused) {
            }
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused2) {
            }
        }
        if (inputStream2 != null) {
            try {
                inputStream2.close();
            } catch (IOException unused3) {
            }
        }
        if (inputStreamReader != null) {
            try {
                inputStreamReader.close();
            } catch (IOException unused4) {
            }
        }
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException unused5) {
            }
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x000a */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:2|3|4|5|7) */
    /* JADX WARNING: Missing block: B:8:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:10:?, code skipped:
            return;
     */
    private static void a(java.lang.Process r1) {
        /*
        r0 = b(r1);
        if (r0 == 0) goto L_0x000d;
    L_0x0006:
        android.os.Process.killProcess(r0);	 Catch:{ Exception -> 0x000a }
        goto L_0x000d;
    L_0x000a:
        r1.destroy();	 Catch:{ Exception -> 0x000d }
    L_0x000d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.utils.g.a(java.lang.Process):void");
    }

    private static int b(Process process) {
        String obj = process.toString();
        try {
            return Integer.parseInt(obj.substring(obj.indexOf("=") + 1, obj.indexOf("]")));
        } catch (Exception unused) {
            return 0;
        }
    }

    private static void c(Process process) {
        if (process != null) {
            try {
                if (process.exitValue() != 0) {
                    a(process);
                }
            } catch (IllegalThreadStateException unused) {
                a(process);
            }
        }
    }
}
