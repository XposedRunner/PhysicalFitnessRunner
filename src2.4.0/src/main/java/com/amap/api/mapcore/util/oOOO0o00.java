package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.maps.AMapException;

/* compiled from: StatisticsEntity */
public class oOOO0o00 {
    private Context O000000o;
    private String O00000Oo;
    private String O00000o;
    private String O00000o0;
    private String O00000oO;

    public oOOO0o00(Context context, String str, String str2, String str3) throws o0O0oo0o {
        if (TextUtils.isEmpty(str3) || str3.length() > 256) {
            throw new o0O0oo0o(AMapException.ERROR_INVALID_PARAMETER);
        }
        this.O000000o = context.getApplicationContext();
        this.O00000o0 = str;
        this.O00000o = str2;
        this.O00000Oo = str3;
    }

    public void O000000o(String str) throws o0O0oo0o {
        if (TextUtils.isEmpty(str) || str.length() > 65536) {
            throw new o0O0oo0o(AMapException.ERROR_INVALID_PARAMETER);
        }
        this.O00000oO = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0067 A:{SYNTHETIC, Splitter:B:24:0x0067} */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0073 A:{SYNTHETIC, Splitter:B:30:0x0073} */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x004c A:{SYNTHETIC, Splitter:B:11:0x004c} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x002d */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0055 A:{Splitter:B:3:0x0009, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:15:0x0055, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:16:0x0057, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:17:0x0058, code skipped:
            r2 = r3;
     */
    /* JADX WARNING: Missing block: B:31:?, code skipped:
            r3.close();
     */
    /* JADX WARNING: Missing block: B:32:0x0077, code skipped:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:33:0x0078, code skipped:
            r1.printStackTrace();
     */
    public byte[] O000000o() {
        /*
        r8 = this;
        r0 = 0;
        r1 = new byte[r0];
        r2 = 0;
        r3 = new java.io.ByteArrayOutputStream;	 Catch:{ Throwable -> 0x005d }
        r3.<init>();	 Catch:{ Throwable -> 0x005d }
        r2 = r8.O00000o0;	 Catch:{ Throwable -> 0x0057, all -> 0x0055 }
        com.amap.api.mapcore.util.o0OOOO00.O000000o(r3, r2);	 Catch:{ Throwable -> 0x0057, all -> 0x0055 }
        r2 = r8.O00000o;	 Catch:{ Throwable -> 0x0057, all -> 0x0055 }
        com.amap.api.mapcore.util.o0OOOO00.O000000o(r3, r2);	 Catch:{ Throwable -> 0x0057, all -> 0x0055 }
        r2 = r8.O00000Oo;	 Catch:{ Throwable -> 0x0057, all -> 0x0055 }
        com.amap.api.mapcore.util.o0OOOO00.O000000o(r3, r2);	 Catch:{ Throwable -> 0x0057, all -> 0x0055 }
        r2 = r8.O000000o;	 Catch:{ Throwable -> 0x0057, all -> 0x0055 }
        r2 = com.amap.api.mapcore.util.o0O0o000.O0000oO0(r2);	 Catch:{ Throwable -> 0x0057, all -> 0x0055 }
        r2 = java.lang.String.valueOf(r2);	 Catch:{ Throwable -> 0x0057, all -> 0x0055 }
        com.amap.api.mapcore.util.o0OOOO00.O000000o(r3, r2);	 Catch:{ Throwable -> 0x0057, all -> 0x0055 }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x002d, all -> 0x0055 }
        r6 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r4 = r4 / r6;
        r0 = (int) r4;
    L_0x002d:
        r0 = r8.O000000o(r0);	 Catch:{ Throwable -> 0x0057, all -> 0x0055 }
        r3.write(r0);	 Catch:{ Throwable -> 0x0057, all -> 0x0055 }
        r0 = r8.O00000oO;	 Catch:{ Throwable -> 0x0057, all -> 0x0055 }
        r0 = r8.O00000Oo(r0);	 Catch:{ Throwable -> 0x0057, all -> 0x0055 }
        r3.write(r0);	 Catch:{ Throwable -> 0x0057, all -> 0x0055 }
        r0 = r8.O00000oO;	 Catch:{ Throwable -> 0x0057, all -> 0x0055 }
        r0 = com.amap.api.mapcore.util.o0OOOO00.O000000o(r0);	 Catch:{ Throwable -> 0x0057, all -> 0x0055 }
        r3.write(r0);	 Catch:{ Throwable -> 0x0057, all -> 0x0055 }
        r0 = r3.toByteArray();	 Catch:{ Throwable -> 0x0057, all -> 0x0055 }
        if (r3 == 0) goto L_0x0070;
    L_0x004c:
        r3.close();	 Catch:{ Throwable -> 0x0050 }
        goto L_0x0070;
    L_0x0050:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0070;
    L_0x0055:
        r0 = move-exception;
        goto L_0x0071;
    L_0x0057:
        r0 = move-exception;
        r2 = r3;
        goto L_0x005e;
    L_0x005a:
        r0 = move-exception;
        r3 = r2;
        goto L_0x0071;
    L_0x005d:
        r0 = move-exception;
    L_0x005e:
        r3 = "se";
        r4 = "tds";
        com.amap.api.mapcore.util.ooOOOOoo.O00000o0(r0, r3, r4);	 Catch:{ all -> 0x005a }
        if (r2 == 0) goto L_0x006f;
    L_0x0067:
        r2.close();	 Catch:{ Throwable -> 0x006b }
        goto L_0x006f;
    L_0x006b:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x006f:
        r0 = r1;
    L_0x0070:
        return r0;
    L_0x0071:
        if (r3 == 0) goto L_0x007b;
    L_0x0073:
        r3.close();	 Catch:{ Throwable -> 0x0077 }
        goto L_0x007b;
    L_0x0077:
        r1 = move-exception;
        r1.printStackTrace();
    L_0x007b:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.oOOO0o00.O000000o():byte[]");
    }

    public byte[] O000000o(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public byte[] O00000Oo(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[]{(byte) 0, (byte) 0};
        }
        byte[] O000000o = o0OOOO00.O000000o(this.O00000oO);
        if (O000000o == null) {
            return new byte[]{(byte) 0, (byte) 0};
        }
        byte length = (byte) (O000000o.length % 256);
        return new byte[]{(byte) (r4 / 256), length};
    }
}
