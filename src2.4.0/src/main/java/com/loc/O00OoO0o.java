package com.loc;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.maps.AMapException;

/* compiled from: StatisticsEntity */
public final class O00OoO0o {
    private Context O000000o;
    private String O00000Oo;
    private String O00000o;
    private String O00000o0;
    private String O00000oO;

    public O00OoO0o(Context context, String str, String str2, String str3) throws OO00Oo0 {
        if (TextUtils.isEmpty(str3) || str3.length() > 256) {
            throw new OO00Oo0(AMapException.ERROR_INVALID_PARAMETER);
        }
        this.O000000o = context.getApplicationContext();
        this.O00000o0 = str;
        this.O00000o = str2;
        this.O00000Oo = str3;
    }

    public final void O000000o(String str) throws OO00Oo0 {
        if (TextUtils.isEmpty(str) || str.length() > 65536) {
            throw new OO00Oo0(AMapException.ERROR_INVALID_PARAMETER);
        }
        this.O00000oO = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0089 A:{SYNTHETIC, Splitter:B:21:0x0089} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b0 A:{SYNTHETIC, Splitter:B:43:0x00b0} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0092 A:{Splitter:B:3:0x0009, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a4 A:{SYNTHETIC, Splitter:B:36:0x00a4} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:27:0x0092, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:28:0x0094, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:29:0x0095, code skipped:
            r2 = r3;
     */
    /* JADX WARNING: Missing block: B:37:?, code skipped:
            r2.close();
     */
    /* JADX WARNING: Missing block: B:38:0x00a8, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:39:0x00a9, code skipped:
            r0.printStackTrace();
     */
    /* JADX WARNING: Missing block: B:44:?, code skipped:
            r3.close();
     */
    /* JADX WARNING: Missing block: B:45:0x00b4, code skipped:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:46:0x00b5, code skipped:
            r1.printStackTrace();
     */
    public final byte[] O000000o() {
        /*
        r8 = this;
        r0 = 0;
        r1 = new byte[r0];
        r2 = 0;
        r3 = new java.io.ByteArrayOutputStream;	 Catch:{ Throwable -> 0x009a }
        r3.<init>();	 Catch:{ Throwable -> 0x009a }
        r2 = r8.O00000o0;	 Catch:{ Throwable -> 0x0094, all -> 0x0092 }
        com.loc.OO0o000.O000000o(r3, r2);	 Catch:{ Throwable -> 0x0094, all -> 0x0092 }
        r2 = r8.O00000o;	 Catch:{ Throwable -> 0x0094, all -> 0x0092 }
        com.loc.OO0o000.O000000o(r3, r2);	 Catch:{ Throwable -> 0x0094, all -> 0x0092 }
        r2 = r8.O00000Oo;	 Catch:{ Throwable -> 0x0094, all -> 0x0092 }
        com.loc.OO0o000.O000000o(r3, r2);	 Catch:{ Throwable -> 0x0094, all -> 0x0092 }
        r2 = r8.O000000o;	 Catch:{ Throwable -> 0x0094, all -> 0x0092 }
        r2 = com.loc.OO0O0o0.O0000oO0(r2);	 Catch:{ Throwable -> 0x0094, all -> 0x0092 }
        r2 = java.lang.String.valueOf(r2);	 Catch:{ Throwable -> 0x0094, all -> 0x0092 }
        com.loc.OO0o000.O000000o(r3, r2);	 Catch:{ Throwable -> 0x0094, all -> 0x0092 }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x002e, all -> 0x0092 }
        r6 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r4 = r4 / r6;
        r2 = (int) r4;
        goto L_0x002f;
    L_0x002e:
        r2 = r0;
    L_0x002f:
        r4 = 4;
        r4 = new byte[r4];	 Catch:{ Throwable -> 0x0094, all -> 0x0092 }
        r5 = r2 >> 24;
        r5 = r5 & 255;
        r5 = (byte) r5;	 Catch:{ Throwable -> 0x0094, all -> 0x0092 }
        r4[r0] = r5;	 Catch:{ Throwable -> 0x0094, all -> 0x0092 }
        r5 = r2 >> 16;
        r5 = r5 & 255;
        r5 = (byte) r5;	 Catch:{ Throwable -> 0x0094, all -> 0x0092 }
        r6 = 1;
        r4[r6] = r5;	 Catch:{ Throwable -> 0x0094, all -> 0x0092 }
        r5 = r2 >> 8;
        r5 = r5 & 255;
        r5 = (byte) r5;	 Catch:{ Throwable -> 0x0094, all -> 0x0092 }
        r7 = 2;
        r4[r7] = r5;	 Catch:{ Throwable -> 0x0094, all -> 0x0092 }
        r5 = 3;
        r2 = r2 & 255;
        r2 = (byte) r2;	 Catch:{ Throwable -> 0x0094, all -> 0x0092 }
        r4[r5] = r2;	 Catch:{ Throwable -> 0x0094, all -> 0x0092 }
        r3.write(r4);	 Catch:{ Throwable -> 0x0094, all -> 0x0092 }
        r2 = r8.O00000oO;	 Catch:{ Throwable -> 0x0094, all -> 0x0092 }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Throwable -> 0x0094, all -> 0x0092 }
        if (r2 == 0) goto L_0x0060;
    L_0x005a:
        r0 = new byte[r7];	 Catch:{ Throwable -> 0x0094, all -> 0x0092 }
        r0 = {0, 0};	 Catch:{ Throwable -> 0x0094, all -> 0x0092 }
        goto L_0x0077;
    L_0x0060:
        r2 = r8.O00000oO;	 Catch:{ Throwable -> 0x0094, all -> 0x0092 }
        r2 = com.loc.OO0o000.O000000o(r2);	 Catch:{ Throwable -> 0x0094, all -> 0x0092 }
        if (r2 != 0) goto L_0x0069;
    L_0x0068:
        goto L_0x005a;
    L_0x0069:
        r2 = r2.length;	 Catch:{ Throwable -> 0x0094, all -> 0x0092 }
        r4 = r2 / 256;
        r4 = (byte) r4;	 Catch:{ Throwable -> 0x0094, all -> 0x0092 }
        r2 = r2 % 256;
        r2 = (byte) r2;	 Catch:{ Throwable -> 0x0094, all -> 0x0092 }
        r5 = new byte[r7];	 Catch:{ Throwable -> 0x0094, all -> 0x0092 }
        r5[r0] = r4;	 Catch:{ Throwable -> 0x0094, all -> 0x0092 }
        r5[r6] = r2;	 Catch:{ Throwable -> 0x0094, all -> 0x0092 }
        r0 = r5;
    L_0x0077:
        r3.write(r0);	 Catch:{ Throwable -> 0x0094, all -> 0x0092 }
        r0 = r8.O00000oO;	 Catch:{ Throwable -> 0x0094, all -> 0x0092 }
        r0 = com.loc.OO0o000.O000000o(r0);	 Catch:{ Throwable -> 0x0094, all -> 0x0092 }
        r3.write(r0);	 Catch:{ Throwable -> 0x0094, all -> 0x0092 }
        r0 = r3.toByteArray();	 Catch:{ Throwable -> 0x0094, all -> 0x0092 }
        if (r3 == 0) goto L_0x00ad;
    L_0x0089:
        r3.close();	 Catch:{ Throwable -> 0x008d }
        return r0;
    L_0x008d:
        r1 = move-exception;
        r1.printStackTrace();
        return r0;
    L_0x0092:
        r0 = move-exception;
        goto L_0x00ae;
    L_0x0094:
        r0 = move-exception;
        r2 = r3;
        goto L_0x009b;
    L_0x0097:
        r0 = move-exception;
        r3 = r2;
        goto L_0x00ae;
    L_0x009a:
        r0 = move-exception;
    L_0x009b:
        r3 = "se";
        r4 = "tds";
        com.loc.O0000o.O00000Oo(r0, r3, r4);	 Catch:{ all -> 0x0097 }
        if (r2 == 0) goto L_0x00ac;
    L_0x00a4:
        r2.close();	 Catch:{ Throwable -> 0x00a8 }
        goto L_0x00ac;
    L_0x00a8:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x00ac:
        r0 = r1;
    L_0x00ad:
        return r0;
    L_0x00ae:
        if (r3 == 0) goto L_0x00b8;
    L_0x00b0:
        r3.close();	 Catch:{ Throwable -> 0x00b4 }
        goto L_0x00b8;
    L_0x00b4:
        r1 = move-exception;
        r1.printStackTrace();
    L_0x00b8:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O00OoO0o.O000000o():byte[]");
    }
}
