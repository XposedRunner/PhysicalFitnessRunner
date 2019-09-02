package com.qiyukf.unicorn.b;

import android.content.Context;
import com.qiyukf.unicorn.api.YSFOptions;
import java.io.Serializable;

public final class a implements Serializable {
    private String a;
    private YSFOptions b;

    private a(String str, YSFOptions ySFOptions) {
        this.a = str;
        this.b = ySFOptions;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0044 A:{SYNTHETIC, Splitter:B:31:0x0044} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0037 A:{SYNTHETIC, Splitter:B:22:0x0037} */
    public static synchronized com.qiyukf.unicorn.b.a a(android.content.Context r5) {
        /*
        r0 = com.qiyukf.unicorn.b.a.class;
        monitor-enter(r0);
        r1 = 0;
        r2 = new java.io.FileInputStream;	 Catch:{ Throwable -> 0x0030, all -> 0x002d }
        r5 = b(r5);	 Catch:{ Throwable -> 0x0030, all -> 0x002d }
        r2.<init>(r5);	 Catch:{ Throwable -> 0x0030, all -> 0x002d }
        r5 = new java.io.ObjectInputStream;	 Catch:{ Throwable -> 0x002b }
        r5.<init>(r2);	 Catch:{ Throwable -> 0x002b }
        r3 = r5.readUTF();	 Catch:{ Throwable -> 0x002b }
        r5 = r5.readObject();	 Catch:{ Throwable -> 0x002b }
        r5 = (com.qiyukf.unicorn.api.YSFOptions) r5;	 Catch:{ Throwable -> 0x002b }
        r4 = new com.qiyukf.unicorn.b.a;	 Catch:{ Throwable -> 0x002b }
        r4.<init>(r3, r5);	 Catch:{ Throwable -> 0x002b }
        r2.close();	 Catch:{ IOException -> 0x0025 }
        goto L_0x0029;
    L_0x0025:
        r5 = move-exception;
        r5.printStackTrace();	 Catch:{ all -> 0x0048 }
    L_0x0029:
        monitor-exit(r0);
        return r4;
    L_0x002b:
        r5 = move-exception;
        goto L_0x0032;
    L_0x002d:
        r5 = move-exception;
        r2 = r1;
        goto L_0x0042;
    L_0x0030:
        r5 = move-exception;
        r2 = r1;
    L_0x0032:
        r5.printStackTrace();	 Catch:{ all -> 0x0041 }
        if (r2 == 0) goto L_0x003f;
    L_0x0037:
        r2.close();	 Catch:{ IOException -> 0x003b }
        goto L_0x003f;
    L_0x003b:
        r5 = move-exception;
        r5.printStackTrace();	 Catch:{ all -> 0x0048 }
    L_0x003f:
        monitor-exit(r0);
        return r1;
    L_0x0041:
        r5 = move-exception;
    L_0x0042:
        if (r2 == 0) goto L_0x004e;
    L_0x0044:
        r2.close();	 Catch:{ IOException -> 0x004a }
        goto L_0x004e;
    L_0x0048:
        r5 = move-exception;
        goto L_0x004f;
    L_0x004a:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ all -> 0x0048 }
    L_0x004e:
        throw r5;	 Catch:{ all -> 0x0048 }
    L_0x004f:
        monitor-exit(r0);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.unicorn.b.a.a(android.content.Context):com.qiyukf.unicorn.b.a");
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0040 A:{SYNTHETIC, Splitter:B:37:0x0040} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x003c A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0031 A:{SYNTHETIC, Splitter:B:25:0x0031} */
    public static synchronized void a(android.content.Context r3, java.lang.String r4, com.qiyukf.unicorn.api.YSFOptions r5) {
        /*
        r0 = com.qiyukf.unicorn.b.a.class;
        monitor-enter(r0);
        r1 = 0;
        r2 = new java.io.FileOutputStream;	 Catch:{ Throwable -> 0x002b }
        r3 = b(r3);	 Catch:{ Throwable -> 0x002b }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x002b }
        r3 = new java.io.ObjectOutputStream;	 Catch:{ Throwable -> 0x0026, all -> 0x0023 }
        r3.<init>(r2);	 Catch:{ Throwable -> 0x0026, all -> 0x0023 }
        r3.writeUTF(r4);	 Catch:{ Throwable -> 0x0026, all -> 0x0023 }
        r3.writeObject(r5);	 Catch:{ Throwable -> 0x0026, all -> 0x0023 }
        r2.close();	 Catch:{ IOException -> 0x001d }
        monitor-exit(r0);
        return;
    L_0x001d:
        r3 = move-exception;
        r3.printStackTrace();	 Catch:{ all -> 0x0044 }
        monitor-exit(r0);
        return;
    L_0x0023:
        r3 = move-exception;
        r1 = r2;
        goto L_0x003e;
    L_0x0026:
        r3 = move-exception;
        r1 = r2;
        goto L_0x002c;
    L_0x0029:
        r3 = move-exception;
        goto L_0x003e;
    L_0x002b:
        r3 = move-exception;
    L_0x002c:
        r3.printStackTrace();	 Catch:{ all -> 0x0029 }
        if (r1 == 0) goto L_0x003c;
    L_0x0031:
        r1.close();	 Catch:{ IOException -> 0x0036 }
        monitor-exit(r0);
        return;
    L_0x0036:
        r3 = move-exception;
        r3.printStackTrace();	 Catch:{ all -> 0x0044 }
        monitor-exit(r0);
        return;
    L_0x003c:
        monitor-exit(r0);
        return;
    L_0x003e:
        if (r1 == 0) goto L_0x004a;
    L_0x0040:
        r1.close();	 Catch:{ IOException -> 0x0046 }
        goto L_0x004a;
    L_0x0044:
        r3 = move-exception;
        goto L_0x004b;
    L_0x0046:
        r4 = move-exception;
        r4.printStackTrace();	 Catch:{ all -> 0x0044 }
    L_0x004a:
        throw r3;	 Catch:{ all -> 0x0044 }
    L_0x004b:
        monitor-exit(r0);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.unicorn.b.a.a(android.content.Context, java.lang.String, com.qiyukf.unicorn.api.YSFOptions):void");
    }

    private static String b(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.getApplicationInfo().dataDir);
        stringBuilder.append("/unicorn#cheese#");
        return stringBuilder.toString();
    }

    public final String a() {
        return this.a;
    }

    public final YSFOptions b() {
        return this.b;
    }
}
