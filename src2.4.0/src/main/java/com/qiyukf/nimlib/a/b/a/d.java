package com.qiyukf.nimlib.a.b.a;

import com.qiyukf.nimlib.a.b.a;
import com.qiyukf.nimlib.k.c.b;
import com.qiyukf.nimlib.k.c.c;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public final class d extends a {
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a7 A:{SYNTHETIC, Splitter:B:54:0x00a7} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00b1 A:{SYNTHETIC, Splitter:B:59:0x00b1} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0090 A:{SYNTHETIC, Splitter:B:40:0x0090} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x009a A:{SYNTHETIC, Splitter:B:45:0x009a} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a7 A:{SYNTHETIC, Splitter:B:54:0x00a7} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00b1 A:{SYNTHETIC, Splitter:B:59:0x00b1} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0090 A:{SYNTHETIC, Splitter:B:40:0x0090} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x009a A:{SYNTHETIC, Splitter:B:45:0x009a} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a7 A:{SYNTHETIC, Splitter:B:54:0x00a7} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00b1 A:{SYNTHETIC, Splitter:B:59:0x00b1} */
    private static java.lang.String a() {
        /*
        r0 = "nim_sdk.log";
        r1 = com.qiyukf.nimlib.k.c.b.TYPE_LOG;
        r0 = com.qiyukf.nimlib.k.c.c.b(r0, r1);
        r1 = android.text.TextUtils.isEmpty(r0);
        r2 = 0;
        if (r1 == 0) goto L_0x0010;
    L_0x000f:
        return r2;
    L_0x0010:
        r1 = new java.lang.StringBuilder;
        r3 = "nim_sdk_";
        r1.<init>(r3);
        r3 = java.lang.System.currentTimeMillis();
        r1.append(r3);
        r3 = ".log";
        r1.append(r3);
        r1 = r1.toString();
        r3 = com.qiyukf.nimlib.k.c.b.TYPE_LOG;
        r1 = com.qiyukf.nimlib.k.c.c.a(r1, r3);
        r3 = new java.io.FileWriter;	 Catch:{ IOException -> 0x0089, all -> 0x0085 }
        r3.<init>(r1);	 Catch:{ IOException -> 0x0089, all -> 0x0085 }
        r4 = com.qiyukf.unicorn.d.b.a();	 Catch:{ IOException -> 0x0081, all -> 0x007e }
        r3.write(r4);	 Catch:{ IOException -> 0x0081, all -> 0x007e }
        r4 = new java.io.FileReader;	 Catch:{ IOException -> 0x0081, all -> 0x007e }
        r4.<init>(r0);	 Catch:{ IOException -> 0x0081, all -> 0x007e }
        r2 = new java.io.File;	 Catch:{ IOException -> 0x007c, all -> 0x007a }
        r2.<init>(r0);	 Catch:{ IOException -> 0x007c, all -> 0x007a }
        r5 = r2.length();	 Catch:{ IOException -> 0x007c, all -> 0x007a }
        r0 = com.qiyukf.nimlib.b.a();	 Catch:{ IOException -> 0x007c, all -> 0x007a }
        r0 = com.qiyukf.basesdk.c.d.c.a(r0);	 Catch:{ IOException -> 0x007c, all -> 0x007a }
        r2 = 1;
        if (r0 == r2) goto L_0x005e;
    L_0x0052:
        r7 = 512000; // 0x7d000 float:7.17465E-40 double:2.529616E-318;
        r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
        if (r0 <= 0) goto L_0x005e;
    L_0x0059:
        r9 = r5 - r7;
        r4.skip(r9);	 Catch:{ IOException -> 0x007c, all -> 0x007a }
    L_0x005e:
        r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r0 = new char[r0];	 Catch:{ IOException -> 0x007c, all -> 0x007a }
    L_0x0062:
        r2 = r4.read(r0);	 Catch:{ IOException -> 0x007c, all -> 0x007a }
        r5 = -1;
        if (r2 == r5) goto L_0x006e;
    L_0x0069:
        r5 = 0;
        r3.write(r0, r5, r2);	 Catch:{ IOException -> 0x007c, all -> 0x007a }
        goto L_0x0062;
    L_0x006e:
        r3.close();	 Catch:{ IOException -> 0x0072 }
        goto L_0x0076;
    L_0x0072:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x0076:
        r4.close();	 Catch:{ IOException -> 0x009e }
        return r1;
    L_0x007a:
        r0 = move-exception;
        goto L_0x00a5;
    L_0x007c:
        r0 = move-exception;
        goto L_0x0083;
    L_0x007e:
        r0 = move-exception;
        r4 = r2;
        goto L_0x00a5;
    L_0x0081:
        r0 = move-exception;
        r4 = r2;
    L_0x0083:
        r2 = r3;
        goto L_0x008b;
    L_0x0085:
        r0 = move-exception;
        r3 = r2;
        r4 = r3;
        goto L_0x00a5;
    L_0x0089:
        r0 = move-exception;
        r4 = r2;
    L_0x008b:
        r0.printStackTrace();	 Catch:{ all -> 0x00a3 }
        if (r2 == 0) goto L_0x0098;
    L_0x0090:
        r2.close();	 Catch:{ IOException -> 0x0094 }
        goto L_0x0098;
    L_0x0094:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x0098:
        if (r4 == 0) goto L_0x00a2;
    L_0x009a:
        r4.close();	 Catch:{ IOException -> 0x009e }
        return r1;
    L_0x009e:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x00a2:
        return r1;
    L_0x00a3:
        r0 = move-exception;
        r3 = r2;
    L_0x00a5:
        if (r3 == 0) goto L_0x00af;
    L_0x00a7:
        r3.close();	 Catch:{ IOException -> 0x00ab }
        goto L_0x00af;
    L_0x00ab:
        r1 = move-exception;
        r1.printStackTrace();
    L_0x00af:
        if (r4 == 0) goto L_0x00b9;
    L_0x00b1:
        r4.close();	 Catch:{ IOException -> 0x00b5 }
        goto L_0x00b9;
    L_0x00b5:
        r1 = move-exception;
        r1.printStackTrace();
    L_0x00b9:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.a.b.a.d.a():java.lang.String");
    }

    private static void a(String str, ZipOutputStream zipOutputStream) {
        if (zipOutputStream != null) {
            File file = new File(str);
            int i = 0;
            if (file.isFile()) {
                ZipEntry zipEntry = new ZipEntry(file.getName());
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                zipOutputStream.putNextEntry(zipEntry);
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read != -1) {
                        zipOutputStream.write(bArr, 0, read);
                    } else {
                        zipOutputStream.closeEntry();
                        bufferedInputStream.close();
                        return;
                    }
                }
            }
            String[] list = file.list();
            if (list.length <= 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(File.separator);
                zipOutputStream.putNextEntry(new ZipEntry(stringBuilder.toString()));
                zipOutputStream.closeEntry();
            }
            while (i < list.length) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str);
                stringBuilder2.append(File.separator);
                stringBuilder2.append(list[i]);
                a(stringBuilder2.toString(), zipOutputStream);
                i++;
            }
        }
    }

    public final void a(com.qiyukf.nimlib.a.d.a aVar) {
        String a = a();
        if (a != null && new File(a).exists()) {
            try {
                final String a2 = c.a(com.qiyukf.basesdk.c.c.d.b(), b.TYPE_LOG);
                ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(a2)));
                a(a, zipOutputStream);
                zipOutputStream.finish();
                zipOutputStream.close();
                new File(a).delete();
                com.qiyukf.basesdk.b.a.b.a.a().a(a2, null, a2, new com.qiyukf.basesdk.b.a.b.c() {
                    public final void a() {
                    }

                    public final void a(int i) {
                    }

                    public final void a(long j, long j2) {
                    }

                    public final void a(String str) {
                        com.qiyukf.nimlib.a.c.a().a(new com.qiyukf.nimlib.a.c.a.d(str), com.qiyukf.nimlib.a.f.a.d);
                        new File(a2).delete();
                    }
                });
            } catch (Exception unused) {
            }
        }
    }
}
