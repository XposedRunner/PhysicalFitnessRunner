package com.qiyukf.basesdk.c.a;

import android.text.TextUtils;
import cn.jiguang.net.HttpUtils;
import java.io.File;
import java.io.IOException;

public final class a {
    /* JADX WARNING: Unknown top exception splitter block from list: {B:51:0x0086=Splitter:B:51:0x0086, B:61:0x0096=Splitter:B:61:0x0096} */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00b0 A:{SYNTHETIC, Splitter:B:76:0x00b0} */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00b8 A:{Catch:{ IOException -> 0x00b4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x009b A:{SYNTHETIC, Splitter:B:64:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00a3 A:{Catch:{ IOException -> 0x009f }} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x008b A:{SYNTHETIC, Splitter:B:54:0x008b} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0090 A:{Catch:{ IOException -> 0x009f }} */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00b0 A:{SYNTHETIC, Splitter:B:76:0x00b0} */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00b8 A:{Catch:{ IOException -> 0x00b4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x009b A:{SYNTHETIC, Splitter:B:64:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00a3 A:{Catch:{ IOException -> 0x009f }} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x008b A:{SYNTHETIC, Splitter:B:54:0x008b} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0090 A:{Catch:{ IOException -> 0x009f }} */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00b0 A:{SYNTHETIC, Splitter:B:76:0x00b0} */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00b8 A:{Catch:{ IOException -> 0x00b4 }} */
    public static long a(java.lang.String r7, java.lang.String r8) {
        /*
        r0 = android.text.TextUtils.isEmpty(r7);
        r1 = -1;
        if (r0 != 0) goto L_0x00c0;
    L_0x0008:
        r0 = android.text.TextUtils.isEmpty(r8);
        if (r0 == 0) goto L_0x000f;
    L_0x000e:
        return r1;
    L_0x000f:
        r0 = new java.io.File;
        r0.<init>(r7);
        r3 = r0.exists();
        if (r3 != 0) goto L_0x001b;
    L_0x001a:
        return r1;
    L_0x001b:
        r7 = r7.equals(r8);
        if (r7 == 0) goto L_0x0026;
    L_0x0021:
        r7 = r0.length();
        return r7;
    L_0x0026:
        r7 = 0;
        r3 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x0094, IOException -> 0x0084, all -> 0x0081 }
        r3.<init>(r0);	 Catch:{ FileNotFoundException -> 0x0094, IOException -> 0x0084, all -> 0x0081 }
        r3 = r3.getChannel();	 Catch:{ FileNotFoundException -> 0x0094, IOException -> 0x0084, all -> 0x0081 }
        r4 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x007d, IOException -> 0x0079, all -> 0x0077 }
        r8 = a(r8);	 Catch:{ FileNotFoundException -> 0x007d, IOException -> 0x0079, all -> 0x0077 }
        r4.<init>(r8);	 Catch:{ FileNotFoundException -> 0x007d, IOException -> 0x0079, all -> 0x0077 }
        r8 = r4.getChannel();	 Catch:{ FileNotFoundException -> 0x007d, IOException -> 0x0079, all -> 0x0077 }
        r7 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r7 = java.nio.ByteBuffer.allocateDirect(r7);	 Catch:{ FileNotFoundException -> 0x0073, IOException -> 0x006f, all -> 0x006a }
    L_0x0043:
        r4 = r3.read(r7);	 Catch:{ FileNotFoundException -> 0x0073, IOException -> 0x006f, all -> 0x006a }
        r5 = -1;
        if (r4 == r5) goto L_0x0054;
    L_0x004a:
        r7.flip();	 Catch:{ FileNotFoundException -> 0x0073, IOException -> 0x006f, all -> 0x006a }
        r8.write(r7);	 Catch:{ FileNotFoundException -> 0x0073, IOException -> 0x006f, all -> 0x006a }
        r7.clear();	 Catch:{ FileNotFoundException -> 0x0073, IOException -> 0x006f, all -> 0x006a }
        goto L_0x0043;
    L_0x0054:
        r4 = r0.length();	 Catch:{ FileNotFoundException -> 0x0073, IOException -> 0x006f, all -> 0x006a }
        if (r3 == 0) goto L_0x0060;
    L_0x005a:
        r3.close();	 Catch:{ IOException -> 0x005e }
        goto L_0x0060;
    L_0x005e:
        r7 = move-exception;
        goto L_0x0066;
    L_0x0060:
        if (r8 == 0) goto L_0x0069;
    L_0x0062:
        r8.close();	 Catch:{ IOException -> 0x005e }
        return r4;
    L_0x0066:
        r7.printStackTrace();
    L_0x0069:
        return r4;
    L_0x006a:
        r7 = move-exception;
        r6 = r8;
        r8 = r7;
        r7 = r6;
        goto L_0x00ae;
    L_0x006f:
        r7 = move-exception;
        r0 = r8;
        r8 = r7;
        goto L_0x007b;
    L_0x0073:
        r7 = move-exception;
        r0 = r8;
        r8 = r7;
        goto L_0x007f;
    L_0x0077:
        r8 = move-exception;
        goto L_0x00ae;
    L_0x0079:
        r8 = move-exception;
        r0 = r7;
    L_0x007b:
        r7 = r3;
        goto L_0x0086;
    L_0x007d:
        r8 = move-exception;
        r0 = r7;
    L_0x007f:
        r7 = r3;
        goto L_0x0096;
    L_0x0081:
        r8 = move-exception;
        r3 = r7;
        goto L_0x00ae;
    L_0x0084:
        r8 = move-exception;
        r0 = r7;
    L_0x0086:
        r8.printStackTrace();	 Catch:{ all -> 0x00ab }
        if (r7 == 0) goto L_0x008e;
    L_0x008b:
        r7.close();	 Catch:{ IOException -> 0x009f }
    L_0x008e:
        if (r0 == 0) goto L_0x00aa;
    L_0x0090:
        r0.close();	 Catch:{ IOException -> 0x009f }
        return r1;
    L_0x0094:
        r8 = move-exception;
        r0 = r7;
    L_0x0096:
        r8.printStackTrace();	 Catch:{ all -> 0x00ab }
        if (r7 == 0) goto L_0x00a1;
    L_0x009b:
        r7.close();	 Catch:{ IOException -> 0x009f }
        goto L_0x00a1;
    L_0x009f:
        r7 = move-exception;
        goto L_0x00a7;
    L_0x00a1:
        if (r0 == 0) goto L_0x00aa;
    L_0x00a3:
        r0.close();	 Catch:{ IOException -> 0x009f }
        return r1;
    L_0x00a7:
        r7.printStackTrace();
    L_0x00aa:
        return r1;
    L_0x00ab:
        r8 = move-exception;
        r3 = r7;
        r7 = r0;
    L_0x00ae:
        if (r3 == 0) goto L_0x00b6;
    L_0x00b0:
        r3.close();	 Catch:{ IOException -> 0x00b4 }
        goto L_0x00b6;
    L_0x00b4:
        r7 = move-exception;
        goto L_0x00bc;
    L_0x00b6:
        if (r7 == 0) goto L_0x00bf;
    L_0x00b8:
        r7.close();	 Catch:{ IOException -> 0x00b4 }
        goto L_0x00bf;
    L_0x00bc:
        r7.printStackTrace();
    L_0x00bf:
        throw r8;
    L_0x00c0:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.basesdk.c.a.a.a(java.lang.String, java.lang.String):long");
    }

    public static File a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            file.createNewFile();
            return file;
        } catch (IOException unused) {
            if (file.exists()) {
                file.delete();
            }
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0034 A:{SYNTHETIC, Splitter:B:28:0x0034} */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x002a A:{SYNTHETIC, Splitter:B:19:0x002a} */
    public static boolean a(android.graphics.Bitmap r3, java.lang.String r4) {
        /*
        r0 = 0;
        if (r3 == 0) goto L_0x003a;
    L_0x0003:
        r1 = android.text.TextUtils.isEmpty(r4);
        if (r1 == 0) goto L_0x000a;
    L_0x0009:
        return r0;
    L_0x000a:
        r1 = 0;
        r2 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x0031, all -> 0x0027 }
        r2.<init>(r4);	 Catch:{ FileNotFoundException -> 0x0031, all -> 0x0027 }
        r4 = new java.io.BufferedOutputStream;	 Catch:{ FileNotFoundException -> 0x0031, all -> 0x0027 }
        r4.<init>(r2);	 Catch:{ FileNotFoundException -> 0x0031, all -> 0x0027 }
        r1 = android.graphics.Bitmap.CompressFormat.JPEG;	 Catch:{ FileNotFoundException -> 0x0032, all -> 0x0024 }
        r2 = 80;
        r3.compress(r1, r2, r4);	 Catch:{ FileNotFoundException -> 0x0032, all -> 0x0024 }
        r4.close();	 Catch:{ IOException -> 0x001f }
    L_0x001f:
        r3.recycle();
        r3 = 1;
        return r3;
    L_0x0024:
        r0 = move-exception;
        r1 = r4;
        goto L_0x0028;
    L_0x0027:
        r0 = move-exception;
    L_0x0028:
        if (r1 == 0) goto L_0x002d;
    L_0x002a:
        r1.close();	 Catch:{ IOException -> 0x002d }
    L_0x002d:
        r3.recycle();
        throw r0;
    L_0x0031:
        r4 = r1;
    L_0x0032:
        if (r4 == 0) goto L_0x0037;
    L_0x0034:
        r4.close();	 Catch:{ IOException -> 0x0037 }
    L_0x0037:
        r3.recycle();
    L_0x003a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.basesdk.c.a.a.a(android.graphics.Bitmap, java.lang.String):boolean");
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(file.getParent());
        stringBuilder.append(HttpUtils.PATHS_SEPARATOR);
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append("_tmp");
        File file2 = new File(stringBuilder.toString());
        if (file.renameTo(file2)) {
            file = file2;
        }
        return file.delete();
    }
}
