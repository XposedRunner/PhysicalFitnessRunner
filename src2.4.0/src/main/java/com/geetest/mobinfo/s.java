package com.geetest.mobinfo;

import com.bangcle.andJni.JniLib1557756502;

/* compiled from: IOUtils */
public class s {
    private static final String a = "s";

    /* JADX WARNING: Removed duplicated region for block: B:48:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x007b A:{SYNTHETIC, Splitter:B:52:0x007b} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0085 A:{SYNTHETIC, Splitter:B:57:0x0085} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0059 A:{SYNTHETIC, Splitter:B:39:0x0059} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0063 A:{SYNTHETIC, Splitter:B:44:0x0063} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x007b A:{SYNTHETIC, Splitter:B:52:0x007b} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0085 A:{SYNTHETIC, Splitter:B:57:0x0085} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0059 A:{SYNTHETIC, Splitter:B:39:0x0059} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0063 A:{SYNTHETIC, Splitter:B:44:0x0063} */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x007b A:{SYNTHETIC, Splitter:B:52:0x007b} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0085 A:{SYNTHETIC, Splitter:B:57:0x0085} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0059 A:{SYNTHETIC, Splitter:B:39:0x0059} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0063 A:{SYNTHETIC, Splitter:B:44:0x0063} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0039 A:{Splitter:B:5:0x000b, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:22:0x0034, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:23:0x0035, code skipped:
            r3 = r1;
            r1 = r4;
            r4 = r0;
     */
    /* JADX WARNING: Missing block: B:24:0x0039, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:40:?, code skipped:
            r0.close();
     */
    /* JADX WARNING: Missing block: B:41:0x005d, code skipped:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:42:0x005e, code skipped:
            r4.printStackTrace();
     */
    /* JADX WARNING: Missing block: B:45:?, code skipped:
            r1.close();
     */
    /* JADX WARNING: Missing block: B:53:?, code skipped:
            r1.close();
     */
    /* JADX WARNING: Missing block: B:54:0x007f, code skipped:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:55:0x0080, code skipped:
            r1.printStackTrace();
     */
    /* JADX WARNING: Missing block: B:58:?, code skipped:
            r4.close();
     */
    /* JADX WARNING: Missing block: B:59:0x0089, code skipped:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:60:0x008a, code skipped:
            r4.printStackTrace();
     */
    public static java.lang.String a(java.lang.String r4) {
        /*
        r0 = 0;
        r1 = new java.io.FileReader;	 Catch:{ Exception -> 0x0051, all -> 0x004c }
        r1.<init>(r4);	 Catch:{ Exception -> 0x0051, all -> 0x004c }
        r4 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x0047, all -> 0x0042 }
        r4.<init>(r1);	 Catch:{ Exception -> 0x0047, all -> 0x0042 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x003b, all -> 0x0039 }
        r2.<init>();	 Catch:{ Exception -> 0x003b, all -> 0x0039 }
    L_0x0010:
        r0 = r4.readLine();	 Catch:{ Exception -> 0x0034, all -> 0x0039 }
        if (r0 == 0) goto L_0x001f;
    L_0x0016:
        r2.append(r0);	 Catch:{ Exception -> 0x0034, all -> 0x0039 }
        r0 = "\n";
        r2.append(r0);	 Catch:{ Exception -> 0x0034, all -> 0x0039 }
        goto L_0x0010;
    L_0x001f:
        if (r1 == 0) goto L_0x0029;
    L_0x0021:
        r1.close();	 Catch:{ IOException -> 0x0025 }
        goto L_0x0029;
    L_0x0025:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x0029:
        if (r4 == 0) goto L_0x0066;
    L_0x002b:
        r4.close();	 Catch:{ IOException -> 0x002f }
        goto L_0x0066;
    L_0x002f:
        r4 = move-exception;
        r4.printStackTrace();
        goto L_0x0066;
    L_0x0034:
        r0 = move-exception;
        r3 = r1;
        r1 = r4;
        r4 = r0;
        goto L_0x0040;
    L_0x0039:
        r0 = move-exception;
        goto L_0x0079;
    L_0x003b:
        r2 = move-exception;
        r3 = r1;
        r1 = r4;
        r4 = r2;
        r2 = r0;
    L_0x0040:
        r0 = r3;
        goto L_0x0054;
    L_0x0042:
        r4 = move-exception;
        r3 = r0;
        r0 = r4;
        r4 = r3;
        goto L_0x0079;
    L_0x0047:
        r4 = move-exception;
        r2 = r0;
        r0 = r1;
        r1 = r2;
        goto L_0x0054;
    L_0x004c:
        r4 = move-exception;
        r1 = r0;
        r0 = r4;
        r4 = r1;
        goto L_0x0079;
    L_0x0051:
        r4 = move-exception;
        r1 = r0;
        r2 = r1;
    L_0x0054:
        r4.printStackTrace();	 Catch:{ all -> 0x0074 }
        if (r0 == 0) goto L_0x0061;
    L_0x0059:
        r0.close();	 Catch:{ IOException -> 0x005d }
        goto L_0x0061;
    L_0x005d:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x0061:
        if (r1 == 0) goto L_0x0066;
    L_0x0063:
        r1.close();	 Catch:{ IOException -> 0x002f }
    L_0x0066:
        if (r2 != 0) goto L_0x006b;
    L_0x0068:
        r4 = "";
        goto L_0x0073;
    L_0x006b:
        r4 = r2.toString();
        r4 = r4.trim();
    L_0x0073:
        return r4;
    L_0x0074:
        r4 = move-exception;
        r3 = r0;
        r0 = r4;
        r4 = r1;
        r1 = r3;
    L_0x0079:
        if (r1 == 0) goto L_0x0083;
    L_0x007b:
        r1.close();	 Catch:{ IOException -> 0x007f }
        goto L_0x0083;
    L_0x007f:
        r1 = move-exception;
        r1.printStackTrace();
    L_0x0083:
        if (r4 == 0) goto L_0x008d;
    L_0x0085:
        r4.close();	 Catch:{ IOException -> 0x0089 }
        goto L_0x008d;
    L_0x0089:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x008d:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geetest.mobinfo.s.a(java.lang.String):java.lang.String");
    }

    public static boolean b(String str) {
        return JniLib1557756502.cZ(str, Integer.valueOf(158));
    }
}
