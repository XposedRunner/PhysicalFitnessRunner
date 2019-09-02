package com.alibaba.wireless.security.framework.utils;

public class b {
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0038 A:{SYNTHETIC, Splitter:B:28:0x0038} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0031 A:{SYNTHETIC, Splitter:B:20:0x0031} */
    public static java.lang.String a(java.io.File r3) {
        /*
        r0 = 0;
        if (r3 == 0) goto L_0x003d;
    L_0x0003:
        r1 = r3.exists();
        if (r1 != 0) goto L_0x000a;
    L_0x0009:
        return r0;
    L_0x000a:
        r1 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x0035, all -> 0x002e }
        r2 = new java.io.FileReader;	 Catch:{ Exception -> 0x0035, all -> 0x002e }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0035, all -> 0x002e }
        r1.<init>(r2);	 Catch:{ Exception -> 0x0035, all -> 0x002e }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0036, all -> 0x002b }
        r3.<init>();	 Catch:{ Exception -> 0x0036, all -> 0x002b }
    L_0x0019:
        r2 = r1.readLine();	 Catch:{ Exception -> 0x0036, all -> 0x002b }
        if (r2 == 0) goto L_0x0023;
    L_0x001f:
        r3.append(r2);	 Catch:{ Exception -> 0x0036, all -> 0x002b }
        goto L_0x0019;
    L_0x0023:
        r1.close();	 Catch:{ Exception -> 0x0036, all -> 0x002b }
        r3 = r3.toString();	 Catch:{ Exception -> 0x0035, all -> 0x002e }
        return r3;
    L_0x002b:
        r3 = move-exception;
        r0 = r1;
        goto L_0x002f;
    L_0x002e:
        r3 = move-exception;
    L_0x002f:
        if (r0 == 0) goto L_0x0034;
    L_0x0031:
        r0.close();	 Catch:{ Exception -> 0x0034 }
    L_0x0034:
        throw r3;
    L_0x0035:
        r1 = r0;
    L_0x0036:
        if (r1 == 0) goto L_0x003b;
    L_0x0038:
        r1.close();	 Catch:{ Exception -> 0x003b }
    L_0x003b:
        r3 = r0;
        return r3;
    L_0x003d:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.utils.b.a(java.io.File):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0050 A:{SYNTHETIC, Splitter:B:27:0x0050} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004a A:{SYNTHETIC, Splitter:B:21:0x004a} */
    public static boolean a(java.io.File r5, java.lang.String r6) {
        /*
        r0 = 0;
        if (r5 == 0) goto L_0x0055;
    L_0x0003:
        if (r6 != 0) goto L_0x0006;
    L_0x0005:
        return r0;
    L_0x0006:
        r1 = new java.io.File;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = r5.getAbsolutePath();
        r2.append(r3);
        r3 = ".tmp";
        r2.append(r3);
        r2 = r2.toString();
        r1.<init>(r2);
        r2 = 0;
        r3 = r1.exists();	 Catch:{ Exception -> 0x004e, all -> 0x0047 }
        if (r3 != 0) goto L_0x002a;
    L_0x0027:
        r1.createNewFile();	 Catch:{ Exception -> 0x004e, all -> 0x0047 }
    L_0x002a:
        r3 = new java.io.BufferedWriter;	 Catch:{ Exception -> 0x004e, all -> 0x0047 }
        r4 = new java.io.FileWriter;	 Catch:{ Exception -> 0x004e, all -> 0x0047 }
        r4.<init>(r1, r0);	 Catch:{ Exception -> 0x004e, all -> 0x0047 }
        r3.<init>(r4);	 Catch:{ Exception -> 0x004e, all -> 0x0047 }
        r3.write(r6);	 Catch:{ Exception -> 0x0045, all -> 0x0042 }
        r3.flush();	 Catch:{ Exception -> 0x0045, all -> 0x0042 }
        r3.close();	 Catch:{ Exception -> 0x0045, all -> 0x0042 }
        r5 = r1.renameTo(r5);	 Catch:{ Exception -> 0x004e, all -> 0x0047 }
        return r5;
    L_0x0042:
        r5 = move-exception;
        r2 = r3;
        goto L_0x0048;
    L_0x0045:
        r2 = r3;
        goto L_0x004e;
    L_0x0047:
        r5 = move-exception;
    L_0x0048:
        if (r2 == 0) goto L_0x004d;
    L_0x004a:
        r2.close();	 Catch:{ Exception -> 0x004d }
    L_0x004d:
        throw r5;
    L_0x004e:
        if (r2 == 0) goto L_0x0053;
    L_0x0050:
        r2.close();	 Catch:{ Exception -> 0x0053 }
    L_0x0053:
        r5 = r0;
        return r5;
    L_0x0055:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.utils.b.a(java.io.File, java.lang.String):boolean");
    }
}
