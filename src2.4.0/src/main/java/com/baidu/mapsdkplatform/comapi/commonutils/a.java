package com.baidu.mapsdkplatform.comapi.commonutils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import java.io.InputStream;

public class a {
    private static final boolean a = (VERSION.SDK_INT >= 8);

    public static Bitmap a(String str, Context context) {
        try {
            InputStream open = context.getAssets().open(str);
            return open != null ? BitmapFactory.decodeStream(open) : null;
        } catch (Exception unused) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("assets/");
            stringBuilder.append(str);
            return BitmapFactory.decodeFile(b(stringBuilder.toString(), str, context));
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x001e */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:10|11|12|19|13|14) */
    private static void a(java.io.InputStream r3, java.io.FileOutputStream r4) throws java.io.IOException {
        /*
        r0 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r0 = new byte[r0];
    L_0x0004:
        r1 = r3.read(r0);	 Catch:{ all -> 0x001a }
        r2 = -1;
        if (r1 == r2) goto L_0x0010;
    L_0x000b:
        r2 = 0;
        r4.write(r0, r2, r1);	 Catch:{ all -> 0x001a }
        goto L_0x0004;
    L_0x0010:
        r4.flush();	 Catch:{ all -> 0x001a }
        r3.close();	 Catch:{ IOException -> 0x0016 }
    L_0x0016:
        r4.close();	 Catch:{ IOException -> 0x0019 }
    L_0x0019:
        return;
    L_0x001a:
        r0 = move-exception;
        r3.close();	 Catch:{ IOException -> 0x001e }
    L_0x001e:
        r4.close();	 Catch:{ IOException -> 0x0021 }
    L_0x0021:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.commonutils.a.a(java.io.InputStream, java.io.FileOutputStream):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0081 A:{SYNTHETIC, Splitter:B:35:0x0081} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0086 A:{Catch:{ IOException -> 0x005b }} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x008f A:{SYNTHETIC, Splitter:B:44:0x008f} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0097 A:{Catch:{ IOException -> 0x0093 }} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x008f A:{SYNTHETIC, Splitter:B:44:0x008f} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0097 A:{Catch:{ IOException -> 0x0093 }} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0081 A:{SYNTHETIC, Splitter:B:35:0x0081} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0086 A:{Catch:{ IOException -> 0x005b }} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x008f A:{SYNTHETIC, Splitter:B:44:0x008f} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0097 A:{Catch:{ IOException -> 0x0093 }} */
    public static void a(java.lang.String r6, java.lang.String r7, android.content.Context r8) {
        /*
        r0 = 0;
        r1 = r8.getAssets();	 Catch:{ Exception -> 0x006a, all -> 0x0067 }
        r1 = r1.open(r6);	 Catch:{ Exception -> 0x006a, all -> 0x0067 }
        if (r1 == 0) goto L_0x0055;
    L_0x000b:
        r2 = r1.available();	 Catch:{ Exception -> 0x0052, all -> 0x0050 }
        r2 = new byte[r2];	 Catch:{ Exception -> 0x0052, all -> 0x0050 }
        r1.read(r2);	 Catch:{ Exception -> 0x0052, all -> 0x0050 }
        r3 = new java.io.File;	 Catch:{ Exception -> 0x0052, all -> 0x0050 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0052, all -> 0x0050 }
        r4.<init>();	 Catch:{ Exception -> 0x0052, all -> 0x0050 }
        r5 = r8.getFilesDir();	 Catch:{ Exception -> 0x0052, all -> 0x0050 }
        r5 = r5.getAbsolutePath();	 Catch:{ Exception -> 0x0052, all -> 0x0050 }
        r4.append(r5);	 Catch:{ Exception -> 0x0052, all -> 0x0050 }
        r5 = "/";
        r4.append(r5);	 Catch:{ Exception -> 0x0052, all -> 0x0050 }
        r4.append(r7);	 Catch:{ Exception -> 0x0052, all -> 0x0050 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0052, all -> 0x0050 }
        r3.<init>(r4);	 Catch:{ Exception -> 0x0052, all -> 0x0050 }
        r4 = r3.exists();	 Catch:{ Exception -> 0x0052, all -> 0x0050 }
        if (r4 == 0) goto L_0x003e;
    L_0x003b:
        r3.delete();	 Catch:{ Exception -> 0x0052, all -> 0x0050 }
    L_0x003e:
        r3.createNewFile();	 Catch:{ Exception -> 0x0052, all -> 0x0050 }
        r4 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x0052, all -> 0x0050 }
        r4.<init>(r3);	 Catch:{ Exception -> 0x0052, all -> 0x0050 }
        r4.write(r2);	 Catch:{ Exception -> 0x0053, all -> 0x004e }
        r4.close();	 Catch:{ Exception -> 0x0053, all -> 0x004e }
        r0 = r4;
        goto L_0x0055;
    L_0x004e:
        r6 = move-exception;
        goto L_0x008c;
    L_0x0050:
        r6 = move-exception;
        goto L_0x008d;
    L_0x0052:
        r4 = r0;
    L_0x0053:
        r0 = r1;
        goto L_0x006b;
    L_0x0055:
        if (r1 == 0) goto L_0x005d;
    L_0x0057:
        r1.close();	 Catch:{ IOException -> 0x005b }
        goto L_0x005d;
    L_0x005b:
        r6 = move-exception;
        goto L_0x0063;
    L_0x005d:
        if (r0 == 0) goto L_0x0089;
    L_0x005f:
        r0.close();	 Catch:{ IOException -> 0x005b }
        return;
    L_0x0063:
        r6.printStackTrace();
        return;
    L_0x0067:
        r6 = move-exception;
        r1 = r0;
        goto L_0x008d;
    L_0x006a:
        r4 = r0;
    L_0x006b:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008a }
        r1.<init>();	 Catch:{ all -> 0x008a }
        r2 = "assets/";
        r1.append(r2);	 Catch:{ all -> 0x008a }
        r1.append(r6);	 Catch:{ all -> 0x008a }
        r6 = r1.toString();	 Catch:{ all -> 0x008a }
        b(r6, r7, r8);	 Catch:{ all -> 0x008a }
        if (r0 == 0) goto L_0x0084;
    L_0x0081:
        r0.close();	 Catch:{ IOException -> 0x005b }
    L_0x0084:
        if (r4 == 0) goto L_0x0089;
    L_0x0086:
        r4.close();	 Catch:{ IOException -> 0x005b }
    L_0x0089:
        return;
    L_0x008a:
        r6 = move-exception;
        r1 = r0;
    L_0x008c:
        r0 = r4;
    L_0x008d:
        if (r1 == 0) goto L_0x0095;
    L_0x008f:
        r1.close();	 Catch:{ IOException -> 0x0093 }
        goto L_0x0095;
    L_0x0093:
        r7 = move-exception;
        goto L_0x009b;
    L_0x0095:
        if (r0 == 0) goto L_0x009e;
    L_0x0097:
        r0.close();	 Catch:{ IOException -> 0x0093 }
        goto L_0x009e;
    L_0x009b:
        r7.printStackTrace();
    L_0x009e:
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.commonutils.a.a(java.lang.String, java.lang.String, android.content.Context):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00bc A:{SYNTHETIC, Splitter:B:38:0x00bc} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b2 A:{SYNTHETIC, Splitter:B:32:0x00b2} */
    private static java.lang.String b(java.lang.String r7, java.lang.String r8, android.content.Context r9) {
        /*
        r0 = "";
        r1 = new java.lang.StringBuilder;
        r2 = r9.getFilesDir();
        r2 = r2.getAbsolutePath();
        r1.<init>(r2);
        r2 = a;
        if (r2 == 0) goto L_0x0017;
    L_0x0013:
        r0 = r9.getPackageCodePath();
    L_0x0017:
        r2 = 0;
        r3 = new java.util.zip.ZipFile;	 Catch:{ Exception -> 0x00a4 }
        r3.<init>(r0);	 Catch:{ Exception -> 0x00a4 }
        r0 = "/";
        r0 = r8.lastIndexOf(r0);	 Catch:{ Exception -> 0x009e, all -> 0x009c }
        if (r0 <= 0) goto L_0x005f;
    L_0x0025:
        r4 = new java.io.File;	 Catch:{ Exception -> 0x009e, all -> 0x009c }
        r9 = r9.getFilesDir();	 Catch:{ Exception -> 0x009e, all -> 0x009c }
        r9 = r9.getAbsolutePath();	 Catch:{ Exception -> 0x009e, all -> 0x009c }
        r4.<init>(r9);	 Catch:{ Exception -> 0x009e, all -> 0x009c }
        r9 = 0;
        r9 = r8.substring(r9, r0);	 Catch:{ Exception -> 0x009e, all -> 0x009c }
        r0 = r0 + 1;
        r5 = r8.length();	 Catch:{ Exception -> 0x009e, all -> 0x009c }
        r8 = r8.substring(r0, r5);	 Catch:{ Exception -> 0x009e, all -> 0x009c }
        r0 = new java.io.File;	 Catch:{ Exception -> 0x009e, all -> 0x009c }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x009e, all -> 0x009c }
        r5.<init>();	 Catch:{ Exception -> 0x009e, all -> 0x009c }
        r6 = r4.getAbsolutePath();	 Catch:{ Exception -> 0x009e, all -> 0x009c }
        r5.append(r6);	 Catch:{ Exception -> 0x009e, all -> 0x009c }
        r6 = "/";
        r5.append(r6);	 Catch:{ Exception -> 0x009e, all -> 0x009c }
        r5.append(r9);	 Catch:{ Exception -> 0x009e, all -> 0x009c }
        r9 = r5.toString();	 Catch:{ Exception -> 0x009e, all -> 0x009c }
        r0.<init>(r9, r8);	 Catch:{ Exception -> 0x009e, all -> 0x009c }
        goto L_0x0073;
    L_0x005f:
        r4 = new java.io.File;	 Catch:{ Exception -> 0x009e, all -> 0x009c }
        r9 = r9.getFilesDir();	 Catch:{ Exception -> 0x009e, all -> 0x009c }
        r0 = "assets";
        r4.<init>(r9, r0);	 Catch:{ Exception -> 0x009e, all -> 0x009c }
        r0 = new java.io.File;	 Catch:{ Exception -> 0x009e, all -> 0x009c }
        r9 = r4.getAbsolutePath();	 Catch:{ Exception -> 0x009e, all -> 0x009c }
        r0.<init>(r9, r8);	 Catch:{ Exception -> 0x009e, all -> 0x009c }
    L_0x0073:
        r4.mkdirs();	 Catch:{ Exception -> 0x009e, all -> 0x009c }
        r8 = r3.getEntry(r7);	 Catch:{ Exception -> 0x009e, all -> 0x009c }
        if (r8 != 0) goto L_0x0082;
    L_0x007c:
        if (r3 == 0) goto L_0x0081;
    L_0x007e:
        r3.close();	 Catch:{ IOException -> 0x0081 }
    L_0x0081:
        return r2;
    L_0x0082:
        r8 = r3.getInputStream(r8);	 Catch:{ Exception -> 0x009e, all -> 0x009c }
        r9 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x009e, all -> 0x009c }
        r9.<init>(r0);	 Catch:{ Exception -> 0x009e, all -> 0x009c }
        a(r8, r9);	 Catch:{ Exception -> 0x009e, all -> 0x009c }
        r8 = "/";
        r1.append(r8);	 Catch:{ Exception -> 0x009e, all -> 0x009c }
        r1.append(r7);	 Catch:{ Exception -> 0x009e, all -> 0x009c }
        if (r3 == 0) goto L_0x00b5;
    L_0x0098:
        r3.close();	 Catch:{ IOException -> 0x00b5 }
        goto L_0x00b5;
    L_0x009c:
        r7 = move-exception;
        goto L_0x00ba;
    L_0x009e:
        r7 = move-exception;
        r2 = r3;
        goto L_0x00a5;
    L_0x00a1:
        r7 = move-exception;
        r3 = r2;
        goto L_0x00ba;
    L_0x00a4:
        r7 = move-exception;
    L_0x00a5:
        r8 = com.baidu.mapsdkplatform.comapi.commonutils.a.class;
        r8 = r8.getSimpleName();	 Catch:{ all -> 0x00a1 }
        r9 = "copyAssetsError";
        android.util.Log.e(r8, r9, r7);	 Catch:{ all -> 0x00a1 }
        if (r2 == 0) goto L_0x00b5;
    L_0x00b2:
        r2.close();	 Catch:{ IOException -> 0x00b5 }
    L_0x00b5:
        r7 = r1.toString();
        return r7;
    L_0x00ba:
        if (r3 == 0) goto L_0x00bf;
    L_0x00bc:
        r3.close();	 Catch:{ IOException -> 0x00bf }
    L_0x00bf:
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.commonutils.a.b(java.lang.String, java.lang.String, android.content.Context):java.lang.String");
    }
}
